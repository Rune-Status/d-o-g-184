package com.jagex;

public class Class199 {
    public static final Class199 aClass199_1621;
    public static final Class199 aClass199_1624;
    public static final Class199 aClass199_1620;
    public static final Class199 aClass199_1618;
    public static final Class199 aClass199_1625;
    public static final Class199 aClass199_1622;
    static DoublyLinkedNode_Sub24_Sub4 aDoublyNode_Sub24_Sub4_1623;
    static int[] anIntArray1626;

    static {
        aClass199_1624 = new Class199("p11_full");
        aClass199_1625 = new Class199("p12_full");
        aClass199_1622 = new Class199("b12_full");
        aClass199_1621 = new Class199("verdana_11pt_regular");
        aClass199_1620 = new Class199("verdana_13pt_regular");
        aClass199_1618 = new Class199("verdana_15pt_regular");
    }

    String aString1619;

    Class199(String var1) {
        this.aString1619 = var1;
    }

    static void method1182(InterfaceNode var0, boolean var1) {
        int var2 = var0.id;
        int var3 = (int) var0.key;
        var0.unlink();
        if (var1) {
            InterfaceNode.method830(var2);
        }

        for (IntegerNode var4 = (IntegerNode) client.interfaceConfigs.method314(); var4 != null; var4 = (IntegerNode) client.interfaceConfigs.method313()) {
            if ((long) var2 == (var4.key >> 48 & 65535L)) {
                var4.unlink();
            }
        }

        InterfaceComponent var5 = InterfaceComponent.lookup(var3);
        if (var5 != null) {
            Enum_Sub2.repaintComponent(var5);
        }

        Class53.method317();
        if (client.rootInterfaceIndex != -1) {
            Class16.method118(client.rootInterfaceIndex, 1);
        }

    }

    public static Class199[] method1183() {
        return new Class199[]{aClass199_1620, aClass199_1622, aClass199_1621, aClass199_1625, aClass199_1618, aClass199_1624};
    }

    static void method1181() {
        Inventory.cache = new NodeTable(32);
    }
}
