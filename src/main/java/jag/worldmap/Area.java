package jag.worldmap;

import jag.Vertex;
import jag.audi.PcmStream_Sub4;
import jag.commons.Jagception;
import jag.game.type.AnimationFrameGroup;
import jag.graphics.IndexedSprite;
import jag.js5.ReferenceTable;
import jag.opcode.OutgoingPacket;
import jag.statics.Statics41;

public final class Area {
    // $FF: synthetic field
    final WorldMapController controller;
    int x;
    int width;
    int y;
    int height;

    Area(WorldMapController controller) {
        this.controller = controller;
    }

    public static IndexedSprite method375(ReferenceTable var0, String var1, String var2) {
        int var3 = var0.get(var1);
        int var4 = var0.method907(var3, var2);
        IndexedSprite var5;
        if (!Vertex.method534(var0, var3, var4)) {
            var5 = null;
        } else {
            IndexedSprite var6 = new IndexedSprite();
            var6.anInt375 = Statics41.anInt1824;
            var6.anInt372 = AnimationFrameGroup.anInt378;
            var6.insetX = Statics41.anIntArray1821[0];
            var6.insetY = PcmStream_Sub4.anIntArray1107[0];
            var6.anInt378 = Statics41.anIntArray1820[0];
            var6.anInt377 = Jagception.anIntArray1878[0];
            var6.palette = Statics41.anIntArray1823;
            var6.indices = OutgoingPacket.aByteArrayArray114[0];
            Statics41.anIntArray1821 = null;
            PcmStream_Sub4.anIntArray1107 = null;
            Statics41.anIntArray1820 = null;
            Jagception.anIntArray1878 = null;
            Statics41.anIntArray1823 = null;
            OutgoingPacket.aByteArrayArray114 = null;
            var5 = var6;
        }

        return var5;
    }
}
