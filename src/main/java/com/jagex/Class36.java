package com.jagex;

public class Class36 implements Class10 {
    static Class213 aClass213_343;
    int anInt279;
    int anInt285;
    int anInt287;
    int anInt277;
    int anInt281;
    int anInt280;

    Class36() {
    }

    static void processComponentAction(int actionIndex, int uid, int subcomponent, int itemId, String actionText) {
        InterfaceComponent component = InterfaceComponent.lookup(uid, subcomponent);
        if (component != null) {
            if (component.mousePressListeners != null) {
                ScriptEvent event = new ScriptEvent();
                event.source = component;
                event.actionIndex = actionIndex;
                event.opbase = actionText;
                event.args = component.mousePressListeners;
                DefinitionProperty.fireScriptEvent(event);
            }

            boolean var7 = true;
            if (component.contentType > 0) {
                var7 = Class11.method96(component);
            }

            if (var7) {
                int config = InterfaceComponent.getConfig(component);
                int action = actionIndex - 1;
                boolean actionEnabled = (config >> action + 1 & 1) != 0;
                if (actionEnabled) {
                    OutgoingPacket packet;
                    if (actionIndex == 1) {
                        packet = OutgoingPacket.prepare(OutgoingPacketMeta.INTERFACE_ACTION_0, client.connectionContext.encryptor);
                        packet.buffer.writeInt(uid);
                        packet.buffer.writeShort(subcomponent);
                        packet.buffer.writeShort(itemId);
                        client.connectionContext.writeLater(packet);
                    }

                    if (actionIndex == 2) {
                        packet = OutgoingPacket.prepare(OutgoingPacketMeta.INTERFACE_ACTION_1, client.connectionContext.encryptor);
                        packet.buffer.writeInt(uid);
                        packet.buffer.writeShort(subcomponent);
                        packet.buffer.writeShort(itemId);
                        client.connectionContext.writeLater(packet);
                    }

                    if (actionIndex == 3) {
                        packet = OutgoingPacket.prepare(OutgoingPacketMeta.INTERFACE_ACTION_2, client.connectionContext.encryptor);
                        packet.buffer.writeInt(uid);
                        packet.buffer.writeShort(subcomponent);
                        packet.buffer.writeShort(itemId);
                        client.connectionContext.writeLater(packet);
                    }

                    if (actionIndex == 4) {
                        packet = OutgoingPacket.prepare(OutgoingPacketMeta.INTERFACE_ACTION_3, client.connectionContext.encryptor);
                        packet.buffer.writeInt(uid);
                        packet.buffer.writeShort(subcomponent);
                        packet.buffer.writeShort(itemId);
                        client.connectionContext.writeLater(packet);
                    }

                    if (actionIndex == 5) {
                        packet = OutgoingPacket.prepare(OutgoingPacketMeta.INTERFACE_ACTION_4, client.connectionContext.encryptor);
                        packet.buffer.writeInt(uid);
                        packet.buffer.writeShort(subcomponent);
                        packet.buffer.writeShort(itemId);
                        client.connectionContext.writeLater(packet);
                    }

                    if (actionIndex == 6) {
                        packet = OutgoingPacket.prepare(OutgoingPacketMeta.INTERFACE_ACTION_5, client.connectionContext.encryptor);
                        packet.buffer.writeInt(uid);
                        packet.buffer.writeShort(subcomponent);
                        packet.buffer.writeShort(itemId);
                        client.connectionContext.writeLater(packet);
                    }

                    if (actionIndex == 7) {
                        packet = OutgoingPacket.prepare(OutgoingPacketMeta.INTERFACE_ACTION_6, client.connectionContext.encryptor);
                        packet.buffer.writeInt(uid);
                        packet.buffer.writeShort(subcomponent);
                        packet.buffer.writeShort(itemId);
                        client.connectionContext.writeLater(packet);
                    }

                    if (actionIndex == 8) {
                        packet = OutgoingPacket.prepare(OutgoingPacketMeta.INTERFACE_ACTION_7, client.connectionContext.encryptor);
                        packet.buffer.writeInt(uid);
                        packet.buffer.writeShort(subcomponent);
                        packet.buffer.writeShort(itemId);
                        client.connectionContext.writeLater(packet);
                    }

                    if (actionIndex == 9) {
                        packet = OutgoingPacket.prepare(OutgoingPacketMeta.INTERFACE_ACTION_8, client.connectionContext.encryptor);
                        packet.buffer.writeInt(uid);
                        packet.buffer.writeShort(subcomponent);
                        packet.buffer.writeShort(itemId);
                        client.connectionContext.writeLater(packet);
                    }

                    if (actionIndex == 10) {
                        packet = OutgoingPacket.prepare(OutgoingPacketMeta.INTERFACE_ACTION_9, client.connectionContext.encryptor);
                        packet.buffer.writeInt(uid);
                        packet.buffer.writeShort(subcomponent);
                        packet.buffer.writeShort(itemId);
                        client.connectionContext.writeLater(packet);
                    }
                }
            }
        }
    }

