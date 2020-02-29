package com.jagex;

import java.util.Iterator;

public class Class9 {
    static int anInt130;
    String aString137;
    int anInt136;
    String aString132;
    boolean aBoolean128;
    int anInt139;
    int anInt135;
    SceneOffset aSceneOffset133;
    java.util.LinkedList aLinkedList127;
    int anInt131;
    int anInt134;
    int anInt129;
    int anInt138;

    public Class9() {
        this.anInt139 = -1;
        this.anInt136 = -1;
        this.anInt135 = -1;
        this.aSceneOffset133 = null;
        this.anInt134 = Integer.MAX_VALUE;
        this.anInt131 = 0;
        this.anInt138 = Integer.MAX_VALUE;
        this.anInt129 = 0;
        this.aBoolean128 = false;
    }

    static void method77(int var0, CacheIndex var1, CacheReferenceTable var2) {
        byte[] var3 = null;
        synchronized (Class174.aNodeDeque1465) {
            for (FileSystem var5 = (FileSystem) Class174.aNodeDeque1465.head(); var5 != null; var5 = (FileSystem) Class174.aNodeDeque1465.next()) {
                if ((long) var0 == var5.key && var1 == var5.index && var5.anInt380 == 0) {
                    var3 = var5.buffer;
                    break;
                }
            }
        }

        if (var3 != null) {
            var2.method486(var1, var0, var3, true);
        } else {
            byte[] var4 = var1.method1490(var0);
            var2.method486(var1, var0, var4, true);
        }
    }

    public static void method88(ReferenceTable var0, ReferenceTable var1, ReferenceTable var2) {
        HitsplatDefinition.table = var0;
        Class56.aReferenceTable480 = var1;
        HitsplatDefinition.aReferenceTable1515 = var2;
    }

    public void method87(Buffer var1, int var2) {
        this.anInt139 = var2;
        this.aString132 = var1.readString();
        this.aString137 = var1.readString();
        this.aSceneOffset133 = new SceneOffset(var1.readInt());
        this.anInt136 = var1.readInt();
        var1.readUByte();
        this.aBoolean128 = var1.readUByte() == 1;
        this.anInt135 = var1.readUByte();
        int var3 = var1.readUByte();
        this.aLinkedList127 = new java.util.LinkedList();

        for (int var4 = 0; var4 < var3; ++var4) {
            this.aLinkedList127.add(this.method76(var1));
        }

        this.method80();
    }

    public boolean method83(int var1, int var2) {
        int var3 = var1 / 64;
        int var4 = var2 / 64;
        if (var3 >= this.anInt134 && var3 <= this.anInt131) {
            if (var4 >= this.anInt138 && var4 <= this.anInt129) {
                Iterator var5 = this.aLinkedList127.iterator();

                Class10 var6;
                do {
                    if (!var5.hasNext()) {
                        return false;
                    }

                    var6 = (Class10) var5.next();
                } while (!var6.method92(var1, var2));

                return true;
            }
            return false;
        }
        return false;
    }

    public int method75() {
        return this.anInt139;
    }

    public int[] method81(int var1, int var2, int var3) {
        Iterator var4 = this.aLinkedList127.iterator();

        Class10 var5;
        do {
            if (!var4.hasNext()) {
                return null;
            }

            var5 = (Class10) var4.next();
        } while (!var5.method94(var1, var2, var3));

        return var5.method91(var1, var2, var3);
    }

    public int method66() {
        return this.anInt134;
    }

    public int method85() {
        return this.anInt138;
    }

    public boolean method84(int var1, int var2, int var3) {
        Iterator var4 = this.aLinkedList127.iterator();

        Class10 var5;
        do {
            if (!var4.hasNext()) {
                return false;
            }

            var5 = (Class10) var4.next();
        } while (!var5.method94(var1, var2, var3));

        return true;
    }

    public SceneOffset method79(int var1, int var2) {
        Iterator var3 = this.aLinkedList127.iterator();

        Class10 var4;
        do {
            if (!var3.hasNext()) {
                return null;
            }

            var4 = (Class10) var3.next();
        } while (!var4.method92(var1, var2));

        return var4.method90(var1, var2);
    }

    public int method71() {
        return this.aSceneOffset133.floorLevel;
    }

    public String method73() {
        return this.aString132;
    }

    public int method82() {
        return this.aSceneOffset133.anInt1891;
    }

    public int method74() {
        return this.aSceneOffset133.anInt1892;
    }

    public int method78() {
        return this.anInt135;
    }

    void method80() {

        for (Object anALinkedList127 : this.aLinkedList127) {
            Class10 var2 = (Class10) anALinkedList127;
            var2.method93(this);
        }

    }

    Class10 method76(Buffer var1) {
        int var2 = var1.readUByte();
        Enum_Sub2[] var3 = new Enum_Sub2[]{Enum_Sub2.anEnum_Sub2_624, Enum_Sub2.anEnum_Sub2_622, Enum_Sub2.anEnum_Sub2_621, Enum_Sub2.anEnum_Sub2_625};
        Enum_Sub2 var4 = (Enum_Sub2) OldConnection.method716(var3, var2);
        Class10 var5 = null;
        switch (var4.anInt619) {
            case 0:
                var5 = new Class70();
                break;
            case 1:
                var5 = new Class20();
                break;
            case 2:
                var5 = new Class66();
                break;
            case 3:
                var5 = new Class36();
                break;
            default:
                throw new IllegalStateException("");
        }

        var5.method89(var1);
        return var5;
    }

    public int method70() {
        return this.anInt131;
    }

    public boolean method86() {
        return this.aBoolean128;
    }

    public int method72() {
        return this.anInt129;
    }

    int method67() {
        return this.anInt136;
    }

    public String method68() {
        return this.aString137;
    }

    public SceneOffset method69() {
        return new SceneOffset(this.aSceneOffset133);
    }
}
