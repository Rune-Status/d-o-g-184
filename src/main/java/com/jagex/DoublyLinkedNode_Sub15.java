package com.jagex;

public class DoublyLinkedNode_Sub15 extends DoublyLinkedNode {
    public static ReferenceCache aReferenceCache700;
    public static DoublyLinkedNode_Sub15[] aDoublyNode_Sub15Array1475;
    public static int anInt378;
    public static ReferenceTable aReferenceTable383;

    static {
        aReferenceCache700 = new ReferenceCache(256);
    }

    public final int anInt574;
    public int anInt112;
    public String aString1474;
    public Enum_Sub9 anEnum_Sub9_1477;
    public int anInt379;
    public Enum_Sub8 anEnum_Sub8_1472;
    public int anInt564;
    public String[] aStringArray1470;
    public int anInt1473;
    public String aString1476;
    int[] anIntArray1469;
    int anInt375;
    int anInt696;
    int anInt788;
    int anInt702;
    int anInt666;
    int[] anIntArray787;
    byte[] aByteArray1471;

    public DoublyLinkedNode_Sub15(int var1) {
        this.anInt112 = -1;
        this.anInt375 = -1;
        this.anInt564 = 0;
        this.aStringArray1470 = new String[5];
        this.anInt696 = Integer.MAX_VALUE;
        this.anInt702 = Integer.MAX_VALUE;
        this.anInt788 = Integer.MIN_VALUE;
        this.anInt666 = Integer.MIN_VALUE;
        this.anEnum_Sub9_1477 = Enum_Sub9.anEnum_Sub9_1485;
        this.anEnum_Sub8_1472 = Enum_Sub8.anEnum_Sub8_1481;
        this.anInt1473 = -1;
        this.anInt574 = var1;
    }

    public static void method1084(int var0, int var1) {
        Varpbit var2 = (Varpbit) Varpbit.aReferenceCache385.get((long) var0);
        Varpbit var3;
        if (var2 != null) {
            var3 = var2;
        } else {
            byte[] var8 = Varpbit.aReferenceTable383.unpack(14, var0);
            var2 = new Varpbit();
            if (var8 != null) {
                var2.method990(new Buffer(var8));
            }

            Varpbit.aReferenceCache385.put(var2, (long) var0);
            var3 = var2;
        }

        int var4 = var3.varpIndex;
        int var5 = var3.lower;
        int var6 = var3.upper;
        int var7 = Varps.anIntArray1908[var6 - var5];
        if (var1 < 0 || var1 > var7) {
            var1 = 0;
        }

        var7 <<= var5;
        Varps.values[var4] = Varps.values[var4] & ~var7 | var1 << var5 & var7;
    }

    public Sprite method1083() {
        int var2 = this.anInt112;
        return this.method1081(var2);
    }

    Sprite method1081(int var1) {
        if (var1 < 0) {
            return null;
        }
        Sprite var2 = (Sprite) aReferenceCache700.get((long) var1);
        if (var2 != null) {
            return var2;
        }
        var2 = Sprite.get(aReferenceTable383, var1, 0);
        if (var2 != null) {
            aReferenceCache700.put(var2, (long) var1);
        }

        return var2;
    }

    void method988(Buffer var1, int var2) {
        if (var2 == 1) {
            this.anInt112 = var1.method1051();
        } else if (var2 == 2) {
            this.anInt375 = var1.method1051();
        } else if (var2 == 3) {
            this.aString1474 = var1.readString();
        } else if (var2 == 4) {
            this.anInt379 = var1.readMediumInt();
        } else if (var2 == 5) {
            var1.readMediumInt();
        } else if (var2 == 6) {
            this.anInt564 = var1.readUByte();
        } else {
            int var3;
            if (var2 == 7) {
                var3 = var1.readUByte();
                if ((var3 & 1) == 0) {
                }

                if ((var3 & 2) == 2) {
                }
            } else if (var2 == 8) {
                var1.readUByte();
            } else if (var2 >= 10 && var2 <= 14) {
                this.aStringArray1470[var2 - 10] = var1.readString();
            } else if (var2 == 15) {
                var3 = var1.readUByte();
                this.anIntArray1469 = new int[var3 * 2];

                int var4;
                for (var4 = 0; var4 < var3 * 2; ++var4) {
                    this.anIntArray1469[var4] = var1.method1029();
                }

                var1.readInt();
                var4 = var1.readUByte();
                this.anIntArray787 = new int[var4];

                int var5;
                for (var5 = 0; var5 < this.anIntArray787.length; ++var5) {
                    this.anIntArray787[var5] = var1.readInt();
                }

                this.aByteArray1471 = new byte[var3];

                for (var5 = 0; var5 < var3; ++var5) {
                    this.aByteArray1471[var5] = var1.readByte();
                }
            } else if (var2 != 16) {
                if (var2 == 17) {
                    this.aString1476 = var1.readString();
                } else if (var2 == 18) {
                    var1.method1051();
                } else if (var2 == 19) {
                    this.anInt1473 = var1.readUShort();
                } else if (var2 == 21) {
                    var1.readInt();
                } else if (var2 == 22) {
                    var1.readInt();
                } else if (var2 == 23) {
                    var1.readUByte();
                    var1.readUByte();
                    var1.readUByte();
                } else if (var2 == 24) {
                    var1.method1029();
                    var1.method1029();
                } else if (var2 == 25) {
                    var1.method1051();
                } else if (var2 == 28) {
                    var1.readUByte();
                } else if (var2 == 29) {
                    this.anEnum_Sub9_1477 = (Enum_Sub9) OldConnection.method716(PlayerAppearance.method1435(), var1.readUByte());
                } else if (var2 == 30) {
                    Enum_Sub8[] var6 = new Enum_Sub8[]{Enum_Sub8.anEnum_Sub8_1480, Enum_Sub8.anEnum_Sub8_1479, Enum_Sub8.anEnum_Sub8_1481};
                    this.anEnum_Sub8_1472 = (Enum_Sub8) OldConnection.method716(var6, var1.readUByte());
                }
            }
        }

    }

    public int method1082() {
        return this.anInt574;
    }

    public void method990(Buffer var1) {
        while (true) {
            int var2 = var1.readUByte();
            if (var2 == 0) {
                return;
            }

            this.method988(var1, var2);
        }
    }

    public void method775() {
        if (this.anIntArray1469 != null) {
            for (int var1 = 0; var1 < this.anIntArray1469.length; var1 += 2) {
                if (this.anIntArray1469[var1] < this.anInt696) {
                    this.anInt696 = this.anIntArray1469[var1];
                } else if (this.anIntArray1469[var1] > this.anInt788) {
                    this.anInt788 = this.anIntArray1469[var1];
                }

                if (this.anIntArray1469[var1 + 1] < this.anInt702) {
                    this.anInt702 = this.anIntArray1469[var1 + 1];
                } else if (this.anIntArray1469[var1 + 1] > this.anInt666) {
                    this.anInt666 = this.anIntArray1469[var1 + 1];
                }
            }
        }

    }
}
