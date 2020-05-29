package jag.audi;

import jag.ClientLocale;
import jag.SerializableLong;
import jag.URLRequest;
import jag.audi.vorbis.Vorbis8;
import jag.commons.collection.Node;
import jag.commons.input.Keyboard;
import jag.commons.input.Mouse;
import jag.game.InterfaceComponent;
import jag.game.SubInterface;
import jag.game.World;
import jag.game.client;
import jag.game.stockmarket.StockMarketOfferQuantityComparator;
import jag.game.type.AnimationFrameGroup;
import jag.game.type.ItemDefinition;
import jag.opcode.AsyncOutputStream;
import jag.opcode.OldConnection;
import jag.script.ScriptEvent;
import jag.statics.*;
import jag.worldmap.*;

public class Node_Sub19 extends Node {
    public static int anInt1191;
    public int anInt564;
    public AudioOverrideEffect aAudioOverrideEffect_1193;
    public AudioOverride aAudioOverride_1192;
    public Vorbis8 aClass5_Sub10_Sub1_1194;
    public PcmStream_Sub2 aClass5_Sub6_Sub2_1195;
    public int anInt368;
    public int anInt380;
    public int anInt379;
    public int anInt696;
    public int anInt563;
    public int anInt372;
    public int anInt574;
    public int anInt375;
    public int anInt1149;
    public int anInt112;
    public int anInt367;
    public int anInt386;
    public int anInt788;
    public int anInt366;
    public int anInt666;
    public int anInt702;

    public Node_Sub19() {
    }

