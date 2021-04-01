package jag.statics;

import java.io.File;
import java.util.Hashtable;

public class Statics4 {
    public static final Hashtable<String, File> rwFileCache;
    public static boolean aBoolean830;
    public static File aFile831;

    static {
        aBoolean830 = false;
        rwFileCache = new Hashtable<>(16);
    }
}
