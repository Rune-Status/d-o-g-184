package com.jagex;

public class Statics19 {
    public static Class166 aClass166_1261;

    static void messageReceived(int var0, String var1, String var2) {
        Class63_Sub1.messageReceived(var0, var1, var2, null);
    }

    static void method919() {
        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.GAME_BOUNDS, client.connectionContext.encryptor);
        packet.buffer.writeByte(client.isResizable());
        packet.buffer.writeShort(client.canvasWidth);
        packet.buffer.writeShort(client.canvasHeight);
        client.connectionContext.writeLater(packet);
    }
}
