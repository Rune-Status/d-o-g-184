package com.jagex;

import java.io.IOException;

public class PlayerAppearance {
    static final int[] anIntArray1926;
    public static short[][] aShortArrayArray1928;
    public static short[] aShortArray1927;
    static ReferenceCache aReferenceCache1924;

    static {
        anIntArray1926 = new int[]{8, 11, 4, 6, 9, 7, 10};
        aReferenceCache1924 = new ReferenceCache(260);
    }

    public int transformedNpcId;
    public boolean female;
    int[] ids;
    long aLong1925;
    int[] equipmentIds;
    long aLong1923;

    public static boolean loadWorlds() {
        long var1 = Class24.currentTime();
        int var3 = (int) (var1 - Statics25.aLong1501);
        Statics25.aLong1501 = var1;
        if (var3 > 200) {
            var3 = 200;
        }

        Statics25.anInt1494 += var3;
        if (Statics25.anInt1486 == 0 && Statics25.anInt1496 == 0 && Statics25.anInt1491 == 0 && Statics25.anInt1497 == 0) {
            return true;
        }
        if (Statics25.connection == null) {
            return false;
        }
        try {
            if (Statics25.anInt1494 > 30000) {
                throw new IOException();
            }
            DoublyLinkedNode_Sub7 var4;
            Buffer var5;
            while (Statics25.anInt1496 < 200 && Statics25.anInt1497 > 0) {
                var4 = (DoublyLinkedNode_Sub7) Statics25.aNodeTable1500.method314();
                var5 = new Buffer(4);
                var5.writeByte(1);
                var5.writeMediumInt((int) var4.key);
                Statics25.connection.writeBytes(var5.payload, 0, 4);
                Statics25.aNodeTable1495.put(var4, var4.key);
                --Statics25.anInt1497;
                ++Statics25.anInt1496;
            }

            while (Statics25.anInt1486 < 200 && Statics25.anInt1491 > 0) {
                var4 = (DoublyLinkedNode_Sub7) Statics25.aQueue1493.method299();
                var5 = new Buffer(4);
                var5.writeByte(0);
                var5.writeMediumInt((int) var4.key);
                Statics25.connection.writeBytes(var5.payload, 0, 4);
                var4.unlinkDoubly();
                Statics25.aNodeTable1487.put(var4, var4.key);
                --Statics25.anInt1491;
                ++Statics25.anInt1486;
            }

            for (int var6 = 0; var6 < 100; ++var6) {
                int var7 = Statics25.connection.readable();
                if (var7 < 0) {
                    throw new IOException();
                }

                if (var7 == 0) {
                    break;
                }

                Statics25.anInt1494 = 0;
                byte var8 = 0;
                if (Class25.aDoublyNode_Sub7_303 == null) {
                    var8 = 8;
                } else if (Statics25.anInt1499 == 0) {
                    var8 = 1;
                }

                int var9;
                int var10;
                int var11;
                int var13;
                byte[] var10000;
                int var10001;
                Buffer var23;
                if (var8 > 0) {
                    var9 = var8 - Statics25.aBuffer1489.caret;
                    if (var9 > var7) {
                        var9 = var7;
                    }

                    Statics25.connection.readBytes(Statics25.aBuffer1489.payload, Statics25.aBuffer1489.caret, var9);
                    if (Statics25.aByte1490 != 0) {
                        for (var10 = 0; var10 < var9; ++var10) {
                            var10000 = Statics25.aBuffer1489.payload;
                            var10001 = Statics25.aBuffer1489.caret + var10;
                            var10000[var10001] ^= Statics25.aByte1490;
                        }
                    }

                    var23 = Statics25.aBuffer1489;
                    var23.caret += var9;
                    if (Statics25.aBuffer1489.caret < var8) {
                        break;
                    }

                    if (Class25.aDoublyNode_Sub7_303 == null) {
                        Statics25.aBuffer1489.caret = 0;
                        var10 = Statics25.aBuffer1489.readUByte();
                        var11 = Statics25.aBuffer1489.readUShort();
                        int var12 = Statics25.aBuffer1489.readUByte();
                        var13 = Statics25.aBuffer1489.readInt();
                        long var14 = (long) (var11 + (var10 << 16));
                        DoublyLinkedNode_Sub7 var16 = (DoublyLinkedNode_Sub7) Statics25.aNodeTable1495.lookup(var14);
                        AssociateComparator_Sub4.aBoolean804 = true;
                        if (var16 == null) {
                            var16 = (DoublyLinkedNode_Sub7) Statics25.aNodeTable1487.lookup(var14);
                            AssociateComparator_Sub4.aBoolean804 = false;
                        }

                        if (var16 == null) {
                            throw new IOException();
                        }

                        int var17 = var12 == 0 ? 5 : 9;
                        Class25.aDoublyNode_Sub7_303 = var16;
                        Class104.aBuffer771 = new Buffer(var13 + var17 + Class25.aDoublyNode_Sub7_303.aByte1220);
                        Class104.aBuffer771.writeByte(var12);
                        Class104.aBuffer771.writeInt(var13);
                        Statics25.anInt1499 = 8;
                        Statics25.aBuffer1489.caret = 0;
                    } else if (Statics25.anInt1499 == 0) {
                        if (Statics25.aBuffer1489.payload[0] == -1) {
                            Statics25.anInt1499 = 1;
                            Statics25.aBuffer1489.caret = 0;
                        } else {
                            Class25.aDoublyNode_Sub7_303 = null;
                        }
                    }
                } else {
                    var9 = Class104.aBuffer771.payload.length - Class25.aDoublyNode_Sub7_303.aByte1220;
                    var10 = 512 - Statics25.anInt1499;
                    if (var10 > var9 - Class104.aBuffer771.caret) {
                        var10 = var9 - Class104.aBuffer771.caret;
                    }

                    if (var10 > var7) {
                        var10 = var7;
                    }

                    Statics25.connection.readBytes(Class104.aBuffer771.payload, Class104.aBuffer771.caret, var10);
                    if (Statics25.aByte1490 != 0) {
                        for (var11 = 0; var11 < var10; ++var11) {
                            var10000 = Class104.aBuffer771.payload;
                            var10001 = var11 + Class104.aBuffer771.caret;
                            var10000[var10001] ^= Statics25.aByte1490;
                        }
                    }

                    var23 = Class104.aBuffer771;
                    var23.caret += var10;
                    Statics25.anInt1499 += var10;
                    if (var9 == Class104.aBuffer771.caret) {
                        if (16711935L == Class25.aDoublyNode_Sub7_303.key) {
                            Class27.aBuffer314 = Class104.aBuffer771;

                            for (var11 = 0; var11 < 256; ++var11) {
                                CacheReferenceTable var18 = Statics25.aCacheReferenceTableArray1498[var11];
                                if (var18 != null) {
                                    Class27.aBuffer314.caret = var11 * 8 + 5;
                                    var13 = Class27.aBuffer314.readInt();
                                    int var19 = Class27.aBuffer314.readInt();
                                    var18.method493(var13, var19);
                                }
                            }
                        } else {
                            Statics25.aCRC32_1502.reset();
                            Statics25.aCRC32_1502.update(Class104.aBuffer771.payload, 0, var9);
                            var11 = (int) Statics25.aCRC32_1502.getValue();
                            if (var11 != Class25.aDoublyNode_Sub7_303.anInt568) {
                                try {
                                    Statics25.connection.stop();
                                } catch (Exception ignored) {
                                }

                                ++Statics25.anInt1492;
                                Statics25.connection = null;
                                Statics25.aByte1490 = (byte) ((int) (Math.random() * 255.0D + 1.0D));
                                return false;
                            }

                            Statics25.anInt1492 = 0;
                            Statics25.anInt1488 = 0;
                            Class25.aDoublyNode_Sub7_303.aCacheReferenceTable1221.method498((int) (Class25.aDoublyNode_Sub7_303.key & 65535L), Class104.aBuffer771.payload, (Class25.aDoublyNode_Sub7_303.key & 16711680L) == 16711680L, AssociateComparator_Sub4.aBoolean804);
                        }

                        Class25.aDoublyNode_Sub7_303.unlink();
                        if (AssociateComparator_Sub4.aBoolean804) {
                            --Statics25.anInt1496;
                        } else {
                            --Statics25.anInt1486;
                        }

                        Statics25.anInt1499 = 0;
                        Class25.aDoublyNode_Sub7_303 = null;
                        Class104.aBuffer771 = null;
                    } else {
                        if (Statics25.anInt1499 != 512) {
                            break;
                        }

                        Statics25.anInt1499 = 0;
                    }
                }
            }

            return true;
        } catch (IOException var22) {
            try {
                Statics25.connection.stop();
            } catch (Exception ignored) {
            }

            ++Statics25.anInt1488;
            Statics25.connection = null;
            return false;
        }
    }

