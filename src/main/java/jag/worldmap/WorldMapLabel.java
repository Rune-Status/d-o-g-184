package jag.worldmap;

import jag.game.client;
import jag.game.scene.entity.PlayerEntity;
import jag.js5.Archive;
import jag.opcode.OutgoingPacket;
import jag.opcode.OutgoingPacketMeta;

public class WorldMapLabel {
    public static Archive aArchive341;
    public final int anInt342;
    public final int anInt339;
    final String aString340;
    final WorldMapLabelSize aWorldMapLabelSize_338;

    WorldMapLabel(String var1, int var2, int var3, WorldMapLabelSize var4) {
        this.aString340 = var1;
        this.anInt342 = var2;
        this.anInt339 = var3;
        this.aWorldMapLabelSize_338 = var4;
    }

    public static void method232() {
        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.WRITE_SOME_STRING_NONEMPTY_3619, client.connectionContext.encryptor);
        packet.buffer.writeByte(0);
        client.connectionContext.writeLater(packet);
    }

    public static void method233(int var0, WorldMapPosition var1, boolean var2) {
        WorldMapArea var3 = client.getWorldMap().getArea(var0);
        int var4 = PlayerEntity.local.anInt1473;
        int var5 = client.baseX + (PlayerEntity.local.fineX >> 7);
        int var6 = client.baseY + (PlayerEntity.local.fineY >> 7);
        WorldMapPosition var7 = new WorldMapPosition(var4, var5, var6);
        client.getWorldMap().method1277(var3, var7, var1, var2);
    }
}
