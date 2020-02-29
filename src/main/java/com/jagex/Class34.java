package com.jagex;

public class Class34 {
    static MouseRecorder mouseRecorder;
    static CacheReferenceTable aCacheReferenceTable341;
    String aString340;
    int anInt342;
    Class65 aClass65_338;
    int anInt339;

    Class34(String var1, int var2, int var3, Class65 var4) {
        this.aString340 = var1;
        this.anInt342 = var2;
        this.anInt339 = var3;
        this.aClass65_338 = var4;
    }

    static void method232() {
        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta34, client.connectionContext.encryptor);
        packet.buffer.writeByte(0);
        client.connectionContext.writeLater(packet);
    }

    static void method233(int var0, SceneOffset var1, boolean var2) {
        Class9 var3 = Class98.method542().method1242(var0);
        int var4 = PlayerEntity.local.anInt1473;
        int var5 = Statics18.baseX + (PlayerEntity.local.fineX >> 7);
        int var6 = Statics36.baseY + (PlayerEntity.local.fineY >> 7);
        SceneOffset var7 = new SceneOffset(var4, var5, var6);
        Class98.method542().method1277(var3, var7, var1, var2);
    }
}
