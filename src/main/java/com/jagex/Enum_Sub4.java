package com.jagex;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Enum_Sub4 implements EnumType {
    anEnum_Sub4_1177(0, new Class144[]{Class144.aClass144_1144}),
    anEnum_Sub4_1169(1, new Class144[]{Class144.aClass144_1146, Class144.aClass144_1144}),
    anEnum_Sub4_1175(2, new Class144[]{Class144.aClass144_1146, Class144.aClass144_1145, Class144.aClass144_1144}),
    anEnum_Sub4_1174(3, new Class144[]{Class144.aClass144_1146}),
    anEnum_Sub4_1173(),
    anEnum_Sub4_1171(5, new Class144[]{Class144.aClass144_1146, Class144.aClass144_1144}),
    anEnum_Sub4_1172(6, new Class144[]{Class144.aClass144_1144}),
    anEnum_Sub4_1168(8, new Class144[]{Class144.aClass144_1146, Class144.aClass144_1144}),
    anEnum_Sub4_1176(9, new Class144[]{Class144.aClass144_1146, Class144.aClass144_1145}),
    anEnum_Sub4_1167(10, new Class144[]{Class144.aClass144_1146}),
    anEnum_Sub4_1165(11, new Class144[]{Class144.aClass144_1146}),
    anEnum_Sub4_1164(12, new Class144[]{Class144.aClass144_1146, Class144.aClass144_1144}),
    anEnum_Sub4_1170(13, new Class144[]{Class144.aClass144_1146});

    final int anInt1163;
    final Set aSet1166;

    Enum_Sub4(int var4, Class144[] var5) {
        this.aSet1166 = new HashSet();
        this.anInt1163 = var4;

        this.aSet1166.addAll(Arrays.asList(var5));

    }

    Enum_Sub4() {
        this.aSet1166 = new HashSet();
        this.anInt1163 = 4;
    }

    static LoginPacketMeta[] method849() {
        return new LoginPacketMeta[]{LoginPacketMeta.aLoginPacketMeta1997, LoginPacketMeta.aLoginPacketMeta1999, LoginPacketMeta.aLoginPacketMeta1995, LoginPacketMeta.aLoginPacketMeta1996, LoginPacketMeta.aLoginPacketMeta1998};
    }

    public static int method850(int var0, int var1, int var2, Class123 var3, CollisionMap var4, int[] var6, int[] var7) {
        int var9;
        for (int var8 = 0; var8 < 128; ++var8) {
            for (var9 = 0; var9 < 128; ++var9) {
                Statics7.anIntArrayArray860[var8][var9] = 0;
                Statics7.anIntArrayArray859[var8][var9] = 99999999;
            }
        }

        boolean var27;
        if (var2 == 1) {
            var27 = method851(var0, var1, var3, var4);
        } else if (var2 == 2) {
            var27 = Class123.method690(var0, var1, var3, var4);
        } else {
            var27 = Class62.method346(var0, var1, var2, var3, var4);
        }

        var9 = var0 - 64;
        int var10 = var1 - 64;
        int var11 = AssociateComparator_Sub4.anInt803;
        int var12 = Statics7.anInt858;
        int var13;
        int var14;
        int var16;
        if (!var27) {
            var13 = Integer.MAX_VALUE;
            var14 = Integer.MAX_VALUE;
            byte var15 = 10;
            var16 = var3.anInt843;
            int var17 = var3.anInt844;
            int var18 = var3.anInt842;
            int var19 = var3.anInt841;

            for (int var20 = var16 - var15; var20 <= var16 + var15; ++var20) {
                for (int var21 = var17 - var15; var21 <= var15 + var17; ++var21) {
                    int var22 = var20 - var9;
                    int var23 = var21 - var10;
                    if (var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && Statics7.anIntArrayArray859[var22][var23] < 100) {
                        int var24 = 0;
                        if (var20 < var16) {
                            var24 = var16 - var20;
                        } else if (var20 > var16 + var18 - 1) {
                            var24 = var20 - (var18 + var16 - 1);
                        }

                        int var25 = 0;
                        if (var21 < var17) {
                            var25 = var17 - var21;
                        } else if (var21 > var19 + var17 - 1) {
                            var25 = var21 - (var19 + var17 - 1);
                        }

                        int var26 = var25 * var25 + var24 * var24;
                        if (var26 < var13 || var26 == var13 && Statics7.anIntArrayArray859[var22][var23] < var14) {
                            var13 = var26;
                            var14 = Statics7.anIntArrayArray859[var22][var23];
                            var11 = var20;
                            var12 = var21;
                        }
                    }
                }
            }

            if (var13 == Integer.MAX_VALUE) {
                return -1;
            }
        }

        if (var0 == var11 && var12 == var1) {
            return 0;
        }
        byte var28 = 0;
        Statics7.anIntArray862[var28] = var11;
        var13 = var28 + 1;
        Statics7.anIntArray861[var28] = var12;

        int var29;
        for (var14 = var29 = Statics7.anIntArrayArray860[var11 - var9][var12 - var10]; var0 != var11 || var12 != var1; var14 = Statics7.anIntArrayArray860[var11 - var9][var12 - var10]) {
            if (var29 != var14) {
                var29 = var14;
                Statics7.anIntArray862[var13] = var11;
                Statics7.anIntArray861[var13++] = var12;
            }

            if ((var14 & 2) != 0) {
                ++var11;
            } else if ((var14 & 8) != 0) {
                --var11;
            }

            if ((var14 & 1) != 0) {
                ++var12;
            } else if ((var14 & 4) != 0) {
                --var12;
            }
        }

        var16 = 0;

        while (var13-- > 0) {
            var6[var16] = Statics7.anIntArray862[var13];
            var7[var16++] = Statics7.anIntArray861[var13];
            if (var16 >= var6.length) {
                break;
            }
        }

        return var16;
    }

    static boolean method851(int var0, int var1, Class123 var2, CollisionMap var3) {
        int var4 = var0;
        int var5 = var1;
        byte var6 = 64;
        byte var7 = 64;
        int var8 = var0 - var6;
        int var9 = var1 - var7;
        Statics7.anIntArrayArray860[var6][var7] = 99;
        Statics7.anIntArrayArray859[var6][var7] = 0;
        byte var10 = 0;
        int var11 = 0;
        Statics7.anIntArray862[var10] = var0;
        int var18 = var10 + 1;
        Statics7.anIntArray861[var10] = var1;
        int[][] var12 = var3.flags;

        while (var11 != var18) {
            var4 = Statics7.anIntArray862[var11];
            var5 = Statics7.anIntArray861[var11];
            var11 = var11 + 1 & 4095;
            int var16 = var4 - var8;
            int var17 = var5 - var9;
            int var13 = var4 - var3.insetX;
            int var14 = var5 - var3.insetY;
            if (var2.method292(var4, var5)) {
                AssociateComparator_Sub4.anInt803 = var4;
                Statics7.anInt858 = var5;
                return true;
            }

            int var15 = Statics7.anIntArrayArray859[var16][var17] + 1;
            if (var16 > 0 && Statics7.anIntArrayArray860[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
                Statics7.anIntArray862[var18] = var4 - 1;
                Statics7.anIntArray861[var18] = var5;
                var18 = var18 + 1 & 4095;
                Statics7.anIntArrayArray860[var16 - 1][var17] = 2;
                Statics7.anIntArrayArray859[var16 - 1][var17] = var15;
            }

            if (var16 < 127 && Statics7.anIntArrayArray860[var16 + 1][var17] == 0 && (var12[var13 + 1][var14] & 19136896) == 0) {
                Statics7.anIntArray862[var18] = var4 + 1;
                Statics7.anIntArray861[var18] = var5;
                var18 = var18 + 1 & 4095;
                Statics7.anIntArrayArray860[var16 + 1][var17] = 8;
                Statics7.anIntArrayArray859[var16 + 1][var17] = var15;
            }

            if (var17 > 0 && Statics7.anIntArrayArray860[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
                Statics7.anIntArray862[var18] = var4;
                Statics7.anIntArray861[var18] = var5 - 1;
                var18 = var18 + 1 & 4095;
                Statics7.anIntArrayArray860[var16][var17 - 1] = 1;
                Statics7.anIntArrayArray859[var16][var17 - 1] = var15;
            }

            if (var17 < 127 && Statics7.anIntArrayArray860[var16][var17 + 1] == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
                Statics7.anIntArray862[var18] = var4;
                Statics7.anIntArray861[var18] = var5 + 1;
                var18 = var18 + 1 & 4095;
                Statics7.anIntArrayArray860[var16][var17 + 1] = 4;
                Statics7.anIntArrayArray859[var16][var17 + 1] = var15;
            }

            if (var16 > 0 && var17 > 0 && Statics7.anIntArrayArray860[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
                Statics7.anIntArray862[var18] = var4 - 1;
                Statics7.anIntArray861[var18] = var5 - 1;
                var18 = var18 + 1 & 4095;
                Statics7.anIntArrayArray860[var16 - 1][var17 - 1] = 3;
                Statics7.anIntArrayArray859[var16 - 1][var17 - 1] = var15;
            }

            if (var16 < 127 && var17 > 0 && Statics7.anIntArrayArray860[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
                Statics7.anIntArray862[var18] = var4 + 1;
                Statics7.anIntArray861[var18] = var5 - 1;
                var18 = var18 + 1 & 4095;
                Statics7.anIntArrayArray860[var16 + 1][var17 - 1] = 9;
                Statics7.anIntArrayArray859[var16 + 1][var17 - 1] = var15;
            }

            if (var16 > 0 && var17 < 127 && Statics7.anIntArrayArray860[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
                Statics7.anIntArray862[var18] = var4 - 1;
                Statics7.anIntArray861[var18] = var5 + 1;
                var18 = var18 + 1 & 4095;
                Statics7.anIntArrayArray860[var16 - 1][var17 + 1] = 6;
                Statics7.anIntArrayArray859[var16 - 1][var17 + 1] = var15;
            }

            if (var16 < 127 && var17 < 127 && Statics7.anIntArrayArray860[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 1] & 19136992) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
                Statics7.anIntArray862[var18] = var4 + 1;
                Statics7.anIntArray861[var18] = var5 + 1;
                var18 = var18 + 1 & 4095;
                Statics7.anIntArrayArray860[var16 + 1][var17 + 1] = 12;
                Statics7.anIntArrayArray859[var16 + 1][var17 + 1] = var15;
            }
        }

        AssociateComparator_Sub4.anInt803 = var4;
        Statics7.anInt858 = var5;
        return false;
    }

    static void method852(int var0, int var1) {
        int[] var2 = new int[4];
        int[] var3 = new int[4];
        var2[0] = var0;
        var3[0] = var1;
        int var4 = 1;

        for (int var5 = 0; var5 < 4; ++var5) {
            if (World.anIntArray1874[var5] != var0) {
                var2[var4] = World.anIntArray1874[var5];
                var3[var4] = World.anIntArray1870[var5];
                ++var4;
            }
        }

        World.anIntArray1874 = var2;
        World.anIntArray1870 = var3;
        Class63_Sub2.method471(World.worlds, 0, World.worlds.length - 1, World.anIntArray1874, World.anIntArray1870);
    }

    static int method848(int var0, int var1) {
        if (var0 == -1) {
            return 12345678;
        }
        var1 = (var0 & 127) * var1 / 128;
        if (var1 < 2) {
            var1 = 2;
        } else if (var1 > 126) {
            var1 = 126;
        }

        return (var0 & 65408) + var1;
    }

    public int getOrdinal() {
        return this.anInt1163;
    }
}
