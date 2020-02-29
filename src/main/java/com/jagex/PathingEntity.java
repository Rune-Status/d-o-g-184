package com.jagex;

public abstract class PathingEntity extends Entity {
    int animation;
    int pathQueueSize;
    int[] pathXQueue;
    int[] hitsplatCycles;
    int transformedOrienation;
    boolean aBoolean2004;
    int anInt2023;
    int[] pathYQueue;
    int anInt2022;
    int animationDelay;
    LinkedList healthBars;
    int stance;
    int boundSize;
    int walkingStance;
    int animationFrame;
    int anInt709;
    int stanceFrame;
    byte hitsplatCount;
    int anInt1424;
    int[] hitsplats;
    int anInt710;
    byte[] pathQueueTraversed;
    int anInt2006;
    int fineX;
    int anInt1857;
    int anInt1858;
    int anInt2007;
    int anInt2021;
    int fineY;
    int[] hitsplatTypes;
    String overheadText;
    int graphic;
    boolean aBoolean2005;
    int anInt2017;
    int[] hitsplatIds;
    int anInt1344;
    int[] specialHitsplats;
    int anInt1508;
    int anInt1510;
    int anInt2024;
    int anInt2014;
    int targetIndex;
    int animationFrameCycle;
    int anInt2010;
    boolean aBoolean2015;
    int orientation;
    int anInt1436;
    int anInt2009;
    int anInt2020;
    int anInt2013;
    int graphicDelay;
    int anInt2018;
    int anInt1437;
    int forceMovementStartCycle;
    int forceMovementEndCycle;
    int anInt1354;
    int anInt2011;
    int anInt1351;
    int anInt2016;
    int anInt2019;
    boolean aBoolean2008;

    PathingEntity() {
        this.aBoolean2004 = false;
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
        this.transformedOrienation = -1;
        this.stance = -1;
        this.stanceFrame = 0;
        this.anInt2009 = 0;
        this.animation = -1;
        this.animationFrame = 0;
        this.animationFrameCycle = 0;
        this.animationDelay = 0;
        this.anInt2010 = 0;
        this.graphic = -1;
        this.anInt2017 = 0;
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

    static void method1320(PathingEntity var0) {
        AnimationSequence var2;
        int var3;
        int var5;
        int var6;
        if (var0.forceMovementStartCycle > client.engineCycle) {
            Class144.method841(var0);
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
                        var2 = Class57.getAnimationSequence(var0.animation);
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

                            if (var0.anInt2022 > 0 && var0.pathQueueSize > 1) {
                                var11 = 8;
                                --var0.anInt2022;
                            }
                        } else {
                            if (var0.pathQueueSize > 1) {
                                var11 = 6;
                            }

                            if (var0.pathQueueSize > 2) {
                                var11 = 8;
                            }

                            if (var0.anInt2022 > 0 && var0.pathQueueSize > 1) {
                                var11 = 8;
                                --var0.anInt2022;
                            }
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
                        var0.orientation = (int) (Math.atan2((double) var5, (double) var6) * 325.949D) & 2047;
                    }
                } else if (var0.aBoolean2015) {
                    var0.targetIndex = -1;
                    var0.aBoolean2015 = false;
                }
            }

