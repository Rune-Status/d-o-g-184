package com.jagex;

public class Class144 {
    static final Class144 aClass144_1144;
    static final Class144 aClass144_1145;
    static final Class144 aClass144_1146;

    static {
        aClass144_1145 = new Class144();
        aClass144_1146 = new Class144();
        aClass144_1144 = new Class144();
    }

    Class144() {
    }

    public static void method840() {
        if (Keyboard.keyboard != null) {
            synchronized (Keyboard.keyboard) {
                Keyboard.keyboard = null;
            }
        }

    }

    static void method841(PathingEntity var0) {
        int var1 = var0.forceMovementStartCycle - client.engineCycle;
        int var2 = var0.boundSize + var0.anInt1354 * 128;
        int var3 = var0.boundSize + var0.anInt2011 * 128;
        var0.fineX += (var2 - var0.fineX) / var1;
        var0.fineY += (var3 - var0.fineY) / var1;
        var0.anInt2022 = 0;
        var0.orientation = var0.anInt2019;
    }
}
