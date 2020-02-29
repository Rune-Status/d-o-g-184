package com.jagex;

public final class Bzip2Decompressor {

    static Bzip2Context context;

    static {
        context = new Bzip2Context();
    }

    public static int decompress(byte[] var0, int var1, byte[] var2, int var4) {
        synchronized (context) {
            context.aByteArray1601 = var2;
            context.anInt1593 = var4;
            context.aByteArray1589 = var0;
            context.anInt1582 = 0;
            context.anInt1581 = var1;
            context.anInt1605 = 0;
            context.anInt1610 = 0;
            context.anInt1613 = 0;
            context.anInt1598 = 0;
            method1177(context);
            var1 -= context.anInt1581;
            context.aByteArray1601 = null;
            context.aByteArray1589 = null;
            return var1;
        }
    }

    static void method1177(Bzip2Context var0) {
        boolean var1 = false;
        boolean var2 = false;
        boolean var3 = false;
        boolean var4 = false;
        boolean var5 = false;
        boolean var6 = false;
        boolean var7 = false;
        boolean var8 = false;
        boolean var9 = false;
        boolean var10 = false;
        boolean var11 = false;
        boolean var12 = false;
        boolean var13 = false;
        boolean var14 = false;
        boolean var15 = false;
        boolean var16 = false;
        boolean var17 = false;
        boolean var18 = false;
        int var19 = 0;
        int[] var20 = null;
        int[] var21 = null;
        int[] var22 = null;
        var0.anInt1587 = 1410065408;
        if (Class152_Sub1.anIntArray1138 == null) {
            Class152_Sub1.anIntArray1138 = new int[100000];
        }

        boolean var23 = true;

        while (true) {
            while (var23) {
                byte var24 = method1176(var0);
                if (var24 == 23) {
                    return;
                }

                var24 = method1176(var0);
                var24 = method1176(var0);
                var24 = method1176(var0);
                var24 = method1176(var0);
                var24 = method1176(var0);
                var24 = method1176(var0);
                var24 = method1176(var0);
                var24 = method1176(var0);
                var24 = method1176(var0);
                var24 = method1175(var0);
                if (var24 != 0) {
                }

                var0.anInt1611 = 0;
                var24 = method1176(var0);
                var0.anInt1611 = var0.anInt1611 << 8 | var24 & 255;
                var24 = method1176(var0);
                var0.anInt1611 = var0.anInt1611 << 8 | var24 & 255;
                var24 = method1176(var0);
                var0.anInt1611 = var0.anInt1611 << 8 | var24 & 255;

                int var36;
                for (var36 = 0; var36 < 16; ++var36) {
                    var24 = method1175(var0);
                    var0.aBooleanArray1612[var36] = var24 == 1;
                }

                for (var36 = 0; var36 < 256; ++var36) {
                    var0.aBooleanArray1580[var36] = false;
                }

                int var37;
                for (var36 = 0; var36 < 16; ++var36) {
                    if (var0.aBooleanArray1612[var36]) {
                        for (var37 = 0; var37 < 16; ++var37) {
                            var24 = method1175(var0);
                            if (var24 == 1) {
                                var0.aBooleanArray1580[var37 + var36 * 16] = true;
                            }
                        }
                    }
                }

                method1174(var0);
                int var39 = var0.anInt1592 + 2;
                int var40 = method1173(3, var0);
                int var41 = method1173(15, var0);

                for (var36 = 0; var36 < var41; ++var36) {
                    var37 = 0;

                    while (true) {
                        var24 = method1175(var0);
                        if (var24 == 0) {
                            var0.aByteArray1577[var36] = (byte) var37;
                            break;
                        }

                        ++var37;
                    }
                }

                byte[] var25 = new byte[6];

                byte var26;
                for (var26 = 0; var26 < var40; var25[var26] = var26++) {
                }

                for (var36 = 0; var36 < var41; ++var36) {
                    var26 = var0.aByteArray1577[var36];

                    byte var27;
                    for (var27 = var25[var26]; var26 > 0; --var26) {
                        var25[var26] = var25[var26 - 1];
                    }

                    var25[0] = var27;
                    var0.aByteArray1600[var36] = var27;
                }

                int var38;
                for (var38 = 0; var38 < var40; ++var38) {
                    int var50 = method1173(5, var0);

                    for (var36 = 0; var36 < var39; ++var36) {
                        while (true) {
                            var24 = method1175(var0);
                            if (var24 == 0) {
                                var0.aByteArrayArray1609[var38][var36] = (byte) var50;
                                break;
                            }

                            var24 = method1175(var0);
                            if (var24 == 0) {
                                ++var50;
                            } else {
                                --var50;
                            }
                        }
                    }
                }

                for (var38 = 0; var38 < var40; ++var38) {
                    byte var28 = 32;
                    byte var29 = 0;

                    for (var36 = 0; var36 < var39; ++var36) {
                        if (var0.aByteArrayArray1609[var38][var36] > var29) {
                            var29 = var0.aByteArrayArray1609[var38][var36];
                        }

                        if (var0.aByteArrayArray1609[var38][var36] < var28) {
                            var28 = var0.aByteArrayArray1609[var38][var36];
                        }
                    }

                    method1179(var0.anIntArrayArray1603[var38], var0.anIntArrayArray1596[var38], var0.anIntArrayArray1591[var38], var0.aByteArrayArray1609[var38], var28, var29, var39);
                    var0.anIntArray1583[var38] = var28;
                }

                int var42 = var0.anInt1592 + 1;
                int var43 = -1;
                byte var44 = 0;

                for (var36 = 0; var36 <= 255; ++var36) {
                    var0.anIntArray1586[var36] = 0;
                }

                int var55 = 4095;

                int var30;
                int var56;
                for (var30 = 15; var30 >= 0; --var30) {
                    for (var56 = 15; var56 >= 0; --var56) {
                        var0.aByteArray1576[var55] = (byte) (var56 + var30 * 16);
                        --var55;
                    }

                    var0.anIntArray1597[var30] = var55 + 1;
                }

                int var47 = 0;
                byte var54;
                if (var44 == 0) {
                    ++var43;
                    var44 = 50;
                    var54 = var0.aByteArray1600[var43];
                    var19 = var0.anIntArray1583[var54];
                    var20 = var0.anIntArrayArray1603[var54];
                    var22 = var0.anIntArrayArray1591[var54];
                    var21 = var0.anIntArrayArray1596[var54];
                }

                int var45 = var44 - 1;
                int var51 = var19;

                int var52;
                byte var53;
                for (var52 = method1173(var19, var0); var52 > var20[var51]; var52 = var52 << 1 | var53) {
                    ++var51;
                    var53 = method1175(var0);
                }

                int var46 = var22[var52 - var21[var51]];

                while (true) {
                    int[] var10000;
                    int var10002;
                    while (var46 != var42) {
                        if (var46 != 0 && var46 != 1) {
                            int var31 = var46 - 1;
                            int var32;
                            if (var31 < 16) {
                                var32 = var0.anIntArray1597[0];

                                for (var24 = var0.aByteArray1576[var32 + var31]; var31 > 3; var31 -= 4) {
                                    int var33 = var32 + var31;
                                    var0.aByteArray1576[var33] = var0.aByteArray1576[var33 - 1];
                                    var0.aByteArray1576[var33 - 1] = var0.aByteArray1576[var33 - 2];
                                    var0.aByteArray1576[var33 - 2] = var0.aByteArray1576[var33 - 3];
                                    var0.aByteArray1576[var33 - 3] = var0.aByteArray1576[var33 - 4];
                                }

                                while (var31 > 0) {
                                    var0.aByteArray1576[var32 + var31] = var0.aByteArray1576[var32 + var31 - 1];
                                    --var31;
                                }

                                var0.aByteArray1576[var32] = var24;
                            } else {
                                int var34 = var31 / 16;
                                int var35 = var31 % 16;
                                var32 = var0.anIntArray1597[var34] + var35;

                                for (var24 = var0.aByteArray1576[var32]; var32 > var0.anIntArray1597[var34]; --var32) {
                                    var0.aByteArray1576[var32] = var0.aByteArray1576[var32 - 1];
                                }

                                for (var10002 = var0.anIntArray1597[var34]++; var34 > 0; --var34) {
                                    var10002 = var0.anIntArray1597[var34]--;
                                    var0.aByteArray1576[var0.anIntArray1597[var34]] = var0.aByteArray1576[var0.anIntArray1597[var34 - 1] + 16 - 1];
                                }

                                var10002 = var0.anIntArray1597[0]--;
                                var0.aByteArray1576[var0.anIntArray1597[0]] = var24;
                                if (var0.anIntArray1597[0] == 0) {
                                    var55 = 4095;

                                    for (var30 = 15; var30 >= 0; --var30) {
                                        for (var56 = 15; var56 >= 0; --var56) {
                                            var0.aByteArray1576[var55] = var0.aByteArray1576[var0.anIntArray1597[var30] + var56];
                                            --var55;
                                        }

                                        var0.anIntArray1597[var30] = var55 + 1;
                                    }
                                }
                            }

                            var10002 = var0.anIntArray1586[var0.aByteArray1608[var24 & 255] & 255]++;
                            Class152_Sub1.anIntArray1138[var47] = var0.aByteArray1608[var24 & 255] & 255;
                            ++var47;
                            if (var45 == 0) {
                                ++var43;
                                var45 = 50;
                                var54 = var0.aByteArray1600[var43];
                                var19 = var0.anIntArray1583[var54];
                                var20 = var0.anIntArrayArray1603[var54];
                                var22 = var0.anIntArrayArray1591[var54];
                                var21 = var0.anIntArrayArray1596[var54];
                            }

                            --var45;
                            var51 = var19;

                            for (var52 = method1173(var19, var0); var52 > var20[var51]; var52 = var52 << 1 | var53) {
                                ++var51;
                                var53 = method1175(var0);
                            }

                            var46 = var22[var52 - var21[var51]];
                        } else {
                            int var48 = -1;
                            int var49 = 1;

                            do {
                                if (var46 == 0) {
                                    var48 += var49;
                                } else if (var46 == 1) {
                                    var48 += var49 * 2;
                                }

                                var49 *= 2;
                                if (var45 == 0) {
                                    ++var43;
                                    var45 = 50;
                                    var54 = var0.aByteArray1600[var43];
                                    var19 = var0.anIntArray1583[var54];
                                    var20 = var0.anIntArrayArray1603[var54];
                                    var22 = var0.anIntArrayArray1591[var54];
                                    var21 = var0.anIntArrayArray1596[var54];
                                }

                                --var45;
                                var51 = var19;

                                for (var52 = method1173(var19, var0); var52 > var20[var51]; var52 = var52 << 1 | var53) {
                                    ++var51;
                                    var53 = method1175(var0);
                                }

                                var46 = var22[var52 - var21[var51]];
                            } while (var46 == 0 || var46 == 1);

                            ++var48;
                            var24 = var0.aByteArray1608[var0.aByteArray1576[var0.anIntArray1597[0]] & 255];
                            var10000 = var0.anIntArray1586;

                            for (var10000[var24 & 255] += var48; var48 > 0; --var48) {
                                Class152_Sub1.anIntArray1138[var47] = var24 & 255;
                                ++var47;
                            }
                        }
                    }

                    var0.anInt1585 = 0;
                    var0.aByte1578 = 0;
                    var0.anIntArray1584[0] = 0;

                    for (var36 = 1; var36 <= 256; ++var36) {
                        var0.anIntArray1584[var36] = var0.anIntArray1586[var36 - 1];
                    }

                    for (var36 = 1; var36 <= 256; ++var36) {
                        var10000 = var0.anIntArray1584;
                        var10000[var36] += var0.anIntArray1584[var36 - 1];
                    }

                    for (var36 = 0; var36 < var47; ++var36) {
                        var24 = (byte) (Class152_Sub1.anIntArray1138[var36] & 255);
                        var10000 = Class152_Sub1.anIntArray1138;
                        int var10001 = var0.anIntArray1584[var24 & 255];
                        var10000[var10001] |= var36 << 8;
                        var10002 = var0.anIntArray1584[var24 & 255]++;
                    }

                    var0.anInt1588 = Class152_Sub1.anIntArray1138[var0.anInt1611] >> 8;
                    var0.anInt1590 = 0;
                    var0.anInt1588 = Class152_Sub1.anIntArray1138[var0.anInt1588];
                    var0.anInt1604 = (byte) (var0.anInt1588 & 255);
                    var0.anInt1588 >>= 8;
                    ++var0.anInt1590;
                    var0.anInt1594 = var47;
                    method1180(var0);
                    if (var0.anInt1594 + 1 == var0.anInt1590 && var0.anInt1585 == 0) {
                        var23 = true;
                        break;
                    }

                    var23 = false;
                    break;
                }
            }

            return;
        }
    }

