package com.jagex;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Statics10 {
    public static BufferedFile[] aBufferedFileArray1135;

    public static void processClassStructurePacket(PacketBuffer var0) {
        ClassStructure var2 = (ClassStructure) Statics43.classStructures.head();
        if (var2 != null) {
            int var3 = var0.caret;
            var0.writeInt(var2.size);

            for (int var4 = 0; var4 < var2.elementCount; ++var4) {
                if (var2.errors[var4] != 0) {
                    var0.writeByte(var2.errors[var4]);
                } else {
                    try {
                        int var5 = var2.types[var4];
                        Field var6;
                        int var7;
                        if (var5 == 0) {
                            var6 = var2.fields[var4];
                            var7 = var6.getInt(null);
                            var0.writeByte(0);
                            var0.writeInt(var7);
                        } else if (var5 == 1) {
                            var6 = var2.fields[var4];
                            var6.setInt(null, var2.fieldIntValues[var4]);
                            var0.writeByte(0);
                        } else if (var5 == 2) {
                            var6 = var2.fields[var4];
                            var7 = var6.getModifiers();
                            var0.writeByte(0);
                            var0.writeInt(var7);
                        }

                        Method var26;
                        if (var5 != 3) {
                            if (var5 == 4) {
                                var26 = var2.methods[var4];
                                var7 = var26.getModifiers();
                                var0.writeByte(0);
                                var0.writeInt(var7);
                            }
                        } else {
                            var26 = var2.methods[var4];
                            byte[][] var8 = var2.methodArgs[var4];
                            Object[] var9 = new Object[var8.length];

                            for (int var10 = 0; var10 < var8.length; ++var10) {
                                ObjectInputStream var11 = new ObjectInputStream(new ByteArrayInputStream(var8[var10]));
                                var9[var10] = var11.readObject();
                            }

                            Object var12 = var26.invoke(null, var9);
                            if (var12 == null) {
                                var0.writeByte(0);
                            } else if (var12 instanceof Number) {
                                var0.writeByte(1);
                                var0.writeLong(((Number) var12).longValue());
                            } else if (var12 instanceof String) {
                                var0.writeByte(2);
                                var0.writeCString((String) var12);
                            } else {
                                var0.writeByte(4);
                            }
                        }
                    } catch (ClassNotFoundException var14) {
                        var0.writeByte(-10);
                    } catch (InvalidClassException var15) {
                        var0.writeByte(-11);
                    } catch (StreamCorruptedException var16) {
                        var0.writeByte(-12);
                    } catch (OptionalDataException var17) {
                        var0.writeByte(-13);
                    } catch (IllegalAccessException var18) {
                        var0.writeByte(-14);
                    } catch (IllegalArgumentException var19) {
                        var0.writeByte(-15);
                    } catch (InvocationTargetException var20) {
                        var0.writeByte(-16);
                    } catch (SecurityException var21) {
                        var0.writeByte(-17);
                    } catch (IOException var22) {
                        var0.writeByte(-18);
                    } catch (NullPointerException var23) {
                        var0.writeByte(-19);
                    } catch (Exception var24) {
                        var0.writeByte(-20);
                    } catch (Throwable var25) {
                        var0.writeByte(-21);
                    }
                }
            }

            var0.writeCrc(var3);
            var2.unlink();
        }
    }

    static void method798() {
        int var0;
        if (client.bootState == 0) {
            client.sceneGraph = new SceneGraph(4, 104, 104, Class44.tileHeights);

            for (var0 = 0; var0 < 4; ++var0) {
                client.collisionMaps[var0] = new CollisionMap(104, 104);
            }

            Node_Sub2.minimapSprite = new Sprite(512, 512);
            Class55.aString475 = "Starting game engine...";
            Class55.anInt473 = 5;
            client.bootState = 20;
        } else if (client.bootState == 20) {
            Class55.aString475 = "Prepared visibility map";
            Class55.anInt473 = 10;
            client.bootState = 30;
        } else if (client.bootState == 30) {
            Class73.aCacheReferenceTable583 = ActionPrioritySetting.getReferenceTable(0, false, true);
            Class65.aCacheReferenceTable526 = ActionPrioritySetting.getReferenceTable(1, false, true);
            Class104.aCacheReferenceTable773 = ActionPrioritySetting.getReferenceTable(2, true, false);
            Boundary.aCacheReferenceTable1876 = ActionPrioritySetting.getReferenceTable(3, false, true);
            Class74.aCacheReferenceTable586 = ActionPrioritySetting.getReferenceTable(4, false, true);
            Class85.aCacheReferenceTable635 = ActionPrioritySetting.getReferenceTable(5, true, true);
            Statics15.aCacheReferenceTable1234 = ActionPrioritySetting.getReferenceTable(6, true, true);
            Class149.aCacheReferenceTable1188 = ActionPrioritySetting.getReferenceTable(7, false, true);
            Class74.sprites = ActionPrioritySetting.getReferenceTable(8, false, true);
            ActionPrioritySetting.aCacheReferenceTable329 = ActionPrioritySetting.getReferenceTable(9, false, true);
            client.aCacheReferenceTable948 = ActionPrioritySetting.getReferenceTable(10, false, true);
            ClanMember.aCacheReferenceTable867 = ActionPrioritySetting.getReferenceTable(11, false, true);
            Class38.aCacheReferenceTable348 = ActionPrioritySetting.getReferenceTable(12, false, true);
            Tile.aCacheReferenceTable1152 = ActionPrioritySetting.getReferenceTable(13, true, false);
            Class63_Sub1.aCacheReferenceTable166 = ActionPrioritySetting.getReferenceTable(14, false, true);
            RuneScript.aCacheReferenceTable1644 = ActionPrioritySetting.getReferenceTable(15, false, true);
            client.aCacheReferenceTable953 = ActionPrioritySetting.getReferenceTable(17, true, true);
            DoublyLinkedNode_Sub18.aCacheReferenceTable1506 = ActionPrioritySetting.getReferenceTable(18, false, true);
            Class34.aCacheReferenceTable341 = ActionPrioritySetting.getReferenceTable(19, false, true);
            Class25.aCacheReferenceTable304 = ActionPrioritySetting.getReferenceTable(20, false, true);
            Class55.aString475 = "Connecting to update server";
            Class55.anInt473 = 20;
            client.bootState = 40;
        } else if (client.bootState == 40) {
            byte var30 = 0;
            var0 = var30 + Class73.aCacheReferenceTable583.method494() * 4 / 100;
            var0 += Class65.aCacheReferenceTable526.method494() * 4 / 100;
            var0 += Class104.aCacheReferenceTable773.method494() * 2 / 100;
            var0 += Boundary.aCacheReferenceTable1876.method494() * 2 / 100;
            var0 += Class74.aCacheReferenceTable586.method494() * 6 / 100;
            var0 += Class85.aCacheReferenceTable635.method494() * 4 / 100;
            var0 += Statics15.aCacheReferenceTable1234.method494() * 2 / 100;
            var0 += Class149.aCacheReferenceTable1188.method494() * 56 / 100;
            var0 += Class74.sprites.method494() * 2 / 100;
            var0 += ActionPrioritySetting.aCacheReferenceTable329.method494() * 2 / 100;
            var0 += client.aCacheReferenceTable948.method494() * 2 / 100;
            var0 += ClanMember.aCacheReferenceTable867.method494() * 2 / 100;
            var0 += Class38.aCacheReferenceTable348.method494() * 2 / 100;
            var0 += Tile.aCacheReferenceTable1152.method494() * 2 / 100;
            var0 += Class63_Sub1.aCacheReferenceTable166.method494() * 2 / 100;
            var0 += RuneScript.aCacheReferenceTable1644.method494() * 2 / 100;
            var0 += Class34.aCacheReferenceTable341.method494() / 100;
            var0 += DoublyLinkedNode_Sub18.aCacheReferenceTable1506.method494() / 100;
            var0 += Class25.aCacheReferenceTable304.method494() / 100;
            var0 += client.aCacheReferenceTable953.method491() && client.aCacheReferenceTable953.method908() ? 1 : 0;
            if (var0 != 100) {
                if (var0 != 0) {
                    Class55.aString475 = "Checking for updates - " + var0 + "%";
                }

                Class55.anInt473 = 30;
            } else {
                Class9_Sub1.method175(Class73.aCacheReferenceTable583);
                Class9_Sub1.method175(Class65.aCacheReferenceTable526);
                Class9_Sub1.method175(Class74.aCacheReferenceTable586);
                Class9_Sub1.method175(Class85.aCacheReferenceTable635);
                Class9_Sub1.method175(Statics15.aCacheReferenceTable1234);
                Class9_Sub1.method175(Class149.aCacheReferenceTable1188);
                Class9_Sub1.method175(Class74.sprites);
                Class9_Sub1.method175(ClanMember.aCacheReferenceTable867);
                Class9_Sub1.method175(Class63_Sub1.aCacheReferenceTable166);
                Class9_Sub1.method175(RuneScript.aCacheReferenceTable1644);
                Class9_Sub1.method175(Class34.aCacheReferenceTable341);
                Class9_Sub1.method175(DoublyLinkedNode_Sub18.aCacheReferenceTable1506);
                Class9_Sub1.method175(Class25.aCacheReferenceTable304);
                Class63_Sub2.aBootSprites_647 = new BootSprites();
                Class63_Sub2.aBootSprites_647.method1190(client.aCacheReferenceTable953);
                Class55.aString475 = "Loaded update list";
                Class55.anInt473 = 30;
                client.bootState = 45;
            }
        } else {
            CacheReferenceTable var2;
            CacheReferenceTable var3;
            CacheReferenceTable var4;
            if (client.bootState == 45) {
                boolean var28 = !client.lowMemory;
                Class105.anInt775 = 22050;
                AudioSystem.aBoolean1841 = var28;
                Class77.anInt603 = 2;
                Node_Sub6_Sub3 var26 = new Node_Sub6_Sub3();
                var26.method575(9, 128);
                Statics16.anAudioSystem1236 = Class56.method329(0, 22050);
                Statics16.anAudioSystem1236.method1330(var26);
                var2 = RuneScript.aCacheReferenceTable1644;
                var3 = Class63_Sub1.aCacheReferenceTable166;
                var4 = Class74.aCacheReferenceTable586;
                Class147.aReferenceTable1160 = var2;
                Class42.aReferenceTable382 = var3;
                Class147.aReferenceTable1159 = var4;
                Class30.aClass5_Sub6_Sub3_326 = var26;
                Class76.anAudioSystem599 = Class56.method329(1, 2048);
                Class65.aClass5_Sub6_Sub1_528 = new Node_Sub6_Sub1();
                Class76.anAudioSystem599.method1330(Class65.aClass5_Sub6_Sub1_528);
                Class49.aClass98_446 = new Class98(22050, Class105.anInt775);
                Class55.aString475 = "Prepared sound engine";
                Class55.anInt473 = 35;
                client.bootState = 50;
                AssociateComparator_Sub2.aClass202_766 = new Class202(Class74.sprites, Tile.aCacheReferenceTable1152);
            } else if (client.bootState == 50) {
                var0 = Class199.method1183().length;
                client.aHashMap961 = AssociateComparator_Sub2.aClass202_766.method1185(Class199.method1183());
                if (client.aHashMap961.size() < var0) {
                    Class55.aString475 = "Loading fonts - " + client.aHashMap961.size() * 100 / var0 + "%";
                    Class55.anInt473 = 40;
                } else {
                    Class38.aFont345 = (Font) client.aHashMap961.get(Class199.aClass199_1624);
                    BootSprites.font_p12full = (Font) client.aHashMap961.get(Class199.aClass199_1625);
                    Statics7.aFont863 = (Font) client.aHashMap961.get(Class199.aClass199_1622);
                    Statics27.operatingSystemNode = client.aOperatingSystemProvider_935.provide();
                    Class55.aString475 = "Loaded fonts";
                    Class55.anInt473 = 40;
                    client.bootState = 60;
                }
            } else {
                CacheReferenceTable var1;
                int var5;
                if (client.bootState == 60) {
                    var1 = client.aCacheReferenceTable948;
                    var2 = Class74.sprites;
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
                        Class55.aString475 = "Loading title screen - " + var5 * 100 / var27 + "%";
                        Class55.anInt473 = 50;
                    } else {
                        Class55.aString475 = "Loaded title screen";
                        Class55.anInt473 = 50;
                        MouseRecorder.setGameState(5);
                        client.bootState = 70;
                    }
                } else if (client.bootState == 70) {
                    if (!Class104.aCacheReferenceTable773.method908()) {
                        Class55.aString475 = "Loading config - " + Class104.aCacheReferenceTable773.method489() + "%";
                        Class55.anInt473 = 60;
                    } else {
                        DoublyLinkedNode_Sub14.aReferenceTable383 = Class104.aCacheReferenceTable773;
                        var1 = Class104.aCacheReferenceTable773;
                        DoublyLinkedNode_Sub20.aReferenceTable383 = var1;
                        var2 = Class104.aCacheReferenceTable773;
                        var3 = Class149.aCacheReferenceTable1188;
                        DoublyLinkedNode_Sub21.aReferenceTable383 = var2;
                        Class38.aReferenceTable350 = var3;
                        Class12.anInt143 = DoublyLinkedNode_Sub21.aReferenceTable383.method901(3);
                        var4 = Class104.aCacheReferenceTable773;
                        CacheReferenceTable var9 = Class149.aCacheReferenceTable1188;
                        boolean var10 = client.lowMemory;
                        ObjectDefinition.aReferenceTable697 = var4;
                        ObjectDefinition.aReferenceTable1515 = var9;
                        ObjectDefinition.aBoolean792 = var10;
                        CacheReferenceTable var11 = Class104.aCacheReferenceTable773;
                        CacheReferenceTable var12 = Class149.aCacheReferenceTable1188;
                        NpcDefinition.table = var11;
                        NpcDefinition.aReferenceTable697 = var12;
                        DoublyLinkedNode_Sub17.aReferenceTable383 = Class104.aCacheReferenceTable773;
                        Class36.method240(Class104.aCacheReferenceTable773, Class149.aCacheReferenceTable1188, client.membersWorld, Class38.aFont345);
                        AnimationSequence.method1202(Class104.aCacheReferenceTable773, Class73.aCacheReferenceTable583, Class65.aCacheReferenceTable526);
                        CacheReferenceTable var14 = Class104.aCacheReferenceTable773;
                        CacheReferenceTable var15 = Class149.aCacheReferenceTable1188;
                        Class62.aReferenceTable500 = var14;
                        SpotAnimation.aReferenceTable697 = var15;
                        Class56.method327(Class104.aCacheReferenceTable773);
                        DoublyLinkedNode_Sub16.aReferenceTable383 = Class104.aCacheReferenceTable773;
                        DoublyLinkedNode_Sub16.anInt568 = DoublyLinkedNode_Sub16.aReferenceTable383.method901(16);
                        MouseRecorder.method263(Boundary.aCacheReferenceTable1876, Class149.aCacheReferenceTable1188, Class74.sprites, Tile.aCacheReferenceTable1152);
                        Keyboard.method103(Class104.aCacheReferenceTable773);
                        DoublyLinkedNode_Sub11.aReferenceTable383 = Class104.aCacheReferenceTable773;
                        DoublyLinkedNode_Sub18.aReferenceTable383 = Class104.aCacheReferenceTable773;
                        DefinitionProperty.table = Class104.aCacheReferenceTable773;
                        Class147.aClass79_1161 = new Class79();
                        Class9.method88(Class104.aCacheReferenceTable773, Class74.sprites, Tile.aCacheReferenceTable1152);
                        Class48.method296(Class104.aCacheReferenceTable773, Class74.sprites);
                        CacheReferenceTable var20 = Class104.aCacheReferenceTable773;
                        DoublyLinkedNode_Sub15.aReferenceTable383 = Class74.sprites;
                        if (var20.method908()) {
                            DoublyLinkedNode_Sub15.anInt378 = var20.method901(35);
                            DoublyLinkedNode_Sub15.aDoublyNode_Sub15Array1475 = new DoublyLinkedNode_Sub15[DoublyLinkedNode_Sub15.anInt378];

                            for (int var22 = 0; var22 < DoublyLinkedNode_Sub15.anInt378; ++var22) {
                                byte[] var23 = var20.unpack(35, var22);
                                DoublyLinkedNode_Sub15.aDoublyNode_Sub15Array1475[var22] = new DoublyLinkedNode_Sub15(var22);
                                if (var23 != null) {
                                    DoublyLinkedNode_Sub15.aDoublyNode_Sub15Array1475[var22].method990(new Buffer(var23));
                                    DoublyLinkedNode_Sub15.aDoublyNode_Sub15Array1475[var22].method775();
                                }
                            }
                        }

                        Class55.aString475 = "Loaded config";
                        Class55.anInt473 = 60;
                        client.bootState = 80;
                    }
                } else if (client.bootState == 80) {
                    var0 = 0;
                    if (ActionPrioritySetting.compass == null) {
                        ActionPrioritySetting.compass = Sprite.get(Class74.sprites, Class63_Sub2.aBootSprites_647.anInt1656, 0);
                    } else {
                        ++var0;
                    }

                    if (PendingSpawn.mapedge == null) {
                        PendingSpawn.mapedge = Sprite.get(Class74.sprites, Class63_Sub2.aBootSprites_647.anInt1658, 0);
                    } else {
                        ++var0;
                    }

                    if (Class62.mapscene == null) {
                        Class62.mapscene = Statics38.method1194(Class74.sprites, Class63_Sub2.aBootSprites_647.anInt1653, 0);
                    } else {
                        ++var0;
                    }

                    if (DoublyLinkedNode_Sub17.prayerIconSprites == null) {
                        DoublyLinkedNode_Sub17.prayerIconSprites = Canvas.method643(Class74.sprites, Class63_Sub2.aBootSprites_647.anInt1652, 0);
                    } else {
                        ++var0;
                    }

                    if (Class7.skullIconSprites == null) {
                        Class7.skullIconSprites = Canvas.method643(Class74.sprites, Class63_Sub2.aBootSprites_647.anInt1650, 0);
                    } else {
                        ++var0;
                    }

                    if (ClassStructure.hitmarks == null) {
                        ClassStructure.hitmarks = Canvas.method643(Class74.sprites, Class63_Sub2.aBootSprites_647.anInt1648, 0);
                    } else {
                        ++var0;
                    }

                    if (EntityMarker.mapfunctions == null) {
                        EntityMarker.mapfunctions = Canvas.method643(Class74.sprites, Class63_Sub2.aBootSprites_647.anInt1649, 0);
                    } else {
                        ++var0;
                    }

                    if (Class105.hintIcons == null) {
                        Class105.hintIcons = Canvas.method643(Class74.sprites, Class63_Sub2.aBootSprites_647.anInt1657, 0);
                    } else {
                        ++var0;
                    }

                    if (Class54.mapmarkers == null) {
                        Class54.mapmarkers = Canvas.method643(Class74.sprites, Class63_Sub2.aBootSprites_647.anInt1654, 0);
                    } else {
                        ++var0;
                    }

                    if (Class80.scrollbars == null) {
                        Class80.scrollbars = Statics38.method1194(Class74.sprites, Class63_Sub2.aBootSprites_647.anInt1655, 0);
                    } else {
                        ++var0;
                    }

                    if (Class63_Sub2.aDoublyNode_Sub24_Sub4Array648 == null) {
                        Class63_Sub2.aDoublyNode_Sub24_Sub4Array648 = Statics38.method1194(Class74.sprites, Class63_Sub2.aBootSprites_647.anInt1651, 0);
                    } else {
                        ++var0;
                    }

                    if (var0 < 11) {
                        Class55.aString475 = "Loading sprites - " + var0 * 100 / 12 + "%";
                        Class55.anInt473 = 70;
                    } else {
                        DoublyLinkedNode_Sub24_Sub3.aDoublyNode_Sub24_Sub4Array1573 = Class63_Sub2.aDoublyNode_Sub24_Sub4Array648;
                        PendingSpawn.mapedge.method775();
                        int var24 = (int) (Math.random() * 21.0D) - 10;
                        int var25 = (int) (Math.random() * 21.0D) - 10;
                        var5 = (int) (Math.random() * 21.0D) - 10;
                        int var6 = (int) (Math.random() * 41.0D) - 20;
                        Class62.mapscene[0].method1325(var6 + var24, var6 + var25, var6 + var5);
                        Class55.aString475 = "Loaded sprites";
                        Class55.anInt473 = 70;
                        client.bootState = 90;
                    }
                } else if (client.bootState == 90) {
                    if (!ActionPrioritySetting.aCacheReferenceTable329.method908()) {
                        Class55.aString475 = "Loading textures - " + "0%";
                        Class55.anInt473 = 90;
                    } else {
                        CacheReferenceTable.aTextureProviderImpl672 = new TextureProviderImpl(ActionPrioritySetting.aCacheReferenceTable329, Class74.sprites, 20, 0.8D, client.lowMemory ? 64 : 128);
                        JagGraphics3D.method636(CacheReferenceTable.aTextureProviderImpl672);
                        JagGraphics3D.method634(0.8D);
                        client.bootState = 100;
                    }
                } else if (client.bootState == 100) {
                    var0 = CacheReferenceTable.aTextureProviderImpl672.method1516();
                    if (var0 < 100) {
                        Class55.aString475 = "Loading textures - " + var0 + "%";
                        Class55.anInt473 = 90;
                    } else {
                        Class55.aString475 = "Loaded textures";
                        Class55.anInt473 = 90;
                        client.bootState = 110;
                    }
                } else if (client.bootState == 110) {
                    Class34.mouseRecorder = new MouseRecorder();
                    client.aClass125_1321.method697(Class34.mouseRecorder, 10);
                    Class55.aString475 = "Loaded input handler";
                    Class55.anInt473 = 92;
                    client.bootState = 120;
                } else if (client.bootState == 120) {
                    if (!client.aCacheReferenceTable948.method893("huffman", "")) {
                        Class55.aString475 = "Loading wordpack - " + 0 + "%";
                        Class55.anInt473 = 94;
                    } else {
                        Statics19.aClass166_1261 = new Class166(client.aCacheReferenceTable948.method897("huffman", ""));
                        Class55.aString475 = "Loaded wordpack";
                        Class55.anInt473 = 94;
                        client.bootState = 130;
                    }
                } else if (client.bootState == 130) {
                    if (!Boundary.aCacheReferenceTable1876.method908()) {
                        Class55.aString475 = "Loading interfaces - " + Boundary.aCacheReferenceTable1876.method489() * 4 / 5 + "%";
                        Class55.anInt473 = 96;
                    } else if (!Class38.aCacheReferenceTable348.method908()) {
                        Class55.aString475 = "Loading interfaces - " + (80 + Class38.aCacheReferenceTable348.method489() / 6) + "%";
                        Class55.anInt473 = 96;
                    } else if (!Tile.aCacheReferenceTable1152.method908()) {
                        Class55.aString475 = "Loading interfaces - " + (96 + Tile.aCacheReferenceTable1152.method489() / 50) + "%";
                        Class55.anInt473 = 96;
                    } else {
                        Class55.aString475 = "Loaded interfaces";
                        Class55.anInt473 = 98;
                        client.bootState = 140;
                    }
                } else if (client.bootState == 140) {
                    Class55.anInt473 = 100;
                    if (!Class34.aCacheReferenceTable341.method909(Class23.aClass23_297.aString292)) {
                        Class55.aString475 = "Loading world map - " + Class34.aCacheReferenceTable341.method895(Class23.aClass23_297.aString292) / 10 + "%";
                    } else {
                        if (Class44.aClass209_391 == null) {
                            Class44.aClass209_391 = new Class209();
                            Class44.aClass209_391.method1282(Class34.aCacheReferenceTable341, DoublyLinkedNode_Sub18.aCacheReferenceTable1506, Class25.aCacheReferenceTable304, Statics7.aFont863, client.aHashMap961, Class62.mapscene);
                        }

                        Class55.aString475 = "Loaded world map";
                        client.bootState = 150;
                    }
                } else if (client.bootState == 150) {
                    MouseRecorder.setGameState(10);
                }
            }
        }
    }

    public static int method799(int var0) {
        if (var0 > 0) {
            return 1;
        }
        return var0 < 0 ? -1 : 0;
    }

    static int method800(int var0, int var1, int var2) {
        if ((Class44.sceneRenderRules[var0][var1][var2] & 8) != 0) {
            return 0;
        }
        return var0 > 0 && (Class44.sceneRenderRules[1][var1][var2] & 2) != 0 ? var0 - 1 : var0;
    }
}
