package jag.game.scene.entity;

public final class BoundaryDecor {

    public long uid;
    public Entity entity;
    public Entity linkedEntity;
    public int config;
    public int offsetX;
    public int fineX;
    public int fineY;
    public int offsetY;
    public int height;
    public int renderConfig;
    public int orientation;

    public BoundaryDecor() {
        this.uid = 0L;
        this.config = 0;
    }
}
