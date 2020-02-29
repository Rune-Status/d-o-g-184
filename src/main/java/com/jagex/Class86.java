package com.jagex;

public class Class86 {
    float[][] aFloatArrayArray640;
    int anInt644;
    int[] anIntArray639;
    int[] anIntArray642;
    int anInt643;
    int[] anIntArray641;

    Class86() {
        Node_Sub5.method396(24);
        this.anInt643 = Node_Sub5.method396(16);
        this.anInt644 = Node_Sub5.method396(24);
        this.anIntArray642 = new int[this.anInt644];
        boolean var1 = Node_Sub5.method397() != 0;
        int var2;
        int var3;
        int var5;
        if (var1) {
            var2 = 0;

            for (var3 = Node_Sub5.method396(5) + 1; var2 < this.anInt644; ++var3) {
                int var4 = Node_Sub5.method396(PickableNode.method726(this.anInt644 - var2));

                for (var5 = 0; var5 < var4; ++var5) {
                    this.anIntArray642[var2++] = var3;
                }
            }
        } else {
            boolean var14 = Node_Sub5.method397() != 0;

            for (var3 = 0; var3 < this.anInt644; ++var3) {
                if (var14 && Node_Sub5.method397() == 0) {
                    this.anIntArray642[var3] = 0;
                } else {
                    this.anIntArray642[var3] = Node_Sub5.method396(5) + 1;
                }
            }
        }

        this.method463();
        var2 = Node_Sub5.method396(4);
        if (var2 > 0) {
            float var15 = Node_Sub5.method400(Node_Sub5.method396(32));
            float var16 = Node_Sub5.method400(Node_Sub5.method396(32));
            var5 = Node_Sub5.method396(4) + 1;
            boolean var6 = Node_Sub5.method397() != 0;
            int var7;
            if (var2 == 1) {
                var7 = method462(this.anInt644, this.anInt643);
            } else {
                var7 = this.anInt644 * this.anInt643;
            }

            this.anIntArray641 = new int[var7];

            int var8;
            for (var8 = 0; var8 < var7; ++var8) {
                this.anIntArray641[var8] = Node_Sub5.method396(var5);
            }

            this.aFloatArrayArray640 = new float[this.anInt644][this.anInt643];
            float var9;
            int var10;
            int var11;
            if (var2 == 1) {
                for (var8 = 0; var8 < this.anInt644; ++var8) {
                    var9 = 0.0F;
                    var10 = 1;

                    for (var11 = 0; var11 < this.anInt643; ++var11) {
                        int var12 = var8 / var10 % var7;
                        float var13 = (float) this.anIntArray641[var12] * var16 + var15 + var9;
                        this.aFloatArrayArray640[var8][var11] = var13;
                        if (var6) {
                            var9 = var13;
                        }

                        var10 *= var7;
                    }
                }
            } else {
                for (var8 = 0; var8 < this.anInt644; ++var8) {
                    var9 = 0.0F;
                    var10 = var8 * this.anInt643;

                    for (var11 = 0; var11 < this.anInt643; ++var11) {
                        float var17 = (float) this.anIntArray641[var10] * var16 + var15 + var9;
                        this.aFloatArrayArray640[var8][var11] = var17;
                        if (var6) {
                            var9 = var17;
                        }

                        ++var10;
                    }
                }
            }
        }

    }

    static int method462(int var0, int var1) {
        int var2;
        for (var2 = (int) Math.pow((double) var0, 1.0D / (double) var1) + 1; Class24.method183(var2, var1) > var0; --var2) {
        }

        return var2;
    }

    int method461() {
        int var1;
        for (var1 = 0; this.anIntArray639[var1] >= 0; var1 = Node_Sub5.method397() != 0 ? this.anIntArray639[var1] : var1 + 1) {
        }

        return ~this.anIntArray639[var1];
    }

    float[] method460() {
        return this.aFloatArrayArray640[this.method461()];
    }

    void method463() {
        int[] var1 = new int[this.anInt644];
        int[] var2 = new int[33];

        int var3;
        int var4;
        int var6;
        int var7;
        int var8;
        int var9;
        int var11;
        for (var3 = 0; var3 < this.anInt644; ++var3) {
            var4 = this.anIntArray642[var3];
            if (var4 != 0) {
                var6 = 1 << 32 - var4;
                var7 = var2[var4];
                var1[var3] = var7;
                int var12;
                if ((var7 & var6) != 0) {
                    var8 = var2[var4 - 1];
                } else {
                    var8 = var7 | var6;

                    for (var9 = var4 - 1; var9 >= 1; --var9) {
                        var12 = var2[var9];
                        if (var12 != var7) {
                            break;
                        }

                        var11 = 1 << 32 - var9;
                        if ((var12 & var11) != 0) {
                            var2[var9] = var2[var9 - 1];
                            break;
                        }

                        var2[var9] = var12 | var11;
                    }
                }

                var2[var4] = var8;

                for (var9 = var4 + 1; var9 <= 32; ++var9) {
                    var12 = var2[var9];
                    if (var12 == var7) {
                        var2[var9] = var8;
                    }
                }
            }
        }

        this.anIntArray639 = new int[8];
        int var5 = 0;

        for (var3 = 0; var3 < this.anInt644; ++var3) {
            var4 = this.anIntArray642[var3];
            if (var4 != 0) {
                var6 = var1[var3];
                var7 = 0;

                for (var8 = 0; var8 < var4; ++var8) {
                    var9 = Integer.MIN_VALUE >>> var8;
                    if ((var6 & var9) != 0) {
                        if (this.anIntArray639[var7] == 0) {
                            this.anIntArray639[var7] = var5;
                        }

                        var7 = this.anIntArray639[var7];
                    } else {
                        ++var7;
                    }

                    if (var7 >= this.anIntArray639.length) {
                        int[] var10 = new int[this.anIntArray639.length * 2];

                        for (var11 = 0; var11 < this.anIntArray639.length; ++var11) {
                            var10[var11] = this.anIntArray639[var11];
                        }

                        this.anIntArray639 = var10;
                    }

                    var9 >>>= 1;
                }

                this.anIntArray639[var7] = ~var3;
                if (var7 >= var5) {
                    var5 = var7 + 1;
                }
            }
        }

    }
}
