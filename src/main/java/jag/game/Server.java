package jag.game;

import jag.URLRequest;
import jag.game.scene.SceneGraph;
import jag.game.scene.entity.PathingEntity;
import jag.opcode.Buffer;
import jag.opcode.OutgoingPacket;
import jag.opcode.OutgoingPacketMeta;

public class Server {

    public static int count;
    public static int current;
    public static int[] populationComparator;
    public static int[] indexComparator;
    public static Server[] servers;
    public static int expectedRead;
    public static URLRequest request;
    public static String slu;

    static {
        count = 0;
        current = 0;
        populationComparator = new int[]{1, 1, 1, 1};
        indexComparator = new int[]{0, 1, 2, 3};
    }

    public int mask;
    public String domain;
    public int id;
    public String activity;
    public int location;
    public int population;
    public int index;

    public Server() {

    }

    public static int method1351(int var0, int var1) {
        int var2 = var0 >>> 31;
        return (var0 + var2) / var1 - var2;
    }

    public static void method1343(String var0) {
        if (!var0.equals("")) {
            OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.JOIN_CLANCHANNEL, client.netWriter.encryptor);
            packet.buffer.p1(Buffer.stringLengthPlusOne(var0));
            packet.buffer.pcstr(var0);
            client.netWriter.writeLater(packet);
        }
    }

    public static void method1354(PathingEntity var0, int var1) {
        SceneGraph.absoluteToViewport(var0.absoluteX, var0.absoluteY, var1);
    }

    public static void method852(int var0, int var1) {
        int[] var2 = new int[4];
        int[] var3 = new int[4];
        var2[0] = var0;
        var3[0] = var1;
        int var4 = 1;

        for (int var5 = 0; var5 < 4; ++var5) {
            if (indexComparator[var5] != var0) {
                var2[var4] = indexComparator[var5];
                var3[var4] = populationComparator[var5];
                ++var4;
            }
        }

        indexComparator = var2;
        populationComparator = var3;
        sort(servers, 0, servers.length - 1, indexComparator, populationComparator);
    }

    public static String method149(int var0) {
        String var1 = Integer.toString(var0);

        for (int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
            var1 = var1.substring(0, var2) + "," + var1.substring(var2);
        }

        if (var1.length() > 9) {
            return " " + client.getColorTags(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>";
        }
        return var1.length() > 6 ? " " + client.getColorTags(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>" : " " + client.getColorTags(16776960) + var1 + "</col>";
    }

    public static void sort(Server[] array, int start, int end, int[] comparatorA, int[] comparatorB) {
        if (start < end) {
            int var5 = start - 1;
            int var6 = end + 1;
            int var7 = (end + start) / 2;
            Server var8 = array[var7];
            array[var7] = array[start];
            array[start] = var8;

            while (var5 < var6) {
                boolean var9 = true;

                int var10;
                int var11;
                int var12;
                do {
                    --var6;

                    for (var10 = 0; var10 < 4; ++var10) {
                        if (comparatorA[var10] == 2) {
                            var11 = array[var6].index;
                            var12 = var8.index;
                        } else if (comparatorA[var10] == 1) {
                            var11 = array[var6].population;
                            var12 = var8.population;
                            if (var11 == -1 && comparatorB[var10] == 1) {
                                var11 = 2001;
                            }

                            if (var12 == -1 && comparatorB[var10] == 1) {
                                var12 = 2001;
                            }
                        } else if (comparatorA[var10] == 3) {
                            var11 = array[var6].isMembers() ? 1 : 0;
                            var12 = var8.isMembers() ? 1 : 0;
                        } else {
                            var11 = array[var6].id;
                            var12 = var8.id;
                        }

                        if (var11 != var12) {
                            if ((comparatorB[var10] != 1 || var11 <= var12) && (comparatorB[var10] != 0 || var11 >= var12)) {
                                var9 = false;
                            }
                            break;
                        }

                        if (var10 == 3) {
                            var9 = false;
                        }
                    }
                } while (var9);

                var9 = true;

                do {
                    ++var5;

                    for (var10 = 0; var10 < 4; ++var10) {
                        if (comparatorA[var10] == 2) {
                            var11 = array[var5].index;
                            var12 = var8.index;
                        } else if (comparatorA[var10] == 1) {
                            var11 = array[var5].population;
                            var12 = var8.population;
                            if (var11 == -1 && comparatorB[var10] == 1) {
                                var11 = 2001;
                            }

                            if (var12 == -1 && comparatorB[var10] == 1) {
                                var12 = 2001;
                            }
                        } else if (comparatorA[var10] == 3) {
                            var11 = array[var5].isMembers() ? 1 : 0;
                            var12 = var8.isMembers() ? 1 : 0;
                        } else {
                            var11 = array[var5].id;
                            var12 = var8.id;
                        }

                        if (var12 != var11) {
                            if ((comparatorB[var10] != 1 || var11 >= var12) && (comparatorB[var10] != 0 || var11 <= var12)) {
                                var9 = false;
                            }
                            break;
                        }

                        if (var10 == 3) {
                            var9 = false;
                        }
                    }
                } while (var9);

                if (var5 < var6) {
                    Server var13 = array[var5];
                    array[var5] = array[var6];
                    array[var6] = var13;
                }
            }

            sort(array, start, var6, comparatorA, comparatorB);
            sort(array, var6 + 1, end, comparatorA, comparatorB);
        }

    }

    public static Server next() {
        return current < count ? servers[++current - 1] : null;
    }

    public static Server first() {
        current = 0;
        return next();
    }

    public boolean isMembers() {
        return (this.mask & 0x1) != 0;
    }

    public boolean method1350() {
        return (this.mask & 0x8) != 0;
    }

    public boolean method1346() {
        return (this.mask & 0x2) != 0;
    }

    public boolean isPVP() {
        return (this.mask & 0x4) != 0;
    }

    public boolean isTournament() {
        return (this.mask & 0x2000000) != 0;
    }

    public boolean isDeadman() {
        return (this.mask & 0x20000000) != 0;
    }
}
