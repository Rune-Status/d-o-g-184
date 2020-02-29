package com.jagex;

public class ObjectDefinition extends DoublyLinkedNode {
    public static boolean aBoolean792;
    public static ReferenceCache aReferenceCache700;
    public static ReferenceTable aReferenceTable1515;
    public static ReferenceTable aReferenceTable697;
    public static ReferenceCache aReferenceCache1514;
    public static ReferenceCache aReferenceCache1513;
    public static ReferenceCache aReferenceCache1228;
    static UnlitModel[] anUnlitModelArray1512;

    static {
        aBoolean792 = false;
        aReferenceCache700 = new ReferenceCache(4096);
        aReferenceCache1228 = new ReferenceCache(500);
        aReferenceCache1513 = new ReferenceCache(30);
        aReferenceCache1514 = new ReferenceCache(30);
        anUnlitModelArray1512 = new UnlitModel[4];
    }

    public int mapDoorFlag;
    public int[] transformIds;
    public String name;
    public int ambientSoundId;
    public int itemSupport;
    public int anInt693;
    public int[] anIntArray1509;
    public int sizeX;
    public int anInt791;
    public int mapFunction;
    public int sizeY;
    public boolean impenetrable;
    public int anInt1344;
    public int anInt1508;
    public boolean projectileClipped;
    public String[] actions;
    public int anInt1510;
    public int animation;
    public int anInt1369;
    public boolean clipped;
    public int mapSceneId;
    public boolean aBoolean1507;
    IterableNodeTable properties;
    int varpbitIndex;
    int[] anIntArray690;
    int[] modelIds;
    int varpIndex;
    boolean rotated;
    boolean aBoolean1511;
    int clipType;
    int ambient;
    int contrast;
    boolean solid;
    int scaleX;
    int scaleZ;
    int translateX;
    short[] colors;
    short[] textures;
    short[] newColors;
    int scaleY;
    short[] newTextures;
    int translateY;
    int translateZ;

    ObjectDefinition() {
        this.name = "null";
        this.sizeX = 1;
        this.sizeY = 1;
        this.anInt791 = 2;
        this.impenetrable = true;
        this.mapDoorFlag = -1;
        this.clipType = -1;
        this.aBoolean1511 = false;
        this.projectileClipped = false;
        this.animation = -1;
        this.anInt1369 = 16;
        this.ambient = 0;
        this.contrast = 0;
        this.actions = new String[5];
        this.mapFunction = -1;
        this.mapSceneId = -1;
        this.rotated = false;
        this.clipped = true;
        this.scaleX = 128;
        this.scaleZ = 128;
        this.scaleY = 128;
        this.translateX = 0;
        this.translateY = 0;
        this.translateZ = 0;
        this.aBoolean1507 = false;
        this.solid = false;
        this.itemSupport = -1;
        this.varpbitIndex = -1;
        this.varpIndex = -1;
        this.ambientSoundId = -1;
        this.anInt1344 = 0;
        this.anInt1508 = 0;
        this.anInt1510 = 0;
    }

    public final ObjectDefinition method1101() {
        int var1 = -1;
        if (this.varpbitIndex != -1) {
            var1 = Class37.getVarpbit(this.varpbitIndex);
        } else if (this.varpIndex != -1) {
            var1 = Varps.values[this.varpIndex];
        }

        int var2;
        if (var1 >= 0 && var1 < this.transformIds.length - 1) {
            var2 = this.transformIds[var1];
        } else {
            var2 = this.transformIds[this.transformIds.length - 1];
        }

        return var2 != -1 ? Class38.getObjectDefinition(var2) : null;
    }

