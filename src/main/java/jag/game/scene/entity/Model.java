package jag.game.scene.entity;

import jag.ClientLocale;
import jag.Identikit;
import jag.commons.time.Clock;
import jag.game.scene.SceneGraph;
import jag.game.type.AnimationFrameGroup;
import jag.game.type.Skeleton;
import jag.graphics.JagGraphics3D;
import jag.statics.Statics2;

public class Model extends Entity {

    public static final boolean[] aBooleanArray1733;
    public static final int[] anIntArray1740;
    public static final int[] SIN_TABLE;
    public static final Model aModel1756;
    public static final Model aModel1758;
    public static final int[] COS_TABLE;
    public static final int[] anIntArray1730;
    public static final boolean[] offscreenTriangles;
    public static final int[] anIntArray1729;
    public static final int[] anIntArray1742;
    public static final int[][] anIntArrayArray1737;
    public static final int[] screenX;
    public static final int[] screenY;
    public static final int[] anIntArray1748;
    public static final int[] anIntArray1738;
    public static final int[] anIntArray1728;
    public static final int[] anIntArray1731;
    public static final int[] anIntArray1750;
    public static final int[][] anIntArrayArray1736;
    public static final int[] anIntArray1741;
    public static final int[] anIntArray1746;
    public static final int[] anIntArray1751;
    public static final int[] anIntArray1744;
    public static final int[] colorPalette;
    public static final boolean aBoolean1747;
    public static byte[] aByteArray1141;
    public static int anInt714;
    public static byte[] aByteArray503;
    public static int anInt715;
    public static int anInt712;

    static {
        aModel1758 = new Model();
        aByteArray503 = new byte[1];
        aModel1756 = new Model();
        aByteArray1141 = new byte[1];
        offscreenTriangles = new boolean[4700];
        aBooleanArray1733 = new boolean[4700];
        screenX = new int[4700];
        screenY = new int[4700];
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
        SIN_TABLE = JagGraphics3D.SIN_TABLE;
        COS_TABLE = JagGraphics3D.COS_TABLE;
        colorPalette = JagGraphics3D.colorPalette;
        anIntArray1741 = JagGraphics3D.anIntArray785;
    }

    public boolean aabbEnabled;
    public int minimumDiagonal;
    public int anInt711;
    public int state;
    public int[][] anIntArrayArray1755;
    public int vertexCount;
    public int[] xTriangles;
    public int triangleCount;
    public int diagonal;
    public int[] xVertices;
    public int[] zVertices;
    public int[] yTriangles;
    public int[][] anIntArrayArray1754;
    public int[] zTriangles;
    public byte aByte1753;
    public int minimumHeight;
    public int texturedTriangleCount;
    public int[] yVertices;
    public byte[] aByteArray1757;
    public byte[] aByteArray1438;
    public int[] zTexturedTriangles;
    public int[] triangleColors;
    public int anInt556;
    public int[] yTexturedTriangles;
    public int anInt579;
    public int anInt709;
    public int maximumDiagonal;
    public int anInt1424;
    public short[] aShortArray724;
    public int anInt1437;
    public byte[] aByteArray1752;
    public int[] anIntArray782;
    public int[] anIntArray1103;
    public int[] anIntArray781;

    public Model() {
        vertexCount = 0;
        triangleCount = 0;
        aByte1753 = 0;
        texturedTriangleCount = 0;
        aabbEnabled = false;
        anInt711 = -1;
        anInt709 = -1;
        anInt1424 = -1;
    }

