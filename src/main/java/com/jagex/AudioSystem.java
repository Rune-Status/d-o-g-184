package com.jagex;

import javax.sound.sampled.LineUnavailableException;
import java.util.concurrent.ScheduledExecutorService;

public class AudioSystem {
    public static boolean aBoolean1841;
    static ScheduledExecutorService aScheduledExecutorService1839;
    static Class58 aClass58_1840;
    protected int[] samples;
    Node_Sub6[] aNode_Sub6Array1845;
    Node_Sub6 aNode_Sub6_1832;
    int anInt1842;
    boolean aBoolean1837;
    int anInt1834;
    int anInt1846;
    Node_Sub6[] aNode_Sub6Array1830;
    long aLong1843;
    long aLong1844;
    int anInt1833;
    int anInt1831;
    int anInt1836;
    int anInt1847;
    long aLong1838;
    int anInt1835;

    protected AudioSystem() {
        this.anInt1846 = 32;
        this.aLong1844 = Class24.currentTime();
        this.aLong1843 = 0L;
        this.anInt1833 = 0;
        this.anInt1836 = 0;
        this.anInt1831 = 0;
        this.aLong1838 = 0L;
        this.aBoolean1837 = true;
        this.anInt1842 = 0;
        this.aNode_Sub6Array1830 = new Node_Sub6[8];
        this.aNode_Sub6Array1845 = new Node_Sub6[8];
    }

    protected void method1085() {
    }

    protected void method1086() {
    }

    public final synchronized void method1328() {
        if (this.samples != null) {
            long var1 = Class24.currentTime();

            try {
                if (this.aLong1843 != 0L) {
                    if (var1 < this.aLong1843) {
                        return;
                    }

                    this.method1090(this.anInt1834);
                    this.aLong1843 = 0L;
                    this.aBoolean1837 = true;
                }

                int var3 = this.method1088();
                if (this.anInt1831 - var3 > this.anInt1833) {
                    this.anInt1833 = this.anInt1831 - var3;
                }

                int var4 = this.anInt1847 + this.anInt1835;
                if (var4 + 256 > 16384) {
                    var4 = 16128;
                }

                if (var4 + 256 > this.anInt1834) {
                    this.anInt1834 += 1024;
                    if (this.anInt1834 > 16384) {
                        this.anInt1834 = 16384;
                    }

                    this.method1086();
                    this.method1090(this.anInt1834);
                    var3 = 0;
                    this.aBoolean1837 = true;
                    if (var4 + 256 > this.anInt1834) {
                        var4 = this.anInt1834 - 256;
                        this.anInt1835 = var4 - this.anInt1847;
                    }
                }

                while (var3 < var4) {
                    this.method1334(this.samples);
                    this.method1087();
                    var3 += 256;
                }

                if (var1 > this.aLong1838) {
                    if (!this.aBoolean1837) {
                        if (this.anInt1833 == 0 && this.anInt1836 == 0) {
                            this.method1086();
                            this.aLong1843 = var1 + 2000L;
                            return;
                        }

                        this.anInt1835 = Math.min(this.anInt1836, this.anInt1833);
                        this.anInt1836 = this.anInt1833;
                    } else {
                        this.aBoolean1837 = false;
                    }

                    this.anInt1833 = 0;
                    this.aLong1838 = var1 + 2000L;
                }

                this.anInt1831 = var3;
            } catch (Exception var7) {
                this.method1086();
                this.aLong1843 = var1 + 2000L;
            }

            try {
                if (var1 > this.aLong1844 + 500000L) {
                    var1 = this.aLong1844;
                }

                while (var1 > this.aLong1844 + 5000L) {
                    this.method1335();
                    this.aLong1844 += (long) (256000 / Class105.anInt775);
                }
            } catch (Exception var6) {
                this.aLong1844 = var1;
            }

        }
    }

    protected int method1088() {
        return this.anInt1834;
    }

    protected void method1090(int var1) throws LineUnavailableException {
    }

    public final synchronized void method1333() {
        this.aBoolean1837 = true;

        try {
            this.method1085();
        } catch (Exception var2) {
            this.method1086();
            this.aLong1843 = Class24.currentTime() + 2000L;
        }

    }

    final void method1335() {
        this.anInt1842 -= 256;
        if (this.anInt1842 < 0) {
            this.anInt1842 = 0;
        }

        if (this.aNode_Sub6_1832 != null) {
            this.aNode_Sub6_1832.method303(256);
        }

    }

