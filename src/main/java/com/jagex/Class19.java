package com.jagex;

import java.io.*;
import java.util.*;
import java.util.LinkedList;

public final class Class19 {
    protected static String aString264;
    final HashMap aHashMap262;
    final ReferenceTable aReferenceTable275;
    final ReferenceTable aReferenceTable265;
    public int anInt274;
    boolean aBoolean267;
    Sprite aSprite272;
    boolean aBoolean276;
    HashMap aHashMap271;
    int anInt261;
    int anInt268;
    Class7[][] aClass7ArrayArray269;
    HashMap aHashMap270;
    DoublyLinkedNode_Sub24_Sub4[] aDoublyNode_Sub24_Sub4Array266;
    Class9_Sub1 aClass9_Sub1_273;
    int anInt260;
    int anInt263;

    public Class19(DoublyLinkedNode_Sub24_Sub4[] var1, HashMap var2, ReferenceTable var3, ReferenceTable var4) {
        this.aBoolean276 = false;
        this.aBoolean267 = false;
        this.aHashMap270 = new HashMap();
        this.anInt274 = 0;
        this.aDoublyNode_Sub24_Sub4Array266 = var1;
        this.aHashMap262 = var2;
        this.aReferenceTable275 = var3;
        this.aReferenceTable265 = var4;
    }

    static String method143(Throwable var0) throws IOException {
        StringBuilder var2;
        if (var0 instanceof Jagception) {
            Jagception var1 = (Jagception) var0;
            var2 = new StringBuilder(var1.message + " | ");
            var0 = var1.throwable;
        } else {
            var2 = new StringBuilder();
        }

        StringWriter var12 = new StringWriter();
        PrintWriter var3 = new PrintWriter(var12);
        var0.printStackTrace(var3);
        var3.close();
        String var4 = var12.toString();
        BufferedReader var5 = new BufferedReader(new StringReader(var4));
        String var6 = var5.readLine();

        while (true) {
            while (true) {
                String var7 = var5.readLine();
                if (var7 == null) {
                    var2.append("| ").append(var6);
                    return var2.toString();
                }

                int var8 = var7.indexOf(40);
                int var9 = var7.indexOf(41, var8 + 1);
                if (var8 >= 0 && var9 >= 0) {
                    String var10 = var7.substring(var8 + 1, var9);
                    int var11 = var10.indexOf(".java:");
                    if (var11 >= 0) {
                        var10 = var10.substring(0, var11) + var10.substring(var11 + 5);
                        var2.append(var10).append(' ');
                        continue;
                    }

                    var7 = var7.substring(0, var8);
                }

                var7 = var7.trim();
                var7 = var7.substring(var7.lastIndexOf(32) + 1);
                var7 = var7.substring(var7.lastIndexOf(9) + 1);
                var2.append(var7).append(' ');
            }
        }
    }

    static void method146(int var0) {
        if (Class63_Sub2.loadInterface(var0)) {
            InterfaceComponent[] var1 = AssociateComparator_Sub5.interfaces[var0];

            for (InterfaceComponent var3 : var1) {
                if (var3 != null) {
                    var3.anInt1389 = 0;
                    var3.anInt1401 = 0;
                }
            }

        }
    }

    static InterfaceNode method147(int var0, int var1, int var2) {
        InterfaceNode var3 = new InterfaceNode();
        var3.id = var1;
        var3.state = var2;
        client.interfaceNodes.put(var3, (long) var0);
        method146(var1);
        InterfaceComponent var4 = InterfaceComponent.lookup(var0);
        Enum_Sub2.repaintComponent(var4);
        if (client.pleaseWaitComponent != null) {
            Enum_Sub2.repaintComponent(client.pleaseWaitComponent);
            client.pleaseWaitComponent = null;
        }

        Class53.method317();
        GameEngine.method925(AssociateComparator_Sub5.interfaces[var0 >> 16], var4, false);
        Statics9.method796(var1);
        if (client.rootInterfaceIndex != -1) {
            Class16.method118(client.rootInterfaceIndex, 1);
        }

        return var3;
    }

