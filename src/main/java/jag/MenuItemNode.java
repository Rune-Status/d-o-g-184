package jag;

import jag.game.GameEngine;
import jag.js5.CacheRequestWorker;
import jag.js5.ResourceRequest;
import jag.opcode.Buffer;
import jag.opcode.Connection;
import jag.statics.Statics2;
import jag.js5.NetWorker;

import java.io.IOException;

public class MenuItemNode {

    public static int anInt603;

    public int secondary;
    public int tertiary;
    public int opcode;
    public int primary;
    public String action;

    public MenuItemNode() {
    }

    public static void method420(Connection var0, boolean var1) {
        if (NetWorker.connection != null) {
            try {
                NetWorker.connection.stop();
            } catch (Exception ignored) {
            }

            NetWorker.connection = null;
        }

        NetWorker.connection = var0;
        DirectByteBufferProvider.method803(var1);
        NetWorker.header.caret = 0;
        NetWorker.current = null;
        CacheRequestWorker.buffer = null;
        NetWorker.anInt1499 = 0;

        while (true) {
            ResourceRequest var2 = (ResourceRequest) NetWorker.pendingPrioritized.head();
            if (var2 == null) {
                while (true) {
                    var2 = (ResourceRequest) NetWorker.pendingExtras.head();
                    if (var2 == null) {
                        if (NetWorker.encryptionKey != 0) {
                            try {
                                Buffer var7 = new Buffer(4);
                                var7.writeByte(4);
                                var7.writeByte(NetWorker.encryptionKey);
                                var7.writeShort(0);
                                NetWorker.connection.writeBytes(var7.payload, 0, 4);
                            } catch (IOException var5) {
                                try {
                                    NetWorker.connection.stop();
                                } catch (Exception ignored) {
                                }

                                ++NetWorker.anInt1488;
                                NetWorker.connection = null;
                            }
                        }

                        NetWorker.latency = 0;
                        NetWorker.lastAttempt = GameEngine.currentTime();
                        return;
                    }

                    NetWorker.extras.method301(var2);
                    NetWorker.aNodeTable1503.put(var2, var2.key);
                    ++NetWorker.anInt1491;
                    --NetWorker.anInt1486;
                }
            }

            NetWorker.prioritized.put(var2, var2.key);
            ++NetWorker.anInt1497;
            --NetWorker.anInt1496;
        }
    }

    public static void method419() {
        Statics2.aBoolean663 = false;
        Statics2.onCursorCount = 0;
    }
}
