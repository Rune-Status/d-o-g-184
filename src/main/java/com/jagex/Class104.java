package com.jagex;

public class Class104 {
    static CacheReferenceTable aCacheReferenceTable773;
    static Buffer aBuffer771;
    static Font aFont774;
    int anInt772;
    int anInt770;
    int anInt769;

    Class104() {
    }

    static void method610(InterfaceComponent[] var0, int var1, int var2, int var3, boolean var4) {
        for (InterfaceComponent var6 : var0) {
            if (var6 != null && var6.parentUid == var1) {
                PickableNode.method728(var6, var2, var3, var4);
                Class24.method185(var6, var2, var3);
                if (var6.insetX > var6.viewportWidth - var6.width) {
                    var6.insetX = var6.viewportWidth - var6.width;
                }

                if (var6.insetX < 0) {
                    var6.insetX = 0;
                }

                if (var6.insetY > var6.viewportHeight - var6.height) {
                    var6.insetY = var6.viewportHeight - var6.height;
                }

                if (var6.insetY < 0) {
                    var6.insetY = 0;
                }

                if (var6.type == 0) {
                    GameEngine.method925(var0, var6, var4);
                }
            }
        }

    }

    static String method612(InterfaceComponent var0, int var1) {
        int var2 = InterfaceComponent.getConfig(var0);
        boolean var3 = (var2 >> var1 + 1 & 1) != 0;
        if (!var3 && var0.mousePressListeners == null) {
            return null;
        }
        return var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0 ? var0.actions[var1] : null;
    }

    static String method611(String var0, boolean var1) {
        String var2 = var1 ? "https://" : "http://";
        if (client.anInt925 == 1) {
            var0 = var0 + "-wtrc";
        } else if (client.anInt925 == 2) {
            var0 = var0 + "-wtqa";
        } else if (client.anInt925 == 3) {
            var0 = var0 + "-wtwip";
        } else if (client.anInt925 == 5) {
            var0 = var0 + "-wti";
        } else if (client.anInt925 == 4) {
            var0 = "local";
        }

        String var3 = "";
        if (Class147.aString1162 != null) {
            var3 = "/p=" + Class147.aString1162;
        }

        String var4 = "runescape.com";
        return var2 + var0 + "." + var4 + "/l=" + Class65.aClass149_525 + "/a=" + Class9.anInt130 + var3 + "/";
    }
}
