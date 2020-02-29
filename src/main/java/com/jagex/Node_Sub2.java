package com.jagex;

public final class Node_Sub2 extends Node {
    static NodeDeque aNodeDeque373;
    static int anInt371;
    static Sprite minimapSprite;

    static {
        aNodeDeque373 = new NodeDeque();
    }

    int anInt379;
    ObjectDefinition anObjectDefinition376;
    int anInt372;
    int anInt368;
    int anInt367;
    int[] anIntArray374;
    Node_Sub6_Sub2 aClass5_Sub6_Sub2_370;
    int anInt380;
    int anInt377;
    int anInt375;
    int anInt112;
    int anInt378;
    Node_Sub6_Sub2 aClass5_Sub6_Sub2_369;
    int anInt366;

    Node_Sub2() {
    }

    void method254() {
        int var1 = this.anInt379;
        ObjectDefinition var2 = this.anObjectDefinition376.method1101();
        if (var2 != null) {
            this.anInt379 = var2.ambientSoundId;
            this.anInt372 = var2.anInt1344 * 128;
            this.anInt368 = var2.anInt1508;
            this.anInt367 = var2.anInt1510;
            this.anIntArray374 = var2.anIntArray1509;
        } else {
            this.anInt379 = -1;
            this.anInt372 = 0;
            this.anInt368 = 0;
            this.anInt367 = 0;
            this.anIntArray374 = null;
        }

        if (var1 != this.anInt379 && this.aClass5_Sub6_Sub2_370 != null) {
            Class65.aClass5_Sub6_Sub1_528.method306(this.aClass5_Sub6_Sub2_370);
            this.aClass5_Sub6_Sub2_370 = null;
        }

    }
}
