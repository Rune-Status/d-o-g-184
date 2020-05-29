package jag.js5;

import jag.game.client;
import jag.game.stockmarket.StockMarketMediator;
import jag.graphics.DefaultMaterialProvider;
import jag.opcode.Buffer;
import jag.worldmap.WorldMapIcon;
import jag.worldmap.WorldMapDecor;
import jag.worldmap.WorldMapArea;

import java.util.zip.CRC32;

public class Archive extends ReferenceTable {

    static final CRC32 aCRC32_674;
    public static DefaultMaterialProvider textureProvider;

    static {
        aCRC32_674 = new CRC32();
    }

    ResourceCache meta;
    int anInt669;
    ResourceCache cache;
    volatile boolean aBoolean677;
    volatile boolean[] aBooleanArray675;
    int anInt678;
    int anInt679;
    int anInt670;
    boolean aBoolean671;

    public Archive(ResourceCache cache, ResourceCache meta, int var3, boolean var4, boolean var5, boolean var6) {
        super(var4, var5);
        this.aBoolean677 = false;
        this.aBoolean671 = false;
        this.anInt670 = -1;
        this.cache = cache;
        this.meta = meta;
        this.anInt678 = var3;
        this.aBoolean671 = var6;
        int var8 = this.anInt678;
        if (WorldMapIcon.aBuffer314 != null) {
            WorldMapIcon.aBuffer314.caret = var8 * 8 + 5;
            int var9 = WorldMapIcon.aBuffer314.readInt();
            int var10 = WorldMapIcon.aBuffer314.readInt();
            this.method493(var9, var10);
        } else {
            WorldMapDecor.method377(null, 255, 255, 0, (byte) 0, true);
            NetWorker.A_ARCHIVE_RESOURCE_PROVIDER_ARRAY_1498[var8] = this;
        }

    }

    public static void method485() {
        if (client.class69 != null) {
            client.anInt929 = client.engineCycle;
            client.class69.method993();

            for (int var0 = 0; var0 < client.players.length; ++var0) {
                if (client.players[var0] != null) {
                    client.class69.method994(client.baseX + (client.players[var0].fineX >> 7), client.baseY + (client.players[var0].fineY >> 7));
                }
            }
        }

    }

    void method492(int var1) {
        if (this.cache != null && aBooleanArray675 != null && aBooleanArray675[var1]) {
            WorldMapArea.method77(var1, cache, this);
        } else {
            WorldMapDecor.method377(this, anInt678, var1, super.anIntArray1245[var1], (byte) 2, true);
        }

    }

    public boolean method496(int var1) {
        return getFileIds(var1) != null;
    }

    int method497(int var1) {
        if (super.anObjectArray1239[var1] != null) {
            return 100;
        }
        if (aBooleanArray675[var1]) {
            return 100;
        }
        int var2 = anInt678;
        long var3 = (var2 << 16) + var1;
        int var5;
        if (NetWorker.current != null && NetWorker.current.key == var3) {
            var5 = CacheRequestWorker.buffer.caret * 99 / (CacheRequestWorker.buffer.payload.length - NetWorker.current.aByte1220) + 1;
        } else {
            var5 = 0;
        }

        return var5;
    }

    void method487() {
        aBooleanArray675 = new boolean[super.anObjectArray1239.length];

        int var1;
        for (var1 = 0; var1 < aBooleanArray675.length; ++var1) {
            aBooleanArray675[var1] = false;
        }

        if (cache == null) {
            aBoolean677 = true;
        } else {
            anInt670 = -1;

            for (var1 = 0; var1 < aBooleanArray675.length; ++var1) {
                if (super.childrenCounts[var1] > 0) {
                    ResourceCache cache = this.cache;
                    CacheRequest req = new CacheRequest();
                    req.type = 1;
                    req.key = var1;
                    req.cache = cache;
                    req.archive = this;
                    synchronized (CacheRequestWorker.requests) {
                        CacheRequestWorker.requests.add(req);
                    }

                    synchronized (CacheRequestWorker.anObject1463) {
                        if (CacheRequestWorker.anInt1464 == 0) {
                            CacheRequestWorker.thread = new Thread(new CacheRequestWorker());
                            CacheRequestWorker.thread.setDaemon(true);
                            CacheRequestWorker.thread.start();
                            CacheRequestWorker.thread.setPriority(5);
                        }

                        CacheRequestWorker.anInt1464 = 600;
                    }

                    anInt670 = var1;
                }
            }

            if (anInt670 == -1) {
                aBoolean677 = true;
            }

        }
    }

