package jag.opcode;

import jag.commons.collection.LinkedList;

import java.io.IOException;

public class ConnectionContext {

    public final Buffer outbuffer;
    public final LinkedList outgoing;
    public final PacketBuffer inbuffer;
    public IsaacCipher encryptor;
    public Connection connection;
    public boolean alive;

    public int buffered;
    public int idleReadTicks;
    public int idleWriteTicks;
    public int incomingPacketSize;

    public IncomingPacketMeta currentIncomingPacket;
    public IncomingPacketMeta lastIncomingPacket;
    public IncomingPacketMeta secondLastIncomingPacket;
    public IncomingPacketMeta thirdLastIncomingPacket;

    public ConnectionContext() {
        this.outgoing = new LinkedList();
        this.buffered = 0;
        this.outbuffer = new Buffer(5000);
        this.inbuffer = new PacketBuffer(40000);
        this.currentIncomingPacket = null;
        this.incomingPacketSize = 0;
        this.alive = true;
        this.idleReadTicks = 0;
        this.idleWriteTicks = 0;
    }

    public Connection unwrap() {
        return this.connection;
    }

    public void stop() {
        if (this.connection != null) {
            this.connection.stop();
            this.connection = null;
        }

    }

    public final void writeLater(OutgoingPacket packet) {
        this.outgoing.pushBack(packet);
        packet.size = packet.buffer.caret;
        packet.buffer.caret = 0;
        this.buffered += packet.size;
    }

    public void kill() {
        this.connection = null;
    }

    public final void drop() {
        this.outgoing.removeAll();
        this.buffered = 0;
    }

    public final void flush() throws IOException {
        if (this.connection != null && this.buffered > 0) {
            this.outbuffer.caret = 0;

            while (true) {
                OutgoingPacket packet = (OutgoingPacket) this.outgoing.head();
                if (packet == null || packet.size > this.outbuffer.payload.length - this.outbuffer.caret) {
                    this.connection.writeBytes(this.outbuffer.payload, 0, this.outbuffer.caret);
                    this.idleWriteTicks = 0;
                    break;
                }

                this.outbuffer.writeBytes(packet.buffer.payload, 0, packet.size);
                this.buffered -= packet.size;
                packet.unlink();
                packet.buffer.cache();
                packet.cache();
            }
        }

    }

    public void method1000(Connection var1) {
        this.connection = var1;
    }
}
