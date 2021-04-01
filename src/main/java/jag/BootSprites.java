package jag;

import jag.graphics.Font;
import jag.js5.ReferenceTable;
import jag.opcode.Buffer;

public class BootSprites {
    public static Font font_p12full;
    public int anInt1656;
    public int anInt1658;
    public int anInt1653;
    public int anInt1652;
    public int anInt1650;
    public int anInt1648;
    public int anInt1649;
    public int anInt1657;
    public int anInt1654;
    public int anInt1655;
    public int anInt1651;

    public BootSprites() {
        anInt1656 = -1;
        anInt1658 = -1;
        anInt1653 = -1;
        anInt1652 = -1;
        anInt1650 = -1;
        anInt1648 = -1;
        anInt1649 = -1;
        anInt1657 = -1;
        anInt1654 = -1;
        anInt1655 = -1;
        anInt1651 = -1;
    }

    public void method1190(ReferenceTable var1) {
        byte[] var2 = var1.unpack(BootSpriteTypes.A_BOOT_SPRITE_TYPES___1627.anInt1628);
        Buffer buffer = new Buffer(var2);

        while (true) {
            int opcode = buffer.g1();
            if (opcode == 0) {
                return;
            }

            switch (opcode) {
                case 1:
                    buffer.g3();
                    break;
                case 2:
                    anInt1656 = buffer.method1051();
                    anInt1658 = buffer.method1051();
                    anInt1653 = buffer.method1051();
                    anInt1652 = buffer.method1051();
                    anInt1650 = buffer.method1051();
                    anInt1648 = buffer.method1051();
                    anInt1649 = buffer.method1051();
                    anInt1657 = buffer.method1051();
                    anInt1654 = buffer.method1051();
                    anInt1655 = buffer.method1051();
                    anInt1651 = buffer.method1051();
            }
        }
    }
}
