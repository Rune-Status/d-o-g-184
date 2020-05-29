package jag.game.relationship;

import jag.ClientParameter;
import jag.commons.collection.LinkableDeque;
import jag.opcode.Buffer;
import jag.opcode.FriendLoginUpdate;

public class FriendListContext extends ChatterContext {

    public final ClientParameter aClientParameter_486;
    public final LinkableDeque loginUpdates;
    public int anInt833;

    public FriendListContext(ClientParameter var1) {
        super(400);
        this.anInt833 = 1;
        this.loginUpdates = new LinkableDeque();
        this.aClientParameter_486 = var1;
    }

    public void decode(Buffer buffer, int available) {
        while (true) {
            if (buffer.caret < available) {
                boolean var3 = buffer.readUByte() == 1;
                NamePair displayName = new NamePair(buffer.readString(), this.aClientParameter_486);
                NamePair previousName = new NamePair(buffer.readString(), this.aClientParameter_486);
                int var6 = buffer.readUShort();
                int var7 = buffer.readUByte();
                int var8 = buffer.readUByte();
                boolean var9 = (var8 & 2) != 0;
                boolean var10 = (var8 & 1) != 0;
                if (var6 > 0) {
                    buffer.readString();
                    buffer.readUByte();
                    buffer.readInt();
                }

                buffer.readString();
                if (displayName.isFormattedPresent()) {
                    BefriendedPlayer var11 = (BefriendedPlayer) this.getChatterByDisplayName(displayName);
                    if (var3) {
                        BefriendedPlayer var12 = (BefriendedPlayer) this.getChatterByDisplayName(previousName);
                        if (var12 != null && var11 != var12) {
                            if (var11 != null) {
                                this.remove(var12);
                            } else {
                                var11 = var12;
                            }
                        }
                    }

                    if (var11 != null) {
                        this.update(var11, displayName, previousName);
                        if (var6 != var11.world) {
                            boolean var13 = true;

                            for (FriendLoginUpdate update = (FriendLoginUpdate) this.loginUpdates.current(); update != null; update = (FriendLoginUpdate) this.loginUpdates.next()) {
                                if (update.namePair.equals(displayName)) {
                                    if (var6 != 0 && update.world == 0) {
                                        update.unlink();
                                        var13 = false;
                                    } else if (var6 == 0 && update.world != 0) {
                                        update.unlink();
                                        var13 = false;
                                    }
                                }
                            }

                            if (var13) {
                                this.loginUpdates.method1125(new FriendLoginUpdate(displayName, var6));
                            }
                        }
                    } else {
                        if (this.getCount() >= 400) {
                            continue;
                        }

                        var11 = (BefriendedPlayer) this.addAndCache(displayName, previousName);
                    }

                    if (var6 != var11.world) {
                        var11.index = ++this.anInt833 - 1;
                        if (var11.world == -1 && var6 == 0) {
                            var11.index = -(var11.index);
                        }

                        var11.world = var6;
                    }

                    var11.rank = var7;
                    var11.aBoolean745 = var9;
                    var11.aBoolean746 = var10;
                    continue;
                }

                throw new IllegalStateException();
            }

            this.sort();
            return;
        }
    }

    Chatter newChatter() {
        return new BefriendedPlayer();
    }

    public boolean isCached(NamePair var1, boolean requireLoggedIn) {
        BefriendedPlayer friend = (BefriendedPlayer) this.getChatterByAnyName(var1);
        if (friend == null) {
            return false;
        }
        return !requireLoggedIn || friend.world != 0;
    }

    Chatter[] newArray(int size) {
        return new BefriendedPlayer[size];
    }
}
