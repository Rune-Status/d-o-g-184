package com.jagex;

import java.util.zip.Inflater;

public class GzipDecompressor {

    Inflater inflater;

    public GzipDecompressor() {
    }

    public void method1326(Buffer var1, byte[] var2) {
        if (var1.payload[var1.caret] == 31 && var1.payload[var1.caret + 1] == -117) {
            if (this.inflater == null) {
                this.inflater = new Inflater(true);
            }

            try {
                this.inflater.setInput(var1.payload, var1.caret + 10, var1.payload.length - (var1.caret + 8 + 10));
                this.inflater.inflate(var2);
            } catch (Exception var4) {
                this.inflater.reset();
                throw new RuntimeException("");
            }

            this.inflater.reset();
        } else {
            throw new RuntimeException("");
        }
    }
}
