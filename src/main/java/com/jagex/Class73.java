package com.jagex;

final class Class73 implements Class89 {
    static CacheReferenceTable aCacheReferenceTable583;

    public static void method409(boolean var0) {
        if (var0 != Statics6.loadMembersItemDefinitions) {
            InterfaceNode.method837();
            Statics6.loadMembersItemDefinitions = var0;
        }

    }

    static void method406(PlayerEntity var0, int var1, int var2) {
        int var4 = var0.pathXQueue[0];
        int var5 = var0.pathYQueue[0];
        int var6 = var0.boundSize();
        if (var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
            if (var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
                int var9 = var0.boundSize();
                client.aClass123_Sub1_940.anInt843 = var1;
                client.aClass123_Sub1_940.anInt844 = var2;
                client.aClass123_Sub1_940.anInt842 = 1;
                client.aClass123_Sub1_940.anInt841 = 1;
                Class123_Sub1 var10 = client.aClass123_Sub1_940;
                int var11 = Enum_Sub4.method850(var4, var5, var9, var10, client.collisionMaps[var0.anInt1473], client.anIntArray945, client.anIntArray942);
                if (var11 >= 1) {
                    for (int var12 = 0; var12 < var11 - 1; ++var12) {
                        var0.method1413(client.anIntArray945[var12], client.anIntArray942[var12], (byte) 2);
                    }

                }
            }
        }
    }

    static void method404(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
        if (var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
            if (client.lowMemory && var0 != SceneGraph.floorLevel) {
                return;
            }

            long var7 = 0L;
            boolean var9 = true;
            boolean var10 = false;
            boolean var11 = false;
            if (var1 == 0) {
                var7 = client.sceneGraph.method1456(var0, var2, var3);
            }

            if (var1 == 1) {
                var7 = client.sceneGraph.method1440(var0, var2, var3);
            }

            if (var1 == 2) {
                var7 = client.sceneGraph.method1461(var0, var2, var3);
            }

            if (var1 == 3) {
                var7 = client.sceneGraph.method1457(var0, var2, var3);
            }

            int var12;
            if (0L != var7) {
                var12 = client.sceneGraph.method1453(var0, var2, var3, var7);
                int var14 = EntityUID.getObjectId(var7);
                int var15 = var12 & 31;
                int var16 = var12 >> 6 & 3;
                ObjectDefinition var13;
                if (var1 == 0) {
                    client.sceneGraph.method1482(var0, var2, var3);
                    var13 = Class38.getObjectDefinition(var14);
                    if (var13.anInt791 != 0) {
                        client.collisionMaps[var0].method157(var2, var3, var15, var16, var13.impenetrable);
                    }
                }

                if (var1 == 1) {
                    client.sceneGraph.method1473(var0, var2, var3);
                }

                if (var1 == 2) {
                    client.sceneGraph.method1475(var0, var2, var3);
                    var13 = Class38.getObjectDefinition(var14);
                    if (var2 + var13.sizeX > 103 || var3 + var13.sizeX > 103 || var2 + var13.sizeY > 103 || var3 + var13.sizeY > 103) {
                        return;
                    }

                    if (var13.anInt791 != 0) {
                        client.collisionMaps[var0].method153(var2, var3, var13.sizeX, var13.sizeY, var16, var13.impenetrable);
                    }
                }

                if (var1 == 3) {
                    client.sceneGraph.method1471(var0, var2, var3);
                    var13 = Class38.getObjectDefinition(var14);
                    if (var13.anInt791 == 1) {
                        client.collisionMaps[var0].method152(var2, var3);
                    }
                }
            }

            if (var4 >= 0) {
                var12 = var0;
                if (var0 < 3 && (Class44.sceneRenderRules[1][var2][var3] & 2) == 2) {
                    var12 = var0 + 1;
                }

                Class85.method451(var0, var12, var2, var3, var4, var5, var6, client.sceneGraph, client.collisionMaps[var0]);
            }
        }

    }

    static void method407() {
        if (client.aBoolean996 && PlayerEntity.local != null) {
            int var0 = PlayerEntity.local.pathXQueue[0];
            int var1 = PlayerEntity.local.pathYQueue[0];
            if (var0 < 0 || var1 < 0 || var0 >= 104 || var1 >= 104) {
                return;
            }

            Node_Sub2.anInt371 = PlayerEntity.local.fineX;
            int var2 = SceneGraph.getTileHeight(PlayerEntity.local.fineX, PlayerEntity.local.fineY, SceneGraph.floorLevel) - client.anInt982;
            if (var2 < Statics3.anInt802) {
                Statics3.anInt802 = var2;
            }

            Class62.anInt498 = PlayerEntity.local.fineY;
            client.aBoolean996 = false;
        }

    }

    public static int method405() {
        byte var2 = 0;
        return var2 + Statics25.anInt1497 + Statics25.anInt1496;
    }

    void method403(Integer var1, Buffer var2) {
        var2.writeInt(var1);
    }

    public Object method410(Buffer var1) {
        return var1.readInt();
    }

    public void method408(Object var1, Buffer var2) {
        this.method403((Integer) var1, var2);
    }
}
