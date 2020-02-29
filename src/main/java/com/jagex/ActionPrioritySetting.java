package com.jagex;

import java.security.SecureRandom;

public enum ActionPrioritySetting implements EnumType {
    anActionPrioritySetting333(0),
    anActionPrioritySetting336(1),
    anActionPrioritySetting331(2),
    anActionPrioritySetting330(3);

    static int selectedSpellComponentUid;
    static Sprite compass;
    static CacheReferenceTable aCacheReferenceTable329;
    final int anInt335;

    ActionPrioritySetting(int var3) {
        this.anInt335 = var3;
    }

    static SecureRandom method226() {
        SecureRandom var0 = new SecureRandom();
        var0.nextInt();
        return var0;
    }

    static void insertMenuItem(String action, String target, int opcode, int primary, int secondary, int tertiary, boolean var6) {
        if (!client.menuOpen) {
            if (client.menuRowCount < 500) {
                client.menuActions[client.menuRowCount] = action;
                client.menuTargets[client.menuRowCount] = target;
                client.menuOpcodes[client.menuRowCount] = opcode;
                client.menuPrimaryArgs[client.menuRowCount] = primary;
                client.menuSecondaryArgs[client.menuRowCount] = secondary;
                client.menuTertiaryArgs[client.menuRowCount] = tertiary;
                client.menuShiftClickActions[client.menuRowCount] = var6;
                ++client.menuRowCount;
            }

        }
    }

    static CacheReferenceTable getReferenceTable(int var0, boolean var1, boolean var2) {
        CacheIndex var5 = null;
        if (Statics5.aBufferedFile_840 != null) {
            var5 = new CacheIndex(var0, Statics5.aBufferedFile_840, Statics10.aBufferedFileArray1135[var0], 1000000);
        }

        return new CacheReferenceTable(var5, Class63_Sub2.aCacheIndex649, var0, var1, var2, true);
    }

    static void processPlayerUpdate(PacketBuffer packet) {
        packet.bitAccess();
        int index = client.playerIndex;
        PlayerEntity player = PlayerEntity.local = client.players[index] = new PlayerEntity();
        player.anInt1659 = index;
        int var4 = packet.method1398(30);
        byte var5 = (byte) (var4 >> 28);
        int var6 = var4 >> 14 & 16383;
        int var7 = var4 & 16383;
        player.pathXQueue[0] = var6 - Statics18.baseX;
        player.fineX = (player.pathXQueue[0] << 7) + (player.boundSize() << 6);
        player.pathYQueue[0] = var7 - Statics36.baseY;
        player.fineY = (player.pathYQueue[0] << 7) + (player.boundSize() << 6);
        SceneGraph.floorLevel = player.anInt1473 = var5;
        if (GPI.buffers[index] != null) {
            player.decode(GPI.buffers[index]);
        }

        GPI.playerCount = 0;
        GPI.playerIndices[++GPI.playerCount - 1] = index;
        GPI.playerSkipFlags[index] = 0;
        GPI.globalPlayerCount = 0;

        for (int var8 = 1; var8 < 2048; ++var8) {
            if (index != var8) {
                int var9 = packet.method1398(18);
                int var10 = var9 >> 16;
                int var11 = var9 >> 8 & 597;
                int var12 = var9 & 597;
                GPI.playerLocations[var8] = (var11 << 14) + var12 + (var10 << 28);
                GPI.playerOrientations[var8] = 0;
                GPI.playerTargetIndices[var8] = -1;
                GPI.globalPlayerIndices[++GPI.globalPlayerCount - 1] = var8;
                GPI.playerSkipFlags[var8] = 0;
            }
        }

        packet.byteAccess();
    }

    public int getOrdinal() {
        return this.anInt335;
    }
}
