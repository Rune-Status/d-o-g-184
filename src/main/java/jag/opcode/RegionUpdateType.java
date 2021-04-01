package jag.opcode;

import jag.game.client;
import jag.game.stockmarket.StockMarketOfferLifetimeComparator;
import jag.game.stockmarket.StockMarketOfferWorldComparator;
import jag.js5.DiskFile;
import jag.statics.Statics5;

import java.io.File;
import java.io.IOException;

public class RegionUpdateType {
    public static final RegionUpdateType A_REGION_UPDATE_TYPE___1204;
    public static final RegionUpdateType A_REGION_UPDATE_TYPE___1206;
    public static final RegionUpdateType TRANSMOGRIFY_PLAYER;
    public static final RegionUpdateType ADD_PICKABLE;
    public static final RegionUpdateType SPAWN_PROJECTILE;
    public static final RegionUpdateType REMOVE_SCENE_OBJECT;
    public static final RegionUpdateType SPAWN_GRAPHICS_OBJECT;
    public static final RegionUpdateType A_REGION_UPDATE_TYPE___1205;
    public static final RegionUpdateType SET_PICKABLE_STACK_SIZE;
    public static final RegionUpdateType REMOVE_PICKABLE;
    public static int parsedTotp;

    static {
        A_REGION_UPDATE_TYPE___1204 = new RegionUpdateType();
        A_REGION_UPDATE_TYPE___1206 = new RegionUpdateType();
        TRANSMOGRIFY_PLAYER = new RegionUpdateType();
        ADD_PICKABLE = new RegionUpdateType();
        SPAWN_PROJECTILE = new RegionUpdateType();
        REMOVE_SCENE_OBJECT = new RegionUpdateType();
        SPAWN_GRAPHICS_OBJECT = new RegionUpdateType();
        A_REGION_UPDATE_TYPE___1205 = new RegionUpdateType();
        SET_PICKABLE_STACK_SIZE = new RegionUpdateType();
        REMOVE_PICKABLE = new RegionUpdateType();
    }

    RegionUpdateType() {
    }

    public static DiskFile method863(String var0, String var1, boolean var2) {
        File var3 = new File(StockMarketOfferWorldComparator.aFile346, "preferences" + var0 + ".dat");
        if (var3.exists()) {
            try {
                return new DiskFile(var3, "rw", 10000L);
            } catch (IOException ignored) {
            }
        }

        String var4 = "";
        if (AsyncConnection.anInt1210 == 33) {
            var4 = "_rc";
        } else if (AsyncConnection.anInt1210 == 34) {
            var4 = "_wip";
        }

        File var5 = new File(Statics5.userhome, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
        DiskFile var6;
        if (!var2 && var5.exists()) {
            try {
                var6 = new DiskFile(var5, "rw", 10000L);
                return var6;
            } catch (IOException ignored) {
            }
        }

        try {
            var6 = new DiskFile(var3, "rw", 10000L);
            return var6;
        } catch (IOException var7) {
            throw new RuntimeException();
        }
    }

    public static void method865() {
        client.anInt1061 = client.anInt1075;
        StockMarketOfferLifetimeComparator.aBoolean584 = true;
    }

    public static RegionUpdateType[] values() {
        return new RegionUpdateType[]{A_REGION_UPDATE_TYPE___1204, A_REGION_UPDATE_TYPE___1206, TRANSMOGRIFY_PLAYER, ADD_PICKABLE, SPAWN_PROJECTILE, REMOVE_SCENE_OBJECT, SPAWN_GRAPHICS_OBJECT, A_REGION_UPDATE_TYPE___1205, SET_PICKABLE_STACK_SIZE, REMOVE_PICKABLE};
    }
}
