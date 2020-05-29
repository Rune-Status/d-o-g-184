package jag.graphics;

import jag.SecureRandomService;
import jag.commons.collection.IntegerNode;
import jag.commons.collection.NodeTable;
import jag.game.InterfaceComponent;
import jag.game.Inventory;
import jag.game.SubInterface;
import jag.game.client;

public class NamedFont {

    public static final NamedFont VERDANA11;
    public static final NamedFont P11;
    public static final NamedFont VERDANA13;
    public static final NamedFont VERDANA15;
    public static final NamedFont P12;
    public static final NamedFont B12;
    public static IndexedSprite aDoublyNode_Sub24_Sub4_1623;
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

    public static void method1182(SubInterface var0, boolean var1) {
        int var2 = var0.id;
        int var3 = (int) var0.key;
        var0.unlink();
        if (var1) {
            InterfaceComponent.method830(var2);
        }

        for (IntegerNode var4 = client.interfaceConfigs.head(); var4 != null; var4 = client.interfaceConfigs.next()) {
            if ((long) var2 == (var4.key >> 48 & 65535L)) {
                var4.unlink();
            }
        }

        InterfaceComponent var5 = InterfaceComponent.lookup(var3);
        if (var5 != null) {
            InterfaceComponent.repaint(var5);
        }

        SecureRandomService.method317();
        if (client.rootInterfaceIndex != -1) {
            InterfaceComponent.method118(client.rootInterfaceIndex, 1);
        }

    }

    public static NamedFont[] values() {
        return new NamedFont[]{VERDANA13, B12, VERDANA11, P12, VERDANA15, P11};
    }

    public static void method1181() {
        Inventory.cache = new NodeTable(32);
    }
}
