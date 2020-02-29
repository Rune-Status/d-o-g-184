package com.jagex;

import netscape.javascript.JSObject;

import java.applet.Applet;

public class Class15 {
    public static void method113(Applet var0, String var1) {
        JSObject.getWindow(var0).eval(var1);
    }

    public static Object method114(Applet var0, String var1) {
        return JSObject.getWindow(var0).call(var1, (Object[]) null);
    }
}
