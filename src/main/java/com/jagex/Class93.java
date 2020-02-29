package com.jagex;

public class Class93 {
    int anInt680;
    int anInt685;
    int anInt684;
    int anInt686;
    int anInt683;
    int[] anIntArray681;
    int anInt682;

    Class93() {
        this.anInt685 = Node_Sub5.method396(16);
        this.anInt686 = Node_Sub5.method396(24);
        this.anInt684 = Node_Sub5.method396(24);
        this.anInt683 = Node_Sub5.method396(24) + 1;
        this.anInt682 = Node_Sub5.method396(6) + 1;
        this.anInt680 = Node_Sub5.method396(8);
        int[] var1 = new int[this.anInt682];

        int var2;
        for (var2 = 0; var2 < this.anInt682; ++var2) {
            int var3 = 0;
            int var4 = Node_Sub5.method396(3);
            boolean var5 = Node_Sub5.method397() != 0;
            if (var5) {
                var3 = Node_Sub5.method396(5);
            }

            var1[var2] = var3 << 3 | var4;
        }

        this.anIntArray681 = new int[this.anInt682 * 8];

        for (var2 = 0; var2 < this.anInt682 * 8; ++var2) {
            this.anIntArray681[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0 ? Node_Sub5.method396(8) : -1;
        }

    }

    void method501(float[] var1, int var2, boolean var3) {
        int var4;
        for (var4 = 0; var4 < var2; ++var4) {
            var1[var4] = 0.0F;
        }

        if (!var3) {
            var4 = Node_Sub5.aClass86Array557[this.anInt680].anInt643;
            int var5 = this.anInt684 - this.anInt686;
            int var6 = var5 / this.anInt683;
            int[] var7 = new int[var6];

            for (int var8 = 0; var8 < 8; ++var8) {
                int var9 = 0;

                while (var9 < var6) {
                    int var10;
                    int var11;
                    if (var8 == 0) {
                        var10 = Node_Sub5.aClass86Array557[this.anInt680].method461();

                        for (var11 = var4 - 1; var11 >= 0; --var11) {
                            if (var9 + var11 < var6) {
                                var7[var9 + var11] = var10 % this.anInt682;
                            }

                            var10 /= this.anInt682;
                        }
                    }

                    for (var10 = 0; var10 < var4; ++var10) {
                        var11 = var7[var9];
                        int var12 = this.anIntArray681[var8 + var11 * 8];
                        if (var12 >= 0) {
                            int var13 = var9 * this.anInt683 + this.anInt686;
                            Class86 var14 = Node_Sub5.aClass86Array557[var12];
                            int var15;
                            if (this.anInt685 == 0) {
                                var15 = this.anInt683 / var14.anInt643;

                                for (int var16 = 0; var16 < var15; ++var16) {
                                    float[] var17 = var14.method460();

                                    for (int var18 = 0; var18 < var14.anInt643; ++var18) {
                                        var1[var13 + var16 + var18 * var15] += var17[var18];
                                    }
                                }
                            } else {
                                var15 = 0;

                                while (var15 < this.anInt683) {
                                    float[] var19 = var14.method460();

                                    for (int var20 = 0; var20 < var14.anInt643; ++var20) {
                                        var1[var13 + var15] += var19[var20];
                                        ++var15;
                                    }
                                }
                            }
                        }

                        ++var9;
                        if (var9 >= var6) {
                            break;
                        }
                    }
                }
            }

        }
    }
}
