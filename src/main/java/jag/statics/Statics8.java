package jag.statics;

import jag.js5.ReferenceTable;

public class Statics8 {
    static final int[] anIntArray1124;
    public static int anInt1122;
    public static ReferenceTable aReferenceTable1123;

    static {
        new Object();
        anIntArray1124 = new int[33];
        anIntArray1124[0] = 0;
        int var0 = 2;

        for (int var1 = 1; var1 < 33; ++var1) {
            anIntArray1124[var1] = var0 - 1;
            var0 += var0;
        }

    }
}
