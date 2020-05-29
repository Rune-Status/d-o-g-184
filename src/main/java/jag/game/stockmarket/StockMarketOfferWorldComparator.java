package jag.game.stockmarket;

import jag.game.InterfaceComponent;
import jag.game.client;
import jag.game.relationship.ChatLine;
import jag.graphics.Font;
import jag.js5.Archive;
import jag.js5.ReferenceTable;
import jag.statics.Statics53;

import java.io.File;
import java.util.Comparator;

public class StockMarketOfferWorldComparator implements Comparator {
    public static File aFile346;
    public static ReferenceTable aReferenceTable350;
    public static int cameraX;
    public static Font aFont345;
    public static InterfaceComponent anInterfaceComponent351;
    public static int anInt347;
    public static Archive aArchive348;
    public boolean aBoolean349;

    public StockMarketOfferWorldComparator() {
    }

    public static ChatLine method246(int var0) {
        return (ChatLine) Statics53.A_ITERABLE_NODE_TABLE_523.lookup(var0);
    }

    int method247(StockMarketEvent var1, StockMarketEvent var2) {
        if (var2.anInt552 == var1.anInt552) {
            return 0;
        }
        if (this.aBoolean349) {
            if (client.currentWorld == var1.anInt552) {
                return -1;
            }

            if (var2.anInt552 == client.currentWorld) {
                return 1;
            }
        }

        return var1.anInt552 < var2.anInt552 ? -1 : 1;
    }

    public int compare(Object var1, Object var2) {
        return this.method247((StockMarketEvent) var1, (StockMarketEvent) var2);
    }

    public boolean equals(Object var1) {
        return super.equals(var1);
    }
}
