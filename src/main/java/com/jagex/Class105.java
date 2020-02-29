package com.jagex;

import java.net.URL;

public class Class105 {
    public static int anInt775;
    static Sprite[] hintIcons;
    final URL anURL778;
    volatile byte[] aByteArray776;
    volatile boolean aBoolean779;

    Class105(URL var1) {
        this.anURL778 = var1;
    }

    public static void method614() {
        synchronized (Class174.anObject1463) {
            if (Class174.anInt1464 != 0) {
                Class174.anInt1464 = 1;

                try {
                    Class174.anObject1463.wait();
                } catch (InterruptedException ignored) {
                }
            }

        }
    }

    static void method617(InterfaceComponent component, ItemDefinition definition, int index, int i, boolean idk) {
        String[] var5 = definition.actions;
        byte var6 = -1;
        String var7 = null;
        if (var5 != null && var5[i] != null) {
            if (i == 0) {
                var6 = 33;
            } else if (i == 1) {
                var6 = 34;
            } else if (i == 2) {
                var6 = 35;
            } else if (i == 3) {
                var6 = 36;
            } else {
                var6 = 37;
            }

            var7 = var5[i];
        } else if (i == 4) {
            var6 = 37;
            var7 = "Drop";
        }

        if (var6 != -1 && var7 != null) {
            ActionPrioritySetting.insertMenuItem(var7, World.getColorTags(16748608) + definition.name, var6, definition.anInt693, index, component.uid, idk);
        }

    }

    static void method613() {
        if (client.anInt1030 >= 0 && client.players[client.anInt1030] != null) {
            GPI.method415(client.players[client.anInt1030], false);
        }

    }

