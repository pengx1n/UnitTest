package com.pengx.test.mockito;

import com.pengx.test.mockito.DataRepository.Callback;

/**
 * @author PengXin
 */
public class DataModel {

    //...

    private DataRepository mDataRepository;

    public DataRepository getDataRepository() {
        return mDataRepository;
    }

    public void setDataRepository(DataRepository dataRepository) {
        this.mDataRepository = dataRepository;
    }

    public void loadData() {
        mDataRepository.loadData(new Callback() {
            @Override
            public void onSuccess(Object data) {

            }

            @Override
            public void onFailure(int code, String msg) {

            }
        });
    }

    public final boolean finalMethod() {
        return false;
    }

}
