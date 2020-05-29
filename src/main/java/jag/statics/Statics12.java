package jag.statics;

import jag.game.InterfaceComponent;

import java.util.Calendar;
import java.util.TimeZone;

public class Statics12 {
    public static final String[][] aStringArrayArray1208;
    public static final String[] aStringArray1209;
    public static final Calendar aCalendar1207;

    static {
        aStringArrayArray1208 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}, {"jan", "fév", "mars", "avr", "mai", "juin", "juil", "août", "sept", "oct", "nov", "déc"}, {"jan", "fev", "mar", "abr", "mai", "jun", "jul", "ago", "set", "out", "nov", "dez"}, {"jan", "feb", "mrt", "apr", "mei", "jun", "jul", "aug", "sep", "okt", "nov", "dec"}, {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"ene", "feb", "mar", "abr", "may", "jun", "jul", "ago", "sep", "oct", "nov", "dic"}};
        aStringArray1209 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        Calendar.getInstance();
        aCalendar1207 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    }

    public static void method868(InterfaceComponent var0, int var1, byte[] var2, byte[] var3) {
        if (var0.aByteArrayArray1365 == null) {
            if (var2 == null) {
                return;
            }

            var0.aByteArrayArray1365 = new byte[11][];
            var0.aByteArrayArray1363 = new byte[11][];
            var0.anIntArray1361 = new int[11];
            var0.anIntArray1366 = new int[11];
        }

        var0.aByteArrayArray1365[var1] = var2;
        if (var2 != null) {
            var0.aBoolean1372 = true;
        } else {
            var0.aBoolean1372 = false;

            for (int var4 = 0; var4 < var0.aByteArrayArray1365.length; ++var4) {
                if (var0.aByteArrayArray1365[var4] != null) {
                    var0.aBoolean1372 = true;
                    break;
                }
            }
        }

        var0.aByteArrayArray1363[var1] = var3;
    }
}
