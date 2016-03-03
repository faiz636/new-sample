package com.rubbersoft.android.newssample.services.volley;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.rubbersoft.android.newssample.NewsApplication;
import com.rubbersoft.android.newssample.R;
import com.rubbersoft.android.newssample.model.NewsModel;
import com.rubbersoft.android.newssample.services.listeners.ServiceListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.android.volley.Response.ErrorListener;
import static com.android.volley.Response.Listener;

/**
 * Created by Faiz on 21/02/2016.
 */
public class HttpRequest {
    private static void jsonObjectRequest(final String url, JSONObject body,
                                          Response.Listener<JSONObject> responseListener,
                                          ErrorListener errorListener) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                url, body, responseListener, errorListener);

        HttpRequestHandler.getInstance().addToRequestQueue(jsonObjectRequest);
    }

    public static void register(int deviceid, String userid, String key, final ServiceListener<Integer> serviceListener) {
        final Context context = NewsApplication.getContext();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(context.getString(R.string.userid), userid);
            jsonObject.put(context.getString(R.string.registration_key), key);
            jsonObject.put(context.getString(R.string.deviceid), deviceid);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final String url = context.getString(R.string.serveraddress) + context.getString(R.string.registerGCMKey);

        final Listener<JSONObject> listener = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.i("response", "url-->" + url + "--value-->" + jsonObject.toString());
                try {
                    int status = (int) jsonObject.getInt("code");
                    if (status == 200) {
                        int deviceid = jsonObject.getInt(context.getString(R.string.deviceid));
                        serviceListener.success(deviceid);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        ErrorListener errorListener = new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                Toast.makeText(NewsApplication.getContext(), "bad", Toast.LENGTH_SHORT).show();
//                serviceListener.error(new ServiceError(volleyError));
            }
        };
        jsonObjectRequest(url, jsonObject, listener, errorListener);
    }

    public static void getNews(final ServiceListener<ArrayList<NewsModel>> serviceListener){

        final Context context = NewsApplication.getContext();
        final String url = context.getString(R.string.serveraddress) + context.getString(R.string.server_news);

        final Listener<JSONObject> listener = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.i("response", "url-->" + url + "--value-->" + jsonObject.toString());
                try {
                    String status = jsonObject.getString("code");
                    if (!status.equals("200")){
                        Toast.makeText(context,"bad response",Toast.LENGTH_SHORT).show();
                        serviceListener.success(null);
                        return;
                    }
                    JSONArray array = jsonObject.getJSONArray("data");
                    if (array.length()<1){
                        serviceListener.success(null);
                        return;
                    }
                    ArrayList<NewsModel> list = new ArrayList<>();
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = (JSONObject) array.get(i);
                        NewsModel model = new NewsModel();
                        model.setId(object.getInt("newsid"));
                        model.setAuthor(object.getString("author"));
                        model.setImgUrl(object.getString("imageurl"));
                        model.setL_desc(object.getString("l_desc"));
                        model.setS_desc(object.getString("s_desc"));
                        model.setTimestamp(object.getString("timestamp"));
                        model.setTitle(object.getString("title"));
                        list.add(model);
                    }
                    serviceListener.success(list);
                } catch (JSONException e) {
                    serviceListener.success(null);
                    e.printStackTrace();
                }
            }
        };

        ErrorListener errorListener = new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                Toast.makeText(NewsApplication.getContext(), "bad", Toast.LENGTH_SHORT).show();
//                serviceListener.error(new ServiceError(volleyError));
            }
        };
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url, null, listener, errorListener);

        HttpRequestHandler.getInstance().addToRequestQueue(jsonObjectRequest);
    }

    public static void getNews(int id,final ServiceListener<NewsModel> serviceListener){

        final Context context = NewsApplication.getContext();
        final String url = context.getString(R.string.serveraddress) + context.getString(R.string.server_news) +"/"+id;

        final Listener<JSONObject> listener = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.i("response", "url-->" + url + "--value-->" + jsonObject.toString());
                try {
                    String status = jsonObject.getString("code");
                    if (!status.equals("200")){
                        Toast.makeText(context,"bad response",Toast.LENGTH_SHORT).show();
                        serviceListener.success(null);
                        return;
                    }
                    JSONArray array = jsonObject.getJSONArray("data");
                    if (array.length()<1){
                        serviceListener.success(null);
                        return;
                    }
                    JSONObject object = (JSONObject) array.get(0);
                    NewsModel model = new NewsModel();
                    model.setId(object.getInt("newsid"));
                    model.setAuthor(object.getString("author"));
                    model.setImgUrl(object.getString("imageurl"));
                    model.setL_desc(object.getString("l_desc"));
                    model.setS_desc(object.getString("s_desc"));
                    model.setTimestamp(object.getString("timestamp"));
                    model.setTitle(object.getString("title"));
                    serviceListener.success(model);
                    return;
                } catch (JSONException e) {
                    serviceListener.success(null);
                    e.printStackTrace();
                }
            }
        };

        ErrorListener errorListener = new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                Toast.makeText(NewsApplication.getContext(), "bad", Toast.LENGTH_SHORT).show();
//                serviceListener.error(new ServiceError(volleyError));
            }
        };
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url, null, listener, errorListener);

        HttpRequestHandler.getInstance().addToRequestQueue(jsonObjectRequest);
    }

}
