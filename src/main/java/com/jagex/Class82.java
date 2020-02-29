package com.jagex;

import java.math.BigInteger;

public class Class82 {
    static final BigInteger aBigInteger628;
    static final BigInteger aBigInteger626;
    static int anInt627;

    static {
        aBigInteger628 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
        aBigInteger626 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
    }

    public static synchronized void method445(byte[] var0) {
        if (var0.length == 100 && Class204.anInt1641 < 1000) {
            Class204.aByteArrayArray1639[++Class204.anInt1641 - 1] = var0;
        } else if (var0.length == 5000 && Class204.anInt1643 < 250) {
            Class204.aByteArrayArray1638[++Class204.anInt1643 - 1] = var0;
        } else if (var0.length == 30000 && Class204.anInt1640 < 50) {
            Class204.aByteArrayArray1636[++Class204.anInt1640 - 1] = var0;
        } else {
            if (EntityUID.aByteArrayArrayArray547 != null) {
                for (int var1 = 0; var1 < Class204.anIntArray1637.length; ++var1) {
                    if (var0.length == Class204.anIntArray1637[var1] && Class204.anIntArray1642[var1] < EntityUID.aByteArrayArrayArray547[var1].length) {
                        EntityUID.aByteArrayArrayArray547[var1][Class204.anIntArray1642[var1]++] = var0;
                        return;
                    }
                }
            }

        }
    }

    public static void method443() {
        if (Statics25.connection != null) {
            Statics25.connection.stop();
        }

    }

    static void method444(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, SceneGraph var8, CollisionMap[] var9) {
        Buffer var10 = new Buffer(var0);
        int var11 = -1;

        while (true) {
            int var12 = var10.readSmarts();
            if (var12 == 0) {
                return;
            }

            var11 += var12;
            int var13 = 0;

            while (true) {
                int var14 = var10.readSmart();
                if (var14 == 0) {
                    break;
                }

                var13 += var14 - 1;
                int var15 = var13 & 63;
                int var16 = var13 >> 6 & 63;
                int var17 = var13 >> 12;
                int var18 = var10.readUByte();
                int var19 = var18 >> 2;
                int var20 = var18 & 3;
                if (var17 == var4 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < var6 + 8) {
                    ObjectDefinition var21 = Class38.getObjectDefinition(var11);
                    int var23 = var16 & 7;
                    int var24 = var15 & 7;
                    int var26 = var21.sizeX;
                    int var27 = var21.sizeY;
                    int var28;
                    if ((var20 & 1) == 1) {
                        var28 = var26;
                        var26 = var27;
                        var27 = var28;
                    }

                    int var25 = var7 & 3;
                    int var29;
                    if (var25 == 0) {
                        var29 = var23;
                    } else if (var25 == 1) {
                        var29 = var24;
                    } else if (var25 == 2) {
                        var29 = 7 - var23 - (var26 - 1);
                    } else {
                        var29 = 7 - var24 - (var27 - 1);
                    }

                    var28 = var2 + var29;
                    int var31 = var16 & 7;
                    int var32 = var15 & 7;
                    int var34 = var21.sizeX;
                    int var35 = var21.sizeY;
                    int var36;
                    if ((var20 & 1) == 1) {
                        var36 = var34;
                        var34 = var35;
                        var35 = var36;
                    }

                    int var33 = var7 & 3;
                    int var37;
                    if (var33 == 0) {
                        var37 = var32;
                    } else if (var33 == 1) {
                        var37 = 7 - var31 - (var34 - 1);
                    } else if (var33 == 2) {
                        var37 = 7 - var32 - (var35 - 1);
                    } else {
                        var37 = var31;
                    }

                    var36 = var3 + var37;
                    if (var28 > 0 && var36 > 0 && var28 < 103 && var36 < 103) {
                        int var38 = var1;
                        if ((Class44.sceneRenderRules[1][var28][var36] & 2) == 2) {
                            var38 = var1 - 1;
                        }

                        CollisionMap var39 = null;
                        if (var38 >= 0) {
                            var39 = var9[var38];
                        }

                        Class74.method414(var1, var28, var36, var11, var20 + var7 & 3, var19, var8, var39);
                    }
                }
            }
        }
    }
}
