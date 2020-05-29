package jag.statics;

import jag.audi.Node_Sub19;
import jag.audi.ObjectSound;
import jag.game.client;
import jag.game.scene.entity.NpcEntity;
import jag.game.scene.entity.PendingSpawn;
import jag.game.scene.entity.PlayerEntity;
import jag.game.stockmarket.StockMarketOfferWorldComparator;
import jag.opcode.IncomingPacketMeta;
import jag.worldmap.WorldMapIcon_Sub1;
import jag.worldmap.WorldMapSprite;

public class Statics37 {
    public static final char[] aCharArray1634;
    static final char[] aCharArray1635;
    static final char[] aCharArray1633;
    static final int[] anIntArray1632;

    static {
        aCharArray1634 = new char[64];

        int var0;
        for (var0 = 0; var0 < 26; ++var0) {
            aCharArray1634[var0] = (char) (var0 + 65);
        }

        for (var0 = 26; var0 < 52; ++var0) {
            aCharArray1634[var0] = (char) (var0 + 97 - 26);
        }

        for (var0 = 52; var0 < 62; ++var0) {
            aCharArray1634[var0] = (char) (var0 + 48 - 52);
        }

        aCharArray1634[62] = '+';
        aCharArray1634[63] = '/';
        aCharArray1635 = new char[64];

        for (var0 = 0; var0 < 26; ++var0) {
            aCharArray1635[var0] = (char) (var0 + 65);
        }

        for (var0 = 26; var0 < 52; ++var0) {
            aCharArray1635[var0] = (char) (var0 + 97 - 26);
        }

        for (var0 = 52; var0 < 62; ++var0) {
            aCharArray1635[var0] = (char) (var0 + 48 - 52);
        }

        aCharArray1635[62] = '*';
        aCharArray1635[63] = '-';
        aCharArray1633 = new char[64];

        for (var0 = 0; var0 < 26; ++var0) {
            aCharArray1633[var0] = (char) (var0 + 65);
        }

        for (var0 = 26; var0 < 52; ++var0) {
            aCharArray1633[var0] = (char) (var0 + 97 - 26);
        }

        for (var0 = 52; var0 < 62; ++var0) {
            aCharArray1633[var0] = (char) (var0 + 48 - 52);
        }

        aCharArray1633[62] = '-';
        aCharArray1633[63] = '_';
        anIntArray1632 = new int[128];

        for (var0 = 0; var0 < anIntArray1632.length; ++var0) {
            anIntArray1632[var0] = -1;
        }

        for (var0 = 65; var0 <= 90; ++var0) {
            anIntArray1632[var0] = var0 - 65;
        }

        for (var0 = 97; var0 <= 122; ++var0) {
            anIntArray1632[var0] = var0 - 97 + 26;
        }

        for (var0 = 48; var0 <= 57; ++var0) {
            anIntArray1632[var0] = var0 - 48 + 52;
        }

        anIntArray1632[43] = 62;
        anIntArray1632[42] = 62;
        anIntArray1632[47] = 63;
        anIntArray1632[45] = 63;
    }

    public static void method1187(int var0, int var1, boolean var2) {
        if (!var2 || var0 != IncomingPacketMeta.anInt206 || Node_Sub19.anInt1191 != var1) {
            IncomingPacketMeta.anInt206 = var0;
            Node_Sub19.anInt1191 = var1;
            client.setGameState(25);
            WorldMapSprite.method242("Loading - please wait.", true);
            int var3 = client.baseX;
            int var4 = client.baseY;
            client.baseX = (var0 - 6) * 8;
            client.baseY = (var1 - 6) * 8;
            int var5 = client.baseX - var3;
            int var6 = client.baseY - var4;

            int var7;
            int var9;
            int[] var10000;
            for (var7 = 0; var7 < 32768; ++var7) {
                NpcEntity var8 = client.npcs[var7];
                if (var8 != null) {
                    for (var9 = 0; var9 < 10; ++var9) {
                        var10000 = var8.pathXQueue;
                        var10000[var9] -= var5;
                        var10000 = var8.pathYQueue;
                        var10000[var9] -= var6;
                    }

                    var8.fineX -= var5 * 128;
                    var8.fineY -= var6 * 128;
                }
            }

            for (var7 = 0; var7 < 2048; ++var7) {
                PlayerEntity var21 = client.players[var7];
                if (var21 != null) {
                    for (var9 = 0; var9 < 10; ++var9) {
                        var10000 = var21.pathXQueue;
                        var10000[var9] -= var5;
                        var10000 = var21.pathYQueue;
                        var10000[var9] -= var6;
                    }

                    var21.fineX -= var5 * 128;
                    var21.fineY -= var6 * 128;
                }
            }

            byte var20 = 0;
            byte var10 = 104;
            byte var22 = 1;
            if (var5 < 0) {
                var20 = 103;
                var10 = -1;
                var22 = -1;
            }

            byte var11 = 0;
            byte var12 = 104;
            byte var13 = 1;
            if (var6 < 0) {
                var11 = 103;
                var12 = -1;
                var13 = -1;
            }

            for (int var14 = var20; var14 != var10; var14 += var22) {
                for (int var15 = var11; var15 != var12; var15 += var13) {
                    int var16 = var5 + var14;
                    int var17 = var6 + var15;

                    for (int var18 = 0; var18 < 4; ++var18) {
                        if (var16 >= 0 && var17 >= 0 && var16 < 104 && var17 < 104) {
                            client.pickableNodeDeques[var18][var14][var15] = client.pickableNodeDeques[var18][var16][var17];
                        } else {
                            client.pickableNodeDeques[var18][var14][var15] = null;
                        }
                    }
                }
            }

            for (PendingSpawn spawn = client.pendingSpawns.head(); spawn != null; spawn = client.pendingSpawns.next()) {
                spawn.sceneX -= var5;
                spawn.sceneY -= var6;
                if (spawn.sceneX < 0 || spawn.sceneY < 0 || spawn.sceneX >= 104 || spawn.sceneY >= 104) {
                    spawn.unlink();
                }
            }

            if (client.destinationX != 0) {
                client.destinationX -= var5;
                client.destinationY -= var6;
            }

            client.audioEffectCount = 0;
            client.cameraLocked = false;
            StockMarketOfferWorldComparator.cameraX -= var5 << 7;
            WorldMapIcon_Sub1.cameraY -= var6 << 7;
            ObjectSound.anInt371 -= var5 << 7;
            Statics52.anInt498 -= var6 << 7;
            client.minimapFloorLevel = -1;
            client.effectObjects.clear();
            client.projectiles.clear();

            for (int level = 0; level < 4; ++level) {
                client.collisionMaps[level].initialize();
            }

        }
    }
}
