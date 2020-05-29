package jag.game.scene.entity;

import jag.game.InterfaceComponent;
import jag.game.type.AnimationSequence;
import jag.game.type.EffectAnimation;
import jag.statics.Statics21;

public final class Projectile extends Entity {

    public final int anInt693;
    public final int startX;
    public final int endCycle;
    public final int startY;
    public final int targetDistance;
    public final int floorLevel;
    public final int height;
    public final int startCycle;
    public final int slope;
    public final int targetIndex;
    public final int anInt112;
    public final AnimationSequence sequence;
    public boolean inMotion;
    public double fineY;
    public double speedX;
    public int anInt1659;
    public int anInt1661;
    public int yRotation;
    public double fineX;
    public double speedY;
    public double aDouble1660;
    public double heightOffset;
    public double speedZ;
    public double speed;
    public int xRotation;

    public Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
        this.inMotion = false;
        this.anInt1659 = 0;
        this.anInt1661 = 0;
        this.anInt693 = var1;
        this.floorLevel = var2;
        this.startX = var3;
        this.startY = var4;
        this.height = var5;
        this.startCycle = var6;
        this.endCycle = var7;
        this.slope = var8;
        this.targetDistance = var9;
        this.targetIndex = var10;
        this.anInt112 = var11;
        this.inMotion = false;
        int var12 = EffectAnimation.get(this.anInt693).animation;
        if (var12 != -1) {
            this.sequence = AnimationSequence.get(var12);
        } else {
            this.sequence = null;
        }

    }

    public static boolean method1192(InterfaceComponent var0) {
        if (var0.anIntArray1392 == null) {
            return false;
        }
        for (int var1 = 0; var1 < var0.anIntArray1392.length; ++var1) {
            int var2 = Statics21.method922(var0, var1);
            int var3 = var0.anIntArray1395[var1];
            if (var0.anIntArray1392[var1] == 2) {
                if (var2 >= var3) {
                    return false;
                }
            } else if (var0.anIntArray1392[var1] == 3) {
                if (var2 <= var3) {
                    return false;
                }
            } else if (var0.anIntArray1392[var1] == 4) {
                if (var2 == var3) {
                    return false;
                }
            } else if (var3 != var2) {
                return false;
            }
        }

        return true;
    }

    protected final Model getModel() {
        EffectAnimation var1 = EffectAnimation.get(this.anInt693);
        Model var2 = var1.method1004(this.anInt1659);
        if (var2 == null) {
            return null;
        }
        var2.method582(this.yRotation);
        return var2;
    }

    public final void method1193(int var1) {
        this.inMotion = true;
        this.fineY += this.speedX * (double) var1;
        this.fineX += this.speedY * (double) var1;
        this.aDouble1660 += (double) var1 * (double) var1 * 0.5D * this.heightOffset + (double) var1 * this.speedZ;
        this.speedZ += this.heightOffset * (double) var1;
        this.xRotation = (int) (Math.atan2(this.speedX, this.speedY) * 325.949D) + 1024 & 2047;
        this.yRotation = (int) (Math.atan2(this.speedZ, this.speed) * 325.949D) & 2047;
        if (this.sequence != null) {
            this.anInt1661 += var1;

            while (true) {
                do {
                    do {
                        if (this.anInt1661 <= this.sequence.frameLengths[this.anInt1659]) {
                            return;
                        }

                        this.anInt1661 -= this.sequence.frameLengths[this.anInt1659];
                        ++this.anInt1659;
                    } while (this.anInt1659 < this.sequence.frameIds.length);

                    this.anInt1659 -= this.sequence.loopOffset;
                } while (this.anInt1659 >= 0 && this.anInt1659 < this.sequence.frameIds.length);

                this.anInt1659 = 0;
            }
        }
    }

    public final void target(int var1, int var2, int var3, int var4) {
        double var5;
        if (!this.inMotion) {
            var5 = var1 - this.startX;
            double var7 = var2 - this.startY;
            double var9 = Math.sqrt(var7 * var7 + var5 * var5);
            this.fineY = (double) this.targetDistance * var5 / var9 + (double) this.startX;
            this.fineX = (double) this.targetDistance * var7 / var9 + (double) this.startY;
            this.aDouble1660 = this.height;
        }

        var5 = this.endCycle + 1 - var4;
        this.speedX = ((double) var1 - this.fineY) / var5;
        this.speedY = ((double) var2 - this.fineX) / var5;
        this.speed = Math.sqrt(this.speedX * this.speedX + this.speedY * this.speedY);
        if (!this.inMotion) {
            this.speedZ = -this.speed * Math.tan(0.02454369D * (double) this.slope);
        }

        this.heightOffset = 2.0D * ((double) var3 - this.aDouble1660 - var5 * this.speedZ) / (var5 * var5);
    }
}
