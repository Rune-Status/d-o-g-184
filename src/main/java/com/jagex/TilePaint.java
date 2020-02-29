package com.jagex;

public final class TilePaint {
    boolean flatShade;
    int anInt2002;
    int anInt2003;
    int rgb;
    int anInt2001;
    int anInt2000;
    int texture;

    TilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
        this.flatShade = true;
        this.anInt2002 = var1;
        this.anInt2003 = var2;
        this.anInt2001 = var3;
        this.anInt2000 = var4;
        this.texture = var5;
        this.rgb = var6;
        this.flatShade = var7;
    }

    public static int method1501(CharSequence var0) {
        return Class97.method536(var0, 10);
    }

    static void method1500(boolean var0) {
        Class55.loginResponse1 = "";
        Class55.loginResponse2 = "Enter your username/email & password.";
        Class55.loginResponse3 = "";
        Class55.loginState = 2;
        if (var0) {
            Class55.password = "";
        }

        InterfaceNode.method23();
        if (client.aBoolean958 && Class55.username != null && Class55.username.length() > 0) {
            Class55.anInt461 = 1;
        } else {
            Class55.anInt461 = 0;
        }

    }

    static String method1502(Buffer var0) {
        try {
            int var2 = var0.readSmart();
            if (var2 > 32767) {
                var2 = 32767;
            }

            byte[] var3 = new byte[var2];
            var0.caret += Statics19.aClass166_1261.method952(var0.payload, var0.caret, var3, 0, var2);
            return Class46.readStringFromBytes(var3, 0, var2);
        } catch (Exception var6) {
            return "Cabbage";
        }
    }
}
