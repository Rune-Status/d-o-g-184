package jag.game.relationship;

import jag.*;
import jag.audi.AudioSystem;
import jag.audi.DefaultAudioSystemProvider;
import jag.audi.ObjectSound;
import jag.commons.input.Mouse;
import jag.game.client;
import jag.game.scene.SceneGraph;
import jag.game.scene.entity.DynamicObject;
import jag.game.scene.entity.EffectObject;
import jag.game.scene.entity.PlayerEntity;
import jag.game.stockmarket.Class46;
import jag.game.stockmarket.StockMarketOfferWorldComparator;
import jag.game.type.NpcDefinition;
import jag.graphics.DefaultMaterialProvider;
import jag.graphics.JagGraphics;
import jag.graphics.JagGraphics3D;
import jag.graphics.NamedFont;
import jag.opcode.GPI;
import jag.statics.*;
import jag.worldmap.*;

public class BefriendedPlayer extends Associate {

    public boolean aBoolean745;
    public boolean aBoolean746;

    BefriendedPlayer() {
    }

    public static void method553(int var0, int var1, int width, int height) {
        ++client.anInt1001;
        if (PlayerEntity.local.fineX >> 7 == client.destinationX && PlayerEntity.local.fineY >> 7 == client.destinationY) {
            client.destinationX = 0;
        }

        if (client.aBoolean1020) {
            GPI.loadPlayersIntoScene(PlayerEntity.local, false);
        }

        URLRequest.loadPlayerIntoScene();
        SerializableString.loadNpcsIntoScene(true);
        Login.loadPlayersIntoScene();
        SerializableString.loadNpcsIntoScene(false);
        DynamicObject.loadProjectilesIntoScene();

        for (EffectObject object = client.effectObjects.head(); object != null; object = client.effectObjects.next()) {
            if (object.floorLevel == SceneGraph.floorLevel && !object.finished) {
                if (client.engineCycle >= object.endCycle) {
                    object.method703(client.anInt972);
                    if (object.finished) {
                        object.unlink();
                    } else {
                        client.sceneGraph.addEntityMarker(object.floorLevel, object.fineX, object.fineY, object.height, 60, object, 0, -1L, false);
                    }
                }
            } else {
                object.unlink();
            }
        }

        ByteBufferProvider.method867(var0, var1, width, height, true);
        var0 = client.anInt909;
        var1 = client.anInt908;
        width = client.viewportWidth;
        height = client.viewportHeight;
        JagGraphics.setClip(var0, var1, var0 + width, height + var1);
        JagGraphics3D.method499();
        int var5;
        int var6;
        int var7;
        int var8;
        int var9;
        int var12;
        if (!client.cameraLocked) {
            var5 = client.anInt985;
            if (client.anInt1008 / 256 > var5) {
                var5 = client.anInt1008 / 256;
            }

            if (client.aBooleanArray919[4] && client.anIntArray918[4] + 128 > var5) {
                var5 = client.anIntArray918[4] + 128;
            }

            var6 = client.mapRotation & 2047;
            var7 = ObjectSound.anInt371;
            var8 = Statics3.anInt802;
            var9 = Statics52.anInt498;
            var12 = var5 * 3 + 600;
            NpcDefinition.method505(var7, var8, var9, var5, var6, var12, height);

        }

        int var10;
        int var11;
        int var13;
        int var14;
        int var15;
        if (!client.cameraLocked) {
            if (client.preferences.roofsHidden) {
                var6 = SceneGraph.floorLevel;
            } else {
                label409:
                {
                    var7 = 3;
                    if (IgnoreListContext.cameraPitch < 310) {
                        if (client.anInt988 == 1) {
                            var8 = ObjectSound.anInt371 >> 7;
                            var9 = Statics52.anInt498 >> 7;
                        } else {
                            var8 = PlayerEntity.local.fineX >> 7;
                            var9 = PlayerEntity.local.fineY >> 7;
                        }

                        var10 = StockMarketOfferWorldComparator.cameraX >> 7;
                        var11 = WorldMapIcon_Sub1.cameraY >> 7;
                        if (var10 < 0 || var11 < 0 || var10 >= 104 || var11 >= 104) {
                            var6 = SceneGraph.floorLevel;
                            break label409;
                        }

                        if (var8 < 0 || var9 < 0 || var8 >= 104 || var9 >= 104) {
                            var6 = SceneGraph.floorLevel;
                            break label409;
                        }

                        if ((Statics45.sceneRenderRules[SceneGraph.floorLevel][var10][var11] & 4) != 0) {
                            var7 = SceneGraph.floorLevel;
                        }

                        if (var8 > var10) {
                            var12 = var8 - var10;
                        } else {
                            var12 = var10 - var8;
                        }

                        if (var9 > var11) {
                            var13 = var9 - var11;
                        } else {
                            var13 = var11 - var9;
                        }

                        if (var12 > var13) {
                            var14 = var13 * 65536 / var12;
                            var15 = 32768;

                            while (var8 != var10) {
                                if (var10 < var8) {
                                    ++var10;
                                } else if (var10 > var8) {
                                    --var10;
                                }

                                if ((Statics45.sceneRenderRules[SceneGraph.floorLevel][var10][var11] & 4) != 0) {
                                    var7 = SceneGraph.floorLevel;
                                }

                                var15 += var14;
                                if (var15 >= 65536) {
                                    var15 -= 65536;
                                    if (var11 < var9) {
                                        ++var11;
                                    } else if (var11 > var9) {
                                        --var11;
                                    }

                                    if ((Statics45.sceneRenderRules[SceneGraph.floorLevel][var10][var11] & 4) != 0) {
                                        var7 = SceneGraph.floorLevel;
                                    }
                                }
                            }
                        } else if (var13 > 0) {
                            var14 = var12 * 65536 / var13;
                            var15 = 32768;

                            while (var9 != var11) {
                                if (var11 < var9) {
                                    ++var11;
                                } else if (var11 > var9) {
                                    --var11;
                                }

                                if ((Statics45.sceneRenderRules[SceneGraph.floorLevel][var10][var11] & 4) != 0) {
                                    var7 = SceneGraph.floorLevel;
                                }

                                var15 += var14;
                                if (var15 >= 65536) {
                                    var15 -= 65536;
                                    if (var10 < var8) {
                                        ++var10;
                                    } else if (var10 > var8) {
                                        --var10;
                                    }

                                    if ((Statics45.sceneRenderRules[SceneGraph.floorLevel][var10][var11] & 4) != 0) {
                                        var7 = SceneGraph.floorLevel;
                                    }
                                }
                            }
                        }
                    }

                    if (PlayerEntity.local.fineX >= 0 && PlayerEntity.local.fineY >= 0 && PlayerEntity.local.fineX < 13312 && PlayerEntity.local.fineY < 13312) {
                        if ((Statics45.sceneRenderRules[SceneGraph.floorLevel][PlayerEntity.local.fineX >> 7][PlayerEntity.local.fineY >> 7] & 4) != 0) {
                            var7 = SceneGraph.floorLevel;
                        }

                        var6 = var7;
                    } else {
                        var6 = SceneGraph.floorLevel;
                    }
                }
            }

            var5 = var6;
        } else {
            var5 = Statics17.method892();
        }

        var6 = StockMarketOfferWorldComparator.cameraX;
        var7 = Varcs.cameraZ;
        var8 = WorldMapIcon_Sub1.cameraY;
        var9 = IgnoreListContext.cameraPitch;
        var10 = RectangularWorldMapAreaChunk.cameraYaw;

        for (var11 = 0; var11 < 5; ++var11) {
            if (client.aBooleanArray919[var11]) {
                var12 = (int) (Math.random() * (double) (client.anIntArray917[var11] * 2 + 1) - (double) client.anIntArray917[var11] + Math.sin((double) client.anIntArray914[var11] / 100.0D * (double) client.anIntArray916[var11]) * (double) client.anIntArray918[var11]);
                if (var11 == 0) {
                    StockMarketOfferWorldComparator.cameraX += var12;
                }

                if (var11 == 1) {
                    Varcs.cameraZ += var12;
                }

                if (var11 == 2) {
                    WorldMapIcon_Sub1.cameraY += var12;
                }

                if (var11 == 3) {
                    RectangularWorldMapAreaChunk.cameraYaw = var12 + RectangularWorldMapAreaChunk.cameraYaw & 2047;
                }

                if (var11 == 4) {
                    IgnoreListContext.cameraPitch += var12;
                    if (IgnoreListContext.cameraPitch < 128) {
                        IgnoreListContext.cameraPitch = 128;
                    }

                    if (IgnoreListContext.cameraPitch > 383) {
                        IgnoreListContext.cameraPitch = 383;
                    }
                }
            }
        }

        var11 = Mouse.x;
        var12 = Mouse.y;
        if (Mouse.clickMeta != 0) {
            var11 = Mouse.clickX;
            var12 = Mouse.clickY;
        }

        if (var11 >= var0 && var11 < var0 + width && var12 >= var1 && var12 < height + var1) {
            Statics2.method238(var11 - var0, var12 - var1);
        } else {
            MenuItemNode.method419();
        }

        AudioSystem.process();
        JagGraphics.fillRect(var0, var1, width, height, 0);
        AudioSystem.process();
        var13 = JagGraphics3D.anInt367;
        JagGraphics3D.anInt367 = client.viewportScale;
        client.sceneGraph.renderScene(StockMarketOfferWorldComparator.cameraX, Varcs.cameraZ, WorldMapIcon_Sub1.cameraY, IgnoreListContext.cameraPitch, RectangularWorldMapAreaChunk.cameraYaw, var5);
        JagGraphics3D.anInt367 = var13;
        AudioSystem.process();
        client.sceneGraph.method1472();
        Statics2.method481(var0, var1, width, height);
        client.method883(var0, var1);
        ((DefaultMaterialProvider) JagGraphics3D.aMaterialProvider783).method1518(client.anInt972);
        client.anInt1014 = 0;
        var14 = client.baseX + (PlayerEntity.local.fineX >> 7);
        var15 = client.baseY + (PlayerEntity.local.fineY >> 7);
        if (var14 >= 3053 && var14 <= 3156 && var15 >= 3056 && var15 <= 3136) {
            client.anInt1014 = 1;
        }

        if (var14 >= 3072 && var14 <= 3118 && var15 >= 9492 && var15 <= 9535) {
            client.anInt1014 = 1;
        }

        if (client.anInt1014 == 1 && var14 >= 3139 && var14 <= 3199 && var15 >= 3008 && var15 <= 3062) {
            client.anInt1014 = 0;
        }

        StockMarketOfferWorldComparator.cameraX = var6;
        Varcs.cameraZ = var7;
        WorldMapIcon_Sub1.cameraY = var8;
        IgnoreListContext.cameraPitch = var9;
        RectangularWorldMapAreaChunk.cameraYaw = var10;
        if (client.aBoolean939 && SerializableInteger.method405() == 0) {
            client.aBoolean939 = false;
        }

        if (client.aBoolean939) {
            JagGraphics.fillRect(var0, var1, width, height, 0);
            WorldMapSprite.method242("Loading - please wait.", false);
        }

    }

