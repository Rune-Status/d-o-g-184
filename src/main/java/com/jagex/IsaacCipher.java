package com.jagex;

public final class IsaacCipher {
    int anInt1991;
    int anInt1989;
    int anInt1990;
    int[] anIntArray1986;
    int[] anIntArray1988;
    int anInt1987;

    public IsaacCipher(int[] var1) {
        this.anIntArray1986 = new int[256];
        this.anIntArray1988 = new int[256];

        System.arraycopy(var1, 0, this.anIntArray1988, 0, var1.length);

        this.method1493();
    }

    final void method1494() {
        this.anInt1991 += ++this.anInt1990;

        for (int var1 = 0; var1 < 256; ++var1) {
            int var2 = this.anIntArray1986[var1];
            if ((var1 & 2) == 0) {
                if ((var1 & 1) == 0) {
                    this.anInt1987 ^= this.anInt1987 << 13;
                } else {
                    this.anInt1987 ^= this.anInt1987 >>> 6;
                }
            } else if ((var1 & 1) == 0) {
                this.anInt1987 ^= this.anInt1987 << 2;
            } else {
                this.anInt1987 ^= this.anInt1987 >>> 16;
            }

            this.anInt1987 += this.anIntArray1986[128 + var1 & 255];
            int var3;
            this.anIntArray1986[var1] = var3 = this.anIntArray1986[(var2 & 1020) >> 2] + this.anInt1991 + this.anInt1987;
            this.anIntArray1988[var1] = this.anInt1991 = this.anIntArray1986[(var3 >> 8 & 1020) >> 2] + var2;
        }

    }

    final void method1493() {
        int var1 = -1640531527;
        int var2 = -1640531527;
        int var3 = -1640531527;
        int var4 = -1640531527;
        int var5 = -1640531527;
        int var6 = -1640531527;
        int var7 = -1640531527;
        int var8 = -1640531527;

        int var9;
        for (var9 = 0; var9 < 4; ++var9) {
            var8 ^= var7 << 11;
            var5 += var8;
            var7 += var6;
            var7 ^= var6 >>> 2;
            var4 += var7;
            var6 += var5;
            var6 ^= var5 << 8;
            var3 += var6;
            var5 += var4;
            var5 ^= var4 >>> 16;
            var2 += var5;
            var4 += var3;
            var4 ^= var3 << 10;
            var1 += var4;
            var3 += var2;
            var3 ^= var2 >>> 4;
            var8 += var3;
            var2 += var1;
            var2 ^= var1 << 8;
            var7 += var2;
            var1 += var8;
            var1 ^= var8 >>> 9;
            var6 += var1;
            var8 += var7;
        }

        for (var9 = 0; var9 < 256; var9 += 8) {
            var8 += this.anIntArray1988[var9];
            var7 += this.anIntArray1988[var9 + 1];
            var6 += this.anIntArray1988[var9 + 2];
            var5 += this.anIntArray1988[var9 + 3];
            var4 += this.anIntArray1988[var9 + 4];
            var3 += this.anIntArray1988[var9 + 5];
            var2 += this.anIntArray1988[var9 + 6];
            var1 += this.anIntArray1988[var9 + 7];
            var8 ^= var7 << 11;
            var5 += var8;
            var7 += var6;
            var7 ^= var6 >>> 2;
            var4 += var7;
            var6 += var5;
            var6 ^= var5 << 8;
            var3 += var6;
            var5 += var4;
            var5 ^= var4 >>> 16;
            var2 += var5;
            var4 += var3;
            var4 ^= var3 << 10;
            var1 += var4;
            var3 += var2;
            var3 ^= var2 >>> 4;
            var8 += var3;
            var2 += var1;
            var2 ^= var1 << 8;
            var7 += var2;
            var1 += var8;
            var1 ^= var8 >>> 9;
            var6 += var1;
            var8 += var7;
            this.anIntArray1986[var9] = var8;
            this.anIntArray1986[var9 + 1] = var7;
            this.anIntArray1986[var9 + 2] = var6;
            this.anIntArray1986[var9 + 3] = var5;
            this.anIntArray1986[var9 + 4] = var4;
            this.anIntArray1986[var9 + 5] = var3;
            this.anIntArray1986[var9 + 6] = var2;
            this.anIntArray1986[var9 + 7] = var1;
        }

        for (var9 = 0; var9 < 256; var9 += 8) {
            var8 += this.anIntArray1986[var9];
            var7 += this.anIntArray1986[var9 + 1];
            var6 += this.anIntArray1986[var9 + 2];
            var5 += this.anIntArray1986[var9 + 3];
            var4 += this.anIntArray1986[var9 + 4];
            var3 += this.anIntArray1986[var9 + 5];
            var2 += this.anIntArray1986[var9 + 6];
            var1 += this.anIntArray1986[var9 + 7];
            var8 ^= var7 << 11;
            var5 += var8;
            var7 += var6;
            var7 ^= var6 >>> 2;
            var4 += var7;
            var6 += var5;
            var6 ^= var5 << 8;
            var3 += var6;
            var5 += var4;
            var5 ^= var4 >>> 16;
            var2 += var5;
            var4 += var3;
            var4 ^= var3 << 10;
            var1 += var4;
            var3 += var2;
            var3 ^= var2 >>> 4;
            var8 += var3;
            var2 += var1;
            var2 ^= var1 << 8;
            var7 += var2;
            var1 += var8;
            var1 ^= var8 >>> 9;
            var6 += var1;
            var8 += var7;
            this.anIntArray1986[var9] = var8;
            this.anIntArray1986[var9 + 1] = var7;
            this.anIntArray1986[var9 + 2] = var6;
            this.anIntArray1986[var9 + 3] = var5;
            this.anIntArray1986[var9 + 4] = var4;
            this.anIntArray1986[var9 + 5] = var3;
            this.anIntArray1986[var9 + 6] = var2;
            this.anIntArray1986[var9 + 7] = var1;
        }

        this.method1494();
        this.anInt1989 = 256;
    }

    public final int pop() {
        if (this.anInt1989 == 0) {
            this.method1494();
            this.anInt1989 = 256;
        }

        return this.anIntArray1988[--this.anInt1989];
    }

    public final int peek() {
        if (this.anInt1989 == 0) {
            this.method1494();
            this.anInt1989 = 256;
        }

        return this.anIntArray1988[this.anInt1989 - 1];
    }
}
