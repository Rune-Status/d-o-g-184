package com.jagex;

import java.io.IOException;

public abstract class Connection {
    protected Connection() {
    }

    public abstract void stop();

    public abstract boolean available(int amount) throws IOException;

    public abstract int readBytes(byte[] payload, int caret, int length) throws IOException;

    public abstract void writeBytes(byte[] payload, int caret, int length) throws IOException;

    public abstract int readable() throws IOException;

    public abstract int readByte() throws IOException;
}
