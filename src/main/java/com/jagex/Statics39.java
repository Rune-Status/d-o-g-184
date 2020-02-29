package com.jagex;

public class Statics39 {
    static final int[] anIntArray1727;
    static final int[] anIntArray1726;

    static {
        anIntArray1727 = new int[2048];
        anIntArray1726 = new int[2048];
        double var0 = 0.0030679615757712823D;

        for (int var2 = 0; var2 < 2048; ++var2) {
            anIntArray1727[var2] = (int) (65536.0D * Math.sin(var0 * (double) var2));
            anIntArray1726[var2] = (int) (65536.0D * Math.cos((double) var2 * var0));
        }

    }
}
