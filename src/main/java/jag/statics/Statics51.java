package jag.statics;

import jag.audi.AudioOverrideEffect;
import jag.commons.input.Keyboard;
import jag.game.scene.entity.Pickable;
import jag.js5.ReferenceTable;
import jag.worldmap.WorldMapChunkType;

import java.awt.*;
import java.math.BigInteger;

public class Statics51 {
    public static final BigInteger aBigInteger496;
    public static final BigInteger aBigInteger497;
    public static int anInt495;

    static {
        aBigInteger496 = new BigInteger("10001", 16);
        aBigInteger497 = new BigInteger("a8cda33f9c45f0b9d1675c38ec69da6be4143320190060c229bb35ed91677a4447e09e77031e824aed13bfab51ba180bbda7e279a128f3eb016e9b0dd752a948431798626fc36ac10e036d945f2752d0d874c65a86d3e001a17bf9d63d8bc263b07be4ebc613d01781023a07de698e75248b582e682f1751395f61b9ec1bcbb3", 16);
    }

    public static void method343(Component var0) {
        var0.removeKeyListener(Keyboard.instance);
        var0.removeFocusListener(Keyboard.instance);
        Keyboard.anInt150 = -1;
    }

    public static void method344(ReferenceTable var0, int var1, int var2, int var3, boolean var4) {
        Statics57.anInt1157 = 1;
        Statics57.aReferenceTable1155 = var0;
        Statics8.anInt1122 = var1;
        Statics50.anInt327 = var2;
        Pickable.anInt379 = var3;
        WorldMapChunkType.aBoolean620 = var4;
        AudioOverrideEffect.anInt1130 = 10000;
    }
}
