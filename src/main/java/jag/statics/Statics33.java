package jag.statics;

public final class Statics33 {
    public static final char[] aCharArray1570;
    static final long[] aLongArray1571;

    static {
        aCharArray1570 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        aLongArray1571 = new long[12];

        for (int var0 = 0; var0 < aLongArray1571.length; ++var0) {
            aLongArray1571[var0] = (long) Math.pow(37.0D, var0);
        }

    }

    public static int method1141(CharSequence var0) {
        int var1 = var0.length();
        int var2 = 0;

        for (int var3 = 0; var3 < var1; ++var3) {
            var2 = (var2 << 5) - var2 + var0.charAt(var3);
        }

        return var2;
    }
}
