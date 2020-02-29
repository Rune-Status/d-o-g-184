package com.jagex;

public class Class66 implements Class10 {
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

    Class66() {
    }

    public static boolean method367(int var0) {
        return (var0 >> 29 & 1) != 0;
    }

    static void method368(String var0) {
        if (var0.equalsIgnoreCase("toggleroof")) {
            client.preferences.roofsHidden = !client.preferences.roofsHidden;
            Class149.method854();
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
                Class44.aClass209_391.aBoolean1705 = !Class44.aClass209_391.aBoolean1705;
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

    public boolean method92(int var1, int var2) {
        return var1 >= (this.anInt279 << 6) + (this.anInt535 << 3) && var1 <= (this.anInt279 << 6) + (this.anInt536 << 3) + 7 && var2 >= (this.anInt277 << 6) + (this.anInt534 << 3) && var2 <= (this.anInt277 << 6) + (this.anInt533 << 3) + 7;
    }

    public boolean method94(int var1, int var2, int var3) {
        if (var1 >= this.anInt285 && var1 < this.anInt285 + this.anInt287) {
            return var2 >= (this.anInt281 << 6) + (this.anInt278 << 3) && var2 <= (this.anInt281 << 6) + (this.anInt282 << 3) + 7 && var3 >= (this.anInt280 << 6) + (this.anInt286 << 3) && var3 <= (this.anInt280 << 6) + (this.anInt283 << 3) + 7;
        }
        return false;
    }

    public void method93(Class9 var1) {
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

    public SceneOffset method90(int var1, int var2) {
        if (!this.method92(var1, var2)) {
            return null;
        }
        int var3 = this.anInt281 * 64 - this.anInt279 * 64 + (this.anInt278 * 8 - this.anInt535 * 8) + var1;
        int var4 = this.anInt280 * 64 - this.anInt277 * 64 + var2 + (this.anInt286 * 8 - this.anInt534 * 8);
        return new SceneOffset(this.anInt285, var3, var4);
    }

    public int[] method91(int var1, int var2, int var3) {
        if (!this.method94(var1, var2, var3)) {
            return null;
        }
        return new int[]{this.anInt279 * 64 - this.anInt281 * 64 + var2 + (this.anInt535 * 8 - this.anInt278 * 8), var3 + (this.anInt277 * 64 - this.anInt280 * 64) + (this.anInt534 * 8 - this.anInt286 * 8)};
    }

    public void method89(Buffer var1) {
        this.anInt285 = var1.readUByte();
        this.anInt287 = var1.readUByte();
        this.anInt281 = var1.readUShort();
        this.anInt278 = var1.readUByte();
        this.anInt282 = var1.readUByte();
        this.anInt280 = var1.readUShort();
        this.anInt286 = var1.readUByte();
        this.anInt283 = var1.readUByte();
        this.anInt279 = var1.readUShort();
        this.anInt535 = var1.readUByte();
        this.anInt536 = var1.readUByte();
        this.anInt277 = var1.readUShort();
        this.anInt534 = var1.readUByte();
        this.anInt533 = var1.readUByte();
        this.method148();
    }

    void method148() {
    }
}
