package com.jagex;

public class Class96 {
    static Class165 aClass165_725;
    int anInt729;
    int anInt727;
    int anInt726;
    int anInt728;

    Class96() {
    }

    Class96(Class96 var1) {
        this.anInt729 = var1.anInt729;
        this.anInt727 = var1.anInt727;
        this.anInt726 = var1.anInt726;
        this.anInt728 = var1.anInt728;
    }

    public static String method535(CharSequence var0) {
        long var1 = 0L;
        int var3 = var0.length();

        for (int var4 = 0; var4 < var3; ++var4) {
            var1 *= 37L;
            char var5 = var0.charAt(var4);
            if (var5 >= 'A' && var5 <= 'Z') {
                var1 += (long) (var5 + 1 - 65);
            } else if (var5 >= 'a' && var5 <= 'z') {
                var1 += (long) (var5 + 1 - 97);
            } else if (var5 >= '0' && var5 <= '9') {
                var1 += (long) (var5 + 27 - 48);
            }

            if (var1 >= 177917621779460413L) {
                break;
            }
        }

        while (var1 % 37L == 0L && 0L != var1) {
            var1 /= 37L;
        }

        String var8 = World.method1353(var1);
        if (var8 == null) {
            var8 = "";
        }

        return var8;
    }

    static boolean method534(ReferenceTable var0, int var1, int var2) {
        byte[] var3 = var0.unpack(var1, var2);
        if (var3 == null) {
            return false;
        }
        Class44.method267(var3);
        return true;
    }

    public static void method532() {
        synchronized (Mouse.instance) {
            Mouse.pressMeta = Mouse.pendingPressMeta;
            Mouse.x = Mouse.pendingX;
            Mouse.y = Mouse.pendingY;
            Mouse.lastMoveTime = Mouse.pendingMoveTime;
            Mouse.clickMeta = Mouse.pendingClickMeta;
            Mouse.clickX = Mouse.pendingClickX;
            Mouse.clickY = Mouse.pendingClickY;
            Mouse.timeOfClick = Mouse.pendingTimeOfClick;
            Mouse.pendingClickMeta = 0;
        }
    }

    public static void method533() {
        Class30.aClass5_Sub6_Sub3_326.method756();
        Class147.anInt1157 = 1;
        Class147.aReferenceTable1155 = null;
    }
}
