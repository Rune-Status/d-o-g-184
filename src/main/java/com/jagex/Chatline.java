package com.jagex;

public class Chatline extends DoublyLinkedNode {
    static int anInt1232;
    String aString1233;
    Class186 aClass186_1230;
    Class186 aClass186_1229;
    NamePair aNamePair1231;
    int anInt380;
    int anInt568;
    int type;
    String source;
    String message;

    Chatline(int var1, String var2, String var3, String var4) {
        this.aClass186_1229 = Class186.aClass186_1554;
        this.aClass186_1230 = Class186.aClass186_1554;
        this.method885(var1, var2, var3, var4);
    }

    static void method884(int var0, int var1, int var2) {
        if (client.anInt901 != 0 && var1 != 0 && client.anInt903 < 50) {
            client.anIntArray899[client.anInt903] = var0;
            client.anIntArray905[client.anInt903] = var1;
            client.anIntArray906[client.anInt903] = var2;
            client.audioEffects[client.anInt903] = null;
            client.anIntArray902[client.anInt903] = 0;
            ++client.anInt903;
        }

    }

    static void method883(int var0, int var1) {
        if (client.hintArrowType == 2) {
            SceneGraph.absoluteToViewport((client.hintArrowX - Statics18.baseX << 7) + client.anInt946, client.anInt938 * 64 + (client.hintArrowY - Statics36.baseY << 7), client.hintArrowZ * 4);
            if (client.anInt998 > -1 && client.engineCycle % 20 < 10) {
                ClassStructure.hitmarks[0].method809(var0 + client.anInt998 - 12, client.anInt993 + var1 - 28);
            }

        }
    }

    void method775() {
        this.aClass186_1229 = Class44.socialSystem.friendListContext.isCached(this.aNamePair1231) ? Class186.aClass186_1555 : Class186.aClass186_1553;
    }

    void method828() {
        this.aClass186_1230 = Class44.socialSystem.ignoreListContext.isCached(this.aNamePair1231) ? Class186.aClass186_1555 : Class186.aClass186_1553;
    }

    void method885(int var1, String var2, String var3, String var4) {
        this.anInt380 = ++Class64.anInt521 - 1;
        this.anInt568 = client.engineCycle;
        this.type = var1;
        this.aString1233 = var2;
        this.method886();
        this.source = var3;
        this.message = var4;
        this.method254();
        this.method592();
    }

    final void method886() {
        if (this.aString1233 != null) {
            this.aNamePair1231 = new NamePair(Enum_Sub2.method442(this.aString1233), Class36.aClass213_343);
        } else {
            this.aNamePair1231 = null;
        }

    }

    void method592() {
        this.aClass186_1230 = Class186.aClass186_1554;
    }

    void method254() {
        this.aClass186_1229 = Class186.aClass186_1554;
    }

    final boolean method693() {
        if (this.aClass186_1229 == Class186.aClass186_1554) {
            this.method775();
        }

        return this.aClass186_1229 == Class186.aClass186_1555;
    }

    final boolean method882() {
        if (this.aClass186_1230 == Class186.aClass186_1554) {
            this.method828();
        }

        return this.aClass186_1230 == Class186.aClass186_1555;
    }
}
