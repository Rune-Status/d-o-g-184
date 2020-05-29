package jag.js5;

import jag.commons.collection.NodeTable;
import jag.commons.collection.Queue;
import jag.game.client;
import jag.opcode.Buffer;
import jag.opcode.Connection;
import jag.opcode.OutgoingPacket;
import jag.opcode.OutgoingPacketMeta;

import java.util.zip.CRC32;

public class NetWorker {

    public static final NodeTable aNodeTable1503;
    public static final NodeTable<ResourceRequest> prioritized;
    public static final Queue extras;
    public static final NodeTable pendingPrioritized;
    public static final NodeTable pendingExtras;
    public static final Archive[] A_ARCHIVE_RESOURCE_PROVIDER_ARRAY_1498;
    public static final Buffer header;
    public static final CRC32 crc;
    public static int anInt1492;
    public static int anInt1488;
    public static int latency;
    public static long lastAttempt;
    public static int anInt1497;
    public static int anInt1496;
    public static int anInt1486;
    public static Connection connection;
    public static int anInt1491;
    public static int anInt1499;
    public static byte encryptionKey;
    public static ResourceRequest current;

    static {
        latency = 0;
        prioritized = new NodeTable<>(4096);
        anInt1497 = 0;
        pendingPrioritized = new NodeTable(32);
        anInt1496 = 0;
        extras = new Queue();
        aNodeTable1503 = new NodeTable(4096);
        anInt1491 = 0;
        pendingExtras = new NodeTable(4096);
        anInt1486 = 0;
        header = new Buffer(8);
        anInt1499 = 0;
        crc = new CRC32();
        A_ARCHIVE_RESOURCE_PROVIDER_ARRAY_1498 = new Archive[256];
        encryptionKey = 0;
        anInt1492 = 0;
        anInt1488 = 0;
    }

    public static boolean method1094(int var0, int var1) {
        return var0 != 4 || var1 < 8;
    }

    public static void method1092(int var0) {
        client.anInt988 = var0;
    }

    public static void method1093(String var0) {
        if (client.clanSystem != null) {
            OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.WRITE_SOME_STRING_3617, client.connectionContext.encryptor);
            packet.buffer.writeByte(Buffer.stringLengthPlusOne(var0));
            packet.buffer.writeCString(var0);
            client.connectionContext.writeLater(packet);
        }
    }
}
