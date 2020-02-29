package com.jagex;

public final class Class37 {
    final int[] anIntArray344;

    Class37() {
        this.anIntArray344 = new int[4096];
    }

    Class37(int[] var1) {
        this.anIntArray344 = var1;
    }

    public static int getVarpbit(int var0) {
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
        return Varps.values[var4] >> var5 & var7;
    }

    static void method242(String var0, boolean var1) {
        if (client.aBoolean1021) {
            byte var2 = 4;
            int var3 = var2 + 6;
            int var4 = var2 + 6;
            int var5 = BootSprites.font_p12full.method1144(var0, 250);
            int var6 = BootSprites.font_p12full.method1150(var0, 250) * 13;
            JagGraphics.fillRect(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0);
            JagGraphics.method1372(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6, 16777215);
            BootSprites.font_p12full.method1149(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
            int var7 = var3 - var2;
            int var8 = var4 - var2;
            int var9 = var5 + var2 + var2;
            int var10 = var2 + var6 + var2;

            int var11;
            for (var11 = 0; var11 < client.anInt1085; ++var11) {
                if (client.interfacePositionsX[var11] + client.interfaceWidths[var11] > var7 && client.interfacePositionsX[var11] < var9 + var7 && client.interfaceHeights[var11] + client.interfacePositionsY[var11] > var8 && client.interfacePositionsY[var11] < var8 + var10) {
                    client.aBooleanArray1089[var11] = true;
                }
            }

            if (var1) {
                Class20.aClass216_284.method22(0, 0);
            } else {
                var11 = var3;

                for (int var15 = 0; var15 < client.anInt1085; ++var15) {
                    if (client.interfacePositionsX[var15] + client.interfaceWidths[var15] > var11 && client.interfacePositionsX[var15] < var11 + var5 && client.interfacePositionsY[var15] + client.interfaceHeights[var15] > var4 && client.interfacePositionsY[var15] < var6 + var4) {
                        client.aBooleanArray1087[var15] = true;
                    }
                }
            }

        }
    }

    static void method245(ReferenceTable var0, ReferenceTable var1, boolean var2, int var3) {
        if (Class55.aBoolean476) {
            if (var3 == 4) {
                Class55.loginState = 4;
            }

        } else {
            Class55.loginState = var3;
            JagGraphics.method1356();
            byte[] var4 = var0.method897("title.jpg", "");
            Class26.aSprite308 = Class16.method130(var4);
            Statics1.aSprite324 = Class26.aSprite308.method836();
            if ((client.currentWorldMask & 536870912) != 0) {
                Class199.aDoublyNode_Sub24_Sub4_1623 = Class68.method375(var1, "logo_deadman_mode", "");
            } else {
                Class199.aDoublyNode_Sub24_Sub4_1623 = Class68.method375(var1, "logo", "");
            }

            Class8.aDoublyNode_Sub24_Sub4_126 = Class68.method375(var1, "titlebox", "");
            Class216.aDoublyNode_Sub24_Sub4_1815 = Class68.method375(var1, "titlebutton", "");
            Class55.aDoublyNode_Sub24_Sub4Array478 = Class27_Sub2.method474(var1, "runes", "");
            AssociateComparator_Sub2.aDoublyNode_Sub24_Sub4Array765 = Class27_Sub2.method474(var1, "title_mute", "");
            Statics11.aDoublyNode_Sub24_Sub4_1148 = Class68.method375(var1, "options_radio_buttons,0", "");
            ClientPreferences.aDoublyNode_Sub24_Sub4_363 = Class68.method375(var1, "options_radio_buttons,4", "");
            Class20.aDoublyNode_Sub24_Sub4_288 = Class68.method375(var1, "options_radio_buttons,2", "");
            Class55.aDoublyNode_Sub24_Sub4_470 = Class68.method375(var1, "options_radio_buttons,6", "");
            Class61.anInt495 = Statics11.aDoublyNode_Sub24_Sub4_1148.anInt378;
            Class23.anInt296 = Statics11.aDoublyNode_Sub24_Sub4_1148.anInt377;
            AsyncOutputStream.aClass45_105 = new Class45(Class55.aDoublyNode_Sub24_Sub4Array478);
            if (var2) {
                Class55.username = "";
                Class55.password = "";
            }

            RegionUpdateType.anInt1199 = 0;
            DefaultOperatingSystemProvider.aString1867 = "";
            Class55.aBoolean462 = true;
            Class55.loginWorldSelectorOpen = false;
            if (!client.preferences.loginScreenAudioDisabled) {
                Class63_Sub2.method470(2, Statics15.aCacheReferenceTable1234, "scape main", "", 255, false);
            } else {
                Class147.anInt1157 = 1;
                Class147.aReferenceTable1155 = null;
                Statics8.anInt1122 = -1;
                Class30.anInt327 = -1;
                PickableNode.anInt379 = 0;
                Enum_Sub2.aBoolean620 = false;
                Class139.anInt1130 = 2;
            }

            Class152_Sub1.method803(false);
            Class55.aBoolean476 = true;
            Class55.anInt479 = (client.canvasWidth - 765) / 2;
            Class55.anInt474 = Class55.anInt479 + 202;
            Class57.anInt481 = Class55.anInt474 + 180;
            Class26.aSprite308.method817(Class55.anInt479, 0);
            Statics1.aSprite324.method817(Class55.anInt479 + 382, 0);
            Class199.aDoublyNode_Sub24_Sub4_1623.method1324(Class55.anInt479 + 382 - Class199.aDoublyNode_Sub24_Sub4_1623.anInt378 / 2, 18);
        }
    }

    static boolean method243() {
        return client.aBoolean1037;
    }

    final int method244(int var1, int var2) {
        return this.anIntArray344[var2 * 64 + var1];
    }
}
