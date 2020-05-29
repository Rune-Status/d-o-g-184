package jag.game.option;

import jag.audi.AudioSystem;
import jag.audi.ObjectSound;
import jag.commons.collection.NodeDeque;
import jag.game.InterfaceComponent;
import jag.game.client;
import jag.game.scene.SceneGraph;
import jag.game.scene.entity.*;
import jag.game.type.NpcDefinition;
import jag.graphics.IndexedSprite;
import jag.graphics.JagGraphics;
import jag.graphics.Sprite;
import jag.graphics.SpriteClip;
import jag.js5.ReferenceTable;
import jag.opcode.Buffer;
import jag.opcode.GPI;
import jag.statics.Statics17;
import jag.statics.Statics47;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class ClientPreferences {
    public static final int anInt365;
    public static ReferenceTable aReferenceTable364;
    public static IndexedSprite aDoublyNode_Sub24_Sub4_363;

    static {
        anInt365 = 6;
    }

    public int resizable;
    public String aString362;
    public boolean roofsHidden;
    public boolean rememberMe;
    public LinkedHashMap properties;
    public boolean loginScreenAudioDisabled;

    public ClientPreferences() {
        this.resizable = 1;
        this.aString362 = null;
        this.rememberMe = false;
        this.properties = new LinkedHashMap();
        this.method252();
    }

    public ClientPreferences(Buffer var1) {
        this.resizable = 1;
        this.aString362 = null;
        this.rememberMe = false;
        this.properties = new LinkedHashMap();
        if (var1 != null && var1.payload != null) {
            int var2 = var1.readUByte();
            if (var2 >= 0 && var2 <= anInt365) {
                if (var1.readUByte() == 1) {
                    this.roofsHidden = true;
                }

                if (var2 > 1) {
                    this.loginScreenAudioDisabled = var1.readUByte() == 1;
                }

                if (var2 > 3) {
                    this.resizable = var1.readUByte();
                }

                if (var2 > 2) {
                    int var3 = var1.readUByte();

                    for (int var4 = 0; var4 < var3; ++var4) {
                        int var5 = var1.readInt();
                        int var6 = var1.readInt();
                        this.properties.put(var5, var6);
                    }
                }

                if (var2 > 4) {
                    this.aString362 = var1.readCheckedString();
                }

                if (var2 > 5) {
                    this.rememberMe = var1.readBoolean();
                }
            } else {
                this.method252();
            }
        } else {
            this.method252();
        }

    }

    public static void renderMinimap(InterfaceComponent var0, int var1, int var2, int var3) {
        AudioSystem.process();
        SpriteClip var4 = var0.method959(false);
        if (var4 != null) {
            JagGraphics.setClip(var1, var2, var4.anInt380 + var1, var2 + var4.anInt568);
            if (client.mapState != 2 && client.mapState != 5) {
                int var5 = client.mapRotation & 2047;
                int var6 = PlayerEntity.local.fineX / 32 + 48;
                int var7 = 464 - PlayerEntity.local.fineY / 32;
                ObjectSound.minimapSprite.rotate(var1, var2, var4.anInt380, var4.anInt568, var6, var7, var5, 256, var4.anIntArray1108, var4.anIntArray749);

                int var8;
                int var9;
                int var10;
                for (var8 = 0; var8 < client.anInt895; ++var8) {
                    var9 = client.anIntArray892[var8] * 4 + 2 - PlayerEntity.local.fineX / 32;
                    var10 = client.anIntArray894[var8] * 4 + 2 - PlayerEntity.local.fineY / 32;
                    Statics17.method891(var1, var2, var9, var10, client.minimapFunctions[var8], var4);
                }

                int var12;
                int var13;
                for (var8 = 0; var8 < 104; ++var8) {
                    for (var9 = 0; var9 < 104; ++var9) {
                        NodeDeque<Pickable> var11 = client.pickableNodeDeques[SceneGraph.floorLevel][var8][var9];
                        if (var11 != null) {
                            var12 = var8 * 4 + 2 - PlayerEntity.local.fineX / 32;
                            var13 = var9 * 4 + 2 - PlayerEntity.local.fineY / 32;
                            Statics17.method891(var1, var2, var12, var13, Statics47.mapmarkers[0], var4);
                        }
                    }
                }

                for (var8 = 0; var8 < client.npcCount; ++var8) {
                    NpcEntity var14 = client.npcs[client.npcIndices[var8]];
                    if (var14 != null && var14.isDefined()) {
                        NpcDefinition var18 = var14.definition;
                        if (var18 != null && var18.transformIds != null) {
                            var18 = var18.transform();
                        }

                        if (var18 != null && var18.renderedOnMinimap && var18.aBoolean703) {
                            var12 = var14.fineX / 32 - PlayerEntity.local.fineX / 32;
                            var13 = var14.fineY / 32 - PlayerEntity.local.fineY / 32;
                            Statics17.method891(var1, var2, var12, var13, Statics47.mapmarkers[1], var4);
                        }
                    }
                }

                var8 = GPI.playerCount;
                int[] var21 = GPI.playerIndices;

                for (var10 = 0; var10 < var8; ++var10) {
                    PlayerEntity var15 = client.players[var21[var10]];
                    if (var15 != null && var15.isDefined() && !var15.hidden && var15 != PlayerEntity.local) {
                        var13 = var15.fineX / 32 - PlayerEntity.local.fineX / 32;
                        int var16 = var15.fineY / 32 - PlayerEntity.local.fineY / 32;
                        boolean var17 = false;
                        if (var15.team != 0 && var15.team == PlayerEntity.local.team) {
                            var17 = true;
                        }

                        if (var15.method609()) {
                            Statics17.method891(var1, var2, var13, var16, Statics47.mapmarkers[3], var4);
                        } else if (var17) {
                            Statics17.method891(var1, var2, var13, var16, Statics47.mapmarkers[4], var4);
                        } else if (var15.method258()) {
                            Statics17.method891(var1, var2, var13, var16, Statics47.mapmarkers[5], var4);
                        } else {
                            Statics17.method891(var1, var2, var13, var16, Statics47.mapmarkers[2], var4);
                        }
                    }
                }

                if (client.hintArrowType != 0 && client.engineCycle % 20 < 10) {
                    if (client.hintArrowType == 1 && client.hintArrowNpcIndex >= 0 && client.hintArrowNpcIndex < client.npcs.length) {
                        NpcEntity var19 = client.npcs[client.hintArrowNpcIndex];
                        if (var19 != null) {
                            var12 = var19.fineX / 32 - PlayerEntity.local.fineX / 32;
                            var13 = var19.fineY / 32 - PlayerEntity.local.fineY / 32;
                            SceneGraph.method1(var1, var2, var12, var13, Sprite.mapfunctions[1], var4);
                        }
                    }

                    if (client.hintArrowType == 2) {
                        var10 = client.hintArrowX * 4 - client.baseX * 256 + 2 - PlayerEntity.local.fineX / 32;
                        var12 = client.hintArrowY * 4 - client.baseY * 256 + 2 - PlayerEntity.local.fineY / 32;
                        SceneGraph.method1(var1, var2, var10, var12, Sprite.mapfunctions[1], var4);
                    }

                    if (client.hintArrowType == 10 && client.hintArrowPlayerIndex >= 0 && client.hintArrowPlayerIndex < client.players.length) {
                        PlayerEntity var20 = client.players[client.hintArrowPlayerIndex];
                        if (var20 != null) {
                            var12 = var20.fineX / 32 - PlayerEntity.local.fineX / 32;
                            var13 = var20.fineY / 32 - PlayerEntity.local.fineY / 32;
                            SceneGraph.method1(var1, var2, var12, var13, Sprite.mapfunctions[1], var4);
                        }
                    }
                }

                if (client.destinationX != 0) {
                    var10 = client.destinationX * 4 + 2 - PlayerEntity.local.fineX / 32;
                    var12 = client.destinationY * 4 + 2 - PlayerEntity.local.fineY / 32;
                    Statics17.method891(var1, var2, var10, var12, Sprite.mapfunctions[0], var4);
                }

                if (!PlayerEntity.local.hidden) {
                    JagGraphics.fillRect(var4.anInt380 / 2 + var1 - 1, var4.anInt568 / 2 + var2 - 1, 3, 3, 16777215);
                }
            } else {
                JagGraphics.method1362(var1, var2, 0, var4.anIntArray1108, var4.anIntArray749);
            }

            client.aBooleanArray1087[var3] = true;
        }
    }

    public static void method250() {
        GPI.playerCount = 0;

        for (int var0 = 0; var0 < 2048; ++var0) {
            GPI.buffers[var0] = null;
            GPI.aByteArray596[var0] = 1;
        }

    }

    public void method252() {
    }

    public Buffer method253() {
        Buffer var1 = new Buffer(100);
        var1.writeByte(anInt365);
        var1.writeByte(this.roofsHidden ? 1 : 0);
        var1.writeByte(this.loginScreenAudioDisabled ? 1 : 0);
        var1.writeByte(this.resizable);
        var1.writeByte(this.properties.size());

        for (Object o : this.properties.entrySet()) {
            Entry var3 = (Entry) o;
            var1.writeInt((Integer) var3.getKey());
            var1.writeInt((Integer) var3.getValue());
        }

        var1.writeCString(this.aString362 != null ? this.aString362 : "");
        var1.writeBoolean(this.rememberMe);
        return var1;
    }
}
