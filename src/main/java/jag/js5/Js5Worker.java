package jag.js5;

import jag.commons.collection.NodeTable;
import jag.commons.collection.Queue;
import jag.game.client;
import jag.opcode.Buffer;
import jag.opcode.Connection;
import jag.opcode.OutgoingPacket;
import jag.opcode.OutgoingPacketMeta;

import java.io.IOException;
import java.util.zip.CRC32;

public class Js5Worker {

    public static final NodeTable<ResourceRequest> pending;
    public static final NodeTable<ResourceRequest> pendingPriority;
    public static final Queue<ResourceRequest> pendingQueue;
    public static final NodeTable<ResourceRequest> pendingPriorityRecv;
    public static final NodeTable<ResourceRequest> pendingRecv;
    public static final Archive[] ARCHIVES;
    public static final Buffer responseHeader;
    public static final CRC32 crc;
    public static int mismatchedCrcCount;
    public static int ioExceptionCount;
    public static int latency;
    public static long lastAttempt;
    public static int pendingPriorityCount;
    public static int pendingPriorityResponseCount;
    public static int pendingResponseCount;
    public static Connection connection;
    public static int pendingCount;
    public static int anInt1499;
    public static byte encryptionKey;
    public static ResourceRequest current;
    public static Buffer archiveBuffer;

    static {
        latency = 0;
        pendingPriority = new NodeTable<>(4096);
        pendingPriorityCount = 0;
        pendingPriorityRecv = new NodeTable<>(32);
        pendingPriorityResponseCount = 0;
        pendingQueue = new Queue<>();
        pending = new NodeTable<>(4096);
        pendingCount = 0;
        pendingRecv = new NodeTable<>(4096);
        pendingResponseCount = 0;
        responseHeader = new Buffer(8);
        anInt1499 = 0;
        crc = new CRC32();
        ARCHIVES = new Archive[256];
        encryptionKey = 0;
        mismatchedCrcCount = 0;
        ioExceptionCount = 0;
    }

    public static boolean method1094(int var0, int var1) {
        return var0 != 4 || var1 < 8;
    }

    public static void setOculusOrbState(int var0) {
        client.oculusOrbState = var0;
    }

    public static void method1093(String var0) {
        if (client.clanSystem != null) {
            OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.KICK_CLANCHANNEL_USER, client.netWriter.encryptor);
            packet.buffer.p1(Buffer.stringLengthPlusOne(var0));
            packet.buffer.pcstr(var0);
            client.netWriter.writeLater(packet);
        }
    }

    public static void request(Archive archive, int var1, int var2, int crc, byte padding, boolean var5) {
        long var6 = (var1 << 16) + var2;
        ResourceRequest req = pendingPriority.lookup(var6);
        if (req == null) {
            req = pendingPriorityRecv.lookup(var6);
            if (req == null) {
                req = pending.lookup(var6);
                if (req != null) {
                    if (var5) {
                        req.unlinkDoubly();
                        pendingPriority.put(req, var6);
                        --pendingCount;
                        ++pendingPriorityCount;
                    }

                } else {
                    if (!var5) {
                        req = pendingRecv.lookup(var6);
                        if (req != null) {
                            return;
                        }
                    }

                    req = new ResourceRequest();
                    req.archive = archive;
                    req.crc = crc;
                    req.padding = padding;
                    if (var5) {
                        pendingPriority.put(req, var6);
                        ++pendingPriorityCount;
                    } else {
                        pendingQueue.insert(req);
                        pending.put(req, var6);
                        ++pendingCount;
                    }

                }
            }
        }
    }

    public static void kill(boolean var0) {
        if (connection != null) {
            try {
                Buffer var1 = new Buffer(4);
                var1.p1(var0 ? 2 : 3);
                var1.p3(0);
                connection.write(var1.payload, 0, 4);
            } catch (IOException var4) {
                try {
                    connection.stop();
                } catch (Exception ignored) {
                }

                ++ioExceptionCount;
                connection = null;
            }

        }
    }
}
