package jag.worldmap;

import jag.commons.collection.DoublyLinkedNode;
import jag.commons.collection.ReferenceCache;
import jag.graphics.Sprite;
import jag.js5.ReferenceTable;
import jag.opcode.Buffer;
import jag.opcode.OldConnection;

public class WorldMapFunction extends DoublyLinkedNode {

    public static final ReferenceCache cache;
    public static WorldMapFunction[] aDoublyNode_Sub15Array1475;
    public static int anInt378;
    public static ReferenceTable table;

    static {
        cache = new ReferenceCache(256);
    }

    public final int anInt574;
    public int spriteId;
    public String aString1474;
    public Enum_Sub9 anEnum_Sub9_1477;
    public int anInt379;
    public Enum_Sub8 anEnum_Sub8_1472;
    public int anInt564;
    public String[] aStringArray1470;
    public int anInt1473;
    public String aString1476;
    int[] anIntArray1469;
    int anInt375;
    int anInt696;
    int anInt788;
    int anInt702;
    int anInt666;
    int[] anIntArray787;
    byte[] aByteArray1471;

    public WorldMapFunction(int var1) {
        this.spriteId = -1;
        this.anInt375 = -1;
        this.anInt564 = 0;
        this.aStringArray1470 = new String[5];
        this.anInt696 = Integer.MAX_VALUE;
        this.anInt702 = Integer.MAX_VALUE;
        this.anInt788 = Integer.MIN_VALUE;
        this.anInt666 = Integer.MIN_VALUE;
        this.anEnum_Sub9_1477 = Enum_Sub9.anEnum_Sub9_1485;
        this.anEnum_Sub8_1472 = Enum_Sub8.anEnum_Sub8_1481;
        this.anInt1473 = -1;
        this.anInt574 = var1;
    }

    public static WorldMapFunction get(int var0) {
        return var0 >= 0 && var0 < aDoublyNode_Sub15Array1475.length && aDoublyNode_Sub15Array1475[var0] != null ? aDoublyNode_Sub15Array1475[var0] : new WorldMapFunction(var0);
    }

    public Sprite getSprite() {
        int id = this.spriteId;
        return this.getSprite(id);
    }

    Sprite getSprite(int var1) {
        if (var1 < 0) {
            return null;
        }
        Sprite var2 = (Sprite) cache.get(var1);
        if (var2 != null) {
            return var2;
        }
        var2 = Sprite.get(table, var1, 0);
        if (var2 != null) {
            cache.put(var2, var1);
        }

        return var2;
    }

    void decode(Buffer var1, int var2) {
        if (var2 == 1) {
            this.spriteId = var1.method1051();
        } else if (var2 == 2) {
            this.anInt375 = var1.method1051();
        } else if (var2 == 3) {
            this.aString1474 = var1.readString();
        } else if (var2 == 4) {
            this.anInt379 = var1.readMediumInt();
        } else if (var2 == 5) {
            var1.readMediumInt();
        } else if (var2 == 6) {
            this.anInt564 = var1.readUByte();
        } else {
            int var3;
            if (var2 == 7) {
                var3 = var1.readUByte();
                if ((var3 & 1) == 0) {

                }

                if ((var3 & 2) == 2) {

                }
            } else if (var2 == 8) {
                var1.readUByte();
            } else if (var2 >= 10 && var2 <= 14) {
                this.aStringArray1470[var2 - 10] = var1.readString();
            } else if (var2 == 15) {
                var3 = var1.readUByte();
                this.anIntArray1469 = new int[var3 * 2];

                for (int var4 = 0; var4 < var3 * 2; ++var4) {
                    this.anIntArray1469[var4] = var1.method1029();
                }

                var1.readInt();
                int var4 = var1.readUByte();
                this.anIntArray787 = new int[var4];

                for (int var5 = 0; var5 < this.anIntArray787.length; ++var5) {
                    this.anIntArray787[var5] = var1.readInt();
                }

                this.aByteArray1471 = new byte[var3];

                for (int var5 = 0; var5 < var3; ++var5) {
                    this.aByteArray1471[var5] = var1.readByte();
                }
            } else if (var2 != 16) {
                if (var2 == 17) {
                    this.aString1476 = var1.readString();
                } else if (var2 == 18) {
                    var1.method1051();
                } else if (var2 == 19) {
                    this.anInt1473 = var1.readUShort();
                } else if (var2 == 21) {
                    var1.readInt();
                } else if (var2 == 22) {
                    var1.readInt();
                } else if (var2 == 23) {
                    var1.readUByte();
                    var1.readUByte();
                    var1.readUByte();
                } else if (var2 == 24) {
                    var1.method1029();
                    var1.method1029();
                } else if (var2 == 25) {
                    var1.method1051();
                } else if (var2 == 28) {
                    var1.readUByte();
                } else if (var2 == 29) {
                    this.anEnum_Sub9_1477 = (Enum_Sub9) OldConnection.method716(Enum_Sub9.valuess(), var1.readUByte());
                } else if (var2 == 30) {
                    Enum_Sub8[] var6 = new Enum_Sub8[]{Enum_Sub8.anEnum_Sub8_1480, Enum_Sub8.anEnum_Sub8_1479, Enum_Sub8.anEnum_Sub8_1481};
                    this.anEnum_Sub8_1472 = (Enum_Sub8) OldConnection.method716(var6, var1.readUByte());
                }
            }
        }

    }

    public int method1082() {
        return this.anInt574;
    }

    public void decode(Buffer var1) {
        while (true) {
            int var2 = var1.readUByte();
            if (var2 == 0) {
                return;
            }

            this.decode(var1, var2);
        }
    }

    public void method775() {
        if (this.anIntArray1469 != null) {
            for (int var1 = 0; var1 < this.anIntArray1469.length; var1 += 2) {
                if (this.anIntArray1469[var1] < this.anInt696) {
                    this.anInt696 = this.anIntArray1469[var1];
                } else if (this.anIntArray1469[var1] > this.anInt788) {
                    this.anInt788 = this.anIntArray1469[var1];
                }

                if (this.anIntArray1469[var1 + 1] < this.anInt702) {
                    this.anInt702 = this.anIntArray1469[var1 + 1];
                } else if (this.anIntArray1469[var1 + 1] > this.anInt666) {
                    this.anInt666 = this.anIntArray1469[var1 + 1];
                }
            }
        }

    }
}
