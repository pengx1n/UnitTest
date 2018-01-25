package com.pengx.test.presenter;

/**
 * @author PengXin
 */
public class DataRepository {

    private static DataRepository sDataRepository;

    private DataRepository() {

    }

    public static DataRepository getInstance() {
        if (sDataRepository == null) {
            sDataRepository = new DataRepository();
        }
        return sDataRepository;
    }

    public void login(String account, String password, Callback callback) {

    }

    public interface Callback {
        void onSuccess(Object data);

        void onFailure(int code, String msg);

        void onComplete();
    }

}
