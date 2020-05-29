package jag.game.scene.entity;

import jag.SecureRandomService;
import jag.audi.AudioOverrideEffect;
import jag.audi.PcmStream;
import jag.commons.input.Keyboard;
import jag.game.client;
import jag.game.scene.SceneGraph;
import jag.game.type.AnimationSequence;
import jag.game.type.ObjectDefinition;
import jag.opcode.OutgoingPacketMeta;
import jag.statics.Statics45;
import jag.statics.Statics50;
import jag.statics.Statics57;
import jag.statics.Statics8;
import jag.worldmap.WorldMapChunkType;

public class DynamicObject extends Entity {

    public final int anInt693;
    public final int type;
    public final int orientation;
    public final int floorLevel;
    public final int sceneX;
    public final int sceneY;
    public AnimationSequence sequence;
    public int anInt379;
    public int anInt372;

    public DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Entity var9) {
        this.anInt693 = var1;
        this.type = var2;
        this.orientation = var3;
        this.floorLevel = var4;
        this.sceneX = var5;
        this.sceneY = var6;
        if (var7 != -1) {
            this.sequence = AnimationSequence.get(var7);
            this.anInt372 = 0;
            this.anInt379 = client.engineCycle - 1;
            if (this.sequence.replayMode == 0 && var9 instanceof DynamicObject) {
                DynamicObject var10 = (DynamicObject) var9;
                if (var10.sequence == this.sequence) {
                    this.anInt372 = var10.anInt372;
                    this.anInt379 = var10.anInt379;
                    return;
                }
            }

            if (var8 && this.sequence.loopOffset != -1) {
                this.anInt372 = (int) (Math.random() * (double) this.sequence.frameIds.length);
                this.anInt379 -= (int) (Math.random() * (double) this.sequence.frameLengths[this.anInt372]);
            }
        }

    }

    public static void method1506() {
        client.connectionContext.stop();
        client.gc();
        client.sceneGraph.method1486();

        for (int var0 = 0; var0 < 4; ++var0) {
            client.collisionMaps[var0].initialize();
        }

        System.gc();
        Statics57.anInt1157 = 1;
        Statics57.aReferenceTable1155 = null;
        Statics8.anInt1122 = -1;
        Statics50.anInt327 = -1;
        Pickable.anInt379 = 0;
        WorldMapChunkType.aBoolean620 = false;
        AudioOverrideEffect.anInt1130 = 2;
        client.anInt898 = -1;
        client.aBoolean904 = false;
        OutgoingPacketMeta.method4();
        client.setGameState(10);
    }

    public static void method1507(PcmStream var0) {
        var0.aBoolean665 = false;
        if (var0.aVorbisNode_667 != null) {
            var0.aVorbisNode_667.anInt112 = 0;
        }

        for (PcmStream var1 = var0.method307(); var1 != null; var1 = var0.method308()) {
            method1507(var1);
        }

    }

    public static boolean method1114() {
        synchronized (Keyboard.instance) {
            if (Keyboard.anInt162 == Keyboard.anInt157) {
                return false;
            }
            SecureRandomService.anInt457 = Keyboard.anIntArray148[Keyboard.anInt157];
            Keyboard.aChar151 = Keyboard.aCharArray156[Keyboard.anInt157];
            Keyboard.anInt157 = Keyboard.anInt157 + 1 & 127;
            return true;
        }
    }

    public static void loadProjectilesIntoScene() {
        for (Projectile projectile = client.projectiles.head(); projectile != null; projectile = client.projectiles.next()) {
            if (projectile.floorLevel == SceneGraph.floorLevel && client.engineCycle <= projectile.endCycle) {
                if (client.engineCycle >= projectile.startCycle) {
                    if (projectile.targetIndex > 0) {
                        NpcEntity npc = client.npcs[projectile.targetIndex - 1];
                        if (npc != null && npc.fineX >= 0 && npc.fineX < 13312 && npc.fineY >= 0 && npc.fineY < 13312) {
                            projectile.target(npc.fineX, npc.fineY, SceneGraph.getTileHeight(npc.fineX, npc.fineY, projectile.floorLevel) - projectile.anInt112, client.engineCycle);
                        }
                    }

                    if (projectile.targetIndex < 0) {
                        int var2 = -projectile.targetIndex - 1;
                        PlayerEntity player;
                        if (var2 == client.playerIndex) {
                            player = PlayerEntity.local;
                        } else {
                            player = client.players[var2];
                        }

                        if (player != null && player.fineX >= 0 && player.fineX < 13312 && player.fineY >= 0 && player.fineY < 13312) {
                            projectile.target(player.fineX, player.fineY, SceneGraph.getTileHeight(player.fineX, player.fineY, projectile.floorLevel) - projectile.anInt112, client.engineCycle);
                        }
                    }

                    projectile.method1193(client.anInt972);
                    client.sceneGraph.addEntityMarker(SceneGraph.floorLevel, (int) projectile.fineY, (int) projectile.fineX, (int) projectile.aDouble1660, 60, projectile, projectile.xRotation, -1L, false);
                }
            } else {
                projectile.unlink();
            }
        }

    }

    protected final Model getModel() {
        if (this.sequence != null) {
            int var1 = client.engineCycle - this.anInt379;
            if (var1 > 100 && this.sequence.loopOffset > 0) {
                var1 = 100;
            }

            label56:
            {
                do {
                    do {
                        if (var1 <= this.sequence.frameLengths[this.anInt372]) {
                            break label56;
                        }

                        var1 -= this.sequence.frameLengths[this.anInt372];
                        ++this.anInt372;
                    } while (this.anInt372 < this.sequence.frameIds.length);

                    this.anInt372 -= this.sequence.loopOffset;
                } while (this.anInt372 >= 0 && this.anInt372 < this.sequence.frameIds.length);

                this.sequence = null;
            }

            this.anInt379 = client.engineCycle - var1;
        }

        ObjectDefinition var2 = ObjectDefinition.get(this.anInt693);
        if (var2.transformIds != null) {
            var2 = var2.transform();
        }

        if (var2 == null) {
            return null;
        }
        int var3;
        int var4;
        if (this.orientation != 1 && this.orientation != 3) {
            var3 = var2.sizeX;
            var4 = var2.sizeY;
        } else {
            var3 = var2.sizeY;
            var4 = var2.sizeX;
        }

        int var5 = (var3 >> 1) + this.sceneX;
        int var6 = (var3 + 1 >> 1) + this.sceneX;
        int var7 = (var4 >> 1) + this.sceneY;
        int var8 = (var4 + 1 >> 1) + this.sceneY;
        int[][] var9 = Statics45.tileHeights[this.floorLevel];
        int var10 = var9[var6][var7] + var9[var5][var7] + var9[var5][var8] + var9[var6][var8] >> 2;
        int var11 = (this.sceneX << 7) + (var3 << 6);
        int var12 = (this.sceneY << 7) + (var4 << 6);
        return var2.method1107(this.type, this.orientation, var9, var11, var10, var12, this.sequence, this.anInt372);
    }
}
