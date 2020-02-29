package com.jagex;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class AudioSystemImpl extends AudioSystem {
    AudioFormat format;
    int bufferSize;
    SourceDataLine sourceDataLine;
    byte[] buffer;

    AudioSystemImpl() {
    }

    protected void method1085() {
        this.sourceDataLine.flush();
    }

    protected void method1086() {
        if (this.sourceDataLine != null) {
            this.sourceDataLine.close();
            this.sourceDataLine = null;
        }

    }

    protected int method1088() {
        return this.bufferSize - (this.sourceDataLine.available() >> (AudioSystem.aBoolean1841 ? 2 : 1));
    }

    protected void method1090(int var1) throws LineUnavailableException {
        try {
            Info var2 = new Info(SourceDataLine.class, this.format, var1 << (AudioSystem.aBoolean1841 ? 2 : 1));
            this.sourceDataLine = (SourceDataLine) javax.sound.sampled.AudioSystem.getLine(var2);
            this.sourceDataLine.open();
            this.sourceDataLine.start();
            this.bufferSize = var1;
        } catch (LineUnavailableException var5) {
            int var3 = (var1 >>> 1 & 1431655765) + (var1 & 1431655765);
            var3 = (var3 >>> 2 & 858993459) + (var3 & 858993459);
            var3 = (var3 >>> 4) + var3 & 252645135;
            var3 += var3 >>> 8;
            var3 += var3 >>> 16;
            int var4 = var3 & 255;
            if (var4 != 1) {
                this.method1090(Class180.nextPowerOfTwo(var1));
            } else {
                this.sourceDataLine = null;
                throw var5;
            }
        }
    }

    protected void method1087() {
        int var1 = 256;
        if (AudioSystem.aBoolean1841) {
            var1 <<= 1;
        }

        for (int var2 = 0; var2 < var1; ++var2) {
            int var3 = super.samples[var2];
            if ((var3 + 8388608 & -16777216) != 0) {
                var3 = 8388607 ^ var3 >> 31;
            }

            this.buffer[var2 * 2] = (byte) (var3 >> 8);
            this.buffer[var2 * 2 + 1] = (byte) (var3 >> 16);
        }

        this.sourceDataLine.write(this.buffer, 0, var1 << 1);
    }

    protected void method1089() {
        this.format = new AudioFormat((float) Class105.anInt775, 16, AudioSystem.aBoolean1841 ? 2 : 1, true, false);
        this.buffer = new byte[256 << (AudioSystem.aBoolean1841 ? 2 : 1)];
    }
}
