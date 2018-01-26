package com.pengx.test.robolectric;

import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author PengXin
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class LifeCircleActivityTest {

    @Test
    public void testTvAfterOnResume() {
        ActivityController controller = Robolectric.buildActivity(LifeCircleActivity.class).create().start();
        LifeCircleActivity activity = (LifeCircleActivity) controller.get();
        assertNotNull(activity);

        TextView tv = activity.findViewById(R.id.tv);
        assertEquals("life circle",tv.getText().toString());

        assertFalse(activity.isResume());
        controller.resume();
        assertEquals("onResume",tv.getText().toString());
        assertTrue(activity.isResume());
    }
}