package jag.game;

public class Vars {

    public static final int[] baseValues;
    public static final int[] values;
    public static final int[] masks;

    static {
        masks = new int[32];
        int var0 = 2;

        for (int var1 = 0; var1 < 32; ++var1) {
            masks[var1] = var0 - 1;
            var0 += var0;
        }

        baseValues = new int[4000];
        values = new int[4000];
    }
}
