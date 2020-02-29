package com.jagex;

public class Node_Sub6_Sub2 extends Node_Sub6 {
    int anInt377;
    int anInt378;
    int anInt574;
    int anInt372;
    int anInt367;
    int anInt568;
    int anInt380;
    int anInt112;
    int anInt379;
    int anInt375;
    int anInt564;
    int anInt386;
    int anInt366;
    boolean aBoolean763;
    int anInt696;

    Node_Sub6_Sub2(Node_Sub10_Sub1 var1, int var2, int var3, int var4) {
        this.aNode_Sub10_667 = var1;
        this.anInt379 = var1.anInt378;
        this.anInt564 = var1.anInt377;
        this.aBoolean763 = var1.aBoolean502;
        this.anInt568 = var2;
        this.anInt378 = var3;
        this.anInt377 = var4;
        this.anInt380 = 0;
        this.method592();
    }

    Node_Sub6_Sub2(Node_Sub10_Sub1 var1, int var2, int var3) {
        this.aNode_Sub10_667 = var1;
        this.anInt379 = var1.anInt378;
        this.anInt564 = var1.anInt377;
        this.aBoolean763 = var1.aBoolean502;
        this.anInt568 = var2;
        this.anInt378 = var3;
        this.anInt377 = 8192;
        this.anInt380 = 0;
        this.method592();
    }

    static int method601(int var0, int var1) {
        return var1 < 0 ? var0 : (int) ((double) var0 * Math.sqrt((double) (16384 - var1) * 1.220703125E-4D) + 0.5D);
    }

    static int method590(int var0, int var1) {
        return var1 < 0 ? -var0 : (int) ((double) var0 * Math.sqrt((double) var1 * 1.220703125E-4D) + 0.5D);
    }