    public static void processComponentEvents(InterfaceComponent[] group, int var1, int var2, int var3, int var4, int var5, int rootX, int rootY) {
        for (InterfaceComponent c : group) {
            if (c != null && c.parentUid == var1 && (!c.aBoolean562 || c.type == 0 || c.aBoolean1378 || InterfaceComponent.getConfig(c) != 0 || c == client.topLevelOfDraggedComponent || c.contentType == 1338)) {
                if (c.aBoolean562) {
                    if (InterfaceComponent.isExplicitlyHidden(c)) {
                        continue;
                    }
                } else if (c.type == 0 && c != OldConnection.anInterfaceComponent873 && InterfaceComponent.isExplicitlyHidden(c)) {
                    continue;
                }

                int var11 = c.relativeX + rootX;
                int var12 = c.relativeY + rootY;
                int var13;
                int var14;
                int var15;
                int var16;
                int var18;
                int var20;
                if (c.type == 2) {
                    var13 = var2;
                    var14 = var3;
                    var15 = var4;
                    var16 = var5;
                } else {
                    int var17;
                    if (c.type == 9) {
                        var17 = var11;
                        var18 = var12;
                        var20 = var11 + c.width;
                        int var21 = var12 + c.height;
                        if (var20 < var11) {
                            var17 = var20;
                            var20 = var11;
                        }

                        if (var21 < var12) {
                            var18 = var21;
                            var21 = var12;
                        }

                        ++var20;
                        ++var21;
                        var13 = Math.max(var17, var2);
                        var14 = Math.max(var18, var3);
                        var15 = Math.min(var20, var4);
                        var16 = Math.min(var21, var5);
                    } else {
                        var17 = var11 + c.width;
                        var18 = var12 + c.height;
                        var13 = Math.max(var11, var2);
                        var14 = Math.max(var12, var3);
                        var15 = Math.min(var17, var4);
                        var16 = Math.min(var18, var5);
                    }
                }

                if (c == client.draggedComponent) {
                    client.processingComponentDrag = true;
                    client.anInt1068 = var11;
                    client.anInt1073 = var12;
                }

                boolean var33 = false;
                if (c.aBoolean1372) {
                    switch (client.anInt1047) {
                        case 0:
                            var33 = true;
                        case 1:
                        default:
                            break;
                        case 2:
                            if (client.anInt1059 == c.uid >>> 16) {
                                var33 = true;
                            }
                            break;
                        case 3:
                            if (c.uid == client.anInt1059) {
                                var33 = true;
                            }
                    }
                }

                if (var33 || !c.aBoolean562 || var13 < var15 && var14 < var16) {
                    if (c.aBoolean562) {
                        ScriptEvent var19;
                        if (c.aBoolean1412) {
                            if (Mouse.x >= var13 && Mouse.y >= var14 && Mouse.x < var15 && Mouse.y < var16) {
                                for (var19 = client.aNodeDeque1082.head(); var19 != null; var19 = (ScriptEvent) client.aNodeDeque1082.next()) {
                                    if (var19.aBoolean786) {
                                        var19.unlink();
                                        var19.source.aBoolean1404 = false;
                                    }
                                }

                                if (Statics2.anInt654 == 0) {
                                    client.draggedComponent = null;
                                    client.topLevelOfDraggedComponent = null;
                                }

                                if (!client.menuOpen) {
                                    Keyboard.method102();
                                }
                            }
                        } else if (c.aBoolean1410 && Mouse.x >= var13 && Mouse.y >= var14 && Mouse.x < var15 && Mouse.y < var16) {
                            for (var19 = client.aNodeDeque1082.head(); var19 != null; var19 = (ScriptEvent) client.aNodeDeque1082.next()) {
                                if (var19.aBoolean786 && var19.source.scrollListeners == var19.args) {
                                    var19.unlink();
                                }
                            }
                        }
                    }

                    var18 = Mouse.x;
                    var20 = Mouse.y;
                    if (Mouse.clickMeta != 0) {
                        var18 = Mouse.clickX;
                        var20 = Mouse.clickY;
                    }

                    boolean var34 = var18 >= var13 && var20 >= var14 && var18 < var15 && var20 < var16;
                    if (c.contentType == 1337) {
                        if (!client.aBoolean939 && !client.menuOpen && var34) {
                            Statics49.buildMenu(var18, var20, var13, var14);
                        }
                    } else if (c.contentType == 1338) {
                        AsyncOutputStream.processMinimapClick(c, var11, var12);
                    } else {
                        if (c.contentType == 1400) {
                            client.worldMap.method1279(Mouse.x, Mouse.y, var34, var11, var12, c.width, c.height);
                        }

                        if (!client.menuOpen && var34) {
                            if (c.contentType == 1400) {
                                client.worldMap.method1259(var11, var12, c.width, c.height, var18, var20);
                            } else {
                                buildComponentMenu(c, var18 - var11, var20 - var12);
                            }
                        }

                        boolean var23;
                        int var25;
                        if (var33) {
                            for (int var22 = 0; var22 < c.aByteArrayArray1365.length; ++var22) {
                                var23 = false;
                                boolean var24 = false;
                                if (!var23 && c.aByteArrayArray1365[var22] != null) {
                                    for (var25 = 0; var25 < c.aByteArrayArray1365[var22].length; ++var25) {
                                        boolean var26 = false;
                                        if (c.anIntArray1405 != null) {
                                            var26 = Keyboard.heldKeys[c.aByteArrayArray1365[var22][var25]];
                                        }

                                        if (AudioOverrideEffect.method794(c.aByteArrayArray1365[var22][var25]) || var26) {
                                            var23 = true;
                                            if (c.anIntArray1405 != null && c.anIntArray1405[var22] > client.engineCycle) {
                                                break;
                                            }

                                            byte var27 = c.aByteArrayArray1363[var22][var25];
                                            if (var27 == 0 || ((var27 & 8) == 0 || !Keyboard.heldKeys[86] && !Keyboard.heldKeys[82] && !Keyboard.heldKeys[81]) && ((var27 & 2) == 0 || Keyboard.heldKeys[86]) && ((var27 & 1) == 0 || Keyboard.heldKeys[82]) && ((var27 & 4) == 0 || Keyboard.heldKeys[81])) {
                                                var24 = true;
                                                break;
                                            }
                                        }
                                    }
                                }

                                if (var24) {
                                    if (var22 < 10) {
                                        InterfaceComponent.processAction(var22 + 1, c.uid, c.componentIndex, c.itemId, "");
                                    } else if (var22 == 10) {
                                        Statics17.processSelectedSpell();
                                        Statics49.selectSpell(c.uid, c.componentIndex, SerializableLong.getComponentSpellTargets(InterfaceComponent.getConfig(c)), c.itemId);
                                        client.selectedComponentAction = Enum_Sub8.method1091(c);
                                        if (client.selectedComponentAction == null) {
                                            client.selectedComponentAction = "null";
                                        }

                                        client.selectedSpellName = c.name + World.getColorTags(16777215);
                                    }

                                    var25 = c.anIntArray1361[var22];
                                    if (c.anIntArray1405 == null) {
                                        c.anIntArray1405 = new int[c.aByteArrayArray1365.length];
                                    }

                                    if (c.anIntArray1366 == null) {
                                        c.anIntArray1366 = new int[c.aByteArrayArray1365.length];
                                    }

                                    if (var25 != 0) {
                                        if (c.anIntArray1405[var22] == 0) {
                                            c.anIntArray1405[var22] = var25 + client.engineCycle + c.anIntArray1366[var22];
                                        } else {
                                            c.anIntArray1405[var22] = var25 + client.engineCycle;
                                        }
                                    } else {
                                        c.anIntArray1405[var22] = Integer.MAX_VALUE;
                                    }
                                }

                                if (!var23 && c.anIntArray1405 != null) {
                                    c.anIntArray1405[var22] = 0;
                                }
                            }
                        }

                        if (c.aBoolean562) {
                            var34 = Mouse.x >= var13 && Mouse.y >= var14 && Mouse.x < var15 && Mouse.y < var16;

                            boolean var35 = false;
                            if ((Mouse.pressMeta == 1 || !WorldMapIcon_Sub1.aBoolean492 && Mouse.pressMeta == 4) && var34) {
                                var35 = true;
                            }

                            var23 = (Mouse.clickMeta == 1 || !WorldMapIcon_Sub1.aBoolean492 && Mouse.clickMeta == 4) && Mouse.clickX >= var13 && Mouse.clickY >= var14 && Mouse.clickX < var15 && Mouse.clickY < var16;

                            if (var23) {
                                Statics23.drag(c, Mouse.clickX - var11, Mouse.clickY - var12);
                            }

                            if (c.contentType == 1400) {
                                client.worldMap.method1278(var18, var20, var34 & var35, var34 & var23);
                            }

                            if (client.draggedComponent != null && c != client.draggedComponent && var34 && StockMarketOfferQuantityComparator.method477(InterfaceComponent.getConfig(c))) {
                                client.draggedSpecialComponent = c;
                            }

                            if (c == client.topLevelOfDraggedComponent) {
                                client.processingComponentDragTopLevel = true;
                                client.anInt1060 = var11;
                                client.anInt1069 = var12;
                            }

                            if (c.aBoolean1378) {
                                ScriptEvent var28;
                                if (var34 && client.anInt1086 != 0 && c.scrollListeners != null) {
                                    var28 = new ScriptEvent();
                                    var28.aBoolean786 = true;
                                    var28.source = c;
                                    var28.mouseY = client.anInt1086;
                                    var28.args = c.scrollListeners;
                                    client.aNodeDeque1082.add(var28);
                                }

                                if (client.draggedComponent != null || AnimationFrameGroup.anInterfaceComponent800 != null || client.menuOpen) {
                                    var23 = false;
                                    var35 = false;
                                    var34 = false;
                                }

                                if (!c.aBoolean1407 && var23) {
                                    c.aBoolean1407 = true;
                                    if (c.anObjectArray1386 != null) {
                                        var28 = new ScriptEvent();
                                        var28.aBoolean786 = true;
                                        var28.source = c;
                                        var28.mouseX = Mouse.clickX - var11;
                                        var28.mouseY = Mouse.clickY - var12;
                                        var28.args = c.anObjectArray1386;
                                        client.aNodeDeque1082.add(var28);
                                    }
                                }

                                if (c.aBoolean1407 && var35 && c.anObjectArray1385 != null) {
                                    var28 = new ScriptEvent();
                                    var28.aBoolean786 = true;
                                    var28.source = c;
                                    var28.mouseX = Mouse.x - var11;
                                    var28.mouseY = Mouse.y - var12;
                                    var28.args = c.anObjectArray1385;
                                    client.aNodeDeque1082.add(var28);
                                }

                                if (c.aBoolean1407 && !var35) {
                                    c.aBoolean1407 = false;
                                    if (c.anObjectArray1376 != null) {
                                        var28 = new ScriptEvent();
                                        var28.aBoolean786 = true;
                                        var28.source = c;
                                        var28.mouseX = Mouse.x - var11;
                                        var28.mouseY = Mouse.y - var12;
                                        var28.args = c.anObjectArray1376;
                                        client.aNodeDeque1080.add(var28);
                                    }
                                }

                                if (var35 && c.anObjectArray1379 != null) {
                                    var28 = new ScriptEvent();
                                    var28.aBoolean786 = true;
                                    var28.source = c;
                                    var28.mouseX = Mouse.x - var11;
                                    var28.mouseY = Mouse.y - var12;
                                    var28.args = c.anObjectArray1379;
                                    client.aNodeDeque1082.add(var28);
                                }

                                if (!c.aBoolean1404 && var34) {
                                    c.aBoolean1404 = true;
                                    if (c.mouseEnterListeners != null) {
                                        var28 = new ScriptEvent();
                                        var28.aBoolean786 = true;
                                        var28.source = c;
                                        var28.mouseX = Mouse.x - var11;
                                        var28.mouseY = Mouse.y - var12;
                                        var28.args = c.mouseEnterListeners;
                                        client.aNodeDeque1082.add(var28);
                                    }
                                }

                                if (c.aBoolean1404 && var34 && c.hoverListeners != null) {
                                    var28 = new ScriptEvent();
                                    var28.aBoolean786 = true;
                                    var28.source = c;
                                    var28.mouseX = Mouse.x - var11;
                                    var28.mouseY = Mouse.y - var12;
                                    var28.args = c.hoverListeners;
                                    client.aNodeDeque1082.add(var28);
                                }

                                if (c.aBoolean1404 && !var34) {
                                    c.aBoolean1404 = false;
                                    if (c.mouseExitListeners != null) {
                                        var28 = new ScriptEvent();
                                        var28.aBoolean786 = true;
                                        var28.source = c;
                                        var28.mouseX = Mouse.x - var11;
                                        var28.mouseY = Mouse.y - var12;
                                        var28.args = c.mouseExitListeners;
                                        client.aNodeDeque1080.add(var28);
                                    }
                                }

                                if (c.renderListeners != null) {
                                    var28 = new ScriptEvent();
                                    var28.source = c;
                                    var28.args = c.renderListeners;
                                    client.aNodeDeque1088.add(var28);
                                }

                                ScriptEvent var29;
                                int var36;
                                int var37;
                                if (c.configListenerArgs != null && client.anInt1064 > c.anInt1413) {
                                    if (c.configTriggers != null && client.anInt1064 - c.anInt1413 <= 32) {
                                        label876:
                                        for (var36 = c.anInt1413; var36 < client.anInt1064; ++var36) {
                                            var25 = client.anIntArray1076[var36 & 31];

                                            for (var37 = 0; var37 < c.configTriggers.length; ++var37) {
                                                if (var25 == c.configTriggers[var37]) {
                                                    var29 = new ScriptEvent();
                                                    var29.source = c;
                                                    var29.args = c.configListenerArgs;
                                                    client.aNodeDeque1082.add(var29);
                                                    break label876;
                                                }
                                            }
                                        }
                                    } else {
                                        var28 = new ScriptEvent();
                                        var28.source = c;
                                        var28.args = c.configListenerArgs;
                                        client.aNodeDeque1082.add(var28);
                                    }

                                    c.anInt1413 = client.anInt1064;
                                }

                                if (c.tableListenerArgs != null && client.anInt1078 > c.anInt1408) {
                                    if (c.itemTriggers != null && client.anInt1078 - c.anInt1408 <= 32) {
                                        label852:
                                        for (var36 = c.anInt1408; var36 < client.anInt1078; ++var36) {
                                            var25 = client.inventories[var36 & 31];

                                            for (var37 = 0; var37 < c.itemTriggers.length; ++var37) {
                                                if (var25 == c.itemTriggers[var37]) {
                                                    var29 = new ScriptEvent();
                                                    var29.source = c;
                                                    var29.args = c.tableListenerArgs;
                                                    client.aNodeDeque1082.add(var29);
                                                    break label852;
                                                }
                                            }
                                        }
                                    } else {
                                        var28 = new ScriptEvent();
                                        var28.source = c;
                                        var28.args = c.tableListenerArgs;
                                        client.aNodeDeque1082.add(var28);
                                    }

                                    c.anInt1408 = client.anInt1078;
                                }

                                if (c.skillListenerArgs != null && client.anInt1063 > c.anInt1411) {
                                    if (c.skillTriggers != null && client.anInt1063 - c.anInt1411 <= 32) {
                                        label828:
                                        for (var36 = c.anInt1411; var36 < client.anInt1063; ++var36) {
                                            var25 = client.anIntArray1079[var36 & 31];

                                            for (var37 = 0; var37 < c.skillTriggers.length; ++var37) {
                                                if (var25 == c.skillTriggers[var37]) {
                                                    var29 = new ScriptEvent();
                                                    var29.source = c;
                                                    var29.args = c.skillListenerArgs;
                                                    client.aNodeDeque1082.add(var29);
                                                    break label828;
                                                }
                                            }
                                        }
                                    } else {
                                        var28 = new ScriptEvent();
                                        var28.source = c;
                                        var28.args = c.skillListenerArgs;
                                        client.aNodeDeque1082.add(var28);
                                    }

                                    c.anInt1411 = client.anInt1063;
                                }

                                if (client.anInt1066 > c.anInt1406 && c.anObjectArray1403 != null) {
                                    var28 = new ScriptEvent();
                                    var28.source = c;
                                    var28.args = c.anObjectArray1403;
                                    client.aNodeDeque1082.add(var28);
                                }

                                if (client.anInt1065 > c.anInt1406 && c.anObjectArray1399 != null) {
                                    var28 = new ScriptEvent();
                                    var28.source = c;
                                    var28.args = c.anObjectArray1399;
                                    client.aNodeDeque1082.add(var28);
                                }

                                if (client.anInt1061 > c.anInt1406 && c.anObjectArray1396 != null) {
                                    var28 = new ScriptEvent();
                                    var28.source = c;
                                    var28.args = c.anObjectArray1396;
                                    client.aNodeDeque1082.add(var28);
                                }

                                if (client.anInt1071 > c.anInt1406 && c.anObjectArray1391 != null) {
                                    var28 = new ScriptEvent();
                                    var28.source = c;
                                    var28.args = c.anObjectArray1391;
                                    client.aNodeDeque1082.add(var28);
                                }

                                if (client.anInt1077 > c.anInt1406 && c.anObjectArray1394 != null) {
                                    var28 = new ScriptEvent();
                                    var28.source = c;
                                    var28.args = c.anObjectArray1394;
                                    client.aNodeDeque1082.add(var28);
                                }

                                if (client.anInt1074 > c.anInt1406 && c.anObjectArray1390 != null) {
                                    var28 = new ScriptEvent();
                                    var28.source = c;
                                    var28.args = c.anObjectArray1390;
                                    client.aNodeDeque1082.add(var28);
                                }

                                c.anInt1406 = client.anInt1075;
                                if (c.anObjectArray1398 != null) {
                                    for (var36 = 0; var36 < client.anInt1092; ++var36) {
                                        ScriptEvent var30 = new ScriptEvent();
                                        var30.source = c;
                                        var30.anInt372 = client.anIntArray1096[var36];
                                        var30.anInt379 = client.anIntArray1097[var36];
                                        var30.args = c.anObjectArray1398;
                                        client.aNodeDeque1082.add(var30);
                                    }
                                }
                            }
                        }

                        if (!c.aBoolean562) {
                            if (client.draggedComponent != null || AnimationFrameGroup.anInterfaceComponent800 != null || client.menuOpen) {
                                continue;
                            }

                            if ((c.anInt1402 >= 0 || c.anInt1345 != 0) && Mouse.x >= var13 && Mouse.y >= var14 && Mouse.x < var15 && Mouse.y < var16) {
                                if (c.anInt1402 >= 0) {
                                    OldConnection.anInterfaceComponent873 = group[c.anInt1402];
                                } else {
                                    OldConnection.anInterfaceComponent873 = c;
                                }
                            }

                            if (c.type == 8 && Mouse.x >= var13 && Mouse.y >= var14 && Mouse.x < var15 && Mouse.y < var16) {
                                Statics24.anInterfaceComponent1417 = c;
                            }

                            if (c.viewportHeight > c.height) {
                                InterfaceComponent.method177(c, var11 + c.width, var12, c.height, c.viewportHeight, Mouse.x, Mouse.y);
                            }
                        }

                        if (c.type == 0) {
                            processComponentEvents(group, c.uid, var13, var14, var15, var16, var11 - c.insetX, var12 - c.insetY);
                            if (c.components != null) {
                                processComponentEvents(c.components, c.uid, var13, var14, var15, var16, var11 - c.insetX, var12 - c.insetY);
                            }

                            SubInterface var31 = client.subInterfaces.lookup(c.uid);
                            if (var31 != null) {
                                if (var31.state == 0 && Mouse.x >= var13 && Mouse.y >= var14 && Mouse.x < var15 && Mouse.y < var16 && !client.menuOpen) {
                                    for (ScriptEvent var32 = client.aNodeDeque1082.head(); var32 != null; var32 = client.aNodeDeque1082.next()) {
                                        if (var32.aBoolean786) {
                                            var32.unlink();
                                            var32.source.aBoolean1404 = false;
                                        }
                                    }

                                    if (Statics2.anInt654 == 0) {
                                        client.draggedComponent = null;
                                        client.topLevelOfDraggedComponent = null;
                                    }

                                    if (!client.menuOpen) {
                                        Keyboard.method102();
                                    }
                                }

                                WorldMapTileDecor.processComponentRendering(var31.id, var13, var14, var15, var16, var11, var12);
                            }
                        }
                    }
                }
            }
        }

    }

