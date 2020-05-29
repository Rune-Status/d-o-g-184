package jag.game.type;

import jag.commons.collection.DoublyLinkedNode;
import jag.commons.collection.ReferenceCache;
import jag.js5.ReferenceTable;
import jag.opcode.Buffer;

public class VarDefinition extends DoublyLinkedNode {

    public static final ReferenceCache aReferenceCache701;
    public static ReferenceTable aReferenceTable383;
    public static int anInt568;

    static {
        aReferenceCache701 = new ReferenceCache(64);
    }

    public int anInt377;

    public VarDefinition() {
        this.anInt377 = 0;
    }

    void decode(Buffer var1, int var2) {
        if (var2 == 5) {
            this.anInt377 = var1.readUShort();
        }

    }

    public void decode(Buffer var1) {
        while (true) {
            int var2 = var1.readUByte();
            if (var2 == 0) {
                return;
            }

            this.decode(var1, var2);
        }
    }
}
