package jag.statics;

import jag.graphics.Font;

public class Statics7 {

    public static Font fontb12full;
    public static int anInt858;

    public static int method702(CharSequence var0) {
        int var1 = var0.length();
        int var2 = 0;

        for (int var3 = 0; var3 < var1; ++var3) {
            char var4 = var0.charAt(var3);
            if (var4 <= 127) {
                ++var2;
            } else if (var4 <= 2047) {
                var2 += 2;
            } else {
                var2 += 3;
            }
        }

        return var2;
    }
}
