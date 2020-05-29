package jag.opcode;

import jag.ClientParameter;
import jag.LoginScreenEffect;
import jag.commons.input.Keyboard;
import jag.commons.input.Mouse;
import jag.game.InterfaceComponent;
import jag.game.client;
import jag.game.scene.entity.PlayerEntity;
import jag.graphics.JagGraphics3D;
import jag.graphics.SpriteClip;
import jag.worldmap.WorldMapIcon_Sub1;

import java.io.IOException;
import java.io.OutputStream;

public class AsyncOutputStream implements Runnable {

    public static LoginScreenEffect loginScreenEffect;

    final OutputStream output;
    final Thread thread;
    final int anInt107;
    final byte[] buffer;
    boolean aBoolean109;
    IOException error;
    int anInt104;
    int anInt102;

    AsyncOutputStream(OutputStream var1, int var2) {
        this.anInt104 = 0;
        this.anInt102 = 0;
        this.output = var1;
        this.anInt107 = var2 + 1;
        this.buffer = new byte[this.anInt107];
        this.thread = new Thread(this);
        this.thread.setDaemon(true);
        this.thread.start();
    }

    public static int method15(ClientParameter var0) {
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

    public static void processMinimapClick(InterfaceComponent component, int x, int y) {
        if (client.mapState != 0 && client.mapState != 3) {
            return;
        }

        if (!client.menuOpen && (Mouse.clickMeta == 1 || !WorldMapIcon_Sub1.aBoolean492 && Mouse.clickMeta == 4)) {
            SpriteClip image = component.method959(true);
            if (image == null) {
                return;
            }

            int mapClickX = Mouse.clickX - x;
            int mapClickY = Mouse.clickY - y;
            if (image.contains(mapClickX, mapClickY)) {
                mapClickX -= image.anInt380 / 2;
                mapClickY -= image.anInt568 / 2;
                int rot = client.mapRotation & 2047;
                int sin = JagGraphics3D.SIN_TABLE[rot];
                int cos = JagGraphics3D.COS_TABLE[rot];
                int xInc = mapClickY * sin + mapClickX * cos >> 11;
                int yInc = mapClickY * cos - sin * mapClickX >> 11;
                int sceneX = xInc + PlayerEntity.local.fineX >> 7;
                int sceneY = PlayerEntity.local.fineY - yInc >> 7;
                OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.WALK_MAP, client.connectionContext.encryptor);
                packet.buffer.writeByte(18);
                packet.buffer.writeLEShortA(client.baseX + sceneX);
                packet.buffer.writeLEShort(client.baseY + sceneY);
                packet.buffer.writeNegatedByte(Keyboard.heldKeys[82] ? (Keyboard.heldKeys[81] ? 2 : 1) : 0);
                packet.buffer.writeByte(mapClickX);
                packet.buffer.writeByte(mapClickY);
                packet.buffer.writeShort(client.mapRotation);
                packet.buffer.writeByte(57);
                packet.buffer.writeByte(0);
                packet.buffer.writeByte(0);
                packet.buffer.writeByte(89);
                packet.buffer.writeShort(PlayerEntity.local.fineX);
                packet.buffer.writeShort(PlayerEntity.local.fineY);
                packet.buffer.writeByte(63);
                client.connectionContext.writeLater(packet);
                client.destinationX = sceneX;
                client.destinationY = sceneY;
            }
        }

    }

    void method16(byte[] var1, int var2, int var3) throws IOException {
        if (var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
            synchronized (this) {
                if (this.error != null) {
                    throw new IOException(this.error.toString());
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
                    System.arraycopy(var1, var2, this.buffer, this.anInt102, var3);
                } else {
                    int var6 = this.anInt107 - this.anInt102;
                    System.arraycopy(var1, var2, this.buffer, this.anInt102, var6);
                    System.arraycopy(var1, var6 + var2, this.buffer, 0, var3 - var6);
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
            this.thread.join();
        } catch (InterruptedException ignored) {
        }

    }

    boolean method14() {
        if (this.aBoolean109) {
            try {
                this.output.close();
                if (this.error == null) {
                    this.error = new IOException("");
                }
            } catch (IOException var2) {
                if (this.error == null) {
                    this.error = new IOException(var2);
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
                    if (this.error != null) {
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
                        this.output.flush();
                    } catch (IOException var11) {
                        this.error = var11;
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
                    this.output.write(this.buffer, this.anInt104, var2);
                } else {
                    int var5 = this.anInt107 - this.anInt104;
                    this.output.write(this.buffer, this.anInt104, var5);
                    this.output.write(this.buffer, 0, var2 - var5);
                }
            } catch (IOException var10) {
                synchronized (this) {
                    this.error = var10;
                    return;
                }
            }

            synchronized (this) {
                this.anInt104 = (var2 + this.anInt104) % this.anInt107;
            }
        } while (!this.method14());

    }
}
