package jag;

import jag.game.GameEngine;
import jag.game.World;
import jag.game.client;
import jag.opcode.LoginStep;
import jag.game.relationship.AssociateComparator;
import jag.game.scene.SceneGraph;
import jag.game.scene.entity.NpcEntity;
import jag.game.type.HitsplatDefinition;
import jag.graphics.IndexedSprite;
import jag.js5.Bzip2Entry;
import jag.opcode.Buffer;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;

public final class SerializableString implements Serializable {
    public static IndexedSprite[] scrollbars;

    public static int method437() {
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
            long var3 = GameEngine.currentTime();
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

    public static void loadNpcsIntoScene(boolean prioritized) {
        for (int i = 0; i < client.npcCount; ++i) {
            NpcEntity npc = client.npcs[client.npcIndices[i]];
            if (npc != null && npc.isDefined() && npc.definition.renderingPrioritized == prioritized && npc.definition.validate()) {
                int sceneX = npc.fineX >> 7;
                int sceneY = npc.fineY >> 7;
                if (sceneX >= 0 && sceneX < 104 && sceneY >= 0 && sceneY < 104) {
                    if (npc.boundSize == 1 && (npc.fineX & 127) == 64 && (npc.fineY & 127) == 64) {
                        if (client.anIntArrayArray1003[sceneX][sceneY] == client.anInt1001) {
                            continue;
                        }

                        client.anIntArrayArray1003[sceneX][sceneY] = client.anInt1001;
                    }

                    long uid = EntityUID.build(0, 0, 1, !npc.definition.aBoolean703, client.npcIndices[i]);
                    npc.renderCycle = client.engineCycle;
                    client.sceneGraph.addEntityMarker(SceneGraph.floorLevel, npc.fineX, npc.fineY, SceneGraph.getTileHeight(npc.boundSize - 64 + npc.fineX, npc.boundSize - 64 + npc.fineY, SceneGraph.floorLevel), npc.boundSize - 64 + 60, npc, npc.anInt1436, uid, npc.stretch);
                }
            }
        }

    }

    public static void setWorld(World var0) {
        if (var0.isMembers() != client.membersWorld) {
            client.membersWorld = var0.isMembers();
            SerializableInteger.method409(var0.isMembers());
        }

        LoginStep.currentDomain = var0.domain;
        client.currentWorld = var0.anInt1875;
        client.currentWorldMask = var0.mask;
        HitsplatDefinition.anInt1929 = client.anInt925 == 0 ? 43594 : var0.anInt1875 + 40000;
        Bzip2Entry.anInt1579 = client.anInt925 == 0 ? 443 : var0.anInt1875 + 50000;
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
