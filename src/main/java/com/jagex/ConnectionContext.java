package com.jagex;

import java.io.IOException;

public class ConnectionContext {

    public IsaacCipher encryptor;

    Buffer outbuffer;
    Connection connection;
    LinkedList outgoing;
    PacketBuffer inbuffer;

    boolean alive;

    int buffered;
    int idleReadTicks;
    int idleWriteTicks;
    int incomingPacketSize;

    IncomingPacketMeta currentIncomingPacket;
    IncomingPacketMeta lastIncomingPacket;
    IncomingPacketMeta secondLastIncomingPacket;
    IncomingPacketMeta thirdLastIncomingPacket;

    ConnectionContext() {
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

    Connection unwrap() {
        return this.connection;
    }

    void stop() {
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

    void kill() {
        this.connection = null;
    }

    final void drop() {
        this.outgoing.removeAll();
        this.buffered = 0;
    }

    final void flush() throws IOException {
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

    void method1000(Connection var1) {
        this.connection = var1;
    }
}
