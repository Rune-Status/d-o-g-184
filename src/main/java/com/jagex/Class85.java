package com.jagex;

public class Class85 implements EnumType {
    static final Class85 aClass85_637;
    static final Class85 aClass85_638;
    static final Class85 aClass85_634;
    static CacheReferenceTable aCacheReferenceTable635;
    static String aString636;

    static {
        aClass85_637 = new Class85(1, 0, Integer.class, new Class73());
        aClass85_638 = new Class85(0, 1, Long.class, new Class87());
        aClass85_634 = new Class85(2, 2, String.class, new Class80());
    }

    public final Class89 aClass89_632;
    public final int anInt619;
    final int anInt633;
    final Class aClass631;

    Class85(int var1, int var2, Class var3, Class89 var4) {
        this.anInt633 = var1;
        this.anInt619 = var2;
        this.aClass631 = var3;
        this.aClass89_632 = var4;
    }

    public static Class85[] method457() {
        return new Class85[]{aClass85_634, aClass85_638, aClass85_637};
    }

    public static Class85 method452(Class var0) {
        Class85[] var1 = method457();

        for (Class85 var3 : var1) {
            if (var3.aClass631 == var0) {
                return var3;
            }
        }

        return null;
    }

    static void method459(int var0, int var1) {
        Class77 var2 = DefinitionProperty.aClass77_384;
        client.processAction(var2.anInt605, var2.anInt602, var2.anInt604, var2.anInt601, var2.aString600, var0, var1);
        DefinitionProperty.aClass77_384 = null;
    }

    static void method456(int var0, int var1, int var2, int var3) {
        for (Node_Sub2 var4 = (Node_Sub2) Node_Sub2.aNodeDeque373.head(); var4 != null; var4 = (Node_Sub2) Node_Sub2.aNodeDeque373.next()) {
            if (var4.anInt379 != -1 || var4.anIntArray374 != null) {
                int var5 = 0;
                if (var1 > var4.anInt380 * 16384) {
                    var5 += var1 - var4.anInt380 * 16384;
                } else if (var1 < var4.anInt377 * 128) {
                    var5 += var4.anInt377 * 128 - var1;
                }

                if (var2 > var4.anInt375 * 16384) {
                    var5 += var2 - var4.anInt375 * 16384;
                } else if (var2 < var4.anInt112 * 128) {
                    var5 += var4.anInt112 * 128 - var2;
                }

                if (var5 - 64 <= var4.anInt372 && client.anInt897 != 0 && var0 == var4.anInt378) {
                    var5 -= 64;
                    if (var5 < 0) {
                        var5 = 0;
                    }

                    int var6 = (var4.anInt372 - var5) * client.anInt897 / var4.anInt372;
                    if (var4.aClass5_Sub6_Sub2_370 == null) {
                        if (var4.anInt379 >= 0) {
                            AudioEffect var7 = AudioEffect.load(Class74.aCacheReferenceTable586, var4.anInt379, 0);
                            if (var7 != null) {
                                Node_Sub10_Sub1 var8 = var7.method1523().method349(Class49.aClass98_446);
                                Node_Sub6_Sub2 var9 = Node_Sub6_Sub2.method598(var8, 100, var6);
                                var9.method585(-1);
                                Class65.aClass5_Sub6_Sub1_528.method312(var9);
                                var4.aClass5_Sub6_Sub2_370 = var9;
                            }
                        }
                    } else {
                        var4.aClass5_Sub6_Sub2_370.method302(var6);
                    }

                    if (var4.aClass5_Sub6_Sub2_369 == null) {
                        if (var4.anIntArray374 != null && (var4.anInt366 -= var3) <= 0) {
                            int var10 = (int) (Math.random() * (double) var4.anIntArray374.length);
                            AudioEffect var12 = AudioEffect.load(Class74.aCacheReferenceTable586, var4.anIntArray374[var10], 0);
                            if (var12 != null) {
                                Node_Sub10_Sub1 var13 = var12.method1523().method349(Class49.aClass98_446);
                                Node_Sub6_Sub2 var11 = Node_Sub6_Sub2.method598(var13, 100, var6);
                                var11.method585(0);
                                Class65.aClass5_Sub6_Sub1_528.method312(var11);
                                var4.aClass5_Sub6_Sub2_369 = var11;
                                var4.anInt366 = var4.anInt368 + (int) (Math.random() * (double) (var4.anInt367 - var4.anInt368));
                            }
                        }
                    } else {
                        var4.aClass5_Sub6_Sub2_369.method302(var6);
                        if (!var4.aClass5_Sub6_Sub2_369.isLinked()) {
                            var4.aClass5_Sub6_Sub2_369 = null;
                        }
                    }
                } else {
                    if (var4.aClass5_Sub6_Sub2_370 != null) {
                        Class65.aClass5_Sub6_Sub1_528.method306(var4.aClass5_Sub6_Sub2_370);
                        var4.aClass5_Sub6_Sub2_370 = null;
                    }

                    if (var4.aClass5_Sub6_Sub2_369 != null) {
                        Class65.aClass5_Sub6_Sub1_528.method306(var4.aClass5_Sub6_Sub2_369);
                        var4.aClass5_Sub6_Sub2_369 = null;
                    }
                }
            }
        }

    }

