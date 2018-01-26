package com.pengx.test.mockito;

import com.pengx.test.mockito.DataRepository.Callback;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;

/**
 * @author PengXin
 */
public class DataModelTest {

    @Test
    public void testLoadData() {
        //mock对象
        DataRepository mockDataRepository = Mockito.mock(DataRepository.class);
        Callback mockCallback = Mockito.mock(Callback.class);

        //指定Callback回调方法
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] arguments = invocation.getArguments();
                Callback callback = (Callback) arguments[0];
                callback.onFailure(500, "Server error");
                return 500;
            }
        }).when(mockDataRepository).loadData(any(Callback.class));

        DataModel dataModel = new DataModel();
        dataModel.setDataRepository(mockDataRepository);
        dataModel.loadData(mockCallback);

        //验证方法被调用
        Mockito.verify(mockDataRepository).loadData(any(Callback.class));

        //验证方法被调用次数
        Mockito.verify(mockDataRepository, Mockito.times(1)).loadData(any(Callback.class));

        //指定方法返回值
        Mockito.when(mockDataRepository.isNetworkConnected()).thenReturn(false);
        assertFalse(mockDataRepository.isNetworkConnected());

        Mockito.verify(mockCallback).onFailure(any(Integer.class), any(String.class));
    }

    @Test
    public void testSpy() {
        //mock对象
        DataRepository mockDataRepository = Mockito.mock(DataRepository.class);
        //不指定返回false
        assertFalse(mockDataRepository.isNetworkConnected());

        //spy对象
        DataRepository spyDataRepository = Mockito.spy(DataRepository.class);
        //不指定则返回真实调用时的返回值
        assertTrue(spyDataRepository.isNetworkConnected());

        //指定Spy对象方法返回值
        Mockito.when(spyDataRepository.isNetworkConnected()).thenReturn(false);
        assertFalse(spyDataRepository.isNetworkConnected());
    }

//    @Test
//    public void testFinalMethod() {
//        DataModel dataModel = Mockito.mock(DataModel.class);
//        Mockito.when(dataModel.finalMethod()).thenReturn(true);
//        assertTrue(dataModel.finalMethod());
//    }
}