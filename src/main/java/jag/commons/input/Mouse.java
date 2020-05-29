package jag.commons.input;

import jag.game.GameEngine;

import java.awt.event.*;

public class Mouse implements MouseListener, MouseMotionListener, FocusListener {

    private static final int LEFT_MBUTTON = 1;
    private static final int MIDDLE_MBUTTON = 2;
    private static final int RIGHT_MBUTTON = 3;
    public static volatile int idleTime;
    public static int clickMeta;
    public static int x;
    public static int y;
    public static int pressMeta;
    public static long lastMoveTime;
    public static int clickX;
    public static int clickY;
    public static long timeOfClick;
    public static Mouse instance;
    public static volatile int pendingPressMeta;
    public static volatile int pendingX;
    public static volatile int pendingClickX;
    public static volatile int pendingY;
    public static volatile int pendingClickY;
    public static volatile long pendingMoveTime;
    public static int[] mapRegions;
    public static volatile long pendingTimeOfClick;
    public static volatile int pendingClickMeta;

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

    public Mouse() {
    }

    public static void destroy() {
        if (instance != null) {
            synchronized (instance) {
                instance = null;
            }
        }

    }

    public final synchronized void mouseMoved(MouseEvent var1) {
        if (instance != null) {
            idleTime = 0;
            pendingX = var1.getX();
            pendingY = var1.getY();
            pendingMoveTime = var1.getWhen();
        }

    }

    final int getClickMeta(MouseEvent event) {
        int button = event.getButton();
        if (event.isAltDown() || button == MIDDLE_MBUTTON) {
            return 4;
        }
        return !event.isMetaDown() && button != RIGHT_MBUTTON ? 1 : 2;
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
            pendingTimeOfClick = GameEngine.currentTime();
            pendingClickMeta = this.getClickMeta(var1);
            if (pendingClickMeta != 0) {
                pendingPressMeta = pendingClickMeta;
            }
        }

        if (var1.isPopupTrigger()) {
            var1.consume();
        }

    }
}