    static Enum_Sub9[] method1435() {
        return new Enum_Sub9[]{Enum_Sub9.anEnum_Sub9_1483, Enum_Sub9.anEnum_Sub9_1484, Enum_Sub9.anEnum_Sub9_1485};
    }

    static int method1426(int var0) {
        return (int) Math.pow(2.0D, (double) (7.0F + (float) var0 / 256.0F));
    }

    public void update(int[] equipmentIds, int[] ids, boolean female, int transformedNpcId) {
        if (equipmentIds == null) {
            equipmentIds = new int[12];

            for (int var5 = 0; var5 < 7; ++var5) {
                for (int var6 = 0; var6 < Class12.anInt143; ++var6) {
                    DoublyLinkedNode_Sub21 var7 = Statics21.method923(var6);
                    if (var7 != null && !var7.aBoolean1517 && var5 + (female ? 7 : 0) == var7.anInt574) {
                        equipmentIds[anIntArray1926[var5]] = var6 + 256;
                        break;
                    }
                }
            }
        }

        this.equipmentIds = equipmentIds;
        this.ids = ids;
        this.female = female;
        this.transformedNpcId = transformedNpcId;
        this.method1429();
    }

    void method1429() {
        long var1 = this.aLong1925;
        int var3 = this.equipmentIds[5];
        int var4 = this.equipmentIds[9];
        this.equipmentIds[5] = var4;
        this.equipmentIds[9] = var3;
        this.aLong1925 = 0L;

        int var5;
        for (var5 = 0; var5 < 12; ++var5) {
            this.aLong1925 <<= 4;
            if (this.equipmentIds[var5] >= 256) {
                this.aLong1925 += (long) (this.equipmentIds[var5] - 256);
            }
        }

        if (this.equipmentIds[0] >= 256) {
            this.aLong1925 += (long) (this.equipmentIds[0] - 256 >> 4);
        }

        if (this.equipmentIds[1] >= 256) {
            this.aLong1925 += (long) (this.equipmentIds[1] - 256 >> 8);
        }

        for (var5 = 0; var5 < 5; ++var5) {
            this.aLong1925 <<= 3;
            this.aLong1925 += (long) this.ids[var5];
        }

        this.aLong1925 <<= 1;
        this.aLong1925 += (long) (this.female ? 1 : 0);
        this.equipmentIds[5] = var3;
        this.equipmentIds[9] = var4;
        if (var1 != 0L && this.aLong1925 != var1) {
            aReferenceCache1924.method337(var1);
        }

    }

