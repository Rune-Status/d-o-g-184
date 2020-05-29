package jag.game.relationship;

import jag.game.client;
import jag.game.type.EnumDefinition;
import jag.opcode.Buffer;

public class AssociateComparator_Sub4 extends AssociateComparator {

    public static boolean aBoolean804;
    public static int anInt803;
    public final boolean aBoolean764;

    public AssociateComparator_Sub4(boolean var1) {
        this.aBoolean764 = var1;
    }

    public static EnumDefinition method664(int var0) {
        EnumDefinition var1 = (EnumDefinition) EnumDefinition.aReferenceCache385.get(var0);
        if (var1 != null) {
            return var1;
        }
        byte[] var2 = EnumDefinition.aReferenceTable383.unpack(8, var0);
        var1 = new EnumDefinition();
        if (var2 != null) {
            var1.method990(new Buffer(var2));
        }

        EnumDefinition.aReferenceCache385.put(var1, var0);
        return var1;
    }

    int method604(Associate var1, Associate var2) {
        if (client.currentWorld == var1.world && var2.world == client.currentWorld) {
            return this.aBoolean764 ? var1.index - var2.index : var2.index - var1.index;
        }
        return this.method1135(var1, var2);
    }

    public int compare(Associate var1, Associate var2) {
        return this.method604(var1, var2);
    }
}
