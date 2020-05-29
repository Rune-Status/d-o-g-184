package jag.opcode;

import jag.EntityUID;
import jag.LoginScreenEffect;
import jag.commons.collection.Node;
import jag.game.relationship.AssociateComparatorByName;
import jag.statics.Statics54;
import jag.statics.Statics56;
import jag.statics.Statics7;
import jag.worldmap.WorldMapIcon;
import jag.game.stockmarket.Class46;

import java.math.BigInteger;

public class Buffer extends Node {

    public static final int[] crc32;
    static final long[] aLongArray1468;

    static {
        crc32 = new int[256];

        int var2;
        for (int var0 = 0; var0 < 256; ++var0) {
            int var1 = var0;

            for (var2 = 0; var2 < 8; ++var2) {
                if ((var1 & 1) == 1) {
                    var1 = var1 >>> 1 ^ -306674912;
                } else {
                    var1 >>>= 1;
                }
            }

            crc32[var0] = var1;
        }

        aLongArray1468 = new long[256];

        for (var2 = 0; var2 < 256; ++var2) {
            long var3 = var2;

            for (int var5 = 0; var5 < 8; ++var5) {
                if ((var3 & 1L) == 1L) {
                    var3 = var3 >>> 1 ^ -3932672073523589310L;
                } else {
                    var3 >>>= 1;
                }
            }

            aLongArray1468[var2] = var3;
        }

    }

    public byte[] payload;
    public int caret;

    public Buffer(int var1) {
        payload = newSyncPooledBuffer(var1);
        caret = 0;
    }

    public Buffer(byte[] payload) {
        this.payload = payload;
        caret = 0;
    }

    public static int stringLengthPlusOne(String var0) {
        return var0.length() + 1;
    }

    public static synchronized byte[] newPooledBuffer(int var0) {
        byte[] var2;
        if (var0 != 100) {
            if (var0 < 100) {
            }
        } else if (Statics56.anInt1641 > 0) {
            var2 = Statics56.aByteArrayArray1639[--Statics56.anInt1641];
            Statics56.aByteArrayArray1639[Statics56.anInt1641] = null;
            return var2;
        }

        if (var0 != 5000) {
            if (var0 < 5000) {
            }
        } else if (Statics56.anInt1643 > 0) {
            var2 = Statics56.aByteArrayArray1638[--Statics56.anInt1643];
            Statics56.aByteArrayArray1638[Statics56.anInt1643] = null;
            return var2;
        }

        if (var0 != 30000) {
            if (var0 < 30000) {
            }
        } else if (Statics56.anInt1640 > 0) {
            var2 = Statics56.aByteArrayArray1636[--Statics56.anInt1640];
            Statics56.aByteArrayArray1636[Statics56.anInt1640] = null;
            return var2;
        }

        if (EntityUID.aByteArrayArrayArray547 != null) {
            for (int var3 = 0; var3 < Statics56.anIntArray1637.length; ++var3) {
                if (Statics56.anIntArray1637[var3] != var0) {
                    if (var0 < Statics56.anIntArray1637[var3]) {
                    }
                } else if (Statics56.anIntArray1642[var3] > 0) {
                    byte[] var4 = EntityUID.aByteArrayArrayArray547[var3][--Statics56.anIntArray1642[var3]];
                    EntityUID.aByteArrayArrayArray547[var3][Statics56.anIntArray1642[var3]] = null;
                    return var4;
                }
            }
        }

        return new byte[var0];
    }

    public static synchronized byte[] newSyncPooledBuffer(int var0) {
        return newPooledBuffer(var0);
    }

