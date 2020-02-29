package com.jagex;

public class DynamicObject extends Entity {
    AnimationSequence sequence;
    int anInt693;
    int anInt379;
    int type;
    int orientation;
    int floorLevel;
    int anInt372;
    int sceneX;
    int sceneY;

    DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Entity var9) {
        this.anInt693 = var1;
        this.type = var2;
        this.orientation = var3;
        this.floorLevel = var4;
        this.sceneX = var5;
        this.sceneY = var6;
        if (var7 != -1) {
            this.sequence = Class57.getAnimationSequence(var7);
            this.anInt372 = 0;
            this.anInt379 = client.engineCycle - 1;
            if (this.sequence.replayMode == 0 && var9 instanceof DynamicObject) {
                DynamicObject var10 = (DynamicObject) var9;
                if (var10.sequence == this.sequence) {
                    this.anInt372 = var10.anInt372;
                    this.anInt379 = var10.anInt379;
                    return;
                }
            }

            if (var8 && this.sequence.loopOffset != -1) {
                this.anInt372 = (int) (Math.random() * (double) this.sequence.frameIds.length);
                this.anInt379 -= (int) (Math.random() * (double) this.sequence.frameLengths[this.anInt372]);
            }
        }

    }

    static void method1506() {
        client.connectionContext.stop();
        Class27_Sub1.method342();
        client.sceneGraph.method1486();

        for (int var0 = 0; var0 < 4; ++var0) {
            client.collisionMaps[var0].method162();
        }

        System.gc();
        Class147.anInt1157 = 1;
        Class147.aReferenceTable1155 = null;
        Statics8.anInt1122 = -1;
        Class30.anInt327 = -1;
        PickableNode.anInt379 = 0;
        Enum_Sub2.aBoolean620 = false;
        Class139.anInt1130 = 2;
        client.anInt898 = -1;
        client.aBoolean904 = false;
        OutgoingPacketMeta.method4();
        MouseRecorder.setGameState(10);
    }

    static void method1507(Node_Sub6 var0) {
        var0.aBoolean665 = false;
        if (var0.aNode_Sub10_667 != null) {
            var0.aNode_Sub10_667.anInt112 = 0;
        }

        for (Node_Sub6 var1 = var0.method307(); var1 != null; var1 = var0.method308()) {
            method1507(var1);
        }

    }

    public static boolean method1114() {
        synchronized (Keyboard.keyboard) {
            if (Keyboard.anInt162 == Keyboard.anInt157) {
                return false;
            }
            Class53.anInt457 = Keyboard.anIntArray148[Keyboard.anInt157];
            Keyboard.aChar151 = Keyboard.aCharArray156[Keyboard.anInt157];
            Keyboard.anInt157 = Keyboard.anInt157 + 1 & 127;
            return true;
        }
    }

    static void method1505() {
        for (Projectile var0 = (Projectile) client.projectileDeque.head(); var0 != null; var0 = (Projectile) client.projectileDeque.next()) {
            if (var0.floorLevel == SceneGraph.floorLevel && client.engineCycle <= var0.endCycle) {
                if (client.engineCycle >= var0.startCycle) {
                    if (var0.targetIndex > 0) {
                        NpcEntity var1 = client.npcs[var0.targetIndex - 1];
                        if (var1 != null && var1.fineX >= 0 && var1.fineX < 13312 && var1.fineY >= 0 && var1.fineY < 13312) {
                            var0.method271(var1.fineX, var1.fineY, SceneGraph.getTileHeight(var1.fineX, var1.fineY, var0.floorLevel) - var0.anInt112, client.engineCycle);
                        }
                    }

                    if (var0.targetIndex < 0) {
                        int var2 = -var0.targetIndex - 1;
                        PlayerEntity var3;
                        if (var2 == client.playerIndex) {
                            var3 = PlayerEntity.local;
                        } else {
                            var3 = client.players[var2];
                        }

                        if (var3 != null && var3.fineX >= 0 && var3.fineX < 13312 && var3.fineY >= 0 && var3.fineY < 13312) {
                            var0.method271(var3.fineX, var3.fineY, SceneGraph.getTileHeight(var3.fineX, var3.fineY, var0.floorLevel) - var0.anInt112, client.engineCycle);
                        }
                    }

                    var0.method1193(client.anInt972);
                    client.sceneGraph.method1469(SceneGraph.floorLevel, (int) var0.fineY, (int) var0.fineX, (int) var0.aDouble1660, 60, var0, var0.xRotation, -1L, false);
                }
            } else {
                var0.unlink();
            }
        }

    }

    protected final Model getModel() {
        if (this.sequence != null) {
            int var1 = client.engineCycle - this.anInt379;
            if (var1 > 100 && this.sequence.loopOffset > 0) {
                var1 = 100;
            }

            label56:
            {
                do {
                    do {
                        if (var1 <= this.sequence.frameLengths[this.anInt372]) {
                            break label56;
                        }

                        var1 -= this.sequence.frameLengths[this.anInt372];
                        ++this.anInt372;
                    } while (this.anInt372 < this.sequence.frameIds.length);

                    this.anInt372 -= this.sequence.loopOffset;
                } while (this.anInt372 >= 0 && this.anInt372 < this.sequence.frameIds.length);

                this.sequence = null;
            }

            this.anInt379 = client.engineCycle - var1;
        }

        ObjectDefinition var2 = Class38.getObjectDefinition(this.anInt693);
        if (var2.transformIds != null) {
            var2 = var2.method1101();
        }

        if (var2 == null) {
            return null;
        }
        int var3;
        int var4;
        if (this.orientation != 1 && this.orientation != 3) {
            var3 = var2.sizeX;
            var4 = var2.sizeY;
        } else {
            var3 = var2.sizeY;
            var4 = var2.sizeX;
        }

        int var5 = (var3 >> 1) + this.sceneX;
        int var6 = (var3 + 1 >> 1) + this.sceneX;
        int var7 = (var4 >> 1) + this.sceneY;
        int var8 = (var4 + 1 >> 1) + this.sceneY;
        int[][] var9 = Class44.tileHeights[this.floorLevel];
        int var10 = var9[var6][var7] + var9[var5][var7] + var9[var5][var8] + var9[var6][var8] >> 2;
        int var11 = (this.sceneX << 7) + (var3 << 6);
        int var12 = (this.sceneY << 7) + (var4 << 6);
        return var2.method1107(this.type, this.orientation, var9, var11, var10, var12, this.sequence, this.anInt372);
    }
}
