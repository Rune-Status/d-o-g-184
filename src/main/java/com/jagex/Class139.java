package com.jagex;

public class Class139 {
    public static int anInt1130;
    int anInt1133;
    int anInt1129;
    int anInt1126;
    byte[] aByteArray1132;
    int anInt1131;
    int anInt1125;
    byte[] aByteArray1134;
    int anInt1128;
    int anInt1127;

    Class139() {
    }

    static boolean method794(int var0) {
        for (int var1 = 0; var1 < client.anInt1092; ++var1) {
            if (client.anIntArray1096[var1] == var0) {
                return true;
            }
        }

        return false;
    }

    static void method795(int var0) {
        if (var0 == -1 && !client.aBoolean904) {
            Class96.method533();
        } else if (var0 != -1 && var0 != client.anInt898 && client.anInt900 != 0 && !client.aBoolean904) {
            CacheReferenceTable var1 = Statics15.aCacheReferenceTable1234;
            int var2 = client.anInt900;
            Class147.anInt1157 = 1;
            Class147.aReferenceTable1155 = var1;
            Statics8.anInt1122 = var0;
            Class30.anInt327 = 0;
            PickableNode.anInt379 = var2;
            Enum_Sub2.aBoolean620 = false;
            anInt1130 = 2;
        }

        client.anInt898 = var0;
    }
}
