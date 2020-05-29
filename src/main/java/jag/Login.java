package jag;

import jag.audi.*;
import jag.audi.vorbis.Vorbis4;
import jag.commons.input.Keyboard;
import jag.commons.input.Mouse;
import jag.game.HealthBar;
import jag.game.World;
import jag.game.client;
import jag.game.option.AttackOptionPriority;
import jag.opcode.LoginStep;
import jag.game.relationship.AssociateComparator_Sub2;
import jag.game.relationship.ClanMember;
import jag.game.scene.CollisionMap;
import jag.game.scene.SceneGraph;
import jag.game.scene.Tile;
import jag.game.scene.entity.PendingSpawn;
import jag.game.stockmarket.*;
import jag.game.type.*;
import jag.graphics.*;
import jag.js5.Archive;
import jag.js5.ReferenceTable;
import jag.opcode.*;
import jag.script.RuneScript;
import jag.statics.*;
import jag.worldmap.*;

import java.text.DecimalFormat;

public class Login {

    public static OldConnectionTask aOldConnectionTask_464;
    public static String loginResponse1;
    public static int anInt479;
    public static String loginResponse2;
    public static String loginResponse3;
    public static int anInt474;
    public static int anInt473;
    public static String aString475;
    public static int anInt468;
    public static int step;
    public static int anInt469;
    public static String aString471;
    public static String username;
    public static String password;
    public static boolean aBoolean477;
    public static boolean aBoolean472;
    public static boolean aBoolean462;
    public static int anInt461;
    public static boolean worldSelectorOpen;
    public static int anInt463;
    public static int anInt460;
    public static int anInt466;
    public static long aLong467;
    public static long aLong465;
    public static boolean aBoolean476;
    public static IndexedSprite[] aDoublyNode_Sub24_Sub4Array478;
    public static IndexedSprite aDoublyNode_Sub24_Sub4_470;
    public static String totp;
    public static Archive aArchive1876;

    static {
        anInt479 = 0;
        anInt474 = anInt479 + 202;
        anInt473 = 10;
        aString475 = "";
        anInt468 = -1;
        anInt469 = 1;
        step = 0;
        aString471 = "";
        loginResponse1 = "";
        loginResponse2 = "";
        loginResponse3 = "";
        username = "";
        password = "";
        aBoolean477 = false;
        aBoolean472 = false;
        aBoolean462 = true;
        anInt461 = 0;
        worldSelectorOpen = false;
        anInt463 = -1;
        anInt460 = 0;
        anInt466 = 0;
        new DecimalFormat("##0.00");
        aLong467 = -1L;
        aLong465 = -1L;
    }

    public static void loadPlayersIntoScene() {
        int var0 = GPI.playerCount;
        int[] var1 = GPI.playerIndices;

        for (int var2 = 0; var2 < var0; ++var2) {
            if (var1[var2] != client.anInt1030 && var1[var2] != client.playerIndex) {
                GPI.loadPlayersIntoScene(client.players[var1[var2]], true);
            }
        }

    }

    public static int method324(int var0, int var1) {
        int var2 = LoginStep.method686(var0 - 1, var1 - 1) + LoginStep.method686(var0 + 1, var1 - 1) + LoginStep.method686(var0 - 1, 1 + var1) + LoginStep.method686(1 + var0, var1 + 1);
        int var3 = LoginStep.method686(var0 - 1, var1) + LoginStep.method686(var0 + 1, var1) + LoginStep.method686(var0, var1 - 1) + LoginStep.method686(var0, var1 + 1);
        int var4 = LoginStep.method686(var0, var1);
        return var2 / 16 + var3 / 8 + var4 / 4;
    }

