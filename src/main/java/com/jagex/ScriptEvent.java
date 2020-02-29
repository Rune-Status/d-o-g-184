package com.jagex;

import java.util.Date;

public class ScriptEvent extends Node {
    static int anInt1806;
    static int[] intStack;
    static String[] stringStack;
    int anInt367;
    Object[] args;
    InterfaceComponent source;
    int actionIndex;
    String opbase;
    boolean aBoolean786;
    int mouseX;
    int mouseY;
    InterfaceComponent target;
    int anInt368;
    int anInt372;
    int anInt379;

    public ScriptEvent() {
        this.anInt367 = 76;
    }

    public static String format(CharSequence var0, Class213 var1) {
        if (var0 == null) {
            return null;
        }
        int var2 = 0;

        int var3;
        for (var3 = var0.length(); var2 < var3 && Boundary.method1377(var0.charAt(var2)); ++var2) {
        }

        while (var3 > var2 && Boundary.method1377(var0.charAt(var3 - 1))) {
            --var3;
        }

        int var4 = var3 - var2;
        if (var4 >= 1 && var4 <= AsyncOutputStream.method15(var1)) {
            StringBuilder var5 = new StringBuilder(var4);

            for (int var6 = var2; var6 < var3; ++var6) {
                char var7 = var0.charAt(var6);
                boolean var8;
                if (Character.isISOControl(var7)) {
                    var8 = false;
                } else if (ReferenceTable.method898(var7)) {
                    var8 = true;
                } else {
                    char[] var10 = Statics42.aCharArray1910;
                    int var11 = 0;

                    label73:
                    while (true) {
                        char var12;
                        if (var11 >= var10.length) {
                            var10 = Statics42.aCharArray1909;

                            for (var11 = 0; var11 < var10.length; ++var11) {
                                var12 = var10[var11];
                                if (var7 == var12) {
                                    var8 = true;
                                    break label73;
                                }
                            }

                            var8 = false;
                            break;
                        }

                        var12 = var10[var11];
                        if (var12 == var7) {
                            var8 = true;
                            break;
                        }

                        ++var11;
                    }
                }

                if (var8) {
                    char var9 = Class8.method64(var7);
                    if (var9 != 0) {
                        var5.append(var9);
                    }
                }
            }

            if (var5.length() == 0) {
                return null;
            }
            return var5.toString();
        }
        return null;
    }

    static void method1305() {
        client.menuRowCount = 0;
        client.menuOpen = false;
    }

