package com.jagex;

public class SocialSystem {
    static int anInt319;
    public final IgnoreListContext ignoreListContext;
    public final FriendListContext friendListContext;
    final Class213 aClass213_320;
    int state;

    SocialSystem(Class213 var1) {
        state = 0;
        aClass213_320 = var1;
        friendListContext = new FriendListContext(var1);
        ignoreListContext = new IgnoreListContext(var1);
    }

    final boolean isFriendLoggedIn(NamePair name) {
        BefriendedPlayer var2 = (BefriendedPlayer) friendListContext.getChatterByAnyName(name);
        return var2 != null && var2.isLoggedIn();
    }

    final boolean isIgnoreListFull() {
        return ignoreListContext.isFull() || ignoreListContext.getCount() >= 100 && client.anInt1029 != 1;
    }

    final boolean isFriendsListFull() {
        return friendListContext.isFull() || friendListContext.getCount() >= 200 && client.anInt1029 != 1;
    }

    final boolean isOnFriendsList(NamePair name) {
        if (name == null) {
            return false;
        }

        if (name.equals(PlayerEntity.local.namePair)) {
            return true;
        }

        return friendListContext.isCached(name, false);
    }

    final boolean isOnIgnoreList(NamePair name) {
        if (name == null) {
            return false;
        }
        return ignoreListContext.isCached(name);
    }

    final void decodeFriends(Buffer buffer, int var2) {
        friendListContext.decode(buffer, var2);
        state = 2;
        SceneOffset.method1400();
    }

    final void method210() {
        state = 1;
    }

    boolean isReady() {
        return state == 2;
    }

    final void addFriend(String displayName) {
        if (displayName != null) {
            NamePair name = new NamePair(displayName, aClass213_320);
            if (name.isFormattedPresent()) {
                String message;
                if (isFriendsListFull()) {
                    message = "Your friend list is full. Max of 200 for free users, and 400 for members";
                    Statics19.messageReceived(30, "", message);
                } else if (PlayerEntity.local.namePair.equals(name)) {
                    message = "You can't add yourself to your own friend list";
                    Statics19.messageReceived(30, "", message);
                } else if (isOnFriendsList(name)) {
                    message = displayName + " is already on your friend list";
                    Statics19.messageReceived(30, "", message);
                } else if (isOnIgnoreList(name)) {
                    message = "Please remove " + displayName + " from your ignore list first";
                    Statics19.messageReceived(30, "", message);
                } else {
                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.ADD_FRIEND, client.connectionContext.encryptor);
                    packet.buffer.writeByte(Statics30.stringLengthPlusOne(displayName));
                    packet.buffer.writeCString(displayName);
                    client.connectionContext.writeLater(packet);
                }
            }
        }
    }

    final void removeFriend(String displayName) {
        if (displayName != null) {
            NamePair name = new NamePair(displayName, aClass213_320);
            if (name.isFormattedPresent()) {
                if (friendListContext.remove(name)) {
                    client.anInt1065 = client.anInt1075;
                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.REMOVE_FRIEND, client.connectionContext.encryptor);
                    packet.buffer.writeByte(Statics30.stringLengthPlusOne(displayName));
                    packet.buffer.writeCString(displayName);
                    client.connectionContext.writeLater(packet);
                }

                SceneOffset.method1400();
            }
        }
    }

    final void addToIgnoreList(String var1) {
        if (var1 != null) {
            NamePair var2 = new NamePair(var1, aClass213_320);
            if (var2.isFormattedPresent()) {
                if (isIgnoreListFull()) {
                    Class23.method178();
                } else {
                    String message;
                    if (PlayerEntity.local.namePair.equals(var2)) {
                        message = "You can't add yourself to your own ignore list";
                        Statics19.messageReceived(30, "", message);
                    } else if (isOnIgnoreList(var2)) {
                        message = var1 + " is already on your ignore list";
                        Statics19.messageReceived(30, "", message);
                    } else if (isOnFriendsList(var2)) {
                        message = "Please remove " + var1 + " from your friend list first";
                        Statics19.messageReceived(30, "", message);
                    } else {
                        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.ADD_TO_IGNORE_LIST, client.connectionContext.encryptor);
                        packet.buffer.writeByte(Statics30.stringLengthPlusOne(var1));
                        packet.buffer.writeCString(var1);
                        client.connectionContext.writeLater(packet);
                    }
                }
            }
        }
    }

    final void removeFromIgnoreList(String displayName) {
        if (displayName != null) {
            NamePair name = new NamePair(displayName, aClass213_320);
            if (name.isFormattedPresent()) {
                if (ignoreListContext.remove(name)) {
                    client.anInt1065 = client.anInt1075;
                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.REMOVE_FROM_IGNORE_LIST, client.connectionContext.encryptor);
                    packet.buffer.writeByte(Statics30.stringLengthPlusOne(displayName));
                    packet.buffer.writeCString(displayName);
                    client.connectionContext.writeLater(packet);
                }

                Statics11.method843();
            }
        }
    }

    final void clear() {
        state = 0;
        friendListContext.clear();
        ignoreListContext.clear();
    }

    final void processFriendLoginUpdates() {
        for (FriendLoginUpdate update = (FriendLoginUpdate) friendListContext.loginUpdates.current(); update != null; update = (FriendLoginUpdate) friendListContext.loginUpdates.next()) {
            if ((long) update.time < Class24.currentTime() / 1000L - 5L) {
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