    static void spawnObjectLater(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        PendingSpawn var10 = null;

        for (PendingSpawn var11 = (PendingSpawn) client.pendingSpawns.head(); var11 != null; var11 = (PendingSpawn) client.pendingSpawns.next()) {
            if (var0 == var11.floorLevel && var11.sceneX == var1 && var2 == var11.sceneY && var3 == var11.type) {
                var10 = var11;
                break;
            }
        }

        if (var10 == null) {
            var10 = new PendingSpawn();
            var10.floorLevel = var0;
            var10.type = var3;
            var10.sceneX = var1;
            var10.sceneY = var2;
            Class72.method388(var10);
            client.pendingSpawns.add(var10);
        }

        var10.anInt693 = var4;
        var10.anInt564 = var5;
        var10.orientation = var6;
        var10.delay = var7;
        var10.hitpoints = var8;
    }

    static RuneScript method239(int var0) {
        RuneScript var2 = (RuneScript) RuneScript.aReferenceCache1647.get((long) (var0 << 16));
        if (var2 != null) {
            return var2;
        }
        String var3 = String.valueOf(var0);
        int var4 = Class38.aCacheReferenceTable348.method900(var3);
        if (var4 == -1) {
            return null;
        }
        byte[] var5 = Class38.aCacheReferenceTable348.method904(var4);
        if (var5 != null) {
            if (var5.length <= 1) {
                return null;
            }

            var2 = Class85.method455(var5);
            if (var2 != null) {
                RuneScript.aReferenceCache1647.put(var2, (long) (var0 << 16));
                return var2;
            }
        }

        return null;
    }

    public static void method240(ReferenceTable var0, ReferenceTable var1, boolean var2, Font var3) {
        ItemDefinition.aReferenceTable721 = var0;
        ItemDefinition.aReferenceTable722 = var1;
        Statics6.loadMembersItemDefinitions = var2;
        Statics5.anInt838 = ItemDefinition.aReferenceTable721.method901(10);
        Class104.aFont774 = var3;
    }

    public static void method238(int var0, int var1) {
        Statics2.anInt656 = var0;
        Statics2.anInt661 = var1;
        Statics2.aBoolean663 = true;
        Statics2.onCursorCount = 0;
        Statics2.aBoolean660 = false;
    }

    public boolean method92(int var1, int var2) {
        return var1 >> 6 == this.anInt279 && var2 >> 6 == this.anInt277;
    }

    public boolean method94(int var1, int var2, int var3) {
        if (var1 >= this.anInt285 && var1 < this.anInt287 + this.anInt285) {
            return var2 >> 6 == this.anInt281 && var3 >> 6 == this.anInt280;
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
        int var3 = this.anInt281 * 64 - this.anInt279 * 64 + var1;
        int var4 = this.anInt280 * 64 - this.anInt277 * 64 + var2;
        return new SceneOffset(this.anInt285, var3, var4);
    }

    public int[] method91(int var1, int var2, int var3) {
        if (!this.method94(var1, var2, var3)) {
            return null;
        }
        return new int[]{this.anInt279 * 64 - this.anInt281 * 64 + var2, var3 + (this.anInt277 * 64 - this.anInt280 * 64)};
    }

    void method148() {
    }

    public void method89(Buffer var1) {
        this.anInt285 = var1.readUByte();
        this.anInt287 = var1.readUByte();
        this.anInt281 = var1.readUShort();
        this.anInt280 = var1.readUShort();
        this.anInt279 = var1.readUShort();
        this.anInt277 = var1.readUShort();
        this.method148();
    }
}
