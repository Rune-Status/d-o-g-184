package jag.game.type;

import jag.commons.collection.DoublyLinkedNode;
import jag.commons.collection.ReferenceCache;
import jag.game.option.AttackOptionPriority;
import jag.js5.ReferenceTable;
import jag.opcode.Buffer;

public class TileUnderlay extends DoublyLinkedNode {
    public static final ReferenceCache aReferenceCache385;
    public static ReferenceTable aReferenceTable383;

    static {
        aReferenceCache385 = new ReferenceCache(64);
    }

    public int anInt574;
    public int anInt112;
    public int anInt375;
    public int anInt377;
    int anInt378;

    public TileUnderlay() {
        this.anInt378 = 0;
    }

    public static AttackOptionPriority[] method1109() {
        return new AttackOptionPriority[]{AttackOptionPriority.anActionPrioritySetting330, AttackOptionPriority.anActionPrioritySetting331, AttackOptionPriority.anActionPrioritySetting336, AttackOptionPriority.anActionPrioritySetting333};
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
        this.anInt574 = (int) (256.0D * var14);
        this.anInt112 = (int) (var16 * 256.0D);
        if (this.anInt574 < 0) {
            this.anInt574 = 0;
        } else if (this.anInt574 > 255) {
            this.anInt574 = 255;
        }

        if (this.anInt112 < 0) {
            this.anInt112 = 0;
        } else if (this.anInt112 > 255) {
            this.anInt112 = 255;
        }

        if (var16 > 0.5D) {
            this.anInt375 = (int) (512.0D * var14 * (1.0D - var16));
        } else {
            this.anInt375 = (int) (512.0D * var16 * var14);
        }

        if (this.anInt375 < 1) {
            this.anInt375 = 1;
        }

        this.anInt377 = (int) ((double) this.anInt375 * var12);
    }

    void decode(Buffer var1, int var2) {
        if (var2 == 1) {
            this.anInt378 = var1.readMediumInt();
        }

    }

    public void method254() {
        this.method830(this.anInt378);
    }

    public void decode(Buffer var1) {
        while (true) {
            int var3 = var1.readUByte();
            if (var3 == 0) {
                return;
            }

            this.decode(var1, var3);
        }
    }
}
