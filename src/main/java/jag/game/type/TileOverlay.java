package jag.game.type;

import jag.commons.collection.DoublyLinkedNode;
import jag.commons.collection.ReferenceCache;
import jag.js5.ReferenceTable;
import jag.opcode.Buffer;

import java.awt.*;

public class TileOverlay extends DoublyLinkedNode {

    public static final ReferenceCache aReferenceCache385;
    public static ReferenceTable aReferenceTable383;
    public static FontMetrics aFontMetrics1467;

    static {
        aReferenceCache385 = new ReferenceCache(64);
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
        this.anInt378 = 0;
        this.anInt377 = -1;
        this.aBoolean502 = true;
        this.anInt112 = -1;
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
            this.anInt378 = var1.readMediumInt();
        } else if (var2 == 2) {
            this.anInt377 = var1.readUByte();
        } else if (var2 == 5) {
            this.aBoolean502 = false;
        } else if (var2 == 7) {
            this.anInt112 = var1.readMediumInt();
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
        this.anInt375 = (int) (256.0D * var12);
        this.anInt372 = (int) (256.0D * var14);
        this.anInt379 = (int) (var16 * 256.0D);
        if (this.anInt372 < 0) {
            this.anInt372 = 0;
        } else if (this.anInt372 > 255) {
            this.anInt372 = 255;
        }

        if (this.anInt379 < 0) {
            this.anInt379 = 0;
        } else if (this.anInt379 > 255) {
            this.anInt379 = 255;
        }

    }

    public void method499() {
        if (this.anInt112 != -1) {
            this.method1007(this.anInt112);
            this.anInt564 = this.anInt375;
            this.anInt368 = this.anInt372;
            this.anInt367 = this.anInt379;
        }

        this.method1007(this.anInt378);
    }

    public void decode(Buffer var1) {
        while (true) {
            int var3 = var1.readUByte();
            if (var3 == 0) {
                return;
            }

            this.decode(var1, var3);
        }
    }
}
