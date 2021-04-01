package jag.worldmap;

import jag.EnumType;

public enum VAlign implements EnumType {
    anEnum_Sub8_1480(0, 0),
    anEnum_Sub8_1481(2, 1),
    anEnum_Sub8_1479(1, 2);

    public static long aLong1478;
    public final int anInt633;
    final int anInt619;

    VAlign(int var3, int var4) {
        this.anInt633 = var3;
        this.anInt619 = var4;
    }

    public int getOrdinal() {
        return this.anInt619;
    }
}
