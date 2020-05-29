package jag.opcode;

public class PacketBuffer extends Buffer {
    static final int[] anIntArray1574;

    static {
        anIntArray1574 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
    }

    IsaacCipher cipher;
    int bitCaret;

    public PacketBuffer(int var1) {
        super(var1);
    }

    public void bitAccess() {
        this.bitCaret = super.caret * 8;
    }

    public int method1398(int var1) {
        int var2 = this.bitCaret >> 3;
        int var3 = 8 - (this.bitCaret & 7);
        int var4 = 0;

        for (this.bitCaret += var1; var1 > var3; var3 = 8) {
            var4 += (super.payload[var2++] & anIntArray1574[var3]) << var1 - var3;
            var1 -= var3;
        }

        if (var3 == var1) {
            var4 += super.payload[var2] & anIntArray1574[var3];
        } else {
            var4 += super.payload[var2] >> var3 - var1 & anIntArray1574[var1];
        }

        return var4;
    }

    public boolean method258() {
        int var1 = super.payload[super.caret] - this.cipher.peek() & 255;
        return var1 >= 128;
    }

    public void byteAccess() {
        super.caret = (this.bitCaret + 7) / 8;
    }

    public int method1394(int var1) {
        return var1 * 8 - this.bitCaret;
    }

    public void setCipher(IsaacCipher var1) {
        this.cipher = var1;
    }

    public void writeHeader(int var1) {
        super.payload[++super.caret - 1] = (byte) (var1 + this.cipher.pop());
    }

    public void method1397(byte[] var1, int var2, int var3) {
        for (int var4 = 0; var4 < var3; ++var4) {
            var1[var4 + var2] = (byte) (super.payload[++super.caret - 1] - this.cipher.pop());
        }

    }

    public int readHeader() {
        return super.payload[++super.caret - 1] - this.cipher.pop() & 255;
    }

    public int method1396() {
        int var1 = super.payload[++super.caret - 1] - this.cipher.pop() & 255;
        return var1 < 128 ? var1 : (var1 - 128 << 8) + (super.payload[++super.caret - 1] - this.cipher.pop() & 255);
    }

    public void method1399(int[] var1) {
        this.cipher = new IsaacCipher(var1);
    }
}