    public Model(Model[] children, int childrenCount) {
        vertexCount = 0;
        triangleCount = 0;
        aByte1753 = 0;
        texturedTriangleCount = 0;
        aabbEnabled = false;
        anInt711 = -1;
        anInt709 = -1;
        anInt1424 = -1;

        boolean var3 = false;
        boolean var4 = false;
        boolean var5 = false;
        boolean var6 = false;

        vertexCount = 0;
        triangleCount = 0;
        texturedTriangleCount = 0;
        aByte1753 = -1;

        for (int i = 0; i < childrenCount; ++i) {
            Model model = children[i];
            if (model != null) {
                vertexCount += model.vertexCount;
                triangleCount += model.triangleCount;
                texturedTriangleCount += model.texturedTriangleCount;
                if (model.aByteArray1757 != null) {
                    var3 = true;
                } else {
                    if (aByte1753 == -1) {
                        aByte1753 = model.aByte1753;
                    }

                    if (aByte1753 != model.aByte1753) {
                        var3 = true;
                    }
                }

                var4 |= model.aByteArray1438 != null;
                var5 |= model.aShortArray724 != null;
                var6 |= model.aByteArray1752 != null;
            }
        }

        xVertices = new int[vertexCount];
        yVertices = new int[vertexCount];
        zVertices = new int[vertexCount];
        xTriangles = new int[triangleCount];
        yTriangles = new int[triangleCount];
        zTriangles = new int[triangleCount];
        triangleColors = new int[triangleCount];
        yTexturedTriangles = new int[triangleCount];
        zTexturedTriangles = new int[triangleCount];
        if (var3) {
            aByteArray1757 = new byte[triangleCount];
        }

        if (var4) {
            aByteArray1438 = new byte[triangleCount];
        }

        if (var5) {
            aShortArray724 = new short[triangleCount];
        }

        if (var6) {
            aByteArray1752 = new byte[triangleCount];
        }

        if (texturedTriangleCount > 0) {
            anIntArray782 = new int[texturedTriangleCount];
            anIntArray1103 = new int[texturedTriangleCount];
            anIntArray781 = new int[texturedTriangleCount];
        }

        vertexCount = 0;
        triangleCount = 0;
        texturedTriangleCount = 0;

        for (int i = 0; i < childrenCount; ++i) {
            Model model = children[i];
            if (model != null) {
                for (int triangle = 0; triangle < model.triangleCount; ++triangle) {
                    xTriangles[triangleCount] = vertexCount + model.xTriangles[triangle];
                    yTriangles[triangleCount] = vertexCount + model.yTriangles[triangle];
                    zTriangles[triangleCount] = vertexCount + model.zTriangles[triangle];
                    triangleColors[triangleCount] = model.triangleColors[triangle];
                    yTexturedTriangles[triangleCount] = model.yTexturedTriangles[triangle];
                    zTexturedTriangles[triangleCount] = model.zTexturedTriangles[triangle];
                    if (var3) {
                        if (model.aByteArray1757 != null) {
                            aByteArray1757[triangleCount] = model.aByteArray1757[triangle];
                        } else {
                            aByteArray1757[triangleCount] = model.aByte1753;
                        }
                    }

                    if (var4 && model.aByteArray1438 != null) {
                        aByteArray1438[triangleCount] = model.aByteArray1438[triangle];
                    }

                    if (var5) {
                        if (model.aShortArray724 != null) {
                            aShortArray724[triangleCount] = model.aShortArray724[triangle];
                        } else {
                            aShortArray724[triangleCount] = -1;
                        }
                    }

                    if (var6) {
                        if (model.aByteArray1752 != null && model.aByteArray1752[triangle] != -1) {
                            aByteArray1752[triangleCount] = (byte) (texturedTriangleCount + model.aByteArray1752[triangle]);
                        } else {
                            aByteArray1752[triangleCount] = -1;
                        }
                    }

                    ++triangleCount;
                }

                for (int triangle = 0; triangle < model.texturedTriangleCount; ++triangle) {
                    anIntArray782[texturedTriangleCount] = vertexCount + model.anIntArray782[triangle];
                    anIntArray1103[texturedTriangleCount] = vertexCount + model.anIntArray1103[triangle];
                    anIntArray781[texturedTriangleCount] = vertexCount + model.anIntArray781[triangle];
                    ++texturedTriangleCount;
                }

                for (int vertice = 0; vertice < model.vertexCount; ++vertice) {
                    xVertices[vertexCount] = model.xVertices[vertice];
                    yVertices[vertexCount] = model.yVertices[vertice];
                    zVertices[vertexCount] = model.zVertices[vertice];
                    ++vertexCount;
                }
            }
        }
    }

    public void computeBounds() {
        if (state != 1) {
            state = 1;
            super.height = 0;
            minimumHeight = 0;
            diagonal = 0;

            for (int i = 0; i < vertexCount; ++i) {
                int var2 = xVertices[i];
                int var3 = yVertices[i];
                int var4 = zVertices[i];
                if (-var3 > super.height) {
                    super.height = -var3;
                }

                if (var3 > minimumHeight) {
                    minimumHeight = var3;
                }

                int var5 = var2 * var2 + var4 * var4;
                if (var5 > diagonal) {
                    diagonal = var5;
                }
            }

            diagonal = (int) (Math.sqrt(diagonal) + 0.99D);
            maximumDiagonal = (int) (Math.sqrt(diagonal * diagonal + super.height * super.height) + 0.99D);
            minimumDiagonal = maximumDiagonal + (int) (Math.sqrt(diagonal * diagonal + minimumHeight * minimumHeight) + 0.99D);
        }
    }

    public void method1286(AnimationFrameGroup var1, int var2) {
        if (anIntArrayArray1755 != null) {
            if (var2 != -1) {
                Identikit var3 = var1.identikits[var2];
                Skeleton var4 = var3.frame;
                anInt714 = 0;
                anInt715 = 0;
                anInt712 = 0;

                for (int i = 0; i < var3.anInt1329; ++i) {
                    int var6 = var3.anIntArray1322[i];
                    method1292(var4.types[var6], var4.labels[var6], var3.anIntArray1330[i], var3.anIntArray1326[i], var3.anIntArray1327[i]);
                }

                method972();
            }
        }
    }

    public void method972() {
        state = 0;
        anInt711 = -1;
    }

