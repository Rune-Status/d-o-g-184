package jag.game.scene.entity;

import jag.EnumType;
import jag.PlayerAccountType;
import jag.DefaultRouteStrategy;
import jag.SerializableInteger;
import jag.commons.Jagexception;
import jag.commons.input.Keyboard;
import jag.game.PlayerModel;
import jag.game.client;
import jag.game.relationship.ChatHistory;
import jag.game.relationship.ChatLinePrivacyType;
import jag.game.relationship.NamePair;
import jag.game.scene.SceneGraph;
import jag.game.type.AnimationSequence;
import jag.game.type.EffectAnimation;
import jag.game.type.ItemDefinition;
import jag.game.type.NpcDefinition;
import jag.graphics.BaseFont;
import jag.opcode.*;
import jag.opcode.login.LoginPacketMeta;
import jag.statics.Statics26;
import jag.statics.Statics34;
import jag.worldmap.PreciseWorldMapAreaChunk;

public final class PlayerEntity extends PathingEntity {

    public static PlayerEntity local;
    public final String[] actions;
    public PlayerModel model;
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
    public int animationStartCycle;
    public int animationEndCycle;
    public boolean hidden;
    public boolean aBoolean1904;
    public Model transformedNpcModel;
    public int floorLevel;
    public int maxX;
    public int anInt386;
    public int anInt379;
    public int maxY;
    public int anInt702;
    public int anInt666;
    public int anInt788;
    public int anInt791;
    public int anInt704;
    public int anInt1739;

    public PlayerEntity() {
        prayerIcon = -1;
        skullIcon = -1;
        actions = new String[3];

        for (int i = 0; i < 3; ++i) {
            actions[i] = "";
        }

        combatLevel = 0;
        skillLevel = 0;
        animationStartCycle = 0;
        animationEndCycle = 0;
        aBoolean1905 = false;
        team = 0;
        hidden = false;
        aChatLinePrivacyType_1907 = ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1554;
        aChatLinePrivacyType_1906 = ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1554;
        aBoolean1904 = false;
    }

