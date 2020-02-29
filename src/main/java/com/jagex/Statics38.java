package com.jagex;

public class Statics38 {
    public static DoublyLinkedNode_Sub24_Sub4[] method1194(ReferenceTable var0, int var1, int var2) {
        if (!Class96.method534(var0, var1, var2)) {
            return null;
        }
        DoublyLinkedNode_Sub24_Sub4[] var3 = new DoublyLinkedNode_Sub24_Sub4[Statics41.anInt1822];

        for (int var4 = 0; var4 < Statics41.anInt1822; ++var4) {
            DoublyLinkedNode_Sub24_Sub4 var5 = var3[var4] = new DoublyLinkedNode_Sub24_Sub4();
            var5.anInt375 = Statics41.anInt1824;
            var5.anInt372 = DoublyLinkedNode_Sub6.anInt378;
            var5.insetX = Statics41.anIntArray1821[var4];
            var5.insetY = Node_Sub6_Sub4.anIntArray1107[var4];
            var5.anInt378 = Statics41.anIntArray1820[var4];
            var5.anInt377 = Jagception.anIntArray1878[var4];
            var5.palette = Statics41.anIntArray1823;
            var5.indices = OutgoingPacket.aByteArrayArray114[var4];
        }

        Statics41.anIntArray1821 = null;
        Node_Sub6_Sub4.anIntArray1107 = null;
        Statics41.anIntArray1820 = null;
        Jagception.anIntArray1878 = null;
        Statics41.anIntArray1823 = null;
        OutgoingPacket.aByteArrayArray114 = null;
        return var3;
    }
}