    static void buildComponentMenu(InterfaceComponent var0, int var1, int var2) {
        if (var0.buttonType == 1) {
            WorldMapTileDecor_Sub1.insertMenuItem(var0.toolTip, "", 24, 0, 0, var0.uid);
        }

        String var4;
        if (var0.buttonType == 2 && !client.spellSelected) {
            var4 = Enum_Sub8.method1091(var0);
            if (var4 != null) {
                WorldMapTileDecor_Sub1.insertMenuItem(var4, World.getColorTags(65280) + var0.spellName, 25, 0, -1, var0.uid);
            }
        }

        if (var0.buttonType == 3) {
            WorldMapTileDecor_Sub1.insertMenuItem("Close", "", 26, 0, 0, var0.uid);
        }

        if (var0.buttonType == 4) {
            WorldMapTileDecor_Sub1.insertMenuItem(var0.toolTip, "", 28, 0, 0, var0.uid);
        }

        if (var0.buttonType == 5) {
            WorldMapTileDecor_Sub1.insertMenuItem(var0.toolTip, "", 29, 0, 0, var0.uid);
        }

        if (var0.buttonType == 6 && client.pleaseWaitComponent == null) {
            WorldMapTileDecor_Sub1.insertMenuItem(var0.toolTip, "", 30, 0, -1, var0.uid);
        }

        int var5;
        int var6;
        int var7;
        if (var0.type == 2) {
            var5 = 0;

            for (var6 = 0; var6 < var0.height; ++var6) {
                for (var7 = 0; var7 < var0.width; ++var7) {
                    int var8 = (var0.xPadding + 32) * var7;
                    int var9 = (var0.yPadding + 32) * var6;
                    if (var5 < 20) {
                        var8 += var0.xSprites[var5];
                        var9 += var0.ySprites[var5];
                    }

                    if (var1 >= var8 && var2 >= var9 && var1 < var8 + 32 && var2 < var9 + 32) {
                        client.anInt1019 = var5;
                        DefaultAudioSystemProvider.anInterfaceComponent144 = var0;
                        if (var0.itemIds[var5] > 0) {
                            label331:
                            {
                                ItemDefinition var10 = ItemDefinition.get(var0.itemIds[var5] - 1);
                                int var11;
                                boolean var12;
                                if (client.itemSelectionState == 1) {
                                    var11 = InterfaceComponent.getConfig(var0);
                                    var12 = (var11 >> 30 & 1) != 0;
                                    if (var12) {
                                        if (var0.uid != SerializableLong.selectedItemComponentUid || var5 != DefaultAudioSystemProvider.selectedItemId) {
                                            WorldMapTileDecor_Sub1.insertMenuItem("Use", client.selectedItemName + " " + "->" + " " + World.getColorTags(16748608) + var10.name, 31, var10.anInt693, var5, var0.uid);
                                        }
                                        break label331;
                                    }
                                }

                                if (client.spellSelected) {
                                    var11 = InterfaceComponent.getConfig(var0);
                                    var12 = (var11 >> 30 & 1) != 0;
                                    if (var12) {
                                        if ((client.spellTargetFlags & 16) == 16) {
                                            WorldMapTileDecor_Sub1.insertMenuItem(client.selectedComponentAction, client.selectedSpellName + " " + "->" + " " + World.getColorTags(16748608) + var10.name, 32, var10.anInt693, var5, var0.uid);
                                        }
                                        break label331;
                                    }
                                }

                                String[] var13;
                                var11 = -1;
                                if (client.aBoolean1044 && Statics52.method345()) {
                                    var11 = var10.method522();
                                }

                                int var14 = InterfaceComponent.getConfig(var0);
                                boolean var15 = (var14 >> 30 & 1) != 0;
                                if (var15) {
                                    for (int var16 = 4; var16 >= 3; --var16) {
                                        if (var16 != var11) {
                                            URLRequest.method617(var0, var10, var5, var16, false);
                                        }
                                    }
                                }

                                int var17 = InterfaceComponent.getConfig(var0);
                                boolean var26 = (var17 >> 31 & 1) != 0;
                                if (var26) {
                                    WorldMapTileDecor_Sub1.insertMenuItem("Use", World.getColorTags(16748608) + var10.name, 38, var10.anInt693, var5, var0.uid);
                                }

                                int var18 = InterfaceComponent.getConfig(var0);
                                boolean var19 = (var18 >> 30 & 1) != 0;
                                int var20;
                                if (var19) {
                                    for (var20 = 2; var20 >= 0; --var20) {
                                        if (var11 != var20) {
                                            URLRequest.method617(var0, var10, var5, var20, false);
                                        }
                                    }

                                    if (var11 >= 0) {
                                        URLRequest.method617(var0, var10, var5, var11, true);
                                    }
                                }

                                var13 = var0.tableActions;
                                if (var13 != null) {
                                    for (var20 = 4; var20 >= 0; --var20) {
                                        if (var13[var20] != null) {
                                            byte var21 = 0;
                                            if (var20 == 0) {
                                                var21 = 39;
                                            }

                                            if (var20 == 1) {
                                                var21 = 40;
                                            }

                                            if (var20 == 2) {
                                                var21 = 41;
                                            }

                                            if (var20 == 3) {
                                                var21 = 42;
                                            }

                                            if (var20 == 4) {
                                                var21 = 43;
                                            }

                                            WorldMapTileDecor_Sub1.insertMenuItem(var13[var20], World.getColorTags(16748608) + var10.name, var21, var10.anInt693, var5, var0.uid);
                                        }
                                    }
                                }

                                WorldMapTileDecor_Sub1.insertMenuItem("Examine", World.getColorTags(16748608) + var10.name, 1005, var10.anInt693, var5, var0.uid);
                            }
                        }
                    }

                    ++var5;
                }
            }
        }

        if (var0.aBoolean562) {
            if (client.spellSelected) {
                var6 = InterfaceComponent.getConfig(var0);
                boolean var24 = (var6 >> 21 & 1) != 0;
                if (var24 && (client.spellTargetFlags & 32) == 32) {
                    WorldMapTileDecor_Sub1.insertMenuItem(client.selectedComponentAction, client.selectedSpellName + " " + "->" + " " + var0.name, 58, 0, var0.componentIndex, var0.uid);
                }
            } else {
                for (var5 = 9; var5 >= 5; --var5) {
                    String var22 = InterfaceComponent.method612(var0, var5);
                    if (var22 != null) {
                        WorldMapTileDecor_Sub1.insertMenuItem(var22, var0.name, 1007, var5 + 1, var0.componentIndex, var0.uid);
                    }
                }

                var4 = Enum_Sub8.method1091(var0);
                if (var4 != null) {
                    WorldMapTileDecor_Sub1.insertMenuItem(var4, var0.name, 25, 0, var0.componentIndex, var0.uid);
                }

                for (var6 = 4; var6 >= 0; --var6) {
                    String var23 = InterfaceComponent.method612(var0, var6);
                    if (var23 != null) {
                        client.insertMenuItem(var23, var0.name, 57, var6 + 1, var0.componentIndex, var0.uid, var0.aBoolean1409);
                    }
                }

                var7 = InterfaceComponent.getConfig(var0);
                boolean var25 = (var7 & 1) != 0;
                if (var25) {
                    WorldMapTileDecor_Sub1.insertMenuItem("Continue", "", 30, 0, var0.componentIndex, var0.uid);
                }
            }
        }

    }

    public static int method858(char var0, ClientLocale var1) {
        int var2 = var0 << 4;
        if (Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
            var0 = Character.toLowerCase(var0);
            var2 = (var0 << 4) + 1;
        }

        if (var0 == 241 && var1 == ClientLocale.ES) {
            var2 = 1762;
        }

        return var2;
    }

    public void method499() {
        this.aAudioOverride_1192 = null;
        this.aClass5_Sub10_Sub1_1194 = null;
        this.aAudioOverrideEffect_1193 = null;
        this.aClass5_Sub6_Sub2_1195 = null;
    }
}
