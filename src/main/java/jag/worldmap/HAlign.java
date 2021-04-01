package jag.worldmap;

import jag.EnumType;

public enum HAlign implements EnumType {
    anEnum_Sub9_1484(1, 0),
    anEnum_Sub9_1485(2, 1),
    anEnum_Sub9_1483(0, 2);

    public static short[] aShortArray1482;
    public final int anInt633;
    final int anInt619;

    HAlign(int var3, int var4) {
        this.anInt633 = var3;
        this.anInt619 = var4;
    }

    public static HAlign[] valuess() {
        return new HAlign[]{anEnum_Sub9_1483, anEnum_Sub9_1484, anEnum_Sub9_1485};
    }

    public int getOrdinal() {
        return this.anInt619;
    }
}
