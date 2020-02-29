package com.jagex;

public enum Enum_Sub10 implements EnumType {
    anEnum_Sub10_1767(4, 0),
    anEnum_Sub10_1769(1, 1),
    anEnum_Sub10_1765(8, 2),
    anEnum_Sub10_1764(2, 3),
    anEnum_Sub10_1762(6, 4),
    anEnum_Sub10_1760(5, 5),
    anEnum_Sub10_1761(0, 6),
    anEnum_Sub10_1768(7, 7),
    anEnum_Sub10_1766(3, 8);

    final int anInt1763;
    final int anInt1180;

    Enum_Sub10(int var3, int var4) {
        this.anInt1180 = var3;
        this.anInt1763 = var4;
    }

    static void method1297(PathingEntity entity, int var1, int var2, int var3, int var4, int var5) {
        if (entity != null && entity.method684()) {
            if (entity instanceof NpcEntity) {
                NpcDefinition var6 = ((NpcEntity) entity).definition;
                if (var6.transformIds != null) {
                    var6 = var6.transform();
                }

                if (var6 == null) {
                    return;
                }
            }

            int var7 = GPI.playerCount;
            int[] var8 = GPI.playerIndices;
            byte var9 = 0;
            if (var1 < var7 && entity.anInt1437 == client.engineCycle && Class57.method331((PlayerEntity) entity)) {
                PlayerEntity var10 = (PlayerEntity) entity;
                if (var1 < var7) {
                    World.method1354(entity, entity.anInt2021 + 15);
                    DoublyLinkedNode_Sub24_Sub3 var11 = (DoublyLinkedNode_Sub24_Sub3) client.aHashMap961.get(Class199.aClass199_1625);
                    byte var12 = 9;
                    var11.method1154(var10.namePair.getRaw(), var2 + client.anInt998, var3 + client.anInt993 - var12, 16777215, 0);
                    var9 = 18;
                }
            }

            int var13 = -2;
            int var18;
            int var19;
            int var25;
            int var26;
            if (!entity.healthBars.method662()) {
                World.method1354(entity, entity.anInt2021 + 15);

                for (HealthBar var89 = (HealthBar) entity.healthBars.head(); var89 != null; var89 = (HealthBar) entity.healthBars.method658()) {
                    HitUpdate var14 = var89.method695(client.engineCycle);
                    if (var14 == null) {
                        if (var89.method693()) {
                            var89.unlink();
                        }
                    } else {
                        HealthBarDefinition var15 = var89.definition;
                        Sprite var16 = var15.method1378();
                        Sprite var17 = var15.method1379();
                        var18 = 0;
                        if (var16 != null && var17 != null) {
                            if (var15.anInt702 * 2 < var17.width) {
                                var18 = var15.anInt702;
                            }

                            var19 = var17.width - var18 * 2;
                        } else {
                            var19 = var15.maxWidth;
                        }

                        int var20 = 255;
                        boolean var21 = true;
                        int var22 = client.engineCycle - var14.startCycle;
                        int var23 = var19 * var14.currentWidth / var15.maxWidth;
                        int var24;
                        int var94;
                        if (var14.currentCycle > var22) {
                            var24 = var15.anInt368 == 0 ? 0 : var15.anInt368 * (var22 / var15.anInt368);
                            var25 = var19 * var14.startWidth / var15.maxWidth;
                            var94 = var24 * (var23 - var25) / var14.currentCycle + var25;
                        } else {
                            var94 = var23;
                            var24 = var15.anInt367 + var14.currentCycle - var22;
                            if (var15.anInt564 >= 0) {
                                var20 = (var24 << 8) / (var15.anInt367 - var15.anInt564);
                            }
                        }

                        if (var14.currentWidth > 0 && var94 < 1) {
                            var94 = 1;
                        }

                        if (var16 != null && var17 != null) {
                            if (var19 == var94) {
                                var94 += var18 * 2;
                            } else {
                                var94 += var18;
                            }

                            var24 = var16.height;
                            var13 += var24;
                            var25 = var2 + client.anInt998 - (var19 >> 1);
                            var26 = var3 + client.anInt993 - var13;
                            var25 -= var18;
                            if (var20 >= 0 && var20 < 255) {
                                var16.method832(var25, var26, var20);
                                JagGraphics.method1364(var25, var26, var25 + var94, var26 + var24);
                                var17.method832(var25, var26, var20);
                            } else {
                                var16.method809(var25, var26);
                                JagGraphics.method1364(var25, var26, var94 + var25, var26 + var24);
                                var17.method809(var25, var26);
                            }

                            JagGraphics.setClip(var2, var3, var2 + var4, var3 + var5);
                            var13 += 2;
                        } else {
                            var13 += 5;
                            if (client.anInt998 > -1) {
                                var24 = var2 + client.anInt998 - (var19 >> 1);
                                var25 = var3 + client.anInt993 - var13;
                                JagGraphics.fillRect(var24, var25, var94, 5, 65280);
                                JagGraphics.fillRect(var24 + var94, var25, var19 - var94, 5, 16711680);
                            }

                            var13 += 2;
                        }
                    }
                }
            }

            if (var13 == -2) {
                var13 += 7;
            }

            var13 += var9;
            if (var1 < var7) {
                PlayerEntity player = (PlayerEntity) entity;
                if (player.hidden) {
                    return;
                }

                if (player.prayerIcon != -1 || player.skullIcon != -1) {
                    World.method1354(entity, entity.anInt2021 + 15);
                    if (client.anInt998 > -1) {
                        if (player.prayerIcon != -1) {
                            var13 += 25;
                            DoublyLinkedNode_Sub17.prayerIconSprites[player.prayerIcon].method809(var2 + client.anInt998 - 12, var3 + client.anInt993 - var13);
                        }

                        if (player.skullIcon != -1) {
                            var13 += 25;
                            Class7.skullIconSprites[player.skullIcon].method809(var2 + client.anInt998 - 12, var3 + client.anInt993 - var13);
                        }
                    }
                }

                if (var1 >= 0 && client.hintArrowType == 10 && var8[var1] == client.hintArrowPlayerIndex) {
                    World.method1354(entity, entity.anInt2021 + 15);
                    if (client.anInt998 > -1) {
                        var13 += ClassStructure.hitmarks[1].height;
                        ClassStructure.hitmarks[1].method809(var2 + client.anInt998 - 12, var3 + client.anInt993 - var13);
                    }
                }
            } else {
                NpcDefinition var91 = ((NpcEntity) entity).definition;
                if (var91.transformIds != null) {
                    var91 = var91.transform();
                }

                if (var91.prayerIcon >= 0 && var91.prayerIcon < Class7.skullIconSprites.length) {
                    World.method1354(entity, entity.anInt2021 + 15);
                    if (client.anInt998 > -1) {
                        Class7.skullIconSprites[var91.prayerIcon].method809(var2 + client.anInt998 - 12, var3 + client.anInt993 - 30);
                    }
                }

                if (client.hintArrowType == 1 && client.npcIndices[var1 - var7] == client.hintArrowNpcIndex && client.engineCycle % 20 < 10) {
                    World.method1354(entity, entity.anInt2021 + 15);
                    if (client.anInt998 > -1) {
                        ClassStructure.hitmarks[0].method809(var2 + client.anInt998 - 12, var3 + client.anInt993 - 28);
                    }
                }
            }

            if (entity.overheadText != null && (var1 >= var7 || !entity.aBoolean2005 && (client.publicChatMode == 4 || !entity.aBoolean2008 && (client.publicChatMode == 0 || client.publicChatMode == 3 || client.publicChatMode == 1 && ((PlayerEntity) entity).method609())))) {
                World.method1354(entity, entity.anInt2021);
                if (client.anInt998 > -1 && client.anInt1000 < client.anInt1010) {
                    client.anIntArray994[client.anInt1000] = Statics7.aFont863.method1145(entity.overheadText) / 2;
                    client.anIntArray1012[client.anInt1000] = Statics7.aFont863.anInt375;
                    client.anIntArray1013[client.anInt1000] = client.anInt998;
                    client.anIntArray1005[client.anInt1000] = client.anInt993;
                    client.anIntArray995[client.anInt1000] = entity.anInt1508;
                    client.anIntArray1007[client.anInt1000] = entity.anInt1510;
                    client.anIntArray991[client.anInt1000] = entity.anInt1344;
                    client.aStringArray1011[client.anInt1000] = entity.overheadText;
                    ++client.anInt1000;
                }
            }

            for (int var27 = 0; var27 < 4; ++var27) {
                int var92 = entity.hitsplatCycles[var27];
                int var28 = entity.hitsplatTypes[var27];
                HitsplatDefinition var93 = null;
                int var29 = 0;
                HitsplatDefinition var30;
                if (var28 >= 0) {
                    if (var92 <= client.engineCycle) {
                        continue;
                    }

                    var18 = entity.hitsplatTypes[var27];
                    var30 = (HitsplatDefinition) HitsplatDefinition.cache.get((long) var18);
                    HitsplatDefinition var31;
                    if (var30 != null) {
                        var31 = var30;
                    } else {
                        byte[] var32 = HitsplatDefinition.table.unpack(32, var18);
                        var30 = new HitsplatDefinition();
                        if (var32 != null) {
                            var30.decode(new Buffer(var32));
                        }

                        HitsplatDefinition.cache.put(var30, (long) var18);
                        var31 = var30;
                    }

                    var93 = var31;
                    var29 = var31.duration;
                    if (var31 != null && var31.transformIds != null) {
                        var93 = var31.method1437();
                        if (var93 == null) {
                            entity.hitsplatCycles[var27] = -1;
                            continue;
                        }
                    }
                } else if (var92 < 0) {
                    continue;
                }

                var19 = entity.hitsplatIds[var27];
                HitsplatDefinition var33 = null;
                HitsplatDefinition var95;
                if (var19 >= 0) {
                    var95 = (HitsplatDefinition) HitsplatDefinition.cache.get((long) var19);
                    if (var95 != null) {
                        var30 = var95;
                    } else {
                        byte[] var34 = HitsplatDefinition.table.unpack(32, var19);
                        var95 = new HitsplatDefinition();
                        if (var34 != null) {
                            var95.decode(new Buffer(var34));
                        }

                        HitsplatDefinition.cache.put(var95, (long) var19);
                        var30 = var95;
                    }

                    var33 = var30;
                    if (var30 != null && var30.transformIds != null) {
                        var33 = var30.method1437();
                    }
                }

                if (var92 - var29 <= client.engineCycle) {
                    if (var93 == null) {
                        entity.hitsplatCycles[var27] = -1;
                    } else {
                        World.method1354(entity, entity.anInt2021 / 2);
                        if (client.anInt998 > -1) {
                            if (var27 == 1) {
                                client.anInt993 -= 20;
                            }

                            if (var27 == 2) {
                                client.anInt998 -= 15;
                                client.anInt993 -= 10;
                            }

                            if (var27 == 3) {
                                client.anInt998 += 15;
                                client.anInt993 -= 10;
                            }

                            var95 = null;
                            Sprite var97 = null;
                            Sprite var35 = null;
                            Sprite var36 = null;
                            var25 = 0;
                            var26 = 0;
                            int var37 = 0;
                            int var38 = 0;
                            int var39 = 0;
                            int var40 = 0;
                            int var41 = 0;
                            int var42 = 0;
                            Sprite var43 = null;
                            Sprite var44 = null;
                            Sprite var45 = null;
                            Sprite var46 = null;
                            int var47 = 0;
                            int var48 = 0;
                            int var49 = 0;
                            int var50 = 0;
                            int var51 = 0;
                            int var52 = 0;
                            int var53 = 0;
                            int var54 = 0;
                            int var55 = 0;
                            Sprite var96 = var93.getIcon();
                            int var56;
                            if (var96 != null) {
                                var25 = var96.width;
                                var56 = var96.height;
                                if (var56 > var55) {
                                    var55 = var56;
                                }

                                var39 = var96.anInt377;
                            }

                            var97 = var93.getMiddleSprite();
                            if (var97 != null) {
                                var26 = var97.width;
                                var56 = var97.height;
                                if (var56 > var55) {
                                    var55 = var56;
                                }

                                var40 = var97.anInt377;
                            }

                            var35 = var93.getLeftSprite();
                            if (var35 != null) {
                                var37 = var35.width;
                                var56 = var35.height;
                                if (var56 > var55) {
                                    var55 = var56;
                                }

                                var41 = var35.anInt377;
                            }

                            var36 = var93.getRightSprite();
                            if (var36 != null) {
                                var38 = var36.width;
                                var56 = var36.height;
                                if (var56 > var55) {
                                    var55 = var56;
                                }

                                var42 = var36.anInt377;
                            }

                            if (var33 != null) {
                                var43 = var33.getIcon();
                                if (var43 != null) {
                                    var47 = var43.width;
                                    var56 = var43.height;
                                    if (var56 > var55) {
                                        var55 = var56;
                                    }

                                    var51 = var43.anInt377;
                                }

                                var44 = var33.getMiddleSprite();
                                if (var44 != null) {
                                    var48 = var44.width;
                                    var56 = var44.height;
                                    if (var56 > var55) {
                                        var55 = var56;
                                    }

                                    var52 = var44.anInt377;
                                }

                                var45 = var33.getLeftSprite();
                                if (var45 != null) {
                                    var49 = var45.width;
                                    var56 = var45.height;
                                    if (var56 > var55) {
                                        var55 = var56;
                                    }

                                    var53 = var45.anInt377;
                                }

                                var46 = var33.getRightSprite();
                                if (var46 != null) {
                                    var50 = var46.width;
                                    var56 = var46.height;
                                    if (var56 > var55) {
                                        var55 = var56;
                                    }

                                    var54 = var46.anInt377;
                                }
                            }

                            Font var57 = var93.method1438();
                            if (var57 == null) {
                                var57 = Class38.aFont345;
                            }

                            Font var58;
                            if (var33 != null) {
                                var58 = var33.method1438();
                                if (var58 == null) {
                                    var58 = Class38.aFont345;
                                }
                            } else {
                                var58 = Class38.aFont345;
                            }

                            String var59 = null;
                            String var60 = null;
                            boolean var61 = false;
                            int var62 = 0;
                            var59 = var93.method1436(entity.hitsplats[var27]);
                            int var98 = var57.method1145(var59);
                            if (var33 != null) {
                                var60 = var33.method1436(entity.specialHitsplats[var27]);
                                var62 = var58.method1145(var60);
                            }

                            int var63 = 0;
                            int var64 = 0;
                            if (var26 > 0) {
                                if (var35 == null && var36 == null) {
                                    var63 = 1;
                                } else {
                                    var63 = var98 / var26 + 1;
                                }
                            }

                            if (var33 != null && var48 > 0) {
                                if (var45 == null && var46 == null) {
                                    var64 = 1;
                                } else {
                                    var64 = var62 / var48 + 1;
                                }
                            }

                            int var65 = 0;
                            int var66 = var65;
                            if (var25 > 0) {
                                var65 += var25;
                            }

                            var65 += 2;
                            int var67 = var65;
                            if (var37 > 0) {
                                var65 += var37;
                            }

                            int var68 = var65;
                            int var69 = var65;
                            int var70;
                            if (var26 > 0) {
                                var70 = var26 * var63;
                                var65 += var70;
                                var69 += (var70 - var98) / 2;
                            } else {
                                var65 += var98;
                            }

                            var70 = var65;
                            if (var38 > 0) {
                                var65 += var38;
                            }

                            int var71 = 0;
                            int var72 = 0;
                            int var73 = 0;
                            int var74 = 0;
                            int var75 = 0;
                            int var76;
                            if (var33 != null) {
                                var65 += 2;
                                var71 = var65;
                                if (var47 > 0) {
                                    var65 += var47;
                                }

                                var65 += 2;
                                var72 = var65;
                                if (var49 > 0) {
                                    var65 += var49;
                                }

                                var73 = var65;
                                var75 = var65;
                                if (var48 > 0) {
                                    var76 = var48 * var64;
                                    var65 += var76;
                                    var75 += (var76 - var62) / 2;
                                } else {
                                    var65 += var62;
                                }

                                var74 = var65;
                                if (var50 > 0) {
                                    var65 += var50;
                                }
                            }

                            var76 = entity.hitsplatCycles[var27] - client.engineCycle;
                            int var77 = var93.offsetX - var76 * var93.offsetX / var93.duration;
                            int var78 = var76 * var93.offsetY / var93.duration + -var93.offsetY;
                            int var79 = var77 + (var2 + client.anInt998 - (var65 >> 1));
                            int var80 = var78 + (var3 + client.anInt993 - 12);
                            int var81 = var80;
                            int var82 = var80 + var55;
                            int var83 = var80 + var93.anInt1659 + 15;
                            int var84 = var83 - var57.anInt372;
                            int var85 = var83 + var57.anInt379;
                            if (var84 < var80) {
                                var81 = var84;
                            }

                            if (var85 > var82) {
                                var82 = var85;
                            }

                            int var86 = 0;
                            int var87;
                            int var88;
                            if (var33 != null) {
                                var86 = var80 + var33.anInt1659 + 15;
                                var87 = var86 - var58.anInt372;
                                var88 = var86 + var58.anInt379;
                            }

                            var87 = 255;
                            if (var93.fade >= 0) {
                                var87 = (var76 << 8) / (var93.duration - var93.fade);
                            }

                            if (var87 >= 0 && var87 < 255) {
                                if (var96 != null) {
                                    var96.method832(var79 + var66 - var39, var80, var87);
                                }

                                if (var35 != null) {
                                    var35.method832(var67 + var79 - var41, var80, var87);
                                }

                                if (var97 != null) {
                                    for (var88 = 0; var88 < var63; ++var88) {
                                        var97.method832(var26 * var88 + (var68 + var79 - var40), var80, var87);
                                    }
                                }

                                if (var36 != null) {
                                    var36.method832(var70 + var79 - var42, var80, var87);
                                }

                                var57.method1164(var59, var69 + var79, var83, var93.textColor, 0, var87);
                                if (var33 != null) {
                                    if (var43 != null) {
                                        var43.method832(var71 + var79 - var51, var80, var87);
                                    }

                                    if (var45 != null) {
                                        var45.method832(var72 + var79 - var53, var80, var87);
                                    }

                                    if (var44 != null) {
                                        for (var88 = 0; var88 < var64; ++var88) {
                                            var44.method832(var48 * var88 + (var79 + var73 - var52), var80, var87);
                                        }
                                    }

                                    if (var46 != null) {
                                        var46.method832(var74 + var79 - var54, var80, var87);
                                    }

                                    var58.method1164(var60, var79 + var75, var86, var33.textColor, 0, var87);
                                }
                            } else {
                                if (var96 != null) {
                                    var96.method809(var79 + var66 - var39, var80);
                                }

                                if (var35 != null) {
                                    var35.method809(var79 + var67 - var41, var80);
                                }

                                if (var97 != null) {
                                    for (var88 = 0; var88 < var63; ++var88) {
                                        var97.method809(var88 * var26 + (var68 + var79 - var40), var80);
                                    }
                                }

                                if (var36 != null) {
                                    var36.method809(var70 + var79 - var42, var80);
                                }

                                var57.method1152(var59, var69 + var79, var83, var93.textColor | -16777216, 0);
                                if (var33 != null) {
                                    if (var43 != null) {
                                        var43.method809(var79 + var71 - var51, var80);
                                    }

                                    if (var45 != null) {
                                        var45.method809(var79 + var72 - var53, var80);
                                    }

                                    if (var44 != null) {
                                        for (var88 = 0; var88 < var64; ++var88) {
                                            var44.method809(var88 * var48 + (var73 + var79 - var52), var80);
                                        }
                                    }

                                    if (var46 != null) {
                                        var46.method809(var74 + var79 - var54, var80);
                                    }

                                    var58.method1152(var60, var75 + var79, var86, var33.textColor | -16777216, 0);
                                }
                            }
                        }
                    }
                }
            }

        }
    }

    public int getOrdinal() {
        return this.anInt1763;
    }
}
