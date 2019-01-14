package com.example.doubea.firebasekitchensink;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.doubea.firebasekitchensink.Activities.LoggingActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoggingActivityEspressoTest {


    @Rule
    public ActivityTestRule<LoggingActivity> mActivityRule =
            new ActivityTestRule<>(LoggingActivity.class);

    @Test
    public void SignUp()
    {

        onView(withId(R.id.logging_username_editText)).perform(clearText(), typeText("Espresso Test"));

        onView(withId(R.id.logging_email_editText)).perform(clearText(), typeText("espressoTest@email.com"));

        onView(withId(R.id.logging_signup_button)).perform(click());
    }
}
