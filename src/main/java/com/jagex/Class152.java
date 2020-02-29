package com.jagex;

public abstract class Class152 {
    Class152() {
    }

    static void method867(int var0, int var1, int var2, int var3, boolean var4) {
        if (var2 < 1) {
            var2 = 1;
        }

        if (var3 < 1) {
            var3 = 1;
        }

        int var5 = var3 - 334;
        int var6;
        if (var5 < 0) {
            var6 = client.aShort922;
        } else if (var5 >= 100) {
            var6 = client.aShort912;
        } else {
            var6 = (client.aShort912 - client.aShort922) * var5 / 100 + client.aShort922;
        }

        int var7 = var3 * var6 * 512 / (var2 * 334);
        int var8;
        int var9;
        short var10;
        if (var7 < client.aShort910) {
            var10 = client.aShort910;
            var6 = var10 * var2 * 334 / (var3 * 512);
            if (var6 > client.aShort907) {
                var6 = client.aShort907;
                var8 = var3 * var6 * 512 / (var10 * 334);
                var9 = (var2 - var8) / 2;
                if (var4) {
                    JagGraphics.resetDrawingArea();
                    JagGraphics.fillRect(var0, var1, var9, var3, -16777216);
                    JagGraphics.fillRect(var0 + var2 - var9, var1, var9, var3, -16777216);
                }

                var0 += var9;
                var2 -= var9 * 2;
            }
        } else if (var7 > client.aShort921) {
            var10 = client.aShort921;
            var6 = var10 * var2 * 334 / (var3 * 512);
            if (var6 < client.aShort915) {
                var6 = client.aShort915;
                var8 = var10 * var2 * 334 / (var6 * 512);
                var9 = (var3 - var8) / 2;
                if (var4) {
                    JagGraphics.resetDrawingArea();
                    JagGraphics.fillRect(var0, var1, var2, var9, -16777216);
                    JagGraphics.fillRect(var0, var3 + var1 - var9, var2, var9, -16777216);
                }

                var1 += var9;
                var3 -= var9 * 2;
            }
        }

        client.viewportScale = var3 * var6 / 334;
        if (var2 != client.viewportWidth || var3 != client.viewportHeight) {
            Class88.method480(var2, var3);
        }

        client.anInt909 = var0;
        client.anInt908 = var1;
        client.viewportWidth = var2;
        client.viewportHeight = var3;
    }

    static World method866() {
        return World.anInt1872 < World.anInt1871 ? World.worlds[++World.anInt1872 - 1] : null;
    }

    abstract byte[] method802();

    abstract void method801(byte[] var1);
}
