package com.jagex;

public final class PlayerEntity extends PathingEntity {
    static PlayerEntity local;
    PlayerAppearance appearance;
    Class186 aClass186_1906;
    Class186 aClass186_1907;
    NamePair namePair;
    int prayerIcon;
    int skullIcon;
    boolean aBoolean1905;
    String[] actions;
    int anInt1659;
    int combatLevel;
    int skillLevel;
    int team;
    int anInt564;
    int anInt368;
    boolean hidden;
    boolean aBoolean1904;
    Model transformedNpcModel;
    int anInt1473;
    int anInt367;
    int anInt386;
    int anInt379;
    int anInt366;
    int anInt702;
    int anInt666;
    int anInt788;
    int anInt791;
    int anInt704;
    int anInt1739;

    PlayerEntity() {
        this.prayerIcon = -1;
        this.skullIcon = -1;
        this.actions = new String[3];

        for (int var1 = 0; var1 < 3; ++var1) {
            this.actions[var1] = "";
        }

        this.combatLevel = 0;
        this.skillLevel = 0;
        this.anInt564 = 0;
        this.anInt368 = 0;
        this.aBoolean1905 = false;
        this.team = 0;
        this.hidden = false;
        this.aClass186_1907 = Class186.aClass186_1554;
        this.aClass186_1906 = Class186.aClass186_1554;
        this.aBoolean1904 = false;
    }

    protected final Model getModel() {
        if (this.appearance == null) {
            return null;
        }
        AnimationSequence var1 = super.animation != -1 && super.animationDelay == 0 ? Class57.getAnimationSequence(super.animation) : null;
        AnimationSequence var2 = super.stance != -1 && !this.aBoolean1905 && (super.stance != super.walkingStance || var1 == null) ? Class57.getAnimationSequence(super.stance) : null;
        Model var3 = this.appearance.getModel(var1, super.animationFrame, var2, super.stanceFrame);
        if (var3 == null) {
            return null;
        }
        var3.method827();
        super.anInt2021 = var3.height;
        Model var4;
        Model[] var5;
        if (!this.aBoolean1905 && super.graphic != -1 && super.anInt2017 != -1) {
            var4 = InterfaceNode.getGraphicDefinition(super.graphic).method1004(super.anInt2017);
            if (var4 != null) {
                var4.method832(0, -super.anInt2014, 0);
                var5 = new Model[]{var3, var4};
                var3 = new Model(var5, 2);
            }
        }

        if (!this.aBoolean1905 && this.transformedNpcModel != null) {
            if (client.engineCycle >= this.anInt368) {
                this.transformedNpcModel = null;
            }

            if (client.engineCycle >= this.anInt564 && client.engineCycle < this.anInt368) {
                var4 = this.transformedNpcModel;
                var4.method832(this.anInt367 * super.fineX, this.anInt386 - this.anInt379, this.anInt366 * super.fineY);
                if (super.orientation == 512) {
                    var4.method1283();
                    var4.method1283();
                    var4.method1283();
                } else if (super.orientation == 1024) {
                    var4.method1283();
                    var4.method1283();
                } else if (super.orientation == 1536) {
                    var4.method1283();
                }

                var5 = new Model[]{var3, var4};
                var3 = new Model(var5, 2);
                if (super.orientation == 512) {
                    var4.method1283();
                } else if (super.orientation == 1024) {
                    var4.method1283();
                    var4.method1283();
                } else if (super.orientation == 1536) {
                    var4.method1283();
                    var4.method1283();
                    var4.method1283();
                }

                var4.method832(super.fineX - this.anInt367, this.anInt379 - this.anInt386, super.fineY - this.anInt366);
            }
        }

        var3.aabbEnabled = true;
        return var3;
    }

    void method828() {
        this.aClass186_1906 = Varps.clanSystem != null && Varps.clanSystem.isCached(this.namePair) ? Class186.aClass186_1555 : Class186.aClass186_1553;
    }

    void method775() {
        this.aClass186_1907 = Class44.socialSystem.isFriendLoggedIn(this.namePair) ? Class186.aClass186_1555 : Class186.aClass186_1553;
    }

    void method1414(int var1, int var2) {
        super.pathQueueSize = 0;
        super.anInt2023 = 0;
        super.anInt2022 = 0;
        super.pathXQueue[0] = var1;
        super.pathYQueue[0] = var2;
        int size = this.boundSize();
        super.fineX = size * 64 + super.pathXQueue[0] * 128;
        super.fineY = size * 64 + super.pathYQueue[0] * 128;
    }

    int boundSize() {
        return this.appearance != null && this.appearance.transformedNpcId != -1 ? OutgoingPacket.getNpcDefinition(this.appearance.transformedNpcId).size : 1;
    }

