package jag.statics;

import jag.game.client;
import jag.game.relationship.ChatLine;
import jag.graphics.IndexedSprite;

public class Statics11 {

    public static IndexedSprite aDoublyNode_Sub24_Sub4_1148;

    public static void method843() {
        for (ChatLine var1 : Statics53.CHAT_LINE_TABLE) {
            var1.method592();
        }

        if (client.clanSystem != null) {
            client.clanSystem.method1386();
        }

    }
}
