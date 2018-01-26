package com.pengx.test.presenter;

import android.text.TextUtils;

import com.pengx.test.presenter.DataRepository.Callback;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.PrepareOnlyThisForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;

/**
 * @author PengXin
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({TextUtils.class})
@PrepareOnlyThisForTest(DataRepository.class)
public class LoginPresenterTest {

    @Mock
    private DataRepository mDataRepository;

    @Mock
    private LoginContract.View mView;

    @Captor
    private ArgumentCaptor<Callback> mCallback;

    private LoginContract.Presenter mPresenter;

    @Before
    public void setupMockAndViews() {
        MockitoAnnotations.initMocks(this);

        PowerMockito.mockStatic(TextUtils.class);
        PowerMockito.when(TextUtils.isEmpty(any(CharSequence.class))).thenAnswer(new Answer<Boolean>() {
            @Override
            public Boolean answer(InvocationOnMock invocation) throws Throwable {
                CharSequence charSequence = (CharSequence) invocation.getArguments()[0];
                return charSequence == null || charSequence.length() == 0;
            }
        });

        PowerMockito.mockStatic(DataRepository.class);
        PowerMockito.when(DataRepository.getInstance()).thenReturn(mDataRepository);

        mPresenter = new LoginPresenter(mView);
    }

    @Test
    public void testLogin() throws Exception {
//        Mockito.doAnswer(new Answer() {
//            @Override
//            public Object answer(InvocationOnMock invocation) throws Throwable {
//                Object[] arguments = invocation.getArguments();
//                Callback callback = (Callback) arguments[2];
//                callback.onFailure(500, "Server error");
//                return 500;
//            }
//        }).when(mDataRepository).login(any(String.class), any(String.class),any(Callback.class));

        //登录操作
        mPresenter.login("123456@qq.com", "123456");

        //验证显示loading
        Mockito.verify(mView, times(1)).setProgressVis(any(Boolean.class));

        //验证调用 DataRepository.login()
        Mockito.verify(mDataRepository, times(1)).login(any(String.class), any(String.class), mCallback.capture());

        //login 失败
        mCallback.getValue().onFailure(500, "Server error");
        Mockito.verify(mView).loginFailure();

        //login 成功
        mCallback.getValue().onSuccess(null);
        Mockito.verify(mView).loginSuccess();

        //login 完成
        ArgumentCaptor<Boolean> showCaptor = ArgumentCaptor.forClass(Boolean.class);
        mCallback.getValue().onComplete();
        Mockito.verify(mView, times(2)).setProgressVis(showCaptor.capture());
        assertFalse(showCaptor.getValue());
    }

}