    void method259(Buffer var1, int var2) {
        int var3;
        int var4;
        if (var2 == 1) {
            var3 = var1.readUByte();
            if (var3 > 0) {
                if (this.anIntArray690 != null && !aBoolean792) {
                    var1.caret += 3 * var3;
                } else {
                    this.modelIds = new int[var3];
                    this.anIntArray690 = new int[var3];

                    for (var4 = 0; var4 < var3; ++var4) {
                        this.anIntArray690[var4] = var1.readUShort();
                        this.modelIds[var4] = var1.readUByte();
                    }
                }
            }
        } else if (var2 == 2) {
            this.name = var1.readString();
        } else if (var2 == 5) {
            var3 = var1.readUByte();
            if (var3 > 0) {
                if (this.anIntArray690 != null && !aBoolean792) {
                    var1.caret += var3 * 2;
                } else {
                    this.modelIds = null;
                    this.anIntArray690 = new int[var3];

                    for (var4 = 0; var4 < var3; ++var4) {
                        this.anIntArray690[var4] = var1.readUShort();
                    }
                }
            }
        } else if (var2 == 14) {
            this.sizeX = var1.readUByte();
        } else if (var2 == 15) {
            this.sizeY = var1.readUByte();
        } else if (var2 == 17) {
            this.anInt791 = 0;
            this.impenetrable = false;
        } else if (var2 == 18) {
            this.impenetrable = false;
        } else if (var2 == 19) {
            this.mapDoorFlag = var1.readUByte();
        } else if (var2 == 21) {
            this.clipType = 0;
        } else if (var2 == 22) {
            this.aBoolean1511 = true;
        } else if (var2 == 23) {
            this.projectileClipped = true;
        } else if (var2 == 24) {
            this.animation = var1.readUShort();
            if (this.animation == 65535) {
                this.animation = -1;
            }
        } else if (var2 == 27) {
            this.anInt791 = 1;
        } else if (var2 == 28) {
            this.anInt1369 = var1.readUByte();
        } else if (var2 == 29) {
            this.ambient = var1.readByte();
        } else if (var2 == 39) {
            this.contrast = var1.readByte();
        } else if (var2 >= 30 && var2 < 35) {
            this.actions[var2 - 30] = var1.readString();
            if (this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
                this.actions[var2 - 30] = null;
            }
        } else if (var2 == 40) {
            var3 = var1.readUByte();
            this.colors = new short[var3];
            this.newColors = new short[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.colors[var4] = (short) var1.readUShort();
                this.newColors[var4] = (short) var1.readUShort();
            }
        } else if (var2 == 41) {
            var3 = var1.readUByte();
            this.textures = new short[var3];
            this.newTextures = new short[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.textures[var4] = (short) var1.readUShort();
                this.newTextures[var4] = (short) var1.readUShort();
            }
        } else if (var2 == 62) {
            this.rotated = true;
        } else if (var2 == 64) {
            this.clipped = false;
        } else if (var2 == 65) {
            this.scaleX = var1.readUShort();
        } else if (var2 == 66) {
            this.scaleZ = var1.readUShort();
        } else if (var2 == 67) {
            this.scaleY = var1.readUShort();
        } else if (var2 == 68) {
            this.mapSceneId = var1.readUShort();
        } else if (var2 == 69) {
            var1.readUByte();
        } else if (var2 == 70) {
            this.translateX = var1.method1029();
        } else if (var2 == 71) {
            this.translateY = var1.method1029();
        } else if (var2 == 72) {
            this.translateZ = var1.method1029();
        } else if (var2 == 73) {
            this.aBoolean1507 = true;
        } else if (var2 == 74) {
            this.solid = true;
        } else if (var2 == 75) {
            this.itemSupport = var1.readUByte();
        } else if (var2 != 77 && var2 != 92) {
            if (var2 == 78) {
                this.ambientSoundId = var1.readUShort();
                this.anInt1344 = var1.readUByte();
            } else if (var2 == 79) {
                this.anInt1508 = var1.readUShort();
                this.anInt1510 = var1.readUShort();
                this.anInt1344 = var1.readUByte();
                var3 = var1.readUByte();
                this.anIntArray1509 = new int[var3];

                for (var4 = 0; var4 < var3; ++var4) {
                    this.anIntArray1509[var4] = var1.readUShort();
                }
            } else if (var2 == 81) {
                this.clipType = var1.readUByte() * 256;
            } else if (var2 == 82) {
                this.mapFunction = var1.readUShort();
            } else if (var2 == 249) {
                this.properties = AssociateComparator_Sub5.method676(var1, this.properties);
            }
        } else {
            this.varpbitIndex = var1.readUShort();
            if (this.varpbitIndex == 65535) {
                this.varpbitIndex = -1;
            }

            this.varpIndex = var1.readUShort();
            if (this.varpIndex == 65535) {
                this.varpIndex = -1;
            }

            var3 = -1;
            if (var2 == 92) {
                var3 = var1.readUShort();
                if (var3 == 65535) {
                    var3 = -1;
                }
            }

            var4 = var1.readUByte();
            this.transformIds = new int[var4 + 2];

            for (int var5 = 0; var5 <= var4; ++var5) {
                this.transformIds[var5] = var1.readUShort();
                if (this.transformIds[var5] == 65535) {
                    this.transformIds[var5] = -1;
                }
            }

            this.transformIds[var4 + 1] = var3;
        }

    }

