package com.jagex;

public class Class99 {
    static float[][] aFloatArrayArray737;
    static int[][] anIntArrayArray738;
    static float aFloat744;
    static int anInt742;

    static {
        aFloatArrayArray737 = new float[2][8];
        anIntArrayArray738 = new int[2][8];
    }

    int[][][] anIntArrayArrayArray740;
    int[][][] anIntArrayArrayArray741;
    int[] anIntArray739;
    int[] anIntArray743;

    Class99() {
        this.anIntArray743 = new int[2];
        this.anIntArrayArrayArray741 = new int[2][2][4];
        this.anIntArrayArrayArray740 = new int[2][2][4];
        this.anIntArray739 = new int[2];
    }

    static float method551(float var0) {
        float var1 = 32.703197F * (float) Math.pow(2.0D, (double) var0);
        return var1 * 3.1415927F / 11025.0F;
    }

    float method550(int var1, int var2, float var3) {
        float var4 = (float) this.anIntArrayArrayArray740[var1][0][var2] + var3 * (float) (this.anIntArrayArrayArray740[var1][1][var2] - this.anIntArrayArrayArray740[var1][0][var2]);
        var4 *= 0.0015258789F;
        return 1.0F - (float) Math.pow(10.0D, (double) (-var4 / 20.0F));
    }

    float method549(int var1, int var2, float var3) {
        float var4 = (float) this.anIntArrayArrayArray741[var1][0][var2] + var3 * (float) (this.anIntArrayArrayArray741[var1][1][var2] - this.anIntArrayArrayArray741[var1][0][var2]);
        var4 *= 1.2207031E-4F;
        return method551(var4);
    }

    int method548(int var1, float var2) {
        float var3;
        if (var1 == 0) {
            var3 = (float) this.anIntArray739[0] + (float) (this.anIntArray739[1] - this.anIntArray739[0]) * var2;
            var3 *= 0.0030517578F;
            aFloat744 = (float) Math.pow(0.1D, (double) (var3 / 20.0F));
            anInt742 = (int) (aFloat744 * 65536.0F);
        }

        if (this.anIntArray743[var1] == 0) {
            return 0;
        }
        var3 = this.method550(var1, 0, var2);
        aFloatArrayArray737[var1][0] = -2.0F * var3 * (float) Math.cos((double) this.method549(var1, 0, var2));
        aFloatArrayArray737[var1][1] = var3 * var3;

        float[] var10000;
        int var4;
        for (var4 = 1; var4 < this.anIntArray743[var1]; ++var4) {
            var3 = this.method550(var1, var4, var2);
            float var5 = -2.0F * var3 * (float) Math.cos((double) this.method549(var1, var4, var2));
            float var6 = var3 * var3;
            aFloatArrayArray737[var1][var4 * 2 + 1] = aFloatArrayArray737[var1][var4 * 2 - 1] * var6;
            aFloatArrayArray737[var1][var4 * 2] = aFloatArrayArray737[var1][var4 * 2 - 1] * var5 + aFloatArrayArray737[var1][var4 * 2 - 2] * var6;

            for (int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
                var10000 = aFloatArrayArray737[var1];
                var10000[var7] += aFloatArrayArray737[var1][var7 - 1] * var5 + aFloatArrayArray737[var1][var7 - 2] * var6;
            }

            var10000 = aFloatArrayArray737[var1];
            var10000[1] += aFloatArrayArray737[var1][0] * var5 + var6;
            var10000 = aFloatArrayArray737[var1];
            var10000[0] += var5;
        }

        if (var1 == 0) {
            for (var4 = 0; var4 < this.anIntArray743[0] * 2; ++var4) {
                var10000 = aFloatArrayArray737[0];
                var10000[var4] *= aFloat744;
            }
        }

        for (var4 = 0; var4 < this.anIntArray743[var1] * 2; ++var4) {
            anIntArrayArray738[var1][var4] = (int) (aFloatArrayArray737[var1][var4] * 65536.0F);
        }

        return this.anIntArray743[var1] * 2;
    }

    final void method547(Buffer var1, AudioEnvelope var2) {
        int var3 = var1.readUByte();
        this.anIntArray743[0] = var3 >> 4;
        this.anIntArray743[1] = var3 & 15;
        if (var3 != 0) {
            this.anIntArray739[0] = var1.readUShort();
            this.anIntArray739[1] = var1.readUShort();
            int var4 = var1.readUByte();

            int var5;
            int var6;
            for (var5 = 0; var5 < 2; ++var5) {
                for (var6 = 0; var6 < this.anIntArray743[var5]; ++var6) {
                    this.anIntArrayArrayArray741[var5][0][var6] = var1.readUShort();
                    this.anIntArrayArrayArray740[var5][0][var6] = var1.readUShort();
                }
            }

            for (var5 = 0; var5 < 2; ++var5) {
                for (var6 = 0; var6 < this.anIntArray743[var5]; ++var6) {
                    if ((var4 & 1 << var5 * 4 << var6) != 0) {
                        this.anIntArrayArrayArray741[var5][1][var6] = var1.readUShort();
                        this.anIntArrayArrayArray740[var5][1][var6] = var1.readUShort();
                    } else {
                        this.anIntArrayArrayArray741[var5][1][var6] = this.anIntArrayArrayArray741[var5][0][var6];
                        this.anIntArrayArrayArray740[var5][1][var6] = this.anIntArrayArrayArray740[var5][0][var6];
                    }
                }
            }

            if (var4 != 0 || this.anIntArray739[1] != this.anIntArray739[0]) {
                var2.method1512(var1);
            }
        } else {
            int[] var7 = this.anIntArray739;
            this.anIntArray739[1] = 0;
            var7[0] = 0;
        }

    }
}
