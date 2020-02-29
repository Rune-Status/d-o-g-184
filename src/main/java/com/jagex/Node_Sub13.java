package com.jagex;

public class Node_Sub13 extends Node {
    static DoublyLinkedNode_Sub24_Sub4 aDoublyNode_Sub24_Sub4_811;
    int anInt380;
    int anInt568;
    int[] anIntArray749;
    int[][] anIntArrayArray810;

    Node_Sub13(int var1, byte[] var2) {
        this.anInt380 = var1;
        Buffer var3 = new Buffer(var2);
        this.anInt568 = var3.readUByte();
        this.anIntArray749 = new int[this.anInt568];
        this.anIntArrayArray810 = new int[this.anInt568][];

        int var4;
        for (var4 = 0; var4 < this.anInt568; ++var4) {
            this.anIntArray749[var4] = var3.readUByte();
        }

        for (var4 = 0; var4 < this.anInt568; ++var4) {
            this.anIntArrayArray810[var4] = new int[var3.readUByte()];
        }

        for (var4 = 0; var4 < this.anInt568; ++var4) {
            for (int var5 = 0; var5 < this.anIntArrayArray810[var4].length; ++var5) {
                this.anIntArrayArray810[var4][var5] = var3.readUByte();
            }
        }

    }
}
