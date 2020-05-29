package jag.game;

import jag.commons.collection.IntegerNode;
import jag.commons.collection.IterableNodeTable;
import jag.commons.collection.LinkedList;
import jag.commons.collection.Node;
import jag.game.scene.entity.PathingEntity;
import jag.game.type.AnimationSequence;
import jag.game.type.HealthBarDefinition;
import jag.graphics.IndexedSprite;

public class HealthBar extends Node {

    public static IndexedSprite aDoublyNode_Sub24_Sub4_848;
    public final LinkedList hitsplats;
    public final HealthBarDefinition definition;

    public HealthBar(HealthBarDefinition var1) {
        this.hitsplats = new LinkedList();
        this.definition = var1;
    }

    public static int method696(IterableNodeTable var0, int var1, int var2) {
        if (var0 == null) {
            return var2;
        }
        IntegerNode var3 = (IntegerNode) var0.lookup(var1);
        return var3 == null ? var2 : var3.value;
    }

    public static String method692(int var0, boolean var1) {
        if (var1 && var0 >= 0) {
            int var2 = var0;
            String var3;
            if (var1 && var0 >= 0) {
                int var4 = 2;

                for (int var5 = var0 / 10; var5 != 0; ++var4) {
                    var5 /= 10;
                }

                char[] var6 = new char[var4];
                var6[0] = '+';

                for (int var7 = var4 - 1; var7 > 0; --var7) {
                    int var8 = var2;
                    var2 /= 10;
                    int var9 = var8 - var2 * 10;
                    if (var9 >= 10) {
                        var6[var7] = (char) (var9 + 87);
                    } else {
                        var6[var7] = (char) (var9 + 48);
                    }
                }

                var3 = new String(var6);
            } else {
                var3 = Integer.toString(var0, 10);
            }

            return var3;
        }
        return Integer.toString(var0);
    }

    public static void method694(PathingEntity var0) {
        if (var0.forceMovementEndCycle == client.engineCycle
                || var0.animation == -1
                || var0.animationDelay != 0
                || var0.animationFrameCycle + 1 > AnimationSequence.get(var0.animation).frameLengths[var0.animationFrame]) {
            int var1 = var0.forceMovementEndCycle - var0.forceMovementStartCycle;
            int var2 = client.engineCycle - var0.forceMovementStartCycle;
            int var3 = var0.boundSize + var0.anInt1354 * 128;
            int var4 = var0.boundSize + var0.anInt2011 * 128;
            int var5 = var0.boundSize + var0.anInt1351 * 128;
            int var6 = var0.boundSize + var0.anInt2016 * 128;
            var0.fineX = (var2 * var5 + var3 * (var1 - var2)) / var1;
            var0.fineY = (var6 * var2 + var4 * (var1 - var2)) / var1;
        }

        var0.anInt2022 = 0;
        var0.orientation = var0.anInt2019;
        var0.anInt1436 = var0.orientation;
    }

    public void update(int cycle, int var2, int var3, int var4) {
        HitUpdate pending = null;
        int var6 = 0;

        for (HitUpdate h = (HitUpdate) this.hitsplats.head(); h != null; h = (HitUpdate) this.hitsplats.next()) {
            ++var6;
            if (h.startCycle == cycle) {
                h.set(cycle, var2, var3, var4);
                return;
            }

            if (h.startCycle <= cycle) {
                pending = h;
            }
        }

        if (pending == null) {
            if (var6 < 4) {
                this.hitsplats.addElement(new HitUpdate(cycle, var2, var3, var4));
            }

        } else {
            LinkedList.insertBefore(new HitUpdate(cycle, var2, var3, var4), pending);
            if (var6 >= 4) {
                this.hitsplats.head().unlink();
            }

        }
    }

    public HitUpdate method695(int var1) {
        HitUpdate var2 = (HitUpdate) this.hitsplats.head();
        if (var2 != null && var2.startCycle <= var1) {
            for (HitUpdate var3 = (HitUpdate) this.hitsplats.next(); var3 != null && var3.startCycle <= var1; var3 = (HitUpdate) this.hitsplats.next()) {
                var2.unlink();
                var2 = var3;
            }

            if (this.definition.anInt367 + var2.currentCycle + var2.startCycle > var1) {
                return var2;
            }
            var2.unlink();
            return null;
        }
        return null;
    }

    public boolean method693() {
        return this.hitsplats.method662();
    }
}
