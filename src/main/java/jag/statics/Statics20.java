package jag.statics;

import jag.opcode.OldConnectionTaskProcessor;
import jag.commons.input.Keyboard;

public class Statics20 {
    public static final boolean[] aBooleanArray1263;
    public static final int[] anIntArray1262;

    static {
        aBooleanArray1263 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
        anIntArray1262 = new int[99];
        int var0 = 0;

        for (int var1 = 0; var1 < 99; ++var1) {
            int var2 = var1 + 1;
            int var3 = (int) ((double) var2 + 300.0D * Math.pow(2.0D, (double) var2 / 7.0D));
            var0 += var3;
            anIntArray1262[var1] = var0 / 4;
        }

    }

    public static void method921() {
        if (OldConnectionTaskProcessor.aString855.toLowerCase().contains("microsoft")) {
            Keyboard.anIntArray159[186] = 57;
            Keyboard.anIntArray159[187] = 27;
            Keyboard.anIntArray159[188] = 71;
            Keyboard.anIntArray159[189] = 26;
            Keyboard.anIntArray159[190] = 72;
            Keyboard.anIntArray159[191] = 73;
            Keyboard.anIntArray159[192] = 58;
            Keyboard.anIntArray159[219] = 42;
            Keyboard.anIntArray159[220] = 74;
            Keyboard.anIntArray159[221] = 43;
            Keyboard.anIntArray159[222] = 59;
            Keyboard.anIntArray159[223] = 28;
        } else {
            Keyboard.anIntArray159[44] = 71;
            Keyboard.anIntArray159[45] = 26;
            Keyboard.anIntArray159[46] = 72;
            Keyboard.anIntArray159[47] = 73;
            Keyboard.anIntArray159[59] = 57;
            Keyboard.anIntArray159[61] = 27;
            Keyboard.anIntArray159[91] = 42;
            Keyboard.anIntArray159[92] = 74;
            Keyboard.anIntArray159[93] = 43;
            Keyboard.anIntArray159[192] = 28;
            Keyboard.anIntArray159[222] = 58;
            Keyboard.anIntArray159[520] = 59;
        }

    }
}
