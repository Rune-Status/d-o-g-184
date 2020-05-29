package jag.statics;

import jag.game.client;
import jag.game.relationship.ChatLine;
import jag.graphics.IndexedSprite;

import java.util.HashMap;

public class Statics11 {
    public static IndexedSprite aDoublyNode_Sub24_Sub4_1148;

    static {
        new HashMap();
    }

    public static void method843() {

        for (Object anARS3CopiedNodeTable523 : Statics53.A_ITERABLE_NODE_TABLE_523) {
            ChatLine var1 = (ChatLine) anARS3CopiedNodeTable523;
            var1.method592();
        }

        if (client.clanSystem != null) {
            client.clanSystem.method1386();
        }

    }
}
