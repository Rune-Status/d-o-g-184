package com.jagex;

public class FriendLoginUpdate extends Linkable {
    public static Class97 aClass97_668;
    public int time;
    public short world;
    public NamePair namePair;

    FriendLoginUpdate(NamePair var1, int var2) {
        this.time = (int) (Class24.currentTime() / 1000L);
        this.namePair = var1;
        this.world = (short) var2;
    }

}
