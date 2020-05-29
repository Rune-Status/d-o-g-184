package jag.game.type;

import jag.commons.collection.DoublyLinkedNode;
import jag.commons.collection.ReferenceCache;
import jag.js5.ReferenceTable;
import jag.opcode.Buffer;

public class InventoryDefinition extends DoublyLinkedNode {

    public static final ReferenceCache cache;
    public static ReferenceTable table;

    static {
        cache = new ReferenceCache(64);
    }

    public int capacity;

    public InventoryDefinition() {
        this.capacity = 0;
    }

    public static InventoryDefinition lookup(int key) {
        InventoryDefinition definition = (InventoryDefinition) cache.get(key);
        if (definition != null) {
            return definition;
        }

        byte[] buffer = table.unpack(5, key);
        definition = new InventoryDefinition();
        if (buffer != null) {
            definition.decode(new Buffer(buffer));
        }

        cache.put(definition, key);
        return definition;
    }

    public void decodeOpcode(Buffer buffer, int opcode) {
        if (opcode == 2) {
            this.capacity = buffer.readUShort();
        }

    }

    public void decode(Buffer buffer) {
        while (true) {
            int opcode = buffer.readUByte();
            if (opcode == 0) {
                return;
            }

            this.decodeOpcode(buffer, opcode);
        }
    }
}
