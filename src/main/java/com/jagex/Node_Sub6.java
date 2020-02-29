package com.jagex;

public abstract class Node_Sub6 extends Node {
    volatile boolean aBoolean665;
    Node_Sub10 aNode_Sub10_667;
    Node_Sub6 aNode_Sub6_664;
    int anInt666;

    protected Node_Sub6() {
        this.aBoolean665 = true;
    }

    protected abstract void method311(int[] var1, int var2, int var3);

    protected abstract void method303(int var1);

    final void method482(int[] var1, int var2, int var3) {
        if (this.aBoolean665) {
            this.method311(var1, var2, var3);
        } else {
            this.method303(var3);
        }

    }

    protected abstract Node_Sub6 method308();

    protected abstract Node_Sub6 method307();

    int method483() {
        return 255;
    }

    protected abstract int method305();
}
