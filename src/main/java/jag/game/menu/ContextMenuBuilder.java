package jag.game.menu;

import jag.audi.DefaultAudioSystemProvider;
import jag.commons.collection.NodeDeque;
import jag.game.InterfaceComponent;
import jag.game.client;
import jag.game.option.AttackOptionPriority;
import jag.game.scene.SceneGraph;
import jag.game.scene.entity.EntityUID;
import jag.game.scene.entity.NpcEntity;
import jag.game.scene.entity.Pickable;
import jag.game.scene.entity.PlayerEntity;
import jag.game.type.ItemDefinition;
import jag.game.type.NpcDefinition;
import jag.game.type.ObjectDefinition;
import jag.opcode.GPI;
import jag.statics.Statics2;
import jag.statics.Statics52;

public class ContextMenuBuilder {

    public static void insertRow(String action, String target, int opcode, int primary, int secondary, int tertiary) {
        insertRow(action, target, opcode, primary, secondary, tertiary, false);
    }

    public static void insertRow(String action, String target, int opcode, int primary, int secondary, int tertiary, boolean var6) {
        if (!ContextMenu.open) {
            if (ContextMenu.rowCount < 500) {
                ContextMenu.actions[ContextMenu.rowCount] = action;
                ContextMenu.targets[ContextMenu.rowCount] = target;
                ContextMenu.opcodes[ContextMenu.rowCount] = opcode;
                ContextMenu.primaryArgs[ContextMenu.rowCount] = primary;
                ContextMenu.secondaryArgs[ContextMenu.rowCount] = secondary;
                ContextMenu.tertiaryArgs[ContextMenu.rowCount] = tertiary;
                ContextMenu.shiftClickActions[ContextMenu.rowCount] = var6;
                ++ContextMenu.rowCount;
            }

        }
    }

