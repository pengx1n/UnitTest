package com.pengx.test.robolectric;

import android.app.Application;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowLog;
import org.robolectric.shadows.ShadowToast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author PengXin
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class RobolectricActivityTest {

    @Before
    public void setUp() {
        ShadowLog.stream = System.out;
    }

    @Test
    public void testRobolectrictActivity() {
        RobolectricActivity activity = Robolectric.setupActivity(RobolectricActivity.class);
        assertNotNull(activity);

        Button btn = activity.findViewById(R.id.btn);
        assertNotNull(btn);

        assertEquals("Robolectric button", btn.getText().toString());
        assertTrue(btn.isEnabled());

        TextView tv = activity.findViewById(R.id.tv);
        assertNotNull(tv);
        assertEquals("this is a text",tv.getText().toString());

        btn.performClick();

        assertFalse(btn.isEnabled());
        assertEquals("Button has been clicked",tv.getText().toString());
    }

    @Test
    public void testToNextActivity() {
        RobolectricActivity activity = Robolectric.setupActivity(RobolectricActivity.class);
        assertNotNull(activity);

        Button btnNext = activity.findViewById(R.id.btn_next);
        assertNotNull(btnNext);

        btnNext.performClick();

        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
        Intent nextIntent = shadowActivity.getNextStartedActivity();
        assertEquals(LifeCircleActivity.class.getName(), nextIntent.getComponent().getClassName());
    }

    @Test
    public void testToast() {
        RobolectricActivity activity = Robolectric.setupActivity(RobolectricActivity.class);
        assertNotNull(activity);

        Button btn = activity.findViewById(R.id.btn);
        assertNotNull(btn);

        btn.performClick();
        assertEquals(ShadowToast.getTextOfLatestToast(),"Test Toast");

    }

    @Test
    public void testResources() {
        Application application = RuntimeEnvironment.application;
        String appName = application.getString(R.string.app_name);
        assertEquals("robolectric", appName);
    }

}