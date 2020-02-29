package com.jagex;

import java.awt.*;

public class CollisionMap {
    public int[][] flags;
    int width;
    int insetX;
    int height;
    int insetY;

    public CollisionMap(int var1, int var2) {
        this.insetX = 0;
        this.insetY = 0;
        this.width = var1;
        this.height = var2;
        this.flags = new int[this.width][this.height];
        this.method162();
    }

    static void method155(Component var0) {
        var0.removeMouseListener(Mouse.instance);
        var0.removeMouseMotionListener(Mouse.instance);
        var0.removeFocusListener(Mouse.instance);
        Mouse.pendingPressMeta = 0;
    }

    static void method163(int var0, byte[] var1, CacheIndex var2) {
        FileSystem var3 = new FileSystem();
        var3.anInt380 = 0;
        var3.key = (long) var0;
        var3.buffer = var1;
        var3.index = var2;
        synchronized (Class174.aNodeDeque1465) {
            Class174.aNodeDeque1465.add(var3);
        }

        synchronized (Class174.anObject1463) {
            if (Class174.anInt1464 == 0) {
                AssociateComparator_Sub5.aThread815 = new Thread(new Class174());
                AssociateComparator_Sub5.aThread815.setDaemon(true);
                AssociateComparator_Sub5.aThread815.start();
                AssociateComparator_Sub5.aThread815.setPriority(5);
            }

            Class174.anInt1464 = 600;
        }
    }

    void method161(int var1, int var2, int var3) {
        int[] var10000 = this.flags[var1];
        var10000[var2] &= ~var3;
    }

    void method156(int var1, int var2, int var3) {
        int[] var10000 = this.flags[var1];
        var10000[var2] |= var3;
    }

    public void method162() {
        for (int var1 = 0; var1 < this.width; ++var1) {
            for (int var2 = 0; var2 < this.height; ++var2) {
                if (var1 != 0 && var2 != 0 && var1 < this.width - 5 && var2 < this.height - 5) {
                    this.flags[var1][var2] = 16777216;
                } else {
                    this.flags[var1][var2] = 16777215;
                }
            }
        }

    }

    public void method159(int var1, int var2) {
        var1 -= this.insetX;
        var2 -= this.insetY;
        int[] var10000 = this.flags[var1];
        var10000[var2] |= 2097152;
    }

