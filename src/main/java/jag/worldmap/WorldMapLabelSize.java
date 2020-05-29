package jag.worldmap;

import jag.ClientLocale;
import jag.Login;
import jag.audi.PcmStream_Sub1;
import jag.commons.input.Mouse;
import jag.game.client;
import jag.game.relationship.NamePair;
import jag.game.scene.entity.PlayerEntity;
import jag.graphics.JagGraphics3D;
import jag.js5.Archive;
import jag.opcode.GPI;
import jag.opcode.OutgoingPacket;
import jag.opcode.OutgoingPacketMeta;
import jag.statics.Statics19;

public class WorldMapLabelSize {
    public static final WorldMapLabelSize SMALL;
    public static final WorldMapLabelSize MEDIUM;
    public static final WorldMapLabelSize LARGE;
    public static ClientLocale aClientLocale_525;
    public static PcmStream_Sub1 aClass5_Sub6_Sub1_528;
    public static Archive aArchive526;

    static {
        SMALL = new WorldMapLabelSize(1, 0, 4);
        MEDIUM = new WorldMapLabelSize(0, 1, 2);
        LARGE = new WorldMapLabelSize(2, 2, 0);
    }

    public final int anInt527;
    final int anInt524;
    final int anInt529;

    WorldMapLabelSize(int var1, int var2, int var3) {
        this.anInt529 = var1;
        this.anInt527 = var2;
        this.anInt524 = var3;
    }

    public static WorldMapLabelSize[] method364() {
        return new WorldMapLabelSize[]{LARGE, SMALL, MEDIUM};
    }

    public static void method365(int var0, String var1) {
        int var2 = GPI.playerCount;
        int[] var3 = GPI.playerIndices;
        boolean var4 = false;
        NamePair var5 = new NamePair(var1, PreciseWorldMapAreaChunk.aClientParameter_343);

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

    public static int method363(int var0, int var1, int var2) {
        int var3 = var0 / var2;
        int var4 = var0 & var2 - 1;
        int var5 = var1 / var2;
        int var6 = var1 & var2 - 1;
        int var7 = Login.method324(var3, var5);
        int var8 = Login.method324(var3 + 1, var5);
        int var9 = Login.method324(var3, var5 + 1);
        int var10 = Login.method324(var3 + 1, var5 + 1);
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

    public boolean method366(float var1) {
        return var1 >= (float) this.anInt524;
    }
}
