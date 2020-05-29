package jag.worldmap;

import jag.EntityUID;
import jag.audi.AudioSystem;
import jag.audi.AudioSystemProvider;
import jag.game.GameEngine;
import jag.js5.Archive;
import jag.js5.ResourceRequest;
import jag.js5.NetWorker;

public class WorldMapDecor {
    public static int anInt543;
    final int objectId;
    final int decorationId;
    final int rotation;

    WorldMapDecor(int objectId, int decorationId, int rotation) {
        this.objectId = objectId;
        this.decorationId = decorationId;
        this.rotation = rotation;
    }

    public static void method377(Archive var0, int var1, int var2, int var3, byte var4, boolean var5) {
        long var6 = (var1 << 16) + var2;
        ResourceRequest var8 = (ResourceRequest) NetWorker.prioritized.lookup(var6);
        if (var8 == null) {
            var8 = (ResourceRequest) NetWorker.pendingPrioritized.lookup(var6);
            if (var8 == null) {
                var8 = (ResourceRequest) NetWorker.aNodeTable1503.lookup(var6);
                if (var8 != null) {
                    if (var5) {
                        var8.unlinkDoubly();
                        NetWorker.prioritized.put(var8, var6);
                        --NetWorker.anInt1491;
                        ++NetWorker.anInt1497;
                    }

                } else {
                    if (!var5) {
                        var8 = (ResourceRequest) NetWorker.pendingExtras.lookup(var6);
                        if (var8 != null) {
                            return;
                        }
                    }

                    var8 = new ResourceRequest();
                    var8.aArchive1221 = var0;
                    var8.crc = var3;
                    var8.aByte1220 = var4;
                    if (var5) {
                        NetWorker.prioritized.put(var8, var6);
                        ++NetWorker.anInt1497;
                    } else {
                        NetWorker.extras.method300(var8);
                        NetWorker.aNodeTable1503.put(var8, var6);
                        ++NetWorker.anInt1491;
                    }

                }
            }
        }
    }

    public static boolean method379(long var0) {
        return EntityUID.getObjectType(var0) == 2;
    }

    public static void method382(AudioSystemProvider var0) {
        AudioSystem.aAudioSystemProvider_1840 = var0;
    }

    public static void method383() {
        GameEngine.clock.update();

        int var0;
        for (var0 = 0; var0 < 32; ++var0) {
            GameEngine.aLongArray1289[var0] = 0L;
        }

        for (var0 = 0; var0 < 32; ++var0) {
            GameEngine.aLongArray1313[var0] = 0L;
        }

        GameEngine.anInt1309 = 0;
    }

    public static int method378(int var0, int var1) {
        int var2 = WorldMapLabelSize.method363(45365 + var0, var1 + 91923, 4) - 128 + (WorldMapLabelSize.method363(10294 + var0, 37821 + var1, 2) - 128 >> 1) + (WorldMapLabelSize.method363(var0, var1, 1) - 128 >> 2);
        var2 = (int) ((double) var2 * 0.3D) + 35;
        if (var2 < 10) {
            var2 = 10;
        } else if (var2 > 60) {
            var2 = 60;
        }

        return var2;
    }

}
