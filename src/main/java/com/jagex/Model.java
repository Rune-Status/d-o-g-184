package com.jagex;

public class Model extends Entity {
    static boolean[] aBooleanArray1733;
    static int[] anIntArray1740;
    static int[] anIntArray1743;
    static Model aModel1756;
    static byte[] aByteArray1141;
    static Model aModel1758;
    static int anInt714;
    static byte[] aByteArray503;
    static int[] anIntArray1749;
    static int anInt715;
    static int anInt712;
    static int[] anIntArray1730;
    static boolean[] aBooleanArray1732;
    static int[] anIntArray1729;
    static int[] anIntArray1742;
    static int[][] anIntArrayArray1737;
    static int[] anIntArray1735;
    static int[] anIntArray1734;
    static int[] anIntArray1748;
    static int[] anIntArray1738;
    static int[] anIntArray1728;
    static int[] anIntArray1731;
    static int[] anIntArray1750;
    static int[][] anIntArrayArray1736;
    static int[] anIntArray1741;
    static int[] anIntArray1746;
    static int[] anIntArray1751;
    static int[] anIntArray1744;
    static int[] anIntArray1745;
    static boolean aBoolean1747;

    static {
        aModel1758 = new Model();
        aByteArray503 = new byte[1];
        aModel1756 = new Model();
        aByteArray1141 = new byte[1];
        aBooleanArray1732 = new boolean[4700];
        aBooleanArray1733 = new boolean[4700];
        anIntArray1735 = new int[4700];
        anIntArray1734 = new int[4700];
        anIntArray1728 = new int[4700];
        anIntArray1738 = new int[4700];
        anIntArray1731 = new int[4700];
        anIntArray1730 = new int[4700];
        anIntArray1740 = new int[1600];
        anIntArrayArray1737 = new int[1600][512];
        anIntArray1729 = new int[12];
        anIntArrayArray1736 = new int[12][2000];
        anIntArray1751 = new int[2000];
        anIntArray1744 = new int[2000];
        anIntArray1742 = new int[12];
        anIntArray1748 = new int[10];
        anIntArray1750 = new int[10];
        anIntArray1746 = new int[10];
        aBoolean1747 = true;
        anIntArray1743 = JagGraphics3D.SIN_TABLE;
        anIntArray1749 = JagGraphics3D.COS_TABLE;
        anIntArray1745 = JagGraphics3D.anIntArray782;
        anIntArray1741 = JagGraphics3D.anIntArray785;
    }

    public boolean aabbEnabled;
    int anInt1105;
    int anInt711;
    int anInt704;
    int[][] anIntArrayArray1755;
    int anInt574;
    int[] xTriangles;
    int anInt379;
    int anInt694;
    int[] xVertices;
    int[] zVertices;
    int[] yTriangles;
    int[][] anIntArrayArray1754;
    int[] zTriangles;
    byte aByte1753;
    int anInt1739;
    int anInt575;
    int[] yVertices;
    byte[] aByteArray1757;
    byte[] aByteArray1438;
    int[] anIntArray689;
    int[] anIntArray374;
    int anInt556;
    int[] anIntArray1469;
    int anInt579;
    int anInt709;
    int anInt1436;
    int anInt1424;
    short[] aShortArray724;
    int anInt1437;
    byte[] aByteArray1752;
    int[] anIntArray782;
    int[] anIntArray1103;
    int[] anIntArray781;

    Model() {
        this.anInt574 = 0;
        this.anInt379 = 0;
        this.aByte1753 = 0;
        this.anInt575 = 0;
        this.aabbEnabled = false;
        this.anInt711 = -1;
        this.anInt709 = -1;
        this.anInt1424 = -1;
    }

    public Model(Model[] var1, int var2) {
        this.anInt574 = 0;
        this.anInt379 = 0;
        this.aByte1753 = 0;
        this.anInt575 = 0;
        this.aabbEnabled = false;
        this.anInt711 = -1;
        this.anInt709 = -1;
        this.anInt1424 = -1;
        boolean var3 = false;
        boolean var4 = false;
        boolean var5 = false;
        boolean var6 = false;
        this.anInt574 = 0;
        this.anInt379 = 0;
        this.anInt575 = 0;
        this.aByte1753 = -1;

        int var7;
        Model var8;
        for (var7 = 0; var7 < var2; ++var7) {
            var8 = var1[var7];
            if (var8 != null) {
                this.anInt574 += var8.anInt574;
                this.anInt379 += var8.anInt379;
                this.anInt575 += var8.anInt575;
                if (var8.aByteArray1757 != null) {
                    var3 = true;
                } else {
                    if (this.aByte1753 == -1) {
                        this.aByte1753 = var8.aByte1753;
                    }

                    if (this.aByte1753 != var8.aByte1753) {
                        var3 = true;
                    }
                }

                var4 |= var8.aByteArray1438 != null;
                var5 |= var8.aShortArray724 != null;
                var6 |= var8.aByteArray1752 != null;
            }
        }

        this.xVertices = new int[this.anInt574];
        this.yVertices = new int[this.anInt574];
        this.zVertices = new int[this.anInt574];
        this.xTriangles = new int[this.anInt379];
        this.yTriangles = new int[this.anInt379];
        this.zTriangles = new int[this.anInt379];
        this.anIntArray374 = new int[this.anInt379];
        this.anIntArray1469 = new int[this.anInt379];
        this.anIntArray689 = new int[this.anInt379];
        if (var3) {
            this.aByteArray1757 = new byte[this.anInt379];
        }

        if (var4) {
            this.aByteArray1438 = new byte[this.anInt379];
        }

        if (var5) {
            this.aShortArray724 = new short[this.anInt379];
        }

        if (var6) {
            this.aByteArray1752 = new byte[this.anInt379];
        }

        if (this.anInt575 > 0) {
            this.anIntArray782 = new int[this.anInt575];
            this.anIntArray1103 = new int[this.anInt575];
            this.anIntArray781 = new int[this.anInt575];
        }

        this.anInt574 = 0;
        this.anInt379 = 0;
        this.anInt575 = 0;

        for (var7 = 0; var7 < var2; ++var7) {
            var8 = var1[var7];
            if (var8 != null) {
                int var9;
                for (var9 = 0; var9 < var8.anInt379; ++var9) {
                    this.xTriangles[this.anInt379] = this.anInt574 + var8.xTriangles[var9];
                    this.yTriangles[this.anInt379] = this.anInt574 + var8.yTriangles[var9];
                    this.zTriangles[this.anInt379] = this.anInt574 + var8.zTriangles[var9];
                    this.anIntArray374[this.anInt379] = var8.anIntArray374[var9];
                    this.anIntArray1469[this.anInt379] = var8.anIntArray1469[var9];
                    this.anIntArray689[this.anInt379] = var8.anIntArray689[var9];
                    if (var3) {
                        if (var8.aByteArray1757 != null) {
                            this.aByteArray1757[this.anInt379] = var8.aByteArray1757[var9];
                        } else {
                            this.aByteArray1757[this.anInt379] = var8.aByte1753;
                        }
                    }

                    if (var4 && var8.aByteArray1438 != null) {
                        this.aByteArray1438[this.anInt379] = var8.aByteArray1438[var9];
                    }

                    if (var5) {
                        if (var8.aShortArray724 != null) {
                            this.aShortArray724[this.anInt379] = var8.aShortArray724[var9];
                        } else {
                            this.aShortArray724[this.anInt379] = -1;
                        }
                    }

                    if (var6) {
                        if (var8.aByteArray1752 != null && var8.aByteArray1752[var9] != -1) {
                            this.aByteArray1752[this.anInt379] = (byte) (this.anInt575 + var8.aByteArray1752[var9]);
                        } else {
                            this.aByteArray1752[this.anInt379] = -1;
                        }
                    }

                    ++this.anInt379;
                }

                for (var9 = 0; var9 < var8.anInt575; ++var9) {
                    this.anIntArray782[this.anInt575] = this.anInt574 + var8.anIntArray782[var9];
                    this.anIntArray1103[this.anInt575] = this.anInt574 + var8.anIntArray1103[var9];
                    this.anIntArray781[this.anInt575] = this.anInt574 + var8.anIntArray781[var9];
                    ++this.anInt575;
                }

                for (var9 = 0; var9 < var8.anInt574; ++var9) {
                    this.xVertices[this.anInt574] = var8.xVertices[var9];
                    this.yVertices[this.anInt574] = var8.yVertices[var9];
                    this.zVertices[this.anInt574] = var8.zVertices[var9];
                    ++this.anInt574;
                }
            }
        }

    }