    static void updatePlayers(PacketBuffer packet, int var1) {
        int var2 = packet.caret;
        GPI.anInt594 = 0;
        int var3 = 0;
        packet.bitAccess();

        int var4;
        int var5;
        int var6;
        int var7;
        int var8;
        byte[] var10000;
        for (var4 = 0; var4 < GPI.playerCount; ++var4) {
            var5 = GPI.playerIndices[var4];
            if ((GPI.playerSkipFlags[var5] & 1) == 0) {
                if (var3 > 0) {
                    --var3;
                    var10000 = GPI.playerSkipFlags;
                    var10000[var5] = (byte) (var10000[var5] | 2);
                } else {
                    var6 = packet.method1398(1);
                    if (var6 == 0) {
                        var7 = packet.method1398(2);
                        if (var7 == 0) {
                            var8 = 0;
                        } else if (var7 == 1) {
                            var8 = packet.method1398(5);
                        } else if (var7 == 2) {
                            var8 = packet.method1398(8);
                        } else {
                            var8 = packet.method1398(11);
                        }

                        var3 = var8;
                        var10000 = GPI.playerSkipFlags;
                        var10000[var5] = (byte) (var10000[var5] | 2);
                    } else {
                        Class105.updatePlayerLocation(packet, var5);
                    }
                }
            }
        }

        packet.byteAccess();
        if (var3 != 0) {
            throw new RuntimeException();
        }
        packet.bitAccess();

        for (var4 = 0; var4 < GPI.playerCount; ++var4) {
            var5 = GPI.playerIndices[var4];
            if ((GPI.playerSkipFlags[var5] & 1) != 0) {
                if (var3 > 0) {
                    --var3;
                    var10000 = GPI.playerSkipFlags;
                    var10000[var5] = (byte) (var10000[var5] | 2);
                } else {
                    var6 = packet.method1398(1);
                    if (var6 == 0) {
                        var7 = packet.method1398(2);
                        if (var7 == 0) {
                            var8 = 0;
                        } else if (var7 == 1) {
                            var8 = packet.method1398(5);
                        } else if (var7 == 2) {
                            var8 = packet.method1398(8);
                        } else {
                            var8 = packet.method1398(11);
                        }

                        var3 = var8;
                        var10000 = GPI.playerSkipFlags;
                        var10000[var5] = (byte) (var10000[var5] | 2);
                    } else {
                        Class105.updatePlayerLocation(packet, var5);
                    }
                }
            }
        }

        packet.byteAccess();
        if (var3 != 0) {
            throw new RuntimeException();
        }
        packet.bitAccess();

        for (var4 = 0; var4 < GPI.globalPlayerCount; ++var4) {
            var5 = GPI.globalPlayerIndices[var4];
            if ((GPI.playerSkipFlags[var5] & 1) != 0) {
                if (var3 > 0) {
                    --var3;
                    var10000 = GPI.playerSkipFlags;
                    var10000[var5] = (byte) (var10000[var5] | 2);
                } else {
                    var6 = packet.method1398(1);
                    if (var6 == 0) {
                        var7 = packet.method1398(2);
                        if (var7 == 0) {
                            var8 = 0;
                        } else if (var7 == 1) {
                            var8 = packet.method1398(5);
                        } else if (var7 == 2) {
                            var8 = packet.method1398(8);
                        } else {
                            var8 = packet.method1398(11);
                        }

                        var3 = var8;
                        var10000 = GPI.playerSkipFlags;
                        var10000[var5] = (byte) (var10000[var5] | 2);
                    } else if (Statics34.method1168(packet, var5)) {
                        var10000 = GPI.playerSkipFlags;
                        var10000[var5] = (byte) (var10000[var5] | 2);
                    }
                }
            }
        }

        packet.byteAccess();
        if (var3 != 0) {
            throw new RuntimeException();
        }
        packet.bitAccess();

        for (var4 = 0; var4 < GPI.globalPlayerCount; ++var4) {
            var5 = GPI.globalPlayerIndices[var4];
            if ((GPI.playerSkipFlags[var5] & 1) == 0) {
                if (var3 > 0) {
                    --var3;
                    var10000 = GPI.playerSkipFlags;
                    var10000[var5] = (byte) (var10000[var5] | 2);
                } else {
                    var6 = packet.method1398(1);
                    if (var6 == 0) {
                        var7 = packet.method1398(2);
                        if (var7 == 0) {
                            var8 = 0;
                        } else if (var7 == 1) {
                            var8 = packet.method1398(5);
                        } else if (var7 == 2) {
                            var8 = packet.method1398(8);
                        } else {
                            var8 = packet.method1398(11);
                        }

                        var3 = var8;
                        var10000 = GPI.playerSkipFlags;
                        var10000[var5] = (byte) (var10000[var5] | 2);
                    } else if (Statics34.method1168(packet, var5)) {
                        var10000 = GPI.playerSkipFlags;
                        var10000[var5] = (byte) (var10000[var5] | 2);
                    }
                }
            }
        }

        packet.byteAccess();
        if (var3 != 0) {
            throw new RuntimeException();
        }
        GPI.playerCount = 0;
        GPI.globalPlayerCount = 0;

        PlayerEntity player;
        for (var4 = 1; var4 < 2048; ++var4) {
            var10000 = GPI.playerSkipFlags;
            var10000[var4] = (byte) (var10000[var4] >> 1);
            player = client.players[var4];
            if (player != null) {
                GPI.playerIndices[++GPI.playerCount - 1] = var4;
            } else {
                GPI.globalPlayerIndices[++GPI.globalPlayerCount - 1] = var4;
            }
        }

        for (var3 = 0; var3 < GPI.anInt594; ++var3) {
            var4 = GPI.anIntArray588[var3];
            player = client.players[var4];
            var6 = packet.readUByte();
            if ((var6 & 0x1) != 0) {
                var6 += packet.readUByte() << 8;
            }

            byte var9 = -1;
            if ((var6 & 0x100) != 0) {
                for (var7 = 0; var7 < 3; ++var7) {
                    player.actions[var7] = packet.readString();
                }
            }

            if ((var6 & 0x800) != 0) {
                player.graphic = packet.readUShort();
                var7 = packet.readInt();
                player.anInt2014 = var7 >> 16;
                player.graphicDelay = (var7 & 65535) + client.engineCycle;
                player.anInt2017 = 0;
                player.anInt2013 = 0;
                if (player.graphicDelay > client.engineCycle) {
                    player.anInt2017 = -1;
                }

                if (player.graphic == 65535) {
                    player.graphic = -1;
                }
            }

            if ((var6 & 0x2) != 0) {
                player.overheadText = packet.readString();
                if (player.overheadText.charAt(0) == '~') {
                    player.overheadText = player.overheadText.substring(1);
                    Statics19.messageReceived(2, player.namePair.getRaw(), player.overheadText);
                } else if (player == PlayerEntity.local) {
                    Statics19.messageReceived(2, player.namePair.getRaw(), player.overheadText);
                }

                player.aBoolean2008 = false;
                player.anInt1508 = 0;
                player.anInt1510 = 0;
                player.anInt1344 = 150;
            }

            if ((var6 & 0x8) != 0) {
                var7 = packet.method1072();
                byte[] var11 = new byte[var7];
                Buffer var12 = new Buffer(var11);
                packet.method1016(var11, 0, var7);
                GPI.buffers[var4] = var12;
                player.decode(var12);
            }

            int var14;
            int var15;
            int var18;
            if ((var6 & 0x80) != 0) {
                var7 = packet.readUShort();
                Enum_Sub6 var20 = (Enum_Sub6) OldConnection.method716(Statics13.method871(), packet.readUByte());
                boolean var13 = packet.method1072() == 1;
                var14 = packet.method1072();
                var15 = packet.caret;
                if (player.namePair != null && player.appearance != null) {
                    boolean var16 = false;
                    if (var20.aBoolean1258 && Class44.socialSystem.isOnIgnoreList(player.namePair)) {
                        var16 = true;
                    }

                    if (!var16 && client.anInt1014 == 0 && !player.hidden) {
                        GPI.chatBuffer.caret = 0;
                        packet.method1012(GPI.chatBuffer.payload, 0, var14);
                        GPI.chatBuffer.caret = 0;
                        String var17 = DoublyLinkedNode_Sub24_Sub3.method1166(OldConnection.method714(Class123_Sub1.method294(GPI.chatBuffer)));
                        player.overheadText = var17.trim();
                        player.anInt1508 = var7 >> 8;
                        player.anInt1510 = var7 & 255;
                        player.anInt1344 = 150;
                        player.aBoolean2008 = var13;
                        player.aBoolean2005 = player != PlayerEntity.local && var20.aBoolean1258 && "" != client.aString1091 && !var17.toLowerCase().contains(client.aString1091);
                        if (var20.aBoolean1257) {
                            var18 = var13 ? 91 : 1;
                        } else {
                            var18 = var13 ? 90 : 2;
                        }

                        if (var20.anInt1218 != -1) {
                            Statics19.messageReceived(var18, Statics26.method1111(var20.anInt1218) + player.namePair.getRaw(), var17);
                        } else {
                            Statics19.messageReceived(var18, player.namePair.getRaw(), var17);
                        }
                    }
                }

                packet.caret = var14 + var15;
            }

            if ((var6 & 0x1000) != 0) {
                GPI.aByteArray596[var4] = packet.readByte();
            }

            if ((var6 & 0x10) != 0) {
                var7 = packet.method1060();
                if (var7 == 65535) {
                    var7 = -1;
                }

                var8 = packet.readUByte();
                LoginPacketMeta.method1497(player, var7, var8);
            }

            if ((var6 & 0x200) != 0) {
                var9 = packet.readByte();
            }

            if ((var6 & 0x400) != 0) {
                player.anInt1354 = packet.method1063();
                player.anInt2011 = packet.method1059();
                player.anInt1351 = packet.method1063();
                player.anInt2016 = packet.method1063();
                player.forceMovementStartCycle = packet.readUShort() + client.engineCycle;
                player.forceMovementEndCycle = packet.method1060() + client.engineCycle;
                player.anInt2019 = packet.method1055();
                if (player.aBoolean1904) {
                    player.anInt1354 += player.anInt704;
                    player.anInt2011 += player.anInt1739;
                    player.anInt1351 += player.anInt704;
                    player.anInt2016 += player.anInt1739;
                    player.pathQueueSize = 0;
                } else {
                    player.anInt1354 += player.pathXQueue[0];
                    player.anInt2011 += player.pathYQueue[0];
                    player.anInt1351 += player.pathXQueue[0];
                    player.anInt2016 += player.pathYQueue[0];
                    player.pathQueueSize = 1;
                }

                player.anInt2023 = 0;
            }

            if ((var6 & 0x4) != 0) {
                var7 = packet.method1056();
                int var19;
                int var22;
                int var23;
                if (var7 > 0) {
                    for (var8 = 0; var8 < var7; ++var8) {
                        var14 = -1;
                        var15 = -1;
                        var23 = -1;
                        var22 = packet.readSmart();
                        if (var22 == 32767) {
                            var22 = packet.readSmart();
                            var15 = packet.readSmart();
                            var14 = packet.readSmart();
                            var23 = packet.readSmart();
                        } else if (var22 != 32766) {
                            var15 = packet.readSmart();
                        } else {
                            var22 = -1;
                        }

                        var19 = packet.readSmart();
                        player.addHitSplat(var22, var15, var14, var23, client.engineCycle, var19);
                    }
                }

                var8 = packet.method1074();
                if (var8 > 0) {
                    for (var22 = 0; var22 < var8; ++var22) {
                        var14 = packet.readSmart();
                        var15 = packet.readSmart();
                        if (var15 != 32767) {
                            var23 = packet.readSmart();
                            var19 = packet.method1056();
                            var18 = var15 > 0 ? packet.method1056() : var19;
                            player.updateHealthBar(var14, client.engineCycle, var15, var23, var19, var18);
                        } else {
                            player.method1503(var14);
                        }
                    }
                }
            }

            if ((var6 & 0x40) != 0) {
                player.targetIndex = packet.method1060();
                if (player.targetIndex == 65535) {
                    player.targetIndex = -1;
                }
            }

            if ((var6 & 0x20) != 0) {
                player.transformedOrienation = packet.readUShort();
                if (player.pathQueueSize == 0) {
                    player.orientation = player.transformedOrienation;
                    player.transformedOrienation = -1;
                }
            }

            if (player.aBoolean1904) {
                if (var9 == 127) {
                    player.method1414(player.anInt704, player.anInt1739);
                } else {
                    byte var21;
                    if (var9 != -1) {
                        var21 = var9;
                    } else {
                        var21 = GPI.aByteArray596[var4];
                    }

                    player.method1415(player.anInt704, player.anInt1739, var21);
                }
            }
        }

        if (packet.caret - var2 != var1) {
            throw new RuntimeException(packet.caret - var2 + " " + var1);
        }
    }

