package com.jagex;

public class DefinitionProperty extends DoublyLinkedNode {
    public static ReferenceTable table;
    static ReferenceCache cache;
    static Class77 aClass77_384;
    static int anInt386;

    static {
        cache = new ReferenceCache(64);
    }

    public int defaultInteger;
    public String defaultString;
    char type;
    boolean deleteOnUse;

    DefinitionProperty() {
        this.deleteOnUse = true;
    }

    static boolean method261(int var0) {
        if (var0 < 0) {
            return false;
        }
        int var1 = client.menuOpcodes[var0];
        if (var1 >= 2000) {
            var1 -= 2000;
        }

        return var1 == 1007;
    }

    public static void fireScriptEvent(ScriptEvent var0) {
        ScriptEvent.process(var0, 500000);
    }

    void method259(Buffer var1, int var2) {
        if (var2 == 1) {
            this.type = Class25.method186(var1.readByte());
        } else if (var2 == 2) {
            this.defaultInteger = var1.readInt();
        } else if (var2 == 4) {
            this.deleteOnUse = false;
        } else if (var2 == 5) {
            this.defaultString = var1.readString();
        }

    }

    void method254() {
    }

    void method260(Buffer var1) {
        while (true) {
            int var2 = var1.readUByte();
            if (var2 == 0) {
                return;
            }

            this.method259(var1, var2);
        }
    }

    public boolean method258() {
        return this.type == 's';
    }
}
