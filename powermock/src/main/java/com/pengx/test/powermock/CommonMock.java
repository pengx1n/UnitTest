package com.pengx.test.powermock;

import java.io.File;
import java.util.UUID;

/**
 * @author PengXin
 */
public class CommonMock {

    public boolean isFileExist(String path) {
        File file = new File(path);
        return file.exists();
    }

    public final boolean finalMethod() {
        return false;
    }

    private boolean privateMethod() {
        return false;
    }

    public boolean callPrivateMethod() {
        return privateMethod();
    }

    public static String generateUUId() {
        return UUID.randomUUID().toString();
    }

    private static final int STATE_INIT = 0;
    private static final int STATE_READY = 1;

    private int mState = STATE_READY;

    public boolean isReady() {
        return mState == STATE_READY;
    }
}
