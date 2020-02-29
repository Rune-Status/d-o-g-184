package com.jagex;

public class InventoryDefinition extends DoublyLinkedNode {

    static ReferenceCache cache;
    static ReferenceTable table;

    static {
        cache = new ReferenceCache(64);
    }

    public int capacity;

    InventoryDefinition() {
        this.capacity = 0;
    }

    public static InventoryDefinition lookup(int key) {
        InventoryDefinition definition = (InventoryDefinition) cache.get((long) key);
        if (definition != null) {
            return definition;
        }

        byte[] buffer = table.unpack(5, key);
        definition = new InventoryDefinition();
        if (buffer != null) {
            definition.decode(new Buffer(buffer));
        }

        cache.put(definition, (long) key);
        return definition;
    }

    void decodeOpcode(Buffer buffer, int opcode) {
        if (opcode == 2) {
            this.capacity = buffer.readUShort();
        }

    }

    void decode(Buffer buffer) {
        while (true) {
            int opcode = buffer.readUByte();
            if (opcode == 0) {
                return;
            }

            this.decodeOpcode(buffer, opcode);
        }
    }
}