    void method134() {
        if (this.aHashMap271 == null) {
            this.aHashMap271 = new HashMap();
        }

        this.aHashMap271.clear();

        for (Class7[] anAClass7ArrayArray269 : this.aClass7ArrayArray269) {
            for (Class7 anAnAClass7ArrayArray269 : anAClass7ArrayArray269) {
                List var3 = anAnAClass7ArrayArray269.method36();

                for (Object aVar3 : var3) {
                    Class27 var5 = (Class27) aVar3;
                    if (var5.method195()) {
                        int var6 = var5.method199();
                        if (!this.aHashMap271.containsKey(var6)) {
                            LinkedList var7 = new LinkedList();
                            var7.add(var5);
                            this.aHashMap271.put(var6, var7);
                        } else {
                            List var8 = (List) this.aHashMap271.get(var6);
                            var8.add(var5);
                        }
                    }
                }
            }
        }

    }

    Class68 method139(int var1, int var2, int var3, int var4) {
        Class68 var5 = new Class68(this);
        int var6 = this.anInt261 * 4096 + var1;
        int var7 = this.anInt268 * 4096 + var2;
        int var8 = var3 + this.anInt261 * 4096;
        int var9 = this.anInt268 * 4096 + var4;
        int var10 = var6 / 64;
        int var11 = var7 / 64;
        int var12 = var8 / 64;
        int var13 = var9 / 64;
        var5.anInt539 = var12 - var10 + 1;
        var5.anInt540 = var13 - var11 + 1;
        var5.anInt538 = var10 - this.aClass9_Sub1_273.method66();
        var5.anInt537 = var11 - this.aClass9_Sub1_273.method85();
        if (var5.anInt538 < 0) {
            var5.anInt539 += var5.anInt538;
            var5.anInt538 = 0;
        }

        if (var5.anInt538 > this.aClass7ArrayArray269.length - var5.anInt539) {
            var5.anInt539 = this.aClass7ArrayArray269.length - var5.anInt538;
        }

        if (var5.anInt537 < 0) {
            var5.anInt540 += var5.anInt537;
            var5.anInt537 = 0;
        }

        if (var5.anInt537 > this.aClass7ArrayArray269[0].length - var5.anInt540) {
            var5.anInt540 = this.aClass7ArrayArray269[0].length - var5.anInt537;
        }

        var5.anInt539 = Math.min(var5.anInt539, this.aClass7ArrayArray269.length);
        var5.anInt540 = Math.min(var5.anInt540, this.aClass7ArrayArray269[0].length);
        return var5;
    }

