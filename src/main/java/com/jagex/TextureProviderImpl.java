package com.jagex;

public class TextureProviderImpl implements TextureProvider {
    int anInt2030;
    double aDouble2031;
    Node_Sub8[] aNode_Sub8Array2034;
    NodeDeque aNodeDeque2035;
    int anInt2032;
    int anInt2033;
    ReferenceTable table;

    public TextureProviderImpl(ReferenceTable var1, ReferenceTable var2, int var3, double var4, int var6) {
        this.aNodeDeque2035 = new NodeDeque();
        this.anInt2032 = 0;
        this.aDouble2031 = 1.0D;
        this.anInt2030 = 128;
        this.table = var2;
        this.anInt2033 = var3;
        this.anInt2032 = this.anInt2033;
        this.aDouble2031 = var4;
        this.anInt2030 = var6;
        int[] var7 = var1.method894(0);
        int var8 = var7.length;
        this.aNode_Sub8Array2034 = new Node_Sub8[var1.method901(0)];

        for (int aVar7 : var7) {
            Buffer var10 = new Buffer(var1.unpack(0, aVar7));
            this.aNode_Sub8Array2034[aVar7] = new Node_Sub8(var10);
        }

    }

    static void method1517() {
        Class44.anInt405 = 99;
        Class44.aByteArrayArrayArray404 = new byte[4][104][104];
        Class44.aByteArrayArrayArray401 = new byte[4][104][104];
        Class12.aByteArrayArrayArray141 = new byte[4][104][104];
        Statics35.aByteArrayArrayArray1615 = new byte[4][104][104];
        Class44.anIntArrayArrayArray393 = new int[4][105][105];
        Class44.aByteArrayArrayArray400 = new byte[4][105][105];
        Class12.anIntArrayArray146 = new int[105][105];
        Class44.anIntArray396 = new int[104];
        Class46.anIntArray426 = new int[104];
        Class44.anIntArray390 = new int[104];
        Class199.anIntArray1626 = new int[104];
        Class44.anIntArray389 = new int[104];
    }

    static Class method1515(String var0) throws ClassNotFoundException {
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

    public static void method1513() {
        DefinitionProperty.cache.method334();
    }

    public void method1514() {
        for (Node_Sub8 anANode_Sub8Array2034 : this.aNode_Sub8Array2034) {
            if (anANode_Sub8Array2034 != null) {
                anANode_Sub8Array2034.method254();
            }
        }

        this.aNodeDeque2035 = new NodeDeque();
        this.anInt2032 = this.anInt2033;
    }

    public int method1424(int var1) {
        return this.aNode_Sub8Array2034[var1] != null ? this.aNode_Sub8Array2034[var1].anInt574 : 0;
    }

    public int[] method1425(int var1) {
        Node_Sub8 var2 = this.aNode_Sub8Array2034[var1];
        if (var2 != null) {
            if (var2.anIntArray374 != null) {
                this.aNodeDeque2035.insert(var2);
                var2.aBoolean688 = true;
                return var2.anIntArray374;
            }

            boolean var3 = var2.method503(this.aDouble2031, this.anInt2030, this.table);
            if (var3) {
                if (this.anInt2032 == 0) {
                    Node_Sub8 var4 = (Node_Sub8) this.aNodeDeque2035.popLast();
                    var4.method254();
                } else {
                    --this.anInt2032;
                }

                this.aNodeDeque2035.insert(var2);
                var2.aBoolean688 = true;
                return var2.anIntArray374;
            }
        }

        return null;
    }

    public boolean method1422() {
        return this.anInt2030 == 64;
    }

    public boolean method1423(int var1) {
        return this.aNode_Sub8Array2034[var1].aBoolean571;
    }

    public int method1516() {
        int var1 = 0;
        int var2 = 0;
        Node_Sub8[] var3 = this.aNode_Sub8Array2034;

        for (Node_Sub8 var5 : var3) {
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
        this.aDouble2031 = var1;
        this.method1514();
    }

    public void method1518(int var1) {
        for (Node_Sub8 var3 : this.aNode_Sub8Array2034) {
            if (var3 != null && var3.anInt368 != 0 && var3.aBoolean688) {
                var3.method502(var1);
                var3.aBoolean688 = false;
            }
        }

    }
}
