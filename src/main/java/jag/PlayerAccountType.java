package jag;

import jag.commons.crypt.Djb2;
import jag.commons.input.Mouse;
import jag.game.client;
import jag.js5.LoadedArchive;
import jag.js5.Archive;
import jag.opcode.login.LoginStep;
import jag.opcode.PacketBuffer;
import jag.statics.*;
import jag.worldmap.WorldMapObjectIcon;

public enum PlayerAccountType implements EnumType {

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

    PlayerAccountType(int var3, int var4, boolean var6, boolean var7) {
        this.anInt1253 = var3;
        this.anInt1218 = var4;
        this.aBoolean1257 = var6;
        this.aBoolean1258 = var7;
    }

    public static void method918(boolean var0) {
        if (var0) {
            client.loginStep = Login.aBoolean462 ? LoginStep.anEnum_Sub3_828 : LoginStep.anEnum_Sub3_825;
        } else {
            client.loginStep = client.preferences.properties.containsKey(Djb2.hash(Login.username)) ? LoginStep.anEnum_Sub3_827 : LoginStep.anEnum_Sub3_826;
        }

    }

    public static void onSceneXTEAKeyChange(boolean dynamicScene, PacketBuffer buffer) {
        client.dynamicScene = dynamicScene;

        if (!client.dynamicScene) {
            int var3 = buffer.method1060();
            int var4 = buffer.readLEUShortA();
            int count = buffer.g2();
            Statics32.xteaKeys = new int[count][4];

            for (int var6 = 0; var6 < count; ++var6) {
                for (int var7 = 0; var7 < 4; ++var7) {
                    Statics32.xteaKeys[var6][var7] = buffer.g4();
                }
            }

            Mouse.mapRegions = new int[count];
            Statics57.anIntArray1156 = new int[count];
            Statics44.anIntArray352 = new int[count];
            WorldMapObjectIcon.aByteArrayArray493 = new byte[count][];
            LoadedArchive.aByteArrayArray425 = new byte[count][];
            boolean var17 = false;
            if ((var3 / 8 == 48 || var3 / 8 == 49) && var4 / 8 == 48) {
                var17 = true;
            }

            if (var3 / 8 == 48 && var4 / 8 == 148) {
                var17 = true;
            }

            count = 0;

            for (int var7 = (var3 - 6) / 8; var7 <= (var3 + 6) / 8; ++var7) {
                for (int var8 = (var4 - 6) / 8; var8 <= (var4 + 6) / 8; ++var8) {
                    int var9 = var8 + (var7 << 8);
                    if (!var17 || var8 != 49 && var8 != 149 && var8 != 147 && var7 != 50 && (var7 != 49 || var8 != 47)) {
                        Mouse.mapRegions[count] = var9;
                        Statics57.anIntArray1156[count] = Archive.landscape.getGroup("m" + var7 + "_" + var8);
                        Statics44.anIntArray352[count] = Archive.landscape.getGroup("l" + var7 + "_" + var8);
                        ++count;
                    }
                }
            }

            Base64.method1187(var3, var4, true);
        } else {
            int var3 = buffer.g2();
            boolean var16 = buffer.method1074() == 1;
            int var5 = buffer.method1060();
            int var6 = buffer.g2();
            buffer.bitAccess();

            for (int level = 0; level < 4; ++level) {
                for (int chunkX = 0; chunkX < 13; ++chunkX) {
                    for (int chunkY = 0; chunkY < 13; ++chunkY) {
                        int var10 = buffer.g(1);
                        if (var10 == 1) {
                            client.dynamicSceneData[level][chunkX][chunkY] = buffer.g(26);
                        } else {
                            client.dynamicSceneData[level][chunkX][chunkY] = -1;
                        }
                    }
                }
            }

            buffer.byteAccess();
            Statics32.xteaKeys = new int[var6][4];

            for (int var7 = 0; var7 < var6; ++var7) {
                for (int var8 = 0; var8 < 4; ++var8) {
                    Statics32.xteaKeys[var7][var8] = buffer.g4();
                }
            }

            Mouse.mapRegions = new int[var6];
            Statics57.anIntArray1156 = new int[var6];
            Statics44.anIntArray352 = new int[var6];
            WorldMapObjectIcon.aByteArrayArray493 = new byte[var6][];
            LoadedArchive.aByteArrayArray425 = new byte[var6][];
            var6 = 0;

            for (int var7 = 0; var7 < 4; ++var7) {
                for (int var8 = 0; var8 < 13; ++var8) {
                    for (int var9 = 0; var9 < 13; ++var9) {
                        int var10 = client.dynamicSceneData[var7][var8][var9];
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
                                Statics57.anIntArray1156[var6] = Archive.landscape.getGroup("m" + var14 + "_" + var15);
                                Statics44.anIntArray352[var6] = Archive.landscape.getGroup("l" + var14 + "_" + var15);
                                ++var6;
                            }
                        }
                    }
                }
            }

            Base64.method1187(var5, var3, !var16);
        }

    }

    public static String getNameExcludingTags(String name) {
        PlayerAccountType[] var1 = getValues();

        for (PlayerAccountType var3 : var1) {
            if (var3.anInt1218 != -1 && name.startsWith(Statics26.addImgTags(var3.anInt1218))) {
                name = name.substring(6 + Integer.toString(var3.anInt1218).length());
                break;
            }
        }

        return name;
    }

    public static PlayerAccountType[] getValues() {
        return new PlayerAccountType[]{anEnum_Sub6_1256, anEnum_Sub6_1259, anEnum_Sub6_1260, anEnum_Sub6_1255, anEnum_Sub6_1252, anEnum_Sub6_1254};
    }

    public int getOrdinal() {
        return this.anInt1253;
    }
}
