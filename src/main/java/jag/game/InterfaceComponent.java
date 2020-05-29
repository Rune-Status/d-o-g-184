package jag.game;

import jag.ComponentFillType;
import jag.graphics.NamedFont;
import jag.opcode.OldConnectionTaskProcessor;
import jag.SerializableLong;
import jag.commons.collection.IntegerNode;
import jag.commons.collection.Node;
import jag.commons.collection.ReferenceCache;
import jag.commons.input.Mouse;
import jag.game.option.ClientPreferences;
import jag.game.relationship.ClanMember;
import jag.game.scene.CameraCapture;
import jag.game.scene.entity.Model;
import jag.game.scene.entity.Projectile;
import jag.game.scene.entity.UnlitModel;
import jag.game.stockmarket.StockMarketOffer;
import jag.game.type.AnimationSequence;
import jag.game.type.ItemDefinition;
import jag.game.type.NpcDefinition;
import jag.graphics.Font;
import jag.graphics.Sprite;
import jag.graphics.SpriteClip;
import jag.js5.ReferenceTable;
import jag.opcode.*;
import jag.script.ScriptEvent;
import jag.statics.Statics2;
import jag.statics.Statics21;
import jag.statics.Statics23;
import jag.statics.Statics48;
import jag.worldmap.WorldMapIcon_Sub1;

public class InterfaceComponent extends Node {
    public static final ReferenceCache aReferenceCache1370;
    public static final ReferenceCache aReferenceCache1367;
    public static final ReferenceCache aReferenceCache1364;
    public static final ReferenceCache aReferenceCache1374;
    public static boolean aBoolean1151;
    public static ReferenceTable aReferenceTable1375;

    static {
        aReferenceCache1370 = new ReferenceCache(200);
        aReferenceCache1364 = new ReferenceCache(50);
        aReferenceCache1367 = new ReferenceCache(20);
        aReferenceCache1374 = new ReferenceCache(8);
        aBoolean1151 = false;
    }

    public int enabledMaterialId;
    public String[] actions;
    public int buttonType;
    public int parentUid;
    public int[] itemIds;
    public boolean aBoolean562;
    public int renderCycle;
    public String toolTip;
    public int fontId;
    public int[] anIntArray1371;
    public int materialId;
    public int modelType;
    public int width;
    public int uid;
    public int modelId;
    public boolean aBoolean1378;
    public int type;
    public int height;
    public boolean flippedVertically;
    public int shadowColor;
    public int boundsIndex;
    public boolean flippedHorizontally;
    public int componentIndex;
    public int xLayout;
    public int anInt1369;
    public int borderThickness;
    public int[] itemStackSizes;
    public int xMargin;
    public int anInt694;
    public int relativeX;
    public int contentType;
    public int anInt695;
    public int yLayout;
    public int relativeY;
    public int yMargin;
    public int anInt1105;
    public String selectedAction;
    public boolean explicitlyHidden;
    public int anInt711;
    public int anInt1357;
    public int itemId;
    public boolean aBoolean1372;
    public int anInt709;
    public int anInt1353;
    public int[] anIntArray1392;
    public InterfaceComponent[] components;
    public Object[] mousePressListeners;
    public int anInt1351;
    public int config;
    public String spellName;
    public int[] anIntArray1395;
    public int[][] functionOpcodes;
    public boolean aBoolean1412;
    public int xRotation;
    public int alpha;
    public boolean aBoolean1410;
    public int anInt1401;
    public int zRotation;
    public Object[] anObjectArray1400;
    public int xPadding;
    public int yPadding;
    public int anInt1389;
    public int[] xSprites;
    public int anInt1402;
    public int insetX;
    public int insetY;
    public int[] ySprites;
    public String name;
    public int viewportWidth;
    public boolean aBoolean1404;
    public int viewportHeight;
    public int anInt1381;
    public Object[] scrollListeners;
    public int textColor;
    public int anInt1383;
    public int anInt1348;
    public int anInt1345;
    public int anInt1344;
    public boolean aBoolean1409;
    public boolean aBoolean1346;
    public ComponentFillType anComponentFillType_1349;
    public byte[][] aByteArrayArray1365;
    public int anInt1343;
    public int anInt1347;
    public boolean aBoolean1360;
    public int[] anIntArray1361;
    public Object[] dragListeners;
    public int[] anIntArray1405;
    public Object[] anObjectArray1380;
    public int spriteId;
    public boolean aBoolean1358;
    public int[] anIntArray1366;
    public int horizontalMargin;
    public Object[] anObjectArray1387;
    public int verticalMargin;
    public byte[][] aByteArrayArray1363;
    public Object[] anObjectArray1377;
    public int textSpacing;
    public boolean aBoolean1388;
    public int modelOffsetX;
    public int modelOffsetY;
    public int yRotation;
    public int modelZoom;
    public int anInt1354;
    public boolean textShadowed;
    public boolean aBoolean1352;
    public boolean aBoolean1359;
    public String text;
    public int anInt1356;
    public int itemStackSize;
    public String aString1373;
    public String[] tableActions;
    public InterfaceComponent parent;
    public boolean aBoolean1407;
    public Object[] anObjectArray1386;
    public Object[] anObjectArray1379;
    public Object[] anObjectArray1376;
    public Object[] mouseEnterListeners;
    public int anInt1406;
    public Object[] mouseExitListeners;
    public int anInt1413;
    public Object[] anObjectArray1385;
    public Object[] configListenerArgs;
    public int anInt1408;
    public Object[] renderListeners;
    public int[] configTriggers;
    public int anInt1411;
    public Object[] anObjectArray1384;
    public Object[] hoverListeners;
    public Object[] tableListenerArgs;
    public Object[] skillListenerArgs;
    public int[] itemTriggers;
    public int[] skillTriggers;
    public Object[] anObjectArray1403;
    public Object[] anObjectArray1398;
    public Object[] anObjectArray1399;
    public Object[] anObjectArray1396;
    public Object[] anObjectArray1390;
    public Object[] anObjectArray1397;
    public Object[] anObjectArray1393;
    public Object[] anObjectArray1391;
    public Object[] anObjectArray1394;
    int anInt1355;
    int anInt1350;

