package jag.commons.time;

import jag.game.client;
import jag.game.relationship.ChatLine;
import jag.opcode.OutgoingPacket;
import jag.opcode.OutgoingPacketMeta;
import jag.statics.Statics2;
import jag.statics.Statics53;

public abstract class Clock {

    public static int anInt889;

    public Clock() {
    }

    public static void processDialogActionPacket(int var0, int var1) {
        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.DIALOG_ACTION, client.connectionContext.encryptor);
        packet.buffer.writeLEInt(var0);
        packet.buffer.writeShort(var1);
        client.connectionContext.writeLater(packet);
    }

    public static int method722() {
        return Statics2.anInt656;
    }

    public static int method723(int var0) {
        ChatLine var1 = (ChatLine) Statics53.A_ITERABLE_NODE_TABLE_523.lookup(var0);
        if (var1 == null) {
            return -1;
        }
        return var1.previousDoubly == Statics53.A_ITERABLE_DOUBLY_LINKED_NODE___522.aDoublyLinkedNode1534 ? -1 : ((ChatLine) var1.previousDoubly).index;
    }

    public static Clock create() {
        try {
            return new NanoClock();
        } catch (Throwable var1) {
            return new MillisClock();
        }
    }

    public abstract int sleep(int var1, int var2);

    public abstract void update();
}
