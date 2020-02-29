package com.jagex;

public class World {
    static int anInt1871;
    static int anInt1872;
    static int[] anIntArray1870;
    static int[] anIntArray1874;
    static World[] worlds;
    static int anInt1869;

    static {
        anInt1871 = 0;
        anInt1872 = 0;
        anIntArray1870 = new int[]{1, 1, 1, 1};
        anIntArray1874 = new int[]{0, 1, 2, 3};
    }

    int mask;
    String domain;
    int anInt1875;
    String activity;
    int location;
    int population;
    int anInt1873;

    World() {
    }

    public static String method1353(long var0) {
        if (var0 > 0L && var0 < 6582952005840035281L) {
            if (0L == var0 % 37L) {
                return null;
            }
            int var2 = 0;

            for (long var3 = var0; 0L != var3; var3 /= 37L) {
                ++var2;
            }

            StringBuilder var5;
            char var8;
            for (var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
                long var6 = var0;
                var0 /= 37L;
                var8 = Statics33.aCharArray1570[(int) (var6 - var0 * 37L)];
                if (var8 == '_') {
                    int var9 = var5.length() - 1;
                    var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                    var8 = 160;
                }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
        }
        return null;
    }

    static String getColorTags(int color) {
        return "<col=" + Integer.toHexString(color) + ">";
    }

    public static int method1351(int var0, int var1) {
        int var2 = var0 >>> 31;
        return (var0 + var2) / var1 - var2;
    }

    static void method1343(String var0) {
        if (!var0.equals("")) {
            OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta34, client.connectionContext.encryptor);
            packet.buffer.writeByte(Statics30.stringLengthPlusOne(var0));
            packet.buffer.writeCString(var0);
            client.connectionContext.writeLater(packet);
        }
    }

    static void method1354(PathingEntity var0, int var1) {
        SceneGraph.absoluteToViewport(var0.fineX, var0.fineY, var1);
    }

    boolean isMembers() {
        return (this.mask & 0x1) != 0;
    }

    boolean method1350() {
        return (this.mask & 0x8) != 0;
    }

    boolean method1346() {
        return (this.mask & 0x2) != 0;
    }

    boolean isPVP() {
        return (this.mask & 0x4) != 0;
    }

    boolean isTournament() {
        return (this.mask & 0x2000000) != 0;
    }

    boolean isDeadman() {
        return (this.mask & 0x20000000) != 0;
    }
}
