package jag.game.relationship;

import jag.game.client;
import jag.opcode.OutgoingPacket;
import jag.opcode.OutgoingPacketMeta;
import jag.statics.Statics4;

import java.io.File;
import java.io.RandomAccessFile;

public class AssociateComparatorByMyWorld extends AssociateComparator {

    public final boolean aBoolean764;

    public AssociateComparatorByMyWorld(boolean var1) {
        this.aBoolean764 = var1;
    }

    public static void method603(int var0) {
        client.aLong1081 = 0L;
        client.resizableMode = var0 >= 2;

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
