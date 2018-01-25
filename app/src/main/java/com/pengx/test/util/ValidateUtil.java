package com.pengx.test.util;

import android.text.TextUtils;

import java.util.regex.Pattern;

/**
 * @author PengXin
 */
public class ValidateUtil {

    public static final Pattern EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && EMAIL_PATTERN.matcher(email).matches();
    }
}
