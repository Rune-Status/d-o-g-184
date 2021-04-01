package jag.game.type;

import jag.commons.collection.DoublyLinkedNode;
import jag.commons.collection.ReferenceCache;
import jag.js5.ReferenceTable;
import jag.opcode.Buffer;

import java.awt.*;

public class TileOverlay extends DoublyLinkedNode {

    public static final ReferenceCache<TileOverlay> cache;
    public static ReferenceTable table;
    public static FontMetrics aFontMetrics1467;

    static {
        cache = new ReferenceCache<>(64);
    }

    public int anInt112;
    public int anInt378;
    public boolean aBoolean502;
    public int anInt377;
    public int anInt375;
    public int anInt564;
    public int anInt372;
    public int anInt368;
    public int anInt379;
    public int anInt367;

    public TileOverlay() {
        anInt378 = 0;
        anInt377 = -1;
        aBoolean502 = true;
        anInt112 = -1;
    }

    public static String method1009(CharSequence[] var0, int var1, int var2) {
        if (var2 == 0) {
            return "";
        }
        if (var2 == 1) {
            CharSequence var3 = var0[var1];
            return var3 == null ? "null" : var3.toString();
        }
        int var4 = var2 + var1;
        int var5 = 0;

        for (int var6 = var1; var6 < var4; ++var6) {
            CharSequence var7 = var0[var6];
            if (var7 == null) {
                var5 += 4;
            } else {
                var5 += var7.length();
            }
        }

        StringBuilder var8 = new StringBuilder(var5);

        for (int var9 = var1; var9 < var4; ++var9) {
            CharSequence var10 = var0[var9];
            if (var10 == null) {
                var8.append("null");
            } else {
                var8.append(var10);
            }
        }

        return var8.toString();
    }

    void decode(Buffer var1, int var2) {
        if (var2 == 1) {
            anInt378 = var1.g3();
        } else if (var2 == 2) {
            anInt377 = var1.g1();
        } else if (var2 == 5) {
            aBoolean502 = false;
        } else if (var2 == 7) {
            anInt112 = var1.g3();
        } else if (var2 == 8) {

        }
    }

    void method1007(int var1) {
        double var2 = (double) (var1 >> 16 & 255) / 256.0D;
        double var4 = (double) (var1 >> 8 & 255) / 256.0D;
        double var6 = (double) (var1 & 255) / 256.0D;
        double var8 = var2;
        if (var4 < var2) {
            var8 = var4;
        }

        if (var6 < var8) {
            var8 = var6;
        }

        double var10 = var2;
        if (var4 > var2) {
            var10 = var4;
        }

        if (var6 > var10) {
            var10 = var6;
        }

        double var12 = 0.0D;
        double var14 = 0.0D;
        double var16 = (var8 + var10) / 2.0D;
        if (var8 != var10) {
            if (var16 < 0.5D) {
                var14 = (var10 - var8) / (var8 + var10);
            }

            if (var16 >= 0.5D) {
                var14 = (var10 - var8) / (2.0D - var10 - var8);
            }

            if (var10 == var2) {
                var12 = (var4 - var6) / (var10 - var8);
            } else if (var10 == var4) {
                var12 = (var6 - var2) / (var10 - var8) + 2.0D;
            } else if (var6 == var10) {
                var12 = (var2 - var4) / (var10 - var8) + 4.0D;
            }
        }

        var12 /= 6.0D;
        anInt375 = (int) (256.0D * var12);
        anInt372 = (int) (256.0D * var14);
        anInt379 = (int) (var16 * 256.0D);
        if (anInt372 < 0) {
            anInt372 = 0;
        } else if (anInt372 > 255) {
            anInt372 = 255;
        }

        if (anInt379 < 0) {
            anInt379 = 0;
        } else if (anInt379 > 255) {
            anInt379 = 255;
        }

    }

    public void method499() {
        if (anInt112 != -1) {
            method1007(anInt112);
            anInt564 = anInt375;
            anInt368 = anInt372;
            anInt367 = anInt379;
        }

        method1007(anInt378);
    }

    public void decode(Buffer buffer) {
        while (true) {
            int opcode = buffer.g1();
            if (opcode == 0) {
                return;
            }
            decode(buffer, opcode);
        }
    }
}
