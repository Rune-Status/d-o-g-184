package jag.audi;

import jag.Vertex;
import jag.game.client;
import jag.game.scene.entity.Pickable;
import jag.js5.Archive;
import jag.statics.Statics15;
import jag.statics.Statics50;
import jag.statics.Statics57;
import jag.statics.Statics8;
import jag.worldmap.WorldMapChunkType;

public class AudioOverrideEffect {
    public static int anInt1130;
    int anInt1133;
    int anInt1129;
    int anInt1126;
    byte[] aByteArray1132;
    int anInt1131;
    int anInt1125;
    byte[] aByteArray1134;
    int anInt1128;
    int anInt1127;

    AudioOverrideEffect() {
    }

    public static boolean method794(int var0) {
        for (int var1 = 0; var1 < client.anInt1092; ++var1) {
            if (client.anIntArray1096[var1] == var0) {
                return true;
            }
        }

        return false;
    }

    public static void method795(int var0) {
        if (var0 == -1 && !client.aBoolean904) {
            Vertex.method533();
        } else if (var0 != -1 && var0 != client.anInt898 && client.anInt900 != 0 && !client.aBoolean904) {
            Archive var1 = Statics15.aArchive1234;
            int var2 = client.anInt900;
            Statics57.anInt1157 = 1;
            Statics57.aReferenceTable1155 = var1;
            Statics8.anInt1122 = var0;
            Statics50.anInt327 = 0;
            Pickable.anInt379 = var2;
            WorldMapChunkType.aBoolean620 = false;
            anInt1130 = 2;
        }

        client.anInt898 = var0;
    }
}