    public void method827() {
        if (this.anInt704 != 1) {
            this.anInt704 = 1;
            super.height = 0;
            this.anInt1739 = 0;
            this.anInt694 = 0;

            for (int var1 = 0; var1 < this.anInt574; ++var1) {
                int var2 = this.xVertices[var1];
                int var3 = this.yVertices[var1];
                int var4 = this.zVertices[var1];
                if (-var3 > super.height) {
                    super.height = -var3;
                }

                if (var3 > this.anInt1739) {
                    this.anInt1739 = var3;
                }

                int var5 = var2 * var2 + var4 * var4;
                if (var5 > this.anInt694) {
                    this.anInt694 = var5;
                }
            }

            this.anInt694 = (int) (Math.sqrt((double) this.anInt694) + 0.99D);
            this.anInt1436 = (int) (Math.sqrt((double) (this.anInt694 * this.anInt694 + super.height * super.height)) + 0.99D);
            this.anInt1105 = this.anInt1436 + (int) (Math.sqrt((double) (this.anInt694 * this.anInt694 + this.anInt1739 * this.anInt1739)) + 0.99D);
        }
    }

    public void method1286(DoublyLinkedNode_Sub6 var1, int var2) {
        if (this.anIntArrayArray1755 != null) {
            if (var2 != -1) {
                Identikit var3 = var1.anIdentikitArray799[var2];
                Node_Sub13 var4 = var3.aNode_Sub13_1323;
                anInt714 = 0;
                anInt715 = 0;
                anInt712 = 0;

                for (int var5 = 0; var5 < var3.anInt1329; ++var5) {
                    int var6 = var3.anIntArray1322[var5];
                    this.method1292(var4.anIntArray749[var6], var4.anIntArrayArray810[var6], var3.anIntArray1330[var5], var3.anIntArray1326[var5], var3.anIntArray1327[var5]);
                }

                this.method972();
            }
        }
    }

    void method972() {
        this.anInt704 = 0;
        this.anInt711 = -1;
    }

