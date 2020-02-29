package com.jagex;

public class AssociateComparatorByWorldAndName extends AssociateComparator {
    final boolean aBoolean764;

    public AssociateComparatorByWorldAndName(boolean var1) {
        this.aBoolean764 = var1;
    }

    public static DoublyLinkedNode_Sub20 method644(int var0) {
        DoublyLinkedNode_Sub20 var1 = (DoublyLinkedNode_Sub20) DoublyLinkedNode_Sub20.aReferenceCache385.get((long) var0);
        if (var1 != null) {
            return var1;
        }
        byte[] var2 = DoublyLinkedNode_Sub20.aReferenceTable383.unpack(1, var0);
        var1 = new DoublyLinkedNode_Sub20();
        if (var2 != null) {
            var1.method988(new Buffer(var2));
        }

        var1.method254();
        DoublyLinkedNode_Sub20.aReferenceCache385.put(var1, (long) var0);
        return var1;
    }

    int method604(Associate var1, Associate var2) {
        if (client.currentWorld == var1.world && var2.world == client.currentWorld) {
            return this.aBoolean764 ? var1.getDisplayName().compare0(var2.getDisplayName()) : var2.getDisplayName().compare0(var1.getDisplayName());
        }
        return this.method1135(var1, var2);
    }

    public int compare(Associate var1, Associate var2) {
        return this.method604((Associate) var1, (Associate) var2);
    }
}
