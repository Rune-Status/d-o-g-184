package jag.js5;

public final class Bzip2Entry {

    public static int anInt1579;
    public final int anInt1614;
    public final int anInt1595;
    public final int anInt1607;
    public final int anInt1606;
    public final int anInt1602;
    public final int anInt1599;
    public final int[] anIntArray1586;
    public final int[] anIntArray1584;
    public final boolean[] used;
    public final boolean[] used16;
    public final byte[] unseq;
    public final byte[] aByteArray1576;
    public final int[] anIntArray1597;
    public final byte[] aByteArray1600;
    public final byte[] selector;
    public final byte[][] aByteArrayArray1609;
    public final int[][] limit;
    public final int[][] base;
    public final int[][] perm;
    public final int[] minimumLengths;
    public int caret;
    public int anInt1582;
    public byte[] inputBuffer;
    public byte[] outputBuffer;
    public int size;
    public int anInt1605;
    public int anInt1610;
    public int anInt1613;
    public int anInt1598;
    public int blockSize;
    public int anInt1611;
    public int inUseCaret;
    public int anInt1585;
    public byte aByte1578;
    public int anInt1588;
    public int anInt1590;
    public int anInt1604;
    public int anInt1594;

    public Bzip2Entry() {
        anInt1614 = 4096;
        anInt1595 = 16;
        anInt1607 = 258;
        anInt1606 = 6;
        anInt1602 = 50;
        anInt1599 = 18002;
        caret = 0;
        anInt1582 = 0;
        anIntArray1586 = new int[256];
        anIntArray1584 = new int[257];
        used = new boolean[256];
        used16 = new boolean[16];
        unseq = new byte[256];
        aByteArray1576 = new byte[4096];
        anIntArray1597 = new int[16];
        aByteArray1600 = new byte[18002];
        selector = new byte[18002];
        aByteArrayArray1609 = new byte[6][258];
        limit = new int[6][258];
        base = new int[6][258];
        perm = new int[6][258];
        minimumLengths = new int[6];
    }

    public static boolean method1169(int var0) {
        return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
    }

}
