package com.jagex;

import java.util.Comparator;

final class Class76 implements Comparator {
    static AudioSystem anAudioSystem599;

    public static Sprite getItemSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
        if (var1 == -1) {
            var4 = 0;
        } else if (var4 == 2 && var1 != 1) {
            var4 = 1;
        }

        long var7 = ((long) var3 << 42) + ((long) var4 << 40) + ((long) var2 << 38) + (long) var0 + ((long) var1 << 16);
        Sprite var9;
        if (!var5) {
            var9 = (Sprite) ItemDefinition.aReferenceCache716.get(var7);
            if (var9 != null) {
                return var9;
            }
        }

        ItemDefinition var10 = CameraCapture.getItemDefinition(var0);
        if (var1 > 1 && var10.variantIds != null) {
            int var11 = -1;

            for (int var12 = 0; var12 < 10; ++var12) {
                if (var1 >= var10.variantStackSizes[var12] && var10.variantStackSizes[var12] != 0) {
                    var11 = var10.variantIds[var12];
                }
            }

            if (var11 != -1) {
                var10 = CameraCapture.getItemDefinition(var11);
            }
        }

        Model var13 = var10.getModel(1);
        if (var13 == null) {
            return null;
        }
        Sprite var14 = null;
        if (var10.noteTemplateId != -1) {
            var14 = getItemSprite(var10.noteId, 10, 1, 0, 0, true);
            if (var14 == null) {
                return null;
            }
        } else if (var10.anInt714 != -1) {
            var14 = getItemSprite(var10.anInt713, var1, var2, var3, 0, false);
            if (var14 == null) {
                return null;
            }
        } else if (var10.anInt712 != -1) {
            var14 = getItemSprite(var10.anInt715, var1, 0, 0, 0, false);
            if (var14 == null) {
                return null;
            }
        }

        int[] var15 = JagGraphics.drawingAreaPixels;
        int var16 = JagGraphics.drawingAreaWidth;
        int var17 = JagGraphics.drawingAreaHeight;
        int[] var18 = new int[4];
        JagGraphics.method1366(var18);
        var9 = new Sprite(36, 32);
        JagGraphics.setTarget(var9.pixels, 36, 32);
        JagGraphics.method1356();
        JagGraphics3D.method499();
        JagGraphics3D.method637(16, 16);
        JagGraphics3D.aBoolean789 = false;
        if (var10.anInt712 != -1) {
            var14.method809(0, 0);
        }

        int var19 = var10.spriteScale;
        if (var5) {
            var19 = (int) (1.5D * (double) var19);
        } else if (var2 == 2) {
            var19 = (int) (1.04D * (double) var19);
        }

        int var20 = var19 * JagGraphics3D.SIN_TABLE[var10.spritePitch] >> 16;
        int var21 = var19 * JagGraphics3D.COS_TABLE[var10.spritePitch] >> 16;
        var13.method827();
        var13.method1289(0, var10.spriteRoll, var10.spriteYaw, var10.spritePitch, var10.spriteTranslateX, var13.height / 2 + var20 + var10.spriteTranslateY, var21 + var10.spriteTranslateY);
        if (var10.anInt714 != -1) {
            var14.method809(0, 0);
        }

        if (var2 >= 1) {
            var9.method822(1);
        }

        if (var2 >= 2) {
            var9.method822(16777215);
        }

        if (var3 != 0) {
            var9.method835(var3);
        }

        JagGraphics.setTarget(var9.pixels, 36, 32);
        if (var10.noteTemplateId != -1) {
            var14.method809(0, 0);
        }

        if (var4 == 1 || var4 == 2 && var10.stackable == 1) {
            Class104.aFont774.method1152(Class11.method97(var1), 0, 9, 16776960, 1);
        }

        if (!var5) {
            ItemDefinition.aReferenceCache716.put(var9, var7);
        }

        JagGraphics.setTarget(var15, var16, var17);
        JagGraphics.method1373(var18);
        JagGraphics3D.method499();
        JagGraphics3D.aBoolean789 = true;
        return var9;
    }

    static void method416(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
        int var7;
        if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
            Class44.sceneRenderRules[var1][var2][var3] = 0;

            while (true) {
                var7 = var0.readUByte();
                if (var7 == 0) {
                    if (var1 == 0) {
                        Class44.tileHeights[0][var2][var3] = -Class69.method378(var2 + 932731 + var4, var5 + var3 + 556238) * 8;
                    } else {
                        Class44.tileHeights[var1][var2][var3] = Class44.tileHeights[var1 - 1][var2][var3] - 240;
                    }
                    break;
                }

                if (var7 == 1) {
                    int var8 = var0.readUByte();
                    if (var8 == 1) {
                        var8 = 0;
                    }

                    if (var1 == 0) {
                        Class44.tileHeights[0][var2][var3] = -var8 * 8;
                    } else {
                        Class44.tileHeights[var1][var2][var3] = Class44.tileHeights[var1 - 1][var2][var3] - var8 * 8;
                    }
                    break;
                }

                if (var7 <= 49) {
                    Class44.aByteArrayArrayArray401[var1][var2][var3] = var0.readByte();
                    Class12.aByteArrayArrayArray141[var1][var2][var3] = (byte) ((var7 - 2) / 4);
                    Statics35.aByteArrayArrayArray1615[var1][var2][var3] = (byte) (var7 - 2 + var6 & 3);
                } else if (var7 <= 81) {
                    Class44.sceneRenderRules[var1][var2][var3] = (byte) (var7 - 49);
                } else {
                    Class44.aByteArrayArrayArray404[var1][var2][var3] = (byte) (var7 - 81);
                }
            }
        } else {
            while (true) {
                var7 = var0.readUByte();
                if (var7 == 0) {
                    break;
                }

                if (var7 == 1) {
                    var0.readUByte();
                    break;
                }

                if (var7 <= 49) {
                    var0.readUByte();
                }
            }
        }

    }

    int method418(Class72 var1, Class72 var2) {
        return Integer.compare(var1.anInt552, var2.anInt552);
    }

    public int compare(Object var1, Object var2) {
        return this.method418((Class72) var1, (Class72) var2);
    }

    public boolean equals(Object var1) {
        return super.equals(var1);
    }
}
