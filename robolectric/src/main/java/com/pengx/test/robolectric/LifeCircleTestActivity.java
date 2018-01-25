package com.pengx.test.robolectric;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * @author PengXin
 */
public class LifeCircleTestActivity extends AppCompatActivity {

    private TextView tv;

    private boolean isResume = false;

    public boolean isResume() {
        return isResume;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_circle_test);

        tv = findViewById(R.id.tv);
    }

    @Override
    protected void onResume() {
        super.onResume();

        tv.setText("onResume");
        isResume = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        tv.setText("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        tv.setText("onStop");
    }
}
