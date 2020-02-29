package com.jagex;

import java.io.EOFException;
import java.io.IOException;

public class BufferedFile {
    long aLong1897;
    int anInt1895;
    long aLong1896;
    long aLong1894;
    long aLong1900;
    long aLong1898;
    DiskFile file;
    int anInt1902;
    byte[] aByteArray1893;
    byte[] aByteArray1899;
    long aLong1901;

    public BufferedFile(DiskFile file, int var2, int var3) throws IOException {
        this.aLong1898 = -1L;
        this.aLong1894 = -1L;
        this.anInt1902 = 0;
        this.file = file;
        this.aLong1897 = this.aLong1901 = file.length();
        this.aByteArray1899 = new byte[var2];
        this.aByteArray1893 = new byte[var3];
        this.aLong1900 = 0L;
    }

    public void read(byte[] var1, int var2, int var3) throws IOException {
        try {
            if (var3 + var2 > var1.length) {
                throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
            }

            if (this.aLong1894 != -1L && this.aLong1900 >= this.aLong1894 && (long) var3 + this.aLong1900 <= (long) this.anInt1902 + this.aLong1894) {
                System.arraycopy(this.aByteArray1893, (int) (this.aLong1900 - this.aLong1894), var1, var2, var3);
                this.aLong1900 += (long) var3;
                return;
            }

            long var4 = this.aLong1900;
            int var7 = var3;
            int var8;
            if (this.aLong1900 >= this.aLong1898 && this.aLong1900 < this.aLong1898 + (long) this.anInt1895) {
                var8 = (int) ((long) this.anInt1895 - (this.aLong1900 - this.aLong1898));
                if (var8 > var3) {
                    var8 = var3;
                }

                System.arraycopy(this.aByteArray1899, (int) (this.aLong1900 - this.aLong1898), var1, var2, var8);
                this.aLong1900 += (long) var8;
                var2 += var8;
                var3 -= var8;
            }

            if (var3 > this.aByteArray1899.length) {
                this.file.seek(this.aLong1900);

                for (this.aLong1896 = this.aLong1900; var3 > 0; var3 -= var8) {
                    var8 = this.file.read(var1, var2, var3);
                    if (var8 == -1) {
                        break;
                    }

                    this.aLong1896 += (long) var8;
                    this.aLong1900 += (long) var8;
                    var2 += var8;
                }
            } else if (var3 > 0) {
                this.method1405();
                var8 = var3;
                if (var3 > this.anInt1895) {
                    var8 = this.anInt1895;
                }

                System.arraycopy(this.aByteArray1899, 0, var1, var2, var8);
                var2 += var8;
                var3 -= var8;
                this.aLong1900 += (long) var8;
            }

            if (-1L != this.aLong1894) {
                if (this.aLong1894 > this.aLong1900 && var3 > 0) {
                    var8 = var2 + (int) (this.aLong1894 - this.aLong1900);
                    if (var8 > var3 + var2) {
                        var8 = var3 + var2;
                    }

                    while (var2 < var8) {
                        var1[var2++] = 0;
                        --var3;
                        ++this.aLong1900;
                    }
                }

                long var9 = -1L;
                long var11 = -1L;
                if (this.aLong1894 >= var4 && this.aLong1894 < (long) var7 + var4) {
                    var9 = this.aLong1894;
                } else if (var4 >= this.aLong1894 && var4 < this.aLong1894 + (long) this.anInt1902) {
                    var9 = var4;
                }

                if (this.aLong1894 + (long) this.anInt1902 > var4 && (long) this.anInt1902 + this.aLong1894 <= var4 + (long) var7) {
                    var11 = (long) this.anInt1902 + this.aLong1894;
                } else if (var4 + (long) var7 > this.aLong1894 && var4 + (long) var7 <= this.aLong1894 + (long) this.anInt1902) {
                    var11 = (long) var7 + var4;
                }

                if (var9 > -1L && var11 > var9) {
                    int var13 = (int) (var11 - var9);
                    System.arraycopy(this.aByteArray1893, (int) (var9 - this.aLong1894), var1, (int) (var9 - var4) + var2, var13);
                    if (var11 > this.aLong1900) {
                        var3 = (int) ((long) var3 - (var11 - this.aLong1900));
                        this.aLong1900 = var11;
                    }
                }
            }
        } catch (IOException var15) {
            this.aLong1896 = -1L;
            throw var15;
        }

        if (var3 > 0) {
            throw new EOFException();
        }
    }

