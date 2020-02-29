package com.jagex;

public class Node_Sub8 extends Node {
    static int[] anIntArray689;
    int[] anIntArray687;
    int[] anIntArray374;
    boolean aBoolean571;
    boolean aBoolean688;
    int anInt368;
    int anInt574;
    int anInt367;
    int[] anIntArray690;
    int[] anIntArray692;
    int[] anIntArray691;

    Node_Sub8(Buffer var1) {
        this.aBoolean688 = false;
        this.anInt574 = var1.readUShort();
        this.aBoolean571 = var1.readUByte() == 1;
        int var2 = var1.readUByte();
        if (var2 >= 1 && var2 <= 4) {
            this.anIntArray687 = new int[var2];

            int var3;
            for (var3 = 0; var3 < var2; ++var3) {
                this.anIntArray687[var3] = var1.readUShort();
            }

            if (var2 > 1) {
                this.anIntArray692 = new int[var2 - 1];

                for (var3 = 0; var3 < var2 - 1; ++var3) {
                    this.anIntArray692[var3] = var1.readUByte();
                }
            }

            if (var2 > 1) {
                this.anIntArray691 = new int[var2 - 1];

                for (var3 = 0; var3 < var2 - 1; ++var3) {
                    this.anIntArray691[var3] = var1.readUByte();
                }
            }

            this.anIntArray690 = new int[var2];

            for (var3 = 0; var3 < var2; ++var3) {
                this.anIntArray690[var3] = var1.readInt();
            }

            this.anInt368 = var1.readUByte();
            this.anInt367 = var1.readUByte();
            this.anIntArray374 = null;
        } else {
            throw new RuntimeException();
        }
    }

    void method254() {
        this.anIntArray374 = null;
    }

    boolean method503(double var1, int var3, ReferenceTable var4) {
        int var5;
        for (var5 = 0; var5 < this.anIntArray687.length; ++var5) {
            if (var4.method896(this.anIntArray687[var5]) == null) {
                return false;
            }
        }

        var5 = var3 * var3;
        this.anIntArray374 = new int[var5];

        for (int var6 = 0; var6 < this.anIntArray687.length; ++var6) {
            int var7 = this.anIntArray687[var6];
            byte[] var8 = var4.method904(var7);
            boolean var9;
            if (var8 == null) {
                var9 = false;
            } else {
                Class44.method267(var8);
                var9 = true;
            }

            DoublyLinkedNode_Sub24_Sub4 var10;
            if (!var9) {
                var10 = null;
            } else {
                DoublyLinkedNode_Sub24_Sub4 var12 = new DoublyLinkedNode_Sub24_Sub4();
                var12.anInt375 = Statics41.anInt1824;
                var12.anInt372 = DoublyLinkedNode_Sub6.anInt378;
                var12.insetX = Statics41.anIntArray1821[0];
                var12.insetY = Node_Sub6_Sub4.anIntArray1107[0];
                var12.anInt378 = Statics41.anIntArray1820[0];
                var12.anInt377 = Jagception.anIntArray1878[0];
                var12.palette = Statics41.anIntArray1823;
                var12.indices = OutgoingPacket.aByteArrayArray114[0];
                Statics41.anIntArray1821 = null;
                Node_Sub6_Sub4.anIntArray1107 = null;
                Statics41.anIntArray1820 = null;
                Jagception.anIntArray1878 = null;
                Statics41.anIntArray1823 = null;
                OutgoingPacket.aByteArrayArray114 = null;
                var10 = var12;
            }

            var10.method499();
            var8 = var10.indices;
            int[] var18 = var10.palette;
            int var13 = this.anIntArray690[var6];
            if ((var13 & -16777216) == 16777216) {
            }

            if ((var13 & -16777216) == 33554432) {
            }

            int var14;
            int var15;
            int var16;
            int var17;
            if ((var13 & -16777216) == 50331648) {
                var14 = var13 & 16711935;
                var15 = var13 >> 8 & 255;

                for (var16 = 0; var16 < var18.length; ++var16) {
                    var17 = var18[var16];
                    if (var17 >> 8 == (var17 & 65535)) {
                        var17 &= 255;
                        var18[var16] = var14 * var17 >> 8 & 16711935 | var15 * var17 & 65280;
                    }
                }
            }

            for (var14 = 0; var14 < var18.length; ++var14) {
                var18[var14] = JagGraphics3D.method631(var18[var14], var1);
            }

            if (var6 == 0) {
                var14 = 0;
            } else {
                var14 = this.anIntArray692[var6 - 1];
            }

            if (var14 == 0) {
                if (var3 == var10.anInt378) {
                    for (var15 = 0; var15 < var5; ++var15) {
                        this.anIntArray374[var15] = var18[var8[var15] & 255];
                    }
                } else if (var10.anInt378 == 64 && var3 == 128) {
                    var15 = 0;

                    for (var16 = 0; var16 < var3; ++var16) {
                        for (var17 = 0; var17 < var3; ++var17) {
                            this.anIntArray374[var15++] = var18[var8[(var16 >> 1 << 6) + (var17 >> 1)] & 255];
                        }
                    }
                } else {
                    if (var10.anInt378 != 128 || var3 != 64) {
                        throw new RuntimeException();
                    }

                    var15 = 0;

                    for (var16 = 0; var16 < var3; ++var16) {
                        for (var17 = 0; var17 < var3; ++var17) {
                            this.anIntArray374[var15++] = var18[var8[(var17 << 1) + (var16 << 1 << 7)] & 255];
                        }
                    }
                }
            }

            if (var14 == 1) {
            }

            if (var14 == 2) {
            }

            if (var14 == 3) {
            }
        }

        return true;
    }

    void method502(int var1) {
        if (this.anIntArray374 != null) {
            short var2;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int[] var8;
            if (this.anInt368 == 1 || this.anInt368 == 3) {
                if (anIntArray689 == null || anIntArray689.length < this.anIntArray374.length) {
                    anIntArray689 = new int[this.anIntArray374.length];
                }

                if (this.anIntArray374.length == 4096) {
                    var2 = 64;
                } else {
                    var2 = 128;
                }

                var3 = this.anIntArray374.length;
                var4 = var2 * this.anInt367 * var1;
                var5 = var3 - 1;
                if (this.anInt368 == 1) {
                    var4 = -var4;
                }

                for (var6 = 0; var6 < var3; ++var6) {
                    var7 = var6 + var4 & var5;
                    anIntArray689[var6] = this.anIntArray374[var7];
                }

                var8 = this.anIntArray374;
                this.anIntArray374 = anIntArray689;
                anIntArray689 = var8;
            }

            if (this.anInt368 == 2 || this.anInt368 == 4) {
                if (anIntArray689 == null || anIntArray689.length < this.anIntArray374.length) {
                    anIntArray689 = new int[this.anIntArray374.length];
                }

                if (this.anIntArray374.length == 4096) {
                    var2 = 64;
                } else {
                    var2 = 128;
                }

                var3 = this.anIntArray374.length;
                var4 = this.anInt367 * var1;
                var5 = var2 - 1;
                if (this.anInt368 == 2) {
                    var4 = -var4;
                }

                for (var6 = 0; var6 < var3; var6 += var2) {
                    for (var7 = 0; var7 < var2; ++var7) {
                        int var9 = var6 + var7;
                        int var10 = var6 + (var7 + var4 & var5);
                        anIntArray689[var9] = this.anIntArray374[var10];
                    }
                }

                var8 = this.anIntArray374;
                this.anIntArray374 = anIntArray689;
                anIntArray689 = var8;
            }

        }
    }
}