    public static int writeEscapedStringBytes(CharSequence sequence, int offset, int length, byte[] buffer, int caret) {
        int size = length - offset;

        for (int i = 0; i < size; ++i) {
            char c = sequence.charAt(i + offset);
            if (c > 0 && c < 128 || c >= 160 && c <= 255) {
                buffer[i + caret] = (byte) c;
            } else if (c == 8364) {
                buffer[i + caret] = -128;
            } else if (c == 8218) {
                buffer[i + caret] = -126;
            } else if (c == 402) {
                buffer[i + caret] = -125;
            } else if (c == 8222) {
                buffer[i + caret] = -124;
            } else if (c == 8230) {
                buffer[i + caret] = -123;
            } else if (c == 8224) {
                buffer[i + caret] = -122;
            } else if (c == 8225) {
                buffer[i + caret] = -121;
            } else if (c == 710) {
                buffer[i + caret] = -120;
            } else if (c == 8240) {
                buffer[i + caret] = -119;
            } else if (c == 352) {
                buffer[i + caret] = -118;
            } else if (c == 8249) {
                buffer[i + caret] = -117;
            } else if (c == 338) {
                buffer[i + caret] = -116;
            } else if (c == 381) {
                buffer[i + caret] = -114;
            } else if (c == 8216) {
                buffer[i + caret] = -111;
            } else if (c == 8217) {
                buffer[i + caret] = -110;
            } else if (c == 8220) {
                buffer[i + caret] = -109;
            } else if (c == 8221) {
                buffer[i + caret] = -108;
            } else if (c == 8226) {
                buffer[i + caret] = -107;
            } else if (c == 8211) {
                buffer[i + caret] = -106;
            } else if (c == 8212) {
                buffer[i + caret] = -105;
            } else if (c == 732) {
                buffer[i + caret] = -104;
            } else if (c == 8482) {
                buffer[i + caret] = -103;
            } else if (c == 353) {
                buffer[i + caret] = -102;
            } else if (c == 8250) {
                buffer[i + caret] = -101;
            } else if (c == 339) {
                buffer[i + caret] = -100;
            } else if (c == 382) {
                buffer[i + caret] = -98;
            } else if (c == 376) {
                buffer[i + caret] = -97;
            } else {
                buffer[i + caret] = 63;
            }
        }

        return size;
    }

    public long readLong() {
        long a = (long) readInt() & 0xffffffffL;
        long b = (long) readInt() & 0xffffffffL;
        return b + (a << 32);
    }

    public int readSmart() {
        int ubyte = payload[caret] & 0xff;
        return ubyte >= 128 ? readUShort() - 32768 : readUByte();
    }

    public void writeCString(String var1) {
        int var2 = var1.indexOf(0);
        if (var2 >= 0) {
            throw new IllegalArgumentException("");
        }
        caret += writeEscapedStringBytes(var1, 0, var1.length(), payload, caret);
        payload[caret++] = 0;
    }

    public String readString() {
        int var1 = caret;

        while (payload[caret++] != 0) {

        }

        int var2 = caret - var1 - 1;
        return var2 == 0 ? "" : Class46.readStringFromBytes(payload, var1, var2);
    }

    public int readInt() {
        return ((payload[caret++] & 0xff) << 24)
                + ((payload[caret++] & 0xff) << 16)
                + ((payload[caret++] & 0xff) << 8)
                + (payload[caret++] & 0xff);
    }

    public int readUByte() {
        return payload[caret++] & 0xff;
    }

    public void writeByte(int var1) {
        payload[caret++] = (byte) var1;
    }

    public int readMediumInt() {
        return ((payload[caret++] & 0xff) << 16)
                + ((payload[caret++] & 0xff) << 8)
                + (payload[caret++] & 0xff);
    }

    public int method1051() {
        if (payload[caret] < 0) {
            return readInt() & Integer.MAX_VALUE;
        }
        int var1 = readUShort();
        return var1 == 32767 ? -1 : var1;
    }

    public int method1044() {
        byte var1 = payload[caret++];

        int var2;
        for (var2 = 0; var1 < 0; var1 = payload[caret++]) {
            var2 = (var2 | var1 & 127) << 7;
        }

        return var2 | var1;
    }

    public void writeLong(long var1) {
        payload[caret++] = (byte) ((int) (var1 >> 56));
        payload[caret++] = (byte) ((int) (var1 >> 48));
        payload[caret++] = (byte) ((int) (var1 >> 40));
        payload[caret++] = (byte) ((int) (var1 >> 32));
        payload[caret++] = (byte) ((int) (var1 >> 24));
        payload[caret++] = (byte) ((int) (var1 >> 16));
        payload[caret++] = (byte) ((int) (var1 >> 8));
        payload[caret++] = (byte) ((int) var1);
    }

    public byte readByte() {
        return payload[caret++];
    }

    public void writeInt(int value) {
        payload[caret++] = (byte) (value >> 24);
        payload[caret++] = (byte) (value >> 16);
        payload[caret++] = (byte) (value >> 8);
        payload[caret++] = (byte) value;
    }

