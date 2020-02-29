package com.jagex;

public class Statics13 {
    static DoublyLinkedNode_Sub6 method870(int var0) {
        DoublyLinkedNode_Sub6 var1 = (DoublyLinkedNode_Sub6) AnimationSequence.aReferenceCache1228.get((long) var0);
        if (var1 != null) {
            return var1;
        }
        ReferenceTable var2 = AnimationSequence.aReferenceTable697;
        ReferenceTable var3 = Statics8.aReferenceTable1123;
        boolean var4 = true;
        int[] var5 = var2.method894(var0);

        for (int aVar5 : var5) {
            byte[] var7 = var2.method899(var0, aVar5);
            if (var7 == null) {
                var4 = false;
            } else {
                int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
                byte[] var9 = var3.method899(var8, 0);
                if (var9 == null) {
                    var4 = false;
                }
            }
        }

        DoublyLinkedNode_Sub6 var10;
        if (!var4) {
            var10 = null;
        } else {
            try {
                var10 = new DoublyLinkedNode_Sub6(var2, var3, var0);
            } catch (Exception var12) {
                var10 = null;
            }
        }

        if (var10 != null) {
            AnimationSequence.aReferenceCache1228.put(var10, (long) var0);
        }

        return var10;
    }

    public static Enum_Sub6[] method871() {
        return new Enum_Sub6[]{Enum_Sub6.anEnum_Sub6_1256, Enum_Sub6.anEnum_Sub6_1259, Enum_Sub6.anEnum_Sub6_1260, Enum_Sub6.anEnum_Sub6_1255, Enum_Sub6.anEnum_Sub6_1252, Enum_Sub6.anEnum_Sub6_1254};
    }
}
