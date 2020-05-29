package jag.worldmap;

import jag.BootSprites;
import jag.audi.AudioOverrideEffect;
import jag.game.World;
import jag.game.scene.entity.Pickable;
import jag.graphics.BaseFont;
import jag.graphics.IndexedSprite;
import jag.js5.ResourceCache;
import jag.js5.ReferenceTable;
import jag.opcode.Buffer;
import jag.statics.Statics50;
import jag.statics.Statics57;
import jag.statics.Statics8;

public class WorldMapTileDecor_Sub2 extends WorldMapTileDecor {

    public static ResourceCache aResourceCache649;
    public static BootSprites aBootSprites_647;
    public static IndexedSprite[] aDoublyNode_Sub24_Sub4Array648;

    WorldMapTileDecor_Sub2() {

    }

    public static int method473(CharSequence var0) {
        int var1 = var0.length();
        int var2 = 0;

        for (int var3 = 0; var3 < var1; ++var3) {
            var2 = (var2 << 5) - var2 + BaseFont.method10(var0.charAt(var3));
        }

        return var2;
    }

    public static void method471(World[] var0, int var1, int var2, int[] var3, int[] var4) {
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
        int var6 = var1.get(var2);
        int var7 = var1.method907(var6, var3);
        Statics57.anInt1157 = 1;
        Statics57.aReferenceTable1155 = var1;
        Statics8.anInt1122 = var6;
        Statics50.anInt327 = var7;
        Pickable.anInt379 = var4;
        WorldMapChunkType.aBoolean620 = var5;
        AudioOverrideEffect.anInt1130 = var0;
    }

    void method109(Buffer var1) {
        int var2 = var1.readUByte();
        if (var2 != WorldMapGroundDecorType.A_WORLD_MAP_TYPE___311.index) {
            throw new IllegalStateException("");
        }
        this.anInt515 = var1.readUByte();
        this.levelCount = var1.readUByte();
        this.anInt519 = var1.readUShort() * 4096;
        this.anInt510 = var1.readUShort() * 64;
        this.anInt517 = var1.readUShort();
        this.anInt516 = var1.readUShort();
        this.anInt514 = var1.method1051();
        this.anInt509 = var1.method1051();
    }

    void decode(Buffer buffer) {
        levelCount = Math.min(levelCount, 4);
        aShortArrayArrayArray518 = new short[1][64][64];
        aShortArrayArrayArray508 = new short[levelCount][64][64];
        aByteArrayArrayArray506 = new byte[levelCount][64][64];
        aByteArrayArrayArray505 = new byte[levelCount][64][64];
        aWorldMapDecorArrayArrayArrayArray511 = new WorldMapDecor[levelCount][64][64][];
        int var2 = buffer.readUByte();
        if (var2 != WorldMapGroundDecorType2.A_WORLD_MAP_GROUND_DECOR_TYPE_2___301.index) {
            throw new IllegalStateException("");
        }
        int var3 = buffer.readUByte();
        int var4 = buffer.readUByte();
        if (var3 == anInt517 && var4 == anInt516) {
            for (int x = 0; x < 64; ++x) {
                for (int y = 0; y < 64; ++y) {
                    decode(x, y, buffer);
                }
            }

        } else {
            throw new IllegalStateException("");
        }
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof WorldMapTileDecor_Sub2)) {
            return false;
        }
        WorldMapTileDecor_Sub2 var2 = (WorldMapTileDecor_Sub2) var1;
        return var2.anInt517 == this.anInt517 && var2.anInt516 == this.anInt516;
    }

    public int hashCode() {
        return this.anInt517 | this.anInt516 << 8;
    }
}
