package jag.game.type;

import jag.commons.collection.DoublyLinkedNode;
import jag.commons.collection.ReferenceCache;
import jag.game.option.AttackOptionPriority;
import jag.js5.ReferenceTable;
import jag.opcode.Buffer;

public class TileUnderlay extends DoublyLinkedNode {

    public static final ReferenceCache<TileUnderlay> cache;
    public static ReferenceTable table;

    static {
        cache = new ReferenceCache<>(64);
    }

    public int anInt574;
    public int anInt112;
    public int anInt375;
    public int anInt377;
    int anInt378;

    public TileUnderlay() {
        anInt378 = 0;
    }

    public static AttackOptionPriority[] method1109() {
        return new AttackOptionPriority[]{AttackOptionPriority.HIDDEN, AttackOptionPriority.LEFT, AttackOptionPriority.RIGHT, AttackOptionPriority.DEPENDS};
    }

    public static TileUnderlay get(int id) {
        TileUnderlay var1 = cache.get(id);
        if (var1 != null) {
            return var1;
        }
        byte[] var2 = table.unpack(1, id);
        var1 = new TileUnderlay();
        if (var2 != null) {
            var1.decode(new Buffer(var2));
        }

        var1.method254();
        cache.put(var1, id);
        return var1;
    }

    void method830(int var1) {
        double var2 = (double) (var1 >> 16 & 255) / 256.0D;
        double var4 = (double) (var1 >> 8 & 255) / 256.0D;
        double var6 = (double) (var1 & 255) / 256.0D;
        double var8 = var2;
        if (var4 < var2) {
            var8 = var4;
        }

        if (var6 < var8) {
            var8 = var6;
        }

        double var10 = var2;
        if (var4 > var2) {
            var10 = var4;
        }

        if (var6 > var10) {
            var10 = var6;
        }

        double var12 = 0.0D;
        double var14 = 0.0D;
        double var16 = (var10 + var8) / 2.0D;
        if (var10 != var8) {
            if (var16 < 0.5D) {
                var14 = (var10 - var8) / (var8 + var10);
            }

            if (var16 >= 0.5D) {
                var14 = (var10 - var8) / (2.0D - var10 - var8);
            }

            if (var10 == var2) {
                var12 = (var4 - var6) / (var10 - var8);
            } else if (var10 == var4) {
                var12 = 2.0D + (var6 - var2) / (var10 - var8);
            } else if (var6 == var10) {
                var12 = 4.0D + (var2 - var4) / (var10 - var8);
            }
        }

        var12 /= 6.0D;
        anInt574 = (int) (256.0D * var14);
        anInt112 = (int) (var16 * 256.0D);
        if (anInt574 < 0) {
            anInt574 = 0;
        } else if (anInt574 > 255) {
            anInt574 = 255;
        }

        if (anInt112 < 0) {
            anInt112 = 0;
        } else if (anInt112 > 255) {
            anInt112 = 255;
        }

        if (var16 > 0.5D) {
            anInt375 = (int) (512.0D * var14 * (1.0D - var16));
        } else {
            anInt375 = (int) (512.0D * var16 * var14);
        }

        if (anInt375 < 1) {
            anInt375 = 1;
        }

        anInt377 = (int) ((double) anInt375 * var12);
    }

    void decode(Buffer var1, int var2) {
        if (var2 == 1) {
            anInt378 = var1.g3();
        }

    }

    public void method254() {
        method830(anInt378);
    }

    public void decode(Buffer var1) {
        while (true) {
            int var3 = var1.g1();
            if (var3 == 0) {
                return;
            }

            decode(var1, var3);
        }
    }
}
