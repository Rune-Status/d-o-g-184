package jag;

import jag.commons.time.Clock;
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
        aLong1528 = -1L;
        gameStateChangeTime = -1L;
        aBoolean1525 = false;
        aLong1524 = 0L;
        aLong1523 = 0L;
        alwaysZero2 = 0L;
        gameState = 0;
        alwaysZero = 0;
        anInt1526 = 0;
        anInt1527 = 0;
    }

    public void method1119() {
        if (gameStateChangeTime != -1L) {
            aLong1524 = Clock.now() - gameStateChangeTime;
            gameStateChangeTime = -1L;
        }

        ++anInt1526;
        aBoolean1525 = true;
    }

    public void dropConnection() {
        if (aLong1528 != -1L) {
            aLong1523 = Clock.now() - aLong1528;
            aLong1528 = -1L;
        }

    }

    public void updateGameState(int gameState) {
        gameStateChangeTime = Clock.now();
        gameState = gameState;
    }

    public void updateTime() {
        aLong1528 = Clock.now();
    }

    public void writeTo(Buffer buffer) {
        long var2 = aLong1523;
        var2 /= 10L;
        if (var2 < 0L) {
            var2 = 0L;
        } else if (var2 > 65535L) {
            var2 = 65535L;
        }

        buffer.p2((int) var2);
        long var4 = aLong1524;
        var4 /= 10L;
        if (var4 < 0L) {
            var4 = 0L;
        } else if (var4 > 65535L) {
            var4 = 65535L;
        }

        buffer.p2((int) var4);
        long var6 = alwaysZero2;
        var6 /= 10L;
        if (var6 < 0L) {
            var6 = 0L;
        } else if (var6 > 65535L) {
            var6 = 65535L;
        }

        buffer.p2((int) var6);
        buffer.p2(gameState);
        buffer.p2(alwaysZero);
        buffer.p2(anInt1526);
        buffer.p2(anInt1527);
    }

    public void method1118() {
        aBoolean1525 = false;
        alwaysZero = 0;
    }

    public void method1116() {
        method1119();
    }
}
