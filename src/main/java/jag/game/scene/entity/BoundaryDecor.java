package jag.game.scene.entity;

public final class BoundaryDecor {

    public long uid;
    public Entity entity;
    public Entity linkedEntity;
    public int config;
    public int offsetX;
    public int absoluteX;
    public int absoluteY;
    public int offsetY;
    public int height;
    public int renderConfig;
    public int orientation;

    public BoundaryDecor() {
        uid = 0L;
        config = 0;
    }
}
