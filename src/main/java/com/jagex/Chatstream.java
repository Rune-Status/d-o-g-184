package com.jagex;

public class Chatstream {
    Chatline[] buffer;
    int caret;

    Chatstream() {
        this.buffer = new Chatline[100];
    }

    static void method513(InterfaceComponent[] var0, int var1) {
        for (InterfaceComponent var3 : var0) {
            if (var3 != null && var3.parentUid == var1 && (!var3.aBoolean562 || !Enum_Sub2.method440(var3))) {
                int var5;
                if (var3.type == 0) {
                    if (!var3.aBoolean562 && Enum_Sub2.method440(var3) && var3 != OldConnection.anInterfaceComponent873) {
                        continue;
                    }

                    method513(var0, var3.uid);
                    if (var3.components != null) {
                        method513(var3.components, var3.uid);
                    }

                    InterfaceNode var7 = (InterfaceNode) client.interfaceNodes.lookup((long) var3.uid);
                    if (var7 != null) {
                        var5 = var7.id;
                        if (Class63_Sub2.loadInterface(var5)) {
                            method513(AssociateComparator_Sub5.interfaces[var5], -1);
                        }
                    }
                }

                if (var3.type == 6) {
                    if (var3.anInt1357 != -1 || var3.anInt1353 != -1) {
                        boolean var4 = Projectile.method1192(var3);
                        if (var4) {
                            var5 = var3.anInt1353;
                        } else {
                            var5 = var3.anInt1357;
                        }

                        if (var5 != -1) {
                            AnimationSequence var6 = Class57.getAnimationSequence(var5);

                            for (var3.anInt1401 += client.anInt972; var3.anInt1401 > var6.frameLengths[var3.anInt1389]; Enum_Sub2.repaintComponent(var3)) {
                                var3.anInt1401 -= var6.frameLengths[var3.anInt1389];
                                ++var3.anInt1389;
                                if (var3.anInt1389 >= var6.frameIds.length) {
                                    var3.anInt1389 -= var6.loopOffset;
                                    if (var3.anInt1389 < 0 || var3.anInt1389 >= var6.frameIds.length) {
                                        var3.anInt1389 = 0;
                                    }
                                }
                            }
                        }
                    }

                    if (var3.anInt1351 != 0 && !var3.aBoolean562) {
                        int var8 = var3.anInt1351 >> 16;
                        var5 = var3.anInt1351 << 16 >> 16;
                        var8 *= client.anInt972;
                        var5 *= client.anInt972;
                        var3.xRotation = var8 + var3.xRotation & 2047;
                        var3.zRotation = var5 + var3.zRotation & 2047;
                        Enum_Sub2.repaintComponent(var3);
                    }
                }
            }
        }

    }

    static void method516(int var0) {
        DefinitionProperty.aClass77_384 = new Class77();
        DefinitionProperty.aClass77_384.anInt605 = client.menuSecondaryArgs[var0];
        DefinitionProperty.aClass77_384.anInt602 = client.menuTertiaryArgs[var0];
        DefinitionProperty.aClass77_384.anInt604 = client.menuOpcodes[var0];
        DefinitionProperty.aClass77_384.anInt601 = client.menuPrimaryArgs[var0];
        DefinitionProperty.aClass77_384.aString600 = client.menuActions[var0];
    }

