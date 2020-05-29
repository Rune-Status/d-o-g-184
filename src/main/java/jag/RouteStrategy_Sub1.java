package jag;

import jag.game.stockmarket.Class46;
import jag.opcode.Buffer;
import jag.statics.Statics19;

public class RouteStrategy_Sub1 extends RouteStrategy {

    public RouteStrategy_Sub1() {

    }

    public static int method293(int var0, int var1, int var2) {
        if (var2 > 179) {
            var1 /= 2;
        }

        if (var2 > 192) {
            var1 /= 2;
        }

        if (var2 > 217) {
            var1 /= 2;
        }

        if (var2 > 243) {
            var1 /= 2;
        }

        return (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
    }

    public static String method294(Buffer var0) {
        return method1502(var0);
    }

    public static String method1502(Buffer var0) {
        try {
            int var2 = var0.readSmart();
            if (var2 > 32767) {
                var2 = 32767;
            }

            byte[] var3 = new byte[var2];
            var0.caret += Statics19.huffman.method952(var0.payload, var0.caret, var3, 0, var2);
            return Class46.readStringFromBytes(var3, 0, var2);
        } catch (Exception var6) {
            return "Cabbage";
        }
    }

    public boolean passable(int x, int y) {
        return x == this.destinationX && y == this.destinationY;
    }
}
