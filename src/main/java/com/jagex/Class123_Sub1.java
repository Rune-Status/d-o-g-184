package com.jagex;

public class Class123_Sub1 extends Class123 {
    Class123_Sub1() {
    }

    static int method293(int var0, int var1, int var2) {
        if (var2 > 179) {
            var1 /= 2;
        }

        if (var2 > 192) {
            var1 /= 2;
        }

        if (var2 > 217) {
            var1 /= 2;
        }

        if (var2 > 243) {
            var1 /= 2;
        }

        return (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
    }

    public static String method294(Buffer var0) {
        return TilePaint.method1502(var0);
    }

    protected boolean method292(int var2, int var3) {
        return var2 == this.anInt843 && var3 == this.anInt844;
    }
}
