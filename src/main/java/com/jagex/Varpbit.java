package com.jagex;

public class Varpbit extends DoublyLinkedNode {
    public static ReferenceCache aReferenceCache385;
    public static ReferenceTable aReferenceTable383;

    static {
        aReferenceCache385 = new ReferenceCache(64);
    }

    public int varpIndex;
    public int lower;
    public int upper;

    static void method1301(Font var0, Font var1, Font var2) {
        Class55.anInt479 = (client.canvasWidth - 765) / 2;
        Class55.anInt474 = Class55.anInt479 + 202;
        Class57.anInt481 = Class55.anInt474 + 180;
        byte var7;
        int var8;
        int var10;
        int var12;
        int var19;
        int var20;
        int var21;
        int var22;
        int var23;
        int var24;
        int var41;
        if (Class55.loginWorldSelectorOpen) {
            int var36;
            int var39;
            if (Class46.aSpriteArray429 == null) {
                CacheReferenceTable var35 = Class74.sprites;
                var39 = var35.method900("sl_back");
                var36 = var35.method907(var39, "");
                Class46.aSpriteArray429 = Canvas.method643(var35, var39, var36);
            }

            if (Class149.aDoublyNode_Sub24_Sub4Array1178 == null) {
                Class149.aDoublyNode_Sub24_Sub4Array1178 = Class27_Sub2.method474(Class74.sprites, "sl_flags", "");
            }

            if (Class88.aDoublyNode_Sub24_Sub4Array653 == null) {
                Class88.aDoublyNode_Sub24_Sub4Array653 = Class27_Sub2.method474(Class74.sprites, "sl_arrows", "");
            }

            if (DoublyLinkedNode_Sub6.aDoublyNode_Sub24_Sub4Array801 == null) {
                DoublyLinkedNode_Sub6.aDoublyNode_Sub24_Sub4Array801 = Class27_Sub2.method474(Class74.sprites, "sl_stars", "");
            }

            if (Class27_Sub2.aDoublyNode_Sub24_Sub4_650 == null) {
                Class27_Sub2.aDoublyNode_Sub24_Sub4_650 = Class68.method375(Class74.sprites, "leftarrow", "");
            }

            if (HealthBar.aDoublyNode_Sub24_Sub4_848 == null) {
                HealthBar.aDoublyNode_Sub24_Sub4_848 = Class68.method375(Class74.sprites, "rightarrow", "");
            }

            JagGraphics.fillRect(Class55.anInt479, 23, 765, 480, 0);
            JagGraphics.method1376(Class55.anInt479, 0, 125, 23, 12425273, 9135624);
            JagGraphics.method1376(Class55.anInt479 + 125, 0, 640, 23, 5197647, 2697513);
            var0.method1154("Select a world", Class55.anInt479 + 62, 15, 0, -1);
            if (DoublyLinkedNode_Sub6.aDoublyNode_Sub24_Sub4Array801 != null) {
                DoublyLinkedNode_Sub6.aDoublyNode_Sub24_Sub4Array801[1].method1324(Class55.anInt479 + 140, 1);
                var1.method1152("Members only world", Class55.anInt479 + 152, 10, 16777215, -1);
                DoublyLinkedNode_Sub6.aDoublyNode_Sub24_Sub4Array801[0].method1324(Class55.anInt479 + 140, 12);
                var1.method1152("Free world", Class55.anInt479 + 152, 21, 16777215, -1);
            }

            if (Class88.aDoublyNode_Sub24_Sub4Array653 != null) {
                var41 = Class55.anInt479 + 280;
                if (World.anIntArray1874[0] == 0 && World.anIntArray1870[0] == 0) {
                    Class88.aDoublyNode_Sub24_Sub4Array653[2].method1324(var41, 4);
                } else {
                    Class88.aDoublyNode_Sub24_Sub4Array653[0].method1324(var41, 4);
                }

                if (World.anIntArray1874[0] == 0 && World.anIntArray1870[0] == 1) {
                    Class88.aDoublyNode_Sub24_Sub4Array653[3].method1324(var41 + 15, 4);
                } else {
                    Class88.aDoublyNode_Sub24_Sub4Array653[1].method1324(var41 + 15, 4);
                }

                var0.method1152("World", var41 + 32, 17, 16777215, -1);
                var8 = Class55.anInt479 + 390;
                if (World.anIntArray1874[0] == 1 && World.anIntArray1870[0] == 0) {
                    Class88.aDoublyNode_Sub24_Sub4Array653[2].method1324(var8, 4);
                } else {
                    Class88.aDoublyNode_Sub24_Sub4Array653[0].method1324(var8, 4);
                }

                if (World.anIntArray1874[0] == 1 && World.anIntArray1870[0] == 1) {
                    Class88.aDoublyNode_Sub24_Sub4Array653[3].method1324(var8 + 15, 4);
                } else {
                    Class88.aDoublyNode_Sub24_Sub4Array653[1].method1324(var8 + 15, 4);
                }

                var0.method1152("Players", var8 + 32, 17, 16777215, -1);
                var39 = Class55.anInt479 + 500;
                if (World.anIntArray1874[0] == 2 && World.anIntArray1870[0] == 0) {
                    Class88.aDoublyNode_Sub24_Sub4Array653[2].method1324(var39, 4);
                } else {
                    Class88.aDoublyNode_Sub24_Sub4Array653[0].method1324(var39, 4);
                }

                if (World.anIntArray1874[0] == 2 && World.anIntArray1870[0] == 1) {
                    Class88.aDoublyNode_Sub24_Sub4Array653[3].method1324(var39 + 15, 4);
                } else {
                    Class88.aDoublyNode_Sub24_Sub4Array653[1].method1324(var39 + 15, 4);
                }

                var0.method1152("Location", var39 + 32, 17, 16777215, -1);
                var36 = Class55.anInt479 + 610;
                if (World.anIntArray1874[0] == 3 && World.anIntArray1870[0] == 0) {
                    Class88.aDoublyNode_Sub24_Sub4Array653[2].method1324(var36, 4);
                } else {
                    Class88.aDoublyNode_Sub24_Sub4Array653[0].method1324(var36, 4);
                }

                if (World.anIntArray1874[0] == 3 && World.anIntArray1870[0] == 1) {
                    Class88.aDoublyNode_Sub24_Sub4Array653[3].method1324(var36 + 15, 4);
                } else {
                    Class88.aDoublyNode_Sub24_Sub4Array653[1].method1324(var36 + 15, 4);
                }

                var0.method1152("Type", var36 + 32, 17, 16777215, -1);
            }

            JagGraphics.fillRect(Class55.anInt479 + 708, 4, 50, 16, 0);
            var1.method1154("Cancel", Class55.anInt479 + 708 + 25, 16, 16777215, -1);
            Class55.anInt463 = -1;
            if (Class46.aSpriteArray429 != null) {
                var7 = 88;
                byte var44 = 19;
                var39 = 765 / (var7 + 1) - 1;
                var36 = 480 / (var44 + 1);

                do {
                    var20 = var36;
                    var21 = var39;
                    if (var36 * (var39 - 1) >= World.anInt1871) {
                        --var39;
                    }

                    if (var39 * (var36 - 1) >= World.anInt1871) {
                        --var36;
                    }

                    if (var39 * (var36 - 1) >= World.anInt1871) {
                        --var36;
                    }
                } while (var20 != var36 || var39 != var21);

                var20 = (765 - var39 * var7) / (var39 + 1);
                if (var20 > 5) {
                    var20 = 5;
                }

                var21 = (480 - var44 * var36) / (var36 + 1);
                if (var21 > 5) {
                    var21 = 5;
                }

                var22 = (765 - var7 * var39 - var20 * (var39 - 1)) / 2;
                var10 = (480 - var36 * var44 - var21 * (var36 - 1)) / 2;
                var23 = (var36 + World.anInt1871 - 1) / var36;
                Class55.anInt466 = var23 - var39;
                if (Class27_Sub2.aDoublyNode_Sub24_Sub4_650 != null && Class55.anInt460 > 0) {
                    Class27_Sub2.aDoublyNode_Sub24_Sub4_650.method1324(8, client.canvasHeight / 2 - Class27_Sub2.aDoublyNode_Sub24_Sub4_650.anInt377 / 2);
                }

                if (HealthBar.aDoublyNode_Sub24_Sub4_848 != null && Class55.anInt460 < Class55.anInt466) {
                    HealthBar.aDoublyNode_Sub24_Sub4_848.method1324(client.canvasWidth - HealthBar.aDoublyNode_Sub24_Sub4_848.anInt378 - 8, client.canvasHeight / 2 - HealthBar.aDoublyNode_Sub24_Sub4_848.anInt377 / 2);
                }

                var12 = var10 + 23;
                var24 = var22 + Class55.anInt479;
                var19 = 0;
                boolean var25 = false;
                int var26 = Class55.anInt460;

                int var27;
                for (var27 = var36 * var26; var27 < World.anInt1871 && var26 - Class55.anInt460 < var39; ++var27) {
                    World var30 = World.worlds[var27];
                    boolean var29 = true;
                    String var31 = Integer.toString(var30.population);
                    if (var30.population == -1) {
                        var31 = "OFF";
                        var29 = false;
                    } else if (var30.population > 1980) {
                        var31 = "FULL";
                        var29 = false;
                    }

                    int var32 = 0;
                    byte var33;
                    if (var30.isTournament()) {
                        if (var30.isMembers()) {
                            var33 = 7;
                        } else {
                            var33 = 6;
                        }
                    } else if (var30.isDeadman()) {
                        var32 = 16711680;
                        if (var30.isMembers()) {
                            var33 = 5;
                        } else {
                            var33 = 4;
                        }
                    } else if (var30.isPVP()) {
                        if (var30.isMembers()) {
                            var33 = 3;
                        } else {
                            var33 = 2;
                        }
                    } else if (var30.isMembers()) {
                        var33 = 1;
                    } else {
                        var33 = 0;
                    }

                    if (Mouse.x >= var24 && Mouse.y >= var12 && Mouse.x < var7 + var24 && Mouse.y < var44 + var12 && var29) {
                        Class55.anInt463 = var27;
                        Class46.aSpriteArray429[var33].method834(var24, var12, 128, 16777215);
                        var25 = true;
                    } else {
                        Class46.aSpriteArray429[var33].method817(var24, var12);
                    }

                    if (Class149.aDoublyNode_Sub24_Sub4Array1178 != null) {
                        Class149.aDoublyNode_Sub24_Sub4Array1178[(var30.isMembers() ? 8 : 0) + var30.location].method1324(var24 + 29, var12);
                    }

                    var0.method1154(Integer.toString(var30.anInt1875), var24 + 15, var44 / 2 + var12 + 5, var32, -1);
                    var1.method1154(var31, var24 + 60, var44 / 2 + var12 + 5, 268435455, -1);
                    var12 = var12 + var21 + var44;
                    ++var19;
                    if (var19 >= var36) {
                        var12 = var10 + 23;
                        var24 = var24 + var7 + var20;
                        var19 = 0;
                        ++var26;
                    }
                }

                if (var25) {
                    var27 = var1.method1145(World.worlds[Class55.anInt463].activity) + 6;
                    int var28 = var1.anInt375 + 8;
                    int var50 = Mouse.y + 25;
                    if (var28 + var50 > 480) {
                        var50 = Mouse.y - 25 - var28;
                    }

                    JagGraphics.fillRect(Mouse.x - var27 / 2, var50, var27, var28, 16777120);
                    JagGraphics.method1372(Mouse.x - var27 / 2, var50, var27, var28, 0);
                    var1.method1154(World.worlds[Class55.anInt463].activity, Mouse.x, var50 + var1.anInt375 + 4, 0, -1);
                }
            }

            Class20.aClass216_284.method22(0, 0);
        } else {
            Class26.aSprite308.method817(Class55.anInt479, 0);
            Statics1.aSprite324.method817(Class55.anInt479 + 382, 0);
            Class199.aDoublyNode_Sub24_Sub4_1623.method1324(Class55.anInt479 + 382 - Class199.aDoublyNode_Sub24_Sub4_1623.anInt378 / 2, 18);
            if (client.gameState == 0 || client.gameState == 5) {
                var7 = 20;
                var0.method1154("RuneScape is loading - please wait...", Class55.anInt474 + 180, 245 - var7, 16777215, -1);
                var8 = 253 - var7;
                JagGraphics.method1372(Class55.anInt474 + 180 - 152, var8, 304, 34, 9179409);
                JagGraphics.method1372(Class55.anInt474 + 180 - 151, var8 + 1, 302, 32, 0);
                JagGraphics.fillRect(Class55.anInt474 + 180 - 150, var8 + 2, Class55.anInt473 * 3, 30, 9179409);
                JagGraphics.fillRect(Class55.anInt473 * 3 + (Class55.anInt474 + 180 - 150), var8 + 2, 300 - Class55.anInt473 * 3, 30, 0);
                var0.method1154(Class55.aString475, Class55.anInt474 + 180, 276 - var7, 16777215, -1);
            }

            String var9;
            char[] var11;
            String var13;
            String var15;
            String var17;
            char[] var18;
            short var40;
            short var42;
            String var43;
            if (client.gameState == 20) {
                Class8.aDoublyNode_Sub24_Sub4_126.method1324(Class55.anInt474 + 180 - Class8.aDoublyNode_Sub24_Sub4_126.anInt378 / 2, 271 - Class8.aDoublyNode_Sub24_Sub4_126.anInt377 / 2);
                var40 = 201;
                var0.method1154(Class55.loginResponse1, Class55.anInt474 + 180, var40, 16776960, 0);
                var41 = var40 + 15;
                var0.method1154(Class55.loginResponse2, Class55.anInt474 + 180, var41, 16776960, 0);
                var41 += 15;
                var0.method1154(Class55.loginResponse3, Class55.anInt474 + 180, var41, 16776960, 0);
                var41 += 15;
                var41 += 7;
                if (Class55.loginState != 4) {
                    var0.method1152("Login: ", Class55.anInt474 + 180 - 110, var41, 16777215, 0);
                    var42 = 200;
                    if (!client.preferences.rememberMe) {
                        var15 = Class55.username;
                    } else {
                        var9 = Class55.username;
                        var10 = var9.length();
                        var11 = new char[var10];

                        for (var12 = 0; var12 < var10; ++var12) {
                            var11[var12] = '*';
                        }

                        var13 = new String(var11);
                        var15 = var13;
                    }

                    for (var15 = var15; var0.method1145(var15) > var42; var15 = var15.substring(0, var15.length() - 1)) {
                    }

                    var0.method1152(DoublyLinkedNode_Sub24_Sub3.method1166(var15), Class55.anInt474 + 180 - 70, var41, 16777215, 0);
                    var41 += 15;
                    var9 = "Password: ";
                    var17 = Class55.password;
                    var12 = var17.length();
                    var18 = new char[var12];

                    for (var19 = 0; var19 < var12; ++var19) {
                        var18[var19] = '*';
                    }

                    var43 = new String(var18);
                    var0.method1152(var9 + var43, Class55.anInt474 + 180 - 108, var41, 16777215, 0);
                    var41 += 15;
                }
            }

            if (client.gameState == 10 || client.gameState == 11) {
                Class8.aDoublyNode_Sub24_Sub4_126.method1324(Class55.anInt474, 171);
                short var4;
                if (Class55.loginState == 0) {
                    var40 = 251;
                    var0.method1154("Welcome to RuneScape", Class55.anInt474 + 180, var40, 16776960, 0);
                    var41 = var40 + 30;
                    var8 = Class55.anInt474 + 180 - 80;
                    var4 = 291;
                    Class216.aDoublyNode_Sub24_Sub4_1815.method1324(var8 - 73, var4 - 20);
                    var0.method1149("New User", var8 - 73, var4 - 20, 144, 40, 16777215, 0, 1, 1, 0);
                    var8 = Class55.anInt474 + 180 + 80;
                    Class216.aDoublyNode_Sub24_Sub4_1815.method1324(var8 - 73, var4 - 20);
                    var0.method1149("Existing User", var8 - 73, var4 - 20, 144, 40, 16777215, 0, 1, 1, 0);
                } else if (Class55.loginState == 1) {
                    var0.method1154(Class55.aString471, Class55.anInt474 + 180, 201, 16776960, 0);
                    var40 = 236;
                    var0.method1154(Class55.loginResponse1, Class55.anInt474 + 180, var40, 16777215, 0);
                    var41 = var40 + 15;
                    var0.method1154(Class55.loginResponse2, Class55.anInt474 + 180, var41, 16777215, 0);
                    var41 += 15;
                    var0.method1154(Class55.loginResponse3, Class55.anInt474 + 180, var41, 16777215, 0);
                    var41 += 15;
                    var8 = Class55.anInt474 + 180 - 80;
                    var4 = 321;
                    Class216.aDoublyNode_Sub24_Sub4_1815.method1324(var8 - 73, var4 - 20);
                    var0.method1154("Continue", var8, var4 + 5, 16777215, 0);
                    var8 = Class55.anInt474 + 180 + 80;
                    Class216.aDoublyNode_Sub24_Sub4_1815.method1324(var8 - 73, var4 - 20);
                    var0.method1154("Cancel", var8, var4 + 5, 16777215, 0);
                } else if (Class55.loginState == 2) {
                    var40 = 201;
                    var0.method1154(Class55.loginResponse1, Class57.anInt481, var40, 16776960, 0);
                    var41 = var40 + 15;
                    var0.method1154(Class55.loginResponse2, Class57.anInt481, var41, 16776960, 0);
                    var41 += 15;
                    var0.method1154(Class55.loginResponse3, Class57.anInt481, var41, 16776960, 0);
                    var41 += 15;
                    var41 += 7;
                    var0.method1152("Login: ", Class57.anInt481 - 110, var41, 16777215, 0);
                    var42 = 200;
                    if (!client.preferences.rememberMe) {
                        var15 = Class55.username;
                    } else {
                        var9 = Class55.username;
                        var10 = var9.length();
                        var11 = new char[var10];

                        for (var12 = 0; var12 < var10; ++var12) {
                            var11[var12] = '*';
                        }

                        var13 = new String(var11);
                        var15 = var13;
                    }

                    for (var15 = var15; var0.method1145(var15) > var42; var15 = var15.substring(1)) {
                    }

                    var0.method1152(DoublyLinkedNode_Sub24_Sub3.method1166(var15) + (Class55.anInt461 == 0 & client.engineCycle % 40 < 20 ? World.getColorTags(16776960) + "|" : ""), Class57.anInt481 - 70, var41, 16777215, 0);
                    var41 += 15;
                    var9 = "Password: ";
                    var17 = Class55.password;
                    var12 = var17.length();
                    var18 = new char[var12];

                    for (var19 = 0; var19 < var12; ++var19) {
                        var18[var19] = '*';
                    }

                    var43 = new String(var18);
                    var0.method1152(var9 + var43 + (Class55.anInt461 == 1 & client.engineCycle % 40 < 20 ? World.getColorTags(16776960) + "|" : ""), Class57.anInt481 - 108, var41, 16777215, 0);
                    var41 += 15;
                    var40 = 277;
                    var23 = Class57.anInt481 + -117;
                    DoublyLinkedNode_Sub24_Sub4 var34 = OutgoingPacketMeta.method6(client.aBoolean958, Class55.aBoolean477);
                    var34.method1324(var23, var40);
                    var23 = var23 + var34.anInt378 + 5;
                    var1.method1152("Remember username", var23, var40 + 13, 16776960, 0);
                    var23 = Class57.anInt481 + 24;
                    var34 = OutgoingPacketMeta.method6(client.preferences.rememberMe, Class55.aBoolean472);
                    var34.method1324(var23, var40);
                    var23 = var23 + var34.anInt378 + 5;
                    var1.method1152("Hide username", var23, var40 + 13, 16776960, 0);
                    var41 = var40 + 15;
                    var24 = Class57.anInt481 - 80;
                    short var48 = 321;
                    Class216.aDoublyNode_Sub24_Sub4_1815.method1324(var24 - 73, var48 - 20);
                    var0.method1154("Login", var24, var48 + 5, 16777215, 0);
                    var24 = Class57.anInt481 + 80;
                    Class216.aDoublyNode_Sub24_Sub4_1815.method1324(var24 - 73, var48 - 20);
                    var0.method1154("Cancel", var24, var48 + 5, 16777215, 0);
                    var40 = 357;
                    switch (Class55.anInt469) {
                        case 2:
                            Class85.aString636 = "Having trouble logging in?";
                            break;
                        default:
                            Class85.aString636 = "Can't login? Click here.";
                    }

                    Class45.aClass215_418 = new Class215(Class57.anInt481, var40, var1.method1145(Class85.aString636), 11);
                    Statics6.aClass215_846 = new Class215(Class57.anInt481, var40, var1.method1145("Still having trouble logging in?"), 11);
                    var1.method1154(Class85.aString636, Class57.anInt481, var40, 16777215, 0);
                } else if (Class55.loginState == 3) {
                    var40 = 201;
                    var0.method1154("Invalid credentials.", Class55.anInt474 + 180, var40, 16776960, 0);
                    var41 = var40 + 20;
                    var1.method1154("For accounts created after 24th November 2010, please use your", Class55.anInt474 + 180, var41, 16776960, 0);
                    var41 += 15;
                    var1.method1154("email address to login. Otherwise please login with your username.", Class55.anInt474 + 180, var41, 16776960, 0);
                    var41 += 15;
                    var8 = Class55.anInt474 + 180;
                    var4 = 276;
                    Class216.aDoublyNode_Sub24_Sub4_1815.method1324(var8 - 73, var4 - 20);
                    var2.method1154("Try again", var8, var4 + 5, 16777215, 0);
                    var8 = Class55.anInt474 + 180;
                    var4 = 326;
                    Class216.aDoublyNode_Sub24_Sub4_1815.method1324(var8 - 73, var4 - 20);
                    var2.method1154("Forgotten password?", var8, var4 + 5, 16777215, 0);
                } else {
                    String var16;
                    if (Class55.loginState == 4) {
                        var0.method1154("Authenticator", Class55.anInt474 + 180, 201, 16776960, 0);
                        var40 = 236;
                        var0.method1154(Class55.loginResponse1, Class55.anInt474 + 180, var40, 16777215, 0);
                        var41 = var40 + 15;
                        var0.method1154(Class55.loginResponse2, Class55.anInt474 + 180, var41, 16777215, 0);
                        var41 += 15;
                        var0.method1154(Class55.loginResponse3, Class55.anInt474 + 180, var41, 16777215, 0);
                        var41 += 15;
                        var16 = "PIN: ";
                        String var14 = DefaultOperatingSystemProvider.aString1867;
                        var22 = var14.length();
                        char[] var46 = new char[var22];

                        for (var23 = 0; var23 < var22; ++var23) {
                            var46[var23] = '*';
                        }

                        var9 = new String(var46);
                        var0.method1152(var16 + var9 + (client.engineCycle % 40 < 20 ? World.getColorTags(16776960) + "|" : ""), Class55.anInt474 + 180 - 108, var41, 16777215, 0);
                        var41 -= 8;
                        var0.method1152("Trust this computer", Class55.anInt474 + 180 - 9, var41, 16776960, 0);
                        var41 += 15;
                        var0.method1152("for 30 days: ", Class55.anInt474 + 180 - 9, var41, 16776960, 0);
                        var21 = Class55.anInt474 + 180 - 9 + var0.method1145("for 30 days: ") + 15;
                        var22 = var41 - var0.anInt375;
                        DoublyLinkedNode_Sub24_Sub4 var47;
                        if (Class55.aBoolean462) {
                            var47 = Class20.aDoublyNode_Sub24_Sub4_288;
                        } else {
                            var47 = Statics11.aDoublyNode_Sub24_Sub4_1148;
                        }

                        var47.method1324(var21, var22);
                        var41 += 15;
                        var23 = Class55.anInt474 + 180 - 80;
                        short var45 = 321;
                        Class216.aDoublyNode_Sub24_Sub4_1815.method1324(var23 - 73, var45 - 20);
                        var0.method1154("Continue", var23, var45 + 5, 16777215, 0);
                        var23 = Class55.anInt474 + 180 + 80;
                        Class216.aDoublyNode_Sub24_Sub4_1815.method1324(var23 - 73, var45 - 20);
                        var0.method1154("Cancel", var23, var45 + 5, 16777215, 0);
                        var1.method1154("<u=ff>Can't Log In?</u>", Class55.anInt474 + 180, var45 + 36, 255, 0);
                    } else {
                        short var49;
                        if (Class55.loginState == 5) {
                            var0.method1154("Forgotten your password?", Class55.anInt474 + 180, 201, 16776960, 0);
                            var40 = 221;
                            var2.method1154(Class55.loginResponse1, Class55.anInt474 + 180, var40, 16776960, 0);
                            var41 = var40 + 15;
                            var2.method1154(Class55.loginResponse2, Class55.anInt474 + 180, var41, 16776960, 0);
                            var41 += 15;
                            var2.method1154(Class55.loginResponse3, Class55.anInt474 + 180, var41, 16776960, 0);
                            var41 += 15;
                            var41 += 14;
                            var0.method1152("Username/email: ", Class55.anInt474 + 180 - 145, var41, 16777215, 0);
                            var42 = 174;
                            if (!client.preferences.rememberMe) {
                                var15 = Class55.username;
                            } else {
                                var9 = Class55.username;
                                var10 = var9.length();
                                var11 = new char[var10];

                                for (var12 = 0; var12 < var10; ++var12) {
                                    var11[var12] = '*';
                                }

                                var13 = new String(var11);
                                var15 = var13;
                            }

                            for (var15 = var15; var0.method1145(var15) > var42; var15 = var15.substring(1)) {
                            }

                            var0.method1152(DoublyLinkedNode_Sub24_Sub3.method1166(var15) + (client.engineCycle % 40 < 20 ? World.getColorTags(16776960) + "|" : ""), Class55.anInt474 + 180 - 34, var41, 16777215, 0);
                            var41 += 15;
                            var20 = Class55.anInt474 + 180 - 80;
                            var49 = 321;
                            Class216.aDoublyNode_Sub24_Sub4_1815.method1324(var20 - 73, var49 - 20);
                            var0.method1154("Recover", var20, var49 + 5, 16777215, 0);
                            var20 = Class55.anInt474 + 180 + 80;
                            Class216.aDoublyNode_Sub24_Sub4_1815.method1324(var20 - 73, var49 - 20);
                            var0.method1154("Back", var20, var49 + 5, 16777215, 0);
                            var49 = 356;
                            var1.method1154("Still having trouble logging in?", Class57.anInt481, var49, 268435455, 0);
                        } else if (Class55.loginState == 6) {
                            var40 = 201;
                            var0.method1154(Class55.loginResponse1, Class55.anInt474 + 180, var40, 16776960, 0);
                            var41 = var40 + 15;
                            var0.method1154(Class55.loginResponse2, Class55.anInt474 + 180, var41, 16776960, 0);
                            var41 += 15;
                            var0.method1154(Class55.loginResponse3, Class55.anInt474 + 180, var41, 16776960, 0);
                            var41 += 15;
                            var8 = Class55.anInt474 + 180;
                            var4 = 321;
                            Class216.aDoublyNode_Sub24_Sub4_1815.method1324(var8 - 73, var4 - 20);
                            var0.method1154("Back", var8, var4 + 5, 16777215, 0);
                        } else if (Class55.loginState == 7) {
                            var40 = 216;
                            var0.method1154("Your date of birth isn't set.", Class55.anInt474 + 180, var40, 16776960, 0);
                            var41 = var40 + 15;
                            var2.method1154("Please verify your account status by", Class55.anInt474 + 180, var41, 16776960, 0);
                            var41 += 15;
                            var2.method1154("setting your date of birth.", Class55.anInt474 + 180, var41, 16776960, 0);
                            var41 += 15;
                            var8 = Class55.anInt474 + 180 - 80;
                            var4 = 321;
                            Class216.aDoublyNode_Sub24_Sub4_1815.method1324(var8 - 73, var4 - 20);
                            var0.method1154("Set Date of Birth", var8, var4 + 5, 16777215, 0);
                            var8 = Class55.anInt474 + 180 + 80;
                            Class216.aDoublyNode_Sub24_Sub4_1815.method1324(var8 - 73, var4 - 20);
                            var0.method1154("Back", var8, var4 + 5, 16777215, 0);
                        } else if (Class55.loginState == 8) {
                            var40 = 216;
                            var0.method1154("Sorry, but your account is not eligible to play.", Class55.anInt474 + 180, var40, 16776960, 0);
                            var41 = var40 + 15;
                            var2.method1154("For more information, please take a look at", Class55.anInt474 + 180, var41, 16776960, 0);
                            var41 += 15;
                            var2.method1154("our privacy policy.", Class55.anInt474 + 180, var41, 16776960, 0);
                            var41 += 15;
                            var8 = Class55.anInt474 + 180 - 80;
                            var4 = 321;
                            Class216.aDoublyNode_Sub24_Sub4_1815.method1324(var8 - 73, var4 - 20);
                            var0.method1154("Privacy Policy", var8, var4 + 5, 16777215, 0);
                            var8 = Class55.anInt474 + 180 + 80;
                            Class216.aDoublyNode_Sub24_Sub4_1815.method1324(var8 - 73, var4 - 20);
                            var0.method1154("Back", var8, var4 + 5, 16777215, 0);
                        } else if (Class55.loginState == 12) {
                            var40 = 201;
                            String var3 = "";
                            var16 = "";
                            var15 = "";
                            switch (Class55.anInt468) {
                                case 0:
                                    var3 = "Your account has been disabled.";
                                    var16 = Statics24.aString1419;
                                    var15 = "";
                                    break;
                                case 1:
                                    var3 = "Account locked as we suspect it has been stolen.";
                                    var16 = Statics24.aString1414;
                                    var15 = "";
                                    break;
                                default:
                                    TilePaint.method1500(false);
                            }

                            var0.method1154(var3, Class55.anInt474 + 180, var40, 16776960, 0);
                            var41 = var40 + 15;
                            var2.method1154(var16, Class55.anInt474 + 180, var41, 16776960, 0);
                            var41 += 15;
                            var2.method1154(var15, Class55.anInt474 + 180, var41, 16776960, 0);
                            var41 += 15;
                            var20 = Class55.anInt474 + 180;
                            var49 = 276;
                            Class216.aDoublyNode_Sub24_Sub4_1815.method1324(var20 - 73, var49 - 20);
                            var0.method1154("Support Page", var20, var49 + 5, 16777215, 0);
                            var20 = Class55.anInt474 + 180;
                            var49 = 326;
                            Class216.aDoublyNode_Sub24_Sub4_1815.method1324(var20 - 73, var49 - 20);
                            var0.method1154("Back", var20, var49 + 5, 16777215, 0);
                        } else if (Class55.loginState == 24) {
                            var40 = 221;
                            var0.method1154(Class55.loginResponse1, Class55.anInt474 + 180, var40, 16777215, 0);
                            var41 = var40 + 15;
                            var0.method1154(Class55.loginResponse2, Class55.anInt474 + 180, var41, 16777215, 0);
                            var41 += 15;
                            var0.method1154(Class55.loginResponse3, Class55.anInt474 + 180, var41, 16777215, 0);
                            var41 += 15;
                            var8 = Class55.anInt474 + 180;
                            var4 = 301;
                            Class216.aDoublyNode_Sub24_Sub4_1815.method1324(var8 - 73, var4 - 20);
                            var0.method1154("Ok", var8, var4 + 5, 16777215, 0);
                        }
                    }
                }
            }

            if (client.gameState >= 10) {
                int[] var6 = new int[4];
                JagGraphics.method1366(var6);

                JagGraphics.setClip(Class55.anInt479, 0, Class55.anInt479 + 765, client.canvasHeight);
                AsyncOutputStream.aClass45_105.method283(Class55.anInt479 - 22, client.engineCycle);
                AsyncOutputStream.aClass45_105.method283(Class55.anInt479 + 22 + 765 - 128, client.engineCycle);
                JagGraphics.method1373(var6);
            }

            AssociateComparator_Sub2.aDoublyNode_Sub24_Sub4Array765[client.preferences.loginScreenAudioDisabled ? 1 : 0].method1324(Class55.anInt479 + 765 - 40, 463);
            if (client.gameState > 5 && Class149.aClass149_1190 == Class65.aClass149_525) {
                if (Node_Sub13.aDoublyNode_Sub24_Sub4_811 != null) {
                    var41 = Class55.anInt479 + 5;
                    var42 = 463;
                    byte var38 = 100;
                    byte var5 = 35;
                    Node_Sub13.aDoublyNode_Sub24_Sub4_811.method1324(var41, var42);
                    var0.method1154("World" + " " + client.currentWorld, var38 / 2 + var41, var5 / 2 + var42 - 2, 16777215, 0);
                    if (Statics1.aClass105_322 != null) {
                        var1.method1154("Loading...", var38 / 2 + var41, var5 / 2 + var42 + 12, 16777215, 0);
                    } else {
                        var1.method1154("Click to switch", var38 / 2 + var41, var5 / 2 + var42 + 12, 16777215, 0);
                    }
                } else {
                    Node_Sub13.aDoublyNode_Sub24_Sub4_811 = Class68.method375(Class74.sprites, "sl_button", "");
                }
            }

        }
    }

    void method988(Buffer var1, int var2) {
        if (var2 == 1) {
            this.varpIndex = var1.readUShort();
            this.lower = var1.readUByte();
            this.upper = var1.readUByte();
        }

    }

    public void method990(Buffer var1) {
        while (true) {
            int var2 = var1.readUByte();
            if (var2 == 0) {
                return;
            }

            this.method988(var1, var2);
        }
    }
}
