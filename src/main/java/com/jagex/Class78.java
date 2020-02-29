package com.jagex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Class78 {
    public static Comparator aComparator610;
    public static Comparator aComparator608;
    public static Comparator aComparator607;
    public static Comparator aComparator606;

    static {
        aComparator610 = new Class74();
        new Class76();
        aComparator608 = new Class57();
        aComparator607 = new Class56();
        aComparator606 = new Class88();
    }

    public final List aList609;

    public Class78(Buffer var1) {
        int var3 = var1.readUShort();
        boolean var4 = var1.readUByte() == 1;
        byte var5;
        if (var4) {
            var5 = 1;
        } else {
            var5 = 0;
        }

        int var6 = var1.readUShort();
        this.aList609 = new ArrayList(var6);

        for (int var7 = 0; var7 < var6; ++var7) {
            this.aList609.add(new Class72(var1, var5, var3));
        }

    }

    public static Object method422(byte[] var0) {
        if (var0 == null) {
            return null;
        }
        if (var0.length > 136) {
            Class152_Sub1 var2 = new Class152_Sub1();
            var2.method801(var0);
            return var2;
        }
        return var0;
    }

    public void method421(Comparator var1, boolean var2) {
        if (var2) {
            Collections.sort(this.aList609, var1);
        } else {
            Collections.sort(this.aList609, Collections.reverseOrder(var1));
        }

    }
}