    final UnlitModel method1102(int var1, int var2) {
        UnlitModel var3 = null;
        boolean var4;
        int var5;
        int var7;
        if (this.modelIds == null) {
            if (var1 != 10) {
                return null;
            }

            if (this.anIntArray690 == null) {
                return null;
            }

            var4 = this.rotated;
            if (var1 == 2 && var2 > 3) {
                var4 = !var4;
            }

            var5 = this.anIntArray690.length;

            for (int var6 = 0; var6 < var5; ++var6) {
                var7 = this.anIntArray690[var6];
                if (var4) {
                    var7 += 65536;
                }

                var3 = (UnlitModel) aReferenceCache1228.get((long) var7);
                if (var3 == null) {
                    var3 = UnlitModel.method982(aReferenceTable1515, var7 & 65535, 0);
                    if (var3 == null) {
                        return null;
                    }

                    if (var4) {
                        var3.method981();
                    }

                    aReferenceCache1228.put(var3, (long) var7);
                }

                if (var5 > 1) {
                    anUnlitModelArray1512[var6] = var3;
                }
            }

            if (var5 > 1) {
                var3 = new UnlitModel(anUnlitModelArray1512, var5);
            }
        } else {
            int var9 = -1;

            for (var5 = 0; var5 < this.modelIds.length; ++var5) {
                if (this.modelIds[var5] == var1) {
                    var9 = var5;
                    break;
                }
            }

            if (var9 == -1) {
                return null;
            }

            var5 = this.anIntArray690[var9];
            boolean var10 = this.rotated ^ var2 > 3;
            if (var10) {
                var5 += 65536;
            }

            var3 = (UnlitModel) aReferenceCache1228.get((long) var5);
            if (var3 == null) {
                var3 = UnlitModel.method982(aReferenceTable1515, var5 & 65535, 0);
                if (var3 == null) {
                    return null;
                }

                if (var10) {
                    var3.method981();
                }

                aReferenceCache1228.put(var3, (long) var5);
            }
        }

        var4 = this.scaleX != 128 || this.scaleZ != 128 || this.scaleY != 128;

        boolean var11;
        var11 = this.translateX != 0 || this.translateY != 0 || this.translateZ != 0;

        UnlitModel var8 = new UnlitModel(var3, var2 == 0 && !var4 && !var11, this.colors == null, null == this.textures);
        if (var1 == 4 && var2 > 3) {
            var8.method302(256);
            var8.method976(45, 0, -45);
        }

        var2 &= 3;
        if (var2 == 1) {
            var8.method886();
        } else if (var2 == 2) {
            var8.method972();
        } else if (var2 == 3) {
            var8.method969();
        }

        if (this.colors != null) {
            for (var7 = 0; var7 < this.colors.length; ++var7) {
                var8.texturize(this.colors[var7], this.newColors[var7]);
            }
        }

        if (this.textures != null) {
            for (var7 = 0; var7 < this.textures.length; ++var7) {
                var8.colorize(this.textures[var7], this.newTextures[var7]);
            }
        }

        if (var4) {
            var8.method764(this.scaleX, this.scaleZ, this.scaleY);
        }

        if (var11) {
            var8.method976(this.translateX, this.translateY, this.translateZ);
        }

        return var8;
    }

    void method254() {
        if (this.mapDoorFlag == -1) {
            this.mapDoorFlag = 0;
            if (this.anIntArray690 != null && (this.modelIds == null || this.modelIds[0] == 10)) {
                this.mapDoorFlag = 1;
            }

            for (int var1 = 0; var1 < 5; ++var1) {
                if (this.actions[var1] != null) {
                    this.mapDoorFlag = 1;
                }
            }
        }

        if (this.itemSupport == -1) {
            this.itemSupport = this.anInt791 != 0 ? 1 : 0;
        }

    }

    void method260(Buffer var1) {
        while (true) {
            int var2 = var1.readUByte();
            if (var2 == 0) {
                return;
            }

            this.method259(var1, var2);
        }
    }