    static byte method1176(Bzip2Context var0) {
        return (byte) method1173(8, var0);
    }

    static int method1173(int var0, Bzip2Context var1) {
        while (var1.anInt1605 < var0) {
            var1.anInt1610 = var1.anInt1610 << 8 | var1.aByteArray1601[var1.anInt1593] & 255;
            var1.anInt1605 += 8;
            ++var1.anInt1593;
            ++var1.anInt1613;
            if (var1.anInt1613 == 0) {
            }
        }

        int var2 = var1.anInt1610 >> var1.anInt1605 - var0 & (1 << var0) - 1;
        var1.anInt1605 -= var0;
        return var2;
    }

    static byte method1175(Bzip2Context var0) {
        return (byte) method1173(1, var0);
    }

    static void method1174(Bzip2Context var0) {
        var0.anInt1592 = 0;

        for (int var1 = 0; var1 < 256; ++var1) {
            if (var0.aBooleanArray1580[var1]) {
                var0.aByteArray1608[var0.anInt1592] = (byte) var1;
                ++var0.anInt1592;
            }
        }

    }

    static void method1179(int[] var0, int[] var1, int[] var2, byte[] var3, int var4, int var5, int var6) {
        int var7 = 0;

        int var8;
        for (var8 = var4; var8 <= var5; ++var8) {
            for (int var9 = 0; var9 < var6; ++var9) {
                if (var8 == var3[var9]) {
                    var2[var7] = var9;
                    ++var7;
                }
            }
        }

        for (var8 = 0; var8 < 23; ++var8) {
            var1[var8] = 0;
        }

        for (var8 = 0; var8 < var6; ++var8) {
            ++var1[var3[var8] + 1];
        }

        for (var8 = 1; var8 < 23; ++var8) {
            var1[var8] += var1[var8 - 1];
        }

        for (var8 = 0; var8 < 23; ++var8) {
            var0[var8] = 0;
        }

        int var10 = 0;

        for (var8 = var4; var8 <= var5; ++var8) {
            var10 += var1[var8 + 1] - var1[var8];
            var0[var8] = var10 - 1;
            var10 <<= 1;
        }

        for (var8 = var4 + 1; var8 <= var5; ++var8) {
            var1[var8] = (var0[var8 - 1] + 1 << 1) - var1[var8];
        }

    }

