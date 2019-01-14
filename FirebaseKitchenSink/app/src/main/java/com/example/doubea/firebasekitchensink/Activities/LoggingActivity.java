package com.example.doubea.firebasekitchensink.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doubea.firebasekitchensink.R;
import com.example.doubea.firebasekitchensink.Utils.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoggingActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;

    @BindView(R.id.logging_textview)
    TextView loggingTextview;
    @BindView(R.id.logging_signup_button)
    Button signUpButton;

    @BindView(R.id.logging_username_editText)
    EditText usernameEditText;
    @BindView(R.id.logging_email_editText)
    EditText emailEditText;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logging);

        ButterKnife.bind(this);

        loggingTextview.setText(Constants.Description.EventLogging);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mFirebaseAnalytics.logEvent(Constants.EventTags.LoggingActivityCreated,null);

//        loggingTextview.setText("Enter your username of choice and enter your e-mail then press the sign up button");
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);

                Toast toast = Toast.makeText(getApplicationContext(), "An e-mail has been sent to you", Toast.LENGTH_LONG);
                toast.show();

                Bundle bundle = new Bundle();
                bundle.putString(Constants.EventTags.LoggingUsername, usernameEditText.getText().toString() );
                bundle.putString(Constants.EventTags.LoggingEmail, emailEditText.getText().toString() );
                mFirebaseAnalytics.logEvent(Constants.EventTags.LoggingSignUp, bundle);

               progressBar.setVisibility(View.GONE);
            }
        });
    }
}
