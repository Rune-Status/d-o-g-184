package com.jagex;

public class BootSprites {
    static Font font_p12full;
    public int anInt1656;
    public int anInt1658;
    public int anInt1653;
    public int anInt1652;
    public int anInt1650;
    public int anInt1648;
    public int anInt1649;
    public int anInt1657;
    public int anInt1654;
    public int anInt1655;
    public int anInt1651;

    public BootSprites() {
        this.anInt1656 = -1;
        this.anInt1658 = -1;
        this.anInt1653 = -1;
        this.anInt1652 = -1;
        this.anInt1650 = -1;
        this.anInt1648 = -1;
        this.anInt1649 = -1;
        this.anInt1657 = -1;
        this.anInt1654 = -1;
        this.anInt1655 = -1;
        this.anInt1651 = -1;
    }

    public void method1190(ReferenceTable var1) {
        byte[] var2 = var1.method904(Class200.aClass200_1627.anInt1628);
        Buffer var3 = new Buffer(var2);

        while (true) {
            int var4 = var3.readUByte();
            if (var4 == 0) {
                return;
            }

            switch (var4) {
                case 1:
                    var3.readMediumInt();
                    break;
                case 2:
                    this.anInt1656 = var3.method1051();
                    this.anInt1658 = var3.method1051();
                    this.anInt1653 = var3.method1051();
                    this.anInt1652 = var3.method1051();
                    this.anInt1650 = var3.method1051();
                    this.anInt1648 = var3.method1051();
                    this.anInt1649 = var3.method1051();
                    this.anInt1657 = var3.method1051();
                    this.anInt1654 = var3.method1051();
                    this.anInt1655 = var3.method1051();
                    this.anInt1651 = var3.method1051();
            }
        }
    }
}
