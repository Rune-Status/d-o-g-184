package jag.game.scene.entity;

import jag.graphics.NamedFont;
import jag.commons.collection.LinkedList;
import jag.game.*;
import jag.game.stockmarket.StockMarketOfferPriceComparator;
import jag.game.stockmarket.StockMarketOfferWorldComparator;
import jag.game.type.*;
import jag.graphics.BaseFont;
import jag.graphics.Font;
import jag.graphics.JagGraphics;
import jag.graphics.Sprite;
import jag.opcode.Buffer;
import jag.opcode.ClassStructure;
import jag.opcode.GPI;
import jag.statics.Statics7;
import jag.worldmap.WorldMapChunkDefinition;

public abstract class PathingEntity extends Entity {

    public final int[] pathXQueue;
    public final int[] hitsplatCycles;
    public final int[] pathYQueue;
    public final LinkedList healthBars;
    public final int[] hitsplats;
    public final byte[] pathQueueTraversed;
    public final int[] hitsplatTypes;
    public final int[] hitsplatIds;
    public final int[] specialHitsplats;
    public int animation;
    public int pathQueueSize;
    public int transformedOrientation;
    public boolean stretch;
    public int anInt2023;
    public int anInt2022;
    public int animationDelay;
    public int stance;
    public int boundSize;
    public int walkingStance;
    public int animationFrame;
    public int anInt709;
    public int stanceFrame;
    public byte hitsplatCount;
    public int anInt1424;
    public int anInt710;
    public int anInt2006;
    public int fineX;
    public int anInt1857;
    public int anInt1858;
    public int anInt2007;
    public int anInt2021;
    public int fineY;
    public String overheadText;
    public int graphic;
    public boolean aBoolean2005;
    public int graphicFrame;
    public int anInt1344;
    public int anInt1508;
    public int anInt1510;
    public int anInt2024;
    public int anInt2014;
    public int targetIndex;
    public int animationFrameCycle;
    public int anInt2010;
    public boolean aBoolean2015;
    public int orientation;
    public int anInt1436;
    public int anInt2009;
    public int anInt2020;
    public int anInt2013;
    public int graphicDelay;
    public int anInt2018;
    public int renderCycle;
    public int forceMovementStartCycle;
    public int forceMovementEndCycle;
    public int anInt1354;
    public int anInt2011;
    public int anInt1351;
    public int anInt2016;
    public int anInt2019;
    public boolean aBoolean2008;

    public PathingEntity() {
        this.stretch = false;
        this.boundSize = -1;
        this.walkingStance = -1;
        this.anInt709 = -1;
        this.anInt1424 = -1;
        this.anInt710 = -1;
        this.anInt2006 = -1;
        this.anInt1857 = -1;
        this.anInt1858 = -1;
        this.anInt2007 = -1;
        this.overheadText = null;
        this.aBoolean2005 = false;
        this.anInt1344 = 100;
        this.anInt1508 = 0;
        this.anInt1510 = 0;
        this.hitsplatCount = 0;
        this.hitsplatTypes = new int[4];
        this.hitsplats = new int[4];
        this.hitsplatCycles = new int[4];
        this.hitsplatIds = new int[4];
        this.specialHitsplats = new int[4];
        this.healthBars = new LinkedList();
        this.targetIndex = -1;
        this.aBoolean2015 = false;
        this.transformedOrientation = -1;
        this.stance = -1;
        this.stanceFrame = 0;
        this.anInt2009 = 0;
        this.animation = -1;
        this.animationFrame = 0;
        this.animationFrameCycle = 0;
        this.animationDelay = 0;
        this.anInt2010 = 0;
        this.graphic = -1;
        this.graphicFrame = 0;
        this.anInt2013 = 0;
        this.anInt2024 = 0;
        this.anInt2021 = 200;
        this.anInt2018 = 0;
        this.anInt2020 = 32;
        this.pathQueueSize = 0;
        this.pathXQueue = new int[10];
        this.pathYQueue = new int[10];
        this.pathQueueTraversed = new byte[10];
        this.anInt2022 = 0;
        this.anInt2023 = 0;
    }

