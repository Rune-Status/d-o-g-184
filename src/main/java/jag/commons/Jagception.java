package jag.commons;

import jag.audi.AudioRunnable;

import java.applet.Applet;

public class Jagception extends RuntimeException {

    public static Applet anApplet1881;
    public static int[] anIntArray1878;
    public static String aString1882;
    public static AudioRunnable anAudioRunnable1880;
    public final Throwable throwable;
    public String message;

    public Jagception(Throwable throwable, String message) {
        this.throwable = throwable;
        this.message = message;
    }
}