    float method133(int var1, int var2) {
        float var3 = (float) var1 / (float) var2;
        if (var3 > 8.0F) {
            return 8.0F;
        }
        if (var3 < 1.0F) {
            return 1.0F;
        }
        int var4 = Math.round(var3);
        return Math.abs((float) var4 - var3) < 0.05F ? (float) var4 : var3;
    }

    public boolean method135() {
        return this.aBoolean276;
    }

    public HashMap method144() {
        this.method134();
        return this.aHashMap271;
    }

    public void method140(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
        if (this.aSprite272 != null) {
            this.aSprite272.method807(var1, var2, var3, var4);
            if (var6 > 0 && var6 % var7 < var7 / 2) {
                if (this.aHashMap271 == null) {
                    this.method134();
                }

                Iterator var8 = var5.iterator();

                while (true) {
                    List var10;
                    do {
                        if (!var8.hasNext()) {
                            return;
                        }

                        int var9 = (Integer) var8.next();
                        var10 = (List) this.aHashMap271.get(var9);
                    } while (var10 == null);

                    for (Object aVar10 : var10) {
                        Class27 var12 = (Class27) aVar10;
                        int var13 = var3 * (var12.aSceneOffset313.anInt1891 - this.anInt261 * 4096) / (this.anInt260 * 4096);
                        int var14 = var4 - (var12.aSceneOffset313.anInt1892 - this.anInt268 * 4096) * var4 / (this.anInt263 * 4096);
                        JagGraphics.method1367(var13 + var1, var14 + var2, 2, 16776960, 256);
                    }
                }
            }
        }
    }

