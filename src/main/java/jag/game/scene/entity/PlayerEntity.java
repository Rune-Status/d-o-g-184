package jag.game.scene.entity;

import jag.PlayerAccountType;
import jag.RouteStrategy_Sub1;
import jag.SerializableInteger;
import jag.URLRequest;
import jag.commons.Jagception;
import jag.commons.input.Keyboard;
import jag.game.PlayerAppearance;
import jag.game.client;
import jag.game.relationship.ChatLinePrivacyType;
import jag.game.relationship.NamePair;
import jag.game.scene.SceneGraph;
import jag.game.type.AnimationSequence;
import jag.game.type.EffectAnimation;
import jag.game.type.ItemDefinition;
import jag.game.type.NpcDefinition;
import jag.graphics.BaseFont;
import jag.opcode.*;
import jag.statics.Statics13;
import jag.statics.Statics19;
import jag.statics.Statics26;
import jag.statics.Statics34;
import jag.worldmap.PreciseWorldMapAreaChunk;

public final class PlayerEntity extends PathingEntity {

    public static PlayerEntity local;
    public final String[] actions;
    public PlayerAppearance appearance;
    public ChatLinePrivacyType aChatLinePrivacyType_1906;
    public ChatLinePrivacyType aChatLinePrivacyType_1907;
    public NamePair namePair;
    public int prayerIcon;
    public int skullIcon;
    public boolean aBoolean1905;
    public int index;
    public int combatLevel;
    public int skillLevel;
    public int team;
    public int anInt564;
    public int anInt368;
    public boolean hidden;
    public boolean aBoolean1904;
    public Model transformedNpcModel;
    public int anInt1473;
    public int anInt367;
    public int anInt386;
    public int anInt379;
    public int anInt366;
    public int anInt702;
    public int anInt666;
    public int anInt788;
    public int anInt791;
    public int anInt704;
    public int anInt1739;

    public PlayerEntity() {
        this.prayerIcon = -1;
        this.skullIcon = -1;
        this.actions = new String[3];

        for (int var1 = 0; var1 < 3; ++var1) {
            this.actions[var1] = "";
        }

        this.combatLevel = 0;
        this.skillLevel = 0;
        this.anInt564 = 0;
        this.anInt368 = 0;
        this.aBoolean1905 = false;
        this.team = 0;
        this.hidden = false;
        this.aChatLinePrivacyType_1907 = ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1554;
        this.aChatLinePrivacyType_1906 = ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1554;
        this.aBoolean1904 = false;
    }

