package jag.game.stockmarket;

import jag.game.World;
import jag.game.client;
import jag.game.relationship.AssociateComparator_Sub2;
import jag.graphics.Sprite;
import jag.js5.Archive;
import jag.statics.Statics35;

public class Class46 {

    public static byte[][] aByteArrayArray425;
    public static Sprite[] aSpriteArray429;
    public static int[] anIntArray426;
    public final int anInt428;
    public final Archive aArchive430;
    public int anInt427;

    public Class46(Archive var1) {
        this.anInt427 = 0;
        this.aArchive430 = var1;
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

    public static int method288(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
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

    public static void method175(Archive var0) {
        Class46 var2 = new Class46(var0);
        client.anArrayList928.add(var2);
        client.anInt933 += var2.anInt428;
    }

    public boolean method291() {
        this.anInt427 = 0;

        for (int var1 = 0; var1 < this.anInt428; ++var1) {
            if (!this.aArchive430.method496(var1) || this.aArchive430.method495(var1)) {
                ++this.anInt427;
            }
        }

        return this.anInt427 >= this.anInt428;
    }
}