    public static void method555() {
        Statics45.aByteArrayArrayArray404 = null;
        Statics45.aByteArrayArrayArray401 = null;
        DefaultAudioSystemProvider.aByteArrayArrayArray141 = null;
        Statics35.aByteArrayArrayArray1615 = null;
        Statics45.anIntArrayArrayArray393 = null;
        Statics45.aByteArrayArrayArray400 = null;
        DefaultAudioSystemProvider.anIntArrayArray146 = null;
        Statics45.anIntArray396 = null;
        Class46.anIntArray426 = null;
        Statics45.anIntArray390 = null;
        NamedFont.anIntArray1626 = null;
        Statics45.anIntArray389 = null;
    }

    int method552(BefriendedPlayer var1) {
        if (super.world == client.currentWorld && client.currentWorld != var1.world) {
            return -1;
        }
        if (client.currentWorld == var1.world && super.world != client.currentWorld) {
            return 1;
        }
        if (super.world != 0 && var1.world == 0) {
            return -1;
        }
        if (var1.world != 0 && super.world == 0) {
            return 1;
        }
        if (this.aBoolean745 && !var1.aBoolean745) {
            return -1;
        }
        if (!this.aBoolean745 && var1.aBoolean745) {
            return 1;
        }
        if (this.aBoolean746 && !var1.aBoolean746) {
            return -1;
        }
        if (!this.aBoolean746 && var1.aBoolean746) {
            return 1;
        }
        return super.world != 0 ? super.index - var1.index : var1.index - super.index;
    }

    public int compare0(Chatter var1) {
        return this.method552((BefriendedPlayer) var1);
    }

    public int compareTo(Object var1) {
        return this.method552((BefriendedPlayer) var1);
    }
}
