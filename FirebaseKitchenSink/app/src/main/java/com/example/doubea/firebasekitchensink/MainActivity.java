package com.example.doubea.firebasekitchensink;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.doubea.firebasekitchensink.Activities.AuthenticationActivity;
import com.example.doubea.firebasekitchensink.Activities.ContactListActivity;
import com.example.doubea.firebasekitchensink.Activities.CrashActivity;
import com.example.doubea.firebasekitchensink.Activities.LoggingActivity;
import com.example.doubea.firebasekitchensink.Activities.RemoteConfigActivity;
import com.example.doubea.firebasekitchensink.Activities.StorageActivity;
import com.example.doubea.firebasekitchensink.Utils.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;

    @BindView(R.id.logging_button)
    Button loggingButton;

    @BindView(R.id.crash_button)
    Button crashButton;

    @BindView(R.id.authentication_button)
    Button authenticationButton;

    @BindView(R.id.storage_button)
    Button storageButton;

    @BindView(R.id.realtime_button)
    Button databaseButton;

    @BindView(R.id.remoteConfig_button)
    Button remoteConfigBuggon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mFirebaseAnalytics.logEvent(Constants.EventTags.MainActivityCreated,null);

        loggingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LoggingActivity.class));
            }
        });

        crashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CrashActivity.class));
            }
        });

        authenticationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AuthenticationActivity.class));
            }
        });

        storageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, StorageActivity.class));
            }
        });

        databaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ContactListActivity.class));
            }
        });

        remoteConfigBuggon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RemoteConfigActivity.class));
            }
        });
    }
}
