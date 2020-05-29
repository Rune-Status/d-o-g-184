package jag.game;

import jag.*;
import jag.audi.DefaultAudioSystemProvider;
import jag.commons.JSObjectUtil;
import jag.commons.Jagception;
import jag.commons.input.Keyboard;
import jag.commons.input.MouseWheel;
import jag.commons.input.MouseWheelProvider;
import jag.commons.time.Clock;
import jag.game.scene.CollisionMap;
import jag.game.type.AnimationSequence;
import jag.game.type.TileOverlay;
import jag.graphics.BaseFont;
import jag.graphics.ImageGraphicsProvider;
import jag.graphics.JagGraphics;
import jag.opcode.OldConnection;
import jag.opcode.OldConnectionTaskProcessor;
import jag.statics.*;
import jag.worldmap.*;
import netscape.javascript.JSObject;

import java.applet.Applet;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.net.URI;
import java.net.URL;
import java.util.Date;

public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {

    public static final int anInt1303;
    public static final long[] aLongArray1313;
    public static final long[] aLongArray1289;
    public static OldConnectionTaskProcessor aOldConnectionTaskProcessor_1321;
    public static int anInt1292;
    public static volatile boolean aBoolean1314;
    public static GameEngine aGameEngine1305;
    public static boolean aBoolean1311;
    public static int anInt1316;
    public static long aLong1315;
    public static int anInt1297;
    public static Clock clock;
    public static int anInt1306;
    public static long aLong1298;
    public static long aLong1319;
    public static int anInt1309;
    public static int anInt1288;

    static {
        aGameEngine1305 = null;
        anInt1316 = 0;
        aLong1315 = 0L;
        aBoolean1311 = false;
        anInt1303 = 20;
        anInt1297 = 1;
        anInt1292 = 0;
        aLongArray1289 = new long[32];
        aLongArray1313 = new long[32];
        anInt1306 = 500;
        aBoolean1314 = true;
        aLong1298 = -1L;
        aLong1319 = -1L;
    }

    final EventQueue anEventQueue1294;
    protected int anInt1296;
    protected int anInt1312;
    Clipboard aClipboard1302;
    int anInt1320;
    boolean aBoolean1300;
    int anInt1295;
    boolean aBoolean1307;
    MouseWheel aMouseWheel_1308;
    Frame aFrame1310;
    java.awt.Canvas canvas;
    int anInt1299;
    int anInt1317;
    volatile boolean focused;
    int anInt1301;
    int anInt1291;
    volatile long aLong1304;
    volatile boolean aBoolean1293;

    protected GameEngine() {
        this.aBoolean1307 = false;
        this.anInt1295 = 0;
        this.anInt1299 = 0;
        this.focused = true;
        this.aBoolean1300 = false;
        this.aBoolean1293 = false;
        this.aLong1304 = 0L;
        EventQueue var1 = null;

        try {
            var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
        } catch (Throwable ignored) {
        }

        this.anEventQueue1294 = var1;
        WorldMapDecor.method382(new DefaultAudioSystemProvider());
    }

    public static void method925(InterfaceComponent[] var0, InterfaceComponent var1, boolean var2) {
        int var3 = var1.viewportWidth != 0 ? var1.viewportWidth : var1.width;
        int var4 = var1.viewportHeight != 0 ? var1.viewportHeight : var1.height;
        InterfaceComponent.method610(var0, var1.uid, var3, var4, var2);
        if (var1.components != null) {
            InterfaceComponent.method610(var1.components, var1.uid, var3, var4, var2);
        }

        SubInterface var5 = client.subInterfaces.lookup(var1.uid);
        if (var5 != null) {
            Statics26.method1112(var5.id, var3, var4, var2);
        }

        if (var1.contentType == 1337) {
        }

    }

    public static void drawScrollbar(int var0, int var1, int var2, int var3, int var4) {
        SerializableString.scrollbars[0].method1324(var0, var1);
        SerializableString.scrollbars[1].method1324(var0, var3 + var1 - 16);
        JagGraphics.fillRect(var0, var1 + 16, 16, var3 - 32, client.anInt980);
        int var5 = var3 * (var3 - 32) / var4;
        if (var5 < 8) {
            var5 = 8;
        }

        int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
        JagGraphics.fillRect(var0, var6 + var1 + 16, 16, var5, client.anInt987);
        JagGraphics.drawVerticalLine(var0, var6 + var1 + 16, var5, client.anInt990);
        JagGraphics.drawVerticalLine(var0 + 1, var6 + var1 + 16, var5, client.anInt990);
        JagGraphics.drawHorizontalLine(var0, var6 + var1 + 16, 16, client.anInt990);
        JagGraphics.drawHorizontalLine(var0, var6 + var1 + 17, 16, client.anInt990);
        JagGraphics.drawVerticalLine(var0 + 15, var6 + var1 + 16, var5, client.anInt983);
        JagGraphics.drawVerticalLine(var0 + 14, var6 + var1 + 17, var5 - 1, client.anInt983);
        JagGraphics.drawHorizontalLine(var0, var6 + var5 + var1 + 15, 16, client.anInt983);
        JagGraphics.drawHorizontalLine(var0 + 1, var5 + var6 + var1 + 14, 15, client.anInt983);
    }

    public static synchronized long currentTime() {
        long var0 = System.currentTimeMillis();
        if (var0 < Statics32.aLong1564) {
            Statics32.aLong1565 += Statics32.aLong1564 - var0;
        }

        Statics32.aLong1564 = var0;
        return var0 + Statics32.aLong1565;
    }

    public static void method192(String var0, boolean var1, boolean var3) {
        if (var1) {
            if (!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                try {
                    Desktop.getDesktop().browse(new URI(var0));
                    return;
                } catch (Exception ignored) {
                }
            }

            if (Statics1.aString325.startsWith("win") && !var3) {
                Statics46.method297(var0, 0);
                return;
            }

            if (Statics1.aString325.startsWith("mac")) {
                method191(var0, 1);
                return;
            }

            Statics46.method297(var0, 2);
        } else {
            Statics46.method297(var0, 3);
        }

    }

    public static boolean method191(String var0, int var1) {
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
                JSObjectUtil.call(Statics1.anApplet323, "loggedout");
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

    public static String method611(String var0, boolean var1) {
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
        if (Statics57.aString1162 != null) {
            var3 = "/p=" + Statics57.aString1162;
        }

        String var4 = "runescape.com";
        return var2 + var0 + "." + var4 + "/l=" + WorldMapLabelSize.aClientLocale_525 + "/a=" + WorldMapArea.anInt130 + var3 + "/";
    }

    public static void method1417(String var0) {
        Statics57.aString1162 = var0;

        try {
            String var1 = client.instance.getParameter(Integer.toString(18));
            String var2 = client.instance.getParameter(Integer.toString(13));
            String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
            if (var0.length() == 0) {
                var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
            } else {
                String var4 = var3 + "; Expires=";
                long var5 = currentTime() + 94608000000L;
                Statics12.aCalendar1207.setTime(new Date(var5));
                int var7 = Statics12.aCalendar1207.get(7);
                int var8 = Statics12.aCalendar1207.get(5);
                int var9 = Statics12.aCalendar1207.get(2);
                int var10 = Statics12.aCalendar1207.get(1);
                int var11 = Statics12.aCalendar1207.get(11);
                int var12 = Statics12.aCalendar1207.get(12);
                int var13 = Statics12.aCalendar1207.get(13);
                String var14 = Statics12.aStringArray1209[var7 - 1] + ", " + var8 / 10 + var8 % 10 + "-" + Statics12.aStringArrayArray1208[0][var9] + "-" + var10 + " " + var11 / 10 + var11 % 10 + ":" + var12 / 10 + var12 % 10 + ":" + var13 / 10 + var13 % 10 + " GMT";
                var3 = var4 + var14 + "; Max-Age=" + 94608000L;
            }

            JSObjectUtil.eval(client.instance, "document.cookie=\"" + var3 + "\"");
        } catch (Throwable ignored) {
        }

    }

    public final void destroy() {
        if (this == aGameEngine1305 && !aBoolean1311) {
            aLong1315 = currentTime();
            long var1 = 4999L;

            try {
                Thread.sleep(var1);
            } catch (InterruptedException ignored) {
            }

            try {
                Thread.sleep(1L);
            } catch (InterruptedException ignored) {
            }

            this.method940();
        }
    }

    protected final boolean method937() {
        String var1 = this.getDocumentBase().getHost().toLowerCase();
        if (!var1.equals("jagex.com") && !var1.endsWith(".jagex.com")) {
            if (!var1.equals("runescape.com") && !var1.endsWith(".runescape.com")) {
                if (var1.endsWith("127.0.0.1")) {
                    return true;
                }
                while (var1.length() > 0 && var1.charAt(var1.length() - 1) >= '0' && var1.charAt(var1.length() - 1) <= '9') {
                    var1 = var1.substring(0, var1.length() - 1);
                }

                if (var1.endsWith("192.168.1.")) {
                    return true;
                }
                this.method926("invalidhost");
                return false;
            }
            return true;
        }
        return true;
    }

    public final synchronized void paint(Graphics var1) {
        if (this == aGameEngine1305 && !aBoolean1311) {
            this.focused = true;
            if (currentTime() - this.aLong1304 > 1000L) {
                Rectangle var2 = var1.getClipBounds();
                if (var2 == null || var2.width >= client.canvasWidth && var2.height >= client.canvasHeight) {
                    this.aBoolean1293 = true;
                }
            }

        }
    }

    Bounds method927() {
        Container var1 = this.method930();
        int var2 = Math.max(var1.getWidth(), this.anInt1301);
        int var3 = Math.max(var1.getHeight(), this.anInt1291);
        if (this.aFrame1310 != null) {
            Insets var4 = this.aFrame1310.getInsets();
            var2 -= var4.left + var4.right;
            var3 -= var4.top + var4.bottom;
        }

        return new Bounds(var2, var3);
    }

    Container method930() {
        return (this.aFrame1310 != null ? this.aFrame1310 : this);
    }

    protected void method926(String var1) {
        if (!this.aBoolean1307) {
            this.aBoolean1307 = true;
            System.out.println("error_game_" + var1);

            try {
                this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
            } catch (Exception ignored) {
            }

        }
    }

    final void method934() {
        this.aBoolean1300 = true;
    }

    final synchronized void method940() {
        if (!aBoolean1311) {
            aBoolean1311 = true;

            try {
                this.canvas.removeFocusListener(this);
            } catch (Exception ignored) {
            }

            try {
                this.method747();
            } catch (Exception ignored) {
            }

            if (this.aFrame1310 != null) {
                try {
                    System.exit(0);
                } catch (Throwable ignored) {
                }
            }

            if (aOldConnectionTaskProcessor_1321 != null) {
                try {
                    aOldConnectionTaskProcessor_1321.method699();
                } catch (Exception ignored) {
                }
            }

            this.method743();
        }
    }

    final synchronized void method948() {
        Container var1 = this.method930();
        if (this.canvas != null) {
            this.canvas.removeFocusListener(this);
            var1.remove(this.canvas);
        }

        client.canvasWidth = Math.max(var1.getWidth(), this.anInt1301);
        client.canvasHeight = Math.max(var1.getHeight(), this.anInt1291);
        Insets var2;
        if (this.aFrame1310 != null) {
            var2 = this.aFrame1310.getInsets();
            client.canvasWidth -= var2.right + var2.left;
            client.canvasHeight -= var2.bottom + var2.top;
        }

        this.canvas = new jag.graphics.Canvas(this);
        var1.setBackground(Color.BLACK);
        var1.setLayout(null);
        var1.add(this.canvas);
        this.canvas.setSize(client.canvasWidth, client.canvasHeight);
        this.canvas.setVisible(true);
        this.canvas.setBackground(Color.BLACK);
        if (var1 == this.aFrame1310) {
            var2 = this.aFrame1310.getInsets();
            this.canvas.setLocation(var2.left + this.anInt1295, this.anInt1299 + var2.top);
        } else {
            this.canvas.setLocation(this.anInt1295, this.anInt1299);
        }

        this.canvas.addFocusListener(this);
        this.canvas.requestFocus();
        this.focused = true;
        if (WorldMapAreaChunk_Sub2.aGraphicsProvider_284 != null && client.canvasWidth == WorldMapAreaChunk_Sub2.aGraphicsProvider_284.anInt1817 && client.canvasHeight == WorldMapAreaChunk_Sub2.aGraphicsProvider_284.anInt1816) {
            ((ImageGraphicsProvider) WorldMapAreaChunk_Sub2.aGraphicsProvider_284).method21(this.canvas);
            WorldMapAreaChunk_Sub2.aGraphicsProvider_284.method22(0, 0);
        } else {
            WorldMapAreaChunk_Sub2.aGraphicsProvider_284 = new ImageGraphicsProvider(client.canvasWidth, client.canvasHeight, this.canvas);
        }

        this.aBoolean1293 = false;
        this.aLong1304 = currentTime();
    }

    protected abstract void method747();

    protected abstract void method745();

    final void method933() {
        Container var1 = this.method930();
        if (var1 != null) {
            Bounds var2 = this.method927();
            this.anInt1296 = Math.max(var2.anInt1812, this.anInt1301);
            this.anInt1312 = Math.max(var2.anInt1811, this.anInt1291);
            if (this.anInt1296 <= 0) {
                this.anInt1296 = 1;
            }

            if (this.anInt1312 <= 0) {
                this.anInt1312 = 1;
            }

            client.canvasWidth = Math.min(this.anInt1296, this.anInt1320);
            client.canvasHeight = Math.min(this.anInt1312, this.anInt1317);
            this.anInt1295 = (this.anInt1296 - client.canvasWidth) / 2;
            this.anInt1299 = 0;
            this.canvas.setSize(client.canvasWidth, client.canvasHeight);
            WorldMapAreaChunk_Sub2.aGraphicsProvider_284 = new ImageGraphicsProvider(client.canvasWidth, client.canvasHeight, this.canvas);
            if (var1 == this.aFrame1310) {
                Insets var3 = this.aFrame1310.getInsets();
                this.canvas.setLocation(var3.left + this.anInt1295, this.anInt1299 + var3.top);
            } else {
                this.canvas.setLocation(this.anInt1295, this.anInt1299);
            }

            this.focused = true;
            this.method737();
        }
    }

    protected final void method929() {
        EntityUID.anImage546 = null;
        AnimationSequence.aFont1227 = null;
        TileOverlay.aFontMetrics1467 = null;
    }

    protected abstract void method743();

    protected final void method935() {
        try {
            if (aGameEngine1305 != null) {
                ++anInt1316;
                if (anInt1316 >= 3) {
                    this.method926("alreadyloaded");
                    return;
                }

                this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
                return;
            }

            aGameEngine1305 = this;
            client.canvasWidth = 765;
            client.canvasHeight = 503;
            client.build = 184;
            Jagception.anApplet1881 = this;
            if (aOldConnectionTaskProcessor_1321 == null) {
                aOldConnectionTaskProcessor_1321 = new OldConnectionTaskProcessor();
            }

            aOldConnectionTaskProcessor_1321.method697(this, 1);
        } catch (Exception var5) {
            client.sendError(null, var5);
            this.method926("crash");
        }

    }

    protected final void method931(int var1, String var2, boolean var3) {
        try {
            Graphics var4 = this.canvas.getGraphics();
            if (AnimationSequence.aFont1227 == null) {
                AnimationSequence.aFont1227 = new java.awt.Font("Helvetica", 1, 13);
                TileOverlay.aFontMetrics1467 = this.canvas.getFontMetrics(AnimationSequence.aFont1227);
            }

            if (var3) {
                var4.setColor(Color.black);
                var4.fillRect(0, 0, client.canvasWidth, client.canvasHeight);
            }

            Color var5 = new Color(140, 17, 17);

            try {
                if (EntityUID.anImage546 == null) {
                    EntityUID.anImage546 = this.canvas.createImage(304, 34);
                }

                Graphics var6 = EntityUID.anImage546.getGraphics();
                var6.setColor(var5);
                var6.drawRect(0, 0, 303, 33);
                var6.fillRect(2, 2, var1 * 3, 30);
                var6.setColor(Color.black);
                var6.drawRect(1, 1, 301, 31);
                var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
                var6.setFont(AnimationSequence.aFont1227);
                var6.setColor(Color.white);
                var6.drawString(var2, (304 - TileOverlay.aFontMetrics1467.stringWidth(var2)) / 2, 22);
                var4.drawImage(EntityUID.anImage546, client.canvasWidth / 2 - 152, client.canvasHeight / 2 - 18, null);
            } catch (Exception var9) {
                int var7 = client.canvasWidth / 2 - 152;
                int var8 = client.canvasHeight / 2 - 18;
                var4.setColor(var5);
                var4.drawRect(var7, var8, 303, 33);
                var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
                var4.setColor(Color.black);
                var4.drawRect(var7 + 1, var8 + 1, 301, 31);
                var4.fillRect(var1 * 3 + var7 + 2, var8 + 2, 300 - var1 * 3, 30);
                var4.setFont(AnimationSequence.aFont1227);
                var4.setColor(Color.white);
                var4.drawString(var2, var7 + (304 - TileOverlay.aFontMetrics1467.stringWidth(var2)) / 2, var8 + 22);
            }
        } catch (Exception var10) {
            this.canvas.repaint();
        }

    }

    void processGraphics() {
        Container var1 = this.method930();
        long var2 = currentTime();
        long var4 = aLongArray1289[Varcs.anInt614];
        aLongArray1289[Varcs.anInt614] = var2;
        Varcs.anInt614 = Varcs.anInt614 + 1 & 31;
        if (var4 != 0L && var2 > var4) {
            int var6 = (int) (var2 - var4);
            anInt1292 = ((var6 >> 1) + 32000) / var6;
        }

        if (++anInt1306 - 1 > 50) {
            anInt1306 -= 50;
            this.focused = true;
            this.canvas.setSize(client.canvasWidth, client.canvasHeight);
            this.canvas.setVisible(true);
            if (var1 == this.aFrame1310) {
                Insets var7 = this.aFrame1310.getInsets();
                this.canvas.setLocation(this.anInt1295 + var7.left, var7.top + this.anInt1299);
            } else {
                this.canvas.setLocation(this.anInt1295, this.anInt1299);
            }
        }

        if (this.aBoolean1293) {
            this.method932();
        }

        this.method939();
        this.draw(this.focused);
        if (this.focused) {
            this.method942();
        }

        this.focused = false;
    }

    protected abstract void method736();

    void processEngine() {
        long var1 = currentTime();
        long var3 = aLongArray1313[WorldMapGroundDecorType.anInt310];
        aLongArray1313[WorldMapGroundDecorType.anInt310] = var1;
        WorldMapGroundDecorType.anInt310 = WorldMapGroundDecorType.anInt310 + 1 & 31;
        if (0L != var3 && var1 > var3) {
        }

        synchronized (this) {
            OldConnectionTaskProcessor.aBoolean853 = aBoolean1314;
        }

        this.method736();
    }

    final void method945(Object var1) {
        if (this.anEventQueue1294 != null) {
            for (int var2 = 0; var2 < 50 && this.anEventQueue1294.peekEvent() != null; ++var2) {
                try {
                    Thread.sleep(1L);
                } catch (InterruptedException ignored) {
                }
            }

            if (var1 != null) {
                this.anEventQueue1294.postEvent(new ActionEvent(var1, 1001, "dummy"));
            }

        }
    }

    protected final void method949() {
        Statics20.method921();
        java.awt.Canvas var1 = this.canvas;
        var1.setFocusTraversalKeysEnabled(false);
        var1.addKeyListener(Keyboard.instance);
        var1.addFocusListener(Keyboard.instance);
    }

    protected final void method938() {
        Statics48.method95(this.canvas);
    }

    final void method932() {
        Statics51.method343(this.canvas);
        CollisionMap.method155(this.canvas);
        if (this.aMouseWheel_1308 != null) {
            this.aMouseWheel_1308.method224(this.canvas);
        }

        this.method948();
        Canvas var1 = this.canvas;
        var1.setFocusTraversalKeysEnabled(false);
        var1.addKeyListener(Keyboard.instance);
        var1.addFocusListener(Keyboard.instance);
        Statics48.method95(this.canvas);
        if (this.aMouseWheel_1308 != null) {
            this.aMouseWheel_1308.method223(this.canvas);
        }

        this.method934();
    }

    protected MouseWheelProvider method943() {
        if (this.aMouseWheel_1308 == null) {
            this.aMouseWheel_1308 = new MouseWheel();
            this.aMouseWheel_1308.method223(this.canvas);
        }

        return this.aMouseWheel_1308;
    }

    final void method939() {
        Bounds var1 = this.method927();
        if (var1.anInt1812 != this.anInt1296 || this.anInt1312 != var1.anInt1811 || this.aBoolean1300) {
            this.method933();
            this.aBoolean1300 = false;
        }

    }

    protected abstract void draw(boolean var1);

    public final void method947(int var1, int var2) {
        if (this.anInt1320 != var1 || var2 != this.anInt1317) {
            this.method934();
        }

        this.anInt1320 = var1;
        this.anInt1317 = var2;
    }

    protected void method944() {
        this.aClipboard1302 = this.getToolkit().getSystemClipboard();
    }

    protected abstract void method737();

    void method942() {
        int var1 = this.anInt1295;
        int var2 = this.anInt1299;
        int var3 = this.anInt1296 - client.canvasWidth - var1;
        int var4 = this.anInt1312 - client.canvasHeight - var2;
        if (var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
            try {
                Container var5 = this.method930();
                int var6 = 0;
                int var7 = 0;
                if (var5 == this.aFrame1310) {
                    Insets var8 = this.aFrame1310.getInsets();
                    var6 = var8.left;
                    var7 = var8.top;
                }

                Graphics var10 = var5.getGraphics();
                var10.setColor(Color.black);
                if (var1 > 0) {
                    var10.fillRect(var6, var7, var1, this.anInt1312);
                }

                if (var2 > 0) {
                    var10.fillRect(var6, var7, this.anInt1296, var2);
                }

                if (var3 > 0) {
                    var10.fillRect(var6 + this.anInt1296 - var3, var7, var3, this.anInt1312);
                }

                if (var4 > 0) {
                    var10.fillRect(var6, var7 + this.anInt1312 - var4, this.anInt1296, var4);
                }
            } catch (Exception ignored) {
            }
        }

    }

    protected void method941(String var1) {
        this.aClipboard1302.setContents(new StringSelection(var1), null);
    }

    public final boolean hasFrame() {
        return this.aFrame1310 != null;
    }

    public void run() {
        try {
            if (OldConnectionTaskProcessor.aString855 != null) {
                String var1 = OldConnectionTaskProcessor.aString855.toLowerCase();
                if (var1.contains("sun") || var1.contains("apple")) {
                    String var2 = OldConnectionTaskProcessor.aString856;
                    if (var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                        this.method926("wrongjava");
                        return;
                    }

                    if (var2.startsWith("1.6.0_")) {
                        int var3;
                        for (var3 = 6; var3 < var2.length() && WorldMapIcon.method196(var2.charAt(var3)); ++var3) {
                        }

                        String var4 = var2.substring(6, var3);
                        if (OldConnection.parseInt(var4) && BaseFont.method1501(var4) < 10) {
                            this.method926("wrongjava");
                            return;
                        }
                    }

                    anInt1297 = 5;
                }
            }

            this.setFocusCycleRoot(true);
            this.method948();
            this.method745();
            clock = Clock.create();

            while (0L == aLong1315 || currentTime() < aLong1315) {
                anInt1309 = clock.sleep(anInt1303, anInt1297);

                for (int var5 = 0; var5 < anInt1309; ++var5) {
                    this.processEngine();
                }
                this.processGraphics();
                this.method945(this.canvas);
            }
        } catch (Exception var6) {
            client.sendError(null, var6);
            this.method926("crash");
        }

        this.method940();
    }

    public final void start() {
        if (this == aGameEngine1305 && !aBoolean1311) {
            aLong1315 = 0L;
        }
    }

    public final void stop() {
        if (this == aGameEngine1305 && !aBoolean1311) {
            aLong1315 = currentTime() + 4000L;
        }
    }

    public final void update(Graphics var1) {
        this.paint(var1);
    }

    public final void focusLost(FocusEvent var1) {
        aBoolean1314 = false;
    }

    public final void windowClosed(WindowEvent var1) {
    }

    public final void windowDeiconified(WindowEvent var1) {
    }

    public final void windowIconified(WindowEvent var1) {
    }

    public final void windowOpened(WindowEvent var1) {
    }

    public abstract void init();

    public final void windowClosing(WindowEvent var1) {
        this.destroy();
    }

    public final void windowActivated(WindowEvent var1) {
    }

    public final void windowDeactivated(WindowEvent var1) {
    }

    public final void focusGained(FocusEvent var1) {
        aBoolean1314 = true;
        this.focused = true;
    }
}
