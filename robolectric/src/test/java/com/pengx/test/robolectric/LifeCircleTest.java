package com.pengx.test.robolectric;

import android.app.Activity;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author PengXin
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class LifeCircleTest {

    @Test
    public void testTvAfterOnResume() {
        ActivityController controller = Robolectric.buildActivity(LifeCircleTestActivity.class).create().start();
        Activity activity = (Activity) controller.get();
        assertNotNull(activity);

        TextView tv = activity.findViewById(R.id.tv);
        assertEquals("life circle",tv.getText().toString());
        controller.resume();
        assertEquals("onResume",tv.getText().toString());

    }

}
