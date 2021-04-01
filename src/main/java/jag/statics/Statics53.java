package jag.statics;

import jag.commons.collection.IterableDoublyLinkedNodeQueue;
import jag.commons.collection.IterableNodeTable;
import jag.game.relationship.ChatLine;

public class Statics53 {

    public static final IterableNodeTable<ChatLine> CHAT_LINE_TABLE;
    public static final IterableDoublyLinkedNodeQueue<ChatLine> CHAT_LINE_QUEUE;
    public static int chatLineCount;
    public static int anInt520;

    static {
        CHAT_LINE_TABLE = new IterableNodeTable<>(1024);
        CHAT_LINE_QUEUE = new IterableDoublyLinkedNodeQueue<>();
        chatLineCount = 0;
    }

}
