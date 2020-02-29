package com.jagex;

public class OutgoingPacket extends Node {
    public static byte[][] aByteArrayArray114;
    static OutgoingPacket[] anOutgoingPacketArray113;
    static int anInt112;

    static {
        anOutgoingPacketArray113 = new OutgoingPacket[300];
        anInt112 = 0;
    }

    public PacketBuffer buffer;
    public int size;
    OutgoingPacketMeta meta;
    int payloadSize;

    OutgoingPacket() {
    }

    public static NpcDefinition getNpcDefinition(int id) {
        NpcDefinition var2 = (NpcDefinition) NpcDefinition.cache.get((long) id);
        if (var2 != null) {
            return var2;
        }
        byte[] var3 = NpcDefinition.table.unpack(9, id);
        var2 = new NpcDefinition();
        var2.id = id;
        if (var3 != null) {
            var2.decode(new Buffer(var3));
        }

        var2.method254();
        NpcDefinition.cache.put(var2, (long) id);
        return var2;
    }

    public static OutgoingPacket prepare(OutgoingPacketMeta meta, IsaacCipher cipher) {
        OutgoingPacket packet;
        if (anInt112 == 0) {
            packet = new OutgoingPacket();
        } else {
            packet = anOutgoingPacketArray113[--anInt112];
        }

        packet.meta = meta;
        packet.payloadSize = meta.size;
        if (packet.payloadSize == -1) {
            packet.buffer = new PacketBuffer(260);
        } else if (packet.payloadSize == -2) {
            packet.buffer = new PacketBuffer(10000);
        } else if (packet.payloadSize <= 18) {
            packet.buffer = new PacketBuffer(20);
        } else if (packet.payloadSize <= 98) {
            packet.buffer = new PacketBuffer(100);
        } else {
            packet.buffer = new PacketBuffer(260);
        }

        packet.buffer.setCipher(cipher);
        packet.buffer.writeHeader(packet.meta.opcode);
        packet.size = 0;
        return packet;
    }

    public static OutgoingPacket prepareLoginPacket() {
        OutgoingPacket packet;
        if (anInt112 == 0) {
            packet = new OutgoingPacket();
        } else {
            packet = anOutgoingPacketArray113[--anInt112];
        }

        packet.meta = null;
        packet.payloadSize = 0;
        packet.buffer = new PacketBuffer(5000);
        return packet;
    }

    public void cache() {
        if (anInt112 < anOutgoingPacketArray113.length) {
            anOutgoingPacketArray113[++anInt112 - 1] = this;
        }
    }
}
