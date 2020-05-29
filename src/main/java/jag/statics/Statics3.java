package jag.statics;

import jag.ByteBufferProvider;
import jag.commons.input.Mouse;
import jag.game.World;
import jag.game.client;

public class Statics3 {
    public static int anInt802;

    public Statics3() {
    }

    public static void processActionAt(int index) {
        if (index >= 0) {
            int var1 = client.menuSecondaryArgs[index];
            int var2 = client.menuTertiaryArgs[index];
            int var3 = client.menuOpcodes[index];
            int var4 = client.menuPrimaryArgs[index];
            String var5 = client.menuActions[index];
            String var6 = client.menuTargets[index];
            client.processAction(var1, var2, var3, var4, var6, Mouse.clickX, Mouse.clickY);
        }
    }

    public static boolean method650(int var0) {
        return (var0 >> 28 & 1) != 0;
    }

    public static World method652() {
        World.anInt1872 = 0;
        return ByteBufferProvider.method866();
    }
}
