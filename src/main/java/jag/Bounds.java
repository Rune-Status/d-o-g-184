package jag;

public class Bounds {
    public int y;
    public int height;
    public int width;
    public int x;

    public Bounds(int var1, int var2, int var3, int var4) {
        setLocation(var1, var2);
        setSize(var3, var4);
    }

    public Bounds(int var1, int var2) {
        this(0, 0, var1, var2);
    }

    void method1314(Bounds var1, Bounds var2) {
        var2.x = x;
        var2.width = width;
        if (x < var1.x) {
            var2.width -= var1.x - x;
            var2.x = var1.x;
        }

        if (var2.getMaxX() > var1.getMaxX()) {
            var2.width -= var2.getMaxX() - var1.getMaxX();
        }

        if (var2.width < 0) {
            var2.width = 0;
        }

    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void method1313(Bounds var1, Bounds var2) {
        var2.y = y;
        var2.height = height;
        if (y < var1.y) {
            var2.height -= var1.y - y;
            var2.y = var1.y;
        }

        if (var2.getMaxY() > var1.getMaxY()) {
            var2.height -= var2.getMaxY() - var1.getMaxY();
        }

        if (var2.height < 0) {
            var2.height = 0;
        }

    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    int getMaxX() {
        return x + width;
    }

    int getMaxY() {
        return height + y;
    }

    public void method1315(Bounds var1, Bounds var2) {
        method1314(var1, var2);
        method1313(var1, var2);
    }

    public String toString() {
        return null;
    }
}
