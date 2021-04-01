package jag;

import jag.opcode.Buffer;

public class DefaultRouteStrategy extends RouteStrategy {

    public DefaultRouteStrategy() {

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

    public static String method1502(Buffer buffer) {
        try {
            int len = buffer.gsmarts();
            if (len > 32767) {
                len = 32767;
            }

            byte[] data = new byte[len];
            buffer.pos += Huffman.instance.decompress(buffer.payload, buffer.pos, data, 0, len);
            return Buffer.readStringFromBytes(data, 0, len);
        } catch (Exception var6) {
            return "Cabbage";
        }
    }

    public boolean isDestination(int x, int y) {
        return x == destinationX && y == destinationY;
    }
}
