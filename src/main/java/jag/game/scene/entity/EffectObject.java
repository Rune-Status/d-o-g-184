package jag.game.scene.entity;

import jag.game.type.AnimationSequence;
import jag.game.type.EffectAnimation;

public final class EffectObject extends Entity {

    public final int id;
    public final int floorLevel;
    public final int absoluteX;
    public final int absoluteY;
    public final int height;
    public final int endCycle;
    public boolean finished;
    public int anInt379;
    public int frame;
    public AnimationSequence sequence;

    public EffectObject(int id, int floorLevel, int absoluteX, int absoluteY, int height, int endCycle, int cycle) {
        frame = 0;
        anInt379 = 0;
        finished = false;
        this.id = id;
        this.floorLevel = floorLevel;
        this.absoluteX = absoluteX;
        this.absoluteY = absoluteY;
        this.height = height;
        this.endCycle = cycle + endCycle;
        int animation = EffectAnimation.get(id).animation;
        if (animation != -1) {
            finished = false;
            sequence = AnimationSequence.get(animation);
        } else {
            finished = true;
        }
    }

    protected final Model getModel() {
        EffectAnimation def = EffectAnimation.get(id);
        Model model;
        if (!finished) {
            model = def.method1004(frame);
        } else {
            model = def.method1004(-1);
        }

        return model;
    }

    public final void method703(int var1) {
        if (!finished) {
            anInt379 += var1;

            while (anInt379 > sequence.frameLengths[frame]) {
                anInt379 -= sequence.frameLengths[frame];
                ++frame;
                if (frame >= sequence.frameIds.length) {
                    finished = true;
                    break;
                }
            }

        }
    }
}
