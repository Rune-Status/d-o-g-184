package com.jagex;

public class SceneOffset {
    public int floorLevel;
    public int anInt1892;
    public int anInt1891;

    public SceneOffset(SceneOffset var1) {
        this.floorLevel = var1.floorLevel;
        this.anInt1891 = var1.anInt1891;
        this.anInt1892 = var1.anInt1892;
    }

    public SceneOffset(int var1, int var2, int var3) {
        this.floorLevel = var1;
        this.anInt1891 = var2;
        this.anInt1892 = var3;
    }

    public SceneOffset(int var1) {
        if (var1 == -1) {
            this.floorLevel = -1;
        } else {
            this.floorLevel = var1 >> 28 & 3;
            this.anInt1891 = var1 >> 14 & 16383;
            this.anInt1892 = var1 & 16383;
        }

    }

    static void method1400() {
        for (int var0 = 0; var0 < GPI.playerCount; ++var0) {
            PlayerEntity var1 = client.players[GPI.playerIndices[var0]];
            var1.method23();
        }

        Keyboard.method100();
        if (Varps.clanSystem != null) {
            Varps.clanSystem.method1392();
        }

    }

    static void method1402() {
        Class55.loginWorldSelectorOpen = false;
        Class26.aSprite308.method817(Class55.anInt479, 0);
        Statics1.aSprite324.method817(Class55.anInt479 + 382, 0);
        Class199.aDoublyNode_Sub24_Sub4_1623.method1324(Class55.anInt479 + 382 - Class199.aDoublyNode_Sub24_Sub4_1623.anInt378 / 2, 18);
    }

    String method1401() {
        return this.floorLevel + "," + (this.anInt1891 >> 6) + "," + (this.anInt1892 >> 6) + "," + (this.anInt1891 & 63) + "," + (this.anInt1892 & 63);
    }

    public int positionHash() {
        return this.floorLevel << 28 | this.anInt1891 << 14 | this.anInt1892;
    }

    boolean method1404(SceneOffset var1) {
        if (this.floorLevel != var1.floorLevel) {
            return false;
        }
        if (this.anInt1891 != var1.anInt1891) {
            return false;
        }
        return this.anInt1892 == var1.anInt1892;
    }

    public boolean equals(Object var1) {
        if (this == var1) {
            return true;
        }
        return var1 instanceof SceneOffset && this.method1404((SceneOffset) var1);
    }

    public int hashCode() {
        return this.positionHash();
    }

    public String toString() {
        return this.method1401();
    }
}
