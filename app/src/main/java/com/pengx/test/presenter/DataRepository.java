package com.pengx.test.presenter;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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

    public void login(final String account, final String password, final Callback callback) {
        new Observable<Boolean>() {
            @Override
            protected void subscribeActual(Observer<? super Boolean> observer) {
                if (password.equals("fail")) {
                    observer.onNext(false);
                } else {
                    observer.onNext(true);
                }
                observer.onComplete();
            }
        }.delay(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Boolean result) {
                        if (result) {
                            callback.onSuccess(null);
                        } else {
                            callback.onFailure(-1, "");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailure(-1, e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        callback.onComplete();
                    }
                });
    }

    public interface Callback {
        void onSuccess(Object data);

        void onFailure(int code, String msg);

        void onComplete();
    }

}
