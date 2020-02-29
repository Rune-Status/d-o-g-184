package com.jagex;

public class Class46 {
    static byte[][] aByteArrayArray425;
    static Sprite[] aSpriteArray429;
    static int[] anIntArray426;
    final int anInt428;
    final CacheReferenceTable aCacheReferenceTable430;
    int anInt427;

    Class46(CacheReferenceTable var1) {
        this.anInt427 = 0;
        this.aCacheReferenceTable430 = var1;
        this.anInt428 = var1.method916();
    }

    public static String readStringFromBytes(byte[] var0, int var1, int var2) {
        char[] var3 = new char[var2];
        int var4 = 0;

        for (int var5 = 0; var5 < var2; ++var5) {
            int var6 = var0[var5 + var1] & 255;
            if (var6 != 0) {
                if (var6 >= 128 && var6 < 160) {
                    char var7 = Statics35.aCharArray1616[var6 - 128];
                    if (var7 == 0) {
                        var7 = '?';
                    }

                    var6 = var7;
                }

                var3[var4++] = (char) var6;
            }
        }

        return new String(var3, 0, var4);
    }

    static int method288(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
        int var6 = AssociateComparator_Sub2.method606(var0, var1, var2, var3);
        if (var6 != 0) {
            return var3 ? -var6 : var6;
        }
        if (var4 == -1) {
            return 0;
        }
        int var7 = AssociateComparator_Sub2.method606(var0, var1, var4, var5);
        return var5 ? -var7 : var7;
    }

    boolean method291() {
        this.anInt427 = 0;

        for (int var1 = 0; var1 < this.anInt428; ++var1) {
            if (!this.aCacheReferenceTable430.method496(var1) || this.aCacheReferenceTable430.method495(var1)) {
                ++this.anInt427;
            }
        }

        return this.anInt427 >= this.anInt428;
    }
}
