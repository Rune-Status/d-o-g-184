package jag.graphics;

import jag.audi.DefaultAudioSystemProvider;
import jag.commons.collection.NodeDeque;
import jag.js5.ReferenceTable;
import jag.opcode.Buffer;
import jag.statics.Statics35;
import jag.statics.Statics45;
import jag.game.stockmarket.Class46;

public class DefaultMaterialProvider implements MaterialProvider {

    final Material[] materials;
    final int capacity;
    final ReferenceTable table;
    int size;
    double brightness;
    NodeDeque deque;
    int remaining;

    public DefaultMaterialProvider(ReferenceTable var1, ReferenceTable var2, int var3, double var4, int var6) {
        this.deque = new NodeDeque();
        this.remaining = 0;
        this.brightness = 1.0D;
        this.size = 128;
        this.table = var2;
        this.capacity = var3;
        this.remaining = this.capacity;
        this.brightness = var4;
        this.size = var6;
        int[] var7 = var1.getFileIds(0);
        int var8 = var7.length;
        this.materials = new Material[var1.method901(0)];

        for (int aVar7 : var7) {
            Buffer var10 = new Buffer(var1.unpack(0, aVar7));
            this.materials[aVar7] = new Material(var10);
        }

    }

    public static void method1517() {
        Statics45.anInt405 = 99;
        Statics45.aByteArrayArrayArray404 = new byte[4][104][104];
        Statics45.aByteArrayArrayArray401 = new byte[4][104][104];
        DefaultAudioSystemProvider.aByteArrayArrayArray141 = new byte[4][104][104];
        Statics35.aByteArrayArrayArray1615 = new byte[4][104][104];
        Statics45.anIntArrayArrayArray393 = new int[4][105][105];
        Statics45.aByteArrayArrayArray400 = new byte[4][105][105];
        DefaultAudioSystemProvider.anIntArrayArray146 = new int[105][105];
        Statics45.anIntArray396 = new int[104];
        Class46.anIntArray426 = new int[104];
        Statics45.anIntArray390 = new int[104];
        NamedFont.anIntArray1626 = new int[104];
        Statics45.anIntArray389 = new int[104];
    }

    public static Class method1515(String var0) throws ClassNotFoundException {
        if (var0.equals("B")) {
            return Byte.TYPE;
        }
        if (var0.equals("I")) {
            return Integer.TYPE;
        }
        if (var0.equals("S")) {
            return Short.TYPE;
        }
        if (var0.equals("J")) {
            return Long.TYPE;
        }
        if (var0.equals("Z")) {
            return Boolean.TYPE;
        }
        if (var0.equals("F")) {
            return Float.TYPE;
        }
        if (var0.equals("D")) {
            return Double.TYPE;
        }
        if (var0.equals("C")) {
            return Character.TYPE;
        }
        return var0.equals("void") ? Void.TYPE : Class.forName(var0);
    }

    public void clear() {
        for (Material anAMaterialArray2034 : this.materials) {
            if (anAMaterialArray2034 != null) {
                anAMaterialArray2034.method254();
            }
        }

        this.deque = new NodeDeque();
        this.remaining = this.capacity;
    }

    public int rgb(int var1) {
        return this.materials[var1] != null ? this.materials[var1].rgb : 0;
    }

    public int[] pixels(int var1) {
        Material var2 = this.materials[var1];
        if (var2 != null) {
            if (var2.anIntArray374 != null) {
                this.deque.insert(var2);
                var2.loaded = true;
                return var2.anIntArray374;
            }

            boolean var3 = var2.method503(this.brightness, this.size, this.table);
            if (var3) {
                if (this.remaining == 0) {
                    Material var4 = (Material) this.deque.popLast();
                    var4.method254();
                } else {
                    --this.remaining;
                }

                this.deque.insert(var2);
                var2.loaded = true;
                return var2.anIntArray374;
            }
        }

        return null;
    }

    public boolean isLowDetail() {
        return this.size == 64;
    }

    public boolean method1423(int var1) {
        return this.materials[var1].aBoolean571;
    }

    public int method1516() {
        int var1 = 0;
        int var2 = 0;

        for (Material var5 : this.materials) {
            if (var5 != null && var5.anIntArray687 != null) {
                var1 += var5.anIntArray687.length;
                int[] var6 = var5.anIntArray687;

                for (int var8 : var6) {
                    if (this.table.method910(var8)) {
                        ++var2;
                    }
                }
            }
        }

        if (var1 == 0) {
            return 0;
        }
        return var2 * 100 / var1;
    }

    public void method1519(double var1) {
        this.brightness = var1;
        this.clear();
    }

    public void method1518(int var1) {
        for (Material var3 : this.materials) {
            if (var3 != null && var3.anInt368 != 0 && var3.loaded) {
                var3.method502(var1);
                var3.loaded = false;
            }
        }

    }
}
