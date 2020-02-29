package com.jagex;

import java.awt.*;
import java.awt.image.*;
import java.util.Hashtable;

public final class GraphicsProvider extends Class216 {
    Image image;
    Component aComponent111;

    GraphicsProvider(int var1, int var2, Component var3) {
        super.anInt1817 = var1;
        super.anInt1816 = var2;
        super.anIntArray1818 = new int[var2 * var1 + 1];
        DataBufferInt var4 = new DataBufferInt(super.anIntArray1818, super.anIntArray1818.length);
        DirectColorModel var5 = new DirectColorModel(32, 16711680, 65280, 255);
        WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.anInt1817, super.anInt1816), var4, null);
        this.image = new BufferedImage(var5, var6, false, new Hashtable());
        this.method21(var3);
        this.method1318();
    }

    final void method19(Graphics var1, int var2, int var3, int var4, int var5) {
        try {
            Shape var6 = var1.getClip();
            var1.clipRect(var2, var3, var4, var5);
            var1.drawImage(this.image, 0, 0, this.aComponent111);
            var1.setClip(var6);
        } catch (Exception var7) {
            this.aComponent111.repaint();
        }

    }

    final void drawGame(Graphics var1, int var2, int var3) {
        try {
            var1.drawImage(this.image, var2, var3, this.aComponent111);
        } catch (Exception var6) {
            this.aComponent111.repaint();
        }

    }

    final void method21(Component var1) {
        this.aComponent111 = var1;
    }

    public final void method22(int var1, int var2) {
        this.drawGame(this.aComponent111.getGraphics(), var1, var2);
    }

    public final void method20(int var1, int var2, int var3, int var4) {
        this.method19(this.aComponent111.getGraphics(), var1, var2, var3, var4);
    }
}
