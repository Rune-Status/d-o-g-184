package com.jagex;

public class DoublyLinkedNode_Sub16 extends DoublyLinkedNode {

    public static ReferenceTable aReferenceTable383;
    public static int anInt568;
    static ReferenceCache aReferenceCache701;

    static {
        aReferenceCache701 = new ReferenceCache(64);
    }

    public int anInt377;

    DoublyLinkedNode_Sub16() {
        this.anInt377 = 0;
    }

    void method988(Buffer var1, int var2) {
        if (var2 == 5) {
            this.anInt377 = var1.readUShort();
        }

    }

    void method990(Buffer var1) {
        while (true) {
            int var2 = var1.readUByte();
            if (var2 == 0) {
                return;
            }

            this.method988(var1, var2);
        }
    }
}
