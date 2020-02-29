package com.jagex;

public class MouseRecorder implements Runnable {
    static int anInt388;
    boolean enabled;
    Object lock;
    int caret;
    int[] xHistory;
    int[] yHistory;
    long[] timeHistory;

    MouseRecorder() {
        enabled = true;
        lock = new Object();
        caret = 0;
        xHistory = new int[500];
        yHistory = new int[500];
        timeHistory = new long[500];
    }

    static void setGameState(int var0) {
        if (var0 != client.gameState) {
            if (client.gameState == 0) {
                client.instance.method929();
            }

            if (var0 == 20 || var0 == 40 || var0 == 45) {
                client.anInt956 = 0;
                client.anInt957 = 0;
                client.anInt954 = 0;
                client.aClass180_967.updateGameState(var0);
                if (var0 != 20) {
                    Enum_Sub6.method918(false);
                }
            }

            if (var0 != 20 && var0 != 40 && Class24.aConnection299 != null) {
                Class24.aConnection299.stop();
                Class24.aConnection299 = null;
            }

            if (client.gameState == 25) {
                client.anInt975 = 0;
                client.anInt966 = 0;
                client.anInt971 = 1;
                client.anInt968 = 0;
                client.anInt974 = 1;
            }

            if (var0 != 5 && var0 != 10) {
                if (var0 == 20) {
                    Class37.method245(client.aCacheReferenceTable948, Class74.sprites, true, client.gameState == 11 ? 4 : 0);
                } else if (var0 == 11) {
                    Class37.method245(client.aCacheReferenceTable948, Class74.sprites, false, 4);
                } else if (Class55.aBoolean476) {
                    Class8.aDoublyNode_Sub24_Sub4_126 = null;
                    Class216.aDoublyNode_Sub24_Sub4_1815 = null;
                    Class55.aDoublyNode_Sub24_Sub4Array478 = null;
                    Class26.aSprite308 = null;
                    Statics1.aSprite324 = null;
                    Class199.aDoublyNode_Sub24_Sub4_1623 = null;
                    AssociateComparator_Sub2.aDoublyNode_Sub24_Sub4Array765 = null;
                    Statics11.aDoublyNode_Sub24_Sub4_1148 = null;
                    Class20.aDoublyNode_Sub24_Sub4_288 = null;
                    Class46.aSpriteArray429 = null;
                    Class149.aDoublyNode_Sub24_Sub4Array1178 = null;
                    Class88.aDoublyNode_Sub24_Sub4Array653 = null;
                    DoublyLinkedNode_Sub6.aDoublyNode_Sub24_Sub4Array801 = null;
                    Node_Sub13.aDoublyNode_Sub24_Sub4_811 = null;
                    AsyncOutputStream.aClass45_105.method277();
                    Class147.anInt1157 = 1;
                    Class147.aReferenceTable1155 = null;
                    Statics8.anInt1122 = -1;
                    Class30.anInt327 = -1;
                    PickableNode.anInt379 = 0;
                    Enum_Sub2.aBoolean620 = false;
                    Class139.anInt1130 = 2;
                    Class152_Sub1.method803(true);
                    Class55.aBoolean476 = false;
                }
            } else {
                Class37.method245(client.aCacheReferenceTable948, Class74.sprites, true, 0);
            }

            client.gameState = var0;
        }
    }

    static boolean parseInt(CharSequence var0) {
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

    static void method265(InterfaceComponent[] var0, int var1) {
        for (InterfaceComponent var3 : var0) {
            if (var3 != null) {
                if (var3.type == 0) {
                    if (var3.components != null) {
                        method265(var3.components, var1);
                    }

                    InterfaceNode var4 = (InterfaceNode) client.interfaceNodes.lookup((long) var3.uid);
                    if (var4 != null) {
                        Class16.method118(var4.id, var1);
                    }
                }

                ScriptEvent var5;
                if (var1 == 0 && var3.anObjectArray1397 != null) {
                    var5 = new ScriptEvent();
                    var5.source = var3;
                    var5.args = var3.anObjectArray1397;
                    DefinitionProperty.fireScriptEvent(var5);
                }

                if (var1 == 1 && var3.anObjectArray1393 != null) {
                    if (var3.componentIndex >= 0) {
                        InterfaceComponent var6 = InterfaceComponent.lookup(var3.uid);
                        if (var6 == null || var6.components == null || var3.componentIndex >= var6.components.length || var3 != var6.components[var3.componentIndex]) {
                            continue;
                        }
                    }

                    var5 = new ScriptEvent();
                    var5.source = var3;
                    var5.args = var3.anObjectArray1393;
                    DefinitionProperty.fireScriptEvent(var5);
                }
            }
        }

    }

    public static void method263(ReferenceTable var0, ReferenceTable var1, ReferenceTable var2, ReferenceTable var3) {
        InterfaceComponent.aReferenceTable1375 = var0;
        Class125.aReferenceTable854 = var1;
        ClientPreferences.aReferenceTable364 = var2;
        Class87.aReferenceTable645 = var3;
        AssociateComparator_Sub5.interfaces = new InterfaceComponent[InterfaceComponent.aReferenceTable1375.method916()][];
        Statics2.validInterfaces = new boolean[InterfaceComponent.aReferenceTable1375.method916()];
    }

    public void run() {
        while (enabled) {
            synchronized (lock) {
                if (caret < 500) {
                    xHistory[caret] = Mouse.x;
                    yHistory[caret] = Mouse.y;
                    timeHistory[caret] = Mouse.lastMoveTime;
                    ++caret;
                }
            }

            long var3 = 49L;

            try {
                Thread.sleep(var3);
            } catch (InterruptedException ignored) {
            }

            try {
                Thread.sleep(1L);
            } catch (InterruptedException ignored) {
            }
        }

    }
}
