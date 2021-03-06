package com.rubbersoft.android.newssample.ui.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.rubbersoft.android.newssample.services.QuickstartPreferences;
import com.rubbersoft.android.newssample.services.gcm.RegistrationIntentService;
import com.rubbersoft.android.newssample.services.listeners.ServiceError;
import com.rubbersoft.android.newssample.services.listeners.ServiceListener;
import com.rubbersoft.android.newssample.services.volley.HttpRequest;
import com.rubbersoft.android.newssample.ui.adapters.MyAdapter;
import com.rubbersoft.android.newssample.R;
import com.rubbersoft.android.newssample.model.BaseModel;
import com.rubbersoft.android.newssample.model.NewsModel;
import com.rubbersoft.android.newssample.ui.fragments.NewsDetailFragment;
import com.rubbersoft.android.newssample.ui.fragments.NewsListFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NewsListFragment.FragmentInteractionListener{

    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private static final String TAG = "MainActivity";

    private BroadcastReceiver mRegistrationBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NewsListFragment newsListFragment = new NewsListFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fragment_container,newsListFragment).commit();
        createBroadcastRecivers();

        if (checkPlayServices()) {
            // Start IntentService to register this application with GCM.
            Intent intent = new Intent(this, RegistrationIntentService.class);
            startService(intent);
        }
        ServiceListener serviceListener = new ServiceListener<NewsModel>() {
            @Override
            public void success(NewsModel obj) {
                Toast.makeText(MainActivity.this,"response",Toast.LENGTH_SHORT);
            }

            @Override
            public void error(ServiceError serviceError) {

            }
        };
        HttpRequest.getNews(16,serviceListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(QuickstartPreferences.REGISTRATION_COMPLETE));
    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
        super.onPause();
    }

    public void createBroadcastRecivers(){
        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                SharedPreferences sharedPreferences =
                        PreferenceManager.getDefaultSharedPreferences(context);
                boolean sentToken;
                sentToken = sharedPreferences
                        .getBoolean(QuickstartPreferences.SENT_TOKEN_TO_SERVER, false);
                if (sentToken) {
                    //toast for sent to server
                } else {
                    //token for error message
                }
            }
        };

    }

    /**
     * Check the device to make sure it has the Google Play Services APK. If
     * it doesn't, display a dialog that allows users to download the APK from
     * the Google Play Store or enable it in the device's system settings.
     */
    private boolean checkPlayServices() {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(resultCode)) {
                apiAvailability.getErrorDialog(this, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST)
                        .show();
            } else {
                Log.i(TAG, "This device is not supported.");
                finish();
            }
            return false;
        }
        return true;
    }

    @Override
    public void showDetailFragment(NewsModel newsModel) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(NewsDetailFragment.DATA,newsModel);
        NewsDetailFragment newsDetailFragment = new NewsDetailFragment();
        newsDetailFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,newsDetailFragment)
                .addToBackStack(null)
                .commit();
    }
}