    public static void update(PacketBuffer packet, int var1) {
        int var2 = packet.caret;
        GPI.anInt594 = 0;
        int var3 = 0;
        packet.bitAccess();

        int var4;
        int var5;
        int var6;
        int var7;
        int var8;
        byte[] var10000;
        for (var4 = 0; var4 < GPI.playerCount; ++var4) {
            var5 = GPI.playerIndices[var4];
            if ((GPI.playerSkipFlags[var5] & 1) == 0) {
                if (var3 > 0) {
                    --var3;
                    var10000 = GPI.playerSkipFlags;
                    var10000[var5] = (byte) (var10000[var5] | 2);
                } else {
                    var6 = packet.method1398(1);
                    if (var6 == 0) {
                        var7 = packet.method1398(2);
                        if (var7 == 0) {
                            var8 = 0;
                        } else if (var7 == 1) {
                            var8 = packet.method1398(5);
                        } else if (var7 == 2) {
                            var8 = packet.method1398(8);
                        } else {
                            var8 = packet.method1398(11);
                        }

                        var3 = var8;
                        var10000 = GPI.playerSkipFlags;
                        var10000[var5] = (byte) (var10000[var5] | 2);
                    } else {
                        URLRequest.updatePlayerLocation(packet, var5);
                    }
                }
            }
        }

        packet.byteAccess();
        if (var3 != 0) {
            throw new RuntimeException();
        }
        packet.bitAccess();

        for (var4 = 0; var4 < GPI.playerCount; ++var4) {
            var5 = GPI.playerIndices[var4];
            if ((GPI.playerSkipFlags[var5] & 1) != 0) {
                if (var3 > 0) {
                    --var3;
                    var10000 = GPI.playerSkipFlags;
                    var10000[var5] = (byte) (var10000[var5] | 2);
                } else {
                    var6 = packet.method1398(1);
                    if (var6 == 0) {
                        var7 = packet.method1398(2);
                        if (var7 == 0) {
                            var8 = 0;
                        } else if (var7 == 1) {
                            var8 = packet.method1398(5);
                        } else if (var7 == 2) {
                            var8 = packet.method1398(8);
                        } else {
                            var8 = packet.method1398(11);
                        }

                        var3 = var8;
                        var10000 = GPI.playerSkipFlags;
                        var10000[var5] = (byte) (var10000[var5] | 2);
                    } else {
                        URLRequest.updatePlayerLocation(packet, var5);
                    }
                }
            }
        }

        packet.byteAccess();
        if (var3 != 0) {
            throw new RuntimeException();
        }
        packet.bitAccess();

        for (var4 = 0; var4 < GPI.globalPlayerCount; ++var4) {
            var5 = GPI.globalPlayerIndices[var4];
            if ((GPI.playerSkipFlags[var5] & 1) != 0) {
                if (var3 > 0) {
                    --var3;
                    var10000 = GPI.playerSkipFlags;
                    var10000[var5] = (byte) (var10000[var5] | 2);
                } else {
                    var6 = packet.method1398(1);
                    if (var6 == 0) {
                        var7 = packet.method1398(2);
                        if (var7 == 0) {
                            var8 = 0;
                        } else if (var7 == 1) {
                            var8 = packet.method1398(5);
                        } else if (var7 == 2) {
                            var8 = packet.method1398(8);
                        } else {
                            var8 = packet.method1398(11);
                        }

                        var3 = var8;
                        var10000 = GPI.playerSkipFlags;
                        var10000[var5] = (byte) (var10000[var5] | 2);
                    } else if (Statics34.method1168(packet, var5)) {
                        var10000 = GPI.playerSkipFlags;
                        var10000[var5] = (byte) (var10000[var5] | 2);
                    }
                }
            }
        }

        packet.byteAccess();
        if (var3 != 0) {
            throw new RuntimeException();
        }
        packet.bitAccess();

        for (var4 = 0; var4 < GPI.globalPlayerCount; ++var4) {
            var5 = GPI.globalPlayerIndices[var4];
            if ((GPI.playerSkipFlags[var5] & 1) == 0) {
                if (var3 > 0) {
                    --var3;
                    var10000 = GPI.playerSkipFlags;
                    var10000[var5] = (byte) (var10000[var5] | 2);
                } else {
                    var6 = packet.method1398(1);
                    if (var6 == 0) {
                        var7 = packet.method1398(2);
                        if (var7 == 0) {
                            var8 = 0;
                        } else if (var7 == 1) {
                            var8 = packet.method1398(5);
                        } else if (var7 == 2) {
                            var8 = packet.method1398(8);
                        } else {
                            var8 = packet.method1398(11);
                        }

                        var3 = var8;
                        var10000 = GPI.playerSkipFlags;
                        var10000[var5] = (byte) (var10000[var5] | 2);
                    } else if (Statics34.method1168(packet, var5)) {
                        var10000 = GPI.playerSkipFlags;
                        var10000[var5] = (byte) (var10000[var5] | 2);
                    }
                }
            }
        }

        packet.byteAccess();
        if (var3 != 0) {
            throw new RuntimeException();
        }
        GPI.playerCount = 0;
        GPI.globalPlayerCount = 0;

        PlayerEntity player;
        for (var4 = 1; var4 < 2048; ++var4) {
            var10000 = GPI.playerSkipFlags;
            var10000[var4] = (byte) (var10000[var4] >> 1);
            player = client.players[var4];
            if (player != null) {
                GPI.playerIndices[++GPI.playerCount - 1] = var4;
            } else {
                GPI.globalPlayerIndices[++GPI.globalPlayerCount - 1] = var4;
            }
        }

        for (var3 = 0; var3 < GPI.anInt594; ++var3) {
            var4 = GPI.anIntArray588[var3];
            player = client.players[var4];
            var6 = packet.readUByte();
            if ((var6 & 0x1) != 0) {
                var6 += packet.readUByte() << 8;
            }

            byte var9 = -1;
            if ((var6 & 0x100) != 0) {
                for (var7 = 0; var7 < 3; ++var7) {
                    player.actions[var7] = packet.readString();
                }
            }

            if ((var6 & 0x800) != 0) {
                player.graphic = packet.readUShort();
                var7 = packet.readInt();
                player.anInt2014 = var7 >> 16;
                player.graphicDelay = (var7 & 65535) + client.engineCycle;
                player.graphicFrame = 0;
                player.anInt2013 = 0;
                if (player.graphicDelay > client.engineCycle) {
                    player.graphicFrame = -1;
                }

                if (player.graphic == 65535) {
                    player.graphic = -1;
                }
            }

            if ((var6 & 0x2) != 0) {
                player.overheadText = packet.readString();
                if (player.overheadText.charAt(0) == '~') {
                    player.overheadText = player.overheadText.substring(1);
                    Statics19.messageReceived(2, player.namePair.getRaw(), player.overheadText);
                } else if (player == local) {
                    Statics19.messageReceived(2, player.namePair.getRaw(), player.overheadText);
                }

                player.aBoolean2008 = false;
                player.anInt1508 = 0;
                player.anInt1510 = 0;
                player.anInt1344 = 150;
            }

            if ((var6 & 0x8) != 0) {
                var7 = packet.method1072();
                byte[] var11 = new byte[var7];
                Buffer var12 = new Buffer(var11);
                packet.method1016(var11, 0, var7);
                GPI.buffers[var4] = var12;
                player.decode(var12);
            }

            int var14;
            int var15;
            int var18;
            if ((var6 & 0x80) != 0) {
                var7 = packet.readUShort();
                PlayerAccountType var20 = (PlayerAccountType) OldConnection.method716(Statics13.method871(), packet.readUByte());
                boolean var13 = packet.method1072() == 1;
                var14 = packet.method1072();
                var15 = packet.caret;
                if (player.namePair != null && player.appearance != null) {
                    boolean var16 = false;
                    if (var20.aBoolean1258 && client.relationshipSystem.isIgnoring(player.namePair)) {
                        var16 = true;
                    }

                    if (!var16 && client.anInt1014 == 0 && !player.hidden) {
                        GPI.chatBuffer.caret = 0;
                        packet.method1012(GPI.chatBuffer.payload, 0, var14);
                        GPI.chatBuffer.caret = 0;
                        String var17 = BaseFont.method1166(OldConnection.method714(RouteStrategy_Sub1.method294(GPI.chatBuffer)));
                        player.overheadText = var17.trim();
                        player.anInt1508 = var7 >> 8;
                        player.anInt1510 = var7 & 255;
                        player.anInt1344 = 150;
                        player.aBoolean2008 = var13;
                        player.aBoolean2005 = player != local && var20.aBoolean1258 && "" != client.aString1091 && !var17.toLowerCase().contains(client.aString1091);
                        if (var20.aBoolean1257) {
                            var18 = var13 ? 91 : 1;
                        } else {
                            var18 = var13 ? 90 : 2;
                        }

                        if (var20.anInt1218 != -1) {
                            Statics19.messageReceived(var18, Statics26.method1111(var20.anInt1218) + player.namePair.getRaw(), var17);
                        } else {
                            Statics19.messageReceived(var18, player.namePair.getRaw(), var17);
                        }
                    }
                }

                packet.caret = var14 + var15;
            }

            if ((var6 & 0x1000) != 0) {
                GPI.aByteArray596[var4] = packet.readByte();
            }

            if ((var6 & 0x10) != 0) {
                var7 = packet.method1060();
                if (var7 == 65535) {
                    var7 = -1;
                }

                var8 = packet.readUByte();
                LoginPacketMeta.method1497(player, var7, var8);
            }

            if ((var6 & 0x200) != 0) {
                var9 = packet.readByte();
            }

            if ((var6 & 0x400) != 0) {
                player.anInt1354 = packet.method1063();
                player.anInt2011 = packet.method1059();
                player.anInt1351 = packet.method1063();
                player.anInt2016 = packet.method1063();
                player.forceMovementStartCycle = packet.readUShort() + client.engineCycle;
                player.forceMovementEndCycle = packet.method1060() + client.engineCycle;
                player.anInt2019 = packet.method1055();
                if (player.aBoolean1904) {
                    player.anInt1354 += player.anInt704;
                    player.anInt2011 += player.anInt1739;
                    player.anInt1351 += player.anInt704;
                    player.anInt2016 += player.anInt1739;
                    player.pathQueueSize = 0;
                } else {
                    player.anInt1354 += player.pathXQueue[0];
                    player.anInt2011 += player.pathYQueue[0];
                    player.anInt1351 += player.pathXQueue[0];
                    player.anInt2016 += player.pathYQueue[0];
                    player.pathQueueSize = 1;
                }

                player.anInt2023 = 0;
            }

            if ((var6 & 0x4) != 0) {
                var7 = packet.method1056();
                int var19;
                int var22;
                int var23;
                if (var7 > 0) {
                    for (var8 = 0; var8 < var7; ++var8) {
                        var14 = -1;
                        var15 = -1;
                        var23 = -1;
                        var22 = packet.readSmart();
                        if (var22 == 32767) {
                            var22 = packet.readSmart();
                            var15 = packet.readSmart();
                            var14 = packet.readSmart();
                            var23 = packet.readSmart();
                        } else if (var22 != 32766) {
                            var15 = packet.readSmart();
                        } else {
                            var22 = -1;
                        }

                        var19 = packet.readSmart();
                        player.addHitSplat(var22, var15, var14, var23, client.engineCycle, var19);
                    }
                }

                var8 = packet.method1074();
                if (var8 > 0) {
                    for (var22 = 0; var22 < var8; ++var22) {
                        var14 = packet.readSmart();
                        var15 = packet.readSmart();
                        if (var15 != 32767) {
                            var23 = packet.readSmart();
                            var19 = packet.method1056();
                            var18 = var15 > 0 ? packet.method1056() : var19;
                            player.updateHealthBar(var14, client.engineCycle, var15, var23, var19, var18);
                        } else {
                            player.method1503(var14);
                        }
                    }
                }
            }

            if ((var6 & 0x40) != 0) {
                player.targetIndex = packet.method1060();
                if (player.targetIndex == 65535) {
                    player.targetIndex = -1;
                }
            }

            if ((var6 & 0x20) != 0) {
                player.transformedOrientation = packet.readUShort();
                if (player.pathQueueSize == 0) {
                    player.orientation = player.transformedOrientation;
                    player.transformedOrientation = -1;
                }
            }

            if (player.aBoolean1904) {
                if (var9 == 127) {
                    player.method1414(player.anInt704, player.anInt1739);
                } else {
                    byte var21;
                    if (var9 != -1) {
                        var21 = var9;
                    } else {
                        var21 = GPI.aByteArray596[var4];
                    }

                    player.method1415(player.anInt704, player.anInt1739, var21);
                }
            }
        }

        if (packet.caret - var2 != var1) {
            throw new RuntimeException(packet.caret - var2 + " " + var1);
        }
    }

