package jag.game.stockmarket;

import jag.commons.collection.NodeDeque;
import jag.game.client;
import jag.game.scene.SceneGraph;
import jag.game.scene.entity.*;
import jag.game.type.ObjectDefinition;
import jag.graphics.IndexedSprite;
import jag.graphics.JagGraphics3D;
import jag.opcode.PacketBuffer;
import jag.opcode.RegionUpdateType;
import jag.statics.Statics45;

import java.util.Comparator;

public final class StockMarketOfferQuantityComparator implements Comparator<StockMarketEvent> {

    public static IndexedSprite[] aDoublyNode_Sub24_Sub4Array653;

    public static void method479(RegionUpdateType updateType) {
        PacketBuffer inbuff = client.netWriter.inbuffer;
        int sceneY;
        int var5;
        int var6;
        int var7;
        int var8;
        int var9;
        int var10;
        int var12;
        int var13;
        int var14;
        if (RegionUpdateType.TRANSMOGRIFY_PLAYER == updateType) {
            byte var2 = inbuff.g1b();
            byte var3 = inbuff.g1b();
            sceneY = inbuff.g1();
            var5 = sceneY >> 2;
            var6 = sceneY & 3;
            var7 = client.OBJECT_TYPE_TO_STUB_TYPE[var5];
            var8 = inbuff.ig1();
            var9 = (var8 >> 4 & 7) + SceneGraph.regionChunkX;
            var10 = (var8 & 7) + SceneGraph.regionChunkY;
            byte var11 = inbuff.method1075();
            var12 = inbuff.method1055();
            var13 = inbuff.readLEUShortA();
            var14 = inbuff.g2();
            int var15 = inbuff.method1055();
            byte var16 = inbuff.method1063();
            PlayerEntity var17;
            if (var15 == client.playerIndex) {
                var17 = PlayerEntity.local;
            } else {
                var17 = client.players[var15];
            }

            if (var17 != null) {
                ObjectDefinition var18 = ObjectDefinition.get(var14);
                int var19;
                int var20;
                if (var6 != 1 && var6 != 3) {
                    var19 = var18.sizeX;
                    var20 = var18.sizeY;
                } else {
                    var19 = var18.sizeY;
                    var20 = var18.sizeX;
                }

                int var21 = var9 + (var19 >> 1);
                int var22 = var9 + (var19 + 1 >> 1);
                int var23 = var10 + (var20 >> 1);
                int var24 = var10 + (var20 + 1 >> 1);
                int[][] var25 = Statics45.tileHeights[SceneGraph.floorLevel];
                int var26 = var25[var21][var23] + var25[var22][var23] + var25[var21][var24] + var25[var22][var24] >> 2;
                int var27 = (var9 << 7) + (var19 << 6);
                int var28 = (var10 << 7) + (var20 << 6);
                Model var29 = var18.method1103(var5, var6, var25, var27, var26, var28);
                if (var29 != null) {
                    PendingSpawn.pushLater(SceneGraph.floorLevel, var9, var10, var7, -1, 0, 0, var12 + 1, var13 + 1);
                    var17.animationStartCycle = var12 + client.engineCycle;
                    var17.animationEndCycle = var13 + client.engineCycle;
                    var17.transformedNpcModel = var29;
                    var17.maxX = var9 * 128 + var19 * 64;
                    var17.maxY = var10 * 128 + var20 * 64;
                    var17.anInt386 = var26;
                    byte var30;
                    if (var2 > var11) {
                        var30 = var2;
                        var2 = var11;
                        var11 = var30;
                    }

                    if (var3 > var16) {
                        var30 = var3;
                        var3 = var16;
                        var16 = var30;
                    }

                    var17.anInt702 = var2 + var9;
                    var17.anInt666 = var11 + var9;
                    var17.anInt788 = var10 + var3;
                    var17.anInt791 = var10 + var16;
                }
            }
        }

        int position;
        int sceneX;
        int var40;
        if (RegionUpdateType.A_REGION_UPDATE_TYPE___1205 == updateType) {
            position = inbuff.method1055();
            sceneX = inbuff.ig1();
            sceneY = (sceneX >> 4 & 7) + SceneGraph.regionChunkX;
            var5 = (sceneX & 7) + SceneGraph.regionChunkY;
            var6 = inbuff.g1();
            var7 = var6 >> 2;
            var8 = var6 & 3;
            var9 = client.OBJECT_TYPE_TO_STUB_TYPE[var7];
            if (sceneY >= 0 && var5 >= 0 && sceneY < 103 && var5 < 103) {
                if (var9 == 0) {
                    Boundary var31 = client.sceneGraph.method1476(SceneGraph.floorLevel, sceneY, var5);
                    if (var31 != null) {
                        var40 = EntityUID.getObjectId(var31.uid);
                        if (var7 == 2) {
                            var31.entity = new DynamicObject(var40, 2, var8 + 4, SceneGraph.floorLevel, sceneY, var5, position, false, var31.entity);
                            var31.linkedEntity = new DynamicObject(var40, 2, var8 + 1 & 3, SceneGraph.floorLevel, sceneY, var5, position, false, var31.linkedEntity);
                        } else {
                            var31.entity = new DynamicObject(var40, var7, var8, SceneGraph.floorLevel, sceneY, var5, position, false, var31.entity);
                        }
                    }
                }

                if (var9 == 1) {
                    BoundaryDecor var42 = client.sceneGraph.method1441(SceneGraph.floorLevel, sceneY, var5);
                    if (var42 != null) {
                        var40 = EntityUID.getObjectId(var42.uid);
                        if (var7 != 4 && var7 != 5) {
                            if (var7 == 6) {
                                var42.entity = new DynamicObject(var40, 4, var8 + 4, SceneGraph.floorLevel, sceneY, var5, position, false, var42.entity);
                            } else if (var7 == 7) {
                                var42.entity = new DynamicObject(var40, 4, (var8 + 2 & 3) + 4, SceneGraph.floorLevel, sceneY, var5, position, false, var42.entity);
                            } else if (var7 == 8) {
                                var42.entity = new DynamicObject(var40, 4, var8 + 4, SceneGraph.floorLevel, sceneY, var5, position, false, var42.entity);
                                var42.linkedEntity = new DynamicObject(var40, 4, (var8 + 2 & 3) + 4, SceneGraph.floorLevel, sceneY, var5, position, false, var42.linkedEntity);
                            }
                        } else {
                            var42.entity = new DynamicObject(var40, 4, var8, SceneGraph.floorLevel, sceneY, var5, position, false, var42.entity);
                        }
                    }
                }

                if (var9 == 2) {
                    EntityMarker var43 = client.sceneGraph.method1439(SceneGraph.floorLevel, sceneY, var5);
                    if (var7 == 11) {
                        var7 = 10;
                    }

                    if (var43 != null) {
                        var43.entity = new DynamicObject(EntityUID.getObjectId(var43.uid), var7, var8, SceneGraph.floorLevel, sceneY, var5, position, false, var43.entity);
                    }
                }

                if (var9 == 3) {
                    TileDecor var44 = client.sceneGraph.method1454(SceneGraph.floorLevel, sceneY, var5);
                    if (var44 != null) {
                        var44.entity = new DynamicObject(EntityUID.getObjectId(var44.uid), 22, var8, SceneGraph.floorLevel, sceneY, var5, position, false, var44.entity);
                    }
                }
            }

        } else {
            Pickable pickable;
            if (RegionUpdateType.REMOVE_PICKABLE == updateType) {
                position = inbuff.method1056();
                sceneX = (position >> 4 & 7) + SceneGraph.regionChunkX;
                sceneY = (position & 7) + SceneGraph.regionChunkY;
                var5 = inbuff.method1060();
                if (sceneX >= 0 && sceneY >= 0 && sceneX < 104 && sceneY < 104) {
                    NodeDeque<Pickable> deque = client.pickables[SceneGraph.floorLevel][sceneX][sceneY];
                    if (deque != null) {
                        for (pickable = deque.head(); pickable != null; pickable = deque.next()) {
                            if ((var5 & 32767) == pickable.id) {
                                pickable.unlink();
                                break;
                            }
                        }

                        if (deque.head() == null) {
                            client.pickables[SceneGraph.floorLevel][sceneX][sceneY] = null;
                        }

                        Pickable.refresh(sceneX, sceneY);
                    }
                }

            } else if (RegionUpdateType.REMOVE_SCENE_OBJECT == updateType) {
                position = inbuff.ig1();
                sceneX = position >> 2;
                sceneY = position & 3;
                var5 = client.OBJECT_TYPE_TO_STUB_TYPE[sceneX];
                var6 = inbuff.method1056();
                var7 = (var6 >> 4 & 7) + SceneGraph.regionChunkX;
                var8 = (var6 & 7) + SceneGraph.regionChunkY;
                if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104) {
                    PendingSpawn.pushLater(SceneGraph.floorLevel, var7, var8, var5, -1, sceneX, sceneY, 0, -1);
                }

            } else if (RegionUpdateType.ADD_PICKABLE == updateType) {
                position = inbuff.method1055();
                sceneX = inbuff.readLEUShortA();
                sceneY = inbuff.method1056();
                var5 = (sceneY >> 4 & 7) + SceneGraph.regionChunkX;
                var6 = (sceneY & 7) + SceneGraph.regionChunkY;
                if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                    pickable = new Pickable();
                    pickable.id = sceneX;
                    pickable.stackSize = position;
                    if (client.pickables[SceneGraph.floorLevel][var5][var6] == null) {
                        client.pickables[SceneGraph.floorLevel][var5][var6] = new NodeDeque();
                    }

                    client.pickables[SceneGraph.floorLevel][var5][var6].add(pickable);
                    Pickable.refresh(var5, var6);
                }

            } else {
                if (RegionUpdateType.A_REGION_UPDATE_TYPE___1206 == updateType) {
                    position = inbuff.method1074();
                    sceneX = (position >> 4 & 7) + SceneGraph.regionChunkX;
                    sceneY = (position & 7) + SceneGraph.regionChunkY;
                    var5 = inbuff.method1074();
                    var6 = var5 >> 4 & 15;
                    var7 = var5 & 7;
                    var8 = inbuff.g2();
                    var9 = inbuff.method1074();
                    if (sceneX >= 0 && sceneY >= 0 && sceneX < 104 && sceneY < 104) {
                        var10 = var6 + 1;
                        if (PlayerEntity.local.pathXQueue[0] >= sceneX - var10 && PlayerEntity.local.pathXQueue[0] <= var10 + sceneX && PlayerEntity.local.pathYQueue[0] >= sceneY - var10 && PlayerEntity.local.pathYQueue[0] <= var10 + sceneY && client.anInt897 != 0 && var7 > 0 && client.audioEffectCount < 50) {
                            client.anIntArray899[client.audioEffectCount] = var8;
                            client.anIntArray905[client.audioEffectCount] = var7;
                            client.anIntArray906[client.audioEffectCount] = var9;
                            client.audioEffects[client.audioEffectCount] = null;
                            client.anIntArray902[client.audioEffectCount] = var6 + (sceneY << 8) + (sceneX << 16);
                            ++client.audioEffectCount;
                        }
                    }
                }

                if (RegionUpdateType.A_REGION_UPDATE_TYPE___1204 == updateType) {
                    position = inbuff.g1();
                    sceneX = position >> 2;
                    sceneY = position & 3;
                    var5 = client.OBJECT_TYPE_TO_STUB_TYPE[sceneX];
                    var6 = inbuff.method1056();
                    var7 = (var6 >> 4 & 7) + SceneGraph.regionChunkX;
                    var8 = (var6 & 7) + SceneGraph.regionChunkY;
                    var9 = inbuff.g2();
                    if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104) {
                        PendingSpawn.pushLater(SceneGraph.floorLevel, var7, var8, var5, var9, sceneX, sceneY, 0, -1);
                    }

                } else if (RegionUpdateType.SPAWN_PROJECTILE == updateType) {
                    position = inbuff.method1060();
                    sceneX = inbuff.method1074();
                    sceneY = (sceneX >> 4 & 7) + SceneGraph.regionChunkX;
                    var5 = (sceneX & 7) + SceneGraph.regionChunkY;
                    var6 = inbuff.readLEUShortA();
                    var7 = inbuff.method1060();
                    byte var39 = inbuff.method1059();
                    var9 = inbuff.method1074() * 4;
                    var10 = inbuff.g1();
                    var40 = inbuff.method1056();
                    byte var41 = inbuff.method1063();
                    var13 = inbuff.method1078();
                    var14 = inbuff.method1074() * 4;
                    var12 = var41 + sceneY;
                    var8 = var39 + var5;
                    if (sceneY >= 0 && var5 >= 0 && sceneY < 104 && var5 < 104 && var12 >= 0 && var8 >= 0 && var12 < 104 && var8 < 104 && position != 65535) {
                        sceneY = sceneY * 128 + 64;
                        var5 = var5 * 128 + 64;
                        var12 = var12 * 128 + 64;
                        var8 = var8 * 128 + 64;
                        Projectile var34 = new Projectile(position, SceneGraph.floorLevel, sceneY, var5, SceneGraph.getTileHeight(sceneY, var5, SceneGraph.floorLevel) - var14, var6 + client.engineCycle, var7 + client.engineCycle, var40, var10, var13, var9);
                        var34.target(var12, var8, SceneGraph.getTileHeight(var12, var8, SceneGraph.floorLevel) - var9, var6 + client.engineCycle);
                        client.projectiles.add(var34);
                    }

                } else if (RegionUpdateType.SET_PICKABLE_STACK_SIZE != updateType) {
                    if (RegionUpdateType.SPAWN_GRAPHICS_OBJECT == updateType) {
                        position = inbuff.method1060();
                        sceneX = inbuff.method1056();
                        sceneY = inbuff.method1056();
                        var5 = (sceneY >> 4 & 7) + SceneGraph.regionChunkX;
                        var6 = (sceneY & 7) + SceneGraph.regionChunkY;
                        var7 = inbuff.readLEUShortA();
                        if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                            var5 = var5 * 128 + 64;
                            var6 = var6 * 128 + 64;
                            EffectObject var45 = new EffectObject(var7, SceneGraph.floorLevel, var5, var6, SceneGraph.getTileHeight(var5, var6, SceneGraph.floorLevel) - sceneX, position, client.engineCycle);
                            client.effectObjects.add(var45);
                        }

                    }
                } else {
                    position = inbuff.readLEUShortA();
                    sceneX = inbuff.method1055();
                    sceneY = inbuff.ig1();
                    var5 = (sceneY >> 4 & 7) + SceneGraph.regionChunkX;
                    var6 = (sceneY & 7) + SceneGraph.regionChunkY;
                    var7 = inbuff.method1055();
                    if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                        NodeDeque<Pickable> var35 = client.pickables[SceneGraph.floorLevel][var5][var6];
                        if (var35 != null) {
                            for (Pickable var36 = var35.head(); var36 != null; var36 = var35.next()) {
                                if ((position & 32767) == var36.id && var7 == var36.stackSize) {
                                    var36.stackSize = sceneX;
                                    break;
                                }
                            }

                            Pickable.refresh(var5, var6);
                        }
                    }

                }
            }
        }
    }

    public static boolean method477(int var0) {
        return (var0 >> 20 & 1) != 0;
    }

    public static void method480(int var0, int var1) {
        int[] var2 = new int[9];

        for (int var3 = 0; var3 < var2.length; ++var3) {
            int var4 = var3 * 32 + 15 + 128;
            int var5 = var4 * 3 + 600;
            int var7 = JagGraphics3D.SIN_TABLE[var4];
            int var8 = var1 - 334;
            if (var8 < 0) {
                var8 = 0;
            } else if (var8 > 100) {
                var8 = 100;
            }

            int var9 = (client.aShort920 - client.aShort913) * var8 / 100 + client.aShort913;
            int var10 = var9 * var5 / 256;
            var2[var3] = var7 * var10 >> 16;
        }

        SceneGraph.defineVisibilityMap(var2, 500, 800, var0 * 334 / var1, 334);
    }

    public static int method476() {
        if (client.archives != null && client.anInt926 < client.archives.size()) {
            int var0 = 0;

            for (int var1 = 0; var1 <= client.anInt926; ++var1) {
                var0 += client.archives.get(var1).validEntryCount;
            }

            return var0 * 10000 / client.archiveEntryCount;
        }
        return 10000;
    }

    int method478(StockMarketEvent var1, StockMarketEvent var2) {
        return Integer.compare(var1.aStockMarketOffer551.itemQuantity, var2.aStockMarketOffer551.itemQuantity);
    }

    public int compare(StockMarketEvent var1, StockMarketEvent var2) {
        return this.method478(var1, var2);
    }

    public boolean equals(Object var1) {
        return super.equals(var1);
    }
}
