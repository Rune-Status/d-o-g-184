package jag;

import jag.game.relationship.AssociateComparator_Sub4;
import jag.game.scene.CollisionMap;
import jag.statics.Statics7;

public abstract class RouteStrategy {
    public int destinationX;
    public int destinationY;
    public int destinationSizeX;
    public int destinationSizeY;

    protected RouteStrategy() {

    }

    public static boolean method690(int var0, int var1, RouteStrategy var2, CollisionMap var3) {
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
            if (var16 > 0 && Statics7.anIntArrayArray860[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0) {
                Statics7.anIntArray862[var18] = var4 - 1;
                Statics7.anIntArray861[var18] = var5;
                var18 = var18 + 1 & 4095;
                Statics7.anIntArrayArray860[var16 - 1][var17] = 2;
                Statics7.anIntArrayArray859[var16 - 1][var17] = var15;
            }

            if (var16 < 126 && Statics7.anIntArrayArray860[var16 + 1][var17] == 0 && (var12[var13 + 2][var14] & 19136899) == 0 && (var12[var13 + 2][var14 + 1] & 19136992) == 0) {
                Statics7.anIntArray862[var18] = var4 + 1;
                Statics7.anIntArray861[var18] = var5;
                var18 = var18 + 1 & 4095;
                Statics7.anIntArrayArray860[var16 + 1][var17] = 8;
                Statics7.anIntArrayArray859[var16 + 1][var17] = var15;
            }

            if (var17 > 0 && Statics7.anIntArrayArray860[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
                Statics7.anIntArray862[var18] = var4;
                Statics7.anIntArray861[var18] = var5 - 1;
                var18 = var18 + 1 & 4095;
                Statics7.anIntArrayArray860[var16][var17 - 1] = 1;
                Statics7.anIntArrayArray859[var16][var17 - 1] = var15;
            }

            if (var17 < 126 && Statics7.anIntArrayArray860[var16][var17 + 1] == 0 && (var12[var13][var14 + 2] & 19136824) == 0 && (var12[var13 + 1][var14 + 2] & 19136992) == 0) {
                Statics7.anIntArray862[var18] = var4;
                Statics7.anIntArray861[var18] = var5 + 1;
                var18 = var18 + 1 & 4095;
                Statics7.anIntArrayArray860[var16][var17 + 1] = 4;
                Statics7.anIntArrayArray859[var16][var17 + 1] = var15;
            }

            if (var16 > 0 && var17 > 0 && Statics7.anIntArrayArray860[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
                Statics7.anIntArray862[var18] = var4 - 1;
                Statics7.anIntArray861[var18] = var5 - 1;
                var18 = var18 + 1 & 4095;
                Statics7.anIntArrayArray860[var16 - 1][var17 - 1] = 3;
                Statics7.anIntArrayArray859[var16 - 1][var17 - 1] = var15;
            }

            if (var16 < 126 && var17 > 0 && Statics7.anIntArrayArray860[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && (var12[var13 + 2][var14] & 19136995) == 0) {
                Statics7.anIntArray862[var18] = var4 + 1;
                Statics7.anIntArray861[var18] = var5 - 1;
                var18 = var18 + 1 & 4095;
                Statics7.anIntArrayArray860[var16 + 1][var17 - 1] = 9;
                Statics7.anIntArrayArray859[var16 + 1][var17 - 1] = var15;
            }

            if (var16 > 0 && var17 < 126 && Statics7.anIntArrayArray860[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136830) == 0 && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][var14 + 2] & 19137016) == 0) {
                Statics7.anIntArray862[var18] = var4 - 1;
                Statics7.anIntArray861[var18] = var5 + 1;
                var18 = var18 + 1 & 4095;
                Statics7.anIntArrayArray860[var16 - 1][var17 + 1] = 6;
                Statics7.anIntArrayArray859[var16 - 1][var17 + 1] = var15;
            }

            if (var16 < 126 && var17 < 126 && Statics7.anIntArrayArray860[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 2] & 19137016) == 0 && (var12[var13 + 2][var14 + 2] & 19136992) == 0 && (var12[var13 + 2][var14 + 1] & 19136995) == 0) {
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

    public abstract boolean passable(int x, int y);
}
