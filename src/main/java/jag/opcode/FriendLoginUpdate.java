package jag.opcode;

import jag.audi.Class97;
import jag.commons.collection.Linkable;
import jag.commons.time.Clock;
import jag.game.relationship.NamePair;

public class FriendLoginUpdate extends Linkable {
    public static Class97 aClass97_668;
    public final int time;
    public final short world;
    public final NamePair namePair;

    public FriendLoginUpdate(NamePair var1, int var2) {
        this.time = (int) (Clock.now() / 1000L);
        this.namePair = var1;
        this.world = (short) var2;
    }

}
