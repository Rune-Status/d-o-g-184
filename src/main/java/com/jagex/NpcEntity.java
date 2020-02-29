package com.jagex;

public final class NpcEntity extends PathingEntity {
    static int anInt823;
    NpcDefinition definition;

    NpcEntity() {
    }

    static void method681(String var0, int var1) {
        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta28, client.connectionContext.encryptor);
        packet.buffer.writeByte(Statics30.stringLengthPlusOne(var0) + 1);
        packet.buffer.writeByte(var1);
        packet.buffer.writeCString(var0);
        client.connectionContext.writeLater(packet);
    }

    protected final Model getModel() {
        if (this.definition == null) {
            return null;
        }
        AnimationSequence anim = super.animation != -1 && super.animationDelay == 0 ? Class57.getAnimationSequence(super.animation) : null;
        AnimationSequence stance = super.stance != -1 && (super.stance != super.walkingStance || anim == null) ? Class57.getAnimationSequence(super.stance) : null;
        Model var3 = this.definition.getModel(anim, super.animationFrame, stance, super.stanceFrame);
        if (var3 == null) {
            return null;
        }
        var3.method827();
        super.anInt2021 = var3.height;
        if (super.graphic != -1 && super.anInt2017 != -1) {
            Model var4 = InterfaceNode.getGraphicDefinition(super.graphic).method1004(super.anInt2017);
            if (var4 != null) {
                var4.method832(0, -super.anInt2014, 0);
                Model[] var5 = new Model[]{var3, var4};
                var3 = new Model(var5, 2);
            }
        }

        if (this.definition.size == 1) {
            var3.aabbEnabled = true;
        }

        return var3;
    }

    final void method682(int var1, byte var2) {
        int var3 = super.pathXQueue[0];
        int var4 = super.pathYQueue[0];
        if (var1 == 0) {
            --var3;
            ++var4;
        }

        if (var1 == 1) {
            ++var4;
        }

        if (var1 == 2) {
            ++var3;
            ++var4;
        }

        if (var1 == 3) {
            --var3;
        }

        if (var1 == 4) {
            ++var3;
        }

        if (var1 == 5) {
            --var3;
            --var4;
        }

        if (var1 == 6) {
            --var4;
        }

        if (var1 == 7) {
            ++var3;
            --var4;
        }

        if (super.animation != -1 && Class57.getAnimationSequence(super.animation).walkingPrecedence == 1) {
            super.animation = -1;
        }

        if (super.pathQueueSize < 9) {
            ++super.pathQueueSize;
        }

        for (int var5 = super.pathQueueSize; var5 > 0; --var5) {
            super.pathXQueue[var5] = super.pathXQueue[var5 - 1];
            super.pathYQueue[var5] = super.pathYQueue[var5 - 1];
            super.pathQueueTraversed[var5] = super.pathQueueTraversed[var5 - 1];
        }

        super.pathXQueue[0] = var3;
        super.pathYQueue[0] = var4;
        super.pathQueueTraversed[0] = var2;
    }

    final void method683(int var1, int var2, boolean var3) {
        if (super.animation != -1 && Class57.getAnimationSequence(super.animation).walkingPrecedence == 1) {
            super.animation = -1;
        }

        if (!var3) {
            int var4 = var1 - super.pathXQueue[0];
            int var5 = var2 - super.pathYQueue[0];
            if (var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
                if (super.pathQueueSize < 9) {
                    ++super.pathQueueSize;
                }

                for (int var6 = super.pathQueueSize; var6 > 0; --var6) {
                    super.pathXQueue[var6] = super.pathXQueue[var6 - 1];
                    super.pathYQueue[var6] = super.pathYQueue[var6 - 1];
                    super.pathQueueTraversed[var6] = super.pathQueueTraversed[var6 - 1];
                }

                super.pathXQueue[0] = var1;
                super.pathYQueue[0] = var2;
                super.pathQueueTraversed[0] = 1;
                return;
            }
        }

        super.pathQueueSize = 0;
        super.anInt2023 = 0;
        super.anInt2022 = 0;
        super.pathXQueue[0] = var1;
        super.pathYQueue[0] = var2;
        super.fineX = super.pathXQueue[0] * 128 + super.boundSize;
        super.fineY = super.pathYQueue[0] * 128 + super.boundSize;
    }

    final boolean method684() {
        return this.definition != null;
    }
}
