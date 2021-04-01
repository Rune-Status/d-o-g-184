package jag.game.relationship;

import jag.PlayerAccountType;
import jag.commons.collection.DoublyLinkedNode;
import jag.game.client;
import jag.statics.Statics53;
import jag.worldmap.PreciseWorldMapAreaChunk;

public class ChatLine extends DoublyLinkedNode {

    public String channel;
    public ChatLinePrivacyType ignore;
    public ChatLinePrivacyType friend;
    public NamePair channelPair;
    public int index;
    public int cycle;
    public int type;
    public String source;
    public String message;

    public ChatLine(int type, String channel, String source, String message) {
        this.friend = ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1554;
        this.ignore = ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1554;
        this.set(type, channel, source, message);
    }

    public void method775() {
        this.friend = client.relationshipSystem.friendListContext.isCached(this.channelPair) ? ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1555 : ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1553;
    }

    public void method828() {
        this.ignore = client.relationshipSystem.ignoreListContext.isCached(this.channelPair) ? ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1555 : ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1553;
    }

    public void set(int type, String channel, String source, String message) {
        this.index = ++Statics53.chatLineCount - 1;
        this.cycle = client.engineCycle;
        this.type = type;
        this.channel = channel;
        this.method886();
        this.source = source;
        this.message = message;
        this.method254();
        this.method592();
    }

    public final void method886() {
        if (this.channel != null) {
            this.channelPair = new NamePair(PlayerAccountType.getNameExcludingTags(this.channel), PreciseWorldMapAreaChunk.nameLengthParameter);
        } else {
            this.channelPair = null;
        }

    }

    public void method592() {
        this.ignore = ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1554;
    }

    public void method254() {
        this.friend = ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1554;
    }

    public final boolean method693() {
        if (this.friend == ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1554) {
            this.method775();
        }

        return this.friend == ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1555;
    }

    public final boolean method882() {
        if (this.ignore == ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1554) {
            this.method828();
        }

        return this.ignore == ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1555;
    }
}
