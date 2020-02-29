package com.jagex;

public final class BoundaryDecor {
    public long uid;
    public Entity entity;
    public Entity linkedEntity;
    int config;
    int offsetX;
    int fineX;
    int fineY;
    int offsetY;
    int height;
    int renderConfig;
    int orientation;

    BoundaryDecor() {
        this.uid = 0L;
        this.config = 0;
    }

    public static DefinitionProperty getDefinitionProperty(int var0) {
        DefinitionProperty var2 = (DefinitionProperty) DefinitionProperty.cache.get((long) var0);
        if (var2 != null) {
            return var2;
        }
        byte[] var3 = DefinitionProperty.table.unpack(11, var0);
        var2 = new DefinitionProperty();
        if (var3 != null) {
            var2.method260(new Buffer(var3));
        }

        var2.method254();
        DefinitionProperty.cache.put(var2, (long) var0);
        return var2;
    }

}
