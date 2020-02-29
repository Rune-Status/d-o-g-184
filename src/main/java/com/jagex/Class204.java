package com.jagex;

public class Class204 {
    public static int[] anIntArray1637;
    public static int[] anIntArray1642;
    static int anInt1641;
    static int anInt1643;
    static int anInt1640;
    static byte[][] aByteArrayArray1639;
    static byte[][] aByteArrayArray1638;
    static byte[][] aByteArrayArray1636;

    static {
        anInt1641 = 0;
        anInt1643 = 0;
        anInt1640 = 0;
        aByteArrayArray1639 = new byte[1000][];
        aByteArrayArray1638 = new byte[250][];
        aByteArrayArray1636 = new byte[50][];
    }

    static synchronized byte[] newPooledBuffer(int var0) {
        byte[] var2;
        if (var0 != 100) {
            if (var0 < 100) {
            }
        } else if (anInt1641 > 0) {
            var2 = aByteArrayArray1639[--anInt1641];
            aByteArrayArray1639[anInt1641] = null;
            return var2;
        }

        if (var0 != 5000) {
            if (var0 < 5000) {
            }
        } else if (anInt1643 > 0) {
            var2 = aByteArrayArray1638[--anInt1643];
            aByteArrayArray1638[anInt1643] = null;
            return var2;
        }

        if (var0 != 30000) {
            if (var0 < 30000) {
            }
        } else if (anInt1640 > 0) {
            var2 = aByteArrayArray1636[--anInt1640];
            aByteArrayArray1636[anInt1640] = null;
            return var2;
        }

        if (EntityUID.aByteArrayArrayArray547 != null) {
            for (int var3 = 0; var3 < anIntArray1637.length; ++var3) {
                if (anIntArray1637[var3] != var0) {
                    if (var0 < anIntArray1637[var3]) {
                    }
                } else if (anIntArray1642[var3] > 0) {
                    byte[] var4 = EntityUID.aByteArrayArrayArray547[var3][--anIntArray1642[var3]];
                    EntityUID.aByteArrayArrayArray547[var3][anIntArray1642[var3]] = null;
                    return var4;
                }
            }
        }

        return new byte[var0];
    }
}
