package jag.game.relationship;

public class Associate extends Chatter {

    public int rank;
    public int world;
    public int index;

    public Associate() {
        this.world = -1;
    }

    public boolean isLoggedIn() {
        return this.world > 0;
    }

    public int getWorld() {
        return this.world;
    }

    public void method873(int var1, int var2) {
        this.world = var1;
        this.index = var2;
    }
}
