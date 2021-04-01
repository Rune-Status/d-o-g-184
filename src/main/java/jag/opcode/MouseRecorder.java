package jag.opcode;

import jag.SerializableLong;
import jag.commons.input.Mouse;
import jag.game.InterfaceComponent;
import jag.game.SubInterface;
import jag.game.client;
import jag.js5.ReferenceTable;
import jag.script.ScriptEvent;
import jag.statics.Statics2;

public class MouseRecorder implements Runnable {

    public static int anInt388;
    public final Object lock;
    public final int[] xs;
    public final int[] ys;
    public final long[] times;
    public boolean enabled;
    public int caret;

    public MouseRecorder() {
        enabled = true;
        lock = new Object();
        caret = 0;
        xs = new int[500];
        ys = new int[500];
        times = new long[500];
    }

    public static boolean parseInt(CharSequence var0) {
        boolean var3 = false;
        boolean var4 = false;
        int var5 = 0;
        int var6 = var0.length();

        for (int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if (var7 == 0) {
                if (var8 == '-') {
                    var3 = true;
                    continue;
                }

                if (var8 == '+') {
                    continue;
                }
            }

            int var10;
            if (var8 >= '0' && var8 <= '9') {
                var10 = var8 - '0';
            } else if (var8 >= 'A' && var8 <= 'Z') {
                var10 = var8 - '7';
            } else {
                if (var8 < 'a' || var8 > 'z') {
                    return false;
                }

                var10 = var8 - 'W';
            }

            if (var10 >= 10) {
                return false;
            }

            if (var3) {
                var10 = -var10;
            }

            int var9 = var10 + var5 * 10;
            if (var9 / 10 != var5) {
                return false;
            }

            var5 = var9;
            var4 = true;
        }

        return var4;
    }

    public static void method265(InterfaceComponent[] var0, int var1) {
        for (InterfaceComponent var3 : var0) {
            if (var3 != null) {
                if (var3.type == 0) {
                    if (var3.subcomponents != null) {
                        method265(var3.subcomponents, var1);
                    }

                    SubInterface var4 = client.subInterfaces.lookup(var3.uid);
                    if (var4 != null) {
                        InterfaceComponent.method118(var4.id, var1);
                    }
                }

                ScriptEvent var5;
                if (var1 == 0 && var3.anObjectArray1397 != null) {
                    var5 = new ScriptEvent();
                    var5.component = var3;
                    var5.args = var3.anObjectArray1397;
                    ScriptEvent.fire(var5);
                }

                if (var1 == 1 && var3.anObjectArray1393 != null) {
                    if (var3.subComponentIndex >= 0) {
                        InterfaceComponent var6 = InterfaceComponent.lookup(var3.uid);
                        if (var6 == null || var6.subcomponents == null || var3.subComponentIndex >= var6.subcomponents.length || var3 != var6.subcomponents[var3.subComponentIndex]) {
                            continue;
                        }
                    }

                    var5 = new ScriptEvent();
                    var5.component = var3;
                    var5.args = var3.anObjectArray1393;
                    ScriptEvent.fire(var5);
                }
            }
        }

    }

    public static void method263(ReferenceTable var0, ReferenceTable var1, ReferenceTable var2, ReferenceTable var3) {
        InterfaceComponent.aReferenceTable1375 = var0;
        OldConnectionTaskProcessor.aReferenceTable854 = var1;
        InterfaceComponent.aReferenceTable364 = var2;
        SerializableLong.aReferenceTable645 = var3;
        client.interfaces = new InterfaceComponent[InterfaceComponent.aReferenceTable1375.childrenCount()][];
        Statics2.validInterfaces = new boolean[InterfaceComponent.aReferenceTable1375.childrenCount()];
    }

    public void run() {
        while (enabled) {
            synchronized (lock) {
                if (caret < 500) {
                    xs[caret] = Mouse.x;
                    ys[caret] = Mouse.y;
                    times[caret] = Mouse.lastMoveTime;
                    ++caret;
                }
            }

            long time = 49L;

            try {
                Thread.sleep(time);
            } catch (InterruptedException ignored) {

            }

            try {
                Thread.sleep(1L);
            } catch (InterruptedException ignored) {
            }
        }

    }
}
