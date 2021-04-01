package jag.game.relationship;

import jag.*;
import jag.audi.AudioSystem;
import jag.audi.DefaultAudioSystemProvider;
import jag.audi.ObjectSound;
import jag.commons.input.Mouse;
import jag.game.client;
import jag.game.scene.HintArrow;
import jag.game.scene.SceneGraph;
import jag.game.scene.entity.DynamicObject;
import jag.game.scene.entity.EffectObject;
import jag.game.scene.entity.PlayerEntity;
import jag.js5.LoadedArchive;
import jag.game.type.NpcDefinition;
import jag.graphics.DefaultMaterialProvider;
import jag.graphics.JagGraphics;
import jag.graphics.JagGraphics3D;
import jag.graphics.NamedFont;
import jag.opcode.GPI;
import jag.statics.*;
import jag.worldmap.WorldMapElement;

public class BefriendedPlayer extends Associate {

    public boolean aBoolean745;
    public boolean aBoolean746;

    BefriendedPlayer() {
    }

    public static void method553(int var0, int var1, int width, int height) {
        ++client.viewportRenderCount;
        if (PlayerEntity.local.absoluteX >> 7 == client.destinationX && PlayerEntity.local.absoluteY >> 7 == client.destinationY) {
            client.destinationX = 0;
        }

        if (client.displaySelf) {
            GPI.loadPlayersIntoScene(PlayerEntity.local, false);
        }

        GPI.loadPlayerIntoScene();
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
                        client.sceneGraph.addEntityMarker(object.floorLevel, object.absoluteX, object.absoluteY, object.height, 60, object, 0, -1L, false);
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
            var5 = client.cameraX;
            if (client.anInt1008 / 256 > var5) {
                var5 = client.anInt1008 / 256;
            }

            if (client.aBooleanArray919[4] && client.anIntArray918[4] + 128 > var5) {
                var5 = client.anIntArray918[4] + 128;
            }

            var6 = client.cameraY & 2047;
            var7 = ObjectSound.oculusOrbAbsoluteX;
            var8 = Statics3.anInt802;
            var9 = Statics52.oculusOrbAbsoluteY;
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
                    if (SceneGraph.cameraPitch < 310) {
                        if (client.oculusOrbState == 1) {
                            var8 = ObjectSound.oculusOrbAbsoluteX >> 7;
                            var9 = Statics52.oculusOrbAbsoluteY >> 7;
                        } else {
                            var8 = PlayerEntity.local.absoluteX >> 7;
                            var9 = PlayerEntity.local.absoluteY >> 7;
                        }

                        var10 = SceneGraph.cameraX >> 7;
                        var11 = SceneGraph.cameraY >> 7;
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

                    if (PlayerEntity.local.absoluteX >= 0 && PlayerEntity.local.absoluteY >= 0 && PlayerEntity.local.absoluteX < 13312 && PlayerEntity.local.absoluteY < 13312) {
                        if ((Statics45.sceneRenderRules[SceneGraph.floorLevel][PlayerEntity.local.absoluteX >> 7][PlayerEntity.local.absoluteY >> 7] & 4) != 0) {
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

        var6 = SceneGraph.cameraX;
        var7 = SceneGraph.cameraZ;
        var8 = SceneGraph.cameraY;
        var9 = SceneGraph.cameraPitch;
        var10 = SceneGraph.cameraYaw;

        for (var11 = 0; var11 < 5; ++var11) {
            if (client.aBooleanArray919[var11]) {
                var12 = (int) (Math.random() * (double) (client.anIntArray917[var11] * 2 + 1) - (double) client.anIntArray917[var11] + Math.sin((double) client.anIntArray914[var11] / 100.0D * (double) client.anIntArray916[var11]) * (double) client.anIntArray918[var11]);
                if (var11 == 0) {
                    SceneGraph.cameraX += var12;
                }

                if (var11 == 1) {
                    SceneGraph.cameraZ += var12;
                }

                if (var11 == 2) {
                    SceneGraph.cameraY += var12;
                }

                if (var11 == 3) {
                    SceneGraph.cameraYaw = var12 + SceneGraph.cameraYaw & 2047;
                }

                if (var11 == 4) {
                    SceneGraph.cameraPitch += var12;
                    if (SceneGraph.cameraPitch < 128) {
                        SceneGraph.cameraPitch = 128;
                    }

                    if (SceneGraph.cameraPitch > 383) {
                        SceneGraph.cameraPitch = 383;
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
            Statics2.method419();
        }

        AudioSystem.process();
        JagGraphics.fillRect(var0, var1, width, height, 0);
        AudioSystem.process();
        var13 = JagGraphics3D.anInt367;
        JagGraphics3D.anInt367 = client.viewportScale;
        client.sceneGraph.renderScene(SceneGraph.cameraX, SceneGraph.cameraZ, SceneGraph.cameraY, SceneGraph.cameraPitch, SceneGraph.cameraYaw, var5);
        JagGraphics3D.anInt367 = var13;
        AudioSystem.process();
        client.sceneGraph.method1472();
        Statics2.method481(var0, var1, width, height);
        HintArrow.draw(var0, var1);
        ((DefaultMaterialProvider) JagGraphics3D.aMaterialProvider783).rotate(client.anInt972);
        client.anInt1014 = 0;
        var14 = client.baseX + (PlayerEntity.local.absoluteX >> 7);
        var15 = client.baseY + (PlayerEntity.local.absoluteY >> 7);
        if (var14 >= 3053 && var14 <= 3156 && var15 >= 3056 && var15 <= 3136) {
            client.anInt1014 = 1;
        }

        if (var14 >= 3072 && var14 <= 3118 && var15 >= 9492 && var15 <= 9535) {
            client.anInt1014 = 1;
        }

        if (client.anInt1014 == 1 && var14 >= 3139 && var14 <= 3199 && var15 >= 3008 && var15 <= 3062) {
            client.anInt1014 = 0;
        }

        SceneGraph.cameraX = var6;
        SceneGraph.cameraZ = var7;
        SceneGraph.cameraY = var8;
        SceneGraph.cameraPitch = var9;
        SceneGraph.cameraYaw = var10;
        if (client.loadingPleaseWait && SerializableInteger.method405() == 0) {
            client.loadingPleaseWait = false;
        }

        if (client.loadingPleaseWait) {
            JagGraphics.fillRect(var0, var1, width, height, 0);
            WorldMapElement.method242("Loading - please wait.", false);
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
        LoadedArchive.anIntArray426 = null;
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
