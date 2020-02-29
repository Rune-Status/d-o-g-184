package com.jagex;

public class Class25 {
    static DoublyLinkedNode_Sub7 aDoublyNode_Sub7_303;
    static CacheReferenceTable aCacheReferenceTable304;
    public int anInt306;
    public SceneOffset aSceneOffset307;
    public SceneOffset aSceneOffset305;

    public Class25(int var1, SceneOffset var2, SceneOffset var3) {
        this.anInt306 = var1;
        this.aSceneOffset307 = var2;
        this.aSceneOffset305 = var3;
    }

    public static char method186(byte var0) {
        int var1 = var0 & 255;
        if (var1 == 0) {
            throw new IllegalArgumentException("" + Integer.toString(var1, 16));
        }
        if (var1 >= 128 && var1 < 160) {
            char var2 = Statics35.aCharArray1616[var1 - 128];
            if (var2 == 0) {
                var2 = '?';
            }

            var1 = var2;
        }

        return (char) var1;
    }

    static int method187(int var0, int var1) {
        if (var0 == -2) {
            return 12345678;
        }
        if (var0 == -1) {
            if (var1 < 2) {
                var1 = 2;
            } else if (var1 > 126) {
                var1 = 126;
            }

            return var1;
        }
        var1 = (var0 & 127) * var1 / 128;
        if (var1 < 2) {
            var1 = 2;
        } else if (var1 > 126) {
            var1 = 126;
        }

        return (var0 & 65408) + var1;
    }
}
