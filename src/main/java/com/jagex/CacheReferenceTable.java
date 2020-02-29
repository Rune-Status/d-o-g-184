package com.jagex;

import java.util.zip.CRC32;

public class CacheReferenceTable extends ReferenceTable {
    static CRC32 aCRC32_674;
    static TextureProviderImpl aTextureProviderImpl672;

    static {
        aCRC32_674 = new CRC32();
    }

    CacheIndex aCacheIndex673;
    int anInt669;
    CacheIndex aCacheIndex676;
    volatile boolean aBoolean677;
    volatile boolean[] aBooleanArray675;
    int anInt678;
    int anInt679;
    int anInt670;
    boolean aBoolean671;

    public CacheReferenceTable(CacheIndex var1, CacheIndex var2, int var3, boolean var4, boolean var5, boolean var6) {
        super(var4, var5);
        this.aBoolean677 = false;
        this.aBoolean671 = false;
        this.anInt670 = -1;
        this.aCacheIndex676 = var1;
        this.aCacheIndex673 = var2;
        this.anInt678 = var3;
        this.aBoolean671 = var6;
        int var8 = this.anInt678;
        if (Class27.aBuffer314 != null) {
            Class27.aBuffer314.caret = var8 * 8 + 5;
            int var9 = Class27.aBuffer314.readInt();
            int var10 = Class27.aBuffer314.readInt();
            this.method493(var9, var10);
        } else {
            Class69.method377(null, 255, 255, 0, (byte) 0, true);
            Statics25.aCacheReferenceTableArray1498[var8] = this;
        }

    }

    static void method488() {
        for (int var0 = 0; var0 < GPI.playerCount; ++var0) {
            PlayerEntity var1 = client.players[GPI.playerIndices[var0]];
            var1.method827();
        }

    }

    static void method485() {
        if (Enum_Sub5.aClass172_1216 != null) {
            client.anInt929 = client.engineCycle;
            Enum_Sub5.aClass172_1216.method993();

            for (int var0 = 0; var0 < client.players.length; ++var0) {
                if (client.players[var0] != null) {
                    Enum_Sub5.aClass172_1216.method994(Statics18.baseX + (client.players[var0].fineX >> 7), Statics36.baseY + (client.players[var0].fineY >> 7));
                }
            }
        }

    }

    void method492(int var1) {
        if (this.aCacheIndex676 != null && this.aBooleanArray675 != null && this.aBooleanArray675[var1]) {
            Class9.method77(var1, this.aCacheIndex676, this);
        } else {
            Class69.method377(this, this.anInt678, var1, super.anIntArray1245[var1], (byte) 2, true);
        }

    }

    public boolean method496(int var1) {
        return this.method894(var1) != null;
    }

    int method497(int var1) {
        if (super.anObjectArray1239[var1] != null) {
            return 100;
        }
        if (this.aBooleanArray675[var1]) {
            return 100;
        }
        int var2 = this.anInt678;
        long var3 = (long) ((var2 << 16) + var1);
        int var5;
        if (Class25.aDoublyNode_Sub7_303 != null && Class25.aDoublyNode_Sub7_303.key == var3) {
            var5 = Class104.aBuffer771.caret * 99 / (Class104.aBuffer771.payload.length - Class25.aDoublyNode_Sub7_303.aByte1220) + 1;
        } else {
            var5 = 0;
        }

        return var5;
    }

    void method487() {
        this.aBooleanArray675 = new boolean[super.anObjectArray1239.length];

        int var1;
        for (var1 = 0; var1 < this.aBooleanArray675.length; ++var1) {
            this.aBooleanArray675[var1] = false;
        }

        if (this.aCacheIndex676 == null) {
            this.aBoolean677 = true;
        } else {
            this.anInt670 = -1;

            for (var1 = 0; var1 < this.aBooleanArray675.length; ++var1) {
                if (super.childrenCounts[var1] > 0) {
                    CacheIndex var2 = this.aCacheIndex676;
                    FileSystem var4 = new FileSystem();
                    var4.anInt380 = 1;
                    var4.key = (long) var1;
                    var4.index = var2;
                    var4.table = this;
                    synchronized (Class174.aNodeDeque1465) {
                        Class174.aNodeDeque1465.add(var4);
                    }

                    synchronized (Class174.anObject1463) {
                        if (Class174.anInt1464 == 0) {
                            AssociateComparator_Sub5.aThread815 = new Thread(new Class174());
                            AssociateComparator_Sub5.aThread815.setDaemon(true);
                            AssociateComparator_Sub5.aThread815.start();
                            AssociateComparator_Sub5.aThread815.setPriority(5);
                        }

                        Class174.anInt1464 = 600;
                    }

                    this.anInt670 = var1;
                }
            }

            if (this.anInt670 == -1) {
                this.aBoolean677 = true;
            }

        }
    }

