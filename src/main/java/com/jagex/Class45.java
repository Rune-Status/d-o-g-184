package com.jagex;

import java.net.MalformedURLException;
import java.net.URL;

public class Class45 {
    static Class215 aClass215_418;
    int anInt422;
    int[] anIntArray423;
    int[] anIntArray414;
    int[] anIntArray411;
    int[] anIntArray420;
    int[] anIntArray417;
    int anInt416;
    int[] anIntArray410;
    int anInt419;
    int anInt415;
    int anInt408;
    int[] anIntArray409;
    int[] anIntArray412;
    DoublyLinkedNode_Sub24_Sub4[] aDoublyNode_Sub24_Sub4Array424;
    int[] anIntArray421;

    Class45(DoublyLinkedNode_Sub24_Sub4[] var1) {
        this.anIntArray417 = new int[256];
        this.anInt415 = 0;
        this.anInt416 = 0;
        this.anInt408 = 0;
        this.anInt422 = 0;
        this.anInt419 = 0;
        this.aDoublyNode_Sub24_Sub4Array424 = var1;
        this.method285();
    }

    static int crc32(byte[] var0, int var1, int var2) {
        int var3 = -1;

        for (int var4 = var1; var4 < var2; ++var4) {
            var3 = var3 >>> 8 ^ Buffer.crc32[(var3 ^ var0[var4]) & 255];
        }

        var3 = ~var3;
        return var3;
    }

    public static boolean method278(char var0) {
        if ((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
            if (var0 != 0) {
                char[] var1 = Statics35.aCharArray1616;

                for (char var3 : var1) {
                    if (var0 == var3) {
                        return true;
                    }
                }
            }

            return false;
        }
        return true;
    }

    static void createRandom(byte[] var0, int var1) {
        if (client.random == null) {
            client.random = new byte[24];
        }

        Statics31.method1140(var0, var1, client.random, 0, 24);
    }

    static void method274(InterfaceComponent var0, int var1, int var2, int var3) {
        if (var0.anIntArray1361 == null) {
            throw new RuntimeException();
        }
        var0.anIntArray1361[var1] = var2;
        var0.anIntArray1366[var1] = var3;
    }

    static boolean method286(String var0) {
        if (var0 == null) {
            return false;
        }
        try {
            new URL(var0);
            return true;
        } catch (MalformedURLException var2) {
            return false;
        }
    }

    void method285() {
        this.anIntArray414 = new int[256];

        int var1;
        for (var1 = 0; var1 < 64; ++var1) {
            this.anIntArray414[var1] = var1 * 262144;
        }

        for (var1 = 0; var1 < 64; ++var1) {
            this.anIntArray414[var1 + 64] = var1 * 1024 + 16711680;
        }

        for (var1 = 0; var1 < 64; ++var1) {
            this.anIntArray414[var1 + 128] = var1 * 4 + 16776960;
        }

        for (var1 = 0; var1 < 64; ++var1) {
            this.anIntArray414[var1 + 192] = 16777215;
        }

        this.anIntArray410 = new int[256];

        for (var1 = 0; var1 < 64; ++var1) {
            this.anIntArray410[var1] = var1 * 1024;
        }

        for (var1 = 0; var1 < 64; ++var1) {
            this.anIntArray410[var1 + 64] = var1 * 4 + 65280;
        }

        for (var1 = 0; var1 < 64; ++var1) {
            this.anIntArray410[var1 + 128] = var1 * 262144 + 65535;
        }

        for (var1 = 0; var1 < 64; ++var1) {
            this.anIntArray410[var1 + 192] = 16777215;
        }

        this.anIntArray409 = new int[256];

        for (var1 = 0; var1 < 64; ++var1) {
            this.anIntArray409[var1] = var1 * 4;
        }

        for (var1 = 0; var1 < 64; ++var1) {
            this.anIntArray409[var1 + 64] = var1 * 262144 + 255;
        }

        for (var1 = 0; var1 < 64; ++var1) {
            this.anIntArray409[var1 + 128] = var1 * 1024 + 16711935;
        }

        for (var1 = 0; var1 < 64; ++var1) {
            this.anIntArray409[var1 + 192] = 16777215;
        }

        this.anIntArray423 = new int[256];
        this.anInt422 = 0;
        this.anIntArray420 = new int[32768];
        this.anIntArray412 = new int[32768];
        this.method284(null);
        this.anIntArray411 = new int[32768];
        this.anIntArray421 = new int[32768];
    }

    final void method280(int var1, int[] var2) {
        int var3 = this.anIntArray423.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            if (var1 > 768) {
                this.anIntArray423[var4] = this.method281(this.anIntArray414[var4], var2[var4], 1024 - var1);
            } else if (var1 > 256) {
                this.anIntArray423[var4] = var2[var4];
            } else {
                this.anIntArray423[var4] = this.method281(var2[var4], this.anIntArray414[var4], 256 - var1);
            }
        }

    }

