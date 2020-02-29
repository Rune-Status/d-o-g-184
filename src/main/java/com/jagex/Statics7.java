package com.jagex;

public class Statics7 {
    static Font aFont863;
    static int[][] anIntArrayArray860;
    static int[][] anIntArrayArray859;
    static int[] anIntArray862;
    static int[] anIntArray861;
    static int anInt858;

    static {
        anIntArrayArray860 = new int[128][128];
        anIntArrayArray859 = new int[128][128];
        anIntArray862 = new int[4096];
        anIntArray861 = new int[4096];
    }

    public static int method702(CharSequence var0) {
        int var1 = var0.length();
        int var2 = 0;

        for (int var3 = 0; var3 < var1; ++var3) {
            char var4 = var0.charAt(var3);
            if (var4 <= 127) {
                ++var2;
            } else if (var4 <= 2047) {
                var2 += 2;
            } else {
                var2 += 3;
            }
        }

        return var2;
    }
}
