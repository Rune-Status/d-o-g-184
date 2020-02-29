package com.jagex;

import java.util.concurrent.Callable;

public class Class42 implements Callable {
    public static ReferenceTable aReferenceTable382;

    Class42() {
    }

    static long method256(int var0, int var1, int var2) {
        return (long) (var2 << 16 | var0 << 8 | var1);
    }

    static boolean method257(Model var0, int var1, int var2, int var3) {
        boolean var4 = Statics2.aBoolean663;
        if (!var4) {
            return false;
        }
        int var5;
        int var6;
        int var7;
        int var8;
        int var11;
        int var12;
        int var13;
        int var16;
        int var17;
        if (!Statics2.aBoolean660) {
            var5 = SceneGraph.pitchSin;
            var6 = SceneGraph.pitchCos;
            var7 = SceneGraph.yawSin;
            var8 = SceneGraph.yawCos;
            byte var9 = 50;
            short var10 = 3500;
            var11 = (Statics2.anInt656 - JagGraphics3D.anInt386) * var9 / JagGraphics3D.anInt367;
            var12 = (Statics2.anInt661 - JagGraphics3D.anInt366) * var9 / JagGraphics3D.anInt367;
            var13 = (Statics2.anInt656 - JagGraphics3D.anInt386) * var10 / JagGraphics3D.anInt367;
            int var14 = (Statics2.anInt661 - JagGraphics3D.anInt366) * var10 / JagGraphics3D.anInt367;
            int var15 = JagGraphics3D.method629(var12, var9, var6, var5);
            var16 = JagGraphics3D.method621(var12, var9, var6, var5);
            var12 = var15;
            var15 = JagGraphics3D.method629(var14, var10, var6, var5);
            var17 = JagGraphics3D.method621(var14, var10, var6, var5);
            var14 = var15;
            var15 = JagGraphics3D.method623(var11, var16, var8, var7);
            var16 = JagGraphics3D.method630(var11, var16, var8, var7);
            var11 = var15;
            var15 = JagGraphics3D.method623(var13, var17, var8, var7);
            var17 = JagGraphics3D.method630(var13, var17, var8, var7);
            Statics2.anInt659 = (var15 + var11) / 2;
            Statics2.anInt657 = (var12 + var14) / 2;
            Statics2.anInt658 = (var16 + var17) / 2;
            Statics43.anInt630 = (var15 - var11) / 2;
            Statics2.anInt662 = (var14 - var12) / 2;
            Statics2.anInt655 = (var17 - var16) / 2;
            Statics22.anInt1341 = Math.abs(Statics43.anInt630);
            AssociateComparatorByWorld.anInt822 = Math.abs(Statics2.anInt662);
            DefinitionProperty.anInt386 = Math.abs(Statics2.anInt655);
        }

        var5 = var0.anInt556 + var1;
        var6 = var2 + var0.anInt579;
        var7 = var3 + var0.anInt1437;
        var8 = var0.anInt711;
        var16 = var0.anInt709;
        var17 = var0.anInt1424;
        var11 = Statics2.anInt659 - var5;
        var12 = Statics2.anInt657 - var6;
        var13 = Statics2.anInt658 - var7;
        if (Math.abs(var11) > var8 + Statics22.anInt1341) {
            return false;
        }
        if (Math.abs(var12) > var16 + AssociateComparatorByWorld.anInt822) {
            return false;
        }
        if (Math.abs(var13) > var17 + DefinitionProperty.anInt386) {
            return false;
        }
        if (Math.abs(var13 * Statics2.anInt662 - var12 * Statics2.anInt655) > var16 * DefinitionProperty.anInt386 + var17 * AssociateComparatorByWorld.anInt822) {
            return false;
        }
        if (Math.abs(var11 * Statics2.anInt655 - var13 * Statics43.anInt630) > var17 * Statics22.anInt1341 + var8 * DefinitionProperty.anInt386) {
            return false;
        }
        return Math.abs(var12 * Statics43.anInt630 - var11 * Statics2.anInt662) <= var16 * Statics22.anInt1341 + var8 * AssociateComparatorByWorld.anInt822;
    }

    public static int getKeyboardIdleTime() {
        return Keyboard.idleTime;
    }

    public Object call() {
        return ActionPrioritySetting.method226();
    }
}
