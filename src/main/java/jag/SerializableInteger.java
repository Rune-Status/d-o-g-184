package jag;

import jag.audi.ObjectSound;
import jag.game.client;
import jag.game.scene.CollisionMap;
import jag.game.scene.SceneGraph;
import jag.game.scene.entity.PlayerEntity;
import jag.game.type.ItemDefinition;
import jag.game.type.ObjectDefinition;
import jag.js5.Archive;
import jag.opcode.Buffer;
import jag.js5.NetWorker;
import jag.statics.Statics3;
import jag.statics.Statics45;
import jag.statics.Statics52;

public final class SerializableInteger implements Serializable {
    public static Archive aArchive583;

    public static void method409(boolean var0) {
        if (var0 != ItemDefinition.loadMembersItemDefinitions) {
            ItemDefinition.clear();
            ItemDefinition.loadMembersItemDefinitions = var0;
        }

    }

    public static void method406(PlayerEntity var0, int var1, int var2) {
        int var4 = var0.pathXQueue[0];
        int var5 = var0.pathYQueue[0];
        int var6 = var0.boundSize();
        if (var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
            if (var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
                int var9 = var0.boundSize();
                client.routeStrategy.destinationX = var1;
                client.routeStrategy.destinationY = var2;
                client.routeStrategy.destinationSizeX = 1;
                client.routeStrategy.destinationSizeY = 1;
                RouteStrategy_Sub1 var10 = client.routeStrategy;
                int var11 = CollisionMap.method850(var4, var5, var9, var10, client.collisionMaps[var0.anInt1473], client.anIntArray945, client.anIntArray942);
                if (var11 >= 1) {
                    for (int var12 = 0; var12 < var11 - 1; ++var12) {
                        var0.method1413(client.anIntArray945[var12], client.anIntArray942[var12], (byte) 2);
                    }

                }
            }
        }
    }

    public static void method404(int var0, int var1, int x, int y, int var4, int var5, int var6) {
        if (x >= 1 && y >= 1 && x <= 102 && y <= 102) {
            if (client.lowMemory && var0 != SceneGraph.floorLevel) {
                return;
            }

            long var7 = 0L;
            boolean var9 = true;
            boolean var10 = false;
            boolean var11 = false;
            if (var1 == 0) {
                var7 = client.sceneGraph.method1456(var0, x, y);
            }

            if (var1 == 1) {
                var7 = client.sceneGraph.method1440(var0, x, y);
            }

            if (var1 == 2) {
                var7 = client.sceneGraph.method1461(var0, x, y);
            }

            if (var1 == 3) {
                var7 = client.sceneGraph.method1457(var0, x, y);
            }

            int var12;
            if (0L != var7) {
                var12 = client.sceneGraph.method1453(var0, x, y, var7);
                int var14 = EntityUID.getObjectId(var7);
                int var15 = var12 & 31;
                int var16 = var12 >> 6 & 3;
                ObjectDefinition var13;
                if (var1 == 0) {
                    client.sceneGraph.method1482(var0, x, y);
                    var13 = ObjectDefinition.get(var14);
                    if (var13.anInt791 != 0) {
                        client.collisionMaps[var0].method157(x, y, var15, var16, var13.impenetrable);
                    }
                }

                if (var1 == 1) {
                    client.sceneGraph.method1473(var0, x, y);
                }

                if (var1 == 2) {
                    client.sceneGraph.method1475(var0, x, y);
                    var13 = ObjectDefinition.get(var14);
                    if (x + var13.sizeX > 103 || y + var13.sizeX > 103 || x + var13.sizeY > 103 || y + var13.sizeY > 103) {
                        return;
                    }

                    if (var13.anInt791 != 0) {
                        client.collisionMaps[var0].method153(x, y, var13.sizeX, var13.sizeY, var16, var13.impenetrable);
                    }
                }

                if (var1 == 3) {
                    client.sceneGraph.method1471(var0, x, y);
                    var13 = ObjectDefinition.get(var14);
                    if (var13.anInt791 == 1) {
                        client.collisionMaps[var0].method152(x, y);
                    }
                }
            }

            if (var4 >= 0) {
                var12 = var0;
                if (var0 < 3 && (Statics45.sceneRenderRules[1][x][y] & 2) == 2) {
                    var12 = var0 + 1;
                }

                SerializableProcessor.method451(var0, var12, x, y, var4, var5, var6, client.sceneGraph, client.collisionMaps[var0]);
            }
        }

    }

    public static void method407() {
        if (client.aBoolean996 && PlayerEntity.local != null) {
            int var0 = PlayerEntity.local.pathXQueue[0];
            int var1 = PlayerEntity.local.pathYQueue[0];
            if (var0 < 0 || var1 < 0 || var0 >= 104 || var1 >= 104) {
                return;
            }

            ObjectSound.anInt371 = PlayerEntity.local.fineX;
            int var2 = SceneGraph.getTileHeight(PlayerEntity.local.fineX, PlayerEntity.local.fineY, SceneGraph.floorLevel) - client.anInt982;
            if (var2 < Statics3.anInt802) {
                Statics3.anInt802 = var2;
            }

            Statics52.anInt498 = PlayerEntity.local.fineY;
            client.aBoolean996 = false;
        }

    }

    public static int method405() {
        byte var2 = 0;
        return var2 + NetWorker.anInt1497 + NetWorker.anInt1496;
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
