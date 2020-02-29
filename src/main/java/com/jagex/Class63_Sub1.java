package com.jagex;

public class Class63_Sub1 extends Class63 {
    static CacheReferenceTable aCacheReferenceTable166;
    int anInt163;
    int anInt164;
    int anInt167;
    int anInt165;

    Class63_Sub1() {
    }

    public static void insertMenuItem(String action, String target, int opcode, int primary, int secondary, int tertiary) {
        ActionPrioritySetting.insertMenuItem(action, target, opcode, primary, secondary, tertiary, false);
    }

    static void messageReceived(int var0, String var1, String var2, String var3) {
        Chatstream var5 = (Chatstream) Class64.chatstreams.get(var0);
        if (var5 == null) {
            var5 = new Chatstream();
            Class64.chatstreams.put(var0, var5);
        }

        Chatline var6 = var5.method514(var0, var1, var2, var3);
        Class64.A_ITERABLE_NODE_TABLE_523.method237(var6, (long) var6.anInt380);
        Class64.A_ITERABLE_DOUBLY_LINKED_NODE___522.method1134(var6);
        client.anInt1066 = client.anInt1075;
    }

    int method110() {
        return this.anInt165;
    }

    int method108() {
        return this.anInt167;
    }

    int method107() {
        return this.anInt164;
    }

    void method111(Buffer var1) {
        this.anInt512 = Math.min(this.anInt512, 4);
        this.aShortArrayArrayArray518 = new short[1][64][64];
        this.aShortArrayArrayArray508 = new short[this.anInt512][64][64];
        this.aByteArrayArrayArray506 = new byte[this.anInt512][64][64];
        this.aByteArrayArrayArray505 = new byte[this.anInt512][64][64];
        this.aClass69ArrayArrayArrayArray511 = new Class69[this.anInt512][64][64][];
        int var2 = var1.readUByte();
        if (var2 != Class24.aClass24_302.anInt300) {
            throw new IllegalStateException("");
        }
        int var3 = var1.readUByte();
        int var4 = var1.readUByte();
        int var5 = var1.readUByte();
        int var6 = var1.readUByte();
        if (var3 == this.anInt517 && var4 == this.anInt516 && var5 == this.anInt165 && var6 == this.anInt167) {
            for (int var7 = 0; var7 < 8; ++var7) {
                for (int var8 = 0; var8 < 8; ++var8) {
                    this.method351(var7 + this.anInt165 * 8, var8 + this.anInt167 * 8, var1);
                }
            }

        } else {
            throw new IllegalStateException("");
        }
    }

    void method109(Buffer var1) {
        int var2 = var1.readUByte();
        if (var2 != Class26.aClass26_312.anInt309) {
            throw new IllegalStateException("");
        }
        this.anInt515 = var1.readUByte();
        this.anInt512 = var1.readUByte();
        this.anInt519 = var1.readUShort() * 4096;
        this.anInt510 = var1.readUShort() * 64;
        this.anInt164 = var1.readUByte();
        this.anInt163 = var1.readUByte();
        this.anInt517 = var1.readUShort();
        this.anInt516 = var1.readUShort();
        this.anInt165 = var1.readUByte();
        this.anInt167 = var1.readUByte();
        this.anInt514 = var1.method1051();
        this.anInt509 = var1.method1051();
    }

    int method106() {
        return this.anInt163;
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof Class63_Sub1)) {
            return false;
        }
        Class63_Sub1 var2 = (Class63_Sub1) var1;
        if (var2.anInt517 == this.anInt517 && this.anInt516 == var2.anInt516) {
            return var2.anInt165 == this.anInt165 && this.anInt167 == var2.anInt167;
        }
        return false;
    }

    public int hashCode() {
        return this.anInt517 | this.anInt516 << 8 | this.anInt165 << 16 | this.anInt167 << 24;
    }
}
