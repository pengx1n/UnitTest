package com.pengx.test.junit;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author PengXin
 */
public class StringUtilTest {

    @Test
    public void isEmpty() throws Exception {
        assertTrue(StringUtil.isEmpty(null));
        assertTrue(StringUtil.isEmpty(""));
        assertTrue(StringUtil.isEmpty(" "));
        assertFalse(StringUtil.isEmpty("123456"));
    }

}