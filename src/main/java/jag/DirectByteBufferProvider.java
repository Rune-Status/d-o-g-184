package jag;

import jag.opcode.Buffer;
import jag.js5.NetWorker;

import java.io.IOException;
import java.nio.ByteBuffer;

public class DirectByteBufferProvider extends ByteBufferProvider {
    public static int[] anIntArray1138;
    public static int[] anIntArray1136;
    ByteBuffer aByteBuffer1137;

    public DirectByteBufferProvider() {
    }

    public static void method803(boolean var0) {
        if (NetWorker.connection != null) {
            try {
                Buffer var1 = new Buffer(4);
                var1.writeByte(var0 ? 2 : 3);
                var1.writeMediumInt(0);
                NetWorker.connection.writeBytes(var1.payload, 0, 4);
            } catch (IOException var4) {
                try {
                    NetWorker.connection.stop();
                } catch (Exception ignored) {
                }

                ++NetWorker.anInt1488;
                NetWorker.connection = null;
            }

        }
    }

    public byte[] get() {
        byte[] var1 = new byte[this.aByteBuffer1137.capacity()];
        this.aByteBuffer1137.position(0);
        this.aByteBuffer1137.get(var1);
        return var1;
    }

    public void allocate(byte[] var1) {
        this.aByteBuffer1137 = ByteBuffer.allocateDirect(var1.length);
        this.aByteBuffer1137.position(0);
        this.aByteBuffer1137.put(var1);
    }
}
