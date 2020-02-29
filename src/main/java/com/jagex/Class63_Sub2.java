package com.jagex;

public class Class63_Sub2 extends Class63 {
    static CacheIndex aCacheIndex649;
    static BootSprites aBootSprites_647;
    static DoublyLinkedNode_Sub24_Sub4[] aDoublyNode_Sub24_Sub4Array648;

    Class63_Sub2() {
    }

    public static boolean loadInterface(int var0) {
        if (Statics2.validInterfaces[var0]) {
            return true;
        }
        if (!InterfaceComponent.aReferenceTable1375.method911(var0)) {
            return false;
        }
        int var1 = InterfaceComponent.aReferenceTable1375.method901(var0);
        if (var1 == 0) {
            Statics2.validInterfaces[var0] = true;
            return true;
        }
        if (AssociateComparator_Sub5.interfaces[var0] == null) {
            AssociateComparator_Sub5.interfaces[var0] = new InterfaceComponent[var1];
        }

        for (int var2 = 0; var2 < var1; ++var2) {
            if (AssociateComparator_Sub5.interfaces[var0][var2] == null) {
                byte[] var3 = InterfaceComponent.aReferenceTable1375.unpack(var0, var2);
                if (var3 != null) {
                    AssociateComparator_Sub5.interfaces[var0][var2] = new InterfaceComponent();
                    AssociateComparator_Sub5.interfaces[var0][var2].uid = var2 + (var0 << 16);
                    if (var3[0] == -1) {
                        AssociateComparator_Sub5.interfaces[var0][var2].method963(new Buffer(var3));
                    } else {
                        AssociateComparator_Sub5.interfaces[var0][var2].method962(new Buffer(var3));
                    }
                }
            }
        }

        Statics2.validInterfaces[var0] = true;
        return true;
    }

    public static int method473(CharSequence var0) {
        int var1 = var0.length();
        int var2 = 0;

        for (int var3 = 0; var3 < var1; ++var3) {
            var2 = (var2 << 5) - var2 + Entity.method10(var0.charAt(var3));
        }

        return var2;
    }

    static void method471(World[] var0, int var1, int var2, int[] var3, int[] var4) {
        if (var1 < var2) {
            int var5 = var1 - 1;
            int var6 = var2 + 1;
            int var7 = (var2 + var1) / 2;
            World var8 = var0[var7];
            var0[var7] = var0[var1];
            var0[var1] = var8;

            while (var5 < var6) {
                boolean var9 = true;

                int var10;
                int var11;
                int var12;
                do {
                    --var6;

                    for (var10 = 0; var10 < 4; ++var10) {
                        if (var3[var10] == 2) {
                            var11 = var0[var6].anInt1873;
                            var12 = var8.anInt1873;
                        } else if (var3[var10] == 1) {
                            var11 = var0[var6].population;
                            var12 = var8.population;
                            if (var11 == -1 && var4[var10] == 1) {
                                var11 = 2001;
                            }

                            if (var12 == -1 && var4[var10] == 1) {
                                var12 = 2001;
                            }
                        } else if (var3[var10] == 3) {
                            var11 = var0[var6].isMembers() ? 1 : 0;
                            var12 = var8.isMembers() ? 1 : 0;
                        } else {
                            var11 = var0[var6].anInt1875;
                            var12 = var8.anInt1875;
                        }

                        if (var11 != var12) {
                            if ((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                                var9 = false;
                            }
                            break;
                        }

                        if (var10 == 3) {
                            var9 = false;
                        }
                    }
                } while (var9);

                var9 = true;

                do {
                    ++var5;

                    for (var10 = 0; var10 < 4; ++var10) {
                        if (var3[var10] == 2) {
                            var11 = var0[var5].anInt1873;
                            var12 = var8.anInt1873;
                        } else if (var3[var10] == 1) {
                            var11 = var0[var5].population;
                            var12 = var8.population;
                            if (var11 == -1 && var4[var10] == 1) {
                                var11 = 2001;
                            }

                            if (var12 == -1 && var4[var10] == 1) {
                                var12 = 2001;
                            }
                        } else if (var3[var10] == 3) {
                            var11 = var0[var5].isMembers() ? 1 : 0;
                            var12 = var8.isMembers() ? 1 : 0;
                        } else {
                            var11 = var0[var5].anInt1875;
                            var12 = var8.anInt1875;
                        }

                        if (var12 != var11) {
                            if ((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                                var9 = false;
                            }
                            break;
                        }

                        if (var10 == 3) {
                            var9 = false;
                        }
                    }
                } while (var9);

                if (var5 < var6) {
                    World var13 = var0[var5];
                    var0[var5] = var0[var6];
                    var0[var6] = var13;
                }
            }

            method471(var0, var1, var6, var3, var4);
            method471(var0, var6 + 1, var2, var3, var4);
        }

    }

    public static void method470(int var0, ReferenceTable var1, String var2, String var3, int var4, boolean var5) {
        int var6 = var1.method900(var2);
        int var7 = var1.method907(var6, var3);
        Class147.anInt1157 = 1;
        Class147.aReferenceTable1155 = var1;
        Statics8.anInt1122 = var6;
        Class30.anInt327 = var7;
        PickableNode.anInt379 = var4;
        Enum_Sub2.aBoolean620 = var5;
        Class139.anInt1130 = var0;
    }

    void method109(Buffer var1) {
        int var2 = var1.readUByte();
        if (var2 != Class26.aClass26_311.anInt309) {
            throw new IllegalStateException("");
        }
        this.anInt515 = var1.readUByte();
        this.anInt512 = var1.readUByte();
        this.anInt519 = var1.readUShort() * 4096;
        this.anInt510 = var1.readUShort() * 64;
        this.anInt517 = var1.readUShort();
        this.anInt516 = var1.readUShort();
        this.anInt514 = var1.method1051();
        this.anInt509 = var1.method1051();
    }

    void method111(Buffer var1) {
        this.anInt512 = Math.min(this.anInt512, 4);
        this.aShortArrayArrayArray518 = new short[1][64][64];
        this.aShortArrayArrayArray508 = new short[this.anInt512][64][64];
        this.aByteArrayArrayArray506 = new byte[this.anInt512][64][64];
        this.aByteArrayArrayArray505 = new byte[this.anInt512][64][64];
        this.aClass69ArrayArrayArrayArray511 = new Class69[this.anInt512][64][64][];
        int var2 = var1.readUByte();
        if (var2 != Class24.aClass24_301.anInt300) {
            throw new IllegalStateException("");
        }
        int var3 = var1.readUByte();
        int var4 = var1.readUByte();
        if (var3 == this.anInt517 && var4 == this.anInt516) {
            for (int var5 = 0; var5 < 64; ++var5) {
                for (int var6 = 0; var6 < 64; ++var6) {
                    this.method351(var5, var6, var1);
                }
            }

        } else {
            throw new IllegalStateException("");
        }
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof Class63_Sub2)) {
            return false;
        }
        Class63_Sub2 var2 = (Class63_Sub2) var1;
        return var2.anInt517 == this.anInt517 && var2.anInt516 == this.anInt516;
    }

    public int hashCode() {
        return this.anInt517 | this.anInt516 << 8;
    }
}
