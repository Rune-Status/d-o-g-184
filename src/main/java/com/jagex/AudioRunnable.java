package com.jagex;

public class AudioRunnable implements Runnable {

    volatile AudioSystem[] systems;

    AudioRunnable() {
        this.systems = new AudioSystem[2];
    }

    static void method985(InterfaceComponent var0, int var1, int var2) {
        DoublyLinkedNode_Sub10 var4 = var0.method959(false);
        if (var4 != null) {
            if (client.mapState < 3) {
                ActionPrioritySetting.compass.rotate(var1, var2, var4.anInt380, var4.anInt568, 25, 25, client.mapRotation, 256, var4.anIntArray1108, var4.anIntArray749);
            } else {
                JagGraphics.method1362(var1, var2, 0, var4.anIntArray1108, var4.anIntArray749);
            }

        }
    }

    public static void method986(Buffer var0, int var1) {
        if (Statics5.random != null) {
            try {
                Statics5.random.seek(0L);
                Statics5.random.write(var0.payload, var1, 24);
            } catch (Exception ignored) {
            }
        }

    }

    public void run() {
        try {
            for (int var1 = 0; var1 < 2; ++var1) {
                AudioSystem var2 = this.systems[var1];
                if (var2 != null) {
                    var2.method1328();
                }
            }
        } catch (Exception var4) {
            Class8.method65(null, var4);
        }

    }
}
