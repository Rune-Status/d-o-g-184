package jag.worldmap;

import jag.graphics.NamedFont;
import jag.commons.input.Keyboard;
import jag.game.GameEngine;
import jag.game.client;
import jag.graphics.*;
import jag.js5.ReferenceTable;
import jag.opcode.Buffer;
import jag.opcode.OutgoingPacket;
import jag.opcode.OutgoingPacketMeta;
import jag.script.ScriptEvent;
import jag.statics.Statics35;

import java.util.*;

public class WorldMap {

    static final NamedFont VERDANA11;
    static final NamedFont VERDANA13;
    static final NamedFont VERDANA15;

    static {
        VERDANA11 = NamedFont.VERDANA11;
        VERDANA13 = NamedFont.VERDANA13;
        VERDANA15 = NamedFont.VERDANA15;
    }

    final int[] actionOpcodes;
    public boolean drawMouseOverPosition;
    IndexedSprite[] mapSceneSprites;
    boolean aBoolean1691;
    HashSet<Integer> aHashSet1692;
    int anInt1685;
    int anInt1678;
    int anInt1690;
    HashSet<Integer> aHashSet1677;
    int anInt1693;
    boolean aBoolean1687;
    int anInt1671;
    HashMap<String, WorldMapArea> areas;
    HashSet<Integer> aHashSet1675;
    HashSet<Integer> aHashSet1686;
    WorldMapDefinitionLoader definitionLoader;
    Iterator<WorldMapIcon> anIterator1703;
    int anInt1709;
    float aFloat1672;
    Sprite aSprite1695;
    int anInt1711;
    WorldMapArea activeArea;
    int anInt1676;
    ReferenceTable table;
    int anInt1717;
    WorldMapPosition mouseOver;
    int anInt1715;
    float aFloat1716;
    WorldMapController controller;
    HashMap<WorldMapLabelSize, BaseFont> sizeToFont;
    int anInt1670;
    int anInt1682;
    WorldMapArea aWorldMapArea_1724;
    ReferenceTable scenery;
    WorldMapArea mainland;
    int anInt1681;
    ReferenceTable ground;
    int anInt1679;
    HashSet aHashSet1688;
    int anInt1673;
    Font font;
    int anInt1699;
    int anInt1683;
    List<WorldMapIcon> aList1700;
    int anInt1697;
    int anInt1694;
    int anInt1701;
    boolean aBoolean1689;
    HashSet<WorldMapIcon> aHashSet1698;
    int anInt1680;
    int anInt1674;
    int anInt1704;
    long aLong1684;

    public WorldMap() {
        anInt1709 = -1;
        anInt1717 = -1;
        anInt1693 = -1;
        anInt1690 = -1;
        anInt1670 = -1;
        anInt1683 = -1;
        anInt1685 = 3;
        anInt1671 = 50;
        aBoolean1691 = false;
        aHashSet1686 = null;
        anInt1682 = -1;
        anInt1679 = -1;
        anInt1673 = -1;
        anInt1681 = -1;
        anInt1676 = -1;
        anInt1678 = -1;
        aBoolean1689 = true;
        aHashSet1677 = new HashSet<>();
        aHashSet1692 = new HashSet<>();
        aHashSet1688 = new HashSet<>();
        aHashSet1675 = new HashSet<>();
        aBoolean1687 = false;
        anInt1704 = 0;
        actionOpcodes = new int[]{1008, 1009, 1010, 1011, 1012};
        aHashSet1698 = new HashSet<>();
        mouseOver = null;
        drawMouseOverPosition = false;
        anInt1694 = -1;
        anInt1701 = -1;
        anInt1697 = -1;
    }

    boolean method1267() {
        return anInt1709 != -1 && anInt1717 != -1;
    }

    public WorldMapArea getAreaAt(int level, int x, int y) {
        Iterator<WorldMapArea> var4 = areas.values().iterator();

        WorldMapArea var5;
        do {
            if (!var4.hasNext()) {
                return null;
            }

            var5 = var4.next();
        } while (!var5.contains(level, x, y));

        return var5;
    }

