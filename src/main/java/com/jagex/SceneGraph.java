package com.jagex;

public class SceneGraph {
    static final int[] anIntArray1935;
    static final int[] anIntArray1937;
    static final int[] anIntArray1948;
    static final int[] anIntArray1945;
    static final int[] anIntArray1934;
    static final int[] anIntArray1944;
    static final int[] anIntArray1959;
    public static boolean aBoolean1980;
    public static int selectedRegionTileX;
    public static int selectedRegionTileY;
    static int[] anIntArray1941;
    static boolean viewportWalking;
    static int anInt1933;
    static int renderCameraX;
    static NodeDeque aNodeDeque1936;
    static int renderFloor;
    static int anInt1938;
    static int anInt1962;
    static CameraCapture[] cameraCaptures;
    static int renderCameraY;
    static CameraCapture[][] aCameraCaptureArrayArray1939;
    static boolean aBoolean1942;
    static int renderTick;
    static EntityMarker[] anEntityMarkerArray1940;
    static int anInt1931;
    static int renderCameraZ;
    static int walkingMouseX;
    static int pitchSin;
    static int walkingMouseY;
    static int renderSceneX;
    static int pitchCos;
    static int renderSceneY;
    static int yawSin;
    static int renderAreaMinX;
    static int yawCos;
    static boolean[][][][] aBooleanArrayArrayArrayArray1960;
    static int renderAreaMaxX;
    static int renderAreaMinY;
    static int renderAreaMaxY;
    static boolean[][] aBooleanArrayArray1951;
    static int anInt1956;
    static int anInt1952;
    static int anInt1958;
    static int anInt1953;
    static int anInt1955;
    static int anInt1950;
    static int floorLevel;
    static int regionChunkX;
    static int regionChunkY;

    static {
        aBoolean1980 = true;
        anInt1962 = 0;
        renderFloor = 0;
        anEntityMarkerArray1940 = new EntityMarker[100];
        aBoolean1942 = false;
        anInt1931 = 0;
        walkingMouseX = 0;
        walkingMouseY = 0;
        selectedRegionTileX = -1;
        selectedRegionTileY = -1;
        viewportWalking = false;
        anInt1938 = 4;
        anIntArray1941 = new int[anInt1938];
        aCameraCaptureArrayArray1939 = new CameraCapture[anInt1938][500];
        anInt1933 = 0;
        cameraCaptures = new CameraCapture[500];
        aNodeDeque1936 = new NodeDeque();
        anIntArray1935 = new int[]{19, 55, 38, 155, 255, 110, 137, 205, 76};
        anIntArray1937 = new int[]{160, 192, 80, 96, 0, 144, 80, 48, 160};
        anIntArray1948 = new int[]{76, 8, 137, 4, 0, 1, 38, 2, 19};
        anIntArray1945 = new int[]{0, 0, 2, 0, 0, 2, 1, 1, 0};
        anIntArray1934 = new int[]{2, 0, 0, 2, 0, 0, 0, 4, 4};
        anIntArray1944 = new int[]{0, 4, 4, 8, 0, 0, 8, 0, 0};
        anIntArray1959 = new int[]{1, 1, 0, 0, 0, 8, 0, 0, 8};
        aBooleanArrayArrayArrayArray1960 = new boolean[8][32][51][51];
    }

    int anInt1972;
    int anInt1970;
    int[][][] anIntArrayArrayArray1966;
    int width;
    int anInt1971;
    Tile[][][] tiles;
    EntityMarker[] tempMarkers;
    int length;
    int[][][] anIntArrayArrayArray1973;
    int[][] tileShapes;
    int[][] tileRotations;

