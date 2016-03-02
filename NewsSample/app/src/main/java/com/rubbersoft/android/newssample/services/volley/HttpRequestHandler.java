package com.rubbersoft.android.newssample.services.volley;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.rubbersoft.android.newssample.NewsApplication;


// Implementation References:
// https://developer.android.com/training/volley/requestqueue.html
// http://arnab.ch/blog/2013/08/asynchronous-http-requests-in-android-using-volley/
public class HttpRequestHandler {


    private static final String TAG = "HttpRequestHandler";
    private static HttpRequestHandler httpRequestHandler;
    private static Context mContext;
    private RequestQueue mRequestQueue;
    private ImageLoader imageLoader;

    private HttpRequestHandler() {
        if (mContext == null) {
            mContext = NewsApplication.getContext();
        }
        mRequestQueue = Volley.newRequestQueue(mContext);
    }

    public static HttpRequestHandler getInstance() throws RuntimeException {
        if (httpRequestHandler == null) {
            httpRequestHandler = new HttpRequestHandler();
        }
        return httpRequestHandler;
    }

    public ImageLoader getImageLoader() {
        if (imageLoader == null) {
            imageLoader = new ImageLoader(getRequestQueue(), new ImageLoader.ImageCache() {
                private final LruCache<String, Bitmap> mCache = new LruCache<>(1024);

                @Override
                public Bitmap getBitmap(String s) {
                    return mCache.get(s);
                }

                @Override
                public void putBitmap(String s, Bitmap bitmap) {
                    mCache.put(s, bitmap);
                }
            });
        }
        return imageLoader;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

}