    public static void applyComponentActions(InterfaceComponent component, int rootX, int rootY) {

        if (component.buttonType == 1) {
            insertRow(component.toolTip, "", 24, 0, 0, component.uid);
        }

        if (component.buttonType == 2 && !ComponentSelection.Spell.state) {
            String action = InterfaceComponent.getSelectedAction(component);
            if (action != null) {
                insertRow(action, client.getColorTags(65280) + component.spellName, 25, 0, -1, component.uid);
            }
        }

        if (component.buttonType == 3) {
            insertRow("Close", "", 26, 0, 0, component.uid);
        }

        if (component.buttonType == 4) {
            insertRow(component.toolTip, "", 28, 0, 0, component.uid);
        }

        if (component.buttonType == 5) {
            insertRow(component.toolTip, "", 29, 0, 0, component.uid);
        }

        if (component.buttonType == 6 && client.pleaseWaitComponent == null) {
            insertRow(component.toolTip, "", 30, 0, -1, component.uid);
        }

        if (component.type == 2) {
            int index = 0;
            for (int baseX = 0; baseX < component.height; ++baseX) {
                for (int baseY = 0; baseY < component.width; ++baseY) {
                    int x = (component.xPadding + 32) * baseY;
                    int y = (component.yPadding + 32) * baseX;
                    if (index < 20) {
                        x += component.xSprites[index];
                        y += component.ySprites[index];
                    }

                    if (rootX >= x && rootY >= y && rootX < x + 32 && rootY < y + 32) {
                        client.draggingComponentIndex = index;
                        DefaultAudioSystemProvider.processingItemComponent = component;
                        if (component.itemIds[index] > 0) {
                            label331:
                            {
                                ItemDefinition def = ItemDefinition.get(component.itemIds[index] - 1);
                                if (ComponentSelection.Item.state == 1) {
                                    int cfg = InterfaceComponent.getConfig(component);
                                    boolean allowUsability = (cfg >> 30 & 1) != 0;
                                    if (allowUsability) {
                                        if (component.uid != ComponentSelection.Item.uid || index != ComponentSelection.Item.id) {
                                            insertRow("Use", ComponentSelection.Item.name + " " + "->" + " " + client.getColorTags(16748608) + def.name, 31, def.id, index, component.uid);
                                        }
                                        break label331;
                                    }
                                }

                                if (ComponentSelection.Spell.state) {
                                    int cfg = InterfaceComponent.getConfig(component);
                                    boolean allowUsability = (cfg >> 30 & 1) != 0;
                                    if (allowUsability) {
                                        if ((ComponentSelection.Spell.flags & 16) == 16) {
                                            insertRow(ComponentSelection.action, ComponentSelection.Spell.name + " " + "->" + " " + client.getColorTags(16748608) + def.name, 32, def.id, index, component.uid);
                                        }
                                        break label331;
                                    }
                                }

                                int shiftIndex = -1;
                                if (client.aBoolean1044 && Statics52.method345()) {
                                    shiftIndex = def.getShiftOptionIndex();
                                }

                                int var14 = InterfaceComponent.getConfig(component);
                                boolean var15 = (var14 >> 30 & 1) != 0;
                                if (var15) {
                                    for (int var16 = 4; var16 >= 3; --var16) {
                                        if (var16 != shiftIndex) {
                                            ItemDefinition.processOpcode(component, def, index, var16, false);
                                        }
                                    }
                                }

                                int var17 = InterfaceComponent.getConfig(component);
                                boolean var26 = (var17 >> 31 & 1) != 0;
                                if (var26) {
                                    insertRow("Use", client.getColorTags(16748608) + def.name, 38, def.id, index, component.uid);
                                }

                                int var18 = InterfaceComponent.getConfig(component);
                                boolean allowUsability = (var18 >> 30 & 1) != 0;
                                if (allowUsability) {
                                    for (int i = 2; i >= 0; --i) {
                                        if (shiftIndex != i) {
                                            ItemDefinition.processOpcode(component, def, index, i, false);
                                        }
                                    }

                                    if (shiftIndex >= 0) {
                                        ItemDefinition.processOpcode(component, def, index, shiftIndex, true);
                                    }
                                }

                                String[] tableActions = component.tableActions;
                                if (tableActions != null) {
                                    for (int i = 4; i >= 0; --i) {
                                        if (tableActions[i] != null) {
                                            byte opcode = 0;
                                            if (i == 0) {
                                                opcode = 39;
                                            }

                                            if (i == 1) {
                                                opcode = 40;
                                            }

                                            if (i == 2) {
                                                opcode = 41;
                                            }

                                            if (i == 3) {
                                                opcode = 42;
                                            }

                                            if (i == 4) {
                                                opcode = 43;
                                            }

                                            insertRow(tableActions[i], client.getColorTags(16748608) + def.name, opcode, def.id, index, component.uid);
                                        }
                                    }
                                }

                                insertRow("Examine", client.getColorTags(16748608) + def.name, 1005, def.id, index, component.uid);
                            }
                        }
                    }

                    ++index;
                }
            }
        }

        if (component.format) {
            if (ComponentSelection.Spell.state) {
                int cfg = InterfaceComponent.getConfig(component);
                boolean var24 = (cfg >> 21 & 1) != 0;
                if (var24 && (ComponentSelection.Spell.flags & 32) == 32) {
                    insertRow(ComponentSelection.action, ComponentSelection.Spell.name + " " + "->" + " " + component.name, 58, 0, component.subComponentIndex, component.uid);
                }
            } else {
                for (int i = 9; i >= 5; --i) {
                    String action = InterfaceComponent.getAction(component, i);
                    if (action != null) {
                        insertRow(action, component.name, 1007, i + 1, component.subComponentIndex, component.uid);
                    }
                }

                String selected = InterfaceComponent.getSelectedAction(component);
                if (selected != null) {
                    insertRow(selected, component.name, 25, 0, component.subComponentIndex, component.uid);
                }

                for (int i = 4; i >= 0; --i) {
                    String action = InterfaceComponent.getAction(component, i);
                    if (action != null) {
                        insertRow(action, component.name, 57, i + 1, component.subComponentIndex, component.uid, component.prioritizeMenuOptions);
                    }
                }

                int cfg = InterfaceComponent.getConfig(component);
                boolean var25 = (cfg & 1) != 0;
                if (var25) {
                    insertRow("Continue", "", 30, 0, component.subComponentIndex, component.uid);
                }
            }
        }
    }