    public InterfaceComponent() {
        this.aBoolean562 = false;
        this.uid = -1;
        this.componentIndex = -1;
        this.buttonType = 0;
        this.contentType = 0;
        this.xLayout = 0;
        this.yLayout = 0;
        this.anInt1369 = 0;
        this.anInt695 = 0;
        this.xMargin = 0;
        this.yMargin = 0;
        this.anInt694 = 0;
        this.anInt1105 = 0;
        this.relativeX = 0;
        this.relativeY = 0;
        this.width = 0;
        this.height = 0;
        this.anInt711 = 1;
        this.anInt709 = 1;
        this.parentUid = -1;
        this.explicitlyHidden = false;
        this.insetX = 0;
        this.insetY = 0;
        this.viewportWidth = 0;
        this.viewportHeight = 0;
        this.textColor = 0;
        this.anInt1348 = 0;
        this.anInt1345 = 0;
        this.anInt1344 = 0;
        this.aBoolean1346 = false;
        this.anComponentFillType_1349 = ComponentFillType.anEnum_Sub11_1862;
        this.alpha = 0;
        this.anInt1343 = 0;
        this.anInt1347 = 1;
        this.aBoolean1360 = false;
        this.materialId = -1;
        this.enabledMaterialId = -1;
        this.spriteId = 0;
        this.aBoolean1358 = false;
        this.borderThickness = 0;
        this.shadowColor = 0;
        this.modelType = 1;
        this.modelId = -1;
        this.anInt1355 = 1;
        this.anInt1350 = -1;
        this.anInt1357 = -1;
        this.anInt1353 = -1;
        this.modelOffsetX = 0;
        this.modelOffsetY = 0;
        this.xRotation = 0;
        this.zRotation = 0;
        this.yRotation = 0;
        this.modelZoom = 100;
        this.anInt1354 = 0;
        this.anInt1351 = 0;
        this.aBoolean1352 = false;
        this.aBoolean1359 = false;
        this.anInt1356 = 2;
        this.fontId = -1;
        this.text = "";
        this.aString1373 = "";
        this.textSpacing = 0;
        this.horizontalMargin = 0;
        this.verticalMargin = 0;
        this.textShadowed = false;
        this.xPadding = 0;
        this.yPadding = 0;
        this.config = 0;
        this.aBoolean1372 = false;
        this.name = "";
        this.parent = null;
        this.anInt1381 = 0;
        this.anInt1383 = 0;
        this.aBoolean1388 = false;
        this.selectedAction = "";
        this.aBoolean1378 = false;
        this.anInt1402 = -1;
        this.spellName = "";
        this.toolTip = "Ok";
        this.itemId = -1;
        this.itemStackSize = 0;
        this.anInt1389 = 0;
        this.anInt1401 = 0;
        this.aBoolean1404 = false;
        this.aBoolean1407 = false;
        this.anInt1406 = -1;
        this.anInt1413 = 0;
        this.anInt1408 = 0;
        this.anInt1411 = 0;
        this.boundsIndex = -1;
        this.renderCycle = -1;
        this.aBoolean1412 = false;
        this.aBoolean1410 = false;
        this.aBoolean1409 = false;
    }

    public static InterfaceComponent lookup(int uid, int subcomponent) {
        InterfaceComponent var2 = lookup(uid);
        if (subcomponent == -1) {
            return var2;
        }
        return var2 != null && var2.components != null && subcomponent < var2.components.length ? var2.components[subcomponent] : null;
    }

    public static void closeInterface() {
        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.BUTTON_CLOSE_ACTION, client.connectionContext.encryptor);
        client.connectionContext.writeLater(packet);

        for (SubInterface var1 = client.subInterfaces.head(); var1 != null; var1 = client.subInterfaces.next()) {
            if (var1.state == 0 || var1.state == 3) {
                NamedFont.method1182(var1, true);
            }
        }

