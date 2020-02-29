package com.jagex;

public class ClanSystem extends ChatterContext {

    final LocalPlayerNameProvider localPlayerNameProvider;
    final Class213 aClass213_1889;
    public String channelName;
    public String channelOwner;
    public int localPlayerRank;
    public byte aByte1887;
    int anInt1886;

    public ClanSystem(Class213 aClass213_1889, LocalPlayerNameProvider localPlayerNameProvider) {
        super(100);
        channelName = null;
        channelOwner = null;
        anInt1886 = 1;
        this.aClass213_1889 = aClass213_1889;
        this.localPlayerNameProvider = localPlayerNameProvider;
    }

    final void setChannelOwner(String owner) {
        channelOwner = Class96.method535(owner);
    }

    Chatter newChatter() {
        return new ClanMember();
    }

    final void setChannelName(String var1) {
        channelName = Class96.method535(var1);
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

    final void setLocalPlayerRankFrom(ClanMember member) {
        if (member.getDisplayName().equals(localPlayerNameProvider.getNamePair())) {
            localPlayerRank = member.rank;
        }

    }

    public final void method1389(Buffer var1) {
        NamePair var2 = new NamePair(var1.readString(), aClass213_1889);
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

            var6.method873(var3, ++anInt1886 - 1);
            var6.rank = var4;
            setLocalPlayerRankFrom(var6);
        }

    }

    public final void method1390(Buffer var1) {
        setChannelOwner(var1.readString());
        long var2 = var1.readLong();
        long var4 = var2;
        String var6;
        int var7;
        if (var2 > 0L && var2 < 6582952005840035281L) {
            if (var2 % 37L == 0L) {
                var6 = null;
            } else {
                var7 = 0;

                for (long var11 = var2; 0L != var11; var11 /= 37L) {
                    ++var7;
                }

                StringBuilder var13 = new StringBuilder(var7);

                while (0L != var4) {
                    long var14 = var4;
                    var4 /= 37L;
                    var13.append(Statics33.aCharArray1570[(int) (var14 - 37L * var4)]);
                }

                var6 = var13.reverse().toString();
            }
        } else {
            var6 = null;
        }

        setChannelName(var6);
        aByte1887 = var1.readByte();
        var7 = var1.readUByte();
        if (var7 != 255) {
            clear();

            for (int var8 = 0; var8 < var7; ++var8) {
                ClanMember var9 = (ClanMember) addAndCache(new NamePair(var1.readString(), aClass213_1889));
                int var10 = var1.readUShort();
                var9.method873(var10, ++anInt1886 - 1);
                var9.rank = var1.readByte();
                var1.readString();
                setLocalPlayerRankFrom(var9);
            }

        }
    }
}
