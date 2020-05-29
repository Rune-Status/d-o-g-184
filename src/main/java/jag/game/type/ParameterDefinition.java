package jag.game.type;

import jag.commons.collection.DoublyLinkedNode;
import jag.commons.collection.IterableNodeTable;
import jag.commons.collection.ReferenceCache;
import jag.game.HealthBar;
import jag.graphics.Sprite;
import jag.js5.ReferenceTable;
import jag.opcode.Buffer;

public class ParameterDefinition extends DoublyLinkedNode {
    public static final ReferenceCache aReferenceCache385;
    public static ReferenceTable aReferenceTable383;
    public static Sprite[] prayerIconSprites;

    static {
        aReferenceCache385 = new ReferenceCache(64);
    }

    IterableNodeTable aIterableNodeTable1504;

    public ParameterDefinition() {
    }

    void decode(Buffer var1, int var2) {
        if (var2 == 249) {
            this.aIterableNodeTable1504 = IterableNodeTable.read(var1, this.aIterableNodeTable1504);
        }

    }

    public String method1096(int var1, String var2) {
        return IterableNodeTable.getStringParameter(this.aIterableNodeTable1504, var1, var2);
    }

    public int method1097(int var1, int var2) {
        return HealthBar.method696(this.aIterableNodeTable1504, var1, var2);
    }

    public void method254() {
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
