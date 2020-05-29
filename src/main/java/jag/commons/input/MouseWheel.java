package jag.commons.input;

import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public final class MouseWheel implements MouseWheelProvider, MouseWheelListener {

    public int anInt328;

    public MouseWheel() {
        this.anInt328 = 0;
    }

    public void method223(Component var1) {
        var1.addMouseWheelListener(this);
    }

    public void method224(Component var1) {
        var1.removeMouseWheelListener(this);
    }

    public synchronized int method222() {
        int var1 = this.anInt328;
        this.anInt328 = 0;
        return var1;
    }

    public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
        this.anInt328 += var1.getWheelRotation();
    }
}