    static void renderComponents(InterfaceComponent[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        JagGraphics.setClip(var2, var3, var4, var5);
        JagGraphics3D.method499();

        for (InterfaceComponent var10 : var0) {
            if (var10 != null && (var10.parentUid == var1 || var1 == -1412584499 && var10 == client.draggedComponent)) {
                int var11;
                if (var8 == -1) {
                    client.interfacePositionsX[client.anInt1085] = var10.relativeX + var6;
                    client.interfacePositionsY[client.anInt1085] = var7 + var10.relativeY;
                    client.interfaceWidths[client.anInt1085] = var10.width;
                    client.interfaceHeights[client.anInt1085] = var10.height;
                    var11 = ++client.anInt1085 - 1;
                } else {
                    var11 = var8;
                }

                var10.boundsIndex = var11;
                var10.renderCycle = client.engineCycle;
                if (!var10.aBoolean562 || !Enum_Sub2.method440(var10)) {
                    if (var10.contentType > 0) {
                        Class27_Sub2.method475(var10);
                    }

                    int var12 = var10.relativeX + var6;
                    int var13 = var7 + var10.relativeY;
                    int var14 = var10.alpha;
                    int var15;
                    int var16;
                    if (var10 == client.draggedComponent) {
                        if (var1 != -1412584499 && !var10.aBoolean1388) {
                            GrandExchangeOffer.anInterfaceComponentArray337 = var0;
                            Statics23.anInt1342 = var6;
                            CameraCapture.anInt1913 = var7;
                            continue;
                        }

                        if (client.aBoolean1062 && client.aBoolean1070) {
                            var15 = Mouse.x;
                            var16 = Mouse.y;
                            var15 -= client.currentComponentDragX;
                            var16 -= client.currentComponentDragY;
                            if (var15 < client.anInt1060) {
                                var15 = client.anInt1060;
                            }

                            if (var15 + var10.width > client.anInt1060 + client.topLevelOfDraggedComponent.width) {
                                var15 = client.anInt1060 + client.topLevelOfDraggedComponent.width - var10.width;
                            }

                            if (var16 < client.anInt1069) {
                                var16 = client.anInt1069;
                            }

                            if (var16 + var10.height > client.anInt1069 + client.topLevelOfDraggedComponent.height) {
                                var16 = client.anInt1069 + client.topLevelOfDraggedComponent.height - var10.height;
                            }

                            var12 = var15;
                            var13 = var16;
                        }

                        if (!var10.aBoolean1388) {
                            var14 = 128;
                        }
                    }

                    int var17;
                    int var18;
                    int var19;
                    int var20;
                    int var21;
                    int var22;
                    if (var10.type == 2) {
                        var15 = var2;
                        var16 = var3;
                        var17 = var4;
                        var18 = var5;
                    } else if (var10.type == 9) {
                        var19 = var12;
                        var20 = var13;
                        var21 = var12 + var10.width;
                        var22 = var13 + var10.height;
                        if (var21 < var12) {
                            var19 = var21;
                            var21 = var12;
                        }

                        if (var22 < var13) {
                            var20 = var22;
                            var22 = var13;
                        }

                        ++var21;
                        ++var22;
                        var15 = var19 > var2 ? var19 : var2;
                        var16 = var20 > var3 ? var20 : var3;
                        var17 = var21 < var4 ? var21 : var4;
                        var18 = var22 < var5 ? var22 : var5;
                    } else {
                        var19 = var12 + var10.width;
                        var20 = var13 + var10.height;
                        var15 = var12 > var2 ? var12 : var2;
                        var16 = var13 > var3 ? var13 : var3;
                        var17 = var19 < var4 ? var19 : var4;
                        var18 = var20 < var5 ? var20 : var5;
                    }

                    if (!var10.aBoolean562 || var15 < var17 && var16 < var18) {
                        if (var10.contentType != 0) {
                            if (var10.contentType == 1336) {
                                if (client.aBoolean944) {
                                    var13 += 15;
                                    BootSprites.font_p12full.method1151("Fps:" + client.anInt1292, var12 + var10.width, var13, 16776960, -1);
                                    var13 += 15;
                                    Runtime var39 = Runtime.getRuntime();
                                    var20 = (int) ((var39.totalMemory() - var39.freeMemory()) / 1024L);
                                    var21 = 16776960;
                                    if (var20 > 327680 && !client.lowMemory) {
                                        var21 = 16711680;
                                    }

                                    BootSprites.font_p12full.method1151("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                                    var13 += 15;
                                }
                                continue;
                            }

                            if (var10.contentType == 1337) {
                                client.anInt1039 = var12;
                                client.anInt1038 = var13;
                                BefriendedPlayer.method553(var12, var13, var10.width, var10.height);
                                client.aBooleanArray1089[var10.boundsIndex] = true;
                                JagGraphics.setClip(var2, var3, var4, var5);
                                continue;
                            }

                            if (var10.contentType == 1338) {
                                ClientPreferences.method251(var10, var12, var13, var11);
                                JagGraphics.setClip(var2, var3, var4, var5);
                                continue;
                            }

                            if (var10.contentType == 1339) {
                                AudioRunnable.method985(var10, var12, var13);
                                JagGraphics.setClip(var2, var3, var4, var5);
                                continue;
                            }

                            if (var10.contentType == 1400) {
                                Class44.aClass209_391.method1268(var12, var13, var10.width, var10.height, client.engineCycle);
                            }

                            if (var10.contentType == 1401) {
                                Class44.aClass209_391.method1269(var12, var13, var10.width, var10.height);
                            }

                            if (var10.contentType == 1402) {
                                AsyncOutputStream.aClass45_105.method283(var12, client.engineCycle);
                            }
                        }

                        if (var10.type == 0) {
                            if (!var10.aBoolean562 && Enum_Sub2.method440(var10) && var10 != OldConnection.anInterfaceComponent873) {
                                continue;
                            }

                            if (!var10.aBoolean562) {
                                if (var10.insetY > var10.viewportHeight - var10.height) {
                                    var10.insetY = var10.viewportHeight - var10.height;
                                }

                                if (var10.insetY < 0) {
                                    var10.insetY = 0;
                                }
                            }

                            renderComponents(var0, var10.uid, var15, var16, var17, var18, var12 - var10.insetX, var13 - var10.insetY, var11);
                            if (var10.components != null) {
                                renderComponents(var10.components, var10.uid, var15, var16, var17, var18, var12 - var10.insetX, var13 - var10.insetY, var11);
                            }

                            InterfaceNode var24 = (InterfaceNode) client.interfaceNodes.lookup((long) var10.uid);
                            if (var24 != null) {
                                InterfaceComponent.method1201(var24.id, var15, var16, var17, var18, var12, var13, var11);
                            }

                            JagGraphics.setClip(var2, var3, var4, var5);
                            JagGraphics3D.method499();
                        }

                        if (client.aBoolean1090 || client.aBooleanArray1083[var11] || client.redrawMode > 1) {
                            if (var10.type == 0 && !var10.aBoolean562 && var10.viewportHeight > var10.height) {
                                GameEngine.drawScrollbar(var12 + var10.width, var13, var10.insetY, var10.height, var10.viewportHeight);
                            }

                            if (var10.type != 1) {
                                int var23;
                                int var25;
                                int var26;
                                int var27;
                                if (var10.type == 2) {
                                    var19 = 0;

                                    for (var20 = 0; var20 < var10.anInt1105; ++var20) {
                                        for (var21 = 0; var21 < var10.anInt694; ++var21) {
                                            var22 = var12 + var21 * (var10.xPadding + 32);
                                            var23 = var13 + var20 * (var10.yPadding + 32);
                                            if (var19 < 20) {
                                                var22 += var10.xSprites[var19];
                                                var23 += var10.ySprites[var19];
                                            }

                                            if (var10.itemIds[var19] <= 0) {
                                                if (var10.anIntArray1371 != null && var19 < 20) {
                                                    Sprite var43 = var10.method961(var19);
                                                    if (var43 != null) {
                                                        var43.method809(var22, var23);
                                                    } else if (InterfaceComponent.aBoolean1151) {
                                                        Enum_Sub2.repaintComponent(var10);
                                                    }
                                                }
                                            } else {
                                                boolean var40 = false;
                                                boolean var41 = false;
                                                var27 = var10.itemIds[var19] - 1;
                                                if (var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == DoublyLinkedNode_Sub6.anInterfaceComponent800 && var19 == client.anInt1023) {
                                                    Sprite var28;
                                                    if (client.itemSelectionState == 1 && var19 == Class12.selectedItemId && var10.uid == Class87.selectedItemComponentUid) {
                                                        var28 = Class76.getItemSprite(var27, var10.itemStackSizes[var19], 2, 0, 2, false);
                                                    } else {
                                                        var28 = Class76.getItemSprite(var27, var10.itemStackSizes[var19], 1, 3153952, 2, false);
                                                    }

                                                    if (var28 != null) {
                                                        if (var10 == DoublyLinkedNode_Sub6.anInterfaceComponent800 && var19 == client.anInt1023) {
                                                            var25 = Mouse.x - client.anInt1016;
                                                            var26 = Mouse.y - client.anInt1022;
                                                            if (var25 < 5 && var25 > -5) {
                                                                var25 = 0;
                                                            }

                                                            if (var26 < 5 && var26 > -5) {
                                                                var26 = 0;
                                                            }

                                                            if (client.anInt1027 < 5) {
                                                                var25 = 0;
                                                                var26 = 0;
                                                            }

                                                            var28.method832(var22 + var25, var23 + var26, 128);
                                                            if (var1 != -1) {
                                                                InterfaceComponent var29 = var0[var1 & 65535];
                                                                int var30;
                                                                if (var23 + var26 < JagGraphics.drawingAreaTop && var29.insetY > 0) {
                                                                    var30 = (JagGraphics.drawingAreaTop - var23 - var26) * client.anInt972 / 3;
                                                                    if (var30 > client.anInt972 * 10) {
                                                                        var30 = client.anInt972 * 10;
                                                                    }

                                                                    if (var30 > var29.insetY) {
                                                                        var30 = var29.insetY;
                                                                    }

                                                                    var29.insetY -= var30;
                                                                    client.anInt1022 += var30;
                                                                    Enum_Sub2.repaintComponent(var29);
                                                                }

                                                                if (var23 + var26 + 32 > JagGraphics.drawingAreaRight && var29.insetY < var29.viewportHeight - var29.height) {
                                                                    var30 = (var26 + var23 + 32 - JagGraphics.drawingAreaRight) * client.anInt972 / 3;
                                                                    if (var30 > client.anInt972 * 10) {
                                                                        var30 = client.anInt972 * 10;
                                                                    }

                                                                    if (var30 > var29.viewportHeight - var29.height - var29.insetY) {
                                                                        var30 = var29.viewportHeight - var29.height - var29.insetY;
                                                                    }

                                                                    var29.insetY += var30;
                                                                    client.anInt1022 -= var30;
                                                                    Enum_Sub2.repaintComponent(var29);
                                                                }
                                                            }
                                                        } else if (var10 == Class38.anInterfaceComponent351 && var19 == client.anInt1015) {
                                                            var28.method832(var22, var23, 128);
                                                        } else {
                                                            var28.method809(var22, var23);
                                                        }
                                                    } else {
                                                        Enum_Sub2.repaintComponent(var10);
                                                    }
                                                }
                                            }

                                            ++var19;
                                        }
                                    }
                                } else if (var10.type == 3) {
                                    if (Projectile.method1192(var10)) {
                                        var19 = var10.anInt1348;
                                        if (var10 == OldConnection.anInterfaceComponent873 && var10.anInt1344 != 0) {
                                            var19 = var10.anInt1344;
                                        }
                                    } else {
                                        var19 = var10.textColor;
                                        if (var10 == OldConnection.anInterfaceComponent873 && var10.anInt1345 != 0) {
                                            var19 = var10.anInt1345;
                                        }
                                    }

                                    if (var10.aBoolean1346) {
                                        switch (var10.anEnum_Sub11_1349.anInt633) {
                                            case 1:
                                                JagGraphics.method1376(var12, var13, var10.width, var10.height, var10.textColor, var10.anInt1348);
                                                break;
                                            case 2:
                                                JagGraphics.method1359(var12, var13, var10.width, var10.height, var10.textColor, var10.anInt1348, 255 - (var10.alpha & 255), 255 - (var10.anInt1343 & 255));
                                                break;
                                            default:
                                                if (var14 == 0) {
                                                    JagGraphics.fillRect(var12, var13, var10.width, var10.height, var19);
                                                } else {
                                                    JagGraphics.method1370(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                                                }
                                        }
                                    } else if (var14 == 0) {
                                        JagGraphics.method1372(var12, var13, var10.width, var10.height, var19);
                                    } else {
                                        JagGraphics.drawRect(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                                    }
                                } else {
                                    Font var37;
                                    if (var10.type == 4) {
                                        var37 = var10.method957();
                                        if (var37 == null) {
                                            if (InterfaceComponent.aBoolean1151) {
                                                Enum_Sub2.repaintComponent(var10);
                                            }
                                        } else {
                                            String var45 = var10.text;
                                            if (Projectile.method1192(var10)) {
                                                var20 = var10.anInt1348;
                                                if (var10 == OldConnection.anInterfaceComponent873 && var10.anInt1344 != 0) {
                                                    var20 = var10.anInt1344;
                                                }

                                                if (var10.aString1373.length() > 0) {
                                                    var45 = var10.aString1373;
                                                }
                                            } else {
                                                var20 = var10.textColor;
                                                if (var10 == OldConnection.anInterfaceComponent873 && var10.anInt1345 != 0) {
                                                    var20 = var10.anInt1345;
                                                }
                                            }

                                            if (var10.aBoolean562 && var10.itemId != -1) {
                                                ItemDefinition var46 = CameraCapture.getItemDefinition(var10.itemId);
                                                var45 = var46.name;
                                                if (var45 == null) {
                                                    var45 = "null";
                                                }

                                                if ((var46.stackable == 1 || var10.itemStackSize != 1) && var10.itemStackSize != -1) {
                                                    var45 = World.getColorTags(16748608) + var45 + "</col>" + " " + 'x' + Class20.method149(var10.itemStackSize);
                                                }
                                            }

                                            if (var10 == client.pleaseWaitComponent) {
                                                var45 = "Please wait...";
                                                var20 = var10.textColor;
                                            }

                                            if (!var10.aBoolean562) {
                                                var45 = InterfaceComponent.method1005(var45, var10);
                                            }

                                            var37.method1149(var45, var12, var13, var10.width, var10.height, var20, var10.textShadowed ? 0 : -1, var10.horizontalMargin, var10.verticalMargin, var10.textSpacing);
                                        }
                                    } else if (var10.type == 5) {
                                        Sprite var38;
                                        if (!var10.aBoolean562) {
                                            var38 = var10.method958(Projectile.method1192(var10));
                                            if (var38 != null) {
                                                var38.method809(var12, var13);
                                            } else if (InterfaceComponent.aBoolean1151) {
                                                Enum_Sub2.repaintComponent(var10);
                                            }
                                        } else {
                                            if (var10.itemId != -1) {
                                                var38 = Class76.getItemSprite(var10.itemId, var10.itemStackSize, var10.borderThickness, var10.shadowColor, var10.anInt1356, false);
                                            } else {
                                                var38 = var10.method958(false);
                                            }

                                            if (var38 == null) {
                                                if (InterfaceComponent.aBoolean1151) {
                                                    Enum_Sub2.repaintComponent(var10);
                                                }
                                            } else {
                                                var20 = var38.anInt112;
                                                var21 = var38.anInt375;
                                                if (!var10.aBoolean1358) {
                                                    var22 = var10.width * 4096 / var20;
                                                    if (var10.spriteId != 0) {
                                                        var38.method824(var10.width / 2 + var12, var10.height / 2 + var13, var10.spriteId, var22);
                                                    } else if (var14 != 0) {
                                                        var38.method818(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                                    } else if (var20 == var10.width && var21 == var10.height) {
                                                        var38.method809(var12, var13);
                                                    } else {
                                                        var38.method807(var12, var13, var10.width, var10.height);
                                                    }
                                                } else {
                                                    JagGraphics.method1364(var12, var13, var12 + var10.width, var13 + var10.height);
                                                    var22 = (var20 - 1 + var10.width) / var20;
                                                    var23 = (var21 - 1 + var10.height) / var21;

                                                    for (var25 = 0; var25 < var22; ++var25) {
                                                        for (var26 = 0; var26 < var23; ++var26) {
                                                            if (var10.spriteId != 0) {
                                                                var38.method824(var20 / 2 + var12 + var25 * var20, var21 / 2 + var13 + var26 * var21, var10.spriteId, 4096);
                                                            } else if (var14 != 0) {
                                                                var38.method832(var12 + var25 * var20, var13 + var26 * var21, 256 - (var14 & 255));
                                                            } else {
                                                                var38.method809(var12 + var25 * var20, var13 + var26 * var21);
                                                            }
                                                        }
                                                    }

                                                    JagGraphics.setClip(var2, var3, var4, var5);
                                                }
                                            }
                                        }
                                    } else {
                                        ItemDefinition var34;
                                        if (var10.type == 6) {
                                            boolean var36 = Projectile.method1192(var10);
                                            if (var36) {
                                                var20 = var10.anInt1353;
                                            } else {
                                                var20 = var10.anInt1357;
                                            }

                                            Model var42 = null;
                                            var22 = 0;
                                            if (var10.itemId != -1) {
                                                var34 = CameraCapture.getItemDefinition(var10.itemId);
                                                if (var34 != null) {
                                                    var34 = var34.method519(var10.itemStackSize);
                                                    var42 = var34.getModel(1);
                                                    if (var42 != null) {
                                                        var42.method827();
                                                        var22 = var42.height / 2;
                                                    } else {
                                                        Enum_Sub2.repaintComponent(var10);
                                                    }
                                                }
                                            } else if (var10.modelType == 5) {
                                                if (var10.modelId == 0) {
                                                    var42 = client.aPlayerAppearance924.getModel(null, -1, null, -1);
                                                } else {
                                                    var42 = PlayerEntity.local.getModel();
                                                }
                                            } else if (var20 == -1) {
                                                var42 = var10.method956(null, -1, var36, PlayerEntity.local.appearance);
                                                if (var42 == null && InterfaceComponent.aBoolean1151) {
                                                    Enum_Sub2.repaintComponent(var10);
                                                }
                                            } else {
                                                AnimationSequence var47 = Class57.getAnimationSequence(var20);
                                                var42 = var10.method956(var47, var10.anInt1389, var36, PlayerEntity.local.appearance);
                                                if (var42 == null && InterfaceComponent.aBoolean1151) {
                                                    Enum_Sub2.repaintComponent(var10);
                                                }
                                            }

                                            JagGraphics3D.method637(var10.width / 2 + var12, var10.height / 2 + var13);
                                            var23 = JagGraphics3D.SIN_TABLE[var10.xRotation] * var10.modelZoom >> 16;
                                            var25 = JagGraphics3D.COS_TABLE[var10.xRotation] * var10.modelZoom >> 16;
                                            if (var42 != null) {
                                                if (!var10.aBoolean562) {
                                                    var42.method1289(0, var10.zRotation, 0, var10.xRotation, 0, var23, var25);
                                                } else {
                                                    var42.method827();
                                                    if (var10.aBoolean1352) {
                                                        var42.method1287(0, var10.zRotation, var10.yRotation, var10.xRotation, var10.modelOffsetX, var22 + var23 + var10.modelOffsetY, var25 + var10.modelOffsetY, var10.modelZoom);
                                                    } else {
                                                        var42.method1289(0, var10.zRotation, var10.yRotation, var10.xRotation, var10.modelOffsetX, var23 + var22 + var10.modelOffsetY, var25 + var10.modelOffsetY);
                                                    }
                                                }
                                            }

                                            JagGraphics3D.method23();
                                        } else {
                                            if (var10.type == 7) {
                                                var37 = var10.method957();
                                                if (var37 == null) {
                                                    if (InterfaceComponent.aBoolean1151) {
                                                        Enum_Sub2.repaintComponent(var10);
                                                    }
                                                    continue;
                                                }

                                                var20 = 0;

                                                for (var21 = 0; var21 < var10.anInt1105; ++var21) {
                                                    for (var22 = 0; var22 < var10.anInt694; ++var22) {
                                                        if (var10.itemIds[var20] > 0) {
                                                            var34 = CameraCapture.getItemDefinition(var10.itemIds[var20] - 1);
                                                            String var31;
                                                            if (var34.stackable != 1 && var10.itemStackSizes[var20] == 1) {
                                                                var31 = World.getColorTags(16748608) + var34.name + "</col>";
                                                            } else {
                                                                var31 = World.getColorTags(16748608) + var34.name + "</col>" + " " + 'x' + Class20.method149(var10.itemStackSizes[var20]);
                                                            }

                                                            var26 = var12 + var22 * (var10.xPadding + 115);
                                                            var27 = var13 + (var10.yPadding + 12) * var21;
                                                            if (var10.horizontalMargin == 0) {
                                                                var37.method1152(var31, var26, var27, var10.textColor, var10.textShadowed ? 0 : -1);
                                                            } else if (var10.horizontalMargin == 1) {
                                                                var37.method1154(var31, var10.width / 2 + var26, var27, var10.textColor, var10.textShadowed ? 0 : -1);
                                                            } else {
                                                                var37.method1151(var31, var26 + var10.width - 1, var27, var10.textColor, var10.textShadowed ? 0 : -1);
                                                            }
                                                        }

                                                        ++var20;
                                                    }
                                                }
                                            }

                                            if (var10.type == 8 && var10 == Statics24.anInterfaceComponent1417 && client.anInt1041 == client.anInt1036) {
                                                var19 = 0;
                                                var20 = 0;
                                                Font var32 = BootSprites.font_p12full;
                                                String var33 = var10.text;

                                                String var44;
                                                for (var33 = InterfaceComponent.method1005(var33, var10); var33.length() > 0; var20 = var20 + var32.anInt375 + 1) {
                                                    var25 = var33.indexOf("<br>");
                                                    if (var25 != -1) {
                                                        var44 = var33.substring(0, var25);
                                                        var33 = var33.substring(var25 + 4);
                                                    } else {
                                                        var44 = var33;
                                                        var33 = "";
                                                    }

                                                    var26 = var32.method1145(var44);
                                                    if (var26 > var19) {
                                                        var19 = var26;
                                                    }
                                                }

                                                var19 += 6;
                                                var20 += 7;
                                                var25 = var12 + var10.width - 5 - var19;
                                                var26 = var13 + var10.height + 5;
                                                if (var25 < var12 + 5) {
                                                    var25 = var12 + 5;
                                                }

                                                if (var25 + var19 > var4) {
                                                    var25 = var4 - var19;
                                                }

                                                if (var26 + var20 > var5) {
                                                    var26 = var5 - var20;
                                                }

                                                JagGraphics.fillRect(var25, var26, var19, var20, 16777120);
                                                JagGraphics.method1372(var25, var26, var19, var20, 0);
                                                var33 = var10.text;
                                                var27 = var26 + var32.anInt375 + 2;

                                                for (var33 = InterfaceComponent.method1005(var33, var10); var33.length() > 0; var27 = var27 + var32.anInt375 + 1) {
                                                    int var35 = var33.indexOf("<br>");
                                                    if (var35 != -1) {
                                                        var44 = var33.substring(0, var35);
                                                        var33 = var33.substring(var35 + 4);
                                                    } else {
                                                        var44 = var33;
                                                        var33 = "";
                                                    }

                                                    var32.method1152(var44, var25 + 3, var27, 0, -1);
                                                }
                                            }

                                            if (var10.type == 9) {
                                                if (var10.aBoolean1360) {
                                                    var19 = var12;
                                                    var20 = var13 + var10.height;
                                                    var21 = var12 + var10.width;
                                                    var22 = var13;
                                                } else {
                                                    var19 = var12;
                                                    var20 = var13;
                                                    var21 = var12 + var10.width;
                                                    var22 = var13 + var10.height;
                                                }

                                                if (var10.anInt1347 == 1) {
                                                    JagGraphics.drawDiagonalLine(var19, var20, var21, var22, var10.textColor);
                                                } else {
                                                    Class12.method98(var19, var20, var21, var22, var10.textColor, var10.anInt1347);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    static void method1306(boolean var0) {
        client.aBoolean1037 = var0;
    }

    static int method875(int var0) {
        if (var0 == 3600) {
            if (Class44.socialSystem.state == 0) {
                intStack[++Class49.anInt442 - 1] = -2;
            } else if (Class44.socialSystem.state == 1) {
                intStack[++Class49.anInt442 - 1] = -1;
            } else {
                intStack[++Class49.anInt442 - 1] = Class44.socialSystem.friendListContext.getCount();
            }

            return 1;
        }
        int var3;
        if (var0 == 3601) {
            var3 = intStack[--Class49.anInt442];
            if (Class44.socialSystem.isReady() && var3 >= 0 && var3 < Class44.socialSystem.friendListContext.getCount()) {
                BefriendedPlayer var8 = (BefriendedPlayer) Class44.socialSystem.friendListContext.getChatter(var3);
                stringStack[++Class49.anInt441 - 1] = var8.getRawDisplayName();
                stringStack[++Class49.anInt441 - 1] = var8.getRawPreviousName();
            } else {
                stringStack[++Class49.anInt441 - 1] = "";
                stringStack[++Class49.anInt441 - 1] = "";
            }

            return 1;
        }
        if (var0 == 3602) {
            var3 = intStack[--Class49.anInt442];
            if (Class44.socialSystem.isReady() && var3 >= 0 && var3 < Class44.socialSystem.friendListContext.getCount()) {
                intStack[++Class49.anInt442 - 1] = ((Associate) Class44.socialSystem.friendListContext.getChatter(var3)).world;
            } else {
                intStack[++Class49.anInt442 - 1] = 0;
            }

            return 1;
        }
        if (var0 == 3603) {
            var3 = intStack[--Class49.anInt442];
            if (Class44.socialSystem.isReady() && var3 >= 0 && var3 < Class44.socialSystem.friendListContext.getCount()) {
                intStack[++Class49.anInt442 - 1] = ((Associate) Class44.socialSystem.friendListContext.getChatter(var3)).rank;
            } else {
                intStack[++Class49.anInt442 - 1] = 0;
            }

            return 1;
        }
        String var5;
        if (var0 == 3604) {
            var5 = stringStack[--Class49.anInt441];
            int var6 = intStack[--Class49.anInt442];
            NpcEntity.method681(var5, var6);
            return 1;
        }
        if (var0 == 3605) {
            var5 = stringStack[--Class49.anInt441];
            Class44.socialSystem.addFriend(var5);
            return 1;
        }
        if (var0 == 3606) {
            var5 = stringStack[--Class49.anInt441];
            Class44.socialSystem.removeFriend(var5);
            return 1;
        }
        if (var0 == 3607) {
            var5 = stringStack[--Class49.anInt441];
            Class44.socialSystem.addToIgnoreList(var5);
            return 1;
        }
        if (var0 == 3608) {
            var5 = stringStack[--Class49.anInt441];
            Class44.socialSystem.removeFromIgnoreList(var5);
            return 1;
        }
        if (var0 == 3609) {
            var5 = stringStack[--Class49.anInt441];
            var5 = Enum_Sub2.method442(var5);
            intStack[++Class49.anInt442 - 1] = Class44.socialSystem.isOnFriendsList(new NamePair(var5, Class36.aClass213_343)) ? 1 : 0;
            return 1;
        }
        if (var0 == 3611) {
            if (Varps.clanSystem != null) {
                stringStack[++Class49.anInt441 - 1] = Varps.clanSystem.channelName;
            } else {
                stringStack[++Class49.anInt441 - 1] = "";
            }

            return 1;
        }
        if (var0 == 3612) {
            if (Varps.clanSystem != null) {
                intStack[++Class49.anInt442 - 1] = Varps.clanSystem.getCount();
            } else {
                intStack[++Class49.anInt442 - 1] = 0;
            }

            return 1;
        }
        if (var0 == 3613) {
            var3 = intStack[--Class49.anInt442];
            if (Varps.clanSystem != null && var3 < Varps.clanSystem.getCount()) {
                stringStack[++Class49.anInt441 - 1] = Varps.clanSystem.getChatter(var3).getDisplayName().getRaw();
            } else {
                stringStack[++Class49.anInt441 - 1] = "";
            }

            return 1;
        }
        if (var0 == 3614) {
            var3 = intStack[--Class49.anInt442];
            if (Varps.clanSystem != null && var3 < Varps.clanSystem.getCount()) {
                intStack[++Class49.anInt442 - 1] = ((Associate) Varps.clanSystem.getChatter(var3)).getWorld();
            } else {
                intStack[++Class49.anInt442 - 1] = 0;
            }

            return 1;
        }
        if (var0 == 3615) {
            var3 = intStack[--Class49.anInt442];
            if (Varps.clanSystem != null && var3 < Varps.clanSystem.getCount()) {
                intStack[++Class49.anInt442 - 1] = ((Associate) Varps.clanSystem.getChatter(var3)).rank;
            } else {
                intStack[++Class49.anInt442 - 1] = 0;
            }

            return 1;
        }
        if (var0 == 3616) {
            intStack[++Class49.anInt442 - 1] = Varps.clanSystem != null ? Varps.clanSystem.aByte1887 : 0;
            return 1;
        }
        if (var0 == 3617) {
            var5 = stringStack[--Class49.anInt441];
            Statics25.method1093(var5);
            return 1;
        }
        if (var0 == 3618) {
            intStack[++Class49.anInt442 - 1] = Varps.clanSystem != null ? Varps.clanSystem.localPlayerRank : 0;
            return 1;
        }
        if (var0 == 3619) {
            var5 = stringStack[--Class49.anInt441];
            World.method1343(var5);
            return 1;
        }
        if (var0 == 3620) {
            Class34.method232();
            return 1;
        }
        if (var0 == 3621) {
            if (!Class44.socialSystem.isReady()) {
                intStack[++Class49.anInt442 - 1] = -1;
            } else {
                intStack[++Class49.anInt442 - 1] = Class44.socialSystem.ignoreListContext.getCount();
            }

            return 1;
        }
        if (var0 == 3622) {
            var3 = intStack[--Class49.anInt442];
            if (Class44.socialSystem.isReady() && var3 >= 0 && var3 < Class44.socialSystem.ignoreListContext.getCount()) {
                IgnoredPlayer var4 = (IgnoredPlayer) Class44.socialSystem.ignoreListContext.getChatter(var3);
                stringStack[++Class49.anInt441 - 1] = var4.getRawDisplayName();
                stringStack[++Class49.anInt441 - 1] = var4.getRawPreviousName();
            } else {
                stringStack[++Class49.anInt441 - 1] = "";
                stringStack[++Class49.anInt441 - 1] = "";
            }

            return 1;
        }
        if (var0 == 3623) {
            var5 = stringStack[--Class49.anInt441];
            var5 = Enum_Sub2.method442(var5);
            intStack[++Class49.anInt442 - 1] = Class44.socialSystem.isOnIgnoreList(new NamePair(var5, Class36.aClass213_343)) ? 1 : 0;
            return 1;
        }
        if (var0 == 3624) {
            var3 = intStack[--Class49.anInt442];
            if (Varps.clanSystem != null && var3 < Varps.clanSystem.getCount() && Varps.clanSystem.getChatter(var3).getDisplayName().equals(PlayerEntity.local.namePair)) {
                intStack[++Class49.anInt442 - 1] = 1;
            } else {
                intStack[++Class49.anInt442 - 1] = 0;
            }

            return 1;
        }
        if (var0 == 3625) {
            if (Varps.clanSystem != null && Varps.clanSystem.channelOwner != null) {
                stringStack[++Class49.anInt441 - 1] = Varps.clanSystem.channelOwner;
            } else {
                stringStack[++Class49.anInt441 - 1] = "";
            }

            return 1;
        }
        if (var0 == 3626) {
            var3 = intStack[--Class49.anInt442];
            if (Varps.clanSystem != null && var3 < Varps.clanSystem.getCount() && ((ClanMember) Varps.clanSystem.getChatter(var3)).method711()) {
                intStack[++Class49.anInt442 - 1] = 1;
            } else {
                intStack[++Class49.anInt442 - 1] = 0;
            }

            return 1;
        }
        if (var0 != 3627) {
            if (var0 == 3628) {
                Class44.socialSystem.friendListContext.unsetComparator();
                return 1;
            }
            boolean var7;
            if (var0 == 3629) {
                var7 = intStack[--Class49.anInt442] == 1;
                Class44.socialSystem.friendListContext.setComparator(new Class223(var7));
                return 1;
            }
            if (var0 == 3630) {
                var7 = intStack[--Class49.anInt442] == 1;
                Class44.socialSystem.friendListContext.setComparator(new Class211(var7));
                return 1;
            }
            if (var0 == 3631) {
                var7 = intStack[--Class49.anInt442] == 1;
                Class44.socialSystem.friendListContext.setComparator(new AssociateComparatorByWorld(var7));
                return 1;
            }
            if (var0 == 3632) {
                var7 = intStack[--Class49.anInt442] == 1;
                Class44.socialSystem.friendListContext.setComparator(new Class114(var7));
                return 1;
            }
            if (var0 == 3633) {
                var7 = intStack[--Class49.anInt442] == 1;
                Class44.socialSystem.friendListContext.setComparator(new AssociateComparator_Sub5(var7));
                return 1;
            }
            if (var0 == 3634) {
                var7 = intStack[--Class49.anInt442] == 1;
                Class44.socialSystem.friendListContext.setComparator(new AssociateComparatorByName(var7));
                return 1;
            }
            if (var0 == 3635) {
                var7 = intStack[--Class49.anInt442] == 1;
                Class44.socialSystem.friendListContext.setComparator(new AssociateComparator_Sub2(var7));
                return 1;
            }
            if (var0 == 3636) {
                var7 = intStack[--Class49.anInt442] == 1;
                Class44.socialSystem.friendListContext.setComparator(new AssociateComparatorByMyWorld(var7));
                return 1;
            }
            if (var0 == 3637) {
                var7 = intStack[--Class49.anInt442] == 1;
                Class44.socialSystem.friendListContext.setComparator(new AssociateComparatorByWorldAndName(var7));
                return 1;
            }
            if (var0 == 3638) {
                var7 = intStack[--Class49.anInt442] == 1;
                Class44.socialSystem.friendListContext.setComparator(new AssociateComparator_Sub4(var7));
                return 1;
            }
            if (var0 == 3639) {
                Class44.socialSystem.friendListContext.sort();
                return 1;
            }
            if (var0 == 3640) {
                Class44.socialSystem.ignoreListContext.unsetComparator();
                return 1;
            }
            if (var0 == 3641) {
                var7 = intStack[--Class49.anInt442] == 1;
                Class44.socialSystem.ignoreListContext.setComparator(new Class223(var7));
                return 1;
            }
            if (var0 == 3642) {
                var7 = intStack[--Class49.anInt442] == 1;
                Class44.socialSystem.ignoreListContext.setComparator(new Class211(var7));
                return 1;
            }
            if (var0 == 3643) {
                Class44.socialSystem.ignoreListContext.sort();
                return 1;
            }
            if (var0 == 3644) {
                if (Varps.clanSystem != null) {
                    Varps.clanSystem.unsetComparator();
                }

                return 1;
            }
            if (var0 == 3645) {
                var7 = intStack[--Class49.anInt442] == 1;
                if (Varps.clanSystem != null) {
                    Varps.clanSystem.setComparator(new Class223(var7));
                }

                return 1;
            }
            if (var0 == 3646) {
                var7 = intStack[--Class49.anInt442] == 1;
                if (Varps.clanSystem != null) {
                    Varps.clanSystem.setComparator(new Class211(var7));
                }

                return 1;
            }
            if (var0 == 3647) {
                var7 = intStack[--Class49.anInt442] == 1;
                if (Varps.clanSystem != null) {
                    Varps.clanSystem.setComparator(new AssociateComparatorByWorld(var7));
                }

                return 1;
            }
            if (var0 == 3648) {
                var7 = intStack[--Class49.anInt442] == 1;
                if (Varps.clanSystem != null) {
                    Varps.clanSystem.setComparator(new Class114(var7));
                }

                return 1;
            }
            if (var0 == 3649) {
                var7 = intStack[--Class49.anInt442] == 1;
                if (Varps.clanSystem != null) {
                    Varps.clanSystem.setComparator(new AssociateComparator_Sub5(var7));
                }

                return 1;
            }
            if (var0 == 3650) {
                var7 = intStack[--Class49.anInt442] == 1;
                if (Varps.clanSystem != null) {
                    Varps.clanSystem.setComparator(new AssociateComparatorByName(var7));
                }

                return 1;
            }
            if (var0 == 3651) {
                var7 = intStack[--Class49.anInt442] == 1;
                if (Varps.clanSystem != null) {
                    Varps.clanSystem.setComparator(new AssociateComparator_Sub2(var7));
                }

                return 1;
            }
            if (var0 == 3652) {
                var7 = intStack[--Class49.anInt442] == 1;
                if (Varps.clanSystem != null) {
                    Varps.clanSystem.setComparator(new AssociateComparatorByMyWorld(var7));
                }

                return 1;
            }
            if (var0 == 3653) {
                var7 = intStack[--Class49.anInt442] == 1;
                if (Varps.clanSystem != null) {
                    Varps.clanSystem.setComparator(new AssociateComparatorByWorldAndName(var7));
                }

                return 1;
            }
            if (var0 == 3654) {
                var7 = intStack[--Class49.anInt442] == 1;
                if (Varps.clanSystem != null) {
                    Varps.clanSystem.setComparator(new AssociateComparator_Sub4(var7));
                }

                return 1;
            }
            if (var0 == 3655) {
                if (Varps.clanSystem != null) {
                    Varps.clanSystem.sort();
                }

                return 1;
            }
            if (var0 == 3656) {
                var7 = intStack[--Class49.anInt442] == 1;
                Class44.socialSystem.friendListContext.setComparator(new AssociateComparatorByRank(var7));
                return 1;
            }
            if (var0 == 3657) {
                var7 = intStack[--Class49.anInt442] == 1;
                if (Varps.clanSystem != null) {
                    Varps.clanSystem.setComparator(new AssociateComparatorByRank(var7));
                }

                return 1;
            }
            return 2;
        }
        var3 = intStack[--Class49.anInt442];
        if (Varps.clanSystem != null && var3 < Varps.clanSystem.getCount() && ((ClanMember) Varps.clanSystem.getChatter(var3)).method706()) {
            intStack[++Class49.anInt442 - 1] = 1;
        } else {
            intStack[++Class49.anInt442 - 1] = 0;
        }

        return 1;
    }

    static void process(ScriptEvent event, int size) {
        Object[] var2 = event.args;
        RuneScript var4;
        int var5;
        if (Statics24.method966(event.anInt367)) {
            DoublyLinkedNode_Sub11.aClass25_1443 = (Class25) var2[0];
            DoublyLinkedNode_Sub15 var3 = Class98.method545(DoublyLinkedNode_Sub11.aClass25_1443.anInt306);
            var4 = Class20.method151(event.anInt367, var3.anInt574, var3.anInt1473);
        } else {
            var5 = (Integer) var2[0];
            var4 = LoginPacketMeta.method1499(var5);
        }

        if (var4 != null) {
            Class49.anInt442 = 0;
            Class49.anInt441 = 0;
            var5 = -1;
            int[] var6 = var4.anIntArray1574;
            int[] var7 = var4.anIntArray749;
            byte var8 = -1;
            Class49.anInt436 = 0;
            Class49.aBoolean439 = false;

            try {
                int var11;
                try {
                    Class49.anIntArray447 = new int[var4.anInt574];
                    int var9 = 0;
                    Class108.aStringArray794 = new String[var4.anInt112];
                    int var10 = 0;

                    int var12;
                    String var13;
                    for (var11 = 1; var11 < var2.length; ++var11) {
                        if (var2[var11] instanceof Integer) {
                            var12 = (Integer) var2[var11];
                            if (var12 == -2147483647) {
                                var12 = event.mouseX;
                            }

                            if (var12 == -2147483646) {
                                var12 = event.mouseY;
                            }

                            if (var12 == -2147483645) {
                                var12 = event.source != null ? event.source.uid : -1;
                            }

                            if (var12 == -2147483644) {
                                var12 = event.actionIndex;
                            }

                            if (var12 == -2147483643) {
                                var12 = event.source != null ? event.source.componentIndex : -1;
                            }

                            if (var12 == -2147483642) {
                                var12 = event.target != null ? event.target.uid : -1;
                            }

                            if (var12 == -2147483641) {
                                var12 = event.target != null ? event.target.componentIndex : -1;
                            }

                            if (var12 == -2147483640) {
                                var12 = event.anInt372;
                            }

                            if (var12 == -2147483639) {
                                var12 = event.anInt379;
                            }

                            Class49.anIntArray447[var9++] = var12;
                        } else if (var2[var11] instanceof String) {
                            var13 = (String) var2[var11];
                            if (var13.equals("event_opbase")) {
                                var13 = event.opbase;
                            }

                            Class108.aStringArray794[var10++] = var13;
                        }
                    }

                    var11 = 0;
                    Class49.anInt440 = event.anInt368;

                    while (true) {
                        ++var11;
                        if (var11 > size) {
                            throw new RuntimeException();
                        }

                        ++var5;
                        int var29 = var6[var5];
                        int var19;
                        if (var29 >= 100) {
                            boolean var34 = var4.anIntArray749[var5] == 1;

                            var19 = process(var29, var34);
                            switch (var19) {
                                case 0:
                                    return;
                                case 1:
                                default:
                                    break;
                                case 2:
                                    throw new IllegalStateException();
                            }
                        } else if (var29 == 0) {
                            intStack[++Class49.anInt442 - 1] = var7[var5];
                        } else if (var29 == 1) {
                            var12 = var7[var5];
                            intStack[++Class49.anInt442 - 1] = Varps.values[var12];
                        } else if (var29 == 2) {
                            var12 = var7[var5];
                            Varps.values[var12] = intStack[--Class49.anInt442];
                            OldConnection.method712(var12);
                        } else if (var29 == 3) {
                            stringStack[++Class49.anInt441 - 1] = var4.aStringArray1645[var5];
                        } else if (var29 == 6) {
                            var5 += var7[var5];
                        } else if (var29 == 7) {
                            Class49.anInt442 -= 2;
                            if (intStack[Class49.anInt442] != intStack[Class49.anInt442 + 1]) {
                                var5 += var7[var5];
                            }
                        } else if (var29 == 8) {
                            Class49.anInt442 -= 2;
                            if (intStack[Class49.anInt442] == intStack[Class49.anInt442 + 1]) {
                                var5 += var7[var5];
                            }
                        } else if (var29 == 9) {
                            Class49.anInt442 -= 2;
                            if (intStack[Class49.anInt442] < intStack[Class49.anInt442 + 1]) {
                                var5 += var7[var5];
                            }
                        } else if (var29 == 10) {
                            Class49.anInt442 -= 2;
                            if (intStack[Class49.anInt442] > intStack[Class49.anInt442 + 1]) {
                                var5 += var7[var5];
                            }
                        } else if (var29 == 21) {
                            if (Class49.anInt436 == 0) {
                                return;
                            }

                            Class48 var33 = Class49.aClass48Array435[--Class49.anInt436];
                            var4 = var33.aRuneScript433;
                            var6 = var4.anIntArray1574;
                            var7 = var4.anIntArray749;
                            var5 = var33.anInt434;
                            Class49.anIntArray447 = var33.anIntArray432;
                            Class108.aStringArray794 = var33.aStringArray431;
                        } else if (var29 == 25) {
                            var12 = var7[var5];
                            intStack[++Class49.anInt442 - 1] = Class37.getVarpbit(var12);
                        } else if (var29 == 27) {
                            var12 = var7[var5];
                            DoublyLinkedNode_Sub15.method1084(var12, intStack[--Class49.anInt442]);
                        } else if (var29 == 31) {
                            Class49.anInt442 -= 2;
                            if (intStack[Class49.anInt442] <= intStack[Class49.anInt442 + 1]) {
                                var5 += var7[var5];
                            }
                        } else if (var29 == 32) {
                            Class49.anInt442 -= 2;
                            if (intStack[Class49.anInt442] >= intStack[Class49.anInt442 + 1]) {
                                var5 += var7[var5];
                            }
                        } else if (var29 == 33) {
                            intStack[++Class49.anInt442 - 1] = Class49.anIntArray447[var7[var5]];
                        } else if (var29 == 34) {
                            Class49.anIntArray447[var7[var5]] = intStack[--Class49.anInt442];
                        } else if (var29 == 35) {
                            stringStack[++Class49.anInt441 - 1] = Class108.aStringArray794[var7[var5]];
                        } else if (var29 == 36) {
                            Class108.aStringArray794[var7[var5]] = stringStack[--Class49.anInt441];
                        } else if (var29 == 37) {
                            var12 = var7[var5];
                            Class49.anInt441 -= var12;
                            String var31 = DoublyLinkedNode_Sub14.method1009(stringStack, Class49.anInt441, var12);
                            stringStack[++Class49.anInt441 - 1] = var31;
                        } else if (var29 == 38) {
                            --Class49.anInt442;
                        } else if (var29 == 39) {
                            --Class49.anInt441;
                        } else {
                            int var17;
                            if (var29 != 40) {
                                if (var29 == 42) {
                                    intStack[++Class49.anInt442 - 1] = Class147.aClass79_1161.method428(var7[var5]);
                                } else if (var29 == 43) {
                                    Class147.aClass79_1161.method435(var7[var5], intStack[--Class49.anInt442]);
                                } else if (var29 == 44) {
                                    var12 = var7[var5] >> 16;
                                    var19 = var7[var5] & 65535;
                                    int var20 = intStack[--Class49.anInt442];
                                    if (var20 < 0 || var20 > 5000) {
                                        throw new RuntimeException();
                                    }

                                    Class49.anIntArray445[var12] = var20;
                                    byte var21 = -1;
                                    if (var19 == 105) {
                                        var21 = 0;
                                    }

                                    for (var17 = 0; var17 < var20; ++var17) {
                                        Class49.anIntArrayArray443[var12][var17] = var21;
                                    }
                                } else if (var29 == 45) {
                                    var12 = var7[var5];
                                    var19 = intStack[--Class49.anInt442];
                                    if (var19 < 0 || var19 >= Class49.anIntArray445[var12]) {
                                        throw new RuntimeException();
                                    }

                                    intStack[++Class49.anInt442 - 1] = Class49.anIntArrayArray443[var12][var19];
                                } else if (var29 == 46) {
                                    var12 = var7[var5];
                                    Class49.anInt442 -= 2;
                                    var19 = intStack[Class49.anInt442];
                                    if (var19 < 0 || var19 >= Class49.anIntArray445[var12]) {
                                        throw new RuntimeException();
                                    }

                                    Class49.anIntArrayArray443[var12][var19] = intStack[Class49.anInt442 + 1];
                                } else if (var29 == 47) {
                                    var13 = Class147.aClass79_1161.method429(var7[var5]);
                                    if (var13 == null) {
                                        var13 = "null";
                                    }

                                    stringStack[++Class49.anInt441 - 1] = var13;
                                } else if (var29 == 48) {
                                    Class147.aClass79_1161.method431(var7[var5], stringStack[--Class49.anInt441]);
                                } else if (var29 == 49) {
                                    var13 = Class147.aClass79_1161.method432(var7[var5]);
                                    stringStack[++Class49.anInt441 - 1] = var13;
                                } else if (var29 == 50) {
                                    Class147.aClass79_1161.method433(var7[var5], stringStack[--Class49.anInt441]);
                                } else {
                                    if (var29 != 60) {
                                        throw new IllegalStateException();
                                    }

                                    IterableNodeTable var32 = var4.aIterableNodeTableArray1646[var7[var5]];
                                    IntegerNode var30 = (IntegerNode) var32.lookup((long) intStack[--Class49.anInt442]);
                                    if (var30 != null) {
                                        var5 += var30.value;
                                    }
                                }
                            } else {
                                var12 = var7[var5];
                                RuneScript var14 = LoginPacketMeta.method1499(var12);
                                int[] var15 = new int[var14.anInt574];
                                String[] var16 = new String[var14.anInt112];

                                for (var17 = 0; var17 < var14.anInt375; ++var17) {
                                    var15[var17] = intStack[var17 + (Class49.anInt442 - var14.anInt375)];
                                }

                                for (var17 = 0; var17 < var14.anInt372; ++var17) {
                                    var16[var17] = stringStack[var17 + (Class49.anInt441 - var14.anInt372)];
                                }

                                Class49.anInt442 -= var14.anInt375;
                                Class49.anInt441 -= var14.anInt372;
                                Class48 var18 = new Class48();
                                var18.aRuneScript433 = var4;
                                var18.anInt434 = var5;
                                var18.anIntArray432 = Class49.anIntArray447;
                                var18.aStringArray431 = Class108.aStringArray794;
                                Class49.aClass48Array435[++Class49.anInt436 - 1] = var18;
                                var4 = var14;
                                var6 = var14.anIntArray1574;
                                var7 = var14.anIntArray749;
                                var5 = -1;
                                Class49.anIntArray447 = var15;
                                Class108.aStringArray794 = var16;
                            }
                        }
                    }
                } catch (Exception var27) {
                    StringBuilder var23 = new StringBuilder(30);
                    var23.append(var4.key).append(" ");

                    for (var11 = Class49.anInt436 - 1; var11 >= 0; --var11) {
                        var23.append(Class49.aClass48Array435[var11].aRuneScript433.key).append(" ");
                    }

                    var23.append(var8);
                    Class8.method65(var23.toString(), var27);
                }
            } finally {
                if (Class49.aBoolean439) {
                    Class49.aBoolean449 = true;
                    InterfaceComponent.closeInterface();
                    Class49.aBoolean449 = false;
                    Class49.aBoolean439 = false;
                }

            }
        }
    }

    static int method384(int var0, boolean var2) {
        int var3;
        int var4;
        if (var0 == 100) {
            Class49.anInt442 -= 3;
            var3 = intStack[Class49.anInt442];
            var4 = intStack[Class49.anInt442 + 1];
            int var5 = intStack[Class49.anInt442 + 2];
            if (var4 == 0) {
                throw new RuntimeException();
            }
            InterfaceComponent var8 = InterfaceComponent.lookup(var3);
            if (var8.components == null) {
                var8.components = new InterfaceComponent[var5 + 1];
            }

            if (var8.components.length <= var5) {
                InterfaceComponent[] var9 = new InterfaceComponent[var5 + 1];

                if (var8.components.length >= 0)
                    System.arraycopy(var8.components, 0, var9, 0, var8.components.length);

                var8.components = var9;
            }

            if (var5 > 0 && var8.components[var5 - 1] == null) {
                throw new RuntimeException("" + (var5 - 1));
            }
            InterfaceComponent var12 = new InterfaceComponent();
            var12.type = var4;
            var12.parentUid = var12.uid = var8.uid;
            var12.componentIndex = var5;
            var12.aBoolean562 = true;
            var8.components[var5] = var12;
            if (var2) {
                Class74.anInterfaceComponent585 = var12;
            } else {
                DoublyLinkedNode_Sub21.anInterfaceComponent1518 = var12;
            }

            Enum_Sub2.repaintComponent(var8);
            return 1;
        }
        InterfaceComponent var6;
        if (var0 == 101) {
            var6 = var2 ? Class74.anInterfaceComponent585 : DoublyLinkedNode_Sub21.anInterfaceComponent1518;
            InterfaceComponent var7 = InterfaceComponent.lookup(var6.uid);
            var7.components[var6.componentIndex] = null;
            Enum_Sub2.repaintComponent(var7);
            return 1;
        }
        if (var0 == 102) {
            var6 = InterfaceComponent.lookup(intStack[--Class49.anInt442]);
            var6.components = null;
            Enum_Sub2.repaintComponent(var6);
            return 1;
        }
        if (var0 != 200) {
            if (var0 == 201) {
                var6 = InterfaceComponent.lookup(intStack[--Class49.anInt442]);
                if (var6 != null) {
                    intStack[++Class49.anInt442 - 1] = 1;
                    if (var2) {
                        Class74.anInterfaceComponent585 = var6;
                    } else {
                        DoublyLinkedNode_Sub21.anInterfaceComponent1518 = var6;
                    }
                } else {
                    intStack[++Class49.anInt442 - 1] = 0;
                }

                return 1;
            }
            return 2;
        }
        Class49.anInt442 -= 2;
        var3 = intStack[Class49.anInt442];
        var4 = intStack[Class49.anInt442 + 1];
        InterfaceComponent var11 = InterfaceComponent.lookup(var3, var4);
        if (var11 != null && var4 != -1) {
            intStack[++Class49.anInt442 - 1] = 1;
            if (var2) {
                Class74.anInterfaceComponent585 = var11;
            } else {
                DoublyLinkedNode_Sub21.anInterfaceComponent1518 = var11;
            }
        } else {
            intStack[++Class49.anInt442 - 1] = 0;
        }

        return 1;
    }

    static int method889(int var0) {
        if (var0 == 6500) {
            intStack[++Class49.anInt442 - 1] = AsyncConnection.loadWorlds() ? 1 : 0;
            return 1;
        }
        World var3;
        if (var0 == 6501) {
            var3 = Statics3.method652();
            if (var3 != null) {
                intStack[++Class49.anInt442 - 1] = var3.anInt1875;
                intStack[++Class49.anInt442 - 1] = var3.mask;
                stringStack[++Class49.anInt441 - 1] = var3.activity;
                intStack[++Class49.anInt442 - 1] = var3.location;
                intStack[++Class49.anInt442 - 1] = var3.population;
                stringStack[++Class49.anInt441 - 1] = var3.domain;
            } else {
                intStack[++Class49.anInt442 - 1] = -1;
                intStack[++Class49.anInt442 - 1] = 0;
                stringStack[++Class49.anInt441 - 1] = "";
                intStack[++Class49.anInt442 - 1] = 0;
                intStack[++Class49.anInt442 - 1] = 0;
                stringStack[++Class49.anInt441 - 1] = "";
            }

            return 1;
        }
        if (var0 == 6502) {
            var3 = Class152.method866();
            if (var3 != null) {
                intStack[++Class49.anInt442 - 1] = var3.anInt1875;
                intStack[++Class49.anInt442 - 1] = var3.mask;
                stringStack[++Class49.anInt441 - 1] = var3.activity;
                intStack[++Class49.anInt442 - 1] = var3.location;
                intStack[++Class49.anInt442 - 1] = var3.population;
                stringStack[++Class49.anInt441 - 1] = var3.domain;
            } else {
                intStack[++Class49.anInt442 - 1] = -1;
                intStack[++Class49.anInt442 - 1] = 0;
                stringStack[++Class49.anInt441 - 1] = "";
                intStack[++Class49.anInt442 - 1] = 0;
                intStack[++Class49.anInt442 - 1] = 0;
                stringStack[++Class49.anInt441 - 1] = "";
            }

            return 1;
        }
        int var4;
        World var5;
        int var6;
        if (var0 == 6506) {
            var4 = intStack[--Class49.anInt442];
            var5 = null;

            for (var6 = 0; var6 < World.anInt1871; ++var6) {
                if (var4 == World.worlds[var6].anInt1875) {
                    var5 = World.worlds[var6];
                    break;
                }
            }

            if (var5 != null) {
                intStack[++Class49.anInt442 - 1] = var5.anInt1875;
                intStack[++Class49.anInt442 - 1] = var5.mask;
                stringStack[++Class49.anInt441 - 1] = var5.activity;
                intStack[++Class49.anInt442 - 1] = var5.location;
                intStack[++Class49.anInt442 - 1] = var5.population;
                stringStack[++Class49.anInt441 - 1] = var5.domain;
            } else {
                intStack[++Class49.anInt442 - 1] = -1;
                intStack[++Class49.anInt442 - 1] = 0;
                stringStack[++Class49.anInt441 - 1] = "";
                intStack[++Class49.anInt442 - 1] = 0;
                intStack[++Class49.anInt442 - 1] = 0;
                stringStack[++Class49.anInt441 - 1] = "";
            }

            return 1;
        }
        if (var0 == 6507) {
            Class49.anInt442 -= 4;
            var4 = intStack[Class49.anInt442];
            boolean var10 = intStack[Class49.anInt442 + 1] == 1;
            var6 = intStack[Class49.anInt442 + 2];
            boolean var8 = intStack[Class49.anInt442 + 3] == 1;
            Class30.method220(var4, var10, var6, var8);
            return 1;
        }
        if (var0 != 6511) {
            if (var0 == 6512) {
                client.aBoolean1042 = intStack[--Class49.anInt442] == 1;
                return 1;
            }
            int var7;
            DefinitionProperty var9;
            if (var0 == 6513) {
                Class49.anInt442 -= 2;
                var4 = intStack[Class49.anInt442];
                var7 = intStack[Class49.anInt442 + 1];
                var9 = BoundaryDecor.getDefinitionProperty(var7);
                if (var9.method258()) {
                    stringStack[++Class49.anInt441 - 1] = OutgoingPacket.getNpcDefinition(var4).method504(var7, var9.defaultString);
                } else {
                    intStack[++Class49.anInt442 - 1] = OutgoingPacket.getNpcDefinition(var4).method511(var7, var9.defaultInteger);
                }

                return 1;
            }
            if (var0 == 6514) {
                Class49.anInt442 -= 2;
                var4 = intStack[Class49.anInt442];
                var7 = intStack[Class49.anInt442 + 1];
                var9 = BoundaryDecor.getDefinitionProperty(var7);
                if (var9.method258()) {
                    stringStack[++Class49.anInt441 - 1] = Class38.getObjectDefinition(var4).method1104(var7, var9.defaultString);
                } else {
                    intStack[++Class49.anInt442 - 1] = Class38.getObjectDefinition(var4).method1100(var7, var9.defaultInteger);
                }

                return 1;
            }
            if (var0 == 6515) {
                Class49.anInt442 -= 2;
                var4 = intStack[Class49.anInt442];
                var7 = intStack[Class49.anInt442 + 1];
                var9 = BoundaryDecor.getDefinitionProperty(var7);
                if (var9.method258()) {
                    stringStack[++Class49.anInt441 - 1] = CameraCapture.getItemDefinition(var4).method520(var7, var9.defaultString);
                } else {
                    intStack[++Class49.anInt442 - 1] = CameraCapture.getItemDefinition(var4).method527(var7, var9.defaultInteger);
                }

                return 1;
            }
            if (var0 == 6516) {
                Class49.anInt442 -= 2;
                var4 = intStack[Class49.anInt442];
                var7 = intStack[Class49.anInt442 + 1];
                var9 = BoundaryDecor.getDefinitionProperty(var7);
                if (var9.method258()) {
                    stringStack[++Class49.anInt441 - 1] = Statics5.method689(var4).method1096(var7, var9.defaultString);
                } else {
                    intStack[++Class49.anInt442 - 1] = Statics5.method689(var4).method1097(var7, var9.defaultInteger);
                }

                return 1;
            }
            if (var0 == 6518) {
                intStack[++Class49.anInt442 - 1] = client.aBoolean927 ? 1 : 0;
                return 1;
            }
            if (var0 == 6519) {
                intStack[++Class49.anInt442 - 1] = client.anInt923 & 3;
                return 1;
            }
            if (var0 == 6520) {
                return 1;
            }
            if (var0 == 6521) {
                return 1;
            }
            if (var0 == 6522) {
                --Class49.anInt441;
                --Class49.anInt442;
                return 1;
            }
            if (var0 == 6523) {
                --Class49.anInt441;
                --Class49.anInt442;
                return 1;
            }
            if (var0 == 6524) {
                intStack[++Class49.anInt442 - 1] = -1;
                return 1;
            }
            if (var0 == 6525) {
                intStack[++Class49.anInt442 - 1] = 1;
                return 1;
            }
            if (var0 == 6526) {
                intStack[++Class49.anInt442 - 1] = 1;
                return 1;
            }
            return 2;
        }
        var4 = intStack[--Class49.anInt442];
        if (var4 >= 0 && var4 < World.anInt1871) {
            var5 = World.worlds[var4];
            intStack[++Class49.anInt442 - 1] = var5.anInt1875;
            intStack[++Class49.anInt442 - 1] = var5.mask;
            stringStack[++Class49.anInt441 - 1] = var5.activity;
            intStack[++Class49.anInt442 - 1] = var5.location;
            intStack[++Class49.anInt442 - 1] = var5.population;
            stringStack[++Class49.anInt441 - 1] = var5.domain;
        } else {
            intStack[++Class49.anInt442 - 1] = -1;
            intStack[++Class49.anInt442 - 1] = 0;
            stringStack[++Class49.anInt441 - 1] = "";
            intStack[++Class49.anInt442 - 1] = 0;
            intStack[++Class49.anInt442 - 1] = 0;
            stringStack[++Class49.anInt441 - 1] = "";
        }

        return 1;
    }

    static int method7(int var0) {
        if (var0 == 6200) {
            Class49.anInt442 -= 2;
            client.aShort922 = (short) PlayerAppearance.method1426(intStack[Class49.anInt442]);
            if (client.aShort922 <= 0) {
                client.aShort922 = 256;
            }

            client.aShort912 = (short) PlayerAppearance.method1426(intStack[Class49.anInt442 + 1]);
            if (client.aShort912 <= 0) {
                client.aShort912 = 256;
            }

            return 1;
        }
        if (var0 == 6201) {
            Class49.anInt442 -= 2;
            client.aShort913 = (short) intStack[Class49.anInt442];
            if (client.aShort913 <= 0) {
                client.aShort913 = 256;
            }

            client.aShort920 = (short) intStack[Class49.anInt442 + 1];
            if (client.aShort920 <= 0) {
                client.aShort920 = 320;
            }

            return 1;
        }
        if (var0 == 6202) {
            Class49.anInt442 -= 4;
            client.aShort915 = (short) intStack[Class49.anInt442];
            if (client.aShort915 <= 0) {
                client.aShort915 = 1;
            }

            client.aShort907 = (short) intStack[Class49.anInt442 + 1];
            if (client.aShort907 <= 0) {
                client.aShort907 = 32767;
            } else if (client.aShort907 < client.aShort915) {
                client.aShort907 = client.aShort915;
            }

            client.aShort910 = (short) intStack[Class49.anInt442 + 2];
            if (client.aShort910 <= 0) {
                client.aShort910 = 1;
            }

            client.aShort921 = (short) intStack[Class49.anInt442 + 3];
            if (client.aShort921 <= 0) {
                client.aShort921 = 32767;
            } else if (client.aShort921 < client.aShort910) {
                client.aShort921 = client.aShort910;
            }

            return 1;
        }
        if (var0 == 6203) {
            if (client.anInterfaceComponent1055 != null) {
                Class152.method867(0, 0, client.anInterfaceComponent1055.width, client.anInterfaceComponent1055.height, false);
                intStack[++Class49.anInt442 - 1] = client.viewportWidth;
                intStack[++Class49.anInt442 - 1] = client.viewportHeight;
            } else {
                intStack[++Class49.anInt442 - 1] = -1;
                intStack[++Class49.anInt442 - 1] = -1;
            }

            return 1;
        }
        if (var0 == 6204) {
            intStack[++Class49.anInt442 - 1] = client.aShort913;
            intStack[++Class49.anInt442 - 1] = client.aShort920;
            return 1;
        }
        if (var0 == 6205) {
            intStack[++Class49.anInt442 - 1] = Statics16.method888(client.aShort922);
            intStack[++Class49.anInt442 - 1] = Statics16.method888(client.aShort912);
            return 1;
        }
        if (var0 == 6220) {
            intStack[++Class49.anInt442 - 1] = 0;
            return 1;
        }
        if (var0 == 6221) {
            intStack[++Class49.anInt442 - 1] = 0;
            return 1;
        }
        if (var0 == 6222) {
            intStack[++Class49.anInt442 - 1] = client.canvasWidth;
            return 1;
        }
        if (var0 == 6223) {
            intStack[++Class49.anInt442 - 1] = client.canvasHeight;
            return 1;
        }
        return 2;
    }

    static int method954(int var0) {
        if (var0 == 5630) {
            client.logoutTimer = 250;
            return 1;
        }
        return 2;
    }

    static int method105(int var0) {
        int var3;
        if (var0 == 5504) {
            Class49.anInt442 -= 2;
            var3 = intStack[Class49.anInt442];
            int var4 = intStack[Class49.anInt442 + 1];
            if (!client.cameraLocked) {
                client.anInt985 = var3;
                client.mapRotation = var4;
            }

            return 1;
        }
        if (var0 == 5505) {
            intStack[++Class49.anInt442 - 1] = client.anInt985;
            return 1;
        }
        if (var0 == 5506) {
            intStack[++Class49.anInt442 - 1] = client.mapRotation;
            return 1;
        }
        if (var0 == 5530) {
            var3 = intStack[--Class49.anInt442];
            if (var3 < 0) {
                var3 = 0;
            }

            client.anInt982 = var3;
            return 1;
        }
        if (var0 == 5531) {
            intStack[++Class49.anInt442 - 1] = client.anInt982;
            return 1;
        }
        return 2;
    }

    static int method641(int var0) {
        if (var0 == 5306) {
            intStack[++Class49.anInt442 - 1] = client.isResizable();
            return 1;
        }
        int var3;
        if (var0 == 5307) {
            var3 = intStack[--Class49.anInt442];
            if (var3 == 1 || var3 == 2) {
                AssociateComparatorByMyWorld.method603(var3);
            }

            return 1;
        }
        if (var0 == 5308) {
            intStack[++Class49.anInt442 - 1] = client.preferences.resizable;
            return 1;
        }
        if (var0 != 5309) {
            if (var0 == 5310) {
                --Class49.anInt442;
                return 1;
            }
            return 2;
        }
        var3 = intStack[--Class49.anInt442];
        if (var3 == 1 || var3 == 2) {
            client.preferences.resizable = var3;
            Class149.method854();
        }

        return 1;
    }

    static int method268(int var0) {
        if (var0 == 5000) {
            intStack[++Class49.anInt442 - 1] = client.publicChatMode;
            return 1;
        }
        if (var0 == 5001) {
            Class49.anInt442 -= 3;
            client.publicChatMode = intStack[Class49.anInt442];
            Statics16.aClass193_1237 = Class202.method1186(intStack[Class49.anInt442 + 1]);
            if (Statics16.aClass193_1237 == null) {
                Statics16.aClass193_1237 = Class193.aClass193_1569;
            }

            client.tradeChatMode = intStack[Class49.anInt442 + 2];
            OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.PROCESS_CHAT_MODE, client.connectionContext.encryptor);
            packet.buffer.writeByte(client.publicChatMode);
            packet.buffer.writeByte(Statics16.aClass193_1237.anInt1566);
            packet.buffer.writeByte(client.tradeChatMode);
            client.connectionContext.writeLater(packet);
            return 1;
        }
        String var3;
        int var4;
        if (var0 == 5002) {
            var3 = stringStack[--Class49.anInt441];
            Class49.anInt442 -= 2;
            var4 = intStack[Class49.anInt442];
            int var5 = intStack[Class49.anInt442 + 1];
            OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta88, client.connectionContext.encryptor);
            packet.buffer.writeByte(Statics30.stringLengthPlusOne(var3) + 2);
            packet.buffer.writeCString(var3);
            packet.buffer.writeByte(var4 - 1);
            packet.buffer.writeByte(var5);
            client.connectionContext.writeLater(packet);
            return 1;
        }
        int var7;
        if (var0 == 5003) {
            Class49.anInt442 -= 2;
            var7 = intStack[Class49.anInt442];
            var4 = intStack[Class49.anInt442 + 1];
            Chatline var15 = HitUpdate.method270(var7, var4);
            if (var15 != null) {
                intStack[++Class49.anInt442 - 1] = var15.anInt380;
                intStack[++Class49.anInt442 - 1] = var15.anInt568;
                stringStack[++Class49.anInt441 - 1] = var15.aString1233 != null ? var15.aString1233 : "";
                stringStack[++Class49.anInt441 - 1] = var15.source != null ? var15.source : "";
                stringStack[++Class49.anInt441 - 1] = var15.message != null ? var15.message : "";
                intStack[++Class49.anInt442 - 1] = var15.method693() ? 1 : (var15.method882() ? 2 : 0);
            } else {
                intStack[++Class49.anInt442 - 1] = -1;
                intStack[++Class49.anInt442 - 1] = 0;
                stringStack[++Class49.anInt441 - 1] = "";
                stringStack[++Class49.anInt441 - 1] = "";
                stringStack[++Class49.anInt441 - 1] = "";
                intStack[++Class49.anInt442 - 1] = 0;
            }

            return 1;
        }
        if (var0 == 5004) {
            var7 = intStack[--Class49.anInt442];
            Chatline var16 = Class38.method246(var7);
            if (var16 != null) {
                intStack[++Class49.anInt442 - 1] = var16.type;
                intStack[++Class49.anInt442 - 1] = var16.anInt568;
                stringStack[++Class49.anInt441 - 1] = var16.aString1233 != null ? var16.aString1233 : "";
                stringStack[++Class49.anInt441 - 1] = var16.source != null ? var16.source : "";
                stringStack[++Class49.anInt441 - 1] = var16.message != null ? var16.message : "";
                intStack[++Class49.anInt442 - 1] = var16.method693() ? 1 : (var16.method882() ? 2 : 0);
            } else {
                intStack[++Class49.anInt442 - 1] = -1;
                intStack[++Class49.anInt442 - 1] = 0;
                stringStack[++Class49.anInt441 - 1] = "";
                stringStack[++Class49.anInt441 - 1] = "";
                stringStack[++Class49.anInt441 - 1] = "";
                intStack[++Class49.anInt442 - 1] = 0;
            }

            return 1;
        }
        if (var0 == 5005) {
            if (Statics16.aClass193_1237 == null) {
                intStack[++Class49.anInt442 - 1] = -1;
            } else {
                intStack[++Class49.anInt442 - 1] = Statics16.aClass193_1237.anInt1566;
            }

            return 1;
        }
        if (var0 == 5008) {
            var3 = stringStack[--Class49.anInt441];
            var4 = intStack[--Class49.anInt442];
            String var14 = var3.toLowerCase();
            byte var17 = 0;
            if (var14.startsWith("yellow:")) {
                var17 = 0;
                var3 = var3.substring("yellow:".length());
            } else if (var14.startsWith("red:")) {
                var17 = 1;
                var3 = var3.substring("red:".length());
            } else if (var14.startsWith("green:")) {
                var17 = 2;
                var3 = var3.substring("green:".length());
            } else if (var14.startsWith("cyan:")) {
                var17 = 3;
                var3 = var3.substring("cyan:".length());
            } else if (var14.startsWith("purple:")) {
                var17 = 4;
                var3 = var3.substring("purple:".length());
            } else if (var14.startsWith("white:")) {
                var17 = 5;
                var3 = var3.substring("white:".length());
            } else if (var14.startsWith("flash1:")) {
                var17 = 6;
                var3 = var3.substring("flash1:".length());
            } else if (var14.startsWith("flash2:")) {
                var17 = 7;
                var3 = var3.substring("flash2:".length());
            } else if (var14.startsWith("flash3:")) {
                var17 = 8;
                var3 = var3.substring("flash3:".length());
            } else if (var14.startsWith("glow1:")) {
                var17 = 9;
                var3 = var3.substring("glow1:".length());
            } else if (var14.startsWith("glow2:")) {
                var17 = 10;
                var3 = var3.substring("glow2:".length());
            } else if (var14.startsWith("glow3:")) {
                var17 = 11;
                var3 = var3.substring("glow3:".length());
            } else if (Class65.aClass149_525 != Class149.aClass149_1190) {
                if (var14.startsWith("yellow:")) {
                    var17 = 0;
                    var3 = var3.substring("yellow:".length());
                } else if (var14.startsWith("red:")) {
                    var17 = 1;
                    var3 = var3.substring("red:".length());
                } else if (var14.startsWith("green:")) {
                    var17 = 2;
                    var3 = var3.substring("green:".length());
                } else if (var14.startsWith("cyan:")) {
                    var17 = 3;
                    var3 = var3.substring("cyan:".length());
                } else if (var14.startsWith("purple:")) {
                    var17 = 4;
                    var3 = var3.substring("purple:".length());
                } else if (var14.startsWith("white:")) {
                    var17 = 5;
                    var3 = var3.substring("white:".length());
                } else if (var14.startsWith("flash1:")) {
                    var17 = 6;
                    var3 = var3.substring("flash1:".length());
                } else if (var14.startsWith("flash2:")) {
                    var17 = 7;
                    var3 = var3.substring("flash2:".length());
                } else if (var14.startsWith("flash3:")) {
                    var17 = 8;
                    var3 = var3.substring("flash3:".length());
                } else if (var14.startsWith("glow1:")) {
                    var17 = 9;
                    var3 = var3.substring("glow1:".length());
                } else if (var14.startsWith("glow2:")) {
                    var17 = 10;
                    var3 = var3.substring("glow2:".length());
                } else if (var14.startsWith("glow3:")) {
                    var17 = 11;
                    var3 = var3.substring("glow3:".length());
                }
            }

            var14 = var3.toLowerCase();
            byte var11 = 0;
            if (var14.startsWith("wave:")) {
                var11 = 1;
                var3 = var3.substring("wave:".length());
            } else if (var14.startsWith("wave2:")) {
                var11 = 2;
                var3 = var3.substring("wave2:".length());
            } else if (var14.startsWith("shake:")) {
                var11 = 3;
                var3 = var3.substring("shake:".length());
            } else if (var14.startsWith("scroll:")) {
                var11 = 4;
                var3 = var3.substring("scroll:".length());
            } else if (var14.startsWith("slide:")) {
                var11 = 5;
                var3 = var3.substring("slide:".length());
            } else if (Class149.aClass149_1190 != Class65.aClass149_525) {
                if (var14.startsWith("wave:")) {
                    var11 = 1;
                    var3 = var3.substring("wave:".length());
                } else if (var14.startsWith("wave2:")) {
                    var11 = 2;
                    var3 = var3.substring("wave2:".length());
                } else if (var14.startsWith("shake:")) {
                    var11 = 3;
                    var3 = var3.substring("shake:".length());
                } else if (var14.startsWith("scroll:")) {
                    var11 = 4;
                    var3 = var3.substring("scroll:".length());
                } else if (var14.startsWith("slide:")) {
                    var11 = 5;
                    var3 = var3.substring("slide:".length());
                }
            }

            OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta2, client.connectionContext.encryptor);
            packet.buffer.writeByte(0);
            int var13 = packet.buffer.caret;
            packet.buffer.writeByte(var4);
            packet.buffer.writeByte(var17);
            packet.buffer.writeByte(var11);
            CacheIndex.method1491(packet.buffer, var3);
            packet.buffer.method1050(packet.buffer.caret - var13);
            client.connectionContext.writeLater(packet);
            return 1;
        }
        if (var0 == 5009) {
            Class49.anInt441 -= 2;
            var3 = stringStack[Class49.anInt441];
            String var9 = stringStack[Class49.anInt441 + 1];
            OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta59, client.connectionContext.encryptor);
            packet.buffer.writeShort(0);
            int var10 = packet.buffer.caret;
            packet.buffer.writeCString(var3);
            CacheIndex.method1491(packet.buffer, var9);
            packet.buffer.method1041(packet.buffer.caret - var10);
            client.connectionContext.writeLater(packet);
            return 1;
        }
        if (var0 != 5015) {
            if (var0 == 5016) {
                intStack[++Class49.anInt442 - 1] = client.tradeChatMode;
                return 1;
            }
            if (var0 == 5017) {
                var7 = intStack[--Class49.anInt442];
                intStack[++Class49.anInt442 - 1] = Projectile.method1191(var7);
                return 1;
            }
            if (var0 == 5018) {
                var7 = intStack[--Class49.anInt442];
                intStack[++Class49.anInt442 - 1] = Class54.method321(var7);
                return 1;
            }
            if (var0 == 5019) {
                var7 = intStack[--Class49.anInt442];
                intStack[++Class49.anInt442 - 1] = Class135.method723(var7);
                return 1;
            }
            if (var0 == 5020) {
                var3 = stringStack[--Class49.anInt441];
                Class66.method368(var3);
                return 1;
            }
            if (var0 == 5021) {
                client.aString1091 = stringStack[--Class49.anInt441].toLowerCase().trim();
                return 1;
            }
            if (var0 == 5022) {
                stringStack[++Class49.anInt441 - 1] = client.aString1091;
                return 1;
            }
            if (var0 == 5023) {
                var3 = stringStack[--Class49.anInt441];
                System.out.println(var3);
                return 1;
            }
            return 2;
        }
        if (PlayerEntity.local != null && PlayerEntity.local.namePair != null) {
            var3 = PlayerEntity.local.namePair.getRaw();
        } else {
            var3 = "";
        }

        stringStack[++Class49.anInt441 - 1] = var3;
        return 1;
    }

    static int method953(int var0) {
        int var3;
        if (var0 == 4200) {
            var3 = intStack[--Class49.anInt442];
            stringStack[++Class49.anInt441 - 1] = CameraCapture.getItemDefinition(var3).name;
            return 1;
        }
        int var4;
        ItemDefinition var5;
        if (var0 == 4201) {
            Class49.anInt442 -= 2;
            var3 = intStack[Class49.anInt442];
            var4 = intStack[Class49.anInt442 + 1];
            var5 = CameraCapture.getItemDefinition(var3);
            if (var4 >= 1 && var4 <= 5 && var5.groundActions[var4 - 1] != null) {
                stringStack[++Class49.anInt441 - 1] = var5.groundActions[var4 - 1];
            } else {
                stringStack[++Class49.anInt441 - 1] = "";
            }

            return 1;
        }
        if (var0 == 4202) {
            Class49.anInt442 -= 2;
            var3 = intStack[Class49.anInt442];
            var4 = intStack[Class49.anInt442 + 1];
            var5 = CameraCapture.getItemDefinition(var3);
            if (var4 >= 1 && var4 <= 5 && var5.actions[var4 - 1] != null) {
                stringStack[++Class49.anInt441 - 1] = var5.actions[var4 - 1];
            } else {
                stringStack[++Class49.anInt441 - 1] = "";
            }

            return 1;
        }
        if (var0 == 4203) {
            var3 = intStack[--Class49.anInt442];
            intStack[++Class49.anInt442 - 1] = CameraCapture.getItemDefinition(var3).value;
            return 1;
        }
        if (var0 == 4204) {
            var3 = intStack[--Class49.anInt442];
            intStack[++Class49.anInt442 - 1] = CameraCapture.getItemDefinition(var3).stackable == 1 ? 1 : 0;
            return 1;
        }
        ItemDefinition var6;
        if (var0 == 4205) {
            var3 = intStack[--Class49.anInt442];
            var6 = CameraCapture.getItemDefinition(var3);
            if (var6.noteTemplateId == -1 && var6.noteId >= 0) {
                intStack[++Class49.anInt442 - 1] = var6.noteId;
            } else {
                intStack[++Class49.anInt442 - 1] = var3;
            }

            return 1;
        }
        if (var0 == 4206) {
            var3 = intStack[--Class49.anInt442];
            var6 = CameraCapture.getItemDefinition(var3);
            if (var6.noteTemplateId >= 0 && var6.noteId >= 0) {
                intStack[++Class49.anInt442 - 1] = var6.noteId;
            } else {
                intStack[++Class49.anInt442 - 1] = var3;
            }

            return 1;
        }
        if (var0 == 4207) {
            var3 = intStack[--Class49.anInt442];
            intStack[++Class49.anInt442 - 1] = CameraCapture.getItemDefinition(var3).members ? 1 : 0;
            return 1;
        }
        if (var0 == 4208) {
            var3 = intStack[--Class49.anInt442];
            var6 = CameraCapture.getItemDefinition(var3);
            if (var6.anInt712 == -1 && var6.anInt715 >= 0) {
                intStack[++Class49.anInt442 - 1] = var6.anInt715;
            } else {
                intStack[++Class49.anInt442 - 1] = var3;
            }

            return 1;
        }
        if (var0 == 4209) {
            var3 = intStack[--Class49.anInt442];
            var6 = CameraCapture.getItemDefinition(var3);
            if (var6.anInt712 >= 0 && var6.anInt715 >= 0) {
                intStack[++Class49.anInt442 - 1] = var6.anInt715;
            } else {
                intStack[++Class49.anInt442 - 1] = var3;
            }

            return 1;
        }
        if (var0 == 4210) {
            String var7 = stringStack[--Class49.anInt441];
            var4 = intStack[--Class49.anInt442];
            Canvas.method640(var7, var4 == 1);
            intStack[++Class49.anInt442 - 1] = Class12.anInt142;
            return 1;
        }
        if (var0 != 4211) {
            if (var0 == 4212) {
                ClassStructure.anInt748 = 0;
                return 1;
            }
            return 2;
        }
        if (Class27_Sub2.grandExchangeSearchResults != null && ClassStructure.anInt748 < Class12.anInt142) {
            intStack[++Class49.anInt442 - 1] = Class27_Sub2.grandExchangeSearchResults[++ClassStructure.anInt748 - 1] & '\uffff';
        } else {
            intStack[++Class49.anInt442 - 1] = -1;
        }

        return 1;
    }

    static int method472(int var0) {
        String var3;
        int var4;
        if (var0 == 4100) {
            var3 = stringStack[--Class49.anInt441];
            var4 = intStack[--Class49.anInt442];
            stringStack[++Class49.anInt441 - 1] = var3 + var4;
            return 1;
        }
        String var5;
        if (var0 == 4101) {
            Class49.anInt441 -= 2;
            var3 = stringStack[Class49.anInt441];
            var5 = stringStack[Class49.anInt441 + 1];
            stringStack[++Class49.anInt441 - 1] = var3 + var5;
            return 1;
        }
        if (var0 == 4102) {
            var3 = stringStack[--Class49.anInt441];
            var4 = intStack[--Class49.anInt442];
            stringStack[++Class49.anInt441 - 1] = var3 + HealthBar.method692(var4, true);
            return 1;
        }
        if (var0 == 4103) {
            var3 = stringStack[--Class49.anInt441];
            stringStack[++Class49.anInt441 - 1] = var3.toLowerCase();
            return 1;
        }
        int var6;
        int var9;
        if (var0 == 4104) {
            var6 = intStack[--Class49.anInt442];
            long var7 = 86400000L * (11745L + (long) var6);
            Class49.aCalendar438.setTime(new Date(var7));
            var9 = Class49.aCalendar438.get(5);
            int var16 = Class49.aCalendar438.get(2);
            int var11 = Class49.aCalendar438.get(1);
            stringStack[++Class49.anInt441 - 1] = var9 + "-" + Class49.aStringArray448[var16] + "-" + var11;
            return 1;
        }
        if (var0 != 4105) {
            if (var0 == 4106) {
                var6 = intStack[--Class49.anInt442];
                stringStack[++Class49.anInt441 - 1] = Integer.toString(var6);
                return 1;
            }
            if (var0 == 4107) {
                Class49.anInt441 -= 2;
                intStack[++Class49.anInt442 - 1] = Statics10.method799(Class49.method298(stringStack[Class49.anInt441], stringStack[Class49.anInt441 + 1], Class65.aClass149_525));
                return 1;
            }
            int var12;
            byte[] var13;
            Font var14;
            if (var0 == 4108) {
                var3 = stringStack[--Class49.anInt441];
                Class49.anInt442 -= 2;
                var4 = intStack[Class49.anInt442];
                var12 = intStack[Class49.anInt442 + 1];
                var13 = Tile.aCacheReferenceTable1152.unpack(var12, 0);
                var14 = new Font(var13);
                intStack[++Class49.anInt442 - 1] = var14.method1150(var3, var4);
                return 1;
            }
            if (var0 == 4109) {
                var3 = stringStack[--Class49.anInt441];
                Class49.anInt442 -= 2;
                var4 = intStack[Class49.anInt442];
                var12 = intStack[Class49.anInt442 + 1];
                var13 = Tile.aCacheReferenceTable1152.unpack(var12, 0);
                var14 = new Font(var13);
                intStack[++Class49.anInt442 - 1] = var14.method1144(var3, var4);
                return 1;
            }
            if (var0 == 4110) {
                Class49.anInt441 -= 2;
                var3 = stringStack[Class49.anInt441];
                var5 = stringStack[Class49.anInt441 + 1];
                if (intStack[--Class49.anInt442] == 1) {
                    stringStack[++Class49.anInt441 - 1] = var3;
                } else {
                    stringStack[++Class49.anInt441 - 1] = var5;
                }

                return 1;
            }
            if (var0 == 4111) {
                var3 = stringStack[--Class49.anInt441];
                stringStack[++Class49.anInt441 - 1] = DoublyLinkedNode_Sub24_Sub3.method1166(var3);
                return 1;
            }
            if (var0 == 4112) {
                var3 = stringStack[--Class49.anInt441];
                var4 = intStack[--Class49.anInt442];
                stringStack[++Class49.anInt441 - 1] = var3 + (char) var4;
                return 1;
            }
            if (var0 == 4113) {
                var6 = intStack[--Class49.anInt442];
                intStack[++Class49.anInt442 - 1] = PickableNode.method725((char) var6) ? 1 : 0;
                return 1;
            }
            if (var0 == 4114) {
                var6 = intStack[--Class49.anInt442];
                intStack[++Class49.anInt442 - 1] = ReferenceTable.method898((char) var6) ? 1 : 0;
                return 1;
            }
            if (var0 == 4115) {
                var6 = intStack[--Class49.anInt442];
                intStack[++Class49.anInt442 - 1] = AssociateComparator_Sub2.method607((char) var6) ? 1 : 0;
                return 1;
            }
            if (var0 == 4116) {
                var6 = intStack[--Class49.anInt442];
                intStack[++Class49.anInt442 - 1] = Class27.method196((char) var6) ? 1 : 0;
                return 1;
            }
            if (var0 == 4117) {
                var3 = stringStack[--Class49.anInt441];
                if (var3 != null) {
                    intStack[++Class49.anInt442 - 1] = var3.length();
                } else {
                    intStack[++Class49.anInt442 - 1] = 0;
                }

                return 1;
            }
            if (var0 == 4118) {
                var3 = stringStack[--Class49.anInt441];
                Class49.anInt442 -= 2;
                var4 = intStack[Class49.anInt442];
                var12 = intStack[Class49.anInt442 + 1];
                stringStack[++Class49.anInt441 - 1] = var3.substring(var4, var12);
                return 1;
            }
            if (var0 == 4119) {
                var3 = stringStack[--Class49.anInt441];
                StringBuilder var15 = new StringBuilder(var3.length());
                boolean var17 = false;

                for (var9 = 0; var9 < var3.length(); ++var9) {
                    char var10 = var3.charAt(var9);
                    if (var10 == '<') {
                        var17 = true;
                    } else if (var10 == '>') {
                        var17 = false;
                    } else if (!var17) {
                        var15.append(var10);
                    }
                }

                stringStack[++Class49.anInt441 - 1] = var15.toString();
                return 1;
            }
            if (var0 == 4120) {
                var3 = stringStack[--Class49.anInt441];
                var4 = intStack[--Class49.anInt442];
                intStack[++Class49.anInt442 - 1] = var3.indexOf(var4);
                return 1;
            }
            if (var0 == 4121) {
                Class49.anInt441 -= 2;
                var3 = stringStack[Class49.anInt441];
                var5 = stringStack[Class49.anInt441 + 1];
                var12 = intStack[--Class49.anInt442];
                intStack[++Class49.anInt442 - 1] = var3.indexOf(var5, var12);
                return 1;
            }
            if (var0 == 4122) {
                var3 = stringStack[--Class49.anInt441];
                stringStack[++Class49.anInt441 - 1] = var3.toUpperCase();
                return 1;
            }
            return 2;
        }
        Class49.anInt441 -= 2;
        var3 = stringStack[Class49.anInt441];
        var5 = stringStack[Class49.anInt441 + 1];
        if (PlayerEntity.local.appearance != null && PlayerEntity.local.appearance.female) {
            stringStack[++Class49.anInt441 - 1] = var5;
        } else {
            stringStack[++Class49.anInt441 - 1] = var3;
        }

        return 1;
    }

    static int method323(int var0, boolean var2) {
        int var3 = -1;
        InterfaceComponent var4;
        if (var0 >= 2000) {
            var0 -= 1000;
            var3 = intStack[--Class49.anInt442];
            var4 = InterfaceComponent.lookup(var3);
        } else {
            var4 = var2 ? Class74.anInterfaceComponent585 : DoublyLinkedNode_Sub21.anInterfaceComponent1518;
        }

        if (var0 == 1000) {
            Class49.anInt442 -= 4;
            var4.xMargin = intStack[Class49.anInt442];
            var4.yMargin = intStack[Class49.anInt442 + 1];
            var4.xLayout = intStack[Class49.anInt442 + 2];
            var4.yLayout = intStack[Class49.anInt442 + 3];
            Enum_Sub2.repaintComponent(var4);
            client.instance.method742(var4);
            if (var3 != -1 && var4.type == 0) {
                GameEngine.method925(AssociateComparator_Sub5.interfaces[var3 >> 16], var4, false);
            }

            return 1;
        }
        if (var0 == 1001) {
            Class49.anInt442 -= 4;
            var4.anInt694 = intStack[Class49.anInt442];
            var4.anInt1105 = intStack[Class49.anInt442 + 1];
            var4.anInt1369 = intStack[Class49.anInt442 + 2];
            var4.anInt695 = intStack[Class49.anInt442 + 3];
            Enum_Sub2.repaintComponent(var4);
            client.instance.method742(var4);
            if (var3 != -1 && var4.type == 0) {
                GameEngine.method925(AssociateComparator_Sub5.interfaces[var3 >> 16], var4, false);
            }

            return 1;
        }
        if (var0 == 1003) {
            boolean var5 = intStack[--Class49.anInt442] == 1;
            if (var5 != var4.explicitlyHidden) {
                var4.explicitlyHidden = var5;
                Enum_Sub2.repaintComponent(var4);
            }

            return 1;
        }
        if (var0 == 1005) {
            var4.aBoolean1412 = intStack[--Class49.anInt442] == 1;
            return 1;
        }
        if (var0 == 1006) {
            var4.aBoolean1410 = intStack[--Class49.anInt442] == 1;
            return 1;
        }
        return 2;
    }

    static int method174(int var0) {
        int var3;
        int var4;
        if (var0 == 4000) {
            Class49.anInt442 -= 2;
            var3 = intStack[Class49.anInt442];
            var4 = intStack[Class49.anInt442 + 1];
            intStack[++Class49.anInt442 - 1] = var4 + var3;
            return 1;
        }
        if (var0 == 4001) {
            Class49.anInt442 -= 2;
            var3 = intStack[Class49.anInt442];
            var4 = intStack[Class49.anInt442 + 1];
            intStack[++Class49.anInt442 - 1] = var3 - var4;
            return 1;
        }
        if (var0 == 4002) {
            Class49.anInt442 -= 2;
            var3 = intStack[Class49.anInt442];
            var4 = intStack[Class49.anInt442 + 1];
            intStack[++Class49.anInt442 - 1] = var4 * var3;
            return 1;
        }
        if (var0 == 4003) {
            Class49.anInt442 -= 2;
            var3 = intStack[Class49.anInt442];
            var4 = intStack[Class49.anInt442 + 1];
            intStack[++Class49.anInt442 - 1] = var3 / var4;
            return 1;
        }
        if (var0 == 4004) {
            var3 = intStack[--Class49.anInt442];
            intStack[++Class49.anInt442 - 1] = (int) (Math.random() * (double) var3);
            return 1;
        }
        if (var0 == 4005) {
            var3 = intStack[--Class49.anInt442];
            intStack[++Class49.anInt442 - 1] = (int) (Math.random() * (double) (var3 + 1));
            return 1;
        }
        if (var0 == 4006) {
            Class49.anInt442 -= 5;
            var3 = intStack[Class49.anInt442];
            var4 = intStack[Class49.anInt442 + 1];
            int var5 = intStack[Class49.anInt442 + 2];
            int var6 = intStack[Class49.anInt442 + 3];
            int var7 = intStack[Class49.anInt442 + 4];
            intStack[++Class49.anInt442 - 1] = var3 + (var4 - var3) * (var7 - var5) / (var6 - var5);
            return 1;
        }
        if (var0 == 4007) {
            Class49.anInt442 -= 2;
            var3 = intStack[Class49.anInt442];
            var4 = intStack[Class49.anInt442 + 1];
            intStack[++Class49.anInt442 - 1] = var3 + var4 * var3 / 100;
            return 1;
        }
        if (var0 == 4008) {
            Class49.anInt442 -= 2;
            var3 = intStack[Class49.anInt442];
            var4 = intStack[Class49.anInt442 + 1];
            intStack[++Class49.anInt442 - 1] = var3 | 1 << var4;
            return 1;
        }
        if (var0 == 4009) {
            Class49.anInt442 -= 2;
            var3 = intStack[Class49.anInt442];
            var4 = intStack[Class49.anInt442 + 1];
            intStack[++Class49.anInt442 - 1] = var3 & -1 - (1 << var4);
            return 1;
        }
        if (var0 == 4010) {
            Class49.anInt442 -= 2;
            var3 = intStack[Class49.anInt442];
            var4 = intStack[Class49.anInt442 + 1];
            intStack[++Class49.anInt442 - 1] = (var3 & 1 << var4) != 0 ? 1 : 0;
            return 1;
        }
        if (var0 == 4011) {
            Class49.anInt442 -= 2;
            var3 = intStack[Class49.anInt442];
            var4 = intStack[Class49.anInt442 + 1];
            intStack[++Class49.anInt442 - 1] = var3 % var4;
            return 1;
        }
        if (var0 == 4012) {
            Class49.anInt442 -= 2;
            var3 = intStack[Class49.anInt442];
            var4 = intStack[Class49.anInt442 + 1];
            if (var3 == 0) {
                intStack[++Class49.anInt442 - 1] = 0;
            } else {
                intStack[++Class49.anInt442 - 1] = (int) Math.pow((double) var3, (double) var4);
            }

            return 1;
        }
        if (var0 == 4013) {
            Class49.anInt442 -= 2;
            var3 = intStack[Class49.anInt442];
            var4 = intStack[Class49.anInt442 + 1];
            if (var3 == 0) {
                intStack[++Class49.anInt442 - 1] = 0;
                return 1;
            }
            switch (var4) {
                case 0:
                    intStack[++Class49.anInt442 - 1] = Integer.MAX_VALUE;
                    break;
                case 1:
                    intStack[++Class49.anInt442 - 1] = var3;
                    break;
                case 2:
                    intStack[++Class49.anInt442 - 1] = (int) Math.sqrt((double) var3);
                    break;
                case 3:
                    intStack[++Class49.anInt442 - 1] = (int) Math.cbrt((double) var3);
                    break;
                case 4:
                    intStack[++Class49.anInt442 - 1] = (int) Math.sqrt(Math.sqrt((double) var3));
                    break;
                default:
                    intStack[++Class49.anInt442 - 1] = (int) Math.pow((double) var3, 1.0D / (double) var4);
            }

            return 1;
        }
        if (var0 == 4014) {
            Class49.anInt442 -= 2;
            var3 = intStack[Class49.anInt442];
            var4 = intStack[Class49.anInt442 + 1];
            intStack[++Class49.anInt442 - 1] = var3 & var4;
            return 1;
        }
        if (var0 == 4015) {
            Class49.anInt442 -= 2;
            var3 = intStack[Class49.anInt442];
            var4 = intStack[Class49.anInt442 + 1];
            intStack[++Class49.anInt442 - 1] = var3 | var4;
            return 1;
        }
        if (var0 == 4018) {
            Class49.anInt442 -= 3;
            long var8 = (long) intStack[Class49.anInt442];
            long var10 = (long) intStack[Class49.anInt442 + 1];
            long var12 = (long) intStack[Class49.anInt442 + 2];
            intStack[++Class49.anInt442 - 1] = (int) (var8 * var12 / var10);
            return 1;
        }
        return 2;
    }

    static int method356(int var0) {
        int var3;
        if (var0 == 3903) {
            var3 = intStack[--Class49.anInt442];
            intStack[++Class49.anInt442 - 1] = client.grandExchangeOffers[var3].method229();
            return 1;
        }
        if (var0 == 3904) {
            var3 = intStack[--Class49.anInt442];
            intStack[++Class49.anInt442 - 1] = client.grandExchangeOffers[var3].itemId;
            return 1;
        }
        if (var0 == 3905) {
            var3 = intStack[--Class49.anInt442];
            intStack[++Class49.anInt442 - 1] = client.grandExchangeOffers[var3].itemPrice;
            return 1;
        }
        if (var0 == 3906) {
            var3 = intStack[--Class49.anInt442];
            intStack[++Class49.anInt442 - 1] = client.grandExchangeOffers[var3].itemQuantity;
            return 1;
        }
        if (var0 == 3907) {
            var3 = intStack[--Class49.anInt442];
            intStack[++Class49.anInt442 - 1] = client.grandExchangeOffers[var3].transferred;
            return 1;
        }
        if (var0 == 3908) {
            var3 = intStack[--Class49.anInt442];
            intStack[++Class49.anInt442 - 1] = client.grandExchangeOffers[var3].spent;
            return 1;
        }
        int var12;
        if (var0 == 3910) {
            var3 = intStack[--Class49.anInt442];
            var12 = client.grandExchangeOffers[var3].method230();
            intStack[++Class49.anInt442 - 1] = var12 == 0 ? 1 : 0;
            return 1;
        }
        if (var0 == 3911) {
            var3 = intStack[--Class49.anInt442];
            var12 = client.grandExchangeOffers[var3].method230();
            intStack[++Class49.anInt442 - 1] = var12 == 2 ? 1 : 0;
            return 1;
        }
        if (var0 == 3912) {
            var3 = intStack[--Class49.anInt442];
            var12 = client.grandExchangeOffers[var3].method230();
            intStack[++Class49.anInt442 - 1] = var12 == 5 ? 1 : 0;
            return 1;
        }
        if (var0 == 3913) {
            var3 = intStack[--Class49.anInt442];
            var12 = client.grandExchangeOffers[var3].method230();
            intStack[++Class49.anInt442 - 1] = var12 == 1 ? 1 : 0;
            return 1;
        }
        boolean var13;
        if (var0 == 3914) {
            var13 = intStack[--Class49.anInt442] == 1;
            if (PickableNode.aClass78_890 != null) {
                PickableNode.aClass78_890.method421(Class78.aComparator607, var13);
            }

            return 1;
        }
        if (var0 == 3915) {
            var13 = intStack[--Class49.anInt442] == 1;
            if (PickableNode.aClass78_890 != null) {
                PickableNode.aClass78_890.method421(Class78.aComparator608, var13);
            }

            return 1;
        }
        if (var0 == 3916) {
            Class49.anInt442 -= 2;
            var13 = intStack[Class49.anInt442] == 1;
            boolean var4 = intStack[Class49.anInt442 + 1] == 1;
            if (PickableNode.aClass78_890 != null) {
                client.aClass38_936.aBoolean349 = var4;
                PickableNode.aClass78_890.method421(client.aClass38_936, var13);
            }

            return 1;
        }
        if (var0 == 3917) {
            var13 = intStack[--Class49.anInt442] == 1;
            if (PickableNode.aClass78_890 != null) {
                PickableNode.aClass78_890.method421(Class78.aComparator610, var13);
            }

            return 1;
        }
        if (var0 == 3918) {
            var13 = intStack[--Class49.anInt442] == 1;
            if (PickableNode.aClass78_890 != null) {
                PickableNode.aClass78_890.method421(Class78.aComparator606, var13);
            }

            return 1;
        }
        if (var0 == 3919) {
            intStack[++Class49.anInt442 - 1] = PickableNode.aClass78_890 == null ? 0 : PickableNode.aClass78_890.aList609.size();
            return 1;
        }
        Class72 var5;
        if (var0 == 3920) {
            var3 = intStack[--Class49.anInt442];
            var5 = (Class72) PickableNode.aClass78_890.aList609.get(var3);
            intStack[++Class49.anInt442 - 1] = var5.anInt552;
            return 1;
        }
        if (var0 == 3921) {
            var3 = intStack[--Class49.anInt442];
            var5 = (Class72) PickableNode.aClass78_890.aList609.get(var3);
            stringStack[++Class49.anInt441 - 1] = var5.method390();
            return 1;
        }
        if (var0 == 3922) {
            var3 = intStack[--Class49.anInt442];
            var5 = (Class72) PickableNode.aClass78_890.aList609.get(var3);
            stringStack[++Class49.anInt441 - 1] = var5.method392();
            return 1;
        }
        if (var0 == 3923) {
            var3 = intStack[--Class49.anInt442];
            var5 = (Class72) PickableNode.aClass78_890.aList609.get(var3);
            long var6 = Class24.currentTime() - EntityUID.aLong548 - var5.aLong553;
            int var8 = (int) (var6 / 3600000L);
            int var9 = (int) ((var6 - (long) (var8 * 3600000)) / 60000L);
            int var10 = (int) ((var6 - (long) (var8 * 3600000) - (long) (var9 * 60000)) / 1000L);
            String var11 = var8 + ":" + var9 / 10 + var9 % 10 + ":" + var10 / 10 + var10 % 10;
            stringStack[++Class49.anInt441 - 1] = var11;
            return 1;
        }
        if (var0 == 3924) {
            var3 = intStack[--Class49.anInt442];
            var5 = (Class72) PickableNode.aClass78_890.aList609.get(var3);
            intStack[++Class49.anInt442 - 1] = var5.aGrandExchangeOffer551.itemQuantity;
            return 1;
        }
        if (var0 == 3925) {
            var3 = intStack[--Class49.anInt442];
            var5 = (Class72) PickableNode.aClass78_890.aList609.get(var3);
            intStack[++Class49.anInt442 - 1] = var5.aGrandExchangeOffer551.itemPrice;
            return 1;
        }
        if (var0 == 3926) {
            var3 = intStack[--Class49.anInt442];
            var5 = (Class72) PickableNode.aClass78_890.aList609.get(var3);
            intStack[++Class49.anInt442 - 1] = var5.aGrandExchangeOffer551.itemId;
            return 1;
        }
        return 2;
    }

    static int method1393(int var0) {
        int var3;
        int var4;
        int var6;
        if (var0 == 3400) {
            Class49.anInt442 -= 2;
            var3 = intStack[Class49.anInt442];
            var4 = intStack[Class49.anInt442 + 1];
            DoublyLinkedNode_Sub11 var5 = AssociateComparator_Sub4.method664(var3);
            if (var5.aChar1444 != 's') {
            }

            for (var6 = 0; var6 < var5.anInt375; ++var6) {
                if (var4 == var5.anIntArray692[var6]) {
                    stringStack[++Class49.anInt441 - 1] = var5.aStringArray1446[var6];
                    var5 = null;
                    break;
                }
            }

            if (var5 != null) {
                stringStack[++Class49.anInt441 - 1] = var5.aString1442;
            }

            return 1;
        }
        if (var0 != 3408) {
            if (var0 == 3411) {
                var3 = intStack[--Class49.anInt442];
                DoublyLinkedNode_Sub11 var9 = AssociateComparator_Sub4.method664(var3);
                intStack[++Class49.anInt442 - 1] = var9.method987();
                return 1;
            }
            return 2;
        }
        Class49.anInt442 -= 4;
        var3 = intStack[Class49.anInt442];
        var4 = intStack[Class49.anInt442 + 1];
        int var7 = intStack[Class49.anInt442 + 2];
        var6 = intStack[Class49.anInt442 + 3];
        DoublyLinkedNode_Sub11 var8 = AssociateComparator_Sub4.method664(var7);
        if (var3 == var8.aChar1445 && var4 == var8.aChar1444) {
            for (int var10 = 0; var10 < var8.anInt375; ++var10) {
                if (var6 == var8.anIntArray692[var10]) {
                    if (var4 == 115) {
                        stringStack[++Class49.anInt441 - 1] = var8.aStringArray1446[var10];
                    } else {
                        intStack[++Class49.anInt442 - 1] = var8.anIntArray691[var10];
                    }

                    var8 = null;
                    break;
                }
            }

            if (var8 != null) {
                if (var4 == 115) {
                    stringStack[++Class49.anInt441 - 1] = var8.aString1442;
                } else {
                    intStack[++Class49.anInt442 - 1] = var8.anInt112;
                }
            }

            return 1;
        }
        if (var4 == 115) {
            stringStack[++Class49.anInt441 - 1] = "null";
        } else {
            intStack[++Class49.anInt442 - 1] = 0;
        }

        return 1;
    }

    static int method132(int var0) {
        if (var0 == 3300) {
            intStack[++Class49.anInt442 - 1] = client.engineCycle;
            return 1;
        }
        int var3;
        int var4;
        if (var0 == 3301) {
            Class49.anInt442 -= 2;
            var3 = intStack[Class49.anInt442];
            var4 = intStack[Class49.anInt442 + 1];
            intStack[++Class49.anInt442 - 1] = Inventory.getItemIdAt(var3, var4);
            return 1;
        }
        if (var0 == 3302) {
            Class49.anInt442 -= 2;
            var3 = intStack[Class49.anInt442];
            var4 = intStack[Class49.anInt442 + 1];
            intStack[++Class49.anInt442 - 1] = Inventory.getItemStackSizeAt(var3, var4);
            return 1;
        }
        if (var0 == 3303) {
            Class49.anInt442 -= 2;
            var3 = intStack[Class49.anInt442];
            var4 = intStack[Class49.anInt442 + 1];
            intStack[++Class49.anInt442 - 1] = Inventory.getCountIncludingStacks(var3, var4);
            return 1;
        }
        if (var0 == 3304) {
            var3 = intStack[--Class49.anInt442];
            intStack[++Class49.anInt442 - 1] = InventoryDefinition.lookup(var3).capacity;
            return 1;
        }
        if (var0 == 3305) {
            var3 = intStack[--Class49.anInt442];
            intStack[++Class49.anInt442 - 1] = client.currentLevels[var3];
            return 1;
        }
        if (var0 == 3306) {
            var3 = intStack[--Class49.anInt442];
            intStack[++Class49.anInt442 - 1] = client.levels[var3];
            return 1;
        }
        if (var0 == 3307) {
            var3 = intStack[--Class49.anInt442];
            intStack[++Class49.anInt442 - 1] = client.experiences[var3];
            return 1;
        }
        int var5;
        if (var0 == 3308) {
            var3 = SceneGraph.floorLevel;
            var4 = Statics18.baseX + (PlayerEntity.local.fineX >> 7);
            var5 = Statics36.baseY + (PlayerEntity.local.fineY >> 7);
            intStack[++Class49.anInt442 - 1] = (var4 << 14) + var5 + (var3 << 28);
            return 1;
        }
        if (var0 == 3309) {
            var3 = intStack[--Class49.anInt442];
            intStack[++Class49.anInt442 - 1] = var3 >> 14 & 16383;
            return 1;
        }
        if (var0 == 3310) {
            var3 = intStack[--Class49.anInt442];
            intStack[++Class49.anInt442 - 1] = var3 >> 28;
            return 1;
        }
        if (var0 == 3311) {
            var3 = intStack[--Class49.anInt442];
            intStack[++Class49.anInt442 - 1] = var3 & 16383;
            return 1;
        }
        if (var0 == 3312) {
            intStack[++Class49.anInt442 - 1] = client.membersWorld ? 1 : 0;
            return 1;
        }
        if (var0 == 3313) {
            Class49.anInt442 -= 2;
            var3 = intStack[Class49.anInt442] + 32768;
            var4 = intStack[Class49.anInt442 + 1];
            intStack[++Class49.anInt442 - 1] = Inventory.getItemIdAt(var3, var4);
            return 1;
        }
        if (var0 == 3314) {
            Class49.anInt442 -= 2;
            var3 = intStack[Class49.anInt442] + 32768;
            var4 = intStack[Class49.anInt442 + 1];
            intStack[++Class49.anInt442 - 1] = Inventory.getItemStackSizeAt(var3, var4);
            return 1;
        }
        if (var0 == 3315) {
            Class49.anInt442 -= 2;
            var3 = intStack[Class49.anInt442] + 32768;
            var4 = intStack[Class49.anInt442 + 1];
            intStack[++Class49.anInt442 - 1] = Inventory.getCountIncludingStacks(var3, var4);
            return 1;
        }
        if (var0 == 3316) {
            if (client.rights >= 2) {
                intStack[++Class49.anInt442 - 1] = client.rights;
            } else {
                intStack[++Class49.anInt442 - 1] = 0;
            }

            return 1;
        }
        if (var0 == 3317) {
            intStack[++Class49.anInt442 - 1] = client.anInt934;
            return 1;
        }
        if (var0 == 3318) {
            intStack[++Class49.anInt442 - 1] = client.currentWorld;
            return 1;
        }
        if (var0 == 3321) {
            intStack[++Class49.anInt442 - 1] = client.energy;
            return 1;
        }
        if (var0 == 3322) {
            intStack[++Class49.anInt442 - 1] = client.weight;
            return 1;
        }
        if (var0 == 3323) {
            if (client.aBoolean1056) {
                intStack[++Class49.anInt442 - 1] = 1;
            } else {
                intStack[++Class49.anInt442 - 1] = 0;
            }

            return 1;
        }
        if (var0 == 3324) {
            intStack[++Class49.anInt442 - 1] = client.currentWorldMask;
            return 1;
        }
        if (var0 == 3325) {
            Class49.anInt442 -= 4;
            var3 = intStack[Class49.anInt442];
            var4 = intStack[Class49.anInt442 + 1];
            var5 = intStack[Class49.anInt442 + 2];
            int var6 = intStack[Class49.anInt442 + 3];
            var3 += var4 << 14;
            var3 += var5 << 28;
            var3 += var6;
            intStack[++Class49.anInt442 - 1] = var3;
            return 1;
        }
        return 2;
    }

    static int method556(int var0) {
        if (var0 == 3200) {
            Class49.anInt442 -= 3;
            Chatline.method884(intStack[Class49.anInt442], intStack[Class49.anInt442 + 1], intStack[Class49.anInt442 + 2]);
            return 1;
        }
        if (var0 == 3201) {
            Class139.method795(intStack[--Class49.anInt442]);
            return 1;
        }
        if (var0 == 3202) {
            Class49.anInt442 -= 2;
            OutgoingPacketMeta.method5(intStack[Class49.anInt442]);
            return 1;
        }
        return 2;
    }

    static int method361(int var0, boolean var2) {
        String var3;
        if (var0 == 3100) {
            var3 = stringStack[--Class49.anInt441];
            Statics19.messageReceived(0, "", var3);
            return 1;
        }
        if (var0 == 3101) {
            Class49.anInt442 -= 2;
            LoginPacketMeta.method1497(PlayerEntity.local, intStack[Class49.anInt442], intStack[Class49.anInt442 + 1]);
            return 1;
        }
        if (var0 == 3103) {
            if (!Class49.aBoolean449) {
                Class49.aBoolean439 = true;
            }

            return 1;
        }
        int var10;
        if (var0 == 3104) {
            var3 = stringStack[--Class49.anInt441];
            var10 = 0;
            if (OldConnection.method713(var3)) {
                var10 = TilePaint.method1501(var3);
            }

            OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta100, client.connectionContext.encryptor);
            packet.buffer.writeInt(var10);
            client.connectionContext.writeLater(packet);
            return 1;
        }
        OutgoingPacket packet;
        if (var0 == 3105) {
            var3 = stringStack[--Class49.anInt441];
            packet = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta94, client.connectionContext.encryptor);
            packet.buffer.writeByte(var3.length() + 1);
            packet.buffer.writeCString(var3);
            client.connectionContext.writeLater(packet);
            return 1;
        }
        if (var0 == 3106) {
            var3 = stringStack[--Class49.anInt441];
            packet = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta9, client.connectionContext.encryptor);
            packet.buffer.writeByte(var3.length() + 1);
            packet.buffer.writeCString(var3);
            client.connectionContext.writeLater(packet);
            return 1;
        }
        String var6;
        int var14;
        if (var0 == 3107) {
            var14 = intStack[--Class49.anInt442];
            var6 = stringStack[--Class49.anInt441];
            Class65.method365(var14, var6);
            return 1;
        }
        if (var0 == 3108) {
            Class49.anInt442 -= 3;
            var14 = intStack[Class49.anInt442];
            var10 = intStack[Class49.anInt442 + 1];
            int var8 = intStack[Class49.anInt442 + 2];
            InterfaceComponent var15 = InterfaceComponent.lookup(var8);
            Statics23.drag(var15, var14, var10);
            return 1;
        }
        if (var0 == 3109) {
            Class49.anInt442 -= 2;
            var14 = intStack[Class49.anInt442];
            var10 = intStack[Class49.anInt442 + 1];
            InterfaceComponent var11 = var2 ? Class74.anInterfaceComponent585 : DoublyLinkedNode_Sub21.anInterfaceComponent1518;
            Statics23.drag(var11, var14, var10);
            return 1;
        }
        if (var0 == 3110) {
            Class27_Sub1.aBoolean492 = intStack[--Class49.anInt442] == 1;
            return 1;
        }
        if (var0 == 3111) {
            intStack[++Class49.anInt442 - 1] = client.preferences.roofsHidden ? 1 : 0;
            return 1;
        }
        if (var0 == 3112) {
            client.preferences.roofsHidden = intStack[--Class49.anInt442] == 1;
            Class149.method854();
            return 1;
        }
        if (var0 == 3113) {
            var3 = stringStack[--Class49.anInt441];
            boolean var4 = intStack[--Class49.anInt442] == 1;
            Class174.method1006(var3, var4, false);
            return 1;
        }
        if (var0 == 3115) {
            var14 = intStack[--Class49.anInt442];
            packet = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta30, client.connectionContext.encryptor);
            packet.buffer.writeShort(var14);
            client.connectionContext.writeLater(packet);
            return 1;
        }
        if (var0 == 3116) {
            var14 = intStack[--Class49.anInt442];
            Class49.anInt441 -= 2;
            var6 = stringStack[Class49.anInt441];
            String var5 = stringStack[Class49.anInt441 + 1];
            if (var6.length() > 500) {
                return 1;
            }
            if (var5.length() > 500) {
                return 1;
            }
            OutgoingPacket var9 = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta96, client.connectionContext.encryptor);
            var9.buffer.writeShort(1 + Statics30.stringLengthPlusOne(var6) + Statics30.stringLengthPlusOne(var5));
            var9.buffer.writeCString(var6);
            var9.buffer.writeCString(var5);
            var9.buffer.writeNegatedByte(var14);
            client.connectionContext.writeLater(var9);
            return 1;
        }
        if (var0 == 3117) {
            client.aBoolean1044 = intStack[--Class49.anInt442] == 1;
            return 1;
        }
        if (var0 == 3118) {
            client.aBoolean1043 = intStack[--Class49.anInt442] == 1;
            return 1;
        }
        if (var0 == 3119) {
            client.aBoolean1020 = intStack[--Class49.anInt442] == 1;
            return 1;
        }
        if (var0 == 3120) {
            if (intStack[--Class49.anInt442] == 1) {
                client.anInt1031 |= 1;
            } else {
                client.anInt1031 &= -2;
            }

            return 1;
        }
        if (var0 == 3121) {
            if (intStack[--Class49.anInt442] == 1) {
                client.anInt1031 |= 2;
            } else {
                client.anInt1031 &= -3;
            }

            return 1;
        }
        if (var0 == 3122) {
            if (intStack[--Class49.anInt442] == 1) {
                client.anInt1031 |= 4;
            } else {
                client.anInt1031 &= -5;
            }

            return 1;
        }
        if (var0 == 3123) {
            if (intStack[--Class49.anInt442] == 1) {
                client.anInt1031 |= 8;
            } else {
                client.anInt1031 &= -9;
            }

            return 1;
        }
        if (var0 == 3124) {
            client.anInt1031 = 0;
            return 1;
        }
        if (var0 == 3125) {
            client.aBoolean1028 = intStack[--Class49.anInt442] == 1;
            return 1;
        }
        if (var0 == 3126) {
            client.aBoolean1021 = intStack[--Class49.anInt442] == 1;
            return 1;
        }
        if (var0 == 3127) {
            method1306(intStack[--Class49.anInt442] == 1);
            return 1;
        }
        if (var0 == 3128) {
            intStack[++Class49.anInt442 - 1] = Class37.method243() ? 1 : 0;
            return 1;
        }
        if (var0 == 3129) {
            Class49.anInt442 -= 2;
            client.anInt1004 = intStack[Class49.anInt442];
            client.anInt992 = intStack[Class49.anInt442 + 1];
            return 1;
        }
        if (var0 == 3130) {
            Class49.anInt442 -= 2;
            return 1;
        }
        if (var0 == 3131) {
            --Class49.anInt442;
            return 1;
        }
        if (var0 == 3132) {
            intStack[++Class49.anInt442 - 1] = client.canvasWidth;
            intStack[++Class49.anInt442 - 1] = client.canvasHeight;
            return 1;
        }
        if (var0 == 3133) {
            --Class49.anInt442;
            return 1;
        }
        if (var0 == 3134) {
            return 1;
        }
        if (var0 == 3135) {
            Class49.anInt442 -= 2;
            return 1;
        }
        if (var0 == 3136) {
            client.anInt1047 = 3;
            client.anInt1059 = intStack[--Class49.anInt442];
            return 1;
        }
        if (var0 == 3137) {
            client.anInt1047 = 2;
            client.anInt1059 = intStack[--Class49.anInt442];
            return 1;
        }
        if (var0 == 3138) {
            client.anInt1047 = 0;
            return 1;
        }
        if (var0 == 3139) {
            client.anInt1047 = 1;
            return 1;
        }
        if (var0 == 3140) {
            client.anInt1047 = 3;
            client.anInt1059 = var2 ? Class74.anInterfaceComponent585.uid : DoublyLinkedNode_Sub21.anInterfaceComponent1518.uid;
            return 1;
        }
        boolean var7;
        if (var0 == 3141) {
            var7 = intStack[--Class49.anInt442] == 1;
            client.preferences.rememberMe = var7;
            Class149.method854();
            return 1;
        }
        if (var0 == 3142) {
            intStack[++Class49.anInt442 - 1] = client.preferences.rememberMe ? 1 : 0;
            return 1;
        }
        if (var0 == 3143) {
            var7 = intStack[--Class49.anInt442] == 1;
            client.aBoolean958 = var7;
            if (!var7) {
                client.preferences.aString362 = "";
                Class149.method854();
            }

            return 1;
        }
        if (var0 == 3144) {
            intStack[++Class49.anInt442 - 1] = client.aBoolean958 ? 1 : 0;
            return 1;
        }
        if (var0 == 3145) {
            return 1;
        }
        if (var0 == 3146) {
            var7 = intStack[--Class49.anInt442] == 1;
            if (var7 == client.preferences.loginScreenAudioDisabled) {
                client.preferences.loginScreenAudioDisabled = !var7;
                Class149.method854();
            }

            return 1;
        }
        if (var0 == 3147) {
            intStack[++Class49.anInt442 - 1] = client.preferences.loginScreenAudioDisabled ? 0 : 1;
            return 1;
        }
        if (var0 == 3148) {
            return 1;
        }
        if (var0 == 3149) {
            intStack[++Class49.anInt442 - 1] = 0;
            return 1;
        }
        if (var0 == 3150) {
            intStack[++Class49.anInt442 - 1] = 0;
            return 1;
        }
        if (var0 == 3151) {
            intStack[++Class49.anInt442 - 1] = 0;
            return 1;
        }
        if (var0 == 3152) {
            intStack[++Class49.anInt442 - 1] = 0;
            return 1;
        }
        if (var0 == 3153) {
            intStack[++Class49.anInt442 - 1] = Class55.anInt473;
            return 1;
        }
        if (var0 == 3154) {
            intStack[++Class49.anInt442 - 1] = Class88.method476();
            return 1;
        }
        if (var0 == 3155) {
            --Class49.anInt441;
            return 1;
        }
        if (var0 == 3156) {
            return 1;
        }
        if (var0 == 3157) {
            Class49.anInt442 -= 2;
            return 1;
        }
        if (var0 == 3158) {
            intStack[++Class49.anInt442 - 1] = 0;
            return 1;
        }
        if (var0 == 3159) {
            intStack[++Class49.anInt442 - 1] = 0;
            return 1;
        }
        if (var0 == 3160) {
            intStack[++Class49.anInt442 - 1] = 0;
            return 1;
        }
        if (var0 == 3161) {
            --Class49.anInt442;
            intStack[++Class49.anInt442 - 1] = 0;
            return 1;
        }
        if (var0 == 3162) {
            --Class49.anInt442;
            intStack[++Class49.anInt442 - 1] = 0;
            return 1;
        }
        if (var0 == 3163) {
            --Class49.anInt441;
            intStack[++Class49.anInt442 - 1] = 0;
            return 1;
        }
        if (var0 == 3164) {
            --Class49.anInt442;
            stringStack[++Class49.anInt441 - 1] = "";
            return 1;
        }
        if (var0 == 3165) {
            --Class49.anInt442;
            intStack[++Class49.anInt442 - 1] = 0;
            return 1;
        }
        if (var0 == 3166) {
            Class49.anInt442 -= 2;
            intStack[++Class49.anInt442 - 1] = 0;
            return 1;
        }
        if (var0 == 3167) {
            Class49.anInt442 -= 2;
            intStack[++Class49.anInt442 - 1] = 0;
            return 1;
        }
        if (var0 == 3168) {
            Class49.anInt442 -= 2;
            stringStack[++Class49.anInt441 - 1] = "";
            stringStack[++Class49.anInt441 - 1] = "";
            stringStack[++Class49.anInt441 - 1] = "";
            stringStack[++Class49.anInt441 - 1] = "";
            stringStack[++Class49.anInt441 - 1] = "";
            stringStack[++Class49.anInt441 - 1] = "";
            stringStack[++Class49.anInt441 - 1] = "";
            stringStack[++Class49.anInt441 - 1] = "";
            stringStack[++Class49.anInt441 - 1] = "";
            return 1;
        }
        if (var0 == 3169) {
            return 1;
        }
        if (var0 == 3170) {
            intStack[++Class49.anInt442 - 1] = 0;
            return 1;
        }
        if (var0 == 3171) {
            intStack[++Class49.anInt442 - 1] = 0;
            return 1;
        }
        if (var0 == 3172) {
            --Class49.anInt442;
            return 1;
        }
        if (var0 == 3173) {
            --Class49.anInt442;
            intStack[++Class49.anInt442 - 1] = 0;
            return 1;
        }
        if (var0 == 3174) {
            --Class49.anInt442;
            return 1;
        }
        if (var0 == 3175) {
            intStack[++Class49.anInt442 - 1] = 0;
            return 1;
        }
        return var0 == 3176 ? 1 : 2;
    }

    static int method3(int var0, boolean var2) {
        InterfaceComponent var3;
        if (var0 >= 2000) {
            var0 -= 1000;
            var3 = InterfaceComponent.lookup(intStack[--Class49.anInt442]);
        } else {
            var3 = var2 ? Class74.anInterfaceComponent585 : DoublyLinkedNode_Sub21.anInterfaceComponent1518;
        }

        if (var0 == 1927) {
            if (Class49.anInt440 >= 10) {
                throw new RuntimeException();
            }
            if (var3.anObjectArray1400 == null) {
                return 0;
            }
            ScriptEvent var4 = new ScriptEvent();
            var4.source = var3;
            var4.args = var3.anObjectArray1400;
            var4.anInt368 = Class49.anInt440 + 1;
            client.aNodeDeque1082.add(var4);
            return 1;
        }
        return 2;
    }

    static int method720(int var0) {
        InterfaceComponent var3;
        if (var0 == 2700) {
            var3 = InterfaceComponent.lookup(intStack[--Class49.anInt442]);
            intStack[++Class49.anInt442 - 1] = var3.itemId;
            return 1;
        }
        if (var0 == 2701) {
            var3 = InterfaceComponent.lookup(intStack[--Class49.anInt442]);
            if (var3.itemId != -1) {
                intStack[++Class49.anInt442 - 1] = var3.itemStackSize;
            } else {
                intStack[++Class49.anInt442 - 1] = 0;
            }

            return 1;
        }
        if (var0 == 2702) {
            int var4 = intStack[--Class49.anInt442];
            InterfaceNode var5 = (InterfaceNode) client.interfaceNodes.lookup((long) var4);
            if (var5 != null) {
                intStack[++Class49.anInt442 - 1] = 1;
            } else {
                intStack[++Class49.anInt442 - 1] = 0;
            }

            return 1;
        }
        if (var0 == 2706) {
            intStack[++Class49.anInt442 - 1] = client.rootInterfaceIndex;
            return 1;
        }
        return 2;
    }

    static int method32(int var0) {
        InterfaceComponent var3 = InterfaceComponent.lookup(intStack[--Class49.anInt442]);
        if (var0 == 2800) {
            intStack[++Class49.anInt442 - 1] = Class87.getComponentSpellTargets(InterfaceComponent.getConfig(var3));
            return 1;
        }
        if (var0 != 2801) {
            if (var0 == 2802) {
                if (var3.name == null) {
                    stringStack[++Class49.anInt441 - 1] = "";
                } else {
                    stringStack[++Class49.anInt441 - 1] = var3.name;
                }

                return 1;
            }
            return 2;
        }
        int var4 = intStack[--Class49.anInt442];
        --var4;
        if (var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
            stringStack[++Class49.anInt441 - 1] = var3.actions[var4];
        } else {
            stringStack[++Class49.anInt441 - 1] = "";
        }

        return 1;
    }

    static int method739(int var0) {
        InterfaceComponent var3 = InterfaceComponent.lookup(intStack[--Class49.anInt442]);
        if (var0 == 2600) {
            intStack[++Class49.anInt442 - 1] = var3.insetX;
            return 1;
        }
        if (var0 == 2601) {
            intStack[++Class49.anInt442 - 1] = var3.insetY;
            return 1;
        }
        if (var0 == 2602) {
            stringStack[++Class49.anInt441 - 1] = var3.text;
            return 1;
        }
        if (var0 == 2603) {
            intStack[++Class49.anInt442 - 1] = var3.viewportWidth;
            return 1;
        }
        if (var0 == 2604) {
            intStack[++Class49.anInt442 - 1] = var3.viewportHeight;
            return 1;
        }
        if (var0 == 2605) {
            intStack[++Class49.anInt442 - 1] = var3.modelZoom;
            return 1;
        }
        if (var0 == 2606) {
            intStack[++Class49.anInt442 - 1] = var3.xRotation;
            return 1;
        }
        if (var0 == 2607) {
            intStack[++Class49.anInt442 - 1] = var3.yRotation;
            return 1;
        }
        if (var0 == 2608) {
            intStack[++Class49.anInt442 - 1] = var3.zRotation;
            return 1;
        }
        if (var0 == 2609) {
            intStack[++Class49.anInt442 - 1] = var3.alpha;
            return 1;
        }
        if (var0 == 2610) {
            intStack[++Class49.anInt442 - 1] = var3.anInt1343;
            return 1;
        }
        if (var0 == 2611) {
            intStack[++Class49.anInt442 - 1] = var3.textColor;
            return 1;
        }
        if (var0 == 2612) {
            intStack[++Class49.anInt442 - 1] = var3.anInt1348;
            return 1;
        }
        if (var0 == 2613) {
            intStack[++Class49.anInt442 - 1] = var3.anEnum_Sub11_1349.getOrdinal();
            return 1;
        }
        if (var0 == 2614) {
            intStack[++Class49.anInt442 - 1] = var3.aBoolean1359 ? 1 : 0;
            return 1;
        }
        return 2;
    }

    static int method218(int var0) {
        InterfaceComponent var3 = InterfaceComponent.lookup(intStack[--Class49.anInt442]);
        if (var0 == 2500) {
            intStack[++Class49.anInt442 - 1] = var3.relativeX;
            return 1;
        }
        if (var0 == 2501) {
            intStack[++Class49.anInt442 - 1] = var3.relativeY;
            return 1;
        }
        if (var0 == 2502) {
            intStack[++Class49.anInt442 - 1] = var3.width;
            return 1;
        }
        if (var0 == 2503) {
            intStack[++Class49.anInt442 - 1] = var3.height;
            return 1;
        }
        if (var0 == 2504) {
            intStack[++Class49.anInt442 - 1] = var3.explicitlyHidden ? 1 : 0;
            return 1;
        }
        if (var0 == 2505) {
            intStack[++Class49.anInt442 - 1] = var3.parentUid;
            return 1;
        }
        return 2;
    }

    static int method266(int var0, boolean var2) {
        InterfaceComponent var3;
        if (var0 >= 2000) {
            var0 -= 1000;
            var3 = InterfaceComponent.lookup(intStack[--Class49.anInt442]);
        } else {
            var3 = var2 ? Class74.anInterfaceComponent585 : DoublyLinkedNode_Sub21.anInterfaceComponent1518;
        }

        String var4 = stringStack[--Class49.anInt441];
        int[] var5 = null;
        if (var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
            int var6 = intStack[--Class49.anInt442];
            if (var6 > 0) {
                for (var5 = new int[var6]; var6-- > 0; var5[var6] = intStack[--Class49.anInt442]) {
                }
            }

            var4 = var4.substring(0, var4.length() - 1);
        }

        Object[] var7 = new Object[var4.length() + 1];

        int var8;
        for (var8 = var7.length - 1; var8 >= 1; --var8) {
            if (var4.charAt(var8 - 1) == 's') {
                var7[var8] = stringStack[--Class49.anInt441];
            } else {
                var7[var8] = intStack[--Class49.anInt442];
            }
        }

        var8 = intStack[--Class49.anInt442];
        if (var8 != -1) {
            var7[0] = var8;
        } else {
            var7 = null;
        }

        if (var0 == 1400) {
            var3.anObjectArray1386 = var7;
        } else if (var0 == 1401) {
            var3.anObjectArray1379 = var7;
        } else if (var0 == 1402) {
            var3.anObjectArray1376 = var7;
        } else if (var0 == 1403) {
            var3.mouseEnterListeners = var7;
        } else if (var0 == 1404) {
            var3.mouseExitListeners = var7;
        } else if (var0 == 1405) {
            var3.dragListeners = var7;
        } else if (var0 == 1406) {
            var3.anObjectArray1380 = var7;
        } else if (var0 == 1407) {
            var3.configListenerArgs = var7;
            var3.configTriggers = var5;
        } else if (var0 == 1408) {
            var3.renderListeners = var7;
        } else if (var0 == 1409) {
            var3.mousePressListeners = var7;
        } else if (var0 == 1410) {
            var3.anObjectArray1387 = var7;
        } else if (var0 == 1411) {
            var3.anObjectArray1385 = var7;
        } else if (var0 == 1412) {
            var3.hoverListeners = var7;
        } else if (var0 == 1414) {
            var3.tableListenerArgs = var7;
            var3.itemTriggers = var5;
        } else if (var0 == 1415) {
            var3.skillListenerArgs = var7;
            var3.skillTriggers = var5;
        } else if (var0 == 1416) {
            var3.anObjectArray1377 = var7;
        } else if (var0 == 1417) {
            var3.scrollListeners = var7;
        } else if (var0 == 1418) {
            var3.anObjectArray1403 = var7;
        } else if (var0 == 1419) {
            var3.anObjectArray1398 = var7;
        } else if (var0 == 1420) {
            var3.anObjectArray1399 = var7;
        } else if (var0 == 1421) {
            var3.anObjectArray1396 = var7;
        } else if (var0 == 1422) {
            var3.anObjectArray1390 = var7;
        } else if (var0 == 1423) {
            var3.anObjectArray1397 = var7;
        } else if (var0 == 1424) {
            var3.anObjectArray1393 = var7;
        } else if (var0 == 1425) {
            var3.anObjectArray1391 = var7;
        } else if (var0 == 1426) {
            var3.anObjectArray1394 = var7;
        } else {
            if (var0 != 1427) {
                return 2;
            }

            var3.anObjectArray1400 = var7;
        }

        var3.aBoolean1378 = true;
        return 1;
    }

    static int method120(int var0, boolean var2) {
        boolean var3 = true;
        InterfaceComponent var4;
        if (var0 >= 2000) {
            var0 -= 1000;
            var4 = InterfaceComponent.lookup(intStack[--Class49.anInt442]);
            var3 = false;
        } else {
            var4 = var2 ? Class74.anInterfaceComponent585 : DoublyLinkedNode_Sub21.anInterfaceComponent1518;
        }

        int var11;
        if (var0 == 1300) {
            var11 = intStack[--Class49.anInt442] - 1;
            if (var11 >= 0 && var11 <= 9) {
                var4.method964(var11, stringStack[--Class49.anInt441]);
                return 1;
            }
            --Class49.anInt441;
            return 1;
        }
        int var6;
        if (var0 == 1301) {
            Class49.anInt442 -= 2;
            var11 = intStack[Class49.anInt442];
            var6 = intStack[Class49.anInt442 + 1];
            var4.parent = InterfaceComponent.lookup(var11, var6);
            return 1;
        }
        if (var0 == 1302) {
            var4.aBoolean1388 = intStack[--Class49.anInt442] == 1;
            return 1;
        }
        if (var0 == 1303) {
            var4.anInt1381 = intStack[--Class49.anInt442];
            return 1;
        }
        if (var0 == 1304) {
            var4.anInt1383 = intStack[--Class49.anInt442];
            return 1;
        }
        if (var0 == 1305) {
            var4.name = stringStack[--Class49.anInt441];
            return 1;
        }
        if (var0 == 1306) {
            var4.selectedAction = stringStack[--Class49.anInt441];
            return 1;
        }
        if (var0 == 1307) {
            var4.actions = null;
            return 1;
        }
        if (var0 == 1308) {
            var4.aBoolean1409 = intStack[--Class49.anInt442] == 1;
            return 1;
        }
        byte[] var8;
        int var9;
        if (var0 != 1350) {
            byte var5;
            if (var0 == 1351) {
                Class49.anInt442 -= 2;
                var5 = 10;
                var8 = new byte[]{(byte) intStack[Class49.anInt442]};
                byte[] var10 = new byte[]{(byte) intStack[Class49.anInt442 + 1]};
                Statics12.method868(var4, var5, var8, var10);
                return 1;
            }
            if (var0 == 1352) {
                Class49.anInt442 -= 3;
                var11 = intStack[Class49.anInt442] - 1;
                var6 = intStack[Class49.anInt442 + 1];
                var9 = intStack[Class49.anInt442 + 2];
                if (var11 >= 0 && var11 <= 9) {
                    Class45.method274(var4, var11, var6, var9);
                    return 1;
                }
                throw new RuntimeException();
            }
            if (var0 == 1353) {
                var5 = 10;
                var6 = intStack[--Class49.anInt442];
                var9 = intStack[--Class49.anInt442];
                Class45.method274(var4, var5, var6, var9);
                return 1;
            }
            if (var0 == 1354) {
                --Class49.anInt442;
                var11 = intStack[Class49.anInt442] - 1;
                if (var11 >= 0 && var11 <= 9) {
                    Class54.method320(var4, var11);
                    return 1;
                }
                throw new RuntimeException();
            }
            if (var0 == 1355) {
                var5 = 10;
                Class54.method320(var4, var5);
                return 1;
            }
            return 2;
        }
        byte[] var7 = null;
        var8 = null;
        if (var3) {
            Class49.anInt442 -= 10;

            for (var9 = 0; var9 < 10 && intStack[var9 + Class49.anInt442] >= 0; var9 += 2) {
            }

            if (var9 > 0) {
                var7 = new byte[var9 / 2];
                var8 = new byte[var9 / 2];

                for (var9 -= 2; var9 >= 0; var9 -= 2) {
                    var7[var9 / 2] = (byte) intStack[var9 + Class49.anInt442];
                    var8[var9 / 2] = (byte) intStack[var9 + Class49.anInt442 + 1];
                }
            }
        } else {
            Class49.anInt442 -= 2;
            var7 = new byte[]{(byte) intStack[Class49.anInt442]};
            var8 = new byte[]{(byte) intStack[Class49.anInt442 + 1]};
        }

        var9 = intStack[--Class49.anInt442] - 1;
        if (var9 >= 0 && var9 <= 9) {
            Statics12.method868(var4, var9, var7, var8);
            return 1;
        }
        throw new RuntimeException();
    }

    static int method484(int var0, boolean var2) {
        InterfaceComponent var3;
        if (var0 >= 2000) {
            var0 -= 1000;
            var3 = InterfaceComponent.lookup(intStack[--Class49.anInt442]);
        } else {
            var3 = var2 ? Class74.anInterfaceComponent585 : DoublyLinkedNode_Sub21.anInterfaceComponent1518;
        }

        Enum_Sub2.repaintComponent(var3);
        if (var0 != 1200 && var0 != 1205 && var0 != 1212) {
            if (var0 == 1201) {
                var3.modelType = 2;
                var3.modelId = intStack[--Class49.anInt442];
                return 1;
            }
            if (var0 == 1202) {
                var3.modelType = 3;
                var3.modelId = PlayerEntity.local.appearance.method1433();
                return 1;
            }
            return 2;
        }
        Class49.anInt442 -= 2;
        int var4 = intStack[Class49.anInt442];
        int var5 = intStack[Class49.anInt442 + 1];
        var3.itemId = var4;
        var3.itemStackSize = var5;
        ItemDefinition var6 = CameraCapture.getItemDefinition(var4);
        var3.xRotation = var6.spritePitch;
        var3.zRotation = var6.spriteRoll;
        var3.yRotation = var6.spriteYaw;
        var3.modelOffsetX = var6.spriteTranslateX;
        var3.modelOffsetY = var6.spriteTranslateY;
        var3.modelZoom = var6.spriteScale;
        if (var0 == 1205) {
            var3.anInt1356 = 0;
        } else if (var0 == 1212 | var6.stackable == 1) {
            var3.anInt1356 = 1;
        } else {
            var3.anInt1356 = 2;
        }

        if (var3.anInt1354 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.anInt1354;
        } else if (var3.anInt694 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.anInt694;
        }

        return 1;
    }

    static int method386(int var0, boolean var2) {
        int var3 = -1;
        InterfaceComponent var4;
        if (var0 >= 2000) {
            var0 -= 1000;
            var3 = intStack[--Class49.anInt442];
            var4 = InterfaceComponent.lookup(var3);
        } else {
            var4 = var2 ? Class74.anInterfaceComponent585 : DoublyLinkedNode_Sub21.anInterfaceComponent1518;
        }

        if (var0 == 1100) {
            Class49.anInt442 -= 2;
            var4.insetX = intStack[Class49.anInt442];
            if (var4.insetX > var4.viewportWidth - var4.width) {
                var4.insetX = var4.viewportWidth - var4.width;
            }

            if (var4.insetX < 0) {
                var4.insetX = 0;
            }

            var4.insetY = intStack[Class49.anInt442 + 1];
            if (var4.insetY > var4.viewportHeight - var4.height) {
                var4.insetY = var4.viewportHeight - var4.height;
            }

            if (var4.insetY < 0) {
                var4.insetY = 0;
            }

            Enum_Sub2.repaintComponent(var4);
            return 1;
        }
        if (var0 == 1101) {
            var4.textColor = intStack[--Class49.anInt442];
            Enum_Sub2.repaintComponent(var4);
            return 1;
        }
        if (var0 == 1102) {
            var4.aBoolean1346 = intStack[--Class49.anInt442] == 1;
            Enum_Sub2.repaintComponent(var4);
            return 1;
        }
        if (var0 == 1103) {
            var4.alpha = intStack[--Class49.anInt442];
            Enum_Sub2.repaintComponent(var4);
            return 1;
        }
        if (var0 == 1104) {
            var4.anInt1347 = intStack[--Class49.anInt442];
            Enum_Sub2.repaintComponent(var4);
            return 1;
        }
        if (var0 == 1105) {
            var4.materialId = intStack[--Class49.anInt442];
            Enum_Sub2.repaintComponent(var4);
            return 1;
        }
        if (var0 == 1106) {
            var4.spriteId = intStack[--Class49.anInt442];
            Enum_Sub2.repaintComponent(var4);
            return 1;
        }
        if (var0 == 1107) {
            var4.aBoolean1358 = intStack[--Class49.anInt442] == 1;
            Enum_Sub2.repaintComponent(var4);
            return 1;
        }
        if (var0 == 1108) {
            var4.modelType = 1;
            var4.modelId = intStack[--Class49.anInt442];
            Enum_Sub2.repaintComponent(var4);
            return 1;
        }
        if (var0 == 1109) {
            Class49.anInt442 -= 6;
            var4.modelOffsetX = intStack[Class49.anInt442];
            var4.modelOffsetY = intStack[Class49.anInt442 + 1];
            var4.xRotation = intStack[Class49.anInt442 + 2];
            var4.zRotation = intStack[Class49.anInt442 + 3];
            var4.yRotation = intStack[Class49.anInt442 + 4];
            var4.modelZoom = intStack[Class49.anInt442 + 5];
            Enum_Sub2.repaintComponent(var4);
            return 1;
        }
        int var8;
        if (var0 == 1110) {
            var8 = intStack[--Class49.anInt442];
            if (var8 != var4.anInt1357) {
                var4.anInt1357 = var8;
                var4.anInt1389 = 0;
                var4.anInt1401 = 0;
                Enum_Sub2.repaintComponent(var4);
            }

            return 1;
        }
        if (var0 == 1111) {
            var4.aBoolean1352 = intStack[--Class49.anInt442] == 1;
            Enum_Sub2.repaintComponent(var4);
            return 1;
        }
        if (var0 == 1112) {
            String var6 = stringStack[--Class49.anInt441];
            if (!var6.equals(var4.text)) {
                var4.text = var6;
                Enum_Sub2.repaintComponent(var4);
            }

            return 1;
        }
        if (var0 == 1113) {
            var4.fontId = intStack[--Class49.anInt442];
            Enum_Sub2.repaintComponent(var4);
            return 1;
        }
        if (var0 == 1114) {
            Class49.anInt442 -= 3;
            var4.horizontalMargin = intStack[Class49.anInt442];
            var4.verticalMargin = intStack[Class49.anInt442 + 1];
            var4.textSpacing = intStack[Class49.anInt442 + 2];
            Enum_Sub2.repaintComponent(var4);
            return 1;
        }
        if (var0 == 1115) {
            var4.textShadowed = intStack[--Class49.anInt442] == 1;
            Enum_Sub2.repaintComponent(var4);
            return 1;
        }
        if (var0 == 1116) {
            var4.borderThickness = intStack[--Class49.anInt442];
            Enum_Sub2.repaintComponent(var4);
            return 1;
        }
        if (var0 == 1117) {
            var4.shadowColor = intStack[--Class49.anInt442];
            Enum_Sub2.repaintComponent(var4);
            return 1;
        }
        if (var0 == 1118) {
            var4.flippedVertically = intStack[--Class49.anInt442] == 1;
            Enum_Sub2.repaintComponent(var4);
            return 1;
        }
        if (var0 == 1119) {
            var4.flippedHorizontally = intStack[--Class49.anInt442] == 1;
            Enum_Sub2.repaintComponent(var4);
            return 1;
        }
        if (var0 == 1120) {
            Class49.anInt442 -= 2;
            var4.viewportWidth = intStack[Class49.anInt442];
            var4.viewportHeight = intStack[Class49.anInt442 + 1];
            Enum_Sub2.repaintComponent(var4);
            if (var3 != -1 && var4.type == 0) {
                GameEngine.method925(AssociateComparator_Sub5.interfaces[var3 >> 16], var4, false);
            }

            return 1;
        }
        if (var0 == 1121) {
            Class135.writeDialogActionPacket(var4.uid, var4.componentIndex);
            client.pleaseWaitComponent = var4;
            Enum_Sub2.repaintComponent(var4);
            return 1;
        }
        if (var0 == 1122) {
            var4.enabledMaterialId = intStack[--Class49.anInt442];
            Enum_Sub2.repaintComponent(var4);
            return 1;
        }
        if (var0 == 1123) {
            var4.anInt1348 = intStack[--Class49.anInt442];
            Enum_Sub2.repaintComponent(var4);
            return 1;
        }
        if (var0 == 1124) {
            var4.anInt1343 = intStack[--Class49.anInt442];
            Enum_Sub2.repaintComponent(var4);
            return 1;
        }
        if (var0 == 1125) {
            var8 = intStack[--Class49.anInt442];
            Enum_Sub11 var7 = (Enum_Sub11) OldConnection.method716(Enum_Sub11.method449(), var8);
            if (var7 != null) {
                var4.anEnum_Sub11_1349 = var7;
                Enum_Sub2.repaintComponent(var4);
            }

            return 1;
        }
        boolean var5;
        if (var0 == 1126) {
            var5 = intStack[--Class49.anInt442] == 1;
            var4.aBoolean1360 = var5;
            return 1;
        }
        if (var0 == 1127) {
            var5 = intStack[--Class49.anInt442] == 1;
            var4.aBoolean1359 = var5;
            return 1;
        }
        return 2;
    }

    static int method1352(int var0, boolean var2) {
        InterfaceComponent var3 = var2 ? Class74.anInterfaceComponent585 : DoublyLinkedNode_Sub21.anInterfaceComponent1518;
        if (var0 == 1800) {
            intStack[++Class49.anInt442 - 1] = Class87.getComponentSpellTargets(InterfaceComponent.getConfig(var3));
            return 1;
        }
        if (var0 != 1801) {
            if (var0 == 1802) {
                if (var3.name == null) {
                    stringStack[++Class49.anInt441 - 1] = "";
                } else {
                    stringStack[++Class49.anInt441 - 1] = var3.name;
                }

                return 1;
            }
            return 2;
        }
        int var4 = intStack[--Class49.anInt442];
        --var4;
        if (var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
            stringStack[++Class49.anInt441 - 1] = var3.actions[var4];
        } else {
            stringStack[++Class49.anInt441 - 1] = "";
        }

        return 1;
    }

    static int method1095(int var0, boolean var2) {
        InterfaceComponent var3 = var2 ? Class74.anInterfaceComponent585 : DoublyLinkedNode_Sub21.anInterfaceComponent1518;
        if (var0 == 1700) {
            intStack[++Class49.anInt442 - 1] = var3.itemId;
            return 1;
        }
        if (var0 == 1701) {
            if (var3.itemId != -1) {
                intStack[++Class49.anInt442 - 1] = var3.itemStackSize;
            } else {
                intStack[++Class49.anInt442 - 1] = 0;
            }

            return 1;
        }
        if (var0 == 1702) {
            intStack[++Class49.anInt442 - 1] = var3.componentIndex;
            return 1;
        }
        return 2;
    }

    static int method717(int var0, boolean var2) {
        InterfaceComponent var3 = var2 ? Class74.anInterfaceComponent585 : DoublyLinkedNode_Sub21.anInterfaceComponent1518;
        if (var0 == 1600) {
            intStack[++Class49.anInt442 - 1] = var3.insetX;
            return 1;
        }
        if (var0 == 1601) {
            intStack[++Class49.anInt442 - 1] = var3.insetY;
            return 1;
        }
        if (var0 == 1602) {
            stringStack[++Class49.anInt441 - 1] = var3.text;
            return 1;
        }
        if (var0 == 1603) {
            intStack[++Class49.anInt442 - 1] = var3.viewportWidth;
            return 1;
        }
        if (var0 == 1604) {
            intStack[++Class49.anInt442 - 1] = var3.viewportHeight;
            return 1;
        }
        if (var0 == 1605) {
            intStack[++Class49.anInt442 - 1] = var3.modelZoom;
            return 1;
        }
        if (var0 == 1606) {
            intStack[++Class49.anInt442 - 1] = var3.xRotation;
            return 1;
        }
        if (var0 == 1607) {
            intStack[++Class49.anInt442 - 1] = var3.yRotation;
            return 1;
        }
        if (var0 == 1608) {
            intStack[++Class49.anInt442 - 1] = var3.zRotation;
            return 1;
        }
        if (var0 == 1609) {
            intStack[++Class49.anInt442 - 1] = var3.alpha;
            return 1;
        }
        if (var0 == 1610) {
            intStack[++Class49.anInt442 - 1] = var3.anInt1343;
            return 1;
        }
        if (var0 == 1611) {
            intStack[++Class49.anInt442 - 1] = var3.textColor;
            return 1;
        }
        if (var0 == 1612) {
            intStack[++Class49.anInt442 - 1] = var3.anInt1348;
            return 1;
        }
        if (var0 == 1613) {
            intStack[++Class49.anInt442 - 1] = var3.anEnum_Sub11_1349.getOrdinal();
            return 1;
        }
        if (var0 == 1614) {
            intStack[++Class49.anInt442 - 1] = var3.aBoolean1359 ? 1 : 0;
            return 1;
        }
        return 2;
    }

    static int method1184(int var0, boolean var2) {
        InterfaceComponent var3 = var2 ? Class74.anInterfaceComponent585 : DoublyLinkedNode_Sub21.anInterfaceComponent1518;
        if (var0 == 1500) {
            intStack[++Class49.anInt442 - 1] = var3.relativeX;
            return 1;
        }
        if (var0 == 1501) {
            intStack[++Class49.anInt442 - 1] = var3.relativeY;
            return 1;
        }
        if (var0 == 1502) {
            intStack[++Class49.anInt442 - 1] = var3.width;
            return 1;
        }
        if (var0 == 1503) {
            intStack[++Class49.anInt442 - 1] = var3.height;
            return 1;
        }
        if (var0 == 1504) {
            intStack[++Class49.anInt442 - 1] = var3.explicitlyHidden ? 1 : 0;
            return 1;
        }
        if (var0 == 1505) {
            intStack[++Class49.anInt442 - 1] = var3.parentUid;
            return 1;
        }
        return 2;
    }

    static int process(int opcode, boolean var2) {
        if (opcode < 1000) {
            return method384(opcode, var2);
        }
        if (opcode < 1100) {
            return method323(opcode, var2);
        }
        if (opcode < 1200) {
            return method386(opcode, var2);
        }
        if (opcode < 1300) {
            return method484(opcode, var2);
        }
        if (opcode < 1400) {
            return method120(opcode, var2);
        }
        if (opcode < 1500) {
            return method266(opcode, var2);
        }
        if (opcode < 1600) {
            return method1184(opcode, var2);
        }
        if (opcode < 1700) {
            return method717(opcode, var2);
        }
        if (opcode < 1800) {
            return method1095(opcode, var2);
        }
        if (opcode < 1900) {
            return method1352(opcode, var2);
        }
        if (opcode < 2000) {
            return method3(opcode, var2);
        }
        if (opcode < 2100) {
            return method323(opcode, var2);
        }
        if (opcode < 2200) {
            return method386(opcode, var2);
        }
        if (opcode < 2300) {
            return method484(opcode, var2);
        }
        if (opcode < 2400) {
            return method120(opcode, var2);
        }
        if (opcode < 2500) {
            return method266(opcode, var2);
        }
        if (opcode < 2600) {
            return method218(opcode);
        }
        if (opcode < 2700) {
            return method739(opcode);
        }
        if (opcode < 2800) {
            return method720(opcode);
        }
        if (opcode < 2900) {
            return method32(opcode);
        }
        if (opcode < 3000) {
            return method3(opcode, var2);
        }
        if (opcode < 3200) {
            return method361(opcode, var2);
        }
        if (opcode < 3300) {
            return method556(opcode);
        }
        if (opcode < 3400) {
            return method132(opcode);
        }
        if (opcode < 3500) {
            return method1393(opcode);
        }
        if (opcode < 3700) {
            return method875(opcode);
        }
        if (opcode < 4000) {
            return method356(opcode);
        }
        if (opcode < 4100) {
            return method174(opcode);
        }
        if (opcode < 4200) {
            return method472(opcode);
        }
        if (opcode < 4300) {
            return method953(opcode);
        }
        if (opcode < 5100) {
            return method268(opcode);
        }
        if (opcode < 5400) {
            return method641(opcode);
        }
        if (opcode < 5600) {
            return method105(opcode);
        }
        if (opcode < 5700) {
            return method954(opcode);
        }
        if (opcode < 6300) {
            return method7(opcode);
        }
        if (opcode < 6600) {
            return method889(opcode);
        }
        return opcode < 6700 ? AssociateComparatorByName.method718(opcode) : 2;
    }

    public void method1304(Object[] var1) {
        this.args = var1;
    }

    public void method1193(int var1) {
        this.anInt367 = var1;
    }
}
