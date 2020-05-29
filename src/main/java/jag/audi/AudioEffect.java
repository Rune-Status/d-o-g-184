package jag.audi;

import jag.audi.vorbis.Vorbis8;
import jag.js5.ReferenceTable;
import jag.opcode.Buffer;

public class AudioEffect {
    public final AudioInstrument[] instruments;
    public int start;
    public int end;

    public AudioEffect(Buffer var1) {
        this.instruments = new AudioInstrument[10];

        for (int var2 = 0; var2 < 10; ++var2) {
            int var3 = var1.readUByte();
            if (var3 != 0) {
                --var1.caret;
                this.instruments[var2] = new AudioInstrument();
                this.instruments[var2].method1298(var1);
            }
        }

        this.start = var1.readUShort();
        this.end = var1.readUShort();
    }

    public static AudioEffect load(ReferenceTable var0, int var1, int var2) {
        byte[] var3 = var0.unpack(var1, var2);
        return var3 == null ? null : new AudioEffect(new Buffer(var3));
    }

    public final byte[] method1520() {
        int var1 = 0;

        int var2;
        for (var2 = 0; var2 < 10; ++var2) {
            if (this.instruments[var2] != null && this.instruments[var2].anInt1790 + this.instruments[var2].anInt1787 > var1) {
                var1 = this.instruments[var2].anInt1790 + this.instruments[var2].anInt1787;
            }
        }

        if (var1 == 0) {
            return new byte[0];
        }
        var2 = var1 * 22050 / 1000;
        byte[] var3 = new byte[var2];

        for (int var4 = 0; var4 < 10; ++var4) {
            if (this.instruments[var4] != null) {
                int var5 = this.instruments[var4].anInt1790 * 22050 / 1000;
                int var6 = this.instruments[var4].anInt1787 * 22050 / 1000;
                int[] var7 = this.instruments[var4].method1299(var5, this.instruments[var4].anInt1790);

                for (int var8 = 0; var8 < var5; ++var8) {
                    int var9 = (var7[var8] >> 8) + var3[var8 + var6];
                    if ((var9 + 128 & -256) != 0) {
                        var9 = var9 >> 31 ^ 127;
                    }

                    var3[var8 + var6] = (byte) var9;
                }
            }
        }

        return var3;
    }

    public Vorbis8 method1523() {
        byte[] var1 = this.method1520();
        return new Vorbis8(var1, this.start * 22050 / 1000, this.end * 22050 / 1000);
    }

    public final int method1521() {
        int var1 = 9999999;

        int var2;
        for (var2 = 0; var2 < 10; ++var2) {
            if (this.instruments[var2] != null && this.instruments[var2].anInt1787 / 20 < var1) {
                var1 = this.instruments[var2].anInt1787 / 20;
            }
        }

        if (this.start < this.end && this.start / 20 < var1) {
            var1 = this.start / 20;
        }

        if (var1 != 9999999 && var1 != 0) {
            for (var2 = 0; var2 < 10; ++var2) {
                if (this.instruments[var2] != null) {
                    AudioInstrument var10000 = this.instruments[var2];
                    var10000.anInt1787 -= var1 * 20;
                }
            }

            if (this.start < this.end) {
                this.start -= var1 * 20;
                this.end -= var1 * 20;
            }

            return var1;
        }
        return 0;
    }
}
