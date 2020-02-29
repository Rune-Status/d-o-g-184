package com.jagex;

import java.security.SecureRandom;

public final class SpotAnimationObject extends Entity {
    static SecureRandom aSecureRandom864;
    int anInt693;
    boolean finished;
    int anInt379;
    int anInt372;
    AnimationSequence sequence;
    int floorLevel;
    int fineX;
    int fineY;
    int height;
    int anInt378;

    SpotAnimationObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        this.anInt372 = 0;
        this.anInt379 = 0;
        this.finished = false;
        this.anInt693 = var1;
        this.floorLevel = var2;
        this.fineX = var3;
        this.fineY = var4;
        this.height = var5;
        this.anInt378 = var7 + var6;
        int var8 = InterfaceNode.getGraphicDefinition(this.anInt693).animation;
        if (var8 != -1) {
            this.finished = false;
            this.sequence = Class57.getAnimationSequence(var8);
        } else {
            this.finished = true;
        }

    }

    protected final Model getModel() {
        SpotAnimation var1 = InterfaceNode.getGraphicDefinition(this.anInt693);
        Model var2;
        if (!this.finished) {
            var2 = var1.method1004(this.anInt372);
        } else {
            var2 = var1.method1004(-1);
        }

        return var2;
    }

    final void method703(int var1) {
        if (!this.finished) {
            this.anInt379 += var1;

            while (this.anInt379 > this.sequence.frameLengths[this.anInt372]) {
                this.anInt379 -= this.sequence.frameLengths[this.anInt372];
                ++this.anInt372;
                if (this.anInt372 >= this.sequence.frameIds.length) {
                    this.finished = true;
                    break;
                }
            }

        }
    }
}
