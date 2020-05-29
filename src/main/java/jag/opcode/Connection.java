package jag.opcode;

import jag.js5.NetWorker;

import java.io.IOException;

public abstract class Connection {
    protected Connection() {
    }

    public static void destroy() {
        if (NetWorker.connection != null) {
            NetWorker.connection.stop();
        }

    }

    public abstract void stop();

    public abstract boolean available(int amount) throws IOException;

    public abstract int readBytes(byte[] payload, int caret, int length) throws IOException;

    public abstract void writeBytes(byte[] payload, int caret, int length) throws IOException;

    public abstract int readable() throws IOException;

    public abstract int readByte() throws IOException;
}