    final void drawTriangle(int triangle) {
        int var2 = JagGraphics3D.anInt386;
        int var3 = JagGraphics3D.anInt366;
        int var4 = 0;
        int var5 = this.xTriangles[triangle];
        int var6 = this.yTriangles[triangle];
        int var7 = this.zTriangles[triangle];
        int var8 = anIntArray1730[var5];
        int var9 = anIntArray1730[var6];
        int var10 = anIntArray1730[var7];
        if (this.aByteArray1438 == null) {
            JagGraphics3D.alpha = 0;
        } else {
            JagGraphics3D.alpha = this.aByteArray1438[triangle] & 255;
        }

        int var11;
        int var12;
        int var13;
        int var14;
        if (var8 >= 50) {
            anIntArray1748[var4] = anIntArray1735[var5];
            anIntArray1750[var4] = anIntArray1734[var5];
            anIntArray1746[var4++] = this.anIntArray374[triangle];
        } else {
            var11 = anIntArray1738[var5];
            var12 = anIntArray1731[var5];
            var13 = this.anIntArray374[triangle];
            if (var10 >= 50) {
                var14 = anIntArray1741[var10 - var8] * (50 - var8);
                anIntArray1748[var4] = var2 + JagGraphics3D.anInt367 * (var11 + ((anIntArray1738[var7] - var11) * var14 >> 16)) / 50;
                anIntArray1750[var4] = var3 + JagGraphics3D.anInt367 * (var12 + ((anIntArray1731[var7] - var12) * var14 >> 16)) / 50;
                anIntArray1746[var4++] = var13 + ((this.anIntArray689[triangle] - var13) * var14 >> 16);
            }

            if (var9 >= 50) {
                var14 = anIntArray1741[var9 - var8] * (50 - var8);
                anIntArray1748[var4] = var2 + JagGraphics3D.anInt367 * (var11 + ((anIntArray1738[var6] - var11) * var14 >> 16)) / 50;
                anIntArray1750[var4] = var3 + JagGraphics3D.anInt367 * (var12 + ((anIntArray1731[var6] - var12) * var14 >> 16)) / 50;
                anIntArray1746[var4++] = var13 + ((this.anIntArray1469[triangle] - var13) * var14 >> 16);
            }
        }

        if (var9 >= 50) {
            anIntArray1748[var4] = anIntArray1735[var6];
            anIntArray1750[var4] = anIntArray1734[var6];
            anIntArray1746[var4++] = this.anIntArray1469[triangle];
        } else {
            var11 = anIntArray1738[var6];
            var12 = anIntArray1731[var6];
            var13 = this.anIntArray1469[triangle];
            if (var8 >= 50) {
                var14 = anIntArray1741[var8 - var9] * (50 - var9);
                anIntArray1748[var4] = var2 + JagGraphics3D.anInt367 * (var11 + ((anIntArray1738[var5] - var11) * var14 >> 16)) / 50;
                anIntArray1750[var4] = var3 + JagGraphics3D.anInt367 * (var12 + ((anIntArray1731[var5] - var12) * var14 >> 16)) / 50;
                anIntArray1746[var4++] = var13 + ((this.anIntArray374[triangle] - var13) * var14 >> 16);
            }

            if (var10 >= 50) {
                var14 = anIntArray1741[var10 - var9] * (50 - var9);
                anIntArray1748[var4] = var2 + JagGraphics3D.anInt367 * (var11 + ((anIntArray1738[var7] - var11) * var14 >> 16)) / 50;
                anIntArray1750[var4] = var3 + JagGraphics3D.anInt367 * (var12 + ((anIntArray1731[var7] - var12) * var14 >> 16)) / 50;
                anIntArray1746[var4++] = var13 + ((this.anIntArray689[triangle] - var13) * var14 >> 16);
            }
        }

        if (var10 >= 50) {
            anIntArray1748[var4] = anIntArray1735[var7];
            anIntArray1750[var4] = anIntArray1734[var7];
            anIntArray1746[var4++] = this.anIntArray689[triangle];
        } else {
            var11 = anIntArray1738[var7];
            var12 = anIntArray1731[var7];
            var13 = this.anIntArray689[triangle];
            if (var9 >= 50) {
                var14 = anIntArray1741[var9 - var10] * (50 - var10);
                anIntArray1748[var4] = var2 + JagGraphics3D.anInt367 * (var11 + ((anIntArray1738[var6] - var11) * var14 >> 16)) / 50;
                anIntArray1750[var4] = var3 + JagGraphics3D.anInt367 * (var12 + ((anIntArray1731[var6] - var12) * var14 >> 16)) / 50;
                anIntArray1746[var4++] = var13 + ((this.anIntArray1469[triangle] - var13) * var14 >> 16);
            }

            if (var8 >= 50) {
                var14 = anIntArray1741[var8 - var10] * (50 - var10);
                anIntArray1748[var4] = var2 + JagGraphics3D.anInt367 * (var11 + ((anIntArray1738[var5] - var11) * var14 >> 16)) / 50;
                anIntArray1750[var4] = var3 + JagGraphics3D.anInt367 * (var12 + ((anIntArray1731[var5] - var12) * var14 >> 16)) / 50;
                anIntArray1746[var4++] = var13 + ((this.anIntArray374[triangle] - var13) * var14 >> 16);
            }
        }

        var11 = anIntArray1748[0];
        var12 = anIntArray1748[1];
        var13 = anIntArray1748[2];
        var14 = anIntArray1750[0];
        int var15 = anIntArray1750[1];
        int var16 = anIntArray1750[2];
        JagGraphics3D.aBoolean792 = false;
        int var17;
        int var18;
        int var19;
        int var20;
        if (var4 == 3) {
            if (var11 < 0 || var12 < 0 || var13 < 0 || var11 > JagGraphics3D.anInt696 || var12 > JagGraphics3D.anInt696 || var13 > JagGraphics3D.anInt696) {
                JagGraphics3D.aBoolean792 = true;
            }

            if (this.aShortArray724 != null && this.aShortArray724[triangle] != -1) {
                if (this.aByteArray1752 != null && this.aByteArray1752[triangle] != -1) {
                    var17 = this.aByteArray1752[triangle] & 255;
                    var18 = this.anIntArray782[var17];
                    var19 = this.anIntArray1103[var17];
                    var20 = this.anIntArray781[var17];
                } else {
                    var18 = var5;
                    var19 = var6;
                    var20 = var7;
                }

                if (this.anIntArray689[triangle] == -1) {
                    JagGraphics3D.method619(var14, var15, var16, var11, var12, var13, this.anIntArray374[triangle], this.anIntArray374[triangle], this.anIntArray374[triangle], anIntArray1738[var18], anIntArray1738[var19], anIntArray1738[var20], anIntArray1731[var18], anIntArray1731[var19], anIntArray1731[var20], anIntArray1730[var18], anIntArray1730[var19], anIntArray1730[var20], this.aShortArray724[triangle]);
                } else {
                    JagGraphics3D.method619(var14, var15, var16, var11, var12, var13, anIntArray1746[0], anIntArray1746[1], anIntArray1746[2], anIntArray1738[var18], anIntArray1738[var19], anIntArray1738[var20], anIntArray1731[var18], anIntArray1731[var19], anIntArray1731[var20], anIntArray1730[var18], anIntArray1730[var19], anIntArray1730[var20], this.aShortArray724[triangle]);
                }
            } else if (this.anIntArray689[triangle] == -1) {
                JagGraphics3D.fillTriangle(var14, var15, var16, var11, var12, var13, anIntArray1745[this.anIntArray374[triangle]]);
            } else {
                JagGraphics3D.method627(var14, var15, var16, var11, var12, var13, anIntArray1746[0], anIntArray1746[1], anIntArray1746[2]);
            }
        }

        if (var4 == 4) {
            if (var11 < 0 || var12 < 0 || var13 < 0 || var11 > JagGraphics3D.anInt696 || var12 > JagGraphics3D.anInt696 || var13 > JagGraphics3D.anInt696 || anIntArray1748[3] < 0 || anIntArray1748[3] > JagGraphics3D.anInt696) {
                JagGraphics3D.aBoolean792 = true;
            }

            if (this.aShortArray724 != null && this.aShortArray724[triangle] != -1) {
                if (this.aByteArray1752 != null && this.aByteArray1752[triangle] != -1) {
                    var17 = this.aByteArray1752[triangle] & 255;
                    var18 = this.anIntArray782[var17];
                    var19 = this.anIntArray1103[var17];
                    var20 = this.anIntArray781[var17];
                } else {
                    var18 = var5;
                    var19 = var6;
                    var20 = var7;
                }

                short var21 = this.aShortArray724[triangle];
                if (this.anIntArray689[triangle] == -1) {
                    JagGraphics3D.method619(var14, var15, var16, var11, var12, var13, this.anIntArray374[triangle], this.anIntArray374[triangle], this.anIntArray374[triangle], anIntArray1738[var18], anIntArray1738[var19], anIntArray1738[var20], anIntArray1731[var18], anIntArray1731[var19], anIntArray1731[var20], anIntArray1730[var18], anIntArray1730[var19], anIntArray1730[var20], var21);
                    JagGraphics3D.method619(var14, var16, anIntArray1750[3], var11, var13, anIntArray1748[3], this.anIntArray374[triangle], this.anIntArray374[triangle], this.anIntArray374[triangle], anIntArray1738[var18], anIntArray1738[var19], anIntArray1738[var20], anIntArray1731[var18], anIntArray1731[var19], anIntArray1731[var20], anIntArray1730[var18], anIntArray1730[var19], anIntArray1730[var20], var21);
                } else {
                    JagGraphics3D.method619(var14, var15, var16, var11, var12, var13, anIntArray1746[0], anIntArray1746[1], anIntArray1746[2], anIntArray1738[var18], anIntArray1738[var19], anIntArray1738[var20], anIntArray1731[var18], anIntArray1731[var19], anIntArray1731[var20], anIntArray1730[var18], anIntArray1730[var19], anIntArray1730[var20], var21);
                    JagGraphics3D.method619(var14, var16, anIntArray1750[3], var11, var13, anIntArray1748[3], anIntArray1746[0], anIntArray1746[2], anIntArray1746[3], anIntArray1738[var18], anIntArray1738[var19], anIntArray1738[var20], anIntArray1731[var18], anIntArray1731[var19], anIntArray1731[var20], anIntArray1730[var18], anIntArray1730[var19], anIntArray1730[var20], var21);
                }
            } else if (this.anIntArray689[triangle] == -1) {
                var18 = anIntArray1745[this.anIntArray374[triangle]];
                JagGraphics3D.fillTriangle(var14, var15, var16, var11, var12, var13, var18);
                JagGraphics3D.fillTriangle(var14, var16, anIntArray1750[3], var11, var13, anIntArray1748[3], var18);
            } else {
                JagGraphics3D.method627(var14, var15, var16, var11, var12, var13, anIntArray1746[0], anIntArray1746[1], anIntArray1746[2]);
                JagGraphics3D.method627(var14, var16, anIntArray1750[3], var11, var13, anIntArray1748[3], anIntArray1746[0], anIntArray1746[2], anIntArray1746[3]);
            }
        }

    }

