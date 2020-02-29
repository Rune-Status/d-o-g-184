package com.jagex;

public class DoublyLinkedNode_Sub6 extends DoublyLinkedNode {
    public static int anInt378;
    static InterfaceComponent anInterfaceComponent800;
    static DoublyLinkedNode_Sub24_Sub4[] aDoublyNode_Sub24_Sub4Array801;
    Identikit[] anIdentikitArray799;

    public DoublyLinkedNode_Sub6(ReferenceTable var1, ReferenceTable var2, int var3) {
        NodeDeque var5 = new NodeDeque();
        int var6 = var1.method901(var3);
        this.anIdentikitArray799 = new Identikit[var6];
        int[] var7 = var1.method894(var3);

        for (int aVar7 : var7) {
            byte[] var9 = var1.unpack(var3, aVar7);
            Node_Sub13 var10 = null;
            int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

            for (Node_Sub13 var12 = (Node_Sub13) var5.head(); var12 != null; var12 = (Node_Sub13) var5.next()) {
                if (var11 == var12.anInt380) {
                    var10 = var12;
                    break;
                }
            }

            if (var10 == null) {
                byte[] var13 = var2.method899(var11, 0);
                var10 = new Node_Sub13(var11, var13);
                var5.add(var10);
            }

            this.anIdentikitArray799[aVar7] = new Identikit(var9, var10);
        }

    }

    public boolean method649(int var1) {
        return this.anIdentikitArray799[var1].showing;
    }
}
