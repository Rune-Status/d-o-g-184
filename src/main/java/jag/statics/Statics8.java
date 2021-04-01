package jag.statics;

import jag.js5.ReferenceTable;

public class Statics8 {

    static final int[] powers;
    public static ReferenceTable aReferenceTable1123;

    static {
        new Object();
        powers = new int[33];
        powers[0] = 0;
        int var0 = 2;

        for (int var1 = 1; var1 < 33; ++var1) {
            powers[var1] = var0 - 1;
            var0 += var0;
        }

    }
}
