package jag.game.stockmarket;

import jag.DirectByteBufferProvider;
import jag.opcode.Buffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StockMarketMediator {

    public static final Comparator aComparator610;
    public static final Comparator aComparator608;
    public static final Comparator aComparator607;
    public static final Comparator aComparator606;

    static {
        aComparator610 = new StockMarketOfferLifetimeComparator();
        new Class76();
        aComparator608 = new StockMarketOfferPriceComparator();
        aComparator607 = new StockMarketOfferNameComparator();
        aComparator606 = new StockMarketOfferQuantityComparator();
    }

    public final List aList609;

    public StockMarketMediator(Buffer var1) {
        int var3 = var1.readUShort();
        boolean var4 = var1.readUByte() == 1;
        byte var5;
        if (var4) {
            var5 = 1;
        } else {
            var5 = 0;
        }

        int var6 = var1.readUShort();
        this.aList609 = new ArrayList(var6);

        for (int var7 = 0; var7 < var6; ++var7) {
            this.aList609.add(new StockMarketEvent(var1, var5, var3));
        }

    }

    public static Object method422(byte[] var0) {
        if (var0 == null) {
            return null;
        }
        if (var0.length > 136) {
            DirectByteBufferProvider var2 = new DirectByteBufferProvider();
            var2.allocate(var0);
            return var2;
        }
        return var0;
    }

    public void method421(Comparator var1, boolean var2) {
        if (var2) {
            Collections.sort(this.aList609, var1);
        } else {
            Collections.sort(this.aList609, Collections.reverseOrder(var1));
        }

    }
}
