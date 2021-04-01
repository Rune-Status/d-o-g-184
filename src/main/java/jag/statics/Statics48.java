package jag.statics;

import jag.commons.input.Mouse;
import jag.game.InterfaceComponent;
import jag.game.client;
import jag.opcode.Connection;
import jag.opcode.OutgoingPacket;
import jag.opcode.OutgoingPacketMeta;

import java.awt.*;

public final class Statics48 {
    public static Connection js5connection;

    public static void method95(Component var0) {
        var0.addMouseListener(Mouse.instance);
        var0.addMouseMotionListener(Mouse.instance);
        var0.addFocusListener(Mouse.instance);
    }

    public static boolean isAppearanceCode(InterfaceComponent var0) {
        int var1 = var0.contentType;
        if (var1 == 205) {
            client.logoutTimer = 250;
            return true;
        }
        int var2;
        int var3;
        if (var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            client.renderedAppearance.method1428(var2, var3 == 1);
        }

        if (var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            client.renderedAppearance.method1432(var2, var3 == 1);
        }

        if (var1 == 324) {
            client.renderedAppearance.setGender(false);
        }

        if (var1 == 325) {
            client.renderedAppearance.setGender(true);
        }

        if (var1 == 326) {
            OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.PLAYER_APPEARANCE_BUTTON, client.netWriter.encryptor);
            client.renderedAppearance.writeAppearanceTo(packet.buffer);
            client.netWriter.writeLater(packet);
            return true;
        }
        return false;
    }

}
