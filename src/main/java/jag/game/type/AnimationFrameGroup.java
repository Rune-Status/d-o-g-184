package jag.game.type;

import jag.Identikit;
import jag.commons.collection.DoublyLinkedNode;
import jag.commons.collection.NodeDeque;
import jag.game.InterfaceComponent;
import jag.graphics.IndexedSprite;
import jag.js5.ReferenceTable;

public class AnimationFrameGroup extends DoublyLinkedNode {

    public static int anInt378;
    public static InterfaceComponent anInterfaceComponent800;
    public static IndexedSprite[] aDoublyNode_Sub24_Sub4Array801;
    public final Identikit[] anIdentikitArray799;

    public AnimationFrameGroup(ReferenceTable var1, ReferenceTable var2, int var3) {
        NodeDeque var5 = new NodeDeque();
        int var6 = var1.method901(var3);
        this.anIdentikitArray799 = new Identikit[var6];
        int[] var7 = var1.getFileIds(var3);

        for (int aVar7 : var7) {
            byte[] var9 = var1.unpack(var3, aVar7);
            AnimationFrame var10 = null;
            int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

            for (AnimationFrame var12 = (AnimationFrame) var5.head(); var12 != null; var12 = (AnimationFrame) var5.next()) {
                if (var11 == var12.anInt380) {
                    var10 = var12;
                    break;
                }
            }

            if (var10 == null) {
                byte[] var13 = var2.method899(var11, 0);
                var10 = new AnimationFrame(var11, var13);
                var5.add(var10);
            }

            this.anIdentikitArray799[aVar7] = new Identikit(var9, var10);
        }

    }

    public boolean method649(int var1) {
        return this.anIdentikitArray799[var1].showing;
    }
}
