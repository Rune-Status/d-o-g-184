package com.jagex;

import java.io.IOException;

public class GrandExchangeOffer {
    static InterfaceComponent[] anInterfaceComponentArray337;
    public int itemPrice;
    public int itemQuantity;
    public int itemId;
    public int transferred;
    public int spent;
    byte state;

    public GrandExchangeOffer() {
    }

    public GrandExchangeOffer(Buffer var1) {
        this.state = var1.readByte();
        this.itemId = var1.readUShort();
        this.itemPrice = var1.readInt();
        this.itemQuantity = var1.readInt();
        this.transferred = var1.readInt();
        this.spent = var1.readInt();
    }

    static void method231(boolean var0) {
        Class26.method190();
        ++client.connectionContext.idleWriteTicks;
        if (client.connectionContext.idleWriteTicks >= 50 || var0) {
            client.connectionContext.idleWriteTicks = 0;
            if (!client.pendingDisconnect && client.connectionContext.unwrap() != null) {
                OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta62, client.connectionContext.encryptor);
                client.connectionContext.writeLater(packet);

                try {
                    client.connectionContext.flush();
                } catch (IOException var3) {
                    client.pendingDisconnect = true;
                }
            }

        }
    }

    void method228() {
        this.state &= -8;
        this.state = (byte) (this.state | 2 & 7);
    }

    void method227(int var1) {
        this.state &= -9;
        if (var1 == 1) {
            this.state = (byte) (this.state | 8);
        }

    }

    public int method229() {
        return (this.state & 8) == 8 ? 1 : 0;
    }

    public int method230() {
        return this.state & 7;
    }
}
