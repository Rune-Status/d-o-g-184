package jag.opcode;

import jag.EntityUID;
import jag.game.client;
import jag.game.scene.SceneGraph;
import jag.game.scene.entity.PlayerEntity;

public class GPI {
    public static final byte[] playerSkipFlags;
    public static final byte[] aByteArray596;
    public static final Buffer[] buffers;
    public static final int[] playerIndices;
    public static final int[] globalPlayerIndices;
    public static final int[] playerLocations;
    public static final int[] playerOrientations;
    public static final int[] playerTargetIndices;
    public static final int[] anIntArray588;
    public static final Buffer chatBuffer;
    public static int playerCount;
    public static int globalPlayerCount;
    public static int anInt594;

    static {
        playerSkipFlags = new byte[2048];
        aByteArray596 = new byte[2048];
        buffers = new Buffer[2048];
        playerCount = 0;
        playerIndices = new int[2048];
        globalPlayerCount = 0;
        globalPlayerIndices = new int[2048];
        playerLocations = new int[2048];
        playerOrientations = new int[2048];
        playerTargetIndices = new int[2048];
        anInt594 = 0;
        anIntArray588 = new int[2048];
        chatBuffer = new Buffer(new byte[5000]);
    }

    public static void loadPlayersIntoScene(PlayerEntity var0, boolean var1) {
        if (var0 != null && var0.isDefined() && !var0.hidden) {
            var0.aBoolean1905 = (client.lowMemory && playerCount > 50 || playerCount > 200) && var1 && var0.walkingStance == var0.stance;

            int var2 = var0.fineX >> 7;
            int var3 = var0.fineY >> 7;
            if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
                long var4 = EntityUID.build(0, 0, 0, false, var0.index);
                if (var0.transformedNpcModel != null && client.engineCycle >= var0.anInt564 && client.engineCycle < var0.anInt368) {
                    var0.aBoolean1905 = false;
                    var0.anInt379 = SceneGraph.getTileHeight(var0.fineX, var0.fineY, SceneGraph.floorLevel);
                    var0.renderCycle = client.engineCycle;
                    client.sceneGraph.addPlayerObject(SceneGraph.floorLevel, var0.fineX, var0.fineY, var0.anInt379, var0, var0.anInt1436, var4, var0.anInt702, var0.anInt788, var0.anInt666, var0.anInt791);
                } else {
                    if ((var0.fineX & 127) == 64 && (var0.fineY & 127) == 64) {
                        if (client.anIntArrayArray1003[var2][var3] == client.anInt1001) {
                            return;
                        }

                        client.anIntArrayArray1003[var2][var3] = client.anInt1001;
                    }

                    var0.anInt379 = SceneGraph.getTileHeight(var0.fineX, var0.fineY, SceneGraph.floorLevel);
                    var0.renderCycle = client.engineCycle;
                    client.sceneGraph.addEntityMarker(SceneGraph.floorLevel, var0.fineX, var0.fineY, var0.anInt379, 60, var0, var0.anInt1436, var4, var0.stretch);
                }
            }
        }

    }

    public static void method488() {
        for (int var0 = 0; var0 < playerCount; ++var0) {
            PlayerEntity var1 = client.players[playerIndices[var0]];
            var1.method827();
        }

    }
}