    static void method453() {
        Class7.aClass112_118.method665();
    }

    static RuneScript method455(byte[] var0) {
        RuneScript var1 = new RuneScript();
        Buffer var2 = new Buffer(var0);
        var2.caret = var2.payload.length - 2;
        int var3 = var2.readUShort();
        int var4 = var2.payload.length - 2 - var3 - 12;
        var2.caret = var4;
        int var5 = var2.readInt();
        var1.anInt574 = var2.readUShort();
        var1.anInt112 = var2.readUShort();
        var1.anInt375 = var2.readUShort();
        var1.anInt372 = var2.readUShort();
        int var6 = var2.readUByte();
        int var7;
        int var8;
        if (var6 > 0) {
            var1.aIterableNodeTableArray1646 = var1.method1189(var6);

            for (var7 = 0; var7 < var6; ++var7) {
                var8 = var2.readUShort();
                IterableNodeTable var9 = new IterableNodeTable(var8 > 0 ? Class180.nextPowerOfTwo(var8) : 1);
                var1.aIterableNodeTableArray1646[var7] = var9;

                while (var8-- > 0) {
                    int var10 = var2.readInt();
                    int var11 = var2.readInt();
                    var9.method237(new IntegerNode(var11), (long) var10);
                }
            }
        }

        var2.caret = 0;
        var2.readCheckedString();
        var1.anIntArray1574 = new int[var5];
        var1.anIntArray749 = new int[var5];
        var1.aStringArray1645 = new String[var5];

        for (var7 = 0; var2.caret < var4; var1.anIntArray1574[var7++] = var8) {
            var8 = var2.readUShort();
            if (var8 == 3) {
                var1.aStringArray1645[var7] = var2.readString();
            } else if (var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
                var1.anIntArray749[var7] = var2.readInt();
            } else {
                var1.anIntArray749[var7] = var2.readUByte();
            }
        }

        return var1;
    }

    static void method450() {
        Class55.loginState = 24;
        Enum_Sub6.setLoginMessages("The game servers are currently being updated.", "Please wait a few minutes and try again.", "");
    }

