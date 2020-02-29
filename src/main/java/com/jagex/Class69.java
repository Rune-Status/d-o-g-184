package com.jagex;

public class Class69 {
    static int anInt543;
    final int anInt542;
    final int anInt544;
    final int anInt541;

    Class69(int var1, int var2, int var3) {
        this.anInt542 = var1;
        this.anInt544 = var2;
        this.anInt541 = var3;
    }

    static void method377(CacheReferenceTable var0, int var1, int var2, int var3, byte var4, boolean var5) {
        long var6 = (long) ((var1 << 16) + var2);
        DoublyLinkedNode_Sub7 var8 = (DoublyLinkedNode_Sub7) Statics25.aNodeTable1500.lookup(var6);
        if (var8 == null) {
            var8 = (DoublyLinkedNode_Sub7) Statics25.aNodeTable1495.lookup(var6);
            if (var8 == null) {
                var8 = (DoublyLinkedNode_Sub7) Statics25.aNodeTable1503.lookup(var6);
                if (var8 != null) {
                    if (var5) {
                        var8.unlinkDoubly();
                        Statics25.aNodeTable1500.put(var8, var6);
                        --Statics25.anInt1491;
                        ++Statics25.anInt1497;
                    }

                } else {
                    if (!var5) {
                        var8 = (DoublyLinkedNode_Sub7) Statics25.aNodeTable1487.lookup(var6);
                        if (var8 != null) {
                            return;
                        }
                    }

                    var8 = new DoublyLinkedNode_Sub7();
                    var8.aCacheReferenceTable1221 = var0;
                    var8.anInt568 = var3;
                    var8.aByte1220 = var4;
                    if (var5) {
                        Statics25.aNodeTable1500.put(var8, var6);
                        ++Statics25.anInt1497;
                    } else {
                        Statics25.aQueue1493.method300(var8);
                        Statics25.aNodeTable1503.put(var8, var6);
                        ++Statics25.anInt1491;
                    }

                }
            }
        }
    }

    static boolean method379(long var0) {
        return EntityUID.getObjectType(var0) == 2;
    }

    public static void method382(Class58 var0) {
        AudioSystem.aClass58_1840 = var0;
    }

    protected static void method383() {
        GameEngine.aClass135_1290.method677();

        int var0;
        for (var0 = 0; var0 < 32; ++var0) {
            GameEngine.aLongArray1289[var0] = 0L;
        }

        for (var0 = 0; var0 < 32; ++var0) {
            GameEngine.aLongArray1313[var0] = 0L;
        }

        GameEngine.anInt1309 = 0;
    }

    static void method376() {
        Class64.chatstreams.clear();
        Class64.A_ITERABLE_NODE_TABLE_523.method236();
        Class64.A_ITERABLE_DOUBLY_LINKED_NODE___522.method1133();
        Class64.anInt521 = 0;
    }

    static int method378(int var0, int var1) {
        int var2 = Class65.method363(45365 + var0, var1 + 91923, 4) - 128 + (Class65.method363(10294 + var0, 37821 + var1, 2) - 128 >> 1) + (Class65.method363(var0, var1, 1) - 128 >> 2);
        var2 = (int) ((double) var2 * 0.3D) + 35;
        if (var2 < 10) {
            var2 = 10;
        } else if (var2 > 60) {
            var2 = 60;
        }

        return var2;
    }

}
