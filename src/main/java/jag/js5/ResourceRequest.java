package jag.js5;

import jag.commons.collection.DoublyLinkedNode;
import jag.game.GameEngine;
import jag.game.relationship.AssociateComparator_Sub4;
import jag.opcode.Buffer;
import jag.worldmap.WorldMapIcon;

import java.io.IOException;

public class ResourceRequest extends DoublyLinkedNode {

    public byte aByte1220;
    public Archive aArchive1221;
    public int crc;

    public ResourceRequest() {

    }

    public static boolean processResources() {
        long time = GameEngine.currentTime();
        int change = (int) (time - NetWorker.lastAttempt);
        NetWorker.lastAttempt = time;
        if (change > 200) {
            change = 200;
        }

        NetWorker.latency += change;
        if (NetWorker.anInt1486 == 0 && NetWorker.anInt1496 == 0
                && NetWorker.anInt1491 == 0 && NetWorker.anInt1497 == 0) {
            return true;
        }

        if (NetWorker.connection == null) {
            return false;
        }

        try {
            if (NetWorker.latency > 30000) {
                throw new IOException();
            }
            ResourceRequest buffer;
            Buffer var5;
            while (NetWorker.anInt1496 < 200 && NetWorker.anInt1497 > 0) {
                buffer = NetWorker.prioritized.head();
                var5 = new Buffer(4);
                var5.writeByte(1);
                var5.writeMediumInt((int) buffer.key);
                NetWorker.connection.writeBytes(var5.payload, 0, 4);
                NetWorker.pendingPrioritized.put(buffer, buffer.key);
                --NetWorker.anInt1497;
                ++NetWorker.anInt1496;
            }

            while (NetWorker.anInt1486 < 200 && NetWorker.anInt1491 > 0) {
                buffer = (ResourceRequest) NetWorker.extras.method299();
                var5 = new Buffer(4);
                var5.writeByte(0);
                var5.writeMediumInt((int) buffer.key);
                NetWorker.connection.writeBytes(var5.payload, 0, 4);
                buffer.unlinkDoubly();
                NetWorker.pendingExtras.put(buffer, buffer.key);
                --NetWorker.anInt1491;
                ++NetWorker.anInt1486;
            }

            for (int input = 0; input < 100; ++input) {
                int available = NetWorker.connection.readable();
                if (available < 0) {
                    throw new IOException();
                }

                if (available == 0) {
                    break;
                }

                NetWorker.latency = 0;
                byte var8 = 0;
                if (NetWorker.current == null) {
                    var8 = 8;
                } else if (NetWorker.anInt1499 == 0) {
                    var8 = 1;
                }

                int var9;
                int var10;
                int var11;
                int var13;
                byte[] header;
                int var10001;
                Buffer var23;
                if (var8 > 0) {
                    var9 = var8 - NetWorker.header.caret;
                    if (var9 > available) {
                        var9 = available;
                    }

                    NetWorker.connection.readBytes(NetWorker.header.payload, NetWorker.header.caret, var9);
                    if (NetWorker.encryptionKey != 0) {
                        for (var10 = 0; var10 < var9; ++var10) {
                            header = NetWorker.header.payload;
                            var10001 = NetWorker.header.caret + var10;
                            header[var10001] ^= NetWorker.encryptionKey;
                        }
                    }

                    var23 = NetWorker.header;
                    var23.caret += var9;
                    if (NetWorker.header.caret < var8) {
                        break;
                    }

                    if (NetWorker.current == null) {
                        NetWorker.header.caret = 0;
                        var10 = NetWorker.header.readUByte();
                        var11 = NetWorker.header.readUShort();
                        int var12 = NetWorker.header.readUByte();
                        var13 = NetWorker.header.readInt();
                        long var14 = var11 + (var10 << 16);
                        ResourceRequest var16 = (ResourceRequest) NetWorker.pendingPrioritized.lookup(var14);
                        AssociateComparator_Sub4.aBoolean804 = true;
                        if (var16 == null) {
                            var16 = (ResourceRequest) NetWorker.pendingExtras.lookup(var14);
                            AssociateComparator_Sub4.aBoolean804 = false;
                        }

                        if (var16 == null) {
                            throw new IOException();
                        }

                        int var17 = var12 == 0 ? 5 : 9;
                        NetWorker.current = var16;
                        CacheRequestWorker.buffer = new Buffer(var13 + var17 + NetWorker.current.aByte1220);
                        CacheRequestWorker.buffer.writeByte(var12);
                        CacheRequestWorker.buffer.writeInt(var13);
                        NetWorker.anInt1499 = 8;
                        NetWorker.header.caret = 0;
                    } else if (NetWorker.anInt1499 == 0) {
                        if (NetWorker.header.payload[0] == -1) {
                            NetWorker.anInt1499 = 1;
                            NetWorker.header.caret = 0;
                        } else {
                            NetWorker.current = null;
                        }
                    }
                } else {
                    var9 = CacheRequestWorker.buffer.payload.length - NetWorker.current.aByte1220;
                    var10 = 512 - NetWorker.anInt1499;
                    if (var10 > var9 - CacheRequestWorker.buffer.caret) {
                        var10 = var9 - CacheRequestWorker.buffer.caret;
                    }

                    if (var10 > available) {
                        var10 = available;
                    }

                    NetWorker.connection.readBytes(CacheRequestWorker.buffer.payload, CacheRequestWorker.buffer.caret, var10);
                    if (NetWorker.encryptionKey != 0) {
                        for (var11 = 0; var11 < var10; ++var11) {
                            header = CacheRequestWorker.buffer.payload;
                            var10001 = var11 + CacheRequestWorker.buffer.caret;
                            header[var10001] ^= NetWorker.encryptionKey;
                        }
                    }

                    var23 = CacheRequestWorker.buffer;
                    var23.caret += var10;
                    NetWorker.anInt1499 += var10;
                    if (var9 == CacheRequestWorker.buffer.caret) {
                        if (16711935L == NetWorker.current.key) {
                            WorldMapIcon.aBuffer314 = CacheRequestWorker.buffer;

                            for (var11 = 0; var11 < 256; ++var11) {
                                Archive var18 = NetWorker.A_ARCHIVE_RESOURCE_PROVIDER_ARRAY_1498[var11];
                                if (var18 != null) {
                                    WorldMapIcon.aBuffer314.caret = var11 * 8 + 5;
                                    var13 = WorldMapIcon.aBuffer314.readInt();
                                    int var19 = WorldMapIcon.aBuffer314.readInt();
                                    var18.method493(var13, var19);
                                }
                            }
                        } else {
                            NetWorker.crc.reset();
                            NetWorker.crc.update(CacheRequestWorker.buffer.payload, 0, var9);
                            var11 = (int) NetWorker.crc.getValue();
                            if (var11 != NetWorker.current.crc) {
                                try {
                                    NetWorker.connection.stop();
                                } catch (Exception ignored) {

                                }

                                ++NetWorker.anInt1492;
                                NetWorker.connection = null;
                                NetWorker.encryptionKey = (byte) ((int) (Math.random() * 255.0D + 1.0D));
                                return false;
                            }

                            NetWorker.anInt1492 = 0;
                            NetWorker.anInt1488 = 0;
                            NetWorker.current.aArchive1221.method498((int) (NetWorker.current.key & 65535L), CacheRequestWorker.buffer.payload, (NetWorker.current.key & 16711680L) == 16711680L, AssociateComparator_Sub4.aBoolean804);
                        }

                        NetWorker.current.unlink();
                        if (AssociateComparator_Sub4.aBoolean804) {
                            --NetWorker.anInt1496;
                        } else {
                            --NetWorker.anInt1486;
                        }

                        NetWorker.anInt1499 = 0;
                        NetWorker.current = null;
                        CacheRequestWorker.buffer = null;
                    } else {
                        if (NetWorker.anInt1499 != 512) {
                            break;
                        }

                        NetWorker.anInt1499 = 0;
                    }
                }
            }

            return true;
        } catch (IOException var22) {
            try {
                NetWorker.connection.stop();
            } catch (Exception ignored) {
            }

            ++NetWorker.anInt1488;
            NetWorker.connection = null;
            return false;
        }
    }
}
