package com.jagex;

import java.awt.event.*;

public class Mouse implements MouseListener, MouseMotionListener, FocusListener {
    public static volatile int idleTime;
    public static int clickMeta;
    public static int x;
    public static int y;
    public static int pressMeta;
    public static long lastMoveTime;
    public static int clickX;
    public static int clickY;
    public static long timeOfClick;
    static Mouse instance;
    static volatile int pendingPressMeta;
    static volatile int pendingX;
    static volatile int pendingClickX;
    static volatile int pendingY;
    static volatile int pendingClickY;
    static volatile long pendingMoveTime;
    static int[] mapRegions;
    static volatile long pendingTimeOfClick;
    static volatile int pendingClickMeta;

    static {
        instance = new Mouse();
        idleTime = 0;
        pendingPressMeta = 0;
        pendingX = -1;
        pendingY = -1;
        pendingMoveTime = -1L;
        pressMeta = 0;
        x = 0;
        y = 0;
        lastMoveTime = 0L;
        pendingClickMeta = 0;
        pendingClickX = 0;
        pendingClickY = 0;
        pendingTimeOfClick = 0L;
        clickMeta = 0;
        clickX = 0;
        clickY = 0;
        timeOfClick = 0L;
    }

    Mouse() {
    }

    public final synchronized void mouseMoved(MouseEvent var1) {
        if (instance != null) {
            idleTime = 0;
            pendingX = var1.getX();
            pendingY = var1.getY();
            pendingMoveTime = var1.getWhen();
        }

    }

    final int method249(MouseEvent event) {
        int button = event.getButton();
        if (!event.isAltDown() && button != 2) {
            if (!event.isMetaDown() && button != 3) {
                return 1;
            } else {
                return 2;
            }
        }
        return 4;
    }

    public final synchronized void mouseReleased(MouseEvent var1) {
        if (instance != null) {
            idleTime = 0;
            pendingPressMeta = 0;
        }

        if (var1.isPopupTrigger()) {
            var1.consume();
        }

    }

    public final void mouseClicked(MouseEvent var1) {
        if (var1.isPopupTrigger()) {
            var1.consume();
        }

    }

    public final synchronized void mouseDragged(MouseEvent var1) {
        this.mouseMoved(var1);
    }

    public final void focusGained(FocusEvent var1) {
    }

    public final synchronized void focusLost(FocusEvent var1) {
        if (instance != null) {
            pendingPressMeta = 0;
        }

    }

    public final synchronized void mouseEntered(MouseEvent var1) {
        this.mouseMoved(var1);
    }

    public final synchronized void mouseExited(MouseEvent var1) {
        if (instance != null) {
            idleTime = 0;
            pendingX = -1;
            pendingY = -1;
            pendingMoveTime = var1.getWhen();
        }

    }

    public final synchronized void mousePressed(MouseEvent var1) {
        if (instance != null) {
            idleTime = 0;
            pendingClickX = var1.getX();
            pendingClickY = var1.getY();
            pendingTimeOfClick = Class24.currentTime();
            pendingClickMeta = this.method249(var1);
            if (pendingClickMeta != 0) {
                pendingPressMeta = pendingClickMeta;
            }
        }

        if (var1.isPopupTrigger()) {
            var1.consume();
        }

    }
}
