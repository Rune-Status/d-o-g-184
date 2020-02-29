package com.jagex;

import java.util.*;

public class Class209 {
    static final Class199 aClass199_1714;
    static final Class199 aClass199_1708;
    static final Class199 aClass199_1707;

    static {
        aClass199_1714 = Class199.aClass199_1621;
        aClass199_1708 = Class199.aClass199_1620;
        aClass199_1707 = Class199.aClass199_1618;
    }

    final int[] anIntArray1696;
    public boolean aBoolean1705;
    DoublyLinkedNode_Sub24_Sub4[] aDoublyNode_Sub24_Sub4Array1710;
    boolean aBoolean1691;
    HashSet aHashSet1692;
    int anInt1685;
    int anInt1678;
    int anInt1690;
    HashSet aHashSet1677;
    int anInt1693;
    boolean aBoolean1687;
    int anInt1671;
    HashMap aHashMap1723;
    HashSet aHashSet1675;
    HashSet aHashSet1686;
    Class214 aClass214_1721;
    Iterator anIterator1703;
    int anInt1709;
    float aFloat1672;
    Sprite aSprite1695;
    int anInt1711;
    Class9 aClass9_1712;
    int anInt1676;
    ReferenceTable aReferenceTable1720;
    int anInt1717;
    SceneOffset aSceneOffset1702;
    int anInt1715;
    float aFloat1716;
    Class19 aClass19_1713;
    HashMap aHashMap1706;
    int anInt1670;
    int anInt1682;
    Class9 aClass9_1724;
    ReferenceTable aReferenceTable1718;
    Class9 aClass9_1722;
    int anInt1681;
    ReferenceTable aReferenceTable1725;
    int anInt1679;
    HashSet aHashSet1688;
    int anInt1673;
    Font aFont1719;
    int anInt1699;
    int anInt1683;
    List aList1700;
    int anInt1697;
    int anInt1694;
    int anInt1701;
    boolean aBoolean1689;
    HashSet aHashSet1698;
    int anInt1680;
    int anInt1674;
    int anInt1704;
    long aLong1684;

    public Class209() {
        this.anInt1709 = -1;
        this.anInt1717 = -1;
        this.anInt1693 = -1;
        this.anInt1690 = -1;
        this.anInt1670 = -1;
        this.anInt1683 = -1;
        this.anInt1685 = 3;
        this.anInt1671 = 50;
        this.aBoolean1691 = false;
        this.aHashSet1686 = null;
        this.anInt1682 = -1;
        this.anInt1679 = -1;
        this.anInt1673 = -1;
        this.anInt1681 = -1;
        this.anInt1676 = -1;
        this.anInt1678 = -1;
        this.aBoolean1689 = true;
        this.aHashSet1677 = new HashSet();
        this.aHashSet1692 = new HashSet();
        this.aHashSet1688 = new HashSet();
        this.aHashSet1675 = new HashSet();
        this.aBoolean1687 = false;
        this.anInt1704 = 0;
        this.anIntArray1696 = new int[]{1008, 1009, 1010, 1011, 1012};
        this.aHashSet1698 = new HashSet();
        this.aSceneOffset1702 = null;
        this.aBoolean1705 = false;
        this.anInt1694 = -1;
        this.anInt1701 = -1;
        this.anInt1697 = -1;
    }

    boolean method1267() {
        return this.anInt1709 != -1 && this.anInt1717 != -1;
    }

    public Class9 method1262(int var1, int var2, int var3) {
        Iterator var4 = this.aHashMap1723.values().iterator();

        Class9 var5;
        do {
            if (!var4.hasNext()) {
                return null;
            }

            var5 = (Class9) var4.next();
        } while (!var5.method84(var1, var2, var3));

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

    public Class9 method1242(int var1) {
        Iterator var2 = this.aHashMap1723.values().iterator();

        Class9 var3;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            var3 = (Class9) var2.next();
        } while (var3.method75() != var1);

        return var3;
    }

