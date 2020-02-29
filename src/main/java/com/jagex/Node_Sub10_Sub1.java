package com.jagex;

public class Node_Sub10_Sub1 extends Node_Sub10 {
    public byte[] aByteArray503;
    public int anInt380;
    public boolean aBoolean502;
    public int anInt378;
    int anInt377;

    Node_Sub10_Sub1(byte[] var2, int var3, int var4) {
        this.anInt380 = 22050;
        this.aByteArray503 = var2;
        this.anInt378 = var3;
        this.anInt377 = var4;
    }

    Node_Sub10_Sub1(int var1, byte[] var2, int var3, int var4, boolean var5) {
        this.anInt380 = var1;
        this.aByteArray503 = var2;
        this.anInt378 = var3;
        this.anInt377 = var4;
        this.aBoolean502 = var5;
    }

    public Node_Sub10_Sub1 method349(Class98 var1) {
        this.aByteArray503 = var1.method544(this.aByteArray503);
        this.anInt380 = var1.method546(this.anInt380);
        if (this.anInt378 == this.anInt377) {
            this.anInt378 = this.anInt377 = var1.method543(this.anInt378);
        } else {
            this.anInt378 = var1.method543(this.anInt378);
            this.anInt377 = var1.method543(this.anInt377);
            if (this.anInt378 == this.anInt377) {
                --this.anInt378;
            }
        }

        return this;
    }
}