    public static void update(PacketBuffer packet, int var1) {
        int var2 = packet.pos;
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
                    var6 = packet.g(1);
                    if (var6 == 0) {
                        var7 = packet.g(2);
                        if (var7 == 0) {
                            var8 = 0;
                        } else if (var7 == 1) {
                            var8 = packet.g(5);
                        } else if (var7 == 2) {
                            var8 = packet.g(8);
                        } else {
                            var8 = packet.g(11);
                        }

                        var3 = var8;
                        var10000 = GPI.playerSkipFlags;
                        var10000[var5] = (byte) (var10000[var5] | 2);
                    } else {
                        GPI.updatePlayerLocation(packet, var5);
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
                    var6 = packet.g(1);
                    if (var6 == 0) {
                        var7 = packet.g(2);
                        if (var7 == 0) {
                            var8 = 0;
                        } else if (var7 == 1) {
                            var8 = packet.g(5);
                        } else if (var7 == 2) {
                            var8 = packet.g(8);
                        } else {
                            var8 = packet.g(11);
                        }

                        var3 = var8;
                        var10000 = GPI.playerSkipFlags;
                        var10000[var5] = (byte) (var10000[var5] | 2);
                    } else {
                        GPI.updatePlayerLocation(packet, var5);
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
                    var6 = packet.g(1);
                    if (var6 == 0) {
                        var7 = packet.g(2);
                        if (var7 == 0) {
                            var8 = 0;
                        } else if (var7 == 1) {
                            var8 = packet.g(5);
                        } else if (var7 == 2) {
                            var8 = packet.g(8);
                        } else {
                            var8 = packet.g(11);
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
                    var6 = packet.g(1);
                    if (var6 == 0) {
                        var7 = packet.g(2);
                        if (var7 == 0) {
                            var8 = 0;
                        } else if (var7 == 1) {
                            var8 = packet.g(5);
                        } else if (var7 == 2) {
                            var8 = packet.g(8);
                        } else {
                            var8 = packet.g(11);
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
            var6 = packet.g1();
            if ((var6 & 0x1) != 0) {
                var6 += packet.g1() << 8;
            }

            byte var9 = -1;
            if ((var6 & 0x100) != 0) {
                for (var7 = 0; var7 < 3; ++var7) {
                    player.actions[var7] = packet.gstr();
                }
            }

            if ((var6 & 0x800) != 0) {
                player.graphic = packet.g2();
                var7 = packet.g4();
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
                player.overheadText = packet.gstr();
                if (player.overheadText.charAt(0) == '~') {
                    player.overheadText = player.overheadText.substring(1);
                    ChatHistory.messageReceived(2, player.namePair.getRaw(), player.overheadText);
                } else if (player == local) {
                    ChatHistory.messageReceived(2, player.namePair.getRaw(), player.overheadText);
                }

                player.aBoolean2008 = false;
                player.anInt1508 = 0;
                player.anInt1510 = 0;
                player.anInt1344 = 150;
            }

            if ((var6 & 0x8) != 0) {
                var7 = packet.ig1();
                byte[] var11 = new byte[var7];
                Buffer var12 = new Buffer(var11);
                packet.igdataa(var11, 0, var7);
                GPI.buffers[var4] = var12;
                player.decode(var12);
            }

            int var14;
            int var15;
            int var18;
            if ((var6 & 0x80) != 0) {
                var7 = packet.g2();
                PlayerAccountType var20 = (PlayerAccountType) EnumType.getByOrdinal(PlayerAccountType.getValues(), packet.g1());
                boolean var13 = packet.ig1() == 1;
                var14 = packet.ig1();
                var15 = packet.pos;
                if (player.namePair != null && player.model != null) {
                    boolean var16 = false;
                    if (var20.aBoolean1258 && client.relationshipSystem.isIgnoring(player.namePair)) {
                        var16 = true;
                    }

                    if (!var16 && client.anInt1014 == 0 && !player.hidden) {
                        GPI.chatBuffer.pos = 0;
                        packet.igdata(GPI.chatBuffer.payload, 0, var14);
                        GPI.chatBuffer.pos = 0;
                        String var17 = BaseFont.method1166(OldConnection.method714(DefaultRouteStrategy.method294(GPI.chatBuffer)));
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
                            ChatHistory.messageReceived(var18, Statics26.addImgTags(var20.anInt1218) + player.namePair.getRaw(), var17);
                        } else {
                            ChatHistory.messageReceived(var18, player.namePair.getRaw(), var17);
                        }
                    }
                }

                packet.pos = var14 + var15;
            }

            if ((var6 & 0x1000) != 0) {
                GPI.aByteArray596[var4] = packet.g1b();
            }

            if ((var6 & 0x10) != 0) {
                var7 = packet.method1060();
                if (var7 == 65535) {
                    var7 = -1;
                }

                var8 = packet.g1();
                LoginPacketMeta.method1497(player, var7, var8);
            }

            if ((var6 & 0x200) != 0) {
                var9 = packet.g1b();
            }

            if ((var6 & 0x400) != 0) {
                player.anInt1354 = packet.method1063();
                player.anInt2011 = packet.method1059();
                player.anInt1351 = packet.method1063();
                player.anInt2016 = packet.method1063();
                player.forceMovementStartCycle = packet.g2() + client.engineCycle;
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
                        var22 = packet.gsmarts();
                        if (var22 == 32767) {
                            var22 = packet.gsmarts();
                            var15 = packet.gsmarts();
                            var14 = packet.gsmarts();
                            var23 = packet.gsmarts();
                        } else if (var22 != 32766) {
                            var15 = packet.gsmarts();
                        } else {
                            var22 = -1;
                        }

                        var19 = packet.gsmarts();
                        player.addHitSplat(var22, var15, var14, var23, client.engineCycle, var19);
                    }
                }

                var8 = packet.method1074();
                if (var8 > 0) {
                    for (var22 = 0; var22 < var8; ++var22) {
                        var14 = packet.gsmarts();
                        var15 = packet.gsmarts();
                        if (var15 != 32767) {
                            var23 = packet.gsmarts();
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
                player.transformedOrientation = packet.g2();
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

        if (packet.pos - var2 != var1) {
            throw new RuntimeException(packet.pos - var2 + " " + var1);
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
        int var4 = packet.g(30);
        byte var5 = (byte) (var4 >> 28);
        int var6 = var4 >> 14 & 16383;
        int var7 = var4 & 16383;
        player.pathXQueue[0] = var6 - client.baseX;
        player.absoluteX = (player.pathXQueue[0] << 7) + (player.boundSize() << 6);
        player.pathYQueue[0] = var7 - client.baseY;
        player.absoluteY = (player.pathYQueue[0] << 7) + (player.boundSize() << 6);
        SceneGraph.floorLevel = player.floorLevel = var5;
        if (GPI.buffers[index] != null) {
            player.decode(GPI.buffers[index]);
        }

        GPI.playerCount = 0;
        GPI.playerIndices[++GPI.playerCount - 1] = index;
        GPI.playerSkipFlags[index] = 0;
        GPI.globalPlayerCount = 0;

        for (int var8 = 1; var8 < 2048; ++var8) {
            if (index != var8) {
                int var9 = packet.g(18);
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
        if (model == null) {
            return null;
        }
        AnimationSequence var1 = super.animation != -1 && super.animationDelay == 0 ? AnimationSequence.get(super.animation) : null;
        AnimationSequence var2 = super.stance != -1 && !aBoolean1905 && (super.stance != super.idleStance || var1 == null) ? AnimationSequence.get(super.stance) : null;
        Model var3 = model.getModel(var1, super.animationFrame, var2, super.stanceFrame);
        if (var3 == null) {
            return null;
        }
        var3.computeBounds();
        super.anInt2021 = var3.height;
        Model var4;
        Model[] var5;
        if (!aBoolean1905 && super.graphic != -1 && super.graphicFrame != -1) {
            var4 = EffectAnimation.get(super.graphic).method1004(super.graphicFrame);
            if (var4 != null) {
                var4.method832(0, -super.anInt2014, 0);
                var5 = new Model[]{var3, var4};
                var3 = new Model(var5, 2);
            }
        }

        if (!aBoolean1905 && transformedNpcModel != null) {
            if (client.engineCycle >= animationEndCycle) {
                transformedNpcModel = null;
            }

            if (client.engineCycle >= animationStartCycle && client.engineCycle < animationEndCycle) {
                var4 = transformedNpcModel;
                var4.method832(maxX * super.absoluteX, anInt386 - anInt379, maxY * super.absoluteY);
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

                var4.method832(super.absoluteX - maxX, anInt379 - anInt386, super.absoluteY - maxY);
            }
        }

        var3.aabbEnabled = true;
        return var3;
    }

    public void method828() {
        aChatLinePrivacyType_1906 = client.clanSystem != null && client.clanSystem.isCached(namePair) ? ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1555 : ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1553;
    }

    public void method775() {
        aChatLinePrivacyType_1907 = client.relationshipSystem.isFriendLoggedIn(namePair) ? ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1555 : ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1553;
    }

    public void method1414(int var1, int var2) {
        super.pathQueueSize = 0;
        super.anInt2023 = 0;
        super.anInt2022 = 0;
        super.pathXQueue[0] = var1;
        super.pathYQueue[0] = var2;
        int size = boundSize();
        super.absoluteX = size * 64 + super.pathXQueue[0] * 128;
        super.absoluteY = size * 64 + super.pathYQueue[0] * 128;
    }

    public int boundSize() {
        return model != null && model.transformedNpcId != -1 ? NpcDefinition.get(model.transformedNpcId).size : 1;
    }

    public void method23() {
        aChatLinePrivacyType_1907 = ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1554;
    }

    public final void method1413(int var1, int var2, byte var3) {
        if (super.pathQueueSize < 9) {
            ++super.pathQueueSize;
        }

        for (int i = super.pathQueueSize; i > 0; --i) {
            super.pathXQueue[i] = super.pathXQueue[i - 1];
            super.pathYQueue[i] = super.pathYQueue[i - 1];
            super.pathQueueTraversed[i] = super.pathQueueTraversed[i - 1];
        }

        super.pathXQueue[0] = var1;
        super.pathYQueue[0] = var2;
        super.pathQueueTraversed[0] = var3;
    }

    public final void decode(Buffer buffer) {
        buffer.pos = 0;
        int var2 = buffer.g1();
        prayerIcon = buffer.g1b();
        skullIcon = buffer.g1b();
        int var3 = -1;
        team = 0;
        int[] var4 = new int[12];

        int var6;
        int var8;
        for (int var5 = 0; var5 < 12; ++var5) {
            var6 = buffer.g1();
            if (var6 == 0) {
                var4[var5] = 0;
            } else {
                var8 = buffer.g1();
                var4[var5] = var8 + (var6 << 8);
                if (var5 == 0 && var4[0] == 65535) {
                    var3 = buffer.g2();
                    break;
                }

                if (var4[var5] >= 512) {
                    int var9 = ItemDefinition.get(var4[var5] - 512).team;
                    if (var9 != 0) {
                        team = var9;
                    }
                }
            }
        }

        int[] var7 = new int[5];

        for (var6 = 0; var6 < 5; ++var6) {
            var8 = buffer.g1();
            if (var8 < 0 || var8 >= PlayerModel.colors[var6].length) {
                var8 = 0;
            }

            var7[var6] = var8;
        }

        super.idleStance = buffer.g2();
        if (super.idleStance == 65535) {
            super.idleStance = -1;
        }

        super.turnLeftStance = buffer.g2();
        if (super.turnLeftStance == 65535) {
            super.turnLeftStance = -1;
        }

        super.turnRightStance = super.turnLeftStance;
        super.walkStance = buffer.g2();
        if (super.walkStance == 65535) {
            super.walkStance = -1;
        }

        super.turnAroundStance = buffer.g2();
        if (super.turnAroundStance == 65535) {
            super.turnAroundStance = -1;
        }

        super.walkLeftStance = buffer.g2();
        if (super.walkLeftStance == 65535) {
            super.walkLeftStance = -1;
        }

        super.walkRightStance = buffer.g2();
        if (super.walkRightStance == 65535) {
            super.walkRightStance = -1;
        }

        super.anInt2007 = buffer.g2();
        if (super.anInt2007 == 65535) {
            super.anInt2007 = -1;
        }

        namePair = new NamePair(buffer.gstr(), PreciseWorldMapAreaChunk.nameLengthParameter);
        method23();
        method827();
        if (this == local) {
            Jagexception.aString1882 = namePair.getRaw();
        }

        combatLevel = buffer.g1();
        skillLevel = buffer.g2();
        hidden = buffer.g1() == 1;
        if (client.gameType == 0 && client.rights >= 2) {
            hidden = false;
        }

        if (model == null) {
            model = new PlayerModel();
        }

        model.update(var4, var7, var2 == 1, var3);
    }

    public void method827() {
        aChatLinePrivacyType_1906 = ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1554;
    }

    public final boolean isDefined() {
        return model != null;
    }

    public boolean method609() {
        if (aChatLinePrivacyType_1907 == ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1554) {
            method775();
        }

        return aChatLinePrivacyType_1907 == ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1555;
    }

    public boolean method258() {
        if (aChatLinePrivacyType_1906 == ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1554) {
            method828();
        }

        return aChatLinePrivacyType_1906 == ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1555;
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

                method1413(sceneX, sceneY, var3);
            } else {
                method1414(sceneX, sceneY);
            }
        } else {
            method1414(sceneX, sceneY);
        }

    }
}
