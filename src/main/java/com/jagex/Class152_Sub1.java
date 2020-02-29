package com.jagex;

import java.io.IOException;
import java.nio.ByteBuffer;

public class Class152_Sub1 extends Class152 {
    static int[] anIntArray1138;
    static int[] anIntArray1136;
    ByteBuffer aByteBuffer1137;

    Class152_Sub1() {
    }

    public static void method803(boolean var0) {
        if (Statics25.connection != null) {
            try {
                Buffer var1 = new Buffer(4);
                var1.writeByte(var0 ? 2 : 3);
                var1.writeMediumInt(0);
                Statics25.connection.writeBytes(var1.payload, 0, 4);
            } catch (IOException var4) {
                try {
                    Statics25.connection.stop();
                } catch (Exception ignored) {
                }

                ++Statics25.anInt1488;
                Statics25.connection = null;
            }

        }
    }

    byte[] method802() {
        byte[] var1 = new byte[this.aByteBuffer1137.capacity()];
        this.aByteBuffer1137.position(0);
        this.aByteBuffer1137.get(var1);
        return var1;
    }

    void method801(byte[] var1) {
        this.aByteBuffer1137 = ByteBuffer.allocateDirect(var1.length);
        this.aByteBuffer1137.position(0);
        this.aByteBuffer1137.put(var1);
    }
}
