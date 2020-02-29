package com.jagex;

public class Class65 {
    public static final Class65 aClass65_531;
    public static final Class65 aClass65_532;
    public static final Class65 aClass65_530;
    static Class149 aClass149_525;
    static Node_Sub6_Sub1 aClass5_Sub6_Sub1_528;
    static CacheReferenceTable aCacheReferenceTable526;

    static {
        aClass65_531 = new Class65(1, 0, 4);
        aClass65_532 = new Class65(0, 1, 2);
        aClass65_530 = new Class65(2, 2, 0);
    }

    final int anInt524;
    final int anInt529;
    final int anInt527;

    Class65(int var1, int var2, int var3) {
        this.anInt529 = var1;
        this.anInt527 = var2;
        this.anInt524 = var3;
    }

    static Class65[] method364() {
        return new Class65[]{aClass65_530, aClass65_531, aClass65_532};
    }

    static void method365(int var0, String var1) {
        int var2 = GPI.playerCount;
        int[] var3 = GPI.playerIndices;
        boolean var4 = false;
        NamePair var5 = new NamePair(var1, Class36.aClass213_343);

        for (int var6 = 0; var6 < var2; ++var6) {
            PlayerEntity var7 = client.players[var3[var6]];
            if (var7 != null && var7 != PlayerEntity.local && var7.namePair != null && var7.namePair.equals(var5)) {
                OutgoingPacket packet;
                if (var0 == 1) {
                    packet = OutgoingPacket.prepare(OutgoingPacketMeta.PLAYER_ACTION_0, client.connectionContext.encryptor);
                    packet.buffer.writeShortA(var3[var6]);
                    packet.buffer.method1058(0);
                    client.connectionContext.writeLater(packet);
                } else if (var0 == 4) {
                    packet = OutgoingPacket.prepare(OutgoingPacketMeta.PLAYER_ACTION_3, client.connectionContext.encryptor);
                    packet.buffer.writeLEShortA(var3[var6]);
                    packet.buffer.writeNegatedByte(0);
                    client.connectionContext.writeLater(packet);
                } else if (var0 == 6) {
                    packet = OutgoingPacket.prepare(OutgoingPacketMeta.PLAYER_ACTION_5, client.connectionContext.encryptor);
                    packet.buffer.writeShort(var3[var6]);
                    packet.buffer.method1058(0);
                    client.connectionContext.writeLater(packet);
                } else if (var0 == 7) {
                    packet = OutgoingPacket.prepare(OutgoingPacketMeta.PLAYER_ACTION_6, client.connectionContext.encryptor);
                    packet.buffer.writeLEShort(var3[var6]);
                    packet.buffer.method1058(0);
                    client.connectionContext.writeLater(packet);
                }

                var4 = true;
                break;
            }
        }

        if (!var4) {
            Statics19.messageReceived(4, "", "Unable to find " + var1);
        }

    }

    static int method363(int var0, int var1, int var2) {
        int var3 = var0 / var2;
        int var4 = var0 & var2 - 1;
        int var5 = var1 / var2;
        int var6 = var1 & var2 - 1;
        int var7 = Class55.method324(var3, var5);
        int var8 = Class55.method324(var3 + 1, var5);
        int var9 = Class55.method324(var3, var5 + 1);
        int var10 = Class55.method324(var3 + 1, var5 + 1);
        int var11 = 65536 - JagGraphics3D.COS_TABLE[var4 * 1024 / var2] >> 1;
        int var12 = ((65536 - var11) * var7 >> 16) + (var11 * var8 >> 16);
        int var13 = 65536 - JagGraphics3D.COS_TABLE[var4 * 1024 / var2] >> 1;
        int var14 = ((65536 - var13) * var9 >> 16) + (var10 * var13 >> 16);
        int var15 = 65536 - JagGraphics3D.COS_TABLE[var6 * 1024 / var2] >> 1;
        return ((65536 - var15) * var12 >> 16) + (var14 * var15 >> 16);
    }

    public static int getAndIncrementMouseIdleTime() {
        return ++Mouse.idleTime - 1;
    }

    boolean method366(float var1) {
        return var1 >= (float) this.anInt524;
    }
}
