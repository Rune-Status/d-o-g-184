package com.jagex;

public class Class62 {
    public static ReferenceTable aReferenceTable500;
    static int anInt498;
    static DoublyLinkedNode_Sub24_Sub4[] mapscene;
    static int anInt499;

    public static Jagception method348(Throwable var0, String var1) {
        Jagception var2;
        if (var0 instanceof Jagception) {
            var2 = (Jagception) var0;
            var2.message = var2.message + ' ' + var1;
        } else {
            var2 = new Jagception(var0, var1);
        }

        return var2;
    }

    static boolean method346(int var0, int var1, int var2, Class123 var3, CollisionMap var4) {
        int var5 = var0;
        int var6 = var1;
        byte var7 = 64;
        byte var8 = 64;
        int var9 = var0 - var7;
        int var10 = var1 - var8;
        Statics7.anIntArrayArray860[var7][var8] = 99;
        Statics7.anIntArrayArray859[var7][var8] = 0;
        byte var11 = 0;
        int var12 = 0;
        Statics7.anIntArray862[var11] = var0;
        int var20 = var11 + 1;
        Statics7.anIntArray861[var11] = var1;
        int[][] var13 = var4.flags;

        while (true) {
            label303:
            while (true) {
                int var14;
                int var15;
                int var16;
                int var17;
                int var18;
                int var19;
                do {
                    do {
                        do {
                            label280:
                            do {
                                if (var12 == var20) {
                                    AssociateComparator_Sub4.anInt803 = var5;
                                    Statics7.anInt858 = var6;
                                    return false;
                                }

                                var5 = Statics7.anIntArray862[var12];
                                var6 = Statics7.anIntArray861[var12];
                                var12 = var12 + 1 & 4095;
                                var18 = var5 - var9;
                                var19 = var6 - var10;
                                var14 = var5 - var4.insetX;
                                var15 = var6 - var4.insetY;
                                if (var3.method292(var5, var6)) {
                                    AssociateComparator_Sub4.anInt803 = var5;
                                    Statics7.anInt858 = var6;
                                    return true;
                                }

                                var16 = Statics7.anIntArrayArray859[var18][var19] + 1;
                                if (var18 > 0 && Statics7.anIntArrayArray860[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                                    var17 = 1;

                                    while (true) {
                                        if (var17 >= var2 - 1) {
                                            Statics7.anIntArray862[var20] = var5 - 1;
                                            Statics7.anIntArray861[var20] = var6;
                                            var20 = var20 + 1 & 4095;
                                            Statics7.anIntArrayArray860[var18 - 1][var19] = 2;
                                            Statics7.anIntArrayArray859[var18 - 1][var19] = var16;
                                            break;
                                        }

                                        if ((var13[var14 - 1][var15 + var17] & 19136830) != 0) {
                                            break;
                                        }

                                        ++var17;
                                    }
                                }

                                if (var18 < 128 - var2 && Statics7.anIntArrayArray860[var18 + 1][var19] == 0 && (var13[var14 + var2][var15] & 19136899) == 0 && (var13[var14 + var2][var15 + var2 - 1] & 19136992) == 0) {
                                    var17 = 1;

                                    while (true) {
                                        if (var17 >= var2 - 1) {
                                            Statics7.anIntArray862[var20] = var5 + 1;
                                            Statics7.anIntArray861[var20] = var6;
                                            var20 = var20 + 1 & 4095;
                                            Statics7.anIntArrayArray860[var18 + 1][var19] = 8;
                                            Statics7.anIntArrayArray859[var18 + 1][var19] = var16;
                                            break;
                                        }

                                        if ((var13[var14 + var2][var17 + var15] & 19136995) != 0) {
                                            break;
                                        }

                                        ++var17;
                                    }
                                }

                                if (var19 > 0 && Statics7.anIntArrayArray860[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var14 + var2 - 1][var15 - 1] & 19136899) == 0) {
                                    var17 = 1;

                                    while (true) {
                                        if (var17 >= var2 - 1) {
                                            Statics7.anIntArray862[var20] = var5;
                                            Statics7.anIntArray861[var20] = var6 - 1;
                                            var20 = var20 + 1 & 4095;
                                            Statics7.anIntArrayArray860[var18][var19 - 1] = 1;
                                            Statics7.anIntArrayArray859[var18][var19 - 1] = var16;
                                            break;
                                        }

                                        if ((var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                            break;
                                        }

                                        ++var17;
                                    }
                                }

                                if (var19 < 128 - var2 && Statics7.anIntArrayArray860[var18][var19 + 1] == 0 && (var13[var14][var15 + var2] & 19136824) == 0 && (var13[var14 + var2 - 1][var15 + var2] & 19136992) == 0) {
                                    var17 = 1;

                                    while (true) {
                                        if (var17 >= var2 - 1) {
                                            Statics7.anIntArray862[var20] = var5;
                                            Statics7.anIntArray861[var20] = var6 + 1;
                                            var20 = var20 + 1 & 4095;
                                            Statics7.anIntArrayArray860[var18][var19 + 1] = 4;
                                            Statics7.anIntArrayArray859[var18][var19 + 1] = var16;
                                            break;
                                        }

                                        if ((var13[var14 + var17][var15 + var2] & 19137016) != 0) {
                                            break;
                                        }

                                        ++var17;
                                    }
                                }

                                if (var18 > 0 && var19 > 0 && Statics7.anIntArrayArray860[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                                    var17 = 1;

                                    while (true) {
                                        if (var17 >= var2) {
                                            Statics7.anIntArray862[var20] = var5 - 1;
                                            Statics7.anIntArray861[var20] = var6 - 1;
                                            var20 = var20 + 1 & 4095;
                                            Statics7.anIntArrayArray860[var18 - 1][var19 - 1] = 3;
                                            Statics7.anIntArrayArray859[var18 - 1][var19 - 1] = var16;
                                            break;
                                        }

                                        if ((var13[var14 - 1][var17 + (var15 - 1)] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 - 1] & 19136911) != 0) {
                                            break;
                                        }

                                        ++var17;
                                    }
                                }

                                if (var18 < 128 - var2 && var19 > 0 && Statics7.anIntArrayArray860[var18 + 1][var19 - 1] == 0 && (var13[var14 + var2][var15 - 1] & 19136899) == 0) {
                                    var17 = 1;

                                    while (true) {
                                        if (var17 >= var2) {
                                            Statics7.anIntArray862[var20] = var5 + 1;
                                            Statics7.anIntArray861[var20] = var6 - 1;
                                            var20 = var20 + 1 & 4095;
                                            Statics7.anIntArrayArray860[var18 + 1][var19 - 1] = 9;
                                            Statics7.anIntArrayArray859[var18 + 1][var19 - 1] = var16;
                                            break;
                                        }

                                        if ((var13[var14 + var2][var17 + (var15 - 1)] & 19136995) != 0 || (var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                            break;
                                        }

                                        ++var17;
                                    }
                                }

                                if (var18 > 0 && var19 < 128 - var2 && Statics7.anIntArrayArray860[var18 - 1][var19 + 1] == 0 && (var13[var14 - 1][var15 + var2] & 19136824) == 0) {
                                    for (var17 = 1; var17 < var2; ++var17) {
                                        if ((var13[var14 - 1][var17 + var15] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 + var2] & 19137016) != 0) {
                                            continue label280;
                                        }
                                    }

                                    Statics7.anIntArray862[var20] = var5 - 1;
                                    Statics7.anIntArray861[var20] = var6 + 1;
                                    var20 = var20 + 1 & 4095;
                                    Statics7.anIntArrayArray860[var18 - 1][var19 + 1] = 6;
                                    Statics7.anIntArrayArray859[var18 - 1][var19 + 1] = var16;
                                }
                            } while (var18 >= 128 - var2);
                        } while (var19 >= 128 - var2);
                    } while (Statics7.anIntArrayArray860[var18 + 1][var19 + 1] != 0);
                } while ((var13[var14 + var2][var15 + var2] & 19136992) != 0);

                for (var17 = 1; var17 < var2; ++var17) {
                    if ((var13[var17 + var14][var15 + var2] & 19137016) != 0 || (var13[var14 + var2][var15 + var17] & 19136995) != 0) {
                        continue label303;
                    }
                }

                Statics7.anIntArray862[var20] = var5 + 1;
                Statics7.anIntArray861[var20] = var6 + 1;
                var20 = var20 + 1 & 4095;
                Statics7.anIntArrayArray860[var18 + 1][var19 + 1] = 12;
                Statics7.anIntArrayArray859[var18 + 1][var19 + 1] = var16;
            }
        }
    }

    static boolean method345() {
        return client.aBoolean1037 || Keyboard.heldKeys[81];
    }

    static char method347(char var0) {
        if (var0 == 198) {
            return 'E';
        }
        if (var0 == 230) {
            return 'e';
        }
        if (var0 == 223) {
            return 's';
        }
        if (var0 == 338) {
            return 'E';
        }
        return (var0 == 339 ? 'e' : '\u0000');
    }
}