    Model method1293(boolean var1, Model var2, byte[] var3) {
        var2.anInt574 = this.anInt574;
        var2.anInt379 = this.anInt379;
        var2.anInt575 = this.anInt575;
        if (var2.xVertices == null || var2.xVertices.length < this.anInt574) {
            var2.xVertices = new int[this.anInt574 + 100];
            var2.yVertices = new int[this.anInt574 + 100];
            var2.zVertices = new int[this.anInt574 + 100];
        }

        int var4;
        for (var4 = 0; var4 < this.anInt574; ++var4) {
            var2.xVertices[var4] = this.xVertices[var4];
            var2.yVertices[var4] = this.yVertices[var4];
            var2.zVertices[var4] = this.zVertices[var4];
        }

        if (var1) {
            var2.aByteArray1438 = this.aByteArray1438;
        } else {
            var2.aByteArray1438 = var3;
            if (this.aByteArray1438 == null) {
                for (var4 = 0; var4 < this.anInt379; ++var4) {
                    var2.aByteArray1438[var4] = 0;
                }
            } else {
                for (var4 = 0; var4 < this.anInt379; ++var4) {
                    var2.aByteArray1438[var4] = this.aByteArray1438[var4];
                }
            }
        }

        var2.xTriangles = this.xTriangles;
        var2.yTriangles = this.yTriangles;
        var2.zTriangles = this.zTriangles;
        var2.anIntArray374 = this.anIntArray374;
        var2.anIntArray1469 = this.anIntArray1469;
        var2.anIntArray689 = this.anIntArray689;
        var2.aByteArray1757 = this.aByteArray1757;
        var2.aByteArray1752 = this.aByteArray1752;
        var2.aShortArray724 = this.aShortArray724;
        var2.aByte1753 = this.aByte1753;
        var2.anIntArray782 = this.anIntArray782;
        var2.anIntArray1103 = this.anIntArray1103;
        var2.anIntArray781 = this.anIntArray781;
        var2.anIntArrayArray1755 = this.anIntArrayArray1755;
        var2.anIntArrayArray1754 = this.anIntArrayArray1754;
        var2.aabbEnabled = this.aabbEnabled;
        var2.method972();
        return var2;
    }

    void method830(int var1) {
        if (this.anInt711 == -1) {
            int var2 = 0;
            int var3 = 0;
            int var4 = 0;
            int var5 = 0;
            int var6 = 0;
            int var7 = 0;
            int var8 = anIntArray1749[var1];
            int var9 = anIntArray1743[var1];

            for (int var10 = 0; var10 < this.anInt574; ++var10) {
                int var11 = JagGraphics3D.method625(this.xVertices[var10], this.zVertices[var10], var8, var9);
                int var12 = this.yVertices[var10];
                int var13 = JagGraphics3D.method628(this.xVertices[var10], this.zVertices[var10], var8, var9);
                if (var11 < var2) {
                    var2 = var11;
                }

                if (var11 > var5) {
                    var5 = var11;
                }

                if (var12 < var3) {
                    var3 = var12;
                }

                if (var12 > var6) {
                    var6 = var12;
                }

                if (var13 < var4) {
                    var4 = var13;
                }

                if (var13 > var7) {
                    var7 = var13;
                }
            }

            this.anInt556 = (var5 + var2) / 2;
            this.anInt579 = (var6 + var3) / 2;
            this.anInt1437 = (var7 + var4) / 2;
            this.anInt711 = (var5 - var2 + 1) / 2;
            this.anInt709 = (var6 - var3 + 1) / 2;
            this.anInt1424 = (var7 - var4 + 1) / 2;
            if (this.anInt711 < 32) {
                this.anInt711 = 32;
            }

            if (this.anInt1424 < 32) {
                this.anInt1424 = 32;
            }

            if (this.aabbEnabled) {
                this.anInt711 += 8;
                this.anInt1424 += 8;
            }

        }
    }

    public Model method1291(boolean var1) {
        if (!var1 && aByteArray503.length < this.anInt379) {
            aByteArray503 = new byte[this.anInt379 + 100];
        }

        return this.method1293(var1, aModel1758, aByteArray503);
    }

    void method828() {
        if (this.anInt704 != 2) {
            this.anInt704 = 2;
            this.anInt694 = 0;

            for (int var1 = 0; var1 < this.anInt574; ++var1) {
                int var2 = this.xVertices[var1];
                int var3 = this.yVertices[var1];
                int var4 = this.zVertices[var1];
                int var5 = var2 * var2 + var4 * var4 + var3 * var3;
                if (var5 > this.anInt694) {
                    this.anInt694 = var5;
                }
            }

            this.anInt694 = (int) (Math.sqrt((double) this.anInt694) + 0.99D);
            this.anInt1436 = this.anInt694;
            this.anInt1105 = this.anInt694 + this.anInt694;
        }
    }

    public Model method1294(boolean var1) {
        if (!var1 && aByteArray1141.length < this.anInt379) {
            aByteArray1141 = new byte[this.anInt379 + 100];
        }

        return this.method1293(var1, aModel1756, aByteArray1141);
    }

    public void method582(int var1) {
        int var2 = anIntArray1743[var1];
        int var3 = anIntArray1749[var1];

        for (int var4 = 0; var4 < this.anInt574; ++var4) {
            int var5 = var3 * this.yVertices[var4] - var2 * this.zVertices[var4] >> 16;
            this.zVertices[var4] = var2 * this.yVertices[var4] + var3 * this.zVertices[var4] >> 16;
            this.yVertices[var4] = var5;
        }

        this.method972();
    }

    public Model method1295(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
        this.method827();
        int var7 = var2 - this.anInt694;
        int var8 = var2 + this.anInt694;
        int var9 = var4 - this.anInt694;
        int var10 = var4 + this.anInt694;
        if (var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
            var7 >>= 7;
            var8 = var8 + 127 >> 7;
            var9 >>= 7;
            var10 = var10 + 127 >> 7;
            if (var3 == var1[var7][var9] && var3 == var1[var8][var9] && var3 == var1[var7][var10] && var3 == var1[var8][var10]) {
                return this;
            }
            Model var11;
            if (var5) {
                var11 = new Model();
                var11.anInt574 = this.anInt574;
                var11.anInt379 = this.anInt379;
                var11.anInt575 = this.anInt575;
                var11.xVertices = this.xVertices;
                var11.zVertices = this.zVertices;
                var11.xTriangles = this.xTriangles;
                var11.yTriangles = this.yTriangles;
                var11.zTriangles = this.zTriangles;
                var11.anIntArray374 = this.anIntArray374;
                var11.anIntArray1469 = this.anIntArray1469;
                var11.anIntArray689 = this.anIntArray689;
                var11.aByteArray1757 = this.aByteArray1757;
                var11.aByteArray1438 = this.aByteArray1438;
                var11.aByteArray1752 = this.aByteArray1752;
                var11.aShortArray724 = this.aShortArray724;
                var11.aByte1753 = this.aByte1753;
                var11.anIntArray782 = this.anIntArray782;
                var11.anIntArray1103 = this.anIntArray1103;
                var11.anIntArray781 = this.anIntArray781;
                var11.anIntArrayArray1755 = this.anIntArrayArray1755;
                var11.anIntArrayArray1754 = this.anIntArrayArray1754;
                var11.aabbEnabled = this.aabbEnabled;
                var11.yVertices = new int[var11.anInt574];
            } else {
                var11 = this;
            }

            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            int var20;
            int var21;
            if (var6 == 0) {
                for (var12 = 0; var12 < var11.anInt574; ++var12) {
                    var13 = var2 + this.xVertices[var12];
                    var14 = var4 + this.zVertices[var12];
                    var15 = var13 & 127;
                    var16 = var14 & 127;
                    var17 = var13 >> 7;
                    var18 = var14 >> 7;
                    var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                    var20 = var1[var17][var18 + 1] * (128 - var15) + var15 * var1[var17 + 1][var18 + 1] >> 7;
                    var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                    var11.yVertices[var12] = var21 + this.yVertices[var12] - var3;
                }
            } else {
                for (var12 = 0; var12 < var11.anInt574; ++var12) {
                    var13 = (-this.yVertices[var12] << 16) / super.height;
                    if (var13 < var6) {
                        var14 = var2 + this.xVertices[var12];
                        var15 = var4 + this.zVertices[var12];
                        var16 = var14 & 127;
                        var17 = var15 & 127;
                        var18 = var14 >> 7;
                        var19 = var15 >> 7;
                        var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                        var21 = var1[var18][var19 + 1] * (128 - var16) + var16 * var1[var18 + 1][var19 + 1] >> 7;
                        int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                        var11.yVertices[var12] = (var6 - var13) * (var22 - var3) / var6 + this.yVertices[var12];
                    }
                }
            }

            var11.method972();
            return var11;
        }
        return this;
    }

