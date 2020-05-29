package jag.game.type;

import jag.commons.collection.Node;
import jag.graphics.IndexedSprite;
import jag.opcode.Buffer;

public class AnimationFrame extends Node {

    public static IndexedSprite aDoublyNode_Sub24_Sub4_811;
    public final int anInt380;
    public final int anInt568;
    public final int[] anIntArray749;
    public final int[][] anIntArrayArray810;

    AnimationFrame(int var1, byte[] var2) {
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
