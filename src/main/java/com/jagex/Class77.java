package com.jagex;

import java.io.IOException;

public class Class77 {
    public static int anInt603;
    int anInt605;
    int anInt602;
    int anInt604;
    int anInt601;
    String aString600;

    Class77() {
    }

    public static void method420(Connection var0, boolean var1) {
        if (Statics25.connection != null) {
            try {
                Statics25.connection.stop();
            } catch (Exception ignored) {
            }

            Statics25.connection = null;
        }

        Statics25.connection = var0;
        Class152_Sub1.method803(var1);
        Statics25.aBuffer1489.caret = 0;
        Class25.aDoublyNode_Sub7_303 = null;
        Class104.aBuffer771 = null;
        Statics25.anInt1499 = 0;

        while (true) {
            DoublyLinkedNode_Sub7 var2 = (DoublyLinkedNode_Sub7) Statics25.aNodeTable1495.method314();
            if (var2 == null) {
                while (true) {
                    var2 = (DoublyLinkedNode_Sub7) Statics25.aNodeTable1487.method314();
                    if (var2 == null) {
                        if (Statics25.aByte1490 != 0) {
                            try {
                                Buffer var7 = new Buffer(4);
                                var7.writeByte(4);
                                var7.writeByte(Statics25.aByte1490);
                                var7.writeShort(0);
                                Statics25.connection.writeBytes(var7.payload, 0, 4);
                            } catch (IOException var5) {
                                try {
                                    Statics25.connection.stop();
                                } catch (Exception ignored) {
                                }

                                ++Statics25.anInt1488;
                                Statics25.connection = null;
                            }
                        }

                        Statics25.anInt1494 = 0;
                        Statics25.aLong1501 = Class24.currentTime();
                        return;
                    }

                    Statics25.aQueue1493.method301(var2);
                    Statics25.aNodeTable1503.put(var2, var2.key);
                    ++Statics25.anInt1491;
                    --Statics25.anInt1486;
                }
            }

            Statics25.aNodeTable1500.put(var2, var2.key);
            ++Statics25.anInt1497;
            --Statics25.anInt1496;
        }
    }

    public static void method419() {
        Statics2.aBoolean663 = false;
        Statics2.onCursorCount = 0;
    }
}
