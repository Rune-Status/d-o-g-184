package com.jagex;

public final class Boundary {
    static CacheReferenceTable aCacheReferenceTable1876;
    public long uid;
    public Entity entity;
    public Entity linkedEntity;
    int config;
    int fineX;
    int fineY;
    int height;
    int orientation;
    int linkedOrientation;

    Boundary() {
        this.uid = 0L;
        this.config = 0;
    }

    static boolean method1377(char var0) {
        return var0 == 160 || var0 == ' ' || var0 == '_' || var0 == '-';
    }
}