    public void method157(int var1, int var2, int var3, int var4, boolean var5) {
        var1 -= this.insetX;
        var2 -= this.insetY;
        if (var3 == 0) {
            if (var4 == 0) {
                this.method161(var1, var2, 128);
                this.method161(var1 - 1, var2, 8);
            }

            if (var4 == 1) {
                this.method161(var1, var2, 2);
                this.method161(var1, var2 + 1, 32);
            }

            if (var4 == 2) {
                this.method161(var1, var2, 8);
                this.method161(var1 + 1, var2, 128);
            }

            if (var4 == 3) {
                this.method161(var1, var2, 32);
                this.method161(var1, var2 - 1, 2);
            }
        }

        if (var3 == 1 || var3 == 3) {
            if (var4 == 0) {
                this.method161(var1, var2, 1);
                this.method161(var1 - 1, var2 + 1, 16);
            }

            if (var4 == 1) {
                this.method161(var1, var2, 4);
                this.method161(var1 + 1, var2 + 1, 64);
            }

            if (var4 == 2) {
                this.method161(var1, var2, 16);
                this.method161(var1 + 1, var2 - 1, 1);
            }

            if (var4 == 3) {
                this.method161(var1, var2, 64);
                this.method161(var1 - 1, var2 - 1, 4);
            }
        }

        if (var3 == 2) {
            if (var4 == 0) {
                this.method161(var1, var2, 130);
                this.method161(var1 - 1, var2, 8);
                this.method161(var1, var2 + 1, 32);
            }

            if (var4 == 1) {
                this.method161(var1, var2, 10);
                this.method161(var1, var2 + 1, 32);
                this.method161(var1 + 1, var2, 128);
            }

            if (var4 == 2) {
                this.method161(var1, var2, 40);
                this.method161(var1 + 1, var2, 128);
                this.method161(var1, var2 - 1, 2);
            }

            if (var4 == 3) {
                this.method161(var1, var2, 160);
                this.method161(var1, var2 - 1, 2);
                this.method161(var1 - 1, var2, 8);
            }
        }

        if (var5) {
            if (var3 == 0) {
                if (var4 == 0) {
                    this.method161(var1, var2, 65536);
                    this.method161(var1 - 1, var2, 4096);
                }

                if (var4 == 1) {
                    this.method161(var1, var2, 1024);
                    this.method161(var1, var2 + 1, 16384);
                }

                if (var4 == 2) {
                    this.method161(var1, var2, 4096);
                    this.method161(var1 + 1, var2, 65536);
                }

                if (var4 == 3) {
                    this.method161(var1, var2, 16384);
                    this.method161(var1, var2 - 1, 1024);
                }
            }

            if (var3 == 1 || var3 == 3) {
                if (var4 == 0) {
                    this.method161(var1, var2, 512);
                    this.method161(var1 - 1, var2 + 1, 8192);
                }

                if (var4 == 1) {
                    this.method161(var1, var2, 2048);
                    this.method161(var1 + 1, var2 + 1, 32768);
                }

                if (var4 == 2) {
                    this.method161(var1, var2, 8192);
                    this.method161(var1 + 1, var2 - 1, 512);
                }

                if (var4 == 3) {
                    this.method161(var1, var2, 32768);
                    this.method161(var1 - 1, var2 - 1, 2048);
                }
            }

            if (var3 == 2) {
                if (var4 == 0) {
                    this.method161(var1, var2, 66560);
                    this.method161(var1 - 1, var2, 4096);
                    this.method161(var1, var2 + 1, 16384);
                }

                if (var4 == 1) {
                    this.method161(var1, var2, 5120);
                    this.method161(var1, var2 + 1, 16384);
                    this.method161(var1 + 1, var2, 65536);
                }

                if (var4 == 2) {
                    this.method161(var1, var2, 20480);
                    this.method161(var1 + 1, var2, 65536);
                    this.method161(var1, var2 - 1, 1024);
                }

                if (var4 == 3) {
                    this.method161(var1, var2, 81920);
                    this.method161(var1, var2 - 1, 1024);
                    this.method161(var1 - 1, var2, 4096);
                }
            }
        }

    }

    public void method152(int var1, int var2) {
        var1 -= this.insetX;
        var2 -= this.insetY;
        int[] var10000 = this.flags[var1];
        var10000[var2] &= -262145;
    }

    public void method153(int var1, int var2, int var3, int var4, int var5, boolean var6) {
        int var7 = 256;
        if (var6) {
            var7 += 131072;
        }

        var1 -= this.insetX;
        var2 -= this.insetY;
        int var8;
        if (var5 == 1 || var5 == 3) {
            var8 = var3;
            var3 = var4;
            var4 = var8;
        }

        for (var8 = var1; var8 < var3 + var1; ++var8) {
            if (var8 >= 0 && var8 < this.width) {
                for (int var9 = var2; var9 < var2 + var4; ++var9) {
                    if (var9 >= 0 && var9 < this.height) {
                        this.method161(var8, var9, var7);
                    }
                }
            }
        }

    }

    public void method158(int var1, int var2) {
        var1 -= this.insetX;
        var2 -= this.insetY;
        int[] var10000 = this.flags[var1];
        var10000[var2] |= 262144;
    }

    public void method160(int var1, int var2, int var3, int var4, boolean var5) {
        int var6 = 256;
        if (var5) {
            var6 += 131072;
        }

        var1 -= this.insetX;
        var2 -= this.insetY;

        for (int var7 = var1; var7 < var3 + var1; ++var7) {
            if (var7 >= 0 && var7 < this.width) {
                for (int var8 = var2; var8 < var2 + var4; ++var8) {
                    if (var8 >= 0 && var8 < this.height) {
                        this.method156(var7, var8, var6);
                    }
                }
            }
        }

    }

