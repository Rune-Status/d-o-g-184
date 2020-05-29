package jag;

import jag.game.type.AnimationFrame;
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

    public AnimationFrame aAnimationFrame_1323;
    public boolean showing;
    public int anInt1329;
    public int[] anIntArray1322;
    public int[] anIntArray1330;
    public int[] anIntArray1326;
    public int[] anIntArray1327;

    public Identikit(byte[] var1, AnimationFrame var2) {
        this.aAnimationFrame_1323 = null;
        this.anInt1329 = -1;
        this.showing = false;
        this.aAnimationFrame_1323 = var2;
        Buffer var3 = new Buffer(var1);
        Buffer var4 = new Buffer(var1);
        var3.caret = 2;
        int var5 = var3.readUByte();
        int var6 = -1;
        int var7 = 0;
        var4.caret = var5 + var3.caret;

        int var8;
        for (var8 = 0; var8 < var5; ++var8) {
            int var9 = var3.readUByte();
            if (var9 > 0) {
                if (this.aAnimationFrame_1323.anIntArray749[var8] != 0) {
                    for (int var10 = var8 - 1; var10 > var6; --var10) {
                        if (this.aAnimationFrame_1323.anIntArray749[var10] == 0) {
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
                if (this.aAnimationFrame_1323.anIntArray749[var8] == 3) {
                    var11 = 128;
                }

                if ((var9 & 1) != 0) {
                    anIntArray1331[var7] = var4.method1046();
                } else {
                    anIntArray1331[var7] = var11;
                }

                if ((var9 & 2) != 0) {
                    anIntArray1325[var7] = var4.method1046();
                } else {
                    anIntArray1325[var7] = var11;
                }

                if ((var9 & 4) != 0) {
                    anIntArray1324[var7] = var4.method1046();
                } else {
                    anIntArray1324[var7] = var11;
                }

                var6 = var8;
                ++var7;
                if (this.aAnimationFrame_1323.anIntArray749[var8] == 5) {
                    this.showing = true;
                }
            }
        }

        if (var1.length != var4.caret) {
            throw new RuntimeException();
        }
        this.anInt1329 = var7;
        this.anIntArray1322 = new int[var7];
        this.anIntArray1330 = new int[var7];
        this.anIntArray1326 = new int[var7];
        this.anIntArray1327 = new int[var7];

        for (var8 = 0; var8 < var7; ++var8) {
            this.anIntArray1322[var8] = anIntArray1328[var8];
            this.anIntArray1330[var8] = anIntArray1331[var8];
            this.anIntArray1326[var8] = anIntArray1325[var8];
            this.anIntArray1327[var8] = anIntArray1324[var8];
        }

    }
}
