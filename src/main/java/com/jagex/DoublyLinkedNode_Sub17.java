package com.jagex;

public class DoublyLinkedNode_Sub17 extends DoublyLinkedNode {
    public static ReferenceCache aReferenceCache385;
    public static ReferenceTable aReferenceTable383;
    static Sprite[] prayerIconSprites;

    static {
        aReferenceCache385 = new ReferenceCache(64);
    }

    IterableNodeTable aIterableNodeTable1504;

    DoublyLinkedNode_Sub17() {
    }

    void method259(Buffer var1, int var2) {
        if (var2 == 249) {
            this.aIterableNodeTable1504 = AssociateComparator_Sub5.method676(var1, this.aIterableNodeTable1504);
        }

    }

    public String method1096(int var1, String var2) {
        return IterableNodeTable.getStringParameter(this.aIterableNodeTable1504, var1, var2);
    }

    public int method1097(int var1, int var2) {
        return HealthBar.method696(this.aIterableNodeTable1504, var1, var2);
    }

    void method254() {
    }

    void method260(Buffer var1) {
        while (true) {
            int var2 = var1.readUByte();
            if (var2 == 0) {
                return;
            }

            this.method259(var1, var2);
        }
    }
}
