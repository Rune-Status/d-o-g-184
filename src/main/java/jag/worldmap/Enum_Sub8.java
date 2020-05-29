package jag.worldmap;

import jag.EnumType;
import jag.SerializableLong;
import jag.game.InterfaceComponent;

public enum Enum_Sub8 implements EnumType {
    anEnum_Sub8_1480(0, 0),
    anEnum_Sub8_1481(2, 1),
    anEnum_Sub8_1479(1, 2);

    public static long aLong1478;
    public final int anInt633;
    final int anInt619;

    Enum_Sub8(int var3, int var4) {
        this.anInt633 = var3;
        this.anInt619 = var4;
    }

    public static String method1091(InterfaceComponent var0) {
        if (SerializableLong.getComponentSpellTargets(InterfaceComponent.getConfig(var0)) == 0) {
            return null;
        }
        return var0.selectedAction != null && var0.selectedAction.trim().length() != 0 ? var0.selectedAction : null;
    }

    public int getOrdinal() {
        return this.anInt619;
    }
}