    void method11(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9) {
        anIntArray1740[0] = -1;
        if (this.anInt704 != 1) {
            this.method827();
        }

        this.method830(var1);
        int var11 = var5 * var8 - var4 * var6 >> 16;
        int var12 = var2 * var7 + var3 * var11 >> 16;
        int var13 = var3 * this.anInt694 >> 16;
        int var14 = var12 + var13;
        if (var14 > 50 && var12 < 3500) {
            int var15 = var8 * var4 + var5 * var6 >> 16;
            int var16 = (var15 - this.anInt694) * JagGraphics3D.anInt367;
            if (var16 / var14 < JagGraphics3D.anInt666) {
                int var17 = (var15 + this.anInt694) * JagGraphics3D.anInt367;
                if (var17 / var14 > JagGraphics3D.anInt788) {
                    int var18 = var3 * var7 - var11 * var2 >> 16;
                    int var19 = var2 * this.anInt694 >> 16;
                    int var20 = (var18 + var19) * JagGraphics3D.anInt367;
                    if (var20 / var14 > JagGraphics3D.anInt791) {
                        int var21 = (var3 * super.height >> 16) + var19;
                        int var22 = (var18 - var21) * JagGraphics3D.anInt367;
                        if (var22 / var14 < JagGraphics3D.anInt563) {
                            int var23 = var13 + (var2 * super.height >> 16);
                            boolean var24 = false;
                            boolean var25 = false;
                            if (var12 - var23 <= 50) {
                                var25 = true;
                            }

                            boolean var26 = var25 || this.anInt575 > 0;
                            int var27 = Class135.method722();
                            int var28 = Statics2.anInt661;
                            boolean var30 = Statics2.aBoolean663;
                            boolean var32 = Class149.method857(var9);
                            boolean var33 = false;
                            int var35;
                            int var36;
                            int var37;
                            if (var32 && var30) {
                                boolean var34 = false;
                                if (aBoolean1747) {
                                    var34 = Class42.method257(this, var6, var7, var8);
                                } else {
                                    var35 = var12 - var13;
                                    if (var35 <= 50) {
                                        var35 = 50;
                                    }

                                    if (var15 > 0) {
                                        var16 /= var14;
                                        var17 /= var35;
                                    } else {
                                        var17 /= var14;
                                        var16 /= var35;
                                    }

                                    if (var18 > 0) {
                                        var22 /= var14;
                                        var20 /= var35;
                                    } else {
                                        var20 /= var14;
                                        var22 /= var35;
                                    }

                                    var36 = var27 - JagGraphics3D.anInt386;
                                    var37 = var28 - JagGraphics3D.anInt366;
                                    if (var36 > var16 && var36 < var17 && var37 > var22 && var37 < var20) {
                                        var34 = true;
                                    }
                                }

                                if (var34) {
                                    if (this.aabbEnabled) {
                                        Statics2.onCursorUids[++Statics2.onCursorCount - 1] = var9;
                                    } else {
                                        var33 = true;
                                    }
                                }
                            }

                            int var47 = JagGraphics3D.anInt386;
                            var35 = JagGraphics3D.anInt366;
                            var36 = 0;
                            var37 = 0;
                            if (var1 != 0) {
                                var36 = anIntArray1743[var1];
                                var37 = anIntArray1749[var1];
                            }

                            for (int var40 = 0; var40 < this.anInt574; ++var40) {
                                int var41 = this.xVertices[var40];
                                int var42 = this.yVertices[var40];
                                int var43 = this.zVertices[var40];
                                int var44;
                                if (var1 != 0) {
                                    var44 = var43 * var36 + var41 * var37 >> 16;
                                    var43 = var43 * var37 - var41 * var36 >> 16;
                                    var41 = var44;
                                }

                                var41 += var6;
                                var42 += var7;
                                var43 += var8;
                                var44 = var43 * var4 + var5 * var41 >> 16;
                                var43 = var5 * var43 - var41 * var4 >> 16;
                                var41 = var44;
                                var44 = var3 * var42 - var43 * var2 >> 16;
                                var43 = var42 * var2 + var3 * var43 >> 16;
                                anIntArray1728[var40] = var43 - var12;
                                if (var43 >= 50) {
                                    anIntArray1735[var40] = var41 * JagGraphics3D.anInt367 / var43 + var47;
                                    anIntArray1734[var40] = var44 * JagGraphics3D.anInt367 / var43 + var35;
                                } else {
                                    anIntArray1735[var40] = -5000;
                                    var24 = true;
                                }

                                if (var26) {
                                    anIntArray1738[var40] = var41;
                                    anIntArray1731[var40] = var44;
                                    anIntArray1730[var40] = var43;
                                }
                            }

                            try {
                                this.translateToScreen(var24, var33, this.aabbEnabled, var9);
                            } catch (Exception ignored) {
                            }

                        }
                    }
                }
            }
        }
    }

    public void method981() {
        for (int var1 = 0; var1 < this.anInt574; ++var1) {
            int var2 = this.zVertices[var1];
            this.zVertices[var1] = this.xVertices[var1];
            this.xVertices[var1] = -var2;
        }

        this.method972();
    }

    public void scale(int var1, int var2, int var3) {
        for (int var4 = 0; var4 < this.anInt574; ++var4) {
            this.xVertices[var4] = this.xVertices[var4] * var1 / 128;
            this.yVertices[var4] = var2 * this.yVertices[var4] / 128;
            this.zVertices[var4] = var3 * this.zVertices[var4] / 128;
        }

        this.method972();
    }

    public void method1288() {
        for (int var1 = 0; var1 < this.anInt574; ++var1) {
            this.xVertices[var1] = -this.xVertices[var1];
            this.zVertices[var1] = -this.zVertices[var1];
        }

        this.method972();
    }

    public void method1283() {
        for (int var1 = 0; var1 < this.anInt574; ++var1) {
            int var2 = this.xVertices[var1];
            this.xVertices[var1] = this.zVertices[var1];
            this.zVertices[var1] = -var2;
        }

        this.method972();
    }

