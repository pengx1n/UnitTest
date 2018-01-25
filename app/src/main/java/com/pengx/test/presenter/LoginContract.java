package com.pengx.test.presenter;

/**
 * @author PengXin
 */
public interface LoginContract {

    interface View {
        void setProgressVis(boolean show);

        void showToast(String msg);

        void loginSuccess();

        void loginFailure();
    }

    interface Presenter {
        void login(String account, String password);
    }
}
