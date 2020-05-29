package jag.game.type;

import jag.commons.collection.DoublyLinkedNode;
import jag.commons.collection.ReferenceCache;
import jag.game.Vars;
import jag.js5.ReferenceTable;
import jag.opcode.Buffer;

public class Varbit extends DoublyLinkedNode {

    public static final ReferenceCache cache;
    public static ReferenceTable table;

    static {
        cache = new ReferenceCache(64);
    }

    public int parent;
    public int lower;
    public int upper;

    public static void set(int var0, int var1) {
        Varbit var2 = (Varbit) cache.get(var0);
        Varbit var3;
        if (var2 == null) {
            byte[] var8 = table.unpack(14, var0);
            var2 = new Varbit();
            if (var8 != null) {
                var2.method990(new Buffer(var8));
            }

            cache.put(var2, var0);
        }
        var3 = var2;

        int var4 = var3.parent;
        int var5 = var3.lower;
        int var6 = var3.upper;
        int var7 = Vars.masks[var6 - var5];
        if (var1 < 0 || var1 > var7) {
            var1 = 0;
        }

        var7 <<= var5;
        Vars.values[var4] = Vars.values[var4] & ~var7 | var1 << var5 & var7;
    }

    public static int get(int var0) {
        Varbit var2 = (Varbit) cache.get(var0);
        Varbit var3;
        if (var2 == null) {
            byte[] var8 = table.unpack(14, var0);
            var2 = new Varbit();
            if (var8 != null) {
                var2.method990(new Buffer(var8));
            }

            cache.put(var2, var0);
        }
        var3 = var2;

        int var4 = var3.parent;
        int var5 = var3.lower;
        int var6 = var3.upper;
        int var7 = Vars.masks[var6 - var5];
        return Vars.values[var4] >> var5 & var7;
    }

    public void method988(Buffer var1, int var2) {
        if (var2 == 1) {
            this.parent = var1.readUShort();
            this.lower = var1.readUByte();
            this.upper = var1.readUByte();
        }

    }

    public void method990(Buffer var1) {
        while (true) {
            int var2 = var1.readUByte();
            if (var2 == 0) {
                return;
            }

            this.method988(var1, var2);
        }
    }
}
