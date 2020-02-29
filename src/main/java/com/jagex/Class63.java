package com.jagex;

public abstract class Class63 {
    static int anInt513;
    boolean aBoolean504;
    short[][][] aShortArrayArrayArray518;
    int anInt517;
    int anInt516;
    int anInt512;
    int anInt514;
    boolean aBoolean507;
    short[][][] aShortArrayArrayArray508;
    Class69[][][][] aClass69ArrayArrayArrayArray511;
    int anInt509;
    byte[][][] aByteArrayArrayArray506;
    byte[][][] aByteArrayArrayArray505;
    int anInt515;
    int anInt519;
    int anInt510;

    Class63() {
        this.anInt514 = -1;
        this.anInt509 = -1;
        new java.util.LinkedList();
        this.aBoolean504 = false;
        this.aBoolean507 = false;
    }

    static void processComponentRendering(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
        if (Class63_Sub2.loadInterface(var0)) {
            Node_Sub19.processComponentEvents(AssociateComparator_Sub5.interfaces[var0], -1, var1, var2, var3, var4, var5, var6);
        }
    }

    public static DoublyLinkedNode_Sub16 method360(int var0) {
        DoublyLinkedNode_Sub16 var1 = (DoublyLinkedNode_Sub16) DoublyLinkedNode_Sub16.aReferenceCache701.get((long) var0);
        if (var1 != null) {
            return var1;
        }
        byte[] var2 = DoublyLinkedNode_Sub16.aReferenceTable383.unpack(16, var0);
        var1 = new DoublyLinkedNode_Sub16();
        if (var2 != null) {
            var1.method990(new Buffer(var2));
        }

        DoublyLinkedNode_Sub16.aReferenceCache701.put(var1, (long) var0);
        return var1;
    }

    static void method357(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
        if (var0 < var1) {
            int var6 = (var0 + var1) / 2;
            int var7 = var0;
            World var8 = World.worlds[var6];
            World.worlds[var6] = World.worlds[var1];
            World.worlds[var1] = var8;

            for (int var9 = var0; var9 < var1; ++var9) {
                if (Class46.method288(World.worlds[var9], var8, var2, var3, var4, var5) <= 0) {
                    World var10 = World.worlds[var9];
                    World.worlds[var9] = World.worlds[var7];
                    World.worlds[var7++] = var10;
                }
            }

            World.worlds[var1] = World.worlds[var7];
            World.worlds[var7] = var8;
            method357(var0, var7 - 1, var2, var3, var4, var5);
            method357(var7 + 1, var1, var2, var3, var4, var5);
        }

    }

    boolean method359() {
        return this.aBoolean504 && this.aBoolean507;
    }

    void method352() {
        this.aShortArrayArrayArray518 = null;
        this.aShortArrayArrayArray508 = null;
        this.aByteArrayArrayArray506 = null;
        this.aByteArrayArrayArray505 = null;
        this.aClass69ArrayArrayArrayArray511 = null;
        this.aBoolean504 = false;
        this.aBoolean507 = false;
    }

    void method355(int var1, int var2, Buffer var3, int var4) {
        boolean var5 = (var4 & 2) != 0;
        if (var5) {
            this.aShortArrayArrayArray508[0][var1][var2] = (short) var3.readUByte();
        }

        this.aShortArrayArrayArray518[0][var1][var2] = (short) var3.readUByte();
    }

    void method350(int var1, int var2, Buffer var3, int var4) {
        int var5 = ((var4 & 24) >> 3) + 1;
        boolean var6 = (var4 & 2) != 0;
        boolean var7 = (var4 & 4) != 0;
        this.aShortArrayArrayArray518[0][var1][var2] = (short) var3.readUByte();
        int var8;
        int var9;
        int var11;
        if (var6) {
            var8 = var3.readUByte();

            for (var9 = 0; var9 < var8; ++var9) {
                int var10 = var3.readUByte();
                if (var10 != 0) {
                    this.aShortArrayArrayArray508[var9][var1][var2] = (short) var10;
                    var11 = var3.readUByte();
                    this.aByteArrayArrayArray506[var9][var1][var2] = (byte) (var11 >> 2);
                    this.aByteArrayArrayArray505[var9][var1][var2] = (byte) (var11 & 3);
                }
            }
        }

        if (var7) {
            for (var8 = 0; var8 < var5; ++var8) {
                var9 = var3.readUByte();
                if (var9 != 0) {
                    Class69[] var12 = this.aClass69ArrayArrayArrayArray511[var8][var1][var2] = new Class69[var9];

                    for (var11 = 0; var11 < var9; ++var11) {
                        int var13 = var3.method1051();
                        int var14 = var3.readUByte();
                        var12[var11] = new Class69(var13, var14 >> 2, var14 & 3);
                    }
                }
            }
        }

    }

    void method354(ReferenceTable var1) {
        if (!this.method359()) {
            byte[] var2 = var1.unpack(this.anInt514, this.anInt509);
            if (var2 != null) {
                this.method111(new Buffer(var2));
                this.aBoolean504 = true;
                this.aBoolean507 = true;
            }

        }
    }

    int method353() {
        return this.anInt517;
    }

    int method358() {
        return this.anInt516;
    }

    abstract void method111(Buffer var1);

    void method351(int var1, int var2, Buffer var3) {
        int var4 = var3.readUByte();
        if (var4 != 0) {
            if ((var4 & 1) != 0) {
                this.method355(var1, var2, var3, var4);
            } else {
                this.method350(var1, var2, var3, var4);
            }

        }
    }
}
