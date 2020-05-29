package jag.worldmap;

import jag.game.InterfaceComponent;
import jag.game.client;
import jag.graphics.IndexedSprite;
import jag.graphics.Sprite;
import jag.js5.ReferenceTable;
import jag.statics.Statics38;

public class WorldMapIcon_Sub2 extends WorldMapIcon {
    public static IndexedSprite aDoublyNode_Sub24_Sub4_650;
    public static short[] grandExchangeSearchResults;
    final WorldMapLabel label;
    final int width;
    final int height;
    final int mapFunction;

    WorldMapIcon_Sub2(WorldMapPosition min, WorldMapPosition max, int mapFunction, WorldMapLabel label) {
        super(min, max);
        this.mapFunction = mapFunction;
        this.label = label;
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

    public WorldMapLabel getLabel() {
        return label;
    }

    public int getMapFunction() {
        return mapFunction;
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }
}