    public static void applyPlayerActions(PlayerEntity var0, int var1, int var2, int var3) {
        if (PlayerEntity.local != var0) {
            if (ContextMenu.rowCount < 400) {
                int var5;
                String var9;
                if (var0.skillLevel == 0) {
                    String var4 = var0.actions[0] + var0.namePair + var0.actions[1];
                    var5 = var0.combatLevel;
                    int var6 = PlayerEntity.local.combatLevel;
                    int var7 = var6 - var5;
                    String var8;
                    if (var7 < -9) {
                        var8 = client.getColorTags(16711680);
                    } else if (var7 < -6) {
                        var8 = client.getColorTags(16723968);
                    } else if (var7 < -3) {
                        var8 = client.getColorTags(16740352);
                    } else if (var7 < 0) {
                        var8 = client.getColorTags(16756736);
                    } else if (var7 > 9) {
                        var8 = client.getColorTags(65280);
                    } else if (var7 > 6) {
                        var8 = client.getColorTags(4259584);
                    } else if (var7 > 3) {
                        var8 = client.getColorTags(8453888);
                    } else if (var7 > 0) {
                        var8 = client.getColorTags(12648192);
                    } else {
                        var8 = client.getColorTags(16776960);
                    }

                    var9 = var4 + var8 + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
                } else {
                    var9 = var0.actions[0] + var0.namePair + var0.actions[1] + " " + " (" + "skill-" + var0.skillLevel + ")" + var0.actions[2];
                }

                int var10;
                if (ComponentSelection.Item.state == 1) {
                    insertRow("Use", ComponentSelection.Item.name + " " + "->" + " " + client.getColorTags(16777215) + var9, 14, var1, var2, var3);
                } else if (ComponentSelection.Spell.state) {
                    if ((ComponentSelection.Spell.flags & 8) == 8) {
                        insertRow(ComponentSelection.action, ComponentSelection.Spell.name + " " + "->" + " " + client.getColorTags(16777215) + var9, 15, var1, var2, var3);
                    }
                } else {
                    for (var10 = 7; var10 >= 0; --var10) {
                        if (client.playerActions[var10] != null) {
                            short var11 = 0;
                            if (client.playerActions[var10].equalsIgnoreCase("Attack")) {
                                if (AttackOptionPriority.HIDDEN == client.playerAttackOptionPriority) {
                                    continue;
                                }

                                if (AttackOptionPriority.RIGHT == client.playerAttackOptionPriority || client.playerAttackOptionPriority == AttackOptionPriority.DEPENDS && var0.combatLevel > PlayerEntity.local.combatLevel) {
                                    var11 = 2000;
                                }

                                if (PlayerEntity.local.team != 0 && var0.team != 0) {
                                    if (var0.team == PlayerEntity.local.team) {
                                        var11 = 2000;
                                    } else {
                                        var11 = 0;
                                    }
                                }
                            } else if (client.playerActionPriorities[var10]) {
                                var11 = 2000;
                            }

                            boolean var12 = false;
                            var5 = client.PLAYER_ACTION_OPCODES[var10] + var11;
                            insertRow(client.playerActions[var10], client.getColorTags(16777215) + var9, var5, var1, var2, var3);
                        }
                    }
                }

                for (var10 = 0; var10 < ContextMenu.rowCount; ++var10) {
                    if (ContextMenu.opcodes[var10] == 23) {
                        ContextMenu.targets[var10] = client.getColorTags(16777215) + var9;
                        break;
                    }
                }

            }
        }
    }