    public int readUShort() {
        return ((payload[caret++] & 0xff) << 8) + (payload[caret++] & 0xff);
    }

    public void readBytes(byte[] var1, int var2, int var3) {
        for (int var4 = var2; var4 < var3 + var2; ++var4) {
            var1[var4] = payload[caret++];
        }

    }

    public int method1060() {
        return (payload[caret++] - 128 & 0xff) + ((payload[caret++] & 0xff) << 8);
    }

    public void writeShort(int value) {
        payload[caret++] = (byte) (value >> 8);
        payload[caret++] = (byte) value;
    }

    public int readLEUShortA() {
        return (payload[caret++] & 0xff) + ((payload[caret++] & 0xff) << 8);
    }

    public int method1074() {
        return 128 - payload[caret++] & 0xff;
    }

    public int method1029() {
        int var1 = ((payload[caret++] & 0xff) << 8) + (payload[caret++] & 0xff);
        if (var1 > 32767) {
            var1 -= 65536;
        }

        return var1;
    }

    public String readCString() {
        byte var1 = payload[caret++];
        if (var1 != 0) {
            throw new IllegalStateException("");
        }
        int var2 = caret;

        while (payload[caret++] != 0) {
        }

        int var3 = caret - var2 - 1;
        return var3 == 0 ? "" : Class46.readStringFromBytes(payload, var2, var3);
    }

    public void writeFlags(int flags) {
        if ((flags & -128) != 0) {
            if ((flags & -16384) != 0) {
                if ((flags & -2097152) != 0) {
                    if ((flags & -268435456) != 0) {
                        writeByte(flags >>> 28 | 128);
                    }
                    writeByte(flags >>> 21 | 128);
                }
                writeByte(flags >>> 14 | 128);
            }
            writeByte(flags >>> 7 | 128);
        }
        writeByte(flags & 127);
    }

    public int writeCrc(int var1) {
        int crc = LoginScreenEffect.crc32(payload, var1, caret);
        writeInt(crc);
        return crc;
    }

    public void writeBytes(byte[] var1, int var2, int var3) {
        for (int var4 = var2; var4 < var3 + var2; ++var4) {
            payload[caret++] = var1[var4];
        }
    }

    public int method1035() {
        return payload[caret] < 0 ? readInt() & Integer.MAX_VALUE : readUShort();
    }

    public void method1069(int[] keys, int start, int end) {
        int var4 = caret;
        caret = start;
        int var5 = (end - start) / 8;

        for (int var6 = 0; var6 < var5; ++var6) {
            int var7 = readInt();
            int var8 = readInt();
            int var9 = 0xc6ef3720;
            int var10 = 0x9e3779b9;

            for (int var11 = 32; var11-- > 0; var7 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + keys[var9 & 3]) {
                var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ keys[var9 >>> 11 & 3] + var9;
                var9 -= var10;
            }

            caret -= 8;
            writeInt(var7);
            writeInt(var8);
        }

        caret = var4;
    }

    public void writeLEInt(int var1) {
        payload[caret++] = (byte) var1;
        payload[caret++] = (byte) (var1 >> 8);
        payload[caret++] = (byte) (var1 >> 16);
        payload[caret++] = (byte) (var1 >> 24);
    }

    public void writeLEShortA(int var1) {
        payload[caret++] = (byte) (var1 + 128);
        payload[caret++] = (byte) (var1 >> 8);
    }

    public void writeBoolean(boolean var1) {
        writeByte(var1 ? 1 : 0);
    }

    public void writeMediumInt(int var1) {
        payload[caret++] = (byte) (var1 >> 16);
        payload[caret++] = (byte) (var1 >> 8);
        payload[caret++] = (byte) var1;
    }

    public void cache() {
        if (payload != null) {
            Statics54.method445(payload);
        }

        payload = null;
    }

    public void writeLEShort(int var1) {
        payload[caret++] = (byte) var1;
        payload[caret++] = (byte) (var1 >> 8);
    }

    public int method1072() {
        return 0 - payload[caret++] & 0xff;
    }

    public int method1055() {
        return ((payload[caret++] & 0xff) << 8) + (payload[caret++] - 128 & 0xff);
    }

    public String readCheckedString() {
        if (payload[caret] == 0) {
            caret++;
            return null;
        }
        return readString();
    }

