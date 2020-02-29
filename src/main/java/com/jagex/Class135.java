package com.jagex;

public abstract class Class135 {
    static int anInt889;

    Class135() {
    }

    static void writeDialogActionPacket(int var0, int var1) {
        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.DIALOG_ACTION, client.connectionContext.encryptor);
        packet.buffer.writeLEInt(var0);
        packet.buffer.writeShort(var1);
        client.connectionContext.writeLater(packet);
    }

    static int method722() {
        return Statics2.anInt656;
    }

    static int method723(int var0) {
        Chatline var1 = (Chatline) Class64.A_ITERABLE_NODE_TABLE_523.lookup((long) var0);
        if (var1 == null) {
            return -1;
        }
        return var1.previousDoubly == Class64.A_ITERABLE_DOUBLY_LINKED_NODE___522.aDoublyLinkedNode1534 ? -1 : ((Chatline) var1.previousDoubly).anInt380;
    }

    public static Class135 method1200() {
        try {
            return new Class135_Sub2();
        } catch (Throwable var1) {
            return new Class135_Sub1();
        }
    }

    public abstract int method678(int var1, int var2);

    public abstract void method677();
}