    public static void applyNpcActions(NpcDefinition def, int index, int sceneX, int sceneY) {
        if (ContextMenu.rowCount < 400) {
            if (def.transformIds != null) {
                def = def.transform();
            }

            if (def != null && def.interactable && (!def.follower || client.anInt1053 == index)) {
                String menuDefinition = def.name;
                int var6;
                int opcode;
                if (def.combatLevel != 0) {
                    var6 = def.combatLevel;
                    opcode = PlayerEntity.local.combatLevel;
                    int var8 = opcode - var6;
                    String color;
                    if (var8 < -9) {
                        color = client.getColorTags(16711680);
                    } else if (var8 < -6) {
                        color = client.getColorTags(16723968);
                    } else if (var8 < -3) {
                        color = client.getColorTags(16740352);
                    } else if (var8 < 0) {
                        color = client.getColorTags(16756736);
                    } else if (var8 > 9) {
                        color = client.getColorTags(65280);
                    } else if (var8 > 6) {
                        color = client.getColorTags(4259584);
                    } else if (var8 > 3) {
                        color = client.getColorTags(8453888);
                    } else if (var8 > 0) {
                        color = client.getColorTags(12648192);
                    } else {
                        color = client.getColorTags(16776960);
                    }

                    menuDefinition = menuDefinition + color + " " + " (" + "level-" + def.combatLevel + ")";
                }

                if (def.follower && client.aBoolean1042) {
                    insertRow("Examine", client.getColorTags(16776960) + menuDefinition, 1003, index, sceneX, sceneY);
                }

                if (ComponentSelection.Item.state == 1) {
                    insertRow("Use", ComponentSelection.Item.name + " " + "->" + " " + client.getColorTags(16776960) + menuDefinition, 7, index, sceneX, sceneY);
                } else if (ComponentSelection.Spell.state) {
                    if ((ComponentSelection.Spell.flags & 2) == 2) {
                        insertRow(ComponentSelection.action, ComponentSelection.Spell.name + " " + "->" + " " + client.getColorTags(16776960) + menuDefinition, 8, index, sceneX, sceneY);
                    }
                } else {
                    int var10 = def.follower && client.aBoolean1042 ? 2000 : 0;
                    String[] var12 = def.actions;
                    if (var12 != null) {
                        for (var6 = 4; var6 >= 0; --var6) {
                            if (var12[var6] != null && !var12[var6].equalsIgnoreCase("Attack")) {
                                opcode = 0;
                                if (var6 == 0) {
                                    opcode = var10 + 9;
                                }

                                if (var6 == 1) {
                                    opcode = var10 + 10;
                                }

                                if (var6 == 2) {
                                    opcode = var10 + 11;
                                }

                                if (var6 == 3) {
                                    opcode = var10 + 12;
                                }

                                if (var6 == 4) {
                                    opcode = var10 + 13;
                                }

                                insertRow(var12[var6], client.getColorTags(16776960) + menuDefinition, opcode, index, sceneX, sceneY);
                            }
                        }
                    }

                    if (var12 != null) {
                        for (var6 = 4; var6 >= 0; --var6) {
                            if (var12[var6] != null && var12[var6].equalsIgnoreCase("Attack")) {
                                short var11 = 0;
                                if (client.npcAttackOptionPriority != AttackOptionPriority.HIDDEN) {
                                    if (AttackOptionPriority.RIGHT == client.npcAttackOptionPriority || AttackOptionPriority.DEPENDS == client.npcAttackOptionPriority && def.combatLevel > PlayerEntity.local.combatLevel) {
                                        var11 = 2000;
                                    }

                                    opcode = 0;
                                    if (var6 == 0) {
                                        opcode = var11 + 9;
                                    }

                                    if (var6 == 1) {
                                        opcode = var11 + 10;
                                    }

                                    if (var6 == 2) {
                                        opcode = var11 + 11;
                                    }

                                    if (var6 == 3) {
                                        opcode = var11 + 12;
                                    }

                                    if (var6 == 4) {
                                        opcode = var11 + 13;
                                    }

                                    insertRow(var12[var6], client.getColorTags(16776960) + menuDefinition, opcode, index, sceneX, sceneY);
                                }
                            }
                        }
                    }

                    if (!def.follower || !client.aBoolean1042) {
                        insertRow("Examine", client.getColorTags(16776960) + menuDefinition, 1003, index, sceneX, sceneY);
                    }
                }

            }
        }
    }

