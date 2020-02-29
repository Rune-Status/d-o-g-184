package com.jagex;

import netscape.javascript.JSObject;

import java.applet.Applet;
import java.awt.*;
import java.awt.Desktop.Action;
import java.net.URI;
import java.net.URL;

public class Class26 {
    static final Class26 aClass26_311;
    static final Class26 aClass26_312;
    static int anInt310;
    static Sprite aSprite308;

    static {
        aClass26_311 = new Class26(0);
        aClass26_312 = new Class26(1);
    }

    final int anInt309;

    Class26(int var1) {
        this.anInt309 = var1;
    }

    static void method190() {
        if (Class76.anAudioSystem599 != null) {
            Class76.anAudioSystem599.method1328();
        }

        if (Statics16.anAudioSystem1236 != null) {
            Statics16.anAudioSystem1236.method1328();
        }

    }

    static void method192(String var0, boolean var1, boolean var3) {
        if (var1) {
            if (!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                try {
                    Desktop.getDesktop().browse(new URI(var0));
                    return;
                } catch (Exception ignored) {
                }
            }

            if (Statics1.aString325.startsWith("win") && !var3) {
                Class49.method297(var0, 0);
                return;
            }

            if (Statics1.aString325.startsWith("mac")) {
                method191(var0, 1);
                return;
            }

            Class49.method297(var0, 2);
        } else {
            Class49.method297(var0, 3);
        }

    }

    static boolean method191(String var0, int var1) {
        if (var1 == 0) {
            try {
                if (!Statics1.aString325.startsWith("win")) {
                    throw new Exception();
                }
                if (!var0.startsWith("http://") && !var0.startsWith("https://")) {
                    throw new Exception();
                }
                String var13 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

                for (int var4 = 0; var4 < var0.length(); ++var4) {
                    if (var13.indexOf(var0.charAt(var4)) == -1) {
                        throw new Exception();
                    }
                }

                Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
                return true;
            } catch (Throwable var8) {
                return false;
            }
        }
        if (var1 == 1) {
            try {
                Applet var5 = Statics1.anApplet323;
                Object[] var6 = new Object[]{(new URL(Statics1.anApplet323.getCodeBase(), var0)).toString()};
                Object var3 = JSObject.getWindow(var5).call("openjs", var6);
                return var3 != null;
            } catch (Throwable var9) {
                return false;
            }
        }
        if (var1 == 2) {
            try {
                Statics1.anApplet323.getAppletContext().showDocument(new URL(Statics1.anApplet323.getCodeBase(), var0), "_blank");
                return true;
            } catch (Exception var10) {
                return false;
            }
        }
        if (var1 == 3) {
            try {
                Class15.method114(Statics1.anApplet323, "loggedout");
            } catch (Throwable ignored) {
            }

            try {
                Statics1.anApplet323.getAppletContext().showDocument(new URL(Statics1.anApplet323.getCodeBase(), var0), "_top");
                return true;
            } catch (Exception var11) {
                return false;
            }
        }
        throw new IllegalArgumentException();
    }

    static void method189(int var0, int var1, int var2) {
        int var3;
        for (var3 = 0; var3 < 8; ++var3) {
            for (int var4 = 0; var4 < 8; ++var4) {
                Class44.tileHeights[var0][var3 + var1][var4 + var2] = 0;
            }
        }

        if (var1 > 0) {
            for (var3 = 1; var3 < 8; ++var3) {
                Class44.tileHeights[var0][var1][var3 + var2] = Class44.tileHeights[var0][var1 - 1][var3 + var2];
            }
        }

        if (var2 > 0) {
            for (var3 = 1; var3 < 8; ++var3) {
                Class44.tileHeights[var0][var3 + var1][var2] = Class44.tileHeights[var0][var3 + var1][var2 - 1];
            }
        }

        if (var1 > 0 && Class44.tileHeights[var0][var1 - 1][var2] != 0) {
            Class44.tileHeights[var0][var1][var2] = Class44.tileHeights[var0][var1 - 1][var2];
        } else if (var2 > 0 && Class44.tileHeights[var0][var1][var2 - 1] != 0) {
            Class44.tileHeights[var0][var1][var2] = Class44.tileHeights[var0][var1][var2 - 1];
        } else if (var1 > 0 && var2 > 0 && Class44.tileHeights[var0][var1 - 1][var2 - 1] != 0) {
            Class44.tileHeights[var0][var1][var2] = Class44.tileHeights[var0][var1 - 1][var2 - 1];
        }

    }
}
