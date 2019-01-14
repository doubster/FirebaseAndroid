package com.example.doubea.firebasekitchensink.Activities;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.doubea.firebasekitchensink.R;
import com.example.doubea.firebasekitchensink.Utils.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crash.FirebaseCrash;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CrashActivity extends AppCompatActivity {

    @BindView(R.id.crash_calculate_button)
    Button calculateButton;

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash);

        ButterKnife.bind(this);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mFirebaseAnalytics.logEvent(Constants.EventTags.CrashActivityCreated,null);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    float a = 9%0;
                }
                catch (ArithmeticException e) {
                    FirebaseCrash.logcat(Log.ERROR, "ERROR", "Calculate Button Clicked");
                    FirebaseCrash.report(e);
                }
                catch (Exception e) {
                    System.out.println("Exception occurred");

                    FirebaseCrash.logcat(Log.ERROR, "ERROR", "Calculate Button Clicked");
                    FirebaseCrash.report(e);
                }
            }
        });
    }
}