        if (client.pleaseWaitComponent != null) {
            repaint(client.pleaseWaitComponent);
            client.pleaseWaitComponent = null;
        }

    }

    public static InterfaceComponent lookup(int uid) {
        int var1 = uid >> 16;
        int var2 = uid & 65535;
        if (client.interfaces[var1] == null || client.interfaces[var1][var2] == null) {
            boolean var3 = load(var1);
            if (!var3) {
                return null;
            }
        }

        return client.interfaces[var1][var2];
    }

    public static InterfaceComponent getTopLevelComponent(InterfaceComponent src) {
        int depth = getScriptEventDepth(getConfig(src));
        if (depth == 0) {
            return null;
        }
        for (int var2 = 0; var2 < depth; ++var2) {
            src = lookup(src.parentUid);
            if (src == null) {
                return null;
            }
        }

        return src;
    }

    public static int getScriptEventDepth(int config) {
        return config >> 17 & 7;
    }

    public static int getConfig(InterfaceComponent component) {
        IntegerNode node = client.interfaceConfigs.lookup(((long) component.uid << 32) + (long) component.componentIndex);
        return node != null ? node.value : component.config;
    }

    public static void renderInterface(int group,
            int minX, int minY,
            int maxX, int maxY,
            int parentX, int parentY,
            int boundsIndex) {
        if (load(group)) {
            StockMarketOffer.draggingInterface = null;
            ScriptEvent.renderComponents(client.interfaces[group], -1, minX, minY, maxX, maxY, parentX, parentY, boundsIndex);
            if (StockMarketOffer.draggingInterface != null) {
                ScriptEvent.renderComponents(StockMarketOffer.draggingInterface, -1412584499, minX, minY, maxX, maxY, Statics23.anInt1342, CameraCapture.anInt1913, boundsIndex);
                StockMarketOffer.draggingInterface = null;
            }

        } else {
            if (boundsIndex != -1) {
                client.renderedComponents[boundsIndex] = true;
            } else {
                for (int var8 = 0; var8 < 100; ++var8) {
                    client.renderedComponents[var8] = true;
                }
            }

        }
    }

    public static String method1005(String var0, InterfaceComponent var1) {
        if (var0.contains("%")) {
            for (int var2 = 1; var2 <= 5; ++var2) {
                while (true) {
                    int var3 = var0.indexOf("%" + var2);
                    if (var3 == -1) {
                        break;
                    }

                    String var4 = var0.substring(0, var3);
                    int var5 = Statics21.method922(var1, var2 - 1);
                    String var6;
                    if (var5 < 999999999) {
                        var6 = Integer.toString(var5);
                    } else {
                        var6 = "*";
                    }

                    var0 = var4 + var6 + var0.substring(var3 + 2);
                }
            }
        }

        return var0;
    }

    public static void method513(InterfaceComponent[] var0, int var1) {
        for (InterfaceComponent var3 : var0) {
            if (var3 != null && var3.parentUid == var1 && (!var3.aBoolean562 || !isExplicitlyHidden(var3))) {
                int var5;
                if (var3.type == 0) {
                    if (!var3.aBoolean562 && isExplicitlyHidden(var3) && var3 != OldConnection.anInterfaceComponent873) {
                        continue;
                    }

                    method513(var0, var3.uid);
                    if (var3.components != null) {
                        method513(var3.components, var3.uid);
                    }

                    SubInterface var7 = client.subInterfaces.lookup(var3.uid);
                    if (var7 != null) {
                        var5 = var7.id;
                        if (load(var5)) {
                            method513(client.interfaces[var5], -1);
                        }
                    }
                }

                if (var3.type == 6) {
                    if (var3.anInt1357 != -1 || var3.anInt1353 != -1) {
                        boolean var4 = Projectile.method1192(var3);
                        if (var4) {
                            var5 = var3.anInt1353;
                        } else {
                            var5 = var3.anInt1357;
                        }

                        if (var5 != -1) {
                            AnimationSequence var6 = AnimationSequence.get(var5);

                            for (var3.anInt1401 += client.anInt972; var3.anInt1401 > var6.frameLengths[var3.anInt1389]; repaint(var3)) {
                                var3.anInt1401 -= var6.frameLengths[var3.anInt1389];
                                ++var3.anInt1389;
                                if (var3.anInt1389 >= var6.frameIds.length) {
                                    var3.anInt1389 -= var6.loopOffset;
                                    if (var3.anInt1389 < 0 || var3.anInt1389 >= var6.frameIds.length) {
                                        var3.anInt1389 = 0;
                                    }
                                }
                            }
                        }
                    }

                    if (var3.anInt1351 != 0 && !var3.aBoolean562) {
                        int var8 = var3.anInt1351 >> 16;
                        var5 = var3.anInt1351 << 16 >> 16;
                        var8 *= client.anInt972;
                        var5 *= client.anInt972;
                        var3.xRotation = var8 + var3.xRotation & 2047;
                        var3.zRotation = var5 + var3.zRotation & 2047;
                        repaint(var3);
                    }
                }
            }
        }

    }

    public static void method830(int var0) {
        if (var0 != -1) {
            if (Statics2.validInterfaces[var0]) {
                aReferenceTable1375.method914(var0);
                if (client.interfaces[var0] != null) {
                    boolean var1 = true;

                    for (int var2 = 0; var2 < client.interfaces[var0].length; ++var2) {
                        if (client.interfaces[var0][var2] != null) {
                            if (client.interfaces[var0][var2].type != 2) {
                                client.interfaces[var0][var2] = null;
                            } else {
                                var1 = false;
                            }
                        }
                    }

                    if (var1) {
                        client.interfaces[var0] = null;
                    }

                    Statics2.validInterfaces[var0] = false;
                }
            }
        }
    }

    public static boolean load(int var0) {
        if (Statics2.validInterfaces[var0]) {
            return true;
        }
        if (!aReferenceTable1375.method911(var0)) {
            return false;
        }
        int var1 = aReferenceTable1375.method901(var0);
        if (var1 == 0) {
            Statics2.validInterfaces[var0] = true;
            return true;
        }
        if (client.interfaces[var0] == null) {
            client.interfaces[var0] = new InterfaceComponent[var1];
        }

        for (int var2 = 0; var2 < var1; ++var2) {
            if (client.interfaces[var0][var2] == null) {
                byte[] var3 = aReferenceTable1375.unpack(var0, var2);
                if (var3 != null) {
                    client.interfaces[var0][var2] = new InterfaceComponent();
                    client.interfaces[var0][var2].uid = var2 + (var0 << 16);
                    if (var3[0] == -1) {
                        client.interfaces[var0][var2].method963(new Buffer(var3));
                    } else {
                        client.interfaces[var0][var2].method962(new Buffer(var3));
                    }
                }
            }
        }

        Statics2.validInterfaces[var0] = true;
        return true;
    }

    public static void method146(int var0) {
        if (load(var0)) {
            InterfaceComponent[] var1 = client.interfaces[var0];

            for (InterfaceComponent var3 : var1) {
                if (var3 != null) {
                    var3.anInt1389 = 0;
                    var3.anInt1401 = 0;
                }
            }

        }
    }

    public static void repaint(InterfaceComponent var0) {
        if (var0.renderCycle == client.anInt1084) {
            client.renderedComponents[var0.boundsIndex] = true;
        }

    }

    public static void method118(int var0, int var1) {
        if (load(var0)) {
            MouseRecorder.method265(client.interfaces[var0], var1);
        }
    }

    public static void processAction(int actionIndex, int uid, int subcomponent, int itemId, String actionText) {
        InterfaceComponent component = lookup(uid, subcomponent);
        if (component != null) {
            if (component.mousePressListeners != null) {
                ScriptEvent event = new ScriptEvent();
                event.source = component;
                event.actionIndex = actionIndex;
                event.opbase = actionText;
                event.args = component.mousePressListeners;
                ScriptEvent.fire(event);
            }

            boolean var7 = true;
            if (component.contentType > 0) {
                var7 = Statics48.isAppearanceCode(component);
            }

            if (var7) {
                int config = getConfig(component);
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

    public static void method177(InterfaceComponent var0, int var1, int var2, int var3, int var4, int var5, int var6) {
        if (client.aBoolean984) {
            client.anInt976 = 32;
        } else {
            client.anInt976 = 0;
        }

        client.aBoolean984 = false;
        int var7;
        if (Mouse.pressMeta == 1 || !WorldMapIcon_Sub1.aBoolean492 && Mouse.pressMeta == 4) {
            if (var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
                var0.insetY -= 4;
                repaint(var0);
            } else if (var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
                var0.insetY += 4;
                repaint(var0);
            } else if (var5 >= var1 - client.anInt976 && var5 < client.anInt976 + var1 + 16 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
                var7 = var3 * (var3 - 32) / var4;
                if (var7 < 8) {
                    var7 = 8;
                }

                int var8 = var6 - var2 - 16 - var7 / 2;
                int var9 = var3 - 32 - var7;
                var0.insetY = var8 * (var4 - var3) / var9;
                repaint(var0);
                client.aBoolean984 = true;
            }
        }

        if (client.anInt1086 != 0) {
            var7 = var0.width;
            if (var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
                var0.insetY += client.anInt1086 * 45;
                repaint(var0);
            }
        }

    }

    public static void method728(InterfaceComponent var0, int var1, int var2, boolean var3) {
        int var4 = var0.width;
        int var5 = var0.height;
        if (var0.anInt1369 == 0) {
            var0.width = var0.anInt694;
        } else if (var0.anInt1369 == 1) {
            var0.width = var1 - var0.anInt694;
        } else if (var0.anInt1369 == 2) {
            var0.width = var0.anInt694 * var1 >> 14;
        }

        if (var0.anInt695 == 0) {
            var0.height = var0.anInt1105;
        } else if (var0.anInt695 == 1) {
            var0.height = var2 - var0.anInt1105;
        } else if (var0.anInt695 == 2) {
            var0.height = var2 * var0.anInt1105 >> 14;
        }

        if (var0.anInt1369 == 4) {
            var0.width = var0.anInt711 * var0.height / var0.anInt709;
        }

        if (var0.anInt695 == 4) {
            var0.height = var0.anInt709 * var0.width / var0.anInt711;
        }

        if (var0.contentType == 1337) {
            client.minimapComponent = var0;
        }

        if (var3 && var0.anObjectArray1400 != null && (var4 != var0.width || var5 != var0.height)) {
            ScriptEvent var6 = new ScriptEvent();
            var6.source = var0;
            var6.args = var0.anObjectArray1400;
            client.aNodeDeque1082.add(var6);
        }

    }

    public static boolean isExplicitlyHidden(InterfaceComponent component) {
        return component.explicitlyHidden;
    }

    public static void method185(InterfaceComponent var0, int var1, int var2) {
        if (var0.xLayout == 0) {
            var0.relativeX = var0.xMargin;
        } else if (var0.xLayout == 1) {
            var0.relativeX = var0.xMargin + (var1 - var0.width) / 2;
        } else if (var0.xLayout == 2) {
            var0.relativeX = var1 - var0.width - var0.xMargin;
        } else if (var0.xLayout == 3) {
            var0.relativeX = var0.xMargin * var1 >> 14;
        } else if (var0.xLayout == 4) {
            var0.relativeX = (var1 - var0.width) / 2 + (var0.xMargin * var1 >> 14);
        } else {
            var0.relativeX = var1 - var0.width - (var0.xMargin * var1 >> 14);
        }

        if (var0.yLayout == 0) {
            var0.relativeY = var0.yMargin;
        } else if (var0.yLayout == 1) {
            var0.relativeY = (var2 - var0.height) / 2 + var0.yMargin;
        } else if (var0.yLayout == 2) {
            var0.relativeY = var2 - var0.height - var0.yMargin;
        } else if (var0.yLayout == 3) {
            var0.relativeY = var2 * var0.yMargin >> 14;
        } else if (var0.yLayout == 4) {
            var0.relativeY = (var2 * var0.yMargin >> 14) + (var2 - var0.height) / 2;
        } else {
            var0.relativeY = var2 - var0.height - (var2 * var0.yMargin >> 14);
        }

    }

    public static void method475(InterfaceComponent var0) {
        int var1 = var0.contentType;
        if (var1 == 324) {
            if (client.anInt930 == -1) {
                client.anInt930 = var0.materialId;
                client.anInt931 = var0.enabledMaterialId;
            }

            if (client.renderedAppearance.female) {
                var0.materialId = client.anInt930;
            } else {
                var0.materialId = client.anInt931;
            }

        } else if (var1 == 325) {
            if (client.anInt930 == -1) {
                client.anInt930 = var0.materialId;
                client.anInt931 = var0.enabledMaterialId;
            }

            if (client.renderedAppearance.female) {
                var0.materialId = client.anInt931;
            } else {
                var0.materialId = client.anInt930;
            }

        } else if (var1 == 327) {
            var0.xRotation = 150;
            var0.zRotation = (int) (Math.sin((double) client.engineCycle / 40.0D) * 256.0D) & 2047;
            var0.modelType = 5;
            var0.modelId = 0;
        } else if (var1 == 328) {
            var0.xRotation = 150;
            var0.zRotation = (int) (Math.sin((double) client.engineCycle / 40.0D) * 256.0D) & 2047;
            var0.modelType = 5;
            var0.modelId = 1;
        }
    }

    public static void method610(InterfaceComponent[] var0, int var1, int var2, int var3, boolean var4) {
        for (InterfaceComponent var6 : var0) {
            if (var6 != null && var6.parentUid == var1) {
                method728(var6, var2, var3, var4);
                method185(var6, var2, var3);
                if (var6.insetX > var6.viewportWidth - var6.width) {
                    var6.insetX = var6.viewportWidth - var6.width;
                }

                if (var6.insetX < 0) {
                    var6.insetX = 0;
                }

                if (var6.insetY > var6.viewportHeight - var6.height) {
                    var6.insetY = var6.viewportHeight - var6.height;
                }

                if (var6.insetY < 0) {
                    var6.insetY = 0;
                }

                if (var6.type == 0) {
                    GameEngine.method925(var0, var6, var4);
                }
            }
        }

    }

    public static String method612(InterfaceComponent var0, int var1) {
        int var2 = getConfig(var0);
        boolean var3 = (var2 >> var1 + 1 & 1) != 0;
        if (!var3 && var0.mousePressListeners == null) {
            return null;
        }
        return var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0 ? var0.actions[var1] : null;
    }

    public Sprite method958(boolean var1) {
        aBoolean1151 = false;
        int var2;
        if (var1) {
            var2 = this.enabledMaterialId;
        } else {
            var2 = this.materialId;
        }

        if (var2 == -1) {
            return null;
        }
        long var3 = ((long) this.shadowColor << 40) + ((this.flippedHorizontally ? 1L : 0L) << 39) + (long) var2 + ((long) this.borderThickness << 36) + ((this.flippedVertically ? 1L : 0L) << 38);
        Sprite var5 = (Sprite) aReferenceCache1370.get(var3);
        if (var5 != null) {
            return var5;
        }
        var5 = Sprite.get(ClientPreferences.aReferenceTable364, var2, 0);
        if (var5 == null) {
            aBoolean1151 = true;
            return null;
        }
        if (this.flippedVertically) {
            var5.method828();
        }

        if (this.flippedHorizontally) {
            var5.method827();
        }

        if (this.borderThickness > 0) {
            var5.method830(this.borderThickness);
        }

        if (this.borderThickness >= 1) {
            var5.method822(1);
        }

        if (this.borderThickness >= 2) {
            var5.method822(16777215);
        }

        if (this.shadowColor != 0) {
            var5.method835(this.shadowColor);
        }

        aReferenceCache1370.put(var5, var3);
        return var5;
    }

    public void method962(Buffer var1) {
        this.aBoolean562 = false;
        this.type = var1.readUByte();
        this.buttonType = var1.readUByte();
        this.contentType = var1.readUShort();
        this.xMargin = var1.method1029();
        this.yMargin = var1.method1029();
        this.anInt694 = var1.readUShort();
        this.anInt1105 = var1.readUShort();
        this.alpha = var1.readUByte();
        this.parentUid = var1.readUShort();
        if (this.parentUid == 65535) {
            this.parentUid = -1;
        } else {
            this.parentUid += this.uid & -65536;
        }

        this.anInt1402 = var1.readUShort();
        if (this.anInt1402 == 65535) {
            this.anInt1402 = -1;
        }

        int var2 = var1.readUByte();
        int var3;
        if (var2 > 0) {
            this.anIntArray1392 = new int[var2];
            this.anIntArray1395 = new int[var2];

            for (var3 = 0; var3 < var2; ++var3) {
                this.anIntArray1392[var3] = var1.readUByte();
                this.anIntArray1395[var3] = var1.readUShort();
            }
        }

        var3 = var1.readUByte();
        int var4;
        int var5;
        int var6;
        if (var3 > 0) {
            this.functionOpcodes = new int[var3][];

            for (var4 = 0; var4 < var3; ++var4) {
                var5 = var1.readUShort();
                this.functionOpcodes[var4] = new int[var5];

                for (var6 = 0; var6 < var5; ++var6) {
                    this.functionOpcodes[var4][var6] = var1.readUShort();
                    if (this.functionOpcodes[var4][var6] == 65535) {
                        this.functionOpcodes[var4][var6] = -1;
                    }
                }
            }
        }

        if (this.type == 0) {
            this.viewportHeight = var1.readUShort();
            this.explicitlyHidden = var1.readUByte() == 1;
        }

        if (this.type == 1) {
            var1.readUShort();
            var1.readUByte();
        }

        if (this.type == 2) {
            this.itemIds = new int[this.anInt694 * this.anInt1105];
            this.itemStackSizes = new int[this.anInt1105 * this.anInt694];
            var4 = var1.readUByte();
            if (var4 == 1) {
                this.config |= 268435456;
            }

            var5 = var1.readUByte();
            if (var5 == 1) {
                this.config |= 1073741824;
            }

            var6 = var1.readUByte();
            if (var6 == 1) {
                this.config |= Integer.MIN_VALUE;
            }

            int var7 = var1.readUByte();
            if (var7 == 1) {
                this.config |= 536870912;
            }

            this.xPadding = var1.readUByte();
            this.yPadding = var1.readUByte();
            this.xSprites = new int[20];
            this.ySprites = new int[20];
            this.anIntArray1371 = new int[20];

            int var8;
            for (var8 = 0; var8 < 20; ++var8) {
                int var9 = var1.readUByte();
                if (var9 == 1) {
                    this.xSprites[var8] = var1.method1029();
                    this.ySprites[var8] = var1.method1029();
                    this.anIntArray1371[var8] = var1.readInt();
                } else {
                    this.anIntArray1371[var8] = -1;
                }
            }

            this.tableActions = new String[5];

            for (var8 = 0; var8 < 5; ++var8) {
                String var11 = var1.readString();
                if (var11.length() > 0) {
                    this.tableActions[var8] = var11;
                    this.config |= 1 << var8 + 23;
                }
            }
        }

        if (this.type == 3) {
            this.aBoolean1346 = var1.readUByte() == 1;
        }

        if (this.type == 4 || this.type == 1) {
            this.horizontalMargin = var1.readUByte();
            this.verticalMargin = var1.readUByte();
            this.textSpacing = var1.readUByte();
            this.fontId = var1.readUShort();
            if (this.fontId == 65535) {
                this.fontId = -1;
            }

            this.textShadowed = var1.readUByte() == 1;
        }

        if (this.type == 4) {
            this.text = var1.readString();
            this.aString1373 = var1.readString();
        }

        if (this.type == 1 || this.type == 3 || this.type == 4) {
            this.textColor = var1.readInt();
        }

        if (this.type == 3 || this.type == 4) {
            this.anInt1348 = var1.readInt();
            this.anInt1345 = var1.readInt();
            this.anInt1344 = var1.readInt();
        }

        if (this.type == 5) {
            this.materialId = var1.readInt();
            this.enabledMaterialId = var1.readInt();
        }

        if (this.type == 6) {
            this.modelType = 1;
            this.modelId = var1.readUShort();
            if (this.modelId == 65535) {
                this.modelId = -1;
            }

            this.anInt1355 = 1;
            this.anInt1350 = var1.readUShort();
            if (this.anInt1350 == 65535) {
                this.anInt1350 = -1;
            }

            this.anInt1357 = var1.readUShort();
            if (this.anInt1357 == 65535) {
                this.anInt1357 = -1;
            }

            this.anInt1353 = var1.readUShort();
            if (this.anInt1353 == 65535) {
                this.anInt1353 = -1;
            }

            this.modelZoom = var1.readUShort();
            this.xRotation = var1.readUShort();
            this.zRotation = var1.readUShort();
        }

        if (this.type == 7) {
            this.itemIds = new int[this.anInt1105 * this.anInt694];
            this.itemStackSizes = new int[this.anInt694 * this.anInt1105];
            this.horizontalMargin = var1.readUByte();
            this.fontId = var1.readUShort();
            if (this.fontId == 65535) {
                this.fontId = -1;
            }

            this.textShadowed = var1.readUByte() == 1;
            this.textColor = var1.readInt();
            this.xPadding = var1.method1029();
            this.yPadding = var1.method1029();
            var4 = var1.readUByte();
            if (var4 == 1) {
                this.config |= 1073741824;
            }

            this.tableActions = new String[5];

            for (var5 = 0; var5 < 5; ++var5) {
                String var10 = var1.readString();
                if (var10.length() > 0) {
                    this.tableActions[var5] = var10;
                    this.config |= 1 << var5 + 23;
                }
            }
        }

        if (this.type == 8) {
            this.text = var1.readString();
        }

        if (this.buttonType == 2 || this.type == 2) {
            this.selectedAction = var1.readString();
            this.spellName = var1.readString();
            var4 = var1.readUShort() & 63;
            this.config |= var4 << 11;
        }

        if (this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5 || this.buttonType == 6) {
            this.toolTip = var1.readString();
            if (this.toolTip.length() == 0) {
                if (this.buttonType == 1) {
                    this.toolTip = "Ok";
                }

                if (this.buttonType == 4) {
                    this.toolTip = "Select";
                }

                if (this.buttonType == 5) {
                    this.toolTip = "Select";
                }

                if (this.buttonType == 6) {
                    this.toolTip = "Continue";
                }
            }
        }

        if (this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5) {
            this.config |= 4194304;
        }

        if (this.buttonType == 6) {
            this.config |= 1;
        }

    }

    public void method963(Buffer var1) {
        var1.readUByte();
        this.aBoolean562 = true;
        this.type = var1.readUByte();
        this.contentType = var1.readUShort();
        this.xMargin = var1.method1029();
        this.yMargin = var1.method1029();
        this.anInt694 = var1.readUShort();
        if (this.type == 9) {
            this.anInt1105 = var1.method1029();
        } else {
            this.anInt1105 = var1.readUShort();
        }

        this.anInt1369 = var1.readByte();
        this.anInt695 = var1.readByte();
        this.xLayout = var1.readByte();
        this.yLayout = var1.readByte();
        this.parentUid = var1.readUShort();
        if (this.parentUid == 65535) {
            this.parentUid = -1;
        } else {
            this.parentUid += this.uid & -65536;
        }

        this.explicitlyHidden = var1.readUByte() == 1;
        if (this.type == 0) {
            this.viewportWidth = var1.readUShort();
            this.viewportHeight = var1.readUShort();
            this.aBoolean1412 = var1.readUByte() == 1;
        }

        if (this.type == 5) {
            this.materialId = var1.readInt();
            this.spriteId = var1.readUShort();
            this.aBoolean1358 = var1.readUByte() == 1;
            this.alpha = var1.readUByte();
            this.borderThickness = var1.readUByte();
            this.shadowColor = var1.readInt();
            this.flippedVertically = var1.readUByte() == 1;
            this.flippedHorizontally = var1.readUByte() == 1;
        }

        if (this.type == 6) {
            this.modelType = 1;
            this.modelId = var1.readUShort();
            if (this.modelId == 65535) {
                this.modelId = -1;
            }

            this.modelOffsetX = var1.method1029();
            this.modelOffsetY = var1.method1029();
            this.xRotation = var1.readUShort();
            this.zRotation = var1.readUShort();
            this.yRotation = var1.readUShort();
            this.modelZoom = var1.readUShort();
            this.anInt1357 = var1.readUShort();
            if (this.anInt1357 == 65535) {
                this.anInt1357 = -1;
            }

            this.aBoolean1352 = var1.readUByte() == 1;
            var1.readUShort();
            if (this.anInt1369 != 0) {
                this.anInt1354 = var1.readUShort();
            }

            if (this.anInt695 != 0) {
                var1.readUShort();
            }
        }

        if (this.type == 4) {
            this.fontId = var1.readUShort();
            if (this.fontId == 65535) {
                this.fontId = -1;
            }

            this.text = var1.readString();
            this.textSpacing = var1.readUByte();
            this.horizontalMargin = var1.readUByte();
            this.verticalMargin = var1.readUByte();
            this.textShadowed = var1.readUByte() == 1;
            this.textColor = var1.readInt();
        }

        if (this.type == 3) {
            this.textColor = var1.readInt();
            this.aBoolean1346 = var1.readUByte() == 1;
            this.alpha = var1.readUByte();
        }

        if (this.type == 9) {
            this.anInt1347 = var1.readUByte();
            this.textColor = var1.readInt();
            this.aBoolean1360 = var1.readUByte() == 1;
        }

        this.config = var1.readMediumInt();
        this.name = var1.readString();
        int var2 = var1.readUByte();
        if (var2 > 0) {
            this.actions = new String[var2];

            for (int var3 = 0; var3 < var2; ++var3) {
                this.actions[var3] = var1.readString();
            }
        }

        this.anInt1381 = var1.readUByte();
        this.anInt1383 = var1.readUByte();
        this.aBoolean1388 = var1.readUByte() == 1;
        this.selectedAction = var1.readString();
        this.anObjectArray1384 = this.method960(var1);
        this.mouseEnterListeners = this.method960(var1);
        this.mouseExitListeners = this.method960(var1);
        this.anObjectArray1380 = this.method960(var1);
        this.anObjectArray1377 = this.method960(var1);
        this.configListenerArgs = this.method960(var1);
        this.tableListenerArgs = this.method960(var1);
        this.skillListenerArgs = this.method960(var1);
        this.renderListeners = this.method960(var1);
        this.mousePressListeners = this.method960(var1);
        this.hoverListeners = this.method960(var1);
        this.anObjectArray1386 = this.method960(var1);
        this.anObjectArray1385 = this.method960(var1);
        this.anObjectArray1376 = this.method960(var1);
        this.anObjectArray1379 = this.method960(var1);
        this.dragListeners = this.method960(var1);
        this.anObjectArray1387 = this.method960(var1);
        this.scrollListeners = this.method960(var1);
        this.configTriggers = this.method965(var1);
        this.itemTriggers = this.method965(var1);
        this.skillTriggers = this.method965(var1);
    }

    public SpriteClip method959(boolean var1) {
        if (this.enabledMaterialId == -1) {
            var1 = false;
        }

        int var2 = var1 ? this.enabledMaterialId : this.materialId;
        if (var2 == -1) {
            return null;
        }
        long var3 = ((this.flippedVertically ? 1L : 0L) << 38) + (long) var2 + ((long) this.borderThickness << 36) + ((this.flippedHorizontally ? 1L : 0L) << 39) + ((long) this.shadowColor << 40);
        SpriteClip var5 = (SpriteClip) aReferenceCache1374.get(var3);
        if (var5 != null) {
            return var5;
        }
        Sprite var6 = this.method958(var1);
        if (var6 == null) {
            return null;
        }
        Sprite var7 = var6.method823();
        int[] var8 = new int[var7.height];
        int[] var9 = new int[var7.height];

        for (int var10 = 0; var10 < var7.height; ++var10) {
            int var11 = 0;
            int var12 = var7.width;

            int var13;
            for (var13 = 0; var13 < var7.width; ++var13) {
                if (var7.pixels[var13 + var10 * var7.width] == 0) {
                    var11 = var13;
                    break;
                }
            }

            for (var13 = var7.width - 1; var13 >= var11; --var13) {
                if (var7.pixels[var13 + var10 * var7.width] == 0) {
                    var12 = var13 + 1;
                    break;
                }
            }

            var8[var10] = var11;
            var9[var10] = var12 - var11;
        }

        var5 = new SpriteClip(var7.width, var7.height, var9, var8);
        aReferenceCache1374.put(var5, var3);
        return var5;
    }

    public Font method957() {
        aBoolean1151 = false;
        if (this.fontId == -1) {
            return null;
        }
        Font var1 = (Font) aReferenceCache1367.get(this.fontId);
        if (var1 != null) {
            return var1;
        }
        var1 = ClanMember.method708(ClientPreferences.aReferenceTable364, SerializableLong.aReferenceTable645, this.fontId, 0);
        if (var1 != null) {
            aReferenceCache1367.put(var1, this.fontId);
        } else {
            aBoolean1151 = true;
        }

        return var1;
    }

    public Model method956(AnimationSequence var1, int var2, boolean var3, PlayerAppearance var4) {
        aBoolean1151 = false;
        int var5;
        int var6;
        if (var3) {
            var5 = this.anInt1355;
            var6 = this.anInt1350;
        } else {
            var5 = this.modelType;
            var6 = this.modelId;
        }

        if (var5 == 0) {
            return null;
        }
        if (var5 == 1 && var6 == -1) {
            return null;
        }
        Model var7 = (Model) aReferenceCache1364.get(var6 + (var5 << 16));
        if (var7 == null) {
            UnlitModel var8;
            if (var5 == 1) {
                var8 = UnlitModel.method982(OldConnectionTaskProcessor.aReferenceTable854, var6, 0);
                if (var8 == null) {
                    aBoolean1151 = true;
                    return null;
                }

                var7 = var8.light(64, 768, -50, -10, -50);
            }

            if (var5 == 2) {
                var8 = NpcDefinition.get(var6).method507();
                if (var8 == null) {
                    aBoolean1151 = true;
                    return null;
                }

                var7 = var8.light(64, 768, -50, -10, -50);
            }

            if (var5 == 3) {
                if (var4 == null) {
                    return null;
                }

                var8 = var4.method1427();
                if (var8 == null) {
                    aBoolean1151 = true;
                    return null;
                }

                var7 = var8.light(64, 768, -50, -10, -50);
            }

            if (var5 == 4) {
                ItemDefinition var9 = ItemDefinition.get(var6);
                var8 = var9.method531(10);
                if (var8 == null) {
                    aBoolean1151 = true;
                    return null;
                }

                var7 = var8.light(var9.ambient + 64, var9.contrast + 768, -50, -10, -50);
            }

            aReferenceCache1364.put(var7, var6 + (var5 << 16));
        }

        if (var1 != null) {
            var7 = var1.method879(var7, var2);
        }

        return var7;
    }

    public Sprite method961(int var1) {
        aBoolean1151 = false;
        if (var1 >= 0 && var1 < this.anIntArray1371.length) {
            int var2 = this.anIntArray1371[var1];
            if (var2 == -1) {
                return null;
            }
            Sprite var3 = (Sprite) aReferenceCache1370.get(var2);
            if (var3 != null) {
                return var3;
            }
            var3 = Sprite.get(ClientPreferences.aReferenceTable364, var2, 0);
            if (var3 != null) {
                aReferenceCache1370.put(var3, var2);
            } else {
                aBoolean1151 = true;
            }

            return var3;
        }
        return null;
    }

    public void method964(int var1, String var2) {
        if (this.actions == null || this.actions.length <= var1) {
            String[] var3 = new String[var1 + 1];
            if (this.actions != null) {
                System.arraycopy(this.actions, 0, var3, 0, this.actions.length);
            }

            this.actions = var3;
        }

        this.actions[var1] = var2;
    }

    Object[] method960(Buffer var1) {
        int var2 = var1.readUByte();
        if (var2 == 0) {
            return null;
        }
        Object[] var3 = new Object[var2];

        for (int var4 = 0; var4 < var2; ++var4) {
            int var5 = var1.readUByte();
            if (var5 == 0) {
                var3[var4] = var1.readInt();
            } else if (var5 == 1) {
                var3[var4] = var1.readString();
            }
        }

        this.aBoolean1378 = true;
        return var3;
    }

    int[] method965(Buffer var1) {
        int var2 = var1.readUByte();
        if (var2 == 0) {
            return null;
        }
        int[] var3 = new int[var2];

        for (int var4 = 0; var4 < var2; ++var4) {
            var3[var4] = var1.readInt();
        }

        return var3;
    }

    public void method817(int var1, int var2) {
        int var3 = this.itemIds[var2];
        this.itemIds[var2] = this.itemIds[var1];
        this.itemIds[var1] = var3;
        var3 = this.itemStackSizes[var2];
        this.itemStackSizes[var2] = this.itemStackSizes[var1];
        this.itemStackSizes[var1] = var3;
    }
}
