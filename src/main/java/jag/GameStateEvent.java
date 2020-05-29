package jag;

import jag.game.GameEngine;
import jag.opcode.Buffer;

public class GameStateEvent {
    final long alwaysZero2;
    final int anInt1527;
    public boolean aBoolean1525;
    long aLong1523;
    long aLong1528;
    int alwaysZero;
    int anInt1526;
    long aLong1524;
    int gameState;
    long gameStateChangeTime;

    public GameStateEvent() {
        this.aLong1528 = -1L;
        this.gameStateChangeTime = -1L;
        this.aBoolean1525 = false;
        this.aLong1524 = 0L;
        this.aLong1523 = 0L;
        this.alwaysZero2 = 0L;
        this.gameState = 0;
        this.alwaysZero = 0;
        this.anInt1526 = 0;
        this.anInt1527 = 0;
    }

    public static int nextPowerOfTwo(int src) {
        --src;
        src |= src >>> 1;
        src |= src >>> 2;
        src |= src >>> 4;
        src |= src >>> 8;
        src |= src >>> 16;
        return src + 1;
    }

    public void method1119() {
        if (this.gameStateChangeTime != -1L) {
            this.aLong1524 = GameEngine.currentTime() - this.gameStateChangeTime;
            this.gameStateChangeTime = -1L;
        }

        ++this.anInt1526;
        this.aBoolean1525 = true;
    }

    public void dropConnection() {
        if (this.aLong1528 != -1L) {
            this.aLong1523 = GameEngine.currentTime() - this.aLong1528;
            this.aLong1528 = -1L;
        }

    }

    public void updateGameState(int gameState) {
        this.gameStateChangeTime = GameEngine.currentTime();
        this.gameState = gameState;
    }

    public void updateTime() {
        this.aLong1528 = GameEngine.currentTime();
    }

    public void writeTo(Buffer buffer) {
        long var2 = this.aLong1523;
        var2 /= 10L;
        if (var2 < 0L) {
            var2 = 0L;
        } else if (var2 > 65535L) {
            var2 = 65535L;
        }

        buffer.writeShort((int) var2);
        long var4 = this.aLong1524;
        var4 /= 10L;
        if (var4 < 0L) {
            var4 = 0L;
        } else if (var4 > 65535L) {
            var4 = 65535L;
        }

        buffer.writeShort((int) var4);
        long var6 = this.alwaysZero2;
        var6 /= 10L;
        if (var6 < 0L) {
            var6 = 0L;
        } else if (var6 > 65535L) {
            var6 = 65535L;
        }

        buffer.writeShort((int) var6);
        buffer.writeShort(this.gameState);
        buffer.writeShort(this.alwaysZero);
        buffer.writeShort(this.anInt1526);
        buffer.writeShort(this.anInt1527);
    }

    public void method1118() {
        this.aBoolean1525 = false;
        this.alwaysZero = 0;
    }

    public void method1116() {
        this.method1119();
    }
}