            if (var0.transformedOrienation != -1 && (var0.pathQueueSize == 0 || var0.anInt2022 > 0)) {
                var0.orientation = var0.transformedOrienation;
                var0.transformedOrienation = -1;
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

        var0.aBoolean2004 = false;
        if (var0.stance != -1) {
            var2 = Class57.getAnimationSequence(var0.stance);
            if (var2 != null && var2.frameIds != null) {
                ++var0.anInt2009;
                if (var0.stanceFrame < var2.frameIds.length && var0.anInt2009 > var2.frameLengths[var0.stanceFrame]) {
                    var0.anInt2009 = 1;
                    ++var0.stanceFrame;
                    Class24.method181(var2, var0.stanceFrame, var0.fineX, var0.fineY);
                }

                if (var0.stanceFrame >= var2.frameIds.length) {
                    var0.anInt2009 = 0;
                    var0.stanceFrame = 0;
                    Class24.method181(var2, var0.stanceFrame, var0.fineX, var0.fineY);
                }
            } else {
                var0.stance = -1;
            }
        }

        if (var0.graphic != -1 && client.engineCycle >= var0.graphicDelay) {
            if (var0.anInt2017 < 0) {
                var0.anInt2017 = 0;
            }

            var3 = InterfaceNode.getGraphicDefinition(var0.graphic).animation;
            if (var3 != -1) {
                AnimationSequence var4 = Class57.getAnimationSequence(var3);
                if (var4 != null && var4.frameIds != null) {
                    ++var0.anInt2013;
                    if (var0.anInt2017 < var4.frameIds.length && var0.anInt2013 > var4.frameLengths[var0.anInt2017]) {
                        var0.anInt2013 = 1;
                        ++var0.anInt2017;
                        Class24.method181(var4, var0.anInt2017, var0.fineX, var0.fineY);
                    }

                    if (var0.anInt2017 >= var4.frameIds.length && (var0.anInt2017 < 0 || var0.anInt2017 >= var4.frameIds.length)) {
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
            var2 = Class57.getAnimationSequence(var0.animation);
            if (var2.animatingPrecedence == 1 && var0.anInt2023 > 0 && var0.forceMovementStartCycle <= client.engineCycle && var0.forceMovementEndCycle < client.engineCycle) {
                var0.animationDelay = 1;
                return;
            }
        }

        if (var0.animation != -1 && var0.animationDelay == 0) {
            var2 = Class57.getAnimationSequence(var0.animation);
            if (var2 != null && var2.frameIds != null) {
                ++var0.animationFrameCycle;
                if (var0.animationFrame < var2.frameIds.length && var0.animationFrameCycle > var2.frameLengths[var0.animationFrame]) {
                    var0.animationFrameCycle = 1;
                    ++var0.animationFrame;
                    Class24.method181(var2, var0.animationFrame, var0.fineX, var0.fineY);
                }

                if (var0.animationFrame >= var2.frameIds.length) {
                    var0.animationFrame -= var2.loopOffset;
                    ++var0.anInt2010;
                    if (var0.anInt2010 >= var2.maxLoops) {
                        var0.animation = -1;
                    } else if (var0.animationFrame >= 0 && var0.animationFrame < var2.frameIds.length) {
                        Class24.method181(var2, var0.animationFrame, var0.fineX, var0.fineY);
                    } else {
                        var0.animation = -1;
                    }
                }

                var0.aBoolean2004 = var2.stretch;
            } else {
                var0.animation = -1;
            }
        }

        if (var0.animationDelay > 0) {
            --var0.animationDelay;
        }

    }

    final void addHitSplat(int type, int damage, int id, int special, int currentCycle, int delay) {
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
            HitsplatDefinition definition = (HitsplatDefinition) HitsplatDefinition.cache.get((long) type);
            if (definition == null) {
                byte[] payload = HitsplatDefinition.table.unpack(32, type);
                definition = new HitsplatDefinition();
                if (payload != null) {
                    definition.decode(new Buffer(payload));
                }
                HitsplatDefinition.cache.put(definition, (long) type);
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

    final void method1503(int var1) {
        HealthBarDefinition var2 = (HealthBarDefinition) HealthBarDefinition.cache.get((long) var1);
        HealthBarDefinition var3;
        if (var2 != null) {
            var3 = var2;
        } else {
            byte[] var4 = HealthBarDefinition.table.unpack(33, var1);
            var2 = new HealthBarDefinition();
            if (var4 != null) {
                var2.decode(new Buffer(var4));
            }

            HealthBarDefinition.cache.put(var2, (long) var1);
            var3 = var2;
        }

        var2 = var3;

        for (HealthBar var5 = (HealthBar) this.healthBars.head(); var5 != null; var5 = (HealthBar) this.healthBars.method658()) {
            if (var2 == var5.definition) {
                var5.unlink();
                return;
            }
        }

    }

    final void updateHealthBar(int var1, int currentCycle, int var3, int delay, int var5, int var6) {
        HealthBarDefinition definition = (HealthBarDefinition) HealthBarDefinition.cache.get((long) var1);
        if (definition == null) {
            byte[] payload = HealthBarDefinition.table.unpack(33, var1);
            definition = new HealthBarDefinition();
            if (payload != null) {
                definition.decode(new Buffer(payload));
            }
            HealthBarDefinition.cache.put(definition, (long) var1);
        }

        HealthBar var15 = null;
        HealthBar var11 = null;
        int var12 = definition.anInt379;
        int var13 = 0;

        HealthBar var14;
        for (var14 = (HealthBar) this.healthBars.head(); var14 != null; var14 = (HealthBar) this.healthBars.method658()) {
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

    boolean method684() {
        return false;
    }

    final void method1504() {
        this.pathQueueSize = 0;
        this.anInt2023 = 0;
    }
}
