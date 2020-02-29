package com.jagex;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class AsyncInputStream implements Runnable {
    IOException anIOException1663;
    int anInt1662;
    int anInt1664;
    int anInt1666;
    byte[] aByteArray1665;
    InputStream anInputStream1668;
    Thread aThread1667;

    AsyncInputStream(InputStream var1, int var2) {
        this.anInt1664 = 0;
        this.anInt1662 = 0;
        this.anInputStream1668 = var1;
        this.anInt1666 = var2 + 1;
        this.aByteArray1665 = new byte[this.anInt1666];
        this.aThread1667 = new Thread(this);
        this.aThread1667.setDaemon(true);
        this.aThread1667.start();
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
                    if (this.anIOException1663 != null) {
                        throw new IOException(this.anIOException1663.toString());
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
                if (this.anIOException1663 != null) {
                    throw new IOException(this.anIOException1663.toString());
                }
                return -1;
            }
            int var2 = this.aByteArray1665[this.anInt1664] & 255;
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

                if (var3 == 0 && this.anIOException1663 != null) {
                    throw new IOException(this.anIOException1663.toString());
                }
                if (var3 + this.anInt1664 <= this.anInt1666) {
                    System.arraycopy(this.aByteArray1665, this.anInt1664, var1, var2, var3);
                } else {
                    int var6 = this.anInt1666 - this.anInt1664;
                    System.arraycopy(this.aByteArray1665, this.anInt1664, var1, var2, var6);
                    System.arraycopy(this.aByteArray1665, 0, var1, var6 + var2, var3 - var6);
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

            if (var2 <= 0 && this.anIOException1663 != null) {
                throw new IOException(this.anIOException1663.toString());
            }
            this.notifyAll();
            return var2;
        }
    }

    void method1195() {
        synchronized (this) {
            if (this.anIOException1663 == null) {
                this.anIOException1663 = new IOException("");
            }

            this.notifyAll();
        }

        try {
            this.aThread1667.join();
        } catch (InterruptedException ignored) {
        }

    }

    public void run() {
        while (true) {
            int var2;
            synchronized (this) {
                while (true) {
                    if (this.anIOException1663 != null) {
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
                var5 = this.anInputStream1668.read(this.aByteArray1665, this.anInt1662, var2);
                if (var5 == -1) {
                    throw new EOFException();
                }
            } catch (IOException var11) {
                synchronized (this) {
                    this.anIOException1663 = var11;
                    return;
                }
            }

            synchronized (this) {
                this.anInt1662 = (var5 + this.anInt1662) % this.anInt1666;
            }
        }
    }
}