    public static void method1400() {
        for (int var0 = 0; var0 < GPI.playerCount; ++var0) {
            PlayerEntity var1 = client.players[GPI.playerIndices[var0]];
            var1.method23();
        }

        Keyboard.method100();
        if (client.clanSystem != null) {
            client.clanSystem.method1392();
        }

    }

    public static void update(PacketBuffer packet) {
        packet.bitAccess();
        int index = client.playerIndex;
        PlayerEntity player = local = client.players[index] = new PlayerEntity();
        player.index = index;
        int var4 = packet.method1398(30);
        byte var5 = (byte) (var4 >> 28);
        int var6 = var4 >> 14 & 16383;
        int var7 = var4 & 16383;
        player.pathXQueue[0] = var6 - client.baseX;
        player.fineX = (player.pathXQueue[0] << 7) + (player.boundSize() << 6);
        player.pathYQueue[0] = var7 - client.baseY;
        player.fineY = (player.pathYQueue[0] << 7) + (player.boundSize() << 6);
        SceneGraph.floorLevel = player.anInt1473 = var5;
        if (GPI.buffers[index] != null) {
            player.decode(GPI.buffers[index]);
        }

        GPI.playerCount = 0;
        GPI.playerIndices[++GPI.playerCount - 1] = index;
        GPI.playerSkipFlags[index] = 0;
        GPI.globalPlayerCount = 0;

        for (int var8 = 1; var8 < 2048; ++var8) {
            if (index != var8) {
                int var9 = packet.method1398(18);
                int var10 = var9 >> 16;
                int var11 = var9 >> 8 & 597;
                int var12 = var9 & 597;
                GPI.playerLocations[var8] = (var11 << 14) + var12 + (var10 << 28);
                GPI.playerOrientations[var8] = 0;
                GPI.playerTargetIndices[var8] = -1;
                GPI.globalPlayerIndices[++GPI.globalPlayerCount - 1] = var8;
                GPI.playerSkipFlags[var8] = 0;
            }
        }

        packet.byteAccess();
    }