    public static void build(int var0, int var1, int var2, int var3) {
        if (ComponentSelection.Item.state == 0 && !ComponentSelection.Spell.state) {
            insertRow("Walk here", "", 23, 0, var0 - var2, var1 - var3);
        }

        long var5 = -1L;
        long var7 = -1L;
        int sceneX = 0;

        while (true) {
            int var11 = Statics2.onCursorCount;
            if (sceneX >= var11) {
                if (var5 != -1L) {
                    sceneX = EntityUID.getObjectSceneX(var5);
                    int sceneY = EntityUID.getObjectSceneY(var5);
                    PlayerEntity var12 = client.players[client.anInt1030];
                    applyPlayerActions(var12, client.anInt1030, sceneX, sceneY);
                }

                return;
            }

            long var13 = Statics2.onCursorUids[sceneX];
            if (var13 != var7) {
                label336:
                {
                    var7 = var13;
                    int x = EntityUID.getObjectSceneX(Statics2.onCursorUids[sceneX]);
                    int y = EntityUID.getHoveredObjectSceneY(sceneX);
                    int var20 = EntityUID.getHoveredObjectType(sceneX);
                    int var21 = EntityUID.getObjectId(Statics2.onCursorUids[sceneX]);
                    if (var20 == 2 && client.sceneGraph.getConfigAt(SceneGraph.floorLevel, x, y, var13) >= 0) {
                        ObjectDefinition var23 = ObjectDefinition.get(var21);
                        if (var23.transformIds != null) {
                            var23 = var23.transform();
                        }

                        if (var23 == null) {
                            break label336;
                        }

                        if (ComponentSelection.Item.state == 1) {
                            insertRow("Use", ComponentSelection.Item.name + " " + "->" + " " + client.getColorTags(65535) + var23.name, 1, var21, x, y);
                        } else if (ComponentSelection.Spell.state) {
                            if ((ComponentSelection.Spell.flags & 4) == 4) {
                                insertRow(ComponentSelection.action, ComponentSelection.Spell.name + " " + "->" + " " + client.getColorTags(65535) + var23.name, 2, var21, x, y);
                            }
                        } else {
                            String[] var28 = var23.actions;
                            if (var28 != null) {
                                for (int var29 = 4; var29 >= 0; --var29) {
                                    if (var28[var29] != null) {
                                        short var26 = 0;
                                        if (var29 == 0) {
                                            var26 = 3;
                                        }

                                        if (var29 == 1) {
                                            var26 = 4;
                                        }

                                        if (var29 == 2) {
                                            var26 = 5;
                                        }

                                        if (var29 == 3) {
                                            var26 = 6;
                                        }

                                        if (var29 == 4) {
                                            var26 = 1001;
                                        }

                                        insertRow(var28[var29], client.getColorTags(65535) + var23.name, var26, var21, x, y);
                                    }
                                }
                            }

                            insertRow("Examine", client.getColorTags(65535) + var23.name, 1002, var23.anInt693, x, y);
                        }
                    }

                    int var24;
                    NpcEntity var25;
                    PlayerEntity var27;
                    int[] var36;
                    int var39;
                    if (var20 == 1) {
                        NpcEntity var33 = client.npcs[var21];
                        if (var33 == null) {
                            break label336;
                        }

                        if (var33.definition.size == 1 && (var33.absoluteX & 127) == 64 && (var33.absoluteY & 127) == 64) {
                            for (var24 = 0; var24 < client.npcCount; ++var24) {
                                var25 = client.npcs[client.npcIndices[var24]];
                                if (var25 != null && var25 != var33 && var25.definition.size == 1 && var25.absoluteX == var33.absoluteX && var25.absoluteY == var33.absoluteY) {
                                    applyNpcActions(var25.definition, client.npcIndices[var24], x, y);
                                }
                            }

                            var24 = GPI.playerCount;
                            var36 = GPI.playerIndices;

                            for (var39 = 0; var39 < var24; ++var39) {
                                var27 = client.players[var36[var39]];
                                if (var27 != null && var33.absoluteX == var27.absoluteX && var33.absoluteY == var27.absoluteY) {
                                    applyPlayerActions(var27, var36[var39], x, y);
                                }
                            }
                        }

                        applyNpcActions(var33.definition, var21, x, y);
                    }

                    if (var20 == 0) {
                        PlayerEntity var34 = client.players[var21];
                        if (var34 == null) {
                            break label336;
                        }

                        if ((var34.absoluteX & 127) == 64 && (var34.absoluteY & 127) == 64) {
                            for (var24 = 0; var24 < client.npcCount; ++var24) {
                                var25 = client.npcs[client.npcIndices[var24]];
                                if (var25 != null && var25.definition.size == 1 && var25.absoluteX == var34.absoluteX && var34.absoluteY == var25.absoluteY) {
                                    applyNpcActions(var25.definition, client.npcIndices[var24], x, y);
                                }
                            }

                            var24 = GPI.playerCount;
                            var36 = GPI.playerIndices;

                            for (var39 = 0; var39 < var24; ++var39) {
                                var27 = client.players[var36[var39]];
                                if (var27 != null && var34 != var27 && var34.absoluteX == var27.absoluteX && var34.absoluteY == var27.absoluteY) {
                                    applyPlayerActions(var27, var36[var39], x, y);
                                }
                            }
                        }

                        if (var21 != client.anInt1030) {
                            applyPlayerActions(var34, var21, x, y);
                        } else {
                            var5 = var13;
                        }
                    }

                    if (var20 == 3) {
                        NodeDeque<Pickable> var35 = client.pickables[SceneGraph.floorLevel][x][y];
                        if (var35 != null) {
                            for (Pickable pickable = var35.tail(); pickable != null; pickable = var35.previous()) {
                                ItemDefinition def = ItemDefinition.get(pickable.id);
                                if (ComponentSelection.Item.state == 1) {
                                    insertRow("Use", ComponentSelection.Item.name + " " + "->" + " " + client.getColorTags(16748608) + def.name, 16, pickable.id, x, y);
                                } else if (ComponentSelection.Spell.state) {
                                    if ((ComponentSelection.Spell.flags & 1) == 1) {
                                        insertRow(ComponentSelection.action, ComponentSelection.Spell.name + " " + "->" + " " + client.getColorTags(16748608) + def.name, 17, pickable.id, x, y);
                                    }
                                } else {
                                    String[] var30 = def.groundActions;

                                    for (int var31 = 4; var31 >= 0; --var31) {
                                        if (var30 != null && var30[var31] != null) {
                                            byte var32 = 0;
                                            if (var31 == 0) {
                                                var32 = 18;
                                            }

                                            if (var31 == 1) {
                                                var32 = 19;
                                            }

                                            if (var31 == 2) {
                                                var32 = 20;
                                            }

                                            if (var31 == 3) {
                                                var32 = 21;
                                            }

                                            if (var31 == 4) {
                                                var32 = 22;
                                            }

                                            insertRow(var30[var31], client.getColorTags(16748608) + def.name, var32, pickable.id, x, y);
                                        } else if (var31 == 2) {
                                            insertRow("Take", client.getColorTags(0xff9040) + def.name, 20, pickable.id, x, y);
                                        }
                                    }

                                    insertRow("Examine", client.getColorTags(16748608) + def.name, 1004, pickable.id, x, y);
                                }
                            }
                        }
                    }
                }
            }

            ++sceneX;
        }
    }

    public static void insertCancelItem() {
        ContextMenu.close();
        ContextMenu.actions[0] = "Cancel";
        ContextMenu.targets[0] = "";
        ContextMenu.opcodes[0] = 1006;
        ContextMenu.shiftClickActions[0] = false;
        ContextMenu.rowCount = 1;
    }
}
