package com.jagex;

import java.io.IOException;
import java.io.OutputStream;

public class AsyncOutputStream implements Runnable {
    static Class45 aClass45_105;
    boolean aBoolean109;
    IOException anIOException103;
    int anInt104;
    OutputStream anOutputStream110;
    Thread aThread108;
    int anInt102;
    int anInt107;
    byte[] aByteArray106;

    AsyncOutputStream(OutputStream var1, int var2) {
        this.anInt104 = 0;
        this.anInt102 = 0;
        this.anOutputStream110 = var1;
        this.anInt107 = var2 + 1;
        this.aByteArray106 = new byte[this.anInt107];
        this.aThread108 = new Thread(this);
        this.aThread108.setDaemon(true);
        this.aThread108.start();
    }

    static int method15(Class213 var0) {
        if (var0 == null) {
            return 12;
        }
        switch (var0.anInt1800) {
            case 0:
                return 20;
            default:
                return 12;
        }
    }

    static void method13(InterfaceComponent component, int x, int y) {
        if (client.mapState == 0 || client.mapState == 3) {
            if (!client.menuOpen && (Mouse.clickMeta == 1 || !Class27_Sub1.aBoolean492 && Mouse.clickMeta == 4)) {
                DoublyLinkedNode_Sub10 var3 = component.method959(true);
                if (var3 == null) {
                    return;
                }

                int mapX = Mouse.clickX - x;
                int mapY = Mouse.clickY - y;
                if (var3.method983(mapX, mapY)) {
                    mapX -= var3.anInt380 / 2;
                    mapY -= var3.anInt568 / 2;
                    int var6 = client.mapRotation & 2047;
                    int var7 = JagGraphics3D.SIN_TABLE[var6];
                    int var8 = JagGraphics3D.COS_TABLE[var6];
                    int var9 = mapY * var7 + mapX * var8 >> 11;
                    int var10 = mapY * var8 - var7 * mapX >> 11;
                    int var11 = var9 + PlayerEntity.local.fineX >> 7;
                    int var12 = PlayerEntity.local.fineY - var10 >> 7;
                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta66, client.connectionContext.encryptor);
                    packet.buffer.writeByte(18);
                    packet.buffer.writeLEShortA(Statics18.baseX + var11);
                    packet.buffer.writeLEShort(Statics36.baseY + var12);
                    packet.buffer.writeNegatedByte(Keyboard.heldKeys[82] ? (Keyboard.heldKeys[81] ? 2 : 1) : 0);
                    packet.buffer.writeByte(mapX);
                    packet.buffer.writeByte(mapY);
                    packet.buffer.writeShort(client.mapRotation);
                    packet.buffer.writeByte(57);
                    packet.buffer.writeByte(0);
                    packet.buffer.writeByte(0);
                    packet.buffer.writeByte(89);
                    packet.buffer.writeShort(PlayerEntity.local.fineX);
                    packet.buffer.writeShort(PlayerEntity.local.fineY);
                    packet.buffer.writeByte(63);
                    client.connectionContext.writeLater(packet);
                    client.destinationX = var11;
                    client.destinationY = var12;
                }
            }

        }
    }

    void method16(byte[] var1, int var2, int var3) throws IOException {
        if (var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
            synchronized (this) {
                if (this.anIOException103 != null) {
                    throw new IOException(this.anIOException103.toString());
                }
                int var5;
                if (this.anInt104 <= this.anInt102) {
                    var5 = this.anInt107 - this.anInt102 + this.anInt104 - 1;
                } else {
                    var5 = this.anInt104 - this.anInt102 - 1;
                }

                if (var5 < var3) {
                    throw new IOException("");
                }
                if (var3 + this.anInt102 <= this.anInt107) {
                    System.arraycopy(var1, var2, this.aByteArray106, this.anInt102, var3);
                } else {
                    int var6 = this.anInt107 - this.anInt102;
                    System.arraycopy(var1, var2, this.aByteArray106, this.anInt102, var6);
                    System.arraycopy(var1, var6 + var2, this.aByteArray106, 0, var3 - var6);
                }

                this.anInt102 = (var3 + this.anInt102) % this.anInt107;
                this.notifyAll();
            }
        } else {
            throw new IOException();
        }
    }

    void method12() {
        synchronized (this) {
            this.aBoolean109 = true;
            this.notifyAll();
        }

        try {
            this.aThread108.join();
        } catch (InterruptedException ignored) {
        }

    }

    boolean method14() {
        if (this.aBoolean109) {
            try {
                this.anOutputStream110.close();
                if (this.anIOException103 == null) {
                    this.anIOException103 = new IOException("");
                }
            } catch (IOException var2) {
                if (this.anIOException103 == null) {
                    this.anIOException103 = new IOException(var2);
                }
            }

            return true;
        }
        return false;
    }

    public void run() {
        do {
            int var2;
            synchronized (this) {
                while (true) {
                    if (this.anIOException103 != null) {
                        return;
                    }

                    if (this.anInt104 <= this.anInt102) {
                        var2 = this.anInt102 - this.anInt104;
                    } else {
                        var2 = this.anInt107 - this.anInt104 + this.anInt102;
                    }

                    if (var2 > 0) {
                        break;
                    }

                    try {
                        this.anOutputStream110.flush();
                    } catch (IOException var11) {
                        this.anIOException103 = var11;
                        return;
                    }

                    if (this.method14()) {
                        return;
                    }

                    try {
                        this.wait();
                    } catch (InterruptedException ignored) {
                    }
                }
            }

            try {
                if (var2 + this.anInt104 <= this.anInt107) {
                    this.anOutputStream110.write(this.aByteArray106, this.anInt104, var2);
                } else {
                    int var5 = this.anInt107 - this.anInt104;
                    this.anOutputStream110.write(this.aByteArray106, this.anInt104, var5);
                    this.anOutputStream110.write(this.aByteArray106, 0, var2 - var5);
                }
            } catch (IOException var10) {
                synchronized (this) {
                    this.anIOException103 = var10;
                    return;
                }
            }

            synchronized (this) {
                this.anInt104 = (var2 + this.anInt104) % this.anInt107;
            }
        } while (!this.method14());

    }
}