    void method1266(Class9 var1) {
        this.aClass9_1712 = var1;
        this.aClass19_1713 = new Class19(this.aDoublyNode_Sub24_Sub4Array1710, this.aHashMap1706, this.aReferenceTable1718, this.aReferenceTable1725);
        this.aClass214_1721.method1309(this.aClass9_1712.method73());
    }

    void method1280(Class9 var1) {
        if (this.aClass9_1712 == null || var1 != this.aClass9_1712) {
            this.method1266(var1);
            this.method1265(-1, -1, -1);
        }
    }

    public int method1232() {
        return this.aClass9_1712 == null ? -1 : this.anInt1711 + this.aClass9_1712.method66() * 64;
    }

    void method1274() {
        if (Enum_Sub5.aClass172_1216 != null) {
            this.aFloat1716 = this.aFloat1672;
        } else {
            if (this.aFloat1716 < this.aFloat1672) {
                this.aFloat1716 = Math.min(this.aFloat1672, this.aFloat1716 + this.aFloat1716 / 30.0F);
            }

            if (this.aFloat1716 > this.aFloat1672) {
                this.aFloat1716 = Math.max(this.aFloat1672, this.aFloat1716 - this.aFloat1716 / 30.0F);
            }

        }
    }

    void method1256() {
        this.aHashSet1675.clear();
        this.aHashSet1675.addAll(this.aHashSet1677);
        this.aHashSet1675.addAll(this.aHashSet1688);
    }

    void method1265(int var1, int var2, int var3) {
        if (this.aClass9_1712 != null) {
            int[] var4 = this.aClass9_1712.method81(var1, var2, var3);
            if (var4 == null) {
                var4 = this.aClass9_1712.method81(this.aClass9_1712.method71(), this.aClass9_1712.method82(), this.aClass9_1712.method74());
            }

            this.method1271(var4[0] - this.aClass9_1712.method66() * 64, var4[1] - this.aClass9_1712.method85() * 64, true);
            this.anInt1709 = -1;
            this.anInt1717 = -1;
            this.aFloat1716 = this.method1239(this.aClass9_1712.method78());
            this.aFloat1672 = this.aFloat1716;
            this.aList1700 = null;
            this.anIterator1703 = null;
            this.aClass19_1713.method136();
        }
    }

    public int method1236() {
        return this.anInt1693;
    }

    public int method1234() {
        return this.aClass9_1712 == null ? -1 : this.anInt1715 + this.aClass9_1712.method85() * 64;
    }

    void method1275() {
        if (this.method1267()) {
            int var1 = this.anInt1709 - this.anInt1711;
            int var2 = this.anInt1717 - this.anInt1715;
            if (var1 != 0) {
                var1 /= Math.min(8, Math.abs(var1));
            }

            if (var2 != 0) {
                var2 /= Math.min(8, Math.abs(var2));
            }

            this.method1271(var1 + this.anInt1711, var2 + this.anInt1715, true);
            if (this.anInt1709 == this.anInt1711 && this.anInt1715 == this.anInt1717) {
                this.anInt1709 = -1;
                this.anInt1717 = -1;
            }

        }
    }

    final void method1281() {
        this.anInt1678 = -1;
        this.anInt1676 = -1;
        this.anInt1681 = -1;
        this.anInt1673 = -1;
    }

    public void method1235(int var1, int var2) {
        if (this.aClass9_1712 != null) {
            this.method1271(var1 - this.aClass9_1712.method66() * 64, var2 - this.aClass9_1712.method85() * 64, true);
            this.anInt1709 = -1;
            this.anInt1717 = -1;
        }
    }

    public void method1238(int var1, int var2) {
        if (this.aClass9_1712 != null && this.aClass9_1712.method83(var1, var2)) {
            this.anInt1709 = var1 - this.aClass9_1712.method66() * 64;
            this.anInt1717 = var2 - this.aClass9_1712.method85() * 64;
        }
    }