    void method490(int var1) {
        int var2 = this.anInt678;
        long var3 = (long) ((var2 << 16) + var1);
        DoublyLinkedNode_Sub7 var5 = (DoublyLinkedNode_Sub7) Statics25.aNodeTable1503.lookup(var3);
        if (var5 != null) {
            Statics25.aQueue1493.method301(var5);
        }

    }

    public boolean method495(int var1) {
        return this.aBooleanArray675[var1];
    }

    public void method486(CacheIndex var1, int var2, byte[] var3, boolean var4) {
        int var5;
        if (var1 == this.aCacheIndex673) {
            if (this.aBoolean677) {
                throw new RuntimeException();
            }

            if (var3 == null) {
                Class69.method377(this, 255, this.anInt678, this.anInt669, (byte) 0, true);
                return;
            }

            aCRC32_674.reset();
            aCRC32_674.update(var3, 0, var3.length);
            var5 = (int) aCRC32_674.getValue();
            if (var5 != this.anInt669) {
                Class69.method377(this, 255, this.anInt678, this.anInt669, (byte) 0, true);
                return;
            }

            Buffer buffer = new Buffer(ReferenceTable.decodeContainer(var3));
            int format = buffer.readUByte();
            if (format != 5 && format != 6) {
                throw new RuntimeException(format + "," + this.anInt678 + "," + var2);
            }

            int version = 0;
            if (format >= 6) {
                version = buffer.readInt();
            }

            if (version != this.anInt679) {
                Class69.method377(this, 255, this.anInt678, this.anInt669, (byte) 0, true);
                return;
            }

            this.decode(var3);
            this.method487();
        } else {
            if (!var4 && var2 == this.anInt670) {
                this.aBoolean677 = true;
            }

            if (var3 == null || var3.length <= 2) {
                this.aBooleanArray675[var2] = false;
                if (this.aBoolean671 || var4) {
                    Class69.method377(this, this.anInt678, var2, super.anIntArray1245[var2], (byte) 2, var4);
                }

                return;
            }

            aCRC32_674.reset();
            aCRC32_674.update(var3, 0, var3.length - 2);
            var5 = (int) aCRC32_674.getValue();
            int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
            if (var5 != super.anIntArray1245[var2] || var6 != super.anIntArray1246[var2]) {
                this.aBooleanArray675[var2] = false;
                if (this.aBoolean671 || var4) {
                    Class69.method377(this, this.anInt678, var2, super.anIntArray1245[var2], (byte) 2, var4);
                }

                return;
            }

            this.aBooleanArray675[var2] = true;
            if (var4) {
                super.anObjectArray1239[var2] = Class78.method422(var3);
            }
        }

    }

    void method493(int var1, int var2) {
        this.anInt669 = var1;
        this.anInt679 = var2;
        if (this.aCacheIndex673 != null) {
            Class9.method77(this.anInt678, this.aCacheIndex673, this);
        } else {
            Class69.method377(this, 255, this.anInt678, this.anInt669, (byte) 0, true);
        }

    }

    void method498(int var1, byte[] var2, boolean var3, boolean var4) {
        if (var3) {
            if (this.aBoolean677) {
                throw new RuntimeException();
            }

            if (this.aCacheIndex673 != null) {
                CollisionMap.method163(this.anInt678, var2, this.aCacheIndex673);
            }

            this.decode(var2);
            this.method487();
        } else {
            var2[var2.length - 2] = (byte) (super.anIntArray1246[var1] >> 8);
            var2[var2.length - 1] = (byte) super.anIntArray1246[var1];
            if (this.aCacheIndex676 != null) {
                CollisionMap.method163(var1, var2, this.aCacheIndex676);
                this.aBooleanArray675[var1] = true;
            }

            if (var4) {
                super.anObjectArray1239[var1] = Class78.method422(var2);
            }
        }

    }

    public int method494() {
        if (this.aBoolean677) {
            return 100;
        }
        if (super.anObjectArray1239 != null) {
            return 99;
        }
        int var1 = this.anInt678;
        long var2 = (long) (var1 + 16711680);
        int var4;
        if (Class25.aDoublyNode_Sub7_303 != null && Class25.aDoublyNode_Sub7_303.key == var2) {
            var4 = Class104.aBuffer771.caret * 99 / (Class104.aBuffer771.payload.length - Class25.aDoublyNode_Sub7_303.aByte1220) + 1;
        } else {
            var4 = 0;
        }

        int var5 = var4;
        if (var4 >= 100) {
            var5 = 99;
        }

        return var5;
    }

    public int method489() {
        int var1 = 0;
        int var2 = 0;

        int var3;
        for (var3 = 0; var3 < super.anObjectArray1239.length; ++var3) {
            if (super.childrenCounts[var3] > 0) {
                var1 += 100;
                var2 += this.method497(var3);
            }
        }

        if (var1 == 0) {
            return 100;
        }
        var3 = var2 * 100 / var1;
        return var3;
    }

    public boolean method491() {
        return this.aBoolean677;
    }
}
