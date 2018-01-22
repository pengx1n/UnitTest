package com.pengx.test.robolectric;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author PengXin
 */
public class RobolectricTestActivity extends AppCompatActivity implements OnClickListener{

    private static final String TAG = RobolectricTestActivity.class.getSimpleName();

    private Button mBtn;
    private TextView mTv;
    private Button mBtnNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robolectric_test);

        mBtn = findViewById(R.id.btn);
        mTv = findViewById(R.id.tv);
        mBtnNext = findViewById(R.id.btn_next);

        mBtn.setOnClickListener(this);
        mBtnNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn) {
            mBtn.setEnabled(false);
            mTv.setText("Button has been clicked");
            Toast.makeText(this, "Test Toast", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btn_next) {
            Intent i = new Intent(this, LifeCircleTestActivity.class);
            startActivity(i);
        }
    }
}
