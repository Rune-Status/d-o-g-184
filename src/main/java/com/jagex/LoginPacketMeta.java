package com.jagex;

public class LoginPacketMeta implements Class127 {
    public static final LoginPacketMeta aLoginPacketMeta1998;
    public static final LoginPacketMeta aLoginPacketMeta1997;
    public static final LoginPacketMeta aLoginPacketMeta1996;
    static final LoginPacketMeta aLoginPacketMeta1999;
    static final LoginPacketMeta aLoginPacketMeta1995;
    static final LoginPacketMeta[] aLoginPacketMetaArray1994;
    static OldConnectionTask aOldConnectionTask_1992;

    static {
        aLoginPacketMeta1998 = new LoginPacketMeta(14);
        aLoginPacketMeta1999 = new LoginPacketMeta(15);
        aLoginPacketMeta1997 = new LoginPacketMeta(16);
        aLoginPacketMeta1996 = new LoginPacketMeta(18);
        aLoginPacketMeta1995 = new LoginPacketMeta(27);
        aLoginPacketMetaArray1994 = new LoginPacketMeta[32];
        LoginPacketMeta[] var0 = Enum_Sub4.method849();

        for (LoginPacketMeta aVar0 : var0) {
            aLoginPacketMetaArray1994[aVar0.anInt1993] = aVar0;
        }

    }

    public final int anInt1993;

    LoginPacketMeta(int var1) {
        this.anInt1993 = var1;
    }

