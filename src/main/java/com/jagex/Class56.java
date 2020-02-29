package com.jagex;

import java.util.Comparator;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

final class Class56 implements Comparator {
    static ReferenceTable aReferenceTable480;

    public static AudioSystem method329(int var1, int var2) {
        if (Class105.anInt775 == 0) {
            throw new IllegalStateException();
        }
        if (var1 >= 0 && var1 < 2) {
            if (var2 < 256) {
                var2 = 256;
            }

            try {
                AudioSystem var3 = AudioSystem.aClass58_1840.method99();
                var3.samples = new int[256 * (AudioSystem.aBoolean1841 ? 2 : 1)];
                var3.anInt1847 = var2;
                var3.method1089();
                var3.anInt1834 = (var2 & -1024) + 1024;
                if (var3.anInt1834 > 16384) {
                    var3.anInt1834 = 16384;
                }

                var3.method1090(var3.anInt1834);
                if (Class77.anInt603 > 0 && Jagception.anAudioRunnable1880 == null) {
                    Jagception.anAudioRunnable1880 = new AudioRunnable();
                    AudioSystem.aScheduledExecutorService1839 = Executors.newScheduledThreadPool(1);
                    AudioSystem.aScheduledExecutorService1839.scheduleAtFixedRate(Jagception.anAudioRunnable1880, 0L, 10L, TimeUnit.MILLISECONDS);
                }

                if (Jagception.anAudioRunnable1880 != null) {
                    if (Jagception.anAudioRunnable1880.systems[var1] != null) {
                        throw new IllegalArgumentException();
                    }

                    Jagception.anAudioRunnable1880.systems[var1] = var3;
                }

                return var3;
            } catch (Throwable var4) {
                return new AudioSystem();
            }
        }
        throw new IllegalArgumentException();
    }

    public static void method327(ReferenceTable var0) {
        Varpbit.aReferenceTable383 = var0;
    }

    public static void method328(String[] var0, short[] var1, int var2, int var3) {
        if (var2 < var3) {
            int var4 = (var3 + var2) / 2;
            int var5 = var2;
            String var6 = var0[var4];
            var0[var4] = var0[var3];
            var0[var3] = var6;
            short var7 = var1[var4];
            var1[var4] = var1[var3];
            var1[var3] = var7;

            for (int var8 = var2; var8 < var3; ++var8) {
                if (var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
                    String var9 = var0[var8];
                    var0[var8] = var0[var5];
                    var0[var5] = var9;
                    short var10 = var1[var8];
                    var1[var8] = var1[var5];
                    var1[var5++] = var10;
                }
            }

            var0[var3] = var0[var5];
            var0[var5] = var6;
            var1[var3] = var1[var5];
            var1[var5] = var7;
            method328(var0, var1, var2, var5 - 1);
            method328(var0, var1, var5 + 1, var3);
        }

    }

    int method326(Class72 var1, Class72 var2) {
        return var1.method390().compareTo(var2.method390());
    }

    public int compare(Object var1, Object var2) {
        return this.method326((Class72) var1, (Class72) var2);
    }

    public boolean equals(Object var1) {
        return super.equals(var1);
    }
}
