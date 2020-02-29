package com.jagex;

public class BefriendedPlayer extends Associate {
    boolean aBoolean745;
    boolean aBoolean746;

    BefriendedPlayer() {
    }

    static void method553(int var0, int var1, int width, int height) {
        ++client.anInt1001;
        if (PlayerEntity.local.fineX >> 7 == client.destinationX && PlayerEntity.local.fineY >> 7 == client.destinationY) {
            client.destinationX = 0;
        }

        if (client.aBoolean1020) {
            GPI.method415(PlayerEntity.local, false);
        }

        Class105.method613();
        Class80.method438(true);
        Class55.method325();
        Class80.method438(false);
        DynamicObject.method1505();

        for (SpotAnimationObject var4 = (SpotAnimationObject) client.graphicsObjectDeque.head(); var4 != null; var4 = (SpotAnimationObject) client.graphicsObjectDeque.next()) {
            if (var4.floorLevel == SceneGraph.floorLevel && !var4.finished) {
                if (client.engineCycle >= var4.anInt378) {
                    var4.method703(client.anInt972);
                    if (var4.finished) {
                        var4.unlink();
                    } else {
                        client.sceneGraph.method1469(var4.floorLevel, var4.fineX, var4.fineY, var4.height, 60, var4, 0, -1L, false);
                    }
                }
            } else {
                var4.unlink();
            }
        }

        Class152.method867(var0, var1, width, height, true);
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
            var7 = Node_Sub2.anInt371;
            var8 = Statics3.anInt802;
            var9 = Class62.anInt498;
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
                            var8 = Node_Sub2.anInt371 >> 7;
                            var9 = Class62.anInt498 >> 7;
                        } else {
                            var8 = PlayerEntity.local.fineX >> 7;
                            var9 = PlayerEntity.local.fineY >> 7;
                        }

                        var10 = Class38.cameraX >> 7;
                        var11 = Class27_Sub1.cameraY >> 7;
                        if (var10 < 0 || var11 < 0 || var10 >= 104 || var11 >= 104) {
                            var6 = SceneGraph.floorLevel;
                            break label409;
                        }

                        if (var8 < 0 || var9 < 0 || var8 >= 104 || var9 >= 104) {
                            var6 = SceneGraph.floorLevel;
                            break label409;
                        }

                        if ((Class44.sceneRenderRules[SceneGraph.floorLevel][var10][var11] & 4) != 0) {
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

                                if ((Class44.sceneRenderRules[SceneGraph.floorLevel][var10][var11] & 4) != 0) {
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

                                    if ((Class44.sceneRenderRules[SceneGraph.floorLevel][var10][var11] & 4) != 0) {
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

                                if ((Class44.sceneRenderRules[SceneGraph.floorLevel][var10][var11] & 4) != 0) {
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

                                    if ((Class44.sceneRenderRules[SceneGraph.floorLevel][var10][var11] & 4) != 0) {
                                        var7 = SceneGraph.floorLevel;
                                    }
                                }
                            }
                        }
                    }

                    if (PlayerEntity.local.fineX >= 0 && PlayerEntity.local.fineY >= 0 && PlayerEntity.local.fineX < 13312 && PlayerEntity.local.fineY < 13312) {
                        if ((Class44.sceneRenderRules[SceneGraph.floorLevel][PlayerEntity.local.fineX >> 7][PlayerEntity.local.fineY >> 7] & 4) != 0) {
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

        var6 = Class38.cameraX;
        var7 = Class79.cameraZ;
        var8 = Class27_Sub1.cameraY;
        var9 = IgnoreListContext.cameraPitch;
        var10 = Class70.cameraYaw;

        for (var11 = 0; var11 < 5; ++var11) {
            if (client.aBooleanArray919[var11]) {
                var12 = (int) (Math.random() * (double) (client.anIntArray917[var11] * 2 + 1) - (double) client.anIntArray917[var11] + Math.sin((double) client.anIntArray914[var11] / 100.0D * (double) client.anIntArray916[var11]) * (double) client.anIntArray918[var11]);
                if (var11 == 0) {
                    Class38.cameraX += var12;
                }

                if (var11 == 1) {
                    Class79.cameraZ += var12;
                }

                if (var11 == 2) {
                    Class27_Sub1.cameraY += var12;
                }

                if (var11 == 3) {
                    Class70.cameraYaw = var12 + Class70.cameraYaw & 2047;
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
            Class36.method238(var11 - var0, var12 - var1);
        } else {
            Class77.method419();
        }

        Class26.method190();
        JagGraphics.fillRect(var0, var1, width, height, 0);
        Class26.method190();
        var13 = JagGraphics3D.anInt367;
        JagGraphics3D.anInt367 = client.viewportScale;
        client.sceneGraph.renderScene(Class38.cameraX, Class79.cameraZ, Class27_Sub1.cameraY, IgnoreListContext.cameraPitch, Class70.cameraYaw, var5);
        JagGraphics3D.anInt367 = var13;
        Class26.method190();
        client.sceneGraph.method1472();
        Statics2.method481(var0, var1, width, height);
        Chatline.method883(var0, var1);
        ((TextureProviderImpl) JagGraphics3D.aTextureProvider783).method1518(client.anInt972);
        client.anInt1014 = 0;
        var14 = Statics18.baseX + (PlayerEntity.local.fineX >> 7);
        var15 = Statics36.baseY + (PlayerEntity.local.fineY >> 7);
        if (var14 >= 3053 && var14 <= 3156 && var15 >= 3056 && var15 <= 3136) {
            client.anInt1014 = 1;
        }

        if (var14 >= 3072 && var14 <= 3118 && var15 >= 9492 && var15 <= 9535) {
            client.anInt1014 = 1;
        }

        if (client.anInt1014 == 1 && var14 >= 3139 && var14 <= 3199 && var15 >= 3008 && var15 <= 3062) {
            client.anInt1014 = 0;
        }

        Class38.cameraX = var6;
        Class79.cameraZ = var7;
        Class27_Sub1.cameraY = var8;
        IgnoreListContext.cameraPitch = var9;
        Class70.cameraYaw = var10;
        if (client.aBoolean939 && Class73.method405() == 0) {
            client.aBoolean939 = false;
        }

        if (client.aBoolean939) {
            JagGraphics.fillRect(var0, var1, width, height, 0);
            Class37.method242("Loading - please wait.", false);
        }

    }

    static void method555() {
        Class44.aByteArrayArrayArray404 = null;
        Class44.aByteArrayArrayArray401 = null;
        Class12.aByteArrayArrayArray141 = null;
        Statics35.aByteArrayArrayArray1615 = null;
        Class44.anIntArrayArrayArray393 = null;
        Class44.aByteArrayArrayArray400 = null;
        Class12.anIntArrayArray146 = null;
        Class44.anIntArray396 = null;
        Class46.anIntArray426 = null;
        Class44.anIntArray390 = null;
        Class199.anIntArray1626 = null;
        Class44.anIntArray389 = null;
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
        return super.world != 0 ? super.anInt1222 - var1.anInt1222 : var1.anInt1222 - super.anInt1222;
    }

    public int compare0(Chatter var1) {
        return this.method552((BefriendedPlayer) var1);
    }

    public int compareTo(Object var1) {
        return this.method552((BefriendedPlayer) var1);
    }
}
