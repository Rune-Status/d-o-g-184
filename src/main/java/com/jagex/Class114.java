package com.jagex;

import java.util.Comparator;

public class Class114 implements Comparator {
    public static String[] cacheDirectories;
    final boolean aBoolean813;

    public Class114(boolean var1) {
        this.aBoolean813 = var1;
    }

    static void method672() {
        if (client.anInt988 == 1) {
            client.aBoolean996 = true;
        }

    }

    public static void method674(ReferenceTable var0, String var1, String var2, int var3, boolean var4) {
        int var5 = var0.method900(var1);
        int var6 = var0.method907(var5, var2);
        Class61.method344(var0, var5, var6, var3, var4);
    }

    int method673(Associate var1, Associate var2) {
        return this.aBoolean813 ? var1.anInt1222 - var2.anInt1222 : var2.anInt1222 - var1.anInt1222;
    }

    public int compare(Object var1, Object var2) {
        return this.method673((Associate) var1, (Associate) var2);
    }

    public boolean equals(Object var1) {
        return super.equals(var1);
    }
}
