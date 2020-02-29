package com.jagex;

public class DoublyLinkedNode_Sub18 extends DoublyLinkedNode {

    public static ReferenceCache aReferenceCache385;
    public static ReferenceTable aReferenceTable383;
    static CacheReferenceTable aCacheReferenceTable1506;

    static {
        aReferenceCache385 = new ReferenceCache(64);
    }

    public boolean aBoolean790;

    public DoublyLinkedNode_Sub18() {
        this.aBoolean790 = false;
    }

    void method1010(int var2) {
        if (var2 == 2) {
            this.aBoolean790 = true;
        }

    }

    public void method1098(Buffer var1) {
        while (true) {
            int var2 = var1.readUByte();
            if (var2 == 0) {
                return;
            }

            this.method1010(var2);
        }
    }
}
