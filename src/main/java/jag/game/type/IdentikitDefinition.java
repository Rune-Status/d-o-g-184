package jag.game.type;

import jag.commons.collection.DoublyLinkedNode;
import jag.commons.collection.ReferenceCache;
import jag.game.InterfaceComponent;
import jag.game.scene.entity.UnlitModel;
import jag.game.stockmarket.StockMarketOfferWorldComparator;
import jag.js5.ReferenceTable;
import jag.opcode.Buffer;

public class IdentikitDefinition extends DoublyLinkedNode {
    public static final ReferenceCache aReferenceCache700;
    public static ReferenceTable aReferenceTable383;
    public static InterfaceComponent anInterfaceComponent1518;

    static {
        aReferenceCache700 = new ReferenceCache(64);
    }

    public int anInt574;
    public boolean aBoolean1517;
    int[] anIntArray747;
    int[] anIntArray1101;
    short[] aShortArray1516;
    short[] aShortArray1462;
    short[] aShortArray1461;
    short[] aShortArray1460;

    public IdentikitDefinition() {
        this.anInt574 = -1;
        this.anIntArray1101 = new int[]{-1, -1, -1, -1, -1};
        this.aBoolean1517 = false;
    }

    void decode(Buffer var1, int var2) {
        if (var2 == 1) {
            this.anInt574 = var1.readUByte();
        } else {
            if (var2 == 2) {
                int var3 = var1.readUByte();
                this.anIntArray747 = new int[var3];

                for (int var4 = 0; var4 < var3; ++var4) {
                    this.anIntArray747[var4] = var1.readUShort();
                }
            } else if (var2 == 3) {
                this.aBoolean1517 = true;
            } else if (var2 == 40) {
                int var3 = var1.readUByte();
                this.aShortArray1516 = new short[var3];
                this.aShortArray1461 = new short[var3];

                for (int var4 = 0; var4 < var3; ++var4) {
                    this.aShortArray1516[var4] = (short) var1.readUShort();
                    this.aShortArray1461[var4] = (short) var1.readUShort();
                }
            } else if (var2 == 41) {
                int var3 = var1.readUByte();
                this.aShortArray1462 = new short[var3];
                this.aShortArray1460 = new short[var3];

                for (int var4 = 0; var4 < var3; ++var4) {
                    this.aShortArray1462[var4] = (short) var1.readUShort();
                    this.aShortArray1460[var4] = (short) var1.readUShort();
                }
            } else if (var2 >= 60 && var2 < 70) {
                this.anIntArray1101[var2 - 60] = var1.readUShort();
            }
        }

    }

    public boolean method882() {
        boolean var1 = true;

        for (int var2 = 0; var2 < 5; ++var2) {
            if (this.anIntArray1101[var2] != -1 && !StockMarketOfferWorldComparator.aReferenceTable350.method913(this.anIntArray1101[var2], 0)) {
                var1 = false;
            }
        }

        return var1;
    }

    public UnlitModel method1113() {
        UnlitModel[] var1 = new UnlitModel[5];
        int var2 = 0;

        for (int var3 = 0; var3 < 5; ++var3) {
            if (this.anIntArray1101[var3] != -1) {
                var1[var2++] = UnlitModel.method982(StockMarketOfferWorldComparator.aReferenceTable350, this.anIntArray1101[var3], 0);
            }
        }

        UnlitModel var4 = new UnlitModel(var1, var2);
        int var5;
        if (this.aShortArray1516 != null) {
            for (var5 = 0; var5 < this.aShortArray1516.length; ++var5) {
                var4.texturize(this.aShortArray1516[var5], this.aShortArray1461[var5]);
            }
        }

        if (this.aShortArray1462 != null) {
            for (var5 = 0; var5 < this.aShortArray1462.length; ++var5) {
                var4.colorize(this.aShortArray1462[var5], this.aShortArray1460[var5]);
            }
        }

        return var4;
    }

    public boolean method1114() {
        if (this.anIntArray747 == null) {
            return true;
        }
        boolean var1 = true;

        for (int anAnIntArray747 : this.anIntArray747) {
            if (!StockMarketOfferWorldComparator.aReferenceTable350.method913(anAnIntArray747, 0)) {
                var1 = false;
            }
        }

        return var1;
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

    public UnlitModel method978() {
        if (this.anIntArray747 == null) {
            return null;
        }
        UnlitModel[] var1 = new UnlitModel[this.anIntArray747.length];

        for (int var2 = 0; var2 < this.anIntArray747.length; ++var2) {
            var1[var2] = UnlitModel.method982(StockMarketOfferWorldComparator.aReferenceTable350, this.anIntArray747[var2], 0);
        }

        UnlitModel var3;
        if (var1.length == 1) {
            var3 = var1[0];
        } else {
            var3 = new UnlitModel(var1, var1.length);
        }

        int var4;
        if (this.aShortArray1516 != null) {
            for (var4 = 0; var4 < this.aShortArray1516.length; ++var4) {
                var3.texturize(this.aShortArray1516[var4], this.aShortArray1461[var4]);
            }
        }

        if (this.aShortArray1462 != null) {
            for (var4 = 0; var4 < this.aShortArray1462.length; ++var4) {
                var3.colorize(this.aShortArray1462[var4], this.aShortArray1460[var4]);
            }
        }

        return var3;
    }
}
