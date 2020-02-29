package com.jagex;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;

public class AsyncConnection extends Connection {
    public static int anInt1210;
    AsyncOutputStream output;
    AsyncInputStream input;
    Socket socket;

    public AsyncConnection(Socket var1, int var2, int var3) throws IOException {
        this.socket = var1;
        this.socket.setSoTimeout(30000);
        this.socket.setTcpNoDelay(true);
        this.socket.setReceiveBufferSize(65536);
        this.socket.setSendBufferSize(65536);
        this.input = new AsyncInputStream(this.socket.getInputStream(), var2);
        this.output = new AsyncOutputStream(this.socket.getOutputStream(), var3);
    }

    static boolean loadWorlds() {
        try {
            if (Statics1.aClass105_322 == null) {
                Statics1.aClass105_322 = client.aClass108_965.method647(new URL(Enum_Sub2.aString623));
            } else if (Statics1.aClass105_322.method616()) {
                byte[] var1 = Statics1.aClass105_322.method618();
                Buffer var2 = new Buffer(var1);
                var2.readInt();
                World.anInt1871 = var2.readUShort();
                World.worlds = new World[World.anInt1871];

                World var4;
                for (int var3 = 0; var3 < World.anInt1871; var4.anInt1873 = var3++) {
                    var4 = World.worlds[var3] = new World();
                    var4.anInt1875 = var2.readUShort();
                    var4.mask = var2.readInt();
                    var4.domain = var2.readString();
                    var4.activity = var2.readString();
                    var4.location = var2.readUByte();
                    var4.population = var2.method1029();
                }

                Class63_Sub2.method471(World.worlds, 0, World.worlds.length - 1, World.anIntArray1874, World.anIntArray1870);
                Statics1.aClass105_322 = null;
                return true;
            }
        } catch (Exception var5) {
            var5.printStackTrace();
            Statics1.aClass105_322 = null;
        }

        return false;
    }

    public void stop() {
        this.output.method12();

        try {
            this.socket.close();
        } catch (IOException ignored) {
        }

        this.input.method1195();
    }

    public boolean available(int amount) throws IOException {
        return this.input.method1198(amount);
    }

    public int readBytes(byte[] payload, int caret, int length) throws IOException {
        return this.input.method1196(payload, caret, length);
    }

    public void writeBytes(byte[] payload, int caret, int length) throws IOException {
        this.output.method16(payload, caret, length);
    }

    public int readable() throws IOException {
        return this.input.method1199();
    }

    public int readByte() throws IOException {
        return this.input.method1197();
    }

    protected void finalize() {
        this.stop();
    }
}