    final void method275(int var1) {
        int var2 = 0;

        for (int var3 = 1; var3 < 255; ++var3) {
            int var4 = (256 - var3) * this.anIntArray417[var3] / 256;
            int var5 = var4 + var1;
            int var6 = 0;
            int var7 = 128;
            if (var5 < 0) {
                var6 = -var5;
                var5 = 0;
            }

            if (var5 + 128 >= Class20.aClass216_284.anInt1817) {
                var7 = Class20.aClass216_284.anInt1817 - var5;
            }

            int var8 = var5 + (var3 + 8) * Class20.aClass216_284.anInt1817;
            var2 += var6;

            for (int var9 = var6; var9 < var7; ++var9) {
                int var10 = this.anIntArray411[var2++];
                int var11 = var8 % JagGraphics.drawingAreaWidth;
                if (var10 != 0 && var11 >= JagGraphics.drawingAreaLeft && var11 < JagGraphics.drawingAreaBottom) {
                    int var12 = var10;
                    int var13 = 256 - var10;
                    var10 = this.anIntArray423[var10];
                    int var14 = Class20.aClass216_284.anIntArray1818[var8];
                    Class20.aClass216_284.anIntArray1818[var8++] = -16777216 | ((var14 & 16711935) * var13 + (var10 & 16711935) * var12 & -16711936) + (var12 * (var10 & 65280) + var13 * (var14 & 65280) & 16711680) >> 8;
                } else {
                    ++var8;
                }
            }

            var2 += 128 - var7;
        }

    }

    final int method281(int var1, int var2, int var3) {
        int var4 = 256 - var3;
        return (var3 * (var2 & 65280) + var4 * (var1 & 65280) & 16711680) + (var4 * (var1 & 16711935) + var3 * (var2 & 16711935) & -16711936) >> 8;
    }

    final void method282(int var1) {
        long time = System.currentTimeMillis();
        this.anInt422 += var1 * 128;
        int var2;
        if (this.anInt422 > this.anIntArray420.length) {
            this.anInt422 -= this.anIntArray420.length;
            var2 = (int) (Math.random() * 12.0D);
            this.method284(this.aDoublyNode_Sub24_Sub4Array424[var2]);
        }

        var2 = 0;
        int var3 = var1 * 128;
        int var4 = (256 - var1) * 128;

        int var6;
        for (int var5 = 0; var5 < var4; ++var5) {
            var6 = this.anIntArray411[var2 + var3] - this.anIntArray420[var2 + this.anInt422 & this.anIntArray420.length - 1] * var1 / 6;
            if (var6 < 0) {
                var6 = 0;
            }

            this.anIntArray411[var2++] = var6;
        }

        byte var15 = 10;
        var6 = 128 - var15;

        int var7;
        int var10;
        for (var7 = 256 - var1; var7 < 256; ++var7) {
            int var8 = var7 * 128;

            for (int var9 = 0; var9 < 128; ++var9) {
                var10 = (int) (Math.random() * 100.0D);
                if (var10 < 50 && var9 > var15 && var9 < var6) {
                    this.anIntArray411[var9 + var8] = 255;
                } else {
                    this.anIntArray411[var8 + var9] = 0;
                }
            }
        }

        if (this.anInt416 * 16 > 0) {
            this.anInt416 = this.anInt416 * 16 - var1 * 4;
        }

        if (this.anInt408 * 16 > 0) {
            this.anInt408 = this.anInt408 * 16 - var1 * 4;
        }

        if (this.anInt416 * 16 == 0 && this.anInt408 * 16 == 0) {
            var7 = (int) (Math.random() * (double) (2000 / var1));
            if (var7 == 0) {
                this.anInt416 = 1024;
            }

            if (var7 == 1) {
                this.anInt408 = 1024;
            }
        }

        for (var7 = 0; var7 < 256 - var1; ++var7) {
            this.anIntArray417[var7] = this.anIntArray417[var7 + var1];
        }

        for (var7 = 256 - var1; var7 < 256; ++var7) {
            this.anIntArray417[var7] = (int) (Math.sin((double) this.anInt415 / 14.0D) * 16.0D + Math.sin((double) this.anInt415 / 15.0D) * 14.0D + Math.sin((double) this.anInt415 / 16.0D) * 12.0D);
            ++this.anInt415;
        }

        var7 = ((client.engineCycle & 1) + var1) / 2;

        if (var7 > 0) {
            short var16 = 128;
            byte var17 = 2;
            var10 = 128 - var17 - var17;

            int var11;
            int var12;
            int var13;
            for (var11 = 0; var11 < var1 * 100; ++var11) {
                var12 = (int) (Math.random() * (double) var10) + var17;
                var13 = (int) (Math.random() * (double) var16) + var16;
                this.anIntArray411[var12 + (var13 << 7)] = 192;
            }


            int var14;
            for (var11 = 0; var11 < 256; ++var11) {
                var12 = 0;
                var13 = var11 * 128;

                for (var14 = -var7; var14 < 128; ++var14) {
                    if (var14 + var7 < 128) {
                        var12 += this.anIntArray411[var7 + var14 + var13];
                    }

                    if (var14 - (var7 + 1) >= 0) {
                        var12 -= this.anIntArray411[var13 + var14 - (var7 + 1)];
                    }

                    if (var14 >= 0) {
                        this.anIntArray421[var14 + var13] = var12 / (var7 * 2 + 1);
                    }
                }
            }

            for (var11 = 0; var11 < 128; ++var11) {
                var12 = 0;

                for (var13 = -var7; var13 < 256; ++var13) {
                    var14 = var13 * 128;
                    if (var7 + var13 < 256) {
                        var12 += this.anIntArray421[var7 * 128 + var14 + var11];
                    }

                    if (var13 - (var7 + 1) >= 0) {
                        var12 -= this.anIntArray421[var14 + var11 - (var7 + 1) * 128];
                    }

                    if (var13 >= 0) {
                        this.anIntArray411[var11 + var14] = var12 / (var7 * 2 + 1);
                    }
                }
            }
        }


    }

