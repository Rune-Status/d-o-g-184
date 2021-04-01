package jag.game.type;

import jag.commons.collection.DoublyLinkedNode;
import jag.commons.collection.ReferenceCache;
import jag.js5.ReferenceTable;
import jag.opcode.Buffer;

public class VarcInteger extends DoublyLinkedNode {

    public static final ReferenceCache<VarcInteger> cache;
    public static ReferenceTable aReferenceTable383;

    static {
        cache = new ReferenceCache<>(64);
    }

    public boolean aBoolean790;

    public VarcInteger() {
        aBoolean790 = false;
    }

    void decode(int opcode) {
        if (opcode == 2) {
            aBoolean790 = true;
        }
    }

    public void decode(Buffer buffer) {
        while (true) {
            int opcode = buffer.g1();
            if (opcode == 0) {
                return;
            }

            decode(opcode);
        }
    }
}