    void method23() {
        this.aClass186_1907 = Class186.aClass186_1554;
    }

    final void method1413(int var1, int var2, byte var3) {
        if (super.pathQueueSize < 9) {
            ++super.pathQueueSize;
        }

        for (int var4 = super.pathQueueSize; var4 > 0; --var4) {
            super.pathXQueue[var4] = super.pathXQueue[var4 - 1];
            super.pathYQueue[var4] = super.pathYQueue[var4 - 1];
            super.pathQueueTraversed[var4] = super.pathQueueTraversed[var4 - 1];
        }

        super.pathXQueue[0] = var1;
        super.pathYQueue[0] = var2;
        super.pathQueueTraversed[0] = var3;
    }

    final void decode(Buffer buffer) {
        buffer.caret = 0;
        int var2 = buffer.readUByte();
        this.prayerIcon = buffer.readByte();
        this.skullIcon = buffer.readByte();
        int var3 = -1;
        this.team = 0;
        int[] var4 = new int[12];

        int var6;
        int var8;
        for (int var5 = 0; var5 < 12; ++var5) {
            var6 = buffer.readUByte();
            if (var6 == 0) {
                var4[var5] = 0;
            } else {
                var8 = buffer.readUByte();
                var4[var5] = var8 + (var6 << 8);
                if (var5 == 0 && var4[0] == 65535) {
                    var3 = buffer.readUShort();
                    break;
                }

                if (var4[var5] >= 512) {
                    int var9 = CameraCapture.getItemDefinition(var4[var5] - 512).team;
                    if (var9 != 0) {
                        this.team = var9;
                    }
                }
            }
        }

        int[] var7 = new int[5];

        for (var6 = 0; var6 < 5; ++var6) {
            var8 = buffer.readUByte();
            if (var8 < 0 || var8 >= PlayerAppearance.aShortArrayArray1928[var6].length) {
                var8 = 0;
            }

            var7[var6] = var8;
        }

        super.walkingStance = buffer.readUShort();
        if (super.walkingStance == 65535) {
            super.walkingStance = -1;
        }

        super.anInt709 = buffer.readUShort();
        if (super.anInt709 == 65535) {
            super.anInt709 = -1;
        }

        super.anInt1424 = super.anInt709;
        super.anInt710 = buffer.readUShort();
        if (super.anInt710 == 65535) {
            super.anInt710 = -1;
        }

        super.anInt2006 = buffer.readUShort();
        if (super.anInt2006 == 65535) {
            super.anInt2006 = -1;
        }

        super.anInt1857 = buffer.readUShort();
        if (super.anInt1857 == 65535) {
            super.anInt1857 = -1;
        }

        super.anInt1858 = buffer.readUShort();
        if (super.anInt1858 == 65535) {
            super.anInt1858 = -1;
        }

        super.anInt2007 = buffer.readUShort();
        if (super.anInt2007 == 65535) {
            super.anInt2007 = -1;
        }

        this.namePair = new NamePair(buffer.readString(), Class36.aClass213_343);
        this.method23();
        this.method827();
        if (this == local) {
            Jagception.aString1882 = this.namePair.getRaw();
        }

        this.combatLevel = buffer.readUByte();
        this.skillLevel = buffer.readUShort();
        this.hidden = buffer.readUByte() == 1;
        if (client.anInt925 == 0 && client.rights >= 2) {
            this.hidden = false;
        }

        if (this.appearance == null) {
            this.appearance = new PlayerAppearance();
        }

        this.appearance.update(var4, var7, var2 == 1, var3);
    }

    void method827() {
        this.aClass186_1906 = Class186.aClass186_1554;
    }

    final boolean method684() {
        return this.appearance != null;
    }

    boolean method609() {
        if (this.aClass186_1907 == Class186.aClass186_1554) {
            this.method775();
        }

        return this.aClass186_1907 == Class186.aClass186_1555;
    }

    boolean method258() {
        if (this.aClass186_1906 == Class186.aClass186_1554) {
            this.method828();
        }

        return this.aClass186_1906 == Class186.aClass186_1555;
    }

    final void method1415(int var1, int var2, byte var3) {
        if (super.animation != -1 && Class57.getAnimationSequence(super.animation).walkingPrecedence == 1) {
            super.animation = -1;
        }

        super.transformedOrienation = -1;
        if (var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
            if (super.pathXQueue[0] >= 0 && super.pathXQueue[0] < 104 && super.pathYQueue[0] >= 0 && super.pathYQueue[0] < 104) {
                if (var3 == 2) {
                    Class73.method406(this, var1, var2);
                }

                this.method1413(var1, var2, var3);
            } else {
                this.method1414(var1, var2);
            }
        } else {
            this.method1414(var1, var2);
        }

    }
}
