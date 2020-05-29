package jag.statics;

import jag.opcode.OldConnectionTaskProcessor;
import jag.game.client;
import jag.opcode.OutgoingPacket;
import jag.opcode.OutgoingPacketMeta;

public class Statics35 {

    public static final char[] aCharArray1616;
    public static byte[][][] aByteArrayArrayArray1615;

    static {
        aCharArray1616 = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};
    }

    public static double[] method1172(double var0, double var2, int var4) {
        int var5 = var4 * 2 + 1;
        double[] var6 = new double[var5];
        int var7 = -var4;

        for (int var8 = 0; var7 <= var4; ++var8) {
            var6[var8] = OldConnectionTaskProcessor.method700(var7, var0, var2);
            ++var7;
        }

        return var6;
    }

    public static void method1171(int var0, int var1, int var2, boolean var3) {
        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta78, client.connectionContext.encryptor);
        packet.buffer.writeByteS(var2);
        packet.buffer.writeLEInt(var3 ? client.anInt1002 : 0);
        packet.buffer.writeShort(var1);
        packet.buffer.writeLEShortA(var0);
        client.connectionContext.writeLater(packet);
    }
}