    public static void draw(Font var0, Font var1, Font var2) {
        anInt479 = (client.canvasWidth - 765) / 2;
        anInt474 = anInt479 + 202;
        StockMarketOfferPriceComparator.anInt481 = anInt474 + 180;
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
        if (worldSelectorOpen) {
            int var36;
            int var39;
            if (Class46.aSpriteArray429 == null) {
                Archive var35 = StockMarketOfferLifetimeComparator.sprites;
                var39 = var35.get("sl_back");
                var36 = var35.method907(var39, "");
                Class46.aSpriteArray429 = Canvas.method643(var35, var39, var36);
            }

            if (ClientLocale.aDoublyNode_Sub24_Sub4Array1178 == null) {
                ClientLocale.aDoublyNode_Sub24_Sub4Array1178 = IndexedSprite.method474(StockMarketOfferLifetimeComparator.sprites, "sl_flags", "");
            }

            if (StockMarketOfferQuantityComparator.aDoublyNode_Sub24_Sub4Array653 == null) {
                StockMarketOfferQuantityComparator.aDoublyNode_Sub24_Sub4Array653 = IndexedSprite.method474(StockMarketOfferLifetimeComparator.sprites, "sl_arrows", "");
            }

            if (AnimationFrameGroup.aDoublyNode_Sub24_Sub4Array801 == null) {
                AnimationFrameGroup.aDoublyNode_Sub24_Sub4Array801 = IndexedSprite.method474(StockMarketOfferLifetimeComparator.sprites, "sl_stars", "");
            }

            if (WorldMapIcon_Sub2.aDoublyNode_Sub24_Sub4_650 == null) {
                WorldMapIcon_Sub2.aDoublyNode_Sub24_Sub4_650 = Area.method375(StockMarketOfferLifetimeComparator.sprites, "leftarrow", "");
            }

            if (HealthBar.aDoublyNode_Sub24_Sub4_848 == null) {
                HealthBar.aDoublyNode_Sub24_Sub4_848 = Area.method375(StockMarketOfferLifetimeComparator.sprites, "rightarrow", "");
            }

            JagGraphics.fillRect(anInt479, 23, 765, 480, 0);
            JagGraphics.method1376(anInt479, 0, 125, 23, 12425273, 9135624);
            JagGraphics.method1376(anInt479 + 125, 0, 640, 23, 5197647, 2697513);
            var0.method1154("Select a world", anInt479 + 62, 15, 0, -1);
            if (AnimationFrameGroup.aDoublyNode_Sub24_Sub4Array801 != null) {
                AnimationFrameGroup.aDoublyNode_Sub24_Sub4Array801[1].method1324(anInt479 + 140, 1);
                var1.drawString("Members only world", anInt479 + 152, 10, 16777215, -1);
                AnimationFrameGroup.aDoublyNode_Sub24_Sub4Array801[0].method1324(anInt479 + 140, 12);
                var1.drawString("Free world", anInt479 + 152, 21, 16777215, -1);
            }

            if (StockMarketOfferQuantityComparator.aDoublyNode_Sub24_Sub4Array653 != null) {
                var41 = anInt479 + 280;
                if (World.anIntArray1874[0] == 0 && World.anIntArray1870[0] == 0) {
                    StockMarketOfferQuantityComparator.aDoublyNode_Sub24_Sub4Array653[2].method1324(var41, 4);
                } else {
                    StockMarketOfferQuantityComparator.aDoublyNode_Sub24_Sub4Array653[0].method1324(var41, 4);
                }

                if (World.anIntArray1874[0] == 0 && World.anIntArray1870[0] == 1) {
                    StockMarketOfferQuantityComparator.aDoublyNode_Sub24_Sub4Array653[3].method1324(var41 + 15, 4);
                } else {
                    StockMarketOfferQuantityComparator.aDoublyNode_Sub24_Sub4Array653[1].method1324(var41 + 15, 4);
                }

                var0.drawString("World", var41 + 32, 17, 16777215, -1);
                var8 = anInt479 + 390;
                if (World.anIntArray1874[0] == 1 && World.anIntArray1870[0] == 0) {
                    StockMarketOfferQuantityComparator.aDoublyNode_Sub24_Sub4Array653[2].method1324(var8, 4);
                } else {
                    StockMarketOfferQuantityComparator.aDoublyNode_Sub24_Sub4Array653[0].method1324(var8, 4);
                }

                if (World.anIntArray1874[0] == 1 && World.anIntArray1870[0] == 1) {
                    StockMarketOfferQuantityComparator.aDoublyNode_Sub24_Sub4Array653[3].method1324(var8 + 15, 4);
                } else {
                    StockMarketOfferQuantityComparator.aDoublyNode_Sub24_Sub4Array653[1].method1324(var8 + 15, 4);
                }

                var0.drawString("Players", var8 + 32, 17, 16777215, -1);
                var39 = anInt479 + 500;
                if (World.anIntArray1874[0] == 2 && World.anIntArray1870[0] == 0) {
                    StockMarketOfferQuantityComparator.aDoublyNode_Sub24_Sub4Array653[2].method1324(var39, 4);
                } else {
                    StockMarketOfferQuantityComparator.aDoublyNode_Sub24_Sub4Array653[0].method1324(var39, 4);
                }

                if (World.anIntArray1874[0] == 2 && World.anIntArray1870[0] == 1) {
                    StockMarketOfferQuantityComparator.aDoublyNode_Sub24_Sub4Array653[3].method1324(var39 + 15, 4);
                } else {
                    StockMarketOfferQuantityComparator.aDoublyNode_Sub24_Sub4Array653[1].method1324(var39 + 15, 4);
                }

                var0.drawString("Location", var39 + 32, 17, 16777215, -1);
                var36 = anInt479 + 610;
                if (World.anIntArray1874[0] == 3 && World.anIntArray1870[0] == 0) {
                    StockMarketOfferQuantityComparator.aDoublyNode_Sub24_Sub4Array653[2].method1324(var36, 4);
                } else {
                    StockMarketOfferQuantityComparator.aDoublyNode_Sub24_Sub4Array653[0].method1324(var36, 4);
                }

                if (World.anIntArray1874[0] == 3 && World.anIntArray1870[0] == 1) {
                    StockMarketOfferQuantityComparator.aDoublyNode_Sub24_Sub4Array653[3].method1324(var36 + 15, 4);
                } else {
                    StockMarketOfferQuantityComparator.aDoublyNode_Sub24_Sub4Array653[1].method1324(var36 + 15, 4);
                }

                var0.drawString("Type", var36 + 32, 17, 16777215, -1);
            }

            JagGraphics.fillRect(anInt479 + 708, 4, 50, 16, 0);
            var1.method1154("Cancel", anInt479 + 708 + 25, 16, 16777215, -1);
            anInt463 = -1;
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
                anInt466 = var23 - var39;
                if (WorldMapIcon_Sub2.aDoublyNode_Sub24_Sub4_650 != null && anInt460 > 0) {
                    WorldMapIcon_Sub2.aDoublyNode_Sub24_Sub4_650.method1324(8, client.canvasHeight / 2 - WorldMapIcon_Sub2.aDoublyNode_Sub24_Sub4_650.anInt377 / 2);
                }

                if (HealthBar.aDoublyNode_Sub24_Sub4_848 != null && anInt460 < anInt466) {
                    HealthBar.aDoublyNode_Sub24_Sub4_848.method1324(client.canvasWidth - HealthBar.aDoublyNode_Sub24_Sub4_848.anInt378 - 8, client.canvasHeight / 2 - HealthBar.aDoublyNode_Sub24_Sub4_848.anInt377 / 2);
                }

                var12 = var10 + 23;
                var24 = var22 + anInt479;
                var19 = 0;
                boolean var25 = false;
                int var26 = anInt460;

                int var27;
                for (var27 = var36 * var26; var27 < World.anInt1871 && var26 - anInt460 < var39; ++var27) {
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
                        anInt463 = var27;
                        Class46.aSpriteArray429[var33].method834(var24, var12, 128, 16777215);
                        var25 = true;
                    } else {
                        Class46.aSpriteArray429[var33].method817(var24, var12);
                    }

                    if (ClientLocale.aDoublyNode_Sub24_Sub4Array1178 != null) {
                        ClientLocale.aDoublyNode_Sub24_Sub4Array1178[(var30.isMembers() ? 8 : 0) + var30.location].method1324(var24 + 29, var12);
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
                    var27 = var1.method1145(World.worlds[anInt463].activity) + 6;
                    int var28 = var1.anInt375 + 8;
                    int var50 = Mouse.y + 25;
                    if (var28 + var50 > 480) {
                        var50 = Mouse.y - 25 - var28;
                    }

                    JagGraphics.fillRect(Mouse.x - var27 / 2, var50, var27, var28, 16777120);
                    JagGraphics.method1372(Mouse.x - var27 / 2, var50, var27, var28, 0);
                    var1.method1154(World.worlds[anInt463].activity, Mouse.x, var50 + var1.anInt375 + 4, 0, -1);
                }
            }

            WorldMapAreaChunk_Sub2.aGraphicsProvider_284.method22(0, 0);
        } else {
            WorldMapGroundDecorType.aSprite308.method817(anInt479, 0);
            Statics1.aSprite324.method817(anInt479 + 382, 0);
            NamedFont.aDoublyNode_Sub24_Sub4_1623.method1324(anInt479 + 382 - NamedFont.aDoublyNode_Sub24_Sub4_1623.anInt378 / 2, 18);
            if (client.gameState == 0 || client.gameState == 5) {
                var7 = 20;
                var0.method1154("RuneScape is loading - please wait...", anInt474 + 180, 245 - var7, 16777215, -1);
                var8 = 253 - var7;
                JagGraphics.method1372(anInt474 + 180 - 152, var8, 304, 34, 9179409);
                JagGraphics.method1372(anInt474 + 180 - 151, var8 + 1, 302, 32, 0);
                JagGraphics.fillRect(anInt474 + 180 - 150, var8 + 2, anInt473 * 3, 30, 9179409);
                JagGraphics.fillRect(anInt473 * 3 + (anInt474 + 180 - 150), var8 + 2, 300 - anInt473 * 3, 30, 0);
                var0.method1154(aString475, anInt474 + 180, 276 - var7, 16777215, -1);
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
                Statics49.aDoublyNode_Sub24_Sub4_126.method1324(anInt474 + 180 - Statics49.aDoublyNode_Sub24_Sub4_126.anInt378 / 2, 271 - Statics49.aDoublyNode_Sub24_Sub4_126.anInt377 / 2);
                var40 = 201;
                var0.method1154(loginResponse1, anInt474 + 180, var40, 16776960, 0);
                var41 = var40 + 15;
                var0.method1154(loginResponse2, anInt474 + 180, var41, 16776960, 0);
                var41 += 15;
                var0.method1154(loginResponse3, anInt474 + 180, var41, 16776960, 0);
                var41 += 15;
                var41 += 7;
                if (step != 4) {
                    var0.drawString("Login: ", anInt474 + 180 - 110, var41, 16777215, 0);
                    var42 = 200;
                    if (!client.preferences.rememberMe) {
                        var15 = username;
                    } else {
                        var9 = username;
                        var10 = var9.length();
                        var11 = new char[var10];

                        for (var12 = 0; var12 < var10; ++var12) {
                            var11[var12] = '*';
                        }

                        var13 = new String(var11);
                        var15 = var13;
                    }

                    while (var0.method1145(var15) > var42) {
                        var15 = var15.substring(0, var15.length() - 1);
                    }

                    var0.drawString(BaseFont.method1166(var15), anInt474 + 180 - 70, var41, 16777215, 0);
                    var41 += 15;
                    var9 = "Password: ";
                    var17 = password;
                    var12 = var17.length();
                    var18 = new char[var12];

                    for (var19 = 0; var19 < var12; ++var19) {
                        var18[var19] = '*';
                    }

                    var43 = new String(var18);
                    var0.drawString(var9 + var43, anInt474 + 180 - 108, var41, 16777215, 0);
                }
            }

            if (client.gameState == 10 || client.gameState == 11) {
                Statics49.aDoublyNode_Sub24_Sub4_126.method1324(anInt474, 171);
                short var4;
                if (step == 0) {
                    var40 = 251;
                    var0.method1154("Welcome to RuneScape", anInt474 + 180, var40, 16776960, 0);
                    var8 = anInt474 + 180 - 80;
                    var4 = 291;
                    GraphicsProvider.aDoublyNode_Sub24_Sub4_1815.method1324(var8 - 73, var4 - 20);
                    var0.method1149("New User", var8 - 73, var4 - 20, 144, 40, 16777215, 0, 1, 1, 0);
                    var8 = anInt474 + 180 + 80;
                    GraphicsProvider.aDoublyNode_Sub24_Sub4_1815.method1324(var8 - 73, var4 - 20);
                    var0.method1149("Existing User", var8 - 73, var4 - 20, 144, 40, 16777215, 0, 1, 1, 0);
                } else if (step == 1) {
                    var0.method1154(aString471, anInt474 + 180, 201, 16776960, 0);
                    var40 = 236;
                    var0.method1154(loginResponse1, anInt474 + 180, var40, 16777215, 0);
                    var41 = var40 + 15;
                    var0.method1154(loginResponse2, anInt474 + 180, var41, 16777215, 0);
                    var41 += 15;
                    var0.method1154(loginResponse3, anInt474 + 180, var41, 16777215, 0);
                    var8 = anInt474 + 180 - 80;
                    var4 = 321;
                    GraphicsProvider.aDoublyNode_Sub24_Sub4_1815.method1324(var8 - 73, var4 - 20);
                    var0.method1154("Continue", var8, var4 + 5, 16777215, 0);
                    var8 = anInt474 + 180 + 80;
                    GraphicsProvider.aDoublyNode_Sub24_Sub4_1815.method1324(var8 - 73, var4 - 20);
                    var0.method1154("Cancel", var8, var4 + 5, 16777215, 0);
                } else if (step == 2) {
                    var40 = 201;
                    var0.method1154(loginResponse1, StockMarketOfferPriceComparator.anInt481, var40, 16776960, 0);
                    var41 = var40 + 15;
                    var0.method1154(loginResponse2, StockMarketOfferPriceComparator.anInt481, var41, 16776960, 0);
                    var41 += 15;
                    var0.method1154(loginResponse3, StockMarketOfferPriceComparator.anInt481, var41, 16776960, 0);
                    var41 += 15;
                    var41 += 7;
                    var0.drawString("Login: ", StockMarketOfferPriceComparator.anInt481 - 110, var41, 16777215, 0);
                    var42 = 200;
                    if (!client.preferences.rememberMe) {
                        var15 = username;
                    } else {
                        var9 = username;
                        var10 = var9.length();
                        var11 = new char[var10];

                        for (var12 = 0; var12 < var10; ++var12) {
                            var11[var12] = '*';
                        }

                        var13 = new String(var11);
                        var15 = var13;
                    }

                    while (var0.method1145(var15) > var42) {
                        var15 = var15.substring(1);
                    }

                    var0.drawString(BaseFont.method1166(var15) + (anInt461 == 0 & client.engineCycle % 40 < 20 ? World.getColorTags(16776960) + "|" : ""), StockMarketOfferPriceComparator.anInt481 - 70, var41, 16777215, 0);
                    var41 += 15;
                    var9 = "Password: ";
                    var17 = password;
                    var12 = var17.length();
                    var18 = new char[var12];

                    for (var19 = 0; var19 < var12; ++var19) {
                        var18[var19] = '*';
                    }

                    var43 = new String(var18);
                    var0.drawString(var9 + var43 + (anInt461 == 1 & client.engineCycle % 40 < 20 ? World.getColorTags(16776960) + "|" : ""), StockMarketOfferPriceComparator.anInt481 - 108, var41, 16777215, 0);
                    var40 = 277;
                    var23 = StockMarketOfferPriceComparator.anInt481 + -117;
                    IndexedSprite var34 = OutgoingPacketMeta.method6(client.aBoolean958, aBoolean477);
                    var34.method1324(var23, var40);
                    var23 = var23 + var34.anInt378 + 5;
                    var1.drawString("Remember username", var23, var40 + 13, 16776960, 0);
                    var23 = StockMarketOfferPriceComparator.anInt481 + 24;
                    var34 = OutgoingPacketMeta.method6(client.preferences.rememberMe, aBoolean472);
                    var34.method1324(var23, var40);
                    var23 = var23 + var34.anInt378 + 5;
                    var1.drawString("Hide username", var23, var40 + 13, 16776960, 0);
                    var24 = StockMarketOfferPriceComparator.anInt481 - 80;
                    short var48 = 321;
                    GraphicsProvider.aDoublyNode_Sub24_Sub4_1815.method1324(var24 - 73, var48 - 20);
                    var0.method1154("Login", var24, var48 + 5, 16777215, 0);
                    var24 = StockMarketOfferPriceComparator.anInt481 + 80;
                    GraphicsProvider.aDoublyNode_Sub24_Sub4_1815.method1324(var24 - 73, var48 - 20);
                    var0.method1154("Cancel", var24, var48 + 5, 16777215, 0);
                    var40 = 357;
                    switch (anInt469) {
                        case 2:
                            SerializableProcessor.aString636 = "Having trouble logging in?";
                            break;
                        default:
                            SerializableProcessor.aString636 = "Can't login? Click here.";
                    }

                    LoginScreenEffect.aBounds_418 = new Bounds(StockMarketOfferPriceComparator.anInt481, var40, var1.method1145(SerializableProcessor.aString636), 11);
                    LoginPacketMeta.aBounds_846 = new Bounds(StockMarketOfferPriceComparator.anInt481, var40, var1.method1145("Still having trouble logging in?"), 11);
                    var1.method1154(SerializableProcessor.aString636, StockMarketOfferPriceComparator.anInt481, var40, 16777215, 0);
                } else if (step == 3) {
                    var40 = 201;
                    var0.method1154("Invalid credentials.", anInt474 + 180, var40, 16776960, 0);
                    var41 = var40 + 20;
                    var1.method1154("For accounts created after 24th November 2010, please use your", anInt474 + 180, var41, 16776960, 0);
                    var41 += 15;
                    var1.method1154("email address to login. Otherwise please login with your username.", anInt474 + 180, var41, 16776960, 0);
                    var8 = anInt474 + 180;
                    var4 = 276;
                    GraphicsProvider.aDoublyNode_Sub24_Sub4_1815.method1324(var8 - 73, var4 - 20);
                    var2.method1154("Try again", var8, var4 + 5, 16777215, 0);
                    var8 = anInt474 + 180;
                    var4 = 326;
                    GraphicsProvider.aDoublyNode_Sub24_Sub4_1815.method1324(var8 - 73, var4 - 20);
                    var2.method1154("Forgotten password?", var8, var4 + 5, 16777215, 0);
                } else {
                    String var16;
                    if (step == 4) {
                        var0.method1154("Authenticator", anInt474 + 180, 201, 16776960, 0);
                        var40 = 236;
                        var0.method1154(loginResponse1, anInt474 + 180, var40, 16777215, 0);
                        var41 = var40 + 15;
                        var0.method1154(loginResponse2, anInt474 + 180, var41, 16777215, 0);
                        var41 += 15;
                        var0.method1154(loginResponse3, anInt474 + 180, var41, 16777215, 0);
                        var41 += 15;
                        var16 = "PIN: ";
                        String var14 = totp;
                        var22 = var14.length();
                        char[] var46 = new char[var22];

                        for (var23 = 0; var23 < var22; ++var23) {
                            var46[var23] = '*';
                        }

                        var9 = new String(var46);
                        var0.drawString(var16 + var9 + (client.engineCycle % 40 < 20 ? World.getColorTags(16776960) + "|" : ""), anInt474 + 180 - 108, var41, 16777215, 0);
                        var41 -= 8;
                        var0.drawString("Trust this computer", anInt474 + 180 - 9, var41, 16776960, 0);
                        var41 += 15;
                        var0.drawString("for 30 days: ", anInt474 + 180 - 9, var41, 16776960, 0);
                        var21 = anInt474 + 180 - 9 + var0.method1145("for 30 days: ") + 15;
                        var22 = var41 - var0.anInt375;
                        IndexedSprite var47;
                        if (aBoolean462) {
                            var47 = WorldMapAreaChunk_Sub2.aDoublyNode_Sub24_Sub4_288;
                        } else {
                            var47 = Statics11.aDoublyNode_Sub24_Sub4_1148;
                        }

                        var47.method1324(var21, var22);
                        var23 = anInt474 + 180 - 80;
                        short var45 = 321;
                        GraphicsProvider.aDoublyNode_Sub24_Sub4_1815.method1324(var23 - 73, var45 - 20);
                        var0.method1154("Continue", var23, var45 + 5, 16777215, 0);
                        var23 = anInt474 + 180 + 80;
                        GraphicsProvider.aDoublyNode_Sub24_Sub4_1815.method1324(var23 - 73, var45 - 20);
                        var0.method1154("Cancel", var23, var45 + 5, 16777215, 0);
                        var1.method1154("<u=ff>Can't Log In?</u>", anInt474 + 180, var45 + 36, 255, 0);
                    } else {
                        short var49;
                        if (step == 5) {
                            var0.method1154("Forgotten your password?", anInt474 + 180, 201, 16776960, 0);
                            var40 = 221;
                            var2.method1154(loginResponse1, anInt474 + 180, var40, 16776960, 0);
                            var41 = var40 + 15;
                            var2.method1154(loginResponse2, anInt474 + 180, var41, 16776960, 0);
                            var41 += 15;
                            var2.method1154(loginResponse3, anInt474 + 180, var41, 16776960, 0);
                            var41 += 15;
                            var41 += 14;
                            var0.drawString("Username/email: ", anInt474 + 180 - 145, var41, 16777215, 0);
                            var42 = 174;
                            if (!client.preferences.rememberMe) {
                                var15 = username;
                            } else {
                                var9 = username;
                                var10 = var9.length();
                                var11 = new char[var10];

                                for (var12 = 0; var12 < var10; ++var12) {
                                    var11[var12] = '*';
                                }

                                var13 = new String(var11);
                                var15 = var13;
                            }

                            while (var0.method1145(var15) > var42) {
                                var15 = var15.substring(1);
                            }

                            var0.drawString(BaseFont.method1166(var15) + (client.engineCycle % 40 < 20 ? World.getColorTags(16776960) + "|" : ""), anInt474 + 180 - 34, var41, 16777215, 0);
                            var20 = anInt474 + 180 - 80;
                            var49 = 321;
                            GraphicsProvider.aDoublyNode_Sub24_Sub4_1815.method1324(var20 - 73, var49 - 20);
                            var0.method1154("Recover", var20, var49 + 5, 16777215, 0);
                            var20 = anInt474 + 180 + 80;
                            GraphicsProvider.aDoublyNode_Sub24_Sub4_1815.method1324(var20 - 73, var49 - 20);
                            var0.method1154("Back", var20, var49 + 5, 16777215, 0);
                            var49 = 356;
                            var1.method1154("Still having trouble logging in?", StockMarketOfferPriceComparator.anInt481, var49, 268435455, 0);
                        } else if (step == 6) {
                            var40 = 201;
                            var0.method1154(loginResponse1, anInt474 + 180, var40, 16776960, 0);
                            var41 = var40 + 15;
                            var0.method1154(loginResponse2, anInt474 + 180, var41, 16776960, 0);
                            var41 += 15;
                            var0.method1154(loginResponse3, anInt474 + 180, var41, 16776960, 0);
                            var8 = anInt474 + 180;
                            var4 = 321;
                            GraphicsProvider.aDoublyNode_Sub24_Sub4_1815.method1324(var8 - 73, var4 - 20);
                            var0.method1154("Back", var8, var4 + 5, 16777215, 0);
                        } else if (step == 7) {
                            var40 = 216;
                            var0.method1154("Your date of birth isn't set.", anInt474 + 180, var40, 16776960, 0);
                            var41 = var40 + 15;
                            var2.method1154("Please verify your account status by", anInt474 + 180, var41, 16776960, 0);
                            var41 += 15;
                            var2.method1154("setting your date of birth.", anInt474 + 180, var41, 16776960, 0);
                            var8 = anInt474 + 180 - 80;
                            var4 = 321;
                            GraphicsProvider.aDoublyNode_Sub24_Sub4_1815.method1324(var8 - 73, var4 - 20);
                            var0.method1154("Set Date of Birth", var8, var4 + 5, 16777215, 0);
                            var8 = anInt474 + 180 + 80;
                            GraphicsProvider.aDoublyNode_Sub24_Sub4_1815.method1324(var8 - 73, var4 - 20);
                            var0.method1154("Back", var8, var4 + 5, 16777215, 0);
                        } else if (step == 8) {
                            var40 = 216;
                            var0.method1154("Sorry, but your account is not eligible to play.", anInt474 + 180, var40, 16776960, 0);
                            var41 = var40 + 15;
                            var2.method1154("For more information, please take a look at", anInt474 + 180, var41, 16776960, 0);
                            var41 += 15;
                            var2.method1154("our privacy policy.", anInt474 + 180, var41, 16776960, 0);
                            var8 = anInt474 + 180 - 80;
                            var4 = 321;
                            GraphicsProvider.aDoublyNode_Sub24_Sub4_1815.method1324(var8 - 73, var4 - 20);
                            var0.method1154("Privacy Policy", var8, var4 + 5, 16777215, 0);
                            var8 = anInt474 + 180 + 80;
                            GraphicsProvider.aDoublyNode_Sub24_Sub4_1815.method1324(var8 - 73, var4 - 20);
                            var0.method1154("Back", var8, var4 + 5, 16777215, 0);
                        } else if (step == 12) {
                            var40 = 201;
                            String var3 = "";
                            var16 = "";
                            var15 = "";
                            switch (anInt468) {
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
                                    method1500(false);
                            }

                            var0.method1154(var3, anInt474 + 180, var40, 16776960, 0);
                            var41 = var40 + 15;
                            var2.method1154(var16, anInt474 + 180, var41, 16776960, 0);
                            var41 += 15;
                            var2.method1154(var15, anInt474 + 180, var41, 16776960, 0);
                            var20 = anInt474 + 180;
                            var49 = 276;
                            GraphicsProvider.aDoublyNode_Sub24_Sub4_1815.method1324(var20 - 73, var49 - 20);
                            var0.method1154("Support Page", var20, var49 + 5, 16777215, 0);
                            var20 = anInt474 + 180;
                            var49 = 326;
                            GraphicsProvider.aDoublyNode_Sub24_Sub4_1815.method1324(var20 - 73, var49 - 20);
                            var0.method1154("Back", var20, var49 + 5, 16777215, 0);
                        } else if (step == 24) {
                            var40 = 221;
                            var0.method1154(loginResponse1, anInt474 + 180, var40, 16777215, 0);
                            var41 = var40 + 15;
                            var0.method1154(loginResponse2, anInt474 + 180, var41, 16777215, 0);
                            var41 += 15;
                            var0.method1154(loginResponse3, anInt474 + 180, var41, 16777215, 0);
                            var8 = anInt474 + 180;
                            var4 = 301;
                            GraphicsProvider.aDoublyNode_Sub24_Sub4_1815.method1324(var8 - 73, var4 - 20);
                            var0.method1154("Ok", var8, var4 + 5, 16777215, 0);
                        }
                    }
                }
            }

            if (client.gameState >= 10) {
                int[] var6 = new int[4];
                JagGraphics.method1366(var6);

                JagGraphics.setClip(anInt479, 0, anInt479 + 765, client.canvasHeight);
                AsyncOutputStream.loginScreenEffect.method283(anInt479 - 22, client.engineCycle);
                AsyncOutputStream.loginScreenEffect.method283(anInt479 + 22 + 765 - 128, client.engineCycle);
                JagGraphics.method1373(var6);
            }

            AssociateComparator_Sub2.aDoublyNode_Sub24_Sub4Array765[client.preferences.loginScreenAudioDisabled ? 1 : 0].method1324(anInt479 + 765 - 40, 463);
            if (client.gameState > 5 && ClientLocale.GB == WorldMapLabelSize.aClientLocale_525) {
                if (AnimationFrame.aDoublyNode_Sub24_Sub4_811 != null) {
                    var41 = anInt479 + 5;
                    var42 = 463;
                    byte var38 = 100;
                    byte var5 = 35;
                    AnimationFrame.aDoublyNode_Sub24_Sub4_811.method1324(var41, var42);
                    var0.method1154("World" + " " + client.currentWorld, var38 / 2 + var41, var5 / 2 + var42 - 2, 16777215, 0);
                    if (Statics1.aURLRequest_322 != null) {
                        var1.method1154("Loading...", var38 / 2 + var41, var5 / 2 + var42 + 12, 16777215, 0);
                    } else {
                        var1.method1154("Click to switch", var38 / 2 + var41, var5 / 2 + var42 + 12, 16777215, 0);
                    }
                } else {
                    AnimationFrame.aDoublyNode_Sub24_Sub4_811 = Area.method375(StockMarketOfferLifetimeComparator.sprites, "sl_button", "");
                }
            }

        }
    }

    public static void method23() {
        if (username == null || username.length() <= 0) {
            if (client.preferences.aString362 != null) {
                username = client.preferences.aString362;
                client.aBoolean958 = true;
            } else {
                client.aBoolean958 = false;
            }

        }
    }

    public static void method1500(boolean var0) {
        loginResponse1 = "";
        loginResponse2 = "Enter your username/email & password.";
        loginResponse3 = "";
        step = 2;
        if (var0) {
            password = "";
        }

        method23();
        if (client.aBoolean958 && username != null && username.length() > 0) {
            anInt461 = 1;
        } else {
            anInt461 = 0;
        }

    }

    public static void method798() {
        int var0;
        if (client.bootState == 0) {
            client.sceneGraph = new SceneGraph(4, 104, 104, Statics45.tileHeights);

            for (var0 = 0; var0 < 4; ++var0) {
                client.collisionMaps[var0] = new CollisionMap(104, 104);
            }

            ObjectSound.minimapSprite = new Sprite(512, 512);
            aString475 = "Starting game engine...";
            anInt473 = 5;
            client.bootState = 20;
        } else if (client.bootState == 20) {
            aString475 = "Prepared visibility map";
            anInt473 = 10;
            client.bootState = 30;
        } else if (client.bootState == 30) {
            SerializableInteger.aArchive583 = ReferenceTable.getReferenceTable(0, false, true);
            WorldMapLabelSize.aArchive526 = ReferenceTable.getReferenceTable(1, false, true);
            Face.aArchive773 = ReferenceTable.getReferenceTable(2, true, false);
            aArchive1876 = ReferenceTable.getReferenceTable(3, false, true);
            StockMarketOfferLifetimeComparator.aArchive586 = ReferenceTable.getReferenceTable(4, false, true);
            SerializableProcessor.aArchive635 = ReferenceTable.getReferenceTable(5, true, true);
            Statics15.aArchive1234 = ReferenceTable.getReferenceTable(6, true, true);
            ClientLocale.aArchive1188 = ReferenceTable.getReferenceTable(7, false, true);
            StockMarketOfferLifetimeComparator.sprites = ReferenceTable.getReferenceTable(8, false, true);
            AttackOptionPriority.aArchive329 = ReferenceTable.getReferenceTable(9, false, true);
            client.aArchive948 = ReferenceTable.getReferenceTable(10, false, true);
            ClanMember.aArchive867 = ReferenceTable.getReferenceTable(11, false, true);
            StockMarketOfferWorldComparator.aArchive348 = ReferenceTable.getReferenceTable(12, false, true);
            Tile.aArchive1152 = ReferenceTable.getReferenceTable(13, true, false);
            WorldMapTileDecor_Sub1.aArchive166 = ReferenceTable.getReferenceTable(14, false, true);
            RuneScript.aArchive1644 = ReferenceTable.getReferenceTable(15, false, true);
            client.aArchive953 = ReferenceTable.getReferenceTable(17, true, true);
            VarcInteger.aArchive1506 = ReferenceTable.getReferenceTable(18, false, true);
            WorldMapLabel.aArchive341 = ReferenceTable.getReferenceTable(19, false, true);
            WorldMapScriptEvent.aArchive304 = ReferenceTable.getReferenceTable(20, false, true);
            aString475 = "Connecting to update server";
            anInt473 = 20;
            client.bootState = 40;
        } else if (client.bootState == 40) {
            byte var30 = 0;
            var0 = var30 + SerializableInteger.aArchive583.method494() * 4 / 100;
            var0 += WorldMapLabelSize.aArchive526.method494() * 4 / 100;
            var0 += Face.aArchive773.method494() * 2 / 100;
            var0 += aArchive1876.method494() * 2 / 100;
            var0 += StockMarketOfferLifetimeComparator.aArchive586.method494() * 6 / 100;
            var0 += SerializableProcessor.aArchive635.method494() * 4 / 100;
            var0 += Statics15.aArchive1234.method494() * 2 / 100;
            var0 += ClientLocale.aArchive1188.method494() * 56 / 100;
            var0 += StockMarketOfferLifetimeComparator.sprites.method494() * 2 / 100;
            var0 += AttackOptionPriority.aArchive329.method494() * 2 / 100;
            var0 += client.aArchive948.method494() * 2 / 100;
            var0 += ClanMember.aArchive867.method494() * 2 / 100;
            var0 += StockMarketOfferWorldComparator.aArchive348.method494() * 2 / 100;
            var0 += Tile.aArchive1152.method494() * 2 / 100;
            var0 += WorldMapTileDecor_Sub1.aArchive166.method494() * 2 / 100;
            var0 += RuneScript.aArchive1644.method494() * 2 / 100;
            var0 += WorldMapLabel.aArchive341.method494() / 100;
            var0 += VarcInteger.aArchive1506.method494() / 100;
            var0 += WorldMapScriptEvent.aArchive304.method494() / 100;
            var0 += client.aArchive953.method491() && client.aArchive953.method908() ? 1 : 0;
            if (var0 != 100) {
                if (var0 != 0) {
                    aString475 = "Checking for updates - " + var0 + "%";
                }

                anInt473 = 30;
            } else {
                Class46.method175(SerializableInteger.aArchive583);
                Class46.method175(WorldMapLabelSize.aArchive526);
                Class46.method175(StockMarketOfferLifetimeComparator.aArchive586);
                Class46.method175(SerializableProcessor.aArchive635);
                Class46.method175(Statics15.aArchive1234);
                Class46.method175(ClientLocale.aArchive1188);
                Class46.method175(StockMarketOfferLifetimeComparator.sprites);
                Class46.method175(ClanMember.aArchive867);
                Class46.method175(WorldMapTileDecor_Sub1.aArchive166);
                Class46.method175(RuneScript.aArchive1644);
                Class46.method175(WorldMapLabel.aArchive341);
                Class46.method175(VarcInteger.aArchive1506);
                Class46.method175(WorldMapScriptEvent.aArchive304);
                WorldMapTileDecor_Sub2.aBootSprites_647 = new BootSprites();
                WorldMapTileDecor_Sub2.aBootSprites_647.method1190(client.aArchive953);
                aString475 = "Loaded update list";
                anInt473 = 30;
                client.bootState = 45;
            }
        } else {
            Archive var2;
            Archive var3;
            Archive var4;
            if (client.bootState == 45) {
                boolean var28 = !client.lowMemory;
                URLRequest.audioSampleRate = 22050;
                AudioSystem.useTwoChannels = var28;
                MenuItemNode.anInt603 = 2;
                PcmStream_Sub3 var26 = new PcmStream_Sub3();
                var26.method575(9, 128);
                AudioSystem.anAudioSystem1236 = StockMarketOfferNameComparator.method329(0, 22050);
                AudioSystem.anAudioSystem1236.method1330(var26);
                var2 = RuneScript.aArchive1644;
                var3 = WorldMapTileDecor_Sub1.aArchive166;
                var4 = StockMarketOfferLifetimeComparator.aArchive586;
                Statics57.aReferenceTable1160 = var2;
                SecureRandomCallable.aReferenceTable382 = var3;
                Statics57.aReferenceTable1159 = var4;
                Statics50.aClass5_Sub6_Sub3_326 = var26;
                Class76.anAudioSystem599 = StockMarketOfferNameComparator.method329(1, 2048);
                WorldMapLabelSize.aClass5_Sub6_Sub1_528 = new PcmStream_Sub1();
                Class76.anAudioSystem599.method1330(WorldMapLabelSize.aClass5_Sub6_Sub1_528);
                Statics46.aClass98_446 = new Vorbis4(22050, URLRequest.audioSampleRate);
                aString475 = "Prepared sound engine";
                anInt473 = 35;
                client.bootState = 50;
                AssociateComparator_Sub2.aFonts_766 = new Fonts(StockMarketOfferLifetimeComparator.sprites, Tile.aArchive1152);
            } else if (client.bootState == 50) {
                var0 = NamedFont.values().length;
                client.fonts = AssociateComparator_Sub2.aFonts_766.lookup(NamedFont.values());
                if (client.fonts.size() < var0) {
                    aString475 = "Loading fonts - " + client.fonts.size() * 100 / var0 + "%";
                    anInt473 = 40;
                } else {
                    StockMarketOfferWorldComparator.aFont345 = (Font) client.fonts.get(NamedFont.P11);
                    BootSprites.font_p12full = (Font) client.fonts.get(NamedFont.P12);
                    Statics7.aFont863 = (Font) client.fonts.get(NamedFont.B12);
                    client.operatingSystemNode = client.operatingSystemProvider.provide();
                    aString475 = "Loaded fonts";
                    anInt473 = 40;
                    client.bootState = 60;
                }
            } else {
                Archive var1;
                int var5;
                if (client.bootState == 60) {
                    var1 = client.aArchive948;
                    var2 = StockMarketOfferLifetimeComparator.sprites;
                    var5 = 0;
                    if (var1.method893("title.jpg", "")) {
                        ++var5;
                    }

                    if (var2.method893("logo", "")) {
                        ++var5;
                    }

                    if (var2.method893("logo_deadman_mode", "")) {
                        ++var5;
                    }

                    if (var2.method893("titlebox", "")) {
                        ++var5;
                    }

                    if (var2.method893("titlebutton", "")) {
                        ++var5;
                    }

                    if (var2.method893("runes", "")) {
                        ++var5;
                    }

                    if (var2.method893("title_mute", "")) {
                        ++var5;
                    }

                    if (var2.method893("options_radio_buttons,0", "")) {
                        ++var5;
                    }

                    if (var2.method893("options_radio_buttons,2", "")) {
                        ++var5;
                    }

                    if (var2.method893("options_radio_buttons,4", "")) {
                        ++var5;
                    }

                    if (var2.method893("options_radio_buttons,6", "")) {
                        ++var5;
                    }

                    var2.method893("sl_back", "");
                    var2.method893("sl_flags", "");
                    var2.method893("sl_arrows", "");
                    var2.method893("sl_stars", "");
                    var2.method893("sl_button", "");
                    byte var27 = 11;
                    if (var5 < var27) {
                        aString475 = "Loading title screen - " + var5 * 100 / var27 + "%";
                        anInt473 = 50;
                    } else {
                        aString475 = "Loaded title screen";
                        anInt473 = 50;
                        client.setGameState(5);
                        client.bootState = 70;
                    }
                } else if (client.bootState == 70) {
                    if (!Face.aArchive773.method908()) {
                        aString475 = "Loading config - " + Face.aArchive773.method489() + "%";
                        anInt473 = 60;
                    } else {
                        TileOverlay.aReferenceTable383 = Face.aArchive773;
                        var1 = Face.aArchive773;
                        TileUnderlay.aReferenceTable383 = var1;
                        var2 = Face.aArchive773;
                        var3 = ClientLocale.aArchive1188;
                        IdentikitDefinition.aReferenceTable383 = var2;
                        StockMarketOfferWorldComparator.aReferenceTable350 = var3;
                        DefaultAudioSystemProvider.anInt143 = IdentikitDefinition.aReferenceTable383.method901(3);
                        var4 = Face.aArchive773;
                        Archive var9 = ClientLocale.aArchive1188;
                        boolean var10 = client.lowMemory;
                        ObjectDefinition.aReferenceTable697 = var4;
                        ObjectDefinition.aReferenceTable1515 = var9;
                        ObjectDefinition.aBoolean792 = var10;
                        Archive var11 = Face.aArchive773;
                        Archive var12 = ClientLocale.aArchive1188;
                        NpcDefinition.table = var11;
                        NpcDefinition.aReferenceTable697 = var12;
                        ParameterDefinition.aReferenceTable383 = Face.aArchive773;
                        ItemDefinition.method240(Face.aArchive773, ClientLocale.aArchive1188, client.membersWorld, StockMarketOfferWorldComparator.aFont345);
                        AnimationSequence.method1202(Face.aArchive773, SerializableInteger.aArchive583, WorldMapLabelSize.aArchive526);
                        Archive var14 = Face.aArchive773;
                        Archive var15 = ClientLocale.aArchive1188;
                        Statics52.aReferenceTable500 = var14;
                        EffectAnimation.table = var15;
                        StockMarketOfferNameComparator.method327(Face.aArchive773);
                        VarDefinition.aReferenceTable383 = Face.aArchive773;
                        VarDefinition.anInt568 = VarDefinition.aReferenceTable383.method901(16);
                        MouseRecorder.method263(aArchive1876, ClientLocale.aArchive1188, StockMarketOfferLifetimeComparator.sprites, Tile.aArchive1152);
                        Keyboard.method103(Face.aArchive773);
                        EnumDefinition.aReferenceTable383 = Face.aArchive773;
                        VarcInteger.aReferenceTable383 = Face.aArchive773;
                        DefinitionProperty.table = Face.aArchive773;
                        client.varcs = new Varcs();
                        WorldMapArea.method88(Face.aArchive773, StockMarketOfferLifetimeComparator.sprites, Tile.aArchive1152);
                        HealthBarDefinition.method296(Face.aArchive773, StockMarketOfferLifetimeComparator.sprites);
                        Archive var20 = Face.aArchive773;
                        WorldMapFunction.table = StockMarketOfferLifetimeComparator.sprites;
                        if (var20.method908()) {
                            WorldMapFunction.anInt378 = var20.method901(35);
                            WorldMapFunction.aDoublyNode_Sub15Array1475 = new WorldMapFunction[WorldMapFunction.anInt378];

                            for (int var22 = 0; var22 < WorldMapFunction.anInt378; ++var22) {
                                byte[] var23 = var20.unpack(35, var22);
                                WorldMapFunction.aDoublyNode_Sub15Array1475[var22] = new WorldMapFunction(var22);
                                if (var23 != null) {
                                    WorldMapFunction.aDoublyNode_Sub15Array1475[var22].decode(new Buffer(var23));
                                    WorldMapFunction.aDoublyNode_Sub15Array1475[var22].method775();
                                }
                            }
                        }

                        aString475 = "Loaded config";
                        anInt473 = 60;
                        client.bootState = 80;
                    }
                } else if (client.bootState == 80) {
                    var0 = 0;
                    if (AttackOptionPriority.compass == null) {
                        AttackOptionPriority.compass = Sprite.get(StockMarketOfferLifetimeComparator.sprites, WorldMapTileDecor_Sub2.aBootSprites_647.anInt1656, 0);
                    } else {
                        ++var0;
                    }

                    if (PendingSpawn.mapedge == null) {
                        PendingSpawn.mapedge = Sprite.get(StockMarketOfferLifetimeComparator.sprites, WorldMapTileDecor_Sub2.aBootSprites_647.anInt1658, 0);
                    } else {
                        ++var0;
                    }

                    if (Statics52.mapscene == null) {
                        Statics52.mapscene = Statics38.method1194(StockMarketOfferLifetimeComparator.sprites, WorldMapTileDecor_Sub2.aBootSprites_647.anInt1653, 0);
                    } else {
                        ++var0;
                    }

                    if (ParameterDefinition.prayerIconSprites == null) {
                        ParameterDefinition.prayerIconSprites = Canvas.method643(StockMarketOfferLifetimeComparator.sprites, WorldMapTileDecor_Sub2.aBootSprites_647.anInt1652, 0);
                    } else {
                        ++var0;
                    }

                    if (WorldMapChunkDefinition.skullIconSprites == null) {
                        WorldMapChunkDefinition.skullIconSprites = Canvas.method643(StockMarketOfferLifetimeComparator.sprites, WorldMapTileDecor_Sub2.aBootSprites_647.anInt1650, 0);
                    } else {
                        ++var0;
                    }

                    if (ClassStructure.hitmarks == null) {
                        ClassStructure.hitmarks = Canvas.method643(StockMarketOfferLifetimeComparator.sprites, WorldMapTileDecor_Sub2.aBootSprites_647.anInt1648, 0);
                    } else {
                        ++var0;
                    }

                    if (Sprite.mapfunctions == null) {
                        Sprite.mapfunctions = Canvas.method643(StockMarketOfferLifetimeComparator.sprites, WorldMapTileDecor_Sub2.aBootSprites_647.anInt1649, 0);
                    } else {
                        ++var0;
                    }

                    if (URLRequest.hintIcons == null) {
                        URLRequest.hintIcons = Canvas.method643(StockMarketOfferLifetimeComparator.sprites, WorldMapTileDecor_Sub2.aBootSprites_647.anInt1657, 0);
                    } else {
                        ++var0;
                    }

                    if (Statics47.mapmarkers == null) {
                        Statics47.mapmarkers = Canvas.method643(StockMarketOfferLifetimeComparator.sprites, WorldMapTileDecor_Sub2.aBootSprites_647.anInt1654, 0);
                    } else {
                        ++var0;
                    }

                    if (SerializableString.scrollbars == null) {
                        SerializableString.scrollbars = Statics38.method1194(StockMarketOfferLifetimeComparator.sprites, WorldMapTileDecor_Sub2.aBootSprites_647.anInt1655, 0);
                    } else {
                        ++var0;
                    }

                    if (WorldMapTileDecor_Sub2.aDoublyNode_Sub24_Sub4Array648 == null) {
                        WorldMapTileDecor_Sub2.aDoublyNode_Sub24_Sub4Array648 = Statics38.method1194(StockMarketOfferLifetimeComparator.sprites, WorldMapTileDecor_Sub2.aBootSprites_647.anInt1651, 0);
                    } else {
                        ++var0;
                    }

                    if (var0 < 11) {
                        aString475 = "Loading sprites - " + var0 * 100 / 12 + "%";
                        anInt473 = 70;
                    } else {
                        BaseFont.aDoublyNode_Sub24_Sub4Array1573 = WorldMapTileDecor_Sub2.aDoublyNode_Sub24_Sub4Array648;
                        PendingSpawn.mapedge.method775();
                        int var24 = (int) (Math.random() * 21.0D) - 10;
                        int var25 = (int) (Math.random() * 21.0D) - 10;
                        var5 = (int) (Math.random() * 21.0D) - 10;
                        int var6 = (int) (Math.random() * 41.0D) - 20;
                        Statics52.mapscene[0].method1325(var6 + var24, var6 + var25, var6 + var5);
                        aString475 = "Loaded sprites";
                        anInt473 = 70;
                        client.bootState = 90;
                    }
                } else if (client.bootState == 90) {
                    if (!AttackOptionPriority.aArchive329.method908()) {
                        aString475 = "Loading textures - " + "0%";
                        anInt473 = 90;
                    } else {
                        Archive.textureProvider = new DefaultMaterialProvider(AttackOptionPriority.aArchive329, StockMarketOfferLifetimeComparator.sprites, 20, 0.8D, client.lowMemory ? 64 : 128);
                        JagGraphics3D.method636(Archive.textureProvider);
                        JagGraphics3D.method634(0.8D);
                        client.bootState = 100;
                    }
                } else if (client.bootState == 100) {
                    var0 = Archive.textureProvider.method1516();
                    if (var0 < 100) {
                        aString475 = "Loading textures - " + var0 + "%";
                        anInt473 = 90;
                    } else {
                        aString475 = "Loaded textures";
                        anInt473 = 90;
                        client.bootState = 110;
                    }
                } else if (client.bootState == 110) {
                    client.mouseRecorder = new MouseRecorder();
                    client.aOldConnectionTaskProcessor_1321.method697(client.mouseRecorder, 10);
                    aString475 = "Loaded input handler";
                    anInt473 = 92;
                    client.bootState = 120;
                } else if (client.bootState == 120) {
                    if (!client.aArchive948.method893("huffman", "")) {
                        aString475 = "Loading wordpack - " + 0 + "%";
                        anInt473 = 94;
                    } else {
                        Statics19.huffman = new Huffman(client.aArchive948.method897("huffman", ""));
                        aString475 = "Loaded wordpack";
                        anInt473 = 94;
                        client.bootState = 130;
                    }
                } else if (client.bootState == 130) {
                    if (!aArchive1876.method908()) {
                        aString475 = "Loading interfaces - " + aArchive1876.method489() * 4 / 5 + "%";
                        anInt473 = 96;
                    } else if (!StockMarketOfferWorldComparator.aArchive348.method908()) {
                        aString475 = "Loading interfaces - " + (80 + StockMarketOfferWorldComparator.aArchive348.method489() / 6) + "%";
                        anInt473 = 96;
                    } else if (!Tile.aArchive1152.method908()) {
                        aString475 = "Loading interfaces - " + (96 + Tile.aArchive1152.method489() / 50) + "%";
                        anInt473 = 96;
                    } else {
                        aString475 = "Loaded interfaces";
                        anInt473 = 98;
                        client.bootState = 140;
                    }
                } else if (client.bootState == 140) {
                    anInt473 = 100;
                    if (!WorldMapLabel.aArchive341.method909(WorldMapCacheFeature.DETAILS.name)) {
                        aString475 = "Loading world map - " + WorldMapLabel.aArchive341.method895(WorldMapCacheFeature.DETAILS.name) / 10 + "%";
                    } else {
                        if (client.worldMap == null) {
                            client.worldMap = new WorldMap();
                            client.worldMap.initialize(WorldMapLabel.aArchive341, VarcInteger.aArchive1506, WorldMapScriptEvent.aArchive304, Statics7.aFont863, client.fonts, Statics52.mapscene);
                        }

                        aString475 = "Loaded world map";
                        client.bootState = 150;
                    }
                } else if (client.bootState == 150) {
                    client.setGameState(10);
                }
            }
        }
    }

    public static void processResponseCode(int code) {
        if (code == -3) {
            PlayerAccountType.setLoginMessages("Connection timed out.", "Please try using a different world.", "");
        } else if (code == -2) {
            PlayerAccountType.setLoginMessages("", "Error connecting to server.", "");
        } else if (code == -1) {
            PlayerAccountType.setLoginMessages("No response from server.", "Please try using a different world.", "");
        } else if (code == 3) {
            step = 3;
            anInt469 = 1;
        } else if (code == 4) {
            step = 12;
            anInt468 = 0;
        } else if (code == 5) {
            anInt469 = 2;
            PlayerAccountType.setLoginMessages("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
        } else if (code == 68 || !client.aBoolean927 && code == 6) {
            PlayerAccountType.setLoginMessages("RuneScape has been updated!", "Please reload this page.", "");
        } else if (code == 7) {
            PlayerAccountType.setLoginMessages("This world is full.", "Please use a different world.", "");
        } else if (code == 8) {
            PlayerAccountType.setLoginMessages("Unable to connect.", "Login server offline.", "");
        } else if (code == 9) {
            PlayerAccountType.setLoginMessages("Login limit exceeded.", "Too many connections from your address.", "");
        } else if (code == 10) {
            PlayerAccountType.setLoginMessages("Unable to connect.", "Bad session id.", "");
        } else if (code == 11) {
            PlayerAccountType.setLoginMessages("We suspect someone knows your password.", "Press 'change your password' on front page.", "");
        } else if (code == 12) {
            PlayerAccountType.setLoginMessages("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
        } else if (code == 13) {
            PlayerAccountType.setLoginMessages("Could not complete login.", "Please try using a different world.", "");
        } else if (code == 14) {
            PlayerAccountType.setLoginMessages("The server is being updated.", "Please wait 1 minute and try again.", "");
        } else if (code == 16) {
            PlayerAccountType.setLoginMessages("Too many login attempts.", "Please wait a few minutes before trying again.", "");
        } else if (code == 17) {
            PlayerAccountType.setLoginMessages("You are standing in a members-only area.", "To play on this world move to a free area first", "");
        } else if (code == 18) {
            step = 12;
            anInt468 = 1;
        } else if (code == 19) {
            PlayerAccountType.setLoginMessages("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
        } else if (code == 20) {
            PlayerAccountType.setLoginMessages("Invalid loginserver requested.", "Please try using a different world.", "");
        } else if (code == 22) {
            PlayerAccountType.setLoginMessages("Malformed login packet.", "Please try again.", "");
        } else if (code == 23) {
            PlayerAccountType.setLoginMessages("No reply from loginserver.", "Please wait 1 minute and try again.", "");
        } else if (code == 24) {
            PlayerAccountType.setLoginMessages("Error loading your profile.", "Please contact customer support.", "");
        } else if (code == 25) {
            PlayerAccountType.setLoginMessages("Unexpected loginserver response.", "Please try using a different world.", "");
        } else if (code == 26) {
            PlayerAccountType.setLoginMessages("This computers address has been blocked", "as it was used to break our rules.", "");
        } else if (code == 27) {
            PlayerAccountType.setLoginMessages("", "Service unavailable.", "");
        } else if (code == 31) {
            PlayerAccountType.setLoginMessages("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
        } else if (code == 32) {
            PlayerAccountType.setLoginMessages("Your attempt to log into your account was", "unsuccessful.  Don't worry, you can sort", "this out by visiting the billing system.");
        } else if (code == 37) {
            PlayerAccountType.setLoginMessages("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
        } else if (code == 38) {
            PlayerAccountType.setLoginMessages("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
        } else if (code == 55) {
            step = 8;
        } else {
            if (code == 56) {
                PlayerAccountType.setLoginMessages("Enter the 6-digit code generated by your", "authenticator app.", "");
                client.setGameState(11);
                return;
            }

            if (code == 57) {
                PlayerAccountType.setLoginMessages("The code you entered was incorrect.", "Please try again.", "");
                client.setGameState(11);
                return;
            }

            if (code == 61) {
                step = 7;
            } else {
                PlayerAccountType.setLoginMessages("Unexpected server response", "Please try using a different world.", "");
            }
        }

        client.setGameState(10);
    }
}
