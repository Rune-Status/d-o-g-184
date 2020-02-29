package com.jagex;

public class InterfaceNode extends Node {
    boolean aBoolean790;
    int state;
    int id;

    InterfaceNode() {
        this.aBoolean790 = false;
    }

    public static SpotAnimation getGraphicDefinition(int var0) {
        SpotAnimation var2 = (SpotAnimation) SpotAnimation.aReferenceCache701.get((long) var0);
        if (var2 != null) {
            return var2;
        }
        byte[] var3 = Class62.aReferenceTable500.unpack(13, var0);
        var2 = new SpotAnimation();
        var2.anInt574 = var0;
        if (var3 != null) {
            var2.method990(new Buffer(var3));
        }

        SpotAnimation.aReferenceCache701.put(var2, (long) var0);
        return var2;
    }

    public static void method837() {
        ItemDefinition.aReferenceCache720.method334();
        ItemDefinition.aReferenceCache717.method334();
        ItemDefinition.aReferenceCache716.method334();
    }

    public static void method830(int var0) {
        if (var0 != -1) {
            if (Statics2.validInterfaces[var0]) {
                InterfaceComponent.aReferenceTable1375.method914(var0);
                if (AssociateComparator_Sub5.interfaces[var0] != null) {
                    boolean var1 = true;

                    for (int var2 = 0; var2 < AssociateComparator_Sub5.interfaces[var0].length; ++var2) {
                        if (AssociateComparator_Sub5.interfaces[var0][var2] != null) {
                            if (AssociateComparator_Sub5.interfaces[var0][var2].type != 2) {
                                AssociateComparator_Sub5.interfaces[var0][var2] = null;
                            } else {
                                var1 = false;
                            }
                        }
                    }

                    if (var1) {
                        AssociateComparator_Sub5.interfaces[var0] = null;
                    }

                    Statics2.validInterfaces[var0] = false;
                }
            }
        }
    }

    static void method23() {
        if (Class55.username == null || Class55.username.length() <= 0) {
            if (client.preferences.aString362 != null) {
                Class55.username = client.preferences.aString362;
                client.aBoolean958 = true;
            } else {
                client.aBoolean958 = false;
            }

        }
    }

