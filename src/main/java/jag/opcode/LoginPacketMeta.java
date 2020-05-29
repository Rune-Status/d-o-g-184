package jag.opcode;

import jag.*;
import jag.commons.input.Keyboard;
import jag.commons.input.Mouse;
import jag.game.GameEngine;
import jag.game.HealthBar;
import jag.game.World;
import jag.game.client;
import jag.game.relationship.Class114;
import jag.game.scene.entity.DynamicObject;
import jag.game.scene.entity.PlayerEntity;
import jag.game.stockmarket.Class46;
import jag.game.stockmarket.StockMarketOfferLifetimeComparator;
import jag.game.stockmarket.StockMarketOfferPriceComparator;
import jag.game.stockmarket.StockMarketOfferWorldComparator;
import jag.game.type.AnimationSequence;
import jag.js5.CacheRequestWorker;
import jag.script.RuneScript;
import jag.statics.Statics1;
import jag.statics.Statics15;
import jag.statics.Statics51;
import jag.worldmap.*;

public class LoginPacketMeta implements OutgoingPacketProtocol {

    public static final LoginPacketMeta aLoginPacketMeta1998;
    public static final LoginPacketMeta aLoginPacketMeta1997;
    public static final LoginPacketMeta aLoginPacketMeta1996;
    public static final LoginPacketMeta aLoginPacketMeta1999;
    public static final LoginPacketMeta aLoginPacketMeta1995;
    public static final LoginPacketMeta[] aLoginPacketMetaArray1994;
    public static OldConnectionTask aOldConnectionTask_1992;
    public static Bounds aBounds_846;

    static {
        aLoginPacketMeta1998 = new LoginPacketMeta(14);
        aLoginPacketMeta1999 = new LoginPacketMeta(15);
        aLoginPacketMeta1997 = new LoginPacketMeta(16);
        aLoginPacketMeta1996 = new LoginPacketMeta(18);
        aLoginPacketMeta1995 = new LoginPacketMeta(27);
        aLoginPacketMetaArray1994 = new LoginPacketMeta[32];
        LoginPacketMeta[] var0 = values();

        for (LoginPacketMeta aVar0 : var0) {
            aLoginPacketMetaArray1994[aVar0.anInt1993] = aVar0;
        }

    }

    public final int anInt1993;

    LoginPacketMeta(int var1) {
        this.anInt1993 = var1;
    }

    public static LoginPacketMeta[] values() {
        return new LoginPacketMeta[]{LoginPacketMeta.aLoginPacketMeta1997, LoginPacketMeta.aLoginPacketMeta1999, LoginPacketMeta.aLoginPacketMeta1995, LoginPacketMeta.aLoginPacketMeta1996, LoginPacketMeta.aLoginPacketMeta1998};
    }

