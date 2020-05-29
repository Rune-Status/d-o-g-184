package jag.game.option;

import jag.EnumType;
import jag.graphics.Sprite;
import jag.js5.Archive;

public enum AttackOptionPriority implements EnumType {

    anActionPrioritySetting333(0),
    anActionPrioritySetting336(1),
    anActionPrioritySetting331(2),
    anActionPrioritySetting330(3);

    public static int selectedSpellComponentUid;
    public static Sprite compass;
    public static Archive aArchive329;
    public final int index;

    AttackOptionPriority(int index) {
        this.index = index;
    }

    public int getOrdinal() {
        return this.index;
    }
}
