package jag.game.type;

import jag.MenuItemNode;
import jag.commons.collection.DoublyLinkedNode;
import jag.commons.collection.ReferenceCache;
import jag.game.client;
import jag.js5.ReferenceTable;
import jag.opcode.Buffer;
import jag.script.ScriptEvent;
import jag.worldmap.WorldMapScriptEvent;

public class DefinitionProperty extends DoublyLinkedNode {

    public static final ReferenceCache cache;
    public static ReferenceTable table;
    public static MenuItemNode aMenuItemNode_384;
    public static int anInt386;

    static {
        cache = new ReferenceCache(64);
    }

    public int defaultInteger;
    public String defaultString;
    public char type;
    public boolean deleteOnUse;

    public DefinitionProperty() {
        this.deleteOnUse = true;
    }

    public static boolean method261(int var0) {
        if (var0 < 0) {
            return false;
        }
        int var1 = client.menuOpcodes[var0];
        if (var1 >= 2000) {
            var1 -= 2000;
        }

        return var1 == 1007;
    }

    public static DefinitionProperty get(int var0) {
        DefinitionProperty var2 = (DefinitionProperty) cache.get(var0);
        if (var2 != null) {
            return var2;
        }
        byte[] var3 = table.unpack(11, var0);
        var2 = new DefinitionProperty();
        if (var3 != null) {
            var2.method260(new Buffer(var3));
        }

        var2.method254();
        cache.put(var2, var0);
        return var2;
    }

    public static void method516(int var0) {
        aMenuItemNode_384 = new MenuItemNode();
        aMenuItemNode_384.secondary = client.menuSecondaryArgs[var0];
        aMenuItemNode_384.tertiary = client.menuTertiaryArgs[var0];
        aMenuItemNode_384.opcode = client.menuOpcodes[var0];
        aMenuItemNode_384.primary = client.menuPrimaryArgs[var0];
        aMenuItemNode_384.action = client.menuActions[var0];
    }

    public static void clear() {
        cache.clear();
    }

    public void method259(Buffer var1, int var2) {
        if (var2 == 1) {
            this.type = WorldMapScriptEvent.method186(var1.readByte());
        } else if (var2 == 2) {
            this.defaultInteger = var1.readInt();
        } else if (var2 == 4) {
            this.deleteOnUse = false;
        } else if (var2 == 5) {
            this.defaultString = var1.readString();
        }

    }

    public void method254() {
    }

    public void method260(Buffer var1) {
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