    public void method145(ReferenceTable var1, String var2, boolean var3) {
        if (!this.aBoolean267) {
            this.aBoolean276 = false;
            this.aBoolean267 = true;
            System.nanoTime();
            int var4 = var1.method900(Class23.aClass23_297.aString292);
            int var5 = var1.method907(var4, var2);
            Buffer var6 = new Buffer(var1.method897(Class23.aClass23_297.aString292, var2));
            Buffer var7 = new Buffer(var1.method897(Class23.aClass23_298.aString292, var2));
            System.nanoTime();
            System.nanoTime();
            this.aClass9_Sub1_273 = new Class9_Sub1();

            try {
                this.aClass9_Sub1_273.method172(var6, var7, var5, var3);
            } catch (IllegalStateException var19) {
                return;
            }

            this.aClass9_Sub1_273.method82();
            this.aClass9_Sub1_273.method71();
            this.aClass9_Sub1_273.method74();
            this.anInt261 = this.aClass9_Sub1_273.method66() * 64;
            this.anInt268 = this.aClass9_Sub1_273.method85() * 64;
            this.anInt260 = (this.aClass9_Sub1_273.method70() - this.aClass9_Sub1_273.method66() + 1) * 64;
            this.anInt263 = (this.aClass9_Sub1_273.method72() - this.aClass9_Sub1_273.method85() + 1) * 64;
            int var9 = this.aClass9_Sub1_273.method70() - this.aClass9_Sub1_273.method66() + 1;
            int var10 = this.aClass9_Sub1_273.method72() - this.aClass9_Sub1_273.method85() + 1;
            System.nanoTime();
            System.nanoTime();
            Class85.method453();
            this.aClass7ArrayArray269 = new Class7[var9][var10];

            for (Object anAHashSet291 : this.aClass9_Sub1_273.aHashSet291) {
                Class63_Sub2 var12 = (Class63_Sub2) anAHashSet291;
                int var13 = var12.anInt517;
                int var14 = var12.anInt516;
                int var15 = var13 - this.aClass9_Sub1_273.method66();
                int var16 = var14 - this.aClass9_Sub1_273.method85();
                this.aClass7ArrayArray269[var15][var16] = new Class7(var13, var14, this.aClass9_Sub1_273.method67(), this.aHashMap262);
                this.aClass7ArrayArray269[var15][var16].method54(var12, this.aClass9_Sub1_273.aList290);
            }

            for (int var17 = 0; var17 < var9; ++var17) {
                for (int var18 = 0; var18 < var10; ++var18) {
                    if (this.aClass7ArrayArray269[var17][var18] == null) {
                        this.aClass7ArrayArray269[var17][var18] = new Class7(this.aClass9_Sub1_273.method66() + var17, this.aClass9_Sub1_273.method85() + var18, this.aClass9_Sub1_273.method67(), this.aHashMap262);
                        this.aClass7ArrayArray269[var17][var18].method52(this.aClass9_Sub1_273.aHashSet289, this.aClass9_Sub1_273.aList290);
                    }
                }
            }

            System.nanoTime();
            System.nanoTime();
            if (var1.method906(Class23.aClass23_295.aString292, var2)) {
                byte[] var20 = var1.method897(Class23.aClass23_295.aString292, var2);
                this.aSprite272 = Class16.method130(var20);
            }

            System.nanoTime();
            var1.method903();
            var1.method902();
            this.aBoolean276 = true;
        }
    }

