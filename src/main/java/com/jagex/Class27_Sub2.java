package com.jagex;

public class Class27_Sub2 extends Class27 {
    static DoublyLinkedNode_Sub24_Sub4 aDoublyNode_Sub24_Sub4_650;
    static short[] grandExchangeSearchResults;
    final Class34 aClass34_652;
    final int anInt490;
    final int anInt651;
    final int anInt491;

    Class27_Sub2(SceneOffset var1, SceneOffset var2, int var3, Class34 var4) {
        super(var1, var2);
        this.anInt491 = var3;
        this.aClass34_652 = var4;
        DoublyLinkedNode_Sub15 var5 = Class98.method545(this.method199());
        Sprite var6 = var5.method1083();
        if (var6 != null) {
            this.anInt490 = var6.width;
            this.anInt651 = var6.height;
        } else {
            this.anInt490 = 0;
            this.anInt651 = 0;
        }

    }

    public static DoublyLinkedNode_Sub24_Sub4[] method474(ReferenceTable var0, String var1, String var2) {
        int var3 = var0.method900(var1);
        int var4 = var0.method907(var3, var2);
        return Statics38.method1194(var0, var3, var4);
    }

    static void method475(InterfaceComponent var0) {
        int var1 = var0.contentType;
        if (var1 == 324) {
            if (client.anInt930 == -1) {
                client.anInt930 = var0.materialId;
                client.anInt931 = var0.enabledMaterialId;
            }

            if (client.aPlayerAppearance924.female) {
                var0.materialId = client.anInt930;
            } else {
                var0.materialId = client.anInt931;
            }

        } else if (var1 == 325) {
            if (client.anInt930 == -1) {
                client.anInt930 = var0.materialId;
                client.anInt931 = var0.enabledMaterialId;
            }

            if (client.aPlayerAppearance924.female) {
                var0.materialId = client.anInt931;
            } else {
                var0.materialId = client.anInt930;
            }

        } else if (var1 == 327) {
            var0.xRotation = 150;
            var0.zRotation = (int) (Math.sin((double) client.engineCycle / 40.0D) * 256.0D) & 2047;
            var0.modelType = 5;
            var0.modelId = 0;
        } else if (var1 == 328) {
            var0.xRotation = 150;
            var0.zRotation = (int) (Math.sin((double) client.engineCycle / 40.0D) * 256.0D) & 2047;
            var0.modelType = 5;
            var0.modelId = 1;
        }
    }

    Class34 method201() {
        return this.aClass34_652;
    }

    public int method199() {
        return this.anInt491;
    }

    int method198() {
        return this.anInt490;
    }

    int method197() {
        return this.anInt651;
    }
}
