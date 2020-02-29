package com.jagex;

final class Class87 implements Class89 {
    static ReferenceTable aReferenceTable645;
    static int selectedItemComponentUid;

    public static int method466(CharSequence var0, int var1) {
        return Class97.method536(var0, var1);
    }

    public static int getComponentSpellTargets(int value) {
        return value >> 11 & 63;
    }

    void method464(Long var1, Buffer var2) {
        var2.writeLong(var1);
    }

    public Object method410(Buffer var1) {
        return var1.readLong();
    }

    public void method408(Object var1, Buffer var2) {
        this.method464((Long) var1, var2);
    }
}