    static void method451(int var0, int var1, int var2, int var3, int var4, int var5, int var6, SceneGraph var7, CollisionMap var8) {
        ObjectDefinition var9 = Class38.getObjectDefinition(var4);
        int var10;
        int var11;
        if (var5 != 1 && var5 != 3) {
            var10 = var9.sizeX;
            var11 = var9.sizeY;
        } else {
            var10 = var9.sizeY;
            var11 = var9.sizeX;
        }

        int var12;
        int var13;
        if (var10 + var2 <= 104) {
            var12 = (var10 >> 1) + var2;
            var13 = var2 + (var10 + 1 >> 1);
        } else {
            var12 = var2;
            var13 = var2 + 1;
        }

        int var14;
        int var15;
        if (var3 + var11 <= 104) {
            var14 = var3 + (var11 >> 1);
            var15 = var3 + (var11 + 1 >> 1);
        } else {
            var14 = var3;
            var15 = var3 + 1;
        }

        int[][] var16 = Class44.tileHeights[var1];
        int var17 = var16[var13][var15] + var16[var12][var14] + var16[var13][var14] + var16[var12][var15] >> 2;
        int var18 = (var2 << 7) + (var10 << 6);
        int var19 = (var3 << 7) + (var11 << 6);
        long var20 = EntityUID.build(var2, var3, 2, var9.mapDoorFlag == 0, var4);
        int var22 = (var5 << 6) + var6;
        if (var9.itemSupport == 1) {
            var22 += 256;
        }

        Entity var23;
        if (var6 == 22) {
            if (var9.animation == -1 && var9.transformIds == null) {
                var23 = var9.method1103(22, var5, var16, var18, var17, var19);
            } else {
                var23 = new DynamicObject(var4, 22, var5, var1, var2, var3, var9.animation, true, null);
            }

            var7.addTileDecor(var0, var2, var3, var17, var23, var20, var22);
            if (var9.anInt791 == 1) {
                var8.method158(var2, var3);
            }

        } else if (var6 != 10 && var6 != 11) {
            if (var6 >= 12) {
                if (var9.animation == -1 && var9.transformIds == null) {
                    var23 = var9.method1103(var6, var5, var16, var18, var17, var19);
                } else {
                    var23 = new DynamicObject(var4, var6, var5, var1, var2, var3, var9.animation, true, null);
                }

                var7.method1470(var0, var2, var3, var17, 1, 1, var23, 0, var20, var22);
                if (var9.anInt791 != 0) {
                    var8.method160(var2, var3, var10, var11, var9.impenetrable);
                }

            } else if (var6 == 0) {
                if (var9.animation == -1 && var9.transformIds == null) {
                    var23 = var9.method1103(0, var5, var16, var18, var17, var19);
                } else {
                    var23 = new DynamicObject(var4, 0, var5, var1, var2, var3, var9.animation, true, null);
                }

                var7.addBoundary(var0, var2, var3, var17, var23, null, Class44.anIntArray406[var5], 0, var20, var22);
                if (var9.anInt791 != 0) {
                    var8.method154(var2, var3, var6, var5, var9.impenetrable);
                }

            } else if (var6 == 1) {
                if (var9.animation == -1 && var9.transformIds == null) {
                    var23 = var9.method1103(1, var5, var16, var18, var17, var19);
                } else {
                    var23 = new DynamicObject(var4, 1, var5, var1, var2, var3, var9.animation, true, null);
                }

                var7.addBoundary(var0, var2, var3, var17, var23, null, Class44.anIntArray395[var5], 0, var20, var22);
                if (var9.anInt791 != 0) {
                    var8.method154(var2, var3, var6, var5, var9.impenetrable);
                }

            } else {
                int var24;
                if (var6 == 2) {
                    var24 = var5 + 1 & 3;
                    Entity var25;
                    Entity var26;
                    if (var9.animation == -1 && var9.transformIds == null) {
                        var25 = var9.method1103(2, var5 + 4, var16, var18, var17, var19);
                        var26 = var9.method1103(2, var24, var16, var18, var17, var19);
                    } else {
                        var25 = new DynamicObject(var4, 2, var5 + 4, var1, var2, var3, var9.animation, true, null);
                        var26 = new DynamicObject(var4, 2, var24, var1, var2, var3, var9.animation, true, null);
                    }

                    var7.addBoundary(var0, var2, var3, var17, var25, var26, Class44.anIntArray406[var5], Class44.anIntArray406[var24], var20, var22);
                    if (var9.anInt791 != 0) {
                        var8.method154(var2, var3, var6, var5, var9.impenetrable);
                    }

                } else if (var6 == 3) {
                    if (var9.animation == -1 && var9.transformIds == null) {
                        var23 = var9.method1103(3, var5, var16, var18, var17, var19);
                    } else {
                        var23 = new DynamicObject(var4, 3, var5, var1, var2, var3, var9.animation, true, null);
                    }

                    var7.addBoundary(var0, var2, var3, var17, var23, null, Class44.anIntArray395[var5], 0, var20, var22);
                    if (var9.anInt791 != 0) {
                        var8.method154(var2, var3, var6, var5, var9.impenetrable);
                    }

                } else if (var6 == 9) {
                    if (var9.animation == -1 && var9.transformIds == null) {
                        var23 = var9.method1103(var6, var5, var16, var18, var17, var19);
                    } else {
                        var23 = new DynamicObject(var4, var6, var5, var1, var2, var3, var9.animation, true, null);
                    }

                    var7.method1470(var0, var2, var3, var17, 1, 1, var23, 0, var20, var22);
                    if (var9.anInt791 != 0) {
                        var8.method160(var2, var3, var10, var11, var9.impenetrable);
                    }

                } else if (var6 == 4) {
                    if (var9.animation == -1 && var9.transformIds == null) {
                        var23 = var9.method1103(4, var5, var16, var18, var17, var19);
                    } else {
                        var23 = new DynamicObject(var4, 4, var5, var1, var2, var3, var9.animation, true, null);
                    }

                    var7.addBoundaryDecor(var0, var2, var3, var17, var23, null, Class44.anIntArray406[var5], 0, 0, 0, var20, var22);
                } else {
                    long var27;
                    Entity var29;
                    if (var6 == 5) {
                        var24 = 16;
                        var27 = var7.method1456(var0, var2, var3);
                        if (var27 != 0L) {
                            var24 = Class38.getObjectDefinition(EntityUID.getObjectId(var27)).anInt1369;
                        }

                        if (var9.animation == -1 && var9.transformIds == null) {
                            var29 = var9.method1103(4, var5, var16, var18, var17, var19);
                        } else {
                            var29 = new DynamicObject(var4, 4, var5, var1, var2, var3, var9.animation, true, null);
                        }

                        var7.addBoundaryDecor(var0, var2, var3, var17, var29, null, Class44.anIntArray406[var5], 0, var24 * Class44.anIntArray402[var5], var24 * Class44.anIntArray394[var5], var20, var22);
                    } else if (var6 == 6) {
                        var24 = 8;
                        var27 = var7.method1456(var0, var2, var3);
                        if (var27 != 0L) {
                            var24 = Class38.getObjectDefinition(EntityUID.getObjectId(var27)).anInt1369 / 2;
                        }

                        if (var9.animation == -1 && var9.transformIds == null) {
                            var29 = var9.method1103(4, var5 + 4, var16, var18, var17, var19);
                        } else {
                            var29 = new DynamicObject(var4, 4, var5 + 4, var1, var2, var3, var9.animation, true, null);
                        }

                        var7.addBoundaryDecor(var0, var2, var3, var17, var29, null, 256, var5, var24 * Class44.anIntArray397[var5], var24 * Class44.anIntArray392[var5], var20, var22);
                    } else if (var6 == 7) {
                        int var30 = var5 + 2 & 3;
                        if (var9.animation == -1 && var9.transformIds == null) {
                            var23 = var9.method1103(4, var30 + 4, var16, var18, var17, var19);
                        } else {
                            var23 = new DynamicObject(var4, 4, var30 + 4, var1, var2, var3, var9.animation, true, null);
                        }

                        var7.addBoundaryDecor(var0, var2, var3, var17, var23, null, 256, var30, 0, 0, var20, var22);
                    } else if (var6 == 8) {
                        var24 = 8;
                        var27 = var7.method1456(var0, var2, var3);
                        if (var27 != 0L) {
                            var24 = Class38.getObjectDefinition(EntityUID.getObjectId(var27)).anInt1369 / 2;
                        }

                        int var31 = var5 + 2 & 3;
                        Entity var32;
                        if (var9.animation == -1 && var9.transformIds == null) {
                            var29 = var9.method1103(4, var5 + 4, var16, var18, var17, var19);
                            var32 = var9.method1103(4, var31 + 4, var16, var18, var17, var19);
                        } else {
                            var29 = new DynamicObject(var4, 4, var5 + 4, var1, var2, var3, var9.animation, true, null);
                            var32 = new DynamicObject(var4, 4, var31 + 4, var1, var2, var3, var9.animation, true, null);
                        }

                        var7.addBoundaryDecor(var0, var2, var3, var17, var29, var32, 256, var5, var24 * Class44.anIntArray397[var5], var24 * Class44.anIntArray392[var5], var20, var22);
                    }
                }
            }
        } else {
            if (var9.animation == -1 && var9.transformIds == null) {
                var23 = var9.method1103(10, var5, var16, var18, var17, var19);
            } else {
                var23 = new DynamicObject(var4, 10, var5, var1, var2, var3, var9.animation, true, null);
            }

            if (var23 != null) {
                var7.method1470(var0, var2, var3, var17, var10, var11, var23, var6 == 11 ? 256 : 0, var20, var22);
            }

            if (var9.anInt791 != 0) {
                var8.method160(var2, var3, var10, var11, var9.impenetrable);
            }

        }
    }

    public static String method458(byte[] var0, int var1, int var2) {
        StringBuilder var3 = new StringBuilder();

        for (int var4 = var1; var4 < var2 + var1; var4 += 3) {
            int var5 = var0[var4] & 255;
            var3.append(Statics37.aCharArray1634[var5 >>> 2]);
            if (var4 < var2 - 1) {
                int var6 = var0[var4 + 1] & 255;
                var3.append(Statics37.aCharArray1634[(var5 & 3) << 4 | var6 >>> 4]);
                if (var4 < var2 - 2) {
                    int var7 = var0[var4 + 2] & 255;
                    var3.append(Statics37.aCharArray1634[(var6 & 15) << 2 | var7 >>> 6]).append(Statics37.aCharArray1634[var7 & 63]);
                } else {
                    var3.append(Statics37.aCharArray1634[(var6 & 15) << 2]).append("=");
                }
            } else {
                var3.append(Statics37.aCharArray1634[(var5 & 3) << 4]).append("==");
            }
        }

        return var3.toString();
    }

    public int getOrdinal() {
        return this.anInt619;
    }

    public Object method454(Buffer var1) {
        return this.aClass89_632.method410(var1);
    }
}
