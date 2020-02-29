package com.jagex;

import java.util.zip.CRC32;

public class Statics25 {
    public static int anInt1492;
    public static int anInt1488;
    static int anInt1494;
    static NodeTable aNodeTable1503;
    static long aLong1501;
    static NodeTable aNodeTable1500;
    static Queue aQueue1493;
    static int anInt1497;
    static NodeTable aNodeTable1495;
    static int anInt1496;
    static int anInt1486;
    static Connection connection;
    static int anInt1491;
    static NodeTable aNodeTable1487;
    static CacheReferenceTable[] aCacheReferenceTableArray1498;
    static Buffer aBuffer1489;
    static int anInt1499;
    static CRC32 aCRC32_1502;
    static byte aByte1490;

    static {
        anInt1494 = 0;
        aNodeTable1500 = new NodeTable(4096);
        anInt1497 = 0;
        aNodeTable1495 = new NodeTable(32);
        anInt1496 = 0;
        aQueue1493 = new Queue();
        aNodeTable1503 = new NodeTable(4096);
        anInt1491 = 0;
        aNodeTable1487 = new NodeTable(4096);
        anInt1486 = 0;
        aBuffer1489 = new Buffer(8);
        anInt1499 = 0;
        aCRC32_1502 = new CRC32();
        aCacheReferenceTableArray1498 = new CacheReferenceTable[256];
        aByte1490 = 0;
        anInt1492 = 0;
        anInt1488 = 0;
    }

    static boolean method1094(int var0, int var1) {
        return var0 != 4 || var1 < 8;
    }

    static void method1092(int var0) {
        client.anInt988 = var0;
    }

    static void method1093(String var0) {
        if (Varps.clanSystem != null) {
            OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta73, client.connectionContext.encryptor);
            packet.buffer.writeByte(Statics30.stringLengthPlusOne(var0));
            packet.buffer.writeCString(var0);
            client.connectionContext.writeLater(packet);
        }
    }
}
