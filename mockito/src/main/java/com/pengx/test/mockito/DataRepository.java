package com.pengx.test.mockito;

/**
 * @author PengXin
 */
public class DataRepository {

    public boolean isNetworkConnected() {
        return true;
    }

    public void loadData(Callback callback) {

    }

    public interface Callback {
        void onSuccess(Object data);

        void onFailure(int code, String msg);
    }


}
