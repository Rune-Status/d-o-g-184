package com.jagex;

public class Class72 {
    public final long aLong553;
    public final int anInt552;
    public final GrandExchangeOffer aGrandExchangeOffer551;
    String aString549;
    String aString550;

    Class72(Buffer var1, byte var2, int var3) {
        this.aString550 = var1.readString();
        this.aString549 = var1.readString();
        this.anInt552 = var1.readUShort();
        this.aLong553 = var1.readLong();
        int var4 = var1.readInt();
        int var5 = var1.readInt();
        this.aGrandExchangeOffer551 = new GrandExchangeOffer();
        this.aGrandExchangeOffer551.method228();
        this.aGrandExchangeOffer551.method227(var2);
        this.aGrandExchangeOffer551.itemPrice = var4;
        this.aGrandExchangeOffer551.itemQuantity = var5;
        this.aGrandExchangeOffer551.transferred = 0;
        this.aGrandExchangeOffer551.spent = 0;
        this.aGrandExchangeOffer551.itemId = var3;
    }

    static void buildPlayerMenu(PlayerEntity var0, int var1, int var2, int var3) {
        if (PlayerEntity.local != var0) {
            if (client.menuRowCount < 400) {
                int var5;
                String var9;
                if (var0.skillLevel == 0) {
                    String var4 = var0.actions[0] + var0.namePair + var0.actions[1];
                    var5 = var0.combatLevel;
                    int var6 = PlayerEntity.local.combatLevel;
                    int var7 = var6 - var5;
                    String var8;
                    if (var7 < -9) {
                        var8 = World.getColorTags(16711680);
                    } else if (var7 < -6) {
                        var8 = World.getColorTags(16723968);
                    } else if (var7 < -3) {
                        var8 = World.getColorTags(16740352);
                    } else if (var7 < 0) {
                        var8 = World.getColorTags(16756736);
                    } else if (var7 > 9) {
                        var8 = World.getColorTags(65280);
                    } else if (var7 > 6) {
                        var8 = World.getColorTags(4259584);
                    } else if (var7 > 3) {
                        var8 = World.getColorTags(8453888);
                    } else if (var7 > 0) {
                        var8 = World.getColorTags(12648192);
                    } else {
                        var8 = World.getColorTags(16776960);
                    }

                    var9 = var4 + var8 + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
                } else {
                    var9 = var0.actions[0] + var0.namePair + var0.actions[1] + " " + " (" + "skill-" + var0.skillLevel + ")" + var0.actions[2];
                }

                int var10;
                if (client.itemSelectionState == 1) {
                    Class63_Sub1.insertMenuItem("Use", client.aString1009 + " " + "->" + " " + World.getColorTags(16777215) + var9, 14, var1, var2, var3);
                } else if (client.spellSelected) {
                    if ((client.spellTargetFlags & 8) == 8) {
                        Class63_Sub1.insertMenuItem(client.aString1049, client.aString1051 + " " + "->" + " " + World.getColorTags(16777215) + var9, 15, var1, var2, var3);
                    }
                } else {
                    for (var10 = 7; var10 >= 0; --var10) {
                        if (client.playerActions[var10] != null) {
                            short var11 = 0;
                            if (client.playerActions[var10].equalsIgnoreCase("Attack")) {
                                if (ActionPrioritySetting.anActionPrioritySetting330 == client.playerActionPriority) {
                                    continue;
                                }

                                if (ActionPrioritySetting.anActionPrioritySetting336 == client.playerActionPriority || client.playerActionPriority == ActionPrioritySetting.anActionPrioritySetting333 && var0.combatLevel > PlayerEntity.local.combatLevel) {
                                    var11 = 2000;
                                }

                                if (PlayerEntity.local.team != 0 && var0.team != 0) {
                                    if (var0.team == PlayerEntity.local.team) {
                                        var11 = 2000;
                                    } else {
                                        var11 = 0;
                                    }
                                }
                            } else if (client.playerActionPriorities[var10]) {
                                var11 = 2000;
                            }

                            boolean var12 = false;
                            var5 = client.anIntArray1032[var10] + var11;
                            Class63_Sub1.insertMenuItem(client.playerActions[var10], World.getColorTags(16777215) + var9, var5, var1, var2, var3);
                        }
                    }
                }

                for (var10 = 0; var10 < client.menuRowCount; ++var10) {
                    if (client.menuOpcodes[var10] == 23) {
                        client.menuTargets[var10] = World.getColorTags(16777215) + var9;
                        break;
                    }
                }

            }
        }
    }

    static void method388(PendingSpawn var0) {
        long var1 = 0L;
        int var3 = -1;
        int var4 = 0;
        int var5 = 0;
        if (var0.type == 0) {
            var1 = client.sceneGraph.method1456(var0.floorLevel, var0.sceneX, var0.sceneY);
        }

        if (var0.type == 1) {
            var1 = client.sceneGraph.method1440(var0.floorLevel, var0.sceneX, var0.sceneY);
        }

        if (var0.type == 2) {
            var1 = client.sceneGraph.method1461(var0.floorLevel, var0.sceneX, var0.sceneY);
        }

        if (var0.type == 3) {
            var1 = client.sceneGraph.method1457(var0.floorLevel, var0.sceneX, var0.sceneY);
        }

        if (0L != var1) {
            int var6 = client.sceneGraph.method1453(var0.floorLevel, var0.sceneX, var0.sceneY, var1);
            var3 = EntityUID.getObjectId(var1);
            var4 = var6 & 31;
            var5 = var6 >> 6 & 3;
        }

        var0.anInt380 = var3;
        var0.anInt375 = var4;
        var0.anInt112 = var5;
    }

    public static void method389() {
        HitsplatDefinition.cache.method334();
        HitsplatDefinition.aReferenceCache1228.method334();
        HitsplatDefinition.aReferenceCache1513.method334();
    }

    public String method390() {
        return this.aString550;
    }

    public String method392() {
        return this.aString549;
    }
}
