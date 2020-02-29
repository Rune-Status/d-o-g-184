package com.jagex;

public class AssociateComparator_Sub5 extends AssociateComparator {
    public static InterfaceComponent[][] interfaces;
    static Thread aThread815;
    final boolean aBoolean764;

    public AssociateComparator_Sub5(boolean var1) {
        this.aBoolean764 = var1;
    }

    public static int stringLengthPlusTwo(String var0) {
        return var0.length() + 2;
    }

    static IterableNodeTable method676(Buffer var0, IterableNodeTable var1) {
        int var2 = var0.readUByte();
        int var3;
        if (var1 == null) {
            var3 = Class180.nextPowerOfTwo(var2);
            var1 = new IterableNodeTable(var3);
        }

        for (var3 = 0; var3 < var2; ++var3) {
            boolean var4 = var0.readUByte() == 1;
            int var5 = var0.readMediumInt();
            Node var6;
            if (var4) {
                var6 = new ObjectNode(var0.readString());
            } else {
                var6 = new IntegerNode(var0.readInt());
            }

            var1.method237(var6, (long) var5);
        }

        return var1;
    }

    int method604(Associate var1, Associate var2) {
        if (var1.world != 0) {
            if (var2.world == 0) {
                return this.aBoolean764 ? -1 : 1;
            }
        } else if (var2.world != 0) {
            return this.aBoolean764 ? 1 : -1;
        }

        return this.method1135(var1, var2);
    }

    public int compare(Associate var1, Associate var2) {
        return this.method604((Associate) var1, (Associate) var2);
    }
}