    public boolean readBoolean() {
        return (readUByte() & 1) == 1;
    }

    public int method1046() {
        int ubyte = payload[caret] & 0xff;
        return ubyte < 128 ? readUByte() - 64 : readUShort() - 49152;
    }

    public void writeIMEInt(int var1) {
        payload[caret++] = (byte) (var1 >> 8);
        payload[caret++] = (byte) var1;
        payload[caret++] = (byte) (var1 >> 24);
        payload[caret++] = (byte) (var1 >> 16);
    }

    public void method1027(String var1) {
        int var2 = var1.indexOf(0);
        if (var2 >= 0) {
            throw new IllegalArgumentException("");
        }
        payload[caret++] = 0;
        caret += writeEscapedStringBytes(var1, 0, var1.length(), payload, caret);
        payload[caret++] = 0;
    }

    public void method1014(int var1) {
        payload[caret++] = (byte) (var1 >> 16);
        payload[caret++] = (byte) (var1 >> 24);
        payload[caret++] = (byte) var1;
        payload[caret++] = (byte) (var1 >> 8);
    }

    public void method1050(int var1) {
        if (var1 >= 0 && var1 <= 255) {
            payload[caret - var1 - 1] = (byte) var1;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int method1070() {
        int var1 = (payload[caret++] - 128 & 0xff) + ((payload[caret++] & 0xff) << 8);
        if (var1 > 32767) {
            var1 -= 65536;
        }

        return var1;
    }

    public int method1015() {
        return (payload[caret++] & 0xff)
                + ((payload[caret++] & 0xff) << 8)
                + ((payload[caret++] & 0xff) << 16)
                + ((payload[caret++] & 0xff) << 24);
    }

    public int method1056() {
        return payload[caret++] - 128 & 0xff;
    }

    public void writeShortA(int var1) {
        payload[caret++] = (byte) (var1 >> 8);
        payload[caret++] = (byte) (var1 + 128);
    }

    public void writeNegatedByte(int var1) {
        payload[caret++] = (byte) (0 - var1);
    }

    public byte method1075() {
        return (byte) (0 - payload[caret++]);
    }

    public void method1058(int var1) {
        payload[caret++] = (byte) (var1 + 128);
    }

    public void writeByteS(int var1) {
        payload[caret++] = (byte) (128 - var1);
    }

    public byte method1063() {
        return (byte) (payload[caret++] - 128);
    }

    public int method1019() {
        return ((payload[caret++] & 0xff) << 8)
                + (payload[caret++] & 0xff)
                + ((payload[caret++] & 0xff) << 24)
                + ((payload[caret++] & 0xff) << 16);
    }

    public boolean matchCrcs() {
        caret -= 4;
        int var1 = LoginScreenEffect.crc32(payload, 0, caret);
        int var2 = readInt();
        return var2 == var1;
    }

    public int method1067() {
        int var1 = ((payload[caret++] & 0xff) << 8) + (payload[caret++] - 128 & 0xff);
        if (var1 > 32767) {
            var1 -= 65536;
        }

        return var1;
    }

    public int method1011() {
        return ((payload[caret++] & 0xff) << 16)
                + ((payload[caret++] & 0xff) << 24)
                + (payload[caret++] & 0xff)
                + ((payload[caret++] & 0xff) << 8);
    }

    public String method1045() {
        byte var1 = payload[caret++];
        if (var1 != 0) {
            throw new IllegalStateException("");
        }
        int var2 = method1044();
        if (var2 + caret > payload.length) {
            throw new IllegalStateException("");
        }
        String var3 = AssociateComparatorByName.method719(payload, caret, var2);
        caret += var2;
        return var3;
    }

    public byte method1059() {
        return (byte) (128 - payload[caret++]);
    }

    public void method1041(int var1) {
        if (var1 >= 0 && var1 <= 65535) {
            payload[caret - var1 - 2] = (byte) (var1 >> 8);
            payload[caret - var1 - 1] = (byte) var1;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void writeRSA(BigInteger var1, BigInteger var2) {
        int var3 = caret;
        caret = 0;
        byte[] var4 = new byte[var3];
        readBytes(var4, 0, var3);
        BigInteger var5 = new BigInteger(var4);
        BigInteger var6 = var5.modPow(var1, var2);
        byte[] var7 = var6.toByteArray();
        caret = 0;
        writeShort(var7.length);
        writeBytes(var7, 0, var7.length);
    }

    public void method1062(int var1) {
        payload[caret++] = (byte) var1;
        payload[caret++] = (byte) (var1 >> 8);
        payload[caret++] = (byte) (var1 >> 16);
    }

    public int method1078() {
        int var1 = (payload[caret++] & 0xff) + ((payload[caret++] & 0xff) << 8);
        if (var1 > 32767) {
            var1 -= 65536;
        }

        return var1;
    }

    public int readSmarts() {
        int var1 = 0;

        int var2;
        for (var2 = readSmart(); var2 == 32767; var2 = readSmart()) {
            var1 += 32767;
        }

        var1 += var2;
        return var1;
    }

    public void method1052(CharSequence var1) {
        int var2 = Statics7.method702(var1);
        payload[caret++] = 0;
        writeFlags(var2);
        caret += WorldMapIcon.method202(payload, caret, var1);
    }

    public void method1032(int var1) {
        if (var1 < 0) {
            throw new IllegalArgumentException();
        }
        payload[caret - var1 - 4] = (byte) (var1 >> 24);
        payload[caret - var1 - 3] = (byte) (var1 >> 16);
        payload[caret - var1 - 2] = (byte) (var1 >> 8);
        payload[caret - var1 - 1] = (byte) var1;
    }

    public void writeSmart(int var1) {
        if (var1 >= 0 && var1 < 128) {
            writeByte(var1);
        } else if (var1 >= 0 && var1 < 32768) {
            writeShort(var1 + 32768);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void method1022(long var1) {
        payload[caret++] = (byte) ((int) (var1 >> 40));
        payload[caret++] = (byte) ((int) (var1 >> 32));
        payload[caret++] = (byte) ((int) (var1 >> 24));
        payload[caret++] = (byte) ((int) (var1 >> 16));
        payload[caret++] = (byte) ((int) (var1 >> 8));
        payload[caret++] = (byte) ((int) var1);
    }

    public int method1017() {
        return (payload[caret++] & 0xff)
                + ((payload[caret++] & 0xff) << 8)
                + ((payload[caret++] & 0xff) << 16);
    }

    public void method1076(int[] keys) {
        int var2 = caret / 8;
        caret = 0;

        for (int var3 = 0; var3 < var2; ++var3) {
            int var4 = readInt();
            int var5 = readInt();
            int var6 = 0;
            int var7 = 0x9e3779b9;

            for (int var8 = 32; var8-- > 0; var5 += var4 + (var4 << 4 ^ var4 >>> 5) ^ keys[var6 >>> 11 & 3] + var6) {
                var4 += var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + keys[var6 & 3];
                var6 += var7;
            }

            caret -= 8;
            writeInt(var4);
            writeInt(var5);
        }

    }

    public void method1076(int[] var1, int var2, int var3) {
        int var4 = caret;
        caret = var2;
        int var5 = (var3 - var2) / 8;

        for (int var6 = 0; var6 < var5; ++var6) {
            int var7 = readInt();
            int var8 = readInt();
            int var9 = 0;
            int var10 = 0x9e3779b9;

            for (int var11 = 32; var11-- > 0; var8 += var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9) {
                var7 += var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3];
                var9 += var10;
            }

            caret -= 8;
            writeInt(var7);
            writeInt(var8);
        }

        caret = var4;
    }

    public void method1065(int[] var1) {
        int var2 = caret / 8;
        caret = 0;

        for (int var3 = 0; var3 < var2; ++var3) {
            int var4 = readInt();
            int var5 = readInt();
            int var6 = -957401312;
            int var7 = -1640531527;

            for (int var8 = 32; var8-- > 0; var4 -= var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3]) {
                var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6;
                var6 -= var7;
            }

            caret -= 8;
            writeInt(var4);
            writeInt(var5);
        }

    }

    public void method1016(byte[] var1, int var2, int var3) {
        for (int var4 = var3 + var2 - 1; var4 >= var2; --var4) {
            var1[var4] = (byte) (payload[caret++] - 128);
        }

    }

    public void method1012(byte[] var1, int var2, int var3) {
        for (int var4 = var2; var4 < var3 + var2; ++var4) {
            var1[var4] = (byte) (payload[caret++] - 128);
        }

    }
}
