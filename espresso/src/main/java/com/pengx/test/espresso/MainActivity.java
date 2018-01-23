package com.pengx.test.espresso;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_recyclerview).setOnClickListener(this);
        findViewById(R.id.btn_webview).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_recyclerview:
                Intent intent = new Intent(this, RecyclerViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_webview:
                Intent webIntent = new Intent(this, WebViewActivity.class);
                startActivity(webIntent);
                break;
            default:
        }
    }
}
