package com.jagex;

public final class Class44 {
    static final int[] anIntArray406;
    static final int[] anIntArray395;
    static final int[] anIntArray402;
    static final int[] anIntArray394;
    static final int[] anIntArray397;
    static final int[] anIntArray392;
    public static SocialSystem socialSystem;
    static int[][][] tileHeights;
    static byte[][][] sceneRenderRules;
    static int anInt405;
    static int anInt399;
    static Class209 aClass209_391;
    static int anInt398;
    static long aLong403;
    static byte[][][] aByteArrayArrayArray404;
    static byte[][][] aByteArrayArrayArray401;
    static int[][][] anIntArrayArrayArray393;
    static byte[][][] aByteArrayArrayArray400;
    static int[] anIntArray396;
    static int[] anIntArray390;
    static int[] anIntArray389;

    static {
        tileHeights = new int[4][105][105];
        sceneRenderRules = new byte[4][104][104];
        anInt405 = 99;
        anIntArray406 = new int[]{1, 2, 4, 8};
        anIntArray395 = new int[]{16, 32, 64, 128};
        anIntArray402 = new int[]{1, 0, -1, 0};
        anIntArray394 = new int[]{0, -1, 0, 1};
        anIntArray397 = new int[]{1, -1, -1, 1};
        anIntArray392 = new int[]{-1, -1, 1, 1};
        anInt399 = (int) (Math.random() * 17.0D) - 8;
        anInt398 = (int) (Math.random() * 33.0D) - 16;
    }

    public static void method267(byte[] var0) {
        Buffer var1 = new Buffer(var0);
        var1.caret = var0.length - 2;
        Statics41.anInt1822 = var1.readUShort();
        Statics41.anIntArray1821 = new int[Statics41.anInt1822];
        Node_Sub6_Sub4.anIntArray1107 = new int[Statics41.anInt1822];
        Statics41.anIntArray1820 = new int[Statics41.anInt1822];
        Jagception.anIntArray1878 = new int[Statics41.anInt1822];
        OutgoingPacket.aByteArrayArray114 = new byte[Statics41.anInt1822][];
        var1.caret = var0.length - 7 - Statics41.anInt1822 * 8;
        Statics41.anInt1824 = var1.readUShort();
        DoublyLinkedNode_Sub6.anInt378 = var1.readUShort();
        int var2 = (var1.readUByte() & 255) + 1;

        int var3;
        for (var3 = 0; var3 < Statics41.anInt1822; ++var3) {
            Statics41.anIntArray1821[var3] = var1.readUShort();
        }

        for (var3 = 0; var3 < Statics41.anInt1822; ++var3) {
            Node_Sub6_Sub4.anIntArray1107[var3] = var1.readUShort();
        }

        for (var3 = 0; var3 < Statics41.anInt1822; ++var3) {
            Statics41.anIntArray1820[var3] = var1.readUShort();
        }

        for (var3 = 0; var3 < Statics41.anInt1822; ++var3) {
            Jagception.anIntArray1878[var3] = var1.readUShort();
        }

        var1.caret = var0.length - 7 - Statics41.anInt1822 * 8 - (var2 - 1) * 3;
        Statics41.anIntArray1823 = new int[var2];

        for (var3 = 1; var3 < var2; ++var3) {
            Statics41.anIntArray1823[var3] = var1.readMediumInt();
            if (Statics41.anIntArray1823[var3] == 0) {
                Statics41.anIntArray1823[var3] = 1;
            }
        }

        var1.caret = 0;

        for (var3 = 0; var3 < Statics41.anInt1822; ++var3) {
            int var4 = Statics41.anIntArray1820[var3];
            int var5 = Jagception.anIntArray1878[var3];
            int var6 = var4 * var5;
            byte[] var7 = new byte[var6];
            OutgoingPacket.aByteArrayArray114[var3] = var7;
            int var8 = var1.readUByte();
            int var9;
            if (var8 == 0) {
                for (var9 = 0; var9 < var6; ++var9) {
                    var7[var9] = var1.readByte();
                }
            } else if (var8 == 1) {
                for (var9 = 0; var9 < var4; ++var9) {
                    for (int var10 = 0; var10 < var5; ++var10) {
                        var7[var9 + var4 * var10] = var1.readByte();
                    }
                }
            }
        }

    }

}
