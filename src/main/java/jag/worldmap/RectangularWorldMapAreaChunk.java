package jag.worldmap;

import jag.opcode.Buffer;

public class RectangularWorldMapAreaChunk implements WorldMapAreaChunk {

    public static int cameraYaw;

    int anInt278;
    int minLevel;
    int levelCount;
    int anInt282;
    int anInt286;
    int minX;
    int anInt283;
    int maxX;
    int minY;
    int maxY;

    RectangularWorldMapAreaChunk() {
    }

    public boolean contains(int x, int y) {
        return x >> 6 >= this.anInt278 && x >> 6 <= this.anInt282 && y >> 6 >= this.anInt286 && y >> 6 <= this.anInt283;
    }

    public boolean contains(int level, int x, int y) {
        if (level >= this.minLevel && level < this.levelCount + this.minLevel) {
            return x >> 6 >= this.minX && x >> 6 <= this.maxX
                    && y >> 6 >= this.minY && y >> 6 <= this.maxY;
        }
        return false;
    }

    public void method93(WorldMapArea var1) {
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

    public WorldMapPosition getPosition(int x, int y) {
        if (!this.contains(x, y)) {
            return null;
        }
        int var3 = this.minX * 64 - this.anInt278 * 64 + x;
        int var4 = this.minY * 64 - this.anInt286 * 64 + y;
        return new WorldMapPosition(this.minLevel, var3, var4);
    }

    public int[] outline(int level, int x, int y) {
        if (!this.contains(level, x, y)) {
            return null;
        }
        return new int[]{this.anInt278 * 64 - this.minX * 64 + x, y + (this.anInt286 * 64 - this.minY * 64)};
    }

    public void decode(Buffer buffer) {
        minLevel = buffer.readUByte();
        levelCount = buffer.readUByte();
        minX = buffer.readUShort();
        minY = buffer.readUShort();
        maxX = buffer.readUShort();
        maxY = buffer.readUShort();
        anInt278 = buffer.readUShort();
        anInt286 = buffer.readUShort();
        anInt282 = buffer.readUShort();
        anInt283 = buffer.readUShort();
        method148();
    }

    void method148() {

    }
}