    public final void drawTriangle(int triangle) {
        int var2 = JagGraphics3D.anInt386;
        int var3 = JagGraphics3D.anInt366;
        int var4 = 0;
        int var5 = xTriangles[triangle];
        int var6 = yTriangles[triangle];
        int var7 = zTriangles[triangle];
        int var8 = anIntArray1730[var5];
        int var9 = anIntArray1730[var6];
        int var10 = anIntArray1730[var7];
        if (aByteArray1438 == null) {
            JagGraphics3D.alpha = 0;
        } else {
            JagGraphics3D.alpha = aByteArray1438[triangle] & 255;
        }

        int var11;
        int var12;
        int var13;
        int var14;
        if (var8 >= 50) {
            anIntArray1748[var4] = screenX[var5];
            anIntArray1750[var4] = screenY[var5];
            anIntArray1746[var4++] = triangleColors[triangle];
        } else {
            var11 = anIntArray1738[var5];
            var12 = anIntArray1731[var5];
            var13 = triangleColors[triangle];
            if (var10 >= 50) {
                var14 = anIntArray1741[var10 - var8] * (50 - var8);
                anIntArray1748[var4] = var2 + JagGraphics3D.anInt367 * (var11 + ((anIntArray1738[var7] - var11) * var14 >> 16)) / 50;
                anIntArray1750[var4] = var3 + JagGraphics3D.anInt367 * (var12 + ((anIntArray1731[var7] - var12) * var14 >> 16)) / 50;
                anIntArray1746[var4++] = var13 + ((zTexturedTriangles[triangle] - var13) * var14 >> 16);
            }

            if (var9 >= 50) {
                var14 = anIntArray1741[var9 - var8] * (50 - var8);
                anIntArray1748[var4] = var2 + JagGraphics3D.anInt367 * (var11 + ((anIntArray1738[var6] - var11) * var14 >> 16)) / 50;
                anIntArray1750[var4] = var3 + JagGraphics3D.anInt367 * (var12 + ((anIntArray1731[var6] - var12) * var14 >> 16)) / 50;
                anIntArray1746[var4++] = var13 + ((yTexturedTriangles[triangle] - var13) * var14 >> 16);
            }
        }

        if (var9 >= 50) {
            anIntArray1748[var4] = screenX[var6];
            anIntArray1750[var4] = screenY[var6];
            anIntArray1746[var4++] = yTexturedTriangles[triangle];
        } else {
            var11 = anIntArray1738[var6];
            var12 = anIntArray1731[var6];
            var13 = yTexturedTriangles[triangle];
            if (var8 >= 50) {
                var14 = anIntArray1741[var8 - var9] * (50 - var9);
                anIntArray1748[var4] = var2 + JagGraphics3D.anInt367 * (var11 + ((anIntArray1738[var5] - var11) * var14 >> 16)) / 50;
                anIntArray1750[var4] = var3 + JagGraphics3D.anInt367 * (var12 + ((anIntArray1731[var5] - var12) * var14 >> 16)) / 50;
                anIntArray1746[var4++] = var13 + ((triangleColors[triangle] - var13) * var14 >> 16);
            }

            if (var10 >= 50) {
                var14 = anIntArray1741[var10 - var9] * (50 - var9);
                anIntArray1748[var4] = var2 + JagGraphics3D.anInt367 * (var11 + ((anIntArray1738[var7] - var11) * var14 >> 16)) / 50;
                anIntArray1750[var4] = var3 + JagGraphics3D.anInt367 * (var12 + ((anIntArray1731[var7] - var12) * var14 >> 16)) / 50;
                anIntArray1746[var4++] = var13 + ((zTexturedTriangles[triangle] - var13) * var14 >> 16);
            }
        }

        if (var10 >= 50) {
            anIntArray1748[var4] = screenX[var7];
            anIntArray1750[var4] = screenY[var7];
            anIntArray1746[var4++] = zTexturedTriangles[triangle];
        } else {
            var11 = anIntArray1738[var7];
            var12 = anIntArray1731[var7];
            var13 = zTexturedTriangles[triangle];
            if (var9 >= 50) {
                var14 = anIntArray1741[var9 - var10] * (50 - var10);
                anIntArray1748[var4] = var2 + JagGraphics3D.anInt367 * (var11 + ((anIntArray1738[var6] - var11) * var14 >> 16)) / 50;
                anIntArray1750[var4] = var3 + JagGraphics3D.anInt367 * (var12 + ((anIntArray1731[var6] - var12) * var14 >> 16)) / 50;
                anIntArray1746[var4++] = var13 + ((yTexturedTriangles[triangle] - var13) * var14 >> 16);
            }

            if (var8 >= 50) {
                var14 = anIntArray1741[var8 - var10] * (50 - var10);
                anIntArray1748[var4] = var2 + JagGraphics3D.anInt367 * (var11 + ((anIntArray1738[var5] - var11) * var14 >> 16)) / 50;
                anIntArray1750[var4] = var3 + JagGraphics3D.anInt367 * (var12 + ((anIntArray1731[var5] - var12) * var14 >> 16)) / 50;
                anIntArray1746[var4++] = var13 + ((triangleColors[triangle] - var13) * var14 >> 16);
            }
        }

        var11 = anIntArray1748[0];
        var12 = anIntArray1748[1];
        var13 = anIntArray1748[2];
        var14 = anIntArray1750[0];
        int var15 = anIntArray1750[1];
        int var16 = anIntArray1750[2];
        JagGraphics3D.drawingOffscreen = false;
        int var17;
        int var18;
        int var19;
        int var20;
        if (var4 == 3) {
            if (var11 < 0 || var12 < 0 || var13 < 0 || var11 > JagGraphics3D.anInt696 || var12 > JagGraphics3D.anInt696 || var13 > JagGraphics3D.anInt696) {
                JagGraphics3D.drawingOffscreen = true;
            }

            if (aShortArray724 != null && aShortArray724[triangle] != -1) {
                if (aByteArray1752 != null && aByteArray1752[triangle] != -1) {
                    var17 = aByteArray1752[triangle] & 255;
                    var18 = anIntArray782[var17];
                    var19 = anIntArray1103[var17];
                    var20 = anIntArray781[var17];
                } else {
                    var18 = var5;
                    var19 = var6;
                    var20 = var7;
                }

                if (zTexturedTriangles[triangle] == -1) {
                    JagGraphics3D.method619(var14, var15, var16, var11, var12, var13, triangleColors[triangle], triangleColors[triangle], triangleColors[triangle], anIntArray1738[var18], anIntArray1738[var19], anIntArray1738[var20], anIntArray1731[var18], anIntArray1731[var19], anIntArray1731[var20], anIntArray1730[var18], anIntArray1730[var19], anIntArray1730[var20], aShortArray724[triangle]);
                } else {
                    JagGraphics3D.method619(var14, var15, var16, var11, var12, var13, anIntArray1746[0], anIntArray1746[1], anIntArray1746[2], anIntArray1738[var18], anIntArray1738[var19], anIntArray1738[var20], anIntArray1731[var18], anIntArray1731[var19], anIntArray1731[var20], anIntArray1730[var18], anIntArray1730[var19], anIntArray1730[var20], aShortArray724[triangle]);
                }
            } else if (zTexturedTriangles[triangle] == -1) {
                JagGraphics3D.fillTriangle(var14, var15, var16, var11, var12, var13, colorPalette[triangleColors[triangle]]);
            } else {
                JagGraphics3D.method627(var14, var15, var16, var11, var12, var13, anIntArray1746[0], anIntArray1746[1], anIntArray1746[2]);
            }
        }

        if (var4 == 4) {
            if (var11 < 0 || var12 < 0 || var13 < 0 || var11 > JagGraphics3D.anInt696 || var12 > JagGraphics3D.anInt696 || var13 > JagGraphics3D.anInt696 || anIntArray1748[3] < 0 || anIntArray1748[3] > JagGraphics3D.anInt696) {
                JagGraphics3D.drawingOffscreen = true;
            }

            if (aShortArray724 != null && aShortArray724[triangle] != -1) {
                if (aByteArray1752 != null && aByteArray1752[triangle] != -1) {
                    var17 = aByteArray1752[triangle] & 255;
                    var18 = anIntArray782[var17];
                    var19 = anIntArray1103[var17];
                    var20 = anIntArray781[var17];
                } else {
                    var18 = var5;
                    var19 = var6;
                    var20 = var7;
                }

                short var21 = aShortArray724[triangle];
                if (zTexturedTriangles[triangle] == -1) {
                    JagGraphics3D.method619(var14, var15, var16, var11, var12, var13, triangleColors[triangle], triangleColors[triangle], triangleColors[triangle], anIntArray1738[var18], anIntArray1738[var19], anIntArray1738[var20], anIntArray1731[var18], anIntArray1731[var19], anIntArray1731[var20], anIntArray1730[var18], anIntArray1730[var19], anIntArray1730[var20], var21);
                    JagGraphics3D.method619(var14, var16, anIntArray1750[3], var11, var13, anIntArray1748[3], triangleColors[triangle], triangleColors[triangle], triangleColors[triangle], anIntArray1738[var18], anIntArray1738[var19], anIntArray1738[var20], anIntArray1731[var18], anIntArray1731[var19], anIntArray1731[var20], anIntArray1730[var18], anIntArray1730[var19], anIntArray1730[var20], var21);
                } else {
                    JagGraphics3D.method619(var14, var15, var16, var11, var12, var13, anIntArray1746[0], anIntArray1746[1], anIntArray1746[2], anIntArray1738[var18], anIntArray1738[var19], anIntArray1738[var20], anIntArray1731[var18], anIntArray1731[var19], anIntArray1731[var20], anIntArray1730[var18], anIntArray1730[var19], anIntArray1730[var20], var21);
                    JagGraphics3D.method619(var14, var16, anIntArray1750[3], var11, var13, anIntArray1748[3], anIntArray1746[0], anIntArray1746[2], anIntArray1746[3], anIntArray1738[var18], anIntArray1738[var19], anIntArray1738[var20], anIntArray1731[var18], anIntArray1731[var19], anIntArray1731[var20], anIntArray1730[var18], anIntArray1730[var19], anIntArray1730[var20], var21);
                }
            } else if (zTexturedTriangles[triangle] == -1) {
                var18 = colorPalette[triangleColors[triangle]];
                JagGraphics3D.fillTriangle(var14, var15, var16, var11, var12, var13, var18);
                JagGraphics3D.fillTriangle(var14, var16, anIntArray1750[3], var11, var13, anIntArray1748[3], var18);
            } else {
                JagGraphics3D.method627(var14, var15, var16, var11, var12, var13, anIntArray1746[0], anIntArray1746[1], anIntArray1746[2]);
                JagGraphics3D.method627(var14, var16, anIntArray1750[3], var11, var13, anIntArray1748[3], anIntArray1746[0], anIntArray1746[2], anIntArray1746[3]);
            }
        }

    }

