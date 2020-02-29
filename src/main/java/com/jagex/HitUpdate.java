package com.jagex;

public class HitUpdate extends Node {

    public static String aString407;

    int startCycle;
    int startWidth;
    int currentWidth;
    int currentCycle;

    HitUpdate(int var1, int var2, int var3, int var4) {
        this.startCycle = var1;
        this.startWidth = var2;
        this.currentWidth = var3;
        this.currentCycle = var4;
    }

    static Chatline method270(int var0, int var1) {
        Chatstream var2 = (Chatstream) Class64.chatstreams.get(var0);
        return var2.method515(var1);
    }

    void method271(int var1, int var2, int var3, int var4) {
        this.startCycle = var1;
        this.startWidth = var2;
        this.currentWidth = var3;
        this.currentCycle = var4;
    }
}
