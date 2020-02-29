package com.jagex;

import java.util.HashSet;
import java.util.List;

public class Class9_Sub1 extends Class9 {
    List aList290;
    HashSet aHashSet291;
    HashSet aHashSet289;

    Class9_Sub1() {
    }

    static void method177(InterfaceComponent var0, int var1, int var2, int var3, int var4, int var5, int var6) {
        if (client.aBoolean984) {
            client.anInt976 = 32;
        } else {
            client.anInt976 = 0;
        }

        client.aBoolean984 = false;
        int var7;
        if (Mouse.pressMeta == 1 || !Class27_Sub1.aBoolean492 && Mouse.pressMeta == 4) {
            if (var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
                var0.insetY -= 4;
                Enum_Sub2.repaintComponent(var0);
            } else if (var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
                var0.insetY += 4;
                Enum_Sub2.repaintComponent(var0);
            } else if (var5 >= var1 - client.anInt976 && var5 < client.anInt976 + var1 + 16 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
                var7 = var3 * (var3 - 32) / var4;
                if (var7 < 8) {
                    var7 = 8;
                }

                int var8 = var6 - var2 - 16 - var7 / 2;
                int var9 = var3 - 32 - var7;
                var0.insetY = var8 * (var4 - var3) / var9;
                Enum_Sub2.repaintComponent(var0);
                client.aBoolean984 = true;
            }
        }

        if (client.anInt1086 != 0) {
            var7 = var0.width;
            if (var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
                var0.insetY += client.anInt1086 * 45;
                Enum_Sub2.repaintComponent(var0);
            }
        }

    }

    static void method173(int var0) {
        Inventory var1 = (Inventory) Inventory.cache.lookup((long) var0);
        if (var1 != null) {
            var1.unlink();
        }
    }

    static void method175(CacheReferenceTable var0) {
        Class46 var2 = new Class46(var0);
        client.anArrayList928.add(var2);
        client.anInt933 += var2.anInt428;
    }

    void method176(Buffer var1, boolean var2) {
        this.aList290 = new java.util.LinkedList();
        int var3 = var1.readUShort();

        for (int var4 = 0; var4 < var3; ++var4) {
            int var5 = var1.method1051();
            SceneOffset var6 = new SceneOffset(var1.readInt());
            boolean var7 = var1.readUByte() == 1;
            if (var2 || !var7) {
                this.aList290.add(new Class27_Sub2(null, var6, var5, null));
            }
        }

    }

    void method172(Buffer var1, Buffer var2, int var3, boolean var4) {
        this.method87(var1, var3);
        int var5 = var2.readUShort();
        this.aHashSet291 = new HashSet(var5);

        int var6;
        for (var6 = 0; var6 < var5; ++var6) {
            Class63_Sub2 var7 = new Class63_Sub2();

            try {
                var7.method109(var2);
            } catch (IllegalStateException var12) {
                continue;
            }

            this.aHashSet291.add(var7);
        }

        var6 = var2.readUShort();
        this.aHashSet289 = new HashSet(var6);

        for (int var9 = 0; var9 < var6; ++var9) {
            Class63_Sub1 var8 = new Class63_Sub1();

            try {
                var8.method109(var2);
            } catch (IllegalStateException var11) {
                continue;
            }

            this.aHashSet289.add(var8);
        }

        this.method176(var2, var4);
    }
}
