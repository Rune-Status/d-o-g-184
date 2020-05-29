package jag.game.relationship;

import jag.ClientParameter;
import jag.LocalPlayerNameProvider;
import jag.Vertex;
import jag.opcode.Buffer;
import jag.statics.Statics33;

public class ClanSystem extends ChatterContext {

    public final LocalPlayerNameProvider localPlayerNameProvider;
    public final ClientParameter gameType;

    public String channelName;
    public String channelOwner;

    public int localPlayerRank;
    public int memberCount;

    public byte channelRank;

    public ClanSystem(ClientParameter gameType, LocalPlayerNameProvider localPlayerNameProvider) {
        super(100);
        this.gameType = gameType;
        this.localPlayerNameProvider = localPlayerNameProvider;
        channelName = null;
        channelOwner = null;
        memberCount = 1;
    }

    public final void setChannelOwner(String owner) {
        channelOwner = Vertex.encodeBase37(owner);
    }

    Chatter newChatter() {
        return new ClanMember();
    }

    public final void setChannelName(String var1) {
        channelName = Vertex.encodeBase37(var1);
    }

    Chatter[] newArray(int size) {
        return new ClanMember[size];
    }

    public final void method1392() {
        for (int index = 0; index < getCount(); ++index) {
            ((ClanMember) getChatter(index)).method710();
        }

    }

    public final void method1386() {
        for (int var1 = 0; var1 < getCount(); ++var1) {
            ((ClanMember) getChatter(var1)).method707();
        }

    }

    public final void setLocalPlayerRankFrom(ClanMember member) {
        if (member.getDisplayName().equals(localPlayerNameProvider.getNamePair())) {
            localPlayerRank = member.rank;
        }

    }

    public final void method1389(Buffer var1) {
        NamePair var2 = new NamePair(var1.readString(), gameType);
        int var3 = var1.readUShort();
        byte var4 = var1.readByte();
        boolean var5 = false;
        if (var4 == -128) {
            var5 = true;
        }

        ClanMember var6;
        if (var5) {
            if (getCount() == 0) {
                return;
            }

            var6 = (ClanMember) getChatterByDisplayName(var2);
            if (var6 != null && var6.getWorld() == var3) {
                remove(var6);
            }
        } else {
            var1.readString();
            var6 = (ClanMember) getChatterByDisplayName(var2);
            if (var6 == null) {
                if (getCount() > super.capacity) {
                    return;
                }

                var6 = (ClanMember) addAndCache(var2);
            }

            var6.method873(var3, ++memberCount - 1);
            var6.rank = var4;
            setLocalPlayerRankFrom(var6);
        }

    }

    public final void decode(Buffer buffer) {
        setChannelOwner(buffer.readString());
        long encoded = buffer.readLong();
        long var4 = encoded;
        String decodedBase37;
        if (encoded > 0L && encoded < 6582952005840035281L) {
            if (encoded % 37L == 0L) {
                decodedBase37 = null;
            } else {
                int length = 0;

                for (long var11 = encoded; 0L != var11; var11 /= 37L) {
                    ++length;
                }

                StringBuilder processed = new StringBuilder(length);

                while (var4 != 0L) {
                    long old = var4;
                    var4 /= 37L;
                    processed.append(Statics33.aCharArray1570[(int) (old - 37L * var4)]);
                }

                decodedBase37 = processed.reverse().toString();
            }
        } else {
            decodedBase37 = null;
        }

        setChannelName(decodedBase37);
        channelRank = buffer.readByte();
        int count = buffer.readUByte();
        if (count != 255) {
            clear();

            for (int i = 0; i < count; ++i) {
                ClanMember member = (ClanMember) addAndCache(new NamePair(buffer.readString(), gameType));
                int world = buffer.readUShort();
                member.method873(world, ++memberCount - 1);
                member.rank = buffer.readByte();
                buffer.readString();
                setLocalPlayerRankFrom(member);
            }
        }
    }
}
