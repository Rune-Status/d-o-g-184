package jag.statics;

import jag.game.InterfaceComponent;
import jag.game.client;

public class Statics26 {
    public static void method1112(int var0, int var1, int var2, boolean var3) {
        if (InterfaceComponent.load(var0)) {
            InterfaceComponent.method610(client.interfaces[var0], -1, var1, var2, var3);
        }
    }

    public static String method1111(int var0) {
        return "<img=" + var0 + ">";
    }

}