    public static void processLoginScreen() {
        int var6;
        if (Login.worldSelectorOpen) {
            while (true) {
                if (!DynamicObject.method1114()) {
                    if (Mouse.clickMeta != 1 && (WorldMapIcon_Sub1.aBoolean492 || Mouse.clickMeta != 4)) {
                        break;
                    }

                    int var1 = Login.anInt479 + 280;
                    if (Mouse.clickX >= var1 && Mouse.clickX <= var1 + 14 && Mouse.clickY >= 4 && Mouse.clickY <= 18) {
                        World.method852(0, 0);
                        break;
                    }

                    if (Mouse.clickX >= var1 + 15 && Mouse.clickX <= var1 + 80 && Mouse.clickY >= 4 && Mouse.clickY <= 18) {
                        World.method852(0, 1);
                        break;
                    }

                    int var2 = Login.anInt479 + 390;
                    if (Mouse.clickX >= var2 && Mouse.clickX <= var2 + 14 && Mouse.clickY >= 4 && Mouse.clickY <= 18) {
                        World.method852(1, 0);
                        break;
                    }

                    if (Mouse.clickX >= var2 + 15 && Mouse.clickX <= var2 + 80 && Mouse.clickY >= 4 && Mouse.clickY <= 18) {
                        World.method852(1, 1);
                        break;
                    }

                    int var17 = Login.anInt479 + 500;
                    if (Mouse.clickX >= var17 && Mouse.clickX <= var17 + 14 && Mouse.clickY >= 4 && Mouse.clickY <= 18) {
                        World.method852(2, 0);
                        break;
                    }

                    if (Mouse.clickX >= var17 + 15 && Mouse.clickX <= var17 + 80 && Mouse.clickY >= 4 && Mouse.clickY <= 18) {
                        World.method852(2, 1);
                        break;
                    }

                    var6 = Login.anInt479 + 610;
                    if (Mouse.clickX >= var6 && Mouse.clickX <= var6 + 14 && Mouse.clickY >= 4 && Mouse.clickY <= 18) {
                        World.method852(3, 0);
                        break;
                    }

                    if (Mouse.clickX >= var6 + 15 && Mouse.clickX <= var6 + 80 && Mouse.clickY >= 4 && Mouse.clickY <= 18) {
                        World.method852(3, 1);
                        break;
                    }

                    if (Mouse.clickX >= Login.anInt479 + 708 && Mouse.clickY >= 4 && Mouse.clickX <= Login.anInt479 + 708 + 50 && Mouse.clickY <= 20) {
                        Class69.method1402();
                        break;
                    }

                    if (Login.anInt463 != -1) {
                        World var7 = World.worlds[Login.anInt463];
                        SerializableString.setWorld(var7);
                        Class69.method1402();
                    } else {
                        if (Login.anInt460 > 0 && WorldMapIcon_Sub2.aDoublyNode_Sub24_Sub4_650 != null && Mouse.clickX >= 0 && Mouse.clickX <= WorldMapIcon_Sub2.aDoublyNode_Sub24_Sub4_650.anInt378 && Mouse.clickY >= client.canvasHeight / 2 - 50 && Mouse.clickY <= client.canvasHeight / 2 + 50) {
                            --Login.anInt460;
                        }

                        if (Login.anInt460 < Login.anInt466 && HealthBar.aDoublyNode_Sub24_Sub4_848 != null && Mouse.clickX >= client.canvasWidth - HealthBar.aDoublyNode_Sub24_Sub4_848.anInt378 - 5 && Mouse.clickX <= client.canvasWidth && Mouse.clickY >= client.canvasHeight / 2 - 50 && Mouse.clickY <= client.canvasHeight / 2 + 50) {
                            ++Login.anInt460;
                        }
                    }
                    break;
                }

                if (SecureRandomService.anInt457 == 13) {
                    Class69.method1402();
                    break;
                }

                if (SecureRandomService.anInt457 == 96) {
                    if (Login.anInt460 > 0 && WorldMapIcon_Sub2.aDoublyNode_Sub24_Sub4_650 != null) {
                        --Login.anInt460;
                    }
                } else if (SecureRandomService.anInt457 == 97 && Login.anInt460 < Login.anInt466 && HealthBar.aDoublyNode_Sub24_Sub4_848 != null) {
                    ++Login.anInt460;
                }
            }

        } else {
            if ((Mouse.clickMeta == 1 || !WorldMapIcon_Sub1.aBoolean492 && Mouse.clickMeta == 4) && Mouse.clickX >= Login.anInt479 + 765 - 50 && Mouse.clickY >= 453) {
                client.preferences.loginScreenAudioDisabled = !client.preferences.loginScreenAudioDisabled;
                ClientLocale.method854();
                if (!client.preferences.loginScreenAudioDisabled) {
                    Class114.method674(Statics15.aArchive1234, "scape main", "", 255, false);
                } else {
                    Vertex.method533();
                }
            }

            if (client.gameState != 5) {
                if (Login.aLong467 == -1L) {
                    Login.aLong467 = GameEngine.currentTime() + 1000L;
                }

                long var4 = GameEngine.currentTime();
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

                if (var3 && Login.aLong465 == -1L) {
                    Login.aLong465 = var4;
                    if (Login.aLong465 > Login.aLong467) {
                        Login.aLong467 = Login.aLong465;
                    }
                }

                if (client.gameState == 10 || client.gameState == 11) {
                    if (WorldMapLabelSize.aClientLocale_525 == ClientLocale.GB) {
                        if (Mouse.clickMeta == 1 || !WorldMapIcon_Sub1.aBoolean492 && Mouse.clickMeta == 4) {
                            var6 = Login.anInt479 + 5;
                            short var8 = 463;
                            byte var9 = 100;
                            byte var10 = 35;
                            if (Mouse.clickX >= var6 && Mouse.clickX <= var9 + var6 && Mouse.clickY >= var8 && Mouse.clickY <= var8 + var10) {
                                if (AsyncConnection.loadWorlds()) {
                                    Login.worldSelectorOpen = true;
                                    Login.anInt460 = 0;
                                    Login.anInt466 = 0;
                                }

                                return;
                            }
                        }

                        if (Statics1.aURLRequest_322 != null && AsyncConnection.loadWorlds()) {
                            Login.worldSelectorOpen = true;
                            Login.anInt460 = 0;
                            Login.anInt466 = 0;
                        }
                    }

                    var6 = Mouse.clickMeta;
                    int var18 = Mouse.clickX;
                    int var19 = Mouse.clickY;
                    if (var6 == 0) {
                        var18 = Mouse.x;
                        var19 = Mouse.y;
                    }

                    if (!WorldMapIcon_Sub1.aBoolean492 && var6 == 4) {
                        var6 = 1;
                    }

                    int var11;
                    short var12;
                    if (Login.step == 0) {
                        boolean var20 = false;

                        while (DynamicObject.method1114()) {
                            if (SecureRandomService.anInt457 == 84) {
                                var20 = true;
                            }
                        }

                        var11 = StockMarketOfferPriceComparator.anInt481 - 80;
                        var12 = 291;
                        if (var6 == 1 && var18 >= var11 - 75 && var18 <= var11 + 75 && var19 >= var12 - 20 && var19 <= var12 + 20) {
                            CacheRequestWorker.method1006(GameEngine.method611("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                        }

                        var11 = StockMarketOfferPriceComparator.anInt481 + 80;
                        if (var6 == 1 && var18 >= var11 - 75 && var18 <= var11 + 75 && var19 >= var12 - 20 && var19 <= var12 + 20 || var20) {
                            if ((client.currentWorldMask & 33554432) != 0) {
                                Login.aString471 = "";
                                Login.loginResponse1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                                Login.loginResponse2 = "Your normal account will not be affected.";
                                Login.loginResponse3 = "";
                                Login.step = 1;
                                if (client.aBoolean958 && Login.username != null && Login.username.length() > 0) {
                                    Login.anInt461 = 1;
                                } else {
                                    Login.anInt461 = 0;
                                }
                            } else if ((client.currentWorldMask & 4) != 0) {
                                if ((client.currentWorldMask & 1024) != 0) {
                                    Login.loginResponse1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                                    Login.loginResponse2 = "Players can attack each other almost everywhere";
                                    Login.loginResponse3 = "and the Protect Item prayer won't work.";
                                } else {
                                    Login.loginResponse1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                                    Login.loginResponse2 = "Players can attack each other";
                                    Login.loginResponse3 = "almost everywhere.";
                                }

                                Login.aString471 = "Warning!";
                                Login.step = 1;
                                if (client.aBoolean958 && Login.username != null && Login.username.length() > 0) {
                                    Login.anInt461 = 1;
                                } else {
                                    Login.anInt461 = 0;
                                }
                            } else if ((client.currentWorldMask & 1024) != 0) {
                                Login.loginResponse1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                                Login.loginResponse2 = "The Protect Item prayer will";
                                Login.loginResponse3 = "not work on this world.";
                                Login.aString471 = "Warning!";
                                Login.step = 1;
                                if (client.aBoolean958 && Login.username != null && Login.username.length() > 0) {
                                    Login.anInt461 = 1;
                                } else {
                                    Login.anInt461 = 0;
                                }
                            } else {
                                Login.method1500(false);
                            }
                        }
                    } else {
                        int var21;
                        short var23;
                        if (Login.step != 1) {
                            boolean var14;
                            int var15;
                            short var22;
                            if (Login.step == 2) {
                                var22 = 201;
                                var21 = var22 + 52;
                                if (var6 == 1 && var19 >= var21 - 12 && var19 < var21 + 2) {
                                    Login.anInt461 = 0;
                                }

                                var21 += 15;
                                if (var6 == 1 && var19 >= var21 - 12 && var19 < var21 + 2) {
                                    Login.anInt461 = 1;
                                }

                                var22 = 361;
                                if (LoginScreenEffect.aBounds_418 != null) {
                                    var11 = LoginScreenEffect.aBounds_418.anInt1812 / 2;
                                    if (var6 == 1 && var18 >= LoginScreenEffect.aBounds_418.anInt1813 - var11 && var18 <= var11 + LoginScreenEffect.aBounds_418.anInt1813 && var19 >= var22 - 15 && var19 < var22) {
                                        switch (Login.anInt469) {
                                            case 1:
                                                PlayerAccountType.setLoginMessages("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                                                Login.step = 5;
                                                return;
                                            case 2:
                                                CacheRequestWorker.method1006("https://support.runescape.com/hc/en-gb", true, false);
                                        }
                                    }
                                }

                                var11 = StockMarketOfferPriceComparator.anInt481 - 80;
                                var12 = 321;
                                if (var6 == 1 && var18 >= var11 - 75 && var18 <= var11 + 75 && var19 >= var12 - 20 && var19 <= var12 + 20) {
                                    Login.username = Login.username.trim();
                                    if (Login.username.length() == 0) {
                                        PlayerAccountType.setLoginMessages("", "Please enter your username/email address.", "");
                                        return;
                                    }

                                    if (Login.password.length() == 0) {
                                        PlayerAccountType.setLoginMessages("", "Please enter your password.", "");
                                        return;
                                    }

                                    PlayerAccountType.setLoginMessages("", "Connecting to server...", "");
                                    PlayerAccountType.method918(false);
                                    client.setGameState(20);
                                    return;
                                }

                                var11 = Login.anInt474 + 180 + 80;
                                if (var6 == 1 && var18 >= var11 - 75 && var18 <= var11 + 75 && var19 >= var12 - 20 && var19 <= var12 + 20) {
                                    Login.step = 0;
                                    Login.username = "";
                                    Login.password = "";
                                    RegionUpdateType.anInt1199 = 0;
                                    Login.totp = "";
                                    Login.aBoolean462 = true;
                                }

                                var11 = StockMarketOfferPriceComparator.anInt481 + -117;
                                var12 = 277;
                                Login.aBoolean477 = var18 >= var11 && var18 < var11 + Statics51.anInt495 && var19 >= var12 && var19 < var12 + WorldMapCacheFeature.anInt296;
                                if (var6 == 1 && Login.aBoolean477) {
                                    client.aBoolean958 = !client.aBoolean958;
                                    if (!client.aBoolean958 && client.preferences.aString362 != null) {
                                        client.preferences.aString362 = null;
                                        ClientLocale.method854();
                                    }
                                }

                                var11 = StockMarketOfferPriceComparator.anInt481 + 24;
                                var12 = 277;
                                Login.aBoolean472 = var18 >= var11 && var18 < var11 + Statics51.anInt495 && var19 >= var12 && var19 < var12 + WorldMapCacheFeature.anInt296;
                                if (var6 == 1 && Login.aBoolean472) {
                                    client.preferences.rememberMe = !client.preferences.rememberMe;
                                    if (!client.preferences.rememberMe) {
                                        Login.username = "";
                                        client.preferences.aString362 = null;
                                        if (client.aBoolean958 && Login.username != null && Login.username.length() > 0) {
                                            Login.anInt461 = 1;
                                        } else {
                                            Login.anInt461 = 0;
                                        }
                                    }

                                    ClientLocale.method854();
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

                                        if (SecureRandomService.anInt457 == 13) {
                                            Login.step = 0;
                                            Login.username = "";
                                            Login.password = "";
                                            RegionUpdateType.anInt1199 = 0;
                                            Login.totp = "";
                                            Login.aBoolean462 = true;
                                        } else if (Login.anInt461 == 0) {
                                            if (SecureRandomService.anInt457 == 85 && Login.username.length() > 0) {
                                                Login.username = Login.username.substring(0, Login.username.length() - 1);
                                            }

                                            if (SecureRandomService.anInt457 == 84 || SecureRandomService.anInt457 == 80) {
                                                Login.anInt461 = 1;
                                            }

                                            if (var14 && Login.username.length() < 320) {
                                                Login.username = Login.username + Keyboard.aChar151;
                                            }
                                        } else if (Login.anInt461 == 1) {
                                            if (SecureRandomService.anInt457 == 85 && Login.password.length() > 0) {
                                                Login.password = Login.password.substring(0, Login.password.length() - 1);
                                            }

                                            if (SecureRandomService.anInt457 == 84 || SecureRandomService.anInt457 == 80) {
                                                Login.anInt461 = 0;
                                            }

                                            if (SecureRandomService.anInt457 == 84) {
                                                Login.username = Login.username.trim();
                                                if (Login.username.length() == 0) {
                                                    PlayerAccountType.setLoginMessages("", "Please enter your username/email address.", "");
                                                    return;
                                                }

                                                if (Login.password.length() == 0) {
                                                    PlayerAccountType.setLoginMessages("", "Please enter your password.", "");
                                                    return;
                                                }

                                                PlayerAccountType.setLoginMessages("", "Connecting to server...", "");
                                                PlayerAccountType.method918(false);
                                                client.setGameState(20);
                                                return;
                                            }

                                            if (var14 && Login.password.length() < 20) {
                                                Login.password = Login.password + Keyboard.aChar151;
                                            }
                                        }
                                    }

                                    return;
                                }
                            }
                            if (Login.step == 3) {
                                var21 = Login.anInt474 + 180;
                                var23 = 276;
                                if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                    Login.method1500(false);
                                }

                                var21 = Login.anInt474 + 180;
                                var23 = 326;
                                if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                    PlayerAccountType.setLoginMessages("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                                    Login.step = 5;
                                }
                            } else {
                                int var25;
                                if (Login.step == 4) {
                                    var21 = Login.anInt474 + 180 - 80;
                                    var23 = 321;
                                    if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                        Login.totp.trim();
                                        if (Login.totp.length() != 6) {
                                            PlayerAccountType.setLoginMessages("", "Please enter a 6-digit PIN.", "");
                                            return;
                                        }

                                        RegionUpdateType.anInt1199 = Integer.parseInt(Login.totp);
                                        Login.totp = "";
                                        PlayerAccountType.method918(true);
                                        PlayerAccountType.setLoginMessages("", "Connecting to server...", "");
                                        client.setGameState(20);
                                        return;
                                    }

                                    if (var6 == 1 && var18 >= Login.anInt474 + 180 - 9 && var18 <= Login.anInt474 + 180 + 130 && var19 >= 263 && var19 <= 296) {
                                        Login.aBoolean462 = !Login.aBoolean462;
                                    }

                                    if (var6 == 1 && var18 >= Login.anInt474 + 180 - 34 && var18 <= Login.anInt474 + 34 + 180 && var19 >= 351 && var19 <= 363) {
                                        CacheRequestWorker.method1006(GameEngine.method611("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                                    }

                                    var21 = Login.anInt474 + 180 + 80;
                                    if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                        Login.step = 0;
                                        Login.username = "";
                                        Login.password = "";
                                        RegionUpdateType.anInt1199 = 0;
                                        Login.totp = "";
                                    }

                                    while (DynamicObject.method1114()) {
                                        boolean var24 = false;

                                        for (var25 = 0; var25 < "1234567890".length(); ++var25) {
                                            if (Keyboard.aChar151 == "1234567890".charAt(var25)) {
                                                var24 = true;
                                                break;
                                            }
                                        }

                                        if (SecureRandomService.anInt457 == 13) {
                                            Login.step = 0;
                                            Login.username = "";
                                            Login.password = "";
                                            RegionUpdateType.anInt1199 = 0;
                                            Login.totp = "";
                                        } else {
                                            if (SecureRandomService.anInt457 == 85 && Login.totp.length() > 0) {
                                                Login.totp = Login.totp.substring(0, Login.totp.length() - 1);
                                            }

                                            if (SecureRandomService.anInt457 == 84) {
                                                Login.totp.trim();
                                                if (Login.totp.length() != 6) {
                                                    PlayerAccountType.setLoginMessages("", "Please enter a 6-digit PIN.", "");
                                                    return;
                                                }

                                                RegionUpdateType.anInt1199 = Integer.parseInt(Login.totp);
                                                Login.totp = "";
                                                PlayerAccountType.method918(true);
                                                PlayerAccountType.setLoginMessages("", "Connecting to server...", "");
                                                client.setGameState(20);
                                                return;
                                            }

                                            if (var24 && Login.totp.length() < 6) {
                                                Login.totp = Login.totp + Keyboard.aChar151;
                                            }
                                        }
                                    }
                                } else if (Login.step == 5) {
                                    var21 = Login.anInt474 + 180 - 80;
                                    var23 = 321;
                                    if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                        StockMarketOfferLifetimeComparator.method411();
                                        return;
                                    }

                                    var21 = Login.anInt474 + 180 + 80;
                                    if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                        Login.method1500(true);
                                    }

                                    var12 = 361;
                                    if (aBounds_846 != null) {
                                        var25 = aBounds_846.anInt1812 / 2;
                                        if (var6 == 1 && var18 >= aBounds_846.anInt1813 - var25 && var18 <= var25 + aBounds_846.anInt1813 && var19 >= var12 - 15 && var19 < var12) {
                                            CacheRequestWorker.method1006(GameEngine.method611("secure", true) + "m=weblogin/g=oldscape/cant_log_in", true, false);
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

                                        if (SecureRandomService.anInt457 == 13) {
                                            Login.method1500(true);
                                        } else {
                                            if (SecureRandomService.anInt457 == 85 && Login.username.length() > 0) {
                                                Login.username = Login.username.substring(0, Login.username.length() - 1);
                                            }

                                            if (SecureRandomService.anInt457 == 84) {
                                                StockMarketOfferLifetimeComparator.method411();
                                                return;
                                            }

                                            if (var14 && Login.username.length() < 320) {
                                                Login.username = Login.username + Keyboard.aChar151;
                                            }
                                        }
                                    }
                                } else if (Login.step == 6) {
                                    while (true) {
                                        do {
                                            if (!DynamicObject.method1114()) {
                                                var22 = 321;
                                                if (var6 == 1 && var19 >= var22 - 20 && var19 <= var22 + 20) {
                                                    Login.method1500(true);
                                                }

                                                return;
                                            }
                                        } while (SecureRandomService.anInt457 != 84 && SecureRandomService.anInt457 != 13);

                                        Login.method1500(true);
                                    }
                                } else if (Login.step == 7) {
                                    var21 = Login.anInt474 + 180 - 80;
                                    var23 = 321;
                                    if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                        CacheRequestWorker.method1006(GameEngine.method611("secure", true) + "m=dob/set_dob.ws", true, false);
                                        PlayerAccountType.setLoginMessages("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                                        Login.step = 6;
                                        return;
                                    }

                                    var21 = Login.anInt474 + 180 + 80;
                                    if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                        Login.method1500(true);
                                    }
                                } else if (Login.step == 8) {
                                    var21 = Login.anInt474 + 180 - 80;
                                    var23 = 321;
                                    if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                        CacheRequestWorker.method1006("https://www.jagex.com/terms/privacy/#eight", true, false);
                                        PlayerAccountType.setLoginMessages("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                                        Login.step = 6;
                                        return;
                                    }

                                    var21 = Login.anInt474 + 180 + 80;
                                    if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                        Login.method1500(true);
                                    }
                                } else if (Login.step == 12) {
                                    String var16 = "";
                                    switch (Login.anInt468) {
                                        case 0:
                                            var16 = "https://support.runescape.com/hc/en-gb/articles/115002238729-Account-Bans";
                                            break;
                                        case 1:
                                            var16 = "https://support.runescape.com/hc/en-gb/articles/206103939-My-account-is-locked";
                                            break;
                                        default:
                                            Login.method1500(false);
                                    }

                                    var11 = Login.anInt474 + 180;
                                    var12 = 276;
                                    if (var6 == 1 && var18 >= var11 - 75 && var18 <= var11 + 75 && var19 >= var12 - 20 && var19 <= var12 + 20) {
                                        CacheRequestWorker.method1006(var16, true, false);
                                        PlayerAccountType.setLoginMessages("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                                        Login.step = 6;
                                        return;
                                    }

                                    var11 = Login.anInt474 + 180;
                                    var12 = 326;
                                    if (var6 == 1 && var18 >= var11 - 75 && var18 <= var11 + 75 && var19 >= var12 - 20 && var19 <= var12 + 20) {
                                        Login.method1500(false);
                                    }
                                } else if (Login.step == 24) {
                                    var21 = Login.anInt474 + 180;
                                    var23 = 301;
                                    if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                        Login.method1500(false);
                                    }
                                }
                            }
                        } else {
                            while (DynamicObject.method1114()) {
                                if (SecureRandomService.anInt457 == 84) {
                                    Login.method1500(false);
                                } else if (SecureRandomService.anInt457 == 13) {
                                    Login.step = 0;
                                }
                            }

                            var21 = StockMarketOfferPriceComparator.anInt481 - 80;
                            var23 = 321;
                            if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                Login.method1500(false);
                            }

                            var21 = StockMarketOfferPriceComparator.anInt481 + 80;
                            if (var6 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                                Login.step = 0;
                            }
                        }
                    }

                }
            }
        }
    }

    public static RuneScript method1499(int var0) {
        RuneScript var1 = (RuneScript) RuneScript.aReferenceCache1647.get(var0);
        if (var1 != null) {
            return var1;
        }
        byte[] var2 = StockMarketOfferWorldComparator.aArchive348.unpack(var0, 0);
        if (var2 == null) {
            return null;
        }
        var1 = SerializableProcessor.method455(var2);
        RuneScript.aReferenceCache1647.put(var1, var0);
        return var1;
    }

    public static void method1497(PlayerEntity var0, int var1, int var2) {
        if (var0.animation == var1 && var1 != -1) {
            int var3 = AnimationSequence.get(var1).replayMode;
            if (var3 == 1) {
                var0.animationFrame = 0;
                var0.animationFrameCycle = 0;
                var0.animationDelay = var2;
                var0.anInt2010 = 0;
            }

            if (var3 == 2) {
                var0.anInt2010 = 0;
            }
        } else if (var1 == -1 || var0.animation == -1 || AnimationSequence.get(var1).priority >= AnimationSequence.get(var0.animation).priority) {
            var0.animation = var1;
            var0.animationFrame = 0;
            var0.animationFrameCycle = 0;
            var0.animationDelay = var2;
            var0.anInt2010 = 0;
            var0.anInt2023 = var0.pathQueueSize;
        }

    }
}
