package com.jagex;

import javax.imageio.ImageIO;

public class Class30 {
    public static Node_Sub6_Sub3 aClass5_Sub6_Sub3_326;
    public static int anInt327;

    static {
        ImageIO.setUseCache(false);
    }

    static Font method221(byte[] var0) {
        if (var0 == null) {
            return null;
        }
        Font var1 = new Font(var0, Statics41.anIntArray1821, Node_Sub6_Sub4.anIntArray1107, Statics41.anIntArray1820, Jagception.anIntArray1878, OutgoingPacket.aByteArrayArray114);
        Statics41.anIntArray1821 = null;
        Node_Sub6_Sub4.anIntArray1107 = null;
        Statics41.anIntArray1820 = null;
        Jagception.anIntArray1878 = null;
        Statics41.anIntArray1823 = null;
        OutgoingPacket.aByteArrayArray114 = null;
        return var1;
    }

    static void method220(int var0, boolean var1, int var2, boolean var3) {
        if (World.worlds != null) {
            Class63.method357(0, World.worlds.length - 1, var0, var1, var2, var3);
        }

    }
}
