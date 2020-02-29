package com.jagex;

import java.util.Date;

public final class CameraCapture {
    static int anInt1913;
    int anInt1912;
    int minFineX;
    int minFineY;
    int flag;
    int anInt1914;
    int anInt1922;
    int maxFineY;
    int anInt1921;
    int anInt1920;
    int anInt1917;
    int componentHeight;
    int maxFineX;
    int anInt1918;
    int anInt1911;
    int tileHeight;
    int anInt1915;
    int anInt1919;
    int anInt1916;

    CameraCapture() {
    }

    public static ItemDefinition getItemDefinition(int var0) {
        ItemDefinition var2 = (ItemDefinition) ItemDefinition.aReferenceCache720.get((long) var0);
        if (var2 != null) {
            return var2;
        }
        byte[] var3 = ItemDefinition.aReferenceTable721.unpack(10, var0);
        var2 = new ItemDefinition();
        var2.anInt693 = var0;
        if (var3 != null) {
            var2.method528(new Buffer(var3));
        }

        var2.method23();
        if (var2.noteTemplateId != -1) {
            var2.method524(getItemDefinition(var2.noteTemplateId), getItemDefinition(var2.noteId));
        }

        if (var2.anInt714 != -1) {
            var2.method525(getItemDefinition(var2.anInt714), getItemDefinition(var2.anInt713));
        }

        if (var2.anInt712 != -1) {
            var2.method523(getItemDefinition(var2.anInt712), getItemDefinition(var2.anInt715));
        }

        if (!Statics6.loadMembersItemDefinitions && var2.members) {
            var2.name = "Members object";
            var2.tradable = false;
            var2.groundActions = null;
            var2.actions = null;
            var2.shiftClickActionIndex = -1;
            var2.team = 0;
            if (var2.properties != null) {
                boolean var4 = false;

                for (Node var5 = var2.properties.method235(); var5 != null; var5 = var2.properties.method234()) {
                    DefinitionProperty var6 = BoundaryDecor.getDefinitionProperty((int) var5.key);
                    if (var6.deleteOnUse) {
                        var5.unlink();
                    } else {
                        var4 = true;
                    }
                }

                if (!var4) {
                    var2.properties = null;
                }
            }
        }

        ItemDefinition.aReferenceCache720.put(var2, (long) var0);
        return var2;
    }

    public static void method1416() {
        try {
            Statics5.aBufferedFile_840.close();

            for (int var0 = 0; var0 < Statics5.anInt834; ++var0) {
                Statics10.aBufferedFileArray1135[var0].close();
            }

            Statics5.aBufferedFile_835.close();
            Statics5.random.close();
        } catch (Exception ignored) {
        }

    }

    static void method1417(String var0) {
        Class147.aString1162 = var0;

        try {
            String var1 = client.instance.getParameter(Integer.toString(18));
            String var2 = client.instance.getParameter(Integer.toString(13));
            String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
            if (var0.length() == 0) {
                var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
            } else {
                String var4 = var3 + "; Expires=";
                long var5 = Class24.currentTime() + 94608000000L;
                Statics12.aCalendar1207.setTime(new Date(var5));
                int var7 = Statics12.aCalendar1207.get(7);
                int var8 = Statics12.aCalendar1207.get(5);
                int var9 = Statics12.aCalendar1207.get(2);
                int var10 = Statics12.aCalendar1207.get(1);
                int var11 = Statics12.aCalendar1207.get(11);
                int var12 = Statics12.aCalendar1207.get(12);
                int var13 = Statics12.aCalendar1207.get(13);
                String var14 = Statics12.aStringArray1209[var7 - 1] + ", " + var8 / 10 + var8 % 10 + "-" + Statics12.aStringArrayArray1208[0][var9] + "-" + var10 + " " + var11 / 10 + var11 % 10 + ":" + var12 / 10 + var12 % 10 + ":" + var13 / 10 + var13 % 10 + " GMT";
                var3 = var4 + var14 + "; Max-Age=" + 94608000L;
            }

            Class15.method113(client.instance, "document.cookie=\"" + var3 + "\"");
        } catch (Throwable ignored) {
        }

    }
}
