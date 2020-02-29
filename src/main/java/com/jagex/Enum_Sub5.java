package com.jagex;

public enum Enum_Sub5 implements EnumType {
    anEnum_Sub5_1217("runescape", 0),
    anEnum_Sub5_1219("stellardawn", 1),
    anEnum_Sub5_1215("game3", 2),
    anEnum_Sub5_1214("game4", 3),
    anEnum_Sub5_1213("game5", 4),
    anEnum_Sub5_1211("oldscape", 5);

    public static Class172 aClass172_1216;
    public final String aString1212;
    final int anInt1218;

    Enum_Sub5(String var3, int var5) {
        this.aString1212 = var3;
        this.anInt1218 = var5;
    }

    public int getOrdinal() {
        return this.anInt1218;
    }
}
