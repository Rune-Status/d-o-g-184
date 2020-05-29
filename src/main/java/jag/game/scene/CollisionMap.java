package jag.game.scene;

import jag.RouteStrategy;
import jag.commons.input.Mouse;
import jag.game.relationship.AssociateComparator_Sub4;
import jag.statics.Statics52;
import jag.statics.Statics7;

import java.awt.*;

public class CollisionMap {

    public final int[][] flags;
    public final int width;
    public final int insetX;
    public final int height;
    public final int insetY;

    public CollisionMap(int width, int height) {
        this.insetX = 0;
        this.insetY = 0;
        this.width = width;
        this.height = height;
        this.flags = new int[width][height];
        initialize();
    }

    public static void method155(Component var0) {
        var0.removeMouseListener(Mouse.instance);
        var0.removeMouseMotionListener(Mouse.instance);
        var0.removeFocusListener(Mouse.instance);
        Mouse.pendingPressMeta = 0;
    }

    public static int method850(int var0, int var1, int var2, RouteStrategy var3, CollisionMap var4, int[] var6, int[] var7) {
        int var9;
        for (int var8 = 0; var8 < 128; ++var8) {
            for (var9 = 0; var9 < 128; ++var9) {
                Statics7.anIntArrayArray860[var8][var9] = 0;
                Statics7.anIntArrayArray859[var8][var9] = 99999999;
            }
        }

        boolean var27;
        if (var2 == 1) {
            var27 = CollisionMap.method851(var0, var1, var3, var4);
        } else if (var2 == 2) {
            var27 = RouteStrategy.method690(var0, var1, var3, var4);
        } else {
            var27 = Statics52.method346(var0, var1, var2, var3, var4);
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
            var16 = var3.destinationX;
            int var17 = var3.destinationY;
            int var18 = var3.destinationSizeX;
            int var19 = var3.destinationSizeY;

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

    static boolean method851(int var0, int var1, RouteStrategy var2, CollisionMap var3) {
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
            if (var2.passable(var4, var5)) {
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

    public void invert(int x, int y, int flag) {
        flags[x][y] &= ~flag;
    }

    public void add(int x, int y, int var3) {
        flags[x][y] |= var3;
    }

    public void initialize() {
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (x != 0 && y != 0 && x < width - 5 && y < height - 5) {
                    flags[x][y] = 16777216;
                } else {
                    flags[x][y] = 16777215;
                }
            }
        }

    }

    public void method159(int var1, int var2) {
        var1 -= insetX;
        var2 -= insetY;
        int[] var10000 = flags[var1];
        var10000[var2] |= 2097152;
    }

    public void method157(int x, int y, int var3, int var4, boolean impenetrable) {
        x -= insetX;
        y -= insetY;
        if (var3 == 0) {
            if (var4 == 0) {
                invert(x, y, 128);
                invert(x - 1, y, 8);
            }

            if (var4 == 1) {
                invert(x, y, 2);
                invert(x, y + 1, 32);
            }

            if (var4 == 2) {
                invert(x, y, 8);
                invert(x + 1, y, 128);
            }

            if (var4 == 3) {
                invert(x, y, 32);
                invert(x, y - 1, 2);
            }
        }

        if (var3 == 1 || var3 == 3) {
            if (var4 == 0) {
                invert(x, y, 1);
                invert(x - 1, y + 1, 16);
            }

            if (var4 == 1) {
                invert(x, y, 4);
                invert(x + 1, y + 1, 64);
            }

            if (var4 == 2) {
                invert(x, y, 16);
                invert(x + 1, y - 1, 1);
            }

            if (var4 == 3) {
                invert(x, y, 64);
                invert(x - 1, y - 1, 4);
            }
        }

        if (var3 == 2) {
            if (var4 == 0) {
                invert(x, y, 130);
                invert(x - 1, y, 8);
                invert(x, y + 1, 32);
            }

            if (var4 == 1) {
                invert(x, y, 10);
                invert(x, y + 1, 32);
                invert(x + 1, y, 128);
            }

            if (var4 == 2) {
                invert(x, y, 40);
                invert(x + 1, y, 128);
                invert(x, y - 1, 2);
            }

            if (var4 == 3) {
                invert(x, y, 160);
                invert(x, y - 1, 2);
                invert(x - 1, y, 8);
            }
        }

        if (impenetrable) {
            if (var3 == 0) {
                if (var4 == 0) {
                    invert(x, y, 65536);
                    invert(x - 1, y, 4096);
                }

                if (var4 == 1) {
                    invert(x, y, 1024);
                    invert(x, y + 1, 16384);
                }

                if (var4 == 2) {
                    invert(x, y, 4096);
                    invert(x + 1, y, 65536);
                }

                if (var4 == 3) {
                    invert(x, y, 16384);
                    invert(x, y - 1, 1024);
                }
            }

            if (var3 == 1 || var3 == 3) {
                if (var4 == 0) {
                    invert(x, y, 512);
                    invert(x - 1, y + 1, 8192);
                }

                if (var4 == 1) {
                    invert(x, y, 2048);
                    invert(x + 1, y + 1, 32768);
                }

                if (var4 == 2) {
                    invert(x, y, 8192);
                    invert(x + 1, y - 1, 512);
                }

                if (var4 == 3) {
                    invert(x, y, 32768);
                    invert(x - 1, y - 1, 2048);
                }
            }

            if (var3 == 2) {
                if (var4 == 0) {
                    invert(x, y, 66560);
                    invert(x - 1, y, 4096);
                    invert(x, y + 1, 16384);
                }

                if (var4 == 1) {
                    invert(x, y, 5120);
                    invert(x, y + 1, 16384);
                    invert(x + 1, y, 65536);
                }

                if (var4 == 2) {
                    invert(x, y, 20480);
                    invert(x + 1, y, 65536);
                    invert(x, y - 1, 1024);
                }

                if (var4 == 3) {
                    invert(x, y, 81920);
                    invert(x, y - 1, 1024);
                    invert(x - 1, y, 4096);
                }
            }
        }
    }

    public void method152(int x, int y) {
        x -= insetX;
        y -= insetY;
        flags[x][y] &= -262145;
    }

    public void method153(int var1, int var2, int var3, int var4, int var5, boolean var6) {
        int var7 = 256;
        if (var6) {
            var7 += 131072;
        }

        var1 -= insetX;
        var2 -= insetY;
        int var8;
        if (var5 == 1 || var5 == 3) {
            var8 = var3;
            var3 = var4;
            var4 = var8;
        }

        for (var8 = var1; var8 < var3 + var1; ++var8) {
            if (var8 >= 0 && var8 < width) {
                for (int var9 = var2; var9 < var2 + var4; ++var9) {
                    if (var9 >= 0 && var9 < height) {
                        invert(var8, var9, var7);
                    }
                }
            }
        }

    }

    public void method158(int x, int y) {
        x -= insetX;
        y -= insetY;
        flags[x][y] |= 262144;
    }

    public void method160(int x, int y, int var3, int var4, boolean var5) {
        int var6 = 256;
        if (var5) {
            var6 += 131072;
        }

        x -= insetX;
        y -= insetY;

        for (int var7 = x; var7 < var3 + x; ++var7) {
            if (var7 >= 0 && var7 < width) {
                for (int var8 = y; var8 < y + var4; ++var8) {
                    if (var8 >= 0 && var8 < height) {
                        add(var7, var8, var6);
                    }
                }
            }
        }

    }

    public void method154(int x, int y, int var3, int var4, boolean var5) {
        x -= insetX;
        y -= insetY;
        if (var3 == 0) {
            if (var4 == 0) {
                add(x, y, 128);
                add(x - 1, y, 8);
            }

            if (var4 == 1) {
                add(x, y, 2);
                add(x, y + 1, 32);
            }

            if (var4 == 2) {
                add(x, y, 8);
                add(x + 1, y, 128);
            }

            if (var4 == 3) {
                add(x, y, 32);
                add(x, y - 1, 2);
            }
        }

        if (var3 == 1 || var3 == 3) {
            if (var4 == 0) {
                add(x, y, 1);
                add(x - 1, y + 1, 16);
            }

            if (var4 == 1) {
                add(x, y, 4);
                add(x + 1, y + 1, 64);
            }

            if (var4 == 2) {
                add(x, y, 16);
                add(x + 1, y - 1, 1);
            }

            if (var4 == 3) {
                add(x, y, 64);
                add(x - 1, y - 1, 4);
            }
        }

        if (var3 == 2) {
            if (var4 == 0) {
                add(x, y, 130);
                add(x - 1, y, 8);
                add(x, y + 1, 32);
            }

            if (var4 == 1) {
                add(x, y, 10);
                add(x, y + 1, 32);
                add(x + 1, y, 128);
            }

            if (var4 == 2) {
                add(x, y, 40);
                add(x + 1, y, 128);
                add(x, y - 1, 2);
            }

            if (var4 == 3) {
                add(x, y, 160);
                add(x, y - 1, 2);
                add(x - 1, y, 8);
            }
        }

        if (var5) {
            if (var3 == 0) {
                if (var4 == 0) {
                    add(x, y, 65536);
                    add(x - 1, y, 4096);
                }

                if (var4 == 1) {
                    add(x, y, 1024);
                    add(x, y + 1, 16384);
                }

                if (var4 == 2) {
                    add(x, y, 4096);
                    add(x + 1, y, 65536);
                }

                if (var4 == 3) {
                    add(x, y, 16384);
                    add(x, y - 1, 1024);
                }
            }

            if (var3 == 1 || var3 == 3) {
                if (var4 == 0) {
                    add(x, y, 512);
                    add(x - 1, y + 1, 8192);
                }

                if (var4 == 1) {
                    add(x, y, 2048);
                    add(x + 1, y + 1, 32768);
                }

                if (var4 == 2) {
                    add(x, y, 8192);
                    add(x + 1, y - 1, 512);
                }

                if (var4 == 3) {
                    add(x, y, 32768);
                    add(x - 1, y - 1, 2048);
                }
            }

            if (var3 == 2) {
                if (var4 == 0) {
                    add(x, y, 66560);
                    add(x - 1, y, 4096);
                    add(x, y + 1, 16384);
                }

                if (var4 == 1) {
                    add(x, y, 5120);
                    add(x, y + 1, 16384);
                    add(x + 1, y, 65536);
                }

                if (var4 == 2) {
                    add(x, y, 20480);
                    add(x + 1, y, 65536);
                    add(x, y - 1, 1024);
                }

                if (var4 == 3) {
                    add(x, y, 81920);
                    add(x, y - 1, 1024);
                    add(x - 1, y, 4096);
                }
            }
        }
    }
}
