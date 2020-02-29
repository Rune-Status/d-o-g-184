package com.jagex;

public enum Enum_Sub11 implements EnumType {
    anEnum_Sub11_1862(0, 0),
    anEnum_Sub11_1863(1, 1),
    anEnum_Sub11_1861(2, 2);

    public final int anInt633;
    final int anInt619;

    Enum_Sub11(int var3, int var4) {
        this.anInt633 = var3;
        this.anInt619 = var4;
    }

    static Sprite method1336() {
        Sprite var0 = new Sprite();
        var0.anInt112 = Statics41.anInt1824;
        var0.anInt375 = DoublyLinkedNode_Sub6.anInt378;
        var0.anInt377 = Statics41.anIntArray1821[0];
        var0.anInt574 = Node_Sub6_Sub4.anIntArray1107[0];
        var0.width = Statics41.anIntArray1820[0];
        var0.height = Jagception.anIntArray1878[0];
        int var1 = var0.height * var0.width;
        byte[] var2 = OutgoingPacket.aByteArrayArray114[0];
        var0.pixels = new int[var1];

        for (int var3 = 0; var3 < var1; ++var3) {
            var0.pixels[var3] = Statics41.anIntArray1823[var2[var3] & 255];
        }

        Statics41.anIntArray1821 = null;
        Node_Sub6_Sub4.anIntArray1107 = null;
        Statics41.anIntArray1820 = null;
        Jagception.anIntArray1878 = null;
        Statics41.anIntArray1823 = null;
        OutgoingPacket.aByteArrayArray114 = null;
        return var0;
    }

    public static Enum_Sub11[] method449() {
        return new Enum_Sub11[]{anEnum_Sub11_1863, anEnum_Sub11_1862, anEnum_Sub11_1861};
    }

    public int getOrdinal() {
        return this.anInt619;
    }
}