    float method1239(int var1) {
        if (var1 == 25) {
            return 1.0F;
        }
        if (var1 == 37) {
            return 1.5F;
        }
        if (var1 == 50) {
            return 2.0F;
        }
        if (var1 == 75) {
            return 3.0F;
        }
        return var1 == 100 ? 4.0F : 8.0F;
    }

    public WorldMapArea getArea(int id) {
        Iterator<WorldMapArea> var2 = areas.values().iterator();

        WorldMapArea var3;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            var3 = var2.next();
        } while (var3.getId() != id);

        return var3;
    }

    void method1266(WorldMapArea var1) {
        activeArea = var1;
        controller = new WorldMapController(mapSceneSprites, sizeToFont, scenery, ground);
        definitionLoader.method1309(activeArea.getJagName());
    }

    void setArea(WorldMapArea var1) {
        if (activeArea == null || var1 != activeArea) {
            method1266(var1);
            method1265(-1, -1, -1);
        }
    }

    public int method1232() {
        return activeArea == null ? -1 : anInt1711 + activeArea.method66() * 64;
    }

    void method1274() {
        if (client.class69 != null) {
            aFloat1716 = aFloat1672;
        } else {
            if (aFloat1716 < aFloat1672) {
                aFloat1716 = Math.min(aFloat1672, aFloat1716 + aFloat1716 / 30.0F);
            }

            if (aFloat1716 > aFloat1672) {
                aFloat1716 = Math.max(aFloat1672, aFloat1716 - aFloat1716 / 30.0F);
            }

        }
    }

    void method1256() {
        aHashSet1675.clear();
        aHashSet1675.addAll(aHashSet1677);
        aHashSet1675.addAll(aHashSet1688);
    }

    void method1265(int var1, int var2, int var3) {
        if (activeArea != null) {
            int[] var4 = activeArea.method81(var1, var2, var3);
            if (var4 == null) {
                var4 = activeArea.method81(activeArea.getLevel(), activeArea.getBaseX(), activeArea.getBaseY());
            }

            method1271(var4[0] - activeArea.method66() * 64, var4[1] - activeArea.method85() * 64, true);
            anInt1709 = -1;
            anInt1717 = -1;
            aFloat1716 = method1239(activeArea.method78());
            aFloat1672 = aFloat1716;
            aList1700 = null;
            anIterator1703 = null;
            controller.method136();
        }
    }

    public int method1236() {
        return anInt1693;
    }

    public int method1234() {
        return activeArea == null ? -1 : anInt1715 + activeArea.method85() * 64;
    }

    void method1275() {
        if (method1267()) {
            int var1 = anInt1709 - anInt1711;
            int var2 = anInt1717 - anInt1715;
            if (var1 != 0) {
                var1 /= Math.min(8, Math.abs(var1));
            }

            if (var2 != 0) {
                var2 /= Math.min(8, Math.abs(var2));
            }

            method1271(var1 + anInt1711, var2 + anInt1715, true);
            if (anInt1709 == anInt1711 && anInt1715 == anInt1717) {
                anInt1709 = -1;
                anInt1717 = -1;
            }

        }
    }

    final void method1281() {
        anInt1678 = -1;
        anInt1676 = -1;
        anInt1681 = -1;
        anInt1673 = -1;
    }

    public void method1235(int var1, int var2) {
        if (activeArea != null) {
            method1271(var1 - activeArea.method66() * 64, var2 - activeArea.method85() * 64, true);
            anInt1709 = -1;
            anInt1717 = -1;
        }
    }

    public void method1238(int var1, int var2) {
        if (activeArea != null && activeArea.method83(var1, var2)) {
            anInt1709 = var1 - activeArea.method66() * 64;
            anInt1717 = var2 - activeArea.method85() * 64;
        }
    }

    void method1276(int var1, int var2, boolean var3, long var4) {
        if (activeArea != null) {
            int var6 = (int) ((float) anInt1711 + ((float) (var1 - anInt1670) - (float) method1236() * aFloat1716 / 2.0F) / aFloat1716);
            int var7 = (int) ((float) anInt1715 - ((float) (var2 - anInt1683) - (float) method1228() * aFloat1716 / 2.0F) / aFloat1716);
            mouseOver = activeArea.getPosition(var6 + activeArea.method66() * 64, var7 + activeArea.method85() * 64);
            if (mouseOver != null && var3) {
                boolean var8 = client.rights >= 2;
                if (var8 && Keyboard.heldKeys[82] && Keyboard.heldKeys[81]) {
                    Statics35.method1171(mouseOver.x, mouseOver.y, mouseOver.floorLevel, false);
                } else {
                    boolean var9 = true;
                    if (aBoolean1689) {
                        int var10 = var1 - anInt1680;
                        int var11 = var2 - anInt1674;
                        if (var4 - aLong1684 > 500L || var10 < -25 || var10 > 25 || var11 < -25 || var11 > 25) {
                            var9 = false;
                        }
                    }

                    if (var9) {
                        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta51, client.connectionContext.encryptor);
                        packet.buffer.writeInt(mouseOver.getHash());
                        client.connectionContext.writeLater(packet);
                        aLong1684 = 0L;
                    }
                }
            }
        } else {
            mouseOver = null;
        }

    }

    final void method1271(int var1, int var2, boolean var3) {
        anInt1711 = var1;
        anInt1715 = var2;
        GameEngine.currentTime();
        if (var3) {
            method1281();
        }

    }

    public int method1228() {
        return anInt1690;
    }

    public WorldMapIcon method1255() {
        if (anIterator1703 == null) {
            return null;
        }
        WorldMapIcon var1;
        do {
            if (!anIterator1703.hasNext()) {
                return null;
            }

            var1 = anIterator1703.next();
        } while (var1.getMapFunction() == -1);

        return var1;
    }

    boolean method1263(int var1, int var2, int var3, int var4, int var5, int var6) {
        if (aSprite1695 == null) {
            return true;
        }
        if (aSprite1695.width == var1 && aSprite1695.height == var2) {
            if (controller.tileScale != anInt1699) {
                return true;
            }
            if (anInt1697 != client.anInt929) {
                return true;
            }
            if (var3 <= 0 && var4 <= 0) {
                return var3 + var1 < var5 || var2 + var4 < var6;
            }
            return true;
        }
        return true;
    }

    void method1224(int var1, int var2, int var3, int var4, int var5) {
        byte var6 = 20;
        int var7 = var3 / 2 + var1;
        int var8 = var4 / 2 + var2 - 18 - var6;
        JagGraphics.fillRect(var1, var2, var3, var4, -16777216);
        JagGraphics.method1372(var7 - 152, var8, 304, 34, -65536);
        JagGraphics.fillRect(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
        font.method1154("Loading...", var7, var6 + var8, -1, -1);
    }

    public void method1279(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
        if (definitionLoader.method1308()) {
            method1274();
            method1275();
            if (var3) {
                int var8 = (int) Math.ceil((float) var6 / aFloat1716);
                int var9 = (int) Math.ceil((float) var7 / aFloat1716);
                List<WorldMapIcon> var10 = controller.method138(anInt1711 - var8 / 2 - 1, anInt1715 - var9 / 2 - 1, var8 / 2 + anInt1711 + 1, var9 / 2 + anInt1715 + 1, var4, var5, var6, var7, var1, var2);
                HashSet<WorldMapIcon> var11 = new HashSet<>();

                Iterator<WorldMapIcon> var12;
                WorldMapIcon var13;
                ScriptEvent var14;
                WorldMapScriptEvent var15;
                for (var12 = var10.iterator(); var12.hasNext(); ScriptEvent.fire(var14)) {
                    var13 = var12.next();
                    var11.add(var13);
                    var14 = new ScriptEvent();
                    var15 = new WorldMapScriptEvent(var13.getMapFunction(), var13.min, var13.max);
                    var14.method1304(new Object[]{var15, var1, var2});
                    if (aHashSet1698.contains(var13)) {
                        var14.method1193(17);
                    } else {
                        var14.method1193(15);
                    }
                }

                var12 = aHashSet1698.iterator();

                while (var12.hasNext()) {
                    var13 = var12.next();
                    if (!var11.contains(var13)) {
                        var14 = new ScriptEvent();
                        var15 = new WorldMapScriptEvent(var13.getMapFunction(), var13.min, var13.max);
                        var14.method1304(new Object[]{var15, var1, var2});
                        var14.method1193(16);
                        ScriptEvent.fire(var14);
                    }
                }

                aHashSet1698 = var11;
            }
        }
    }

    public void method1253(int var1, int var2, WorldMapPosition var3, WorldMapPosition var4) {
        ScriptEvent var5 = new ScriptEvent();
        WorldMapScriptEvent var6 = new WorldMapScriptEvent(var2, var3, var4);
        var5.method1304(new Object[]{var6});
        switch (var1) {
            case 1008:
                var5.method1193(10);
                break;
            case 1009:
                var5.method1193(11);
                break;
            case 1010:
                var5.method1193(12);
                break;
            case 1011:
                var5.method1193(13);
                break;
            case 1012:
                var5.method1193(14);
        }

        ScriptEvent.fire(var5);
    }

    public void method1259(int var1, int var2, int var3, int var4, int var5, int var6) {
        if (definitionLoader.method1308()) {
            int var7 = (int) Math.ceil((float) var3 / aFloat1716);
            int var8 = (int) Math.ceil((float) var4 / aFloat1716);
            List<WorldMapIcon> var9 = controller.method138(anInt1711 - var7 / 2 - 1, anInt1715 - var8 / 2 - 1, var7 / 2 + anInt1711 + 1, var8 / 2 + anInt1715 + 1, var1, var2, var3, var4, var5, var6);
            if (!var9.isEmpty()) {
                Iterator<WorldMapIcon> var10 = var9.iterator();

                boolean var13;
                do {
                    if (!var10.hasNext()) {
                        return;
                    }

                    WorldMapIcon var11 = var10.next();
                    WorldMapFunction var12 = WorldMapFunction.get(var11.getMapFunction());
                    var13 = false;

                    for (int var14 = actionOpcodes.length - 1; var14 >= 0; --var14) {
                        if (var12.aStringArray1470[var14] != null) {
                            WorldMapTileDecor_Sub1.insertMenuItem(var12.aStringArray1470[var14], var12.aString1476, actionOpcodes[var14], var11.getMapFunction(), var11.min.getHash(), var11.max.getHash());
                            var13 = true;
                        }
                    }
                } while (!var13);

            }
        }
    }

    void method1270(int var1, int var2, int var3, int var4, int var5, int var6) {
        if (client.class69 != null) {
            int var7 = 512 / (controller.tileScale * 2);
            int var8 = var3 + 512;
            int var9 = var4 + 512;
            float var10 = 1.0F;
            var8 = (int) ((float) var8 / var10);
            var9 = (int) ((float) var9 / var10);
            int var11 = method1232() - var5 / 2 - var7;
            int var12 = method1234() - var6 / 2 - var7;
            int var13 = var1 - (var11 + var7 - anInt1694) * controller.tileScale;
            int var14 = var2 - controller.tileScale * (var7 - (var12 - anInt1701));
            if (method1263(var8, var9, var13, var14, var3, var4)) {
                if (aSprite1695 != null && aSprite1695.width == var8 && aSprite1695.height == var9) {
                    Arrays.fill(aSprite1695.pixels, 0);
                } else {
                    aSprite1695 = new Sprite(var8, var9);
                }

                anInt1694 = method1232() - var5 / 2 - var7;
                anInt1701 = method1234() - var6 / 2 - var7;
                anInt1699 = controller.tileScale;
                client.class69.method992(anInt1694, anInt1701, aSprite1695, (float) anInt1699 / var10);
                anInt1697 = client.anInt929;
                var13 = var1 - (var7 + var11 - anInt1694) * controller.tileScale;
                var14 = var2 - controller.tileScale * (var7 - (var12 - anInt1701));
            }

            JagGraphics.method1370(var1, var2, var3, var4, 0, 128);
            if (1.0F == var10) {
                aSprite1695.method821(var13, var14, 192);
            } else {
                aSprite1695.method806(var13, var14, (int) (var10 * (float) var8), (int) ((float) var9 * var10), 192);
            }
        }

    }

    public void method1278(int var1, int var2, boolean var3, boolean var4) {
        long var5 = GameEngine.currentTime();
        method1276(var1, var2, var4, var5);
        if (!method1267() && (var4 || var3)) {
            if (var4) {
                anInt1676 = var1;
                anInt1678 = var2;
                anInt1673 = anInt1711;
                anInt1681 = anInt1715;
            }

            if (anInt1673 != -1) {
                int var7 = var1 - anInt1676;
                int var8 = var2 - anInt1678;
                method1271(anInt1673 - (int) ((float) var7 / aFloat1672), (int) ((float) var8 / aFloat1672) + anInt1681, false);
            }
        } else {
            method1281();
        }

        if (var4) {
            aLong1684 = var5;
            anInt1680 = var1;
            anInt1674 = var2;
        }

    }

    public void method1268(int var1, int var2, int var3, int var4, int var5) {
        int[] var6 = new int[4];
        JagGraphics.method1366(var6);
        JagGraphics.setClip(var1, var2, var3 + var1, var2 + var4);
        JagGraphics.fillRect(var1, var2, var3, var4, -16777216);
        int var7 = definitionLoader.method1307();
        if (var7 < 100) {
            method1224(var1, var2, var3, var4, var7);
        } else {
            if (!controller.method135()) {
                controller.method145(table, activeArea.getJagName(), client.membersWorld);
                if (!controller.method135()) {
                    return;
                }
            }

            if (aHashSet1686 != null) {
                ++anInt1679;
                if (anInt1679 % anInt1671 == 0) {
                    anInt1679 = 0;
                    ++anInt1682;
                }

                if (anInt1682 >= anInt1685 && !aBoolean1691) {
                    aHashSet1686 = null;
                }
            }

            int var8 = (int) Math.ceil((float) var3 / aFloat1716);
            int var9 = (int) Math.ceil((float) var4 / aFloat1716);
            controller.method142(anInt1711 - var8 / 2, anInt1715 - var9 / 2, var8 / 2 + anInt1711, var9 / 2 + anInt1715, var1, var3 + var1, var2 + var4);
            boolean var10;
            if (!aBoolean1687) {
                var10 = false;
                if (var5 - anInt1704 > 100) {
                    anInt1704 = var5;
                    var10 = true;
                }

                controller.method141(anInt1711 - var8 / 2, anInt1715 - var9 / 2, var8 / 2 + anInt1711, var9 / 2 + anInt1715, var1, var3 + var1, var2 + var4, aHashSet1675, aHashSet1686, anInt1679, anInt1671, var10);
            }

            method1270(var1, var2, var3, var4, var8, var9);
            var10 = client.rights >= 2;
            if (var10 && drawMouseOverPosition && mouseOver != null) {
                font.drawString("Coord: " + mouseOver, JagGraphics.drawingAreaLeft + 10, JagGraphics.drawingAreaTop + 20, 16776960, -1);
            }

            anInt1693 = var8;
            anInt1690 = var9;
            anInt1670 = var1;
            anInt1683 = var2;
            JagGraphics.method1373(var6);
        }
    }

    public void method1269(int var1, int var2, int var3, int var4) {
        if (definitionLoader.method1308()) {
            if (!controller.method135()) {
                controller.method145(table, activeArea.getJagName(), client.membersWorld);
                if (!controller.method135()) {
                    return;
                }
            }

            controller.method140(var1, var2, var3, var4, aHashSet1686, anInt1679, anInt1671);
        }
    }

    public void method1272() {
        WorldMapChunkDefinition.A_REFERENCE_NODE_TABLE___118.method666(5);
    }

    public void initialize(ReferenceTable table, ReferenceTable scenery, ReferenceTable ground,
            Font font, HashMap<NamedFont, BaseFont> namedFonts, IndexedSprite[] mapSceneSprites) {
        this.mapSceneSprites = mapSceneSprites;
        this.table = table;
        this.scenery = scenery;
        this.ground = ground;
        this.font = font;
        this.sizeToFont = new HashMap<>();

        this.sizeToFont.put(WorldMapLabelSize.SMALL, namedFonts.get(VERDANA11));
        this.sizeToFont.put(WorldMapLabelSize.MEDIUM, namedFonts.get(VERDANA13));
        this.sizeToFont.put(WorldMapLabelSize.LARGE, namedFonts.get(VERDANA15));
        this.definitionLoader = new WorldMapDefinitionLoader(table);

        int var7 = table.get(WorldMapCacheFeature.DETAILS.name);
        int[] ids = table.getFileIds(var7);

        this.areas = new HashMap<>(ids.length);

        for (int id : ids) {
            Buffer buffer = new Buffer(table.unpack(var7, id));
            WorldMapArea area = new WorldMapArea();
            area.decode(buffer, id);
            areas.put(area.getJagName(), area);
            if (area.isMainland()) {
               mainland = area;
            }
        }

        setArea(mainland);
        aWorldMapArea_1724 = null;
    }

    public void setArea(int id) {
        WorldMapArea area = getArea(id);
        if (area != null) {
            setArea(area);
        }

    }

    public int getZoom() {
        if (1.0D == (double) aFloat1672) {
            return 25;
        }
        if ((double) aFloat1672 == 1.5D) {
            return 37;
        }
        if (2.0D == (double) aFloat1672) {
            return 50;
        }
        if ((double) aFloat1672 == 3.0D) {
            return 75;
        }
        return (double) aFloat1672 == 4.0D ? 100 : 200;
    }

    public void method1261(int var1, int var2, int var3, boolean var4) {
        WorldMapArea var5 = getAreaAt(var1, var2, var3);
        if (var5 == null) {
            if (!var4) {
                return;
            }

            var5 = mainland;
        }

        boolean var6 = false;
        if (var5 != aWorldMapArea_1724 || var4) {
            aWorldMapArea_1724 = var5;
            setArea(var5);
            var6 = true;
        }

        if (var6 || var4) {
            method1265(var1, var2, var3);
        }

    }

    public void method1226(int var1) {
        aFloat1672 = method1239(var1);
    }

    public boolean method1246() {
        return definitionLoader.method1308();
    }

    public WorldMapPosition method1240() {
        return activeArea == null ? null : activeArea.getPosition(method1232(), method1234());
    }

    public void method1227(int var1, int var2, int var3) {
        if (activeArea != null) {
            int[] var4 = activeArea.method81(var1, var2, var3);
            if (var4 != null) {
                method1238(var4[0], var4[1]);
            }

        }
    }

    public void method1237(int var1, int var2, int var3) {
        if (activeArea != null) {
            int[] var4 = activeArea.method81(var1, var2, var3);
            if (var4 != null) {
                method1235(var4[0], var4[1]);
            }

        }
    }

    public int method1260() {
        return activeArea == null ? -1 : activeArea.getId();
    }

    public void method1231() {
        anInt1685 = 3;
    }

    public WorldMapArea getActiveArea() {
        return activeArea;
    }

    public void method1233() {
        anInt1671 = 50;
    }

    public void method1245(int var1) {
        if (var1 >= 1) {
            anInt1685 = var1;
        }

    }

    public void method1243() {
        aHashSet1686 = null;
    }

    public void method1230(int var1) {
        if (var1 >= 1) {
            anInt1671 = var1;
        }

    }

    public void method1244(int var1) {
        aHashSet1686 = new HashSet<>();
        aHashSet1686.add(var1);
        anInt1682 = 0;
        anInt1679 = 0;
    }

    public void method1247(boolean var1) {
        aBoolean1691 = var1;
    }

    public void method1229(int var1) {
        aHashSet1686 = new HashSet<>();
        anInt1682 = 0;
        anInt1679 = 0;

        for (int var2 = 0; var2 < WorldMapFunction.anInt378; ++var2) {
            if (WorldMapFunction.get(var2) != null && WorldMapFunction.get(var2).anInt1473 == var1) {
                aHashSet1686.add(WorldMapFunction.get(var2).anInt574);
            }
        }

    }

    public WorldMapIcon method1248() {
        if (!definitionLoader.method1308()) {
            return null;
        }

        if (!controller.method135()) {
            return null;
        }

        HashMap<Integer, List<WorldMapIcon>> var1 = controller.method144();
        aList1700 = new java.util.LinkedList<>();

        for (List<WorldMapIcon> o : var1.values()) {
            aList1700.addAll(o);
        }

        anIterator1703 = aList1700.iterator();
        return method1255();
    }

    public void method1258(boolean var1) {
        aBoolean1687 = !var1;
    }

    public boolean method1254() {
        return !aBoolean1687;
    }

    public void method1251(int var1, boolean var2) {
        if (!var2) {
            aHashSet1677.add(var1);
        } else {
            aHashSet1677.remove(var1);
        }

        method1256();
    }

    public void method1250(int var1, boolean var2) {
        if (!var2) {
            aHashSet1692.add(var1);
        } else {
            aHashSet1692.remove(var1);
        }

        for (int var3 = 0; var3 < WorldMapFunction.anInt378; ++var3) {
            if (WorldMapFunction.get(var3) != null && WorldMapFunction.get(var3).anInt1473 == var1) {
                int var4 = WorldMapFunction.get(var3).anInt574;
                if (!var2) {
                    aHashSet1688.add(var4);
                } else {
                    aHashSet1688.remove(var4);
                }
            }
        }

        method1256();
    }

    public boolean method1257(int var1) {
        return !aHashSet1677.contains(var1);
    }

    public void method1277(WorldMapArea var1, WorldMapPosition var2, WorldMapPosition var3, boolean var4) {
        if (var1 != null) {
            if (activeArea == null || var1 != activeArea) {
                method1266(var1);
            }

            if (!var4 && activeArea.contains(var2.floorLevel, var2.x, var2.y)) {
                method1265(var2.floorLevel, var2.x, var2.y);
            } else {
                method1265(var3.floorLevel, var3.x, var3.y);
            }
        }
    }

    public boolean method1252(int var1) {
        return !aHashSet1692.contains(var1);
    }

    public WorldMapPosition method1249(int var1, WorldMapPosition var2) {
        if (!definitionLoader.method1308()) {
            return null;
        }

        if (!controller.method135()) {
            return null;
        }

        if (!activeArea.method83(var2.x, var2.y)) {
            return null;
        }

        HashMap var3 = controller.method144();
        List var4 = (List) var3.get(var1);
        if (var4 != null && !var4.isEmpty()) {
            WorldMapIcon var5 = null;
            int var6 = -1;
            Iterator var7 = var4.iterator();

            while (true) {
                WorldMapIcon var8;
                int var11;
                do {
                    if (!var7.hasNext()) {
                        return var5.max;
                    }

                    var8 = (WorldMapIcon) var7.next();
                    int var9 = var8.max.x - var2.x;
                    int var10 = var8.max.y - var2.y;
                    var11 = var10 * var10 + var9 * var9;
                    if (var11 == 0) {
                        return var8.max;
                    }
                } while (var11 >= var6 && var5 != null);

                var5 = var8;
                var6 = var11;
            }
        }
        return null;
    }

    public void method1225() {
        definitionLoader.method1310();
    }
}
