package com.jagex;

public class Node_Sub19 extends Node {
    static int anInt1191;
    int anInt564;
    Class139 aClass139_1193;
    Node_Sub16 aNode_Sub16_1192;
    Node_Sub10_Sub1 aClass5_Sub10_Sub1_1194;
    Node_Sub6_Sub2 aClass5_Sub6_Sub2_1195;
    int anInt368;
    int anInt380;
    int anInt379;
    int anInt696;
    int anInt563;
    int anInt372;
    int anInt574;
    int anInt375;
    int anInt1149;
    int anInt112;
    int anInt367;
    int anInt386;
    int anInt788;
    int anInt366;
    int anInt666;
    int anInt702;

    Node_Sub19() {
    }

    static void processComponentEvents(InterfaceComponent[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        for (InterfaceComponent var10 : var0) {
            if (var10 != null && var10.parentUid == var1 && (!var10.aBoolean562 || var10.type == 0 || var10.aBoolean1378 || InterfaceComponent.getConfig(var10) != 0 || var10 == client.topLevelOfDraggedComponent || var10.contentType == 1338)) {
                if (var10.aBoolean562) {
                    if (Enum_Sub2.method440(var10)) {
                        continue;
                    }
                } else if (var10.type == 0 && var10 != OldConnection.anInterfaceComponent873 && Enum_Sub2.method440(var10)) {
                    continue;
                }

                int var11 = var10.relativeX + var6;
                int var12 = var7 + var10.relativeY;
                int var13;
                int var14;
                int var15;
                int var16;
                int var18;
                int var20;
                if (var10.type == 2) {
                    var13 = var2;
                    var14 = var3;
                    var15 = var4;
                    var16 = var5;
                } else {
                    int var17;
                    if (var10.type == 9) {
                        var17 = var11;
                        var18 = var12;
                        var20 = var11 + var10.width;
                        int var21 = var12 + var10.height;
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
                        var13 = var17 > var2 ? var17 : var2;
                        var14 = var18 > var3 ? var18 : var3;
                        var15 = var20 < var4 ? var20 : var4;
                        var16 = var21 < var5 ? var21 : var5;
                    } else {
                        var17 = var11 + var10.width;
                        var18 = var12 + var10.height;
                        var13 = var11 > var2 ? var11 : var2;
                        var14 = var12 > var3 ? var12 : var3;
                        var15 = var17 < var4 ? var17 : var4;
                        var16 = var18 < var5 ? var18 : var5;
                    }
                }

                if (var10 == client.draggedComponent) {
                    client.aBoolean1067 = true;
                    client.anInt1068 = var11;
                    client.anInt1073 = var12;
                }

                boolean var33 = false;
                if (var10.aBoolean1372) {
                    switch (client.anInt1047) {
                        case 0:
                            var33 = true;
                        case 1:
                        default:
                            break;
                        case 2:
                            if (client.anInt1059 == var10.uid >>> 16) {
                                var33 = true;
                            }
                            break;
                        case 3:
                            if (var10.uid == client.anInt1059) {
                                var33 = true;
                            }
                    }
                }

                if (var33 || !var10.aBoolean562 || var13 < var15 && var14 < var16) {
                    if (var10.aBoolean562) {
                        ScriptEvent var19;
                        if (var10.aBoolean1412) {
                            if (Mouse.x >= var13 && Mouse.y >= var14 && Mouse.x < var15 && Mouse.y < var16) {
                                for (var19 = (ScriptEvent) client.aNodeDeque1082.head(); var19 != null; var19 = (ScriptEvent) client.aNodeDeque1082.next()) {
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
                        } else if (var10.aBoolean1410 && Mouse.x >= var13 && Mouse.y >= var14 && Mouse.x < var15 && Mouse.y < var16) {
                            for (var19 = (ScriptEvent) client.aNodeDeque1082.head(); var19 != null; var19 = (ScriptEvent) client.aNodeDeque1082.next()) {
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
                    if (var10.contentType == 1337) {
                        if (!client.aBoolean939 && !client.menuOpen && var34) {
                            Class8.buildMenu(var18, var20, var13, var14);
                        }
                    } else if (var10.contentType == 1338) {
                        AsyncOutputStream.method13(var10, var11, var12);
                    } else {
                        if (var10.contentType == 1400) {
                            Class44.aClass209_391.method1279(Mouse.x, Mouse.y, var34, var11, var12, var10.width, var10.height);
                        }

                        if (!client.menuOpen && var34) {
                            if (var10.contentType == 1400) {
                                Class44.aClass209_391.method1259(var11, var12, var10.width, var10.height, var18, var20);
                            } else {
                                buildComponentMenu(var10, var18 - var11, var20 - var12);
                            }
                        }

                        boolean var23;
                        int var25;
                        if (var33) {
                            for (int var22 = 0; var22 < var10.aByteArrayArray1365.length; ++var22) {
                                var23 = false;
                                boolean var24 = false;
                                if (!var23 && var10.aByteArrayArray1365[var22] != null) {
                                    for (var25 = 0; var25 < var10.aByteArrayArray1365[var22].length; ++var25) {
                                        boolean var26 = false;
                                        if (var10.anIntArray1405 != null) {
                                            var26 = Keyboard.heldKeys[var10.aByteArrayArray1365[var22][var25]];
                                        }

                                        if (Class139.method794(var10.aByteArrayArray1365[var22][var25]) || var26) {
                                            var23 = true;
                                            if (var10.anIntArray1405 != null && var10.anIntArray1405[var22] > client.engineCycle) {
                                                break;
                                            }

                                            byte var27 = var10.aByteArrayArray1363[var22][var25];
                                            if (var27 == 0 || ((var27 & 8) == 0 || !Keyboard.heldKeys[86] && !Keyboard.heldKeys[82] && !Keyboard.heldKeys[81]) && ((var27 & 2) == 0 || Keyboard.heldKeys[86]) && ((var27 & 1) == 0 || Keyboard.heldKeys[82]) && ((var27 & 4) == 0 || Keyboard.heldKeys[81])) {
                                                var24 = true;
                                                break;
                                            }
                                        }
                                    }
                                }

                                if (var24) {
                                    if (var22 < 10) {
                                        Class36.processComponentAction(var22 + 1, var10.uid, var10.componentIndex, var10.itemId, "");
                                    } else if (var22 == 10) {
                                        Statics17.processSelectedSpell();
                                        Class8.selectSpell(var10.uid, var10.componentIndex, Class87.getComponentSpellTargets(InterfaceComponent.getConfig(var10)), var10.itemId);
                                        client.aString1049 = Enum_Sub8.method1091(var10);
                                        if (client.aString1049 == null) {
                                            client.aString1049 = "null";
                                        }

                                        client.aString1051 = var10.name + World.getColorTags(16777215);
                                    }

                                    var25 = var10.anIntArray1361[var22];
                                    if (var10.anIntArray1405 == null) {
                                        var10.anIntArray1405 = new int[var10.aByteArrayArray1365.length];
                                    }

                                    if (var10.anIntArray1366 == null) {
                                        var10.anIntArray1366 = new int[var10.aByteArrayArray1365.length];
                                    }

                                    if (var25 != 0) {
                                        if (var10.anIntArray1405[var22] == 0) {
                                            var10.anIntArray1405[var22] = var25 + client.engineCycle + var10.anIntArray1366[var22];
                                        } else {
                                            var10.anIntArray1405[var22] = var25 + client.engineCycle;
                                        }
                                    } else {
                                        var10.anIntArray1405[var22] = Integer.MAX_VALUE;
                                    }
                                }

                                if (!var23 && var10.anIntArray1405 != null) {
                                    var10.anIntArray1405[var22] = 0;
                                }
                            }
                        }

                        if (var10.aBoolean562) {
                            var34 = Mouse.x >= var13 && Mouse.y >= var14 && Mouse.x < var15 && Mouse.y < var16;

                            boolean var35 = false;
                            if ((Mouse.pressMeta == 1 || !Class27_Sub1.aBoolean492 && Mouse.pressMeta == 4) && var34) {
                                var35 = true;
                            }

                            var23 = (Mouse.clickMeta == 1 || !Class27_Sub1.aBoolean492 && Mouse.clickMeta == 4) && Mouse.clickX >= var13 && Mouse.clickY >= var14 && Mouse.clickX < var15 && Mouse.clickY < var16;

                            if (var23) {
                                Statics23.drag(var10, Mouse.clickX - var11, Mouse.clickY - var12);
                            }

                            if (var10.contentType == 1400) {
                                Class44.aClass209_391.method1278(var18, var20, var34 & var35, var34 & var23);
                            }

                            if (client.draggedComponent != null && var10 != client.draggedComponent && var34 && Class88.method477(InterfaceComponent.getConfig(var10))) {
                                client.anInterfaceComponent1058 = var10;
                            }

                            if (var10 == client.topLevelOfDraggedComponent) {
                                client.aBoolean1070 = true;
                                client.anInt1060 = var11;
                                client.anInt1069 = var12;
                            }

                            if (var10.aBoolean1378) {
                                ScriptEvent var28;
                                if (var34 && client.anInt1086 != 0 && var10.scrollListeners != null) {
                                    var28 = new ScriptEvent();
                                    var28.aBoolean786 = true;
                                    var28.source = var10;
                                    var28.mouseY = client.anInt1086;
                                    var28.args = var10.scrollListeners;
                                    client.aNodeDeque1082.add(var28);
                                }

                                if (client.draggedComponent != null || DoublyLinkedNode_Sub6.anInterfaceComponent800 != null || client.menuOpen) {
                                    var23 = false;
                                    var35 = false;
                                    var34 = false;
                                }

                                if (!var10.aBoolean1407 && var23) {
                                    var10.aBoolean1407 = true;
                                    if (var10.anObjectArray1386 != null) {
                                        var28 = new ScriptEvent();
                                        var28.aBoolean786 = true;
                                        var28.source = var10;
                                        var28.mouseX = Mouse.clickX - var11;
                                        var28.mouseY = Mouse.clickY - var12;
                                        var28.args = var10.anObjectArray1386;
                                        client.aNodeDeque1082.add(var28);
                                    }
                                }

                                if (var10.aBoolean1407 && var35 && var10.anObjectArray1385 != null) {
                                    var28 = new ScriptEvent();
                                    var28.aBoolean786 = true;
                                    var28.source = var10;
                                    var28.mouseX = Mouse.x - var11;
                                    var28.mouseY = Mouse.y - var12;
                                    var28.args = var10.anObjectArray1385;
                                    client.aNodeDeque1082.add(var28);
                                }

                                if (var10.aBoolean1407 && !var35) {
                                    var10.aBoolean1407 = false;
                                    if (var10.anObjectArray1376 != null) {
                                        var28 = new ScriptEvent();
                                        var28.aBoolean786 = true;
                                        var28.source = var10;
                                        var28.mouseX = Mouse.x - var11;
                                        var28.mouseY = Mouse.y - var12;
                                        var28.args = var10.anObjectArray1376;
                                        client.aNodeDeque1080.add(var28);
                                    }
                                }

                                if (var35 && var10.anObjectArray1379 != null) {
                                    var28 = new ScriptEvent();
                                    var28.aBoolean786 = true;
                                    var28.source = var10;
                                    var28.mouseX = Mouse.x - var11;
                                    var28.mouseY = Mouse.y - var12;
                                    var28.args = var10.anObjectArray1379;
                                    client.aNodeDeque1082.add(var28);
                                }

                                if (!var10.aBoolean1404 && var34) {
                                    var10.aBoolean1404 = true;
                                    if (var10.mouseEnterListeners != null) {
                                        var28 = new ScriptEvent();
                                        var28.aBoolean786 = true;
                                        var28.source = var10;
                                        var28.mouseX = Mouse.x - var11;
                                        var28.mouseY = Mouse.y - var12;
                                        var28.args = var10.mouseEnterListeners;
                                        client.aNodeDeque1082.add(var28);
                                    }
                                }

                                if (var10.aBoolean1404 && var34 && var10.hoverListeners != null) {
                                    var28 = new ScriptEvent();
                                    var28.aBoolean786 = true;
                                    var28.source = var10;
                                    var28.mouseX = Mouse.x - var11;
                                    var28.mouseY = Mouse.y - var12;
                                    var28.args = var10.hoverListeners;
                                    client.aNodeDeque1082.add(var28);
                                }

                                if (var10.aBoolean1404 && !var34) {
                                    var10.aBoolean1404 = false;
                                    if (var10.mouseExitListeners != null) {
                                        var28 = new ScriptEvent();
                                        var28.aBoolean786 = true;
                                        var28.source = var10;
                                        var28.mouseX = Mouse.x - var11;
                                        var28.mouseY = Mouse.y - var12;
                                        var28.args = var10.mouseExitListeners;
                                        client.aNodeDeque1080.add(var28);
                                    }
                                }

                                if (var10.renderListeners != null) {
                                    var28 = new ScriptEvent();
                                    var28.source = var10;
                                    var28.args = var10.renderListeners;
                                    client.aNodeDeque1088.add(var28);
                                }

                                ScriptEvent var29;
                                int var36;
                                int var37;
                                if (var10.configListenerArgs != null && client.anInt1064 > var10.anInt1413) {
                                    if (var10.configTriggers != null && client.anInt1064 - var10.anInt1413 <= 32) {
                                        label876:
                                        for (var36 = var10.anInt1413; var36 < client.anInt1064; ++var36) {
                                            var25 = client.anIntArray1076[var36 & 31];

                                            for (var37 = 0; var37 < var10.configTriggers.length; ++var37) {
                                                if (var25 == var10.configTriggers[var37]) {
                                                    var29 = new ScriptEvent();
                                                    var29.source = var10;
                                                    var29.args = var10.configListenerArgs;
                                                    client.aNodeDeque1082.add(var29);
                                                    break label876;
                                                }
                                            }
                                        }
                                    } else {
                                        var28 = new ScriptEvent();
                                        var28.source = var10;
                                        var28.args = var10.configListenerArgs;
                                        client.aNodeDeque1082.add(var28);
                                    }

                                    var10.anInt1413 = client.anInt1064;
                                }

                                if (var10.tableListenerArgs != null && client.anInt1078 > var10.anInt1408) {
                                    if (var10.itemTriggers != null && client.anInt1078 - var10.anInt1408 <= 32) {
                                        label852:
                                        for (var36 = var10.anInt1408; var36 < client.anInt1078; ++var36) {
                                            var25 = client.inventories[var36 & 31];

                                            for (var37 = 0; var37 < var10.itemTriggers.length; ++var37) {
                                                if (var25 == var10.itemTriggers[var37]) {
                                                    var29 = new ScriptEvent();
                                                    var29.source = var10;
                                                    var29.args = var10.tableListenerArgs;
                                                    client.aNodeDeque1082.add(var29);
                                                    break label852;
                                                }
                                            }
                                        }
                                    } else {
                                        var28 = new ScriptEvent();
                                        var28.source = var10;
                                        var28.args = var10.tableListenerArgs;
                                        client.aNodeDeque1082.add(var28);
                                    }

                                    var10.anInt1408 = client.anInt1078;
                                }

                                if (var10.skillListenerArgs != null && client.anInt1063 > var10.anInt1411) {
                                    if (var10.skillTriggers != null && client.anInt1063 - var10.anInt1411 <= 32) {
                                        label828:
                                        for (var36 = var10.anInt1411; var36 < client.anInt1063; ++var36) {
                                            var25 = client.anIntArray1079[var36 & 31];

                                            for (var37 = 0; var37 < var10.skillTriggers.length; ++var37) {
                                                if (var25 == var10.skillTriggers[var37]) {
                                                    var29 = new ScriptEvent();
                                                    var29.source = var10;
                                                    var29.args = var10.skillListenerArgs;
                                                    client.aNodeDeque1082.add(var29);
                                                    break label828;
                                                }
                                            }
                                        }
                                    } else {
                                        var28 = new ScriptEvent();
                                        var28.source = var10;
                                        var28.args = var10.skillListenerArgs;
                                        client.aNodeDeque1082.add(var28);
                                    }

                                    var10.anInt1411 = client.anInt1063;
                                }

                                if (client.anInt1066 > var10.anInt1406 && var10.anObjectArray1403 != null) {
                                    var28 = new ScriptEvent();
                                    var28.source = var10;
                                    var28.args = var10.anObjectArray1403;
                                    client.aNodeDeque1082.add(var28);
                                }

                                if (client.anInt1065 > var10.anInt1406 && var10.anObjectArray1399 != null) {
                                    var28 = new ScriptEvent();
                                    var28.source = var10;
                                    var28.args = var10.anObjectArray1399;
                                    client.aNodeDeque1082.add(var28);
                                }

                                if (client.anInt1061 > var10.anInt1406 && var10.anObjectArray1396 != null) {
                                    var28 = new ScriptEvent();
                                    var28.source = var10;
                                    var28.args = var10.anObjectArray1396;
                                    client.aNodeDeque1082.add(var28);
                                }

                                if (client.anInt1071 > var10.anInt1406 && var10.anObjectArray1391 != null) {
                                    var28 = new ScriptEvent();
                                    var28.source = var10;
                                    var28.args = var10.anObjectArray1391;
                                    client.aNodeDeque1082.add(var28);
                                }

                                if (client.anInt1077 > var10.anInt1406 && var10.anObjectArray1394 != null) {
                                    var28 = new ScriptEvent();
                                    var28.source = var10;
                                    var28.args = var10.anObjectArray1394;
                                    client.aNodeDeque1082.add(var28);
                                }

                                if (client.anInt1074 > var10.anInt1406 && var10.anObjectArray1390 != null) {
                                    var28 = new ScriptEvent();
                                    var28.source = var10;
                                    var28.args = var10.anObjectArray1390;
                                    client.aNodeDeque1082.add(var28);
                                }

                                var10.anInt1406 = client.anInt1075;
                                if (var10.anObjectArray1398 != null) {
                                    for (var36 = 0; var36 < client.anInt1092; ++var36) {
                                        ScriptEvent var30 = new ScriptEvent();
                                        var30.source = var10;
                                        var30.anInt372 = client.anIntArray1096[var36];
                                        var30.anInt379 = client.anIntArray1097[var36];
                                        var30.args = var10.anObjectArray1398;
                                        client.aNodeDeque1082.add(var30);
                                    }
                                }
                            }
                        }

                        if (!var10.aBoolean562) {
                            if (client.draggedComponent != null || DoublyLinkedNode_Sub6.anInterfaceComponent800 != null || client.menuOpen) {
                                continue;
                            }

                            if ((var10.anInt1402 >= 0 || var10.anInt1345 != 0) && Mouse.x >= var13 && Mouse.y >= var14 && Mouse.x < var15 && Mouse.y < var16) {
                                if (var10.anInt1402 >= 0) {
                                    OldConnection.anInterfaceComponent873 = var0[var10.anInt1402];
                                } else {
                                    OldConnection.anInterfaceComponent873 = var10;
                                }
                            }

                            if (var10.type == 8 && Mouse.x >= var13 && Mouse.y >= var14 && Mouse.x < var15 && Mouse.y < var16) {
                                Statics24.anInterfaceComponent1417 = var10;
                            }

                            if (var10.viewportHeight > var10.height) {
                                Class9_Sub1.method177(var10, var11 + var10.width, var12, var10.height, var10.viewportHeight, Mouse.x, Mouse.y);
                            }
                        }

                        if (var10.type == 0) {
                            processComponentEvents(var0, var10.uid, var13, var14, var15, var16, var11 - var10.insetX, var12 - var10.insetY);
                            if (var10.components != null) {
                                processComponentEvents(var10.components, var10.uid, var13, var14, var15, var16, var11 - var10.insetX, var12 - var10.insetY);
                            }

                            InterfaceNode var31 = (InterfaceNode) client.interfaceNodes.lookup((long) var10.uid);
                            if (var31 != null) {
                                if (var31.state == 0 && Mouse.x >= var13 && Mouse.y >= var14 && Mouse.x < var15 && Mouse.y < var16 && !client.menuOpen) {
                                    for (ScriptEvent var32 = (ScriptEvent) client.aNodeDeque1082.head(); var32 != null; var32 = (ScriptEvent) client.aNodeDeque1082.next()) {
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

                                Class63.processComponentRendering(var31.id, var13, var14, var15, var16, var11, var12);
                            }
                        }
                    }
                }
            }
        }

    }

    static void buildComponentMenu(InterfaceComponent var0, int var1, int var2) {
        if (var0.buttonType == 1) {
            Class63_Sub1.insertMenuItem(var0.toolTip, "", 24, 0, 0, var0.uid);
        }

        String var4;
        if (var0.buttonType == 2 && !client.spellSelected) {
            var4 = Enum_Sub8.method1091(var0);
            if (var4 != null) {
                Class63_Sub1.insertMenuItem(var4, World.getColorTags(65280) + var0.spellName, 25, 0, -1, var0.uid);
            }
        }

        if (var0.buttonType == 3) {
            Class63_Sub1.insertMenuItem("Close", "", 26, 0, 0, var0.uid);
        }

        if (var0.buttonType == 4) {
            Class63_Sub1.insertMenuItem(var0.toolTip, "", 28, 0, 0, var0.uid);
        }

        if (var0.buttonType == 5) {
            Class63_Sub1.insertMenuItem(var0.toolTip, "", 29, 0, 0, var0.uid);
        }

        if (var0.buttonType == 6 && client.pleaseWaitComponent == null) {
            Class63_Sub1.insertMenuItem(var0.toolTip, "", 30, 0, -1, var0.uid);
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
                        Class12.anInterfaceComponent144 = var0;
                        if (var0.itemIds[var5] > 0) {
                            label331:
                            {
                                ItemDefinition var10 = CameraCapture.getItemDefinition(var0.itemIds[var5] - 1);
                                int var11;
                                boolean var12;
                                if (client.itemSelectionState == 1) {
                                    var11 = InterfaceComponent.getConfig(var0);
                                    var12 = (var11 >> 30 & 1) != 0;
                                    if (var12) {
                                        if (var0.uid != Class87.selectedItemComponentUid || var5 != Class12.selectedItemId) {
                                            Class63_Sub1.insertMenuItem("Use", client.aString1009 + " " + "->" + " " + World.getColorTags(16748608) + var10.name, 31, var10.anInt693, var5, var0.uid);
                                        }
                                        break label331;
                                    }
                                }

                                if (client.spellSelected) {
                                    var11 = InterfaceComponent.getConfig(var0);
                                    var12 = (var11 >> 30 & 1) != 0;
                                    if (var12) {
                                        if ((client.spellTargetFlags & 16) == 16) {
                                            Class63_Sub1.insertMenuItem(client.aString1049, client.aString1051 + " " + "->" + " " + World.getColorTags(16748608) + var10.name, 32, var10.anInt693, var5, var0.uid);
                                        }
                                        break label331;
                                    }
                                }

                                String[] var13 = var10.actions;
                                var11 = -1;
                                if (client.aBoolean1044 && Class62.method345()) {
                                    var11 = var10.method522();
                                }

                                int var14 = InterfaceComponent.getConfig(var0);
                                boolean var15 = (var14 >> 30 & 1) != 0;
                                if (var15) {
                                    for (int var16 = 4; var16 >= 3; --var16) {
                                        if (var16 != var11) {
                                            Class105.method617(var0, var10, var5, var16, false);
                                        }
                                    }
                                }

                                int var17 = InterfaceComponent.getConfig(var0);
                                boolean var26 = (var17 >> 31 & 1) != 0;
                                if (var26) {
                                    Class63_Sub1.insertMenuItem("Use", World.getColorTags(16748608) + var10.name, 38, var10.anInt693, var5, var0.uid);
                                }

                                int var18 = InterfaceComponent.getConfig(var0);
                                boolean var19 = (var18 >> 30 & 1) != 0;
                                int var20;
                                if (var19) {
                                    for (var20 = 2; var20 >= 0; --var20) {
                                        if (var11 != var20) {
                                            Class105.method617(var0, var10, var5, var20, false);
                                        }
                                    }

                                    if (var11 >= 0) {
                                        Class105.method617(var0, var10, var5, var11, true);
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

                                            Class63_Sub1.insertMenuItem(var13[var20], World.getColorTags(16748608) + var10.name, var21, var10.anInt693, var5, var0.uid);
                                        }
                                    }
                                }

                                Class63_Sub1.insertMenuItem("Examine", World.getColorTags(16748608) + var10.name, 1005, var10.anInt693, var5, var0.uid);
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
                    Class63_Sub1.insertMenuItem(client.aString1049, client.aString1051 + " " + "->" + " " + var0.name, 58, 0, var0.componentIndex, var0.uid);
                }
            } else {
                for (var5 = 9; var5 >= 5; --var5) {
                    String var22 = Class104.method612(var0, var5);
                    if (var22 != null) {
                        Class63_Sub1.insertMenuItem(var22, var0.name, 1007, var5 + 1, var0.componentIndex, var0.uid);
                    }
                }

                var4 = Enum_Sub8.method1091(var0);
                if (var4 != null) {
                    Class63_Sub1.insertMenuItem(var4, var0.name, 25, 0, var0.componentIndex, var0.uid);
                }

                for (var6 = 4; var6 >= 0; --var6) {
                    String var23 = Class104.method612(var0, var6);
                    if (var23 != null) {
                        ActionPrioritySetting.insertMenuItem(var23, var0.name, 57, var6 + 1, var0.componentIndex, var0.uid, var0.aBoolean1409);
                    }
                }

                var7 = InterfaceComponent.getConfig(var0);
                boolean var25 = (var7 & 1) != 0;
                if (var25) {
                    Class63_Sub1.insertMenuItem("Continue", "", 30, 0, var0.componentIndex, var0.uid);
                }
            }
        }

    }

    static int method858(char var0, Class149 var1) {
        int var2 = var0 << 4;
        if (Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
            var0 = Character.toLowerCase(var0);
            var2 = (var0 << 4) + 1;
        }

        if (var0 == 241 && var1 == Class149.aClass149_1183) {
            var2 = 1762;
        }

        return var2;
    }

    void method499() {
        this.aNode_Sub16_1192 = null;
        this.aClass5_Sub10_Sub1_1194 = null;
        this.aClass139_1193 = null;
        this.aClass5_Sub6_Sub2_1195 = null;
    }
}
