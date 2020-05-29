package jag.game.type;

import jag.commons.collection.DoublyLinkedNode;
import jag.commons.collection.ReferenceCache;
import jag.graphics.Sprite;
import jag.js5.ReferenceTable;
import jag.opcode.Buffer;

public class HealthBarDefinition extends DoublyLinkedNode {

    public static final ReferenceCache cache;
    public static final ReferenceCache aReferenceCache700;
    public static ReferenceTable table;
    public static ReferenceTable aReferenceTable697;

    static {
        cache = new ReferenceCache(64);
        aReferenceCache700 = new ReferenceCache(64);
    }

    public int anInt372;
    public int anInt564;
    public int anInt379;
    public int anInt367;
    public int anInt368;
    public int anInt574;
    public int maxWidth;
    public int anInt702;
    public int underlaySpriteId;
    public int overlaySpriteId;

    public HealthBarDefinition() {
        this.anInt372 = 255;
        this.anInt379 = 255;
        this.anInt564 = -1;
        this.anInt368 = 1;
        this.anInt367 = 70;
        this.overlaySpriteId = -1;
        this.underlaySpriteId = -1;
        this.maxWidth = 30;
        this.anInt702 = 0;
    }

    public static void method296(ReferenceTable var0, ReferenceTable var1) {
        table = var0;
        aReferenceTable697 = var1;
    }

    public void method988(Buffer var1, int var2) {
        if (var2 == 1) {
            var1.readUShort();
        } else if (var2 == 2) {
            this.anInt372 = var1.readUByte();
        } else if (var2 == 3) {
            this.anInt379 = var1.readUByte();
        } else if (var2 == 4) {
            this.anInt564 = 0;
        } else if (var2 == 5) {
            this.anInt367 = var1.readUShort();
        } else if (var2 == 6) {
            var1.readUByte();
        } else if (var2 == 7) {
            this.overlaySpriteId = var1.method1051();
        } else if (var2 == 8) {
            this.underlaySpriteId = var1.method1051();
        } else if (var2 == 11) {
            this.anInt564 = var1.readUShort();
        } else if (var2 == 14) {
            this.maxWidth = var1.readUByte();
        } else if (var2 == 15) {
            this.anInt702 = var1.readUByte();
        }

    }

    public void decode(Buffer var1) {
        while (true) {
            int var2 = var1.readUByte();
            if (var2 == 0) {
                return;
            }

            this.method988(var1, var2);
        }
    }

    public Sprite method1378() {
        if (this.underlaySpriteId < 0) {
            return null;
        }
        Sprite var1 = (Sprite) aReferenceCache700.get(this.underlaySpriteId);
        if (var1 != null) {
            return var1;
        }
        var1 = Sprite.get(aReferenceTable697, this.underlaySpriteId, 0);
        if (var1 != null) {
            aReferenceCache700.put(var1, this.underlaySpriteId);
        }

        return var1;
    }

    public Sprite method1379() {
        if (this.overlaySpriteId < 0) {
            return null;
        }
        Sprite var1 = (Sprite) aReferenceCache700.get(this.overlaySpriteId);
        if (var1 != null) {
            return var1;
        }
        var1 = Sprite.get(aReferenceTable697, this.overlaySpriteId, 0);
        if (var1 != null) {
            aReferenceCache700.put(var1, this.overlaySpriteId);
        }

        return var1;
    }
}
