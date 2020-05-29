package jag;

import jag.game.client;
import jag.graphics.IndexedSprite;
import jag.js5.Archive;
import jag.js5.DiskFile;
import jag.opcode.Buffer;
import jag.opcode.RegionUpdateType;
import jag.statics.Statics55;

import java.util.Locale;

public class ClientLocale implements EnumType {

    public static final ClientLocale GB;
    public static final ClientLocale FR;
    public static final ClientLocale ES;
    static final ClientLocale DE;
    static final ClientLocale[] VALUES;
    static final ClientLocale BR;
    static final ClientLocale NL;
    static final ClientLocale MX;

    public static IndexedSprite[] aDoublyNode_Sub24_Sub4Array1178;
    public static Archive aArchive1188;

    static {
        GB = new ClientLocale("EN", "en", 0, "GB");
        DE = new ClientLocale("DE", "de", 1, "DE");
        FR = new ClientLocale("FR", "fr", 2, "FR");
        BR = new ClientLocale("PT", "pt", 3, "BR");
        NL = new ClientLocale("NL", "nl", 4, "NL");
        ES = new ClientLocale("ES", "es", 5, "ES");
        MX = new ClientLocale("ES_MX", "es-mx", 6, "MX");

        ClientLocale[] values = values();
        VALUES = new ClientLocale[values.length];

        for (ClientLocale locale : values) {
            if (VALUES[locale.index] != null) {
                throw new IllegalStateException();
            }

            VALUES[locale.index] = locale;
        }

    }

    final String aString1189;
    final int index;
    final String aString1181;

    ClientLocale(String var1, String var2, int var5, String country) {
        this.aString1181 = var1;
        this.aString1189 = var2;
        this.index = var5;
        if (country != null) {
            new Locale(var2.substring(0, 2), country);
        } else {
            new Locale(var2.substring(0, 2));
        }

    }

    public static ClientLocale valueOf(int index) {
        return index >= 0 && index < VALUES.length ? VALUES[index] : null;
    }

    static ClientLocale[] values() {
        return new ClientLocale[]{BR, GB, NL, ES, FR, MX, DE};
    }

    public static boolean method857(long var0) {
        boolean var2 = 0L != var0;
        if (var2) {
            boolean var3 = (int) (var0 >>> 16 & 1L) == 1;
            var2 = !var3;
        }

        return var2;
    }

    public static void method854() {
        DiskFile var0 = null;

        try {
            var0 = RegionUpdateType.method863("", Statics55.anGameType_629.name, true);
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
        return this.index;
    }

    public String toString() {
        return this.method856().toLowerCase(Locale.ENGLISH);
    }
}
