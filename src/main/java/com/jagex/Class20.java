package com.jagex;

public class Class20 implements Class10 {
    public static Class216 aClass216_284;
    static DoublyLinkedNode_Sub24_Sub4 aDoublyNode_Sub24_Sub4_288;
    int anInt285;
    int anInt282;
    int anInt279;
    int anInt287;
    int anInt281;
    int anInt278;
    int anInt283;
    int anInt277;
    int anInt280;
    int anInt286;

    Class20() {
    }

    static RuneScript method151(int var0, int var1, int var2) {
        int var3 = (var1 << 8) + var0;
        RuneScript var5 = Class36.method239(var3);
        if (var5 != null) {
            return var5;
        }
        int var6 = (var2 + 40000 << 8) + var0;
        var5 = Class36.method239(var6);
        return var5;
    }

    static String method149(int var0) {
        String var1 = Integer.toString(var0);

        for (int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
            var1 = var1.substring(0, var2) + "," + var1.substring(var2);
        }

        if (var1.length() > 9) {
            return " " + World.getColorTags(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>";
        }
        return var1.length() > 6 ? " " + World.getColorTags(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>" : " " + World.getColorTags(16776960) + var1 + "</col>";
    }

    static void drawMinimapObjects(int var0, int var1, int var2, int var3, int var4) {
        long var5 = client.sceneGraph.method1456(var0, var1, var2);
        int var7;
        int var8;
        int var9;
        int var10;
        int var12;
        int var13;
        if (var5 != 0L) {
            var7 = client.sceneGraph.method1453(var0, var1, var2, var5);
            var8 = var7 >> 6 & 3;
            var9 = var7 & 31;
            var10 = var3;
            if (Class149.method857(var5)) {
                var10 = var4;
            }

            int[] var11 = Node_Sub2.minimapSprite.pixels;
            var12 = var1 * 4 + (103 - var2) * 2048 + 24624;
            var13 = EntityUID.getObjectId(var5);
            ObjectDefinition var14 = Class38.getObjectDefinition(var13);
            if (var14.mapSceneId != -1) {
                DoublyLinkedNode_Sub24_Sub4 var15 = Class62.mapscene[var14.mapSceneId];
                if (var15 != null) {
                    int var16 = (var14.sizeX * 4 - var15.anInt378) / 2;
                    int var17 = (var14.sizeY * 4 - var15.anInt377) / 2;
                    var15.method1324(var1 * 4 + var16 + 48, var17 + (104 - var2 - var14.sizeY) * 4 + 48);
                }
            } else {
                if (var9 == 0 || var9 == 2) {
                    if (var8 == 0) {
                        var11[var12] = var10;
                        var11[var12 + 512] = var10;
                        var11[var12 + 1024] = var10;
                        var11[var12 + 1536] = var10;
                    } else if (var8 == 1) {
                        var11[var12] = var10;
                        var11[var12 + 1] = var10;
                        var11[var12 + 2] = var10;
                        var11[var12 + 3] = var10;
                    } else if (var8 == 2) {
                        var11[var12 + 3] = var10;
                        var11[var12 + 512 + 3] = var10;
                        var11[var12 + 1024 + 3] = var10;
                        var11[var12 + 1536 + 3] = var10;
                    } else if (var8 == 3) {
                        var11[var12 + 1536] = var10;
                        var11[var12 + 1536 + 1] = var10;
                        var11[var12 + 1536 + 2] = var10;
                        var11[var12 + 1536 + 3] = var10;
                    }
                }

                if (var9 == 3) {
                    if (var8 == 0) {
                        var11[var12] = var10;
                    } else if (var8 == 1) {
                        var11[var12 + 3] = var10;
                    } else if (var8 == 2) {
                        var11[var12 + 1536 + 3] = var10;
                    } else if (var8 == 3) {
                        var11[var12 + 1536] = var10;
                    }
                }

                if (var9 == 2) {
                    if (var8 == 3) {
                        var11[var12] = var10;
                        var11[var12 + 512] = var10;
                        var11[var12 + 1024] = var10;
                        var11[var12 + 1536] = var10;
                    } else if (var8 == 0) {
                        var11[var12] = var10;
                        var11[var12 + 1] = var10;
                        var11[var12 + 2] = var10;
                        var11[var12 + 3] = var10;
                    } else if (var8 == 1) {
                        var11[var12 + 3] = var10;
                        var11[var12 + 512 + 3] = var10;
                        var11[var12 + 1024 + 3] = var10;
                        var11[var12 + 1536 + 3] = var10;
                    } else if (var8 == 2) {
                        var11[var12 + 1536] = var10;
                        var11[var12 + 1536 + 1] = var10;
                        var11[var12 + 1536 + 2] = var10;
                        var11[var12 + 1536 + 3] = var10;
                    }
                }
            }
        }

        var5 = client.sceneGraph.method1461(var0, var1, var2);
        if (var5 != 0L) {
            var7 = client.sceneGraph.method1453(var0, var1, var2, var5);
            var8 = var7 >> 6 & 3;
            var9 = var7 & 31;
            var10 = EntityUID.getObjectId(var5);
            ObjectDefinition var24 = Class38.getObjectDefinition(var10);
            int var19;
            if (var24.mapSceneId != -1) {
                DoublyLinkedNode_Sub24_Sub4 var18 = Class62.mapscene[var24.mapSceneId];
                if (var18 != null) {
                    var13 = (var24.sizeX * 4 - var18.anInt378) / 2;
                    var19 = (var24.sizeY * 4 - var18.anInt377) / 2;
                    var18.method1324(var1 * 4 + var13 + 48, var19 + (104 - var2 - var24.sizeY) * 4 + 48);
                }
            } else if (var9 == 9) {
                var12 = 15658734;
                if (Class149.method857(var5)) {
                    var12 = 15597568;
                }

                int[] var23 = Node_Sub2.minimapSprite.pixels;
                var19 = var1 * 4 + (103 - var2) * 2048 + 24624;
                if (var8 != 0 && var8 != 2) {
                    var23[var19] = var12;
                    var23[var19 + 1 + 512] = var12;
                    var23[var19 + 1024 + 2] = var12;
                    var23[var19 + 1536 + 3] = var12;
                } else {
                    var23[var19 + 1536] = var12;
                    var23[var19 + 1 + 1024] = var12;
                    var23[var19 + 512 + 2] = var12;
                    var23[var19 + 3] = var12;
                }
            }
        }

        var5 = client.sceneGraph.method1457(var0, var1, var2);
        if (var5 != 0L) {
            var7 = EntityUID.getObjectId(var5);
            ObjectDefinition var20 = Class38.getObjectDefinition(var7);
            if (var20.mapSceneId != -1) {
                DoublyLinkedNode_Sub24_Sub4 var21 = Class62.mapscene[var20.mapSceneId];
                if (var21 != null) {
                    var10 = (var20.sizeX * 4 - var21.anInt378) / 2;
                    int var22 = (var20.sizeY * 4 - var21.anInt377) / 2;
                    var21.method1324(var1 * 4 + var10 + 48, (104 - var2 - var20.sizeY) * 4 + var22 + 48);
                }
            }
        }

    }

    public boolean method92(int var1, int var2) {
        return var1 >= (this.anInt279 << 6) + (this.anInt282 << 3) && var1 <= (this.anInt279 << 6) + (this.anInt282 << 3) + 7 && var2 >= (this.anInt277 << 6) + (this.anInt283 << 3) && var2 <= (this.anInt277 << 6) + (this.anInt283 << 3) + 7;
    }

    public boolean method94(int var1, int var2, int var3) {
        if (var1 >= this.anInt285 && var1 < this.anInt287 + this.anInt285) {
            return var2 >= (this.anInt281 << 6) + (this.anInt278 << 3) && var2 <= (this.anInt281 << 6) + (this.anInt278 << 3) + 7 && var3 >= (this.anInt280 << 6) + (this.anInt286 << 3) && var3 <= (this.anInt280 << 6) + (this.anInt286 << 3) + 7;
        }
        return false;
    }

    public void method93(Class9 var1) {
        if (var1.anInt134 > this.anInt279) {
            var1.anInt134 = this.anInt279;
        }

        if (var1.anInt131 < this.anInt279) {
            var1.anInt131 = this.anInt279;
        }

        if (var1.anInt138 > this.anInt277) {
            var1.anInt138 = this.anInt277;
        }

        if (var1.anInt129 < this.anInt277) {
            var1.anInt129 = this.anInt277;
        }

    }

    public SceneOffset method90(int var1, int var2) {
        if (!this.method92(var1, var2)) {
            return null;
        }
        int var3 = this.anInt281 * 64 - this.anInt279 * 64 + (this.anInt278 * 8 - this.anInt282 * 8) + var1;
        int var4 = this.anInt280 * 64 - this.anInt277 * 64 + var2 + (this.anInt286 * 8 - this.anInt283 * 8);
        return new SceneOffset(this.anInt285, var3, var4);
    }

    public int[] method91(int var1, int var2, int var3) {
        if (!this.method94(var1, var2, var3)) {
            return null;
        }
        return new int[]{this.anInt279 * 64 - this.anInt281 * 64 + var2 + (this.anInt282 * 8 - this.anInt278 * 8), var3 + (this.anInt277 * 64 - this.anInt280 * 64) + (this.anInt283 * 8 - this.anInt286 * 8)};
    }

    public void method89(Buffer var1) {
        this.anInt285 = var1.readUByte();
        this.anInt287 = var1.readUByte();
        this.anInt281 = var1.readUShort();
        this.anInt278 = var1.readUByte();
        this.anInt280 = var1.readUShort();
        this.anInt286 = var1.readUByte();
        this.anInt279 = var1.readUShort();
        this.anInt282 = var1.readUByte();
        this.anInt277 = var1.readUShort();
        this.anInt283 = var1.readUByte();
        this.method148();
    }

    void method148() {
    }
}