    static void updatePlayerLocation(PacketBuffer packet, int index) {
        boolean var2 = packet.method1398(1) == 1;
        if (var2) {
            GPI.anIntArray588[++GPI.anInt594 - 1] = index;
        }

        int var3 = packet.method1398(2);
        PlayerEntity player = client.players[index];
        if (var3 == 0) {
            if (var2) {
                player.aBoolean1904 = false;
            } else if (client.playerIndex == index) {
                throw new RuntimeException();
            } else {
                GPI.playerLocations[index] = (player.anInt1473 << 28) + (Statics18.baseX + player.pathXQueue[0] >> 13 << 14) + (Statics36.baseY + player.pathYQueue[0] >> 13);
                if (player.transformedOrienation != -1) {
                    GPI.playerOrientations[index] = player.transformedOrienation;
                } else {
                    GPI.playerOrientations[index] = player.orientation;
                }

                GPI.playerTargetIndices[index] = player.targetIndex;
                client.players[index] = null;
                if (packet.method1398(1) != 0) {
                    Statics34.method1168(packet, index);
                }

            }
        } else {
            int var5;
            int var6;
            int var7;
            if (var3 == 1) {
                var5 = packet.method1398(3);
                var6 = player.pathXQueue[0];
                var7 = player.pathYQueue[0];
                if (var5 == 0) {
                    --var6;
                    --var7;
                } else if (var5 == 1) {
                    --var7;
                } else if (var5 == 2) {
                    ++var6;
                    --var7;
                } else if (var5 == 3) {
                    --var6;
                } else if (var5 == 4) {
                    ++var6;
                } else if (var5 == 5) {
                    --var6;
                    ++var7;
                } else if (var5 == 6) {
                    ++var7;
                } else if (var5 == 7) {
                    ++var6;
                    ++var7;
                }

                if (client.playerIndex != index || player.fineX >= 1536 && player.fineY >= 1536 && player.fineX < 11776 && player.fineY < 11776) {
                    if (var2) {
                        player.aBoolean1904 = true;
                        player.anInt704 = var6;
                        player.anInt1739 = var7;
                    } else {
                        player.aBoolean1904 = false;
                        player.method1415(var6, var7, GPI.aByteArray596[index]);
                    }
                } else {
                    player.method1414(var6, var7);
                    player.aBoolean1904 = false;
                }

            } else if (var3 == 2) {
                var5 = packet.method1398(4);
                var6 = player.pathXQueue[0];
                var7 = player.pathYQueue[0];
                if (var5 == 0) {
                    var6 -= 2;
                    var7 -= 2;
                } else if (var5 == 1) {
                    --var6;
                    var7 -= 2;
                } else if (var5 == 2) {
                    var7 -= 2;
                } else if (var5 == 3) {
                    ++var6;
                    var7 -= 2;
                } else if (var5 == 4) {
                    var6 += 2;
                    var7 -= 2;
                } else if (var5 == 5) {
                    var6 -= 2;
                    --var7;
                } else if (var5 == 6) {
                    var6 += 2;
                    --var7;
                } else if (var5 == 7) {
                    var6 -= 2;
                } else if (var5 == 8) {
                    var6 += 2;
                } else if (var5 == 9) {
                    var6 -= 2;
                    ++var7;
                } else if (var5 == 10) {
                    var6 += 2;
                    ++var7;
                } else if (var5 == 11) {
                    var6 -= 2;
                    var7 += 2;
                } else if (var5 == 12) {
                    --var6;
                    var7 += 2;
                } else if (var5 == 13) {
                    var7 += 2;
                } else if (var5 == 14) {
                    ++var6;
                    var7 += 2;
                } else if (var5 == 15) {
                    var6 += 2;
                    var7 += 2;
                }

                if (client.playerIndex == index && (player.fineX < 1536 || player.fineY < 1536 || player.fineX >= 11776 || player.fineY >= 11776)) {
                    player.method1414(var6, var7);
                    player.aBoolean1904 = false;
                } else if (var2) {
                    player.aBoolean1904 = true;
                    player.anInt704 = var6;
                    player.anInt1739 = var7;
                } else {
                    player.aBoolean1904 = false;
                    player.method1415(var6, var7, GPI.aByteArray596[index]);
                }

            } else {
                var5 = packet.method1398(1);
                int var8;
                int var9;
                int var10;
                int var11;
                if (var5 == 0) {
                    var6 = packet.method1398(12);
                    var7 = var6 >> 10;
                    var8 = var6 >> 5 & 31;
                    if (var8 > 15) {
                        var8 -= 32;
                    }

                    var9 = var6 & 31;
                    if (var9 > 15) {
                        var9 -= 32;
                    }

                    var10 = var8 + player.pathXQueue[0];
                    var11 = var9 + player.pathYQueue[0];
                    if (client.playerIndex == index && (player.fineX < 1536 || player.fineY < 1536 || player.fineX >= 11776 || player.fineY >= 11776)) {
                        player.method1414(var10, var11);
                        player.aBoolean1904 = false;
                    } else if (var2) {
                        player.aBoolean1904 = true;
                        player.anInt704 = var10;
                        player.anInt1739 = var11;
                    } else {
                        player.aBoolean1904 = false;
                        player.method1415(var10, var11, GPI.aByteArray596[index]);
                    }

                    player.anInt1473 = (byte) (var7 + player.anInt1473 & 3);
                    if (client.playerIndex == index) {
                        SceneGraph.floorLevel = player.anInt1473;
                    }

                } else {
                    var6 = packet.method1398(30);
                    var7 = var6 >> 28;
                    var8 = var6 >> 14 & 16383;
                    var9 = var6 & 16383;
                    var10 = (Statics18.baseX + var8 + player.pathXQueue[0] & 16383) - Statics18.baseX;
                    var11 = (Statics36.baseY + var9 + player.pathYQueue[0] & 16383) - Statics36.baseY;
                    if (client.playerIndex != index || player.fineX >= 1536 && player.fineY >= 1536 && player.fineX < 11776 && player.fineY < 11776) {
                        if (var2) {
                            player.aBoolean1904 = true;
                            player.anInt704 = var10;
                            player.anInt1739 = var11;
                        } else {
                            player.aBoolean1904 = false;
                            player.method1415(var10, var11, GPI.aByteArray596[index]);
                        }
                    } else {
                        player.method1414(var10, var11);
                        player.aBoolean1904 = false;
                    }

                    player.anInt1473 = (byte) (var7 + player.anInt1473 & 3);
                    if (client.playerIndex == index) {
                        SceneGraph.floorLevel = player.anInt1473;
                    }

                }
            }
        }
    }

    public boolean method616() {
        return this.aBoolean779;
    }

    public byte[] method618() {
        return this.aByteArray776;
    }
}
