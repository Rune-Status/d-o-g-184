package com.jagex;

import java.util.Locale;

public class Class149 implements EnumType {
    public static final Class149 aClass149_1190;
    public static final Class149 aClass149_1187;
    public static final Class149 aClass149_1183;
    static final Class149 aClass149_1182;
    static final Class149[] aClass149Array1179;
    static final Class149 aClass149_1186;
    static final Class149 aClass149_1185;
    static final Class149 aClass149_1184;
    static DoublyLinkedNode_Sub24_Sub4[] aDoublyNode_Sub24_Sub4Array1178;
    static CacheReferenceTable aCacheReferenceTable1188;

    static {
        aClass149_1190 = new Class149("EN", "en", 0, "GB");
        aClass149_1182 = new Class149("DE", "de", 1, "DE");
        aClass149_1187 = new Class149("FR", "fr", 2, "FR");
        aClass149_1186 = new Class149("PT", "pt", 3, "BR");
        aClass149_1185 = new Class149("NL", "nl", 4, "NL");
        aClass149_1183 = new Class149("ES", "es", 5, "ES");
        aClass149_1184 = new Class149("ES_MX", "es-mx", 6, "MX");
        Class149[] var0 = method855();
        aClass149Array1179 = new Class149[var0.length];

        for (Class149 var3 : var0) {
            if (aClass149Array1179[var3.anInt1180] != null) {
                throw new IllegalStateException();
            }

            aClass149Array1179[var3.anInt1180] = var3;
        }

    }

    final String aString1189;
    final int anInt1180;
    final String aString1181;

    Class149(String var1, String var2, int var5, String var6) {
        this.aString1181 = var1;
        this.aString1189 = var2;
        this.anInt1180 = var5;
        if (var6 != null) {
            new Locale(var2.substring(0, 2), var6);
        } else {
            new Locale(var2.substring(0, 2));
        }

    }

    public static Class149 method853(int var0) {
        return var0 >= 0 && var0 < aClass149Array1179.length ? aClass149Array1179[var0] : null;
    }

    static Class149[] method855() {
        return new Class149[]{aClass149_1186, aClass149_1190, aClass149_1185, aClass149_1183, aClass149_1187, aClass149_1184, aClass149_1182};
    }

    public static boolean method857(long var0) {
        boolean var2 = 0L != var0;
        if (var2) {
            boolean var3 = (int) (var0 >>> 16 & 1L) == 1;
            var2 = !var3;
        }

        return var2;
    }

    static void method854() {
        DiskFile var0 = null;

        try {
            var0 = RegionUpdateType.method863("", Class83.anEnum_Sub5_629.aString1212, true);
            Buffer var1 = client.preferences.method253();
            var0.write(var1.payload, 0, var1.caret);
        } catch (Exception ignored) {
        }

        try {
            if (var0 != null) {
                var0.close(true);
            }
        } catch (Exception ignored) {
        }

    }

    String method856() {
        return this.aString1189;
    }

    public int getOrdinal() {
        return this.anInt1180;
    }

    public String toString() {
        return this.method856().toLowerCase(Locale.ENGLISH);
    }
}
