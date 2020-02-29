package com.jagex;

import java.applet.Applet;

public class Jagception extends RuntimeException {

    public static Applet anApplet1881;
    public static int[] anIntArray1878;
    public static String aString1882;
    static AudioRunnable anAudioRunnable1880;

    String message;
    Throwable throwable;

    Jagception(Throwable throwable, String message) {
        this.throwable = throwable;
        this.message = message;
    }
}
