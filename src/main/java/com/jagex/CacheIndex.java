package com.jagex;

import java.io.EOFException;
import java.io.IOException;

public final class CacheIndex {
    static byte[] aByteArray1984;

    static {
        aByteArray1984 = new byte[520];
    }

    BufferedFile aBufferedFile_1985;
    BufferedFile aBufferedFile_1983;
    int anInt1981;
    int anInt1982;

    public CacheIndex(int var1, BufferedFile var2, BufferedFile var3, int var4) {
        this.aBufferedFile_1985 = null;
        this.aBufferedFile_1983 = null;
        this.anInt1981 = 65000;
        this.anInt1982 = var1;
        this.aBufferedFile_1985 = var2;
        this.aBufferedFile_1983 = var3;
        this.anInt1981 = var4;
    }

    static void method1488(int var0) {
        if (var0 == -3) {
            Enum_Sub6.setLoginMessages("Connection timed out.", "Please try using a different world.", "");
        } else if (var0 == -2) {
            Enum_Sub6.setLoginMessages("", "Error connecting to server.", "");
        } else if (var0 == -1) {
            Enum_Sub6.setLoginMessages("No response from server.", "Please try using a different world.", "");
        } else if (var0 == 3) {
            Class55.loginState = 3;
            Class55.anInt469 = 1;
        } else if (var0 == 4) {
            Class55.loginState = 12;
            Class55.anInt468 = 0;
        } else if (var0 == 5) {
            Class55.anInt469 = 2;
            Enum_Sub6.setLoginMessages("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
        } else if (var0 == 68 || !client.aBoolean927 && var0 == 6) {
            Enum_Sub6.setLoginMessages("RuneScape has been updated!", "Please reload this page.", "");
        } else if (var0 == 7) {
            Enum_Sub6.setLoginMessages("This world is full.", "Please use a different world.", "");
        } else if (var0 == 8) {
            Enum_Sub6.setLoginMessages("Unable to connect.", "Login server offline.", "");
        } else if (var0 == 9) {
            Enum_Sub6.setLoginMessages("Login limit exceeded.", "Too many connections from your address.", "");
        } else if (var0 == 10) {
            Enum_Sub6.setLoginMessages("Unable to connect.", "Bad session id.", "");
        } else if (var0 == 11) {
            Enum_Sub6.setLoginMessages("We suspect someone knows your password.", "Press 'change your password' on front page.", "");
        } else if (var0 == 12) {
            Enum_Sub6.setLoginMessages("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
        } else if (var0 == 13) {
            Enum_Sub6.setLoginMessages("Could not complete login.", "Please try using a different world.", "");
        } else if (var0 == 14) {
            Enum_Sub6.setLoginMessages("The server is being updated.", "Please wait 1 minute and try again.", "");
        } else if (var0 == 16) {
            Enum_Sub6.setLoginMessages("Too many login attempts.", "Please wait a few minutes before trying again.", "");
        } else if (var0 == 17) {
            Enum_Sub6.setLoginMessages("You are standing in a members-only area.", "To play on this world move to a free area first", "");
        } else if (var0 == 18) {
            Class55.loginState = 12;
            Class55.anInt468 = 1;
        } else if (var0 == 19) {
            Enum_Sub6.setLoginMessages("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
        } else if (var0 == 20) {
            Enum_Sub6.setLoginMessages("Invalid loginserver requested.", "Please try using a different world.", "");
        } else if (var0 == 22) {
            Enum_Sub6.setLoginMessages("Malformed login packet.", "Please try again.", "");
        } else if (var0 == 23) {
            Enum_Sub6.setLoginMessages("No reply from loginserver.", "Please wait 1 minute and try again.", "");
        } else if (var0 == 24) {
            Enum_Sub6.setLoginMessages("Error loading your profile.", "Please contact customer support.", "");
        } else if (var0 == 25) {
            Enum_Sub6.setLoginMessages("Unexpected loginserver response.", "Please try using a different world.", "");
        } else if (var0 == 26) {
            Enum_Sub6.setLoginMessages("This computers address has been blocked", "as it was used to break our rules.", "");
        } else if (var0 == 27) {
            Enum_Sub6.setLoginMessages("", "Service unavailable.", "");
        } else if (var0 == 31) {
            Enum_Sub6.setLoginMessages("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
        } else if (var0 == 32) {
            Enum_Sub6.setLoginMessages("Your attempt to log into your account was", "unsuccessful.  Don't worry, you can sort", "this out by visiting the billing system.");
        } else if (var0 == 37) {
            Enum_Sub6.setLoginMessages("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
        } else if (var0 == 38) {
            Enum_Sub6.setLoginMessages("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
        } else if (var0 == 55) {
            Class55.loginState = 8;
        } else {
            if (var0 == 56) {
                Enum_Sub6.setLoginMessages("Enter the 6-digit code generated by your", "authenticator app.", "");
                MouseRecorder.setGameState(11);
                return;
            }

            if (var0 == 57) {
                Enum_Sub6.setLoginMessages("The code you entered was incorrect.", "Please try again.", "");
                MouseRecorder.setGameState(11);
                return;
            }

            if (var0 == 61) {
                Class55.loginState = 7;
            } else {
                Enum_Sub6.setLoginMessages("Unexpected server response", "Please try using a different world.", "");
            }
        }

        MouseRecorder.setGameState(10);
    }

    static void method1489(Buffer var0, int var1) {
        Class45.createRandom(var0.payload, var1);
        AudioRunnable.method986(var0, var1);
    }

    public static int method1491(Buffer var0, String var1) {
        int var2 = var0.caret;
        byte[] var3 = AssociateComparatorByWorld.method680(var1);
        var0.writeSmart(var3.length);
        var0.caret += Statics19.aClass166_1261.method951(var3, 0, var3.length, var0.payload, var0.caret);
        return var0.caret - var2;
    }

    boolean method1487(int var1, byte[] var2, int var3, boolean var4) {
        synchronized (this.aBufferedFile_1985) {
            try {
                int var6;
                boolean var10000;
                if (var4) {
                    if (this.aBufferedFile_1983.method1409() < (long) (var1 * 6 + 6)) {
                        var10000 = false;
                        return var10000;
                    }

                    this.aBufferedFile_1983.seek((long) (var1 * 6));
                    this.aBufferedFile_1983.read(aByteArray1984, 0, 6);
                    var6 = (aByteArray1984[5] & 255) + ((aByteArray1984[3] & 255) << 16) + ((aByteArray1984[4] & 255) << 8);
                    if (var6 <= 0 || (long) var6 > this.aBufferedFile_1985.method1409() / 520L) {
                        var10000 = false;
                        return var10000;
                    }
                } else {
                    var6 = (int) ((this.aBufferedFile_1985.method1409() + 519L) / 520L);
                    if (var6 == 0) {
                        var6 = 1;
                    }
                }

                aByteArray1984[0] = (byte) (var3 >> 16);
                aByteArray1984[1] = (byte) (var3 >> 8);
                aByteArray1984[2] = (byte) var3;
                aByteArray1984[3] = (byte) (var6 >> 16);
                aByteArray1984[4] = (byte) (var6 >> 8);
                aByteArray1984[5] = (byte) var6;
                this.aBufferedFile_1983.seek((long) (var1 * 6));
                this.aBufferedFile_1983.write(aByteArray1984, 0, 6);
                int var7 = 0;
                int var8 = 0;

                while (true) {
                    if (var7 < var3) {
                        label171:
                        {
                            int var9 = 0;
                            int var11;
                            if (var4) {
                                this.aBufferedFile_1985.seek(520L * (long) var6);
                                int var12;
                                int var13;
                                if (var1 > 65535) {
                                    try {
                                        this.aBufferedFile_1985.read(aByteArray1984, 0, 10);
                                    } catch (EOFException var17) {
                                        break label171;
                                    }

                                    var11 = ((aByteArray1984[1] & 255) << 16) + ((aByteArray1984[0] & 255) << 24) + (aByteArray1984[3] & 255) + ((aByteArray1984[2] & 255) << 8);
                                    var12 = (aByteArray1984[5] & 255) + ((aByteArray1984[4] & 255) << 8);
                                    var9 = (aByteArray1984[8] & 255) + ((aByteArray1984[7] & 255) << 8) + ((aByteArray1984[6] & 255) << 16);
                                    var13 = aByteArray1984[9] & 255;
                                } else {
                                    try {
                                        this.aBufferedFile_1985.read(aByteArray1984, 0, 8);
                                    } catch (EOFException var16) {
                                        break label171;
                                    }

                                    var11 = (aByteArray1984[1] & 255) + ((aByteArray1984[0] & 255) << 8);
                                    var12 = (aByteArray1984[3] & 255) + ((aByteArray1984[2] & 255) << 8);
                                    var9 = ((aByteArray1984[5] & 255) << 8) + ((aByteArray1984[4] & 255) << 16) + (aByteArray1984[6] & 255);
                                    var13 = aByteArray1984[7] & 255;
                                }

                                if (var11 != var1 || var8 != var12 || var13 != this.anInt1982) {
                                    var10000 = false;
                                    return var10000;
                                }

                                if (var9 < 0 || (long) var9 > this.aBufferedFile_1985.method1409() / 520L) {
                                    var10000 = false;
                                    return var10000;
                                }
                            }

                            if (var9 == 0) {
                                var4 = false;
                                var9 = (int) ((this.aBufferedFile_1985.method1409() + 519L) / 520L);
                                if (var9 == 0) {
                                    ++var9;
                                }

                                if (var9 == var6) {
                                    ++var9;
                                }
                            }

                            if (var1 > 65535) {
                                if (var3 - var7 <= 510) {
                                    var9 = 0;
                                }

                                aByteArray1984[0] = (byte) (var1 >> 24);
                                aByteArray1984[1] = (byte) (var1 >> 16);
                                aByteArray1984[2] = (byte) (var1 >> 8);
                                aByteArray1984[3] = (byte) var1;
                                aByteArray1984[4] = (byte) (var8 >> 8);
                                aByteArray1984[5] = (byte) var8;
                                aByteArray1984[6] = (byte) (var9 >> 16);
                                aByteArray1984[7] = (byte) (var9 >> 8);
                                aByteArray1984[8] = (byte) var9;
                                aByteArray1984[9] = (byte) this.anInt1982;
                                this.aBufferedFile_1985.seek(520L * (long) var6);
                                this.aBufferedFile_1985.write(aByteArray1984, 0, 10);
                                var11 = var3 - var7;
                                if (var11 > 510) {
                                    var11 = 510;
                                }

                                this.aBufferedFile_1985.write(var2, var7, var11);
                                var7 += var11;
                            } else {
                                if (var3 - var7 <= 512) {
                                    var9 = 0;
                                }

                                aByteArray1984[0] = (byte) (var1 >> 8);
                                aByteArray1984[1] = (byte) var1;
                                aByteArray1984[2] = (byte) (var8 >> 8);
                                aByteArray1984[3] = (byte) var8;
                                aByteArray1984[4] = (byte) (var9 >> 16);
                                aByteArray1984[5] = (byte) (var9 >> 8);
                                aByteArray1984[6] = (byte) var9;
                                aByteArray1984[7] = (byte) this.anInt1982;
                                this.aBufferedFile_1985.seek((long) var6 * 520L);
                                this.aBufferedFile_1985.write(aByteArray1984, 0, 8);
                                var11 = var3 - var7;
                                if (var11 > 512) {
                                    var11 = 512;
                                }

                                this.aBufferedFile_1985.write(var2, var7, var11);
                                var7 += var11;
                            }

                            var6 = var9;
                            ++var8;
                            continue;
                        }
                    }

                    var10000 = true;
                    return var10000;
                }
            } catch (IOException var18) {
                return false;
            }
        }
    }

    public boolean method1492(int var1, byte[] var2, int var3) {
        synchronized (this.aBufferedFile_1985) {
            if (var3 >= 0 && var3 <= this.anInt1981) {
                boolean var5 = this.method1487(var1, var2, var3, true);
                if (!var5) {
                    var5 = this.method1487(var1, var2, var3, false);
                }

                return var5;
            }
            throw new IllegalArgumentException("" + this.anInt1982 + ',' + var1 + ',' + var3);
        }
    }

    public byte[] method1490(int var1) {
        synchronized (this.aBufferedFile_1985) {
            try {
                Object var10000;
                if (this.aBufferedFile_1983.method1409() < (long) (var1 * 6 + 6)) {
                    var10000 = null;
                    return (byte[]) var10000;
                }
                this.aBufferedFile_1983.seek((long) (var1 * 6));
                this.aBufferedFile_1983.read(aByteArray1984, 0, 6);
                int var3 = ((aByteArray1984[0] & 255) << 16) + (aByteArray1984[2] & 255) + ((aByteArray1984[1] & 255) << 8);
                int var4 = (aByteArray1984[5] & 255) + ((aByteArray1984[3] & 255) << 16) + ((aByteArray1984[4] & 255) << 8);
                if (var3 < 0 || var3 > this.anInt1981) {
                    var10000 = null;
                    return (byte[]) var10000;
                }
                if (var4 <= 0 || (long) var4 > this.aBufferedFile_1985.method1409() / 520L) {
                    var10000 = null;
                    return (byte[]) var10000;
                }
                byte[] var5 = new byte[var3];
                int var6 = 0;
                int var7 = 0;

                while (var6 < var3) {
                    if (var4 == 0) {
                        var10000 = null;
                        return (byte[]) var10000;
                    }

                    this.aBufferedFile_1985.seek((long) var4 * 520L);
                    int var8 = var3 - var6;
                    byte var9;
                    int var10;
                    int var11;
                    int var12;
                    int var13;
                    if (var1 > 65535) {
                        if (var8 > 510) {
                            var8 = 510;
                        }

                        var9 = 10;
                        this.aBufferedFile_1985.read(aByteArray1984, 0, var8 + var9);
                        var10 = ((aByteArray1984[1] & 255) << 16) + ((aByteArray1984[0] & 255) << 24) + (aByteArray1984[3] & 255) + ((aByteArray1984[2] & 255) << 8);
                        var11 = (aByteArray1984[5] & 255) + ((aByteArray1984[4] & 255) << 8);
                        var12 = (aByteArray1984[8] & 255) + ((aByteArray1984[7] & 255) << 8) + ((aByteArray1984[6] & 255) << 16);
                        var13 = aByteArray1984[9] & 255;
                    } else {
                        if (var8 > 512) {
                            var8 = 512;
                        }

                        var9 = 8;
                        this.aBufferedFile_1985.read(aByteArray1984, 0, var8 + var9);
                        var10 = (aByteArray1984[1] & 255) + ((aByteArray1984[0] & 255) << 8);
                        var11 = (aByteArray1984[3] & 255) + ((aByteArray1984[2] & 255) << 8);
                        var12 = ((aByteArray1984[5] & 255) << 8) + ((aByteArray1984[4] & 255) << 16) + (aByteArray1984[6] & 255);
                        var13 = aByteArray1984[7] & 255;
                    }

                    if (var10 == var1 && var11 == var7 && var13 == this.anInt1982) {
                        if (var12 >= 0 && (long) var12 <= this.aBufferedFile_1985.method1409() / 520L) {
                            int var14 = var9 + var8;

                            for (int var15 = var9; var15 < var14; ++var15) {
                                var5[var6++] = aByteArray1984[var15];
                            }

                            var4 = var12;
                            ++var7;
                            continue;
                        }

                        var10000 = null;
                        return (byte[]) var10000;
                    }

                    var10000 = null;
                    return (byte[]) var10000;
                }

                return var5;
            } catch (IOException var18) {
                return null;
            }
        }
    }

    public String toString() {
        return "" + this.anInt1982;
    }
}
