package com.jagex;

import java.util.HashMap;

public class Class172 {
    final HashMap aHashMap1450;
    int anInt1447;
    int[] anIntArray1449;
    int[] anIntArray1448;
    Class215 aClass215_1451;

    public Class172() {
        this.aHashMap1450 = new HashMap();
        this.aClass215_1451 = new Class215(0, 0);
        this.anIntArray1449 = new int[2048];
        this.anIntArray1448 = new int[2048];
        this.anInt1447 = 0;
        Statics28.anIntArray1520 = new int[2000];
        int var1 = 0;
        int var2 = 240;

        int var4;
        for (byte var3 = 12; var1 < 16; var2 -= var3) {
            var4 = Class48.method295((double) ((float) var2 / 360.0F), 0.9998999834060669D, (double) (0.075F + 0.425F * (float) var1 / 16.0F));
            Statics28.anIntArray1520[var1] = var4;
            ++var1;
        }

        var2 = 48;

        for (int var6 = var2 / 6; var1 < Statics28.anIntArray1520.length; var2 -= var6) {
            var4 = var1 * 2;

            for (int var5 = Class48.method295((double) ((float) var2 / 360.0F), 0.9998999834060669D, 0.5D); var1 < var4 && var1 < Statics28.anIntArray1520.length; ++var1) {
                Statics28.anIntArray1520[var1] = var5;
            }
        }

    }

    Sprite method996(int var1) {
        if (!this.aHashMap1450.containsKey(var1)) {
            this.method995(var1);
        }

        return (Sprite) this.aHashMap1450.get(var1);
    }

    void method995(int var1) {
        int var2 = var1 * 2 + 1;
        double[] var3 = Statics35.method1172(0.0D, (double) ((float) var1 / 3.0F), var1);
        double var4 = var3[var1] * var3[var1];
        int[] var6 = new int[var2 * var2];
        boolean var7 = false;

        for (int var8 = 0; var8 < var2; ++var8) {
            for (int var9 = 0; var9 < var2; ++var9) {
                int var10 = var6[var9 + var8 * var2] = (int) (256.0D * (var3[var8] * var3[var9] / var4));
                if (!var7 && var10 > 0) {
                    var7 = true;
                }
            }
        }

        Sprite var11 = new Sprite(var6, var2, var2);
        this.aHashMap1450.put(var1, var11);
    }

    void method991(Sprite var1, Sprite var2, Class215 var3) {
        if (var3.anInt1812 != 0 && var3.anInt1811 != 0) {
            int var4 = 0;
            int var5 = 0;
            if (var3.anInt1813 == 0) {
                var4 = var1.width - var3.anInt1812;
            }

            if (var3.anInt1814 == 0) {
                var5 = var1.height - var3.anInt1811;
            }

            int var6 = var4 + var5 * var1.width;
            int var7 = var3.anInt1813 + var2.width * var3.anInt1814;

            for (int var8 = 0; var8 < var3.anInt1811; ++var8) {
                for (int var9 = 0; var9 < var3.anInt1812; ++var9) {
                    int[] var10000 = var2.pixels;
                    int var10001 = var7++;
                    var10000[var10001] += var1.pixels[var6++];
                }

                var6 += var1.width - var3.anInt1812;
                var7 += var2.width - var3.anInt1812;
            }

        }
    }

    public final void method992(int var1, int var2, Sprite var3, float var4) {
        int var5 = (int) (var4 * 18.0F);
        Sprite var6 = this.method996(var5);
        int var7 = var5 * 2 + 1;
        Class215 var8 = new Class215(0, 0, var3.width, var3.height);
        Class215 var9 = new Class215(0, 0);
        this.aClass215_1451.method1317(var7, var7);
        System.nanoTime();

        int var10;
        int var11;
        int var12;
        for (var10 = 0; var10 < this.anInt1447; ++var10) {
            var11 = this.anIntArray1449[var10];
            var12 = this.anIntArray1448[var10];
            int var13 = (int) ((float) (var11 - var1) * var4) - var5;
            int var14 = (int) ((float) var3.height - var4 * (float) (var12 - var2)) - var5;
            this.aClass215_1451.method1316(var13, var14);
            this.aClass215_1451.method1315(var8, var9);
            this.method991(var6, var3, var9);
        }

        System.nanoTime();
        System.nanoTime();

        for (var10 = 0; var10 < var3.pixels.length; ++var10) {
            if (var3.pixels[var10] == 0) {
                var3.pixels[var10] = -16777216;
            } else {
                var11 = (var3.pixels[var10] + 64 - 1) / 256;
                if (var11 <= 0) {
                    var3.pixels[var10] = -16777216;
                } else {
                    if (var11 > Statics28.anIntArray1520.length) {
                        var11 = Statics28.anIntArray1520.length;
                    }

                    var12 = Statics28.anIntArray1520[var11 - 1];
                    var3.pixels[var10] = -16777216 | var12;
                }
            }
        }

        System.nanoTime();
    }

    public final void method993() {
        this.anInt1447 = 0;
    }

    public final void method994(int var1, int var2) {
        if (this.anInt1447 < this.anIntArray1449.length) {
            this.anIntArray1449[this.anInt1447] = var1;
            this.anIntArray1448[this.anInt1447] = var2;
            ++this.anInt1447;
        }
    }
}
