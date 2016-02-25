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
import com.rubbersoft.android.newssample.services.listeners.ServiceListener;

import org.json.JSONException;
import org.json.JSONObject;

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
            jsonObject.put(context.getString(R.string.registerGCMKey), key);
            if (deviceid > -1) {
                jsonObject.put(context.getString(R.string.deviceid), deviceid);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final String url = context.getString(R.string.serveraddress) + context.getString(R.string.registerGCMKey);

        final Listener<JSONObject> listener = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.i("response", "url-->" + url + "--value-->" + jsonObject.toString());
                try {
                    int status = (int) jsonObject.getInt("status");
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

}