    public final Model getModel() {
        if (this.appearance == null) {
            return null;
        }
        AnimationSequence var1 = super.animation != -1 && super.animationDelay == 0 ? AnimationSequence.get(super.animation) : null;
        AnimationSequence var2 = super.stance != -1 && !this.aBoolean1905 && (super.stance != super.walkingStance || var1 == null) ? AnimationSequence.get(super.stance) : null;
        Model var3 = this.appearance.getModel(var1, super.animationFrame, var2, super.stanceFrame);
        if (var3 == null) {
            return null;
        }
        var3.method827();
        super.anInt2021 = var3.height;
        Model var4;
        Model[] var5;
        if (!this.aBoolean1905 && super.graphic != -1 && super.graphicFrame != -1) {
            var4 = EffectAnimation.get(super.graphic).method1004(super.graphicFrame);
            if (var4 != null) {
                var4.method832(0, -super.anInt2014, 0);
                var5 = new Model[]{var3, var4};
                var3 = new Model(var5, 2);
            }
        }

        if (!this.aBoolean1905 && this.transformedNpcModel != null) {
            if (client.engineCycle >= this.anInt368) {
                this.transformedNpcModel = null;
            }

            if (client.engineCycle >= this.anInt564 && client.engineCycle < this.anInt368) {
                var4 = this.transformedNpcModel;
                var4.method832(this.anInt367 * super.fineX, this.anInt386 - this.anInt379, this.anInt366 * super.fineY);
                if (super.orientation == 512) {
                    var4.method1283();
                    var4.method1283();
                    var4.method1283();
                } else if (super.orientation == 1024) {
                    var4.method1283();
                    var4.method1283();
                } else if (super.orientation == 1536) {
                    var4.method1283();
                }

                var5 = new Model[]{var3, var4};
                var3 = new Model(var5, 2);
                if (super.orientation == 512) {
                    var4.method1283();
                } else if (super.orientation == 1024) {
                    var4.method1283();
                    var4.method1283();
                } else if (super.orientation == 1536) {
                    var4.method1283();
                    var4.method1283();
                    var4.method1283();
                }

                var4.method832(super.fineX - this.anInt367, this.anInt379 - this.anInt386, super.fineY - this.anInt366);
            }
        }

        var3.aabbEnabled = true;
        return var3;
    }

