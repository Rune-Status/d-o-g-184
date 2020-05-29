package jag.game.scene;

import jag.commons.collection.Node;
import jag.game.scene.entity.*;
import jag.js5.Archive;

public final class Tile extends Node {

    public static Archive aArchive1152;

    public final EntityMarker[] markers;
    public final int[] anIntArray374;
    public final int sceneX;
    public final int anInt380;
    public final int sceneY;
    public PickableStack pickableStack;
    public TilePaint paint;
    public BoundaryDecor boundaryDecor;
    public Boundary boundary;
    public TileDecor decor;
    public int anInt368;
    public int anInt366;
    public TileModel model;
    public boolean aBoolean1151;
    public int floorLevel;
    public int anInt696;
    public Tile aTile1150;
    public boolean aBoolean665;
    public int anInt791;
    public boolean aBoolean562;
    public int anInt563;
    public int anInt1149;
    public int anInt575;

    public Tile(int floorLevel, int x, int y) {
        this.markers = new EntityMarker[5];
        this.anIntArray374 = new int[5];
        this.anInt366 = 0;
        this.anInt380 = this.floorLevel = floorLevel;
        this.sceneX = x;
        this.sceneY = y;
    }
}
