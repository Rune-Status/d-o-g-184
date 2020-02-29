package com.jagex;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class Keyboard implements KeyListener, FocusListener {
    public static Keyboard keyboard;
    public static int anInt150;
    public static boolean[] heldKeys;
    public static int[] anIntArray154;
    public static int anInt155;
    public static int anInt153;
    public static int anInt157;
    public static int[] anIntArray147;
    public static int anInt152;
    public static volatile int idleTime;
    public static int anInt162;
    public static char aChar151;
    static int[] anIntArray159;
    static char[] aCharArray156;
    static int[] anIntArray148;
    static Class131 aClass131_158;

    static {
        keyboard = new Keyboard();
        heldKeys = new boolean[112];
        anIntArray154 = new int[128];
        anInt155 = 0;
        anInt150 = 0;
        aCharArray156 = new char[128];
        anIntArray148 = new int[128];
        anIntArray147 = new int[128];
        anInt152 = 0;
        anInt157 = 0;
        anInt153 = 0;
        anInt162 = 0;
        idleTime = 0;
        anIntArray159 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    }

    Keyboard() {
    }

    static void method100() {

        for (Object anARS3CopiedNodeTable523 : Class64.A_ITERABLE_NODE_TABLE_523) {
            Chatline var1 = (Chatline) anARS3CopiedNodeTable523;
            var1.method254();
        }

    }

    static void method102() {
        ScriptEvent.method1305();
        client.menuActions[0] = "Cancel";
        client.menuTargets[0] = "";
        client.menuOpcodes[0] = 1006;
        client.menuShiftClickActions[0] = false;
        client.menuRowCount = 1;
    }

    static void method101() {
        GrandExchangeOffer.method231(false);
        client.anInt966 = 0;
        boolean var0 = true;

        int var1;
        for (var1 = 0; var1 < Class27_Sub1.aByteArrayArray493.length; ++var1) {
            if (Class147.anIntArray1156[var1] != -1 && Class27_Sub1.aByteArrayArray493[var1] == null) {
                Class27_Sub1.aByteArrayArray493[var1] = Class85.aCacheReferenceTable635.unpack(Class147.anIntArray1156[var1], 0);
                if (Class27_Sub1.aByteArrayArray493[var1] == null) {
                    var0 = false;
                    ++client.anInt966;
                }
            }

            if (Class39.anIntArray352[var1] != -1 && Class46.aByteArrayArray425[var1] == null) {
                Class46.aByteArrayArray425[var1] = Class85.aCacheReferenceTable635.unpack(Class39.anIntArray352[var1], 0, Statics32.xteaKeys[var1]);
                if (Class46.aByteArrayArray425[var1] == null) {
                    var0 = false;
                    ++client.anInt966;
                }
            }
        }

        if (!var0) {
            client.anInt975 = 1;
        } else {
            client.anInt968 = 0;
            var0 = true;

            int var3;
            int var4;
            Buffer var7;
            int var8;
            int var9;
            int var11;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            for (var1 = 0; var1 < Class27_Sub1.aByteArrayArray493.length; ++var1) {
                byte[] var2 = Class46.aByteArrayArray425[var1];
                if (var2 != null) {
                    var3 = (Mouse.mapRegions[var1] >> 8) * 64 - Statics18.baseX;
                    var4 = (Mouse.mapRegions[var1] & 255) * 64 - Statics36.baseY;
                    if (client.inInstancedScene) {
                        var3 = 10;
                        var4 = 10;
                    }

                    boolean var6 = true;
                    var7 = new Buffer(var2);
                    var8 = -1;

                    label1329:
                    while (true) {
                        var9 = var7.readSmarts();
                        if (var9 == 0) {
                            var0 &= var6;
                            break;
                        }

                        var8 += var9;
                        var11 = 0;
                        boolean var12 = false;

                        while (true) {
                            while (!var12) {
                                var13 = var7.readSmart();
                                if (var13 == 0) {
                                    continue label1329;
                                }

                                var11 += var13 - 1;
                                var14 = var11 & 63;
                                var15 = var11 >> 6 & 63;
                                var16 = var7.readUByte() >> 2;
                                var17 = var3 + var15;
                                var18 = var4 + var14;
                                if (var17 > 0 && var18 > 0 && var17 < 103 && var18 < 103) {
                                    ObjectDefinition var19 = Class38.getObjectDefinition(var8);
                                    if (var16 != 22 || !client.lowMemory || var19.mapDoorFlag != 0 || var19.anInt791 == 1 || var19.aBoolean1507) {
                                        if (!var19.method882()) {
                                            ++client.anInt968;
                                            var6 = false;
                                        }

                                        var12 = true;
                                    }
                                }
                            }

                            var13 = var7.readSmart();
                            if (var13 == 0) {
                                break;
                            }

                            var7.readUByte();
                        }
                    }
                }
            }

            if (!var0) {
                client.anInt975 = 2;
            } else {
                if (client.anInt975 != 0) {
                    Class37.method242("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                }

                Class26.method190();
                client.sceneGraph.method1486();

                for (var1 = 0; var1 < 4; ++var1) {
                    client.collisionMaps[var1].method162();
                }

                int var20;
                for (var1 = 0; var1 < 4; ++var1) {
                    for (var20 = 0; var20 < 104; ++var20) {
                        for (var3 = 0; var3 < 104; ++var3) {
                            Class44.sceneRenderRules[var1][var20][var3] = 0;
                        }
                    }
                }

                Class26.method190();
                TextureProviderImpl.method1517();
                var1 = Class27_Sub1.aByteArrayArray493.length;
                OutgoingPacketMeta.method4();
                GrandExchangeOffer.method231(true);
                int var5;
                int var25;
                int var26;
                int var30;
                int var66;
                if (!client.inInstancedScene) {
                    byte[] var21;
                    for (var20 = 0; var20 < var1; ++var20) {
                        var3 = (Mouse.mapRegions[var20] >> 8) * 64 - Statics18.baseX;
                        var4 = (Mouse.mapRegions[var20] & 255) * 64 - Statics36.baseY;
                        var21 = Class27_Sub1.aByteArrayArray493[var20];
                        if (var21 != null) {
                            Class26.method190();
                            Class16.method126(var21, var3, var4, IncomingPacketMeta.anInt206 * 8 - 48, Node_Sub19.anInt1191 * 8 - 48, client.collisionMaps);
                        }
                    }

                    for (var20 = 0; var20 < var1; ++var20) {
                        var3 = (Mouse.mapRegions[var20] >> 8) * 64 - Statics18.baseX;
                        var4 = (Mouse.mapRegions[var20] & 255) * 64 - Statics36.baseY;
                        var21 = Class27_Sub1.aByteArrayArray493[var20];
                        if (var21 == null && Node_Sub19.anInt1191 < 800) {
                            Class26.method190();
                            Class24.method180(var3, var4, 64, 64);
                        }
                    }

                    GrandExchangeOffer.method231(true);

                    for (var20 = 0; var20 < var1; ++var20) {
                        byte[] var27 = Class46.aByteArrayArray425[var20];
                        if (var27 != null) {
                            var4 = (Mouse.mapRegions[var20] >> 8) * 64 - Statics18.baseX * 64;
                            var5 = (Mouse.mapRegions[var20] & 255) * 64 - Statics36.baseY * 64;
                            Class26.method190();
                            SceneGraph var28 = client.sceneGraph;
                            CollisionMap[] var29 = client.collisionMaps;
                            var7 = new Buffer(var27);
                            var8 = -1;

                            while (true) {
                                var9 = var7.readSmarts();
                                if (var9 == 0) {
                                    break;
                                }

                                var8 += var9;
                                var11 = 0;

                                while (true) {
                                    var66 = var7.readSmart();
                                    if (var66 == 0) {
                                        break;
                                    }

                                    var11 += var66 - 1;
                                    var13 = var11 & 63;
                                    var14 = var11 >> 6 & 63;
                                    var15 = var11 >> 12;
                                    var16 = var7.readUByte();
                                    var17 = var16 >> 2;
                                    var18 = var16 & 3;
                                    var25 = var14 + var4;
                                    var26 = var5 + var13;
                                    if (var25 > 0 && var26 > 0 && var25 < 103 && var26 < 103) {
                                        var30 = var15;
                                        if ((Class44.sceneRenderRules[1][var25][var26] & 2) == 2) {
                                            var30 = var15 - 1;
                                        }

                                        CollisionMap var47 = null;
                                        if (var30 >= 0) {
                                            var47 = var29[var30];
                                        }

                                        Class74.method414(var15, var25, var26, var8, var18, var17, var28, var47);
                                    }
                                }
                            }
                        }
                    }
                }

                int var10;
                int[] var10000;
                int var22;
                int var31;
                int var35;
                int var36;
                int var37;
                int var38;
                int var41;
                int var43;
                int var44;
                int var46;
                int var65;
                if (client.inInstancedScene) {
                    for (var20 = 0; var20 < 4; ++var20) {
                        Class26.method190();

                        for (var3 = 0; var3 < 13; ++var3) {
                            for (var4 = 0; var4 < 13; ++var4) {
                                boolean var64 = false;
                                var10 = client.dynamicSceneData[var20][var3][var4];
                                if (var10 != -1) {
                                    var65 = var10 >> 24 & 3;
                                    var22 = var10 >> 1 & 3;
                                    var8 = var10 >> 14 & 1023;
                                    var9 = var10 >> 3 & 2047;
                                    var11 = (var8 / 8 << 8) + var9 / 8;

                                    for (var66 = 0; var66 < Mouse.mapRegions.length; ++var66) {
                                        if (Mouse.mapRegions[var66] == var11 && Class27_Sub1.aByteArrayArray493[var66] != null) {
                                            byte[] var23 = Class27_Sub1.aByteArrayArray493[var66];
                                            var14 = var3 * 8;
                                            var15 = var4 * 8;
                                            var16 = (var8 & 7) * 8;
                                            var17 = (var9 & 7) * 8;
                                            CollisionMap[] var24 = client.collisionMaps;

                                            for (var25 = 0; var25 < 8; ++var25) {
                                                for (var26 = 0; var26 < 8; ++var26) {
                                                    if (var14 + var25 > 0 && var25 + var14 < 103 && var15 + var26 > 0 && var26 + var15 < 103) {
                                                        var10000 = var24[var20].flags[var14 + var25];
                                                        var10000[var15 + var26] &= -16777217;
                                                    }
                                                }
                                            }

                                            Buffer var67 = new Buffer(var23);

                                            for (var26 = 0; var26 < 4; ++var26) {
                                                for (var30 = 0; var30 < 64; ++var30) {
                                                    for (var31 = 0; var31 < 64; ++var31) {
                                                        if (var26 == var65 && var30 >= var16 && var30 < var16 + 8 && var31 >= var17 && var31 < var17 + 8) {
                                                            var35 = var30 & 7;
                                                            var36 = var31 & 7;
                                                            var37 = var22 & 3;
                                                            if (var37 == 0) {
                                                                var38 = var35;
                                                            } else if (var37 == 1) {
                                                                var38 = var36;
                                                            } else if (var37 == 2) {
                                                                var38 = 7 - var35;
                                                            } else {
                                                                var38 = 7 - var36;
                                                            }

                                                            var41 = var14 + var38;
                                                            var43 = var30 & 7;
                                                            var44 = var31 & 7;
                                                            int var45 = var22 & 3;
                                                            if (var45 == 0) {
                                                                var46 = var44;
                                                            } else if (var45 == 1) {
                                                                var46 = 7 - var43;
                                                            } else if (var45 == 2) {
                                                                var46 = 7 - var44;
                                                            } else {
                                                                var46 = var43;
                                                            }

                                                            Class76.method416(var67, var20, var41, var46 + var15, 0, 0, var22);
                                                        } else {
                                                            Class76.method416(var67, 0, -1, -1, 0, 0, 0);
                                                        }
                                                    }
                                                }
                                            }

                                            var64 = true;
                                            break;
                                        }
                                    }
                                }

                                if (!var64) {
                                    Class26.method189(var20, var3 * 8, var4 * 8);
                                }
                            }
                        }
                    }

                    for (var20 = 0; var20 < 13; ++var20) {
                        for (var3 = 0; var3 < 13; ++var3) {
                            var4 = client.dynamicSceneData[0][var20][var3];
                            if (var4 == -1) {
                                Class24.method180(var20 * 8, var3 * 8, 8, 8);
                            }
                        }
                    }

                    GrandExchangeOffer.method231(true);

                    for (var20 = 0; var20 < 4; ++var20) {
                        Class26.method190();

                        for (var3 = 0; var3 < 13; ++var3) {
                            for (var4 = 0; var4 < 13; ++var4) {
                                var5 = client.dynamicSceneData[var20][var3][var4];
                                if (var5 != -1) {
                                    var10 = var5 >> 24 & 3;
                                    var65 = var5 >> 1 & 3;
                                    var22 = var5 >> 14 & 1023;
                                    var8 = var5 >> 3 & 2047;
                                    var9 = (var22 / 8 << 8) + var8 / 8;

                                    for (var11 = 0; var11 < Mouse.mapRegions.length; ++var11) {
                                        if (Mouse.mapRegions[var11] == var9 && Class46.aByteArrayArray425[var11] != null) {
                                            Class82.method444(Class46.aByteArrayArray425[var11], var20, var3 * 8, var4 * 8, var10, (var22 & 7) * 8, (var8 & 7) * 8, var65, client.sceneGraph, client.collisionMaps);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                GrandExchangeOffer.method231(true);
                Class26.method190();
                SceneGraph var63 = client.sceneGraph;
                CollisionMap[] var73 = client.collisionMaps;

                for (var4 = 0; var4 < 4; ++var4) {
                    for (var5 = 0; var5 < 104; ++var5) {
                        for (var10 = 0; var10 < 104; ++var10) {
                            if ((Class44.sceneRenderRules[var4][var5][var10] & 1) == 1) {
                                var65 = var4;
                                if ((Class44.sceneRenderRules[1][var5][var10] & 2) == 2) {
                                    var65 = var4 - 1;
                                }

                                if (var65 >= 0) {
                                    var73[var65].method159(var5, var10);
                                }
                            }
                        }
                    }
                }

                Class44.anInt399 += (int) (Math.random() * 5.0D) - 2;
                if (Class44.anInt399 < -8) {
                    Class44.anInt399 = -8;
                }

                if (Class44.anInt399 > 8) {
                    Class44.anInt399 = 8;
                }

                Class44.anInt398 += (int) (Math.random() * 5.0D) - 2;
                if (Class44.anInt398 < -16) {
                    Class44.anInt398 = -16;
                }

                if (Class44.anInt398 > 16) {
                    Class44.anInt398 = 16;
                }

                for (var4 = 0; var4 < 4; ++var4) {
                    byte[][] var69 = Class44.aByteArrayArrayArray400[var4];
                    var11 = (int) Math.sqrt(5100.0D);
                    var66 = var11 * 768 >> 8;

                    for (var13 = 1; var13 < 103; ++var13) {
                        for (var14 = 1; var14 < 103; ++var14) {
                            var15 = Class44.tileHeights[var4][var14 + 1][var13] - Class44.tileHeights[var4][var14 - 1][var13];
                            var16 = Class44.tileHeights[var4][var14][var13 + 1] - Class44.tileHeights[var4][var14][var13 - 1];
                            var17 = (int) Math.sqrt((double) (var16 * var16 + var15 * var15 + 65536));
                            var18 = (var15 << 8) / var17;
                            var25 = 65536 / var17;
                            var26 = (var16 << 8) / var17;
                            var30 = (var18 * -50 + var26 * -50 + var25 * -10) / var66 + 96;
                            var31 = (var69[var14][var13 + 1] >> 3) + (var69[var14 - 1][var13] >> 2) + (var69[var14][var13 - 1] >> 2) + (var69[var14 + 1][var13] >> 3) + (var69[var14][var13] >> 1);
                            Class12.anIntArrayArray146[var14][var13] = var30 - var31;
                        }
                    }

                    for (var13 = 0; var13 < 104; ++var13) {
                        Class44.anIntArray396[var13] = 0;
                        Class46.anIntArray426[var13] = 0;
                        Class44.anIntArray390[var13] = 0;
                        Class199.anIntArray1626[var13] = 0;
                        Class44.anIntArray389[var13] = 0;
                    }

                    for (var13 = -5; var13 < 109; ++var13) {
                        for (var14 = 0; var14 < 104; ++var14) {
                            var15 = var13 + 5;
                            int var10002;
                            if (var15 >= 0 && var15 < 104) {
                                var16 = Class44.aByteArrayArrayArray404[var4][var15][var14] & 255;
                                if (var16 > 0) {
                                    DoublyLinkedNode_Sub20 var48 = AssociateComparatorByWorldAndName.method644(var16 - 1);
                                    var10000 = Class44.anIntArray396;
                                    var10000[var14] += var48.anInt377;
                                    var10000 = Class46.anIntArray426;
                                    var10000[var14] += var48.anInt574;
                                    var10000 = Class44.anIntArray390;
                                    var10000[var14] += var48.anInt112;
                                    var10000 = Class199.anIntArray1626;
                                    var10000[var14] += var48.anInt375;
                                    var10002 = Class44.anIntArray389[var14]++;
                                }
                            }

                            var16 = var13 - 5;
                            if (var16 >= 0 && var16 < 104) {
                                var17 = Class44.aByteArrayArrayArray404[var4][var16][var14] & 255;
                                if (var17 > 0) {
                                    DoublyLinkedNode_Sub20 var72 = AssociateComparatorByWorldAndName.method644(var17 - 1);
                                    var10000 = Class44.anIntArray396;
                                    var10000[var14] -= var72.anInt377;
                                    var10000 = Class46.anIntArray426;
                                    var10000[var14] -= var72.anInt574;
                                    var10000 = Class44.anIntArray390;
                                    var10000[var14] -= var72.anInt112;
                                    var10000 = Class199.anIntArray1626;
                                    var10000[var14] -= var72.anInt375;
                                    var10002 = Class44.anIntArray389[var14]--;
                                }
                            }
                        }

                        if (var13 >= 1 && var13 < 103) {
                            var14 = 0;
                            var15 = 0;
                            var16 = 0;
                            var17 = 0;
                            var18 = 0;

                            for (var25 = -5; var25 < 109; ++var25) {
                                var26 = var25 + 5;
                                if (var26 >= 0 && var26 < 104) {
                                    var14 += Class44.anIntArray396[var26];
                                    var15 += Class46.anIntArray426[var26];
                                    var16 += Class44.anIntArray390[var26];
                                    var17 += Class199.anIntArray1626[var26];
                                    var18 += Class44.anIntArray389[var26];
                                }

                                var30 = var25 - 5;
                                if (var30 >= 0 && var30 < 104) {
                                    var14 -= Class44.anIntArray396[var30];
                                    var15 -= Class46.anIntArray426[var30];
                                    var16 -= Class44.anIntArray390[var30];
                                    var17 -= Class199.anIntArray1626[var30];
                                    var18 -= Class44.anIntArray389[var30];
                                }

                                if (var25 >= 1 && var25 < 103 && (!client.lowMemory || (Class44.sceneRenderRules[0][var13][var25] & 2) != 0 || (Class44.sceneRenderRules[var4][var13][var25] & 16) == 0)) {
                                    if (var4 < Class44.anInt405) {
                                        Class44.anInt405 = var4;
                                    }

                                    var31 = Class44.aByteArrayArrayArray404[var4][var13][var25] & 255;
                                    int var49 = Class44.aByteArrayArrayArray401[var4][var13][var25] & 255;
                                    if (var31 > 0 || var49 > 0) {
                                        int var33 = Class44.tileHeights[var4][var13][var25];
                                        int var34 = Class44.tileHeights[var4][var13 + 1][var25];
                                        var38 = Class44.tileHeights[var4][var13 + 1][var25 + 1];
                                        var35 = Class44.tileHeights[var4][var13][var25 + 1];
                                        var36 = Class12.anIntArrayArray146[var13][var25];
                                        var37 = Class12.anIntArrayArray146[var13 + 1][var25];
                                        int var50 = Class12.anIntArrayArray146[var13 + 1][var25 + 1];
                                        int var40 = Class12.anIntArrayArray146[var13][var25 + 1];
                                        var41 = -1;
                                        int var42 = -1;
                                        if (var31 > 0) {
                                            var46 = var14 * 256 / var17;
                                            var43 = var15 / var18;
                                            var44 = var16 / var18;
                                            var41 = Class74.method412(var46, var43, var44);
                                            var46 = var46 + Class44.anInt399 & 255;
                                            var44 += Class44.anInt398;
                                            if (var44 < 0) {
                                                var44 = 0;
                                            } else if (var44 > 255) {
                                                var44 = 255;
                                            }

                                            var42 = Class74.method412(var46, var43, var44);
                                        }

                                        DoublyLinkedNode_Sub14 var51;
                                        if (var4 > 0) {
                                            boolean var75 = true;
                                            if (var31 == 0 && Class12.aByteArrayArrayArray141[var4][var13][var25] != 0) {
                                                var75 = false;
                                            }

                                            if (var49 > 0) {
                                                var44 = var49 - 1;
                                                var51 = (DoublyLinkedNode_Sub14) DoublyLinkedNode_Sub14.aReferenceCache385.get((long) var44);
                                                DoublyLinkedNode_Sub14 var52;
                                                if (var51 != null) {
                                                    var52 = var51;
                                                } else {
                                                    byte[] var62 = DoublyLinkedNode_Sub14.aReferenceTable383.unpack(4, var44);
                                                    var51 = new DoublyLinkedNode_Sub14();
                                                    if (var62 != null) {
                                                        var51.method1010(new Buffer(var62));
                                                    }

                                                    var51.method499();
                                                    DoublyLinkedNode_Sub14.aReferenceCache385.put(var51, (long) var44);
                                                    var52 = var51;
                                                }

                                                if (!var52.aBoolean502) {
                                                    var75 = false;
                                                }
                                            }

                                            if (var75 && var33 == var34 && var33 == var38 && var35 == var33) {
                                                var10000 = Class44.anIntArrayArrayArray393[var4][var13];
                                                var10000[var25] |= 2340;
                                            }
                                        }

                                        var46 = 0;
                                        if (var42 != -1) {
                                            var46 = JagGraphics3D.anIntArray782[Enum_Sub4.method848(var42, 96)];
                                        }

                                        if (var49 == 0) {
                                            var63.method1480(var4, var13, var25, 0, 0, -1, var33, var34, var38, var35, Enum_Sub4.method848(var41, var36), Enum_Sub4.method848(var41, var37), Enum_Sub4.method848(var41, var50), Enum_Sub4.method848(var41, var40), 0, 0, 0, 0, var46, 0);
                                        } else {
                                            var43 = Class12.aByteArrayArrayArray141[var4][var13][var25] + 1;
                                            byte var74 = Statics35.aByteArrayArrayArray1615[var4][var13][var25];
                                            int var53 = var49 - 1;
                                            DoublyLinkedNode_Sub14 var54 = (DoublyLinkedNode_Sub14) DoublyLinkedNode_Sub14.aReferenceCache385.get((long) var53);
                                            if (var54 != null) {
                                                var51 = var54;
                                            } else {
                                                byte[] var61 = DoublyLinkedNode_Sub14.aReferenceTable383.unpack(4, var53);
                                                var54 = new DoublyLinkedNode_Sub14();
                                                if (var61 != null) {
                                                    var54.method1010(new Buffer(var61));
                                                }

                                                var54.method499();
                                                DoublyLinkedNode_Sub14.aReferenceCache385.put(var54, (long) var53);
                                                var51 = var54;
                                            }

                                            int var55 = var51.anInt377;
                                            int var56;
                                            int var57;
                                            int var58;
                                            int var59;
                                            if (var55 >= 0) {
                                                var56 = JagGraphics3D.aTextureProvider783.method1424(var55);
                                                var57 = -1;
                                            } else if (var51.anInt378 == 16711935) {
                                                var57 = -2;
                                                var55 = -1;
                                                var56 = -2;
                                            } else {
                                                var57 = Class74.method412(var51.anInt375, var51.anInt372, var51.anInt379);
                                                var58 = var51.anInt375 + Class44.anInt399 & 255;
                                                var59 = var51.anInt379 + Class44.anInt398;
                                                if (var59 < 0) {
                                                    var59 = 0;
                                                } else if (var59 > 255) {
                                                    var59 = 255;
                                                }

                                                var56 = Class74.method412(var58, var51.anInt372, var59);
                                            }

                                            var58 = 0;
                                            if (var56 != -2) {
                                                var58 = JagGraphics3D.anIntArray782[Class25.method187(var56, 96)];
                                            }

                                            if (var51.anInt112 != -1) {
                                                var59 = var51.anInt564 + Class44.anInt399 & 255;
                                                int var60 = var51.anInt367 + Class44.anInt398;
                                                if (var60 < 0) {
                                                    var60 = 0;
                                                } else if (var60 > 255) {
                                                    var60 = 255;
                                                }

                                                var56 = Class74.method412(var59, var51.anInt368, var60);
                                                var58 = JagGraphics3D.anIntArray782[Class25.method187(var56, 96)];
                                            }

                                            var63.method1480(var4, var13, var25, var43, var74, var55, var33, var34, var38, var35, Enum_Sub4.method848(var41, var36), Enum_Sub4.method848(var41, var37), Enum_Sub4.method848(var41, var50), Enum_Sub4.method848(var41, var40), Class25.method187(var57, var36), Class25.method187(var57, var37), Class25.method187(var57, var50), Class25.method187(var57, var40), var46, var58);
                                        }
                                    }
                                }
                            }
                        }
                    }

                    for (var13 = 1; var13 < 103; ++var13) {
                        for (var14 = 1; var14 < 103; ++var14) {
                            var63.method1481(var4, var14, var13, Statics10.method800(var4, var14, var13));
                        }
                    }

                    Class44.aByteArrayArrayArray404[var4] = null;
                    Class44.aByteArrayArrayArray401[var4] = null;
                    Class12.aByteArrayArrayArray141[var4] = null;
                    Statics35.aByteArrayArrayArray1615[var4] = null;
                    Class44.aByteArrayArrayArray400[var4] = null;
                }

                var63.method1450(-50, -10, -50);

                for (var4 = 0; var4 < 104; ++var4) {
                    for (var5 = 0; var5 < 104; ++var5) {
                        if ((Class44.sceneRenderRules[1][var4][var5] & 2) == 2) {
                            var63.method1484(var4, var5);
                        }
                    }
                }

                var4 = 1;
                var5 = 2;
                var10 = 4;

                for (var65 = 0; var65 < 4; ++var65) {
                    if (var65 > 0) {
                        var4 <<= 3;
                        var5 <<= 3;
                        var10 <<= 3;
                    }

                    for (var22 = 0; var22 <= var65; ++var22) {
                        for (var8 = 0; var8 <= 104; ++var8) {
                            for (var9 = 0; var9 <= 104; ++var9) {
                                short var68;
                                if ((Class44.anIntArrayArrayArray393[var22][var9][var8] & var4) != 0) {
                                    var11 = var8;
                                    var66 = var8;
                                    var13 = var22;

                                    for (var14 = var22; var11 > 0 && (Class44.anIntArrayArrayArray393[var22][var9][var11 - 1] & var4) != 0; --var11) {
                                    }

                                    while (var66 < 104 && (Class44.anIntArrayArrayArray393[var22][var9][var66 + 1] & var4) != 0) {
                                        ++var66;
                                    }

                                    label901:
                                    while (var13 > 0) {
                                        for (var15 = var11; var15 <= var66; ++var15) {
                                            if ((Class44.anIntArrayArrayArray393[var13 - 1][var9][var15] & var4) == 0) {
                                                break label901;
                                            }
                                        }

                                        --var13;
                                    }

                                    label890:
                                    while (var14 < var65) {
                                        for (var15 = var11; var15 <= var66; ++var15) {
                                            if ((Class44.anIntArrayArrayArray393[var14 + 1][var9][var15] & var4) == 0) {
                                                break label890;
                                            }
                                        }

                                        ++var14;
                                    }

                                    var15 = (var66 - var11 + 1) * (var14 + 1 - var13);
                                    if (var15 >= 8) {
                                        var68 = 240;
                                        var17 = Class44.tileHeights[var14][var9][var11] - var68;
                                        var18 = Class44.tileHeights[var13][var9][var11];
                                        SceneGraph.method1483(var65, 1, var9 * 128, var9 * 128, var11 * 128, var66 * 128 + 128, var17, var18);

                                        for (var25 = var13; var25 <= var14; ++var25) {
                                            for (var26 = var11; var26 <= var66; ++var26) {
                                                var10000 = Class44.anIntArrayArrayArray393[var25][var9];
                                                var10000[var26] &= ~var4;
                                            }
                                        }
                                    }
                                }

                                if ((Class44.anIntArrayArrayArray393[var22][var9][var8] & var5) != 0) {
                                    var11 = var9;
                                    var66 = var9;
                                    var13 = var22;

                                    for (var14 = var22; var11 > 0 && (Class44.anIntArrayArrayArray393[var22][var11 - 1][var8] & var5) != 0; --var11) {
                                    }

                                    while (var66 < 104 && (Class44.anIntArrayArrayArray393[var22][var66 + 1][var8] & var5) != 0) {
                                        ++var66;
                                    }

                                    label954:
                                    while (var13 > 0) {
                                        for (var15 = var11; var15 <= var66; ++var15) {
                                            if ((Class44.anIntArrayArrayArray393[var13 - 1][var15][var8] & var5) == 0) {
                                                break label954;
                                            }
                                        }

                                        --var13;
                                    }

                                    label943:
                                    while (var14 < var65) {
                                        for (var15 = var11; var15 <= var66; ++var15) {
                                            if ((Class44.anIntArrayArrayArray393[var14 + 1][var15][var8] & var5) == 0) {
                                                break label943;
                                            }
                                        }

                                        ++var14;
                                    }

                                    var15 = (var14 + 1 - var13) * (var66 - var11 + 1);
                                    if (var15 >= 8) {
                                        var68 = 240;
                                        var17 = Class44.tileHeights[var14][var11][var8] - var68;
                                        var18 = Class44.tileHeights[var13][var11][var8];
                                        SceneGraph.method1483(var65, 2, var11 * 128, var66 * 128 + 128, var8 * 128, var8 * 128, var17, var18);

                                        for (var25 = var13; var25 <= var14; ++var25) {
                                            for (var26 = var11; var26 <= var66; ++var26) {
                                                var10000 = Class44.anIntArrayArrayArray393[var25][var26];
                                                var10000[var8] &= ~var5;
                                            }
                                        }
                                    }
                                }

                                if ((Class44.anIntArrayArrayArray393[var22][var9][var8] & var10) != 0) {
                                    var11 = var9;
                                    var66 = var9;
                                    var13 = var8;

                                    for (var14 = var8; var13 > 0 && (Class44.anIntArrayArrayArray393[var22][var9][var13 - 1] & var10) != 0; --var13) {
                                    }

                                    while (var14 < 104 && (Class44.anIntArrayArrayArray393[var22][var9][var14 + 1] & var10) != 0) {
                                        ++var14;
                                    }

                                    label1007:
                                    while (var11 > 0) {
                                        for (var15 = var13; var15 <= var14; ++var15) {
                                            if ((Class44.anIntArrayArrayArray393[var22][var11 - 1][var15] & var10) == 0) {
                                                break label1007;
                                            }
                                        }

                                        --var11;
                                    }

                                    label996:
                                    while (var66 < 104) {
                                        for (var15 = var13; var15 <= var14; ++var15) {
                                            if ((Class44.anIntArrayArrayArray393[var22][var66 + 1][var15] & var10) == 0) {
                                                break label996;
                                            }
                                        }

                                        ++var66;
                                    }

                                    if ((var14 - var13 + 1) * (var66 - var11 + 1) >= 4) {
                                        var15 = Class44.tileHeights[var22][var11][var13];
                                        SceneGraph.method1483(var65, 4, var11 * 128, var66 * 128 + 128, var13 * 128, var14 * 128 + 128, var15, var15);

                                        for (var16 = var11; var16 <= var66; ++var16) {
                                            for (var17 = var13; var17 <= var14; ++var17) {
                                                var10000 = Class44.anIntArrayArrayArray393[var22][var16];
                                                var10000[var17] &= ~var10;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                GrandExchangeOffer.method231(true);
                var4 = Class44.anInt405;
                if (var4 > SceneGraph.floorLevel) {
                    var4 = SceneGraph.floorLevel;
                }

                if (var4 < SceneGraph.floorLevel - 1) {
                    var4 = SceneGraph.floorLevel - 1;
                }

                if (client.lowMemory) {
                    client.sceneGraph.method1478(Class44.anInt405);
                } else {
                    client.sceneGraph.method1478(0);
                }

                for (var5 = 0; var5 < 104; ++var5) {
                    for (var10 = 0; var10 < 104; ++var10) {
                        Class23.refreshPickables(var5, var10);
                    }
                }

                Class26.method190();

                for (PendingSpawn var70 = (PendingSpawn) client.pendingSpawns.head(); var70 != null; var70 = (PendingSpawn) client.pendingSpawns.next()) {
                    if (var70.hitpoints == -1) {
                        var70.delay = 0;
                        Class72.method388(var70);
                    } else {
                        var70.unlink();
                    }
                }

                ObjectDefinition.aReferenceCache1228.method334();
                OutgoingPacket packet;
                if (client.instance.hasFrame()) {
                    packet = OutgoingPacket.prepare(OutgoingPacketMeta.USING_FRAME, client.connectionContext.encryptor);
                    packet.buffer.writeInt(1057001181);
                    client.connectionContext.writeLater(packet);
                }

                if (!client.inInstancedScene) {
                    var5 = (IncomingPacketMeta.anInt206 - 6) / 8;
                    var10 = (IncomingPacketMeta.anInt206 + 6) / 8;
                    var65 = (Node_Sub19.anInt1191 - 6) / 8;
                    var22 = (Node_Sub19.anInt1191 + 6) / 8;

                    for (var8 = var5 - 1; var8 <= var10 + 1; ++var8) {
                        for (var9 = var65 - 1; var9 <= var22 + 1; ++var9) {
                            if (var8 < var5 || var8 > var10 || var9 < var65 || var9 > var22) {
                                Class85.aCacheReferenceTable635.method912("m" + var8 + "_" + var9);
                                Class85.aCacheReferenceTable635.method912("l" + var8 + "_" + var9);
                            }
                        }
                    }
                }

                MouseRecorder.setGameState(30);
                Class26.method190();
                BefriendedPlayer.method555();
                packet = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta56, client.connectionContext.encryptor);
                client.connectionContext.writeLater(packet);
                Class69.method383();
            }
        }
    }

    public static void method103(ReferenceTable var0) {
        InventoryDefinition.table = var0;
    }

    public final synchronized void keyReleased(KeyEvent var1) {
        if (keyboard != null) {
            int var2 = var1.getKeyCode();
            if (var2 >= 0 && var2 < anIntArray159.length) {
                var2 = anIntArray159[var2] & -129;
            } else {
                var2 = -1;
            }

            if (anInt150 >= 0 && var2 >= 0) {
                anIntArray154[anInt150] = ~var2;
                anInt150 = anInt150 + 1 & 127;
                if (anInt150 == anInt155) {
                    anInt150 = -1;
                }
            }
        }

        var1.consume();
    }

    public final void focusGained(FocusEvent var1) {
    }

    public final synchronized void focusLost(FocusEvent var1) {
        if (keyboard != null) {
            anInt150 = -1;
        }

    }

    public final synchronized void keyPressed(KeyEvent var1) {
        if (keyboard != null) {
            int var2 = var1.getKeyCode();
            if (var2 >= 0 && var2 < anIntArray159.length) {
                var2 = anIntArray159[var2];
                if ((var2 & 128) != 0) {
                    var2 = -1;
                }
            } else {
                var2 = -1;
            }

            if (anInt150 >= 0 && var2 >= 0) {
                anIntArray154[anInt150] = var2;
                anInt150 = anInt150 + 1 & 127;
                if (anInt155 == anInt150) {
                    anInt150 = -1;
                }
            }

            int var3;
            if (var2 >= 0) {
                var3 = anInt153 + 1 & 127;
                if (var3 != anInt157) {
                    anIntArray148[anInt153] = var2;
                    aCharArray156[anInt153] = 0;
                    anInt153 = var3;
                }
            }

            var3 = var1.getModifiers();
            if ((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
                var1.consume();
            }
        }

    }

    public final void keyTyped(KeyEvent var1) {
        if (keyboard != null) {
            char var2 = var1.getKeyChar();
            if (var2 != 0 && var2 != '\uffff' && Class45.method278(var2)) {
                int var3 = anInt153 + 1 & 127;
                if (var3 != anInt157) {
                    anIntArray148[anInt153] = -1;
                    aCharArray156[anInt153] = var2;
                    anInt153 = var3;
                }
            }
        }

        var1.consume();
    }
}