    static void method1498() {
        int var6;
        if (Class55.loginWorldSelectorOpen) {
            while (true) {
                if (!DynamicObject.method1114()) {
                    if (Mouse.clickMeta != 1 && (Class27_Sub1.aBoolean492 || Mouse.clickMeta != 4)) {
                        break;
                    }

                    int var1 = Class55.anInt479 + 280;
                    if (Mouse.clickX >= var1 && Mouse.clickX <= var1 + 14 && Mouse.clickY >= 4 && Mouse.clickY <= 18) {
                        Enum_Sub4.method852(0, 0);
                        break;
                    }

                    if (Mouse.clickX >= var1 + 15 && Mouse.clickX <= var1 + 80 && Mouse.clickY >= 4 && Mouse.clickY <= 18) {
                        Enum_Sub4.method852(0, 1);
                        break;
                    }

                    int var2 = Class55.anInt479 + 390;
                    if (Mouse.clickX >= var2 && Mouse.clickX <= var2 + 14 && Mouse.clickY >= 4 && Mouse.clickY <= 18) {
                        Enum_Sub4.method852(1, 0);
                        break;
                    }

                    if (Mouse.clickX >= var2 + 15 && Mouse.clickX <= var2 + 80 && Mouse.clickY >= 4 && Mouse.clickY <= 18) {
                        Enum_Sub4.method852(1, 1);
                        break;
                    }

                    int var17 = Class55.anInt479 + 500;
                    if (Mouse.clickX >= var17 && Mouse.clickX <= var17 + 14 && Mouse.clickY >= 4 && Mouse.clickY <= 18) {
                        Enum_Sub4.method852(2, 0);
                        break;
                    }

                    if (Mouse.clickX >= var17 + 15 && Mouse.clickX <= var17 + 80 && Mouse.clickY >= 4 && Mouse.clickY <= 18) {
                        Enum_Sub4.method852(2, 1);
                        break;
                    }

                    var6 = Class55.anInt479 + 610;
                    if (Mouse.clickX >= var6 && Mouse.clickX <= var6 + 14 && Mouse.clickY >= 4 && Mouse.clickY <= 18) {
                        Enum_Sub4.method852(3, 0);
                        break;
                    }

                    if (Mouse.clickX >= var6 + 15 && Mouse.clickX <= var6 + 80 && Mouse.clickY >= 4 && Mouse.clickY <= 18) {
                        Enum_Sub4.method852(3, 1);
                        break;
                    }

                    if (Mouse.clickX >= Class55.anInt479 + 708 && Mouse.clickY >= 4 && Mouse.clickX <= Class55.anInt479 + 708 + 50 && Mouse.clickY <= 20) {
                        SceneOffset.method1402();
                        break;
                    }

                    if (Class55.anInt463 != -1) {
                        World var7 = World.worlds[Class55.anInt463];
                        Class80.setWorld(var7);
                        SceneOffset.method1402();
                    } else {
                        if (Class55.anInt460 > 0 && Class27_Sub2.aDoublyNode_Sub24_Sub4_650 != null && Mouse.clickX >= 0 && Mouse.clickX <= Class27_Sub2.aDoublyNode_Sub24_Sub4_650.anInt378 && Mouse.clickY >= client.canvasHeight / 2 - 50 && Mouse.clickY <= client.canvasHeight / 2 + 50) {
                            --Class55.anInt460;
                        }

                        if (Class55.anInt460 < Class55.anInt466 && HealthBar.aDoublyNode_Sub24_Sub4_848 != null && Mouse.clickX >= client.canvasWidth - HealthBar.aDoublyNode_Sub24_Sub4_848.anInt378 - 5 && Mouse.clickX <= client.canvasWidth && Mouse.clickY >= client.canvasHeight / 2 - 50 && Mouse.clickY <= client.canvasHeight / 2 + 50) {
                            ++Class55.anInt460;
                        }
                    }
                    break;
                }

                if (Class53.anInt457 == 13) {
                    SceneOffset.method1402();
                    break;
                }

                if (Class53.anInt457 == 96) {
                    if (Class55.anInt460 > 0 && Class27_Sub2.aDoublyNode_Sub24_Sub4_650 != null) {
                        --Class55.anInt460;
                    }
                } else if (Class53.anInt457 == 97 && Class55.anInt460 < Class55.anInt466 && HealthBar.aDoublyNode_Sub24_Sub4_848 != null) {
                    ++Class55.anInt460;
                }
            }

        } else {
            if ((Mouse.clickMeta == 1 || !Class27_Sub1.aBoolean492 && Mouse.clickMeta == 4) && Mouse.clickX >= Class55.anInt479 + 765 - 50 && Mouse.clickY >= 453) {
                client.preferences.loginScreenAudioDisabled = !client.preferences.loginScreenAudioDisabled;
                Class149.method854();
                if (!client.preferences.loginScreenAudioDisabled) {
                    Class114.method674(Statics15.aCacheReferenceTable1234, "scape main", "", 255, false);
                } else {
                    Class96.method533();
                }
            }

            if (client.gameState != 5) {
                if (Class55.aLong467 == -1L) {
                    Class55.aLong467 = Class24.currentTime() + 1000L;
                }

                long var4 = Class24.currentTime();
                boolean var3;
                if (client.anArrayList928 != null && client.anInt926 < client.anArrayList928.size()) {
                    while (true) {
                        if (client.anInt926 >= client.anArrayList928.size()) {
                            var3 = true;
                            break;
                        }

                        Class46 var13 = (Class46) client.anArrayList928.get(client.anInt926);
                        if (!var13.method291()) {
                            var3 = false;
                            break;
                        }

                        ++client.anInt926;
                    }
                } else {
                    var3 = true;
                }

                if (var3 && Class55.aLong465 == -1L) {
                    Class55.aLong465 = var4;
                    if (Class55.aLong465 > Class55.aLong467) {
                        Class55.aLong467 = Class55.aLong465;
                    }
                }

                if (client.gameState == 10 || client.gameState == 11) {
                    if (Class65.aClass149_525 == Class149.aClass149_1190) {
                        if (Mouse.clickMeta == 1 || !Class27_Sub1.aBoolean492 && Mouse.clickMeta == 4) {
                            var6 = Class55.anInt479 + 5;
                            short var8 = 463;
                            byte var9 = 100;
                            byte var10 = 35;
                            if (Mouse.clickX >= var6 && Mouse.clickX <= var9 + var6 && Mouse.clickY >= var8 && Mouse.clickY <= var8 + var10) {
                                if (AsyncConnection.loadWorlds()) {
                                    Class55.loginWorldSelectorOpen = true;
                                    Class55.anInt460 = 0;
                                    Class55.anInt466 = 0;
                                }

                                return;
                            }
                        }

                        if (Statics1.aClass105_322 != null && AsyncConnection.loadWorlds()) {
                            Class55.loginWorldSelectorOpen = true;
                            Class55.anInt460 = 0;
                            Class55.anInt466 = 0;
                        }
                    }

                    var6 = Mouse.clickMeta;
                    int var18 = Mouse.clickX;
                    int var19 = Mouse.clickY;
                    if (var6 == 0) {
                        var18 = Mouse.x;
                        var19 = Mouse.y;
                    }

                    if (!Class27_Sub1.aBoolean492 && var6 == 4) {
                        var6 = 1;
                    }

                    int var11;
                    short var12;
                    if (Class55.loginState == 0) {
                        boolean var20 = false;

                        while (DynamicObject.method1114()) {
                            if (Class53.anInt457 == 84) {
                                var20 = true;
                            }
                        }

                        var11 = Class57.anInt481 - 80;
                        var12 = 291;
                        if (var6 == 1 && var18 >= var11 - 75 && var18 <= var11 + 75 && var19 >= var12 - 20 && var19 <= var12 + 20) {
                            Class174.method1006(Class104.method611("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                        }

                        var11 = Class57.anInt481 + 80;
                        if (var6 == 1 && var18 >= var11 - 75 && var18 <= var11 + 75 && var19 >= var12 - 20 && var19 <= var12 + 20 || var20) {
                            if ((client.currentWorldMask & 33554432) != 0) {
                                Class55.aString471 = "";
                                Class55.loginResponse1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                                Class55.loginResponse2 = "Your normal account will not be affected.";
                                Class55.loginResponse3 = "";
                                Class55.loginState = 1;
                                if (client.aBoolean958 && Class55.username != null && Class55.username.length() > 0) {
                                    Class55.anInt461 = 1;
                                } else {
                                    Class55.anInt461 = 0;
                                }
                            } else if ((client.currentWorldMask & 4) != 0) {
                                if ((client.currentWorldMask & 1024) != 0) {
                                    Class55.loginResponse1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                                    Class55.loginResponse2 = "Players can attack each other almost everywhere";
                                    Class55.loginResponse3 = "and the Protect Item prayer won't work.";
                                } else {
                                    Class55.loginResponse1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                                    Class55.loginResponse2 = "Players can attack each other";
                                    Class55.loginResponse3 = "almost everywhere.";
                                }

                                Class55.aString471 = "Warning!";
                                Class55.loginState = 1;
                                if (client.aBoolean958 && Class55.username != null && Class55.username.length() > 0) {
                                    Class55.anInt461 = 1;
                                } else {
                                    Class55.anInt461 = 0;
                                }
                            } else if ((client.currentWorldMask & 1024) != 0) {
                                Class55.loginResponse1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                                Class55.loginResponse2 = "The Protect Item prayer will";
                                Class55.loginResponse3 = "not work on this world.";
                                Class55.aString471 = "Warning!";
                                Class55.loginState = 1;
                                if (client.aBoolean958 && Class55.username != null && Class55.username.length() > 0) {
                                    Class55.anInt461 = 1;
                                } else {
                                    Class55.anInt461 = 0;
                                }
                            } else {
                                TilePaint.method1500(false);
                            }
                        }
                    } else {
                        int var21;
                        short var23;
                        if (Class55.loginState != 1) {
                            boolean var14;
                            int var15;
                            short var22;
                            if (Class55.loginState == 2) {
                                var22 = 201;
                                var21 = var22 + 52;
                                if (var6 == 1 && var19 >= var21 - 12 && var19 < var21 + 2) {
                                    Class55.anInt461 = 0;
                                }

                                var21 += 15;
                                if (var6 == 1 && var19 >= var21 - 12 && var19 < var21 + 2) {
                                    Class55.anInt461 = 1;
                                }

                                var21 += 15;
                                var22 = 361;
                                if (Class45.aClass215_418 != null) {
                                    var11 = Class45.aClass215_418.anInt1812 / 2;
                                    if (var6 == 1 && var18 >= Class45.aClass215_418.anInt1813 - var11 && var18 <= var11 + Class45.aClass215_418.anInt1813 && var19 >= var22 - 15 && var19 < var22) {
                                        switch (Class55.anInt469) {
                                            case 1:
                                                Enum_Sub6.setLoginMessages("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                                                Class55.loginState = 5;
                                                return;
                                            case 2:
                                                Class174.method1006("https://support.runescape.com/hc/en-gb", true, false);
                                        }
                                    }
                                }

                                var11 = Class57.anInt481 - 80;
                                var12 = 321;
                                if (var6 == 1 && var18 >= var11 - 75 && var18 <= var11 + 75 && var19 >= var12 - 20 && var19 <= var12 + 20) {
                                    Class55.username = Class55.username.trim();
                                    if (Class55.username.length() == 0) {
                                        Enum_Sub6.setLoginMessages("", "Please enter your username/email address.", "");
                                        return;
                                    }

                                    if (Class55.password.length() == 0) {
                                        Enum_Sub6.setLoginMessages("", "Please enter your password.", "");
                                        return;
                                    }

                                    Enum_Sub6.setLoginMessages("", "Connecting to server...", "");
                                    Enum_Sub6.method918(false);
                                    MouseRecorder.setGameState(20);
                                    return;
                                }

                                var11 = Class55.anInt474 + 180 + 80;
                                if (var6 == 1 && var18 >= var11 - 75 && var18 <= var11 + 75 && var19 >= var12 - 20 && var19 <= var12 + 20) {
                                    Class55.loginState = 0;
                                    Class55.username = "";
                                    Class55.password = "";
                                    RegionUpdateType.anInt1199 = 0;
                                    DefaultOperatingSystemProvider.aString1867 = "";
                                    Class55.aBoolean462 = true;
                                }

                                var11 = Class57.anInt481 + -117;
                                var12 = 277;
                                Class55.aBoolean477 = var18 >= var11 && var18 < var11 + Class61.anInt495 && var19 >= var12 && var19 < var12 + Class23.anInt296;
                                if (var6 == 1 && Class55.aBoolean477) {
                                    client.aBoolean958 = !client.aBoolean958;
                                    if (!client.aBoolean958 && client.preferences.aString362 != null) {
                                        client.preferences.aString362 = null;
                                        Class149.method854();
                                    }
                                }

                                var11 = Class57.anInt481 + 24;
                                var12 = 277;
                                Class55.aBoolean472 = var18 >= var11 && var18 < var11 + Class61.anInt495 && var19 >= var12 && var19 < var12 + Class23.anInt296;
                                if (var6 == 1 && Class55.aBoolean472) {
                                    client.preferences.rememberMe = !client.preferences.rememberMe;
                                    if (!client.preferences.rememberMe) {
                                        Class55.username = "";
                                        client.preferences.aString362 = null;
                                        if (client.aBoolean958 && Class55.username != null && Class55.username.length() > 0) {
                                            Class55.anInt461 = 1;
                                        } else {
                                            Class55.anInt461 = 0;
                                        }
                                    }

                                    Class149.method854();
                                }

                                while (true) {
                                    while (DynamicObject.method1114()) {
                                        var14 = false;

                                        for (var15 = 0; var15 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var15) {
                                            if (Keyboard.aChar151 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var15)) {
                                                var14 = true;
                                                break;
                                            }
                                        }

                                        if (Class53.anInt457 == 13) {
                                            Class55.loginState = 0;
                                            Class55.username = "";
                                            Class55.password = "";
                                            RegionUpdateType.anInt1199 = 0;
                                            DefaultOperatingSystemProvider.aString1867 = "";
                                            Class55.aBoolean462 = true;
                                        } else if (Class55.anInt461 == 0) {
                                            if (Class53.anInt457 == 85 && Class55.username.length() > 0) {
                                                Class55.username = Class55.username.substring(0, Class55.username.length() - 1);
                                            }

                                            if (Class53.anInt457 == 84 || Class53.anInt457 == 80) {
                                                Class55.anInt461 = 1;
                                            }

                                            if (var14 && Class55.username.length() < 320) {
                                                Class55.username = Class55.username + Keyboard.aChar151;
                                            }
                                        } else if (Class55.anInt461 == 1) {
                                            if (Class53.anInt457 == 85 && Class55.password.length() > 0) {
                                                Class55.password = Class55.password.substring(0, Class55.password.length() - 1);
                                            }

                                            if (Class53.anInt457 == 84 || Class53.anInt457 == 80) {
                                                Class55.anInt461 = 0;
                                            }

                                            if (Class53.anInt457 == 84) {
                                                Class55.username = Class55.username.trim();
                                                if (Class55.username.length() == 0) {
                                                    Enum_Sub6.setLoginMessages("", "Please enter your username/email address.", "");
                                                    return;
                                                }

                                                if (Class55.password.length() == 0) {
                                                    Enum_Sub6.setLoginMessages("", "Please enter your password.", "");
                                                    return;
                                                }

                                                Enum_Sub6.setLoginMessages("", "Connecting to server...", "");
                                                Enum_Sub6.method918(false);
                                                MouseRecorder.setGameState(20);
                                                return;
                                            }

                                            if (var14 && Class55.password.length() < 20) {
                                                Class55.password = Class55.password + Keyboard.aChar151;
                                            }
                                        }
                                    }

                                    return;
                                }
                            }
                            if (Class55.loginState == 3) {
                                var21 = Class55.anInt474 + 180;
                                var23 = 276;
                                if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                    TilePaint.method1500(false);
                                }

                                var21 = Class55.anInt474 + 180;
                                var23 = 326;
                                if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                    Enum_Sub6.setLoginMessages("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                                    Class55.loginState = 5;
                                }
                            } else {
                                int var25;
                                if (Class55.loginState == 4) {
                                    var21 = Class55.anInt474 + 180 - 80;
                                    var23 = 321;
                                    if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                        DefaultOperatingSystemProvider.aString1867.trim();
                                        if (DefaultOperatingSystemProvider.aString1867.length() != 6) {
                                            Enum_Sub6.setLoginMessages("", "Please enter a 6-digit PIN.", "");
                                            return;
                                        }

                                        RegionUpdateType.anInt1199 = Integer.parseInt(DefaultOperatingSystemProvider.aString1867);
                                        DefaultOperatingSystemProvider.aString1867 = "";
                                        Enum_Sub6.method918(true);
                                        Enum_Sub6.setLoginMessages("", "Connecting to server...", "");
                                        MouseRecorder.setGameState(20);
                                        return;
                                    }

                                    if (var6 == 1 && var18 >= Class55.anInt474 + 180 - 9 && var18 <= Class55.anInt474 + 180 + 130 && var19 >= 263 && var19 <= 296) {
                                        Class55.aBoolean462 = !Class55.aBoolean462;
                                    }

                                    if (var6 == 1 && var18 >= Class55.anInt474 + 180 - 34 && var18 <= Class55.anInt474 + 34 + 180 && var19 >= 351 && var19 <= 363) {
                                        Class174.method1006(Class104.method611("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                                    }

                                    var21 = Class55.anInt474 + 180 + 80;
                                    if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                        Class55.loginState = 0;
                                        Class55.username = "";
                                        Class55.password = "";
                                        RegionUpdateType.anInt1199 = 0;
                                        DefaultOperatingSystemProvider.aString1867 = "";
                                    }

                                    while (DynamicObject.method1114()) {
                                        boolean var24 = false;

                                        for (var25 = 0; var25 < "1234567890".length(); ++var25) {
                                            if (Keyboard.aChar151 == "1234567890".charAt(var25)) {
                                                var24 = true;
                                                break;
                                            }
                                        }

                                        if (Class53.anInt457 == 13) {
                                            Class55.loginState = 0;
                                            Class55.username = "";
                                            Class55.password = "";
                                            RegionUpdateType.anInt1199 = 0;
                                            DefaultOperatingSystemProvider.aString1867 = "";
                                        } else {
                                            if (Class53.anInt457 == 85 && DefaultOperatingSystemProvider.aString1867.length() > 0) {
                                                DefaultOperatingSystemProvider.aString1867 = DefaultOperatingSystemProvider.aString1867.substring(0, DefaultOperatingSystemProvider.aString1867.length() - 1);
                                            }

                                            if (Class53.anInt457 == 84) {
                                                DefaultOperatingSystemProvider.aString1867.trim();
                                                if (DefaultOperatingSystemProvider.aString1867.length() != 6) {
                                                    Enum_Sub6.setLoginMessages("", "Please enter a 6-digit PIN.", "");
                                                    return;
                                                }

                                                RegionUpdateType.anInt1199 = Integer.parseInt(DefaultOperatingSystemProvider.aString1867);
                                                DefaultOperatingSystemProvider.aString1867 = "";
                                                Enum_Sub6.method918(true);
                                                Enum_Sub6.setLoginMessages("", "Connecting to server...", "");
                                                MouseRecorder.setGameState(20);
                                                return;
                                            }

                                            if (var24 && DefaultOperatingSystemProvider.aString1867.length() < 6) {
                                                DefaultOperatingSystemProvider.aString1867 = DefaultOperatingSystemProvider.aString1867 + Keyboard.aChar151;
                                            }
                                        }
                                    }
                                } else if (Class55.loginState == 5) {
                                    var21 = Class55.anInt474 + 180 - 80;
                                    var23 = 321;
                                    if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                        Class74.method411();
                                        return;
                                    }

                                    var21 = Class55.anInt474 + 180 + 80;
                                    if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                        TilePaint.method1500(true);
                                    }

                                    var12 = 361;
                                    if (Statics6.aClass215_846 != null) {
                                        var25 = Statics6.aClass215_846.anInt1812 / 2;
                                        if (var6 == 1 && var18 >= Statics6.aClass215_846.anInt1813 - var25 && var18 <= var25 + Statics6.aClass215_846.anInt1813 && var19 >= var12 - 15 && var19 < var12) {
                                            Class174.method1006(Class104.method611("secure", true) + "m=weblogin/g=oldscape/cant_log_in", true, false);
                                        }
                                    }

                                    while (DynamicObject.method1114()) {
                                        var14 = false;

                                        for (var15 = 0; var15 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var15) {
                                            if (Keyboard.aChar151 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var15)) {
                                                var14 = true;
                                                break;
                                            }
                                        }

                                        if (Class53.anInt457 == 13) {
                                            TilePaint.method1500(true);
                                        } else {
                                            if (Class53.anInt457 == 85 && Class55.username.length() > 0) {
                                                Class55.username = Class55.username.substring(0, Class55.username.length() - 1);
                                            }

                                            if (Class53.anInt457 == 84) {
                                                Class74.method411();
                                                return;
                                            }

                                            if (var14 && Class55.username.length() < 320) {
                                                Class55.username = Class55.username + Keyboard.aChar151;
                                            }
                                        }
                                    }
                                } else if (Class55.loginState == 6) {
                                    while (true) {
                                        do {
                                            if (!DynamicObject.method1114()) {
                                                var22 = 321;
                                                if (var6 == 1 && var19 >= var22 - 20 && var19 <= var22 + 20) {
                                                    TilePaint.method1500(true);
                                                }

                                                return;
                                            }
                                        } while (Class53.anInt457 != 84 && Class53.anInt457 != 13);

                                        TilePaint.method1500(true);
                                    }
                                } else if (Class55.loginState == 7) {
                                    var21 = Class55.anInt474 + 180 - 80;
                                    var23 = 321;
                                    if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                        Class174.method1006(Class104.method611("secure", true) + "m=dob/set_dob.ws", true, false);
                                        Enum_Sub6.setLoginMessages("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                                        Class55.loginState = 6;
                                        return;
                                    }

                                    var21 = Class55.anInt474 + 180 + 80;
                                    if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                        TilePaint.method1500(true);
                                    }
                                } else if (Class55.loginState == 8) {
                                    var21 = Class55.anInt474 + 180 - 80;
                                    var23 = 321;
                                    if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                        Class174.method1006("https://www.jagex.com/terms/privacy/#eight", true, false);
                                        Enum_Sub6.setLoginMessages("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                                        Class55.loginState = 6;
                                        return;
                                    }

                                    var21 = Class55.anInt474 + 180 + 80;
                                    if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                        TilePaint.method1500(true);
                                    }
                                } else if (Class55.loginState == 12) {
                                    String var16 = "";
                                    switch (Class55.anInt468) {
                                        case 0:
                                            var16 = "https://support.runescape.com/hc/en-gb/articles/115002238729-Account-Bans";
                                            break;
                                        case 1:
                                            var16 = "https://support.runescape.com/hc/en-gb/articles/206103939-My-account-is-locked";
                                            break;
                                        default:
                                            TilePaint.method1500(false);
                                    }

                                    var11 = Class55.anInt474 + 180;
                                    var12 = 276;
                                    if (var6 == 1 && var18 >= var11 - 75 && var18 <= var11 + 75 && var19 >= var12 - 20 && var19 <= var12 + 20) {
                                        Class174.method1006(var16, true, false);
                                        Enum_Sub6.setLoginMessages("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                                        Class55.loginState = 6;
                                        return;
                                    }

                                    var11 = Class55.anInt474 + 180;
                                    var12 = 326;
                                    if (var6 == 1 && var18 >= var11 - 75 && var18 <= var11 + 75 && var19 >= var12 - 20 && var19 <= var12 + 20) {
                                        TilePaint.method1500(false);
                                    }
                                } else if (Class55.loginState == 24) {
                                    var21 = Class55.anInt474 + 180;
                                    var23 = 301;
                                    if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                        TilePaint.method1500(false);
                                    }
                                }
                            }
                        } else {
                            while (DynamicObject.method1114()) {
                                if (Class53.anInt457 == 84) {
                                    TilePaint.method1500(false);
                                } else if (Class53.anInt457 == 13) {
                                    Class55.loginState = 0;
                                }
                            }

                            var21 = Class57.anInt481 - 80;
                            var23 = 321;
                            if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                TilePaint.method1500(false);
                            }

                            var21 = Class57.anInt481 + 80;
                            if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                Class55.loginState = 0;
                            }
                        }
                    }

                }
            }
        }
    }

    static RuneScript method1499(int var0) {
        RuneScript var1 = (RuneScript) RuneScript.aReferenceCache1647.get((long) var0);
        if (var1 != null) {
            return var1;
        }
        byte[] var2 = Class38.aCacheReferenceTable348.unpack(var0, 0);
        if (var2 == null) {
            return null;
        }
        var1 = Class85.method455(var2);
        RuneScript.aReferenceCache1647.put(var1, (long) var0);
        return var1;
    }

    static void method1497(PlayerEntity var0, int var1, int var2) {
        if (var0.animation == var1 && var1 != -1) {
            int var3 = Class57.getAnimationSequence(var1).replayMode;
            if (var3 == 1) {
                var0.animationFrame = 0;
                var0.animationFrameCycle = 0;
                var0.animationDelay = var2;
                var0.anInt2010 = 0;
            }

            if (var3 == 2) {
                var0.anInt2010 = 0;
            }
        } else if (var1 == -1 || var0.animation == -1 || Class57.getAnimationSequence(var1).priority >= Class57.getAnimationSequence(var0.animation).priority) {
            var0.animation = var1;
            var0.animationFrame = 0;
            var0.animationFrameCycle = 0;
            var0.animationDelay = var2;
            var0.anInt2010 = 0;
            var0.anInt2023 = var0.pathQueueSize;
        }

    }
}
