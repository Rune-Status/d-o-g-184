package com.jagex;

public final class TileModel {
    static final int[][] anIntArrayArray1545;
    static final int[][] anIntArrayArray1536;
    static int[] anIntArray1549;
    static int[] anIntArray1546;
    static int[] anIntArray1537;
    static int[] anIntArray1550;
    static int[] anIntArray1538;

    static {
        anIntArray1549 = new int[6];
        anIntArray1546 = new int[6];
        anIntArray1537 = new int[6];
        anIntArray1550 = new int[6];
        anIntArray1538 = new int[6];
        anIntArrayArray1545 = new int[][]{{1, 3, 5, 7}, {1, 3, 5, 7}, {1, 3, 5, 7}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 2, 6}, {1, 3, 5, 7, 2, 8}, {1, 3, 5, 7, 2, 8}, {1, 3, 5, 7, 11, 12}, {1, 3, 5, 7, 11, 12}, {1, 3, 5, 7, 13, 14}};
        anIntArrayArray1536 = new int[][]{{0, 1, 2, 3, 0, 0, 1, 3}, {1, 1, 2, 3, 1, 0, 1, 3}, {0, 1, 2, 3, 1, 0, 1, 3}, {0, 0, 1, 2, 0, 0, 2, 4, 1, 0, 4, 3}, {0, 0, 1, 4, 0, 0, 4, 3, 1, 1, 2, 4}, {0, 0, 4, 3, 1, 0, 1, 2, 1, 0, 2, 4}, {0, 1, 2, 4, 1, 0, 1, 4, 1, 0, 4, 3}, {0, 4, 1, 2, 0, 4, 2, 5, 1, 0, 4, 5, 1, 0, 5, 3}, {0, 4, 1, 2, 0, 4, 2, 3, 0, 4, 3, 5, 1, 0, 4, 5}, {0, 0, 4, 5, 1, 4, 1, 2, 1, 4, 2, 3, 1, 4, 3, 5}, {0, 0, 1, 5, 0, 1, 4, 5, 0, 1, 2, 4, 1, 0, 5, 3, 1, 5, 4, 3, 1, 4, 2, 3}, {1, 0, 1, 5, 1, 1, 4, 5, 1, 1, 2, 4, 0, 0, 5, 3, 0, 5, 4, 3, 0, 4, 2, 3}, {1, 0, 5, 4, 1, 0, 1, 5, 0, 0, 4, 3, 0, 4, 5, 3, 0, 5, 2, 3, 0, 1, 2, 5}};
    }

    int[] anIntArray1552;
    boolean flatShade;
    int[] anIntArray1543;
    int shape;
    int[] anIntArray1541;
    int rotation;
    int[] anIntArray1540;
    int underlay;
    int[] anIntArray1551;
    int[] anIntArray1548;
    int overlay;
    int[] anIntArray1539;
    int[] anIntArray1547;
    int[] anIntArray1544;
    int[] anIntArray1542;

    TileModel(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19) {
        this.flatShade = var7 == var6 && var8 == var6 && var9 == var6;

        this.shape = var1;
        this.rotation = var2;
        this.underlay = var18;
        this.overlay = var19;
        short var20 = 128;
        int var21 = var20 / 2;
        int var22 = var20 / 4;
        int var23 = var20 * 3 / 4;
        int[] var24 = anIntArrayArray1545[var1];
        int var25 = var24.length;
        this.anIntArray1552 = new int[var25];
        this.anIntArray1541 = new int[var25];
        this.anIntArray1548 = new int[var25];
        int[] var26 = new int[var25];
        int[] var27 = new int[var25];
        int var28 = var20 * var4;
        int var29 = var5 * var20;

        int var31;
        int var32;
        int var33;
        int var34;
        int var35;
        int var36;
        for (int var30 = 0; var30 < var25; ++var30) {
            var31 = var24[var30];
            if ((var31 & 1) == 0 && var31 <= 8) {
                var31 = (var31 - var2 - var2 - 1 & 7) + 1;
            }

            if (var31 > 8 && var31 <= 12) {
                var31 = (var31 - 9 - var2 & 3) + 9;
            }

            if (var31 > 12 && var31 <= 16) {
                var31 = (var31 - 13 - var2 & 3) + 13;
            }

            if (var31 == 1) {
                var32 = var28;
                var33 = var29;
                var34 = var6;
                var35 = var10;
                var36 = var14;
            } else if (var31 == 2) {
                var32 = var28 + var21;
                var33 = var29;
                var34 = var7 + var6 >> 1;
                var35 = var11 + var10 >> 1;
                var36 = var15 + var14 >> 1;
            } else if (var31 == 3) {
                var32 = var28 + var20;
                var33 = var29;
                var34 = var7;
                var35 = var11;
                var36 = var15;
            } else if (var31 == 4) {
                var32 = var28 + var20;
                var33 = var29 + var21;
                var34 = var8 + var7 >> 1;
                var35 = var11 + var12 >> 1;
                var36 = var15 + var16 >> 1;
            } else if (var31 == 5) {
                var32 = var28 + var20;
                var33 = var29 + var20;
                var34 = var8;
                var35 = var12;
                var36 = var16;
            } else if (var31 == 6) {
                var32 = var28 + var21;
                var33 = var29 + var20;
                var34 = var8 + var9 >> 1;
                var35 = var13 + var12 >> 1;
                var36 = var17 + var16 >> 1;
            } else if (var31 == 7) {
                var32 = var28;
                var33 = var29 + var20;
                var34 = var9;
                var35 = var13;
                var36 = var17;
            } else if (var31 == 8) {
                var32 = var28;
                var33 = var29 + var21;
                var34 = var9 + var6 >> 1;
                var35 = var13 + var10 >> 1;
                var36 = var17 + var14 >> 1;
            } else if (var31 == 9) {
                var32 = var28 + var21;
                var33 = var29 + var22;
                var34 = var7 + var6 >> 1;
                var35 = var11 + var10 >> 1;
                var36 = var15 + var14 >> 1;
            } else if (var31 == 10) {
                var32 = var28 + var23;
                var33 = var29 + var21;
                var34 = var8 + var7 >> 1;
                var35 = var11 + var12 >> 1;
                var36 = var15 + var16 >> 1;
            } else if (var31 == 11) {
                var32 = var28 + var21;
                var33 = var29 + var23;
                var34 = var8 + var9 >> 1;
                var35 = var13 + var12 >> 1;
                var36 = var17 + var16 >> 1;
            } else if (var31 == 12) {
                var32 = var28 + var22;
                var33 = var29 + var21;
                var34 = var9 + var6 >> 1;
                var35 = var13 + var10 >> 1;
                var36 = var17 + var14 >> 1;
            } else if (var31 == 13) {
                var32 = var28 + var22;
                var33 = var29 + var22;
                var34 = var6;
                var35 = var10;
                var36 = var14;
            } else if (var31 == 14) {
                var32 = var28 + var23;
                var33 = var29 + var22;
                var34 = var7;
                var35 = var11;
                var36 = var15;
            } else if (var31 == 15) {
                var32 = var28 + var23;
                var33 = var29 + var23;
                var34 = var8;
                var35 = var12;
                var36 = var16;
            } else {
                var32 = var28 + var22;
                var33 = var29 + var23;
                var34 = var9;
                var35 = var13;
                var36 = var17;
            }

            this.anIntArray1552[var30] = var32;
            this.anIntArray1541[var30] = var34;
            this.anIntArray1548[var30] = var33;
            var26[var30] = var35;
            var27[var30] = var36;
        }

        int[] var37 = anIntArrayArray1536[var1];
        var31 = var37.length / 4;
        this.anIntArray1543 = new int[var31];
        this.anIntArray1540 = new int[var31];
        this.anIntArray1551 = new int[var31];
        this.anIntArray1547 = new int[var31];
        this.anIntArray1544 = new int[var31];
        this.anIntArray1542 = new int[var31];
        if (var3 != -1) {
            this.anIntArray1539 = new int[var31];
        }

        var32 = 0;

        for (var33 = 0; var33 < var31; ++var33) {
            var34 = var37[var32];
            var35 = var37[var32 + 1];
            var36 = var37[var32 + 2];
            int var38 = var37[var32 + 3];
            var32 += 4;
            if (var35 < 4) {
                var35 = var35 - var2 & 3;
            }

            if (var36 < 4) {
                var36 = var36 - var2 & 3;
            }

            if (var38 < 4) {
                var38 = var38 - var2 & 3;
            }

            this.anIntArray1543[var33] = var35;
            this.anIntArray1540[var33] = var36;
            this.anIntArray1551[var33] = var38;
            if (var34 == 0) {
                this.anIntArray1547[var33] = var26[var35];
                this.anIntArray1544[var33] = var26[var36];
                this.anIntArray1542[var33] = var26[var38];
                if (this.anIntArray1539 != null) {
                    this.anIntArray1539[var33] = -1;
                }
            } else {
                this.anIntArray1547[var33] = var27[var35];
                this.anIntArray1544[var33] = var27[var36];
                this.anIntArray1542[var33] = var27[var38];
                if (this.anIntArray1539 != null) {
                    this.anIntArray1539[var33] = var3;
                }
            }
        }

        var33 = var6;
        var34 = var7;
        if (var7 < var6) {
            var33 = var7;
        }

        if (var7 > var7) {
            var34 = var7;
        }

        if (var8 < var33) {
            var33 = var8;
        }

        if (var8 > var34) {
            var34 = var8;
        }

        if (var9 < var33) {
            var33 = var9;
        }

        if (var9 > var34) {
            var34 = var9;
        }

        var33 /= 14;
        var34 /= 14;
    }
}
