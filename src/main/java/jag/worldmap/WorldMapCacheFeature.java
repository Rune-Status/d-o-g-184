package jag.worldmap;

import jag.game.type.EnumDefinition;

public class WorldMapCacheFeature {

    public static final WorldMapCacheFeature DETAILS;
    public static final WorldMapCacheFeature COMPOSITEMAP;
    public static final WorldMapCacheFeature COMPOSITETEXTURE;
    public static final WorldMapCacheFeature LABELS;

    static final WorldMapCacheFeature AREA;

    public static int anInt296;

    static {
        DETAILS = new WorldMapCacheFeature("details");
        COMPOSITEMAP = new WorldMapCacheFeature("compositemap");
        COMPOSITETEXTURE = new WorldMapCacheFeature("compositetexture");
        AREA = new WorldMapCacheFeature("area");
        LABELS = new WorldMapCacheFeature("labels");
    }

    public final String name;

    WorldMapCacheFeature(String var1) {
        this.name = var1;
    }

    public static void method178() {
        EnumDefinition.sendFullIgnoreListMessage();
    }

}
