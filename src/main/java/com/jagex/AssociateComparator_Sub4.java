package com.jagex;

public class AssociateComparator_Sub4 extends AssociateComparator {
    static boolean aBoolean804;
    static int anInt803;
    final boolean aBoolean764;

    public AssociateComparator_Sub4(boolean var1) {
        this.aBoolean764 = var1;
    }

    public static DoublyLinkedNode_Sub11 method664(int var0) {
        DoublyLinkedNode_Sub11 var1 = (DoublyLinkedNode_Sub11) DoublyLinkedNode_Sub11.aReferenceCache385.get((long) var0);
        if (var1 != null) {
            return var1;
        }
        byte[] var2 = DoublyLinkedNode_Sub11.aReferenceTable383.unpack(8, var0);
        var1 = new DoublyLinkedNode_Sub11();
        if (var2 != null) {
            var1.method990(new Buffer(var2));
        }

        DoublyLinkedNode_Sub11.aReferenceCache385.put(var1, (long) var0);
        return var1;
    }

    int method604(Associate var1, Associate var2) {
        if (client.currentWorld == var1.world && var2.world == client.currentWorld) {
            return this.aBoolean764 ? var1.anInt1222 - var2.anInt1222 : var2.anInt1222 - var1.anInt1222;
        }
        return this.method1135(var1, var2);
    }

    public int compare(Associate var1, Associate var2) {
        return this.method604(var1, var2);
    }
}
