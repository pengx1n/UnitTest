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

    public void loadData(Callback callback) {
        mDataRepository.loadData(callback);
    }

    public final boolean finalMethod() {
        return false;
    }

}
