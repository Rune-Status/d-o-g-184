package com.jagex;

public abstract class Class27 {
    static Buffer aBuffer314;
    public final SceneOffset aSceneOffset317;
    public final SceneOffset aSceneOffset313;
    int anInt315;
    int anInt316;

    Class27(SceneOffset var1, SceneOffset var2) {
        this.aSceneOffset317 = var1;
        this.aSceneOffset313 = var2;
    }

    public static int method202(byte[] var0, int var1, CharSequence var2) {
        int var3 = var2.length();
        int var4 = var1;

        for (int var5 = 0; var5 < var3; ++var5) {
            char var6 = var2.charAt(var5);
            if (var6 <= 127) {
                var0[var4++] = (byte) var6;
            } else if (var6 <= 2047) {
                var0[var4++] = (byte) (192 | var6 >> 6);
                var0[var4++] = (byte) (128 | var6 & '?');
            } else {
                var0[var4++] = (byte) (224 | var6 >> '\f');
                var0[var4++] = (byte) (128 | var6 >> 6 & 63);
                var0[var4++] = (byte) (128 | var6 & '?');
            }
        }

        return var4 - var1;
    }

    public static boolean method196(char var0) {
        return var0 >= '0' && var0 <= '9';
    }

    static Sprite[] method194() {
        Sprite[] var0 = new Sprite[Statics41.anInt1822];

        for (int var1 = 0; var1 < Statics41.anInt1822; ++var1) {
            Sprite var2 = var0[var1] = new Sprite();
            var2.anInt112 = Statics41.anInt1824;
            var2.anInt375 = DoublyLinkedNode_Sub6.anInt378;
            var2.anInt377 = Statics41.anIntArray1821[var1];
            var2.anInt574 = Node_Sub6_Sub4.anIntArray1107[var1];
            var2.width = Statics41.anIntArray1820[var1];
            var2.height = Jagception.anIntArray1878[var1];
            int var3 = var2.height * var2.width;
            byte[] var4 = OutgoingPacket.aByteArrayArray114[var1];
            var2.pixels = new int[var3];

            for (int var5 = 0; var5 < var3; ++var5) {
                var2.pixels[var5] = Statics41.anIntArray1823[var4[var5] & 255];
            }
        }

        Statics41.anIntArray1821 = null;
        Node_Sub6_Sub4.anIntArray1107 = null;
        Statics41.anIntArray1820 = null;
        Jagception.anIntArray1878 = null;
        Statics41.anIntArray1823 = null;
        OutgoingPacket.aByteArrayArray114 = null;
        return var0;
    }

    boolean method193(int var1, int var2) {
        if (!this.method195()) {
            return false;
        }
        DoublyLinkedNode_Sub15 var3 = Class98.method545(this.method199());
        int var4 = this.method198();
        int var5 = this.method197();
        switch (var3.anEnum_Sub9_1477.anInt633) {
            case 0:
                if (var1 >= this.anInt315 && var1 < var4 + this.anInt315) {
                    break;
                }

                return false;
            case 1:
                if (var1 > this.anInt315 - var4 && var1 <= this.anInt315) {
                    break;
                }

                return false;
            case 2:
                if (var1 < this.anInt315 - var4 / 2 || var1 > var4 / 2 + this.anInt315) {
                    return false;
                }
        }

        switch (var3.anEnum_Sub8_1472.anInt633) {
            case 0:
                if (var2 <= this.anInt316 - var5 || var2 > this.anInt316) {
                    return false;
                }
                break;
            case 1:
                if (var2 < this.anInt316 || var2 >= var5 + this.anInt316) {
                    return false;
                }
                break;
            case 2:
                if (var2 < this.anInt316 - var5 / 2 || var2 > var5 / 2 + this.anInt316) {
                    return false;
                }
        }

        return true;
    }

    abstract Class34 method201();

    boolean method195() {
        return this.method199() >= 0;
    }

    public abstract int method199();

    boolean method203(int var1, int var2) {
        Class34 var3 = this.method201();
        if (var3 == null) {
            return false;
        }
        if (var1 >= this.anInt315 - var3.anInt342 / 2 && var1 <= var3.anInt342 / 2 + this.anInt315) {
            return var2 >= this.anInt316 && var2 <= this.anInt316 + var3.anInt339;
        }
        return false;
    }

    abstract int method198();

    abstract int method197();

    boolean method200(int var1, int var2) {
        if (this.method193(var1, var2)) {
            return true;
        }
        return this.method203(var1, var2);
    }
}
