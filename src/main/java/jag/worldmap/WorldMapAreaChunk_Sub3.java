package jag.worldmap;

import jag.ClientLocale;
import jag.game.client;
import jag.opcode.Buffer;
import jag.opcode.OutgoingPacket;
import jag.opcode.OutgoingPacketMeta;
import jag.statics.Statics19;

public class WorldMapAreaChunk_Sub3 implements WorldMapAreaChunk {
    int anInt535;
    int anInt285;
    int anInt279;
    int anInt287;
    int anInt536;
    int anInt278;
    int anInt281;
    int anInt534;
    int anInt282;
    int anInt277;
    int anInt533;
    int anInt286;
    int anInt280;
    int anInt283;

    WorldMapAreaChunk_Sub3() {
    }

    public static boolean method367(int var0) {
        return (var0 >> 29 & 1) != 0;
    }

    public static void method368(String var0) {
        if (var0.equalsIgnoreCase("toggleroof")) {
            client.preferences.roofsHidden = !client.preferences.roofsHidden;
            ClientLocale.method854();
            if (client.preferences.roofsHidden) {
                Statics19.messageReceived(99, "", "Roofs are now all hidden");
            } else {
                Statics19.messageReceived(99, "", "Roofs will only be removed selectively");
            }
        }

        if (var0.equalsIgnoreCase("displayfps")) {
            client.aBoolean944 = !client.aBoolean944;
        }

        if (var0.equalsIgnoreCase("renderself")) {
            client.aBoolean1020 = !client.aBoolean1020;
        }

        if (var0.equalsIgnoreCase("mouseovertext")) {
            client.aBoolean1043 = !client.aBoolean1043;
        }

        if (client.rights >= 2) {
            if (var0.equalsIgnoreCase("errortest")) {
                throw new RuntimeException();
            }

            if (var0.equalsIgnoreCase("showcoord")) {
                client.worldMap.drawMouseOverPosition = !client.worldMap.drawMouseOverPosition;
            }

            if (var0.equalsIgnoreCase("fpson")) {
                client.aBoolean944 = true;
            }

            if (var0.equalsIgnoreCase("fpsoff")) {
                client.aBoolean944 = false;
            }

            if (var0.equalsIgnoreCase("gc")) {
                System.gc();
            }

            if (var0.equalsIgnoreCase("clientdrop")) {
                client.dropConnection();
            }
        }

        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.PROCESS_COMMAND, client.connectionContext.encryptor);
        packet.buffer.writeByte(var0.length() + 1);
        packet.buffer.writeCString(var0);
        client.connectionContext.writeLater(packet);
    }

    public boolean contains(int x, int y) {
        return x >= (this.anInt279 << 6) + (this.anInt535 << 3) && x <= (this.anInt279 << 6) + (this.anInt536 << 3) + 7 && y >= (this.anInt277 << 6) + (this.anInt534 << 3) && y <= (this.anInt277 << 6) + (this.anInt533 << 3) + 7;
    }

    public boolean contains(int level, int x, int y) {
        if (level >= this.anInt285 && level < this.anInt285 + this.anInt287) {
            return x >= (this.anInt281 << 6) + (this.anInt278 << 3) && x <= (this.anInt281 << 6) + (this.anInt282 << 3) + 7 && y >= (this.anInt280 << 6) + (this.anInt286 << 3) && y <= (this.anInt280 << 6) + (this.anInt283 << 3) + 7;
        }
        return false;
    }

    public void method93(WorldMapArea var1) {
        if (var1.anInt134 > this.anInt279) {
            var1.anInt134 = this.anInt279;
        }

        if (var1.anInt131 < this.anInt279) {
            var1.anInt131 = this.anInt279;
        }

        if (var1.anInt138 > this.anInt277) {
            var1.anInt138 = this.anInt277;
        }

        if (var1.anInt129 < this.anInt277) {
            var1.anInt129 = this.anInt277;
        }

    }

    public WorldMapPosition getPosition(int x, int y) {
        if (!this.contains(x, y)) {
            return null;
        }
        int var3 = this.anInt281 * 64 - this.anInt279 * 64 + (this.anInt278 * 8 - this.anInt535 * 8) + x;
        int var4 = this.anInt280 * 64 - this.anInt277 * 64 + y + (this.anInt286 * 8 - this.anInt534 * 8);
        return new WorldMapPosition(this.anInt285, var3, var4);
    }

    public int[] outline(int level, int x, int y) {
        if (!this.contains(level, x, y)) {
            return null;
        }
        return new int[]{this.anInt279 * 64 - this.anInt281 * 64 + x + (this.anInt535 * 8 - this.anInt278 * 8), y + (this.anInt277 * 64 - this.anInt280 * 64) + (this.anInt534 * 8 - this.anInt286 * 8)};
    }

    public void decode(Buffer buffer) {
        anInt285 = buffer.readUByte();
        anInt287 = buffer.readUByte();
        anInt281 = buffer.readUShort();
        anInt278 = buffer.readUByte();
        anInt282 = buffer.readUByte();
        anInt280 = buffer.readUShort();
        anInt286 = buffer.readUByte();
        anInt283 = buffer.readUByte();
        anInt279 = buffer.readUShort();
        anInt535 = buffer.readUByte();
        anInt536 = buffer.readUByte();
        anInt277 = buffer.readUShort();
        anInt534 = buffer.readUByte();
        anInt533 = buffer.readUByte();
        method148();
    }

    void method148() {

    }
}
