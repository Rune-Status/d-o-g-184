package jag.statics;

import jag.EntityUID;
import jag.commons.collection.NodeDeque;
import jag.game.InterfaceComponent;
import jag.game.World;
import jag.game.client;
import jag.game.option.AttackOptionPriority;
import jag.game.scene.SceneGraph;
import jag.game.scene.entity.NpcEntity;
import jag.game.scene.entity.Pickable;
import jag.game.scene.entity.PlayerEntity;
import jag.game.stockmarket.StockMarketEvent;
import jag.game.type.ItemDefinition;
import jag.game.type.ObjectDefinition;
import jag.graphics.IndexedSprite;
import jag.opcode.GPI;
import jag.script.ScriptEvent;
import jag.worldmap.WorldMapTileDecor_Sub1;

public class Statics49 {
    public static IndexedSprite aDoublyNode_Sub24_Sub4_126;

    public static char convertDiacritic(char var0) {
        switch (var0) {
            case ' ':
            case '-':
            case '_':
            case ' ':
                return '_';
            case '#':
            case '[':
            case ']':
                return var0;
            case 'À':
            case 'Á':
            case 'Â':
            case 'Ã':
            case 'Ä':
            case 'à':
            case 'á':
            case 'â':
            case 'ã':
            case 'ä':
                return 'a';
            case 'Ç':
            case 'ç':
                return 'c';
            case 'È':
            case 'É':
            case 'Ê':
            case 'Ë':
            case 'è':
            case 'é':
            case 'ê':
            case 'ë':
                return 'e';
            case 'Í':
            case 'Î':
            case 'Ï':
            case 'í':
            case 'î':
            case 'ï':
                return 'i';
            case 'Ñ':
            case 'ñ':
                return 'n';
            case 'Ò':
            case 'Ó':
            case 'Ô':
            case 'Õ':
            case 'Ö':
            case 'ò':
            case 'ó':
            case 'ô':
            case 'õ':
            case 'ö':
                return 'o';
            case 'Ù':
            case 'Ú':
            case 'Û':
            case 'Ü':
            case 'ù':
            case 'ú':
            case 'û':
            case 'ü':
                return 'u';
            case 'ß':
                return 'b';
            case 'ÿ':
            case 'Ÿ':
                return 'y';
            default:
                return Character.toLowerCase(var0);
        }
    }

