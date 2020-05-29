package jag;

import jag.commons.collection.Node;
import jag.game.relationship.AssociateComparator_Sub5;
import jag.opcode.Buffer;

public class OperatingSystemNode extends Node {

    final String aString1855;
    final int anInt556;
    final String aString1854;
    final boolean x64;
    final int anInt1437;
    final String aString1856;
    final int anInt711;
    final int anInt709;
    final String aString1860;
    final int anInt1424;
    final int anInt710;
    final boolean aBoolean1507;
    final String aString1849;
    final int anInt1857;
    final int anInt1858;
    final String aString1848;
    final int anInt1853;
    final int anInt1348;
    final String aString1850;
    final int anInt1859;
    final int anInt1343;
    final int anInt1347;
    final int anInt1852;
    final int anInt1851;
    int[] anIntArray1748;

    OperatingSystemNode(int var1, boolean x64, int var3, int var4, int var5, int var6, int var7, int var9, int var10, int var11, String var13, String var14, String var15, String var16, String var21, String var22, int[] var23) {
        this.anIntArray1748 = new int[3];
        this.anInt556 = var1;
        this.x64 = x64;
        this.anInt1437 = var3;
        this.anInt711 = var4;
        this.anInt709 = var5;
        this.anInt1424 = var6;
        this.anInt710 = var7;
        this.aBoolean1507 = false;
        this.anInt1857 = var9;
        this.anInt1858 = var10;
        this.anInt1853 = var11;
        this.anInt1348 = 0;
        this.aString1855 = var13;
        this.aString1854 = var14;
        this.aString1856 = var15;
        this.aString1860 = var16;
        this.anInt1859 = 0;
        this.anInt1343 = 0;
        this.anInt1347 = 0;
        this.anInt1852 = 0;
        this.aString1849 = var21;
        this.aString1848 = var22;
        this.anIntArray1748 = var23;
        this.anInt1851 = 0;
        this.aString1850 = "";
    }

    public int getPayloadSize() {
        byte var1 = 39;
        int var2 = var1 + AssociateComparator_Sub5.stringLengthPlusTwo(this.aString1855);
        var2 += AssociateComparator_Sub5.stringLengthPlusTwo(this.aString1854);
        var2 += AssociateComparator_Sub5.stringLengthPlusTwo(this.aString1856);
        var2 += AssociateComparator_Sub5.stringLengthPlusTwo(this.aString1860);
        var2 += AssociateComparator_Sub5.stringLengthPlusTwo(this.aString1849);
        var2 += AssociateComparator_Sub5.stringLengthPlusTwo(this.aString1848);
        var2 += AssociateComparator_Sub5.stringLengthPlusTwo(this.aString1850);
        return var2;
    }

    public void method1098(Buffer buffer) {
        buffer.writeByte(8);
        buffer.writeByte(this.anInt556);
        buffer.writeByte(this.x64 ? 1 : 0);
        buffer.writeShort(this.anInt1437);
        buffer.writeByte(this.anInt711);
        buffer.writeByte(this.anInt709);
        buffer.writeByte(this.anInt1424);
        buffer.writeByte(this.anInt710);
        buffer.writeByte(this.aBoolean1507 ? 1 : 0);
        buffer.writeShort(this.anInt1857);
        buffer.writeByte(this.anInt1858);
        buffer.writeMediumInt(this.anInt1853);
        buffer.writeShort(this.anInt1348);
        buffer.method1027(this.aString1855);
        buffer.method1027(this.aString1854);
        buffer.method1027(this.aString1856);
        buffer.method1027(this.aString1860);
        buffer.writeByte(this.anInt1343);
        buffer.writeShort(this.anInt1859);
        buffer.method1027(this.aString1849);
        buffer.method1027(this.aString1848);
        buffer.writeByte(this.anInt1347);
        buffer.writeByte(this.anInt1852);

        for (int anAnIntArray1748 : this.anIntArray1748) {
            buffer.writeInt(anAnIntArray1748);
        }

        buffer.writeInt(this.anInt1851);
        buffer.method1027(this.aString1850);
    }
}
