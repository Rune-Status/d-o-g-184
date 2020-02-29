package com.jagex;

public enum Enum_Sub2 implements EnumType {
    anEnum_Sub2_624(0, (byte) 0),
    anEnum_Sub2_625(3, (byte) 1),
    anEnum_Sub2_622(2, (byte) 2),
    anEnum_Sub2_621(1, (byte) 3);

    public static boolean aBoolean620;
    static String aString623;
    final byte aByte618;
    final int anInt619;

    Enum_Sub2(int var3, byte var4) {
        this.anInt619 = var3;
        this.aByte618 = var4;
    }

    static void repaintComponent(InterfaceComponent var0) {
        if (var0.renderCycle == client.anInt1084) {
            client.aBooleanArray1089[var0.boundsIndex] = true;
        }

    }

    static String method442(String var0) {
        Enum_Sub6[] var1 = Statics13.method871();

        for (Enum_Sub6 var3 : var1) {
            if (var3.anInt1218 != -1 && var0.startsWith(Statics26.method1111(var3.anInt1218))) {
                var0 = var0.substring(6 + Integer.toString(var3.anInt1218).length());
                break;
            }
        }

        return var0;
    }

    static boolean method440(InterfaceComponent var0) {
        return var0.explicitlyHidden;
    }

    public int getOrdinal() {
        return this.aByte618;
    }
}