    public static void method1320(PathingEntity var0) {
        AnimationSequence var2;
        int var3;
        int var5;
        int var6;
        if (var0.forceMovementStartCycle > client.engineCycle) {
            method841(var0);
        } else if (var0.forceMovementEndCycle >= client.engineCycle) {
            HealthBar.method694(var0);
        } else {
            var0.stance = var0.walkingStance;
            if (var0.pathQueueSize == 0) {
                var0.anInt2022 = 0;
            } else {
                label548:
                {
                    if (var0.animation != -1 && var0.animationDelay == 0) {
                        var2 = AnimationSequence.get(var0.animation);
                        if (var0.anInt2023 > 0 && var2.animatingPrecedence == 0) {
                            ++var0.anInt2022;
                            break label548;
                        }

                        if (var0.anInt2023 <= 0 && var2.walkingPrecedence == 0) {
                            ++var0.anInt2022;
                            break label548;
                        }
                    }

                    var3 = var0.fineX;
                    var5 = var0.fineY;
                    var6 = var0.pathXQueue[var0.pathQueueSize - 1] * 128 + var0.boundSize;
                    int var7 = var0.pathYQueue[var0.pathQueueSize - 1] * 128 + var0.boundSize;
                    if (var3 < var6) {
                        if (var5 < var7) {
                            var0.orientation = 1280;
                        } else if (var5 > var7) {
                            var0.orientation = 1792;
                        } else {
                            var0.orientation = 1536;
                        }
                    } else if (var3 > var6) {
                        if (var5 < var7) {
                            var0.orientation = 768;
                        } else if (var5 > var7) {
                            var0.orientation = 256;
                        } else {
                            var0.orientation = 512;
                        }
                    } else if (var5 < var7) {
                        var0.orientation = 1024;
                    } else if (var5 > var7) {
                        var0.orientation = 0;
                    }

                    byte var8 = var0.pathQueueTraversed[var0.pathQueueSize - 1];
                    if (var6 - var3 <= 256 && var6 - var3 >= -256 && var7 - var5 <= 256 && var7 - var5 >= -256) {
                        int var9 = var0.orientation - var0.anInt1436 & 2047;
                        if (var9 > 1024) {
                            var9 -= 2048;
                        }

                        int var10 = var0.anInt2006;
                        if (var9 >= -256 && var9 <= 256) {
                            var10 = var0.anInt710;
                        } else if (var9 >= 256 && var9 < 768) {
                            var10 = var0.anInt1858;
                        } else if (var9 >= -768 && var9 <= -256) {
                            var10 = var0.anInt1857;
                        }

                        if (var10 == -1) {
                            var10 = var0.anInt710;
                        }

                        var0.stance = var10;
                        int var11 = 4;
                        boolean var12 = true;
                        if (var0 instanceof NpcEntity) {
                            var12 = ((NpcEntity) var0).definition.aBoolean699;
                        }

                        if (var12) {
                            if (var0.anInt1436 != var0.orientation && var0.targetIndex == -1 && var0.anInt2020 != 0) {
                                var11 = 2;
                            }

                            if (var0.pathQueueSize > 2) {
                                var11 = 6;
                            }

                            if (var0.pathQueueSize > 3) {
                                var11 = 8;
                            }

                        } else {
                            if (var0.pathQueueSize > 1) {
                                var11 = 6;
                            }

                            if (var0.pathQueueSize > 2) {
                                var11 = 8;
                            }

                        }
                        if (var0.anInt2022 > 0 && var0.pathQueueSize > 1) {
                            var11 = 8;
                            --var0.anInt2022;
                        }

                        if (var8 == 2) {
                            var11 <<= 1;
                        }

                        if (var11 >= 8 && var0.anInt710 == var0.stance && var0.anInt2007 != -1) {
                            var0.stance = var0.anInt2007;
                        }

                        if (var3 != var6 || var5 != var7) {
                            if (var3 < var6) {
                                var0.fineX += var11;
                                if (var0.fineX > var6) {
                                    var0.fineX = var6;
                                }
                            } else if (var3 > var6) {
                                var0.fineX -= var11;
                                if (var0.fineX < var6) {
                                    var0.fineX = var6;
                                }
                            }

                            if (var5 < var7) {
                                var0.fineY += var11;
                                if (var0.fineY > var7) {
                                    var0.fineY = var7;
                                }
                            } else if (var5 > var7) {
                                var0.fineY -= var11;
                                if (var0.fineY < var7) {
                                    var0.fineY = var7;
                                }
                            }
                        }

                        if (var6 == var0.fineX && var7 == var0.fineY) {
                            --var0.pathQueueSize;
                            if (var0.anInt2023 > 0) {
                                --var0.anInt2023;
                            }
                        }
                    } else {
                        var0.fineX = var6;
                        var0.fineY = var7;
                        --var0.pathQueueSize;
                        if (var0.anInt2023 > 0) {
                            --var0.anInt2023;
                        }
                    }
                }
            }
        }

        if (var0.fineX < 128 || var0.fineY < 128 || var0.fineX >= 13184 || var0.fineY >= 13184) {
            var0.animation = -1;
            var0.graphic = -1;
            var0.forceMovementStartCycle = 0;
            var0.forceMovementEndCycle = 0;
            var0.fineX = var0.pathXQueue[0] * 128 + var0.boundSize;
            var0.fineY = var0.boundSize + var0.pathYQueue[0] * 128;
            var0.method1504();
        }

        if (PlayerEntity.local == var0 && (var0.fineX < 1536 || var0.fineY < 1536 || var0.fineX >= 11776 || var0.fineY >= 11776)) {
            var0.animation = -1;
            var0.graphic = -1;
            var0.forceMovementStartCycle = 0;
            var0.forceMovementEndCycle = 0;
            var0.fineX = var0.boundSize + var0.pathXQueue[0] * 128;
            var0.fineY = var0.boundSize + var0.pathYQueue[0] * 128;
            var0.method1504();
        }

        if (var0.anInt2020 != 0) {
            if (var0.targetIndex != -1) {
                PathingEntity var13 = null;
                if (var0.targetIndex < 32768) {
                    var13 = client.npcs[var0.targetIndex];
                } else if (var0.targetIndex >= 32768) {
                    var13 = client.players[var0.targetIndex - 32768];
                }

                if (var13 != null) {
                    var5 = var0.fineX - var13.fineX;
                    var6 = var0.fineY - var13.fineY;
                    if (var5 != 0 || var6 != 0) {
                        var0.orientation = (int) (Math.atan2(var5, var6) * 325.949D) & 2047;
                    }
                } else if (var0.aBoolean2015) {
                    var0.targetIndex = -1;
                    var0.aBoolean2015 = false;
                }
            }

            if (var0.transformedOrientation != -1 && (var0.pathQueueSize == 0 || var0.anInt2022 > 0)) {
                var0.orientation = var0.transformedOrientation;
                var0.transformedOrientation = -1;
            }

            var3 = var0.orientation - var0.anInt1436 & 2047;
            if (var3 == 0 && var0.aBoolean2015) {
                var0.targetIndex = -1;
                var0.aBoolean2015 = false;
            }

            if (var3 != 0) {
                ++var0.anInt2018;
                boolean var14;
                if (var3 > 1024) {
                    var0.anInt1436 -= var0.anInt2020;
                    var14 = true;
                    if (var3 < var0.anInt2020 || var3 > 2048 - var0.anInt2020) {
                        var0.anInt1436 = var0.orientation;
                        var14 = false;
                    }

                    if (var0.walkingStance == var0.stance && (var0.anInt2018 > 25 || var14)) {
                        if (var0.anInt709 != -1) {
                            var0.stance = var0.anInt709;
                        } else {
                            var0.stance = var0.anInt710;
                        }
                    }
                } else {
                    var0.anInt1436 += var0.anInt2020;
                    var14 = true;
                    if (var3 < var0.anInt2020 || var3 > 2048 - var0.anInt2020) {
                        var0.anInt1436 = var0.orientation;
                        var14 = false;
                    }

                    if (var0.stance == var0.walkingStance && (var0.anInt2018 > 25 || var14)) {
                        if (var0.anInt1424 != -1) {
                            var0.stance = var0.anInt1424;
                        } else {
                            var0.stance = var0.anInt710;
                        }
                    }
                }

                var0.anInt1436 &= 2047;
            } else {
                var0.anInt2018 = 0;
            }
        }

        var0.stretch = false;
        if (var0.stance != -1) {
            var2 = AnimationSequence.get(var0.stance);
            if (var2 != null && var2.frameIds != null) {
                ++var0.anInt2009;
                if (var0.stanceFrame < var2.frameIds.length && var0.anInt2009 > var2.frameLengths[var0.stanceFrame]) {
                    var0.anInt2009 = 1;
                    ++var0.stanceFrame;
                    client.method181(var2, var0.stanceFrame, var0.fineX, var0.fineY);
                }

                if (var0.stanceFrame >= var2.frameIds.length) {
                    var0.anInt2009 = 0;
                    var0.stanceFrame = 0;
                    client.method181(var2, var0.stanceFrame, var0.fineX, var0.fineY);
                }
            } else {
                var0.stance = -1;
            }
        }

        if (var0.graphic != -1 && client.engineCycle >= var0.graphicDelay) {
            if (var0.graphicFrame < 0) {
                var0.graphicFrame = 0;
            }

            var3 = EffectAnimation.get(var0.graphic).animation;
            if (var3 != -1) {
                AnimationSequence var4 = AnimationSequence.get(var3);
                if (var4 != null && var4.frameIds != null) {
                    ++var0.anInt2013;
                    if (var0.graphicFrame < var4.frameIds.length && var0.anInt2013 > var4.frameLengths[var0.graphicFrame]) {
                        var0.anInt2013 = 1;
                        ++var0.graphicFrame;
                        client.method181(var4, var0.graphicFrame, var0.fineX, var0.fineY);
                    }

                    if (var0.graphicFrame >= var4.frameIds.length && (var0.graphicFrame < 0 || var0.graphicFrame >= var4.frameIds.length)) {
                        var0.graphic = -1;
                    }
                } else {
                    var0.graphic = -1;
                }
            } else {
                var0.graphic = -1;
            }
        }

        if (var0.animation != -1 && var0.animationDelay <= 1) {
            var2 = AnimationSequence.get(var0.animation);
            if (var2.animatingPrecedence == 1 && var0.anInt2023 > 0 && var0.forceMovementStartCycle <= client.engineCycle && var0.forceMovementEndCycle < client.engineCycle) {
                var0.animationDelay = 1;
                return;
            }
        }

        if (var0.animation != -1 && var0.animationDelay == 0) {
            var2 = AnimationSequence.get(var0.animation);
            if (var2 != null && var2.frameIds != null) {
                ++var0.animationFrameCycle;
                if (var0.animationFrame < var2.frameIds.length && var0.animationFrameCycle > var2.frameLengths[var0.animationFrame]) {
                    var0.animationFrameCycle = 1;
                    ++var0.animationFrame;
                    client.method181(var2, var0.animationFrame, var0.fineX, var0.fineY);
                }

                if (var0.animationFrame >= var2.frameIds.length) {
                    var0.animationFrame -= var2.loopOffset;
                    ++var0.anInt2010;
                    if (var0.anInt2010 >= var2.maxLoops) {
                        var0.animation = -1;
                    } else if (var0.animationFrame >= 0 && var0.animationFrame < var2.frameIds.length) {
                        client.method181(var2, var0.animationFrame, var0.fineX, var0.fineY);
                    } else {
                        var0.animation = -1;
                    }
                }

                var0.stretch = var2.stretch;
            } else {
                var0.animation = -1;
            }
        }

        if (var0.animationDelay > 0) {
            --var0.animationDelay;
        }

    }