    public SceneGraph(int var1, int var2, int var3, int[][][] var4) {
        this.anInt1972 = 0;
        this.anInt1970 = 0;
        this.tempMarkers = new EntityMarker[5000];
        this.tileShapes = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}};
        this.tileRotations = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3}, {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, {3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12}};
        this.anInt1971 = var1;
        this.width = var2;
        this.length = var3;
        this.tiles = new Tile[var1][var2][var3];
        this.anIntArrayArrayArray1966 = new int[var1][var2 + 1][var3 + 1];
        this.anIntArrayArrayArray1973 = var4;
        this.method1486();
    }

    public static boolean isMovementPending() {
        return viewportWalking && selectedRegionTileX != -1;
    }

    static boolean method1458(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        if (var1 < var2 && var1 < var3 && var1 < var4) {
            return false;
        }
        if (var1 > var2 && var1 > var3 && var1 > var4) {
            return false;
        }
        if (var0 < var5 && var0 < var6 && var0 < var7) {
            return false;
        }
        if (var0 > var5 && var0 > var6 && var0 > var7) {
            return false;
        }
        int var8 = (var1 - var2) * (var6 - var5) - (var0 - var5) * (var3 - var2);
        int var9 = (var7 - var6) * (var1 - var3) - (var0 - var6) * (var4 - var3);
        int var10 = (var5 - var7) * (var1 - var4) - (var2 - var4) * (var0 - var7);
        if (var8 == 0) {
            if (var9 != 0) {
                return var9 < 0 ? var10 <= 0 : var10 >= 0;
            }
            return true;
        }
        return var8 < 0 ? var9 <= 0 && var10 <= 0 : var9 >= 0 && var10 >= 0;
    }

    static int method1444(int var0, int var1) {
        var1 = (var0 & 127) * var1 >> 7;
        if (var1 < 2) {
            var1 = 2;
        } else if (var1 > 126) {
            var1 = 126;
        }

        return (var0 & 65408) + var1;
    }

    public static void method1449(int[] var0, int var1, int var2, int var3, int var4) {
        anInt1956 = 0;
        anInt1952 = 0;
        anInt1958 = var3;
        anInt1953 = var4;
        anInt1955 = var3 / 2;
        anInt1950 = var4 / 2;
        boolean[][][][] var5 = new boolean[var0.length][32][53][53];

        int var6;
        int var7;
        int var8;
        int var9;
        int var11;
        int var12;
        for (var6 = 128; var6 <= 383; var6 += 32) {
            for (var7 = 0; var7 < 2048; var7 += 64) {
                pitchSin = JagGraphics3D.SIN_TABLE[var6];
                pitchCos = JagGraphics3D.COS_TABLE[var6];
                yawSin = JagGraphics3D.SIN_TABLE[var7];
                yawCos = JagGraphics3D.COS_TABLE[var7];
                var8 = (var6 - 128) / 32;
                var9 = var7 / 64;

                for (int var10 = -26; var10 < 26; ++var10) {
                    for (var11 = -26; var11 < 26; ++var11) {
                        var12 = var10 * 128;
                        int var13 = var11 * 128;
                        boolean var14 = false;

                        for (int var15 = -var1; var15 <= var2; var15 += 128) {
                            if (method1455(var12, var0[var8] + var15, var13)) {
                                var14 = true;
                                break;
                            }
                        }

                        var5[var8][var9][var10 + 1 + 25][var11 + 1 + 25] = var14;
                    }
                }
            }
        }

        for (var6 = 0; var6 < 8; ++var6) {
            for (var7 = 0; var7 < 32; ++var7) {
                for (var8 = -25; var8 < 25; ++var8) {
                    for (var9 = -25; var9 < 25; ++var9) {
                        boolean var16 = false;

                        label76:
                        for (var11 = -1; var11 <= 1; ++var11) {
                            for (var12 = -1; var12 <= 1; ++var12) {
                                if (var5[var6][var7][var8 + var11 + 1 + 25][var9 + var12 + 1 + 25]) {
                                    var16 = true;
                                    break label76;
                                }

                                if (var5[var6][(var7 + 1) % 31][var8 + var11 + 1 + 25][var9 + var12 + 1 + 25]) {
                                    var16 = true;
                                    break label76;
                                }

                                if (var5[var6 + 1][var7][var8 + var11 + 1 + 25][var9 + var12 + 1 + 25]) {
                                    var16 = true;
                                    break label76;
                                }

                                if (var5[var6 + 1][(var7 + 1) % 31][var8 + var11 + 1 + 25][var9 + var12 + 1 + 25]) {
                                    var16 = true;
                                    break label76;
                                }
                            }
                        }

                        aBooleanArrayArrayArrayArray1960[var6][var7][var8 + 25][var9 + 25] = var16;
                    }
                }
            }
        }

    }

    static boolean method1455(int var0, int var1, int var2) {
        int var3 = var0 * yawCos + var2 * yawSin >> 16;
        int var4 = var2 * yawCos - var0 * yawSin >> 16;
        int var5 = var4 * pitchCos + pitchSin * var1 >> 16;
        int var6 = pitchCos * var1 - var4 * pitchSin >> 16;
        if (var5 >= 50 && var5 <= 3500) {
            int var7 = var3 * 128 / var5 + anInt1955;
            int var8 = var6 * 128 / var5 + anInt1950;
            return var7 >= anInt1956 && var7 <= anInt1958 && var8 >= anInt1952 && var8 <= anInt1953;
        }
        return false;
    }

    public static void method1483(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        CameraCapture var8 = new CameraCapture();
        var8.anInt1922 = var2 / 128;
        var8.anInt1916 = var3 / 128;
        var8.anInt1920 = var4 / 128;
        var8.anInt1919 = var5 / 128;
        var8.flag = var1;
        var8.minFineX = var2;
        var8.maxFineX = var3;
        var8.minFineY = var4;
        var8.maxFineY = var5;
        var8.componentHeight = var6;
        var8.tileHeight = var7;
        aCameraCaptureArrayArray1939[var0][anIntArray1941[var0]++] = var8;
    }

    public static void unsetPendingMovement() {
        selectedRegionTileX = -1;
        viewportWalking = false;
    }

    static void absoluteToViewport(int var0, int var1, int var2) {
        if (var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
            int var4 = getTileHeight(var0, var1, floorLevel) - var2;
            var0 -= Class38.cameraX;
            var4 -= Class79.cameraZ;
            var1 -= Class27_Sub1.cameraY;
            int var5 = JagGraphics3D.SIN_TABLE[IgnoreListContext.cameraPitch];
            int var6 = JagGraphics3D.COS_TABLE[IgnoreListContext.cameraPitch];
            int var7 = JagGraphics3D.SIN_TABLE[Class70.cameraYaw];
            int var8 = JagGraphics3D.COS_TABLE[Class70.cameraYaw];
            int var9 = var7 * var1 + var0 * var8 >> 16;
            var1 = var8 * var1 - var0 * var7 >> 16;
            var0 = var9;
            var9 = var4 * var6 - var5 * var1 >> 16;
            var1 = var5 * var4 + var6 * var1 >> 16;
            if (var1 >= 50) {
                client.anInt998 = var0 * client.viewportScale / var1 + client.viewportWidth / 2;
                client.anInt993 = var9 * client.viewportScale / var1 + client.viewportHeight / 2;
            } else {
                client.anInt998 = -1;
                client.anInt993 = -1;
            }

        } else {
            client.anInt998 = -1;
            client.anInt993 = -1;
        }
    }

    static int getTileHeight(int var0, int var1, int baseFloorLevel) {
        int var3 = var0 >> 7;
        int var4 = var1 >> 7;
        if (var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
            int var5 = baseFloorLevel;
            if (baseFloorLevel < 3 && (Class44.sceneRenderRules[1][var3][var4] & 2) == 2) {
                var5 = baseFloorLevel + 1;
            }

            int var6 = var0 & 127;
            int var7 = var1 & 127;
            int var8 = (128 - var6) * Class44.tileHeights[var5][var3][var4] + var6 * Class44.tileHeights[var5][var3 + 1][var4] >> 7;
            int var9 = var6 * Class44.tileHeights[var5][var3 + 1][var4 + 1] + Class44.tileHeights[var5][var3][var4 + 1] * (128 - var6) >> 7;
            return var9 * var7 + var8 * (128 - var7) >> 7;
        }
        return 0;
    }

    boolean method1464(int var1, int var2, int var3) {
        int var4 = this.anIntArrayArrayArray1966[var1][var2][var3];
        if (var4 == -renderTick) {
            return false;
        }
        if (var4 == renderTick) {
            return true;
        }
        int var5 = var2 << 7;
        int var6 = var3 << 7;
        if (this.method1465(var5 + 1, this.anIntArrayArrayArray1973[var1][var2][var3], var6 + 1) && this.method1465(var5 + 128 - 1, this.anIntArrayArrayArray1973[var1][var2 + 1][var3], var6 + 1) && this.method1465(var5 + 128 - 1, this.anIntArrayArrayArray1973[var1][var2 + 1][var3 + 1], var6 + 128 - 1) && this.method1465(var5 + 1, this.anIntArrayArrayArray1973[var1][var2][var3 + 1], var6 + 128 - 1)) {
            this.anIntArrayArrayArray1966[var1][var2][var3] = renderTick;
            return true;
        }
        this.anIntArrayArrayArray1966[var1][var2][var3] = -renderTick;
        return false;
    }

    boolean addEntityMarker(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, Entity var9, int var10, boolean var11, long var12, int var14) {
        int var16;
        for (int var15 = var2; var15 < var2 + var4; ++var15) {
            for (var16 = var3; var16 < var3 + var5; ++var16) {
                if (var15 < 0 || var16 < 0 || var15 >= this.width || var16 >= this.length) {
                    return false;
                }

                Tile var21 = this.tiles[var1][var15][var16];
                if (var21 != null && var21.anInt368 >= 5) {
                    return false;
                }
            }
        }

        EntityMarker var17 = new EntityMarker();
        var17.uid = var12;
        var17.config = var14;
        var17.floorLevel = var1;
        var17.centerFineX = var6;
        var17.centerFineY = var7;
        var17.height = var8;
        var17.entity = var9;
        var17.orientation = var10;
        var17.sceneX = var2;
        var17.sceneY = var3;
        var17.maxSceneX = var2 + var4 - 1;
        var17.maxSceneY = var3 + var5 - 1;

        for (var16 = var2; var16 < var2 + var4; ++var16) {
            for (int var18 = var3; var18 < var3 + var5; ++var18) {
                int var19 = 0;
                if (var16 > var2) {
                    ++var19;
                }

                if (var16 < var2 + var4 - 1) {
                    var19 += 4;
                }

                if (var18 > var3) {
                    var19 += 8;
                }

                if (var18 < var3 + var5 - 1) {
                    var19 += 2;
                }

                for (int var20 = var1; var20 >= 0; --var20) {
                    if (this.tiles[var20][var16][var18] == null) {
                        this.tiles[var20][var16][var18] = new Tile(var20, var16, var18);
                    }
                }

                Tile var22 = this.tiles[var1][var16][var18];
                var22.markers[var22.anInt368] = var17;
                var22.anIntArray374[var22.anInt368] = var19;
                var22.anInt366 |= var19;
                ++var22.anInt368;
            }
        }

        if (var11) {
            this.tempMarkers[this.anInt1970++] = var17;
        }

        return true;
    }

    void method1485(EntityMarker var1) {
        for (int var2 = var1.sceneX; var2 <= var1.maxSceneX; ++var2) {
            for (int var3 = var1.sceneY; var3 <= var1.maxSceneY; ++var3) {
                Tile var4 = this.tiles[var1.floorLevel][var2][var3];
                if (var4 != null) {
                    int var5;
                    for (var5 = 0; var5 < var4.anInt368; ++var5) {
                        if (var4.markers[var5] == var1) {
                            --var4.anInt368;

                            for (int var6 = var5; var6 < var4.anInt368; ++var6) {
                                var4.markers[var6] = var4.markers[var6 + 1];
                                var4.anIntArray374[var6] = var4.anIntArray374[var6 + 1];
                            }

                            var4.markers[var4.anInt368] = null;
                            break;
                        }
                    }

                    var4.anInt366 = 0;

                    for (var5 = 0; var5 < var4.anInt368; ++var5) {
                        var4.anInt366 |= var4.anIntArray374[var5];
                    }
                }
            }
        }

    }

    public void method1451(int var1, int var2, int var3, boolean var4) {
        if (!isMovementPending() || var4) {
            aBoolean1942 = true;
            viewportWalking = var4;
            anInt1931 = var1;
            walkingMouseX = var2;
            walkingMouseY = var3;
            selectedRegionTileX = -1;
            selectedRegionTileY = -1;
        }
    }

    boolean method1465(int var1, int var2, int var3) {
        for (int var4 = 0; var4 < anInt1933; ++var4) {
            CameraCapture var5 = cameraCaptures[var4];
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            if (var5.anInt1912 == 1) {
                var6 = var5.minFineX - var1;
                if (var6 > 0) {
                    var7 = (var6 * var5.anInt1914 >> 8) + var5.minFineY;
                    var8 = (var6 * var5.anInt1921 >> 8) + var5.maxFineY;
                    var9 = (var6 * var5.anInt1918 >> 8) + var5.componentHeight;
                    var10 = (var6 * var5.anInt1915 >> 8) + var5.tileHeight;
                    if (var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                        return true;
                    }
                }
            } else if (var5.anInt1912 == 2) {
                var6 = var1 - var5.minFineX;
                if (var6 > 0) {
                    var7 = (var6 * var5.anInt1914 >> 8) + var5.minFineY;
                    var8 = (var6 * var5.anInt1921 >> 8) + var5.maxFineY;
                    var9 = (var6 * var5.anInt1918 >> 8) + var5.componentHeight;
                    var10 = (var6 * var5.anInt1915 >> 8) + var5.tileHeight;
                    if (var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                        return true;
                    }
                }
            } else if (var5.anInt1912 == 3) {
                var6 = var5.minFineY - var3;
                if (var6 > 0) {
                    var7 = (var6 * var5.anInt1917 >> 8) + var5.minFineX;
                    var8 = (var6 * var5.anInt1911 >> 8) + var5.maxFineX;
                    var9 = (var6 * var5.anInt1918 >> 8) + var5.componentHeight;
                    var10 = (var6 * var5.anInt1915 >> 8) + var5.tileHeight;
                    if (var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                        return true;
                    }
                }
            } else if (var5.anInt1912 == 4) {
                var6 = var3 - var5.minFineY;
                if (var6 > 0) {
                    var7 = (var6 * var5.anInt1917 >> 8) + var5.minFineX;
                    var8 = (var6 * var5.anInt1911 >> 8) + var5.maxFineX;
                    var9 = (var6 * var5.anInt1918 >> 8) + var5.componentHeight;
                    var10 = (var6 * var5.anInt1915 >> 8) + var5.tileHeight;
                    if (var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                        return true;
                    }
                }
            } else if (var5.anInt1912 == 5) {
                var6 = var2 - var5.componentHeight;
                if (var6 > 0) {
                    var7 = (var6 * var5.anInt1917 >> 8) + var5.minFineX;
                    var8 = (var6 * var5.anInt1911 >> 8) + var5.maxFineX;
                    var9 = (var6 * var5.anInt1914 >> 8) + var5.minFineY;
                    var10 = (var6 * var5.anInt1921 >> 8) + var5.maxFineY;
                    if (var1 >= var7 && var1 <= var8 && var3 >= var9 && var3 <= var10) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    void method1452(UnlitModel var1, int var2, int var3, int var4, int var5, int var6) {
        boolean var7 = true;
        int var8 = var3;
        int var9 = var3 + var5;
        int var10 = var4 - 1;
        int var11 = var4 + var6;

        for (int var12 = var2; var12 <= var2 + 1; ++var12) {
            if (var12 != this.anInt1971) {
                for (int var13 = var8; var13 <= var9; ++var13) {
                    if (var13 >= 0 && var13 < this.width) {
                        for (int var14 = var10; var14 <= var11; ++var14) {
                            if (var14 >= 0 && var14 < this.length && (!var7 || var13 >= var9 || var14 >= var11 || var14 < var4 && var3 != var13)) {
                                Tile var15 = this.tiles[var12][var13][var14];
                                if (var15 != null) {
                                    int var16 = (this.anIntArrayArrayArray1973[var12][var13 + 1][var14] + this.anIntArrayArrayArray1973[var12][var13 + 1][var14 + 1] + this.anIntArrayArrayArray1973[var12][var13][var14] + this.anIntArrayArrayArray1973[var12][var13][var14 + 1]) / 4 - (this.anIntArrayArrayArray1973[var2][var3 + 1][var4] + this.anIntArrayArrayArray1973[var2][var3][var4] + this.anIntArrayArrayArray1973[var2][var3 + 1][var4 + 1] + this.anIntArrayArrayArray1973[var2][var3][var4 + 1]) / 4;
                                    Boundary var17 = var15.boundary;
                                    if (var17 != null) {
                                        UnlitModel var18;
                                        if (var17.entity instanceof UnlitModel) {
                                            var18 = (UnlitModel) var17.entity;
                                            UnlitModel.method970(var1, var18, (1 - var5) * 64 + (var13 - var3) * 128, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
                                        }

                                        if (var17.linkedEntity instanceof UnlitModel) {
                                            var18 = (UnlitModel) var17.linkedEntity;
                                            UnlitModel.method970(var1, var18, (1 - var5) * 64 + (var13 - var3) * 128, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
                                        }
                                    }

                                    for (int var19 = 0; var19 < var15.anInt368; ++var19) {
                                        EntityMarker var20 = var15.markers[var19];
                                        if (var20 != null && var20.entity instanceof UnlitModel) {
                                            UnlitModel var21 = (UnlitModel) var20.entity;
                                            int var22 = var20.maxSceneX - var20.sceneX + 1;
                                            int var23 = var20.maxSceneY - var20.sceneY + 1;
                                            UnlitModel.method970(var1, var21, (var22 - var5) * 64 + (var20.sceneX - var3) * 128, var16, (var20.sceneY - var4) * 128 + (var23 - var6) * 64, var7);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                --var8;
                var7 = false;
            }
        }

    }

    boolean method1463(int var1, int var2, int var3, int var4) {
        if (!this.method1464(var1, var2, var3)) {
            return false;
        }
        int var5 = var2 << 7;
        int var6 = var3 << 7;
        int var7 = this.anIntArrayArrayArray1973[var1][var2][var3] - 1;
        int var8 = var7 - 120;
        int var9 = var7 - 230;
        int var10 = var7 - 238;
        if (var4 < 16) {
            if (var4 == 1) {
                if (var5 > renderCameraX) {
                    if (!this.method1465(var5, var7, var6)) {
                        return false;
                    }

                    if (!this.method1465(var5, var7, var6 + 128)) {
                        return false;
                    }
                }

                if (var1 > 0) {
                    if (!this.method1465(var5, var8, var6)) {
                        return false;
                    }

                    if (!this.method1465(var5, var8, var6 + 128)) {
                        return false;
                    }
                }

                if (!this.method1465(var5, var9, var6)) {
                    return false;
                }

                return this.method1465(var5, var9, var6 + 128);
            }

            if (var4 == 2) {
                if (var6 < renderCameraY) {
                    if (!this.method1465(var5, var7, var6 + 128)) {
                        return false;
                    }

                    if (!this.method1465(var5 + 128, var7, var6 + 128)) {
                        return false;
                    }
                }

                if (var1 > 0) {
                    if (!this.method1465(var5, var8, var6 + 128)) {
                        return false;
                    }

                    if (!this.method1465(var5 + 128, var8, var6 + 128)) {
                        return false;
                    }
                }

                if (!this.method1465(var5, var9, var6 + 128)) {
                    return false;
                }

                return this.method1465(var5 + 128, var9, var6 + 128);
            }

            if (var4 == 4) {
                if (var5 < renderCameraX) {
                    if (!this.method1465(var5 + 128, var7, var6)) {
                        return false;
                    }

                    if (!this.method1465(var5 + 128, var7, var6 + 128)) {
                        return false;
                    }
                }

                if (var1 > 0) {
                    if (!this.method1465(var5 + 128, var8, var6)) {
                        return false;
                    }

                    if (!this.method1465(var5 + 128, var8, var6 + 128)) {
                        return false;
                    }
                }

                if (!this.method1465(var5 + 128, var9, var6)) {
                    return false;
                }

                return this.method1465(var5 + 128, var9, var6 + 128);
            }

            if (var4 == 8) {
                if (var6 > renderCameraY) {
                    if (!this.method1465(var5, var7, var6)) {
                        return false;
                    }

                    if (!this.method1465(var5 + 128, var7, var6)) {
                        return false;
                    }
                }

                if (var1 > 0) {
                    if (!this.method1465(var5, var8, var6)) {
                        return false;
                    }

                    if (!this.method1465(var5 + 128, var8, var6)) {
                        return false;
                    }
                }

                if (!this.method1465(var5, var9, var6)) {
                    return false;
                }

                return this.method1465(var5 + 128, var9, var6);
            }
        }

        if (!this.method1465(var5 + 64, var10, var6 + 64)) {
            return false;
        }
        if (var4 == 16) {
            return this.method1465(var5, var9, var6 + 128);
        }
        if (var4 == 32) {
            return this.method1465(var5 + 128, var9, var6 + 128);
        }
        if (var4 == 64) {
            return this.method1465(var5 + 128, var9, var6);
        }
        if (var4 == 128) {
            return this.method1465(var5, var9, var6);
        }
        return true;
    }

    public long method1456(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        return var4 != null && var4.boundary != null ? var4.boundary.uid : 0L;
    }

    public long method1440(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        return var4 != null && var4.boundaryDecor != null ? var4.boundaryDecor.uid : 0L;
    }

    public int method1453(int var1, int var2, int var3, long var4) {
        Tile var6 = this.tiles[var1][var2][var3];
        if (var6 == null) {
            return -1;
        }
        if (var6.boundary != null && var6.boundary.uid == var4) {
            return var6.boundary.config & 255;
        }
        if (var6.boundaryDecor != null && var6.boundaryDecor.uid == var4) {
            return var6.boundaryDecor.config & 255;
        }
        if (var6.decor != null && var6.decor.uid == var4) {
            return var6.decor.config & 255;
        }
        for (int var7 = 0; var7 < var6.anInt368; ++var7) {
            if (var6.markers[var7].uid == var4) {
                return var6.markers[var7].config & 255;
            }
        }

        return -1;
    }

    void method1462(TilePaint var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        int var9;
        int var10 = var9 = (var7 << 7) - renderCameraX;
        int var11;
        int var12 = var11 = (var8 << 7) - renderCameraY;
        int var13;
        int var14 = var13 = var10 + 128;
        int var15;
        int var16 = var15 = var12 + 128;
        int var17 = this.anIntArrayArrayArray1973[var2][var7][var8] - renderCameraZ;
        int var18 = this.anIntArrayArrayArray1973[var2][var7 + 1][var8] - renderCameraZ;
        int var19 = this.anIntArrayArrayArray1973[var2][var7 + 1][var8 + 1] - renderCameraZ;
        int var20 = this.anIntArrayArrayArray1973[var2][var7][var8 + 1] - renderCameraZ;
        int var21 = var10 * var6 + var5 * var12 >> 16;
        var12 = var12 * var6 - var5 * var10 >> 16;
        var10 = var21;
        var21 = var17 * var4 - var3 * var12 >> 16;
        var12 = var3 * var17 + var12 * var4 >> 16;
        var17 = var21;
        if (var12 >= 50) {
            var21 = var14 * var6 + var5 * var11 >> 16;
            var11 = var11 * var6 - var5 * var14 >> 16;
            var14 = var21;
            var21 = var18 * var4 - var3 * var11 >> 16;
            var11 = var3 * var18 + var11 * var4 >> 16;
            var18 = var21;
            if (var11 >= 50) {
                var21 = var13 * var6 + var5 * var16 >> 16;
                var16 = var16 * var6 - var5 * var13 >> 16;
                var13 = var21;
                var21 = var19 * var4 - var3 * var16 >> 16;
                var16 = var3 * var19 + var16 * var4 >> 16;
                var19 = var21;
                if (var16 >= 50) {
                    var21 = var9 * var6 + var5 * var15 >> 16;
                    var15 = var15 * var6 - var5 * var9 >> 16;
                    var9 = var21;
                    var21 = var20 * var4 - var3 * var15 >> 16;
                    var15 = var3 * var20 + var15 * var4 >> 16;
                    if (var15 >= 50) {
                        int var22 = var10 * JagGraphics3D.anInt367 / var12 + JagGraphics3D.anInt386;
                        int var23 = var17 * JagGraphics3D.anInt367 / var12 + JagGraphics3D.anInt366;
                        int var24 = var14 * JagGraphics3D.anInt367 / var11 + JagGraphics3D.anInt386;
                        int var25 = var18 * JagGraphics3D.anInt367 / var11 + JagGraphics3D.anInt366;
                        int var26 = var13 * JagGraphics3D.anInt367 / var16 + JagGraphics3D.anInt386;
                        int var27 = var19 * JagGraphics3D.anInt367 / var16 + JagGraphics3D.anInt366;
                        int var28 = var9 * JagGraphics3D.anInt367 / var15 + JagGraphics3D.anInt386;
                        int var29 = var21 * JagGraphics3D.anInt367 / var15 + JagGraphics3D.anInt366;
                        JagGraphics3D.alpha = 0;
                        int var30;
                        if ((var26 - var28) * (var25 - var29) - (var27 - var29) * (var24 - var28) > 0) {
                            JagGraphics3D.aBoolean792 = var26 < 0 || var28 < 0 || var24 < 0 || var26 > JagGraphics3D.anInt696 || var28 > JagGraphics3D.anInt696 || var24 > JagGraphics3D.anInt696;

                            if (aBoolean1942 && method1458(walkingMouseX, walkingMouseY, var27, var29, var25, var26, var28, var24)) {
                                selectedRegionTileX = var7;
                                selectedRegionTileY = var8;
                            }

                            if (var1.texture == -1) {
                                if (var1.anInt2001 != 12345678) {
                                    JagGraphics3D.method627(var27, var29, var25, var26, var28, var24, var1.anInt2001, var1.anInt2000, var1.anInt2003);
                                }
                            } else if (!aBoolean1980) {
                                if (var1.flatShade) {
                                    JagGraphics3D.method638(var27, var29, var25, var26, var28, var24, var1.anInt2001, var1.anInt2000, var1.anInt2003, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.texture);
                                } else {
                                    JagGraphics3D.method638(var27, var29, var25, var26, var28, var24, var1.anInt2001, var1.anInt2000, var1.anInt2003, var13, var9, var14, var19, var21, var18, var16, var15, var11, var1.texture);
                                }
                            } else {
                                var30 = JagGraphics3D.aTextureProvider783.method1424(var1.texture);
                                JagGraphics3D.method627(var27, var29, var25, var26, var28, var24, method1444(var30, var1.anInt2001), method1444(var30, var1.anInt2000), method1444(var30, var1.anInt2003));
                            }
                        }

                        if ((var22 - var24) * (var29 - var25) - (var23 - var25) * (var28 - var24) > 0) {
                            JagGraphics3D.aBoolean792 = var22 < 0 || var24 < 0 || var28 < 0 || var22 > JagGraphics3D.anInt696 || var24 > JagGraphics3D.anInt696 || var28 > JagGraphics3D.anInt696;

                            if (aBoolean1942 && method1458(walkingMouseX, walkingMouseY, var23, var25, var29, var22, var24, var28)) {
                                selectedRegionTileX = var7;
                                selectedRegionTileY = var8;
                            }

                            if (var1.texture == -1) {
                                if (var1.anInt2002 != 12345678) {
                                    JagGraphics3D.method627(var23, var25, var29, var22, var24, var28, var1.anInt2002, var1.anInt2003, var1.anInt2000);
                                }
                            } else if (!aBoolean1980) {
                                JagGraphics3D.method638(var23, var25, var29, var22, var24, var28, var1.anInt2002, var1.anInt2003, var1.anInt2000, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.texture);
                            } else {
                                var30 = JagGraphics3D.aTextureProvider783.method1424(var1.texture);
                                JagGraphics3D.method627(var23, var25, var29, var22, var24, var28, method1444(var30, var1.anInt2002), method1444(var30, var1.anInt2003), method1444(var30, var1.anInt2000));
                            }
                        }

                    }
                }
            }
        }
    }

    void method1459(TileModel var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        int var8 = var1.anIntArray1552.length;

        int var9;
        int var10;
        int var11;
        int var12;
        int var13;
        for (var9 = 0; var9 < var8; ++var9) {
            var10 = var1.anIntArray1552[var9] - renderCameraX;
            var11 = var1.anIntArray1541[var9] - renderCameraZ;
            var12 = var1.anIntArray1548[var9] - renderCameraY;
            var13 = var12 * var4 + var5 * var10 >> 16;
            var12 = var5 * var12 - var10 * var4 >> 16;
            var10 = var13;
            var13 = var3 * var11 - var12 * var2 >> 16;
            var12 = var11 * var2 + var3 * var12 >> 16;
            if (var12 < 50) {
                return;
            }

            if (var1.anIntArray1539 != null) {
                TileModel.anIntArray1537[var9] = var10;
                TileModel.anIntArray1550[var9] = var13;
                TileModel.anIntArray1538[var9] = var12;
            }

            TileModel.anIntArray1549[var9] = var10 * JagGraphics3D.anInt367 / var12 + JagGraphics3D.anInt386;
            TileModel.anIntArray1546[var9] = var13 * JagGraphics3D.anInt367 / var12 + JagGraphics3D.anInt366;
        }

        JagGraphics3D.alpha = 0;
        var8 = var1.anIntArray1543.length;

        for (var9 = 0; var9 < var8; ++var9) {
            var10 = var1.anIntArray1543[var9];
            var11 = var1.anIntArray1540[var9];
            var12 = var1.anIntArray1551[var9];
            var13 = TileModel.anIntArray1549[var10];
            int var14 = TileModel.anIntArray1549[var11];
            int var15 = TileModel.anIntArray1549[var12];
            int var16 = TileModel.anIntArray1546[var10];
            int var17 = TileModel.anIntArray1546[var11];
            int var18 = TileModel.anIntArray1546[var12];
            if ((var13 - var14) * (var18 - var17) - (var16 - var17) * (var15 - var14) > 0) {
                JagGraphics3D.aBoolean792 = var13 < 0 || var14 < 0 || var15 < 0 || var13 > JagGraphics3D.anInt696 || var14 > JagGraphics3D.anInt696 || var15 > JagGraphics3D.anInt696;

                if (aBoolean1942 && method1458(walkingMouseX, walkingMouseY, var16, var17, var18, var13, var14, var15)) {
                    selectedRegionTileX = var6;
                    selectedRegionTileY = var7;
                }

                if (var1.anIntArray1539 != null && var1.anIntArray1539[var9] != -1) {
                    if (!aBoolean1980) {
                        if (var1.flatShade) {
                            JagGraphics3D.method638(var16, var17, var18, var13, var14, var15, var1.anIntArray1547[var9], var1.anIntArray1544[var9], var1.anIntArray1542[var9], TileModel.anIntArray1537[0], TileModel.anIntArray1537[1], TileModel.anIntArray1537[3], TileModel.anIntArray1550[0], TileModel.anIntArray1550[1], TileModel.anIntArray1550[3], TileModel.anIntArray1538[0], TileModel.anIntArray1538[1], TileModel.anIntArray1538[3], var1.anIntArray1539[var9]);
                        } else {
                            JagGraphics3D.method638(var16, var17, var18, var13, var14, var15, var1.anIntArray1547[var9], var1.anIntArray1544[var9], var1.anIntArray1542[var9], TileModel.anIntArray1537[var10], TileModel.anIntArray1537[var11], TileModel.anIntArray1537[var12], TileModel.anIntArray1550[var10], TileModel.anIntArray1550[var11], TileModel.anIntArray1550[var12], TileModel.anIntArray1538[var10], TileModel.anIntArray1538[var11], TileModel.anIntArray1538[var12], var1.anIntArray1539[var9]);
                        }
                    } else {
                        int var19 = JagGraphics3D.aTextureProvider783.method1424(var1.anIntArray1539[var9]);
                        JagGraphics3D.method627(var16, var17, var18, var13, var14, var15, method1444(var19, var1.anIntArray1547[var9]), method1444(var19, var1.anIntArray1544[var9]), method1444(var19, var1.anIntArray1542[var9]));
                    }
                } else if (var1.anIntArray1547[var9] != 12345678) {
                    JagGraphics3D.method627(var16, var17, var18, var13, var14, var15, var1.anIntArray1547[var9], var1.anIntArray1544[var9], var1.anIntArray1542[var9]);
                }
            }
        }

    }

    public void method1443() {
        viewportWalking = true;
    }

    public long method1461(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        if (var4 == null) {
            return 0L;
        }
        for (int var5 = 0; var5 < var4.anInt368; ++var5) {
            EntityMarker var6 = var4.markers[var5];
            if (Class69.method379(var6.uid) && var2 == var6.sceneX && var3 == var6.sceneY) {
                return var6.uid;
            }
        }

        return 0L;
    }

    void method1442(UnlitModel var1, int var2, int var3, int var4) {
        Tile var5;
        UnlitModel var6;
        if (var3 < this.width) {
            var5 = this.tiles[var2][var3 + 1][var4];
            if (var5 != null && var5.decor != null && var5.decor.entity instanceof UnlitModel) {
                var6 = (UnlitModel) var5.decor.entity;
                UnlitModel.method970(var1, var6, 128, 0, 0, true);
            }
        }

        if (var4 < this.width) {
            var5 = this.tiles[var2][var3][var4 + 1];
            if (var5 != null && var5.decor != null && var5.decor.entity instanceof UnlitModel) {
                var6 = (UnlitModel) var5.decor.entity;
                UnlitModel.method970(var1, var6, 0, 0, 128, true);
            }
        }

        if (var3 < this.width && var4 < this.length) {
            var5 = this.tiles[var2][var3 + 1][var4 + 1];
            if (var5 != null && var5.decor != null && var5.decor.entity instanceof UnlitModel) {
                var6 = (UnlitModel) var5.decor.entity;
                UnlitModel.method970(var1, var6, 128, 0, 128, true);
            }
        }

        if (var3 < this.width && var4 > 0) {
            var5 = this.tiles[var2][var3 + 1][var4 - 1];
            if (var5 != null && var5.decor != null && var5.decor.entity instanceof UnlitModel) {
                var6 = (UnlitModel) var5.decor.entity;
                UnlitModel.method970(var1, var6, 128, 0, -128, true);
            }
        }

    }

    public void method1486() {
        int var1;
        int var2;
        for (var1 = 0; var1 < this.anInt1971; ++var1) {
            for (var2 = 0; var2 < this.width; ++var2) {
                for (int var3 = 0; var3 < this.length; ++var3) {
                    this.tiles[var1][var2][var3] = null;
                }
            }
        }

        for (var1 = 0; var1 < anInt1938; ++var1) {
            for (var2 = 0; var2 < anIntArray1941[var1]; ++var2) {
                aCameraCaptureArrayArray1939[var1][var2] = null;
            }

            anIntArray1941[var1] = 0;
        }

        for (var1 = 0; var1 < this.anInt1970; ++var1) {
            this.tempMarkers[var1] = null;
        }

        this.anInt1970 = 0;

        for (var1 = 0; var1 < anEntityMarkerArray1940.length; ++var1) {
            anEntityMarkerArray1940[var1] = null;
        }

    }

    public long method1457(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        return var4 != null && var4.decor != null ? var4.decor.uid : 0L;
    }

    boolean method1466(int var1, int var2, int var3, int var4) {
        if (!this.method1464(var1, var2, var3)) {
            return false;
        }
        int var5 = var2 << 7;
        int var6 = var3 << 7;
        return this.method1465(var5 + 1, this.anIntArrayArrayArray1973[var1][var2][var3] - var4, var6 + 1) && this.method1465(var5 + 128 - 1, this.anIntArrayArrayArray1973[var1][var2 + 1][var3] - var4, var6 + 1) && this.method1465(var5 + 128 - 1, this.anIntArrayArrayArray1973[var1][var2 + 1][var3 + 1] - var4, var6 + 128 - 1) && this.method1465(var5 + 1, this.anIntArrayArrayArray1973[var1][var2][var3 + 1] - var4, var6 + 128 - 1);
    }

    public Boundary method1476(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        return var4 == null ? null : var4.boundary;
    }

    public BoundaryDecor method1441(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        return var4 == null ? null : var4.boundaryDecor;
    }

    public EntityMarker method1439(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        if (var4 == null) {
            return null;
        }
        for (int var5 = 0; var5 < var4.anInt368; ++var5) {
            EntityMarker var6 = var4.markers[var5];
            if (Class69.method379(var6.uid) && var2 == var6.sceneX && var3 == var6.sceneY) {
                return var6;
            }
        }

        return null;
    }

    public TileDecor method1454(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        return var4 != null && var4.decor != null ? var4.decor : null;
    }

    boolean method1467(int var1, int var2, int var3, int var4, int var5, int var6) {
        int var7;
        int var8;
        if (var3 == var2 && var5 == var4) {
            if (!this.method1464(var1, var2, var4)) {
                return false;
            }
            var7 = var2 << 7;
            var8 = var4 << 7;
            return this.method1465(var7 + 1, this.anIntArrayArrayArray1973[var1][var2][var4] - var6, var8 + 1) && this.method1465(var7 + 128 - 1, this.anIntArrayArrayArray1973[var1][var2 + 1][var4] - var6, var8 + 1) && this.method1465(var7 + 128 - 1, this.anIntArrayArrayArray1973[var1][var2 + 1][var4 + 1] - var6, var8 + 128 - 1) && this.method1465(var7 + 1, this.anIntArrayArrayArray1973[var1][var2][var4 + 1] - var6, var8 + 128 - 1);
        }
        for (var7 = var2; var7 <= var3; ++var7) {
            for (var8 = var4; var8 <= var5; ++var8) {
                if (this.anIntArrayArrayArray1966[var1][var7][var8] == -renderTick) {
                    return false;
                }
            }
        }

        var7 = (var2 << 7) + 1;
        var8 = (var4 << 7) + 2;
        int var9 = this.anIntArrayArrayArray1973[var1][var2][var4] - var6;
        if (!this.method1465(var7, var9, var8)) {
            return false;
        }
        int var10 = (var3 << 7) - 1;
        if (!this.method1465(var10, var9, var8)) {
            return false;
        }
        int var11 = (var5 << 7) - 1;
        if (!this.method1465(var7, var9, var11)) {
            return false;
        }
        return this.method1465(var10, var9, var11);
    }

    void method1468() {
        int var1 = anIntArray1941[renderFloor];
        CameraCapture[] var2 = aCameraCaptureArrayArray1939[renderFloor];
        anInt1933 = 0;

        for (int var3 = 0; var3 < var1; ++var3) {
            CameraCapture var4 = var2[var3];
            int var5;
            int var6;
            int var7;
            int var9;
            boolean var13;
            if (var4.flag == 1) {
                var5 = var4.anInt1922 - renderSceneX + 25;
                if (var5 >= 0 && var5 <= 50) {
                    var6 = var4.anInt1920 - renderSceneY + 25;
                    if (var6 < 0) {
                        var6 = 0;
                    }

                    var7 = var4.anInt1919 - renderSceneY + 25;
                    if (var7 > 50) {
                        var7 = 50;
                    }

                    var13 = false;

                    while (var6 <= var7) {
                        if (aBooleanArrayArray1951[var5][var6++]) {
                            var13 = true;
                            break;
                        }
                    }

                    if (var13) {
                        var9 = renderCameraX - var4.minFineX;
                        if (var9 > 32) {
                            var4.anInt1912 = 1;
                        } else {
                            if (var9 >= -32) {
                                continue;
                            }

                            var4.anInt1912 = 2;
                            var9 = -var9;
                        }

                        var4.anInt1914 = (var4.minFineY - renderCameraY << 8) / var9;
                        var4.anInt1921 = (var4.maxFineY - renderCameraY << 8) / var9;
                        var4.anInt1918 = (var4.componentHeight - renderCameraZ << 8) / var9;
                        var4.anInt1915 = (var4.tileHeight - renderCameraZ << 8) / var9;
                        cameraCaptures[anInt1933++] = var4;
                    }
                }
            } else if (var4.flag == 2) {
                var5 = var4.anInt1920 - renderSceneY + 25;
                if (var5 >= 0 && var5 <= 50) {
                    var6 = var4.anInt1922 - renderSceneX + 25;
                    if (var6 < 0) {
                        var6 = 0;
                    }

                    var7 = var4.anInt1916 - renderSceneX + 25;
                    if (var7 > 50) {
                        var7 = 50;
                    }

                    var13 = false;

                    while (var6 <= var7) {
                        if (aBooleanArrayArray1951[var6++][var5]) {
                            var13 = true;
                            break;
                        }
                    }

                    if (var13) {
                        var9 = renderCameraY - var4.minFineY;
                        if (var9 > 32) {
                            var4.anInt1912 = 3;
                        } else {
                            if (var9 >= -32) {
                                continue;
                            }

                            var4.anInt1912 = 4;
                            var9 = -var9;
                        }

                        var4.anInt1917 = (var4.minFineX - renderCameraX << 8) / var9;
                        var4.anInt1911 = (var4.maxFineX - renderCameraX << 8) / var9;
                        var4.anInt1918 = (var4.componentHeight - renderCameraZ << 8) / var9;
                        var4.anInt1915 = (var4.tileHeight - renderCameraZ << 8) / var9;
                        cameraCaptures[anInt1933++] = var4;
                    }
                }
            } else if (var4.flag == 4) {
                var5 = var4.componentHeight - renderCameraZ;
                if (var5 > 128) {
                    var6 = var4.anInt1920 - renderSceneY + 25;
                    if (var6 < 0) {
                        var6 = 0;
                    }

                    var7 = var4.anInt1919 - renderSceneY + 25;
                    if (var7 > 50) {
                        var7 = 50;
                    }

                    if (var6 <= var7) {
                        int var8 = var4.anInt1922 - renderSceneX + 25;
                        if (var8 < 0) {
                            var8 = 0;
                        }

                        var9 = var4.anInt1916 - renderSceneX + 25;
                        if (var9 > 50) {
                            var9 = 50;
                        }

                        boolean var10 = false;

                        label144:
                        for (int var11 = var8; var11 <= var9; ++var11) {
                            for (int var12 = var6; var12 <= var7; ++var12) {
                                if (aBooleanArrayArray1951[var11][var12]) {
                                    var10 = true;
                                    break label144;
                                }
                            }
                        }

                        if (var10) {
                            var4.anInt1912 = 5;
                            var4.anInt1917 = (var4.minFineX - renderCameraX << 8) / var5;
                            var4.anInt1911 = (var4.maxFineX - renderCameraX << 8) / var5;
                            var4.anInt1914 = (var4.minFineY - renderCameraY << 8) / var5;
                            var4.anInt1921 = (var4.maxFineY - renderCameraY << 8) / var5;
                            cameraCaptures[anInt1933++] = var4;
                        }
                    }
                }
            }
        }

    }

    public void deleteItemPile(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        if (var4 != null) {
            var4.pickablePile = null;
        }
    }

    public void addPickable(int var1, int var2, int var3, int var4, Entity var5, long var6, Entity var8, Entity var9) {
        PickablePile var10 = new PickablePile();
        var10.bottom = var5;
        var10.fineX = var2 * 128 + 64;
        var10.fineY = var3 * 128 + 64;
        var10.anInt172 = var4;
        var10.uid = var6;
        var10.middle = var8;
        var10.top = var9;
        int var11 = 0;
        Tile var12 = this.tiles[var1][var2][var3];
        if (var12 != null) {
            for (int var13 = 0; var13 < var12.anInt368; ++var13) {
                if ((var12.markers[var13].config & 256) == 256 && var12.markers[var13].entity instanceof Model) {
                    Model var14 = (Model) var12.markers[var13].entity;
                    var14.method827();
                    if (var14.height > var11) {
                        var11 = var14.height;
                    }
                }
            }
        }

        var10.height = var11;
        if (this.tiles[var1][var2][var3] == null) {
            this.tiles[var1][var2][var3] = new Tile(var1, var2, var3);
        }

        this.tiles[var1][var2][var3].pickablePile = var10;
    }

    void renderTile(Tile var1, boolean var2) {
        aNodeDeque1936.add(var1);


        while (true) {
            Tile renderingTile;
            int var4;
            int var5;
            int var6;
            int var7;
            Tile[][] var8;
            Tile var9;
            int var11;
            int var16;
            int var17;
            int var18;
            int var24;
            int var25;
            while (true) {
                Boundary var10;
                EntityMarker var12;
                boolean var13;
                int var14;
                int var19;
                int var20;
                Tile var36;
                while (true) {
                    renderingTile = (Tile) aNodeDeque1936.popFirst();
                    if (renderingTile == null) {
                        return;
                    }

                    while (!renderingTile.aBoolean1151) {
                        renderingTile = (Tile) aNodeDeque1936.popFirst();
                        if (renderingTile == null) {

                            return;
                        }
                    }

                    var4 = renderingTile.sceneX;
                    var5 = renderingTile.sceneY;
                    var6 = renderingTile.floorLevel;
                    var7 = renderingTile.anInt380;
                    var8 = this.tiles[var6];
                    if (!renderingTile.aBoolean665) {
                        break;
                    }

                    if (var2) {
                        if (var6 > 0) {
                            var9 = this.tiles[var6 - 1][var4][var5];
                            if (var9 != null && var9.aBoolean1151) {
                                continue;
                            }
                        }

                        if (var4 <= renderSceneX && var4 > renderAreaMinX) {
                            var9 = var8[var4 - 1][var5];
                            if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 1) == 0)) {
                                continue;
                            }
                        }

                        if (var4 >= renderSceneX && var4 < renderAreaMaxX - 1) {
                            var9 = var8[var4 + 1][var5];
                            if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 4) == 0)) {
                                continue;
                            }
                        }

                        if (var5 <= renderSceneY && var5 > renderAreaMinY) {
                            var9 = var8[var4][var5 - 1];
                            if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 8) == 0)) {
                                continue;
                            }
                        }

                        if (var5 >= renderSceneY && var5 < renderAreaMaxY - 1) {
                            var9 = var8[var4][var5 + 1];
                            if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 2) == 0)) {
                                continue;
                            }
                        }
                    } else {
                        var2 = true;
                    }

                    renderingTile.aBoolean665 = false;
                    if (renderingTile.aTile1150 != null) {
                        var9 = renderingTile.aTile1150;
                        if (var9.paint != null) {
                            if (!this.method1464(0, var4, var5)) {

                                this.method1462(var9.paint, 0, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                            }
                        } else if (var9.model != null && !this.method1464(0, var4, var5)) {
                            this.method1459(var9.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                        }

                        var10 = var9.boundary;
                        if (var10 != null) {
                            var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX - renderCameraX, var10.height - renderCameraZ, var10.fineY - renderCameraY, var10.uid);
                        }

                        for (var11 = 0; var11 < var9.anInt368; ++var11) {
                            var12 = var9.markers[var11];
                            if (var12 != null) {
                                var12.entity.method11(var12.orientation, pitchSin, pitchCos, yawSin, yawCos, var12.centerFineX - renderCameraX, var12.height - renderCameraZ, var12.centerFineY - renderCameraY, var12.uid);
                            }
                        }
                    }

                    var13 = false;
                    if (renderingTile.paint != null) {
                        if (!this.method1464(var7, var4, var5)) {
                            var13 = true;
                            if (renderingTile.paint.anInt2001 != 12345678 || aBoolean1942 && var6 <= anInt1931) {
                                this.method1462(renderingTile.paint, var7, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                            }
                        }
                    } else if (renderingTile.model != null && !this.method1464(var7, var4, var5)) {
                        var13 = true;
                        this.method1459(renderingTile.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                    }

                    var14 = 0;
                    var11 = 0;
                    Boundary var31 = renderingTile.boundary;
                    BoundaryDecor var15 = renderingTile.boundaryDecor;
                    if (var31 != null || var15 != null) {
                        if (var4 == renderSceneX) {
                            ++var14;
                        } else if (renderSceneX < var4) {
                            var14 += 2;
                        }

                        if (var5 == renderSceneY) {
                            var14 += 3;
                        } else if (renderSceneY > var5) {
                            var14 += 6;
                        }

                        var11 = anIntArray1935[var14];
                        renderingTile.anInt1149 = anIntArray1948[var14];
                    }

                    if (var31 != null) {
                        if ((var31.orientation & anIntArray1937[var14]) != 0) {
                            if (var31.orientation == 16) {
                                renderingTile.anInt791 = 3;
                                renderingTile.anInt563 = anIntArray1945[var14];
                                renderingTile.anInt575 = 3 - renderingTile.anInt563;
                            } else if (var31.orientation == 32) {
                                renderingTile.anInt791 = 6;
                                renderingTile.anInt563 = anIntArray1934[var14];
                                renderingTile.anInt575 = 6 - renderingTile.anInt563;
                            } else if (var31.orientation == 64) {
                                renderingTile.anInt791 = 12;
                                renderingTile.anInt563 = anIntArray1944[var14];
                                renderingTile.anInt575 = 12 - renderingTile.anInt563;
                            } else {
                                renderingTile.anInt791 = 9;
                                renderingTile.anInt563 = anIntArray1959[var14];
                                renderingTile.anInt575 = 9 - renderingTile.anInt563;
                            }
                        } else {
                            renderingTile.anInt791 = 0;
                        }

                        if ((var31.orientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.orientation)) {
                            var31.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX - renderCameraX, var31.height - renderCameraZ, var31.fineY - renderCameraY, var31.uid);
                        }

                        if ((var31.linkedOrientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.linkedOrientation)) {
                            var31.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX - renderCameraX, var31.height - renderCameraZ, var31.fineY - renderCameraY, var31.uid);
                        }
                    }

                    if (var15 != null && !this.method1466(var7, var4, var5, var15.entity.height)) {
                        if ((var15.renderConfig & var11) != 0) {
                            var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var15.offsetX + (var15.fineX - renderCameraX), var15.height - renderCameraZ, var15.offsetY + (var15.fineY - renderCameraY), var15.uid);
                        } else if (var15.renderConfig == 256) {
                            var16 = var15.fineX - renderCameraX;
                            var17 = var15.height - renderCameraZ;
                            var18 = var15.fineY * renderCameraY;
                            var19 = var15.orientation;
                            if (var19 != 1 && var19 != 2) {
                                var20 = var16;
                            } else {
                                var20 = -var16;
                            }

                            int var21;
                            if (var19 != 2 && var19 != 3) {
                                var21 = var18;
                            } else {
                                var21 = -var18;
                            }

                            if (var21 < var20) {
                                var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16 + var15.offsetX, var17, var18 + var15.offsetY, var15.uid);
                            } else if (var15.linkedEntity != null) {
                                var15.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16, var17, var18, var15.uid);
                            }
                        }
                    }

                    if (var13) {
                        TileDecor var22 = renderingTile.decor;
                        if (var22 != null) {
                            var22.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var22.fineX * renderCameraX, var22.height - renderCameraZ, var22.fineY - renderCameraY, var22.uid);
                        }

                        PickablePile var23 = renderingTile.pickablePile;
                        if (var23 != null && var23.height == 0) {
                            if (var23.middle != null) {
                                var23.middle.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX *
                                        renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                            }

                            if (var23.top != null) {
                                var23.top.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                            }

                            if (var23.bottom != null) {
                                var23.bottom.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                            }
                        }
                    }

                    var16 = renderingTile.anInt366;
                    if (var16 != 0) {
                        if (var4 < renderSceneX && (var16 & 4) != 0) {
                            var36 = var8[var4 + 1][var5];
                            if (var36 != null && var36.aBoolean1151) {
                                aNodeDeque1936.add(var36);
                            }
                        }

                        if (var5 < renderSceneY && (var16 & 2) != 0) {
                            var36 = var8[var4][var5 + 1];
                            if (var36 != null && var36.aBoolean1151) {
                                aNodeDeque1936.add(var36);
                            }
                        }

                        if (var4 > renderSceneX && (var16 & 1) != 0) {
                            var36 = var8[var4 - 1][var5];
                            if (var36 != null && var36.aBoolean1151) {
                                aNodeDeque1936.add(var36);
                            }
                        }

                        if (var5 > renderSceneY && (var16 & 8) != 0) {
                            var36 = var8[var4][var5 - 1];
                            if (var36 != null && var36.aBoolean1151) {
                                aNodeDeque1936.add(var36);
                            }
                        }
                    }
                    break;
                }

                if (renderingTile.anInt791 != 0) {
                    var13 = true;

                    for (var14 = 0; var14 < renderingTile.anInt368; ++var14) {
                        if (renderingTile.markers[var14].anInt452 != renderTick && (renderingTile.anIntArray374[var14] & renderingTile.anInt791) == renderingTile.anInt563) {
                            var13 = false;
                            break;
                        }
                    }

                    if (var13) {
                        var10 = renderingTile.boundary;
                        if (!this.method1463(var7, var4, var5, var10.orientation)) {
                            var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                        }

                        renderingTile.anInt791 = 0;
                    }
                }

                if (!renderingTile.aBoolean562) {
                    break;
                }

                try {
                    int var33 = renderingTile.anInt368;
                    renderingTile.aBoolean562 = false;
                    var14 = 0;

                    label563:
                    for (var11 = 0; var11 < var33; ++var11) {
                        var12 = renderingTile.markers[var11];
                        if (var12.anInt452 != renderTick) {
                            for (var24 = var12.sceneX; var24 <= var12.maxSceneX; ++var24) {
                                for (var16 = var12.sceneY; var16 <= var12.maxSceneY; ++var16) {
                                    var36 = var8[var24][var16];
                                    if (var36.aBoolean665) {
                                        renderingTile.aBoolean562 = true;
                                        continue label563;
                                    }

                                    if (var36.anInt791 != 0) {
                                        var18 = 0;
                                        if (var24 > var12.sceneX) {
                                            ++var18;
                                        }

                                        if (var24 < var12.maxSceneX) {
                                            var18 += 4;
                                        }

                                        if (var16 > var12.sceneY) {
                                            var18 += 8;
                                        }

                                        if (var16 < var12.maxSceneY) {
                                            var18 += 2;
                                        }

                                        if ((var18 & var36.anInt791) == renderingTile.anInt575) {
                                            renderingTile.aBoolean562 = true;
                                            continue label563;
                                        }
                                    }
                                }
                            }

                            anEntityMarkerArray1940[var14++] = var12;
                            var24 = renderSceneX - var12.sceneX;
                            var16 = var12.maxSceneX - renderSceneX;
                            if (var16 > var24) {
                                var24 = var16;
                            }

                            var17 = renderSceneY - var12.sceneY;
                            var18 = var12.maxSceneY - renderSceneY;
                            if (var18 > var17) {
                                var12.anInt453 = var24 + var18;
                            } else {
                                var12.anInt453 = var24 + var17;
                            }
                        }
                    }

                    while (var14 > 0) {
                        var11 = -50;
                        var25 = -1;

                        for (var24 = 0; var24 < var14; ++var24) {
                            EntityMarker var35 = anEntityMarkerArray1940[var24];
                            if (var35.anInt452 != renderTick) {
                                if (var35.anInt453 > var11) {
                                    var11 = var35.anInt453;
                                    var25 = var24;
                                } else if (var11 == var35.anInt453) {
                                    var17 = var35.centerFineX - renderCameraX;
                                    var18 = var35.centerFineY - renderCameraY;
                                    var19 = anEntityMarkerArray1940[var25].centerFineX - renderCameraX;
                                    var20 = anEntityMarkerArray1940[var25].centerFineY - renderCameraY;
                                    if (var17 * var17 + var18 * var18 > var19 * var19 + var20 * var20) {
                                        var25 = var24;
                                    }
                                }
                            }
                        }

                        if (var25 == -1) {
                            break;
                        }

                        EntityMarker var34 = anEntityMarkerArray1940[var25];
                        var34.anInt452 = renderTick;
                        if (!this.method1467(var7, var34.sceneX, var34.maxSceneX, var34.sceneY, var34.maxSceneY, var34.entity.height)) {
                            var34.entity.method11(var34.orientation, pitchSin, pitchCos, yawSin, yawCos, var34.centerFineX - renderCameraX, var34.height - renderCameraZ, var34.centerFineY - renderCameraY, var34.uid);
                        }

                        for (var16 = var34.sceneX; var16 <= var34.maxSceneX; ++var16) {
                            for (var17 = var34.sceneY; var17 <= var34.maxSceneY; ++var17) {
                                Tile var26 = var8[var16][var17];
                                if (var26.anInt791 != 0) {
                                    aNodeDeque1936.add(var26);
                                } else if ((var16 != var4 || var17 != var5) && var26.aBoolean1151) {
                                    aNodeDeque1936.add(var26);
                                }
                            }
                        }
                    }

                    if (!renderingTile.aBoolean562) {
                        break;
                    }
                } catch (Exception var28) {
                    renderingTile.aBoolean562 = false;
                    break;
                }
            }
            while (!renderingTile.aBoolean1151) {
                while (true) {
                    Boundary var10;
                    EntityMarker var12;
                    boolean var13;
                    int var14;
                    int var19;
                    int var20;
                    Tile var36;
                    while (true) {
                        do {
                            renderingTile = (Tile) aNodeDeque1936.popFirst();
                            if (renderingTile == null) {

                                return;
                            }
                        } while (!renderingTile.aBoolean1151);

                        var4 = renderingTile.sceneX;
                        var5 = renderingTile.sceneY;
                        var6 = renderingTile.floorLevel;
                        var7 = renderingTile.anInt380;
                        var8 = this.tiles[var6];
                        if (!renderingTile.aBoolean665) {
                            break;
                        }

                        if (var2) {
                            if (var6 > 0) {
                                var9 = this.tiles[var6 - 1][var4][var5];
                                if (var9 != null && var9.aBoolean1151) {
                                    continue;
                                }
                            }

                            if (var4 <= renderSceneX && var4 > renderAreaMinX) {
                                var9 = var8[var4 - 1][var5];
                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 1) == 0)) {
                                    continue;
                                }
                            }

                            if (var4 >= renderSceneX && var4 < renderAreaMaxX - 1) {
                                var9 = var8[var4 + 1][var5];
                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 4) == 0)) {
                                    continue;
                                }
                            }

                            if (var5 <= renderSceneY && var5 > renderAreaMinY) {
                                var9 = var8[var4][var5 - 1];
                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 8) == 0)) {
                                    continue;
                                }
                            }

                            if (var5 >= renderSceneY && var5 < renderAreaMaxY - 1) {
                                var9 = var8[var4][var5 + 1];
                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 2) == 0)) {
                                    continue;
                                }
                            }
                        } else {
                            var2 = true;
                        }

                        renderingTile.aBoolean665 = false;
                        if (renderingTile.aTile1150 != null) {
                            var9 = renderingTile.aTile1150;
                            if (var9.paint != null) {
                                if (!this.method1464(0, var4, var5)) {
                                    this.method1462(var9.paint, 0, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                }
                            } else if (var9.model != null && !this.method1464(0, var4, var5)) {
                                this.method1459(var9.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                            }

                            var10 = var9.boundary;
                            if (var10 != null) {
                                var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                            }

                            for (var11 = 0; var11 < var9.anInt368; ++var11) {
                                var12 = var9.markers[var11];
                                if (var12 != null) {
                                    var12.entity.method11(var12.orientation, pitchSin, pitchCos, yawSin, yawCos, var12.centerFineX - renderCameraX, var12.height - renderCameraZ, var12.centerFineY - renderCameraY, var12.uid);
                                }
                            }
                        }

                        var13 = false;
                        if (renderingTile.paint != null) {
                            if (!this.method1464(var7, var4, var5)) {
                                var13 = true;
                                if (renderingTile.paint.anInt2001 != 12345678 || aBoolean1942 && var6 <= anInt1931) {
                                    this.method1462(renderingTile.paint, var7, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                }
                            }
                        } else if (renderingTile.model != null && !this.method1464(var7, var4, var5)) {
                            var13 = true;
                            this.method1459(renderingTile.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                        }

                        var14 = 0;
                        var11 = 0;
                        Boundary var31 = renderingTile.boundary;
                        BoundaryDecor var15 = renderingTile.boundaryDecor;
                        if (var31 != null || var15 != null) {
                            if (var4 == renderSceneX) {
                                ++var14;
                            } else if (renderSceneX < var4) {
                                var14 += 2;
                            }

                            if (var5 == renderSceneY) {
                                var14 += 3;
                            } else if (renderSceneY > var5) {
                                var14 += 6;
                            }

                            var11 = anIntArray1935[var14];
                            renderingTile.anInt1149 = anIntArray1948[var14];
                        }

                        if (var31 != null) {
                            if ((var31.orientation & anIntArray1937[var14]) != 0) {
                                if (var31.orientation == 16) {
                                    renderingTile.anInt791 = 3;
                                    renderingTile.anInt563 = anIntArray1945[var14];
                                    renderingTile.anInt575 = 3 - renderingTile.anInt563;
                                } else if (var31.orientation == 32) {
                                    renderingTile.anInt791 = 6;
                                    renderingTile.anInt563 = anIntArray1934[var14];
                                    renderingTile.anInt575 = 6 - renderingTile.anInt563;
                                } else if (var31.orientation == 64) {
                                    renderingTile.anInt791 = 12;
                                    renderingTile.anInt563 = anIntArray1944[var14];
                                    renderingTile.anInt575 = 12 - renderingTile.anInt563;
                                } else {
                                    renderingTile.anInt791 = 9;
                                    renderingTile.anInt563 = anIntArray1959[var14];
                                    renderingTile.anInt575 = 9 - renderingTile.anInt563;
                                }
                            } else {
                                renderingTile.anInt791 = 0;
                            }

                            if ((var31.orientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.orientation)) {
                                var31.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                            }

                            if ((var31.linkedOrientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.linkedOrientation)) {
                                var31.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                            }
                        }

                        if (var15 != null && !this.method1466(var7, var4, var5, var15.entity.height)) {
                            if ((var15.renderConfig & var11) != 0) {
                                var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var15.offsetX + (var15.fineX * renderCameraX), var15.height - renderCameraZ, var15.offsetY + (var15.fineY * renderCameraY), var15.uid);
                            } else if (var15.renderConfig == 256) {
                                var16 = var15.fineX * renderCameraX;
                                var17 = var15.height - renderCameraZ;
                                var18 = var15.fineY * renderCameraY;
                                var19 = var15.orientation;
                                if (var19 != 1 && var19 != 2) {
                                    var20 = var16;
                                } else {
                                    var20 = -var16;
                                }

                                int var21;
                                if (var19 != 2 && var19 != 3) {
                                    var21 = var18;
                                } else {
                                    var21 = -var18;
                                }

                                if (var21 < var20) {
                                    var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16 + var15.offsetX, var17, var18 + var15.offsetY, var15.uid);
                                } else if (var15.linkedEntity != null) {
                                    var15.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16, var17, var18, var15.uid);
                                }
                            }
                        }

                        if (var13) {
                            TileDecor var22 = renderingTile.decor;
                            if (var22 != null) {
                                var22.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var22.fineX * renderCameraX, var22.height - renderCameraZ, var22.fineY * renderCameraY, var22.uid);
                            }

                            PickablePile var23 = renderingTile.pickablePile;
                            if (var23 != null && var23.height == 0) {
                                if (var23.middle != null) {
                                    var23.middle.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                }

                                if (var23.top != null) {
                                    var23.top.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                }

                                if (var23.bottom != null) {
                                    var23.bottom.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                }
                            }
                        }

                        var16 = renderingTile.anInt366;
                        if (var16 != 0) {
                            if (var4 < renderSceneX && (var16 & 4) != 0) {
                                var36 = var8[var4 + 1][var5];
                                if (var36 != null && var36.aBoolean1151) {
                                    aNodeDeque1936.add(var36);
                                }
                            }

                            if (var5 < renderSceneY && (var16 & 2) != 0) {
                                var36 = var8[var4][var5 + 1];
                                if (var36 != null && var36.aBoolean1151) {
                                    aNodeDeque1936.add(var36);
                                }
                            }

                            if (var4 > renderSceneX && (var16 & 1) != 0) {
                                var36 = var8[var4 - 1][var5];
                                if (var36 != null && var36.aBoolean1151) {
                                    aNodeDeque1936.add(var36);
                                }
                            }

                            if (var5 > renderSceneY && (var16 & 8) != 0) {
                                var36 = var8[var4][var5 - 1];
                                if (var36 != null && var36.aBoolean1151) {
                                    aNodeDeque1936.add(var36);
                                }
                            }
                        }
                        break;
                    }

                    if (renderingTile.anInt791 != 0) {
                        var13 = true;

                        for (var14 = 0; var14 < renderingTile.anInt368; ++var14) {
                            if (renderingTile.markers[var14].anInt452 != renderTick && (renderingTile.anIntArray374[var14] & renderingTile.anInt791) == renderingTile.anInt563) {
                                var13 = false;
                                break;
                            }
                        }

                        if (var13) {
                            var10 = renderingTile.boundary;
                            if (!this.method1463(var7, var4, var5, var10.orientation)) {
                                var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                            }

                            renderingTile.anInt791 = 0;
                        }
                    }

                    if (!renderingTile.aBoolean562) {
                        break;
                    }

                    try {
                        int var33 = renderingTile.anInt368;
                        renderingTile.aBoolean562 = false;
                        var14 = 0;

                        label563:
                        for (var11 = 0; var11 < var33; ++var11) {
                            var12 = renderingTile.markers[var11];
                            if (var12.anInt452 != renderTick) {
                                for (var24 = var12.sceneX; var24 <= var12.maxSceneX; ++var24) {
                                    for (var16 = var12.sceneY; var16 <= var12.maxSceneY; ++var16) {
                                        var36 = var8[var24][var16];
                                        if (var36.aBoolean665) {
                                            renderingTile.aBoolean562 = true;
                                            continue label563;
                                        }

                                        if (var36.anInt791 != 0) {
                                            var18 = 0;
                                            if (var24 > var12.sceneX) {
                                                ++var18;
                                            }

                                            if (var24 < var12.maxSceneX) {
                                                var18 += 4;
                                            }

                                            if (var16 > var12.sceneY) {
                                                var18 += 8;
                                            }

                                            if (var16 < var12.maxSceneY) {
                                                var18 += 2;
                                            }

                                            if ((var18 & var36.anInt791) == renderingTile.anInt575) {
                                                renderingTile.aBoolean562 = true;
                                                continue label563;
                                            }
                                        }
                                    }
                                }

                                anEntityMarkerArray1940[var14++] = var12;
                                var24 = renderSceneX - var12.sceneX;
                                var16 = var12.maxSceneX - renderSceneX;
                                if (var16 > var24) {
                                    var24 = var16;
                                }

                                var17 = renderSceneY - var12.sceneY;
                                var18 = var12.maxSceneY - renderSceneY;
                                if (var18 > var17) {
                                    var12.anInt453 = var24 + var18;
                                } else {
                                    var12.anInt453 = var24 + var17;
                                }
                            }
                        }

                        while (var14 > 0) {
                            var11 = -50;
                            var25 = -1;

                            for (var24 = 0; var24 < var14; ++var24) {
                                EntityMarker var35 = anEntityMarkerArray1940[var24];
                                if (var35.anInt452 != renderTick) {
                                    if (var35.anInt453 > var11) {
                                        var11 = var35.anInt453;
                                        var25 = var24;
                                    } else if (var11 == var35.anInt453) {
                                        var17 = var35.centerFineX - renderCameraX;
                                        var18 = var35.centerFineY - renderCameraY;
                                        var19 = anEntityMarkerArray1940[var25].centerFineX - renderCameraX;
                                        var20 = anEntityMarkerArray1940[var25].centerFineY - renderCameraY;
                                        if (var17 * var17 + var18 * var18 > var19 * var19 + var20 * var20) {
                                            var25 = var24;
                                        }
                                    }
                                }
                            }

                            if (var25 == -1) {
                                break;
                            }

                            EntityMarker var34 = anEntityMarkerArray1940[var25];
                            var34.anInt452 = renderTick;
                            if (!this.method1467(var7, var34.sceneX, var34.maxSceneX, var34.sceneY, var34.maxSceneY, var34.entity.height)) {
                                var34.entity.method11(var34.orientation, pitchSin, pitchCos, yawSin, yawCos, var34.centerFineX - renderCameraX, var34.height - renderCameraZ, var34.centerFineY - renderCameraY, var34.uid);
                            }

                            for (var16 = var34.sceneX; var16 <= var34.maxSceneX; ++var16) {
                                for (var17 = var34.sceneY; var17 <= var34.maxSceneY; ++var17) {
                                    Tile var26 = var8[var16][var17];
                                    if (var26.anInt791 != 0) {
                                        aNodeDeque1936.add(var26);
                                    } else if ((var16 != var4 || var17 != var5) && var26.aBoolean1151) {
                                        aNodeDeque1936.add(var26);
                                    }
                                }
                            }
                        }

                        if (!renderingTile.aBoolean562) {
                            break;
                        }
                    } catch (Exception var28) {
                        renderingTile.aBoolean562 = false;
                        break;
                    }
                }
            }
            while (renderingTile.anInt791 != 0) {
                do {
                    while (true) {
                        Boundary var10;
                        EntityMarker var12;
                        boolean var13;
                        int var14;
                        int var19;
                        int var20;
                        Tile var36;
                        while (true) {
                            do {
                                renderingTile = (Tile) aNodeDeque1936.popFirst();
                                if (renderingTile == null) {

                                    return;
                                }
                            } while (!renderingTile.aBoolean1151);

                            var4 = renderingTile.sceneX;
                            var5 = renderingTile.sceneY;
                            var6 = renderingTile.floorLevel;
                            var7 = renderingTile.anInt380;
                            var8 = this.tiles[var6];
                            if (!renderingTile.aBoolean665) {
                                break;
                            }

                            if (var2) {
                                if (var6 > 0) {
                                    var9 = this.tiles[var6 - 1][var4][var5];
                                    if (var9 != null && var9.aBoolean1151) {
                                        continue;
                                    }
                                }

                                if (var4 <= renderSceneX && var4 > renderAreaMinX) {
                                    var9 = var8[var4 - 1][var5];
                                    if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 1) == 0)) {
                                        continue;
                                    }
                                }

                                if (var4 >= renderSceneX && var4 < renderAreaMaxX - 1) {
                                    var9 = var8[var4 + 1][var5];
                                    if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 4) == 0)) {
                                        continue;
                                    }
                                }

                                if (var5 <= renderSceneY && var5 > renderAreaMinY) {
                                    var9 = var8[var4][var5 - 1];
                                    if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 8) == 0)) {
                                        continue;
                                    }
                                }

                                if (var5 >= renderSceneY && var5 < renderAreaMaxY - 1) {
                                    var9 = var8[var4][var5 + 1];
                                    if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 2) == 0)) {
                                        continue;
                                    }
                                }
                            } else {
                                var2 = true;
                            }

                            renderingTile.aBoolean665 = false;
                            if (renderingTile.aTile1150 != null) {
                                var9 = renderingTile.aTile1150;
                                if (var9.paint != null) {
                                    if (!this.method1464(0, var4, var5)) {
                                        this.method1462(var9.paint, 0, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                    }
                                } else if (var9.model != null && !this.method1464(0, var4, var5)) {
                                    this.method1459(var9.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                }

                                var10 = var9.boundary;
                                if (var10 != null) {
                                    var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                }

                                for (var11 = 0; var11 < var9.anInt368; ++var11) {
                                    var12 = var9.markers[var11];
                                    if (var12 != null) {
                                        var12.entity.method11(var12.orientation, pitchSin, pitchCos, yawSin, yawCos, var12.centerFineX - renderCameraX, var12.height - renderCameraZ, var12.centerFineY - renderCameraY, var12.uid);
                                    }
                                }
                            }

                            var13 = false;
                            if (renderingTile.paint != null) {
                                if (!this.method1464(var7, var4, var5)) {
                                    var13 = true;
                                    if (renderingTile.paint.anInt2001 != 12345678 || aBoolean1942 && var6 <= anInt1931) {
                                        this.method1462(renderingTile.paint, var7, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                    }
                                }
                            } else if (renderingTile.model != null && !this.method1464(var7, var4, var5)) {
                                var13 = true;
                                this.method1459(renderingTile.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                            }

                            var14 = 0;
                            var11 = 0;
                            Boundary var31 = renderingTile.boundary;
                            BoundaryDecor var15 = renderingTile.boundaryDecor;
                            if (var31 != null || var15 != null) {
                                if (var4 == renderSceneX) {
                                    ++var14;
                                } else if (renderSceneX < var4) {
                                    var14 += 2;
                                }

                                if (var5 == renderSceneY) {
                                    var14 += 3;
                                } else if (renderSceneY > var5) {
                                    var14 += 6;
                                }

                                var11 = anIntArray1935[var14];
                                renderingTile.anInt1149 = anIntArray1948[var14];
                            }

                            if (var31 != null) {
                                if ((var31.orientation & anIntArray1937[var14]) != 0) {
                                    if (var31.orientation == 16) {
                                        renderingTile.anInt791 = 3;
                                        renderingTile.anInt563 = anIntArray1945[var14];
                                        renderingTile.anInt575 = 3 - renderingTile.anInt563;
                                    } else if (var31.orientation == 32) {
                                        renderingTile.anInt791 = 6;
                                        renderingTile.anInt563 = anIntArray1934[var14];
                                        renderingTile.anInt575 = 6 - renderingTile.anInt563;
                                    } else if (var31.orientation == 64) {
                                        renderingTile.anInt791 = 12;
                                        renderingTile.anInt563 = anIntArray1944[var14];
                                        renderingTile.anInt575 = 12 - renderingTile.anInt563;
                                    } else {
                                        renderingTile.anInt791 = 9;
                                        renderingTile.anInt563 = anIntArray1959[var14];
                                        renderingTile.anInt575 = 9 - renderingTile.anInt563;
                                    }
                                } else {
                                    renderingTile.anInt791 = 0;
                                }

                                if ((var31.orientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.orientation)) {
                                    var31.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                }

                                if ((var31.linkedOrientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.linkedOrientation)) {
                                    var31.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                }
                            }

                            if (var15 != null && !this.method1466(var7, var4, var5, var15.entity.height)) {
                                if ((var15.renderConfig & var11) != 0) {
                                    var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var15.offsetX + (var15.fineX * renderCameraX), var15.height - renderCameraZ, var15.offsetY + (var15.fineY * renderCameraY), var15.uid);
                                } else if (var15.renderConfig == 256) {
                                    var16 = var15.fineX * renderCameraX;
                                    var17 = var15.height - renderCameraZ;
                                    var18 = var15.fineY * renderCameraY;
                                    var19 = var15.orientation;
                                    if (var19 != 1 && var19 != 2) {
                                        var20 = var16;
                                    } else {
                                        var20 = -var16;
                                    }

                                    int var21;
                                    if (var19 != 2 && var19 != 3) {
                                        var21 = var18;
                                    } else {
                                        var21 = -var18;
                                    }

                                    if (var21 < var20) {
                                        var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16 + var15.offsetX, var17, var18 + var15.offsetY, var15.uid);
                                    } else if (var15.linkedEntity != null) {
                                        var15.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16, var17, var18, var15.uid);
                                    }
                                }
                            }

                            if (var13) {
                                TileDecor var22 = renderingTile.decor;
                                if (var22 != null) {
                                    var22.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var22.fineX * renderCameraX, var22.height - renderCameraZ, var22.fineY * renderCameraY, var22.uid);
                                }

                                PickablePile var23 = renderingTile.pickablePile;
                                if (var23 != null && var23.height == 0) {
                                    if (var23.middle != null) {
                                        var23.middle.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                    }

                                    if (var23.top != null) {
                                        var23.top.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                    }

                                    if (var23.bottom != null) {
                                        var23.bottom.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                    }
                                }
                            }

                            var16 = renderingTile.anInt366;
                            if (var16 != 0) {
                                if (var4 < renderSceneX && (var16 & 4) != 0) {
                                    var36 = var8[var4 + 1][var5];
                                    if (var36 != null && var36.aBoolean1151) {
                                        aNodeDeque1936.add(var36);
                                    }
                                }

                                if (var5 < renderSceneY && (var16 & 2) != 0) {
                                    var36 = var8[var4][var5 + 1];
                                    if (var36 != null && var36.aBoolean1151) {
                                        aNodeDeque1936.add(var36);
                                    }
                                }

                                if (var4 > renderSceneX && (var16 & 1) != 0) {
                                    var36 = var8[var4 - 1][var5];
                                    if (var36 != null && var36.aBoolean1151) {
                                        aNodeDeque1936.add(var36);
                                    }
                                }

                                if (var5 > renderSceneY && (var16 & 8) != 0) {
                                    var36 = var8[var4][var5 - 1];
                                    if (var36 != null && var36.aBoolean1151) {
                                        aNodeDeque1936.add(var36);
                                    }
                                }
                            }
                            break;
                        }

                        if (renderingTile.anInt791 != 0) {
                            var13 = true;

                            for (var14 = 0; var14 < renderingTile.anInt368; ++var14) {
                                if (renderingTile.markers[var14].anInt452 != renderTick && (renderingTile.anIntArray374[var14] & renderingTile.anInt791) == renderingTile.anInt563) {
                                    var13 = false;
                                    break;
                                }
                            }

                            if (var13) {
                                var10 = renderingTile.boundary;
                                if (!this.method1463(var7, var4, var5, var10.orientation)) {
                                    var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                }

                                renderingTile.anInt791 = 0;
                            }
                        }

                        if (!renderingTile.aBoolean562) {
                            break;
                        }

                        try {
                            int var33 = renderingTile.anInt368;
                            renderingTile.aBoolean562 = false;
                            var14 = 0;

                            label563:
                            for (var11 = 0; var11 < var33; ++var11) {
                                var12 = renderingTile.markers[var11];
                                if (var12.anInt452 != renderTick) {
                                    for (var24 = var12.sceneX; var24 <= var12.maxSceneX; ++var24) {
                                        for (var16 = var12.sceneY; var16 <= var12.maxSceneY; ++var16) {
                                            var36 = var8[var24][var16];
                                            if (var36.aBoolean665) {
                                                renderingTile.aBoolean562 = true;
                                                continue label563;
                                            }

                                            if (var36.anInt791 != 0) {
                                                var18 = 0;
                                                if (var24 > var12.sceneX) {
                                                    ++var18;
                                                }

                                                if (var24 < var12.maxSceneX) {
                                                    var18 += 4;
                                                }

                                                if (var16 > var12.sceneY) {
                                                    var18 += 8;
                                                }

                                                if (var16 < var12.maxSceneY) {
                                                    var18 += 2;
                                                }

                                                if ((var18 & var36.anInt791) == renderingTile.anInt575) {
                                                    renderingTile.aBoolean562 = true;
                                                    continue label563;
                                                }
                                            }
                                        }
                                    }

                                    anEntityMarkerArray1940[var14++] = var12;
                                    var24 = renderSceneX - var12.sceneX;
                                    var16 = var12.maxSceneX - renderSceneX;
                                    if (var16 > var24) {
                                        var24 = var16;
                                    }

                                    var17 = renderSceneY - var12.sceneY;
                                    var18 = var12.maxSceneY - renderSceneY;
                                    if (var18 > var17) {
                                        var12.anInt453 = var24 + var18;
                                    } else {
                                        var12.anInt453 = var24 + var17;
                                    }
                                }
                            }

                            while (var14 > 0) {
                                var11 = -50;
                                var25 = -1;

                                for (var24 = 0; var24 < var14; ++var24) {
                                    EntityMarker var35 = anEntityMarkerArray1940[var24];
                                    if (var35.anInt452 != renderTick) {
                                        if (var35.anInt453 > var11) {
                                            var11 = var35.anInt453;
                                            var25 = var24;
                                        } else if (var11 == var35.anInt453) {
                                            var17 = var35.centerFineX - renderCameraX;
                                            var18 = var35.centerFineY - renderCameraY;
                                            var19 = anEntityMarkerArray1940[var25].centerFineX - renderCameraX;
                                            var20 = anEntityMarkerArray1940[var25].centerFineY - renderCameraY;
                                            if (var17 * var17 + var18 * var18 > var19 * var19 + var20 * var20) {
                                                var25 = var24;
                                            }
                                        }
                                    }
                                }

                                if (var25 == -1) {
                                    break;
                                }

                                EntityMarker var34 = anEntityMarkerArray1940[var25];
                                var34.anInt452 = renderTick;
                                if (!this.method1467(var7, var34.sceneX, var34.maxSceneX, var34.sceneY, var34.maxSceneY, var34.entity.height)) {
                                    var34.entity.method11(var34.orientation, pitchSin, pitchCos, yawSin, yawCos, var34.centerFineX - renderCameraX, var34.height - renderCameraZ, var34.centerFineY - renderCameraY, var34.uid);
                                }

                                for (var16 = var34.sceneX; var16 <= var34.maxSceneX; ++var16) {
                                    for (var17 = var34.sceneY; var17 <= var34.maxSceneY; ++var17) {
                                        Tile var26 = var8[var16][var17];
                                        if (var26.anInt791 != 0) {
                                            aNodeDeque1936.add(var26);
                                        } else if ((var16 != var4 || var17 != var5) && var26.aBoolean1151) {
                                            aNodeDeque1936.add(var26);
                                        }
                                    }
                                }
                            }

                            if (!renderingTile.aBoolean562) {
                                break;
                            }
                        } catch (Exception var28) {
                            renderingTile.aBoolean562 = false;
                            break;
                        }
                    }
                } while (!renderingTile.aBoolean1151);
            }

            if (var4 > renderSceneX || var4 <= renderAreaMinX) {
                break;
            }

            var9 = var8[var4 - 1][var5];
            while (var9 != null && var9.aBoolean1151) {
                do {
                    do {
                        while (true) {
                            Boundary var10;
                            EntityMarker var12;
                            boolean var13;
                            int var14;
                            int var19;
                            int var20;
                            Tile var36;
                            while (true) {
                                do {
                                    renderingTile = (Tile) aNodeDeque1936.popFirst();
                                    if (renderingTile == null) {

                                        return;
                                    }
                                } while (!renderingTile.aBoolean1151);

                                var4 = renderingTile.sceneX;
                                var5 = renderingTile.sceneY;
                                var6 = renderingTile.floorLevel;
                                var7 = renderingTile.anInt380;
                                var8 = this.tiles[var6];
                                if (!renderingTile.aBoolean665) {
                                    break;
                                }

                                if (var2) {
                                    if (var6 > 0) {
                                        var9 = this.tiles[var6 - 1][var4][var5];
                                        if (var9 != null && var9.aBoolean1151) {
                                            continue;
                                        }
                                    }

                                    if (var4 <= renderSceneX && var4 > renderAreaMinX) {
                                        var9 = var8[var4 - 1][var5];
                                        if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 1) == 0)) {
                                            continue;
                                        }
                                    }

                                    if (var4 >= renderSceneX && var4 < renderAreaMaxX - 1) {
                                        var9 = var8[var4 + 1][var5];
                                        if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 4) == 0)) {
                                            continue;
                                        }
                                    }

                                    if (var5 <= renderSceneY && var5 > renderAreaMinY) {
                                        var9 = var8[var4][var5 - 1];
                                        if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 8) == 0)) {
                                            continue;
                                        }
                                    }

                                    if (var5 >= renderSceneY && var5 < renderAreaMaxY - 1) {
                                        var9 = var8[var4][var5 + 1];
                                        if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 2) == 0)) {
                                            continue;
                                        }
                                    }
                                } else {
                                    var2 = true;
                                }

                                renderingTile.aBoolean665 = false;
                                if (renderingTile.aTile1150 != null) {
                                    var9 = renderingTile.aTile1150;
                                    if (var9.paint != null) {
                                        if (!this.method1464(0, var4, var5)) {
                                            this.method1462(var9.paint, 0, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                        }
                                    } else if (var9.model != null && !this.method1464(0, var4, var5)) {
                                        this.method1459(var9.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                    }

                                    var10 = var9.boundary;
                                    if (var10 != null) {
                                        var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                    }

                                    for (var11 = 0; var11 < var9.anInt368; ++var11) {
                                        var12 = var9.markers[var11];
                                        if (var12 != null) {
                                            var12.entity.method11(var12.orientation, pitchSin, pitchCos, yawSin, yawCos, var12.centerFineX - renderCameraX, var12.height - renderCameraZ, var12.centerFineY - renderCameraY, var12.uid);
                                        }
                                    }
                                }

                                var13 = false;
                                if (renderingTile.paint != null) {
                                    if (!this.method1464(var7, var4, var5)) {
                                        var13 = true;
                                        if (renderingTile.paint.anInt2001 != 12345678 || aBoolean1942 && var6 <= anInt1931) {
                                            this.method1462(renderingTile.paint, var7, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                        }
                                    }
                                } else if (renderingTile.model != null && !this.method1464(var7, var4, var5)) {
                                    var13 = true;
                                    this.method1459(renderingTile.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                }

                                var14 = 0;
                                var11 = 0;
                                Boundary var31 = renderingTile.boundary;
                                BoundaryDecor var15 = renderingTile.boundaryDecor;
                                if (var31 != null || var15 != null) {
                                    if (var4 == renderSceneX) {
                                        ++var14;
                                    } else if (renderSceneX < var4) {
                                        var14 += 2;
                                    }

                                    if (var5 == renderSceneY) {
                                        var14 += 3;
                                    } else if (renderSceneY > var5) {
                                        var14 += 6;
                                    }

                                    var11 = anIntArray1935[var14];
                                    renderingTile.anInt1149 = anIntArray1948[var14];
                                }

                                if (var31 != null) {
                                    if ((var31.orientation & anIntArray1937[var14]) != 0) {
                                        if (var31.orientation == 16) {
                                            renderingTile.anInt791 = 3;
                                            renderingTile.anInt563 = anIntArray1945[var14];
                                            renderingTile.anInt575 = 3 - renderingTile.anInt563;
                                        } else if (var31.orientation == 32) {
                                            renderingTile.anInt791 = 6;
                                            renderingTile.anInt563 = anIntArray1934[var14];
                                            renderingTile.anInt575 = 6 - renderingTile.anInt563;
                                        } else if (var31.orientation == 64) {
                                            renderingTile.anInt791 = 12;
                                            renderingTile.anInt563 = anIntArray1944[var14];
                                            renderingTile.anInt575 = 12 - renderingTile.anInt563;
                                        } else {
                                            renderingTile.anInt791 = 9;
                                            renderingTile.anInt563 = anIntArray1959[var14];
                                            renderingTile.anInt575 = 9 - renderingTile.anInt563;
                                        }
                                    } else {
                                        renderingTile.anInt791 = 0;
                                    }

                                    if ((var31.orientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.orientation)) {
                                        var31.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                    }

                                    if ((var31.linkedOrientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.linkedOrientation)) {
                                        var31.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                    }
                                }

                                if (var15 != null && !this.method1466(var7, var4, var5, var15.entity.height)) {
                                    if ((var15.renderConfig & var11) != 0) {
                                        var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var15.offsetX + (var15.fineX * renderCameraX), var15.height - renderCameraZ, var15.offsetY + (var15.fineY * renderCameraY), var15.uid);
                                    } else if (var15.renderConfig == 256) {
                                        var16 = var15.fineX * renderCameraX;
                                        var17 = var15.height - renderCameraZ;
                                        var18 = var15.fineY * renderCameraY;
                                        var19 = var15.orientation;
                                        if (var19 != 1 && var19 != 2) {
                                            var20 = var16;
                                        } else {
                                            var20 = -var16;
                                        }

                                        int var21;
                                        if (var19 != 2 && var19 != 3) {
                                            var21 = var18;
                                        } else {
                                            var21 = -var18;
                                        }

                                        if (var21 < var20) {
                                            var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16 + var15.offsetX, var17, var18 + var15.offsetY, var15.uid);
                                        } else if (var15.linkedEntity != null) {
                                            var15.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16, var17, var18, var15.uid);
                                        }
                                    }
                                }

                                if (var13) {
                                    TileDecor var22 = renderingTile.decor;
                                    if (var22 != null) {
                                        var22.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var22.fineX * renderCameraX, var22.height - renderCameraZ, var22.fineY * renderCameraY, var22.uid);
                                    }

                                    PickablePile var23 = renderingTile.pickablePile;
                                    if (var23 != null && var23.height == 0) {
                                        if (var23.middle != null) {
                                            var23.middle.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                        }

                                        if (var23.top != null) {
                                            var23.top.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY *  renderCameraY, var23.uid);
                                        }

                                        if (var23.bottom != null) {
                                            var23.bottom.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                        }
                                    }
                                }

                                var16 = renderingTile.anInt366;
                                if (var16 != 0) {
                                    if (var4 < renderSceneX && (var16 & 4) != 0) {
                                        var36 = var8[var4 + 1][var5];
                                        if (var36 != null && var36.aBoolean1151) {
                                            aNodeDeque1936.add(var36);
                                        }
                                    }

                                    if (var5 < renderSceneY && (var16 & 2) != 0) {
                                        var36 = var8[var4][var5 + 1];
                                        if (var36 != null && var36.aBoolean1151) {
                                            aNodeDeque1936.add(var36);
                                        }
                                    }

                                    if (var4 > renderSceneX && (var16 & 1) != 0) {
                                        var36 = var8[var4 - 1][var5];
                                        if (var36 != null && var36.aBoolean1151) {
                                            aNodeDeque1936.add(var36);
                                        }
                                    }

                                    if (var5 > renderSceneY && (var16 & 8) != 0) {
                                        var36 = var8[var4][var5 - 1];
                                        if (var36 != null && var36.aBoolean1151) {
                                            aNodeDeque1936.add(var36);
                                        }
                                    }
                                }
                                break;
                            }

                            if (renderingTile.anInt791 != 0) {
                                var13 = true;

                                for (var14 = 0; var14 < renderingTile.anInt368; ++var14) {
                                    if (renderingTile.markers[var14].anInt452 != renderTick && (renderingTile.anIntArray374[var14] & renderingTile.anInt791) == renderingTile.anInt563) {
                                        var13 = false;
                                        break;
                                    }
                                }

                                if (var13) {
                                    var10 = renderingTile.boundary;
                                    if (!this.method1463(var7, var4, var5, var10.orientation)) {
                                        var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                    }

                                    renderingTile.anInt791 = 0;
                                }
                            }

                            if (!renderingTile.aBoolean562) {
                                break;
                            }

                            try {
                                int var33 = renderingTile.anInt368;
                                renderingTile.aBoolean562 = false;
                                var14 = 0;

                                label563:
                                for (var11 = 0; var11 < var33; ++var11) {
                                    var12 = renderingTile.markers[var11];
                                    if (var12.anInt452 != renderTick) {
                                        for (var24 = var12.sceneX; var24 <= var12.maxSceneX; ++var24) {
                                            for (var16 = var12.sceneY; var16 <= var12.maxSceneY; ++var16) {
                                                var36 = var8[var24][var16];
                                                if (var36.aBoolean665) {
                                                    renderingTile.aBoolean562 = true;
                                                    continue label563;
                                                }

                                                if (var36.anInt791 != 0) {
                                                    var18 = 0;
                                                    if (var24 > var12.sceneX) {
                                                        ++var18;
                                                    }

                                                    if (var24 < var12.maxSceneX) {
                                                        var18 += 4;
                                                    }

                                                    if (var16 > var12.sceneY) {
                                                        var18 += 8;
                                                    }

                                                    if (var16 < var12.maxSceneY) {
                                                        var18 += 2;
                                                    }

                                                    if ((var18 & var36.anInt791) == renderingTile.anInt575) {
                                                        renderingTile.aBoolean562 = true;
                                                        continue label563;
                                                    }
                                                }
                                            }
                                        }

                                        anEntityMarkerArray1940[var14++] = var12;
                                        var24 = renderSceneX - var12.sceneX;
                                        var16 = var12.maxSceneX - renderSceneX;
                                        if (var16 > var24) {
                                            var24 = var16;
                                        }

                                        var17 = renderSceneY - var12.sceneY;
                                        var18 = var12.maxSceneY - renderSceneY;
                                        if (var18 > var17) {
                                            var12.anInt453 = var24 + var18;
                                        } else {
                                            var12.anInt453 = var24 + var17;
                                        }
                                    }
                                }

                                while (var14 > 0) {
                                    var11 = -50;
                                    var25 = -1;

                                    for (var24 = 0; var24 < var14; ++var24) {
                                        EntityMarker var35 = anEntityMarkerArray1940[var24];
                                        if (var35.anInt452 != renderTick) {
                                            if (var35.anInt453 > var11) {
                                                var11 = var35.anInt453;
                                                var25 = var24;
                                            } else if (var11 == var35.anInt453) {
                                                var17 = var35.centerFineX - renderCameraX;
                                                var18 = var35.centerFineY - renderCameraY;
                                                var19 = anEntityMarkerArray1940[var25].centerFineX - renderCameraX;
                                                var20 = anEntityMarkerArray1940[var25].centerFineY - renderCameraY;
                                                if (var17 * var17 + var18 * var18 > var19 * var19 + var20 * var20) {
                                                    var25 = var24;
                                                }
                                            }
                                        }
                                    }

                                    if (var25 == -1) {
                                        break;
                                    }

                                    EntityMarker var34 = anEntityMarkerArray1940[var25];
                                    var34.anInt452 = renderTick;
                                    if (!this.method1467(var7, var34.sceneX, var34.maxSceneX, var34.sceneY, var34.maxSceneY, var34.entity.height)) {
                                        var34.entity.method11(var34.orientation, pitchSin, pitchCos, yawSin, yawCos, var34.centerFineX - renderCameraX, var34.height - renderCameraZ, var34.centerFineY - renderCameraY, var34.uid);
                                    }

                                    for (var16 = var34.sceneX; var16 <= var34.maxSceneX; ++var16) {
                                        for (var17 = var34.sceneY; var17 <= var34.maxSceneY; ++var17) {
                                            Tile var26 = var8[var16][var17];
                                            if (var26.anInt791 != 0) {
                                                aNodeDeque1936.add(var26);
                                            } else if ((var16 != var4 || var17 != var5) && var26.aBoolean1151) {
                                                aNodeDeque1936.add(var26);
                                            }
                                        }
                                    }
                                }

                                if (!renderingTile.aBoolean562) {
                                    break;
                                }
                            } catch (Exception var28) {
                                renderingTile.aBoolean562 = false;
                                break;
                            }
                        }
                    } while (!renderingTile.aBoolean1151);
                } while (renderingTile.anInt791 != 0);

                if (var4 > renderSceneX || var4 <= renderAreaMinX) {
                    break;
                }

                var9 = var8[var4 - 1][var5];
            }

            if (var4 < renderSceneX || var4 >= renderAreaMaxX - 1) {
                break;
            }

            var9 = var8[var4 + 1][var5];
            while (var9 != null && var9.aBoolean1151) {
                do {
                    do {
                        do {
                            while (true) {
                                Boundary var10;
                                EntityMarker var12;
                                boolean var13;
                                int var14;
                                int var19;
                                int var20;
                                Tile var36;
                                while (true) {
                                    do {
                                        renderingTile = (Tile) aNodeDeque1936.popFirst();
                                        if (renderingTile == null) {

                                            return;
                                        }
                                    } while (!renderingTile.aBoolean1151);

                                    var4 = renderingTile.sceneX;
                                    var5 = renderingTile.sceneY;
                                    var6 = renderingTile.floorLevel;
                                    var7 = renderingTile.anInt380;
                                    var8 = this.tiles[var6];
                                    if (!renderingTile.aBoolean665) {
                                        break;
                                    }

                                    if (var2) {
                                        if (var6 > 0) {
                                            var9 = this.tiles[var6 - 1][var4][var5];
                                            if (var9 != null && var9.aBoolean1151) {
                                                continue;
                                            }
                                        }

                                        if (var4 <= renderSceneX && var4 > renderAreaMinX) {
                                            var9 = var8[var4 - 1][var5];
                                            if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 1) == 0)) {
                                                continue;
                                            }
                                        }

                                        if (var4 >= renderSceneX && var4 < renderAreaMaxX - 1) {
                                            var9 = var8[var4 + 1][var5];
                                            if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 4) == 0)) {
                                                continue;
                                            }
                                        }

                                        if (var5 <= renderSceneY && var5 > renderAreaMinY) {
                                            var9 = var8[var4][var5 - 1];
                                            if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 8) == 0)) {
                                                continue;
                                            }
                                        }

                                        if (var5 >= renderSceneY && var5 < renderAreaMaxY - 1) {
                                            var9 = var8[var4][var5 + 1];
                                            if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 2) == 0)) {
                                                continue;
                                            }
                                        }
                                    } else {
                                        var2 = true;
                                    }

                                    renderingTile.aBoolean665 = false;
                                    if (renderingTile.aTile1150 != null) {
                                        var9 = renderingTile.aTile1150;
                                        if (var9.paint != null) {
                                            if (!this.method1464(0, var4, var5)) {
                                                this.method1462(var9.paint, 0, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                            }
                                        } else if (var9.model != null && !this.method1464(0, var4, var5)) {
                                            this.method1459(var9.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                        }

                                        var10 = var9.boundary;
                                        if (var10 != null) {
                                            var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                        }

                                        for (var11 = 0; var11 < var9.anInt368; ++var11) {
                                            var12 = var9.markers[var11];
                                            if (var12 != null) {
                                                var12.entity.method11(var12.orientation, pitchSin, pitchCos, yawSin, yawCos, var12.centerFineX - renderCameraX, var12.height - renderCameraZ, var12.centerFineY - renderCameraY, var12.uid);
                                            }
                                        }
                                    }

                                    var13 = false;
                                    if (renderingTile.paint != null) {
                                        if (!this.method1464(var7, var4, var5)) {
                                            var13 = true;
                                            if (renderingTile.paint.anInt2001 != 12345678 || aBoolean1942 && var6 <= anInt1931) {
                                                this.method1462(renderingTile.paint, var7, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                            }
                                        }
                                    } else if (renderingTile.model != null && !this.method1464(var7, var4, var5)) {
                                        var13 = true;
                                        this.method1459(renderingTile.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                    }

                                    var14 = 0;
                                    var11 = 0;
                                    Boundary var31 = renderingTile.boundary;
                                    BoundaryDecor var15 = renderingTile.boundaryDecor;
                                    if (var31 != null || var15 != null) {
                                        if (var4 == renderSceneX) {
                                            ++var14;
                                        } else if (renderSceneX < var4) {
                                            var14 += 2;
                                        }

                                        if (var5 == renderSceneY) {
                                            var14 += 3;
                                        } else if (renderSceneY > var5) {
                                            var14 += 6;
                                        }

                                        var11 = anIntArray1935[var14];
                                        renderingTile.anInt1149 = anIntArray1948[var14];
                                    }

                                    if (var31 != null) {
                                        if ((var31.orientation & anIntArray1937[var14]) != 0) {
                                            if (var31.orientation == 16) {
                                                renderingTile.anInt791 = 3;
                                                renderingTile.anInt563 = anIntArray1945[var14];
                                                renderingTile.anInt575 = 3 - renderingTile.anInt563;
                                            } else if (var31.orientation == 32) {
                                                renderingTile.anInt791 = 6;
                                                renderingTile.anInt563 = anIntArray1934[var14];
                                                renderingTile.anInt575 = 6 - renderingTile.anInt563;
                                            } else if (var31.orientation == 64) {
                                                renderingTile.anInt791 = 12;
                                                renderingTile.anInt563 = anIntArray1944[var14];
                                                renderingTile.anInt575 = 12 - renderingTile.anInt563;
                                            } else {
                                                renderingTile.anInt791 = 9;
                                                renderingTile.anInt563 = anIntArray1959[var14];
                                                renderingTile.anInt575 = 9 - renderingTile.anInt563;
                                            }
                                        } else {
                                            renderingTile.anInt791 = 0;
                                        }

                                        if ((var31.orientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.orientation)) {
                                            var31.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                        }

                                        if ((var31.linkedOrientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.linkedOrientation)) {
                                            var31.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                        }
                                    }

                                    if (var15 != null && !this.method1466(var7, var4, var5, var15.entity.height)) {
                                        if ((var15.renderConfig & var11) != 0) {
                                            var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var15.offsetX + (var15.fineX * renderCameraX), var15.height - renderCameraZ, var15.offsetY + (var15.fineY * renderCameraY), var15.uid);
                                        } else if (var15.renderConfig == 256) {
                                            var16 = var15.fineX * renderCameraX;
                                            var17 = var15.height - renderCameraZ;
                                            var18 = var15.fineY * renderCameraY;
                                            var19 = var15.orientation;
                                            if (var19 != 1 && var19 != 2) {
                                                var20 = var16;
                                            } else {
                                                var20 = -var16;
                                            }

                                            int var21;
                                            if (var19 != 2 && var19 != 3) {
                                                var21 = var18;
                                            } else {
                                                var21 = -var18;
                                            }

                                            if (var21 < var20) {
                                                var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16 + var15.offsetX, var17, var18 + var15.offsetY, var15.uid);
                                            } else if (var15.linkedEntity != null) {
                                                var15.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16, var17, var18, var15.uid);
                                            }
                                        }
                                    }

                                    if (var13) {
                                        TileDecor var22 = renderingTile.decor;
                                        if (var22 != null) {
                                            var22.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var22.fineX * renderCameraX, var22.height - renderCameraZ, var22.fineY * renderCameraY, var22.uid);
                                        }

                                        PickablePile var23 = renderingTile.pickablePile;
                                        if (var23 != null && var23.height == 0) {
                                            if (var23.middle != null) {
                                                var23.middle.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                            }

                                            if (var23.top != null) {
                                                var23.top.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                            }

                                            if (var23.bottom != null) {
                                                var23.bottom.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                            }
                                        }
                                    }

                                    var16 = renderingTile.anInt366;
                                    if (var16 != 0) {
                                        if (var4 < renderSceneX && (var16 & 4) != 0) {
                                            var36 = var8[var4 + 1][var5];
                                            if (var36 != null && var36.aBoolean1151) {
                                                aNodeDeque1936.add(var36);
                                            }
                                        }

                                        if (var5 < renderSceneY && (var16 & 2) != 0) {
                                            var36 = var8[var4][var5 + 1];
                                            if (var36 != null && var36.aBoolean1151) {
                                                aNodeDeque1936.add(var36);
                                            }
                                        }

                                        if (var4 > renderSceneX && (var16 & 1) != 0) {
                                            var36 = var8[var4 - 1][var5];
                                            if (var36 != null && var36.aBoolean1151) {
                                                aNodeDeque1936.add(var36);
                                            }
                                        }

                                        if (var5 > renderSceneY && (var16 & 8) != 0) {
                                            var36 = var8[var4][var5 - 1];
                                            if (var36 != null && var36.aBoolean1151) {
                                                aNodeDeque1936.add(var36);
                                            }
                                        }
                                    }
                                    break;
                                }

                                if (renderingTile.anInt791 != 0) {
                                    var13 = true;

                                    for (var14 = 0; var14 < renderingTile.anInt368; ++var14) {
                                        if (renderingTile.markers[var14].anInt452 != renderTick && (renderingTile.anIntArray374[var14] & renderingTile.anInt791) == renderingTile.anInt563) {
                                            var13 = false;
                                            break;
                                        }
                                    }

                                    if (var13) {
                                        var10 = renderingTile.boundary;
                                        if (!this.method1463(var7, var4, var5, var10.orientation)) {
                                            var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                        }

                                        renderingTile.anInt791 = 0;
                                    }
                                }

                                if (!renderingTile.aBoolean562) {
                                    break;
                                }

                                try {
                                    int var33 = renderingTile.anInt368;
                                    renderingTile.aBoolean562 = false;
                                    var14 = 0;

                                    label563:
                                    for (var11 = 0; var11 < var33; ++var11) {
                                        var12 = renderingTile.markers[var11];
                                        if (var12.anInt452 != renderTick) {
                                            for (var24 = var12.sceneX; var24 <= var12.maxSceneX; ++var24) {
                                                for (var16 = var12.sceneY; var16 <= var12.maxSceneY; ++var16) {
                                                    var36 = var8[var24][var16];
                                                    if (var36.aBoolean665) {
                                                        renderingTile.aBoolean562 = true;
                                                        continue label563;
                                                    }

                                                    if (var36.anInt791 != 0) {
                                                        var18 = 0;
                                                        if (var24 > var12.sceneX) {
                                                            ++var18;
                                                        }

                                                        if (var24 < var12.maxSceneX) {
                                                            var18 += 4;
                                                        }

                                                        if (var16 > var12.sceneY) {
                                                            var18 += 8;
                                                        }

                                                        if (var16 < var12.maxSceneY) {
                                                            var18 += 2;
                                                        }

                                                        if ((var18 & var36.anInt791) == renderingTile.anInt575) {
                                                            renderingTile.aBoolean562 = true;
                                                            continue label563;
                                                        }
                                                    }
                                                }
                                            }

                                            anEntityMarkerArray1940[var14++] = var12;
                                            var24 = renderSceneX - var12.sceneX;
                                            var16 = var12.maxSceneX - renderSceneX;
                                            if (var16 > var24) {
                                                var24 = var16;
                                            }

                                            var17 = renderSceneY - var12.sceneY;
                                            var18 = var12.maxSceneY - renderSceneY;
                                            if (var18 > var17) {
                                                var12.anInt453 = var24 + var18;
                                            } else {
                                                var12.anInt453 = var24 + var17;
                                            }
                                        }
                                    }

                                    while (var14 > 0) {
                                        var11 = -50;
                                        var25 = -1;

                                        for (var24 = 0; var24 < var14; ++var24) {
                                            EntityMarker var35 = anEntityMarkerArray1940[var24];
                                            if (var35.anInt452 != renderTick) {
                                                if (var35.anInt453 > var11) {
                                                    var11 = var35.anInt453;
                                                    var25 = var24;
                                                } else if (var11 == var35.anInt453) {
                                                    var17 = var35.centerFineX - renderCameraX;
                                                    var18 = var35.centerFineY - renderCameraY;
                                                    var19 = anEntityMarkerArray1940[var25].centerFineX - renderCameraX;
                                                    var20 = anEntityMarkerArray1940[var25].centerFineY - renderCameraY;
                                                    if (var17 * var17 + var18 * var18 > var19 * var19 + var20 * var20) {
                                                        var25 = var24;
                                                    }
                                                }
                                            }
                                        }

                                        if (var25 == -1) {
                                            break;
                                        }

                                        EntityMarker var34 = anEntityMarkerArray1940[var25];
                                        var34.anInt452 = renderTick;
                                        if (!this.method1467(var7, var34.sceneX, var34.maxSceneX, var34.sceneY, var34.maxSceneY, var34.entity.height)) {
                                            var34.entity.method11(var34.orientation, pitchSin, pitchCos, yawSin, yawCos, var34.centerFineX - renderCameraX, var34.height - renderCameraZ, var34.centerFineY - renderCameraY, var34.uid);
                                        }

                                        for (var16 = var34.sceneX; var16 <= var34.maxSceneX; ++var16) {
                                            for (var17 = var34.sceneY; var17 <= var34.maxSceneY; ++var17) {
                                                Tile var26 = var8[var16][var17];
                                                if (var26.anInt791 != 0) {
                                                    aNodeDeque1936.add(var26);
                                                } else if ((var16 != var4 || var17 != var5) && var26.aBoolean1151) {
                                                    aNodeDeque1936.add(var26);
                                                }
                                            }
                                        }
                                    }

                                    if (!renderingTile.aBoolean562) {
                                        break;
                                    }
                                } catch (Exception var28) {
                                    renderingTile.aBoolean562 = false;
                                    break;
                                }
                            }
                        } while (!renderingTile.aBoolean1151);
                    } while (renderingTile.anInt791 != 0);

                    if (var4 > renderSceneX || var4 <= renderAreaMinX) {
                        break;
                    }

                    var9 = var8[var4 - 1][var5];
                } while (var9 != null && var9.aBoolean1151);

                if (var4 < renderSceneX || var4 >= renderAreaMaxX - 1) {
                    break;
                }

                var9 = var8[var4 + 1][var5];
            }

            if (var5 > renderSceneY || var5 <= renderAreaMinY) {
                break;
            }

            var9 = var8[var4][var5 - 1];
            while (var9 != null && var9.aBoolean1151) {
                do {
                    do {
                        do {
                            while (true) {
                                Boundary var10;
                                EntityMarker var12;
                                boolean var13;
                                int var14;
                                int var19;
                                int var20;
                                Tile var36;
                                while (true) {
                                    do {
                                        renderingTile = (Tile) aNodeDeque1936.popFirst();
                                        if (renderingTile == null) {

                                            return;
                                        }
                                    } while (!renderingTile.aBoolean1151);

                                    var4 = renderingTile.sceneX;
                                    var5 = renderingTile.sceneY;
                                    var6 = renderingTile.floorLevel;
                                    var7 = renderingTile.anInt380;
                                    var8 = this.tiles[var6];
                                    if (!renderingTile.aBoolean665) {
                                        break;
                                    }

                                    if (var2) {
                                        if (var6 > 0) {
                                            var9 = this.tiles[var6 - 1][var4][var5];
                                            if (var9 != null && var9.aBoolean1151) {
                                                continue;
                                            }
                                        }

                                        if (var4 <= renderSceneX && var4 > renderAreaMinX) {
                                            var9 = var8[var4 - 1][var5];
                                            if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 1) == 0)) {
                                                continue;
                                            }
                                        }

                                        if (var4 >= renderSceneX && var4 < renderAreaMaxX - 1) {
                                            var9 = var8[var4 + 1][var5];
                                            if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 4) == 0)) {
                                                continue;
                                            }
                                        }

                                        if (var5 <= renderSceneY && var5 > renderAreaMinY) {
                                            var9 = var8[var4][var5 - 1];
                                            if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 8) == 0)) {
                                                continue;
                                            }
                                        }

                                        if (var5 >= renderSceneY && var5 < renderAreaMaxY - 1) {
                                            var9 = var8[var4][var5 + 1];
                                            if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 2) == 0)) {
                                                continue;
                                            }
                                        }
                                    } else {
                                        var2 = true;
                                    }

                                    renderingTile.aBoolean665 = false;
                                    if (renderingTile.aTile1150 != null) {
                                        var9 = renderingTile.aTile1150;
                                        if (var9.paint != null) {
                                            if (!this.method1464(0, var4, var5)) {
                                                this.method1462(var9.paint, 0, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                            }
                                        } else if (var9.model != null && !this.method1464(0, var4, var5)) {
                                            this.method1459(var9.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                        }

                                        var10 = var9.boundary;
                                        if (var10 != null) {
                                            var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                        }

                                        for (var11 = 0; var11 < var9.anInt368; ++var11) {
                                            var12 = var9.markers[var11];
                                            if (var12 != null) {
                                                var12.entity.method11(var12.orientation, pitchSin, pitchCos, yawSin, yawCos, var12.centerFineX - renderCameraX, var12.height - renderCameraZ, var12.centerFineY - renderCameraY, var12.uid);
                                            }
                                        }
                                    }

                                    var13 = false;
                                    if (renderingTile.paint != null) {
                                        if (!this.method1464(var7, var4, var5)) {
                                            var13 = true;
                                            if (renderingTile.paint.anInt2001 != 12345678 || aBoolean1942 && var6 <= anInt1931) {
                                                this.method1462(renderingTile.paint, var7, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                            }
                                        }
                                    } else if (renderingTile.model != null && !this.method1464(var7, var4, var5)) {
                                        var13 = true;
                                        this.method1459(renderingTile.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                    }

                                    var14 = 0;
                                    var11 = 0;
                                    Boundary var31 = renderingTile.boundary;
                                    BoundaryDecor var15 = renderingTile.boundaryDecor;
                                    if (var31 != null || var15 != null) {
                                        if (var4 == renderSceneX) {
                                            ++var14;
                                        } else if (renderSceneX < var4) {
                                            var14 += 2;
                                        }

                                        if (var5 == renderSceneY) {
                                            var14 += 3;
                                        } else if (renderSceneY > var5) {
                                            var14 += 6;
                                        }

                                        var11 = anIntArray1935[var14];
                                        renderingTile.anInt1149 = anIntArray1948[var14];
                                    }

                                    if (var31 != null) {
                                        if ((var31.orientation & anIntArray1937[var14]) != 0) {
                                            if (var31.orientation == 16) {
                                                renderingTile.anInt791 = 3;
                                                renderingTile.anInt563 = anIntArray1945[var14];
                                                renderingTile.anInt575 = 3 - renderingTile.anInt563;
                                            } else if (var31.orientation == 32) {
                                                renderingTile.anInt791 = 6;
                                                renderingTile.anInt563 = anIntArray1934[var14];
                                                renderingTile.anInt575 = 6 - renderingTile.anInt563;
                                            } else if (var31.orientation == 64) {
                                                renderingTile.anInt791 = 12;
                                                renderingTile.anInt563 = anIntArray1944[var14];
                                                renderingTile.anInt575 = 12 - renderingTile.anInt563;
                                            } else {
                                                renderingTile.anInt791 = 9;
                                                renderingTile.anInt563 = anIntArray1959[var14];
                                                renderingTile.anInt575 = 9 - renderingTile.anInt563;
                                            }
                                        } else {
                                            renderingTile.anInt791 = 0;
                                        }

                                        if ((var31.orientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.orientation)) {
                                            var31.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                        }

                                        if ((var31.linkedOrientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.linkedOrientation)) {
                                            var31.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                        }
                                    }

                                    if (var15 != null && !this.method1466(var7, var4, var5, var15.entity.height)) {
                                        if ((var15.renderConfig & var11) != 0) {
                                            var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var15.offsetX + (var15.fineX * renderCameraX), var15.height - renderCameraZ, var15.offsetY + (var15.fineY * renderCameraY), var15.uid);
                                        } else if (var15.renderConfig == 256) {
                                            var16 = var15.fineX * renderCameraX;
                                            var17 = var15.height - renderCameraZ;
                                            var18 = var15.fineY * renderCameraY;
                                            var19 = var15.orientation;
                                            if (var19 != 1 && var19 != 2) {
                                                var20 = var16;
                                            } else {
                                                var20 = -var16;
                                            }

                                            int var21;
                                            if (var19 != 2 && var19 != 3) {
                                                var21 = var18;
                                            } else {
                                                var21 = -var18;
                                            }

                                            if (var21 < var20) {
                                                var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16 + var15.offsetX, var17, var18 + var15.offsetY, var15.uid);
                                            } else if (var15.linkedEntity != null) {
                                                var15.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16, var17, var18, var15.uid);
                                            }
                                        }
                                    }

                                    if (var13) {
                                        TileDecor var22 = renderingTile.decor;
                                        if (var22 != null) {
                                            var22.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var22.fineX * renderCameraX, var22.height - renderCameraZ, var22.fineY * renderCameraY, var22.uid);
                                        }

                                        PickablePile var23 = renderingTile.pickablePile;
                                        if (var23 != null && var23.height == 0) {
                                            if (var23.middle != null) {
                                                var23.middle.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                            }

                                            if (var23.top != null) {
                                                var23.top.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                            }

                                            if (var23.bottom != null) {
                                                var23.bottom.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                            }
                                        }
                                    }

                                    var16 = renderingTile.anInt366;
                                    if (var16 != 0) {
                                        if (var4 < renderSceneX && (var16 & 4) != 0) {
                                            var36 = var8[var4 + 1][var5];
                                            if (var36 != null && var36.aBoolean1151) {
                                                aNodeDeque1936.add(var36);
                                            }
                                        }

                                        if (var5 < renderSceneY && (var16 & 2) != 0) {
                                            var36 = var8[var4][var5 + 1];
                                            if (var36 != null && var36.aBoolean1151) {
                                                aNodeDeque1936.add(var36);
                                            }
                                        }

                                        if (var4 > renderSceneX && (var16 & 1) != 0) {
                                            var36 = var8[var4 - 1][var5];
                                            if (var36 != null && var36.aBoolean1151) {
                                                aNodeDeque1936.add(var36);
                                            }
                                        }

                                        if (var5 > renderSceneY && (var16 & 8) != 0) {
                                            var36 = var8[var4][var5 - 1];
                                            if (var36 != null && var36.aBoolean1151) {
                                                aNodeDeque1936.add(var36);
                                            }
                                        }
                                    }
                                    break;
                                }

                                if (renderingTile.anInt791 != 0) {
                                    var13 = true;

                                    for (var14 = 0; var14 < renderingTile.anInt368; ++var14) {
                                        if (renderingTile.markers[var14].anInt452 != renderTick && (renderingTile.anIntArray374[var14] & renderingTile.anInt791) == renderingTile.anInt563) {
                                            var13 = false;
                                            break;
                                        }
                                    }

                                    if (var13) {
                                        var10 = renderingTile.boundary;
                                        if (!this.method1463(var7, var4, var5, var10.orientation)) {
                                            var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                        }

                                        renderingTile.anInt791 = 0;
                                    }
                                }

                                if (!renderingTile.aBoolean562) {
                                    break;
                                }

                                try {
                                    int var33 = renderingTile.anInt368;
                                    renderingTile.aBoolean562 = false;
                                    var14 = 0;

                                    label563:
                                    for (var11 = 0; var11 < var33; ++var11) {
                                        var12 = renderingTile.markers[var11];
                                        if (var12.anInt452 != renderTick) {
                                            for (var24 = var12.sceneX; var24 <= var12.maxSceneX; ++var24) {
                                                for (var16 = var12.sceneY; var16 <= var12.maxSceneY; ++var16) {
                                                    var36 = var8[var24][var16];
                                                    if (var36.aBoolean665) {
                                                        renderingTile.aBoolean562 = true;
                                                        continue label563;
                                                    }

                                                    if (var36.anInt791 != 0) {
                                                        var18 = 0;
                                                        if (var24 > var12.sceneX) {
                                                            ++var18;
                                                        }

                                                        if (var24 < var12.maxSceneX) {
                                                            var18 += 4;
                                                        }

                                                        if (var16 > var12.sceneY) {
                                                            var18 += 8;
                                                        }

                                                        if (var16 < var12.maxSceneY) {
                                                            var18 += 2;
                                                        }

                                                        if ((var18 & var36.anInt791) == renderingTile.anInt575) {
                                                            renderingTile.aBoolean562 = true;
                                                            continue label563;
                                                        }
                                                    }
                                                }
                                            }

                                            anEntityMarkerArray1940[var14++] = var12;
                                            var24 = renderSceneX - var12.sceneX;
                                            var16 = var12.maxSceneX - renderSceneX;
                                            if (var16 > var24) {
                                                var24 = var16;
                                            }

                                            var17 = renderSceneY - var12.sceneY;
                                            var18 = var12.maxSceneY - renderSceneY;
                                            if (var18 > var17) {
                                                var12.anInt453 = var24 + var18;
                                            } else {
                                                var12.anInt453 = var24 + var17;
                                            }
                                        }
                                    }

                                    while (var14 > 0) {
                                        var11 = -50;
                                        var25 = -1;

                                        for (var24 = 0; var24 < var14; ++var24) {
                                            EntityMarker var35 = anEntityMarkerArray1940[var24];
                                            if (var35.anInt452 != renderTick) {
                                                if (var35.anInt453 > var11) {
                                                    var11 = var35.anInt453;
                                                    var25 = var24;
                                                } else if (var11 == var35.anInt453) {
                                                    var17 = var35.centerFineX - renderCameraX;
                                                    var18 = var35.centerFineY - renderCameraY;
                                                    var19 = anEntityMarkerArray1940[var25].centerFineX - renderCameraX;
                                                    var20 = anEntityMarkerArray1940[var25].centerFineY - renderCameraY;
                                                    if (var17 * var17 + var18 * var18 > var19 * var19 + var20 * var20) {
                                                        var25 = var24;
                                                    }
                                                }
                                            }
                                        }

                                        if (var25 == -1) {
                                            break;
                                        }

                                        EntityMarker var34 = anEntityMarkerArray1940[var25];
                                        var34.anInt452 = renderTick;
                                        if (!this.method1467(var7, var34.sceneX, var34.maxSceneX, var34.sceneY, var34.maxSceneY, var34.entity.height)) {
                                            var34.entity.method11(var34.orientation, pitchSin, pitchCos, yawSin, yawCos, var34.centerFineX - renderCameraX, var34.height - renderCameraZ, var34.centerFineY - renderCameraY, var34.uid);
                                        }

                                        for (var16 = var34.sceneX; var16 <= var34.maxSceneX; ++var16) {
                                            for (var17 = var34.sceneY; var17 <= var34.maxSceneY; ++var17) {
                                                Tile var26 = var8[var16][var17];
                                                if (var26.anInt791 != 0) {
                                                    aNodeDeque1936.add(var26);
                                                } else if ((var16 != var4 || var17 != var5) && var26.aBoolean1151) {
                                                    aNodeDeque1936.add(var26);
                                                }
                                            }
                                        }
                                    }

                                    if (!renderingTile.aBoolean562) {
                                        break;
                                    }
                                } catch (Exception var28) {
                                    renderingTile.aBoolean562 = false;
                                    break;
                                }
                            }
                        } while (!renderingTile.aBoolean1151);
                    } while (renderingTile.anInt791 != 0);

                    if (var4 > renderSceneX || var4 <= renderAreaMinX) {
                        break;
                    }

                    var9 = var8[var4 - 1][var5];
                } while (var9 != null && var9.aBoolean1151);

                if (var4 < renderSceneX || var4 >= renderAreaMaxX - 1) {
                    break;
                }

                var9 = var8[var4 + 1][var5];
                while (var9 != null && var9.aBoolean1151) {
                    do {
                        do {
                            while (true) {
                                Boundary var10;
                                EntityMarker var12;
                                boolean var13;
                                int var14;
                                int var19;
                                int var20;
                                Tile var36;
                                while (true) {
                                    do {
                                        renderingTile = (Tile) aNodeDeque1936.popFirst();
                                        if (renderingTile == null) {

                                            return;
                                        }
                                    } while (!renderingTile.aBoolean1151);

                                    var4 = renderingTile.sceneX;
                                    var5 = renderingTile.sceneY;
                                    var6 = renderingTile.floorLevel;
                                    var7 = renderingTile.anInt380;
                                    var8 = this.tiles[var6];
                                    if (!renderingTile.aBoolean665) {
                                        break;
                                    }

                                    if (var2) {
                                        if (var6 > 0) {
                                            var9 = this.tiles[var6 - 1][var4][var5];
                                            if (var9 != null && var9.aBoolean1151) {
                                                continue;
                                            }
                                        }

                                        if (var4 <= renderSceneX && var4 > renderAreaMinX) {
                                            var9 = var8[var4 - 1][var5];
                                            if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 1) == 0)) {
                                                continue;
                                            }
                                        }

                                        if (var4 >= renderSceneX && var4 < renderAreaMaxX - 1) {
                                            var9 = var8[var4 + 1][var5];
                                            if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 4) == 0)) {
                                                continue;
                                            }
                                        }

                                        if (var5 <= renderSceneY && var5 > renderAreaMinY) {
                                            var9 = var8[var4][var5 - 1];
                                            if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 8) == 0)) {
                                                continue;
                                            }
                                        }

                                        if (var5 >= renderSceneY && var5 < renderAreaMaxY - 1) {
                                            var9 = var8[var4][var5 + 1];
                                            if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 2) == 0)) {
                                                continue;
                                            }
                                        }
                                    } else {
                                        var2 = true;
                                    }

                                    renderingTile.aBoolean665 = false;
                                    if (renderingTile.aTile1150 != null) {
                                        var9 = renderingTile.aTile1150;
                                        if (var9.paint != null) {
                                            if (!this.method1464(0, var4, var5)) {
                                                this.method1462(var9.paint, 0, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                            }
                                        } else if (var9.model != null && !this.method1464(0, var4, var5)) {
                                            this.method1459(var9.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                        }

                                        var10 = var9.boundary;
                                        if (var10 != null) {
                                            var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                        }

                                        for (var11 = 0; var11 < var9.anInt368; ++var11) {
                                            var12 = var9.markers[var11];
                                            if (var12 != null) {
                                                var12.entity.method11(var12.orientation, pitchSin, pitchCos, yawSin, yawCos, var12.centerFineX - renderCameraX, var12.height - renderCameraZ, var12.centerFineY - renderCameraY, var12.uid);
                                            }
                                        }
                                    }

                                    var13 = false;
                                    if (renderingTile.paint != null) {
                                        if (!this.method1464(var7, var4, var5)) {
                                            var13 = true;
                                            if (renderingTile.paint.anInt2001 != 12345678 || aBoolean1942 && var6 <= anInt1931) {
                                                this.method1462(renderingTile.paint, var7, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                            }
                                        }
                                    } else if (renderingTile.model != null && !this.method1464(var7, var4, var5)) {
                                        var13 = true;
                                        this.method1459(renderingTile.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                    }

                                    var14 = 0;
                                    var11 = 0;
                                    Boundary var31 = renderingTile.boundary;
                                    BoundaryDecor var15 = renderingTile.boundaryDecor;
                                    if (var31 != null || var15 != null) {
                                        if (var4 == renderSceneX) {
                                            ++var14;
                                        } else if (renderSceneX < var4) {
                                            var14 += 2;
                                        }

                                        if (var5 == renderSceneY) {
                                            var14 += 3;
                                        } else if (renderSceneY > var5) {
                                            var14 += 6;
                                        }

                                        var11 = anIntArray1935[var14];
                                        renderingTile.anInt1149 = anIntArray1948[var14];
                                    }

                                    if (var31 != null) {
                                        if ((var31.orientation & anIntArray1937[var14]) != 0) {
                                            if (var31.orientation == 16) {
                                                renderingTile.anInt791 = 3;
                                                renderingTile.anInt563 = anIntArray1945[var14];
                                                renderingTile.anInt575 = 3 - renderingTile.anInt563;
                                            } else if (var31.orientation == 32) {
                                                renderingTile.anInt791 = 6;
                                                renderingTile.anInt563 = anIntArray1934[var14];
                                                renderingTile.anInt575 = 6 - renderingTile.anInt563;
                                            } else if (var31.orientation == 64) {
                                                renderingTile.anInt791 = 12;
                                                renderingTile.anInt563 = anIntArray1944[var14];
                                                renderingTile.anInt575 = 12 - renderingTile.anInt563;
                                            } else {
                                                renderingTile.anInt791 = 9;
                                                renderingTile.anInt563 = anIntArray1959[var14];
                                                renderingTile.anInt575 = 9 - renderingTile.anInt563;
                                            }
                                        } else {
                                            renderingTile.anInt791 = 0;
                                        }

                                        if ((var31.orientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.orientation)) {
                                            var31.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                        }

                                        if ((var31.linkedOrientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.linkedOrientation)) {
                                            var31.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                        }
                                    }

                                    if (var15 != null && !this.method1466(var7, var4, var5, var15.entity.height)) {
                                        if ((var15.renderConfig & var11) != 0) {
                                            var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var15.offsetX + (var15.fineX * renderCameraX), var15.height - renderCameraZ, var15.offsetY + (var15.fineY * renderCameraY), var15.uid);
                                        } else if (var15.renderConfig == 256) {
                                            var16 = var15.fineX * renderCameraX;
                                            var17 = var15.height - renderCameraZ;
                                            var18 = var15.fineY * renderCameraY;
                                            var19 = var15.orientation;
                                            if (var19 != 1 && var19 != 2) {
                                                var20 = var16;
                                            } else {
                                                var20 = -var16;
                                            }

                                            int var21;
                                            if (var19 != 2 && var19 != 3) {
                                                var21 = var18;
                                            } else {
                                                var21 = -var18;
                                            }

                                            if (var21 < var20) {
                                                var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16 + var15.offsetX, var17, var18 + var15.offsetY, var15.uid);
                                            } else if (var15.linkedEntity != null) {
                                                var15.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16, var17, var18, var15.uid);
                                            }
                                        }
                                    }

                                    if (var13) {
                                        TileDecor var22 = renderingTile.decor;
                                        if (var22 != null) {
                                            var22.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var22.fineX * renderCameraX, var22.height - renderCameraZ, var22.fineY * renderCameraY, var22.uid);
                                        }

                                        PickablePile var23 = renderingTile.pickablePile;
                                        if (var23 != null && var23.height == 0) {
                                            if (var23.middle != null) {
                                                var23.middle.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                            }

                                            if (var23.top != null) {
                                                var23.top.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                            }

                                            if (var23.bottom != null) {
                                                var23.bottom.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                            }
                                        }
                                    }

                                    var16 = renderingTile.anInt366;
                                    if (var16 != 0) {
                                        if (var4 < renderSceneX && (var16 & 4) != 0) {
                                            var36 = var8[var4 + 1][var5];
                                            if (var36 != null && var36.aBoolean1151) {
                                                aNodeDeque1936.add(var36);
                                            }
                                        }

                                        if (var5 < renderSceneY && (var16 & 2) != 0) {
                                            var36 = var8[var4][var5 + 1];
                                            if (var36 != null && var36.aBoolean1151) {
                                                aNodeDeque1936.add(var36);
                                            }
                                        }

                                        if (var4 > renderSceneX && (var16 & 1) != 0) {
                                            var36 = var8[var4 - 1][var5];
                                            if (var36 != null && var36.aBoolean1151) {
                                                aNodeDeque1936.add(var36);
                                            }
                                        }

                                        if (var5 > renderSceneY && (var16 & 8) != 0) {
                                            var36 = var8[var4][var5 - 1];
                                            if (var36 != null && var36.aBoolean1151) {
                                                aNodeDeque1936.add(var36);
                                            }
                                        }
                                    }
                                    break;
                                }

                                if (renderingTile.anInt791 != 0) {
                                    var13 = true;

                                    for (var14 = 0; var14 < renderingTile.anInt368; ++var14) {
                                        if (renderingTile.markers[var14].anInt452 != renderTick && (renderingTile.anIntArray374[var14] & renderingTile.anInt791) == renderingTile.anInt563) {
                                            var13 = false;
                                            break;
                                        }
                                    }

                                    if (var13) {
                                        var10 = renderingTile.boundary;
                                        if (!this.method1463(var7, var4, var5, var10.orientation)) {
                                            var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                        }

                                        renderingTile.anInt791 = 0;
                                    }
                                }

                                if (!renderingTile.aBoolean562) {
                                    break;
                                }

                                try {
                                    int var33 = renderingTile.anInt368;
                                    renderingTile.aBoolean562 = false;
                                    var14 = 0;

                                    label563:
                                    for (var11 = 0; var11 < var33; ++var11) {
                                        var12 = renderingTile.markers[var11];
                                        if (var12.anInt452 != renderTick) {
                                            for (var24 = var12.sceneX; var24 <= var12.maxSceneX; ++var24) {
                                                for (var16 = var12.sceneY; var16 <= var12.maxSceneY; ++var16) {
                                                    var36 = var8[var24][var16];
                                                    if (var36.aBoolean665) {
                                                        renderingTile.aBoolean562 = true;
                                                        continue label563;
                                                    }

                                                    if (var36.anInt791 != 0) {
                                                        var18 = 0;
                                                        if (var24 > var12.sceneX) {
                                                            ++var18;
                                                        }

                                                        if (var24 < var12.maxSceneX) {
                                                            var18 += 4;
                                                        }

                                                        if (var16 > var12.sceneY) {
                                                            var18 += 8;
                                                        }

                                                        if (var16 < var12.maxSceneY) {
                                                            var18 += 2;
                                                        }

                                                        if ((var18 & var36.anInt791) == renderingTile.anInt575) {
                                                            renderingTile.aBoolean562 = true;
                                                            continue label563;
                                                        }
                                                    }
                                                }
                                            }

                                            anEntityMarkerArray1940[var14++] = var12;
                                            var24 = renderSceneX - var12.sceneX;
                                            var16 = var12.maxSceneX - renderSceneX;
                                            if (var16 > var24) {
                                                var24 = var16;
                                            }

                                            var17 = renderSceneY - var12.sceneY;
                                            var18 = var12.maxSceneY - renderSceneY;
                                            if (var18 > var17) {
                                                var12.anInt453 = var24 + var18;
                                            } else {
                                                var12.anInt453 = var24 + var17;
                                            }
                                        }
                                    }

                                    while (var14 > 0) {
                                        var11 = -50;
                                        var25 = -1;

                                        for (var24 = 0; var24 < var14; ++var24) {
                                            EntityMarker var35 = anEntityMarkerArray1940[var24];
                                            if (var35.anInt452 != renderTick) {
                                                if (var35.anInt453 > var11) {
                                                    var11 = var35.anInt453;
                                                    var25 = var24;
                                                } else if (var11 == var35.anInt453) {
                                                    var17 = var35.centerFineX - renderCameraX;
                                                    var18 = var35.centerFineY - renderCameraY;
                                                    var19 = anEntityMarkerArray1940[var25].centerFineX - renderCameraX;
                                                    var20 = anEntityMarkerArray1940[var25].centerFineY - renderCameraY;
                                                    if (var17 * var17 + var18 * var18 > var19 * var19 + var20 * var20) {
                                                        var25 = var24;
                                                    }
                                                }
                                            }
                                        }

                                        if (var25 == -1) {
                                            break;
                                        }

                                        EntityMarker var34 = anEntityMarkerArray1940[var25];
                                        var34.anInt452 = renderTick;
                                        if (!this.method1467(var7, var34.sceneX, var34.maxSceneX, var34.sceneY, var34.maxSceneY, var34.entity.height)) {
                                            var34.entity.method11(var34.orientation, pitchSin, pitchCos, yawSin, yawCos, var34.centerFineX - renderCameraX, var34.height - renderCameraZ, var34.centerFineY - renderCameraY, var34.uid);
                                        }

                                        for (var16 = var34.sceneX; var16 <= var34.maxSceneX; ++var16) {
                                            for (var17 = var34.sceneY; var17 <= var34.maxSceneY; ++var17) {
                                                Tile var26 = var8[var16][var17];
                                                if (var26.anInt791 != 0) {
                                                    aNodeDeque1936.add(var26);
                                                } else if ((var16 != var4 || var17 != var5) && var26.aBoolean1151) {
                                                    aNodeDeque1936.add(var26);
                                                }
                                            }
                                        }
                                    }

                                    if (!renderingTile.aBoolean562) {
                                        break;
                                    }
                                } catch (Exception var28) {
                                    renderingTile.aBoolean562 = false;
                                    break;
                                }
                            }
                        } while (!renderingTile.aBoolean1151);
                    } while (renderingTile.anInt791 != 0);

                    if (var4 > renderSceneX || var4 <= renderAreaMinX) {
                        break;
                    }

                    var9 = var8[var4 - 1][var5];
                    while (var9 != null && var9.aBoolean1151) {
                        do {
                            while (true) {
                                Boundary var10;
                                EntityMarker var12;
                                boolean var13;
                                int var14;
                                int var19;
                                int var20;
                                Tile var36;
                                while (true) {
                                    do {
                                        renderingTile = (Tile) aNodeDeque1936.popFirst();
                                        if (renderingTile == null) {

                                            return;
                                        }
                                    } while (!renderingTile.aBoolean1151);

                                    var4 = renderingTile.sceneX;
                                    var5 = renderingTile.sceneY;
                                    var6 = renderingTile.floorLevel;
                                    var7 = renderingTile.anInt380;
                                    var8 = this.tiles[var6];
                                    if (!renderingTile.aBoolean665) {
                                        break;
                                    }

                                    if (var2) {
                                        if (var6 > 0) {
                                            var9 = this.tiles[var6 - 1][var4][var5];
                                            if (var9 != null && var9.aBoolean1151) {
                                                continue;
                                            }
                                        }

                                        if (var4 <= renderSceneX && var4 > renderAreaMinX) {
                                            var9 = var8[var4 - 1][var5];
                                            if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 1) == 0)) {
                                                continue;
                                            }
                                        }

                                        if (var4 >= renderSceneX && var4 < renderAreaMaxX - 1) {
                                            var9 = var8[var4 + 1][var5];
                                            if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 4) == 0)) {
                                                continue;
                                            }
                                        }

                                        if (var5 <= renderSceneY && var5 > renderAreaMinY) {
                                            var9 = var8[var4][var5 - 1];
                                            if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 8) == 0)) {
                                                continue;
                                            }
                                        }

                                        if (var5 >= renderSceneY && var5 < renderAreaMaxY - 1) {
                                            var9 = var8[var4][var5 + 1];
                                            if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 2) == 0)) {
                                                continue;
                                            }
                                        }
                                    } else {
                                        var2 = true;
                                    }

                                    renderingTile.aBoolean665 = false;
                                    if (renderingTile.aTile1150 != null) {
                                        var9 = renderingTile.aTile1150;
                                        if (var9.paint != null) {
                                            if (!this.method1464(0, var4, var5)) {
                                                this.method1462(var9.paint, 0, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                            }
                                        } else if (var9.model != null && !this.method1464(0, var4, var5)) {
                                            this.method1459(var9.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                        }

                                        var10 = var9.boundary;
                                        if (var10 != null) {
                                            var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                        }

                                        for (var11 = 0; var11 < var9.anInt368; ++var11) {
                                            var12 = var9.markers[var11];
                                            if (var12 != null) {
                                                var12.entity.method11(var12.orientation, pitchSin, pitchCos, yawSin, yawCos, var12.centerFineX - renderCameraX, var12.height - renderCameraZ, var12.centerFineY - renderCameraY, var12.uid);
                                            }
                                        }
                                    }

                                    var13 = false;
                                    if (renderingTile.paint != null) {
                                        if (!this.method1464(var7, var4, var5)) {
                                            var13 = true;
                                            if (renderingTile.paint.anInt2001 != 12345678 || aBoolean1942 && var6 <= anInt1931) {
                                                this.method1462(renderingTile.paint, var7, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                            }
                                        }
                                    } else if (renderingTile.model != null && !this.method1464(var7, var4, var5)) {
                                        var13 = true;
                                        this.method1459(renderingTile.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                    }

                                    var14 = 0;
                                    var11 = 0;
                                    Boundary var31 = renderingTile.boundary;
                                    BoundaryDecor var15 = renderingTile.boundaryDecor;
                                    if (var31 != null || var15 != null) {
                                        if (var4 == renderSceneX) {
                                            ++var14;
                                        } else if (renderSceneX < var4) {
                                            var14 += 2;
                                        }

                                        if (var5 == renderSceneY) {
                                            var14 += 3;
                                        } else if (renderSceneY > var5) {
                                            var14 += 6;
                                        }

                                        var11 = anIntArray1935[var14];
                                        renderingTile.anInt1149 = anIntArray1948[var14];
                                    }

                                    if (var31 != null) {
                                        if ((var31.orientation & anIntArray1937[var14]) != 0) {
                                            if (var31.orientation == 16) {
                                                renderingTile.anInt791 = 3;
                                                renderingTile.anInt563 = anIntArray1945[var14];
                                                renderingTile.anInt575 = 3 - renderingTile.anInt563;
                                            } else if (var31.orientation == 32) {
                                                renderingTile.anInt791 = 6;
                                                renderingTile.anInt563 = anIntArray1934[var14];
                                                renderingTile.anInt575 = 6 - renderingTile.anInt563;
                                            } else if (var31.orientation == 64) {
                                                renderingTile.anInt791 = 12;
                                                renderingTile.anInt563 = anIntArray1944[var14];
                                                renderingTile.anInt575 = 12 - renderingTile.anInt563;
                                            } else {
                                                renderingTile.anInt791 = 9;
                                                renderingTile.anInt563 = anIntArray1959[var14];
                                                renderingTile.anInt575 = 9 - renderingTile.anInt563;
                                            }
                                        } else {
                                            renderingTile.anInt791 = 0;
                                        }

                                        if ((var31.orientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.orientation)) {
                                            var31.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                        }

                                        if ((var31.linkedOrientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.linkedOrientation)) {
                                            var31.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                        }
                                    }

                                    if (var15 != null && !this.method1466(var7, var4, var5, var15.entity.height)) {
                                        if ((var15.renderConfig & var11) != 0) {
                                            var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var15.offsetX + (var15.fineX * renderCameraX), var15.height - renderCameraZ, var15.offsetY + (var15.fineY * renderCameraY), var15.uid);
                                        } else if (var15.renderConfig == 256) {
                                            var16 = var15.fineX * renderCameraX;
                                            var17 = var15.height - renderCameraZ;
                                            var18 = var15.fineY * renderCameraY;
                                            var19 = var15.orientation;
                                            if (var19 != 1 && var19 != 2) {
                                                var20 = var16;
                                            } else {
                                                var20 = -var16;
                                            }

                                            int var21;
                                            if (var19 != 2 && var19 != 3) {
                                                var21 = var18;
                                            } else {
                                                var21 = -var18;
                                            }

                                            if (var21 < var20) {
                                                var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16 + var15.offsetX, var17, var18 + var15.offsetY, var15.uid);
                                            } else if (var15.linkedEntity != null) {
                                                var15.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16, var17, var18, var15.uid);
                                            }
                                        }
                                    }

                                    if (var13) {
                                        TileDecor var22 = renderingTile.decor;
                                        if (var22 != null) {
                                            var22.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var22.fineX * renderCameraX, var22.height - renderCameraZ, var22.fineY * renderCameraY, var22.uid);
                                        }

                                        PickablePile var23 = renderingTile.pickablePile;
                                        if (var23 != null && var23.height == 0) {
                                            if (var23.middle != null) {
                                                var23.middle.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                            }

                                            if (var23.top != null) {
                                                var23.top.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                            }

                                            if (var23.bottom != null) {
                                                var23.bottom.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                            }
                                        }
                                    }

                                    var16 = renderingTile.anInt366;
                                    if (var16 != 0) {
                                        if (var4 < renderSceneX && (var16 & 4) != 0) {
                                            var36 = var8[var4 + 1][var5];
                                            if (var36 != null && var36.aBoolean1151) {
                                                aNodeDeque1936.add(var36);
                                            }
                                        }

                                        if (var5 < renderSceneY && (var16 & 2) != 0) {
                                            var36 = var8[var4][var5 + 1];
                                            if (var36 != null && var36.aBoolean1151) {
                                                aNodeDeque1936.add(var36);
                                            }
                                        }

                                        if (var4 > renderSceneX && (var16 & 1) != 0) {
                                            var36 = var8[var4 - 1][var5];
                                            if (var36 != null && var36.aBoolean1151) {
                                                aNodeDeque1936.add(var36);
                                            }
                                        }

                                        if (var5 > renderSceneY && (var16 & 8) != 0) {
                                            var36 = var8[var4][var5 - 1];
                                            if (var36 != null && var36.aBoolean1151) {
                                                aNodeDeque1936.add(var36);
                                            }
                                        }
                                    }
                                    break;
                                }

                                if (renderingTile.anInt791 != 0) {
                                    var13 = true;

                                    for (var14 = 0; var14 < renderingTile.anInt368; ++var14) {
                                        if (renderingTile.markers[var14].anInt452 != renderTick && (renderingTile.anIntArray374[var14] & renderingTile.anInt791) == renderingTile.anInt563) {
                                            var13 = false;
                                            break;
                                        }
                                    }

                                    if (var13) {
                                        var10 = renderingTile.boundary;
                                        if (!this.method1463(var7, var4, var5, var10.orientation)) {
                                            var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                        }

                                        renderingTile.anInt791 = 0;
                                    }
                                }

                                if (!renderingTile.aBoolean562) {
                                    break;
                                }

                                try {
                                    int var33 = renderingTile.anInt368;
                                    renderingTile.aBoolean562 = false;
                                    var14 = 0;

                                    label563:
                                    for (var11 = 0; var11 < var33; ++var11) {
                                        var12 = renderingTile.markers[var11];
                                        if (var12.anInt452 != renderTick) {
                                            for (var24 = var12.sceneX; var24 <= var12.maxSceneX; ++var24) {
                                                for (var16 = var12.sceneY; var16 <= var12.maxSceneY; ++var16) {
                                                    var36 = var8[var24][var16];
                                                    if (var36.aBoolean665) {
                                                        renderingTile.aBoolean562 = true;
                                                        continue label563;
                                                    }

                                                    if (var36.anInt791 != 0) {
                                                        var18 = 0;
                                                        if (var24 > var12.sceneX) {
                                                            ++var18;
                                                        }

                                                        if (var24 < var12.maxSceneX) {
                                                            var18 += 4;
                                                        }

                                                        if (var16 > var12.sceneY) {
                                                            var18 += 8;
                                                        }

                                                        if (var16 < var12.maxSceneY) {
                                                            var18 += 2;
                                                        }

                                                        if ((var18 & var36.anInt791) == renderingTile.anInt575) {
                                                            renderingTile.aBoolean562 = true;
                                                            continue label563;
                                                        }
                                                    }
                                                }
                                            }

                                            anEntityMarkerArray1940[var14++] = var12;
                                            var24 = renderSceneX - var12.sceneX;
                                            var16 = var12.maxSceneX - renderSceneX;
                                            if (var16 > var24) {
                                                var24 = var16;
                                            }

                                            var17 = renderSceneY - var12.sceneY;
                                            var18 = var12.maxSceneY - renderSceneY;
                                            if (var18 > var17) {
                                                var12.anInt453 = var24 + var18;
                                            } else {
                                                var12.anInt453 = var24 + var17;
                                            }
                                        }
                                    }

                                    while (var14 > 0) {
                                        var11 = -50;
                                        var25 = -1;

                                        for (var24 = 0; var24 < var14; ++var24) {
                                            EntityMarker var35 = anEntityMarkerArray1940[var24];
                                            if (var35.anInt452 != renderTick) {
                                                if (var35.anInt453 > var11) {
                                                    var11 = var35.anInt453;
                                                    var25 = var24;
                                                } else if (var11 == var35.anInt453) {
                                                    var17 = var35.centerFineX - renderCameraX;
                                                    var18 = var35.centerFineY - renderCameraY;
                                                    var19 = anEntityMarkerArray1940[var25].centerFineX - renderCameraX;
                                                    var20 = anEntityMarkerArray1940[var25].centerFineY - renderCameraY;
                                                    if (var17 * var17 + var18 * var18 > var19 * var19 + var20 * var20) {
                                                        var25 = var24;
                                                    }
                                                }
                                            }
                                        }

                                        if (var25 == -1) {
                                            break;
                                        }

                                        EntityMarker var34 = anEntityMarkerArray1940[var25];
                                        var34.anInt452 = renderTick;
                                        if (!this.method1467(var7, var34.sceneX, var34.maxSceneX, var34.sceneY, var34.maxSceneY, var34.entity.height)) {
                                            var34.entity.method11(var34.orientation, pitchSin, pitchCos, yawSin, yawCos, var34.centerFineX - renderCameraX, var34.height - renderCameraZ, var34.centerFineY - renderCameraY, var34.uid);
                                        }

                                        for (var16 = var34.sceneX; var16 <= var34.maxSceneX; ++var16) {
                                            for (var17 = var34.sceneY; var17 <= var34.maxSceneY; ++var17) {
                                                Tile var26 = var8[var16][var17];
                                                if (var26.anInt791 != 0) {
                                                    aNodeDeque1936.add(var26);
                                                } else if ((var16 != var4 || var17 != var5) && var26.aBoolean1151) {
                                                    aNodeDeque1936.add(var26);
                                                }
                                            }
                                        }
                                    }

                                    if (!renderingTile.aBoolean562) {
                                        break;
                                    }
                                } catch (Exception var28) {
                                    renderingTile.aBoolean562 = false;
                                    break;
                                }
                            }
                            while (!renderingTile.aBoolean1151) {
                                while (true) {
                                    Boundary var10;
                                    EntityMarker var12;
                                    boolean var13;
                                    int var14;
                                    int var19;
                                    int var20;
                                    Tile var36;
                                    while (true) {
                                        do {
                                            renderingTile = (Tile) aNodeDeque1936.popFirst();
                                            if (renderingTile == null) {

                                                return;
                                            }
                                        } while (!renderingTile.aBoolean1151);

                                        var4 = renderingTile.sceneX;
                                        var5 = renderingTile.sceneY;
                                        var6 = renderingTile.floorLevel;
                                        var7 = renderingTile.anInt380;
                                        var8 = this.tiles[var6];
                                        if (!renderingTile.aBoolean665) {
                                            break;
                                        }

                                        if (var2) {
                                            if (var6 > 0) {
                                                var9 = this.tiles[var6 - 1][var4][var5];
                                                if (var9 != null && var9.aBoolean1151) {
                                                    continue;
                                                }
                                            }

                                            if (var4 <= renderSceneX && var4 > renderAreaMinX) {
                                                var9 = var8[var4 - 1][var5];
                                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 1) == 0)) {
                                                    continue;
                                                }
                                            }

                                            if (var4 >= renderSceneX && var4 < renderAreaMaxX - 1) {
                                                var9 = var8[var4 + 1][var5];
                                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 4) == 0)) {
                                                    continue;
                                                }
                                            }

                                            if (var5 <= renderSceneY && var5 > renderAreaMinY) {
                                                var9 = var8[var4][var5 - 1];
                                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 8) == 0)) {
                                                    continue;
                                                }
                                            }

                                            if (var5 >= renderSceneY && var5 < renderAreaMaxY - 1) {
                                                var9 = var8[var4][var5 + 1];
                                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 2) == 0)) {
                                                    continue;
                                                }
                                            }
                                        } else {
                                            var2 = true;
                                        }

                                        renderingTile.aBoolean665 = false;
                                        if (renderingTile.aTile1150 != null) {
                                            var9 = renderingTile.aTile1150;
                                            if (var9.paint != null) {
                                                if (!this.method1464(0, var4, var5)) {
                                                    this.method1462(var9.paint, 0, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                                }
                                            } else if (var9.model != null && !this.method1464(0, var4, var5)) {
                                                this.method1459(var9.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                            }

                                            var10 = var9.boundary;
                                            if (var10 != null) {
                                                var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                            }

                                            for (var11 = 0; var11 < var9.anInt368; ++var11) {
                                                var12 = var9.markers[var11];
                                                if (var12 != null) {
                                                    var12.entity.method11(var12.orientation, pitchSin, pitchCos, yawSin, yawCos, var12.centerFineX - renderCameraX, var12.height - renderCameraZ, var12.centerFineY - renderCameraY, var12.uid);
                                                }
                                            }
                                        }

                                        var13 = false;
                                        if (renderingTile.paint != null) {
                                            if (!this.method1464(var7, var4, var5)) {
                                                var13 = true;
                                                if (renderingTile.paint.anInt2001 != 12345678 || aBoolean1942 && var6 <= anInt1931) {
                                                    this.method1462(renderingTile.paint, var7, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                                }
                                            }
                                        } else if (renderingTile.model != null && !this.method1464(var7, var4, var5)) {
                                            var13 = true;
                                            this.method1459(renderingTile.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                        }

                                        var14 = 0;
                                        var11 = 0;
                                        Boundary var31 = renderingTile.boundary;
                                        BoundaryDecor var15 = renderingTile.boundaryDecor;
                                        if (var31 != null || var15 != null) {
                                            if (var4 == renderSceneX) {
                                                ++var14;
                                            } else if (renderSceneX < var4) {
                                                var14 += 2;
                                            }

                                            if (var5 == renderSceneY) {
                                                var14 += 3;
                                            } else if (renderSceneY > var5) {
                                                var14 += 6;
                                            }

                                            var11 = anIntArray1935[var14];
                                            renderingTile.anInt1149 = anIntArray1948[var14];
                                        }

                                        if (var31 != null) {
                                            if ((var31.orientation & anIntArray1937[var14]) != 0) {
                                                if (var31.orientation == 16) {
                                                    renderingTile.anInt791 = 3;
                                                    renderingTile.anInt563 = anIntArray1945[var14];
                                                    renderingTile.anInt575 = 3 - renderingTile.anInt563;
                                                } else if (var31.orientation == 32) {
                                                    renderingTile.anInt791 = 6;
                                                    renderingTile.anInt563 = anIntArray1934[var14];
                                                    renderingTile.anInt575 = 6 - renderingTile.anInt563;
                                                } else if (var31.orientation == 64) {
                                                    renderingTile.anInt791 = 12;
                                                    renderingTile.anInt563 = anIntArray1944[var14];
                                                    renderingTile.anInt575 = 12 - renderingTile.anInt563;
                                                } else {
                                                    renderingTile.anInt791 = 9;
                                                    renderingTile.anInt563 = anIntArray1959[var14];
                                                    renderingTile.anInt575 = 9 - renderingTile.anInt563;
                                                }
                                            } else {
                                                renderingTile.anInt791 = 0;
                                            }

                                            if ((var31.orientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.orientation)) {
                                                var31.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                            }

                                            if ((var31.linkedOrientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.linkedOrientation)) {
                                                var31.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                            }
                                        }

                                        if (var15 != null && !this.method1466(var7, var4, var5, var15.entity.height)) {
                                            if ((var15.renderConfig & var11) != 0) {
                                                var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var15.offsetX + (var15.fineX * renderCameraX), var15.height - renderCameraZ, var15.offsetY + (var15.fineY * renderCameraY), var15.uid);
                                            } else if (var15.renderConfig == 256) {
                                                var16 = var15.fineX * renderCameraX;
                                                var17 = var15.height - renderCameraZ;
                                                var18 = var15.fineY * renderCameraY;
                                                var19 = var15.orientation;
                                                if (var19 != 1 && var19 != 2) {
                                                    var20 = var16;
                                                } else {
                                                    var20 = -var16;
                                                }

                                                int var21;
                                                if (var19 != 2 && var19 != 3) {
                                                    var21 = var18;
                                                } else {
                                                    var21 = -var18;
                                                }

                                                if (var21 < var20) {
                                                    var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16 + var15.offsetX, var17, var18 + var15.offsetY, var15.uid);
                                                } else if (var15.linkedEntity != null) {
                                                    var15.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16, var17, var18, var15.uid);
                                                }
                                            }
                                        }

                                        if (var13) {
                                            TileDecor var22 = renderingTile.decor;
                                            if (var22 != null) {
                                                var22.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var22.fineX * renderCameraX, var22.height - renderCameraZ, var22.fineY * renderCameraY, var22.uid);
                                            }

                                            PickablePile var23 = renderingTile.pickablePile;
                                            if (var23 != null && var23.height == 0) {
                                                if (var23.middle != null) {
                                                    var23.middle.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                                }

                                                if (var23.top != null) {
                                                    var23.top.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                                }

                                                if (var23.bottom != null) {
                                                    var23.bottom.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                                }
                                            }
                                        }

                                        var16 = renderingTile.anInt366;
                                        if (var16 != 0) {
                                            if (var4 < renderSceneX && (var16 & 4) != 0) {
                                                var36 = var8[var4 + 1][var5];
                                                if (var36 != null && var36.aBoolean1151) {
                                                    aNodeDeque1936.add(var36);
                                                }
                                            }

                                            if (var5 < renderSceneY && (var16 & 2) != 0) {
                                                var36 = var8[var4][var5 + 1];
                                                if (var36 != null && var36.aBoolean1151) {
                                                    aNodeDeque1936.add(var36);
                                                }
                                            }

                                            if (var4 > renderSceneX && (var16 & 1) != 0) {
                                                var36 = var8[var4 - 1][var5];
                                                if (var36 != null && var36.aBoolean1151) {
                                                    aNodeDeque1936.add(var36);
                                                }
                                            }

                                            if (var5 > renderSceneY && (var16 & 8) != 0) {
                                                var36 = var8[var4][var5 - 1];
                                                if (var36 != null && var36.aBoolean1151) {
                                                    aNodeDeque1936.add(var36);
                                                }
                                            }
                                        }
                                        break;
                                    }

                                    if (renderingTile.anInt791 != 0) {
                                        var13 = true;

                                        for (var14 = 0; var14 < renderingTile.anInt368; ++var14) {
                                            if (renderingTile.markers[var14].anInt452 != renderTick && (renderingTile.anIntArray374[var14] & renderingTile.anInt791) == renderingTile.anInt563) {
                                                var13 = false;
                                                break;
                                            }
                                        }

                                        if (var13) {
                                            var10 = renderingTile.boundary;
                                            if (!this.method1463(var7, var4, var5, var10.orientation)) {
                                                var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                            }

                                            renderingTile.anInt791 = 0;
                                        }
                                    }

                                    if (!renderingTile.aBoolean562) {
                                        break;
                                    }

                                    try {
                                        int var33 = renderingTile.anInt368;
                                        renderingTile.aBoolean562 = false;
                                        var14 = 0;

                                        label563:
                                        for (var11 = 0; var11 < var33; ++var11) {
                                            var12 = renderingTile.markers[var11];
                                            if (var12.anInt452 != renderTick) {
                                                for (var24 = var12.sceneX; var24 <= var12.maxSceneX; ++var24) {
                                                    for (var16 = var12.sceneY; var16 <= var12.maxSceneY; ++var16) {
                                                        var36 = var8[var24][var16];
                                                        if (var36.aBoolean665) {
                                                            renderingTile.aBoolean562 = true;
                                                            continue label563;
                                                        }

                                                        if (var36.anInt791 != 0) {
                                                            var18 = 0;
                                                            if (var24 > var12.sceneX) {
                                                                ++var18;
                                                            }

                                                            if (var24 < var12.maxSceneX) {
                                                                var18 += 4;
                                                            }

                                                            if (var16 > var12.sceneY) {
                                                                var18 += 8;
                                                            }

                                                            if (var16 < var12.maxSceneY) {
                                                                var18 += 2;
                                                            }

                                                            if ((var18 & var36.anInt791) == renderingTile.anInt575) {
                                                                renderingTile.aBoolean562 = true;
                                                                continue label563;
                                                            }
                                                        }
                                                    }
                                                }

                                                anEntityMarkerArray1940[var14++] = var12;
                                                var24 = renderSceneX - var12.sceneX;
                                                var16 = var12.maxSceneX - renderSceneX;
                                                if (var16 > var24) {
                                                    var24 = var16;
                                                }

                                                var17 = renderSceneY - var12.sceneY;
                                                var18 = var12.maxSceneY - renderSceneY;
                                                if (var18 > var17) {
                                                    var12.anInt453 = var24 + var18;
                                                } else {
                                                    var12.anInt453 = var24 + var17;
                                                }
                                            }
                                        }

                                        while (var14 > 0) {
                                            var11 = -50;
                                            var25 = -1;

                                            for (var24 = 0; var24 < var14; ++var24) {
                                                EntityMarker var35 = anEntityMarkerArray1940[var24];
                                                if (var35.anInt452 != renderTick) {
                                                    if (var35.anInt453 > var11) {
                                                        var11 = var35.anInt453;
                                                        var25 = var24;
                                                    } else if (var11 == var35.anInt453) {
                                                        var17 = var35.centerFineX - renderCameraX;
                                                        var18 = var35.centerFineY - renderCameraY;
                                                        var19 = anEntityMarkerArray1940[var25].centerFineX - renderCameraX;
                                                        var20 = anEntityMarkerArray1940[var25].centerFineY - renderCameraY;
                                                        if (var17 * var17 + var18 * var18 > var19 * var19 + var20 * var20) {
                                                            var25 = var24;
                                                        }
                                                    }
                                                }
                                            }

                                            if (var25 == -1) {
                                                break;
                                            }

                                            EntityMarker var34 = anEntityMarkerArray1940[var25];
                                            var34.anInt452 = renderTick;
                                            if (!this.method1467(var7, var34.sceneX, var34.maxSceneX, var34.sceneY, var34.maxSceneY, var34.entity.height)) {
                                                var34.entity.method11(var34.orientation, pitchSin, pitchCos, yawSin, yawCos, var34.centerFineX - renderCameraX, var34.height - renderCameraZ, var34.centerFineY - renderCameraY, var34.uid);
                                            }

                                            for (var16 = var34.sceneX; var16 <= var34.maxSceneX; ++var16) {
                                                for (var17 = var34.sceneY; var17 <= var34.maxSceneY; ++var17) {
                                                    Tile var26 = var8[var16][var17];
                                                    if (var26.anInt791 != 0) {
                                                        aNodeDeque1936.add(var26);
                                                    } else if ((var16 != var4 || var17 != var5) && var26.aBoolean1151) {
                                                        aNodeDeque1936.add(var26);
                                                    }
                                                }
                                            }
                                        }

                                        if (!renderingTile.aBoolean562) {
                                            break;
                                        }
                                    } catch (Exception var28) {
                                        renderingTile.aBoolean562 = false;
                                        break;
                                    }
                                }
                            }
                        } while (renderingTile.anInt791 != 0);

                        if (var4 > renderSceneX || var4 <= renderAreaMinX) {
                            break;
                        }

                        var9 = var8[var4 - 1][var5];
                    }

                    if (var4 < renderSceneX || var4 >= renderAreaMaxX - 1) {
                        break;
                    }

                    var9 = var8[var4 + 1][var5];
                }

                if (var5 > renderSceneY || var5 <= renderAreaMinY) {
                    break;
                }

                var9 = var8[var4][var5 - 1];
            }

            if (var5 < renderSceneY || var5 >= renderAreaMaxY - 1) {
                break;
            }

            var9 = var8[var4][var5 + 1];
            while (var9 != null && var9.aBoolean1151) {
                do {
                    do {
                        do {
                            do {
                                while (true) {
                                    Boundary var10;
                                    EntityMarker var12;
                                    boolean var13;
                                    int var14;
                                    int var19;
                                    int var20;
                                    Tile var36;
                                    while (true) {
                                        do {
                                            renderingTile = (Tile) aNodeDeque1936.popFirst();
                                            if (renderingTile == null) {

                                                return;
                                            }
                                        } while (!renderingTile.aBoolean1151);

                                        var4 = renderingTile.sceneX;
                                        var5 = renderingTile.sceneY;
                                        var6 = renderingTile.floorLevel;
                                        var7 = renderingTile.anInt380;
                                        var8 = this.tiles[var6];
                                        if (!renderingTile.aBoolean665) {
                                            break;
                                        }

                                        if (var2) {
                                            if (var6 > 0) {
                                                var9 = this.tiles[var6 - 1][var4][var5];
                                                if (var9 != null && var9.aBoolean1151) {
                                                    continue;
                                                }
                                            }

                                            if (var4 <= renderSceneX && var4 > renderAreaMinX) {
                                                var9 = var8[var4 - 1][var5];
                                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 1) == 0)) {
                                                    continue;
                                                }
                                            }

                                            if (var4 >= renderSceneX && var4 < renderAreaMaxX - 1) {
                                                var9 = var8[var4 + 1][var5];
                                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 4) == 0)) {
                                                    continue;
                                                }
                                            }

                                            if (var5 <= renderSceneY && var5 > renderAreaMinY) {
                                                var9 = var8[var4][var5 - 1];
                                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 8) == 0)) {
                                                    continue;
                                                }
                                            }

                                            if (var5 >= renderSceneY && var5 < renderAreaMaxY - 1) {
                                                var9 = var8[var4][var5 + 1];
                                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 2) == 0)) {
                                                    continue;
                                                }
                                            }
                                        } else {
                                            var2 = true;
                                        }

                                        renderingTile.aBoolean665 = false;
                                        if (renderingTile.aTile1150 != null) {
                                            var9 = renderingTile.aTile1150;
                                            if (var9.paint != null) {
                                                if (!this.method1464(0, var4, var5)) {
                                                    this.method1462(var9.paint, 0, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                                }
                                            } else if (var9.model != null && !this.method1464(0, var4, var5)) {
                                                this.method1459(var9.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                            }

                                            var10 = var9.boundary;
                                            if (var10 != null) {
                                                var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                            }

                                            for (var11 = 0; var11 < var9.anInt368; ++var11) {
                                                var12 = var9.markers[var11];
                                                if (var12 != null) {
                                                    var12.entity.method11(var12.orientation, pitchSin, pitchCos, yawSin, yawCos, var12.centerFineX - renderCameraX, var12.height - renderCameraZ, var12.centerFineY - renderCameraY, var12.uid);
                                                }
                                            }
                                        }

                                        var13 = false;
                                        if (renderingTile.paint != null) {
                                            if (!this.method1464(var7, var4, var5)) {
                                                var13 = true;
                                                if (renderingTile.paint.anInt2001 != 12345678 || aBoolean1942 && var6 <= anInt1931) {
                                                    this.method1462(renderingTile.paint, var7, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                                }
                                            }
                                        } else if (renderingTile.model != null && !this.method1464(var7, var4, var5)) {
                                            var13 = true;
                                            this.method1459(renderingTile.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                        }

                                        var14 = 0;
                                        var11 = 0;
                                        Boundary var31 = renderingTile.boundary;
                                        BoundaryDecor var15 = renderingTile.boundaryDecor;
                                        if (var31 != null || var15 != null) {
                                            if (var4 == renderSceneX) {
                                                ++var14;
                                            } else if (renderSceneX < var4) {
                                                var14 += 2;
                                            }

                                            if (var5 == renderSceneY) {
                                                var14 += 3;
                                            } else if (renderSceneY > var5) {
                                                var14 += 6;
                                            }

                                            var11 = anIntArray1935[var14];
                                            renderingTile.anInt1149 = anIntArray1948[var14];
                                        }

                                        if (var31 != null) {
                                            if ((var31.orientation & anIntArray1937[var14]) != 0) {
                                                if (var31.orientation == 16) {
                                                    renderingTile.anInt791 = 3;
                                                    renderingTile.anInt563 = anIntArray1945[var14];
                                                    renderingTile.anInt575 = 3 - renderingTile.anInt563;
                                                } else if (var31.orientation == 32) {
                                                    renderingTile.anInt791 = 6;
                                                    renderingTile.anInt563 = anIntArray1934[var14];
                                                    renderingTile.anInt575 = 6 - renderingTile.anInt563;
                                                } else if (var31.orientation == 64) {
                                                    renderingTile.anInt791 = 12;
                                                    renderingTile.anInt563 = anIntArray1944[var14];
                                                    renderingTile.anInt575 = 12 - renderingTile.anInt563;
                                                } else {
                                                    renderingTile.anInt791 = 9;
                                                    renderingTile.anInt563 = anIntArray1959[var14];
                                                    renderingTile.anInt575 = 9 - renderingTile.anInt563;
                                                }
                                            } else {
                                                renderingTile.anInt791 = 0;
                                            }

                                            if ((var31.orientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.orientation)) {
                                                var31.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                            }

                                            if ((var31.linkedOrientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.linkedOrientation)) {
                                                var31.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                            }
                                        }

                                        if (var15 != null && !this.method1466(var7, var4, var5, var15.entity.height)) {
                                            if ((var15.renderConfig & var11) != 0) {
                                                var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var15.offsetX + (var15.fineX * renderCameraX), var15.height - renderCameraZ, var15.offsetY + (var15.fineY * renderCameraY), var15.uid);
                                            } else if (var15.renderConfig == 256) {
                                                var16 = var15.fineX * renderCameraX;
                                                var17 = var15.height - renderCameraZ;
                                                var18 = var15.fineY * renderCameraY;
                                                var19 = var15.orientation;
                                                if (var19 != 1 && var19 != 2) {
                                                    var20 = var16;
                                                } else {
                                                    var20 = -var16;
                                                }

                                                int var21;
                                                if (var19 != 2 && var19 != 3) {
                                                    var21 = var18;
                                                } else {
                                                    var21 = -var18;
                                                }

                                                if (var21 < var20) {
                                                    var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16 + var15.offsetX, var17, var18 + var15.offsetY, var15.uid);
                                                } else if (var15.linkedEntity != null) {
                                                    var15.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16, var17, var18, var15.uid);
                                                }
                                            }
                                        }

                                        if (var13) {
                                            TileDecor var22 = renderingTile.decor;
                                            if (var22 != null) {
                                                var22.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var22.fineX * renderCameraX, var22.height - renderCameraZ, var22.fineY * renderCameraY, var22.uid);
                                            }

                                            PickablePile var23 = renderingTile.pickablePile;
                                            if (var23 != null && var23.height == 0) {
                                                if (var23.middle != null) {
                                                    var23.middle.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                                }

                                                if (var23.top != null) {
                                                    var23.top.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                                }

                                                if (var23.bottom != null) {
                                                    var23.bottom.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                                }
                                            }
                                        }

                                        var16 = renderingTile.anInt366;
                                        if (var16 != 0) {
                                            if (var4 < renderSceneX && (var16 & 4) != 0) {
                                                var36 = var8[var4 + 1][var5];
                                                if (var36 != null && var36.aBoolean1151) {
                                                    aNodeDeque1936.add(var36);
                                                }
                                            }

                                            if (var5 < renderSceneY && (var16 & 2) != 0) {
                                                var36 = var8[var4][var5 + 1];
                                                if (var36 != null && var36.aBoolean1151) {
                                                    aNodeDeque1936.add(var36);
                                                }
                                            }

                                            if (var4 > renderSceneX && (var16 & 1) != 0) {
                                                var36 = var8[var4 - 1][var5];
                                                if (var36 != null && var36.aBoolean1151) {
                                                    aNodeDeque1936.add(var36);
                                                }
                                            }

                                            if (var5 > renderSceneY && (var16 & 8) != 0) {
                                                var36 = var8[var4][var5 - 1];
                                                if (var36 != null && var36.aBoolean1151) {
                                                    aNodeDeque1936.add(var36);
                                                }
                                            }
                                        }
                                        break;
                                    }

                                    if (renderingTile.anInt791 != 0) {
                                        var13 = true;

                                        for (var14 = 0; var14 < renderingTile.anInt368; ++var14) {
                                            if (renderingTile.markers[var14].anInt452 != renderTick && (renderingTile.anIntArray374[var14] & renderingTile.anInt791) == renderingTile.anInt563) {
                                                var13 = false;
                                                break;
                                            }
                                        }

                                        if (var13) {
                                            var10 = renderingTile.boundary;
                                            if (!this.method1463(var7, var4, var5, var10.orientation)) {
                                                var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                            }

                                            renderingTile.anInt791 = 0;
                                        }
                                    }

                                    if (!renderingTile.aBoolean562) {
                                        break;
                                    }

                                    try {
                                        int var33 = renderingTile.anInt368;
                                        renderingTile.aBoolean562 = false;
                                        var14 = 0;

                                        label563:
                                        for (var11 = 0; var11 < var33; ++var11) {
                                            var12 = renderingTile.markers[var11];
                                            if (var12.anInt452 != renderTick) {
                                                for (var24 = var12.sceneX; var24 <= var12.maxSceneX; ++var24) {
                                                    for (var16 = var12.sceneY; var16 <= var12.maxSceneY; ++var16) {
                                                        var36 = var8[var24][var16];
                                                        if (var36.aBoolean665) {
                                                            renderingTile.aBoolean562 = true;
                                                            continue label563;
                                                        }

                                                        if (var36.anInt791 != 0) {
                                                            var18 = 0;
                                                            if (var24 > var12.sceneX) {
                                                                ++var18;
                                                            }

                                                            if (var24 < var12.maxSceneX) {
                                                                var18 += 4;
                                                            }

                                                            if (var16 > var12.sceneY) {
                                                                var18 += 8;
                                                            }

                                                            if (var16 < var12.maxSceneY) {
                                                                var18 += 2;
                                                            }

                                                            if ((var18 & var36.anInt791) == renderingTile.anInt575) {
                                                                renderingTile.aBoolean562 = true;
                                                                continue label563;
                                                            }
                                                        }
                                                    }
                                                }

                                                anEntityMarkerArray1940[var14++] = var12;
                                                var24 = renderSceneX - var12.sceneX;
                                                var16 = var12.maxSceneX - renderSceneX;
                                                if (var16 > var24) {
                                                    var24 = var16;
                                                }

                                                var17 = renderSceneY - var12.sceneY;
                                                var18 = var12.maxSceneY - renderSceneY;
                                                if (var18 > var17) {
                                                    var12.anInt453 = var24 + var18;
                                                } else {
                                                    var12.anInt453 = var24 + var17;
                                                }
                                            }
                                        }

                                        while (var14 > 0) {
                                            var11 = -50;
                                            var25 = -1;

                                            for (var24 = 0; var24 < var14; ++var24) {
                                                EntityMarker var35 = anEntityMarkerArray1940[var24];
                                                if (var35.anInt452 != renderTick) {
                                                    if (var35.anInt453 > var11) {
                                                        var11 = var35.anInt453;
                                                        var25 = var24;
                                                    } else if (var11 == var35.anInt453) {
                                                        var17 = var35.centerFineX - renderCameraX;
                                                        var18 = var35.centerFineY - renderCameraY;
                                                        var19 = anEntityMarkerArray1940[var25].centerFineX - renderCameraX;
                                                        var20 = anEntityMarkerArray1940[var25].centerFineY - renderCameraY;
                                                        if (var17 * var17 + var18 * var18 > var19 * var19 + var20 * var20) {
                                                            var25 = var24;
                                                        }
                                                    }
                                                }
                                            }

                                            if (var25 == -1) {
                                                break;
                                            }

                                            EntityMarker var34 = anEntityMarkerArray1940[var25];
                                            var34.anInt452 = renderTick;
                                            if (!this.method1467(var7, var34.sceneX, var34.maxSceneX, var34.sceneY, var34.maxSceneY, var34.entity.height)) {
                                                var34.entity.method11(var34.orientation, pitchSin, pitchCos, yawSin, yawCos, var34.centerFineX - renderCameraX, var34.height - renderCameraZ, var34.centerFineY - renderCameraY, var34.uid);
                                            }

                                            for (var16 = var34.sceneX; var16 <= var34.maxSceneX; ++var16) {
                                                for (var17 = var34.sceneY; var17 <= var34.maxSceneY; ++var17) {
                                                    Tile var26 = var8[var16][var17];
                                                    if (var26.anInt791 != 0) {
                                                        aNodeDeque1936.add(var26);
                                                    } else if ((var16 != var4 || var17 != var5) && var26.aBoolean1151) {
                                                        aNodeDeque1936.add(var26);
                                                    }
                                                }
                                            }
                                        }

                                        if (!renderingTile.aBoolean562) {
                                            break;
                                        }
                                    } catch (Exception var28) {
                                        renderingTile.aBoolean562 = false;
                                        break;
                                    }
                                }
                            } while (!renderingTile.aBoolean1151);
                        } while (renderingTile.anInt791 != 0);

                        if (var4 > renderSceneX || var4 <= renderAreaMinX) {
                            break;
                        }

                        var9 = var8[var4 - 1][var5];
                    } while (var9 != null && var9.aBoolean1151);

                    if (var4 < renderSceneX || var4 >= renderAreaMaxX - 1) {
                        break;
                    }

                    var9 = var8[var4 + 1][var5];
                } while (var9 != null && var9.aBoolean1151);

                if (var5 > renderSceneY || var5 <= renderAreaMinY) {
                    break;
                }

                var9 = var8[var4][var5 - 1];
                while (var9 != null && var9.aBoolean1151) {
                    do {
                        do {
                            do {
                                while (true) {
                                    Boundary var10;
                                    EntityMarker var12;
                                    boolean var13;
                                    int var14;
                                    int var19;
                                    int var20;
                                    Tile var36;
                                    while (true) {
                                        do {
                                            renderingTile = (Tile) aNodeDeque1936.popFirst();
                                            if (renderingTile == null) {

                                                return;
                                            }
                                        } while (!renderingTile.aBoolean1151);

                                        var4 = renderingTile.sceneX;
                                        var5 = renderingTile.sceneY;
                                        var6 = renderingTile.floorLevel;
                                        var7 = renderingTile.anInt380;
                                        var8 = this.tiles[var6];
                                        if (!renderingTile.aBoolean665) {
                                            break;
                                        }

                                        if (var2) {
                                            if (var6 > 0) {
                                                var9 = this.tiles[var6 - 1][var4][var5];
                                                if (var9 != null && var9.aBoolean1151) {
                                                    continue;
                                                }
                                            }

                                            if (var4 <= renderSceneX && var4 > renderAreaMinX) {
                                                var9 = var8[var4 - 1][var5];
                                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 1) == 0)) {
                                                    continue;
                                                }
                                            }

                                            if (var4 >= renderSceneX && var4 < renderAreaMaxX - 1) {
                                                var9 = var8[var4 + 1][var5];
                                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 4) == 0)) {
                                                    continue;
                                                }
                                            }

                                            if (var5 <= renderSceneY && var5 > renderAreaMinY) {
                                                var9 = var8[var4][var5 - 1];
                                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 8) == 0)) {
                                                    continue;
                                                }
                                            }

                                            if (var5 >= renderSceneY && var5 < renderAreaMaxY - 1) {
                                                var9 = var8[var4][var5 + 1];
                                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 2) == 0)) {
                                                    continue;
                                                }
                                            }
                                        } else {
                                            var2 = true;
                                        }

                                        renderingTile.aBoolean665 = false;
                                        if (renderingTile.aTile1150 != null) {
                                            var9 = renderingTile.aTile1150;
                                            if (var9.paint != null) {
                                                if (!this.method1464(0, var4, var5)) {
                                                    this.method1462(var9.paint, 0, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                                }
                                            } else if (var9.model != null && !this.method1464(0, var4, var5)) {
                                                this.method1459(var9.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                            }

                                            var10 = var9.boundary;
                                            if (var10 != null) {
                                                var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                            }

                                            for (var11 = 0; var11 < var9.anInt368; ++var11) {
                                                var12 = var9.markers[var11];
                                                if (var12 != null) {
                                                    var12.entity.method11(var12.orientation, pitchSin, pitchCos, yawSin, yawCos, var12.centerFineX - renderCameraX, var12.height - renderCameraZ, var12.centerFineY - renderCameraY, var12.uid);
                                                }
                                            }
                                        }

                                        var13 = false;
                                        if (renderingTile.paint != null) {
                                            if (!this.method1464(var7, var4, var5)) {
                                                var13 = true;
                                                if (renderingTile.paint.anInt2001 != 12345678 || aBoolean1942 && var6 <= anInt1931) {
                                                    this.method1462(renderingTile.paint, var7, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                                }
                                            }
                                        } else if (renderingTile.model != null && !this.method1464(var7, var4, var5)) {
                                            var13 = true;
                                            this.method1459(renderingTile.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                        }

                                        var14 = 0;
                                        var11 = 0;
                                        Boundary var31 = renderingTile.boundary;
                                        BoundaryDecor var15 = renderingTile.boundaryDecor;
                                        if (var31 != null || var15 != null) {
                                            if (var4 == renderSceneX) {
                                                ++var14;
                                            } else if (renderSceneX < var4) {
                                                var14 += 2;
                                            }

                                            if (var5 == renderSceneY) {
                                                var14 += 3;
                                            } else if (renderSceneY > var5) {
                                                var14 += 6;
                                            }

                                            var11 = anIntArray1935[var14];
                                            renderingTile.anInt1149 = anIntArray1948[var14];
                                        }

                                        if (var31 != null) {
                                            if ((var31.orientation & anIntArray1937[var14]) != 0) {
                                                if (var31.orientation == 16) {
                                                    renderingTile.anInt791 = 3;
                                                    renderingTile.anInt563 = anIntArray1945[var14];
                                                    renderingTile.anInt575 = 3 - renderingTile.anInt563;
                                                } else if (var31.orientation == 32) {
                                                    renderingTile.anInt791 = 6;
                                                    renderingTile.anInt563 = anIntArray1934[var14];
                                                    renderingTile.anInt575 = 6 - renderingTile.anInt563;
                                                } else if (var31.orientation == 64) {
                                                    renderingTile.anInt791 = 12;
                                                    renderingTile.anInt563 = anIntArray1944[var14];
                                                    renderingTile.anInt575 = 12 - renderingTile.anInt563;
                                                } else {
                                                    renderingTile.anInt791 = 9;
                                                    renderingTile.anInt563 = anIntArray1959[var14];
                                                    renderingTile.anInt575 = 9 - renderingTile.anInt563;
                                                }
                                            } else {
                                                renderingTile.anInt791 = 0;
                                            }

                                            if ((var31.orientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.orientation)) {
                                                var31.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                            }

                                            if ((var31.linkedOrientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.linkedOrientation)) {
                                                var31.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                            }
                                        }

                                        if (var15 != null && !this.method1466(var7, var4, var5, var15.entity.height)) {
                                            if ((var15.renderConfig & var11) != 0) {
                                                var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var15.offsetX + (var15.fineX * renderCameraX), var15.height - renderCameraZ, var15.offsetY + (var15.fineY * renderCameraY), var15.uid);
                                            } else if (var15.renderConfig == 256) {
                                                var16 = var15.fineX * renderCameraX;
                                                var17 = var15.height - renderCameraZ;
                                                var18 = var15.fineY * renderCameraY;
                                                var19 = var15.orientation;
                                                if (var19 != 1 && var19 != 2) {
                                                    var20 = var16;
                                                } else {
                                                    var20 = -var16;
                                                }

                                                int var21;
                                                if (var19 != 2 && var19 != 3) {
                                                    var21 = var18;
                                                } else {
                                                    var21 = -var18;
                                                }

                                                if (var21 < var20) {
                                                    var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16 + var15.offsetX, var17, var18 + var15.offsetY, var15.uid);
                                                } else if (var15.linkedEntity != null) {
                                                    var15.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16, var17, var18, var15.uid);
                                                }
                                            }
                                        }

                                        if (var13) {
                                            TileDecor var22 = renderingTile.decor;
                                            if (var22 != null) {
                                                var22.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var22.fineX * renderCameraX, var22.height - renderCameraZ, var22.fineY * renderCameraY, var22.uid);
                                            }

                                            PickablePile var23 = renderingTile.pickablePile;
                                            if (var23 != null && var23.height == 0) {
                                                if (var23.middle != null) {
                                                    var23.middle.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                                }

                                                if (var23.top != null) {
                                                    var23.top.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                                }

                                                if (var23.bottom != null) {
                                                    var23.bottom.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                                }
                                            }
                                        }

                                        var16 = renderingTile.anInt366;
                                        if (var16 != 0) {
                                            if (var4 < renderSceneX && (var16 & 4) != 0) {
                                                var36 = var8[var4 + 1][var5];
                                                if (var36 != null && var36.aBoolean1151) {
                                                    aNodeDeque1936.add(var36);
                                                }
                                            }

                                            if (var5 < renderSceneY && (var16 & 2) != 0) {
                                                var36 = var8[var4][var5 + 1];
                                                if (var36 != null && var36.aBoolean1151) {
                                                    aNodeDeque1936.add(var36);
                                                }
                                            }

                                            if (var4 > renderSceneX && (var16 & 1) != 0) {
                                                var36 = var8[var4 - 1][var5];
                                                if (var36 != null && var36.aBoolean1151) {
                                                    aNodeDeque1936.add(var36);
                                                }
                                            }

                                            if (var5 > renderSceneY && (var16 & 8) != 0) {
                                                var36 = var8[var4][var5 - 1];
                                                if (var36 != null && var36.aBoolean1151) {
                                                    aNodeDeque1936.add(var36);
                                                }
                                            }
                                        }
                                        break;
                                    }

                                    if (renderingTile.anInt791 != 0) {
                                        var13 = true;

                                        for (var14 = 0; var14 < renderingTile.anInt368; ++var14) {
                                            if (renderingTile.markers[var14].anInt452 != renderTick && (renderingTile.anIntArray374[var14] & renderingTile.anInt791) == renderingTile.anInt563) {
                                                var13 = false;
                                                break;
                                            }
                                        }

                                        if (var13) {
                                            var10 = renderingTile.boundary;
                                            if (!this.method1463(var7, var4, var5, var10.orientation)) {
                                                var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                            }

                                            renderingTile.anInt791 = 0;
                                        }
                                    }

                                    if (!renderingTile.aBoolean562) {
                                        break;
                                    }

                                    try {
                                        int var33 = renderingTile.anInt368;
                                        renderingTile.aBoolean562 = false;
                                        var14 = 0;

                                        label563:
                                        for (var11 = 0; var11 < var33; ++var11) {
                                            var12 = renderingTile.markers[var11];
                                            if (var12.anInt452 != renderTick) {
                                                for (var24 = var12.sceneX; var24 <= var12.maxSceneX; ++var24) {
                                                    for (var16 = var12.sceneY; var16 <= var12.maxSceneY; ++var16) {
                                                        var36 = var8[var24][var16];
                                                        if (var36.aBoolean665) {
                                                            renderingTile.aBoolean562 = true;
                                                            continue label563;
                                                        }

                                                        if (var36.anInt791 != 0) {
                                                            var18 = 0;
                                                            if (var24 > var12.sceneX) {
                                                                ++var18;
                                                            }

                                                            if (var24 < var12.maxSceneX) {
                                                                var18 += 4;
                                                            }

                                                            if (var16 > var12.sceneY) {
                                                                var18 += 8;
                                                            }

                                                            if (var16 < var12.maxSceneY) {
                                                                var18 += 2;
                                                            }

                                                            if ((var18 & var36.anInt791) == renderingTile.anInt575) {
                                                                renderingTile.aBoolean562 = true;
                                                                continue label563;
                                                            }
                                                        }
                                                    }
                                                }

                                                anEntityMarkerArray1940[var14++] = var12;
                                                var24 = renderSceneX - var12.sceneX;
                                                var16 = var12.maxSceneX - renderSceneX;
                                                if (var16 > var24) {
                                                    var24 = var16;
                                                }

                                                var17 = renderSceneY - var12.sceneY;
                                                var18 = var12.maxSceneY - renderSceneY;
                                                if (var18 > var17) {
                                                    var12.anInt453 = var24 + var18;
                                                } else {
                                                    var12.anInt453 = var24 + var17;
                                                }
                                            }
                                        }

                                        while (var14 > 0) {
                                            var11 = -50;
                                            var25 = -1;

                                            for (var24 = 0; var24 < var14; ++var24) {
                                                EntityMarker var35 = anEntityMarkerArray1940[var24];
                                                if (var35.anInt452 != renderTick) {
                                                    if (var35.anInt453 > var11) {
                                                        var11 = var35.anInt453;
                                                        var25 = var24;
                                                    } else if (var11 == var35.anInt453) {
                                                        var17 = var35.centerFineX - renderCameraX;
                                                        var18 = var35.centerFineY - renderCameraY;
                                                        var19 = anEntityMarkerArray1940[var25].centerFineX - renderCameraX;
                                                        var20 = anEntityMarkerArray1940[var25].centerFineY - renderCameraY;
                                                        if (var17 * var17 + var18 * var18 > var19 * var19 + var20 * var20) {
                                                            var25 = var24;
                                                        }
                                                    }
                                                }
                                            }

                                            if (var25 == -1) {
                                                break;
                                            }

                                            EntityMarker var34 = anEntityMarkerArray1940[var25];
                                            var34.anInt452 = renderTick;
                                            if (!this.method1467(var7, var34.sceneX, var34.maxSceneX, var34.sceneY, var34.maxSceneY, var34.entity.height)) {
                                                var34.entity.method11(var34.orientation, pitchSin, pitchCos, yawSin, yawCos, var34.centerFineX - renderCameraX, var34.height - renderCameraZ, var34.centerFineY - renderCameraY, var34.uid);
                                            }

                                            for (var16 = var34.sceneX; var16 <= var34.maxSceneX; ++var16) {
                                                for (var17 = var34.sceneY; var17 <= var34.maxSceneY; ++var17) {
                                                    Tile var26 = var8[var16][var17];
                                                    if (var26.anInt791 != 0) {
                                                        aNodeDeque1936.add(var26);
                                                    } else if ((var16 != var4 || var17 != var5) && var26.aBoolean1151) {
                                                        aNodeDeque1936.add(var26);
                                                    }
                                                }
                                            }
                                        }

                                        if (!renderingTile.aBoolean562) {
                                            break;
                                        }
                                    } catch (Exception var28) {
                                        renderingTile.aBoolean562 = false;
                                        break;
                                    }
                                }
                            } while (!renderingTile.aBoolean1151);
                        } while (renderingTile.anInt791 != 0);

                        if (var4 > renderSceneX || var4 <= renderAreaMinX) {
                            break;
                        }

                        var9 = var8[var4 - 1][var5];
                    } while (var9 != null && var9.aBoolean1151);

                    if (var4 < renderSceneX || var4 >= renderAreaMaxX - 1) {
                        break;
                    }

                    var9 = var8[var4 + 1][var5];
                    while (var9 != null && var9.aBoolean1151) {
                        do {
                            do {
                                while (true) {
                                    Boundary var10;
                                    EntityMarker var12;
                                    boolean var13;
                                    int var14;
                                    int var19;
                                    int var20;
                                    Tile var36;
                                    while (true) {
                                        do {
                                            renderingTile = (Tile) aNodeDeque1936.popFirst();
                                            if (renderingTile == null) {

                                                return;
                                            }
                                        } while (!renderingTile.aBoolean1151);

                                        var4 = renderingTile.sceneX;
                                        var5 = renderingTile.sceneY;
                                        var6 = renderingTile.floorLevel;
                                        var7 = renderingTile.anInt380;
                                        var8 = this.tiles[var6];
                                        if (!renderingTile.aBoolean665) {
                                            break;
                                        }

                                        if (var2) {
                                            if (var6 > 0) {
                                                var9 = this.tiles[var6 - 1][var4][var5];
                                                if (var9 != null && var9.aBoolean1151) {
                                                    continue;
                                                }
                                            }

                                            if (var4 <= renderSceneX && var4 > renderAreaMinX) {
                                                var9 = var8[var4 - 1][var5];
                                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 1) == 0)) {
                                                    continue;
                                                }
                                            }

                                            if (var4 >= renderSceneX && var4 < renderAreaMaxX - 1) {
                                                var9 = var8[var4 + 1][var5];
                                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 4) == 0)) {
                                                    continue;
                                                }
                                            }

                                            if (var5 <= renderSceneY && var5 > renderAreaMinY) {
                                                var9 = var8[var4][var5 - 1];
                                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 8) == 0)) {
                                                    continue;
                                                }
                                            }

                                            if (var5 >= renderSceneY && var5 < renderAreaMaxY - 1) {
                                                var9 = var8[var4][var5 + 1];
                                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 2) == 0)) {
                                                    continue;
                                                }
                                            }
                                        } else {
                                            var2 = true;
                                        }

                                        renderingTile.aBoolean665 = false;
                                        if (renderingTile.aTile1150 != null) {
                                            var9 = renderingTile.aTile1150;
                                            if (var9.paint != null) {
                                                if (!this.method1464(0, var4, var5)) {
                                                    this.method1462(var9.paint, 0, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                                }
                                            } else if (var9.model != null && !this.method1464(0, var4, var5)) {
                                                this.method1459(var9.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                            }

                                            var10 = var9.boundary;
                                            if (var10 != null) {
                                                var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                            }

                                            for (var11 = 0; var11 < var9.anInt368; ++var11) {
                                                var12 = var9.markers[var11];
                                                if (var12 != null) {
                                                    var12.entity.method11(var12.orientation, pitchSin, pitchCos, yawSin, yawCos, var12.centerFineX - renderCameraX, var12.height - renderCameraZ, var12.centerFineY - renderCameraY, var12.uid);
                                                }
                                            }
                                        }

                                        var13 = false;
                                        if (renderingTile.paint != null) {
                                            if (!this.method1464(var7, var4, var5)) {
                                                var13 = true;
                                                if (renderingTile.paint.anInt2001 != 12345678 || aBoolean1942 && var6 <= anInt1931) {
                                                    this.method1462(renderingTile.paint, var7, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                                }
                                            }
                                        } else if (renderingTile.model != null && !this.method1464(var7, var4, var5)) {
                                            var13 = true;
                                            this.method1459(renderingTile.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                        }

                                        var14 = 0;
                                        var11 = 0;
                                        Boundary var31 = renderingTile.boundary;
                                        BoundaryDecor var15 = renderingTile.boundaryDecor;
                                        if (var31 != null || var15 != null) {
                                            if (var4 == renderSceneX) {
                                                ++var14;
                                            } else if (renderSceneX < var4) {
                                                var14 += 2;
                                            }

                                            if (var5 == renderSceneY) {
                                                var14 += 3;
                                            } else if (renderSceneY > var5) {
                                                var14 += 6;
                                            }

                                            var11 = anIntArray1935[var14];
                                            renderingTile.anInt1149 = anIntArray1948[var14];
                                        }

                                        if (var31 != null) {
                                            if ((var31.orientation & anIntArray1937[var14]) != 0) {
                                                if (var31.orientation == 16) {
                                                    renderingTile.anInt791 = 3;
                                                    renderingTile.anInt563 = anIntArray1945[var14];
                                                    renderingTile.anInt575 = 3 - renderingTile.anInt563;
                                                } else if (var31.orientation == 32) {
                                                    renderingTile.anInt791 = 6;
                                                    renderingTile.anInt563 = anIntArray1934[var14];
                                                    renderingTile.anInt575 = 6 - renderingTile.anInt563;
                                                } else if (var31.orientation == 64) {
                                                    renderingTile.anInt791 = 12;
                                                    renderingTile.anInt563 = anIntArray1944[var14];
                                                    renderingTile.anInt575 = 12 - renderingTile.anInt563;
                                                } else {
                                                    renderingTile.anInt791 = 9;
                                                    renderingTile.anInt563 = anIntArray1959[var14];
                                                    renderingTile.anInt575 = 9 - renderingTile.anInt563;
                                                }
                                            } else {
                                                renderingTile.anInt791 = 0;
                                            }

                                            if ((var31.orientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.orientation)) {
                                                var31.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                            }

                                            if ((var31.linkedOrientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.linkedOrientation)) {
                                                var31.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                            }
                                        }

                                        if (var15 != null && !this.method1466(var7, var4, var5, var15.entity.height)) {
                                            if ((var15.renderConfig & var11) != 0) {
                                                var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var15.offsetX + (var15.fineX * renderCameraX), var15.height - renderCameraZ, var15.offsetY + (var15.fineY * renderCameraY), var15.uid);
                                            } else if (var15.renderConfig == 256) {
                                                var16 = var15.fineX * renderCameraX;
                                                var17 = var15.height - renderCameraZ;
                                                var18 = var15.fineY * renderCameraY;
                                                var19 = var15.orientation;
                                                if (var19 != 1 && var19 != 2) {
                                                    var20 = var16;
                                                } else {
                                                    var20 = -var16;
                                                }

                                                int var21;
                                                if (var19 != 2 && var19 != 3) {
                                                    var21 = var18;
                                                } else {
                                                    var21 = -var18;
                                                }

                                                if (var21 < var20) {
                                                    var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16 + var15.offsetX, var17, var18 + var15.offsetY, var15.uid);
                                                } else if (var15.linkedEntity != null) {
                                                    var15.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16, var17, var18, var15.uid);
                                                }
                                            }
                                        }

                                        if (var13) {
                                            TileDecor var22 = renderingTile.decor;
                                            if (var22 != null) {
                                                var22.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var22.fineX * renderCameraX, var22.height - renderCameraZ, var22.fineY * renderCameraY, var22.uid);
                                            }

                                            PickablePile var23 = renderingTile.pickablePile;
                                            if (var23 != null && var23.height == 0) {
                                                if (var23.middle != null) {
                                                    var23.middle.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                                }

                                                if (var23.top != null) {
                                                    var23.top.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                                }

                                                if (var23.bottom != null) {
                                                    var23.bottom.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                                }
                                            }
                                        }

                                        var16 = renderingTile.anInt366;
                                        if (var16 != 0) {
                                            if (var4 < renderSceneX && (var16 & 4) != 0) {
                                                var36 = var8[var4 + 1][var5];
                                                if (var36 != null && var36.aBoolean1151) {
                                                    aNodeDeque1936.add(var36);
                                                }
                                            }

                                            if (var5 < renderSceneY && (var16 & 2) != 0) {
                                                var36 = var8[var4][var5 + 1];
                                                if (var36 != null && var36.aBoolean1151) {
                                                    aNodeDeque1936.add(var36);
                                                }
                                            }

                                            if (var4 > renderSceneX && (var16 & 1) != 0) {
                                                var36 = var8[var4 - 1][var5];
                                                if (var36 != null && var36.aBoolean1151) {
                                                    aNodeDeque1936.add(var36);
                                                }
                                            }

                                            if (var5 > renderSceneY && (var16 & 8) != 0) {
                                                var36 = var8[var4][var5 - 1];
                                                if (var36 != null && var36.aBoolean1151) {
                                                    aNodeDeque1936.add(var36);
                                                }
                                            }
                                        }
                                        break;
                                    }

                                    if (renderingTile.anInt791 != 0) {
                                        var13 = true;

                                        for (var14 = 0; var14 < renderingTile.anInt368; ++var14) {
                                            if (renderingTile.markers[var14].anInt452 != renderTick && (renderingTile.anIntArray374[var14] & renderingTile.anInt791) == renderingTile.anInt563) {
                                                var13 = false;
                                                break;
                                            }
                                        }

                                        if (var13) {
                                            var10 = renderingTile.boundary;
                                            if (!this.method1463(var7, var4, var5, var10.orientation)) {
                                                var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                            }

                                            renderingTile.anInt791 = 0;
                                        }
                                    }

                                    if (!renderingTile.aBoolean562) {
                                        break;
                                    }

                                    try {
                                        int var33 = renderingTile.anInt368;
                                        renderingTile.aBoolean562 = false;
                                        var14 = 0;

                                        label563:
                                        for (var11 = 0; var11 < var33; ++var11) {
                                            var12 = renderingTile.markers[var11];
                                            if (var12.anInt452 != renderTick) {
                                                for (var24 = var12.sceneX; var24 <= var12.maxSceneX; ++var24) {
                                                    for (var16 = var12.sceneY; var16 <= var12.maxSceneY; ++var16) {
                                                        var36 = var8[var24][var16];
                                                        if (var36.aBoolean665) {
                                                            renderingTile.aBoolean562 = true;
                                                            continue label563;
                                                        }

                                                        if (var36.anInt791 != 0) {
                                                            var18 = 0;
                                                            if (var24 > var12.sceneX) {
                                                                ++var18;
                                                            }

                                                            if (var24 < var12.maxSceneX) {
                                                                var18 += 4;
                                                            }

                                                            if (var16 > var12.sceneY) {
                                                                var18 += 8;
                                                            }

                                                            if (var16 < var12.maxSceneY) {
                                                                var18 += 2;
                                                            }

                                                            if ((var18 & var36.anInt791) == renderingTile.anInt575) {
                                                                renderingTile.aBoolean562 = true;
                                                                continue label563;
                                                            }
                                                        }
                                                    }
                                                }

                                                anEntityMarkerArray1940[var14++] = var12;
                                                var24 = renderSceneX - var12.sceneX;
                                                var16 = var12.maxSceneX - renderSceneX;
                                                if (var16 > var24) {
                                                    var24 = var16;
                                                }

                                                var17 = renderSceneY - var12.sceneY;
                                                var18 = var12.maxSceneY - renderSceneY;
                                                if (var18 > var17) {
                                                    var12.anInt453 = var24 + var18;
                                                } else {
                                                    var12.anInt453 = var24 + var17;
                                                }
                                            }
                                        }

                                        while (var14 > 0) {
                                            var11 = -50;
                                            var25 = -1;

                                            for (var24 = 0; var24 < var14; ++var24) {
                                                EntityMarker var35 = anEntityMarkerArray1940[var24];
                                                if (var35.anInt452 != renderTick) {
                                                    if (var35.anInt453 > var11) {
                                                        var11 = var35.anInt453;
                                                        var25 = var24;
                                                    } else if (var11 == var35.anInt453) {
                                                        var17 = var35.centerFineX - renderCameraX;
                                                        var18 = var35.centerFineY - renderCameraY;
                                                        var19 = anEntityMarkerArray1940[var25].centerFineX - renderCameraX;
                                                        var20 = anEntityMarkerArray1940[var25].centerFineY - renderCameraY;
                                                        if (var17 * var17 + var18 * var18 > var19 * var19 + var20 * var20) {
                                                            var25 = var24;
                                                        }
                                                    }
                                                }
                                            }

                                            if (var25 == -1) {
                                                break;
                                            }

                                            EntityMarker var34 = anEntityMarkerArray1940[var25];
                                            var34.anInt452 = renderTick;
                                            if (!this.method1467(var7, var34.sceneX, var34.maxSceneX, var34.sceneY, var34.maxSceneY, var34.entity.height)) {
                                                var34.entity.method11(var34.orientation, pitchSin, pitchCos, yawSin, yawCos, var34.centerFineX - renderCameraX, var34.height - renderCameraZ, var34.centerFineY - renderCameraY, var34.uid);
                                            }

                                            for (var16 = var34.sceneX; var16 <= var34.maxSceneX; ++var16) {
                                                for (var17 = var34.sceneY; var17 <= var34.maxSceneY; ++var17) {
                                                    Tile var26 = var8[var16][var17];
                                                    if (var26.anInt791 != 0) {
                                                        aNodeDeque1936.add(var26);
                                                    } else if ((var16 != var4 || var17 != var5) && var26.aBoolean1151) {
                                                        aNodeDeque1936.add(var26);
                                                    }
                                                }
                                            }
                                        }

                                        if (!renderingTile.aBoolean562) {
                                            break;
                                        }
                                    } catch (Exception var28) {
                                        renderingTile.aBoolean562 = false;
                                        break;
                                    }
                                }
                            } while (!renderingTile.aBoolean1151);
                        } while (renderingTile.anInt791 != 0);

                        if (var4 > renderSceneX || var4 <= renderAreaMinX) {
                            break;
                        }

                        var9 = var8[var4 - 1][var5];
                        while (var9 != null && var9.aBoolean1151) {
                            do {
                                while (true) {
                                    Boundary var10;
                                    EntityMarker var12;
                                    boolean var13;
                                    int var14;
                                    int var19;
                                    int var20;
                                    Tile var36;
                                    while (true) {
                                        do {
                                            renderingTile = (Tile) aNodeDeque1936.popFirst();
                                            if (renderingTile == null) {

                                                return;
                                            }
                                        } while (!renderingTile.aBoolean1151);

                                        var4 = renderingTile.sceneX;
                                        var5 = renderingTile.sceneY;
                                        var6 = renderingTile.floorLevel;
                                        var7 = renderingTile.anInt380;
                                        var8 = this.tiles[var6];
                                        if (!renderingTile.aBoolean665) {
                                            break;
                                        }

                                        if (var2) {
                                            if (var6 > 0) {
                                                var9 = this.tiles[var6 - 1][var4][var5];
                                                if (var9 != null && var9.aBoolean1151) {
                                                    continue;
                                                }
                                            }

                                            if (var4 <= renderSceneX && var4 > renderAreaMinX) {
                                                var9 = var8[var4 - 1][var5];
                                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 1) == 0)) {
                                                    continue;
                                                }
                                            }

                                            if (var4 >= renderSceneX && var4 < renderAreaMaxX - 1) {
                                                var9 = var8[var4 + 1][var5];
                                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 4) == 0)) {
                                                    continue;
                                                }
                                            }

                                            if (var5 <= renderSceneY && var5 > renderAreaMinY) {
                                                var9 = var8[var4][var5 - 1];
                                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 8) == 0)) {
                                                    continue;
                                                }
                                            }

                                            if (var5 >= renderSceneY && var5 < renderAreaMaxY - 1) {
                                                var9 = var8[var4][var5 + 1];
                                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 2) == 0)) {
                                                    continue;
                                                }
                                            }
                                        } else {
                                            var2 = true;
                                        }

                                        renderingTile.aBoolean665 = false;
                                        if (renderingTile.aTile1150 != null) {
                                            var9 = renderingTile.aTile1150;
                                            if (var9.paint != null) {
                                                if (!this.method1464(0, var4, var5)) {
                                                    this.method1462(var9.paint, 0, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                                }
                                            } else if (var9.model != null && !this.method1464(0, var4, var5)) {
                                                this.method1459(var9.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                            }

                                            var10 = var9.boundary;
                                            if (var10 != null) {
                                                var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                            }

                                            for (var11 = 0; var11 < var9.anInt368; ++var11) {
                                                var12 = var9.markers[var11];
                                                if (var12 != null) {
                                                    var12.entity.method11(var12.orientation, pitchSin, pitchCos, yawSin, yawCos, var12.centerFineX - renderCameraX, var12.height - renderCameraZ, var12.centerFineY - renderCameraY, var12.uid);
                                                }
                                            }
                                        }

                                        var13 = false;
                                        if (renderingTile.paint != null) {
                                            if (!this.method1464(var7, var4, var5)) {
                                                var13 = true;
                                                if (renderingTile.paint.anInt2001 != 12345678 || aBoolean1942 && var6 <= anInt1931) {
                                                    this.method1462(renderingTile.paint, var7, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                                }
                                            }
                                        } else if (renderingTile.model != null && !this.method1464(var7, var4, var5)) {
                                            var13 = true;
                                            this.method1459(renderingTile.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                        }

                                        var14 = 0;
                                        var11 = 0;
                                        Boundary var31 = renderingTile.boundary;
                                        BoundaryDecor var15 = renderingTile.boundaryDecor;
                                        if (var31 != null || var15 != null) {
                                            if (var4 == renderSceneX) {
                                                ++var14;
                                            } else if (renderSceneX < var4) {
                                                var14 += 2;
                                            }

                                            if (var5 == renderSceneY) {
                                                var14 += 3;
                                            } else if (renderSceneY > var5) {
                                                var14 += 6;
                                            }

                                            var11 = anIntArray1935[var14];
                                            renderingTile.anInt1149 = anIntArray1948[var14];
                                        }

                                        if (var31 != null) {
                                            if ((var31.orientation & anIntArray1937[var14]) != 0) {
                                                if (var31.orientation == 16) {
                                                    renderingTile.anInt791 = 3;
                                                    renderingTile.anInt563 = anIntArray1945[var14];
                                                    renderingTile.anInt575 = 3 - renderingTile.anInt563;
                                                } else if (var31.orientation == 32) {
                                                    renderingTile.anInt791 = 6;
                                                    renderingTile.anInt563 = anIntArray1934[var14];
                                                    renderingTile.anInt575 = 6 - renderingTile.anInt563;
                                                } else if (var31.orientation == 64) {
                                                    renderingTile.anInt791 = 12;
                                                    renderingTile.anInt563 = anIntArray1944[var14];
                                                    renderingTile.anInt575 = 12 - renderingTile.anInt563;
                                                } else {
                                                    renderingTile.anInt791 = 9;
                                                    renderingTile.anInt563 = anIntArray1959[var14];
                                                    renderingTile.anInt575 = 9 - renderingTile.anInt563;
                                                }
                                            } else {
                                                renderingTile.anInt791 = 0;
                                            }

                                            if ((var31.orientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.orientation)) {
                                                var31.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                            }

                                            if ((var31.linkedOrientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.linkedOrientation)) {
                                                var31.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                            }
                                        }

                                        if (var15 != null && !this.method1466(var7, var4, var5, var15.entity.height)) {
                                            if ((var15.renderConfig & var11) != 0) {
                                                var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var15.offsetX + (var15.fineX * renderCameraX), var15.height - renderCameraZ, var15.offsetY + (var15.fineY * renderCameraY), var15.uid);
                                            } else if (var15.renderConfig == 256) {
                                                var16 = var15.fineX * renderCameraX;
                                                var17 = var15.height - renderCameraZ;
                                                var18 = var15.fineY * renderCameraY;
                                                var19 = var15.orientation;
                                                if (var19 != 1 && var19 != 2) {
                                                    var20 = var16;
                                                } else {
                                                    var20 = -var16;
                                                }

                                                int var21;
                                                if (var19 != 2 && var19 != 3) {
                                                    var21 = var18;
                                                } else {
                                                    var21 = -var18;
                                                }

                                                if (var21 < var20) {
                                                    var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16 + var15.offsetX, var17, var18 + var15.offsetY, var15.uid);
                                                } else if (var15.linkedEntity != null) {
                                                    var15.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16, var17, var18, var15.uid);
                                                }
                                            }
                                        }

                                        if (var13) {
                                            TileDecor var22 = renderingTile.decor;
                                            if (var22 != null) {
                                                var22.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var22.fineX * renderCameraX, var22.height - renderCameraZ, var22.fineY * renderCameraY, var22.uid);
                                            }

                                            PickablePile var23 = renderingTile.pickablePile;
                                            if (var23 != null && var23.height == 0) {
                                                if (var23.middle != null) {
                                                    var23.middle.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                                }

                                                if (var23.top != null) {
                                                    var23.top.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                                }

                                                if (var23.bottom != null) {
                                                    var23.bottom.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                                }
                                            }
                                        }

                                        var16 = renderingTile.anInt366;
                                        if (var16 != 0) {
                                            if (var4 < renderSceneX && (var16 & 4) != 0) {
                                                var36 = var8[var4 + 1][var5];
                                                if (var36 != null && var36.aBoolean1151) {
                                                    aNodeDeque1936.add(var36);
                                                }
                                            }

                                            if (var5 < renderSceneY && (var16 & 2) != 0) {
                                                var36 = var8[var4][var5 + 1];
                                                if (var36 != null && var36.aBoolean1151) {
                                                    aNodeDeque1936.add(var36);
                                                }
                                            }

                                            if (var4 > renderSceneX && (var16 & 1) != 0) {
                                                var36 = var8[var4 - 1][var5];
                                                if (var36 != null && var36.aBoolean1151) {
                                                    aNodeDeque1936.add(var36);
                                                }
                                            }

                                            if (var5 > renderSceneY && (var16 & 8) != 0) {
                                                var36 = var8[var4][var5 - 1];
                                                if (var36 != null && var36.aBoolean1151) {
                                                    aNodeDeque1936.add(var36);
                                                }
                                            }
                                        }
                                        break;
                                    }

                                    if (renderingTile.anInt791 != 0) {
                                        var13 = true;

                                        for (var14 = 0; var14 < renderingTile.anInt368; ++var14) {
                                            if (renderingTile.markers[var14].anInt452 != renderTick && (renderingTile.anIntArray374[var14] & renderingTile.anInt791) == renderingTile.anInt563) {
                                                var13 = false;
                                                break;
                                            }
                                        }

                                        if (var13) {
                                            var10 = renderingTile.boundary;
                                            if (!this.method1463(var7, var4, var5, var10.orientation)) {
                                                var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                            }

                                            renderingTile.anInt791 = 0;
                                        }
                                    }

                                    if (!renderingTile.aBoolean562) {
                                        break;
                                    }

                                    try {
                                        int var33 = renderingTile.anInt368;
                                        renderingTile.aBoolean562 = false;
                                        var14 = 0;

                                        label563:
                                        for (var11 = 0; var11 < var33; ++var11) {
                                            var12 = renderingTile.markers[var11];
                                            if (var12.anInt452 != renderTick) {
                                                for (var24 = var12.sceneX; var24 <= var12.maxSceneX; ++var24) {
                                                    for (var16 = var12.sceneY; var16 <= var12.maxSceneY; ++var16) {
                                                        var36 = var8[var24][var16];
                                                        if (var36.aBoolean665) {
                                                            renderingTile.aBoolean562 = true;
                                                            continue label563;
                                                        }

                                                        if (var36.anInt791 != 0) {
                                                            var18 = 0;
                                                            if (var24 > var12.sceneX) {
                                                                ++var18;
                                                            }

                                                            if (var24 < var12.maxSceneX) {
                                                                var18 += 4;
                                                            }

                                                            if (var16 > var12.sceneY) {
                                                                var18 += 8;
                                                            }

                                                            if (var16 < var12.maxSceneY) {
                                                                var18 += 2;
                                                            }

                                                            if ((var18 & var36.anInt791) == renderingTile.anInt575) {
                                                                renderingTile.aBoolean562 = true;
                                                                continue label563;
                                                            }
                                                        }
                                                    }
                                                }

                                                anEntityMarkerArray1940[var14++] = var12;
                                                var24 = renderSceneX - var12.sceneX;
                                                var16 = var12.maxSceneX - renderSceneX;
                                                if (var16 > var24) {
                                                    var24 = var16;
                                                }

                                                var17 = renderSceneY - var12.sceneY;
                                                var18 = var12.maxSceneY - renderSceneY;
                                                if (var18 > var17) {
                                                    var12.anInt453 = var24 + var18;
                                                } else {
                                                    var12.anInt453 = var24 + var17;
                                                }
                                            }
                                        }

                                        while (var14 > 0) {
                                            var11 = -50;
                                            var25 = -1;

                                            for (var24 = 0; var24 < var14; ++var24) {
                                                EntityMarker var35 = anEntityMarkerArray1940[var24];
                                                if (var35.anInt452 != renderTick) {
                                                    if (var35.anInt453 > var11) {
                                                        var11 = var35.anInt453;
                                                        var25 = var24;
                                                    } else if (var11 == var35.anInt453) {
                                                        var17 = var35.centerFineX - renderCameraX;
                                                        var18 = var35.centerFineY - renderCameraY;
                                                        var19 = anEntityMarkerArray1940[var25].centerFineX - renderCameraX;
                                                        var20 = anEntityMarkerArray1940[var25].centerFineY - renderCameraY;
                                                        if (var17 * var17 + var18 * var18 > var19 * var19 + var20 * var20) {
                                                            var25 = var24;
                                                        }
                                                    }
                                                }
                                            }

                                            if (var25 == -1) {
                                                break;
                                            }

                                            EntityMarker var34 = anEntityMarkerArray1940[var25];
                                            var34.anInt452 = renderTick;
                                            if (!this.method1467(var7, var34.sceneX, var34.maxSceneX, var34.sceneY, var34.maxSceneY, var34.entity.height)) {
                                                var34.entity.method11(var34.orientation, pitchSin, pitchCos, yawSin, yawCos, var34.centerFineX - renderCameraX, var34.height - renderCameraZ, var34.centerFineY - renderCameraY, var34.uid);
                                            }

                                            for (var16 = var34.sceneX; var16 <= var34.maxSceneX; ++var16) {
                                                for (var17 = var34.sceneY; var17 <= var34.maxSceneY; ++var17) {
                                                    Tile var26 = var8[var16][var17];
                                                    if (var26.anInt791 != 0) {
                                                        aNodeDeque1936.add(var26);
                                                    } else if ((var16 != var4 || var17 != var5) && var26.aBoolean1151) {
                                                        aNodeDeque1936.add(var26);
                                                    }
                                                }
                                            }
                                        }

                                        if (!renderingTile.aBoolean562) {
                                            break;
                                        }
                                    } catch (Exception var28) {
                                        renderingTile.aBoolean562 = false;
                                        break;
                                    }
                                }
                            } while (!renderingTile.aBoolean1151);
                            while (renderingTile.anInt791 != 0) {
                                while (true) {
                                    Boundary var10;
                                    EntityMarker var12;
                                    boolean var13;
                                    int var14;
                                    int var19;
                                    int var20;
                                    Tile var36;
                                    while (true) {
                                        do {
                                            renderingTile = (Tile) aNodeDeque1936.popFirst();
                                            if (renderingTile == null) {

                                                return;
                                            }
                                        } while (!renderingTile.aBoolean1151);

                                        var4 = renderingTile.sceneX;
                                        var5 = renderingTile.sceneY;
                                        var6 = renderingTile.floorLevel;
                                        var7 = renderingTile.anInt380;
                                        var8 = this.tiles[var6];
                                        if (!renderingTile.aBoolean665) {
                                            break;
                                        }

                                        if (var2) {
                                            if (var6 > 0) {
                                                var9 = this.tiles[var6 - 1][var4][var5];
                                                if (var9 != null && var9.aBoolean1151) {
                                                    continue;
                                                }
                                            }

                                            if (var4 <= renderSceneX && var4 > renderAreaMinX) {
                                                var9 = var8[var4 - 1][var5];
                                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 1) == 0)) {
                                                    continue;
                                                }
                                            }

                                            if (var4 >= renderSceneX && var4 < renderAreaMaxX - 1) {
                                                var9 = var8[var4 + 1][var5];
                                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 4) == 0)) {
                                                    continue;
                                                }
                                            }

                                            if (var5 <= renderSceneY && var5 > renderAreaMinY) {
                                                var9 = var8[var4][var5 - 1];
                                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 8) == 0)) {
                                                    continue;
                                                }
                                            }

                                            if (var5 >= renderSceneY && var5 < renderAreaMaxY - 1) {
                                                var9 = var8[var4][var5 + 1];
                                                if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 2) == 0)) {
                                                    continue;
                                                }
                                            }
                                        } else {
                                            var2 = true;
                                        }

                                        renderingTile.aBoolean665 = false;
                                        if (renderingTile.aTile1150 != null) {
                                            var9 = renderingTile.aTile1150;
                                            if (var9.paint != null) {
                                                if (!this.method1464(0, var4, var5)) {
                                                    this.method1462(var9.paint, 0, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                                }
                                            } else if (var9.model != null && !this.method1464(0, var4, var5)) {
                                                this.method1459(var9.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                            }

                                            var10 = var9.boundary;
                                            if (var10 != null) {
                                                var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                            }

                                            for (var11 = 0; var11 < var9.anInt368; ++var11) {
                                                var12 = var9.markers[var11];
                                                if (var12 != null) {
                                                    var12.entity.method11(var12.orientation, pitchSin, pitchCos, yawSin, yawCos, var12.centerFineX - renderCameraX, var12.height - renderCameraZ, var12.centerFineY - renderCameraY, var12.uid);
                                                }
                                            }
                                        }

                                        var13 = false;
                                        if (renderingTile.paint != null) {
                                            if (!this.method1464(var7, var4, var5)) {
                                                var13 = true;
                                                if (renderingTile.paint.anInt2001 != 12345678 || aBoolean1942 && var6 <= anInt1931) {
                                                    this.method1462(renderingTile.paint, var7, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                                }
                                            }
                                        } else if (renderingTile.model != null && !this.method1464(var7, var4, var5)) {
                                            var13 = true;
                                            this.method1459(renderingTile.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                        }

                                        var14 = 0;
                                        var11 = 0;
                                        Boundary var31 = renderingTile.boundary;
                                        BoundaryDecor var15 = renderingTile.boundaryDecor;
                                        if (var31 != null || var15 != null) {
                                            if (var4 == renderSceneX) {
                                                ++var14;
                                            } else if (renderSceneX < var4) {
                                                var14 += 2;
                                            }

                                            if (var5 == renderSceneY) {
                                                var14 += 3;
                                            } else if (renderSceneY > var5) {
                                                var14 += 6;
                                            }

                                            var11 = anIntArray1935[var14];
                                            renderingTile.anInt1149 = anIntArray1948[var14];
                                        }

                                        if (var31 != null) {
                                            if ((var31.orientation & anIntArray1937[var14]) != 0) {
                                                if (var31.orientation == 16) {
                                                    renderingTile.anInt791 = 3;
                                                    renderingTile.anInt563 = anIntArray1945[var14];
                                                    renderingTile.anInt575 = 3 - renderingTile.anInt563;
                                                } else if (var31.orientation == 32) {
                                                    renderingTile.anInt791 = 6;
                                                    renderingTile.anInt563 = anIntArray1934[var14];
                                                    renderingTile.anInt575 = 6 - renderingTile.anInt563;
                                                } else if (var31.orientation == 64) {
                                                    renderingTile.anInt791 = 12;
                                                    renderingTile.anInt563 = anIntArray1944[var14];
                                                    renderingTile.anInt575 = 12 - renderingTile.anInt563;
                                                } else {
                                                    renderingTile.anInt791 = 9;
                                                    renderingTile.anInt563 = anIntArray1959[var14];
                                                    renderingTile.anInt575 = 9 - renderingTile.anInt563;
                                                }
                                            } else {
                                                renderingTile.anInt791 = 0;
                                            }

                                            if ((var31.orientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.orientation)) {
                                                var31.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                            }

                                            if ((var31.linkedOrientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.linkedOrientation)) {
                                                var31.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                            }
                                        }

                                        if (var15 != null && !this.method1466(var7, var4, var5, var15.entity.height)) {
                                            if ((var15.renderConfig & var11) != 0) {
                                                var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var15.offsetX + (var15.fineX * renderCameraX), var15.height - renderCameraZ, var15.offsetY + (var15.fineY * renderCameraY), var15.uid);
                                            } else if (var15.renderConfig == 256) {
                                                var16 = var15.fineX * renderCameraX;
                                                var17 = var15.height - renderCameraZ;
                                                var18 = var15.fineY * renderCameraY;
                                                var19 = var15.orientation;
                                                if (var19 != 1 && var19 != 2) {
                                                    var20 = var16;
                                                } else {
                                                    var20 = -var16;
                                                }

                                                int var21;
                                                if (var19 != 2 && var19 != 3) {
                                                    var21 = var18;
                                                } else {
                                                    var21 = -var18;
                                                }

                                                if (var21 < var20) {
                                                    var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16 + var15.offsetX, var17, var18 + var15.offsetY, var15.uid);
                                                } else if (var15.linkedEntity != null) {
                                                    var15.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16, var17, var18, var15.uid);
                                                }
                                            }
                                        }

                                        if (var13) {
                                            TileDecor var22 = renderingTile.decor;
                                            if (var22 != null) {
                                                var22.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var22.fineX * renderCameraX, var22.height - renderCameraZ, var22.fineY * renderCameraY, var22.uid);
                                            }

                                            PickablePile var23 = renderingTile.pickablePile;
                                            if (var23 != null && var23.height == 0) {
                                                if (var23.middle != null) {
                                                    var23.middle.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                                }

                                                if (var23.top != null) {
                                                    var23.top.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                                }

                                                if (var23.bottom != null) {
                                                    var23.bottom.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                                }
                                            }
                                        }

                                        var16 = renderingTile.anInt366;
                                        if (var16 != 0) {
                                            if (var4 < renderSceneX && (var16 & 4) != 0) {
                                                var36 = var8[var4 + 1][var5];
                                                if (var36 != null && var36.aBoolean1151) {
                                                    aNodeDeque1936.add(var36);
                                                }
                                            }

                                            if (var5 < renderSceneY && (var16 & 2) != 0) {
                                                var36 = var8[var4][var5 + 1];
                                                if (var36 != null && var36.aBoolean1151) {
                                                    aNodeDeque1936.add(var36);
                                                }
                                            }

                                            if (var4 > renderSceneX && (var16 & 1) != 0) {
                                                var36 = var8[var4 - 1][var5];
                                                if (var36 != null && var36.aBoolean1151) {
                                                    aNodeDeque1936.add(var36);
                                                }
                                            }

                                            if (var5 > renderSceneY && (var16 & 8) != 0) {
                                                var36 = var8[var4][var5 - 1];
                                                if (var36 != null && var36.aBoolean1151) {
                                                    aNodeDeque1936.add(var36);
                                                }
                                            }
                                        }
                                        break;
                                    }

                                    if (renderingTile.anInt791 != 0) {
                                        var13 = true;

                                        for (var14 = 0; var14 < renderingTile.anInt368; ++var14) {
                                            if (renderingTile.markers[var14].anInt452 != renderTick && (renderingTile.anIntArray374[var14] & renderingTile.anInt791) == renderingTile.anInt563) {
                                                var13 = false;
                                                break;
                                            }
                                        }

                                        if (var13) {
                                            var10 = renderingTile.boundary;
                                            if (!this.method1463(var7, var4, var5, var10.orientation)) {
                                                var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                            }

                                            renderingTile.anInt791 = 0;
                                        }
                                    }

                                    if (!renderingTile.aBoolean562) {
                                        break;
                                    }

                                    try {
                                        int var33 = renderingTile.anInt368;
                                        renderingTile.aBoolean562 = false;
                                        var14 = 0;

                                        label563:
                                        for (var11 = 0; var11 < var33; ++var11) {
                                            var12 = renderingTile.markers[var11];
                                            if (var12.anInt452 != renderTick) {
                                                for (var24 = var12.sceneX; var24 <= var12.maxSceneX; ++var24) {
                                                    for (var16 = var12.sceneY; var16 <= var12.maxSceneY; ++var16) {
                                                        var36 = var8[var24][var16];
                                                        if (var36.aBoolean665) {
                                                            renderingTile.aBoolean562 = true;
                                                            continue label563;
                                                        }

                                                        if (var36.anInt791 != 0) {
                                                            var18 = 0;
                                                            if (var24 > var12.sceneX) {
                                                                ++var18;
                                                            }

                                                            if (var24 < var12.maxSceneX) {
                                                                var18 += 4;
                                                            }

                                                            if (var16 > var12.sceneY) {
                                                                var18 += 8;
                                                            }

                                                            if (var16 < var12.maxSceneY) {
                                                                var18 += 2;
                                                            }

                                                            if ((var18 & var36.anInt791) == renderingTile.anInt575) {
                                                                renderingTile.aBoolean562 = true;
                                                                continue label563;
                                                            }
                                                        }
                                                    }
                                                }

                                                anEntityMarkerArray1940[var14++] = var12;
                                                var24 = renderSceneX - var12.sceneX;
                                                var16 = var12.maxSceneX - renderSceneX;
                                                if (var16 > var24) {
                                                    var24 = var16;
                                                }

                                                var17 = renderSceneY - var12.sceneY;
                                                var18 = var12.maxSceneY - renderSceneY;
                                                if (var18 > var17) {
                                                    var12.anInt453 = var24 + var18;
                                                } else {
                                                    var12.anInt453 = var24 + var17;
                                                }
                                            }
                                        }

                                        while (var14 > 0) {
                                            var11 = -50;
                                            var25 = -1;

                                            for (var24 = 0; var24 < var14; ++var24) {
                                                EntityMarker var35 = anEntityMarkerArray1940[var24];
                                                if (var35.anInt452 != renderTick) {
                                                    if (var35.anInt453 > var11) {
                                                        var11 = var35.anInt453;
                                                        var25 = var24;
                                                    } else if (var11 == var35.anInt453) {
                                                        var17 = var35.centerFineX - renderCameraX;
                                                        var18 = var35.centerFineY - renderCameraY;
                                                        var19 = anEntityMarkerArray1940[var25].centerFineX - renderCameraX;
                                                        var20 = anEntityMarkerArray1940[var25].centerFineY - renderCameraY;
                                                        if (var17 * var17 + var18 * var18 > var19 * var19 + var20 * var20) {
                                                            var25 = var24;
                                                        }
                                                    }
                                                }
                                            }

                                            if (var25 == -1) {
                                                break;
                                            }

                                            EntityMarker var34 = anEntityMarkerArray1940[var25];
                                            var34.anInt452 = renderTick;
                                            if (!this.method1467(var7, var34.sceneX, var34.maxSceneX, var34.sceneY, var34.maxSceneY, var34.entity.height)) {
                                                var34.entity.method11(var34.orientation, pitchSin, pitchCos, yawSin, yawCos, var34.centerFineX - renderCameraX, var34.height - renderCameraZ, var34.centerFineY - renderCameraY, var34.uid);
                                            }

                                            for (var16 = var34.sceneX; var16 <= var34.maxSceneX; ++var16) {
                                                for (var17 = var34.sceneY; var17 <= var34.maxSceneY; ++var17) {
                                                    Tile var26 = var8[var16][var17];
                                                    if (var26.anInt791 != 0) {
                                                        aNodeDeque1936.add(var26);
                                                    } else if ((var16 != var4 || var17 != var5) && var26.aBoolean1151) {
                                                        aNodeDeque1936.add(var26);
                                                    }
                                                }
                                            }
                                        }

                                        if (!renderingTile.aBoolean562) {
                                            break;
                                        }
                                    } catch (Exception var28) {
                                        renderingTile.aBoolean562 = false;
                                        break;
                                    }
                                }
                                while (!renderingTile.aBoolean1151) {
                                    while (true) {
                                        Boundary var10;
                                        EntityMarker var12;
                                        boolean var13;
                                        int var14;
                                        int var19;
                                        int var20;
                                        Tile var36;
                                        while (true) {
                                            do {
                                                renderingTile = (Tile) aNodeDeque1936.popFirst();
                                                if (renderingTile == null) {

                                                    return;
                                                }
                                            } while (!renderingTile.aBoolean1151);

                                            var4 = renderingTile.sceneX;
                                            var5 = renderingTile.sceneY;
                                            var6 = renderingTile.floorLevel;
                                            var7 = renderingTile.anInt380;
                                            var8 = this.tiles[var6];
                                            if (!renderingTile.aBoolean665) {
                                                break;
                                            }

                                            if (var2) {
                                                if (var6 > 0) {
                                                    var9 = this.tiles[var6 - 1][var4][var5];
                                                    if (var9 != null && var9.aBoolean1151) {
                                                        continue;
                                                    }
                                                }

                                                if (var4 <= renderSceneX && var4 > renderAreaMinX) {
                                                    var9 = var8[var4 - 1][var5];
                                                    if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 1) == 0)) {
                                                        continue;
                                                    }
                                                }

                                                if (var4 >= renderSceneX && var4 < renderAreaMaxX - 1) {
                                                    var9 = var8[var4 + 1][var5];
                                                    if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 4) == 0)) {
                                                        continue;
                                                    }
                                                }

                                                if (var5 <= renderSceneY && var5 > renderAreaMinY) {
                                                    var9 = var8[var4][var5 - 1];
                                                    if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 8) == 0)) {
                                                        continue;
                                                    }
                                                }

                                                if (var5 >= renderSceneY && var5 < renderAreaMaxY - 1) {
                                                    var9 = var8[var4][var5 + 1];
                                                    if (var9 != null && var9.aBoolean1151 && (var9.aBoolean665 || (renderingTile.anInt366 & 2) == 0)) {
                                                        continue;
                                                    }
                                                }
                                            } else {
                                                var2 = true;
                                            }

                                            renderingTile.aBoolean665 = false;
                                            if (renderingTile.aTile1150 != null) {
                                                var9 = renderingTile.aTile1150;
                                                if (var9.paint != null) {
                                                    if (!this.method1464(0, var4, var5)) {
                                                        this.method1462(var9.paint, 0, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                                    }
                                                } else if (var9.model != null && !this.method1464(0, var4, var5)) {
                                                    this.method1459(var9.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                                }

                                                var10 = var9.boundary;
                                                if (var10 != null) {
                                                    var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                                }

                                                for (var11 = 0; var11 < var9.anInt368; ++var11) {
                                                    var12 = var9.markers[var11];
                                                    if (var12 != null) {
                                                        var12.entity.method11(var12.orientation, pitchSin, pitchCos, yawSin, yawCos, var12.centerFineX - renderCameraX, var12.height - renderCameraZ, var12.centerFineY - renderCameraY, var12.uid);
                                                    }
                                                }
                                            }

                                            var13 = false;
                                            if (renderingTile.paint != null) {
                                                if (!this.method1464(var7, var4, var5)) {
                                                    var13 = true;
                                                    if (renderingTile.paint.anInt2001 != 12345678 || aBoolean1942 && var6 <= anInt1931) {
                                                        this.method1462(renderingTile.paint, var7, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                                    }
                                                }
                                            } else if (renderingTile.model != null && !this.method1464(var7, var4, var5)) {
                                                var13 = true;
                                                this.method1459(renderingTile.model, pitchSin, pitchCos, yawSin, yawCos, var4, var5);
                                            }

                                            var14 = 0;
                                            var11 = 0;
                                            Boundary var31 = renderingTile.boundary;
                                            BoundaryDecor var15 = renderingTile.boundaryDecor;
                                            if (var31 != null || var15 != null) {
                                                if (var4 == renderSceneX) {
                                                    ++var14;
                                                } else if (renderSceneX < var4) {
                                                    var14 += 2;
                                                }

                                                if (var5 == renderSceneY) {
                                                    var14 += 3;
                                                } else if (renderSceneY > var5) {
                                                    var14 += 6;
                                                }

                                                var11 = anIntArray1935[var14];
                                                renderingTile.anInt1149 = anIntArray1948[var14];
                                            }

                                            if (var31 != null) {
                                                if ((var31.orientation & anIntArray1937[var14]) != 0) {
                                                    if (var31.orientation == 16) {
                                                        renderingTile.anInt791 = 3;
                                                        renderingTile.anInt563 = anIntArray1945[var14];
                                                        renderingTile.anInt575 = 3 - renderingTile.anInt563;
                                                    } else if (var31.orientation == 32) {
                                                        renderingTile.anInt791 = 6;
                                                        renderingTile.anInt563 = anIntArray1934[var14];
                                                        renderingTile.anInt575 = 6 - renderingTile.anInt563;
                                                    } else if (var31.orientation == 64) {
                                                        renderingTile.anInt791 = 12;
                                                        renderingTile.anInt563 = anIntArray1944[var14];
                                                        renderingTile.anInt575 = 12 - renderingTile.anInt563;
                                                    } else {
                                                        renderingTile.anInt791 = 9;
                                                        renderingTile.anInt563 = anIntArray1959[var14];
                                                        renderingTile.anInt575 = 9 - renderingTile.anInt563;
                                                    }
                                                } else {
                                                    renderingTile.anInt791 = 0;
                                                }

                                                if ((var31.orientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.orientation)) {
                                                    var31.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                                }

                                                if ((var31.linkedOrientation & var11) != 0 && !this.method1463(var7, var4, var5, var31.linkedOrientation)) {
                                                    var31.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var31.fineX * renderCameraX, var31.height - renderCameraZ, var31.fineY * renderCameraY, var31.uid);
                                                }
                                            }

                                            if (var15 != null && !this.method1466(var7, var4, var5, var15.entity.height)) {
                                                if ((var15.renderConfig & var11) != 0) {
                                                    var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var15.offsetX + (var15.fineX * renderCameraX), var15.height - renderCameraZ, var15.offsetY + (var15.fineY * renderCameraY), var15.uid);
                                                } else if (var15.renderConfig == 256) {
                                                    var16 = var15.fineX * renderCameraX;
                                                    var17 = var15.height - renderCameraZ;
                                                    var18 = var15.fineY * renderCameraY;
                                                    var19 = var15.orientation;
                                                    if (var19 != 1 && var19 != 2) {
                                                        var20 = var16;
                                                    } else {
                                                        var20 = -var16;
                                                    }

                                                    int var21;
                                                    if (var19 != 2 && var19 != 3) {
                                                        var21 = var18;
                                                    } else {
                                                        var21 = -var18;
                                                    }

                                                    if (var21 < var20) {
                                                        var15.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16 + var15.offsetX, var17, var18 + var15.offsetY, var15.uid);
                                                    } else if (var15.linkedEntity != null) {
                                                        var15.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var16, var17, var18, var15.uid);
                                                    }
                                                }
                                            }

                                            if (var13) {
                                                TileDecor var22 = renderingTile.decor;
                                                if (var22 != null) {
                                                    var22.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var22.fineX * renderCameraX, var22.height - renderCameraZ, var22.fineY * renderCameraY, var22.uid);
                                                }

                                                PickablePile var23 = renderingTile.pickablePile;
                                                if (var23 != null && var23.height == 0) {
                                                    if (var23.middle != null) {
                                                        var23.middle.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                                    }

                                                    if (var23.top != null) {
                                                        var23.top.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                                    }

                                                    if (var23.bottom != null) {
                                                        var23.bottom.method11(0, pitchSin, pitchCos, yawSin, yawCos, var23.fineX * renderCameraX, var23.anInt172 - renderCameraZ, var23.fineY * renderCameraY, var23.uid);
                                                    }
                                                }
                                            }

                                            var16 = renderingTile.anInt366;
                                            if (var16 != 0) {
                                                if (var4 < renderSceneX && (var16 & 4) != 0) {
                                                    var36 = var8[var4 + 1][var5];
                                                    if (var36 != null && var36.aBoolean1151) {
                                                        aNodeDeque1936.add(var36);
                                                    }
                                                }

                                                if (var5 < renderSceneY && (var16 & 2) != 0) {
                                                    var36 = var8[var4][var5 + 1];
                                                    if (var36 != null && var36.aBoolean1151) {
                                                        aNodeDeque1936.add(var36);
                                                    }
                                                }

                                                if (var4 > renderSceneX && (var16 & 1) != 0) {
                                                    var36 = var8[var4 - 1][var5];
                                                    if (var36 != null && var36.aBoolean1151) {
                                                        aNodeDeque1936.add(var36);
                                                    }
                                                }

                                                if (var5 > renderSceneY && (var16 & 8) != 0) {
                                                    var36 = var8[var4][var5 - 1];
                                                    if (var36 != null && var36.aBoolean1151) {
                                                        aNodeDeque1936.add(var36);
                                                    }
                                                }
                                            }
                                            break;
                                        }

                                        if (renderingTile.anInt791 != 0) {
                                            var13 = true;

                                            for (var14 = 0; var14 < renderingTile.anInt368; ++var14) {
                                                if (renderingTile.markers[var14].anInt452 != renderTick && (renderingTile.anIntArray374[var14] & renderingTile.anInt791) == renderingTile.anInt563) {
                                                    var13 = false;
                                                    break;
                                                }
                                            }

                                            if (var13) {
                                                var10 = renderingTile.boundary;
                                                if (!this.method1463(var7, var4, var5, var10.orientation)) {
                                                    var10.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var10.fineX * renderCameraX, var10.height - renderCameraZ, var10.fineY * renderCameraY, var10.uid);
                                                }

                                                renderingTile.anInt791 = 0;
                                            }
                                        }

                                        if (!renderingTile.aBoolean562) {
                                            break;
                                        }

                                        try {
                                            int var33 = renderingTile.anInt368;
                                            renderingTile.aBoolean562 = false;
                                            var14 = 0;

                                            label563:
                                            for (var11 = 0; var11 < var33; ++var11) {
                                                var12 = renderingTile.markers[var11];
                                                if (var12.anInt452 != renderTick) {
                                                    for (var24 = var12.sceneX; var24 <= var12.maxSceneX; ++var24) {
                                                        for (var16 = var12.sceneY; var16 <= var12.maxSceneY; ++var16) {
                                                            var36 = var8[var24][var16];
                                                            if (var36.aBoolean665) {
                                                                renderingTile.aBoolean562 = true;
                                                                continue label563;
                                                            }

                                                            if (var36.anInt791 != 0) {
                                                                var18 = 0;
                                                                if (var24 > var12.sceneX) {
                                                                    ++var18;
                                                                }

                                                                if (var24 < var12.maxSceneX) {
                                                                    var18 += 4;
                                                                }

                                                                if (var16 > var12.sceneY) {
                                                                    var18 += 8;
                                                                }

                                                                if (var16 < var12.maxSceneY) {
                                                                    var18 += 2;
                                                                }

                                                                if ((var18 & var36.anInt791) == renderingTile.anInt575) {
                                                                    renderingTile.aBoolean562 = true;
                                                                    continue label563;
                                                                }
                                                            }
                                                        }
                                                    }

                                                    anEntityMarkerArray1940[var14++] = var12;
                                                    var24 = renderSceneX - var12.sceneX;
                                                    var16 = var12.maxSceneX - renderSceneX;
                                                    if (var16 > var24) {
                                                        var24 = var16;
                                                    }

                                                    var17 = renderSceneY - var12.sceneY;
                                                    var18 = var12.maxSceneY - renderSceneY;
                                                    if (var18 > var17) {
                                                        var12.anInt453 = var24 + var18;
                                                    } else {
                                                        var12.anInt453 = var24 + var17;
                                                    }
                                                }
                                            }

                                            while (var14 > 0) {
                                                var11 = -50;
                                                var25 = -1;

                                                for (var24 = 0; var24 < var14; ++var24) {
                                                    EntityMarker var35 = anEntityMarkerArray1940[var24];
                                                    if (var35.anInt452 != renderTick) {
                                                        if (var35.anInt453 > var11) {
                                                            var11 = var35.anInt453;
                                                            var25 = var24;
                                                        } else if (var11 == var35.anInt453) {
                                                            var17 = var35.centerFineX - renderCameraX;
                                                            var18 = var35.centerFineY - renderCameraY;
                                                            var19 = anEntityMarkerArray1940[var25].centerFineX - renderCameraX;
                                                            var20 = anEntityMarkerArray1940[var25].centerFineY - renderCameraY;
                                                            if (var17 * var17 + var18 * var18 > var19 * var19 + var20 * var20) {
                                                                var25 = var24;
                                                            }
                                                        }
                                                    }
                                                }

                                                if (var25 == -1) {
                                                    break;
                                                }

                                                EntityMarker var34 = anEntityMarkerArray1940[var25];
                                                var34.anInt452 = renderTick;
                                                if (!this.method1467(var7, var34.sceneX, var34.maxSceneX, var34.sceneY, var34.maxSceneY, var34.entity.height)) {
                                                    var34.entity.method11(var34.orientation, pitchSin, pitchCos, yawSin, yawCos, var34.centerFineX - renderCameraX, var34.height - renderCameraZ, var34.centerFineY - renderCameraY, var34.uid);
                                                }

                                                for (var16 = var34.sceneX; var16 <= var34.maxSceneX; ++var16) {
                                                    for (var17 = var34.sceneY; var17 <= var34.maxSceneY; ++var17) {
                                                        Tile var26 = var8[var16][var17];
                                                        if (var26.anInt791 != 0) {
                                                            aNodeDeque1936.add(var26);
                                                        } else if ((var16 != var4 || var17 != var5) && var26.aBoolean1151) {
                                                            aNodeDeque1936.add(var26);
                                                        }
                                                    }
                                                }
                                            }

                                            if (!renderingTile.aBoolean562) {
                                                break;
                                            }
                                        } catch (Exception var28) {
                                            renderingTile.aBoolean562 = false;
                                            break;
                                        }
                                    }
                                }
                            }

                            if (var4 > renderSceneX || var4 <= renderAreaMinX) {
                                break;
                            }

                            var9 = var8[var4 - 1][var5];
                        }

                        if (var4 < renderSceneX || var4 >= renderAreaMaxX - 1) {
                            break;
                        }

                        var9 = var8[var4 + 1][var5];
                    }

                    if (var5 > renderSceneY || var5 <= renderAreaMinY) {
                        break;
                    }

                    var9 = var8[var4][var5 - 1];
                }

                if (var5 < renderSceneY || var5 >= renderAreaMaxY - 1) {
                    break;
                }

                var9 = var8[var4][var5 + 1];
            }

            renderingTile.aBoolean1151 = false;
            --anInt1962;
            PickablePile var32 = renderingTile.pickablePile;
            if (var32 != null && var32.height != 0) {
                if (var32.middle != null) {
                    var32.middle.method11(0, pitchSin, pitchCos, yawSin, yawCos, var32.fineX * renderCameraX, var32.anInt172 - renderCameraZ - var32.height, var32.fineY * renderCameraY, var32.uid);
                }

                if (var32.top != null) {
                    var32.top.method11(0, pitchSin, pitchCos, yawSin, yawCos, var32.fineX * renderCameraX, var32.anInt172 - renderCameraZ - var32.height, var32.fineY * renderCameraY, var32.uid);
                }

                if (var32.bottom != null) {
                    var32.bottom.method11(0, pitchSin, pitchCos, yawSin, yawCos, var32.fineX * renderCameraX, var32.anInt172 - renderCameraZ - var32.height, var32.fineY * renderCameraY, var32.uid);
                }
            }

            if (renderingTile.anInt1149 != 0) {
                BoundaryDecor var29 = renderingTile.boundaryDecor;
                if (var29 != null && !this.method1466(var7, var4, var5, var29.entity.height)) {
                    if ((var29.renderConfig & renderingTile.anInt1149) != 0) {
                        var29.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var29.offsetX + (var29.fineX * renderCameraX), var29.height - renderCameraZ, var29.offsetY + (var29.fineY * renderCameraY), var29.uid);
                    } else if (var29.renderConfig == 256) {
                        var11 = var29.fineX * renderCameraX;
                        var25 = var29.height - renderCameraZ;
                        var24 = var29.fineY * renderCameraY;
                        var16 = var29.orientation;
                        if (var16 != 1 && var16 != 2) {
                            var17 = var11;
                        } else {
                            var17 = -var11;
                        }

                        if (var16 != 2 && var16 != 3) {
                            var18 = var24;
                        } else {
                            var18 = -var24;
                        }

                        if (var18 >= var17) {
                            var29.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var11 + var29.offsetX, var25, var24 + var29.offsetY, var29.uid);
                        } else if (var29.linkedEntity != null) {
                            var29.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var11, var25, var24, var29.uid);
                        }
                    }
                }

                Boundary var27 = renderingTile.boundary;
                if (var27 != null) {
                    if ((var27.linkedOrientation & renderingTile.anInt1149) != 0 && !this.method1463(var7, var4, var5, var27.linkedOrientation)) {
                        var27.linkedEntity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var27.fineX * renderCameraX, var27.height - renderCameraZ, var27.fineY * renderCameraY, var27.uid);
                    }

                    if ((var27.orientation & renderingTile.anInt1149) != 0 && !this.method1463(var7, var4, var5, var27.orientation)) {
                        var27.entity.method11(0, pitchSin, pitchCos, yawSin, yawCos, var27.fineX * renderCameraX, var27.height - renderCameraZ, var27.fineY * renderCameraY, var27.uid);
                    }
                }
            }

            Tile var30;
            if (var6 < this.anInt1971 - 1) {
                var30 = this.tiles[var6 + 1][var4][var5];
                if (var30 != null && var30.aBoolean1151) {
                    aNodeDeque1936.add(var30);
                }
            }

            if (var4 < renderSceneX) {
                var30 = var8[var4 + 1][var5];
                if (var30 != null && var30.aBoolean1151) {
                    aNodeDeque1936.add(var30);
                }
            }

            if (var5 < renderSceneY) {
                var30 = var8[var4][var5 + 1];
                if (var30 != null && var30.aBoolean1151) {
                    aNodeDeque1936.add(var30);
                }
            }

            if (var4 > renderSceneX) {
                var30 = var8[var4 - 1][var5];
                if (var30 != null && var30.aBoolean1151) {
                    aNodeDeque1936.add(var30);
                }
            }

            if (var5 > renderSceneY) {
                var30 = var8[var4][var5 - 1];
                if (var30 != null && var30.aBoolean1151) {
                    aNodeDeque1936.add(var30);
                }
            }
        }
    }

    public void drawMinimapTile(int[] raster, int index, int width, int floorLevel, int sceneX, int sceneY) {
        Tile tile = this.tiles[floorLevel][sceneX][sceneY];

        if (tile != null) {
            TilePaint paintTile = tile.paint;
            if (paintTile != null) {
                int color = paintTile.rgb;
                if (color != 0) {
                    for (int i = 0; i < 4; ++i) {
                        raster[index] = color;
                        raster[index + 1] = color;
                        raster[index + 2] = color;
                        raster[index + 3] = color;
                        index += width;
                    }

                }
            } else {
                TileModel model = tile.model;
                if (model != null) {
                    int shape = model.shape;
                    int rotation = model.rotation;
                    int underlay = model.underlay;
                    int overlay = model.overlay;
                    int[] tileShapes = this.tileShapes[shape];
                    int[] tileRotations = this.tileRotations[rotation];
                    int var17 = 0;
                    int var18;
                    if (underlay != 0) {
                        for (var18 = 0; var18 < 4; ++var18) {
                            raster[index] = tileShapes[tileRotations[var17++]] == 0 ? underlay : overlay;
                            raster[index + 1] = tileShapes[tileRotations[var17++]] == 0 ? underlay : overlay;
                            raster[index + 2] = tileShapes[tileRotations[var17++]] == 0 ? underlay : overlay;
                            raster[index + 3] = tileShapes[tileRotations[var17++]] == 0 ? underlay : overlay;
                            index += width;
                        }
                    } else {
                        for (var18 = 0; var18 < 4; ++var18) {
                            if (tileShapes[tileRotations[var17++]] != 0) {
                                raster[index] = overlay;
                            }

                            if (tileShapes[tileRotations[var17++]] != 0) {
                                raster[index + 1] = overlay;
                            }

                            if (tileShapes[tileRotations[var17++]] != 0) {
                                raster[index + 2] = overlay;
                            }

                            if (tileShapes[tileRotations[var17++]] != 0) {
                                raster[index + 3] = overlay;
                            }

                            index += width;
                        }
                    }

                }
            }
        }
    }

    public boolean method1469(int var1, int var2, int var3, int var4, int var5, Entity var6, int var7, long var8, boolean var10) {
        if (var6 == null) {
            return true;
        }
        int var11 = var2 - var5;
        int var12 = var3 - var5;
        int var13 = var5 + var2;
        int var14 = var3 + var5;
        if (var10) {
            if (var7 > 640 && var7 < 1408) {
                var14 += 128;
            }

            if (var7 > 1152 && var7 < 1920) {
                var13 += 128;
            }

            if (var7 > 1664 || var7 < 384) {
                var12 -= 128;
            }

            if (var7 > 128 && var7 < 896) {
                var11 -= 128;
            }
        }

        var11 /= 128;
        var12 /= 128;
        var13 /= 128;
        var14 /= 128;
        return this.addEntityMarker(var1, var11, var12, var13 - var11 + 1, var14 - var12 + 1, var2, var3, var4, var6, var7, true, var8, 0);
    }

    public boolean method1479(int var1, int var2, int var3, int var4, Entity var6, int var7, long var8, int var10, int var11, int var12, int var13) {
        return var6 == null || this.addEntityMarker(var1, var10, var11, var12 - var10 + 1, var13 - var11 + 1, var2, var3, var4, var6, var7, true, var8, 0);
    }

    public void method1450(int var1, int var2, int var3) {
        for (int var4 = 0; var4 < this.anInt1971; ++var4) {
            for (int var5 = 0; var5 < this.width; ++var5) {
                for (int var6 = 0; var6 < this.length; ++var6) {
                    Tile var7 = this.tiles[var4][var5][var6];
                    if (var7 != null) {
                        Boundary var8 = var7.boundary;
                        UnlitModel var10;
                        if (var8 != null && var8.entity instanceof UnlitModel) {
                            UnlitModel var9 = (UnlitModel) var8.entity;
                            this.method1452(var9, var4, var5, var6, 1, 1);
                            if (var8.linkedEntity instanceof UnlitModel) {
                                var10 = (UnlitModel) var8.linkedEntity;
                                this.method1452(var10, var4, var5, var6, 1, 1);
                                UnlitModel.method970(var9, var10, 0, 0, 0, false);
                                var8.linkedEntity = var10.light(var10.aShort1441, var10.aShort1439, var1, var2, var3);
                            }

                            var8.entity = var9.light(var9.aShort1441, var9.aShort1439, var1, var2, var3);
                        }

                        for (int var11 = 0; var11 < var7.anInt368; ++var11) {
                            EntityMarker var14 = var7.markers[var11];
                            if (var14 != null && var14.entity instanceof UnlitModel) {
                                UnlitModel var12 = (UnlitModel) var14.entity;
                                this.method1452(var12, var4, var5, var6, var14.maxSceneX - var14.sceneX + 1, var14.maxSceneY - var14.sceneY + 1);
                                var14.entity = var12.light(var12.aShort1441, var12.aShort1439, var1, var2, var3);
                            }
                        }

                        TileDecor var13 = var7.decor;
                        if (var13 != null && var13.entity instanceof UnlitModel) {
                            var10 = (UnlitModel) var13.entity;
                            this.method1442(var10, var4, var5, var6);
                            var13.entity = var10.light(var10.aShort1441, var10.aShort1439, var1, var2, var3);
                        }
                    }
                }
            }
        }

    }

    public void method1484(int var1, int var2) {
        Tile var3 = this.tiles[0][var1][var2];

        for (int var4 = 0; var4 < 3; ++var4) {
            Tile var5 = this.tiles[var4][var1][var2] = this.tiles[var4 + 1][var1][var2];
            if (var5 != null) {
                --var5.floorLevel;

                for (int var6 = 0; var6 < var5.anInt368; ++var6) {
                    EntityMarker var7 = var5.markers[var6];
                    if (Class69.method379(var7.uid) && var7.sceneX == var1 && var2 == var7.sceneY) {
                        --var7.floorLevel;
                    }
                }
            }
        }

        if (this.tiles[0][var1][var2] == null) {
            this.tiles[0][var1][var2] = new Tile(0, var1, var2);
        }

        this.tiles[0][var1][var2].aTile1150 = var3;
        this.tiles[3][var1][var2] = null;
    }

    public void method1482(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        if (var4 != null) {
            var4.boundary = null;
        }
    }

    public void method1481(int var1, int var2, int var3, int var4) {
        Tile var5 = this.tiles[var1][var2][var3];
        if (var5 != null) {
            this.tiles[var1][var2][var3].anInt696 = var4;
        }
    }

    public void method1473(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        if (var4 != null) {
            var4.boundaryDecor = null;
        }
    }

    public void method1478(int var1) {
        this.anInt1972 = var1;

        for (int var2 = 0; var2 < this.width; ++var2) {
            for (int var3 = 0; var3 < this.length; ++var3) {
                if (this.tiles[var1][var2][var3] == null) {
                    this.tiles[var1][var2][var3] = new Tile(var1, var2, var3);
                }
            }
        }

    }

    public void method1475(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        if (var4 != null) {
            for (int var5 = 0; var5 < var4.anInt368; ++var5) {
                EntityMarker var6 = var4.markers[var5];
                if (Class69.method379(var6.uid) && var2 == var6.sceneX && var3 == var6.sceneY) {
                    this.method1485(var6);
                    return;
                }
            }

        }
    }

    public void method1471(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        if (var4 != null) {
            var4.decor = null;
        }
    }

    public void renderScene(int camX, int camZ, int camY, int pitch, int yaw, int floor) {
        if (camX < 0) {
            camX = 0;
        } else if (camX >= this.width * 128) {
            camX = this.width * 128 - 1;
        }

        if (camY < 0) {
            camY = 0;
        } else if (camY >= this.length * 128) {
            camY = this.length * 128 - 1;
        }

        if (pitch < 128) {
            pitch = 128;
        } else if (pitch > 383) {
            pitch = 383;
        }

        ++renderTick;
        pitchSin = JagGraphics3D.SIN_TABLE[pitch];
        pitchCos = JagGraphics3D.COS_TABLE[pitch];
        yawSin = JagGraphics3D.SIN_TABLE[yaw];
        yawCos = JagGraphics3D.COS_TABLE[yaw];
        aBooleanArrayArray1951 = aBooleanArrayArrayArrayArray1960[(pitch - 128) / 32][yaw / 64]; //tile visibility maps
        renderCameraX = camX;
        renderCameraZ = camZ;
        renderCameraY = camY;
        renderSceneX = camX / 128;
        renderSceneY = camY / 128;
        renderFloor = floor;
        renderAreaMinX = renderSceneX - 25;
        if (renderAreaMinX < 0) {
            renderAreaMinX = 0;
        }

        renderAreaMinY = renderSceneY - 25;
        if (renderAreaMinY < 0) {
            renderAreaMinY = 0;
        }

        renderAreaMaxX = renderSceneX + 25;
        if (renderAreaMaxX > this.width) {
            renderAreaMaxX = this.width;
        }

        renderAreaMaxY = renderSceneY + 25;
        if (renderAreaMaxY > this.length) {
            renderAreaMaxY = this.length;
        }

        this.method1468();
        anInt1962 = 0;

        int var7;
        Tile[][] var8;
        int var9;
        int var10;
        for (var7 = this.anInt1972; var7 < this.anInt1971; ++var7) {
            var8 = this.tiles[var7];

            for (var9 = renderAreaMinX; var9 < renderAreaMaxX; ++var9) {
                for (var10 = renderAreaMinY; var10 < renderAreaMaxY; ++var10) {
                    Tile var11 = var8[var9][var10];
                    if (var11 != null) {
                        if (var11.anInt696 <= floor && (aBooleanArrayArray1951[var9 - renderSceneX + 25][var10 - renderSceneY + 25] || this.anIntArrayArrayArray1973[var7][var9][var10] - camZ >= 2000)) {
                            var11.aBoolean665 = true;
                            var11.aBoolean1151 = true;
                            var11.aBoolean562 = var11.anInt368 > 0;

                            ++anInt1962;
                        } else {
                            var11.aBoolean665 = false;
                            var11.aBoolean1151 = false;
                            var11.anInt791 = 0;
                        }
                    }
                }
            }
        }

        int var12;
        int var13;
        int var14;
        int var15;
        Tile var16;
        for (var7 = this.anInt1972; var7 < this.anInt1971; ++var7) {
            var8 = this.tiles[var7];

            for (var9 = -25; var9 <= 0; ++var9) {
                var10 = var9 + renderSceneX;
                var12 = renderSceneX - var9;
                if (var10 >= renderAreaMinX || var12 < renderAreaMaxX) {
                    for (var13 = -25; var13 <= 0; ++var13) {
                        var14 = var13 + renderSceneY;
                        var15 = renderSceneY - var13;
                        if (var10 >= renderAreaMinX) {
                            if (var14 >= renderAreaMinY) {
                                var16 = var8[var10][var14];
                                if (var16 != null && var16.aBoolean665) {
                                    this.renderTile(var16, true);
                                }
                            }

                            if (var15 < renderAreaMaxY) {
                                var16 = var8[var10][var15];
                                if (var16 != null && var16.aBoolean665) {
                                    this.renderTile(var16, true);
                                }
                            }
                        }

                        if (var12 < renderAreaMaxX) {
                            if (var14 >= renderAreaMinY) {
                                var16 = var8[var12][var14];
                                if (var16 != null && var16.aBoolean665) {
                                    this.renderTile(var16, true);
                                }
                            }

                            if (var15 < renderAreaMaxY) {
                                var16 = var8[var12][var15];
                                if (var16 != null && var16.aBoolean665) {
                                    this.renderTile(var16, true);
                                }
                            }
                        }

                        if (anInt1962 == 0) {
                            aBoolean1942 = false;
                            return;
                        }
                    }
                }
            }
        }

        for (var7 = this.anInt1972; var7 < this.anInt1971; ++var7) {
            var8 = this.tiles[var7];

            for (var9 = -25; var9 <= 0; ++var9) {
                var10 = var9 + renderSceneX;
                var12 = renderSceneX - var9;
                if (var10 >= renderAreaMinX || var12 < renderAreaMaxX) {
                    for (var13 = -25; var13 <= 0; ++var13) {
                        var14 = var13 + renderSceneY;
                        var15 = renderSceneY - var13;
                        if (var10 >= renderAreaMinX) {
                            if (var14 >= renderAreaMinY) {
                                var16 = var8[var10][var14];
                                if (var16 != null && var16.aBoolean665) {
                                    this.renderTile(var16, false);
                                }
                            }

                            if (var15 < renderAreaMaxY) {
                                var16 = var8[var10][var15];
                                if (var16 != null && var16.aBoolean665) {
                                    this.renderTile(var16, false);
                                }
                            }
                        }

                        if (var12 < renderAreaMaxX) {
                            if (var14 >= renderAreaMinY) {
                                var16 = var8[var12][var14];
                                if (var16 != null && var16.aBoolean665) {
                                    this.renderTile(var16, false);
                                }
                            }

                            if (var15 < renderAreaMaxY) {
                                var16 = var8[var12][var15];
                                if (var16 != null && var16.aBoolean665) {
                                    this.renderTile(var16, false);
                                }
                            }
                        }

                        if (anInt1962 == 0) {
                            aBoolean1942 = false;
                            return;
                        }
                    }
                }
            }
        }

        aBoolean1942 = false;
    }

    public void addTileDecor(int var1, int var2, int var3, int var4, Entity var5, long var6, int var8) {
        if (var5 != null) {
            TileDecor var9 = new TileDecor();
            var9.entity = var5;
            var9.fineX = var2 * 128 + 64;
            var9.fineY = var3 * 128 + 64;
            var9.height = var4;
            var9.uid = var6;
            var9.config = var8;
            if (this.tiles[var1][var2][var3] == null) {
                this.tiles[var1][var2][var3] = new Tile(var1, var2, var3);
            }

            this.tiles[var1][var2][var3].decor = var9;
        }
    }

    public boolean method1470(int var1, int var2, int var3, int var4, int var5, int var6, Entity var7, int var8, long var9, int var11) {
        if (var7 == null) {
            return true;
        }
        int var12 = var5 * 64 + var2 * 128;
        int var13 = var6 * 64 + var3 * 128;
        return this.addEntityMarker(var1, var2, var3, var5, var6, var12, var13, var4, var7, var8, false, var9, var11);
    }

    public void addBoundary(int var1, int var2, int var3, int var4, Entity var5, Entity var6, int var7, int var8, long var9, int var11) {
        if (var5 != null || var6 != null) {
            Boundary var12 = new Boundary();
            var12.uid = var9;
            var12.config = var11;
            var12.fineX = var2 * 128 + 64;
            var12.fineY = var3 * 128 + 64;
            var12.height = var4;
            var12.entity = var5;
            var12.linkedEntity = var6;
            var12.orientation = var7;
            var12.linkedOrientation = var8;

            for (int var13 = var1; var13 >= 0; --var13) {
                if (this.tiles[var13][var2][var3] == null) {
                    this.tiles[var13][var2][var3] = new Tile(var13, var2, var3);
                }
            }

            this.tiles[var1][var2][var3].boundary = var12;
        }
    }

    public void addBoundaryDecor(int var1, int var2, int var3, int var4, Entity var5, Entity var6, int var7, int var8, int var9, int var10, long var11, int var13) {
        if (var5 != null) {
            BoundaryDecor var14 = new BoundaryDecor();
            var14.uid = var11;
            var14.config = var13;
            var14.fineX = var2 * 128 + 64;
            var14.fineY = var3 * 128 + 64;
            var14.height = var4;
            var14.entity = var5;
            var14.linkedEntity = var6;
            var14.renderConfig = var7;
            var14.orientation = var8;
            var14.offsetX = var9;
            var14.offsetY = var10;

            for (int var15 = var1; var15 >= 0; --var15) {
                if (this.tiles[var15][var2][var3] == null) {
                    this.tiles[var15][var2][var3] = new Tile(var15, var2, var3);
                }
            }

            this.tiles[var1][var2][var3].boundaryDecor = var14;
        }
    }

    public void method1472() {
        for (int var1 = 0; var1 < this.anInt1970; ++var1) {
            EntityMarker var2 = this.tempMarkers[var1];
            this.method1485(var2);
            this.tempMarkers[var1] = null;
        }

        this.anInt1970 = 0;
    }

    public void method1474(int var1, int var2, int var3, int var4) {
        Tile var5 = this.tiles[var1][var2][var3];
        if (var5 != null) {
            BoundaryDecor var6 = var5.boundaryDecor;
            if (var6 != null) {
                var6.offsetX = var4 * var6.offsetX / 16;
                var6.offsetY = var4 * var6.offsetY / 16;
            }
        }
    }

    public void method1480(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19, int var20) {
        TilePaint var21;
        int var22;
        if (var4 == 0) {
            var21 = new TilePaint(var11, var12, var13, var14, -1, var19, false);

            for (var22 = var1; var22 >= 0; --var22) {
                if (this.tiles[var22][var2][var3] == null) {
                    this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
                }
            }

            this.tiles[var1][var2][var3].paint = var21;
        } else if (var4 != 1) {
            TileModel var23 = new TileModel(var4, var5, var6, var2, var3, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20);

            for (var22 = var1; var22 >= 0; --var22) {
                if (this.tiles[var22][var2][var3] == null) {
                    this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
                }
            }

            this.tiles[var1][var2][var3].model = var23;
        } else {
            var21 = new TilePaint(var15, var16, var17, var18, var6, var20, var8 == var7 && var7 == var9 && var10 == var7);

            for (var22 = var1; var22 >= 0; --var22) {
                if (this.tiles[var22][var2][var3] == null) {
                    this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
                }
            }

            this.tiles[var1][var2][var3].paint = var21;
        }
    }
}