    final void method588(int var1) {
        if (aBooleanArray1733[var1]) {
            this.drawTriangle(var1);
        } else {
            int var2 = this.xTriangles[var1];
            int var3 = this.yTriangles[var1];
            int var4 = this.zTriangles[var1];
            JagGraphics3D.aBoolean792 = aBooleanArray1732[var1];
            if (this.aByteArray1438 == null) {
                JagGraphics3D.alpha = 0;
            } else {
                JagGraphics3D.alpha = this.aByteArray1438[var1] & 255;
            }

            if (this.aShortArray724 != null && this.aShortArray724[var1] != -1) {
                int var6;
                int var7;
                int var8;
                if (this.aByteArray1752 != null && this.aByteArray1752[var1] != -1) {
                    int var5 = this.aByteArray1752[var1] & 255;
                    var6 = this.anIntArray782[var5];
                    var7 = this.anIntArray1103[var5];
                    var8 = this.anIntArray781[var5];
                } else {
                    var6 = var2;
                    var7 = var3;
                    var8 = var4;
                }

                if (this.anIntArray689[var1] == -1) {
                    JagGraphics3D.method619(anIntArray1734[var2], anIntArray1734[var3], anIntArray1734[var4], anIntArray1735[var2], anIntArray1735[var3], anIntArray1735[var4], this.anIntArray374[var1], this.anIntArray374[var1], this.anIntArray374[var1], anIntArray1738[var6], anIntArray1738[var7], anIntArray1738[var8], anIntArray1731[var6], anIntArray1731[var7], anIntArray1731[var8], anIntArray1730[var6], anIntArray1730[var7], anIntArray1730[var8], this.aShortArray724[var1]);
                } else {
                    JagGraphics3D.method619(anIntArray1734[var2], anIntArray1734[var3], anIntArray1734[var4], anIntArray1735[var2], anIntArray1735[var3], anIntArray1735[var4], this.anIntArray374[var1], this.anIntArray1469[var1], this.anIntArray689[var1], anIntArray1738[var6], anIntArray1738[var7], anIntArray1738[var8], anIntArray1731[var6], anIntArray1731[var7], anIntArray1731[var8], anIntArray1730[var6], anIntArray1730[var7], anIntArray1730[var8], this.aShortArray724[var1]);
                }
            } else if (this.anIntArray689[var1] == -1) {
                JagGraphics3D.fillTriangle(anIntArray1734[var2], anIntArray1734[var3], anIntArray1734[var4], anIntArray1735[var2], anIntArray1735[var3], anIntArray1735[var4], anIntArray1745[this.anIntArray374[var1]]);
            } else {
                JagGraphics3D.method627(anIntArray1734[var2], anIntArray1734[var3], anIntArray1734[var4], anIntArray1735[var2], anIntArray1735[var3], anIntArray1735[var4], this.anIntArray374[var1], this.anIntArray1469[var1], this.anIntArray689[var1]);
            }

        }
    }

    public void method1285(DoublyLinkedNode_Sub6 var1, int var2, DoublyLinkedNode_Sub6 var3, int var4, int[] var5) {
        if (var2 != -1) {
            if (var5 != null && var4 != -1) {
                Identikit var6 = var1.anIdentikitArray799[var2];
                Identikit var7 = var3.anIdentikitArray799[var4];
                Node_Sub13 var8 = var6.aNode_Sub13_1323;
                anInt714 = 0;
                anInt715 = 0;
                anInt712 = 0;
                byte var9 = 0;
                int var13 = var9 + 1;
                int var10 = var5[var9];

                int var11;
                int var12;
                for (var11 = 0; var11 < var6.anInt1329; ++var11) {
                    for (var12 = var6.anIntArray1322[var11]; var12 > var10; var10 = var5[var13++]) {
                    }

                    if (var12 != var10 || var8.anIntArray749[var12] == 0) {
                        this.method1292(var8.anIntArray749[var12], var8.anIntArrayArray810[var12], var6.anIntArray1330[var11], var6.anIntArray1326[var11], var6.anIntArray1327[var11]);
                    }
                }

                anInt714 = 0;
                anInt715 = 0;
                anInt712 = 0;
                var9 = 0;
                var13 = var9 + 1;
                var10 = var5[var9];

                for (var11 = 0; var11 < var7.anInt1329; ++var11) {
                    for (var12 = var7.anIntArray1322[var11]; var12 > var10; var10 = var5[var13++]) {
                    }

                    if (var12 == var10 || var8.anIntArray749[var12] == 0) {
                        this.method1292(var8.anIntArray749[var12], var8.anIntArrayArray810[var12], var7.anIntArray1330[var11], var7.anIntArray1326[var11], var7.anIntArray1327[var11]);
                    }
                }

                this.method972();
            } else {
                this.method1286(var1, var2);
            }
        }
    }

    void method1292(int var1, int[] var2, int var3, int var4, int var5) {
        int var6 = var2.length;
        int var7;
        int var8;
        int var11;
        int var12;
        if (var1 == 0) {
            var7 = 0;
            anInt714 = 0;
            anInt715 = 0;
            anInt712 = 0;

            for (var8 = 0; var8 < var6; ++var8) {
                int var9 = var2[var8];
                if (var9 < this.anIntArrayArray1755.length) {
                    int[] var10 = this.anIntArrayArray1755[var9];

                    for (var11 = 0; var11 < var10.length; ++var11) {
                        var12 = var10[var11];
                        anInt714 += this.xVertices[var12];
                        anInt715 += this.yVertices[var12];
                        anInt712 += this.zVertices[var12];
                        ++var7;
                    }
                }
            }

            if (var7 > 0) {
                anInt714 = var3 + anInt714 / var7;
                anInt715 = var4 + anInt715 / var7;
                anInt712 = var5 + anInt712 / var7;
            } else {
                anInt714 = var3;
                anInt715 = var4;
                anInt712 = var5;
            }

        } else {
            int[] var13;
            int var14;
            int[] var10000;
            if (var1 == 1) {
                for (var7 = 0; var7 < var6; ++var7) {
                    var8 = var2[var7];
                    if (var8 < this.anIntArrayArray1755.length) {
                        var13 = this.anIntArrayArray1755[var8];

                        for (var14 = 0; var14 < var13.length; ++var14) {
                            var11 = var13[var14];
                            var10000 = this.xVertices;
                            var10000[var11] += var3;
                            var10000 = this.yVertices;
                            var10000[var11] += var4;
                            var10000 = this.zVertices;
                            var10000[var11] += var5;
                        }
                    }
                }

            } else if (var1 == 2) {
                for (var7 = 0; var7 < var6; ++var7) {
                    var8 = var2[var7];
                    if (var8 < this.anIntArrayArray1755.length) {
                        var13 = this.anIntArrayArray1755[var8];

                        for (var14 = 0; var14 < var13.length; ++var14) {
                            var11 = var13[var14];
                            var10000 = this.xVertices;
                            var10000[var11] -= anInt714;
                            var10000 = this.yVertices;
                            var10000[var11] -= anInt715;
                            var10000 = this.zVertices;
                            var10000[var11] -= anInt712;
                            var12 = (var3 & 255) * 8;
                            int var15 = (var4 & 255) * 8;
                            int var16 = (var5 & 255) * 8;
                            int var17;
                            int var18;
                            int var19;
                            if (var16 != 0) {
                                var17 = anIntArray1743[var16];
                                var18 = anIntArray1749[var16];
                                var19 = var17 * this.yVertices[var11] + var18 * this.xVertices[var11] >> 16;
                                this.yVertices[var11] = var18 * this.yVertices[var11] - var17 * this.xVertices[var11] >> 16;
                                this.xVertices[var11] = var19;
                            }

                            if (var12 != 0) {
                                var17 = anIntArray1743[var12];
                                var18 = anIntArray1749[var12];
                                var19 = var18 * this.yVertices[var11] - var17 * this.zVertices[var11] >> 16;
                                this.zVertices[var11] = var17 * this.yVertices[var11] + var18 * this.zVertices[var11] >> 16;
                                this.yVertices[var11] = var19;
                            }

                            if (var15 != 0) {
                                var17 = anIntArray1743[var15];
                                var18 = anIntArray1749[var15];
                                var19 = var17 * this.zVertices[var11] + var18 * this.xVertices[var11] >> 16;
                                this.zVertices[var11] = var18 * this.zVertices[var11] - var17 * this.xVertices[var11] >> 16;
                                this.xVertices[var11] = var19;
                            }

                            var10000 = this.xVertices;
                            var10000[var11] += anInt714;
                            var10000 = this.yVertices;
                            var10000[var11] += anInt715;
                            var10000 = this.zVertices;
                            var10000[var11] += anInt712;
                        }
                    }
                }

            } else if (var1 == 3) {
                for (var7 = 0; var7 < var6; ++var7) {
                    var8 = var2[var7];
                    if (var8 < this.anIntArrayArray1755.length) {
                        var13 = this.anIntArrayArray1755[var8];

                        for (var14 = 0; var14 < var13.length; ++var14) {
                            var11 = var13[var14];
                            var10000 = this.xVertices;
                            var10000[var11] -= anInt714;
                            var10000 = this.yVertices;
                            var10000[var11] -= anInt715;
                            var10000 = this.zVertices;
                            var10000[var11] -= anInt712;
                            this.xVertices[var11] = var3 * this.xVertices[var11] / 128;
                            this.yVertices[var11] = var4 * this.yVertices[var11] / 128;
                            this.zVertices[var11] = var5 * this.zVertices[var11] / 128;
                            var10000 = this.xVertices;
                            var10000[var11] += anInt714;
                            var10000 = this.yVertices;
                            var10000[var11] += anInt715;
                            var10000 = this.zVertices;
                            var10000[var11] += anInt712;
                        }
                    }
                }

            } else if (var1 == 5) {
                if (this.anIntArrayArray1754 != null && this.aByteArray1438 != null) {
                    for (var7 = 0; var7 < var6; ++var7) {
                        var8 = var2[var7];
                        if (var8 < this.anIntArrayArray1754.length) {
                            var13 = this.anIntArrayArray1754[var8];

                            for (var14 = 0; var14 < var13.length; ++var14) {
                                var11 = var13[var14];
                                var12 = (this.aByteArray1438[var11] & 255) + var3 * 8;
                                if (var12 < 0) {
                                    var12 = 0;
                                } else if (var12 > 255) {
                                    var12 = 255;
                                }

                                this.aByteArray1438[var11] = (byte) var12;
                            }
                        }
                    }
                }

            }
        }
    }

