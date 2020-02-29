package com.jagex;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public final class OldConnection extends Connection implements Runnable {
    static InterfaceComponent anInterfaceComponent873;
    final int anInt871;
    final int anInt870;
    int anInt874;
    boolean aBoolean879;
    int anInt881;
    boolean aBoolean872;
    InputStream input;
    byte[] aByteArray877;
    OldConnectionTask aOldConnectionTask_876;
    OutputStream output;
    Class125 aClass125_878;
    Socket socket;

    public OldConnection(Socket var1, Class125 var2, int var3) throws IOException {
        this.aBoolean879 = false;
        this.anInt874 = 0;
        this.anInt881 = 0;
        this.aBoolean872 = false;
        this.aClass125_878 = var2;
        this.socket = var1;
        this.anInt871 = var3;
        this.anInt870 = var3 - 100;
        this.socket.setSoTimeout(30000);
        this.socket.setTcpNoDelay(true);
        this.socket.setReceiveBufferSize(65536);
        this.socket.setSendBufferSize(65536);
        this.input = this.socket.getInputStream();
        this.output = this.socket.getOutputStream();
    }

    public static EnumType method716(EnumType[] var0, int var1) {

        for (EnumType var4 : var0) {
            if (var1 == var4.getOrdinal()) {
                return var4;
            }
        }

        return null;
    }

    public static boolean method713(CharSequence var0) {
        return MouseRecorder.parseInt(var0);
    }

    static void method712(int var0) {
        InterfaceNode.method1319();

        for (Node_Sub2 var1 = (Node_Sub2) Node_Sub2.aNodeDeque373.head(); var1 != null; var1 = (Node_Sub2) Node_Sub2.aNodeDeque373.next()) {
            if (var1.anObjectDefinition376 != null) {
                var1.method254();
            }
        }

        int var2 = Class63.method360(var0).anInt377;
        if (var2 != 0) {
            int var3 = Varps.values[var0];
            if (var2 == 1) {
                if (var3 == 1) {
                    JagGraphics3D.method634(0.9D);
                    ((TextureProviderImpl) JagGraphics3D.aTextureProvider783).method1519(0.9D);
                }

                if (var3 == 2) {
                    JagGraphics3D.method634(0.8D);
                    ((TextureProviderImpl) JagGraphics3D.aTextureProvider783).method1519(0.8D);
                }

                if (var3 == 3) {
                    JagGraphics3D.method634(0.7D);
                    ((TextureProviderImpl) JagGraphics3D.aTextureProvider783).method1519(0.7D);
                }

                if (var3 == 4) {
                    JagGraphics3D.method634(0.6D);
                    ((TextureProviderImpl) JagGraphics3D.aTextureProvider783).method1519(0.6D);
                }

                ItemDefinition.aReferenceCache716.method334();
            }

            if (var2 == 3) {
                short var4 = 0;
                if (var3 == 0) {
                    var4 = 255;
                }

                if (var3 == 1) {
                    var4 = 192;
                }

                if (var3 == 2) {
                    var4 = 128;
                }

                if (var3 == 3) {
                    var4 = 64;
                }

                if (var3 == 4) {
                    var4 = 0;
                }

                if (var4 != client.anInt900) {
                    if (client.anInt900 == 0 && client.anInt898 != -1) {
                        Class61.method344(Statics15.aCacheReferenceTable1234, client.anInt898, 0, var4, false);
                        client.aBoolean904 = false;
                    } else if (var4 == 0) {
                        Class96.method533();
                        client.aBoolean904 = false;
                    } else if (Class147.anInt1157 != 0) {
                        PickableNode.anInt379 = var4;
                    } else {
                        Class30.aClass5_Sub6_Sub3_326.method703(var4);
                    }

                    client.anInt900 = var4;
                }
            }

            if (var2 == 4) {
                if (var3 == 0) {
                    client.anInt901 = 127;
                }

                if (var3 == 1) {
                    client.anInt901 = 96;
                }

                if (var3 == 2) {
                    client.anInt901 = 64;
                }

                if (var3 == 3) {
                    client.anInt901 = 32;
                }

                if (var3 == 4) {
                    client.anInt901 = 0;
                }
            }

            if (var2 == 5) {
                client.anInt1034 = var3;
            }

            if (var2 == 6) {
                client.anInt1045 = var3;
            }

            if (var2 == 9) {
                client.anInt1054 = var3;
            }

            if (var2 == 10) {
                if (var3 == 0) {
                    client.anInt897 = 127;
                }

                if (var3 == 1) {
                    client.anInt897 = 96;
                }

                if (var3 == 2) {
                    client.anInt897 = 64;
                }

                if (var3 == 3) {
                    client.anInt897 = 32;
                }

                if (var3 == 4) {
                    client.anInt897 = 0;
                }
            }

            if (var2 == 17) {
                client.anInt1053 = var3 & 65535;
            }

            if (var2 == 18) {
                client.playerActionPriority = (ActionPrioritySetting) method716(DoublyLinkedNode_Sub20.method1109(), var3);
                if (client.playerActionPriority == null) {
                    client.playerActionPriority = ActionPrioritySetting.anActionPrioritySetting333;
                }
            }

            if (var2 == 19) {
                if (var3 == -1) {
                    client.anInt1030 = -1;
                } else {
                    client.anInt1030 = var3 & 2047;
                }
            }

            if (var2 == 22) {
                client.npcActionPriority = (ActionPrioritySetting) method716(DoublyLinkedNode_Sub20.method1109(), var3);
                if (client.npcActionPriority == null) {
                    client.npcActionPriority = ActionPrioritySetting.anActionPrioritySetting333;
                }
            }

        }
    }

    public static String method714(String var0) {
        int var1 = var0.length();
        char[] var2 = new char[var1];
        byte var3 = 2;

        for (int var4 = 0; var4 < var1; ++var4) {
            char var5 = var0.charAt(var4);
            if (var3 == 0) {
                var5 = Character.toLowerCase(var5);
            } else if (var3 == 2 || Character.isUpperCase(var5)) {
                var5 = Class108.method646(var5);
            }

            if (Character.isLetter(var5)) {
                var3 = 0;
            } else if (var5 != '.' && var5 != '?' && var5 != '!') {
                if (Character.isSpaceChar(var5)) {
                    if (var3 != 2) {
                        var3 = 1;
                    }
                } else {
                    var3 = 1;
                }
            } else {
                var3 = 2;
            }

            var2[var4] = var5;
        }

        return new String(var2);
    }

    void method715(byte[] var1, int var2, int var3) throws IOException {
        if (!this.aBoolean879) {
            if (this.aBoolean872) {
                this.aBoolean872 = false;
                throw new IOException();
            }
            if (this.aByteArray877 == null) {
                this.aByteArray877 = new byte[this.anInt871];
            }

            synchronized (this) {
                for (int var5 = 0; var5 < var3; ++var5) {
                    this.aByteArray877[this.anInt881] = var1[var5 + var2];
                    this.anInt881 = (this.anInt881 + 1) % this.anInt871;
                    if ((this.anInt870 + this.anInt874) % this.anInt871 == this.anInt881) {
                        throw new IOException();
                    }
                }

                if (this.aOldConnectionTask_876 == null) {
                    this.aOldConnectionTask_876 = this.aClass125_878.method697(this, 3);
                }

                this.notifyAll();
            }
        }
    }

    public void stop() {
        if (!this.aBoolean879) {
            synchronized (this) {
                this.aBoolean879 = true;
                this.notifyAll();
            }

            if (this.aOldConnectionTask_876 != null) {
                while (this.aOldConnectionTask_876.anInt885 == 0) {
                    try {
                        Thread.sleep(1L);
                    } catch (InterruptedException ignored) {
                    }
                }

                if (this.aOldConnectionTask_876.anInt885 == 1) {
                    try {
                        ((Thread) this.aOldConnectionTask_876.anObject886).join();
                    } catch (InterruptedException ignored) {
                    }
                }
            }

            this.aOldConnectionTask_876 = null;
        }
    }

    public boolean available(int amount) throws IOException {
        if (this.aBoolean879) {
            return false;
        }
        return this.input.available() >= amount;
    }

    public int readBytes(byte[] payload, int caret, int length) throws IOException {
        if (this.aBoolean879) {
            return 0;
        }
        int var4;
        int var5;
        for (var4 = length; length > 0; length -= var5) {
            var5 = this.input.read(payload, caret, length);
            if (var5 <= 0) {
                throw new EOFException();
            }

            caret += var5;
        }

        return var4;
    }

    public void writeBytes(byte[] payload, int caret, int length) throws IOException {
        this.method715(payload, caret, length);
    }

    public int readable() throws IOException {
        return this.aBoolean879 ? 0 : this.input.available();
    }

    public int readByte() throws IOException {
        return this.aBoolean879 ? 0 : this.input.read();
    }

    protected void finalize() {
        this.stop();
    }

    public void run() {
        try {
            while (true) {
                label84:
                {
                    int var3;
                    int var4;
                    synchronized (this) {
                        if (this.anInt874 == this.anInt881) {
                            if (this.aBoolean879) {
                                break label84;
                            }

                            try {
                                this.wait();
                            } catch (InterruptedException ignored) {
                            }
                        }

                        var3 = this.anInt874;
                        if (this.anInt881 >= this.anInt874) {
                            var4 = this.anInt881 - this.anInt874;
                        } else {
                            var4 = this.anInt871 - this.anInt874;
                        }
                    }

                    if (var4 <= 0) {
                        continue;
                    }

                    try {
                        this.output.write(this.aByteArray877, var3, var4);
                    } catch (IOException var9) {
                        this.aBoolean872 = true;
                    }

                    this.anInt874 = (var4 + this.anInt874) % this.anInt871;

                    try {
                        if (this.anInt881 == this.anInt874) {
                            this.output.flush();
                        }
                    } catch (IOException var8) {
                        this.aBoolean872 = true;
                    }
                    continue;
                }

                try {
                    if (this.input != null) {
                        this.input.close();
                    }

                    if (this.output != null) {
                        this.output.close();
                    }

                    if (this.socket != null) {
                        this.socket.close();
                    }
                } catch (IOException ignored) {
                }

                this.aByteArray877 = null;
                break;
            }
        } catch (Exception var12) {
            Class8.method65(null, var12);
        }

    }
}
