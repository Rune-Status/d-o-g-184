package com.jagex;

import java.text.DecimalFormat;

public class Class55 {
    static OldConnectionTask aOldConnectionTask_464;
    static String loginResponse1;
    static int anInt479;
    static String loginResponse2;
    static String loginResponse3;
    static int anInt474;
    static int anInt473;
    static String aString475;
    static int anInt468;
    static int loginState;
    static int anInt469;
    static String aString471;
    static String username;
    static String password;
    static boolean aBoolean477;
    static boolean aBoolean472;
    static boolean aBoolean462;
    static int anInt461;
    static boolean loginWorldSelectorOpen;
    static int anInt463;
    static int anInt460;
    static int anInt466;
    static long aLong467;
    static long aLong465;
    static boolean aBoolean476;
    static DoublyLinkedNode_Sub24_Sub4[] aDoublyNode_Sub24_Sub4Array478;
    static DoublyLinkedNode_Sub24_Sub4 aDoublyNode_Sub24_Sub4_470;

    static {
        anInt479 = 0;
        anInt474 = anInt479 + 202;
        anInt473 = 10;
        aString475 = "";
        anInt468 = -1;
        anInt469 = 1;
        loginState = 0;
        aString471 = "";
        loginResponse1 = "";
        loginResponse2 = "";
        loginResponse3 = "";
        username = "";
        password = "";
        aBoolean477 = false;
        aBoolean472 = false;
        aBoolean462 = true;
        anInt461 = 0;
        loginWorldSelectorOpen = false;
        anInt463 = -1;
        anInt460 = 0;
        anInt466 = 0;
        new DecimalFormat("##0.00");
        new Statics6();
        aLong467 = -1L;
        aLong465 = -1L;
    }

    static void method325() {
        int var0 = GPI.playerCount;
        int[] var1 = GPI.playerIndices;

        for (int var2 = 0; var2 < var0; ++var2) {
            if (var1[var2] != client.anInt1030 && var1[var2] != client.playerIndex) {
                GPI.method415(client.players[var1[var2]], true);
            }
        }

    }

    static int method324(int var0, int var1) {
        int var2 = Enum_Sub3.method686(var0 - 1, var1 - 1) + Enum_Sub3.method686(var0 + 1, var1 - 1) + Enum_Sub3.method686(var0 - 1, 1 + var1) + Enum_Sub3.method686(1 + var0, var1 + 1);
        int var3 = Enum_Sub3.method686(var0 - 1, var1) + Enum_Sub3.method686(var0 + 1, var1) + Enum_Sub3.method686(var0, var1 - 1) + Enum_Sub3.method686(var0, var1 + 1);
        int var4 = Enum_Sub3.method686(var0, var1);
        return var2 / 16 + var3 / 8 + var4 / 4;
    }
}
