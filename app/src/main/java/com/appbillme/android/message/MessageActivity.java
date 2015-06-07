package com.appbillme.android.message;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.appbillme.android.R;
import com.crashlytics.android.Crashlytics;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import io.fabric.sdk.android.Fabric;


public class MessageActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());

        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }
}