    void method1276(int var1, int var2, boolean var3, long var4) {
        if (this.aClass9_1712 != null) {
            int var6 = (int) ((float) this.anInt1711 + ((float) (var1 - this.anInt1670) - (float) this.method1236() * this.aFloat1716 / 2.0F) / this.aFloat1716);
            int var7 = (int) ((float) this.anInt1715 - ((float) (var2 - this.anInt1683) - (float) this.method1228() * this.aFloat1716 / 2.0F) / this.aFloat1716);
            this.aSceneOffset1702 = this.aClass9_1712.method79(var6 + this.aClass9_1712.method66() * 64, var7 + this.aClass9_1712.method85() * 64);
            if (this.aSceneOffset1702 != null && var3) {
                boolean var8 = client.rights >= 2;
                if (var8 && Keyboard.heldKeys[82] && Keyboard.heldKeys[81]) {
                    Statics35.method1171(this.aSceneOffset1702.anInt1891, this.aSceneOffset1702.anInt1892, this.aSceneOffset1702.floorLevel, false);
                } else {
                    boolean var9 = true;
                    if (this.aBoolean1689) {
                        int var10 = var1 - this.anInt1680;
                        int var11 = var2 - this.anInt1674;
                        if (var4 - this.aLong1684 > 500L || var10 < -25 || var10 > 25 || var11 < -25 || var11 > 25) {
                            var9 = false;
                        }
                    }

                    if (var9) {
                        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta51, client.connectionContext.encryptor);
                        packet.buffer.writeInt(this.aSceneOffset1702.positionHash());
                        client.connectionContext.writeLater(packet);
                        this.aLong1684 = 0L;
                    }
                }
            }
        } else {
            this.aSceneOffset1702 = null;
        }

    }

    final void method1271(int var1, int var2, boolean var3) {
        this.anInt1711 = var1;
        this.anInt1715 = var2;
        Class24.currentTime();
        if (var3) {
            this.method1281();
        }

    }

    public int method1228() {
        return this.anInt1690;
    }

    public Class27 method1255() {
        if (this.anIterator1703 == null) {
            return null;
        }
        Class27 var1;
        do {
            if (!this.anIterator1703.hasNext()) {
                return null;
            }

            var1 = (Class27) this.anIterator1703.next();
        } while (var1.method199() == -1);

        return var1;
    }

    boolean method1263(int var1, int var2, int var3, int var4, int var5, int var6) {
        if (this.aSprite1695 == null) {
            return true;
        }
        if (this.aSprite1695.width == var1 && this.aSprite1695.height == var2) {
            if (this.aClass19_1713.anInt274 != this.anInt1699) {
                return true;
            }
            if (this.anInt1697 != client.anInt929) {
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
        this.aFont1719.method1154("Loading...", var7, var6 + var8, -1, -1);
    }

    public void method1279(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
        if (this.aClass214_1721.method1308()) {
            this.method1274();
            this.method1275();
            if (var3) {
                int var8 = (int) Math.ceil((double) ((float) var6 / this.aFloat1716));
                int var9 = (int) Math.ceil((double) ((float) var7 / this.aFloat1716));
                List var10 = this.aClass19_1713.method138(this.anInt1711 - var8 / 2 - 1, this.anInt1715 - var9 / 2 - 1, var8 / 2 + this.anInt1711 + 1, var9 / 2 + this.anInt1715 + 1, var4, var5, var6, var7, var1, var2);
                HashSet var11 = new HashSet();

                Iterator var12;
                Class27 var13;
                ScriptEvent var14;
                Class25 var15;
                for (var12 = var10.iterator(); var12.hasNext(); DefinitionProperty.fireScriptEvent(var14)) {
                    var13 = (Class27) var12.next();
                    var11.add(var13);
                    var14 = new ScriptEvent();
                    var15 = new Class25(var13.method199(), var13.aSceneOffset317, var13.aSceneOffset313);
                    var14.method1304(new Object[]{var15, var1, var2});
                    if (this.aHashSet1698.contains(var13)) {
                        var14.method1193(17);
                    } else {
                        var14.method1193(15);
                    }
                }

                var12 = this.aHashSet1698.iterator();

                while (var12.hasNext()) {
                    var13 = (Class27) var12.next();
                    if (!var11.contains(var13)) {
                        var14 = new ScriptEvent();
                        var15 = new Class25(var13.method199(), var13.aSceneOffset317, var13.aSceneOffset313);
                        var14.method1304(new Object[]{var15, var1, var2});
                        var14.method1193(16);
                        DefinitionProperty.fireScriptEvent(var14);
                    }
                }

                this.aHashSet1698 = var11;
            }
        }
    }

    public void method1253(int var1, int var2, SceneOffset var3, SceneOffset var4) {
        ScriptEvent var5 = new ScriptEvent();
        Class25 var6 = new Class25(var2, var3, var4);
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

        DefinitionProperty.fireScriptEvent(var5);
    }

    public void method1259(int var1, int var2, int var3, int var4, int var5, int var6) {
        if (this.aClass214_1721.method1308()) {
            int var7 = (int) Math.ceil((double) ((float) var3 / this.aFloat1716));
            int var8 = (int) Math.ceil((double) ((float) var4 / this.aFloat1716));
            List var9 = this.aClass19_1713.method138(this.anInt1711 - var7 / 2 - 1, this.anInt1715 - var8 / 2 - 1, var7 / 2 + this.anInt1711 + 1, var8 / 2 + this.anInt1715 + 1, var1, var2, var3, var4, var5, var6);
            if (!var9.isEmpty()) {
                Iterator var10 = var9.iterator();

                boolean var13;
                do {
                    if (!var10.hasNext()) {
                        return;
                    }

                    Class27 var11 = (Class27) var10.next();
                    DoublyLinkedNode_Sub15 var12 = Class98.method545(var11.method199());
                    var13 = false;

                    for (int var14 = this.anIntArray1696.length - 1; var14 >= 0; --var14) {
                        if (var12.aStringArray1470[var14] != null) {
                            Class63_Sub1.insertMenuItem(var12.aStringArray1470[var14], var12.aString1476, this.anIntArray1696[var14], var11.method199(), var11.aSceneOffset317.positionHash(), var11.aSceneOffset313.positionHash());
                            var13 = true;
                        }
                    }
                } while (!var13);

            }
        }
    }

    void method1270(int var1, int var2, int var3, int var4, int var5, int var6) {
        if (Enum_Sub5.aClass172_1216 != null) {
            int var7 = 512 / (this.aClass19_1713.anInt274 * 2);
            int var8 = var3 + 512;
            int var9 = var4 + 512;
            float var10 = 1.0F;
            var8 = (int) ((float) var8 / var10);
            var9 = (int) ((float) var9 / var10);
            int var11 = this.method1232() - var5 / 2 - var7;
            int var12 = this.method1234() - var6 / 2 - var7;
            int var13 = var1 - (var11 + var7 - this.anInt1694) * this.aClass19_1713.anInt274;
            int var14 = var2 - this.aClass19_1713.anInt274 * (var7 - (var12 - this.anInt1701));
            if (this.method1263(var8, var9, var13, var14, var3, var4)) {
                if (this.aSprite1695 != null && this.aSprite1695.width == var8 && this.aSprite1695.height == var9) {
                    Arrays.fill(this.aSprite1695.pixels, 0);
                } else {
                    this.aSprite1695 = new Sprite(var8, var9);
                }

                this.anInt1694 = this.method1232() - var5 / 2 - var7;
                this.anInt1701 = this.method1234() - var6 / 2 - var7;
                this.anInt1699 = this.aClass19_1713.anInt274;
                Enum_Sub5.aClass172_1216.method992(this.anInt1694, this.anInt1701, this.aSprite1695, (float) this.anInt1699 / var10);
                this.anInt1697 = client.anInt929;
                var13 = var1 - (var7 + var11 - this.anInt1694) * this.aClass19_1713.anInt274;
                var14 = var2 - this.aClass19_1713.anInt274 * (var7 - (var12 - this.anInt1701));
            }

            JagGraphics.method1370(var1, var2, var3, var4, 0, 128);
            if (1.0F == var10) {
                this.aSprite1695.method821(var13, var14, 192);
            } else {
                this.aSprite1695.method806(var13, var14, (int) (var10 * (float) var8), (int) ((float) var9 * var10), 192);
            }
        }

    }

    public void method1278(int var1, int var2, boolean var3, boolean var4) {
        long var5 = Class24.currentTime();
        this.method1276(var1, var2, var4, var5);
        if (!this.method1267() && (var4 || var3)) {
            if (var4) {
                this.anInt1676 = var1;
                this.anInt1678 = var2;
                this.anInt1673 = this.anInt1711;
                this.anInt1681 = this.anInt1715;
            }

            if (this.anInt1673 != -1) {
                int var7 = var1 - this.anInt1676;
                int var8 = var2 - this.anInt1678;
                this.method1271(this.anInt1673 - (int) ((float) var7 / this.aFloat1672), (int) ((float) var8 / this.aFloat1672) + this.anInt1681, false);
            }
        } else {
            this.method1281();
        }

        if (var4) {
            this.aLong1684 = var5;
            this.anInt1680 = var1;
            this.anInt1674 = var2;
        }

    }

    public void method1268(int var1, int var2, int var3, int var4, int var5) {
        int[] var6 = new int[4];
        JagGraphics.method1366(var6);
        JagGraphics.setClip(var1, var2, var3 + var1, var2 + var4);
        JagGraphics.fillRect(var1, var2, var3, var4, -16777216);
        int var7 = this.aClass214_1721.method1307();
        if (var7 < 100) {
            this.method1224(var1, var2, var3, var4, var7);
        } else {
            if (!this.aClass19_1713.method135()) {
                this.aClass19_1713.method145(this.aReferenceTable1720, this.aClass9_1712.method73(), client.membersWorld);
                if (!this.aClass19_1713.method135()) {
                    return;
                }
            }

            if (this.aHashSet1686 != null) {
                ++this.anInt1679;
                if (this.anInt1679 % this.anInt1671 == 0) {
                    this.anInt1679 = 0;
                    ++this.anInt1682;
                }

                if (this.anInt1682 >= this.anInt1685 && !this.aBoolean1691) {
                    this.aHashSet1686 = null;
                }
            }

            int var8 = (int) Math.ceil((double) ((float) var3 / this.aFloat1716));
            int var9 = (int) Math.ceil((double) ((float) var4 / this.aFloat1716));
            this.aClass19_1713.method142(this.anInt1711 - var8 / 2, this.anInt1715 - var9 / 2, var8 / 2 + this.anInt1711, var9 / 2 + this.anInt1715, var1, var3 + var1, var2 + var4);
            boolean var10;
            if (!this.aBoolean1687) {
                var10 = false;
                if (var5 - this.anInt1704 > 100) {
                    this.anInt1704 = var5;
                    var10 = true;
                }

                this.aClass19_1713.method141(this.anInt1711 - var8 / 2, this.anInt1715 - var9 / 2, var8 / 2 + this.anInt1711, var9 / 2 + this.anInt1715, var1, var3 + var1, var2 + var4, this.aHashSet1675, this.aHashSet1686, this.anInt1679, this.anInt1671, var10);
            }

            this.method1270(var1, var2, var3, var4, var8, var9);
            var10 = client.rights >= 2;
            if (var10 && this.aBoolean1705 && this.aSceneOffset1702 != null) {
                this.aFont1719.method1152("Coord: " + this.aSceneOffset1702, JagGraphics.drawingAreaLeft + 10, JagGraphics.drawingAreaTop + 20, 16776960, -1);
            }

            this.anInt1693 = var8;
            this.anInt1690 = var9;
            this.anInt1670 = var1;
            this.anInt1683 = var2;
            JagGraphics.method1373(var6);
        }
    }

    public void method1269(int var1, int var2, int var3, int var4) {
        if (this.aClass214_1721.method1308()) {
            if (!this.aClass19_1713.method135()) {
                this.aClass19_1713.method145(this.aReferenceTable1720, this.aClass9_1712.method73(), client.membersWorld);
                if (!this.aClass19_1713.method135()) {
                    return;
                }
            }

            this.aClass19_1713.method140(var1, var2, var3, var4, this.aHashSet1686, this.anInt1679, this.anInt1671);
        }
    }

    public void method1272() {
        Class7.aClass112_118.method666(5);
    }

    public void method1282(ReferenceTable var1, ReferenceTable var2, ReferenceTable var3, Font var4, HashMap var5, DoublyLinkedNode_Sub24_Sub4[] var6) {
        this.aDoublyNode_Sub24_Sub4Array1710 = var6;
        this.aReferenceTable1720 = var1;
        this.aReferenceTable1718 = var2;
        this.aReferenceTable1725 = var3;
        this.aFont1719 = var4;
        this.aHashMap1706 = new HashMap();
        this.aHashMap1706.put(Class65.aClass65_531, var5.get(aClass199_1714));
        this.aHashMap1706.put(Class65.aClass65_532, var5.get(aClass199_1708));
        this.aHashMap1706.put(Class65.aClass65_530, var5.get(aClass199_1707));
        this.aClass214_1721 = new Class214(var1);
        int var7 = this.aReferenceTable1720.method900(Class23.aClass23_297.aString292);
        int[] var8 = this.aReferenceTable1720.method894(var7);
        this.aHashMap1723 = new HashMap(var8.length);

        for (int aVar8 : var8) {
            Buffer var10 = new Buffer(this.aReferenceTable1720.unpack(var7, aVar8));
            Class9 var11 = new Class9();
            var11.method87(var10, aVar8);
            this.aHashMap1723.put(var11.method73(), var11);
            if (var11.method86()) {
                this.aClass9_1722 = var11;
            }
        }

        this.method1280(this.aClass9_1722);
        this.aClass9_1724 = null;
    }

    public void method1273(int var1) {
        Class9 var2 = this.method1242(var1);
        if (var2 != null) {
            this.method1280(var2);
        }

    }

    public int method1241() {
        if (1.0D == (double) this.aFloat1672) {
            return 25;
        }
        if ((double) this.aFloat1672 == 1.5D) {
            return 37;
        }
        if (2.0D == (double) this.aFloat1672) {
            return 50;
        }
        if ((double) this.aFloat1672 == 3.0D) {
            return 75;
        }
        return (double) this.aFloat1672 == 4.0D ? 100 : 200;
    }

    public void method1261(int var1, int var2, int var3, boolean var4) {
        Class9 var5 = this.method1262(var1, var2, var3);
        if (var5 == null) {
            if (!var4) {
                return;
            }

            var5 = this.aClass9_1722;
        }

        boolean var6 = false;
        if (var5 != this.aClass9_1724 || var4) {
            this.aClass9_1724 = var5;
            this.method1280(var5);
            var6 = true;
        }

        if (var6 || var4) {
            this.method1265(var1, var2, var3);
        }

    }

    public void method1226(int var1) {
        this.aFloat1672 = this.method1239(var1);
    }

    public boolean method1246() {
        return this.aClass214_1721.method1308();
    }

    public SceneOffset method1240() {
        return this.aClass9_1712 == null ? null : this.aClass9_1712.method79(this.method1232(), this.method1234());
    }

    public void method1227(int var1, int var2, int var3) {
        if (this.aClass9_1712 != null) {
            int[] var4 = this.aClass9_1712.method81(var1, var2, var3);
            if (var4 != null) {
                this.method1238(var4[0], var4[1]);
            }

        }
    }

    public void method1237(int var1, int var2, int var3) {
        if (this.aClass9_1712 != null) {
            int[] var4 = this.aClass9_1712.method81(var1, var2, var3);
            if (var4 != null) {
                this.method1235(var4[0], var4[1]);
            }

        }
    }

    public int method1260() {
        return this.aClass9_1712 == null ? -1 : this.aClass9_1712.method75();
    }

    public void method1231() {
        this.anInt1685 = 3;
    }

    public Class9 method1264() {
        return this.aClass9_1712;
    }

    public void method1233() {
        this.anInt1671 = 50;
    }

    public void method1245(int var1) {
        if (var1 >= 1) {
            this.anInt1685 = var1;
        }

    }

    public void method1243() {
        this.aHashSet1686 = null;
    }

    public void method1230(int var1) {
        if (var1 >= 1) {
            this.anInt1671 = var1;
        }

    }

    public void method1244(int var1) {
        this.aHashSet1686 = new HashSet();
        this.aHashSet1686.add(var1);
        this.anInt1682 = 0;
        this.anInt1679 = 0;
    }

    public void method1247(boolean var1) {
        this.aBoolean1691 = var1;
    }

    public void method1229(int var1) {
        this.aHashSet1686 = new HashSet();
        this.anInt1682 = 0;
        this.anInt1679 = 0;

        for (int var2 = 0; var2 < DoublyLinkedNode_Sub15.anInt378; ++var2) {
            if (Class98.method545(var2) != null && Class98.method545(var2).anInt1473 == var1) {
                this.aHashSet1686.add(Class98.method545(var2).anInt574);
            }
        }

    }

    public Class27 method1248() {
        if (!this.aClass214_1721.method1308()) {
            return null;
        }
        if (!this.aClass19_1713.method135()) {
            return null;
        }
        HashMap var1 = this.aClass19_1713.method144();
        this.aList1700 = new java.util.LinkedList();

        for (Object o : var1.values()) {
            List var3 = (List) o;
            this.aList1700.addAll(var3);
        }

        this.anIterator1703 = this.aList1700.iterator();
        return this.method1255();
    }

    public void method1258(boolean var1) {
        this.aBoolean1687 = !var1;
    }

    public boolean method1254() {
        return !this.aBoolean1687;
    }

    public void method1251(int var1, boolean var2) {
        if (!var2) {
            this.aHashSet1677.add(var1);
        } else {
            this.aHashSet1677.remove(var1);
        }

        this.method1256();
    }

    public void method1250(int var1, boolean var2) {
        if (!var2) {
            this.aHashSet1692.add(var1);
        } else {
            this.aHashSet1692.remove(var1);
        }

        for (int var3 = 0; var3 < DoublyLinkedNode_Sub15.anInt378; ++var3) {
            if (Class98.method545(var3) != null && Class98.method545(var3).anInt1473 == var1) {
                int var4 = Class98.method545(var3).anInt574;
                if (!var2) {
                    this.aHashSet1688.add(var4);
                } else {
                    this.aHashSet1688.remove(var4);
                }
            }
        }

        this.method1256();
    }

    public boolean method1257(int var1) {
        return !this.aHashSet1677.contains(var1);
    }

    public void method1277(Class9 var1, SceneOffset var2, SceneOffset var3, boolean var4) {
        if (var1 != null) {
            if (this.aClass9_1712 == null || var1 != this.aClass9_1712) {
                this.method1266(var1);
            }

            if (!var4 && this.aClass9_1712.method84(var2.floorLevel, var2.anInt1891, var2.anInt1892)) {
                this.method1265(var2.floorLevel, var2.anInt1891, var2.anInt1892);
            } else {
                this.method1265(var3.floorLevel, var3.anInt1891, var3.anInt1892);
            }

        }
    }

    public boolean method1252(int var1) {
        return !this.aHashSet1692.contains(var1);
    }

    public SceneOffset method1249(int var1, SceneOffset var2) {
        if (!this.aClass214_1721.method1308()) {
            return null;
        }
        if (!this.aClass19_1713.method135()) {
            return null;
        }
        if (!this.aClass9_1712.method83(var2.anInt1891, var2.anInt1892)) {
            return null;
        }
        HashMap var3 = this.aClass19_1713.method144();
        List var4 = (List) var3.get(var1);
        if (var4 != null && !var4.isEmpty()) {
            Class27 var5 = null;
            int var6 = -1;
            Iterator var7 = var4.iterator();

            while (true) {
                Class27 var8;
                int var11;
                do {
                    if (!var7.hasNext()) {
                        return var5.aSceneOffset313;
                    }

                    var8 = (Class27) var7.next();
                    int var9 = var8.aSceneOffset313.anInt1891 - var2.anInt1891;
                    int var10 = var8.aSceneOffset313.anInt1892 - var2.anInt1892;
                    var11 = var10 * var10 + var9 * var9;
                    if (var11 == 0) {
                        return var8.aSceneOffset313;
                    }
                } while (var11 >= var6 && var5 != null);

                var5 = var8;
                var6 = var11;
            }
        }
        return null;
    }

    public void method1225() {
        this.aClass214_1721.method1310();
    }
}