    public static void method841(PathingEntity var0) {
        int var1 = var0.forceMovementStartCycle - client.engineCycle;
        int var2 = var0.boundSize + var0.anInt1354 * 128;
        int var3 = var0.boundSize + var0.anInt2011 * 128;
        var0.fineX += (var2 - var0.fineX) / var1;
        var0.fineY += (var3 - var0.fineY) / var1;
        var0.anInt2022 = 0;
        var0.orientation = var0.anInt2019;
    }

    public static void method1297(PathingEntity entity, int var1, int var2, int var3, int var4, int var5) {
        if (entity != null && entity.isDefined()) {
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
            if (var1 < var7 && entity.renderCycle == client.engineCycle && StockMarketOfferPriceComparator.method331((PlayerEntity) entity)) {
                PlayerEntity var10 = (PlayerEntity) entity;
                if (var1 < var7) {
                    World.method1354(entity, entity.anInt2021 + 15);
                    BaseFont var11 = client.fonts.get(NamedFont.P12);
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

                for (HealthBar var89 = (HealthBar) entity.healthBars.head(); var89 != null; var89 = (HealthBar) entity.healthBars.next()) {
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
                        } else {
                            var13 += 5;
                            if (client.anInt998 > -1) {
                                var24 = var2 + client.anInt998 - (var19 >> 1);
                                var25 = var3 + client.anInt993 - var13;
                                JagGraphics.fillRect(var24, var25, var94, 5, 65280);
                                JagGraphics.fillRect(var24 + var94, var25, var19 - var94, 5, 16711680);
                            }

                        }
                        var13 += 2;
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
                            ParameterDefinition.prayerIconSprites[player.prayerIcon].method809(var2 + client.anInt998 - 12, var3 + client.anInt993 - var13);
                        }

                        if (player.skullIcon != -1) {
                            var13 += 25;
                            WorldMapChunkDefinition.skullIconSprites[player.skullIcon].method809(var2 + client.anInt998 - 12, var3 + client.anInt993 - var13);
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

                if (var91.prayerIcon >= 0 && var91.prayerIcon < WorldMapChunkDefinition.skullIconSprites.length) {
                    World.method1354(entity, entity.anInt2021 + 15);
                    if (client.anInt998 > -1) {
                        WorldMapChunkDefinition.skullIconSprites[var91.prayerIcon].method809(var2 + client.anInt998 - 12, var3 + client.anInt993 - 30);
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
                    client.overheadMessages[client.anInt1000] = entity.overheadText;
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
                    var30 = (HitsplatDefinition) HitsplatDefinition.cache.get(var18);
                    HitsplatDefinition var31;
                    if (var30 == null) {
                        byte[] var32 = HitsplatDefinition.table.unpack(32, var18);
                        var30 = new HitsplatDefinition();
                        if (var32 != null) {
                            var30.decode(new Buffer(var32));
                        }

                        HitsplatDefinition.cache.put(var30, var18);
                    }
                    var31 = var30;

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
                    var95 = (HitsplatDefinition) HitsplatDefinition.cache.get(var19);
                    if (var95 == null) {
                        byte[] var34 = HitsplatDefinition.table.unpack(32, var19);
                        var95 = new HitsplatDefinition();
                        if (var34 != null) {
                            var95.decode(new Buffer(var34));
                        }

                        HitsplatDefinition.cache.put(var95, var19);
                    }
                    var30 = var95;

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

                            Sprite var97;
                            Sprite var35;
                            Sprite var36;
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
                                var57 = StockMarketOfferWorldComparator.aFont345;
                            }

                            Font var58;
                            if (var33 != null) {
                                var58 = var33.method1438();
                                if (var58 == null) {
                                    var58 = StockMarketOfferWorldComparator.aFont345;
                                }
                            } else {
                                var58 = StockMarketOfferWorldComparator.aFont345;
                            }

                            String var59;
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
                            int var82 = var80 + var55;
                            int var83 = var80 + var93.anInt1659 + 15;
                            int var84 = var83 - var57.anInt372;
                            int var85 = var83 + var57.anInt379;
                            if (var84 < var80) {
                            }

                            if (var85 > var82) {
                            }

                            int var86 = 0;
                            int var87;
                            int var88;
                            if (var33 != null) {
                                var86 = var80 + var33.anInt1659 + 15;
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

                                var57.drawString(var59, var69 + var79, var83, var93.textColor | -16777216, 0);
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

                                    var58.drawString(var60, var75 + var79, var86, var33.textColor | -16777216, 0);
                                }
                            }
                        }
                    }
                }
            }

        }
    }

    public final void addHitSplat(int type, int damage, int id, int special, int currentCycle, int delay) {
        boolean expire = true;
        boolean var9 = true;

        for (int var10 = 0; var10 < 4; ++var10) {
            if (this.hitsplatCycles[var10] > currentCycle) {
                expire = false;
            } else {
                var9 = false;
            }
        }

        int comparisonType = -1;
        int duration = 0;
        if (type >= 0) {
            HitsplatDefinition definition = (HitsplatDefinition) HitsplatDefinition.cache.get(type);
            if (definition == null) {
                byte[] payload = HitsplatDefinition.table.unpack(32, type);
                definition = new HitsplatDefinition();
                if (payload != null) {
                    definition.decode(new Buffer(payload));
                }
                HitsplatDefinition.cache.put(definition, type);
            }

            comparisonType = definition.comparisonType;
            duration = definition.duration;
        }

        int index = -1;
        int var15;
        if (var9) {
            if (comparisonType == -1) {
                return;
            }

            index = 0;
            var15 = 0;
            if (comparisonType == 0) {
                var15 = this.hitsplatCycles[0];
            } else if (comparisonType == 1) {
                var15 = this.hitsplats[0];
            }

            for (int i = 1; i < 4; ++i) {
                if (comparisonType == 0) {
                    if (this.hitsplatCycles[i] < var15) {
                        index = i;
                        var15 = this.hitsplatCycles[i];
                    }
                } else if (comparisonType == 1 && this.hitsplats[i] < var15) {
                    index = i;
                    var15 = this.hitsplats[i];
                }
            }

            if (comparisonType == 1 && var15 >= damage) {
                return;
            }
        } else {
            if (expire) {
                this.hitsplatCount = 0;
            }

            for (var15 = 0; var15 < 4; ++var15) {
                byte var18 = this.hitsplatCount;
                this.hitsplatCount = (byte) ((this.hitsplatCount + 1) % 4);
                if (this.hitsplatCycles[var18] <= currentCycle) {
                    index = var18;
                    break;
                }
            }
        }

        if (index >= 0) {
            this.hitsplatTypes[index] = type;
            this.hitsplats[index] = damage;
            this.hitsplatIds[index] = id;
            this.specialHitsplats[index] = special;
            this.hitsplatCycles[index] = currentCycle + duration + delay;
        }
    }

    public final void method1503(int var1) {
        HealthBarDefinition var2 = (HealthBarDefinition) HealthBarDefinition.cache.get(var1);
        HealthBarDefinition var3;
        if (var2 == null) {
            byte[] var4 = HealthBarDefinition.table.unpack(33, var1);
            var2 = new HealthBarDefinition();
            if (var4 != null) {
                var2.decode(new Buffer(var4));
            }

            HealthBarDefinition.cache.put(var2, var1);
        }
        var3 = var2;

        var2 = var3;

        for (HealthBar var5 = (HealthBar) this.healthBars.head(); var5 != null; var5 = (HealthBar) this.healthBars.next()) {
            if (var2 == var5.definition) {
                var5.unlink();
                return;
            }
        }

    }

    public final void updateHealthBar(int var1, int currentCycle, int var3, int delay, int var5, int var6) {
        HealthBarDefinition definition = (HealthBarDefinition) HealthBarDefinition.cache.get(var1);
        if (definition == null) {
            byte[] payload = HealthBarDefinition.table.unpack(33, var1);
            definition = new HealthBarDefinition();
            if (payload != null) {
                definition.decode(new Buffer(payload));
            }
            HealthBarDefinition.cache.put(definition, var1);
        }

        HealthBar var15 = null;
        HealthBar var11 = null;
        int var12 = definition.anInt379;
        int var13 = 0;

        HealthBar var14;
        for (var14 = (HealthBar) this.healthBars.head(); var14 != null; var14 = (HealthBar) this.healthBars.next()) {
            ++var13;
            if (var14.definition.anInt574 == definition.anInt574) {
                var14.update(currentCycle + delay, var5, var6, var3);
                return;
            }

            if (var14.definition.anInt372 <= definition.anInt372) {
                var15 = var14;
            }

            if (var14.definition.anInt379 > var12) {
                var11 = var14;
                var12 = var14.definition.anInt379;
            }
        }

        if (var11 != null || var13 < 4) {
            var14 = new HealthBar(definition);
            if (var15 == null) {
                this.healthBars.addElement(var14);
            } else {
                LinkedList.insertBefore(var14, var15);
            }

            var14.update(currentCycle + delay, var5, var6, var3);
            if (var13 >= 4) {
                var11.unlink();
            }

        }
    }

    public boolean isDefined() {
        return false;
    }

    public final void method1504() {
        this.pathQueueSize = 0;
        this.anInt2023 = 0;
    }
}
