package jag.opcode;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class AsyncInputStream implements Runnable {

    final int anInt1666;
    int anInt1662;
    int anInt1664;

    final byte[] payload;

    final InputStream input;
    final Thread thread;

    IOException error;

    AsyncInputStream(InputStream var1, int var2) {
        this.anInt1664 = 0;
        this.anInt1662 = 0;
        this.input = var1;
        this.anInt1666 = var2 + 1;
        this.payload = new byte[this.anInt1666];
        this.thread = new Thread(this);
        this.thread.setDaemon(true);
        this.thread.start();
    }

    boolean method1198(int var1) throws IOException {
        if (var1 == 0) {
            return true;
        }
        if (var1 > 0 && var1 < this.anInt1666) {
            synchronized (this) {
                int var3;
                if (this.anInt1664 <= this.anInt1662) {
                    var3 = this.anInt1662 - this.anInt1664;
                } else {
                    var3 = this.anInt1666 - this.anInt1664 + this.anInt1662;
                }

                if (var3 < var1) {
                    if (this.error != null) {
                        throw new IOException(this.error.toString());
                    }
                    this.notifyAll();
                    return false;
                }
                return true;
            }
        }
        throw new IOException();
    }

    int method1197() throws IOException {
        synchronized (this) {
            if (this.anInt1662 == this.anInt1664) {
                if (this.error != null) {
                    throw new IOException(this.error.toString());
                }
                return -1;
            }
            int var2 = this.payload[this.anInt1664] & 255;
            this.anInt1664 = (this.anInt1664 + 1) % this.anInt1666;
            this.notifyAll();
            return var2;
        }
    }

    int method1196(byte[] var1, int var2, int var3) throws IOException {
        if (var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
            synchronized (this) {
                int var5;
                if (this.anInt1664 <= this.anInt1662) {
                    var5 = this.anInt1662 - this.anInt1664;
                } else {
                    var5 = this.anInt1666 - this.anInt1664 + this.anInt1662;
                }

                if (var3 > var5) {
                    var3 = var5;
                }

                if (var3 == 0 && this.error != null) {
                    throw new IOException(this.error.toString());
                }
                if (var3 + this.anInt1664 <= this.anInt1666) {
                    System.arraycopy(this.payload, this.anInt1664, var1, var2, var3);
                } else {
                    int var6 = this.anInt1666 - this.anInt1664;
                    System.arraycopy(this.payload, this.anInt1664, var1, var2, var6);
                    System.arraycopy(this.payload, 0, var1, var6 + var2, var3 - var6);
                }

                this.anInt1664 = (var3 + this.anInt1664) % this.anInt1666;
                this.notifyAll();
                return var3;
            }
        }
        throw new IOException();
    }

    int method1199() throws IOException {
        synchronized (this) {
            int var2;
            if (this.anInt1664 <= this.anInt1662) {
                var2 = this.anInt1662 - this.anInt1664;
            } else {
                var2 = this.anInt1666 - this.anInt1664 + this.anInt1662;
            }

            if (var2 <= 0 && this.error != null) {
                throw new IOException(this.error.toString());
            }
            this.notifyAll();
            return var2;
        }
    }

    void method1195() {
        synchronized (this) {
            if (this.error == null) {
                this.error = new IOException("");
            }

            this.notifyAll();
        }

        try {
            this.thread.join();
        } catch (InterruptedException ignored) {
        }

    }

    public void run() {
        while (true) {
            int var2;
            synchronized (this) {
                while (true) {
                    if (this.error != null) {
                        return;
                    }

                    if (this.anInt1664 == 0) {
                        var2 = this.anInt1666 - this.anInt1662 - 1;
                    } else if (this.anInt1664 <= this.anInt1662) {
                        var2 = this.anInt1666 - this.anInt1662;
                    } else {
                        var2 = this.anInt1664 - this.anInt1662 - 1;
                    }

                    if (var2 > 0) {
                        break;
                    }

                    try {
                        this.wait();
                    } catch (InterruptedException ignored) {
                    }
                }
            }

            int var5;
            try {
                var5 = this.input.read(this.payload, this.anInt1662, var2);
                if (var5 == -1) {
                    throw new EOFException();
                }
            } catch (IOException var11) {
                synchronized (this) {
                    this.error = var11;
                    return;
                }
            }

            synchronized (this) {
                this.anInt1662 = (var5 + this.anInt1662) % this.anInt1666;
            }
        }
    }
}