    public List method138(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
        java.util.LinkedList var11 = new java.util.LinkedList();
        if (!this.aBoolean276) {
            return var11;
        }
        Class68 var12 = this.method139(var1, var2, var3, var4);
        float var13 = this.method133(var7, var3 - var1);
        int var14 = (int) (var13 * 64.0F);
        int var15 = this.anInt261 * 4096 + var1;
        int var16 = this.anInt268 * 4096 + var2;

        for (int var17 = var12.anInt538; var17 < var12.anInt538 + var12.anInt539; ++var17) {
            for (int var18 = var12.anInt537; var18 < var12.anInt537 + var12.anInt540; ++var18) {
                List var19 = this.aClass7ArrayArray269[var17][var18].method44(var5 + var14 * (this.aClass7ArrayArray269[var17][var18].anInt115 * 64 - var15) / 64, var8 + var6 - var14 * (this.aClass7ArrayArray269[var17][var18].anInt116 * 64 - var16 + 64) / 64, var14, var9, var10);
                if (!var19.isEmpty()) {
                    var11.addAll(var19);
                }
            }
        }

        return var11;
    }

    public final void method136() {
        this.aHashMap271 = null;
    }

    public final void method142(int var1, int var2, int var3, int var4, int var5, int var7, int var8) {
        int[] var9 = JagGraphics.drawingAreaPixels;
        int var10 = JagGraphics.drawingAreaWidth;
        int var11 = JagGraphics.drawingAreaHeight;
        int[] var12 = new int[4];
        JagGraphics.method1366(var12);
        Class68 var13 = this.method139(var1, var2, var3, var4);
        float var14 = this.method133(var7 - var5, var3 - var1);
        int var15 = (int) Math.ceil((double) var14);
        this.anInt274 = var15;
        if (!this.aHashMap270.containsKey(var15)) {
            Class16 var16 = new Class16(var15);
            var16.method125();
            this.aHashMap270.put(var15, var16);
        }

        int var17 = var13.anInt539 + var13.anInt538 - 1;
        int var18 = var13.anInt537 + var13.anInt540 - 1;

        int var19;
        int var20;
        for (var19 = var13.anInt538; var19 <= var17; ++var19) {
            for (var20 = var13.anInt537; var20 <= var18; ++var20) {
                this.aClass7ArrayArray269[var19][var20].method28(var15, (Class16) this.aHashMap270.get(var15), this.aDoublyNode_Sub24_Sub4Array266, this.aReferenceTable275, this.aReferenceTable265);
            }
        }

        JagGraphics.setTarget(var9, var10, var11);
        JagGraphics.method1373(var12);
        var19 = (int) (var14 * 64.0F);
        var20 = this.anInt261 * 4096 + var1;
        int var21 = this.anInt268 * 4096 + var2;

        for (int var22 = var13.anInt538; var22 < var13.anInt539 + var13.anInt538; ++var22) {
            for (int var23 = var13.anInt537; var23 < var13.anInt537 + var13.anInt540; ++var23) {
                this.aClass7ArrayArray269[var22][var23].method55(var5 + var19 * (this.aClass7ArrayArray269[var22][var23].anInt115 * 64 - var20) / 64, var8 - var19 * (this.aClass7ArrayArray269[var22][var23].anInt116 * 64 - var21 + 64) / 64, var19);
            }
        }

    }