    public final Model method1107(int var1, int var2, int[][] var3, int var4, int var5, int var6, AnimationSequence var7, int var8) {
        long var9;
        if (this.modelIds == null) {
            var9 = (long) (var2 + (this.anInt693 << 10));
        } else {
            var9 = (long) (var2 + (var1 << 3) + (this.anInt693 << 10));
        }

        Model var11 = (Model) aReferenceCache1514.get(var9);
        if (var11 == null) {
            UnlitModel var12 = this.method1102(var1, var2);
            if (var12 == null) {
                return null;
            }

            var11 = var12.light(this.ambient + 64, this.contrast * 25 + 768, -50, -10, -50);
            aReferenceCache1514.put(var11, var9);
        }

        if (var7 == null && this.clipType * 65536 == -1) {
            return var11;
        }
        if (var7 != null) {
            var11 = var7.method877(var11, var8, var2);
        } else {
            var11 = var11.method1291(true);
        }

        if (this.clipType * 65536 >= 0) {
            var11 = var11.method1295(var3, var4, var5, var6, false, this.clipType * 65536);
        }

        return var11;
    }

    public final Model method1103(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
        long var7;
        if (this.modelIds == null) {
            var7 = (long) (var2 + (this.anInt693 << 10));
        } else {
            var7 = (long) (var2 + (var1 << 3) + (this.anInt693 << 10));
        }

        Model var9 = (Model) aReferenceCache1514.get(var7);
        if (var9 == null) {
            UnlitModel var10 = this.method1102(var1, var2);
            if (var10 == null) {
                return null;
            }

            var9 = var10.light(this.ambient + 64, this.contrast * 25 + 768, -50, -10, -50);
            aReferenceCache1514.put(var9, var7);
        }

        if (this.clipType * 65536 >= 0) {
            var9 = var9.method1295(var3, var4, var5, var6, true, this.clipType * 65536);
        }

        return var9;
    }

    public final boolean method882() {
        if (this.anIntArray690 == null) {
            return true;
        }
        boolean var1 = true;

        for (int anAnIntArray690 : this.anIntArray690) {
            var1 &= aReferenceTable1515.method913(anAnIntArray690 & 65535, 0);
        }

        return var1;
    }

    public final boolean method1106(int var1) {
        if (this.modelIds != null) {
            for (int var4 = 0; var4 < this.modelIds.length; ++var4) {
                if (this.modelIds[var4] == var1) {
                    return aReferenceTable1515.method913(this.anIntArray690[var4] & 65535, 0);
                }
            }

            return true;
        }
        if (this.anIntArray690 == null) {
            return true;
        }
        if (var1 != 10) {
            return true;
        }
        boolean var2 = true;

        for (int anAnIntArray690 : this.anIntArray690) {
            var2 &= aReferenceTable1515.method913(anAnIntArray690 & 65535, 0);
        }

        return var2;
    }

    public int method1100(int var1, int var2) {
        return HealthBar.method696(this.properties, var1, var2);
    }

    public String method1104(int var1, String var2) {
        return IterableNodeTable.getStringParameter(this.properties, var1, var2);
    }

    public boolean method1099() {
        if (this.transformIds == null) {
            return this.ambientSoundId != -1 || this.anIntArray1509 != null;
        }
        for (int transformId : this.transformIds) {
            if (transformId != -1) {
                ObjectDefinition var2 = Class38.getObjectDefinition(transformId);
                if (var2.ambientSoundId != -1 || var2.anIntArray1509 != null) {
                    return true;
                }
            }
        }

        return false;
    }

    public final Entity method1105(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
        long var7;
        if (this.modelIds == null) {
            var7 = (long) (var2 + (this.anInt693 << 10));
        } else {
            var7 = (long) (var2 + (var1 << 3) + (this.anInt693 << 10));
        }

        DoublyLinkedNode var9 = aReferenceCache1513.get(var7);
        if (var9 == null) {
            UnlitModel var10 = this.method1102(var1, var2);
            if (var10 == null) {
                return null;
            }

            if (!this.aBoolean1511) {
                var9 = var10.light(this.ambient + 64, this.contrast * 25 + 768, -50, -10, -50);
            } else {
                var10.aShort1441 = (short) (this.ambient + 64);
                var10.aShort1439 = (short) (this.contrast * 25 + 768);
                var10.method593();
                var9 = var10;
            }

            aReferenceCache1513.put(var9, var7);
        }

        if (this.aBoolean1511) {
            var9 = ((UnlitModel) var9).method978();
        }

        if (this.clipType * 65536 >= 0) {
            if (var9 instanceof Model) {
                var9 = ((Model) var9).method1295(var3, var4, var5, var6, true, this.clipType * 65536);
            } else if (var9 instanceof UnlitModel) {
                var9 = ((UnlitModel) var9).method977(var3, var4, var5, var6, this.clipType * 65536);
            }
        }

        return (Entity) var9;
    }
}