    public Model method1293(boolean var1, Model var2, byte[] var3) {
        var2.vertexCount = vertexCount;
        var2.triangleCount = triangleCount;
        var2.texturedTriangleCount = texturedTriangleCount;
        if (var2.xVertices == null || var2.xVertices.length < vertexCount) {
            var2.xVertices = new int[vertexCount + 100];
            var2.yVertices = new int[vertexCount + 100];
            var2.zVertices = new int[vertexCount + 100];
        }

        for (int i = 0; i < vertexCount; ++i) {
            var2.xVertices[i] = xVertices[i];
            var2.yVertices[i] = yVertices[i];
            var2.zVertices[i] = zVertices[i];
        }

        if (var1) {
            var2.aByteArray1438 = aByteArray1438;
        } else {
            var2.aByteArray1438 = var3;
            if (aByteArray1438 == null) {
                for (int i = 0; i < triangleCount; ++i) {
                    var2.aByteArray1438[i] = 0;
                }
            } else {
                for (int i = 0; i < triangleCount; ++i) {
                    var2.aByteArray1438[i] = aByteArray1438[i];
                }
            }
        }

        var2.xTriangles = xTriangles;
        var2.yTriangles = yTriangles;
        var2.zTriangles = zTriangles;
        var2.triangleColors = triangleColors;
        var2.yTexturedTriangles = yTexturedTriangles;
        var2.zTexturedTriangles = zTexturedTriangles;
        var2.aByteArray1757 = aByteArray1757;
        var2.aByteArray1752 = aByteArray1752;
        var2.aShortArray724 = aShortArray724;
        var2.aByte1753 = aByte1753;
        var2.anIntArray782 = anIntArray782;
        var2.anIntArray1103 = anIntArray1103;
        var2.anIntArray781 = anIntArray781;
        var2.anIntArrayArray1755 = anIntArrayArray1755;
        var2.anIntArrayArray1754 = anIntArrayArray1754;
        var2.aabbEnabled = aabbEnabled;
        var2.method972();
        return var2;
    }

