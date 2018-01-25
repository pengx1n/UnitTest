package com.pengx.test.util;

import android.text.TextUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;

/**
 * @author PengXin
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({TextUtils.class})
public class ValidateUtilTest {

    @Before
    public void setup() {
        PowerMockito.mockStatic(TextUtils.class);
        PowerMockito.when(TextUtils.isEmpty(any(CharSequence.class))).thenAnswer(new Answer<Boolean>() {
            @Override
            public Boolean answer(InvocationOnMock invocation) throws Throwable {
                CharSequence charSequence = (CharSequence) invocation.getArguments()[0];
                return charSequence == null || charSequence.length() == 0;
            }
        });
    }

    @Test
    public void isValidEmail() throws Exception {

        assertTrue(ValidateUtil.isValidEmail("123@qq.com"));

        assertFalse(ValidateUtil.isValidEmail("123"));
        assertFalse(ValidateUtil.isValidEmail(null));
        assertFalse(ValidateUtil.isValidEmail(""));
    }

}