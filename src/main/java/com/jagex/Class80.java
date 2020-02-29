package com.jagex;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;

final class Class80 implements Class89 {
    static DoublyLinkedNode_Sub24_Sub4[] scrollbars;

    protected static int method437() {
        int var0 = 0;
        if (AssociateComparator.aGarbageCollectorMXBean1556 == null || !AssociateComparator.aGarbageCollectorMXBean1556.isValid()) {
            try {

                for (GarbageCollectorMXBean var2 : ManagementFactory.getGarbageCollectorMXBeans()) {
                    if (var2.isValid()) {
                        AssociateComparator.aGarbageCollectorMXBean1556 = var2;
                        GameEngine.aLong1319 = -1L;
                        GameEngine.aLong1298 = -1L;
                    }
                }
            } catch (Throwable ignored) {
            }
        }

        if (AssociateComparator.aGarbageCollectorMXBean1556 != null) {
            long var3 = Class24.currentTime();
            long var5 = AssociateComparator.aGarbageCollectorMXBean1556.getCollectionTime();
            if (GameEngine.aLong1298 != -1L) {
                long var7 = var5 - GameEngine.aLong1298;
                long var9 = var3 - GameEngine.aLong1319;
                if (var9 != 0L) {
                    var0 = (int) (var7 * 100L / var9);
                }
            }

            GameEngine.aLong1298 = var5;
            GameEngine.aLong1319 = var3;
        }

        return var0;
    }

    static void method438(boolean var0) {
        for (int var1 = 0; var1 < client.npcCount; ++var1) {
            NpcEntity var2 = client.npcs[client.npcIndices[var1]];
            if (var2 != null && var2.method684() && var2.definition.renderingPrioritized == var0 && var2.definition.method506()) {
                int var3 = var2.fineX >> 7;
                int var4 = var2.fineY >> 7;
                if (var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
                    if (var2.boundSize == 1 && (var2.fineX & 127) == 64 && (var2.fineY & 127) == 64) {
                        if (client.anIntArrayArray1003[var3][var4] == client.anInt1001) {
                            continue;
                        }

                        client.anIntArrayArray1003[var3][var4] = client.anInt1001;
                    }

                    long var5 = EntityUID.build(0, 0, 1, !var2.definition.aBoolean703, client.npcIndices[var1]);
                    var2.anInt1437 = client.engineCycle;
                    client.sceneGraph.method1469(SceneGraph.floorLevel, var2.fineX, var2.fineY, SceneGraph.getTileHeight(var2.boundSize - 64 + var2.fineX, var2.boundSize - 64 + var2.fineY, SceneGraph.floorLevel), var2.boundSize - 64 + 60, var2, var2.anInt1436, var5, var2.aBoolean2004);
                }
            }
        }

    }

    static void setWorld(World var0) {
        if (var0.isMembers() != client.membersWorld) {
            client.membersWorld = var0.isMembers();
            Class73.method409(var0.isMembers());
        }

        Enum_Sub3.currentDomain = var0.domain;
        client.currentWorld = var0.anInt1875;
        client.currentWorldMask = var0.mask;
        HitsplatDefinition.anInt1929 = client.anInt925 == 0 ? 43594 : var0.anInt1875 + 40000;
        Bzip2Context.anInt1579 = client.anInt925 == 0 ? 443 : var0.anInt1875 + 50000;
        NpcEntity.anInt823 = HitsplatDefinition.anInt1929;
    }

    void method436(String var1, Buffer var2) {
        var2.writeCString(var1);
    }

    public Object method410(Buffer var1) {
        return var1.readString();
    }

    public void method408(Object var1, Buffer var2) {
        this.method436((String) var1, var2);
    }
}
