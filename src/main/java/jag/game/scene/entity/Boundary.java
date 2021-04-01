package jag.game.scene.entity;

public final class Boundary {

    public long uid;
    public Entity entity;
    public Entity linkedEntity;
    public int config;
    public int absoluteX;
    public int absoluteY;
    public int height;
    public int orientation;
    public int linkedOrientation;

    public Boundary() {
        uid = 0L;
        config = 0;
    }
}