    static void updateNpcs(boolean var0, PacketBuffer var1) {
        client.npcCount2 = 0;
        client.anInt964 = 0;
        Class98.method541();

        int var3;
        NpcEntity var5;
        int var6;
        int var7;
        int var8;
        int var9;
        int var10;
        while (var1.method1394(client.connectionContext.incomingPacketSize) >= 27) {
            var3 = var1.method1398(15);
            if (var3 == 32767) {
                break;
            }

            boolean var4 = false;
            if (client.npcs[var3] == null) {
                client.npcs[var3] = new NpcEntity();
                var4 = true;
            }

            var5 = client.npcs[var3];
            client.npcIndices[++client.npcCount - 1] = var3;
            var5.anInt2024 = client.engineCycle;
            if (var0) {
                var6 = var1.method1398(8);
                if (var6 > 127) {
                    var6 -= 256;
                }
            } else {
                var6 = var1.method1398(5);
                if (var6 > 15) {
                    var6 -= 32;
                }
            }

            if (var0) {
                var7 = var1.method1398(8);
                if (var7 > 127) {
                    var7 -= 256;
                }
            } else {
                var7 = var1.method1398(5);
                if (var7 > 15) {
                    var7 -= 32;
                }
            }

            var8 = client.anIntArray1035[var1.method1398(3)];
            if (var4) {
                var5.orientation = var5.anInt1436 = var8;
            }

            var9 = var1.method1398(1);
            if (var9 == 1) {
                client.anIntArray963[++client.anInt964 - 1] = var3;
            }

            var10 = var1.method1398(1);
            var5.definition = OutgoingPacket.getNpcDefinition(var1.method1398(14));
            var5.boundSize = var5.definition.size;
            var5.anInt2020 = var5.definition.anInt694;
            if (var5.anInt2020 == 0) {
                var5.anInt1436 = 0;
            }

            var5.anInt710 = var5.definition.walkAnimation;
            var5.anInt2006 = var5.definition.anInt366;
            var5.anInt1857 = var5.definition.anInt696;
            var5.anInt1858 = var5.definition.anInt702;
            var5.walkingStance = var5.definition.idleAnimation;
            var5.anInt709 = var5.definition.anInt368;
            var5.anInt1424 = var5.definition.anInt367;
            var5.method683(PlayerEntity.local.pathXQueue[0] + var6, PlayerEntity.local.pathYQueue[0] + var7, var10 == 1);
        }

        var1.byteAccess();

        int var15;
        for (var3 = 0; var3 < client.anInt964; ++var3) {
            var15 = client.anIntArray963[var3];
            var5 = client.npcs[var15];
            var6 = var1.readUByte();
            if ((var6 & 16) != 0) {
                var7 = var1.readUShort();
                if (var7 == 65535) {
                    var7 = -1;
                }

                var8 = var1.method1074();
                if (var7 == var5.animation && var7 != -1) {
                    var9 = Class57.getAnimationSequence(var7).replayMode;
                    if (var9 == 1) {
                        var5.animationFrame = 0;
                        var5.animationFrameCycle = 0;
                        var5.animationDelay = var8;
                        var5.anInt2010 = 0;
                    }

                    if (var9 == 2) {
                        var5.anInt2010 = 0;
                    }
                } else if (var7 == -1 || var5.animation == -1 || Class57.getAnimationSequence(var7).priority >= Class57.getAnimationSequence(var5.animation).priority) {
                    var5.animation = var7;
                    var5.animationFrame = 0;
                    var5.animationFrameCycle = 0;
                    var5.animationDelay = var8;
                    var5.anInt2010 = 0;
                    var5.anInt2023 = var5.pathQueueSize;
                }
            }

            if ((var6 & 1) != 0) {
                var7 = var1.method1072();
                int var11;
                int var12;
                int var13;
                if (var7 > 0) {
                    for (var8 = 0; var8 < var7; ++var8) {
                        var10 = -1;
                        var11 = -1;
                        var12 = -1;
                        var9 = var1.readSmart();
                        if (var9 == 32767) {
                            var9 = var1.readSmart();
                            var11 = var1.readSmart();
                            var10 = var1.readSmart();
                            var12 = var1.readSmart();
                        } else if (var9 != 32766) {
                            var11 = var1.readSmart();
                        } else {
                            var9 = -1;
                        }

                        var13 = var1.readSmart();
                        var5.addHitSplat(var9, var11, var10, var12, client.engineCycle, var13);
                    }
                }

                var8 = var1.method1074();
                if (var8 > 0) {
                    for (var9 = 0; var9 < var8; ++var9) {
                        var10 = var1.readSmart();
                        var11 = var1.readSmart();
                        if (var11 != 32767) {
                            var12 = var1.readSmart();
                            var13 = var1.method1072();
                            int var14 = var11 > 0 ? var1.method1072() : var13;
                            var5.updateHealthBar(var10, client.engineCycle, var11, var12, var13, var14);
                        } else {
                            var5.method1503(var10);
                        }
                    }
                }
            }

            if ((var6 & 2) != 0) {
                var5.targetIndex = var1.method1055();
                if (var5.targetIndex == 65535) {
                    var5.targetIndex = -1;
                }
            }

            if ((var6 & 32) != 0) {
                var5.definition = OutgoingPacket.getNpcDefinition(var1.method1060());
                var5.boundSize = var5.definition.size;
                var5.anInt2020 = var5.definition.anInt694;
                var5.anInt710 = var5.definition.walkAnimation;
                var5.anInt2006 = var5.definition.anInt366;
                var5.anInt1857 = var5.definition.anInt696;
                var5.anInt1858 = var5.definition.anInt702;
                var5.walkingStance = var5.definition.idleAnimation;
                var5.anInt709 = var5.definition.anInt368;
                var5.anInt1424 = var5.definition.anInt367;
            }

            if ((var6 & 4) != 0) {
                var7 = var1.method1055();
                var8 = var1.method1060();
                var9 = var5.fineX - (var7 - Statics18.baseX - Statics18.baseX) * 64;
                var10 = var5.fineY - (var8 - Statics36.baseY - Statics36.baseY) * 64;
                if (var9 != 0 || var10 != 0) {
                    var5.transformedOrienation = (int) (Math.atan2((double) var9, (double) var10) * 325.949D) & 2047;
                }
            }

            if ((var6 & 8) != 0) {
                var5.graphic = var1.method1060();
                var7 = var1.method1019();
                var5.anInt2014 = var7 >> 16;
                var5.graphicDelay = (var7 & 65535) + client.engineCycle;
                var5.anInt2017 = 0;
                var5.anInt2013 = 0;
                if (var5.graphicDelay > client.engineCycle) {
                    var5.anInt2017 = -1;
                }

                if (var5.graphic == 65535) {
                    var5.graphic = -1;
                }
            }

            if ((var6 & 64) != 0) {
                var5.overheadText = var1.readString();
                var5.anInt1344 = 100;
            }
        }

        for (var3 = 0; var3 < client.npcCount2; ++var3) {
            var15 = client.npcIndices2[var3];
            if (client.npcs[var15].anInt2024 != client.engineCycle) {
                client.npcs[var15].definition = null;
                client.npcs[var15] = null;
            }
        }

        if (var1.caret != client.connectionContext.incomingPacketSize) {
            throw new RuntimeException(var1.caret + "," + client.connectionContext.incomingPacketSize);
        }
        for (var3 = 0; var3 < client.npcCount; ++var3) {
            if (client.npcs[client.npcIndices[var3]] == null) {
                throw new RuntimeException(var3 + "," + client.npcCount);
            }
        }

    }

    static void method1319() {
        for (InterfaceNode var0 = (InterfaceNode) client.interfaceNodes.method314(); var0 != null; var0 = (InterfaceNode) client.interfaceNodes.method313()) {
            int groupIndex = var0.id;
            if (Class63_Sub2.loadInterface(groupIndex)) {
                boolean check = true;
                InterfaceComponent[] group = AssociateComparator_Sub5.interfaces[groupIndex];
                for (InterfaceComponent component : group) {
                    if (component != null) {
                        check = component.aBoolean562;
                        break;
                    }
                }

                if (!check) {
                    int var4 = (int) var0.key;
                    InterfaceComponent var5 = InterfaceComponent.lookup(var4);
                    if (var5 != null) {
                        Enum_Sub2.repaintComponent(var5);
                    }
                }
            }
        }

    }
}
