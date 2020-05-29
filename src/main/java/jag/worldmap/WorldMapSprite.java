package jag.worldmap;

import jag.*;
import jag.audi.AudioOverrideEffect;
import jag.game.client;
import jag.game.option.ClientPreferences;
import jag.game.relationship.AssociateComparator_Sub2;
import jag.game.scene.entity.Pickable;
import jag.game.stockmarket.StockMarketOfferPriceComparator;
import jag.graphics.GraphicsProvider;
import jag.graphics.IndexedSprite;
import jag.graphics.JagGraphics;
import jag.graphics.NamedFont;
import jag.js5.ReferenceTable;
import jag.opcode.AsyncOutputStream;
import jag.opcode.RegionUpdateType;
import jag.statics.*;

public final class WorldMapSprite {

    final int[] anIntArray344;

    public WorldMapSprite() {
        this.anIntArray344 = new int[4096];
    }

    public WorldMapSprite(int[] var1) {
        this.anIntArray344 = var1;
    }

    public static void method242(String var0, boolean var1) {
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

            for (int var11 = 0; var11 < client.anInt1085; ++var11) {
                if (client.interfacePositionsX[var11] + client.interfaceWidths[var11] > var7 && client.interfacePositionsX[var11] < var9 + var7 && client.interfaceHeights[var11] + client.interfacePositionsY[var11] > var8 && client.interfacePositionsY[var11] < var8 + var10) {
                    client.renderedComponents[var11] = true;
                }
            }

            if (var1) {
                WorldMapAreaChunk_Sub2.aGraphicsProvider_284.method22(0, 0);
            } else {
                for (int var15 = 0; var15 < client.anInt1085; ++var15) {
                    if (client.interfacePositionsX[var15] + client.interfaceWidths[var15] > var3 && client.interfacePositionsX[var15] < var3 + var5 && client.interfacePositionsY[var15] + client.interfaceHeights[var15] > var4 && client.interfacePositionsY[var15] < var6 + var4) {
                        client.aBooleanArray1087[var15] = true;
                    }
                }
            }

        }
    }

    public static void method245(ReferenceTable var0, ReferenceTable var1, boolean var2, int var3) {
        if (Login.aBoolean476) {
            if (var3 == 4) {
                Login.step = 4;
            }

        } else {
            Login.step = var3;
            JagGraphics.method1356();
            byte[] var4 = var0.method897("title.jpg", "");
            WorldMapGroundDecorType.aSprite308 = WorldMapRenderRules.method130(var4);
            Statics1.aSprite324 = WorldMapGroundDecorType.aSprite308.method836();
            if ((client.currentWorldMask & 536870912) != 0) {
                NamedFont.aDoublyNode_Sub24_Sub4_1623 = Area.method375(var1, "logo_deadman_mode", "");
            } else {
                NamedFont.aDoublyNode_Sub24_Sub4_1623 = Area.method375(var1, "logo", "");
            }

            Statics49.aDoublyNode_Sub24_Sub4_126 = Area.method375(var1, "titlebox", "");
            GraphicsProvider.aDoublyNode_Sub24_Sub4_1815 = Area.method375(var1, "titlebutton", "");
            Login.aDoublyNode_Sub24_Sub4Array478 = IndexedSprite.method474(var1, "runes", "");
            AssociateComparator_Sub2.aDoublyNode_Sub24_Sub4Array765 = IndexedSprite.method474(var1, "title_mute", "");
            Statics11.aDoublyNode_Sub24_Sub4_1148 = Area.method375(var1, "options_radio_buttons,0", "");
            ClientPreferences.aDoublyNode_Sub24_Sub4_363 = Area.method375(var1, "options_radio_buttons,4", "");
            WorldMapAreaChunk_Sub2.aDoublyNode_Sub24_Sub4_288 = Area.method375(var1, "options_radio_buttons,2", "");
            Login.aDoublyNode_Sub24_Sub4_470 = Area.method375(var1, "options_radio_buttons,6", "");
            Statics51.anInt495 = Statics11.aDoublyNode_Sub24_Sub4_1148.anInt378;
            WorldMapCacheFeature.anInt296 = Statics11.aDoublyNode_Sub24_Sub4_1148.anInt377;
            AsyncOutputStream.loginScreenEffect = new LoginScreenEffect(Login.aDoublyNode_Sub24_Sub4Array478);
            if (var2) {
                Login.username = "";
                Login.password = "";
            }

            RegionUpdateType.anInt1199 = 0;
            Login.totp = "";
            Login.aBoolean462 = true;
            Login.worldSelectorOpen = false;
            if (!client.preferences.loginScreenAudioDisabled) {
                WorldMapTileDecor_Sub2.method470(2, Statics15.aArchive1234, "scape main", "", 255, false);
            } else {
                Statics57.anInt1157 = 1;
                Statics57.aReferenceTable1155 = null;
                Statics8.anInt1122 = -1;
                Statics50.anInt327 = -1;
                Pickable.anInt379 = 0;
                WorldMapChunkType.aBoolean620 = false;
                AudioOverrideEffect.anInt1130 = 2;
            }

            DirectByteBufferProvider.method803(false);
            Login.aBoolean476 = true;
            Login.anInt479 = (client.canvasWidth - 765) / 2;
            Login.anInt474 = Login.anInt479 + 202;
            StockMarketOfferPriceComparator.anInt481 = Login.anInt474 + 180;
            WorldMapGroundDecorType.aSprite308.method817(Login.anInt479, 0);
            Statics1.aSprite324.method817(Login.anInt479 + 382, 0);
            NamedFont.aDoublyNode_Sub24_Sub4_1623.method1324(Login.anInt479 + 382 - NamedFont.aDoublyNode_Sub24_Sub4_1623.anInt378 / 2, 18);
        }
    }

    public static boolean method243() {
        return client.aBoolean1037;
    }

    public final int method244(int var1, int var2) {
        return this.anIntArray344[var2 * 64 + var1];
    }
}