    final void translateToScreen(boolean var1, boolean var2, boolean var3, long var4) {
        if (this.anInt1105 < 1600) {
            int var6;
            for (var6 = 0; var6 < this.anInt1105; ++var6) {
                anIntArray1740[var6] = 0;
            }

            var6 = var3 ? 20 : 5;

            int var7;
            int var8;
            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var18;
            for (var7 = 0; var7 < this.anInt379; ++var7) {
                if (this.anIntArray689[var7] != -2) {
                    var8 = this.xTriangles[var7];
                    var11 = this.yTriangles[var7];
                    var10 = this.zTriangles[var7];
                    var12 = anIntArray1735[var8];
                    var13 = anIntArray1735[var11];
                    var14 = anIntArray1735[var10];
                    int var17;
                    int var34;
                    if (var1 && (var12 == -5000 || var13 == -5000 || var14 == -5000)) {
                        var34 = anIntArray1738[var8];
                        var15 = anIntArray1738[var11];
                        var16 = anIntArray1738[var10];
                        var17 = anIntArray1731[var8];
                        var18 = anIntArray1731[var11];
                        int var22 = anIntArray1731[var10];
                        int var23 = anIntArray1730[var8];
                        int var24 = anIntArray1730[var11];
                        int var25 = anIntArray1730[var10];
                        var34 -= var15;
                        var16 -= var15;
                        var17 -= var18;
                        var22 -= var18;
                        var23 -= var24;
                        var25 -= var24;
                        int var26 = var17 * var25 - var23 * var22;
                        int var27 = var23 * var16 - var34 * var25;
                        int var28 = var34 * var22 - var17 * var16;
                        if (var15 * var26 + var18 * var27 + var24 * var28 > 0) {
                            aBooleanArray1733[var7] = true;
                            int var29 = (anIntArray1728[var8] + anIntArray1728[var11] + anIntArray1728[var10]) / 3 + this.anInt1436;
                            anIntArrayArray1737[var29][anIntArray1740[var29]++] = var7;
                        }
                    } else {
                        if (var2) {
                            var15 = anIntArray1734[var8];
                            var16 = anIntArray1734[var11];
                            var17 = anIntArray1734[var10];
                            var18 = var6 + Statics2.anInt661;
                            boolean var19;
                            if (var18 < var15 && var18 < var16 && var18 < var17) {
                                var19 = false;
                            } else {
                                var18 = Statics2.anInt661 - var6;
                                if (var18 > var15 && var18 > var16 && var18 > var17) {
                                    var19 = false;
                                } else {
                                    var18 = var6 + Statics2.anInt656;
                                    if (var18 < var12 && var18 < var13 && var18 < var14) {
                                        var19 = false;
                                    } else {
                                        var18 = Statics2.anInt656 - var6;
                                        var19 = var18 <= var12 || var18 <= var13 || var18 <= var14;
                                    }
                                }
                            }

                            if (var19) {
                                Statics2.onCursorUids[++Statics2.onCursorCount - 1] = var4;
                                var2 = false;
                            }
                        }

                        if ((var12 - var13) * (anIntArray1734[var10] - anIntArray1734[var11]) - (var14 - var13) * (anIntArray1734[var8] - anIntArray1734[var11]) > 0) {
                            aBooleanArray1733[var7] = false;
                            aBooleanArray1732[var7] = var12 < 0 || var13 < 0 || var14 < 0 || var12 > JagGraphics3D.anInt696 || var13 > JagGraphics3D.anInt696 || var14 > JagGraphics3D.anInt696;

                            var34 = (anIntArray1728[var8] + anIntArray1728[var11] + anIntArray1728[var10]) / 3 + this.anInt1436;
                            anIntArrayArray1737[var34][anIntArray1740[var34]++] = var7;
                        }
                    }
                }
            }

            int[] var9;
            if (this.aByteArray1757 == null) {
                for (var7 = this.anInt1105 - 1; var7 >= 0; --var7) {
                    var8 = anIntArray1740[var7];
                    if (var8 > 0) {
                        var9 = anIntArrayArray1737[var7];

                        for (var10 = 0; var10 < var8; ++var10) {
                            this.method588(var9[var10]);
                        }
                    }
                }

            } else {
                for (var7 = 0; var7 < 12; ++var7) {
                    anIntArray1729[var7] = 0;
                    anIntArray1742[var7] = 0;
                }

                for (var7 = this.anInt1105 - 1; var7 >= 0; --var7) {
                    var8 = anIntArray1740[var7];
                    if (var8 > 0) {
                        var9 = anIntArrayArray1737[var7];

                        for (var10 = 0; var10 < var8; ++var10) {
                            var12 = var9[var10];
                            byte var33 = this.aByteArray1757[var12];
                            var14 = anIntArray1729[var33]++;
                            anIntArrayArray1736[var33][var14] = var12;
                            if (var33 < 10) {
                                int[] var10000 = anIntArray1742;
                                var10000[var33] += var7;
                            } else if (var33 == 10) {
                                anIntArray1751[var14] = var7;
                            } else {
                                anIntArray1744[var14] = var7;
                            }
                        }
                    }
                }

                var7 = 0;
                if (anIntArray1729[1] > 0 || anIntArray1729[2] > 0) {
                    var7 = (anIntArray1742[1] + anIntArray1742[2]) / (anIntArray1729[1] + anIntArray1729[2]);
                }

                var8 = 0;
                if (anIntArray1729[3] > 0 || anIntArray1729[4] > 0) {
                    var8 = (anIntArray1742[3] + anIntArray1742[4]) / (anIntArray1729[3] + anIntArray1729[4]);
                }

                var11 = 0;
                if (anIntArray1729[6] > 0 || anIntArray1729[8] > 0) {
                    var11 = (anIntArray1742[8] + anIntArray1742[6]) / (anIntArray1729[8] + anIntArray1729[6]);
                }

                var12 = 0;
                var13 = anIntArray1729[10];
                int[] var30 = anIntArrayArray1736[10];
                int[] var31 = anIntArray1751;
                if (var12 == var13) {
                    var12 = 0;
                    var13 = anIntArray1729[11];
                    var30 = anIntArrayArray1736[11];
                    var31 = anIntArray1744;
                }

                if (var12 < var13) {
                    var10 = var31[var12];
                } else {
                    var10 = -1000;
                }

                for (var15 = 0; var15 < 10; ++var15) {
                    while (var15 == 0 && var10 > var7) {
                        this.method588(var30[var12++]);
                        if (var12 == var13 && var30 != anIntArrayArray1736[11]) {
                            var12 = 0;
                            var13 = anIntArray1729[11];
                            var30 = anIntArrayArray1736[11];
                            var31 = anIntArray1744;
                        }

                        if (var12 < var13) {
                            var10 = var31[var12];
                        } else {
                            var10 = -1000;
                        }
                    }

                    while (var15 == 3 && var10 > var8) {
                        this.method588(var30[var12++]);
                        if (var12 == var13 && var30 != anIntArrayArray1736[11]) {
                            var12 = 0;
                            var13 = anIntArray1729[11];
                            var30 = anIntArrayArray1736[11];
                            var31 = anIntArray1744;
                        }

                        if (var12 < var13) {
                            var10 = var31[var12];
                        } else {
                            var10 = -1000;
                        }
                    }

                    while (var15 == 5 && var10 > var11) {
                        this.method588(var30[var12++]);
                        if (var12 == var13 && var30 != anIntArrayArray1736[11]) {
                            var12 = 0;
                            var13 = anIntArray1729[11];
                            var30 = anIntArrayArray1736[11];
                            var31 = anIntArray1744;
                        }

                        if (var12 < var13) {
                            var10 = var31[var12];
                        } else {
                            var10 = -1000;
                        }
                    }

                    var16 = anIntArray1729[var15];
                    int[] var32 = anIntArrayArray1736[var15];

                    for (var18 = 0; var18 < var16; ++var18) {
                        this.method588(var32[var18]);
                    }
                }

                while (var10 != -1000) {
                    this.method588(var30[var12++]);
                    if (var12 == var13 && var30 != anIntArrayArray1736[11]) {
                        var12 = 0;
                        var30 = anIntArrayArray1736[11];
                        var13 = anIntArray1729[11];
                        var31 = anIntArray1744;
                    }

                    if (var12 < var13) {
                        var10 = var31[var12];
                    } else {
                        var10 = -1000;
                    }
                }

            }
        }
    }

