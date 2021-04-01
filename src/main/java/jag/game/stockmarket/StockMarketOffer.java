package jag.game.stockmarket;

import jag.audi.AudioSystem;
import jag.game.InterfaceComponent;
import jag.game.client;
import jag.opcode.Buffer;
import jag.opcode.OutgoingPacket;
import jag.opcode.OutgoingPacketMeta;

import java.io.IOException;

public class StockMarketOffer {

    public static InterfaceComponent[] draggingInterface;

    public int itemPrice;
    public int itemQuantity;
    public int itemId;
    public int transferred;
    public int spent;
    public byte state;

    public StockMarketOffer() {
    }

    public StockMarketOffer(Buffer var1) {
        this.state = var1.g1b();
        this.itemId = var1.g2();
        this.itemPrice = var1.g4();
        this.itemQuantity = var1.g4();
        this.transferred = var1.g4();
        this.spent = var1.g4();
    }

    public static void method231(boolean var0) {
        AudioSystem.process();
        ++client.netWriter.idleWriteTicks;
        if (client.netWriter.idleWriteTicks >= 50 || var0) {
            client.netWriter.idleWriteTicks = 0;
            if (!client.pendingDisconnect && client.netWriter.unwrap() != null) {
                OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.KEEP_ALIVE, client.netWriter.encryptor);
                client.netWriter.writeLater(packet);

                try {
                    client.netWriter.flush();
                } catch (IOException var3) {
                    client.pendingDisconnect = true;
                }
            }

        }
    }

    public void method228() {
        this.state &= -8;
        this.state = (byte) (this.state | 2 & 7);
    }

    public void method227(int var1) {
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
