package com.rubbersoft.android.newssample;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.rubbersoft.android.newssample.services.volley.HttpRequestHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Faiz on 21/02/2016.
 */
public class NewsApplication extends Application {
    private static final String TAG = "ValveLeakageApplication";

    private static Context context;
    private static Map<String, Boolean> states;

    static {
        states = new HashMap<>();
    }

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "in ValveLeakageApplication onCreate");
        context = this;
        initializeSingletons();
    }

    private void initializeSingletons() {
        HttpRequestHandler httpRequestHandler = HttpRequestHandler.getInstance();
        httpRequestHandler.getImageLoader();
        httpRequestHandler.getRequestQueue();
    }

}
