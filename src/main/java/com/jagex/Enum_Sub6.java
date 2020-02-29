package com.jagex;

public enum Enum_Sub6 implements EnumType {
    anEnum_Sub6_1259(0, -1, false, true),
    anEnum_Sub6_1260(1, 0, true, true),
    anEnum_Sub6_1256(2, 1, true, false),
    anEnum_Sub6_1255(3, 2, false, true),
    anEnum_Sub6_1254(4, 3, false, true),
    anEnum_Sub6_1252(5, 10, false, true);

    public final int anInt1218;
    public final boolean aBoolean1257;
    public final boolean aBoolean1258;
    final int anInt1253;

    Enum_Sub6(int var3, int var4, boolean var6, boolean var7) {
        this.anInt1253 = var3;
        this.anInt1218 = var4;
        this.aBoolean1257 = var6;
        this.aBoolean1258 = var7;
    }

    static void setLoginMessages(String var0, String var1, String var2) {
        Class55.loginResponse1 = var0;
        Class55.loginResponse2 = var1;
        Class55.loginResponse3 = var2;
    }

    static void method918(boolean var0) {
        if (var0) {
            client.anEnum_Sub3_955 = Class55.aBoolean462 ? Enum_Sub3.anEnum_Sub3_828 : Enum_Sub3.anEnum_Sub3_825;
        } else {
            client.anEnum_Sub3_955 = client.preferences.properties.containsKey(Statics33.method1141(Class55.username)) ? Enum_Sub3.anEnum_Sub3_827 : Enum_Sub3.anEnum_Sub3_826;
        }

    }

    static void onSceneXTEAKeyChange(boolean instance, PacketBuffer var1) {
        client.inInstancedScene = instance;
        int var3;
        int var5;
        int var6;
        int var7;
        int var8;
        int var9;
        if (!client.inInstancedScene) {
            var3 = var1.method1060();
            int var4 = var1.readLEUShortA();
            var5 = var1.readUShort();
            Statics32.xteaKeys = new int[var5][4];

            for (var6 = 0; var6 < var5; ++var6) {
                for (var7 = 0; var7 < 4; ++var7) {
                    Statics32.xteaKeys[var6][var7] = var1.readInt();
                }
            }

            Mouse.mapRegions = new int[var5];
            Class147.anIntArray1156 = new int[var5];
            Class39.anIntArray352 = new int[var5];
            Class27_Sub1.aByteArrayArray493 = new byte[var5][];
            Class46.aByteArrayArray425 = new byte[var5][];
            boolean var17 = false;
            if ((var3 / 8 == 48 || var3 / 8 == 49) && var4 / 8 == 48) {
                var17 = true;
            }

            if (var3 / 8 == 48 && var4 / 8 == 148) {
                var17 = true;
            }

            var5 = 0;

            for (var7 = (var3 - 6) / 8; var7 <= (var3 + 6) / 8; ++var7) {
                for (var8 = (var4 - 6) / 8; var8 <= (var4 + 6) / 8; ++var8) {
                    var9 = var8 + (var7 << 8);
                    if (!var17 || var8 != 49 && var8 != 149 && var8 != 147 && var7 != 50 && (var7 != 49 || var8 != 47)) {
                        Mouse.mapRegions[var5] = var9;
                        Class147.anIntArray1156[var5] = Class85.aCacheReferenceTable635.method900("m" + var7 + "_" + var8);
                        Class39.anIntArray352[var5] = Class85.aCacheReferenceTable635.method900("l" + var7 + "_" + var8);
                        ++var5;
                    }
                }
            }

            Statics37.method1187(var3, var4, true);
        } else {
            var3 = var1.readUShort();
            boolean var16 = var1.method1074() == 1;
            var5 = var1.method1060();
            var6 = var1.readUShort();
            var1.bitAccess();

            int var10;
            for (var7 = 0; var7 < 4; ++var7) {
                for (var8 = 0; var8 < 13; ++var8) {
                    for (var9 = 0; var9 < 13; ++var9) {
                        var10 = var1.method1398(1);
                        if (var10 == 1) {
                            client.dynamicSceneData[var7][var8][var9] = var1.method1398(26);
                        } else {
                            client.dynamicSceneData[var7][var8][var9] = -1;
                        }
                    }
                }
            }

            var1.byteAccess();
            Statics32.xteaKeys = new int[var6][4];

            for (var7 = 0; var7 < var6; ++var7) {
                for (var8 = 0; var8 < 4; ++var8) {
                    Statics32.xteaKeys[var7][var8] = var1.readInt();
                }
            }

            Mouse.mapRegions = new int[var6];
            Class147.anIntArray1156 = new int[var6];
            Class39.anIntArray352 = new int[var6];
            Class27_Sub1.aByteArrayArray493 = new byte[var6][];
            Class46.aByteArrayArray425 = new byte[var6][];
            var6 = 0;

            for (var7 = 0; var7 < 4; ++var7) {
                for (var8 = 0; var8 < 13; ++var8) {
                    for (var9 = 0; var9 < 13; ++var9) {
                        var10 = client.dynamicSceneData[var7][var8][var9];
                        if (var10 != -1) {
                            int var11 = var10 >> 14 & 1023;
                            int var12 = var10 >> 3 & 2047;
                            int var13 = (var11 / 8 << 8) + var12 / 8;

                            int var14;
                            for (var14 = 0; var14 < var6; ++var14) {
                                if (Mouse.mapRegions[var14] == var13) {
                                    var13 = -1;
                                    break;
                                }
                            }

                            if (var13 != -1) {
                                Mouse.mapRegions[var6] = var13;
                                var14 = var13 >> 8 & 255;
                                int var15 = var13 & 255;
                                Class147.anIntArray1156[var6] = Class85.aCacheReferenceTable635.method900("m" + var14 + "_" + var15);
                                Class39.anIntArray352[var6] = Class85.aCacheReferenceTable635.method900("l" + var14 + "_" + var15);
                                ++var6;
                            }
                        }
                    }
                }
            }

            Statics37.method1187(var5, var3, !var16);
        }

    }

    public int getOrdinal() {
        return this.anInt1253;
    }
}
