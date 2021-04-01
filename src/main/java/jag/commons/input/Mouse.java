package jag.commons.input;

import jag.commons.time.Clock;

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

    public static int getAndIncrementIdleTime() {
        return ++idleTime - 1;
    }

    public static void process() {
        synchronized (instance) {
            pressMeta = pendingPressMeta;
            x = pendingX;
            y = pendingY;
            lastMoveTime = pendingMoveTime;
            clickMeta = pendingClickMeta;
            clickX = pendingClickX;
            clickY = pendingClickY;
            timeOfClick = pendingTimeOfClick;
            pendingClickMeta = 0;
        }
    }

    public final synchronized void mouseMoved(MouseEvent e) {
        if (instance != null) {
            idleTime = 0;
            pendingX = e.getX();
            pendingY = e.getY();
            pendingMoveTime = e.getWhen();
        }
    }

    final int getClickMeta(MouseEvent event) {
        int button = event.getButton();
        if (event.isAltDown() || button == MIDDLE_MBUTTON) {
            return 4;
        }
        return !event.isMetaDown() && button != RIGHT_MBUTTON ? 1 : 2;
    }

    public final synchronized void mouseReleased(MouseEvent e) {
        if (instance != null) {
            idleTime = 0;
            pendingPressMeta = 0;
        }

        if (e.isPopupTrigger()) {
            e.consume();
        }
    }

    public final void mouseClicked(MouseEvent e) {
        if (e.isPopupTrigger()) {
            e.consume();
        }
    }

    public final synchronized void mouseDragged(MouseEvent e) {
        mouseMoved(e);
    }

    public final void focusGained(FocusEvent e) {

    }

    public final synchronized void focusLost(FocusEvent e) {
        if (instance != null) {
            pendingPressMeta = 0;
        }
    }

    public final synchronized void mouseEntered(MouseEvent e) {
        mouseMoved(e);
    }

    public final synchronized void mouseExited(MouseEvent e) {
        if (instance != null) {
            idleTime = 0;
            pendingX = -1;
            pendingY = -1;
            pendingMoveTime = e.getWhen();
        }
    }

    public final synchronized void mousePressed(MouseEvent e) {
        if (instance != null) {
            idleTime = 0;
            pendingClickX = e.getX();
            pendingClickY = e.getY();
            pendingTimeOfClick = Clock.now();
            pendingClickMeta = getClickMeta(e);
            if (pendingClickMeta != 0) {
                pendingPressMeta = pendingClickMeta;
            }
        }

        if (e.isPopupTrigger()) {
            e.consume();
        }
    }
}