    public static void buildMenu(int var0, int var1, int var2, int var3) {
        if (client.itemSelectionState == 0 && !client.spellSelected) {
            WorldMapTileDecor_Sub1.insertMenuItem("Walk here", "", 23, 0, var0 - var2, var1 - var3);
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
                    StockMarketEvent.buildPlayerMenu(var12, client.anInt1030, sceneX, sceneY);
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
                    if (var20 == 2 && client.sceneGraph.method1453(SceneGraph.floorLevel, x, y, var13) >= 0) {
                        ObjectDefinition var23 = ObjectDefinition.get(var21);
                        if (var23.transformIds != null) {
                            var23 = var23.transform();
                        }

                        if (var23 == null) {
                            break label336;
                        }

                        if (client.itemSelectionState == 1) {
                            WorldMapTileDecor_Sub1.insertMenuItem("Use", client.selectedItemName + " " + "->" + " " + World.getColorTags(65535) + var23.name, 1, var21, x, y);
                        } else if (client.spellSelected) {
                            if ((client.spellTargetFlags & 4) == 4) {
                                WorldMapTileDecor_Sub1.insertMenuItem(client.selectedComponentAction, client.selectedSpellName + " " + "->" + " " + World.getColorTags(65535) + var23.name, 2, var21, x, y);
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

                                        WorldMapTileDecor_Sub1.insertMenuItem(var28[var29], World.getColorTags(65535) + var23.name, var26, var21, x, y);
                                    }
                                }
                            }

                            WorldMapTileDecor_Sub1.insertMenuItem("Examine", World.getColorTags(65535) + var23.name, 1002, var23.anInt693, x, y);
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

                        if (var33.definition.size == 1 && (var33.fineX & 127) == 64 && (var33.fineY & 127) == 64) {
                            for (var24 = 0; var24 < client.npcCount; ++var24) {
                                var25 = client.npcs[client.npcIndices[var24]];
                                if (var25 != null && var25 != var33 && var25.definition.size == 1 && var25.fineX == var33.fineX && var25.fineY == var33.fineY) {
                                    Statics9.buildNpcMenu(var25.definition, client.npcIndices[var24], x, y);
                                }
                            }

                            var24 = GPI.playerCount;
                            var36 = GPI.playerIndices;

                            for (var39 = 0; var39 < var24; ++var39) {
                                var27 = client.players[var36[var39]];
                                if (var27 != null && var33.fineX == var27.fineX && var33.fineY == var27.fineY) {
                                    StockMarketEvent.buildPlayerMenu(var27, var36[var39], x, y);
                                }
                            }
                        }

                        Statics9.buildNpcMenu(var33.definition, var21, x, y);
                    }

                    if (var20 == 0) {
                        PlayerEntity var34 = client.players[var21];
                        if (var34 == null) {
                            break label336;
                        }

                        if ((var34.fineX & 127) == 64 && (var34.fineY & 127) == 64) {
                            for (var24 = 0; var24 < client.npcCount; ++var24) {
                                var25 = client.npcs[client.npcIndices[var24]];
                                if (var25 != null && var25.definition.size == 1 && var25.fineX == var34.fineX && var34.fineY == var25.fineY) {
                                    Statics9.buildNpcMenu(var25.definition, client.npcIndices[var24], x, y);
                                }
                            }

                            var24 = GPI.playerCount;
                            var36 = GPI.playerIndices;

                            for (var39 = 0; var39 < var24; ++var39) {
                                var27 = client.players[var36[var39]];
                                if (var27 != null && var34 != var27 && var34.fineX == var27.fineX && var34.fineY == var27.fineY) {
                                    StockMarketEvent.buildPlayerMenu(var27, var36[var39], x, y);
                                }
                            }
                        }

                        if (var21 != client.anInt1030) {
                            StockMarketEvent.buildPlayerMenu(var34, var21, x, y);
                        } else {
                            var5 = var13;
                        }
                    }

                    if (var20 == 3) {
                        NodeDeque<Pickable> var35 = client.pickableNodeDeques[SceneGraph.floorLevel][x][y];
                        if (var35 != null) {
                            for (Pickable var38 = var35.tail(); var38 != null; var38 = var35.previous()) {
                                ItemDefinition var37 = ItemDefinition.get(var38.id);
                                if (client.itemSelectionState == 1) {
                                    WorldMapTileDecor_Sub1.insertMenuItem("Use", client.selectedItemName + " " + "->" + " " + World.getColorTags(16748608) + var37.name, 16, var38.id, x, y);
                                } else if (client.spellSelected) {
                                    if ((client.spellTargetFlags & 1) == 1) {
                                        WorldMapTileDecor_Sub1.insertMenuItem(client.selectedComponentAction, client.selectedSpellName + " " + "->" + " " + World.getColorTags(16748608) + var37.name, 17, var38.id, x, y);
                                    }
                                } else {
                                    String[] var30 = var37.groundActions;

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

                                            WorldMapTileDecor_Sub1.insertMenuItem(var30[var31], World.getColorTags(16748608) + var37.name, var32, var38.id, x, y);
                                        } else if (var31 == 2) {
                                            WorldMapTileDecor_Sub1.insertMenuItem("Take", World.getColorTags(16748608) + var37.name, 20, var38.id, x, y);
                                        }
                                    }

                                    WorldMapTileDecor_Sub1.insertMenuItem("Examine", World.getColorTags(16748608) + var37.name, 1004, var38.id, x, y);
                                }
                            }
                        }
                    }
                }
            }

            ++sceneX;
        }
    }

    public static void selectSpell(int component, int index, int flags, int itemId) {
        InterfaceComponent var4 = InterfaceComponent.lookup(component, index);
        if (var4 != null && var4.anObjectArray1377 != null) {
            ScriptEvent var5 = new ScriptEvent();
            var5.source = var4;
            var5.args = var4.anObjectArray1377;
            ScriptEvent.fire(var5);
        }

        client.anInt1052 = itemId;
        client.spellSelected = true;
        AttackOptionPriority.selectedSpellComponentUid = component;
        client.selectedSpellComponentIndex = index;
        client.spellTargetFlags = flags;
        InterfaceComponent.repaint(var4);
    }

}
