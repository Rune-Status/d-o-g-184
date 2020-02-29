package com.jagex;

public class SpotAnimation extends DoublyLinkedNode {
    public static ReferenceTable aReferenceTable697;
    static ReferenceCache aReferenceCache700;
    static ReferenceCache aReferenceCache701;

    static {
        aReferenceCache701 = new ReferenceCache(64);
        aReferenceCache700 = new ReferenceCache(30);
    }

    public int animation;
    int anInt574;
    int modelId;
    int scaleXY;
    int scaleZ;
    int orientation;
    int ambience;
    int contrast;
    short[] aShortArray1461;
    short[] aShortArray1460;
    short[] aShortArray1462;
    short[] aShortArray1459;

    SpotAnimation() {
        this.animation = -1;
        this.scaleXY = 128;
        this.scaleZ = 128;
        this.orientation = 0;
        this.ambience = 0;
        this.contrast = 0;
    }

    void method988(Buffer var1, int var2) {
        if (var2 == 1) {
            this.modelId = var1.readUShort();
        } else if (var2 == 2) {
            this.animation = var1.readUShort();
        } else if (var2 == 4) {
            this.scaleXY = var1.readUShort();
        } else if (var2 == 5) {
            this.scaleZ = var1.readUShort();
        } else if (var2 == 6) {
            this.orientation = var1.readUShort();
        } else if (var2 == 7) {
            this.ambience = var1.readUByte();
        } else if (var2 == 8) {
            this.contrast = var1.readUByte();
        } else {
            int var3;
            int var4;
            if (var2 == 40) {
                var3 = var1.readUByte();
                this.aShortArray1461 = new short[var3];
                this.aShortArray1462 = new short[var3];

                for (var4 = 0; var4 < var3; ++var4) {
                    this.aShortArray1461[var4] = (short) var1.readUShort();
                    this.aShortArray1462[var4] = (short) var1.readUShort();
                }
            } else if (var2 == 41) {
                var3 = var1.readUByte();
                this.aShortArray1460 = new short[var3];
                this.aShortArray1459 = new short[var3];

                for (var4 = 0; var4 < var3; ++var4) {
                    this.aShortArray1460[var4] = (short) var1.readUShort();
                    this.aShortArray1459[var4] = (short) var1.readUShort();
                }
            }
        }

    }

    public final Model method1004(int var1) {
        Model var2 = (Model) aReferenceCache700.get((long) this.anInt574);
        if (var2 == null) {
            UnlitModel var3 = UnlitModel.method982(aReferenceTable697, this.modelId, 0);
            if (var3 == null) {
                return null;
            }

            int var4;
            if (this.aShortArray1461 != null) {
                for (var4 = 0; var4 < this.aShortArray1461.length; ++var4) {
                    var3.texturize(this.aShortArray1461[var4], this.aShortArray1462[var4]);
                }
            }

            if (this.aShortArray1460 != null) {
                for (var4 = 0; var4 < this.aShortArray1460.length; ++var4) {
                    var3.colorize(this.aShortArray1460[var4], this.aShortArray1459[var4]);
                }
            }

            var2 = var3.light(this.ambience + 64, this.contrast + 850, -30, -50, -30);
            aReferenceCache700.put(var2, (long) this.anInt574);
        }

        Model var5;
        if (this.animation != -1 && var1 != -1) {
            var5 = Class57.getAnimationSequence(this.animation).method880(var2, var1);
        } else {
            var5 = var2.method1294(true);
        }

        if (this.scaleXY != 128 || this.scaleZ != 128) {
            var5.scale(this.scaleXY, this.scaleZ, this.scaleXY);
        }

        if (this.orientation != 0) {
            if (this.orientation == 90) {
                var5.method1283();
            }

            if (this.orientation == 180) {
                var5.method1283();
                var5.method1283();
            }

            if (this.orientation == 270) {
                var5.method1283();
                var5.method1283();
                var5.method1283();
            }
        }

        return var5;
    }

    void method990(Buffer var1) {
        while (true) {
            int var2 = var1.readUByte();
            if (var2 == 0) {
                return;
            }

            this.method988(var1, var2);
        }
    }
}
