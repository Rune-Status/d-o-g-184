package jag.statics;

import jag.game.client;
import jag.game.scene.entity.PathingEntity;
import jag.game.scene.entity.PlayerEntity;
import jag.graphics.JagGraphics;
import jag.opcode.GPI;

public class Statics2 {
    public static final long[] onCursorUids;
    public static int onCursorCount;
    public static boolean[] validInterfaces;
    public static boolean aBoolean663;
    public static int anInt656;
    public static int anInt654;
    public static int anInt661;
    public static boolean aBoolean660;
    public static int anInt659;
    public static int anInt657;
    public static int anInt658;
    public static int anInt662;
    public static int anInt655;

    static {
        aBoolean663 = false;
        anInt656 = 0;
        anInt661 = 0;
        aBoolean660 = false;
        onCursorCount = 0;
        onCursorUids = new long[1000];
    }

    public static void method481(int var0, int var1, int var2, int var3) {
        client.anInt1000 = 0;
        boolean var4 = false;
        int var5 = -1;
        int var6 = -1;
        int var7 = GPI.playerCount;
        int[] var8 = GPI.playerIndices;

        int var9;
        for (var9 = 0; var9 < var7 + client.npcCount; ++var9) {
            PathingEntity var10;
            if (var9 < var7) {
                var10 = client.players[var8[var9]];
                if (var8[var9] == client.anInt1030) {
                    var4 = true;
                    var5 = var9;
                    continue;
                }

                if (var10 == PlayerEntity.local) {
                    var6 = var9;
                    continue;
                }
            } else {
                var10 = client.npcs[client.npcIndices[var9 - var7]];
            }

            PathingEntity.method1297(var10, var9, var0, var1, var2, var3);
        }

        if (client.aBoolean1020 && var6 != -1) {
            PathingEntity.method1297(PlayerEntity.local, var6, var0, var1, var2, var3);
        }

        if (var4) {
            PathingEntity.method1297(client.players[client.anInt1030], var5, var0, var1, var2, var3);
        }

        for (var9 = 0; var9 < client.anInt1000; ++var9) {
            int var11 = client.anIntArray1013[var9];
            int var12 = client.anIntArray1005[var9];
            int var13 = client.anIntArray994[var9];
            int var14 = client.anIntArray1012[var9];
            boolean var15 = true;

            while (var15) {
                var15 = false;

                for (int var16 = 0; var16 < var9; ++var16) {
                    if (var12 + 2 > client.anIntArray1005[var16] - client.anIntArray1012[var16] && var12 - var14 < client.anIntArray1005[var16] + 2 && var11 - var13 < client.anIntArray994[var16] + client.anIntArray1013[var16] && var11 + var13 > client.anIntArray1013[var16] - client.anIntArray994[var16] && client.anIntArray1005[var16] - client.anIntArray1012[var16] < var12) {
                        var12 = client.anIntArray1005[var16] - client.anIntArray1012[var16];
                        var15 = true;
                    }
                }
            }

            client.anInt998 = client.anIntArray1013[var9];
            client.anInt993 = client.anIntArray1005[var9] = var12;
            String var17 = client.overheadMessages[var9];
            if (client.anInt1045 == 0) {
                int var18 = 16776960;
                if (client.anIntArray995[var9] < 6) {
                    var18 = client.anIntArray1094[client.anIntArray995[var9]];
                }

                if (client.anIntArray995[var9] == 6) {
                    var18 = client.anInt1001 % 20 < 10 ? 16711680 : 16776960;
                }

                if (client.anIntArray995[var9] == 7) {
                    var18 = client.anInt1001 % 20 < 10 ? 255 : '\uffff';
                }

                if (client.anIntArray995[var9] == 8) {
                    var18 = client.anInt1001 % 20 < 10 ? '뀀' : 8454016;
                }

                int var19;
                if (client.anIntArray995[var9] == 9) {
                    var19 = 150 - client.anIntArray991[var9];
                    if (var19 < 50) {
                        var18 = var19 * 1280 + 16711680;
                    } else if (var19 < 100) {
                        var18 = 16776960 - (var19 - 50) * 327680;
                    } else if (var19 < 150) {
                        var18 = (var19 - 100) * 5 + 65280;
                    }
                }

                if (client.anIntArray995[var9] == 10) {
                    var19 = 150 - client.anIntArray991[var9];
                    if (var19 < 50) {
                        var18 = var19 * 5 + 16711680;
                    } else if (var19 < 100) {
                        var18 = 16711935 - (var19 - 50) * 327680;
                    } else if (var19 < 150) {
                        var18 = (var19 - 100) * 327680 + 255 - (var19 - 100) * 5;
                    }
                }

                if (client.anIntArray995[var9] == 11) {
                    var19 = 150 - client.anIntArray991[var9];
                    if (var19 < 50) {
                        var18 = 16777215 - var19 * 327685;
                    } else if (var19 < 100) {
                        var18 = (var19 - 50) * 327685 + 65280;
                    } else if (var19 < 150) {
                        var18 = 16777215 - (var19 - 100) * 327680;
                    }
                }

                if (client.anIntArray1007[var9] == 0) {
                    Statics7.aFont863.method1154(var17, var0 + client.anInt998, client.anInt993 + var1, var18, 0);
                }

                if (client.anIntArray1007[var9] == 1) {
                    Statics7.aFont863.method1157(var17, var0 + client.anInt998, client.anInt993 + var1, var18, 0, client.anInt1001);
                }

                if (client.anIntArray1007[var9] == 2) {
                    Statics7.aFont863.method1155(var17, var0 + client.anInt998, client.anInt993 + var1, var18, 0, client.anInt1001);
                }

                if (client.anIntArray1007[var9] == 3) {
                    Statics7.aFont863.method1146(var17, var0 + client.anInt998, client.anInt993 + var1, var18, 0, client.anInt1001, 150 - client.anIntArray991[var9]);
                }

                if (client.anIntArray1007[var9] == 4) {
                    var19 = (150 - client.anIntArray991[var9]) * (Statics7.aFont863.method1145(var17) + 100) / 150;
                    JagGraphics.method1364(var0 + client.anInt998 - 50, var1, var0 + client.anInt998 + 50, var3 + var1);
                    Statics7.aFont863.drawString(var17, var0 + client.anInt998 + 50 - var19, client.anInt993 + var1, var18, 0);
                    JagGraphics.setClip(var0, var1, var0 + var2, var3 + var1);
                }

                if (client.anIntArray1007[var9] == 5) {
                    var19 = 150 - client.anIntArray991[var9];
                    int var20 = 0;
                    if (var19 < 25) {
                        var20 = var19 - 25;
                    } else if (var19 > 125) {
                        var20 = var19 - 125;
                    }

                    JagGraphics.method1364(var0, client.anInt993 + var1 - Statics7.aFont863.anInt375 - 1, var0 + var2, client.anInt993 + var1 + 5);
                    Statics7.aFont863.method1154(var17, var0 + client.anInt998, var20 + client.anInt993 + var1, var18, 0);
                    JagGraphics.setClip(var0, var1, var0 + var2, var3 + var1);
                }
            } else {
                Statics7.aFont863.method1154(var17, var0 + client.anInt998, client.anInt993 + var1, 16776960, 0);
            }
        }

    }

    public static void method238(int var0, int var1) {
        anInt656 = var0;
        anInt661 = var1;
        aBoolean663 = true;
        onCursorCount = 0;
        aBoolean660 = false;
    }
}
