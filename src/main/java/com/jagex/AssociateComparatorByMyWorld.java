package com.jagex;

import java.io.File;
import java.io.RandomAccessFile;

public class AssociateComparatorByMyWorld extends AssociateComparator {
    final boolean aBoolean764;

    public AssociateComparatorByMyWorld(boolean var1) {
        this.aBoolean764 = var1;
    }

    static void method603(int var0) {
        client.aLong1081 = 0L;
        client.aBoolean1090 = var0 >= 2;

        if (client.isResizable() == 1) {
            client.instance.method947(765, 503);
        } else {
            client.instance.method947(7680, 2160);
        }

        if (client.gameState >= 25) {
            OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.GAME_BOUNDS, client.connectionContext.encryptor);
            packet.buffer.writeByte(client.isResizable());
            packet.buffer.writeShort(client.canvasWidth);
            packet.buffer.writeShort(client.canvasHeight);
            client.connectionContext.writeLater(packet);
        }

    }

    public static File method605(String var0) {
        if (!Statics4.aBoolean830) {
            throw new RuntimeException("");
        }
        File var1 = (File) Statics4.aHashtable829.get(var0);
        if (var1 != null) {
            return var1;
        }
        File var2 = new File(Statics4.aFile831, var0);
        RandomAccessFile var3 = null;

        try {
            File var4 = new File(var2.getParent());
            if (!var4.exists()) {
                throw new RuntimeException("");
            }
            var3 = new RandomAccessFile(var2, "rw");
            int var5 = var3.read();
            var3.seek(0L);
            var3.write(var5);
            var3.seek(0L);
            var3.close();
            Statics4.aHashtable829.put(var0, var2);
            return var2;
        } catch (Exception var8) {
            try {
                if (var3 != null) {
                    var3.close();
                    var3 = null;
                }
            } catch (Exception ignored) {
            }

            throw new RuntimeException();
        }
    }

    int method604(Associate var1, Associate var2) {
        if (client.currentWorld == var1.world) {
            if (var2.world != client.currentWorld) {
                return this.aBoolean764 ? -1 : 1;
            }
        } else if (var2.world == client.currentWorld) {
            return this.aBoolean764 ? 1 : -1;
        }

        return this.method1135(var1, var2);
    }

    public int compare(Associate var1, Associate var2) {
        return this.method604(var1, var2);
    }
}
