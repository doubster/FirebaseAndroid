package com.example.doubea.firebasekitchensink.Activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doubea.firebasekitchensink.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RemoteConfigActivity extends AppCompatActivity {


    FirebaseRemoteConfig mFirebaseRemoteConfig;

    @BindView(R.id.remoteConfig_WelcomeText)
    TextView welcomeText_TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote_config);

        ButterKnife.bind(this);

        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();

        mFirebaseRemoteConfig.setDefaults(R.xml.remote_config_defaults);

        int cacheExpiration = 12;

        mFirebaseRemoteConfig.fetch(cacheExpiration)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("TAG", "Fetch Succeeded");
                        // Once the config is successfully fetched it must be activated before newly fetched values are returned.
                        mFirebaseRemoteConfig.activateFetched();
                        // Do whatever should be done on success
                        welcomeText_TextView.setText(mFirebaseRemoteConfig.getString("welcome_app"));
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        Log.d("TAG", "Fetch failed");
                        // Do whatever should be done on failure
                    }
                });
    }
}
