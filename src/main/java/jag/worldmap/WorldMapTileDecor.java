package jag.worldmap;

import jag.audi.Node_Sub19;
import jag.game.InterfaceComponent;
import jag.game.World;
import jag.game.client;
import jag.game.stockmarket.Class46;
import jag.game.type.VarDefinition;
import jag.js5.ReferenceTable;
import jag.opcode.Buffer;

public abstract class WorldMapTileDecor {
    public static int selectedItemIndex;
    boolean aBoolean504;
    short[][][] aShortArrayArrayArray518;
    int anInt517;
    int anInt516;
    int levelCount;
    int anInt514;
    boolean aBoolean507;
    short[][][] aShortArrayArrayArray508;
    WorldMapDecor[][][][] aWorldMapDecorArrayArrayArrayArray511;
    int anInt509;
    byte[][][] aByteArrayArrayArray506;
    byte[][][] aByteArrayArrayArray505;
    int anInt515;
    int anInt519;
    int anInt510;

    WorldMapTileDecor() {
        anInt514 = -1;
        anInt509 = -1;
        aBoolean504 = false;
        aBoolean507 = false;
    }

    public static void processComponentRendering(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
        if (InterfaceComponent.load(var0)) {
            Node_Sub19.processComponentEvents(client.interfaces[var0], -1, var1, var2, var3, var4, var5, var6);
        }
    }

    public static VarDefinition method360(int var0) {
        VarDefinition var1 = (VarDefinition) VarDefinition.aReferenceCache701.get(var0);
        if (var1 != null) {
            return var1;
        }
        byte[] var2 = VarDefinition.aReferenceTable383.unpack(16, var0);
        var1 = new VarDefinition();
        if (var2 != null) {
            var1.decode(new Buffer(var2));
        }

        VarDefinition.aReferenceCache701.put(var1, var0);
        return var1;
    }

    public static void method357(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
        if (var0 < var1) {
            int var6 = (var0 + var1) / 2;
            int var7 = var0;
            World var8 = World.worlds[var6];
            World.worlds[var6] = World.worlds[var1];
            World.worlds[var1] = var8;

            for (int var9 = var0; var9 < var1; ++var9) {
                if (Class46.method288(World.worlds[var9], var8, var2, var3, var4, var5) <= 0) {
                    World var10 = World.worlds[var9];
                    World.worlds[var9] = World.worlds[var7];
                    World.worlds[var7++] = var10;
                }
            }

            World.worlds[var1] = World.worlds[var7];
            World.worlds[var7] = var8;
            method357(var0, var7 - 1, var2, var3, var4, var5);
            method357(var7 + 1, var1, var2, var3, var4, var5);
        }

    }

    boolean method359() {
        return aBoolean504 && aBoolean507;
    }

    void method352() {
        aShortArrayArrayArray518 = null;
        aShortArrayArrayArray508 = null;
        aByteArrayArrayArray506 = null;
        aByteArrayArrayArray505 = null;
        aWorldMapDecorArrayArrayArrayArray511 = null;
        aBoolean504 = false;
        aBoolean507 = false;
    }

    void method355(int var1, int var2, Buffer var3, int var4) {
        boolean var5 = (var4 & 2) != 0;
        if (var5) {
            aShortArrayArrayArray508[0][var1][var2] = (short) var3.readUByte();
        }

        aShortArrayArrayArray518[0][var1][var2] = (short) var3.readUByte();
    }

    void method350(int var1, int var2, Buffer var3, int var4) {
        int var5 = ((var4 & 24) >> 3) + 1;
        boolean var6 = (var4 & 2) != 0;
        boolean var7 = (var4 & 4) != 0;
        aShortArrayArrayArray518[0][var1][var2] = (short) var3.readUByte();
        int var8;
        int var9;
        int var11;
        if (var6) {
            var8 = var3.readUByte();

            for (var9 = 0; var9 < var8; ++var9) {
                int var10 = var3.readUByte();
                if (var10 != 0) {
                    aShortArrayArrayArray508[var9][var1][var2] = (short) var10;
                    var11 = var3.readUByte();
                    aByteArrayArrayArray506[var9][var1][var2] = (byte) (var11 >> 2);
                    aByteArrayArrayArray505[var9][var1][var2] = (byte) (var11 & 3);
                }
            }
        }

        if (var7) {
            for (var8 = 0; var8 < var5; ++var8) {
                var9 = var3.readUByte();
                if (var9 != 0) {
                    WorldMapDecor[] var12 = aWorldMapDecorArrayArrayArrayArray511[var8][var1][var2] = new WorldMapDecor[var9];

                    for (var11 = 0; var11 < var9; ++var11) {
                        int var13 = var3.method1051();
                        int var14 = var3.readUByte();
                        var12[var11] = new WorldMapDecor(var13, var14 >> 2, var14 & 3);
                    }
                }
            }
        }

    }

    void method354(ReferenceTable table) {
        if (!method359()) {
            byte[] payload = table.unpack(anInt514, anInt509);
            if (payload != null) {
                decode(new Buffer(payload));
                aBoolean504 = true;
                aBoolean507 = true;
            }

        }
    }

    int method353() {
        return anInt517;
    }

    int method358() {
        return anInt516;
    }

    abstract void decode(Buffer var1);

    void decode(int x, int y, Buffer buffer) {
        int var4 = buffer.readUByte();
        if (var4 != 0) {
            if ((var4 & 1) != 0) {
                method355(x, y, buffer, var4);
            } else {
                method350(x, y, buffer, var4);
            }
        }
    }
}
