package com.jagex;

public class Statics17 {
    static void processSelectedSpell() {
        if (client.spellSelected) {
            InterfaceComponent var0 = InterfaceComponent.lookup(ActionPrioritySetting.selectedSpellComponentUid, client.selectedSpellComponentIndex);
            if (var0 != null && var0.anObjectArray1380 != null) {
                ScriptEvent var1 = new ScriptEvent();
                var1.source = var0;
                var1.args = var0.anObjectArray1380;
                DefinitionProperty.fireScriptEvent(var1);
            }

            client.spellSelected = false;
            Enum_Sub2.repaintComponent(var0);
        }
    }

    static void method891(int var0, int var1, int var2, int var3, Sprite var4, DoublyLinkedNode_Sub10 var5) {
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

    static int method892() {
        if (client.preferences.roofsHidden) {
            return SceneGraph.floorLevel;
        }
        int var0 = SceneGraph.getTileHeight(Class38.cameraX, Class27_Sub1.cameraY, SceneGraph.floorLevel);
        return var0 - Class79.cameraZ < 800 && (Class44.sceneRenderRules[SceneGraph.floorLevel][Class38.cameraX >> 7][Class27_Sub1.cameraY >> 7] & 4) != 0 ? SceneGraph.floorLevel : 3;
    }
}