    public void method830(int var1) {
        if (anInt711 == -1) {
            int var2 = 0;
            int var3 = 0;
            int var4 = 0;
            int var5 = 0;
            int var6 = 0;
            int var7 = 0;
            int var8 = COS_TABLE[var1];
            int var9 = SIN_TABLE[var1];

            for (int i = 0; i < vertexCount; ++i) {
                int var11 = JagGraphics3D.method625(xVertices[i], zVertices[i], var8, var9);
                int var12 = yVertices[i];
                int var13 = JagGraphics3D.method628(xVertices[i], zVertices[i], var8, var9);
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

            anInt556 = (var5 + var2) / 2;
            anInt579 = (var6 + var3) / 2;
            anInt1437 = (var7 + var4) / 2;
            anInt711 = (var5 - var2 + 1) / 2;
            anInt709 = (var6 - var3 + 1) / 2;
            anInt1424 = (var7 - var4 + 1) / 2;
            if (anInt711 < 32) {
                anInt711 = 32;
            }

            if (anInt1424 < 32) {
                anInt1424 = 32;
            }

            if (aabbEnabled) {
                anInt711 += 8;
                anInt1424 += 8;
            }

        }
    }

    public Model method1291(boolean var1) {
        if (!var1 && aByteArray503.length < triangleCount) {
            aByteArray503 = new byte[triangleCount + 100];
        }

        return method1293(var1, aModel1758, aByteArray503);
    }

    public void method828() {
        if (state != 2) {
            state = 2;
            diagonal = 0;

            for (int i = 0; i < vertexCount; ++i) {
                int x = xVertices[i];
                int y = yVertices[i];
                int z = zVertices[i];
                int var5 = x * x + z * z + y * y;
                if (var5 > diagonal) {
                    diagonal = var5;
                }
            }

            diagonal = (int) (Math.sqrt(diagonal) + 0.99D);
            maximumDiagonal = diagonal;
            minimumDiagonal = diagonal + diagonal;
        }
    }

    public Model method1294(boolean var1) {
        if (!var1 && aByteArray1141.length < triangleCount) {
            aByteArray1141 = new byte[triangleCount + 100];
        }

        return method1293(var1, aModel1756, aByteArray1141);
    }

    public void method582(int var1) {
        int sin = SIN_TABLE[var1];
        int cos = COS_TABLE[var1];

        for (int i = 0; i < vertexCount; ++i) {
            int var5 = cos * yVertices[i] - sin * zVertices[i] >> 16;
            zVertices[i] = sin * yVertices[i] + cos * zVertices[i] >> 16;
            yVertices[i] = var5;
        }

        method972();
    }

    public Model method1295(int[][] var1, int var2, int var3, int var4, boolean clone, int var6) {
        computeBounds();
        int var7 = var2 - diagonal;
        int var8 = var2 + diagonal;
        int var9 = var4 - diagonal;
        int var10 = var4 + diagonal;
        if (var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
            var7 >>= 7;
            var8 = var8 + 127 >> 7;
            var9 >>= 7;
            var10 = var10 + 127 >> 7;
            if (var3 == var1[var7][var9] && var3 == var1[var8][var9] && var3 == var1[var7][var10] && var3 == var1[var8][var10]) {
                return this;
            }
            Model model;
            if (clone) {
                model = new Model();
                model.vertexCount = vertexCount;
                model.triangleCount = triangleCount;
                model.texturedTriangleCount = texturedTriangleCount;
                model.xVertices = xVertices;
                model.zVertices = zVertices;
                model.xTriangles = xTriangles;
                model.yTriangles = yTriangles;
                model.zTriangles = zTriangles;
                model.triangleColors = triangleColors;
                model.yTexturedTriangles = yTexturedTriangles;
                model.zTexturedTriangles = zTexturedTriangles;
                model.aByteArray1757 = aByteArray1757;
                model.aByteArray1438 = aByteArray1438;
                model.aByteArray1752 = aByteArray1752;
                model.aShortArray724 = aShortArray724;
                model.aByte1753 = aByte1753;
                model.anIntArray782 = anIntArray782;
                model.anIntArray1103 = anIntArray1103;
                model.anIntArray781 = anIntArray781;
                model.anIntArrayArray1755 = anIntArrayArray1755;
                model.anIntArrayArray1754 = anIntArrayArray1754;
                model.aabbEnabled = aabbEnabled;
                model.yVertices = new int[model.vertexCount];
            } else {
                model = this;
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
                for (var12 = 0; var12 < model.vertexCount; ++var12) {
                    var13 = var2 + xVertices[var12];
                    var14 = var4 + zVertices[var12];
                    var15 = var13 & 127;
                    var16 = var14 & 127;
                    var17 = var13 >> 7;
                    var18 = var14 >> 7;
                    var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                    var20 = var1[var17][var18 + 1] * (128 - var15) + var15 * var1[var17 + 1][var18 + 1] >> 7;
                    var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                    model.yVertices[var12] = var21 + yVertices[var12] - var3;
                }
            } else {
                for (var12 = 0; var12 < model.vertexCount; ++var12) {
                    var13 = (-yVertices[var12] << 16) / super.height;
                    if (var13 < var6) {
                        var14 = var2 + xVertices[var12];
                        var15 = var4 + zVertices[var12];
                        var16 = var14 & 127;
                        var17 = var15 & 127;
                        var18 = var14 >> 7;
                        var19 = var15 >> 7;
                        var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                        var21 = var1[var18][var19 + 1] * (128 - var16) + var16 * var1[var18 + 1][var19 + 1] >> 7;
                        int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                        model.yVertices[var12] = (var6 - var13) * (var22 - var3) / var6 + yVertices[var12];
                    }
                }
            }

            model.method972();
            return model;
        }
        return this;
    }

    public void render(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9) {
        anIntArray1740[0] = -1;
        if (state != 1) {
            computeBounds();
        }

        method830(var1);
        int var11 = var5 * var8 - var4 * var6 >> 16;
        int var12 = var2 * var7 + var3 * var11 >> 16;
        int var13 = var3 * diagonal >> 16;
        int var14 = var12 + var13;
        if (var14 > 50 && var12 < 3500) {
            int var15 = var8 * var4 + var5 * var6 >> 16;
            int var16 = (var15 - diagonal) * JagGraphics3D.anInt367;
            if (var16 / var14 < JagGraphics3D.anInt666) {
                int var17 = (var15 + diagonal) * JagGraphics3D.anInt367;
                if (var17 / var14 > JagGraphics3D.anInt788) {
                    int var18 = var3 * var7 - var11 * var2 >> 16;
                    int var19 = var2 * diagonal >> 16;
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

                            boolean var26 = var25 || texturedTriangleCount > 0;
                            int var27 = Clock.method722();
                            int var28 = Statics2.anInt661;
                            boolean var30 = Statics2.aBoolean663;
                            boolean var32 = ClientLocale.method857(var9);
                            boolean var33 = false;
                            int var35;
                            int var36;
                            int var37;
                            if (var32 && var30) {
                                boolean var34 = false;
                                if (aBoolean1747) {
                                    var34 = SceneGraph.method257(this, var6, var7, var8);
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
                                    if (aabbEnabled) {
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
                                var36 = SIN_TABLE[var1];
                                var37 = COS_TABLE[var1];
                            }

                            for (int var40 = 0; var40 < vertexCount; ++var40) {
                                int var41 = xVertices[var40];
                                int var42 = yVertices[var40];
                                int var43 = zVertices[var40];
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
                                    screenX[var40] = var41 * JagGraphics3D.anInt367 / var43 + var47;
                                    screenY[var40] = var44 * JagGraphics3D.anInt367 / var43 + var35;
                                } else {
                                    screenX[var40] = -5000;
                                    var24 = true;
                                }

                                if (var26) {
                                    anIntArray1738[var40] = var41;
                                    anIntArray1731[var40] = var44;
                                    anIntArray1730[var40] = var43;
                                }
                            }

                            try {
                                translateToScreen(var24, var33, aabbEnabled, var9);
                            } catch (Exception ignored) {
                            }

                        }
                    }
                }
            }
        }
    }

