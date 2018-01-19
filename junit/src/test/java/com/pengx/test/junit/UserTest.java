package com.pengx.test.junit;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author PengXin
 */
public class UserTest {

    @Test
    public void testUser() {
        User user = new User("112334", 1, "13800138000", 20);
        assertNotNull(user);

        assertEquals("112334", user.getUserId());
        assertEquals("13800138000", user.getPhone());
        assertEquals(20, user.getAge());

        assertEquals("男", user.getSexString());
        user.setSex(2);
        assertEquals("女", user.getSexString());
        user.setSex(-1);
        assertEquals("未知", user.getSexString());

    }


}