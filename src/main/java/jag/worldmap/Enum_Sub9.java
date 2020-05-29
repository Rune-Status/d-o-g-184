package jag.worldmap;

import jag.EnumType;

public enum Enum_Sub9 implements EnumType {
    anEnum_Sub9_1484(1, 0),
    anEnum_Sub9_1485(2, 1),
    anEnum_Sub9_1483(0, 2);

    public static short[] aShortArray1482;
    public final int anInt633;
    final int anInt619;

    Enum_Sub9(int var3, int var4) {
        this.anInt633 = var3;
        this.anInt619 = var4;
    }

    public static Enum_Sub9[] valuess() {
        return new Enum_Sub9[]{anEnum_Sub9_1483, anEnum_Sub9_1484, anEnum_Sub9_1485};
    }

    public int getOrdinal() {
        return this.anInt619;
    }
}
