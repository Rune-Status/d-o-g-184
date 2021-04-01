package jag.game.type;

import jag.game.menu.MenuItemNode;
import jag.commons.collection.DoublyLinkedNode;
import jag.commons.collection.ReferenceCache;
import jag.game.menu.ContextMenu;
import jag.js5.ReferenceTable;
import jag.opcode.Buffer;
import jag.worldmap.WorldMapScriptEvent;

public class DefinitionProperty extends DoublyLinkedNode {

    public static final ReferenceCache<DefinitionProperty> cache;
    public static ReferenceTable table;
    public static MenuItemNode aMenuItemNode_384;
    public static int anInt386;

    static {
        cache = new ReferenceCache<>(64);
    }

    public int defaultInteger;
    public String defaultString;
    public char type;
    public boolean deleteOnUse;

    public DefinitionProperty() {
        deleteOnUse = true;
    }

    public static DefinitionProperty get(int id) {
        DefinitionProperty prop = cache.get(id);
        if (prop != null) {
            return prop;
        }
        byte[] data = table.unpack(11, id);
        prop = new DefinitionProperty();
        if (data != null) {
            prop.decode(new Buffer(data));
        }

        prop.method254();
        cache.put(prop, id);
        return prop;
    }

    public static void method516(int var0) {
        aMenuItemNode_384 = new MenuItemNode();
        aMenuItemNode_384.secondaryArg = ContextMenu.secondaryArgs[var0];
        aMenuItemNode_384.tertiaryArg = ContextMenu.tertiaryArgs[var0];
        aMenuItemNode_384.opcode = ContextMenu.opcodes[var0];
        aMenuItemNode_384.primaryArg = ContextMenu.primaryArgs[var0];
        aMenuItemNode_384.action = ContextMenu.actions[var0];
    }

    public static void clear() {
        cache.clear();
    }

    public void decode(Buffer var1, int var2) {
        if (var2 == 1) {
            type = WorldMapScriptEvent.method186(var1.g1b());
        } else if (var2 == 2) {
            defaultInteger = var1.g4();
        } else if (var2 == 4) {
            deleteOnUse = false;
        } else if (var2 == 5) {
            defaultString = var1.gstr();
        }

    }

    public void method254() {
    }

    public void decode(Buffer buffer) {
        while (true) {
            int opcode = buffer.g1();
            if (opcode == 0) {
                return;
            }

            decode(buffer, opcode);
        }
    }

    public boolean method258() {
        return type == 's';
    }
}
