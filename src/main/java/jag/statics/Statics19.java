package jag.statics;

import jag.Huffman;
import jag.game.client;
import jag.game.relationship.ChatHistory;
import jag.opcode.OutgoingPacket;
import jag.opcode.OutgoingPacketMeta;

public class Statics19 {
    public static Huffman huffman;

    public static void messageReceived(int var0, String var1, String var2) {
        ChatHistory.messageReceived(var0, var1, var2, null);
    }

    public static void method919() {
        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.GAME_BOUNDS, client.connectionContext.encryptor);
        packet.buffer.writeByte(client.isResizable());
        packet.buffer.writeShort(client.canvasWidth);
        packet.buffer.writeShort(client.canvasHeight);
        client.connectionContext.writeLater(packet);
    }
}