    public Model getModel(AnimationSequence var1, int var2, AnimationSequence var3, int var4) {
        if (this.transformedNpcId != -1) {
            return OutgoingPacket.getNpcDefinition(this.transformedNpcId).getModel(var1, var2, var3, var4);
        }
        long var6 = this.aLong1925;
        int[] var8 = this.equipmentIds;
        if (var1 != null && (var1.offHand >= 0 || var1.mainHand >= 0)) {
            var8 = new int[12];

            System.arraycopy(this.equipmentIds, 0, var8, 0, 12);

            if (var1.offHand >= 0) {
                var6 += (long) (var1.offHand - this.equipmentIds[5] << 8);
                var8[5] = var1.offHand;
            }

            if (var1.mainHand >= 0) {
                var6 += (long) (var1.mainHand - this.equipmentIds[3] << 16);
                var8[3] = var1.mainHand;
            }
        }

        Model var9 = (Model) aReferenceCache1924.get(var6);
        if (var9 == null) {
            boolean var11 = false;

            int var13;
            for (int var12 = 0; var12 < 12; ++var12) {
                var13 = var8[var12];
                if (var13 >= 256 && var13 < 512 && !Statics21.method923(var13 - 256).method1114()) {
                    var11 = true;
                }

                if (var13 >= 512 && !CameraCapture.getItemDefinition(var13 - 512).method518(this.female)) {
                    var11 = true;
                }
            }

            if (var11) {
                if (-1L != this.aLong1923) {
                    var9 = (Model) aReferenceCache1924.get(this.aLong1923);
                }

                if (var9 == null) {
                    return null;
                }
            }

            if (var9 == null) {
                UnlitModel[] var14 = new UnlitModel[12];
                var13 = 0;

                int var16;
                for (int var15 = 0; var15 < 12; ++var15) {
                    var16 = var8[var15];
                    UnlitModel var17;
                    if (var16 >= 256 && var16 < 512) {
                        var17 = Statics21.method923(var16 - 256).method978();
                        if (var17 != null) {
                            var14[var13++] = var17;
                        }
                    }

                    if (var16 >= 512) {
                        var17 = CameraCapture.getItemDefinition(var16 - 512).getEquipmentModel(this.female);
                        if (var17 != null) {
                            var14[var13++] = var17;
                        }
                    }
                }

                UnlitModel var19 = new UnlitModel(var14, var13);

                for (var16 = 0; var16 < 5; ++var16) {
                    if (this.ids[var16] < aShortArrayArray1928[var16].length) {
                        var19.texturize(Enum_Sub9.aShortArray1482[var16], aShortArrayArray1928[var16][this.ids[var16]]);
                    }

                    if (this.ids[var16] < Class12.aShortArrayArray145[var16].length) {
                        var19.texturize(aShortArray1927[var16], Class12.aShortArrayArray145[var16][this.ids[var16]]);
                    }
                }

                var9 = var19.light(64, 850, -30, -50, -30);
                aReferenceCache1924.put(var9, var6);
                this.aLong1923 = var6;
            }
        }

        if (var1 == null && var3 == null) {
            return var9;
        }
        Model var18;
        if (var1 != null && var3 != null) {
            var18 = var1.applyStanceAndAnimation(var9, var2, var3, var4);
        } else if (var1 != null) {
            var18 = var1.applySequence(var9, var2);
        } else {
            var18 = var3.applySequence(var9, var4);
        }

        return var18;
    }