    public void method981() {
        for (int i = 0; i < vertexCount; ++i) {
            int z = zVertices[i];
            zVertices[i] = xVertices[i];
            xVertices[i] = -z;
        }
        method972();
    }

    public void scale(int x, int y, int z) {
        for (int i = 0; i < vertexCount; ++i) {
            xVertices[i] = xVertices[i] * x / 128;
            yVertices[i] = yVertices[i] * y / 128;
            zVertices[i] = zVertices[i] * z / 128;
        }
        method972();
    }

    public void method1288() {
        for (int i = 0; i < vertexCount; ++i) {
            xVertices[i] = -xVertices[i];
            zVertices[i] = -zVertices[i];
        }
        method972();
    }

    public void method1283() {
        for (int i = 0; i < vertexCount; ++i) {
            int x = xVertices[i];
            xVertices[i] = zVertices[i];
            zVertices[i] = -x;
        }
        method972();
    }

    public final void drawTriangles(int i) {
        if (aBooleanArray1733[i]) {
            drawTriangle(i);
        } else {
            int x = xTriangles[i];
            int y = yTriangles[i];
            int z = zTriangles[i];
            JagGraphics3D.drawingOffscreen = offscreenTriangles[i];
            if (aByteArray1438 == null) {
                JagGraphics3D.alpha = 0;
            } else {
                JagGraphics3D.alpha = aByteArray1438[i] & 255;
            }

            if (aShortArray724 != null && aShortArray724[i] != -1) {
                int var6;
                int var7;
                int var8;
                if (aByteArray1752 != null && aByteArray1752[i] != -1) {
                    int var5 = aByteArray1752[i] & 255;
                    var6 = anIntArray782[var5];
                    var7 = anIntArray1103[var5];
                    var8 = anIntArray781[var5];
                } else {
                    var6 = x;
                    var7 = y;
                    var8 = z;
                }

                if (zTexturedTriangles[i] == -1) {
                    JagGraphics3D.method619(screenY[x], screenY[y], screenY[z], screenX[x], screenX[y], screenX[z], triangleColors[i], triangleColors[i], triangleColors[i], anIntArray1738[var6], anIntArray1738[var7], anIntArray1738[var8], anIntArray1731[var6], anIntArray1731[var7], anIntArray1731[var8], anIntArray1730[var6], anIntArray1730[var7], anIntArray1730[var8], aShortArray724[i]);
                } else {
                    JagGraphics3D.method619(screenY[x], screenY[y], screenY[z], screenX[x], screenX[y], screenX[z], triangleColors[i], yTexturedTriangles[i], zTexturedTriangles[i], anIntArray1738[var6], anIntArray1738[var7], anIntArray1738[var8], anIntArray1731[var6], anIntArray1731[var7], anIntArray1731[var8], anIntArray1730[var6], anIntArray1730[var7], anIntArray1730[var8], aShortArray724[i]);
                }
            } else if (zTexturedTriangles[i] == -1) {
                JagGraphics3D.fillTriangle(screenY[x], screenY[y], screenY[z], screenX[x], screenX[y], screenX[z], colorPalette[triangleColors[i]]);
            } else {
                JagGraphics3D.method627(screenY[x], screenY[y], screenY[z], screenX[x], screenX[y], screenX[z], triangleColors[i], yTexturedTriangles[i], zTexturedTriangles[i]);
            }

        }
    }

