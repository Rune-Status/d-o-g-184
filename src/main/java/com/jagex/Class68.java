package com.jagex;

public final class Class68 {
    // $FF: synthetic field
    final Class19 this$0;
    int anInt538;
    int anInt539;
    int anInt537;
    int anInt540;

    Class68(Class19 var1) {
        this.this$0 = var1;
    }

    public static DoublyLinkedNode_Sub24_Sub4 method375(ReferenceTable var0, String var1, String var2) {
        int var3 = var0.method900(var1);
        int var4 = var0.method907(var3, var2);
        DoublyLinkedNode_Sub24_Sub4 var5;
        if (!Class96.method534(var0, var3, var4)) {
            var5 = null;
        } else {
            DoublyLinkedNode_Sub24_Sub4 var6 = new DoublyLinkedNode_Sub24_Sub4();
            var6.anInt375 = Statics41.anInt1824;
            var6.anInt372 = DoublyLinkedNode_Sub6.anInt378;
            var6.insetX = Statics41.anIntArray1821[0];
            var6.insetY = Node_Sub6_Sub4.anIntArray1107[0];
            var6.anInt378 = Statics41.anIntArray1820[0];
            var6.anInt377 = Jagception.anIntArray1878[0];
            var6.palette = Statics41.anIntArray1823;
            var6.indices = OutgoingPacket.aByteArrayArray114[0];
            Statics41.anIntArray1821 = null;
            Node_Sub6_Sub4.anIntArray1107 = null;
            Statics41.anIntArray1820 = null;
            Jagception.anIntArray1878 = null;
            Statics41.anIntArray1823 = null;
            OutgoingPacket.aByteArrayArray114 = null;
            var5 = var6;
        }

        return var5;
    }
}
