package com.example.doubea.firebasekitchensink;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.doubea.firebasekitchensink.Activities.LoggingActivity;
import com.example.doubea.firebasekitchensink.Activities.RemoteConfigActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class RemoteConfigActivityEspressoTest {


    @Rule
    public ActivityTestRule<RemoteConfigActivity> mActivityRule =
            new ActivityTestRule<>(RemoteConfigActivity.class);

    @Test
    public void IsTextVisible() {
        onView(withId(R.id.remoteConfig_WelcomeText));
    }
}