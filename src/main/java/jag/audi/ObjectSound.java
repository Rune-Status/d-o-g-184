package jag.audi;

import jag.commons.collection.Node;
import jag.commons.collection.NodeDeque;
import jag.game.type.ObjectDefinition;
import jag.graphics.Sprite;
import jag.worldmap.WorldMapLabelSize;

public final class ObjectSound extends Node {
    public static final NodeDeque aNodeDeque373;
    public static int anInt371;
    public static Sprite minimapSprite;

    static {
        aNodeDeque373 = new NodeDeque();
    }

    public ObjectDefinition anObjectDefinition376;
    public PcmStream_Sub2 aClass5_Sub6_Sub2_370;
    public PcmStream_Sub2 aClass5_Sub6_Sub2_369;
    public int anInt379;
    public int anInt372;
    public int anInt368;
    public int anInt367;
    public int[] anIntArray374;
    public int anInt380;
    public int anInt377;
    public int anInt375;
    public int anInt112;
    public int anInt378;
    public int anInt366;

    public ObjectSound() {
    }

    public void method254() {
        int var1 = this.anInt379;
        ObjectDefinition var2 = this.anObjectDefinition376.transform();
        if (var2 != null) {
            this.anInt379 = var2.ambientSoundId;
            this.anInt372 = var2.anInt1344 * 128;
            this.anInt368 = var2.anInt1508;
            this.anInt367 = var2.anInt1510;
            this.anIntArray374 = var2.anIntArray1509;
        } else {
            this.anInt379 = -1;
            this.anInt372 = 0;
            this.anInt368 = 0;
            this.anInt367 = 0;
            this.anIntArray374 = null;
        }

        if (var1 != this.anInt379 && this.aClass5_Sub6_Sub2_370 != null) {
            WorldMapLabelSize.aClass5_Sub6_Sub1_528.method306(this.aClass5_Sub6_Sub2_370);
            this.aClass5_Sub6_Sub2_370 = null;
        }

    }
}
