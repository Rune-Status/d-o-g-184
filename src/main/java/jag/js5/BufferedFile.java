package jag.js5;

import jag.game.client;
import jag.statics.Statics31;
import jag.statics.Statics4;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BufferedFile {

    public static BufferedFile[] indexes;

    public static BufferedFile dataFile;
    public static BufferedFile indexFile;
    public static BufferedFile random;

    public static int indexCount;

    static {
        BufferedFile.random = null;
        BufferedFile.dataFile = null;
        BufferedFile.indexFile = null;
    }

    public final DiskFile file;
    public long aLong1897;
    public int anInt1895;
    public long aLong1896;
    public long aLong1894;
    public long caret;
    public long aLong1898;
    public int anInt1902;
    public byte[] aByteArray1893;
    public byte[] aByteArray1899;
    public long aLong1901;

    public BufferedFile(DiskFile file, int var2, int var3) throws IOException {
        this.aLong1898 = -1L;
        this.aLong1894 = -1L;
        this.anInt1902 = 0;
        this.file = file;
        this.aLong1897 = this.aLong1901 = file.length();
        this.aByteArray1899 = new byte[var2];
        this.aByteArray1893 = new byte[var3];
        this.caret = 0L;
    }

    public static void releaseAll() {
        try {
            dataFile.close();

            for (int i = 0; i < indexCount; ++i) {
                indexes[i].close();
            }

            indexFile.close();
            random.close();
        } catch (Exception ignored) {
        }

    }

    public static File openRw(String file) {
        if (!Statics4.aBoolean830) {
            throw new RuntimeException("");
        }
        File var1 = (File) Statics4.rwFileCache.get(file);
        if (var1 != null) {
            return var1;
        }
        File var2 = new File(Statics4.aFile831, file);
        RandomAccessFile var3 = null;

        try {
            File var4 = new File(var2.getParent());
            if (!var4.exists()) {
                throw new RuntimeException("");
            }
            var3 = new RandomAccessFile(var2, "rw");
            int var5 = var3.read();
            var3.seek(0L);
            var3.write(var5);
            var3.seek(0L);
            var3.close();
            Statics4.rwFileCache.put(file, var2);
            return var2;
        } catch (Exception var8) {
            try {
                if (var3 != null) {
                    var3.close();
                }
            } catch (Exception ignored) {
            }

            throw new RuntimeException();
        }
    }

    public static void createRandom(byte[] var0, int var1) {
        if (client.random == null) {
            client.random = new byte[24];
        }

        Statics31.method1140(var0, var1, client.random, 0, 24);
    }

    public void read(byte[] var1, int var2, int var3) throws IOException {
        try {
            if (var3 + var2 > var1.length) {
                throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
            }

            if (this.aLong1894 != -1L && this.caret >= this.aLong1894 && (long) var3 + this.caret <= (long) this.anInt1902 + this.aLong1894) {
                System.arraycopy(this.aByteArray1893, (int) (this.caret - this.aLong1894), var1, var2, var3);
                this.caret += var3;
                return;
            }

            long var4 = this.caret;
            int var7 = var3;
            int var8;
            if (this.caret >= this.aLong1898 && this.caret < this.aLong1898 + (long) this.anInt1895) {
                var8 = (int) ((long) this.anInt1895 - (this.caret - this.aLong1898));
                if (var8 > var3) {
                    var8 = var3;
                }

                System.arraycopy(this.aByteArray1899, (int) (this.caret - this.aLong1898), var1, var2, var8);
                this.caret += var8;
                var2 += var8;
                var3 -= var8;
            }

            if (var3 > this.aByteArray1899.length) {
                this.file.seek(this.caret);

                for (this.aLong1896 = this.caret; var3 > 0; var3 -= var8) {
                    var8 = this.file.read(var1, var2, var3);
                    if (var8 == -1) {
                        break;
                    }

                    this.aLong1896 += var8;
                    this.caret += var8;
                    var2 += var8;
                }
            } else if (var3 > 0) {
                this.method1405();
                var8 = Math.min(var3, this.anInt1895);

                System.arraycopy(this.aByteArray1899, 0, var1, var2, var8);
                var2 += var8;
                var3 -= var8;
                this.caret += var8;
            }

            if (-1L != this.aLong1894) {
                if (this.aLong1894 > this.caret && var3 > 0) {
                    var8 = var2 + (int) (this.aLong1894 - this.caret);
                    if (var8 > var3 + var2) {
                        var8 = var3 + var2;
                    }

                    while (var2 < var8) {
                        var1[var2++] = 0;
                        --var3;
                        ++this.caret;
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
                    if (var11 > this.caret) {
                        var3 = (int) ((long) var3 - (var11 - this.caret));
                        this.caret = var11;
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
            this.aLong1896 += this.anInt1902;
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

    public void seek(long caret) throws IOException {
        if (caret < 0L) {
            throw new IOException("");
        }
        this.caret = caret;
    }

    public void write(byte[] var1, int var2, int var3) throws IOException {
        try {
            if (this.caret + (long) var3 > this.aLong1897) {
                this.aLong1897 = (long) var3 + this.caret;
            }

            if (-1L != this.aLong1894 && (this.caret < this.aLong1894 || this.caret > (long) this.anInt1902 + this.aLong1894)) {
                this.method1411();
            }

            if (-1L != this.aLong1894 && (long) var3 + this.caret > this.aLong1894 + (long) this.aByteArray1893.length) {
                int var4 = (int) ((long) this.aByteArray1893.length - (this.caret - this.aLong1894));
                System.arraycopy(var1, var2, this.aByteArray1893, (int) (this.caret - this.aLong1894), var4);
                this.caret += var4;
                var2 += var4;
                var3 -= var4;
                this.anInt1902 = this.aByteArray1893.length;
                this.method1411();
            }

            if (var3 <= this.aByteArray1893.length) {
                if (var3 > 0) {
                    if (this.aLong1894 == -1L) {
                        this.aLong1894 = this.caret;
                    }

                    System.arraycopy(var1, var2, this.aByteArray1893, (int) (this.caret - this.aLong1894), var3);
                    this.caret += var3;
                    if (this.caret - this.aLong1894 > (long) this.anInt1902) {
                        this.anInt1902 = (int) (this.caret - this.aLong1894);
                    }

                }
            } else {
                if (this.aLong1896 != this.caret) {
                    this.file.seek(this.caret);
                    this.aLong1896 = this.caret;
                }

                this.file.write(var1, var2, var3);
                this.aLong1896 += var3;
                if (this.aLong1896 > this.aLong1901) {
                    this.aLong1901 = this.aLong1896;
                }

                long var5 = -1L;
                long var7 = -1L;
                if (this.caret >= this.aLong1898 && this.caret < (long) this.anInt1895 + this.aLong1898) {
                    var5 = this.caret;
                } else if (this.aLong1898 >= this.caret && this.aLong1898 < this.caret + (long) var3) {
                    var5 = this.aLong1898;
                }

                if ((long) var3 + this.caret > this.aLong1898 && (long) var3 + this.caret <= this.aLong1898 + (long) this.anInt1895) {
                    var7 = this.caret + (long) var3;
                } else if (this.aLong1898 + (long) this.anInt1895 > this.caret && this.aLong1898 + (long) this.anInt1895 <= this.caret + (long) var3) {
                    var7 = (long) this.anInt1895 + this.aLong1898;
                }

                if (var5 > -1L && var7 > var5) {
                    int var9 = (int) (var7 - var5);
                    System.arraycopy(var1, (int) (var5 + (long) var2 - this.caret), this.aByteArray1899, (int) (var5 - this.aLong1898), var9);
                }

                this.caret += var3;
            }
        } catch (IOException var11) {
            this.aLong1896 = -1L;
            throw var11;
        }
    }

    void method1405() throws IOException {
        this.anInt1895 = 0;
        if (this.caret != this.aLong1896) {
            this.file.seek(this.caret);
            this.aLong1896 = this.caret;
        }

        int var2;
        for (this.aLong1898 = this.caret; this.anInt1895 < this.aByteArray1899.length; this.anInt1895 += var2) {
            int var1 = this.aByteArray1899.length - this.anInt1895;
            if (var1 > 200000000) {
                var1 = 200000000;
            }

            var2 = this.file.read(this.aByteArray1899, this.anInt1895, var1);
            if (var2 == -1) {
                break;
            }

            this.aLong1896 += var2;
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
