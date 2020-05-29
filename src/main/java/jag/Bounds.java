package jag;

public class Bounds {
    public int anInt1814;
    public int anInt1811;
    public int anInt1812;
    public int anInt1813;

    public Bounds(int var1, int var2, int var3, int var4) {
        this.method1316(var1, var2);
        this.method1317(var3, var4);
    }

    public Bounds(int var1, int var2) {
        this(0, 0, var1, var2);
    }

    void method1314(Bounds var1, Bounds var2) {
        var2.anInt1813 = this.anInt1813;
        var2.anInt1812 = this.anInt1812;
        if (this.anInt1813 < var1.anInt1813) {
            var2.anInt1812 -= var1.anInt1813 - this.anInt1813;
            var2.anInt1813 = var1.anInt1813;
        }

        if (var2.method1311() > var1.method1311()) {
            var2.anInt1812 -= var2.method1311() - var1.method1311();
        }

        if (var2.anInt1812 < 0) {
            var2.anInt1812 = 0;
        }

    }

    public void method1316(int var1, int var2) {
        this.anInt1813 = var1;
        this.anInt1814 = var2;
    }

    void method1313(Bounds var1, Bounds var2) {
        var2.anInt1814 = this.anInt1814;
        var2.anInt1811 = this.anInt1811;
        if (this.anInt1814 < var1.anInt1814) {
            var2.anInt1811 -= var1.anInt1814 - this.anInt1814;
            var2.anInt1814 = var1.anInt1814;
        }

        if (var2.method1312() > var1.method1312()) {
            var2.anInt1811 -= var2.method1312() - var1.method1312();
        }

        if (var2.anInt1811 < 0) {
            var2.anInt1811 = 0;
        }

    }

    public void method1317(int var1, int var2) {
        this.anInt1812 = var1;
        this.anInt1811 = var2;
    }

    int method1312() {
        return this.anInt1811 + this.anInt1814;
    }

    int method1311() {
        return this.anInt1813 + this.anInt1812;
    }

    public void method1315(Bounds var1, Bounds var2) {
        this.method1314(var1, var2);
        this.method1313(var1, var2);
    }

    public String toString() {
        return null;
    }
}