    static void method517() {
        int var0 = Statics15.anInt1235 * 16384 + 64;
        int var1 = Class135.anInt889 * 16384 + 64;
        int var2 = SceneGraph.getTileHeight(var0, var1, SceneGraph.floorLevel) - Class38.anInt347;
        if (Class38.cameraX < var0) {
            Class38.cameraX = (var0 - Class38.cameraX) * Class64.anInt520 / 1000 + Class38.cameraX + MouseRecorder.anInt388;
            if (Class38.cameraX > var0) {
                Class38.cameraX = var0;
            }
        }

        if (Class38.cameraX > var0) {
            Class38.cameraX -= Class64.anInt520 * (Class38.cameraX - var0) / 1000 + MouseRecorder.anInt388;
            if (Class38.cameraX < var0) {
                Class38.cameraX = var0;
            }
        }

        if (Class79.cameraZ < var2) {
            Class79.cameraZ = (var2 - Class79.cameraZ) * Class64.anInt520 / 1000 + Class79.cameraZ + MouseRecorder.anInt388;
            if (Class79.cameraZ > var2) {
                Class79.cameraZ = var2;
            }
        }

        if (Class79.cameraZ > var2) {
            Class79.cameraZ -= Class64.anInt520 * (Class79.cameraZ - var2) / 1000 + MouseRecorder.anInt388;
            if (Class79.cameraZ < var2) {
                Class79.cameraZ = var2;
            }
        }

        if (Class27_Sub1.cameraY < var1) {
            Class27_Sub1.cameraY = (var1 - Class27_Sub1.cameraY) * Class64.anInt520 / 1000 + Class27_Sub1.cameraY + MouseRecorder.anInt388;
            if (Class27_Sub1.cameraY > var1) {
                Class27_Sub1.cameraY = var1;
            }
        }

        if (Class27_Sub1.cameraY > var1) {
            Class27_Sub1.cameraY -= Class64.anInt520 * (Class27_Sub1.cameraY - var1) / 1000 + MouseRecorder.anInt388;
            if (Class27_Sub1.cameraY < var1) {
                Class27_Sub1.cameraY = var1;
            }
        }

        var0 = GameEngine.anInt1288 * 128 + 64;
        var1 = Class53.anInt458 * 16384 + 64;
        var2 = SceneGraph.getTileHeight(var0, var1, SceneGraph.floorLevel) - Class62.anInt499;
        int var3 = var0 - Class38.cameraX;
        int var4 = var2 - Class79.cameraZ;
        int var5 = var1 - Class27_Sub1.cameraY;
        int var6 = (int) Math.sqrt((double) (var5 * var5 + var3 * var3));
        int var7 = (int) (Math.atan2((double) var4, (double) var6) * 325.949D) & 2047;
        int var8 = (int) (Math.atan2((double) var3, (double) var5) * -325.949D) & 2047;
        if (var7 < 128) {
            var7 = 128;
        }

        if (var7 > 383) {
            var7 = 383;
        }

        if (IgnoreListContext.cameraPitch < var7) {
            IgnoreListContext.cameraPitch = (var7 - IgnoreListContext.cameraPitch) * ScriptEvent.anInt1806 / 1000 + IgnoreListContext.cameraPitch + Class82.anInt627;
            if (IgnoreListContext.cameraPitch > var7) {
                IgnoreListContext.cameraPitch = var7;
            }
        }

        if (IgnoreListContext.cameraPitch > var7) {
            IgnoreListContext.cameraPitch -= ScriptEvent.anInt1806 * (IgnoreListContext.cameraPitch - var7) / 1000 + Class82.anInt627;
            if (IgnoreListContext.cameraPitch < var7) {
                IgnoreListContext.cameraPitch = var7;
            }
        }

        int var9 = var8 - Class70.cameraYaw;
        if (var9 > 1024) {
            var9 -= 2048;
        }

        if (var9 < -1024) {
            var9 += 2048;
        }

        if (var9 > 0) {
            Class70.cameraYaw = Class70.cameraYaw + Class82.anInt627 + var9 * ScriptEvent.anInt1806 / 1000;
            Class70.cameraYaw &= 2047;
        }

        if (var9 < 0) {
            Class70.cameraYaw -= Class82.anInt627 + -var9 * ScriptEvent.anInt1806 / 1000;
            Class70.cameraYaw &= 2047;
        }

        int var10 = var8 - Class70.cameraYaw;
        if (var10 > 1024) {
            var10 -= 2048;
        }

        if (var10 < -1024) {
            var10 += 2048;
        }

        if (var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
            Class70.cameraYaw = var8;
        }

    }

    Chatline method514(int var1, String var2, String var3, String var4) {
        Chatline var5 = this.buffer[99];

        for (int var6 = this.caret; var6 > 0; --var6) {
            if (var6 != 100) {
                this.buffer[var6] = this.buffer[var6 - 1];
            }
        }

        if (var5 == null) {
            var5 = new Chatline(var1, var2, var4, var3);
        } else {
            var5.unlink();
            var5.unlinkDoubly();
            var5.method885(var1, var2, var4, var3);
        }

        this.buffer[0] = var5;
        if (this.caret < 100) {
            ++this.caret;
        }

        return var5;
    }

    Chatline method515(int var1) {
        return var1 >= 0 && var1 < this.caret ? this.buffer[var1] : null;
    }

    int method512() {
        return this.caret;
    }
}