    final void method279(int var1) {
        int var2 = this.anIntArray423.length;
        if (this.anInt416 * 16 > 0) {
            this.method280(this.anInt416 * 16, this.anIntArray410);
        } else if (this.anInt408 * 16 > 0) {
            this.method280(this.anInt408 * 16, this.anIntArray409);
        } else {
            System.arraycopy(this.anIntArray414, 0, this.anIntArray423, 0, var2);
        }

        this.method275(var1);
    }

    final void method284(DoublyLinkedNode_Sub24_Sub4 var1) {
        int var2;
        for (var2 = 0; var2 < this.anIntArray420.length; ++var2) {
            this.anIntArray420[var2] = 0;
        }

        int var3;
        for (var2 = 0; var2 < 5000; ++var2) {
            var3 = (int) (Math.random() * 128.0D * 256.0D);
            this.anIntArray420[var3] = (int) (Math.random() * 256.0D);
        }

        int var4;
        int var5;
        for (var2 = 0; var2 < 20; ++var2) {
            for (var3 = 1; var3 < 255; ++var3) {
                for (var4 = 1; var4 < 127; ++var4) {
                    var5 = var4 + (var3 << 7);
                    this.anIntArray412[var5] = (this.anIntArray420[var5 + 1] + this.anIntArray420[var5 + 128] + this.anIntArray420[var5 - 128] + this.anIntArray420[var5 - 1]) / 4;
                }
            }

            int[] var8 = this.anIntArray420;
            this.anIntArray420 = this.anIntArray412;
            this.anIntArray412 = var8;
        }

        if (var1 != null) {
            var2 = 0;

            for (var3 = 0; var3 < var1.anInt377; ++var3) {
                for (var4 = 0; var4 < var1.anInt378; ++var4) {
                    if (var1.indices[var2++] != 0) {
                        var5 = var4 + var1.insetX + 16;
                        int var6 = var3 + var1.insetY + 16;
                        int var7 = var5 + (var6 << 7);
                        this.anIntArray420[var7] = 0;
                    }
                }
            }
        }

    }

    void method277() {
        this.anIntArray414 = null;
        this.anIntArray410 = null;
        this.anIntArray409 = null;
        this.anIntArray423 = null;
        this.anIntArray420 = null;
        this.anIntArray412 = null;
        this.anIntArray411 = null;
        this.anIntArray421 = null;
        this.anInt422 = 0;
    }

    void method283(int var1, int var2) {

        if (this.anIntArray411 == null) {
            this.method285();
        }

        if (this.anInt419 == 0) {
            this.anInt419 = var2;
        }

        int var3 = var2 - this.anInt419;
        if (var3 >= 256) {
            var3 = 0;
        }

        this.anInt419 = var2;
        if (var3 > 0) {
            this.method282(var3);
        }

        this.method279(var1);
    }
}