    public final synchronized void method1329() {
        if (Jagception.anAudioRunnable1880 != null) {
            boolean var1 = true;

            for (int var2 = 0; var2 < 2; ++var2) {
                if (this == Jagception.anAudioRunnable1880.systems[var2]) {
                    Jagception.anAudioRunnable1880.systems[var2] = null;
                }

                if (Jagception.anAudioRunnable1880.systems[var2] != null) {
                    var1 = false;
                }
            }

            if (var1) {
                aScheduledExecutorService1839.shutdownNow();
                aScheduledExecutorService1839 = null;
                Jagception.anAudioRunnable1880 = null;
            }
        }

        this.method1086();
        this.samples = null;
    }

    final void method1331(Node_Sub6 var1, int var2) {
        int var3 = var2 >> 5;
        Node_Sub6 var4 = this.aNode_Sub6Array1845[var3];
        if (var4 == null) {
            this.aNode_Sub6Array1830[var3] = var1;
        } else {
            var4.aNode_Sub6_664 = var1;
        }

        this.aNode_Sub6Array1845[var3] = var1;
        var1.anInt666 = var2;
    }

    public final void method1332() {
        this.aBoolean1837 = true;
    }

    final void method1334(int[] var1) {
        int var3 = 256;
        if (aBoolean1841) {
            var3 = 256 << 1;
        }

        Statics31.method1139(var1, 0, var3);
        this.anInt1842 -= 256;
        if (this.aNode_Sub6_1832 != null && this.anInt1842 <= 0) {
            this.anInt1842 += Class105.anInt775 >> 4;
            DynamicObject.method1507(this.aNode_Sub6_1832);
            this.method1331(this.aNode_Sub6_1832, this.aNode_Sub6_1832.method483());
            int var4 = 0;
            int var5 = 255;

            int var6;
            Node_Sub6 var12;
            label104:
            for (var6 = 7; var5 != 0; --var6) {
                int var7;
                int var8;
                if (var6 < 0) {
                    var7 = var6 & 3;
                    var8 = -(var6 >> 2);
                } else {
                    var7 = var6;
                    var8 = 0;
                }

                for (int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
                    if ((var9 & 1) != 0) {
                        var5 &= ~(1 << var7);
                        var12 = null;
                        Node_Sub6 var13 = this.aNode_Sub6Array1830[var7];

                        label98:
                        while (true) {
                            while (true) {
                                if (var13 == null) {
                                    break label98;
                                }

                                Node_Sub10 var14 = var13.aNode_Sub10_667;
                                if (var14 != null && var14.anInt112 > var8) {
                                    var5 |= 1 << var7;
                                    var12 = var13;
                                    var13 = var13.aNode_Sub6_664;
                                } else {
                                    var13.aBoolean665 = true;
                                    int var15 = var13.method305();
                                    var4 += var15;
                                    if (var14 != null) {
                                        var14.anInt112 += var15;
                                    }

                                    if (var4 >= this.anInt1846) {
                                        break label104;
                                    }

                                    Node_Sub6 var16 = var13.method307();
                                    if (var16 != null) {
                                        for (int var17 = var13.anInt666; var16 != null; var16 = var13.method308()) {
                                            this.method1331(var16, var17 * var16.method483() >> 8);
                                        }
                                    }

                                    Node_Sub6 var18 = var13.aNode_Sub6_664;
                                    var13.aNode_Sub6_664 = null;
                                    if (var12 == null) {
                                        this.aNode_Sub6Array1830[var7] = var18;
                                    } else {
                                        var12.aNode_Sub6_664 = var18;
                                    }

                                    if (var18 == null) {
                                        this.aNode_Sub6Array1845[var7] = var12;
                                    }

                                    var13 = var18;
                                }
                            }
                        }
                    }

                    var7 += 4;
                    ++var8;
                }
            }

            for (var6 = 0; var6 < 8; ++var6) {
                Node_Sub6 var10 = this.aNode_Sub6Array1830[var6];
                Node_Sub6[] var11 = this.aNode_Sub6Array1830;
                this.aNode_Sub6Array1845[var6] = null;

                for (var11[var6] = null; var10 != null; var10 = var12) {
                    var12 = var10.aNode_Sub6_664;
                    var10.aNode_Sub6_664 = null;
                }
            }
        }

        if (this.anInt1842 < 0) {
            this.anInt1842 = 0;
        }

        if (this.aNode_Sub6_1832 != null) {
            this.aNode_Sub6_1832.method311(var1, 0, 256);
        }

        this.aLong1844 = Class24.currentTime();
    }

    protected void method1087() {
    }

    public final synchronized void method1330(Node_Sub6 var1) {
        this.aNode_Sub6_1832 = var1;
    }

    protected void method1089() {
    }
}
