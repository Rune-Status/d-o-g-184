package jag;

import jag.game.type.Skeleton;
import jag.opcode.Buffer;

public class Identikit {

    public static final int[] anIntArray1328;
    public static final int[] anIntArray1331;
    public static final int[] anIntArray1325;
    public static final int[] anIntArray1324;

    static {
        anIntArray1328 = new int[500];
        anIntArray1331 = new int[500];
        anIntArray1325 = new int[500];
        anIntArray1324 = new int[500];
    }

    public Skeleton frame;

    public boolean showing;
    public int anInt1329;

    public int[] anIntArray1322;
    public int[] anIntArray1330;
    public int[] anIntArray1326;
    public int[] anIntArray1327;

    public Identikit(byte[] var1, Skeleton frame) {
        this.frame = null;
        anInt1329 = -1;
        showing = false;
        this.frame = frame;
        Buffer buff1 = new Buffer(var1);
        Buffer buff2 = new Buffer(var1);
        buff1.pos = 2;
        int var5 = buff1.g1();
        int var6 = -1;
        int var7 = 0;
        buff2.pos = var5 + buff1.pos;

        int var8;
        for (var8 = 0; var8 < var5; ++var8) {
            int var9 = buff1.g1();
            if (var9 > 0) {
                if (frame.types[var8] != 0) {
                    for (int var10 = var8 - 1; var10 > var6; --var10) {
                        if (frame.types[var10] == 0) {
                            anIntArray1328[var7] = var10;
                            anIntArray1331[var7] = 0;
                            anIntArray1325[var7] = 0;
                            anIntArray1324[var7] = 0;
                            ++var7;
                            break;
                        }
                    }
                }

                anIntArray1328[var7] = var8;
                short var11 = 0;
                if (frame.types[var8] == 3) {
                    var11 = 128;
                }

                if ((var9 & 1) != 0) {
                    anIntArray1331[var7] = buff2.gsmart();
                } else {
                    anIntArray1331[var7] = var11;
                }

                if ((var9 & 2) != 0) {
                    anIntArray1325[var7] = buff2.gsmart();
                } else {
                    anIntArray1325[var7] = var11;
                }

                if ((var9 & 4) != 0) {
                    anIntArray1324[var7] = buff2.gsmart();
                } else {
                    anIntArray1324[var7] = var11;
                }

                var6 = var8;
                ++var7;
                if (frame.types[var8] == 5) {
                    showing = true;
                }
            }
        }

        if (var1.length != buff2.pos) {
            throw new RuntimeException();
        }
        anInt1329 = var7;
        anIntArray1322 = new int[var7];
        anIntArray1330 = new int[var7];
        anIntArray1326 = new int[var7];
        anIntArray1327 = new int[var7];

        for (var8 = 0; var8 < var7; ++var8) {
            anIntArray1322[var8] = anIntArray1328[var8];
            anIntArray1330[var8] = anIntArray1331[var8];
            anIntArray1326[var8] = anIntArray1325[var8];
            anIntArray1327[var8] = anIntArray1324[var8];
        }

    }
}
