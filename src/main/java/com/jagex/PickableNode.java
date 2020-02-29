package com.jagex;

public final class PickableNode extends Entity {
    public static int anInt379;
    static Class78 aClass78_890;
    int id;
    int stackSize;

    PickableNode() {
    }

    static void method728(InterfaceComponent var0, int var1, int var2, boolean var3) {
        int var4 = var0.width;
        int var5 = var0.height;
        if (var0.anInt1369 == 0) {
            var0.width = var0.anInt694;
        } else if (var0.anInt1369 == 1) {
            var0.width = var1 - var0.anInt694;
        } else if (var0.anInt1369 == 2) {
            var0.width = var0.anInt694 * var1 >> 14;
        }

        if (var0.anInt695 == 0) {
            var0.height = var0.anInt1105;
        } else if (var0.anInt695 == 1) {
            var0.height = var2 - var0.anInt1105;
        } else if (var0.anInt695 == 2) {
            var0.height = var2 * var0.anInt1105 >> 14;
        }

        if (var0.anInt1369 == 4) {
            var0.width = var0.anInt711 * var0.height / var0.anInt709;
        }

        if (var0.anInt695 == 4) {
            var0.height = var0.anInt709 * var0.width / var0.anInt711;
        }

        if (var0.contentType == 1337) {
            client.anInterfaceComponent1055 = var0;
        }

        if (var3 && var0.anObjectArray1400 != null && (var4 != var0.width || var5 != var0.height)) {
            ScriptEvent var6 = new ScriptEvent();
            var6.source = var0;
            var6.args = var0.anObjectArray1400;
            client.aNodeDeque1082.add(var6);
        }

    }

    public static int method726(int var0) {
        int var1 = 0;
        if (var0 < 0 || var0 >= 65536) {
            var0 >>>= 16;
            var1 += 16;
        }

        if (var0 >= 256) {
            var0 >>>= 8;
            var1 += 8;
        }

        if (var0 >= 16) {
            var0 >>>= 4;
            var1 += 4;
        }

        if (var0 >= 4) {
            var0 >>>= 2;
            var1 += 2;
        }

        if (var0 >= 1) {
            var0 >>>= 1;
            ++var1;
        }

        return var0 + var1;
    }

    public static boolean method725(char var0) {
        if (var0 >= ' ' && var0 <= '~') {
            return true;
        }
        if (var0 >= 160 && var0 <= 255) {
            return true;
        }
        return var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376;
    }

    protected final Model getModel() {
        return CameraCapture.getItemDefinition(this.id).getModel(this.stackSize);
    }
}