    void method1411() throws IOException {
        if (-1L != this.aLong1894) {
            if (this.aLong1896 != this.aLong1894) {
                this.file.seek(this.aLong1894);
                this.aLong1896 = this.aLong1894;
            }

            this.file.write(this.aByteArray1893, 0, this.anInt1902);
            this.aLong1896 += (long) (this.anInt1902);
            if (this.aLong1896 > this.aLong1901) {
                this.aLong1901 = this.aLong1896;
            }

            long var1 = -1L;
            long var3 = -1L;
            if (this.aLong1894 >= this.aLong1898 && this.aLong1894 < this.aLong1898 + (long) this.anInt1895) {
                var1 = this.aLong1894;
            } else if (this.aLong1898 >= this.aLong1894 && this.aLong1898 < this.aLong1894 + (long) this.anInt1902) {
                var1 = this.aLong1898;
            }

            if ((long) this.anInt1902 + this.aLong1894 > this.aLong1898 && (long) this.anInt1902 + this.aLong1894 <= (long) this.anInt1895 + this.aLong1898) {
                var3 = (long) this.anInt1902 + this.aLong1894;
            } else if ((long) this.anInt1895 + this.aLong1898 > this.aLong1894 && this.aLong1898 + (long) this.anInt1895 <= this.aLong1894 + (long) this.anInt1902) {
                var3 = (long) this.anInt1895 + this.aLong1898;
            }

            if (var1 > -1L && var3 > var1) {
                int var5 = (int) (var3 - var1);
                System.arraycopy(this.aByteArray1893, (int) (var1 - this.aLong1894), this.aByteArray1899, (int) (var1 - this.aLong1898), var5);
            }

            this.aLong1894 = -1L;
            this.anInt1902 = 0;
        }

    }

    public long method1409() {
        return this.aLong1897;
    }

    public void seek(long var1) throws IOException {
        if (var1 < 0L) {
            throw new IOException("");
        }
        this.aLong1900 = var1;
    }

    public void write(byte[] var1, int var2, int var3) throws IOException {
        try {
            if ((long) var3 + this.aLong1900 > this.aLong1897) {
                this.aLong1897 = (long) var3 + this.aLong1900;
            }

            if (-1L != this.aLong1894 && (this.aLong1900 < this.aLong1894 || this.aLong1900 > (long) this.anInt1902 + this.aLong1894)) {
                this.method1411();
            }

            if (-1L != this.aLong1894 && (long) var3 + this.aLong1900 > this.aLong1894 + (long) this.aByteArray1893.length) {
                int var4 = (int) ((long) this.aByteArray1893.length - (this.aLong1900 - this.aLong1894));
                System.arraycopy(var1, var2, this.aByteArray1893, (int) (this.aLong1900 - this.aLong1894), var4);
                this.aLong1900 += (long) var4;
                var2 += var4;
                var3 -= var4;
                this.anInt1902 = this.aByteArray1893.length;
                this.method1411();
            }

            if (var3 <= this.aByteArray1893.length) {
                if (var3 > 0) {
                    if (this.aLong1894 == -1L) {
                        this.aLong1894 = this.aLong1900;
                    }

                    System.arraycopy(var1, var2, this.aByteArray1893, (int) (this.aLong1900 - this.aLong1894), var3);
                    this.aLong1900 += (long) var3;
                    if (this.aLong1900 - this.aLong1894 > (long) this.anInt1902) {
                        this.anInt1902 = (int) (this.aLong1900 - this.aLong1894);
                    }

                }
            } else {
                if (this.aLong1896 != this.aLong1900) {
                    this.file.seek(this.aLong1900);
                    this.aLong1896 = this.aLong1900;
                }

                this.file.write(var1, var2, var3);
                this.aLong1896 += (long) var3;
                if (this.aLong1896 > this.aLong1901) {
                    this.aLong1901 = this.aLong1896;
                }

                long var5 = -1L;
                long var7 = -1L;
                if (this.aLong1900 >= this.aLong1898 && this.aLong1900 < (long) this.anInt1895 + this.aLong1898) {
                    var5 = this.aLong1900;
                } else if (this.aLong1898 >= this.aLong1900 && this.aLong1898 < this.aLong1900 + (long) var3) {
                    var5 = this.aLong1898;
                }

                if ((long) var3 + this.aLong1900 > this.aLong1898 && (long) var3 + this.aLong1900 <= this.aLong1898 + (long) this.anInt1895) {
                    var7 = this.aLong1900 + (long) var3;
                } else if (this.aLong1898 + (long) this.anInt1895 > this.aLong1900 && this.aLong1898 + (long) this.anInt1895 <= this.aLong1900 + (long) var3) {
                    var7 = (long) this.anInt1895 + this.aLong1898;
                }

                if (var5 > -1L && var7 > var5) {
                    int var9 = (int) (var7 - var5);
                    System.arraycopy(var1, (int) (var5 + (long) var2 - this.aLong1900), this.aByteArray1899, (int) (var5 - this.aLong1898), var9);
                }

                this.aLong1900 += (long) var3;
            }
        } catch (IOException var11) {
            this.aLong1896 = -1L;
            throw var11;
        }
    }

    void method1405() throws IOException {
        this.anInt1895 = 0;
        if (this.aLong1900 != this.aLong1896) {
            this.file.seek(this.aLong1900);
            this.aLong1896 = this.aLong1900;
        }

        int var2;
        for (this.aLong1898 = this.aLong1900; this.anInt1895 < this.aByteArray1899.length; this.anInt1895 += var2) {
            int var1 = this.aByteArray1899.length - this.anInt1895;
            if (var1 > 200000000) {
                var1 = 200000000;
            }

            var2 = this.file.read(this.aByteArray1899, this.anInt1895, var1);
            if (var2 == -1) {
                break;
            }

            this.aLong1896 += (long) var2;
        }

    }

    public void close() throws IOException {
        this.method1411();
        this.file.close();
    }

    public void read(byte[] var1) throws IOException {
        this.read(var1, 0, var1.length);
    }
}
