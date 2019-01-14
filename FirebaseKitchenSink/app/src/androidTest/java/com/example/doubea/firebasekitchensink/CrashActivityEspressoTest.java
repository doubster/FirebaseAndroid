package com.example.doubea.firebasekitchensink;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.doubea.firebasekitchensink.Activities.CrashActivity;
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
public class CrashActivityEspressoTest {


    @Rule
    public ActivityTestRule<CrashActivity> mActivityRule =
            new ActivityTestRule<>(CrashActivity.class);

    @Test
    public void Test1() {
        onView(withId(R.id.crash_calculate_button)).perform(click());
    }
}