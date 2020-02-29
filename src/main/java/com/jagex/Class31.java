package com.jagex;

import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public final class Class31 implements Class131, MouseWheelListener {
    int anInt328;

    Class31() {
        this.anInt328 = 0;
    }

    void method223(Component var1) {
        var1.addMouseWheelListener(this);
    }

    void method224(Component var1) {
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
