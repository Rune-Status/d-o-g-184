package com.jagex;

import java.util.HashMap;

public class Class202 {
    ReferenceTable aReferenceTable1630;
    ReferenceTable aReferenceTable1631;
    HashMap aHashMap1629;

    public Class202(ReferenceTable var1, ReferenceTable var2) {
        this.aReferenceTable1630 = var1;
        this.aReferenceTable1631 = var2;
        this.aHashMap1629 = new HashMap();
    }

    public static Class193 method1186(int var0) {
        Class193[] var1 = Bzip2Context.method1170();

        for (Class193 var3 : var1) {
            if (var0 == var3.anInt1566) {
                return var3;
            }
        }

        return null;
    }

    public HashMap method1185(Class199[] var1) {
        HashMap var2 = new HashMap();

        for (Class199 var5 : var1) {
            if (this.aHashMap1629.containsKey(var5)) {
                var2.put(var5, this.aHashMap1629.get(var5));
            } else {
                ReferenceTable var6 = this.aReferenceTable1630;
                ReferenceTable var7 = this.aReferenceTable1631;
                String var8 = var5.aString1619;
                int var9 = var6.method900(var8);
                int var10 = var6.method907(var9, "");
                Font var11 = ClanMember.method708(var6, var7, var9, var10);
                if (var11 != null) {
                    this.aHashMap1629.put(var5, var11);
                    var2.put(var5, var11);
                }
            }
        }

        return var2;
    }
}
