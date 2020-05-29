package jag.game;

import jag.game.scene.SceneGraph;
import jag.game.scene.entity.PathingEntity;
import jag.opcode.Buffer;
import jag.opcode.OutgoingPacket;
import jag.opcode.OutgoingPacketMeta;
import jag.statics.Statics33;
import jag.worldmap.WorldMapTileDecor_Sub2;

public class World {
    public static int anInt1871;
    public static int anInt1872;
    public static int[] anIntArray1870;
    public static int[] anIntArray1874;
    public static World[] worlds;
    public static int anInt1869;

    static {
        anInt1871 = 0;
        anInt1872 = 0;
        anIntArray1870 = new int[]{1, 1, 1, 1};
        anIntArray1874 = new int[]{0, 1, 2, 3};
    }

    public int mask;
    public String domain;
    public int anInt1875;
    public String activity;
    public int location;
    public int population;
    public int anInt1873;

    public World() {
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

            StringBuilder var5 = new StringBuilder(var2);
            while (var0 != 0L) {
                long var6 = var0;
                var0 /= 37L;
                char var8 = Statics33.aCharArray1570[(int) (var6 - var0 * 37L)];
                if (var8 == '_') {
                    int var9 = var5.length() - 1;
                    var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                    var8 = 160;
                }
                var5.append(var8);
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
        }
        return null;
    }

    public static String getColorTags(int color) {
        return "<col=" + Integer.toHexString(color) + ">";
    }

    public static int method1351(int var0, int var1) {
        int var2 = var0 >>> 31;
        return (var0 + var2) / var1 - var2;
    }

    public static void method1343(String var0) {
        if (!var0.equals("")) {
            OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.WRITE_SOME_STRING_NONEMPTY_3619, client.connectionContext.encryptor);
            packet.buffer.writeByte(Buffer.stringLengthPlusOne(var0));
            packet.buffer.writeCString(var0);
            client.connectionContext.writeLater(packet);
        }
    }

    public static void method1354(PathingEntity var0, int var1) {
        SceneGraph.absoluteToViewport(var0.fineX, var0.fineY, var1);
    }

    public static void method852(int var0, int var1) {
        int[] var2 = new int[4];
        int[] var3 = new int[4];
        var2[0] = var0;
        var3[0] = var1;
        int var4 = 1;

        for (int var5 = 0; var5 < 4; ++var5) {
            if (anIntArray1874[var5] != var0) {
                var2[var4] = anIntArray1874[var5];
                var3[var4] = anIntArray1870[var5];
                ++var4;
            }
        }

        anIntArray1874 = var2;
        anIntArray1870 = var3;
        WorldMapTileDecor_Sub2.method471(worlds, 0, worlds.length - 1, anIntArray1874, anIntArray1870);
    }

    public static String method149(int var0) {
        String var1 = Integer.toString(var0);

        for (int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
            var1 = var1.substring(0, var2) + "," + var1.substring(var2);
        }

        if (var1.length() > 9) {
            return " " + getColorTags(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>";
        }
        return var1.length() > 6 ? " " + getColorTags(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>" : " " + getColorTags(16776960) + var1 + "</col>";
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
