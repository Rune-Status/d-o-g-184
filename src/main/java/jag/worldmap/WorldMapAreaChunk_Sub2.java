package jag.worldmap;

import jag.graphics.GraphicsProvider;
import jag.graphics.IndexedSprite;
import jag.opcode.Buffer;
import jag.script.RuneScript;

public class WorldMapAreaChunk_Sub2 implements WorldMapAreaChunk {
    public static GraphicsProvider aGraphicsProvider_284;
    public static IndexedSprite aDoublyNode_Sub24_Sub4_288;
    int anInt285;
    int anInt282;
    int anInt279;
    int anInt287;
    int anInt281;
    int anInt278;
    int anInt283;
    int anInt277;
    int anInt280;
    int anInt286;

    WorldMapAreaChunk_Sub2() {
    }

    public static RuneScript method151(int var0, int var1, int var2) {
        int var3 = (var1 << 8) + var0;
        RuneScript var5 = RuneScript.method239(var3);
        if (var5 != null) {
            return var5;
        }
        int var6 = (var2 + 40000 << 8) + var0;
        var5 = RuneScript.method239(var6);
        return var5;
    }

    public boolean contains(int x, int y) {
        return x >= (this.anInt279 << 6) + (this.anInt282 << 3) && x <= (this.anInt279 << 6) + (this.anInt282 << 3) + 7 && y >= (this.anInt277 << 6) + (this.anInt283 << 3) && y <= (this.anInt277 << 6) + (this.anInt283 << 3) + 7;
    }

    public boolean contains(int level, int x, int y) {
        if (level >= this.anInt285 && level < this.anInt287 + this.anInt285) {
            return x >= (this.anInt281 << 6) + (this.anInt278 << 3) && x <= (this.anInt281 << 6) + (this.anInt278 << 3) + 7 && y >= (this.anInt280 << 6) + (this.anInt286 << 3) && y <= (this.anInt280 << 6) + (this.anInt286 << 3) + 7;
        }
        return false;
    }

    public void method93(WorldMapArea var1) {
        if (var1.anInt134 > this.anInt279) {
            var1.anInt134 = this.anInt279;
        }

        if (var1.anInt131 < this.anInt279) {
            var1.anInt131 = this.anInt279;
        }

        if (var1.anInt138 > this.anInt277) {
            var1.anInt138 = this.anInt277;
        }

        if (var1.anInt129 < this.anInt277) {
            var1.anInt129 = this.anInt277;
        }

    }

    public WorldMapPosition getPosition(int x, int y) {
        if (!this.contains(x, y)) {
            return null;
        }
        int var3 = this.anInt281 * 64 - this.anInt279 * 64 + (this.anInt278 * 8 - this.anInt282 * 8) + x;
        int var4 = this.anInt280 * 64 - this.anInt277 * 64 + y + (this.anInt286 * 8 - this.anInt283 * 8);
        return new WorldMapPosition(this.anInt285, var3, var4);
    }

    public int[] outline(int level, int x, int y) {
        if (!this.contains(level, x, y)) {
            return null;
        }
        return new int[]{this.anInt279 * 64 - this.anInt281 * 64 + x + (this.anInt282 * 8 - this.anInt278 * 8), y + (this.anInt277 * 64 - this.anInt280 * 64) + (this.anInt283 * 8 - this.anInt286 * 8)};
    }

    public void decode(Buffer buffer) {
        anInt285 = buffer.readUByte();
        anInt287 = buffer.readUByte();
        anInt281 = buffer.readUShort();
        anInt278 = buffer.readUByte();
        anInt280 = buffer.readUShort();
        anInt286 = buffer.readUByte();
        anInt279 = buffer.readUShort();
        anInt282 = buffer.readUByte();
        anInt277 = buffer.readUShort();
        anInt283 = buffer.readUByte();
        method148();
    }

    void method148() {

    }
}
