package com.jagex;

public class AudioEnvelope {
    int ticks;
    int max;
    int anInt2028;
    int anInt2027;
    int phaseIndex;
    int[] anIntArray2029;
    int[] phases;
    int amplitude;
    int step;
    int start;
    int end;

    AudioEnvelope() {
        this.anInt2028 = 2;
        this.anIntArray2029 = new int[2];
        this.phases = new int[2];
        this.anIntArray2029[0] = 0;
        this.anIntArray2029[1] = 65535;
        this.phases[0] = 0;
        this.phases[1] = 65535;
    }

    final void method1511(Buffer var1) {
        this.anInt2027 = var1.readUByte();
        this.start = var1.readInt();
        this.end = var1.readInt();
        this.method1512(var1);
    }

    final void method1510() {
        this.ticks = 0;
        this.phaseIndex = 0;
        this.step = 0;
        this.amplitude = 0;
        this.max = 0;
    }

    final void method1512(Buffer var1) {
        this.anInt2028 = var1.readUByte();
        this.anIntArray2029 = new int[this.anInt2028];
        this.phases = new int[this.anInt2028];

        for (int var2 = 0; var2 < this.anInt2028; ++var2) {
            this.anIntArray2029[var2] = var1.readUShort();
            this.phases[var2] = var1.readUShort();
        }

    }

    final int method1509(int var1) {
        if (this.max >= this.ticks) {
            this.amplitude = this.phases[this.phaseIndex++] << 15;
            if (this.phaseIndex >= this.anInt2028) {
                this.phaseIndex = this.anInt2028 - 1;
            }

            this.ticks = (int) ((double) this.anIntArray2029[this.phaseIndex] / 65536.0D * (double) var1);
            if (this.ticks > this.max) {
                this.step = ((this.phases[this.phaseIndex] << 15) - this.amplitude) / (this.ticks - this.max);
            }
        }

        this.amplitude += this.step;
        ++this.max;
        return this.amplitude - this.step >> 15;
    }
}