    static int method573(byte[] var2, int[] var3, int var4, int var5, int var6, int var8, int var9, Node_Sub6_Sub2 var10, int var11, int var12) {
        int var7;
        if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 257) / var11) > var8) {
            var7 = var8;
        }

        byte var13;
        int var10001;
        int var1;
        while (var5 < var7) {
            var1 = var4 >> 8;
            var13 = var2[var1];
            var10001 = var5++;
            var3[var10001] += ((var13 << 8) + (var2[var1 + 1] - var13) * (var4 & 255)) * var6 >> 6;
            var4 += var11;
        }

        if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 1) / var11) > var8) {
            var7 = var8;
        }

        for (var1 = var12; var5 < var7; var4 += var11) {
            var13 = var2[var4 >> 8];
            var10001 = var5++;
            var3[var10001] += ((var13 << 8) + (var1 - var13) * (var4 & 255)) * var6 >> 6;
        }

        var10.anInt380 = var4;
        return var5;
    }

    static int method565(byte[] var2, int[] var3, int var4, int var5, int var6, int var8, int var9, Node_Sub6_Sub2 var10, int var11, int var12) {
        int var7;
        if (var11 == 0 || (var7 = var5 + (var11 + (var9 + 256 - var4)) / var11) > var8) {
            var7 = var8;
        }

        int var10001;
        int var1;
        while (var5 < var7) {
            var1 = var4 >> 8;
            byte var13 = var2[var1 - 1];
            var10001 = var5++;
            var3[var10001] += ((var13 << 8) + (var2[var1] - var13) * (var4 & 255)) * var6 >> 6;
            var4 += var11;
        }

        if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4)) / var11) > var8) {
            var7 = var8;
        }

        int var0 = var12;

        for (var1 = var11; var5 < var7; var4 += var1) {
            var10001 = var5++;
            var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
        }

        var10.anInt380 = var4;
        return var5;
    }

    static int method600(byte[] var0, int[] var1, int var2, int var3, int var4, int var6, int var7, Node_Sub6_Sub2 var8) {
        var2 >>= 8;
        var7 >>= 8;
        var4 <<= 2;
        int var5;
        if ((var5 = var3 + var7 - var2) > var6) {
            var5 = var6;
        }

        int var10001;
        for (var5 -= 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
            var10001 = var3++;
            var1[var10001] += var0[var2++] * var4;
            var10001 = var3++;
            var1[var10001] += var0[var2++] * var4;
            var10001 = var3++;
            var1[var10001] += var0[var2++] * var4;
            var10001 = var3++;
        }

        for (var5 += 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
            var10001 = var3++;
        }

        var8.anInt380 = var2 << 8;
        return var3;
    }

    static int method566(byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var9, int var10, Node_Sub6_Sub2 var11, int var12, int var13) {
        int var8;
        if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
            var8 = var9;
        }

        var5 <<= 1;

        byte var14;
        int var10001;
        int var1;
        int var0;
        for (var8 <<= 1; var5 < var8; var4 += var12) {
            var1 = var4 >> 8;
            var14 = var2[var1];
            var0 = (var14 << 8) + (var4 & 255) * (var2[var1 + 1] - var14);
            var10001 = var5++;
            var3[var10001] += var0 * var6 >> 6;
            var10001 = var5++;
            var3[var10001] += var0 * var7 >> 6;
        }

        if (var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12 - 1) / var12) > var9) {
            var8 = var9;
        }

        var8 <<= 1;

        for (var1 = var13; var5 < var8; var4 += var12) {
            var14 = var2[var4 >> 8];
            var0 = (var14 << 8) + (var1 - var14) * (var4 & 255);
            var10001 = var5++;
            var3[var10001] += var0 * var6 >> 6;
            var10001 = var5++;
            var3[var10001] += var0 * var7 >> 6;
        }

        var11.anInt380 = var4;
        return var5 >> 1;
    }

    static int method579(byte[] var0, int[] var1, int var2, int var3, int var4, int var6, int var7, Node_Sub6_Sub2 var8) {
        var2 >>= 8;
        var7 >>= 8;
        var4 <<= 2;
        int var5;
        if ((var5 = var3 + var2 - (var7 - 1)) > var6) {
            var5 = var6;
        }

        int var10001;
        for (var5 -= 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
            var10001 = var3++;
            var1[var10001] += var0[var2--] * var4;
            var10001 = var3++;
            var1[var10001] += var0[var2--] * var4;
            var10001 = var3++;
            var1[var10001] += var0[var2--] * var4;
            var10001 = var3++;
        }

        for (var5 += 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
            var10001 = var3++;
        }

        var8.anInt380 = var2 << 8;
        return var3;
    }

    static int method569(byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var9, int var10, Node_Sub6_Sub2 var11, int var12, int var13) {
        int var8;
        if (var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
            var8 = var9;
        }

        var5 <<= 1;

        int var10001;
        int var1;
        int var0;
        for (var8 <<= 1; var5 < var8; var4 += var12) {
            var1 = var4 >> 8;
            byte var14 = var2[var1 - 1];
            var0 = (var2[var1] - var14) * (var4 & 255) + (var14 << 8);
            var10001 = var5++;
            var3[var10001] += var0 * var6 >> 6;
            var10001 = var5++;
            var3[var10001] += var0 * var7 >> 6;
        }

        if (var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12) / var12) > var9) {
            var8 = var9;
        }

        var8 <<= 1;

        for (var1 = var13; var5 < var8; var4 += var12) {
            var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
            var10001 = var5++;
            var3[var10001] += var0 * var6 >> 6;
            var10001 = var5++;
            var3[var10001] += var0 * var7 >> 6;
        }

        var11.anInt380 = var4;
        return var5 >> 1;
    }

    static int method595(byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var8, int var9, Node_Sub6_Sub2 var10) {
        var3 >>= 8;
        var9 >>= 8;
        var5 <<= 2;
        var6 <<= 2;
        int var7;
        if ((var7 = var4 + var9 - var3) > var8) {
            var7 = var8;
        }

        var4 <<= 1;
        var7 <<= 1;

        int var10001;
        byte var11;
        for (var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
            var11 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
            var2[var10001] += var11 * var6;
            var11 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
            var2[var10001] += var11 * var6;
            var11 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
            var2[var10001] += var11 * var6;
            var11 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
        }

        for (var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
            var11 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
        }

        var10.anInt380 = var3 << 8;
        return var4 >> 1;
    }

    static int method594(byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var8, int var9, Node_Sub6_Sub2 var10) {
        var3 >>= 8;
        var9 >>= 8;
        var5 <<= 2;
        var6 <<= 2;
        int var7;
        if ((var7 = var3 + var4 - (var9 - 1)) > var8) {
            var7 = var8;
        }

        var4 <<= 1;
        var7 <<= 1;

        int var10001;
        byte var11;
        for (var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
            var11 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
            var2[var10001] += var11 * var6;
            var11 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
            var2[var10001] += var11 * var6;
            var11 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
            var2[var10001] += var11 * var6;
            var11 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
        }

        for (var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
            var11 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
        }

        var10.anInt380 = var3 << 8;
        return var4 >> 1;
    }

    static int method564(byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var9, int var10, Node_Sub6_Sub2 var11, int var12, int var13) {
        var11.anInt112 -= var11.anInt366 * var5;
        var11.anInt375 -= var11.anInt696 * var5;
        int var8;
        if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
            var8 = var9;
        }

        byte var14;
        int var10001;
        int var1;
        while (var5 < var8) {
            var1 = var4 >> 8;
            var14 = var2[var1];
            var10001 = var5++;
            var3[var10001] += ((var14 << 8) + (var2[var1 + 1] - var14) * (var4 & 255)) * var6 >> 6;
            var6 += var7;
            var4 += var12;
        }

        if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 1) / var12) > var9) {
            var8 = var9;
        }

        for (var1 = var13; var5 < var8; var4 += var12) {
            var14 = var2[var4 >> 8];
            var10001 = var5++;
            var3[var10001] += ((var14 << 8) + (var1 - var14) * (var4 & 255)) * var6 >> 6;
            var6 += var7;
        }

        var11.anInt112 += var11.anInt366 * var5;
        var11.anInt375 += var11.anInt696 * var5;
        var11.anInt574 = var6;
        var11.anInt380 = var4;
        return var5;
    }

    static int method602(byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var9, int var10, Node_Sub6_Sub2 var11, int var12, int var13) {
        var11.anInt112 -= var11.anInt366 * var5;
        var11.anInt375 -= var11.anInt696 * var5;
        int var8;
        if (var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
            var8 = var9;
        }

        int var10001;
        int var1;
        while (var5 < var8) {
            var1 = var4 >> 8;
            byte var14 = var2[var1 - 1];
            var10001 = var5++;
            var3[var10001] += ((var14 << 8) + (var2[var1] - var14) * (var4 & 255)) * var6 >> 6;
            var6 += var7;
            var4 += var12;
        }

        if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12) / var12) > var9) {
            var8 = var9;
        }

        int var0 = var13;

        for (var1 = var12; var5 < var8; var4 += var1) {
            var10001 = var5++;
            var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
            var6 += var7;
        }

        var11.anInt112 += var11.anInt366 * var5;
        var11.anInt375 += var11.anInt696 * var5;
        var11.anInt574 = var6;
        var11.anInt380 = var4;
        return var5;
    }

    static int method572(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var7, int var8, Node_Sub6_Sub2 var9) {
        var2 >>= 8;
        var8 >>= 8;
        var4 <<= 2;
        var5 <<= 2;
        int var6;
        if ((var6 = var3 + var8 - var2) > var7) {
            var6 = var7;
        }

        var9.anInt112 += var9.anInt366 * (var6 - var3);
        var9.anInt375 += var9.anInt696 * (var6 - var3);

        int var10001;
        for (var6 -= 3; var3 < var6; var4 += var5) {
            var10001 = var3++;
            var1[var10001] += var0[var2++] * var4;
            var4 += var5;
            var10001 = var3++;
            var1[var10001] += var0[var2++] * var4;
            var4 += var5;
            var10001 = var3++;
            var1[var10001] += var0[var2++] * var4;
            var4 += var5;
            var10001 = var3++;
            var1[var10001] += var0[var2++] * var4;
        }

        for (var6 += 3; var3 < var6; var4 += var5) {
            var10001 = var3++;
            var1[var10001] += var0[var2++] * var4;
        }

        var9.anInt574 = var4 >> 2;
        var9.anInt380 = var2 << 8;
        return var3;
    }

    static int method571(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var7, int var8, Node_Sub6_Sub2 var9) {
        var2 >>= 8;
        var8 >>= 8;
        var4 <<= 2;
        var5 <<= 2;
        int var6;
        if ((var6 = var3 + var2 - (var8 - 1)) > var7) {
            var6 = var7;
        }

        var9.anInt112 += var9.anInt366 * (var6 - var3);
        var9.anInt375 += var9.anInt696 * (var6 - var3);

        int var10001;
        for (var6 -= 3; var3 < var6; var4 += var5) {
            var10001 = var3++;
            var1[var10001] += var0[var2--] * var4;
            var4 += var5;
            var10001 = var3++;
            var1[var10001] += var0[var2--] * var4;
            var4 += var5;
            var10001 = var3++;
            var1[var10001] += var0[var2--] * var4;
            var4 += var5;
            var10001 = var3++;
            var1[var10001] += var0[var2--] * var4;
        }

        for (var6 += 3; var3 < var6; var4 += var5) {
            var10001 = var3++;
            var1[var10001] += var0[var2--] * var4;
        }

        var9.anInt574 = var4 >> 2;
        var9.anInt380 = var2 << 8;
        return var3;
    }

    static int method568(byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var11, int var12, Node_Sub6_Sub2 var13, int var14, int var15) {
        var13.anInt574 -= var5 * var13.anInt386;
        int var10;
        if (var14 == 0 || (var10 = var5 + (var12 - var4 + var14 - 257) / var14) > var11) {
            var10 = var11;
        }

        var5 <<= 1;

        byte var16;
        int var10001;
        int var1;
        int var0;
        for (var10 <<= 1; var5 < var10; var4 += var14) {
            var1 = var4 >> 8;
            var16 = var2[var1];
            var0 = (var16 << 8) + (var4 & 255) * (var2[var1 + 1] - var16);
            var10001 = var5++;
            var3[var10001] += var0 * var6 >> 6;
            var6 += var8;
            var10001 = var5++;
            var3[var10001] += var0 * var7 >> 6;
            var7 += var9;
        }

        if (var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14 - 1) / var14) > var11) {
            var10 = var11;
        }

        var10 <<= 1;

        for (var1 = var15; var5 < var10; var4 += var14) {
            var16 = var2[var4 >> 8];
            var0 = (var16 << 8) + (var1 - var16) * (var4 & 255);
            var10001 = var5++;
            var3[var10001] += var0 * var6 >> 6;
            var6 += var8;
            var10001 = var5++;
            var3[var10001] += var0 * var7 >> 6;
            var7 += var9;
        }

        var5 >>= 1;
        var13.anInt574 += var13.anInt386 * var5;
        var13.anInt112 = var6;
        var13.anInt375 = var7;
        var13.anInt380 = var4;
        return var5;
    }

    static int method570(byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var11, int var12, Node_Sub6_Sub2 var13, int var14, int var15) {
        var13.anInt574 -= var5 * var13.anInt386;
        int var10;
        if (var14 == 0 || (var10 = var5 + (var12 + 256 - var4 + var14) / var14) > var11) {
            var10 = var11;
        }

        var5 <<= 1;

        int var10001;
        int var1;
        int var0;
        for (var10 <<= 1; var5 < var10; var4 += var14) {
            var1 = var4 >> 8;
            byte var16 = var2[var1 - 1];
            var0 = (var2[var1] - var16) * (var4 & 255) + (var16 << 8);
            var10001 = var5++;
            var3[var10001] += var0 * var6 >> 6;
            var6 += var8;
            var10001 = var5++;
            var3[var10001] += var0 * var7 >> 6;
            var7 += var9;
        }

        if (var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14) / var14) > var11) {
            var10 = var11;
        }

        var10 <<= 1;

        for (var1 = var15; var5 < var10; var4 += var14) {
            var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
            var10001 = var5++;
            var3[var10001] += var0 * var6 >> 6;
            var6 += var8;
            var10001 = var5++;
            var3[var10001] += var0 * var7 >> 6;
            var7 += var9;
        }

        var5 >>= 1;
        var13.anInt574 += var13.anInt386 * var5;
        var13.anInt112 = var6;
        var13.anInt375 = var7;
        var13.anInt380 = var4;
        return var5;
    }

    static int method567(byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var10, int var11, Node_Sub6_Sub2 var12) {
        var3 >>= 8;
        var11 >>= 8;
        var5 <<= 2;
        var6 <<= 2;
        var7 <<= 2;
        var8 <<= 2;
        int var9;
        if ((var9 = var11 + var4 - var3) > var10) {
            var9 = var10;
        }

        var12.anInt574 += var12.anInt386 * (var9 - var4);
        var4 <<= 1;
        var9 <<= 1;

        byte var13;
        int var10001;
        for (var9 -= 6; var4 < var9; var6 += var8) {
            var13 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
            var6 += var8;
            var13 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
            var6 += var8;
            var13 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
            var6 += var8;
            var13 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
        }

        for (var9 += 6; var4 < var9; var6 += var8) {
            var13 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
        }

        var12.anInt112 = var5 >> 2;
        var12.anInt375 = var6 >> 2;
        var12.anInt380 = var3 << 8;
        return var4 >> 1;
    }

    static int method574(byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var10, int var11, Node_Sub6_Sub2 var12) {
        var3 >>= 8;
        var11 >>= 8;
        var5 <<= 2;
        var6 <<= 2;
        var7 <<= 2;
        var8 <<= 2;
        int var9;
        if ((var9 = var3 + var4 - (var11 - 1)) > var10) {
            var9 = var10;
        }

        var12.anInt574 += var12.anInt386 * (var9 - var4);
        var4 <<= 1;
        var9 <<= 1;

        byte var13;
        int var10001;
        for (var9 -= 6; var4 < var9; var6 += var8) {
            var13 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
            var6 += var8;
            var13 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
            var6 += var8;
            var13 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
            var6 += var8;
            var13 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
        }

        for (var9 += 6; var4 < var9; var6 += var8) {
            var13 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
        }

        var12.anInt112 = var5 >> 2;
        var12.anInt375 = var6 >> 2;
        var12.anInt380 = var3 << 8;
        return var4 >> 1;
    }

    public static Node_Sub6_Sub2 method597(Node_Sub10_Sub1 var0, int var1, int var2, int var3) {
        return var0.aByteArray503 != null && var0.aByteArray503.length != 0 ? new Node_Sub6_Sub2(var0, var1, var2, var3) : null;
    }

    public static Node_Sub6_Sub2 method598(Node_Sub10_Sub1 var0, int var1, int var2) {
        return var0.aByteArray503 != null && var0.aByteArray503.length != 0 ? new Node_Sub6_Sub2(var0, (int) ((long) var0.anInt380 * 256L * (long) var1 / (long) (Class105.anInt775 * 100)), var2 << 6) : null;
    }

    public synchronized int method599() {
        return this.anInt377 < 0 ? -1 : this.anInt377;
    }

    synchronized void method591() {
        this.method575(0, this.method599());
    }

    synchronized void method575(int var1, int var2) {
        this.anInt378 = var1;
        this.anInt377 = var2;
        this.anInt367 = 0;
        this.method592();
    }

    public synchronized void method576(int var1, int var2, int var3) {
        if (var1 == 0) {
            this.method575(var2, var3);
        } else {
            int var4 = method601(var2, var3);
            int var5 = method590(var2, var3);
            if (var4 == this.anInt112 && var5 == this.anInt375) {
                this.anInt367 = 0;
            } else {
                int var6 = var2 - this.anInt574;
                if (this.anInt574 - var2 > var6) {
                    var6 = this.anInt574 - var2;
                }

                if (var4 - this.anInt112 > var6) {
                    var6 = var4 - this.anInt112;
                }

                if (this.anInt112 - var4 > var6) {
                    var6 = this.anInt112 - var4;
                }

                if (var5 - this.anInt375 > var6) {
                    var6 = var5 - this.anInt375;
                }

                if (this.anInt375 - var5 > var6) {
                    var6 = this.anInt375 - var5;
                }

                if (var1 > var6) {
                    var1 = var6;
                }

                this.anInt367 = var1;
                this.anInt378 = var2;
                this.anInt377 = var3;
                this.anInt386 = (var2 - this.anInt574) / var1;
                this.anInt366 = (var4 - this.anInt112) / var1;
                this.anInt696 = (var5 - this.anInt375) / var1;
            }
        }
    }

    public synchronized void method311(int[] var1, int var2, int var3) {
        if (this.anInt378 == 0 && this.anInt367 == 0) {
            this.method303(var3);
        } else {
            Node_Sub10_Sub1 var4 = (Node_Sub10_Sub1) this.aNode_Sub10_667;
            int var5 = this.anInt379 << 8;
            int var6 = this.anInt564 << 8;
            int var7 = var4.aByteArray503.length << 8;
            int var8 = var6 - var5;
            if (var8 <= 0) {
                this.anInt372 = 0;
            }

            int var9 = var2;
            var3 += var2;
            if (this.anInt380 < 0) {
                if (this.anInt568 <= 0) {
                    this.method580();
                    this.unlink();
                    return;
                }

                this.anInt380 = 0;
            }

            if (this.anInt380 >= var7) {
                if (this.anInt568 >= 0) {
                    this.method580();
                    this.unlink();
                    return;
                }

                this.anInt380 = var7 - 1;
            }

            if (this.anInt372 < 0) {
                if (this.aBoolean763) {
                    if (this.anInt568 < 0) {
                        var9 = this.method581(var1, var2, var5, var3, var4.aByteArray503[this.anInt379]);
                        if (this.anInt380 >= var5) {
                            return;
                        }

                        this.anInt380 = var5 + var5 - 1 - this.anInt380;
                        this.anInt568 = -this.anInt568;
                    }

                    while (true) {
                        var9 = this.method596(var1, var9, var6, var3, var4.aByteArray503[this.anInt564 - 1]);
                        if (this.anInt380 < var6) {
                            return;
                        }

                        this.anInt380 = var6 + var6 - 1 - this.anInt380;
                        this.anInt568 = -this.anInt568;
                        var9 = this.method581(var1, var9, var5, var3, var4.aByteArray503[this.anInt379]);
                        if (this.anInt380 >= var5) {
                            return;
                        }

                        this.anInt380 = var5 + var5 - 1 - this.anInt380;
                        this.anInt568 = -this.anInt568;
                    }
                }
                if (this.anInt568 < 0) {
                    while (true) {
                        var9 = this.method581(var1, var9, var5, var3, var4.aByteArray503[this.anInt564 - 1]);
                        if (this.anInt380 >= var5) {
                            return;
                        }

                        this.anInt380 = var6 - 1 - (var6 - 1 - this.anInt380) % var8;
                    }
                }
                while (true) {
                    var9 = this.method596(var1, var9, var6, var3, var4.aByteArray503[this.anInt379]);
                    if (this.anInt380 < var6) {
                        return;
                    }

                    this.anInt380 = var5 + (this.anInt380 - var5) % var8;
                }
            }
            if (this.anInt372 > 0) {
                if (this.aBoolean763) {
                    label129:
                    {
                        if (this.anInt568 < 0) {
                            var9 = this.method581(var1, var2, var5, var3, var4.aByteArray503[this.anInt379]);
                            if (this.anInt380 >= var5) {
                                return;
                            }

                            this.anInt380 = var5 + var5 - 1 - this.anInt380;
                            this.anInt568 = -this.anInt568;
                            if (--this.anInt372 == 0) {
                                break label129;
                            }
                        }

                        do {
                            var9 = this.method596(var1, var9, var6, var3, var4.aByteArray503[this.anInt564 - 1]);
                            if (this.anInt380 < var6) {
                                return;
                            }

                            this.anInt380 = var6 + var6 - 1 - this.anInt380;
                            this.anInt568 = -this.anInt568;
                            if (--this.anInt372 == 0) {
                                break;
                            }

                            var9 = this.method581(var1, var9, var5, var3, var4.aByteArray503[this.anInt379]);
                            if (this.anInt380 >= var5) {
                                return;
                            }

                            this.anInt380 = var5 + var5 - 1 - this.anInt380;
                            this.anInt568 = -this.anInt568;
                        } while (--this.anInt372 != 0);
                    }
                } else {
                    int var10;
                    if (this.anInt568 < 0) {
                        while (true) {
                            var9 = this.method581(var1, var9, var5, var3, var4.aByteArray503[this.anInt564 - 1]);
                            if (this.anInt380 >= var5) {
                                return;
                            }

                            var10 = (var6 - 1 - this.anInt380) / var8;
                            if (var10 >= this.anInt372) {
                                this.anInt380 += var8 * this.anInt372;
                                this.anInt372 = 0;
                                break;
                            }

                            this.anInt380 += var8 * var10;
                            this.anInt372 -= var10;
                        }
                    } else {
                        while (true) {
                            var9 = this.method596(var1, var9, var6, var3, var4.aByteArray503[this.anInt379]);
                            if (this.anInt380 < var6) {
                                return;
                            }

                            var10 = (this.anInt380 - var5) / var8;
                            if (var10 >= this.anInt372) {
                                this.anInt380 -= var8 * this.anInt372;
                                this.anInt372 = 0;
                                break;
                            }

                            this.anInt380 -= var8 * var10;
                            this.anInt372 -= var10;
                        }
                    }
                }
            }

            if (this.anInt568 < 0) {
                this.method581(var1, var9, 0, var3, 0);
                if (this.anInt380 < 0) {
                    this.anInt380 = -1;
                    this.method580();
                    this.unlink();
                }
            } else {
                this.method596(var1, var9, var7, var3, 0);
                if (this.anInt380 >= var7) {
                    this.anInt380 = var7;
                    this.method580();
                    this.unlink();
                }
            }

        }
    }

    public synchronized void method303(int var1) {
        if (this.anInt367 > 0) {
            if (var1 >= this.anInt367) {
                if (this.anInt378 == Integer.MIN_VALUE) {
                    this.anInt378 = 0;
                    this.anInt375 = 0;
                    this.anInt112 = 0;
                    this.anInt574 = 0;
                    this.unlink();
                    var1 = this.anInt367;
                }

                this.anInt367 = 0;
                this.method592();
            } else {
                this.anInt574 += this.anInt386 * var1;
                this.anInt112 += this.anInt366 * var1;
                this.anInt375 += this.anInt696 * var1;
                this.anInt367 -= var1;
            }
        }

        Node_Sub10_Sub1 var2 = (Node_Sub10_Sub1) this.aNode_Sub10_667;
        int var3 = this.anInt379 << 8;
        int var4 = this.anInt564 << 8;
        int var5 = var2.aByteArray503.length << 8;
        int var6 = var4 - var3;
        if (var6 <= 0) {
            this.anInt372 = 0;
        }

        if (this.anInt380 < 0) {
            if (this.anInt568 <= 0) {
                this.method580();
                this.unlink();
                return;
            }

            this.anInt380 = 0;
        }

        if (this.anInt380 >= var5) {
            if (this.anInt568 >= 0) {
                this.method580();
                this.unlink();
                return;
            }

            this.anInt380 = var5 - 1;
        }

        this.anInt380 += this.anInt568 * var1;
        if (this.anInt372 < 0) {
            if (!this.aBoolean763) {
                if (this.anInt568 < 0) {
                    if (this.anInt380 >= var3) {
                        return;
                    }

                    this.anInt380 = var4 - 1 - (var4 - 1 - this.anInt380) % var6;
                } else {
                    if (this.anInt380 < var4) {
                        return;
                    }

                    this.anInt380 = var3 + (this.anInt380 - var3) % var6;
                }

            } else {
                if (this.anInt568 < 0) {
                    if (this.anInt380 >= var3) {
                        return;
                    }

                    this.anInt380 = var3 + var3 - 1 - this.anInt380;
                    this.anInt568 = -this.anInt568;
                }

                while (this.anInt380 >= var4) {
                    this.anInt380 = var4 + var4 - 1 - this.anInt380;
                    this.anInt568 = -this.anInt568;
                    if (this.anInt380 >= var3) {
                        return;
                    }

                    this.anInt380 = var3 + var3 - 1 - this.anInt380;
                    this.anInt568 = -this.anInt568;
                }

            }
        } else {
            if (this.anInt372 > 0) {
                if (this.aBoolean763) {
                    label126:
                    {
                        if (this.anInt568 < 0) {
                            if (this.anInt380 >= var3) {
                                return;
                            }

                            this.anInt380 = var3 + var3 - 1 - this.anInt380;
                            this.anInt568 = -this.anInt568;
                            if (--this.anInt372 == 0) {
                                break label126;
                            }
                        }

                        do {
                            if (this.anInt380 < var4) {
                                return;
                            }

                            this.anInt380 = var4 + var4 - 1 - this.anInt380;
                            this.anInt568 = -this.anInt568;
                            if (--this.anInt372 == 0) {
                                break;
                            }

                            if (this.anInt380 >= var3) {
                                return;
                            }

                            this.anInt380 = var3 + var3 - 1 - this.anInt380;
                            this.anInt568 = -this.anInt568;
                        } while (--this.anInt372 != 0);
                    }
                } else {
                    int var7;
                    if (this.anInt568 < 0) {
                        if (this.anInt380 >= var3) {
                            return;
                        }

                        var7 = (var4 - 1 - this.anInt380) / var6;
                        if (var7 < this.anInt372) {
                            this.anInt380 += var6 * var7;
                            this.anInt372 -= var7;
                            return;
                        }

                        this.anInt380 += var6 * this.anInt372;
                        this.anInt372 = 0;
                    } else {
                        if (this.anInt380 < var4) {
                            return;
                        }

                        var7 = (this.anInt380 - var3) / var6;
                        if (var7 < this.anInt372) {
                            this.anInt380 -= var6 * var7;
                            this.anInt372 -= var7;
                            return;
                        }

                        this.anInt380 -= var6 * this.anInt372;
                        this.anInt372 = 0;
                    }
                }
            }

            if (this.anInt568 < 0) {
                if (this.anInt380 < 0) {
                    this.anInt380 = -1;
                    this.method580();
                    this.unlink();
                }
            } else if (this.anInt380 >= var5) {
                this.anInt380 = var5;
                this.method580();
                this.unlink();
            }

        }
    }

    void method592() {
        this.anInt574 = this.anInt378;
        this.anInt112 = method601(this.anInt378, this.anInt377);
        this.anInt375 = method590(this.anInt378, this.anInt377);
    }

    public synchronized void method582(int var1) {
        int var2 = ((Node_Sub10_Sub1) this.aNode_Sub10_667).aByteArray503.length << 8;
        if (var1 < -1) {
            var1 = -1;
        }

        if (var1 > var2) {
            var1 = var2;
        }

        this.anInt380 = var1;
    }

    protected Node_Sub6 method308() {
        return null;
    }

    public boolean method586() {
        return this.anInt380 < 0 || this.anInt380 >= ((Node_Sub10_Sub1) this.aNode_Sub10_667).aByteArray503.length << 8;
    }

    public synchronized void method588(int var1) {
        if (this.anInt568 < 0) {
            this.anInt568 = -var1;
        } else {
            this.anInt568 = var1;
        }

    }

    public synchronized void method589(int var1) {
        if (var1 == 0) {
            this.method591();
            this.unlink();
        } else if (this.anInt112 == 0 && this.anInt375 == 0) {
            this.anInt367 = 0;
            this.anInt378 = 0;
            this.anInt574 = 0;
            this.unlink();
        } else {
            int var2 = -this.anInt574;
            if (this.anInt574 > var2) {
                var2 = this.anInt574;
            }

            if (-this.anInt112 > var2) {
                var2 = -this.anInt112;
            }

            if (this.anInt112 > var2) {
                var2 = this.anInt112;
            }

            if (-this.anInt375 > var2) {
                var2 = -this.anInt375;
            }

            if (this.anInt375 > var2) {
                var2 = this.anInt375;
            }

            if (var1 > var2) {
                var1 = var2;
            }

            this.anInt367 = var1;
            this.anInt378 = Integer.MIN_VALUE;
            this.anInt386 = -this.anInt574 / var1;
            this.anInt366 = -this.anInt112 / var1;
            this.anInt696 = -this.anInt375 / var1;
        }
    }

    void method580() {
        if (this.anInt367 != 0) {
            if (this.anInt378 == Integer.MIN_VALUE) {
                this.anInt378 = 0;
            }

            this.anInt367 = 0;
            this.method592();
        }

    }

    public boolean method577() {
        return this.anInt367 != 0;
    }

    public synchronized void method593() {
        this.anInt568 = (this.anInt568 ^ this.anInt568 >> 31) + (this.anInt568 >>> 31);
        this.anInt568 = -this.anInt568;
    }

    protected Node_Sub6 method307() {
        return null;
    }

    int method483() {
        int var1 = this.anInt574 * 3 >> 6;
        var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
        if (this.anInt372 == 0) {
            var1 -= var1 * this.anInt380 / (((Node_Sub10_Sub1) this.aNode_Sub10_667).aByteArray503.length << 8);
        } else if (this.anInt372 >= 0) {
            var1 -= var1 * this.anInt379 / ((Node_Sub10_Sub1) this.aNode_Sub10_667).aByteArray503.length;
        }

        return var1 > 255 ? 255 : var1;
    }

    int method581(int[] var1, int var2, int var3, int var4, int var5) {
        while (true) {
            if (this.anInt367 > 0) {
                int var6 = var2 + this.anInt367;
                if (var6 > var4) {
                    var6 = var4;
                }

                this.anInt367 += var2;
                if (this.anInt568 == -256 && (this.anInt380 & 255) == 0) {
                    if (AudioSystem.aBoolean1841) {
                        var2 = method574(((Node_Sub10_Sub1) this.aNode_Sub10_667).aByteArray503, var1, this.anInt380, var2, this.anInt112, this.anInt375, this.anInt366, this.anInt696, var6, var3, this);
                    } else {
                        var2 = method571(((Node_Sub10_Sub1) this.aNode_Sub10_667).aByteArray503, var1, this.anInt380, var2, this.anInt574, this.anInt386, var6, var3, this);
                    }
                } else if (AudioSystem.aBoolean1841) {
                    var2 = method570(((Node_Sub10_Sub1) this.aNode_Sub10_667).aByteArray503, var1, this.anInt380, var2, this.anInt112, this.anInt375, this.anInt366, this.anInt696, var6, var3, this, this.anInt568, var5);
                } else {
                    var2 = method602(((Node_Sub10_Sub1) this.aNode_Sub10_667).aByteArray503, var1, this.anInt380, var2, this.anInt574, this.anInt386, var6, var3, this, this.anInt568, var5);
                }

                this.anInt367 -= var2;
                if (this.anInt367 != 0) {
                    return var2;
                }

                if (!this.method584()) {
                    continue;
                }

                return var4;
            }

            if (this.anInt568 == -256 && (this.anInt380 & 255) == 0) {
                if (AudioSystem.aBoolean1841) {
                    return method594(((Node_Sub10_Sub1) this.aNode_Sub10_667).aByteArray503, var1, this.anInt380, var2, this.anInt112, this.anInt375, var4, var3, this);
                }

                return method579(((Node_Sub10_Sub1) this.aNode_Sub10_667).aByteArray503, var1, this.anInt380, var2, this.anInt574, var4, var3, this);
            }

            if (AudioSystem.aBoolean1841) {
                return method569(((Node_Sub10_Sub1) this.aNode_Sub10_667).aByteArray503, var1, this.anInt380, var2, this.anInt112, this.anInt375, var4, var3, this, this.anInt568, var5);
            }

            return method565(((Node_Sub10_Sub1) this.aNode_Sub10_667).aByteArray503, var1, this.anInt380, var2, this.anInt574, var4, var3, this, this.anInt568, var5);
        }
    }

    public synchronized int method583() {
        return this.anInt568 < 0 ? -this.anInt568 : this.anInt568;
    }

    boolean method584() {
        int var1 = this.anInt378;
        int var2;
        int var3;
        if (var1 == Integer.MIN_VALUE) {
            var2 = 0;
            var3 = 0;
            var1 = 0;
        } else {
            var3 = method601(var1, this.anInt377);
            var2 = method590(var1, this.anInt377);
        }

        if (var1 == this.anInt574 && var3 == this.anInt112 && var2 == this.anInt375) {
            if (this.anInt378 == Integer.MIN_VALUE) {
                this.anInt378 = 0;
                this.anInt375 = 0;
                this.anInt112 = 0;
                this.anInt574 = 0;
                this.unlink();
                return true;
            }
            this.method592();
            return false;
        }
        if (this.anInt574 < var1) {
            this.anInt386 = 1;
            this.anInt367 = var1 - this.anInt574;
        } else if (this.anInt574 > var1) {
            this.anInt386 = -1;
            this.anInt367 = this.anInt574 - var1;
        } else {
            this.anInt386 = 0;
        }

        if (this.anInt112 < var3) {
            this.anInt366 = 1;
            if (this.anInt367 == 0 || this.anInt367 > var3 - this.anInt112) {
                this.anInt367 = var3 - this.anInt112;
            }
        } else if (this.anInt112 > var3) {
            this.anInt366 = -1;
            if (this.anInt367 == 0 || this.anInt367 > this.anInt112 - var3) {
                this.anInt367 = this.anInt112 - var3;
            }
        } else {
            this.anInt366 = 0;
        }

        if (this.anInt375 < var2) {
            this.anInt696 = 1;
            if (this.anInt367 == 0 || this.anInt367 > var2 - this.anInt375) {
                this.anInt367 = var2 - this.anInt375;
            }
        } else if (this.anInt375 > var2) {
            this.anInt696 = -1;
            if (this.anInt367 == 0 || this.anInt367 > this.anInt375 - var2) {
                this.anInt367 = this.anInt375 - var2;
            }
        } else {
            this.anInt696 = 0;
        }

        return false;
    }

    int method596(int[] var1, int var2, int var3, int var4, int var5) {
        while (true) {
            if (this.anInt367 > 0) {
                int var6 = var2 + this.anInt367;
                if (var6 > var4) {
                    var6 = var4;
                }

                this.anInt367 += var2;
                if (this.anInt568 == 256 && (this.anInt380 & 255) == 0) {
                    if (AudioSystem.aBoolean1841) {
                        var2 = method567(((Node_Sub10_Sub1) this.aNode_Sub10_667).aByteArray503, var1, this.anInt380, var2, this.anInt112, this.anInt375, this.anInt366, this.anInt696, var6, var3, this);
                    } else {
                        var2 = method572(((Node_Sub10_Sub1) this.aNode_Sub10_667).aByteArray503, var1, this.anInt380, var2, this.anInt574, this.anInt386, var6, var3, this);
                    }
                } else if (AudioSystem.aBoolean1841) {
                    var2 = method568(((Node_Sub10_Sub1) this.aNode_Sub10_667).aByteArray503, var1, this.anInt380, var2, this.anInt112, this.anInt375, this.anInt366, this.anInt696, var6, var3, this, this.anInt568, var5);
                } else {
                    var2 = method564(((Node_Sub10_Sub1) this.aNode_Sub10_667).aByteArray503, var1, this.anInt380, var2, this.anInt574, this.anInt386, var6, var3, this, this.anInt568, var5);
                }

                this.anInt367 -= var2;
                if (this.anInt367 != 0) {
                    return var2;
                }

                if (!this.method584()) {
                    continue;
                }

                return var4;
            }

            if (this.anInt568 == 256 && (this.anInt380 & 255) == 0) {
                if (AudioSystem.aBoolean1841) {
                    return method595(((Node_Sub10_Sub1) this.aNode_Sub10_667).aByteArray503, var1, this.anInt380, var2, this.anInt112, this.anInt375, var4, var3, this);
                }

                return method600(((Node_Sub10_Sub1) this.aNode_Sub10_667).aByteArray503, var1, this.anInt380, var2, this.anInt574, var4, var3, this);
            }

            if (AudioSystem.aBoolean1841) {
                return method566(((Node_Sub10_Sub1) this.aNode_Sub10_667).aByteArray503, var1, this.anInt380, var2, this.anInt112, this.anInt375, var4, var3, this, this.anInt568, var5);
            }

            return method573(((Node_Sub10_Sub1) this.aNode_Sub10_667).aByteArray503, var1, this.anInt380, var2, this.anInt574, var4, var3, this, this.anInt568, var5);
        }
    }

    public synchronized int method578() {
        return this.anInt378 == Integer.MIN_VALUE ? 0 : this.anInt378;
    }

    public synchronized void method585(int var1) {
        this.anInt372 = var1;
    }

    protected int method305() {
        return this.anInt378 == 0 && this.anInt367 == 0 ? 0 : 1;
    }

    public synchronized void method587(int var1, int var2) {
        this.method576(var1, var2, this.method599());
    }

    public synchronized void method302(int var1) {
        this.method575(var1 << 6, this.method599());
    }
}
