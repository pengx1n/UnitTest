package com.pengx.test.presenter;

import android.text.TextUtils;

import com.pengx.test.presenter.DataRepository.Callback;
import com.pengx.test.util.ValidateUtil;

/**
 * @author PengXin
 */
public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mView;

    public LoginPresenter(LoginContract.View view) {
        mView = view;
    }

    @Override
    public void login(String account, String password) {
        if (!ValidateUtil.isValidEmail(account)) {
            mView.showToast("请输入正确邮箱账号");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            mView.showToast("请输入密码");
            return;
        }

        mView.setProgressVis(true);
        DataRepository.getInstance().login(account, password, new Callback() {
            @Override
            public void onSuccess(Object data) {
                mView.loginSuccess();
            }

            @Override
            public void onFailure(int code, String msg) {
                mView.loginFailed();
            }

            @Override
            public void onComplete() {
                mView.setProgressVis(false);
            }
        });
    }
}
