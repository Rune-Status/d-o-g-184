package com.jagex;

public class Class70 implements Class10 {
    static int cameraYaw;
    int anInt278;
    int anInt285;
    int anInt287;
    int anInt282;
    int anInt286;
    int anInt281;
    int anInt283;
    int anInt279;
    int anInt280;
    int anInt277;

    Class70() {
    }

    public boolean method92(int var1, int var2) {
        return var1 >> 6 >= this.anInt278 && var1 >> 6 <= this.anInt282 && var2 >> 6 >= this.anInt286 && var2 >> 6 <= this.anInt283;
    }

    public boolean method94(int var1, int var2, int var3) {
        if (var1 >= this.anInt285 && var1 < this.anInt287 + this.anInt285) {
            return var2 >> 6 >= this.anInt281 && var2 >> 6 <= this.anInt279 && var3 >> 6 >= this.anInt280 && var3 >> 6 <= this.anInt277;
        }
        return false;
    }

    public void method93(Class9 var1) {
        if (var1.anInt134 > this.anInt278) {
            var1.anInt134 = this.anInt278;
        }

        if (var1.anInt131 < this.anInt282) {
            var1.anInt131 = this.anInt282;
        }

        if (var1.anInt138 > this.anInt286) {
            var1.anInt138 = this.anInt286;
        }

        if (var1.anInt129 < this.anInt283) {
            var1.anInt129 = this.anInt283;
        }

    }

    public SceneOffset method90(int var1, int var2) {
        if (!this.method92(var1, var2)) {
            return null;
        }
        int var3 = this.anInt281 * 64 - this.anInt278 * 64 + var1;
        int var4 = this.anInt280 * 64 - this.anInt286 * 64 + var2;
        return new SceneOffset(this.anInt285, var3, var4);
    }

    public int[] method91(int var1, int var2, int var3) {
        if (!this.method94(var1, var2, var3)) {
            return null;
        }
        return new int[]{this.anInt278 * 64 - this.anInt281 * 64 + var2, var3 + (this.anInt286 * 64 - this.anInt280 * 64)};
    }

    public void method89(Buffer var1) {
        this.anInt285 = var1.readUByte();
        this.anInt287 = var1.readUByte();
        this.anInt281 = var1.readUShort();
        this.anInt280 = var1.readUShort();
        this.anInt279 = var1.readUShort();
        this.anInt277 = var1.readUShort();
        this.anInt278 = var1.readUShort();
        this.anInt286 = var1.readUShort();
        this.anInt282 = var1.readUShort();
        this.anInt283 = var1.readUShort();
        this.method148();
    }

    void method148() {
    }
}