    public void method154(int var1, int var2, int var3, int var4, boolean var5) {
        var1 -= this.insetX;
        var2 -= this.insetY;
        if (var3 == 0) {
            if (var4 == 0) {
                this.method156(var1, var2, 128);
                this.method156(var1 - 1, var2, 8);
            }

            if (var4 == 1) {
                this.method156(var1, var2, 2);
                this.method156(var1, var2 + 1, 32);
            }

            if (var4 == 2) {
                this.method156(var1, var2, 8);
                this.method156(var1 + 1, var2, 128);
            }

            if (var4 == 3) {
                this.method156(var1, var2, 32);
                this.method156(var1, var2 - 1, 2);
            }
        }

        if (var3 == 1 || var3 == 3) {
            if (var4 == 0) {
                this.method156(var1, var2, 1);
                this.method156(var1 - 1, var2 + 1, 16);
            }

            if (var4 == 1) {
                this.method156(var1, var2, 4);
                this.method156(var1 + 1, var2 + 1, 64);
            }

            if (var4 == 2) {
                this.method156(var1, var2, 16);
                this.method156(var1 + 1, var2 - 1, 1);
            }

            if (var4 == 3) {
                this.method156(var1, var2, 64);
                this.method156(var1 - 1, var2 - 1, 4);
            }
        }

        if (var3 == 2) {
            if (var4 == 0) {
                this.method156(var1, var2, 130);
                this.method156(var1 - 1, var2, 8);
                this.method156(var1, var2 + 1, 32);
            }

            if (var4 == 1) {
                this.method156(var1, var2, 10);
                this.method156(var1, var2 + 1, 32);
                this.method156(var1 + 1, var2, 128);
            }

            if (var4 == 2) {
                this.method156(var1, var2, 40);
                this.method156(var1 + 1, var2, 128);
                this.method156(var1, var2 - 1, 2);
            }

            if (var4 == 3) {
                this.method156(var1, var2, 160);
                this.method156(var1, var2 - 1, 2);
                this.method156(var1 - 1, var2, 8);
            }
        }

        if (var5) {
            if (var3 == 0) {
                if (var4 == 0) {
                    this.method156(var1, var2, 65536);
                    this.method156(var1 - 1, var2, 4096);
                }

                if (var4 == 1) {
                    this.method156(var1, var2, 1024);
                    this.method156(var1, var2 + 1, 16384);
                }

                if (var4 == 2) {
                    this.method156(var1, var2, 4096);
                    this.method156(var1 + 1, var2, 65536);
                }

                if (var4 == 3) {
                    this.method156(var1, var2, 16384);
                    this.method156(var1, var2 - 1, 1024);
                }
            }

            if (var3 == 1 || var3 == 3) {
                if (var4 == 0) {
                    this.method156(var1, var2, 512);
                    this.method156(var1 - 1, var2 + 1, 8192);
                }

                if (var4 == 1) {
                    this.method156(var1, var2, 2048);
                    this.method156(var1 + 1, var2 + 1, 32768);
                }

                if (var4 == 2) {
                    this.method156(var1, var2, 8192);
                    this.method156(var1 + 1, var2 - 1, 512);
                }

                if (var4 == 3) {
                    this.method156(var1, var2, 32768);
                    this.method156(var1 - 1, var2 - 1, 2048);
                }
            }

            if (var3 == 2) {
                if (var4 == 0) {
                    this.method156(var1, var2, 66560);
                    this.method156(var1 - 1, var2, 4096);
                    this.method156(var1, var2 + 1, 16384);
                }

                if (var4 == 1) {
                    this.method156(var1, var2, 5120);
                    this.method156(var1, var2 + 1, 16384);
                    this.method156(var1 + 1, var2, 65536);
                }

                if (var4 == 2) {
                    this.method156(var1, var2, 20480);
                    this.method156(var1 + 1, var2, 65536);
                    this.method156(var1, var2 - 1, 1024);
                }

                if (var4 == 3) {
                    this.method156(var1, var2, 81920);
                    this.method156(var1, var2 - 1, 1024);
                    this.method156(var1 - 1, var2, 4096);
                }
            }
        }

    }
}
