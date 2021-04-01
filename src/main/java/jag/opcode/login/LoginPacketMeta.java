package jag.opcode.login;

import jag.*;
import jag.game.scene.entity.PlayerEntity;
import jag.game.type.AnimationSequence;
import jag.js5.Archive;
import jag.opcode.OldConnectionTask;
import jag.opcode.OutgoingPacketProtocol;
import jag.script.ClientScript;

public class LoginPacketMeta implements OutgoingPacketProtocol {

    public static final LoginPacketMeta HANDSHAKE;
    public static final LoginPacketMeta aLoginPacketMeta1997;
    public static final LoginPacketMeta aLoginPacketMeta1996;
    public static final LoginPacketMeta aLoginPacketMeta1999;
    public static final LoginPacketMeta aLoginPacketMeta1995;
    public static final LoginPacketMeta[] aLoginPacketMetaArray1994;
    public static OldConnectionTask task;
    public static Bounds aBounds_846;

    static {
        HANDSHAKE = new LoginPacketMeta(14);
        aLoginPacketMeta1999 = new LoginPacketMeta(15);
        aLoginPacketMeta1997 = new LoginPacketMeta(16);
        aLoginPacketMeta1996 = new LoginPacketMeta(18);
        aLoginPacketMeta1995 = new LoginPacketMeta(27);
        aLoginPacketMetaArray1994 = new LoginPacketMeta[32];
        LoginPacketMeta[] var0 = values();

        for (LoginPacketMeta aVar0 : var0) {
            aLoginPacketMetaArray1994[aVar0.value] = aVar0;
        }

    }

    public final int value;

    LoginPacketMeta(int var1) {
        this.value = var1;
    }

    public static LoginPacketMeta[] values() {
        return new LoginPacketMeta[]{LoginPacketMeta.aLoginPacketMeta1997, LoginPacketMeta.aLoginPacketMeta1999, LoginPacketMeta.aLoginPacketMeta1995, LoginPacketMeta.aLoginPacketMeta1996, LoginPacketMeta.HANDSHAKE};
    }

    public static ClientScript method1499(int var0) {
        ClientScript var1 = ClientScript.cache.get(var0);
        if (var1 != null) {
            return var1;
        }
        byte[] var2 = Archive.cs2.unpack(var0, 0);
        if (var2 == null) {
            return null;
        }
        var1 = ClientScript.decode(var2);
        ClientScript.cache.put(var1, var0);
        return var1;
    }

    public static void method1497(PlayerEntity var0, int var1, int var2) {
        if (var0.animation == var1 && var1 != -1) {
            int var3 = AnimationSequence.get(var1).replayMode;
            if (var3 == 1) {
                var0.animationFrame = 0;
                var0.animationFrameCycle = 0;
                var0.animationDelay = var2;
                var0.anInt2010 = 0;
            }

            if (var3 == 2) {
                var0.anInt2010 = 0;
            }
        } else if (var1 == -1 || var0.animation == -1 || AnimationSequence.get(var1).priority >= AnimationSequence.get(var0.animation).priority) {
            var0.animation = var1;
            var0.animationFrame = 0;
            var0.animationFrameCycle = 0;
            var0.animationDelay = var2;
            var0.anInt2010 = 0;
            var0.anInt2023 = var0.pathQueueSize;
        }

    }
}
