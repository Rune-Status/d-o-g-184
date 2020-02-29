package com.jagex;

public class DoublyLinkedNode_Sub11 extends DoublyLinkedNode {
    public static ReferenceTable aReferenceTable383;
    static ReferenceCache aReferenceCache385;
    static Class25 aClass25_1443;

    static {
        aReferenceCache385 = new ReferenceCache(64);
    }

    public int anInt375;
    public String aString1442;
    public char aChar1445;
    public char aChar1444;
    public int anInt112;
    public int[] anIntArray692;
    public String[] aStringArray1446;
    public int[] anIntArray691;

    DoublyLinkedNode_Sub11() {
        this.aString1442 = "null";
        this.anInt375 = 0;
    }

    static void method989() {
        Statics19.messageReceived(30, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
    }

    void method988(Buffer var1, int var2) {
        if (var2 == 1) {
            this.aChar1445 = (char) var1.readUByte();
        } else if (var2 == 2) {
            this.aChar1444 = (char) var1.readUByte();
        } else if (var2 == 3) {
            this.aString1442 = var1.readString();
        } else if (var2 == 4) {
            this.anInt112 = var1.readInt();
        } else {
            int var3;
            if (var2 == 5) {
                this.anInt375 = var1.readUShort();
                this.anIntArray692 = new int[this.anInt375];
                this.aStringArray1446 = new String[this.anInt375];

                for (var3 = 0; var3 < this.anInt375; ++var3) {
                    this.anIntArray692[var3] = var1.readInt();
                    this.aStringArray1446[var3] = var1.readString();
                }
            } else if (var2 == 6) {
                this.anInt375 = var1.readUShort();
                this.anIntArray692 = new int[this.anInt375];
                this.anIntArray691 = new int[this.anInt375];

                for (var3 = 0; var3 < this.anInt375; ++var3) {
                    this.anIntArray692[var3] = var1.readInt();
                    this.anIntArray691[var3] = var1.readInt();
                }
            }
        }

    }

    public int method987() {
        return this.anInt375;
    }

    void method990(Buffer var1) {
        while (true) {
            int var2 = var1.readUByte();
            if (var2 == 0) {
                return;
            }

            this.method988(var1, var2);
        }
    }
}
