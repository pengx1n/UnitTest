package com.pengx.test.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.pengx.test.R;
import com.pengx.test.presenter.LoginContract;
import com.pengx.test.presenter.LoginPresenter;

/**
 * @author PengXin
 */
public class LoginActivity extends AppCompatActivity implements OnClickListener, LoginContract.View {

    private static final String TAG = LoginActivity.class.getSimpleName();

    private EditText etAccount;
    private EditText etPassword;
    private ProgressBar progressView;

    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etAccount = findViewById(R.id.et_account);
        etPassword = findViewById(R.id.et_password);
        progressView = findViewById(R.id.progress_view);

        findViewById(R.id.btn_login).setOnClickListener(this);

        mPresenter = new LoginPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                String account = etAccount.getText().toString();
                String password = etPassword.getText().toString();
                mPresenter.login(account, password);
                hideInputMethod(v);
                break;
            default:
        }
    }

    @Override
    public void setProgressVis(final boolean show) {
        progressView.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public void loginFailure() {
        Log.d(TAG, "loginFailure");
    }

    public boolean hideInputMethod(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(INPUT_METHOD_SERVICE);
        return imm != null && imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
