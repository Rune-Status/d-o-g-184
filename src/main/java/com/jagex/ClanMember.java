package com.jagex;

public class ClanMember extends Associate {
    static CacheReferenceTable aCacheReferenceTable867;
    Class186 aClass186_869;
    Class186 aClass186_868;

    ClanMember() {
        this.aClass186_868 = Class186.aClass186_1554;
        this.aClass186_869 = Class186.aClass186_1554;
    }

    public static Font method708(ReferenceTable var0, ReferenceTable var1, int var2, int var3) {
        return !Class96.method534(var0, var2, var3) ? null : Class30.method221(var1.unpack(var2, var3));
    }

    void method709() {
        this.aClass186_868 = Class44.socialSystem.friendListContext.isCached(super.displayName) ? Class186.aClass186_1555 : Class186.aClass186_1553;
    }

    void method705() {
        this.aClass186_869 = Class44.socialSystem.ignoreListContext.isCached(super.displayName) ? Class186.aClass186_1555 : Class186.aClass186_1553;
    }

    void method710() {
        this.aClass186_868 = Class186.aClass186_1554;
    }

    void method707() {
        this.aClass186_869 = Class186.aClass186_1554;
    }

    public final boolean method711() {
        if (this.aClass186_868 == Class186.aClass186_1554) {
            this.method709();
        }

        return this.aClass186_868 == Class186.aClass186_1555;
    }

    public final boolean method706() {
        if (this.aClass186_869 == Class186.aClass186_1554) {
            this.method705();
        }

        return this.aClass186_869 == Class186.aClass186_1555;
    }
}
