package com.jagex;

public class Class39 {
    static int[] anIntArray352;

    static void updateMinimapFloorLevel() {
        if (client.minimapFloorLevel != SceneGraph.floorLevel) {
            client.minimapFloorLevel = SceneGraph.floorLevel;
            int var0 = SceneGraph.floorLevel;
            int[] var1 = Node_Sub2.minimapSprite.pixels;
            int var2 = var1.length;

            int var3;
            for (var3 = 0; var3 < var2; ++var3) {
                var1[var3] = 0;
            }

            int var4;
            int var5;
            for (var3 = 1; var3 < 103; ++var3) {
                var4 = (103 - var3) * 2048 + 24628;

                for (var5 = 1; var5 < 103; ++var5) {
                    if ((Class44.sceneRenderRules[var0][var5][var3] & 24) == 0) {
                        client.sceneGraph.drawMinimapTile(var1, var4, 512, var0, var5, var3);
                    }

                    if (var0 < 3 && (Class44.sceneRenderRules[var0 + 1][var5][var3] & 8) != 0) {
                        client.sceneGraph.drawMinimapTile(var1, var4, 512, var0 + 1, var5, var3);

                    }


                    var4 += 4;
                }
            }

            var3 = (238 + (int) (Math.random() * 20.0D) - 10 << 16) + (238 + (int) (Math.random() * 20.0D) - 10 << 8) + (238 + (int) (Math.random() * 20.0D) - 10);
            var4 = 238 + (int) (Math.random() * 20.0D) - 10 << 16;
            Node_Sub2.minimapSprite.method23();

            int var6;
            for (var5 = 1; var5 < 103; ++var5) {
                for (var6 = 1; var6 < 103; ++var6) {
                    if ((Class44.sceneRenderRules[var0][var6][var5] & 24) == 0) {
                        Class20.drawMinimapObjects(var0, var6, var5, var3, var4);
                    }

                    if (var0 < 3 && (Class44.sceneRenderRules[var0 + 1][var6][var5] & 8) != 0) {
                        Class20.drawMinimapObjects(var0 + 1, var6, var5, var3, var4);
                    }
                }
            }

            client.anInt895 = 0;

            for (var5 = 0; var5 < 104; ++var5) {
                for (var6 = 0; var6 < 104; ++var6) {
                    long var7 = client.sceneGraph.method1457(SceneGraph.floorLevel, var5, var6);
                    if (0L != var7) {
                        int var9 = EntityUID.getObjectId(var7);
                        int var10 = Class38.getObjectDefinition(var9).mapFunction;
                        if (var10 >= 0) {
                            client.aSpriteArray1093[client.anInt895] = Class98.method545(var10).method1083();
                            client.anIntArray892[client.anInt895] = var5;
                            client.anIntArray894[client.anInt895] = var6;
                            ++client.anInt895;
                        }
                    }
                }
            }

            Class20.aClass216_284.method1318();
        }

    }
}
