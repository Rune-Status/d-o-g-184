package jag;

import jag.js5.ReferenceTable;

import java.security.SecureRandom;
import java.util.concurrent.Callable;

public class SecureRandomCallable implements Callable<SecureRandom> {

    public static ReferenceTable aReferenceTable382;
    public static int anInt1341;

    public SecureRandomCallable() {

    }

    public static long method256(int var0, int var1, int var2) {
        return var2 << 16 | var0 << 8 | var1;
    }

    public SecureRandom call() {
        return SecureRandomService.provide();
    }
}
