package com.jagex;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Class16 {
    static int anInt168;
    byte[][][] aByteArrayArrayArray171;
    int anInt170;

    Class16(int var1) {
        this.anInt170 = var1;
    }

    static String method131(int var0) {
        if (var0 < 0) {
            return "";
        }
        return client.menuTargets[var0].length() > 0 ? client.menuActions[var0] + " " + client.menuTargets[var0] : client.menuActions[var0];
    }

    public static Sprite method130(byte[] var0) {
        BufferedImage var1 = null;

        try {
            var1 = ImageIO.read(new ByteArrayInputStream(var0));
            int var2 = var1.getWidth();
            int var3 = var1.getHeight();
            int[] var4 = new int[var2 * var3];
            PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var2, var3, var4, 0, var2);
            var5.grabPixels();
            return new Sprite(var4, var2, var3);
        } catch (IOException | InterruptedException ignored) {
        }

        return new Sprite(0, 0);
    }

    static void method118(int var0, int var1) {
        if (Class63_Sub2.loadInterface(var0)) {
            MouseRecorder.method265(AssociateComparator_Sub5.interfaces[var0], var1);
        }
    }

    static void method126(byte[] var0, int var1, int var2, int var3, int var4, CollisionMap[] var5) {
        int var7;
        int var8;
        for (int var6 = 0; var6 < 4; ++var6) {
            for (var7 = 0; var7 < 64; ++var7) {
                for (var8 = 0; var8 < 64; ++var8) {
                    if (var7 + var1 > 0 && var7 + var1 < 103 && var8 + var2 > 0 && var8 + var2 < 103) {
                        int[] var10000 = var5[var6].flags[var7 + var1];
                        var10000[var2 + var8] &= -16777217;
                    }
                }
            }
        }

        Buffer var9 = new Buffer(var0);

        for (var7 = 0; var7 < 4; ++var7) {
            for (var8 = 0; var8 < 64; ++var8) {
                for (int var10 = 0; var10 < 64; ++var10) {
                    Class76.method416(var9, var7, var8 + var1, var10 + var2, var3, var4, 0);
                }
            }
        }

    }

    void method124() {
        byte[] var1 = new byte[this.anInt170 * this.anInt170];
        int var2 = 0;

        int var3;
        int var4;
        for (var3 = 0; var3 < this.anInt170; ++var3) {
            for (var4 = 0; var4 < this.anInt170; ++var4) {
                if (var4 <= var3) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.aByteArrayArrayArray171[0][0] = var1;
        var1 = new byte[this.anInt170 * this.anInt170];
        var2 = 0;

        for (var3 = this.anInt170 - 1; var3 >= 0; --var3) {
            for (var4 = 0; var4 < this.anInt170; ++var4) {
                if (var4 <= var3) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.aByteArrayArrayArray171[0][1] = var1;
        var1 = new byte[this.anInt170 * this.anInt170];
        var2 = 0;

        for (var3 = 0; var3 < this.anInt170; ++var3) {
            for (var4 = 0; var4 < this.anInt170; ++var4) {
                if (var4 >= var3) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.aByteArrayArrayArray171[0][2] = var1;
        var1 = new byte[this.anInt170 * this.anInt170];
        var2 = 0;

        for (var3 = this.anInt170 - 1; var3 >= 0; --var3) {
            for (var4 = 0; var4 < this.anInt170; ++var4) {
                if (var4 >= var3) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.aByteArrayArrayArray171[0][3] = var1;
    }

    int method121(int var1, int var2) {
        if (var2 == 9) {
            var1 = var1 + 1 & 3;
        }

        if (var2 == 10) {
            var1 = var1 + 3 & 3;
        }

        if (var2 == 11) {
            var1 = var1 + 3 & 3;
        }

        return var1;
    }

    void method122() {
        byte[] var1 = new byte[this.anInt170 * this.anInt170];
        int var2 = 0;

        int var3;
        int var4;
        for (var3 = this.anInt170 - 1; var3 >= 0; --var3) {
            for (var4 = 0; var4 < this.anInt170; ++var4) {
                if (var4 <= var3 >> 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.aByteArrayArrayArray171[1][0] = var1;
        var1 = new byte[this.anInt170 * this.anInt170];
        var2 = 0;

        for (var3 = 0; var3 < this.anInt170; ++var3) {
            for (var4 = 0; var4 < this.anInt170; ++var4) {
                if (var2 >= 0 && var2 < var1.length) {
                    if (var4 >= var3 << 1) {
                        var1[var2] = -1;
                    }

                    ++var2;
                } else {
                    ++var2;
                }
            }
        }

        this.aByteArrayArrayArray171[1][1] = var1;
        var1 = new byte[this.anInt170 * this.anInt170];
        var2 = 0;

        for (var3 = 0; var3 < this.anInt170; ++var3) {
            for (var4 = this.anInt170 - 1; var4 >= 0; --var4) {
                if (var4 <= var3 >> 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.aByteArrayArrayArray171[1][2] = var1;
        var1 = new byte[this.anInt170 * this.anInt170];
        var2 = 0;

        for (var3 = this.anInt170 - 1; var3 >= 0; --var3) {
            for (var4 = this.anInt170 - 1; var4 >= 0; --var4) {
                if (var4 >= var3 << 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.aByteArrayArrayArray171[1][3] = var1;
    }

    int method127(int var1) {
        if (var1 != 9 && var1 != 10) {
            return var1 == 11 ? 8 : var1;
        }
        return 1;
    }

    void method123() {
        byte[] var1 = new byte[this.anInt170 * this.anInt170];
        int var2 = 0;

        int var3;
        int var4;
        for (var3 = this.anInt170 - 1; var3 >= 0; --var3) {
            for (var4 = this.anInt170 - 1; var4 >= 0; --var4) {
                if (var4 <= var3 >> 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.aByteArrayArrayArray171[2][0] = var1;
        var1 = new byte[this.anInt170 * this.anInt170];
        var2 = 0;

        for (var3 = this.anInt170 - 1; var3 >= 0; --var3) {
            for (var4 = 0; var4 < this.anInt170; ++var4) {
                if (var4 >= var3 << 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.aByteArrayArrayArray171[2][1] = var1;
        var1 = new byte[this.anInt170 * this.anInt170];
        var2 = 0;

        for (var3 = 0; var3 < this.anInt170; ++var3) {
            for (var4 = 0; var4 < this.anInt170; ++var4) {
                if (var4 <= var3 >> 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.aByteArrayArrayArray171[2][2] = var1;
        var1 = new byte[this.anInt170 * this.anInt170];
        var2 = 0;

        for (var3 = 0; var3 < this.anInt170; ++var3) {
            for (var4 = this.anInt170 - 1; var4 >= 0; --var4) {
                if (var4 >= var3 << 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.aByteArrayArrayArray171[2][3] = var1;
    }

    void method119() {
        byte[] var1 = new byte[this.anInt170 * this.anInt170];
        int var2 = 0;

        int var3;
        int var4;
        for (var3 = this.anInt170 - 1; var3 >= 0; --var3) {
            for (var4 = 0; var4 < this.anInt170; ++var4) {
                if (var4 >= var3 >> 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.aByteArrayArrayArray171[3][0] = var1;
        var1 = new byte[this.anInt170 * this.anInt170];
        var2 = 0;

        for (var3 = 0; var3 < this.anInt170; ++var3) {
            for (var4 = 0; var4 < this.anInt170; ++var4) {
                if (var4 <= var3 << 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.aByteArrayArrayArray171[3][1] = var1;
        var1 = new byte[this.anInt170 * this.anInt170];
        var2 = 0;

        for (var3 = 0; var3 < this.anInt170; ++var3) {
            for (var4 = this.anInt170 - 1; var4 >= 0; --var4) {
                if (var4 >= var3 >> 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.aByteArrayArrayArray171[3][2] = var1;
        var1 = new byte[this.anInt170 * this.anInt170];
        var2 = 0;

        for (var3 = this.anInt170 - 1; var3 >= 0; --var3) {
            for (var4 = this.anInt170 - 1; var4 >= 0; --var4) {
                if (var4 <= var3 << 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.aByteArrayArrayArray171[3][3] = var1;
    }

    void method128() {
        byte[] var1 = new byte[this.anInt170 * this.anInt170];
        int var2 = 0;

        int var3;
        int var4;
        for (var3 = this.anInt170 - 1; var3 >= 0; --var3) {
            for (var4 = this.anInt170 - 1; var4 >= 0; --var4) {
                if (var4 >= var3 >> 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.aByteArrayArrayArray171[4][0] = var1;
        var1 = new byte[this.anInt170 * this.anInt170];
        var2 = 0;

        for (var3 = this.anInt170 - 1; var3 >= 0; --var3) {
            for (var4 = 0; var4 < this.anInt170; ++var4) {
                if (var4 <= var3 << 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.aByteArrayArrayArray171[4][1] = var1;
        var1 = new byte[this.anInt170 * this.anInt170];
        var2 = 0;

        for (var3 = 0; var3 < this.anInt170; ++var3) {
            for (var4 = 0; var4 < this.anInt170; ++var4) {
                if (var4 >= var3 >> 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.aByteArrayArrayArray171[4][2] = var1;
        var1 = new byte[this.anInt170 * this.anInt170];
        var2 = 0;

        for (var3 = 0; var3 < this.anInt170; ++var3) {
            for (var4 = this.anInt170 - 1; var4 >= 0; --var4) {
                if (var4 <= var3 << 1) {
                    var1[var2] = -1;
                }

                ++var2;
            }
        }

        this.aByteArrayArrayArray171[4][3] = var1;
    }

    void method117() {
        byte[] var1 = new byte[this.anInt170 * this.anInt170];
        boolean var2 = false;
        var1 = new byte[this.anInt170 * this.anInt170];
        int var5 = 0;

        int var3;
        int var4;
        for (var3 = 0; var3 < this.anInt170; ++var3) {
            for (var4 = 0; var4 < this.anInt170; ++var4) {
                if (var4 <= this.anInt170 / 2) {
                    var1[var5] = -1;
                }

                ++var5;
            }
        }

        this.aByteArrayArrayArray171[5][0] = var1;
        var1 = new byte[this.anInt170 * this.anInt170];
        var5 = 0;

        for (var3 = 0; var3 < this.anInt170; ++var3) {
            for (var4 = 0; var4 < this.anInt170; ++var4) {
                if (var3 <= this.anInt170 / 2) {
                    var1[var5] = -1;
                }

                ++var5;
            }
        }

        this.aByteArrayArrayArray171[5][1] = var1;
        var1 = new byte[this.anInt170 * this.anInt170];
        var5 = 0;

        for (var3 = 0; var3 < this.anInt170; ++var3) {
            for (var4 = 0; var4 < this.anInt170; ++var4) {
                if (var4 >= this.anInt170 / 2) {
                    var1[var5] = -1;
                }

                ++var5;
            }
        }

        this.aByteArrayArrayArray171[5][2] = var1;
        var1 = new byte[this.anInt170 * this.anInt170];
        var5 = 0;

        for (var3 = 0; var3 < this.anInt170; ++var3) {
            for (var4 = 0; var4 < this.anInt170; ++var4) {
                if (var3 >= this.anInt170 / 2) {
                    var1[var5] = -1;
                }

                ++var5;
            }
        }

        this.aByteArrayArrayArray171[5][3] = var1;
    }

    void method116() {
        byte[] var1 = new byte[this.anInt170 * this.anInt170];
        boolean var2 = false;
        var1 = new byte[this.anInt170 * this.anInt170];
        int var5 = 0;

        int var3;
        int var4;
        for (var3 = 0; var3 < this.anInt170; ++var3) {
            for (var4 = 0; var4 < this.anInt170; ++var4) {
                if (var4 <= var3 - this.anInt170 / 2) {
                    var1[var5] = -1;
                }

                ++var5;
            }
        }

        this.aByteArrayArrayArray171[6][0] = var1;
        var1 = new byte[this.anInt170 * this.anInt170];
        var5 = 0;

        for (var3 = this.anInt170 - 1; var3 >= 0; --var3) {
            for (var4 = 0; var4 < this.anInt170; ++var4) {
                if (var4 <= var3 - this.anInt170 / 2) {
                    var1[var5] = -1;
                }

                ++var5;
            }
        }

        this.aByteArrayArrayArray171[6][1] = var1;
        var1 = new byte[this.anInt170 * this.anInt170];
        var5 = 0;

        for (var3 = this.anInt170 - 1; var3 >= 0; --var3) {
            for (var4 = this.anInt170 - 1; var4 >= 0; --var4) {
                if (var4 <= var3 - this.anInt170 / 2) {
                    var1[var5] = -1;
                }

                ++var5;
            }
        }

        this.aByteArrayArrayArray171[6][2] = var1;
        var1 = new byte[this.anInt170 * this.anInt170];
        var5 = 0;

        for (var3 = 0; var3 < this.anInt170; ++var3) {
            for (var4 = this.anInt170 - 1; var4 >= 0; --var4) {
                if (var4 <= var3 - this.anInt170 / 2) {
                    var1[var5] = -1;
                }

                ++var5;
            }
        }

        this.aByteArrayArrayArray171[6][3] = var1;
    }

    void method115() {
        byte[] var1 = new byte[this.anInt170 * this.anInt170];
        boolean var2 = false;
        var1 = new byte[this.anInt170 * this.anInt170];
        int var5 = 0;

        int var3;
        int var4;
        for (var3 = 0; var3 < this.anInt170; ++var3) {
            for (var4 = 0; var4 < this.anInt170; ++var4) {
                if (var4 >= var3 - this.anInt170 / 2) {
                    var1[var5] = -1;
                }

                ++var5;
            }
        }

        this.aByteArrayArrayArray171[7][0] = var1;
        var1 = new byte[this.anInt170 * this.anInt170];
        var5 = 0;

        for (var3 = this.anInt170 - 1; var3 >= 0; --var3) {
            for (var4 = 0; var4 < this.anInt170; ++var4) {
                if (var4 >= var3 - this.anInt170 / 2) {
                    var1[var5] = -1;
                }

                ++var5;
            }
        }

        this.aByteArrayArrayArray171[7][1] = var1;
        var1 = new byte[this.anInt170 * this.anInt170];
        var5 = 0;

        for (var3 = this.anInt170 - 1; var3 >= 0; --var3) {
            for (var4 = this.anInt170 - 1; var4 >= 0; --var4) {
                if (var4 >= var3 - this.anInt170 / 2) {
                    var1[var5] = -1;
                }

                ++var5;
            }
        }

        this.aByteArrayArrayArray171[7][2] = var1;
        var1 = new byte[this.anInt170 * this.anInt170];
        var5 = 0;

        for (var3 = 0; var3 < this.anInt170; ++var3) {
            for (var4 = this.anInt170 - 1; var4 >= 0; --var4) {
                if (var4 >= var3 - this.anInt170 / 2) {
                    var1[var5] = -1;
                }

                ++var5;
            }
        }

        this.aByteArrayArrayArray171[7][3] = var1;
    }

    void method125() {
        if (this.aByteArrayArrayArray171 == null) {
            this.aByteArrayArrayArray171 = new byte[8][4][];
            this.method124();
            this.method122();
            this.method123();
            this.method119();
            this.method128();
            this.method117();
            this.method116();
            this.method115();
        }
    }

    void method129(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        if (var7 != 0 && this.anInt170 != 0 && this.aByteArrayArrayArray171 != null) {
            var8 = this.method121(var8, var7);
            var7 = this.method127(var7);
            JagGraphics.method1361(var1, var2, var5, var6, var3, var4, this.aByteArrayArrayArray171[var7 - 1][var8], this.anInt170);
        }
    }
}
