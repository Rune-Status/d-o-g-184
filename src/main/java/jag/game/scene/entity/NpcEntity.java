package jag.game.scene.entity;

import jag.game.client;
import jag.game.type.AnimationSequence;
import jag.game.type.EffectAnimation;
import jag.game.type.NpcDefinition;
import jag.opcode.Buffer;
import jag.opcode.OutgoingPacket;
import jag.opcode.OutgoingPacketMeta;
import jag.opcode.PacketBuffer;

public final class NpcEntity extends PathingEntity {
    public static int anInt823;
    public NpcDefinition definition;

    public NpcEntity() {

    }

    public static void update(boolean var0, PacketBuffer var1) {
        client.npcCount2 = 0;
        client.anInt964 = 0;
        method541();

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

            boolean createdNew = false;
            if (client.npcs[var3] == null) {
                client.npcs[var3] = new NpcEntity();
                createdNew = true;
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
            if (createdNew) {
                var5.orientation = var5.anInt1436 = var8;
            }

            var9 = var1.method1398(1);
            if (var9 == 1) {
                client.anIntArray963[++client.anInt964 - 1] = var3;
            }

            var10 = var1.method1398(1);
            var5.definition = NpcDefinition.get(var1.method1398(14));
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
                    var9 = AnimationSequence.get(var7).replayMode;
                    if (var9 == 1) {
                        var5.animationFrame = 0;
                        var5.animationFrameCycle = 0;
                        var5.animationDelay = var8;
                        var5.anInt2010 = 0;
                    }

                    if (var9 == 2) {
                        var5.anInt2010 = 0;
                    }
                } else if (var7 == -1 || var5.animation == -1 || AnimationSequence.get(var7).priority >= AnimationSequence.get(var5.animation).priority) {
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
                var5.definition = NpcDefinition.get(var1.method1060());
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
                var9 = var5.fineX - (var7 - client.baseX - client.baseX) * 64;
                var10 = var5.fineY - (var8 - client.baseY - client.baseY) * 64;
                if (var9 != 0 || var10 != 0) {
                    var5.transformedOrientation = (int) (Math.atan2(var9, var10) * 325.949D) & 2047;
                }
            }

            if ((var6 & 8) != 0) {
                var5.graphic = var1.method1060();
                var7 = var1.method1019();
                var5.anInt2014 = var7 >> 16;
                var5.graphicDelay = (var7 & 65535) + client.engineCycle;
                var5.graphicFrame = 0;
                var5.anInt2013 = 0;
                if (var5.graphicDelay > client.engineCycle) {
                    var5.graphicFrame = -1;
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

    public static void method541() {
        PacketBuffer var0 = client.connectionContext.inbuffer;
        var0.bitAccess();
        int var1 = var0.method1398(8);
        if (var1 < client.npcCount) {
            for (int var2 = var1; var2 < client.npcCount; ++var2) {
                client.npcIndices2[++client.npcCount2 - 1] = client.npcIndices[var2];
            }
        }

        if (var1 > client.npcCount) {
            throw new RuntimeException("");
        }

        client.npcCount = 0;

        for (int var2 = 0; var2 < var1; ++var2) {
            int var3 = client.npcIndices[var2];
            NpcEntity var4 = client.npcs[var3];
            int var5 = var0.method1398(1);
            if (var5 == 0) {
                client.npcIndices[++client.npcCount - 1] = var3;
                var4.anInt2024 = client.engineCycle;
            } else {
                int var6 = var0.method1398(2);
                if (var6 == 0) {
                    client.npcIndices[++client.npcCount - 1] = var3;
                    var4.anInt2024 = client.engineCycle;
                    client.anIntArray963[++client.anInt964 - 1] = var3;
                } else {
                    int var7;
                    int var8;
                    if (var6 == 1) {
                        client.npcIndices[++client.npcCount - 1] = var3;
                        var4.anInt2024 = client.engineCycle;
                        var7 = var0.method1398(3);
                        var4.method682(var7, (byte) 1);
                        var8 = var0.method1398(1);
                        if (var8 == 1) {
                            client.anIntArray963[++client.anInt964 - 1] = var3;
                        }
                    } else if (var6 == 2) {
                        client.npcIndices[++client.npcCount - 1] = var3;
                        var4.anInt2024 = client.engineCycle;
                        var7 = var0.method1398(3);
                        var4.method682(var7, (byte) 2);
                        var8 = var0.method1398(3);
                        var4.method682(var8, (byte) 2);
                        int var9 = var0.method1398(1);
                        if (var9 == 1) {
                            client.anIntArray963[++client.anInt964 - 1] = var3;
                        }
                    } else if (var6 == 3) {
                        client.npcIndices2[++client.npcCount2 - 1] = var3;
                    }
                }
            }
        }

    }

    protected final Model getModel() {
        if (this.definition == null) {
            return null;
        }
        AnimationSequence anim = super.animation != -1 && super.animationDelay == 0 ? AnimationSequence.get(super.animation) : null;
        AnimationSequence stance = super.stance != -1 && (super.stance != super.walkingStance || anim == null) ? AnimationSequence.get(super.stance) : null;
        Model var3 = this.definition.getModel(anim, super.animationFrame, stance, super.stanceFrame);
        if (var3 == null) {
            return null;
        }
        var3.method827();
        super.anInt2021 = var3.height;
        if (super.graphic != -1 && super.graphicFrame != -1) {
            Model var4 = EffectAnimation.get(super.graphic).method1004(super.graphicFrame);
            if (var4 != null) {
                var4.method832(0, -super.anInt2014, 0);
                Model[] var5 = new Model[]{var3, var4};
                var3 = new Model(var5, 2);
            }
        }

        if (this.definition.size == 1) {
            var3.aabbEnabled = true;
        }

        return var3;
    }

    public final void method682(int var1, byte var2) {
        int var3 = super.pathXQueue[0];
        int var4 = super.pathYQueue[0];
        if (var1 == 0) {
            --var3;
            ++var4;
        }

        if (var1 == 1) {
            ++var4;
        }

        if (var1 == 2) {
            ++var3;
            ++var4;
        }

        if (var1 == 3) {
            --var3;
        }

        if (var1 == 4) {
            ++var3;
        }

        if (var1 == 5) {
            --var3;
            --var4;
        }

        if (var1 == 6) {
            --var4;
        }

        if (var1 == 7) {
            ++var3;
            --var4;
        }

        if (super.animation != -1 && AnimationSequence.get(super.animation).walkingPrecedence == 1) {
            super.animation = -1;
        }

        if (super.pathQueueSize < 9) {
            ++super.pathQueueSize;
        }

        for (int var5 = super.pathQueueSize; var5 > 0; --var5) {
            super.pathXQueue[var5] = super.pathXQueue[var5 - 1];
            super.pathYQueue[var5] = super.pathYQueue[var5 - 1];
            super.pathQueueTraversed[var5] = super.pathQueueTraversed[var5 - 1];
        }

        super.pathXQueue[0] = var3;
        super.pathYQueue[0] = var4;
        super.pathQueueTraversed[0] = var2;
    }

    public final void method683(int var1, int var2, boolean var3) {
        if (super.animation != -1 && AnimationSequence.get(super.animation).walkingPrecedence == 1) {
            super.animation = -1;
        }

        if (!var3) {
            int var4 = var1 - super.pathXQueue[0];
            int var5 = var2 - super.pathYQueue[0];
            if (var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
                if (super.pathQueueSize < 9) {
                    ++super.pathQueueSize;
                }

                for (int var6 = super.pathQueueSize; var6 > 0; --var6) {
                    super.pathXQueue[var6] = super.pathXQueue[var6 - 1];
                    super.pathYQueue[var6] = super.pathYQueue[var6 - 1];
                    super.pathQueueTraversed[var6] = super.pathQueueTraversed[var6 - 1];
                }

                super.pathXQueue[0] = var1;
                super.pathYQueue[0] = var2;
                super.pathQueueTraversed[0] = 1;
                return;
            }
        }

        super.pathQueueSize = 0;
        super.anInt2023 = 0;
        super.anInt2022 = 0;
        super.pathXQueue[0] = var1;
        super.pathYQueue[0] = var2;
        super.fineX = super.pathXQueue[0] * 128 + super.boundSize;
        super.fineY = super.pathYQueue[0] * 128 + super.boundSize;
    }

    public final boolean isDefined() {
        return this.definition != null;
    }
}