    static void method1180(Bzip2Context var0) {
        byte var1 = var0.aByte1578;
        int var2 = var0.anInt1585;
        int var3 = var0.anInt1590;
        int var4 = var0.anInt1604;
        int[] var5 = Class152_Sub1.anIntArray1138;
        int var6 = var0.anInt1588;
        byte[] var7 = var0.aByteArray1589;
        int var8 = var0.anInt1582;
        int var9 = var0.anInt1581;
        int var11 = var0.anInt1594 + 1;

        label61:
        while (true) {
            if (var2 > 0) {
                while (true) {
                    if (var9 == 0) {
                        break label61;
                    }

                    if (var2 == 1) {
                        if (var9 == 0) {
                            var2 = 1;
                            break label61;
                        }

                        var7[var8] = var1;
                        ++var8;
                        --var9;
                        break;
                    }

                    var7[var8] = var1;
                    --var2;
                    ++var8;
                    --var9;
                }
            }

            while (var3 != var11) {
                var1 = (byte) var4;
                var6 = var5[var6];
                byte var13 = (byte) var6;
                var6 >>= 8;
                ++var3;
                if (var13 != var4) {
                    var4 = var13;
                    if (var9 == 0) {
                        var2 = 1;
                        break label61;
                    }

                    var7[var8] = var1;
                    ++var8;
                    --var9;
                } else {
                    if (var3 != var11) {
                        var2 = 2;
                        var6 = var5[var6];
                        var13 = (byte) var6;
                        var6 >>= 8;
                        ++var3;
                        if (var3 != var11) {
                            if (var13 != var4) {
                                var4 = var13;
                            } else {
                                var2 = 3;
                                var6 = var5[var6];
                                var13 = (byte) var6;
                                var6 >>= 8;
                                ++var3;
                                if (var3 != var11) {
                                    if (var13 != var4) {
                                        var4 = var13;
                                    } else {
                                        var6 = var5[var6];
                                        var13 = (byte) var6;
                                        var6 >>= 8;
                                        ++var3;
                                        var2 = (var13 & 255) + 4;
                                        var6 = var5[var6];
                                        var4 = (byte) var6;
                                        var6 >>= 8;
                                        ++var3;
                                    }
                                }
                            }
                        }
                        continue label61;
                    }

                    if (var9 == 0) {
                        var2 = 1;
                        break label61;
                    }

                    var7[var8] = var1;
                    ++var8;
                    --var9;
                }
            }

            var2 = 0;
            break;
        }

        int var12 = var0.anInt1598;
        var0.anInt1598 += var9 - var9;
        if (var0.anInt1598 < var12) {
        }

        var0.aByte1578 = var1;
        var0.anInt1585 = var2;
        var0.anInt1590 = var3;
        var0.anInt1604 = var4;
        Class152_Sub1.anIntArray1138 = var5;
        var0.anInt1588 = var6;
        var0.aByteArray1589 = var7;
        var0.anInt1582 = var8;
        var0.anInt1581 = var9;
    }
}
