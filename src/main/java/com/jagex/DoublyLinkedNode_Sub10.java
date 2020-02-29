package com.jagex;

public class DoublyLinkedNode_Sub10 extends DoublyLinkedNode {
    public final int[] anIntArray1108;
    public final int anInt380;
    public final int anInt568;
    public final int[] anIntArray749;

    DoublyLinkedNode_Sub10(int var1, int var2, int[] var3, int[] var4) {
        this.anInt380 = var1;
        this.anInt568 = var2;
        this.anIntArray749 = var3;
        this.anIntArray1108 = var4;
    }

    public boolean method983(int var1, int var2) {
        if (var2 >= 0 && var2 < this.anIntArray1108.length) {
            int var3 = this.anIntArray1108[var2];
            return var1 >= var3 && var1 <= var3 + this.anIntArray749[var2];
        }

        return false;
    }
}
