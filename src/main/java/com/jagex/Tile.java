package com.jagex;

public final class Tile extends Node {
    static CacheReferenceTable aCacheReferenceTable1152;
    EntityMarker[] markers;
    int[] anIntArray374;
    PickablePile pickablePile;
    TilePaint paint;
    BoundaryDecor boundaryDecor;
    Boundary boundary;
    TileDecor decor;
    int anInt368;
    int anInt366;
    TileModel model;
    boolean aBoolean1151;
    int floorLevel;
    int anInt696;
    int sceneX;
    int anInt380;
    int sceneY;
    Tile aTile1150;
    boolean aBoolean665;
    int anInt791;
    boolean aBoolean562;
    int anInt563;
    int anInt1149;
    int anInt575;

    Tile(int var1, int var2, int var3) {
        this.markers = new EntityMarker[5];
        this.anIntArray374 = new int[5];
        this.anInt366 = 0;
        this.anInt380 = this.floorLevel = var1;
        this.sceneX = var2;
        this.sceneY = var3;
    }
}