    public void method1285(AnimationFrameGroup var1, int var2, AnimationFrameGroup var3, int var4, int[] var5) {
        if (var2 != -1) {
            if (var5 != null && var4 != -1) {
                Identikit var6 = var1.identikits[var2];
                Identikit var7 = var3.identikits[var4];
                Skeleton var8 = var6.frame;
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

                    if (var12 != var10 || var8.types[var12] == 0) {
                        method1292(var8.types[var12], var8.labels[var12], var6.anIntArray1330[var11], var6.anIntArray1326[var11], var6.anIntArray1327[var11]);
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

                    if (var12 == var10 || var8.types[var12] == 0) {
                        method1292(var8.types[var12], var8.labels[var12], var7.anIntArray1330[var11], var7.anIntArray1326[var11], var7.anIntArray1327[var11]);
                    }
                }

                method972();
            } else {
                method1286(var1, var2);
            }
        }
    }

    public void method1292(int var1, int[] var2, int var3, int var4, int var5) {
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
                if (var9 < anIntArrayArray1755.length) {
                    int[] var10 = anIntArrayArray1755[var9];

                    for (var11 = 0; var11 < var10.length; ++var11) {
                        var12 = var10[var11];
                        anInt714 += xVertices[var12];
                        anInt715 += yVertices[var12];
                        anInt712 += zVertices[var12];
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
                    if (var8 < anIntArrayArray1755.length) {
                        var13 = anIntArrayArray1755[var8];

                        for (var14 = 0; var14 < var13.length; ++var14) {
                            var11 = var13[var14];
                            var10000 = xVertices;
                            var10000[var11] += var3;
                            var10000 = yVertices;
                            var10000[var11] += var4;
                            var10000 = zVertices;
                            var10000[var11] += var5;
                        }
                    }
                }

            } else if (var1 == 2) {
                for (var7 = 0; var7 < var6; ++var7) {
                    var8 = var2[var7];
                    if (var8 < anIntArrayArray1755.length) {
                        var13 = anIntArrayArray1755[var8];

                        for (var14 = 0; var14 < var13.length; ++var14) {
                            var11 = var13[var14];
                            var10000 = xVertices;
                            var10000[var11] -= anInt714;
                            var10000 = yVertices;
                            var10000[var11] -= anInt715;
                            var10000 = zVertices;
                            var10000[var11] -= anInt712;
                            var12 = (var3 & 255) * 8;
                            int var15 = (var4 & 255) * 8;
                            int var16 = (var5 & 255) * 8;
                            int var17;
                            int var18;
                            int var19;
                            if (var16 != 0) {
                                var17 = SIN_TABLE[var16];
                                var18 = COS_TABLE[var16];
                                var19 = var17 * yVertices[var11] + var18 * xVertices[var11] >> 16;
                                yVertices[var11] = var18 * yVertices[var11] - var17 * xVertices[var11] >> 16;
                                xVertices[var11] = var19;
                            }

                            if (var12 != 0) {
                                var17 = SIN_TABLE[var12];
                                var18 = COS_TABLE[var12];
                                var19 = var18 * yVertices[var11] - var17 * zVertices[var11] >> 16;
                                zVertices[var11] = var17 * yVertices[var11] + var18 * zVertices[var11] >> 16;
                                yVertices[var11] = var19;
                            }

                            if (var15 != 0) {
                                var17 = SIN_TABLE[var15];
                                var18 = COS_TABLE[var15];
                                var19 = var17 * zVertices[var11] + var18 * xVertices[var11] >> 16;
                                zVertices[var11] = var18 * zVertices[var11] - var17 * xVertices[var11] >> 16;
                                xVertices[var11] = var19;
                            }

                            var10000 = xVertices;
                            var10000[var11] += anInt714;
                            var10000 = yVertices;
                            var10000[var11] += anInt715;
                            var10000 = zVertices;
                            var10000[var11] += anInt712;
                        }
                    }
                }

            } else if (var1 == 3) {
                for (var7 = 0; var7 < var6; ++var7) {
                    var8 = var2[var7];
                    if (var8 < anIntArrayArray1755.length) {
                        var13 = anIntArrayArray1755[var8];

                        for (var14 = 0; var14 < var13.length; ++var14) {
                            var11 = var13[var14];
                            var10000 = xVertices;
                            var10000[var11] -= anInt714;
                            var10000 = yVertices;
                            var10000[var11] -= anInt715;
                            var10000 = zVertices;
                            var10000[var11] -= anInt712;
                            xVertices[var11] = var3 * xVertices[var11] / 128;
                            yVertices[var11] = var4 * yVertices[var11] / 128;
                            zVertices[var11] = var5 * zVertices[var11] / 128;
                            var10000 = xVertices;
                            var10000[var11] += anInt714;
                            var10000 = yVertices;
                            var10000[var11] += anInt715;
                            var10000 = zVertices;
                            var10000[var11] += anInt712;
                        }
                    }
                }

            } else if (var1 == 5) {
                if (anIntArrayArray1754 != null && aByteArray1438 != null) {
                    for (var7 = 0; var7 < var6; ++var7) {
                        var8 = var2[var7];
                        if (var8 < anIntArrayArray1754.length) {
                            var13 = anIntArrayArray1754[var8];

                            for (var14 = 0; var14 < var13.length; ++var14) {
                                var11 = var13[var14];
                                var12 = (aByteArray1438[var11] & 255) + var3 * 8;
                                if (var12 < 0) {
                                    var12 = 0;
                                } else if (var12 > 255) {
                                    var12 = 255;
                                }

                                aByteArray1438[var11] = (byte) var12;
                            }
                        }
                    }
                }

            }
        }
    }

    public final void translateToScreen(boolean var1, boolean var2, boolean var3, long var4) {
        if (minimumDiagonal < 1600) {
            int var6;
            for (var6 = 0; var6 < minimumDiagonal; ++var6) {
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
            for (var7 = 0; var7 < triangleCount; ++var7) {
                if (zTexturedTriangles[var7] != -2) {
                    var8 = xTriangles[var7];
                    var11 = yTriangles[var7];
                    var10 = zTriangles[var7];
                    var12 = screenX[var8];
                    var13 = screenX[var11];
                    var14 = screenX[var10];
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
                            int var29 = (anIntArray1728[var8] + anIntArray1728[var11] + anIntArray1728[var10]) / 3 + maximumDiagonal;
                            anIntArrayArray1737[var29][anIntArray1740[var29]++] = var7;
                        }
                    } else {
                        if (var2) {
                            var15 = screenY[var8];
                            var16 = screenY[var11];
                            var17 = screenY[var10];
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

                        if ((var12 - var13) * (screenY[var10] - screenY[var11]) - (var14 - var13) * (screenY[var8] - screenY[var11]) > 0) {
                            aBooleanArray1733[var7] = false;
                            offscreenTriangles[var7] = var12 < 0 || var13 < 0 || var14 < 0 || var12 > JagGraphics3D.anInt696 || var13 > JagGraphics3D.anInt696 || var14 > JagGraphics3D.anInt696;

                            var34 = (anIntArray1728[var8] + anIntArray1728[var11] + anIntArray1728[var10]) / 3 + maximumDiagonal;
                            anIntArrayArray1737[var34][anIntArray1740[var34]++] = var7;
                        }
                    }
                }
            }

            int[] var9;
            if (aByteArray1757 == null) {
                for (var7 = minimumDiagonal - 1; var7 >= 0; --var7) {
                    var8 = anIntArray1740[var7];
                    if (var8 > 0) {
                        var9 = anIntArrayArray1737[var7];

                        for (var10 = 0; var10 < var8; ++var10) {
                            drawTriangles(var9[var10]);
                        }
                    }
                }

            } else {
                for (var7 = 0; var7 < 12; ++var7) {
                    anIntArray1729[var7] = 0;
                    anIntArray1742[var7] = 0;
                }

                for (var7 = minimumDiagonal - 1; var7 >= 0; --var7) {
                    var8 = anIntArray1740[var7];
                    if (var8 > 0) {
                        var9 = anIntArrayArray1737[var7];

                        for (var10 = 0; var10 < var8; ++var10) {
                            var12 = var9[var10];
                            byte var33 = aByteArray1757[var12];
                            var14 = anIntArray1729[var33]++;
                            anIntArrayArray1736[var33][var14] = var12;
                            if (var33 < 10) {
                                anIntArray1742[var33] += var7;
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
                        drawTriangles(var30[var12++]);
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
                        drawTriangles(var30[var12++]);
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
                        drawTriangles(var30[var12++]);
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
                        drawTriangles(var32[var18]);
                    }
                }

                while (var10 != -1000) {
                    drawTriangles(var30[var12++]);
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

    public void method832(int x, int y, int z) {
        for (int i = 0; i < vertexCount; ++i) {
            int[] vertices = xVertices;
            vertices[i] += x;
            vertices = yVertices;
            vertices[i] += y;
            vertices = zVertices;
            vertices[i] += z;
        }

        method972();
    }

    public final void method1289(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        anIntArray1740[0] = -1;
        if (state != 2 && state != 1) {
            method828();
        }

        int var8 = JagGraphics3D.anInt386;
        int var9 = JagGraphics3D.anInt366;
        int var10 = SIN_TABLE[var1];
        int var11 = COS_TABLE[var1];
        int var12 = SIN_TABLE[var2];
        int var13 = COS_TABLE[var2];
        int var14 = SIN_TABLE[var3];
        int var15 = COS_TABLE[var3];
        int var16 = SIN_TABLE[var4];
        int var17 = COS_TABLE[var4];
        int var18 = var16 * var6 + var17 * var7 >> 16;

        for (int i = 0; i < vertexCount; ++i) {
            int var20 = xVertices[i];
            int var21 = yVertices[i];
            int var22 = zVertices[i];
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
            anIntArray1728[i] = var22 - var18;
            screenX[i] = var20 * JagGraphics3D.anInt367 / var22 + var8;
            screenY[i] = var23 * JagGraphics3D.anInt367 / var22 + var9;
            if (texturedTriangleCount > 0) {
                anIntArray1738[i] = var20;
                anIntArray1731[i] = var23;
                anIntArray1730[i] = var22;
            }
        }

        try {
            translateToScreen(false, false, false, 0L);
        } catch (Exception ignored) {
        }

    }

    public final void method1287(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        anIntArray1740[0] = -1;
        if (state != 2 && state != 1) {
            method828();
        }

        int var9 = JagGraphics3D.anInt386;
        int var10 = JagGraphics3D.anInt366;
        int var11 = SIN_TABLE[var1];
        int var12 = COS_TABLE[var1];
        int var13 = SIN_TABLE[var2];
        int var14 = COS_TABLE[var2];
        int var15 = SIN_TABLE[var3];
        int var16 = COS_TABLE[var3];
        int var17 = SIN_TABLE[var4];
        int var18 = COS_TABLE[var4];
        int var19 = var17 * var6 + var18 * var7 >> 16;

        for (int i = 0; i < vertexCount; ++i) {
            int var21 = xVertices[i];
            int var22 = yVertices[i];
            int var23 = zVertices[i];
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
            anIntArray1728[i] = var23 - var19;
            screenX[i] = var9 + var21 * JagGraphics3D.anInt367 / var8;
            screenY[i] = var10 + var24 * JagGraphics3D.anInt367 / var8;
            if (texturedTriangleCount > 0) {
                anIntArray1738[i] = var21;
                anIntArray1731[i] = var24;
                anIntArray1730[i] = var23;
            }
        }

        try {
            translateToScreen(false, false, false, 0L);
        } catch (Exception ignored) {
        }

    }

    public int radius() {
        computeBounds();
        return diagonal;
    }
}
