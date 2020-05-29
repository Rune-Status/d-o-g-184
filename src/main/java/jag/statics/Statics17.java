package jag.statics;

import jag.Varcs;
import jag.game.InterfaceComponent;
import jag.game.client;
import jag.game.option.AttackOptionPriority;
import jag.game.scene.SceneGraph;
import jag.game.stockmarket.StockMarketOfferWorldComparator;
import jag.graphics.JagGraphics3D;
import jag.graphics.Sprite;
import jag.graphics.SpriteClip;
import jag.script.ScriptEvent;
import jag.worldmap.WorldMapIcon_Sub1;

public class Statics17 {
    public static void processSelectedSpell() {
        if (client.spellSelected) {
            InterfaceComponent var0 = InterfaceComponent.lookup(AttackOptionPriority.selectedSpellComponentUid, client.selectedSpellComponentIndex);
            if (var0 != null && var0.anObjectArray1380 != null) {
                ScriptEvent var1 = new ScriptEvent();
                var1.source = var0;
                var1.args = var0.anObjectArray1380;
                ScriptEvent.fire(var1);
            }

            client.spellSelected = false;
            InterfaceComponent.repaint(var0);
        }
    }

    public static void method891(int var0, int var1, int var2, int var3, Sprite var4, SpriteClip var5) {
        if (var4 != null) {
            int var6 = client.mapRotation & 2047;
            int var7 = var3 * var3 + var2 * var2;
            if (var7 <= 6400) {
                int var8 = JagGraphics3D.SIN_TABLE[var6];
                int var9 = JagGraphics3D.COS_TABLE[var6];
                int var10 = var9 * var2 + var3 * var8 >> 16;
                int var11 = var3 * var9 - var8 * var2 >> 16;
                if (var7 > 2500) {
                    var4.method808(var10 + var5.anInt380 / 2 - var4.anInt112 / 2, var5.anInt568 / 2 - var11 - var4.anInt375 / 2, var0, var1, var5.anInt380, var5.anInt568, var5.anIntArray1108, var5.anIntArray749);
                } else {
                    var4.method809(var0 + var10 + var5.anInt380 / 2 - var4.anInt112 / 2, var5.anInt568 / 2 + var1 - var11 - var4.anInt375 / 2);
                }

            }
        }
    }

    public static int method892() {
        if (client.preferences.roofsHidden) {
            return SceneGraph.floorLevel;
        }
        int var0 = SceneGraph.getTileHeight(StockMarketOfferWorldComparator.cameraX, WorldMapIcon_Sub1.cameraY, SceneGraph.floorLevel);
        return var0 - Varcs.cameraZ < 800 && (Statics45.sceneRenderRules[SceneGraph.floorLevel][StockMarketOfferWorldComparator.cameraX >> 7][WorldMapIcon_Sub1.cameraY >> 7] & 4) != 0 ? SceneGraph.floorLevel : 3;
    }
}