    public void method832(int var1, int var2, int var3) {
        for (int var4 = 0; var4 < this.anInt574; ++var4) {
            int[] var10000 = this.xVertices;
            var10000[var4] += var1;
            var10000 = this.yVertices;
            var10000[var4] += var2;
            var10000 = this.zVertices;
            var10000[var4] += var3;
        }

        this.method972();
    }

    public final void method1289(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        anIntArray1740[0] = -1;
        if (this.anInt704 != 2 && this.anInt704 != 1) {
            this.method828();
        }

        int var8 = JagGraphics3D.anInt386;
        int var9 = JagGraphics3D.anInt366;
        int var10 = anIntArray1743[var1];
        int var11 = anIntArray1749[var1];
        int var12 = anIntArray1743[var2];
        int var13 = anIntArray1749[var2];
        int var14 = anIntArray1743[var3];
        int var15 = anIntArray1749[var3];
        int var16 = anIntArray1743[var4];
        int var17 = anIntArray1749[var4];
        int var18 = var16 * var6 + var17 * var7 >> 16;

        for (int var19 = 0; var19 < this.anInt574; ++var19) {
            int var20 = this.xVertices[var19];
            int var21 = this.yVertices[var19];
            int var22 = this.zVertices[var19];
            int var23;
            if (var3 != 0) {
                var23 = var21 * var14 + var20 * var15 >> 16;
                var21 = var21 * var15 - var20 * var14 >> 16;
                var20 = var23;
            }

            if (var1 != 0) {
                var23 = var21 * var11 - var22 * var10 >> 16;
                var22 = var21 * var10 + var22 * var11 >> 16;
                var21 = var23;
            }

            if (var2 != 0) {
                var23 = var22 * var12 + var20 * var13 >> 16;
                var22 = var22 * var13 - var20 * var12 >> 16;
                var20 = var23;
            }

            var20 += var5;
            var21 += var6;
            var22 += var7;
            var23 = var21 * var17 - var22 * var16 >> 16;
            var22 = var21 * var16 + var22 * var17 >> 16;
            anIntArray1728[var19] = var22 - var18;
            anIntArray1735[var19] = var20 * JagGraphics3D.anInt367 / var22 + var8;
            anIntArray1734[var19] = var23 * JagGraphics3D.anInt367 / var22 + var9;
            if (this.anInt575 > 0) {
                anIntArray1738[var19] = var20;
                anIntArray1731[var19] = var23;
                anIntArray1730[var19] = var22;
            }
        }

        try {
            this.translateToScreen(false, false, false, 0L);
        } catch (Exception ignored) {
        }

    }

    public final void method1287(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        anIntArray1740[0] = -1;
        if (this.anInt704 != 2 && this.anInt704 != 1) {
            this.method828();
        }

        int var9 = JagGraphics3D.anInt386;
        int var10 = JagGraphics3D.anInt366;
        int var11 = anIntArray1743[var1];
        int var12 = anIntArray1749[var1];
        int var13 = anIntArray1743[var2];
        int var14 = anIntArray1749[var2];
        int var15 = anIntArray1743[var3];
        int var16 = anIntArray1749[var3];
        int var17 = anIntArray1743[var4];
        int var18 = anIntArray1749[var4];
        int var19 = var17 * var6 + var18 * var7 >> 16;

        for (int var20 = 0; var20 < this.anInt574; ++var20) {
            int var21 = this.xVertices[var20];
            int var22 = this.yVertices[var20];
            int var23 = this.zVertices[var20];
            int var24;
            if (var3 != 0) {
                var24 = var22 * var15 + var21 * var16 >> 16;
                var22 = var22 * var16 - var21 * var15 >> 16;
                var21 = var24;
            }

            if (var1 != 0) {
                var24 = var22 * var12 - var23 * var11 >> 16;
                var23 = var22 * var11 + var23 * var12 >> 16;
                var22 = var24;
            }

            if (var2 != 0) {
                var24 = var23 * var13 + var21 * var14 >> 16;
                var23 = var23 * var14 - var21 * var13 >> 16;
                var21 = var24;
            }

            var21 += var5;
            var22 += var6;
            var23 += var7;
            var24 = var22 * var18 - var23 * var17 >> 16;
            var23 = var22 * var17 + var23 * var18 >> 16;
            anIntArray1728[var20] = var23 - var19;
            anIntArray1735[var20] = var9 + var21 * JagGraphics3D.anInt367 / var8;
            anIntArray1734[var20] = var10 + var24 * JagGraphics3D.anInt367 / var8;
            if (this.anInt575 > 0) {
                anIntArray1738[var20] = var21;
                anIntArray1731[var20] = var24;
                anIntArray1730[var20] = var23;
            }
        }

        try {
            this.translateToScreen(false, false, false, 0L);
        } catch (Exception ignored) {
        }

    }

    public int method305() {
        this.method827();
        return this.anInt694;
    }
}
