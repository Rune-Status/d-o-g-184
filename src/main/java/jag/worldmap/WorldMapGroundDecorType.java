package jag.worldmap;

import jag.graphics.Sprite;

public class WorldMapGroundDecorType {

    public static final WorldMapGroundDecorType A_WORLD_MAP_TYPE___311;
    public static final WorldMapGroundDecorType A_WORLD_MAP_TYPE___312;

    public static int anInt310;

    static {
        A_WORLD_MAP_TYPE___311 = new WorldMapGroundDecorType(0);
        A_WORLD_MAP_TYPE___312 = new WorldMapGroundDecorType(1);
    }

    public final int index;

    WorldMapGroundDecorType(int index) {
        this.index = index;
    }
}