    UnlitModel method1427() {
        if (this.transformedNpcId != -1) {
            return OutgoingPacket.getNpcDefinition(this.transformedNpcId).method507();
        }
        boolean var1 = false;

        int var3;
        for (int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if (var3 >= 256 && var3 < 512 && !Statics21.method923(var3 - 256).method882()) {
                var1 = true;
            }

            if (var3 >= 512 && !CameraCapture.getItemDefinition(var3 - 512).method530(this.female)) {
                var1 = true;
            }
        }

        if (var1) {
            return null;
        }
        UnlitModel[] var4 = new UnlitModel[12];
        var3 = 0;

        int var6;
        for (int var5 = 0; var5 < 12; ++var5) {
            var6 = this.equipmentIds[var5];
            UnlitModel var7;
            if (var6 >= 256 && var6 < 512) {
                var7 = Statics21.method923(var6 - 256).method1113();
                if (var7 != null) {
                    var4[var3++] = var7;
                }
            }

            if (var6 >= 512) {
                var7 = CameraCapture.getItemDefinition(var6 - 512).method521(this.female);
                if (var7 != null) {
                    var4[var3++] = var7;
                }
            }
        }

        UnlitModel var8 = new UnlitModel(var4, var3);

        for (var6 = 0; var6 < 5; ++var6) {
            if (this.ids[var6] < aShortArrayArray1928[var6].length) {
                var8.texturize(Enum_Sub9.aShortArray1482[var6], aShortArrayArray1928[var6][this.ids[var6]]);
            }

            if (this.ids[var6] < Class12.aShortArrayArray145[var6].length) {
                var8.texturize(aShortArray1927[var6], Class12.aShortArrayArray145[var6][this.ids[var6]]);
            }
        }

        return var8;
    }

    public void method1428(int var1, boolean var2) {
        if (var1 != 1 || !this.female) {
            int var3 = this.equipmentIds[anIntArray1926[var1]];
            if (var3 != 0) {
                var3 -= 256;

                DoublyLinkedNode_Sub21 var4;
                do {
                    if (!var2) {
                        --var3;
                        if (var3 < 0) {
                            var3 = Class12.anInt143 - 1;
                        }
                    } else {
                        ++var3;
                        if (var3 >= Class12.anInt143) {
                            var3 = 0;
                        }
                    }

                    var4 = Statics21.method923(var3);
                } while (var4 == null || var4.aBoolean1517 || var4.anInt574 != var1 + (this.female ? 7 : 0));

                this.equipmentIds[anIntArray1926[var1]] = var3 + 256;
                this.method1429();
            }
        }
    }

    public void method1432(int var1, boolean var2) {
        int var3 = this.ids[var1];
        if (!var2) {
            do {
                --var3;
                if (var3 < 0) {
                    var3 = aShortArrayArray1928[var1].length - 1;
                }
            } while (!Statics25.method1094(var1, var3));
        } else {
            do {
                ++var3;
                if (var3 >= aShortArrayArray1928[var1].length) {
                    var3 = 0;
                }
            } while (!Statics25.method1094(var1, var3));
        }

        this.ids[var1] = var3;
        this.method1429();
    }

    public void method1431(boolean var1) {
        if (this.female != var1) {
            this.update(null, this.ids, var1, -1);
        }
    }

    public void method1430(Buffer var1) {
        var1.writeByte(this.female ? 1 : 0);

        int var2;
        for (var2 = 0; var2 < 7; ++var2) {
            int var3 = this.equipmentIds[anIntArray1926[var2]];
            if (var3 == 0) {
                var1.writeByte(-1);
            } else {
                var1.writeByte(var3 - 256);
            }
        }

        for (var2 = 0; var2 < 5; ++var2) {
            var1.writeByte(this.ids[var2]);
        }

    }

    public int method1433() {
        return this.transformedNpcId == -1 ? (this.equipmentIds[0] << 15) + this.equipmentIds[1] + (this.equipmentIds[11] << 5) + (this.equipmentIds[8] << 10) + (this.ids[0] << 25) + (this.ids[4] << 20) : 305419896 + OutgoingPacket.getNpcDefinition(this.transformedNpcId).id;
    }
}
