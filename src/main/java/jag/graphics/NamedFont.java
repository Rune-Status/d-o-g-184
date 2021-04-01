package jag.graphics;

import jag.commons.collection.NodeTable;
import jag.game.Inventory;

public class NamedFont {

    public static final NamedFont VERDANA11;
    public static final NamedFont P11;
    public static final NamedFont VERDANA13;
    public static final NamedFont VERDANA15;
    public static final NamedFont P12;
    public static final NamedFont B12;
    public static int[] anIntArray1626;

    static {
        P11 = new NamedFont("p11_full");
        P12 = new NamedFont("p12_full");
        B12 = new NamedFont("b12_full");
        VERDANA11 = new NamedFont("verdana_11pt_regular");
        VERDANA13 = new NamedFont("verdana_13pt_regular");
        VERDANA15 = new NamedFont("verdana_15pt_regular");
    }

    public String name;

    NamedFont(String name) {
        this.name = name;
    }

    public static NamedFont[] values() {
        return new NamedFont[]{VERDANA13, B12, VERDANA11, P12, VERDANA15, P11};
    }

    public static void method1181() {
        Inventory.cache = new NodeTable(32);
    }
}
