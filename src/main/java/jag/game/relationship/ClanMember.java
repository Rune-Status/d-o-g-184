package jag.game.relationship;

import jag.game.client;
import jag.graphics.Font;
import jag.js5.ReferenceTable;
import jag.statics.Statics50;

public class ClanMember extends Associate {

    public ChatLinePrivacyType aChatLinePrivacyType_869;
    public ChatLinePrivacyType aChatLinePrivacyType_868;

    public ClanMember() {
        this.aChatLinePrivacyType_868 = ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1554;
        this.aChatLinePrivacyType_869 = ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1554;
    }

    public static Font method708(ReferenceTable var0, ReferenceTable var1, int var2, int var3) {
        return !ReferenceTable.method534(var0, var2, var3) ? null : Statics50.method221(var1.unpack(var2, var3));
    }

    public void method709() {
        this.aChatLinePrivacyType_868 = client.relationshipSystem.friendListContext.isCached(super.displayName) ? ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1555 : ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1553;
    }

    public void method705() {
        this.aChatLinePrivacyType_869 = client.relationshipSystem.ignoreListContext.isCached(super.displayName) ? ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1555 : ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1553;
    }

    public void method710() {
        this.aChatLinePrivacyType_868 = ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1554;
    }

    public void method707() {
        this.aChatLinePrivacyType_869 = ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1554;
    }

    public final boolean method711() {
        if (this.aChatLinePrivacyType_868 == ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1554) {
            this.method709();
        }

        return this.aChatLinePrivacyType_868 == ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1555;
    }

    public final boolean method706() {
        if (this.aChatLinePrivacyType_869 == ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1554) {
            this.method705();
        }

        return this.aChatLinePrivacyType_869 == ChatLinePrivacyType.A_CHAT_LINE_PRIVACY_TYPE___1555;
    }
}
