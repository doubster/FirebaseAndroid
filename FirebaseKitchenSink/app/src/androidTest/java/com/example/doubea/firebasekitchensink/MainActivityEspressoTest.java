package com.example.doubea.firebasekitchensink;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;



/*
To Create the APK use the following commands to create the APK

To Create the APK : ./gradlew clean assembleDebug
To Create the APK Test : ./gradlew clean assembleAndroidTest

 */




@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void LoggingButtonClicked()
    {
        onView(withId(R.id.logging_button)).check(matches(isClickable()));
    }

    @Test
    public void CrashingButtonClicked()
    {
        onView(withId(R.id.crash_button)).check(matches(isClickable()));
    }

    @Test
    public void AuthenticationButtonclicked()
    {
        onView(withId(R.id.authentication_button)).check(matches(isClickable()));
    }

    @Test
    public void NotificationButtonclicked()
    {
        onView(withId(R.id.notification_button)).check(matches(isClickable()));
    }

    @Test
    public void StorageButtonclicked()
    {
        onView(withId(R.id.storage_button)).check(matches(isClickable()));
    }

    @Test
    public void DatabaseButtonclicked()
    {
        onView(withId(R.id.realtime_button)).check(matches(isClickable()));
    }

    @Test
    public void RemoteConfigButtonclicked()
    {
        onView(withId(R.id.remoteConfig_button)).check(matches(isClickable()));
    }

}




