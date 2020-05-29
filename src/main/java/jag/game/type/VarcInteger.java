package jag.game.type;

import jag.commons.collection.DoublyLinkedNode;
import jag.commons.collection.ReferenceCache;
import jag.js5.Archive;
import jag.js5.ReferenceTable;
import jag.opcode.Buffer;

public class VarcInteger extends DoublyLinkedNode {

    public static final ReferenceCache aReferenceCache385;
    public static ReferenceTable aReferenceTable383;
    public static Archive aArchive1506;

    static {
        aReferenceCache385 = new ReferenceCache(64);
    }

    public boolean aBoolean790;

    public VarcInteger() {
        this.aBoolean790 = false;
    }

    void decode(int var2) {
        if (var2 == 2) {
            this.aBoolean790 = true;
        }

    }

    public void decode(Buffer var1) {
        while (true) {
            int var2 = var1.readUByte();
            if (var2 == 0) {
                return;
            }

            this.decode(var2);
        }
    }
}
