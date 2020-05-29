package jag.script;

import jag.SerializableProcessor;
import jag.commons.collection.DoublyLinkedNode;
import jag.commons.collection.IterableNodeTable;
import jag.commons.collection.ReferenceCache;
import jag.game.stockmarket.StockMarketOfferWorldComparator;
import jag.js5.Archive;

public class RuneScript extends DoublyLinkedNode {
    public static final ReferenceCache aReferenceCache1647;
    public static Archive aArchive1644;

    static {
        aReferenceCache1647 = new ReferenceCache(128);
    }

    public int[] anIntArray1574;
    public int[] anIntArray749;
    public int anInt574;
    public int anInt112;
    public int anInt375;
    public String[] aStringArray1645;
    public int anInt372;
    public IterableNodeTable[] aIterableNodeTableArray1646;

    public RuneScript() {
    }

    public static RuneScript method239(int var0) {
        RuneScript var2 = (RuneScript) aReferenceCache1647.get(var0 << 16);
        if (var2 != null) {
            return var2;
        }
        String var3 = String.valueOf(var0);
        int var4 = StockMarketOfferWorldComparator.aArchive348.get(var3);
        if (var4 == -1) {
            return null;
        }
        byte[] var5 = StockMarketOfferWorldComparator.aArchive348.method904(var4);
        if (var5 != null) {
            if (var5.length <= 1) {
                return null;
            }

            var2 = SerializableProcessor.method455(var5);
            if (var2 != null) {
                aReferenceCache1647.put(var2, var0 << 16);
                return var2;
            }
        }

        return null;
    }

    public IterableNodeTable[] method1189(int var1) {
        return new IterableNodeTable[var1];
    }
}
