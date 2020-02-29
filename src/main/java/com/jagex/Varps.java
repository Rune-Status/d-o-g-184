package com.jagex;

public class Varps {
    public static int[] tempVarps;
    public static int[] values;
    static int[] anIntArray1908;
    static ClanSystem clanSystem;

    static {
        anIntArray1908 = new int[32];
        int var0 = 2;

        for (int var1 = 0; var1 < 32; ++var1) {
            anIntArray1908[var1] = var0 - 1;
            var0 += var0;
        }

        tempVarps = new int[4000];
        values = new int[4000];
    }
}