    void method490(int var1) {
        int var2 = anInt678;
        long var3 = (var2 << 16) + var1;
        ResourceRequest var5 = (ResourceRequest) NetWorker.aNodeTable1503.lookup(var3);
        if (var5 != null) {
            NetWorker.extras.method301(var5);
        }

    }

    public boolean method495(int var1) {
        return aBooleanArray675[var1];
    }

    public void method486(ResourceCache var1, int var2, byte[] var3, boolean var4) {
        int var5;
        if (var1 == meta) {
            if (aBoolean677) {
                throw new RuntimeException();
            }

            if (var3 == null) {
                WorldMapDecor.method377(this, 255, anInt678, anInt669, (byte) 0, true);
                return;
            }

            aCRC32_674.reset();
            aCRC32_674.update(var3, 0, var3.length);
            var5 = (int) aCRC32_674.getValue();
            if (var5 != anInt669) {
                WorldMapDecor.method377(this, 255, anInt678, anInt669, (byte) 0, true);
                return;
            }

            Buffer buffer = new Buffer(decodeContainer(var3));
            int format = buffer.readUByte();
            if (format != 5 && format != 6) {
                throw new RuntimeException(format + "," + anInt678 + "," + var2);
            }

            int version = 0;
            if (format >= 6) {
                version = buffer.readInt();
            }

            if (version != anInt679) {
                WorldMapDecor.method377(this, 255, anInt678, anInt669, (byte) 0, true);
                return;
            }

            decode(var3);
            method487();
        } else {
            if (!var4 && var2 == anInt670) {
                aBoolean677 = true;
            }

            if (var3 == null || var3.length <= 2) {
                aBooleanArray675[var2] = false;
                if (aBoolean671 || var4) {
                    WorldMapDecor.method377(this, anInt678, var2, super.anIntArray1245[var2], (byte) 2, var4);
                }

                return;
            }

            aCRC32_674.reset();
            aCRC32_674.update(var3, 0, var3.length - 2);
            var5 = (int) aCRC32_674.getValue();
            int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
            if (var5 != super.anIntArray1245[var2] || var6 != super.anIntArray1246[var2]) {
                aBooleanArray675[var2] = false;
                if (aBoolean671 || var4) {
                    WorldMapDecor.method377(this, anInt678, var2, super.anIntArray1245[var2], (byte) 2, var4);
                }

                return;
            }

            aBooleanArray675[var2] = true;
            if (var4) {
                super.anObjectArray1239[var2] = StockMarketMediator.method422(var3);
            }
        }

    }

    public void method493(int var1, int var2) {
        anInt669 = var1;
        anInt679 = var2;
        if (meta != null) {
            WorldMapArea.method77(anInt678, meta, this);
        } else {
            WorldMapDecor.method377(this, 255, anInt678, anInt669, (byte) 0, true);
        }

    }

    public void method498(int var1, byte[] var2, boolean var3, boolean var4) {
        if (var3) {
            if (aBoolean677) {
                throw new RuntimeException();
            }

            if (meta != null) {
                CacheRequest.write(anInt678, var2, meta);
            }

            decode(var2);
            method487();
        } else {
            var2[var2.length - 2] = (byte) (super.anIntArray1246[var1] >> 8);
            var2[var2.length - 1] = (byte) super.anIntArray1246[var1];
            if (cache != null) {
                CacheRequest.write(var1, var2, this.cache);
                aBooleanArray675[var1] = true;
            }

            if (var4) {
                super.anObjectArray1239[var1] = StockMarketMediator.method422(var2);
            }
        }

    }

    public int method494() {
        if (aBoolean677) {
            return 100;
        }
        if (super.anObjectArray1239 != null) {
            return 99;
        }
        int var1 = anInt678;
        long var2 = var1 + 16711680;
        int var4;
        if (NetWorker.current != null && NetWorker.current.key == var2) {
            var4 = CacheRequestWorker.buffer.caret * 99 / (CacheRequestWorker.buffer.payload.length - NetWorker.current.aByte1220) + 1;
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
                var2 += method497(var3);
            }
        }

        if (var1 == 0) {
            return 100;
        }
        var3 = var2 * 100 / var1;
        return var3;
    }

    public boolean method491() {
        return aBoolean677;
    }
}