    public void method828() {
        this.aChatLinePrivacyType_1906 = client.clanSystem != null && client.clanSystem.isCached(this.namePair) ? ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1555 : ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1553;
    }

    public void method775() {
        this.aChatLinePrivacyType_1907 = client.relationshipSystem.isFriendLoggedIn(this.namePair) ? ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1555 : ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1553;
    }

    public void method1414(int var1, int var2) {
        super.pathQueueSize = 0;
        super.anInt2023 = 0;
        super.anInt2022 = 0;
        super.pathXQueue[0] = var1;
        super.pathYQueue[0] = var2;
        int size = this.boundSize();
        super.fineX = size * 64 + super.pathXQueue[0] * 128;
        super.fineY = size * 64 + super.pathYQueue[0] * 128;
    }

    public int boundSize() {
        return this.appearance != null && this.appearance.transformedNpcId != -1 ? NpcDefinition.get(this.appearance.transformedNpcId).size : 1;
    }

    public void method23() {
        this.aChatLinePrivacyType_1907 = ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1554;
    }

    public final void method1413(int var1, int var2, byte var3) {
        if (super.pathQueueSize < 9) {
            ++super.pathQueueSize;
        }

        for (int var4 = super.pathQueueSize; var4 > 0; --var4) {
            super.pathXQueue[var4] = super.pathXQueue[var4 - 1];
            super.pathYQueue[var4] = super.pathYQueue[var4 - 1];
            super.pathQueueTraversed[var4] = super.pathQueueTraversed[var4 - 1];
        }

        super.pathXQueue[0] = var1;
        super.pathYQueue[0] = var2;
        super.pathQueueTraversed[0] = var3;
    }

