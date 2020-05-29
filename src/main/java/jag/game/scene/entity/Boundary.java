package jag.game.scene.entity;

public final class Boundary {

    public long uid;
    public Entity entity;
    public Entity linkedEntity;
    public int config;
    public int fineX;
    public int fineY;
    public int height;
    public int orientation;
    public int linkedOrientation;

    public Boundary() {
        this.uid = 0L;
        this.config = 0;
    }
}
