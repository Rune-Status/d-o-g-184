package com.jagex;

public final class TileDecor {
    public Entity entity;
    public long uid;
    int fineX;
    int fineY;
    int height;
    int config;

    TileDecor() {
    }

    public static Class165 method2(int var0) {

        for (Class165 var4 : new Class165[]{Class165.aClass165_1337, Class165.aClass165_1336, Class165.aClass165_1335, Class165.aClass165_1334}) {
            if (var0 == var4.anInt1332) {
                return var4;
            }
        }

        return null;
    }

    static void method1(int var0, int var1, int var2, int var3, Sprite var4, DoublyLinkedNode_Sub10 var5) {
        int var6 = var3 * var3 + var2 * var2;
        if (var6 > 4225 && var6 < 90000) {
            int var7 = client.mapRotation & 2047;
            int var8 = JagGraphics3D.SIN_TABLE[var7];
            int var9 = JagGraphics3D.COS_TABLE[var7];
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            double var12 = Math.atan2((double) var10, (double) var11);
            int var14 = var5.anInt380 / 2 - 25;
            int var15 = (int) (Math.sin(var12) * (double) var14);
            int var16 = (int) (Math.cos(var12) * (double) var14);
            byte var17 = 20;
            PendingSpawn.mapedge.method831(var15 + (var0 + var5.anInt380 / 2 - var17 / 2), var5.anInt568 / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
        } else {
            Statics17.method891(var0, var1, var2, var3, var4, var5);
        }

    }
}
