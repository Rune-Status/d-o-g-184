package jag.game.relationship;

import jag.ClientParameter;
import jag.game.GameEngine;
import jag.game.client;
import jag.game.scene.entity.PlayerEntity;
import jag.opcode.Buffer;
import jag.opcode.FriendLoginUpdate;
import jag.opcode.OutgoingPacket;
import jag.opcode.OutgoingPacketMeta;
import jag.statics.Statics11;
import jag.statics.Statics19;
import jag.worldmap.WorldMapCacheFeature;

public class RelationshipSystem {

    public static int anInt319;
    public final IgnoreListContext ignoreListContext;
    public final FriendListContext friendListContext;
    public final ClientParameter aClientParameter_320;
    public int state;

    public RelationshipSystem(ClientParameter var1) {
        state = 0;
        aClientParameter_320 = var1;
        friendListContext = new FriendListContext(var1);
        ignoreListContext = new IgnoreListContext(var1);
    }

    public final boolean isFriendLoggedIn(NamePair name) {
        BefriendedPlayer var2 = (BefriendedPlayer) friendListContext.getChatterByAnyName(name);
        return var2 != null && var2.isLoggedIn();
    }

    public final boolean isIgnoreListFull() {
        return ignoreListContext.isFull() || ignoreListContext.getCount() >= 100 && client.anInt1029 != 1;
    }

    public final boolean isFriendsListFull() {
        return friendListContext.isFull() || friendListContext.getCount() >= 200 && client.anInt1029 != 1;
    }

    public final boolean isBefriended(NamePair name) {
        if (name == null) {
            return false;
        }

        if (name.equals(PlayerEntity.local.namePair)) {
            return true;
        }

        return friendListContext.isCached(name, false);
    }

    public final boolean isIgnoring(NamePair name) {
        if (name == null) {
            return false;
        }
        return ignoreListContext.isCached(name);
    }

    public final void decodeFriends(Buffer buffer, int var2) {
        friendListContext.decode(buffer, var2);
        state = 2;
        PlayerEntity.method1400();
    }

    public final void method210() {
        state = 1;
    }

    public boolean isReady() {
        return state == 2;
    }

    public final void befriend(String displayName) {
        if (displayName != null) {
            NamePair name = new NamePair(displayName, aClientParameter_320);
            if (name.isFormattedPresent()) {
                String message;
                if (isFriendsListFull()) {
                    message = "Your friend list is full. Max of 200 for free users, and 400 for members";
                    Statics19.messageReceived(30, "", message);
                } else if (PlayerEntity.local.namePair.equals(name)) {
                    message = "You can't add yourself to your own friend list";
                    Statics19.messageReceived(30, "", message);
                } else if (isBefriended(name)) {
                    message = displayName + " is already on your friend list";
                    Statics19.messageReceived(30, "", message);
                } else if (isIgnoring(name)) {
                    message = "Please remove " + displayName + " from your ignore list first";
                    Statics19.messageReceived(30, "", message);
                } else {
                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.ADD_FRIEND, client.connectionContext.encryptor);
                    packet.buffer.writeByte(Buffer.stringLengthPlusOne(displayName));
                    packet.buffer.writeCString(displayName);
                    client.connectionContext.writeLater(packet);
                }
            }
        }
    }

    public final void unbefriend(String displayName) {
        if (displayName != null) {
            NamePair name = new NamePair(displayName, aClientParameter_320);
            if (name.isFormattedPresent()) {
                if (friendListContext.remove(name)) {
                    client.anInt1065 = client.anInt1075;
                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.REMOVE_FRIEND, client.connectionContext.encryptor);
                    packet.buffer.writeByte(Buffer.stringLengthPlusOne(displayName));
                    packet.buffer.writeCString(displayName);
                    client.connectionContext.writeLater(packet);
                }

                PlayerEntity.method1400();
            }
        }
    }

    public final void ignore(String var1) {
        if (var1 != null) {
            NamePair var2 = new NamePair(var1, aClientParameter_320);
            if (var2.isFormattedPresent()) {
                if (isIgnoreListFull()) {
                    WorldMapCacheFeature.method178();
                } else {
                    String message;
                    if (PlayerEntity.local.namePair.equals(var2)) {
                        message = "You can't add yourself to your own ignore list";
                        Statics19.messageReceived(30, "", message);
                    } else if (isIgnoring(var2)) {
                        message = var1 + " is already on your ignore list";
                        Statics19.messageReceived(30, "", message);
                    } else if (isBefriended(var2)) {
                        message = "Please remove " + var1 + " from your friend list first";
                        Statics19.messageReceived(30, "", message);
                    } else {
                        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.ADD_TO_IGNORE_LIST, client.connectionContext.encryptor);
                        packet.buffer.writeByte(Buffer.stringLengthPlusOne(var1));
                        packet.buffer.writeCString(var1);
                        client.connectionContext.writeLater(packet);
                    }
                }
            }
        }
    }

    public final void unignore(String displayName) {
        if (displayName != null) {
            NamePair name = new NamePair(displayName, aClientParameter_320);
            if (name.isFormattedPresent()) {
                if (ignoreListContext.remove(name)) {
                    client.anInt1065 = client.anInt1075;
                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.REMOVE_FROM_IGNORE_LIST, client.connectionContext.encryptor);
                    packet.buffer.writeByte(Buffer.stringLengthPlusOne(displayName));
                    packet.buffer.writeCString(displayName);
                    client.connectionContext.writeLater(packet);
                }

                Statics11.method843();
            }
        }
    }

    public final void clear() {
        state = 0;
        friendListContext.clear();
        ignoreListContext.clear();
    }

    public final void processFriendLoginUpdates() {
        for (FriendLoginUpdate update = (FriendLoginUpdate) friendListContext.loginUpdates.current(); update != null; update = (FriendLoginUpdate) friendListContext.loginUpdates.next()) {
            if ((long) update.time < GameEngine.currentTime() / 1000L - 5L) {
                if (update.world > 0) {
                    Statics19.messageReceived(5, "", update.namePair + " has logged in.");
                }

                if (update.world == 0) {
                    Statics19.messageReceived(5, "", update.namePair + " has logged out.");
                }

                update.unlink();
            }
        }

    }
}