    public final void method141(int var1, int var2, int var3, int var4, int var5, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
        Class68 var14 = this.method139(var1, var2, var3, var4);
        float var15 = this.method133(var7 - var5, var3 - var1);
        int var16 = (int) (64.0F * var15);
        int var17 = this.anInt261 * 4096 + var1;
        int var18 = this.anInt268 * 4096 + var2;

        int var19;
        int var20;
        for (var19 = var14.anInt538; var19 < var14.anInt538 + var14.anInt539; ++var19) {
            for (var20 = var14.anInt537; var20 < var14.anInt537 + var14.anInt540; ++var20) {
                if (var13) {
                    this.aClass7ArrayArray269[var19][var20].method43();
                }

                this.aClass7ArrayArray269[var19][var20].method47(var5 + var16 * (this.aClass7ArrayArray269[var19][var20].anInt115 * 64 - var17) / 64, var8 - var16 * (this.aClass7ArrayArray269[var19][var20].anInt116 * 64 - var18 + 64) / 64, var16, var9);
            }
        }

        if (var10 != null && var11 > 0) {
            for (var19 = var14.anInt538; var19 < var14.anInt538 + var14.anInt539; ++var19) {
                for (var20 = var14.anInt537; var20 < var14.anInt540 + var14.anInt537; ++var20) {
                    this.aClass7ArrayArray269[var19][var20].method26(var10, var11, var12);
                }
            }
        }

    }
}
