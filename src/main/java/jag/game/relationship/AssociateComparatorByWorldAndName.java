package jag.game.relationship;

import jag.game.client;
import jag.game.type.TileUnderlay;
import jag.opcode.Buffer;

public class AssociateComparatorByWorldAndName extends AssociateComparator {

    public final boolean aBoolean764;

    public AssociateComparatorByWorldAndName(boolean var1) {
        this.aBoolean764 = var1;
    }

    public static TileUnderlay method644(int var0) {
        TileUnderlay var1 = (TileUnderlay) TileUnderlay.aReferenceCache385.get(var0);
        if (var1 != null) {
            return var1;
        }
        byte[] var2 = TileUnderlay.aReferenceTable383.unpack(1, var0);
        var1 = new TileUnderlay();
        if (var2 != null) {
            var1.decode(new Buffer(var2));
        }

        var1.method254();
        TileUnderlay.aReferenceCache385.put(var1, var0);
        return var1;
    }

    int method604(Associate var1, Associate var2) {
        if (client.currentWorld == var1.world && var2.world == client.currentWorld) {
            return this.aBoolean764 ? var1.getDisplayName().compare0(var2.getDisplayName()) : var2.getDisplayName().compare0(var1.getDisplayName());
        }
        return this.method1135(var1, var2);
    }

    public int compare(Associate var1, Associate var2) {
        return this.method604(var1, var2);
    }
}
