package jag.worldmap;

import jag.game.type.*;
import jag.graphics.Sprite;

public class WorldMapIcon_Sub1 extends WorldMapIcon {
    public static boolean aBoolean492;
    public static int cameraY;
    public static byte[][] aByteArrayArray493;
    public final int objectId;
    public final WorldMapChunkDefinition definition;
    public int height;
    public int width;
    public WorldMapLabel label;
    public int mapFunction;

    public WorldMapIcon_Sub1(WorldMapPosition min, WorldMapPosition max, int objectId, WorldMapChunkDefinition definition) {
        super(min, max);
        this.objectId = objectId;
        this.definition = definition;
        initialize();
    }

    public WorldMapLabel getLabel() {
        return this.label;
    }

    public int getMapFunction() {
        return mapFunction;
    }

    public void initialize() {
        this.mapFunction = ObjectDefinition.get(objectId).transform().mapFunction;
        this.label = definition.createLabel(WorldMapFunction.get(mapFunction));

        WorldMapFunction function = WorldMapFunction.get(getMapFunction());
        Sprite sprite = function.getSprite();
        if (sprite != null) {
            width = sprite.width;
            height = sprite.height;
        } else {
            width = 0;
            height = 0;
        }
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }
}
