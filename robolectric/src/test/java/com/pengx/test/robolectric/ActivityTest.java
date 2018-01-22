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
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;
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
public class ActivityTest {

    @Before
    public void setUp() {
        ShadowLog.stream = System.out;
    }

    @Test
    public void testRobolectrictActivity() {
        RobolectricTestActivity activity = Robolectric.setupActivity(RobolectricTestActivity.class);
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
        RobolectricTestActivity activity = Robolectric.setupActivity(RobolectricTestActivity.class);
        assertNotNull(activity);

        Button btnNext = activity.findViewById(R.id.btn_next);
        assertNotNull(btnNext);

        btnNext.performClick();

        Intent expectedIntent = new Intent(activity, LifeCircleTestActivity.class);
        Intent actual = ShadowApplication.getInstance().getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(), actual.getComponent());
    }

    @Test
    public void testToast() {

        RobolectricTestActivity activity = Robolectric.setupActivity(RobolectricTestActivity.class);
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