    public final void decode(Buffer buffer) {
        buffer.caret = 0;
        int var2 = buffer.readUByte();
        this.prayerIcon = buffer.readByte();
        this.skullIcon = buffer.readByte();
        int var3 = -1;
        this.team = 0;
        int[] var4 = new int[12];

        int var6;
        int var8;
        for (int var5 = 0; var5 < 12; ++var5) {
            var6 = buffer.readUByte();
            if (var6 == 0) {
                var4[var5] = 0;
            } else {
                var8 = buffer.readUByte();
                var4[var5] = var8 + (var6 << 8);
                if (var5 == 0 && var4[0] == 65535) {
                    var3 = buffer.readUShort();
                    break;
                }

                if (var4[var5] >= 512) {
                    int var9 = ItemDefinition.get(var4[var5] - 512).team;
                    if (var9 != 0) {
                        this.team = var9;
                    }
                }
            }
        }

        int[] var7 = new int[5];

        for (var6 = 0; var6 < 5; ++var6) {
            var8 = buffer.readUByte();
            if (var8 < 0 || var8 >= PlayerAppearance.aShortArrayArray1928[var6].length) {
                var8 = 0;
            }

            var7[var6] = var8;
        }

        super.walkingStance = buffer.readUShort();
        if (super.walkingStance == 65535) {
            super.walkingStance = -1;
        }

        super.anInt709 = buffer.readUShort();
        if (super.anInt709 == 65535) {
            super.anInt709 = -1;
        }

        super.anInt1424 = super.anInt709;
        super.anInt710 = buffer.readUShort();
        if (super.anInt710 == 65535) {
            super.anInt710 = -1;
        }

        super.anInt2006 = buffer.readUShort();
        if (super.anInt2006 == 65535) {
            super.anInt2006 = -1;
        }

        super.anInt1857 = buffer.readUShort();
        if (super.anInt1857 == 65535) {
            super.anInt1857 = -1;
        }

        super.anInt1858 = buffer.readUShort();
        if (super.anInt1858 == 65535) {
            super.anInt1858 = -1;
        }

        super.anInt2007 = buffer.readUShort();
        if (super.anInt2007 == 65535) {
            super.anInt2007 = -1;
        }

        this.namePair = new NamePair(buffer.readString(), PreciseWorldMapAreaChunk.aClientParameter_343);
        this.method23();
        this.method827();
        if (this == local) {
            Jagception.aString1882 = this.namePair.getRaw();
        }

        this.combatLevel = buffer.readUByte();
        this.skillLevel = buffer.readUShort();
        this.hidden = buffer.readUByte() == 1;
        if (client.anInt925 == 0 && client.rights >= 2) {
            this.hidden = false;
        }

        if (this.appearance == null) {
            this.appearance = new PlayerAppearance();
        }

        this.appearance.update(var4, var7, var2 == 1, var3);
    }

    public void method827() {
        this.aChatLinePrivacyType_1906 = ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1554;
    }

    public final boolean isDefined() {
        return this.appearance != null;
    }

    public boolean method609() {
        if (this.aChatLinePrivacyType_1907 == ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1554) {
            this.method775();
        }

        return this.aChatLinePrivacyType_1907 == ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1555;
    }

    public boolean method258() {
        if (this.aChatLinePrivacyType_1906 == ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1554) {
            this.method828();
        }

        return this.aChatLinePrivacyType_1906 == ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1555;
    }

    public final void method1415(int sceneX, int sceneY, byte var3) {
        if (super.animation != -1 && AnimationSequence.get(super.animation).walkingPrecedence == 1) {
            super.animation = -1;
        }

        super.transformedOrientation = -1;
        if (sceneX >= 0 && sceneX < 104 && sceneY >= 0 && sceneY < 104) {
            if (super.pathXQueue[0] >= 0 && super.pathXQueue[0] < 104 && super.pathYQueue[0] >= 0 && super.pathYQueue[0] < 104) {
                if (var3 == 2) {
                    SerializableInteger.method406(this, sceneX, sceneY);
                }

                this.method1413(sceneX, sceneY, var3);
            } else {
                this.method1414(sceneX, sceneY);
            }
        } else {
            this.method1414(sceneX, sceneY);
        }

    }
}
