package jag.audi.vorbis;

import jag.worldmap.WorldMapGroundDecorType2;

public class Vorbis1 {
    final int anInt644;
    final int[] anIntArray642;
    final int anInt643;
    float[][] aFloatArrayArray640;
    int[] anIntArray639;
    int[] anIntArray641;

    Vorbis1() {
        Vorbis9.method396(24);
        anInt643 = Vorbis9.method396(16);
        anInt644 = Vorbis9.method396(24);
        anIntArray642 = new int[anInt644];
        boolean var1 = Vorbis9.method397() != 0;

        if (var1) {
            int var2 = 0;
            for (int var3 = Vorbis9.method396(5) + 1; var2 < anInt644; ++var3) {
                int var4 = Vorbis9.method396(method726(anInt644 - var2));
                for (int var5 = 0; var5 < var4; ++var5) {
                    anIntArray642[var2++] = var3;
                }
            }

        } else {
            boolean var14 = Vorbis9.method397() != 0;

            for (int var3 = 0; var3 < anInt644; ++var3) {
                if (var14 && Vorbis9.method397() == 0) {
                    anIntArray642[var3] = 0;
                } else {
                    anIntArray642[var3] = Vorbis9.method396(5) + 1;
                }
            }
        }

        method463();

        int var2 = Vorbis9.method396(4);
        if (var2 > 0) {
            float var15 = Vorbis9.method400(Vorbis9.method396(32));
            float var16 = Vorbis9.method400(Vorbis9.method396(32));
            int var5 = Vorbis9.method396(4) + 1;
            boolean var6 = Vorbis9.method397() != 0;
            int var7;
            if (var2 == 1) {
                var7 = method462(anInt644, anInt643);
            } else {
                var7 = anInt644 * anInt643;
            }

            anIntArray641 = new int[var7];

            int var8;
            for (var8 = 0; var8 < var7; ++var8) {
                anIntArray641[var8] = Vorbis9.method396(var5);
            }

            aFloatArrayArray640 = new float[anInt644][anInt643];
            float var9;
            int var10;
            int var11;
            if (var2 == 1) {
                for (var8 = 0; var8 < anInt644; ++var8) {
                    var9 = 0.0F;
                    var10 = 1;

                    for (var11 = 0; var11 < anInt643; ++var11) {
                        int var12 = var8 / var10 % var7;
                        float var13 = (float) anIntArray641[var12] * var16 + var15 + var9;
                        aFloatArrayArray640[var8][var11] = var13;
                        if (var6) {
                            var9 = var13;
                        }

                        var10 *= var7;
                    }
                }
            } else {
                for (var8 = 0; var8 < anInt644; ++var8) {
                    var9 = 0.0F;
                    var10 = var8 * anInt643;

                    for (var11 = 0; var11 < anInt643; ++var11) {
                        float var17 = (float) anIntArray641[var10] * var16 + var15 + var9;
                        aFloatArrayArray640[var8][var11] = var17;
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
        int var2 = (int) Math.pow(var0, 1.0D / (double) var1) + 1;
        while (WorldMapGroundDecorType2.method183(var2, var1) > var0) {
            --var2;
        }
        return var2;
    }

    public static int method726(int var0) {
        int var1 = 0;
        if (var0 < 0 || var0 >= 65536) {
            var0 >>>= 16;
            var1 += 16;
        }

        if (var0 >= 256) {
            var0 >>>= 8;
            var1 += 8;
        }

        if (var0 >= 16) {
            var0 >>>= 4;
            var1 += 4;
        }

        if (var0 >= 4) {
            var0 >>>= 2;
            var1 += 2;
        }

        if (var0 >= 1) {
            var0 >>>= 1;
            ++var1;
        }

        return var0 + var1;
    }

    int method461() {
        int var1 = 0;
        while (anIntArray639[var1] >= 0) {
            var1 = Vorbis9.method397() != 0 ? anIntArray639[var1] : var1 + 1;
        }

        return ~anIntArray639[var1];
    }

    float[] method460() {
        return aFloatArrayArray640[method461()];
    }

    void method463() {
        int[] var1 = new int[anInt644];
        int[] var2 = new int[33];

        int var3;
        int var4;
        int var6;
        int var7;
        int var8;
        int var9;
        int var11;
        for (var3 = 0; var3 < anInt644; ++var3) {
            var4 = anIntArray642[var3];
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

        anIntArray639 = new int[8];
        int var5 = 0;

        for (var3 = 0; var3 < anInt644; ++var3) {
            var4 = anIntArray642[var3];
            if (var4 != 0) {
                var6 = var1[var3];
                var7 = 0;

                for (var8 = 0; var8 < var4; ++var8) {
                    var9 = Integer.MIN_VALUE >>> var8;
                    if ((var6 & var9) != 0) {
                        if (anIntArray639[var7] == 0) {
                            anIntArray639[var7] = var5;
                        }

                        var7 = anIntArray639[var7];
                    } else {
                        ++var7;
                    }

                    if (var7 >= anIntArray639.length) {
                        int[] var10 = new int[anIntArray639.length * 2];

                        for (var11 = 0; var11 < anIntArray639.length; ++var11) {
                            var10[var11] = anIntArray639[var11];
                        }

                        anIntArray639 = var10;
                    }

                }

                anIntArray639[var7] = ~var3;
                if (var7 >= var5) {
                    var5 = var7 + 1;
                }
            }
        }

    }
}
