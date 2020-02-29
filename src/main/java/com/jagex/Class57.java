package com.jagex;

import java.util.Comparator;

final class Class57 implements Comparator {
    static int anInt481;

    public static AnimationSequence getAnimationSequence(int var0) {
        AnimationSequence var2 = (AnimationSequence) AnimationSequence.aReferenceCache700.get((long) var0);
        if (var2 != null) {
            return var2;
        }
        byte[] var3 = AnimationSequence.aReferenceTable383.unpack(12, var0);
        var2 = new AnimationSequence();
        if (var3 != null) {
            var2.method260(new Buffer(var3));
        }

        var2.method592();
        AnimationSequence.aReferenceCache700.put(var2, (long) var0);
        return var2;
    }

    static void method330() {
        SceneGraph.aBoolean1980 = false;
        client.lowMemory = false;
    }

    public static byte[] method333(Object var0, boolean var1) {
        if (var0 == null) {
            return null;
        }
        if (var0 instanceof byte[]) {
            byte[] var6 = (byte[]) var0;
            if (var1) {
                int var3 = var6.length;
                byte[] var4 = new byte[var3];
                System.arraycopy(var6, 0, var4, 0, var3);
                return var4;
            }
            return var6;
        }
        if (var0 instanceof Class152) {
            Class152 var2 = (Class152) var0;
            return var2.method802();
        }
        throw new IllegalArgumentException();
    }

    static boolean method331(PlayerEntity var0) {
        if (client.anInt1031 == 0) {
            return false;
        }
        if (PlayerEntity.local != var0) {
            boolean var1 = (client.anInt1031 & 4) != 0;
            boolean var2 = var1;
            boolean var3;
            if (!var1) {
                var3 = (client.anInt1031 & 1) != 0;
                var2 = var3 && var0.method609();
            }

            var3 = var2;
            if (!var2) {
                boolean var4 = (client.anInt1031 & 2) != 0;
                var3 = var4 && var0.method258();
            }

            return var3;
        }
        return Class83.method446();
    }

    int method332(Class72 var1, Class72 var2) {
        return Integer.compare(var1.aGrandExchangeOffer551.itemPrice, var2.aGrandExchangeOffer551.itemPrice);
    }

    public int compare(Object var1, Object var2) {
        return this.method332((Class72) var1, (Class72) var2);
    }

    public boolean equals(Object var1) {
        return super.equals(var1);
    }
}
