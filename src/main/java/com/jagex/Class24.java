package com.jagex;

public class Class24 {
    static final Class24 aClass24_301;
    static final Class24 aClass24_302;
    static Connection aConnection299;

    static {
        aClass24_301 = new Class24(0);
        aClass24_302 = new Class24(1);
    }

    final int anInt300;

    Class24(int var1) {
        this.anInt300 = var1;
    }

    public static synchronized long currentTime() {
        long var0 = System.currentTimeMillis();
        if (var0 < Statics32.aLong1564) {
            Statics32.aLong1565 += Statics32.aLong1564 - var0;
        }

        Statics32.aLong1564 = var0;
        return var0 + Statics32.aLong1565;
    }

    public static synchronized byte[] newSyncPooledBuffer(int var0) {
        return Class204.newPooledBuffer(var0);
    }

    static void method185(InterfaceComponent var0, int var1, int var2) {
        if (var0.xLayout == 0) {
            var0.relativeX = var0.xMargin;
        } else if (var0.xLayout == 1) {
            var0.relativeX = var0.xMargin + (var1 - var0.width) / 2;
        } else if (var0.xLayout == 2) {
            var0.relativeX = var1 - var0.width - var0.xMargin;
        } else if (var0.xLayout == 3) {
            var0.relativeX = var0.xMargin * var1 >> 14;
        } else if (var0.xLayout == 4) {
            var0.relativeX = (var1 - var0.width) / 2 + (var0.xMargin * var1 >> 14);
        } else {
            var0.relativeX = var1 - var0.width - (var0.xMargin * var1 >> 14);
        }

        if (var0.yLayout == 0) {
            var0.relativeY = var0.yMargin;
        } else if (var0.yLayout == 1) {
            var0.relativeY = (var2 - var0.height) / 2 + var0.yMargin;
        } else if (var0.yLayout == 2) {
            var0.relativeY = var2 - var0.height - var0.yMargin;
        } else if (var0.yLayout == 3) {
            var0.relativeY = var2 * var0.yMargin >> 14;
        } else if (var0.yLayout == 4) {
            var0.relativeY = (var2 * var0.yMargin >> 14) + (var2 - var0.height) / 2;
        } else {
            var0.relativeY = var2 - var0.height - (var2 * var0.yMargin >> 14);
        }

    }

    public static int method183(int var0, int var1) {
        int var2;
        for (var2 = 1; var1 > 1; var1 >>= 1) {
            if ((var1 & 1) != 0) {
                var2 = var0 * var2;
            }

            var0 *= var0;
        }

        if (var1 == 1) {
            return var0 * var2;
        }
        return var2;
    }

    static void method180(int var0, int var1, int var2, int var3) {
        for (int var4 = var1; var4 <= var3 + var1; ++var4) {
            for (int var5 = var0; var5 <= var0 + var2; ++var5) {
                if (var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
                    Class44.aByteArrayArrayArray400[0][var5][var4] = 127;
                    if (var0 == var5 && var5 > 0) {
                        Class44.tileHeights[0][var5][var4] = Class44.tileHeights[0][var5 - 1][var4];
                    }

                    if (var0 + var2 == var5 && var5 < 103) {
                        Class44.tileHeights[0][var5][var4] = Class44.tileHeights[0][var5 + 1][var4];
                    }

                    if (var4 == var1 && var4 > 0) {
                        Class44.tileHeights[0][var5][var4] = Class44.tileHeights[0][var5][var4 - 1];
                    }

                    if (var4 == var3 + var1 && var4 < 103) {
                        Class44.tileHeights[0][var5][var4] = Class44.tileHeights[0][var5][var4 + 1];
                    }
                }
            }
        }

    }

    static void method181(AnimationSequence var0, int var1, int var2, int var3) {
        if (client.anInt903 < 50 && client.anInt897 != 0) {
            if (var0.anIntArray691 != null && var1 < var0.anIntArray691.length) {
                int var4 = var0.anIntArray691[var1];
                if (var4 != 0) {
                    int var5 = var4 >> 8;
                    int var6 = var4 >> 4 & 7;
                    int var7 = var4 & 15;
                    client.anIntArray899[client.anInt903] = var5;
                    client.anIntArray905[client.anInt903] = var6;
                    client.anIntArray906[client.anInt903] = 0;
                    client.audioEffects[client.anInt903] = null;
                    int var8 = (var2 - 64) / 128;
                    int var9 = (var3 - 64) / 128;
                    client.anIntArray902[client.anInt903] = var7 + (var9 << 8) + (var8 << 16);
                    ++client.anInt903;
                }
            }
        }
    }
}
