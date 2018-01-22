package com.pengx.test.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.io.File;

import static org.junit.Assert.*;

/**
 * @author PengXin
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({CommonMock.class})
public class CommonMockTest {

    @Test
    public void isFileExist() throws Exception {
        File file = PowerMockito.mock(File.class);
        CommonMock commonMock = new CommonMock();
        PowerMockito.whenNew(File.class).withArguments("/0/storage/path").thenReturn(file);
        PowerMockito.when(file.exists()).thenReturn(true);
        assertTrue(commonMock.isFileExist("/0/storage/path"));

        File file2 = Mockito.mock(File.class);
        file2.exists();
        Mockito.verify(file2).exists();
    }

    @Test
    public void testFinalMethod() {
        //测试final方法
        CommonMock commonMock = PowerMockito.mock(CommonMock.class);
        PowerMockito.when(commonMock.finalMethod()).thenReturn(true);
        assertTrue(commonMock.finalMethod());
    }

    @Test
    public void testPrivateMethod() throws Exception {
        //测试私有方法
        CommonMock commonMock = PowerMockito.mock(CommonMock.class);
        PowerMockito.when(commonMock.callPrivateMethod()).thenCallRealMethod();
        PowerMockito.when(commonMock, "privateMethod").thenReturn(true);
        assertTrue(commonMock.callPrivateMethod());
    }

    @Test
    public void testStaticMethod() throws Exception {
        //测试静态方法
        PowerMockito.mockStatic(CommonMock.class);
        PowerMockito.when(CommonMock.generateUUId()).thenReturn("123456789");
        assertEquals("123456789", CommonMock.generateUUId());
    }

    @Test
    public void testPrivateVar() {
        // mock 私有变量
        CommonMock commonMock = new CommonMock();
        Whitebox.setInternalState(commonMock, "mState", 1);
        assertTrue(commonMock.isReady());
    }
}