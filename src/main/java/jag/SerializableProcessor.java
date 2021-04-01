package jag;

import jag.audi.AudioEffect;
import jag.audi.ObjectSound;
import jag.audi.PcmStream_Sub2;
import jag.audi.vorbis.RawAudioOverride;
import jag.game.menu.ContextMenu;
import jag.game.client;
import jag.game.menu.MenuItemNode;
import jag.game.scene.CollisionMap;
import jag.game.scene.SceneGraph;
import jag.game.scene.entity.DynamicObject;
import jag.game.scene.entity.Entity;
import jag.game.scene.entity.EntityUID;
import jag.game.type.DefinitionProperty;
import jag.game.type.ObjectDefinition;
import jag.js5.Archive;
import jag.opcode.Buffer;
import jag.statics.Statics45;
import jag.statics.Statics46;
import jag.worldmap.WorldMapChunkDefinition;
import jag.worldmap.WorldMapLabelSize;

public class SerializableProcessor implements EnumType {

    public static final SerializableProcessor INTEGER_PROCESSOR;
    public static final SerializableProcessor LONG_PROCESSOR;
    public static final SerializableProcessor STRING_PROCESSOR;
    public static String aString636;

    static {
        INTEGER_PROCESSOR = new SerializableProcessor(1, 0, Integer.class, new SerializableInteger());
        LONG_PROCESSOR = new SerializableProcessor(0, 1, Long.class, new SerializableLong());
        STRING_PROCESSOR = new SerializableProcessor(2, 2, String.class, new SerializableString());
    }

    public final Serializable value;
    public final int ordinal;
    public final int type;
    public final Class<?> targetType;

    public SerializableProcessor(int type, int ordinal, Class<?> targetType, Serializable value) {
        this.type = type;
        this.ordinal = ordinal;
        this.targetType = targetType;
        this.value = value;
    }

    public static SerializableProcessor[] values() {
        return new SerializableProcessor[]{STRING_PROCESSOR, LONG_PROCESSOR, INTEGER_PROCESSOR};
    }

    public static SerializableProcessor valueOf(Class<?> type) {
        SerializableProcessor[] values = values();

        for (SerializableProcessor processor : values) {
            if (processor.targetType == type) {
                return processor;
            }
        }

        return null;
    }

    public static void method459(int var0, int var1) {
        MenuItemNode var2 = DefinitionProperty.aMenuItemNode_384;
        ContextMenu.processAction(var2.secondaryArg, var2.tertiaryArg, var2.opcode, var2.primaryArg, var2.action, var0, var1);
        DefinitionProperty.aMenuItemNode_384 = null;
    }

    public static void method456(int var0, int var1, int var2, int var3) {
        for (ObjectSound var4 = ObjectSound.OBJECT_SOUNDS.head(); var4 != null; var4 = ObjectSound.OBJECT_SOUNDS.next()) {
            if (var4.ambientSoundId != -1 || var4.effects != null) {
                int var5 = 0;
                if (var1 > var4.anInt380 * 16384) {
                    var5 += var1 - var4.anInt380 * 16384;
                } else if (var1 < var4.anInt377 * 128) {
                    var5 += var4.anInt377 * 128 - var1;
                }

                if (var2 > var4.anInt375 * 16384) {
                    var5 += var2 - var4.anInt375 * 16384;
                } else if (var2 < var4.anInt112 * 128) {
                    var5 += var4.anInt112 * 128 - var2;
                }

                if (var5 - 64 <= var4.anInt372 && client.anInt897 != 0 && var0 == var4.anInt378) {
                    var5 -= 64;
                    if (var5 < 0) {
                        var5 = 0;
                    }

                    int var6 = (var4.anInt372 - var5) * client.anInt897 / var4.anInt372;
                    if (var4.aClass5_Sub6_Sub2_370 == null) {
                        if (var4.ambientSoundId >= 0) {
                            AudioEffect var7 = AudioEffect.load(Archive.audioEffects, var4.ambientSoundId, 0);
                            if (var7 != null) {
                                RawAudioOverride var8 = var7.method1523().resample(Statics46.aClass98_446);
                                PcmStream_Sub2 var9 = PcmStream_Sub2.method598(var8, 100, var6);
                                var9.method585(-1);
                                WorldMapLabelSize.aClass5_Sub6_Sub1_528.method312(var9);
                                var4.aClass5_Sub6_Sub2_370 = var9;
                            }
                        }
                    } else {
                        var4.aClass5_Sub6_Sub2_370.method302(var6);
                    }

                    if (var4.aClass5_Sub6_Sub2_369 == null) {
                        if (var4.effects != null && (var4.anInt366 -= var3) <= 0) {
                            int var10 = (int) (Math.random() * (double) var4.effects.length);
                            AudioEffect var12 = AudioEffect.load(Archive.audioEffects, var4.effects[var10], 0);
                            if (var12 != null) {
                                RawAudioOverride var13 = var12.method1523().resample(Statics46.aClass98_446);
                                PcmStream_Sub2 var11 = PcmStream_Sub2.method598(var13, 100, var6);
                                var11.method585(0);
                                WorldMapLabelSize.aClass5_Sub6_Sub1_528.method312(var11);
                                var4.aClass5_Sub6_Sub2_369 = var11;
                                var4.anInt366 = var4.anInt368 + (int) (Math.random() * (double) (var4.anInt367 - var4.anInt368));
                            }
                        }
                    } else {
                        var4.aClass5_Sub6_Sub2_369.method302(var6);
                        if (!var4.aClass5_Sub6_Sub2_369.isLinked()) {
                            var4.aClass5_Sub6_Sub2_369 = null;
                        }
                    }
                } else {
                    if (var4.aClass5_Sub6_Sub2_370 != null) {
                        WorldMapLabelSize.aClass5_Sub6_Sub1_528.removeDelegate(var4.aClass5_Sub6_Sub2_370);
                        var4.aClass5_Sub6_Sub2_370 = null;
                    }

                    if (var4.aClass5_Sub6_Sub2_369 != null) {
                        WorldMapLabelSize.aClass5_Sub6_Sub1_528.removeDelegate(var4.aClass5_Sub6_Sub2_369);
                        var4.aClass5_Sub6_Sub2_369 = null;
                    }
                }
            }
        }

    }

    public static void method453() {
        WorldMapChunkDefinition.A_REFERENCE_NODE_TABLE___118.clear();
    }

    public static void method450() {
        Login.step = 24;
        Login.setMessages("The game servers are currently being updated.", "Please wait a few minutes and try again.", "");
    }

    public static void method451(int var0, int var1, int x, int y, int id, int var5, int var6, SceneGraph scene, CollisionMap map) {
        ObjectDefinition def = ObjectDefinition.get(id);
        int width;
        int height;
        if (var5 != 1 && var5 != 3) {
            width = def.sizeX;
            height = def.sizeY;
        } else {
            width = def.sizeY;
            height = def.sizeX;
        }

        int endX;
        int startX;
        if (width + x <= 104) {
            endX = (width >> 1) + x;
            startX = x + (width + 1 >> 1);
        } else {
            endX = x;
            startX = x + 1;
        }

        int endY;
        int startY;
        if (y + height <= 104) {
            endY = y + (height >> 1);
            startY = y + (height + 1 >> 1);
        } else {
            endY = y;
            startY = y + 1;
        }

        int[][] heights = Statics45.tileHeights[var1];
        int var17 = heights[startX][startY] + heights[endX][endY] + heights[startX][endY] + heights[endX][startY] >> 2;
        int var18 = (x << 7) + (width << 6);
        int var19 = (y << 7) + (height << 6);
        long uid = EntityUID.build(x, y, 2, def.mapDoorFlag == 0, id);
        int var22 = (var5 << 6) + var6;
        if (def.itemSupport == 1) {
            var22 += 256;
        }

        Entity var23;
        if (var6 == 22) {
            if (def.animation == -1 && def.transformIds == null) {
                var23 = def.method1103(22, var5, heights, var18, var17, var19);
            } else {
                var23 = new DynamicObject(id, 22, var5, var1, x, y, def.animation, true, null);
            }

            scene.addTileDecor(var0, x, y, var17, var23, uid, var22);
            if (def.anInt791 == 1) {
                map.method158(x, y);
            }

        } else if (var6 != 10 && var6 != 11) {
            if (var6 >= 12) {
                if (def.animation == -1 && def.transformIds == null) {
                    var23 = def.method1103(var6, var5, heights, var18, var17, var19);
                } else {
                    var23 = new DynamicObject(id, var6, var5, var1, x, y, def.animation, true, null);
                }

                scene.method1470(var0, x, y, var17, 1, 1, var23, 0, uid, var22);
                if (def.anInt791 != 0) {
                    map.method160(x, y, width, height, def.impenetrable);
                }

            } else if (var6 == 0) {
                if (def.animation == -1 && def.transformIds == null) {
                    var23 = def.method1103(0, var5, heights, var18, var17, var19);
                } else {
                    var23 = new DynamicObject(id, 0, var5, var1, x, y, def.animation, true, null);
                }

                scene.addBoundary(var0, x, y, var17, var23, null, Statics45.anIntArray406[var5], 0, uid, var22);
                if (def.anInt791 != 0) {
                    map.method154(x, y, var6, var5, def.impenetrable);
                }

            } else if (var6 == 1) {
                if (def.animation == -1 && def.transformIds == null) {
                    var23 = def.method1103(1, var5, heights, var18, var17, var19);
                } else {
                    var23 = new DynamicObject(id, 1, var5, var1, x, y, def.animation, true, null);
                }

                scene.addBoundary(var0, x, y, var17, var23, null, Statics45.anIntArray395[var5], 0, uid, var22);
                if (def.anInt791 != 0) {
                    map.method154(x, y, var6, var5, def.impenetrable);
                }

            } else {
                int var24;
                if (var6 == 2) {
                    var24 = var5 + 1 & 3;
                    Entity var25;
                    Entity var26;
                    if (def.animation == -1 && def.transformIds == null) {
                        var25 = def.method1103(2, var5 + 4, heights, var18, var17, var19);
                        var26 = def.method1103(2, var24, heights, var18, var17, var19);
                    } else {
                        var25 = new DynamicObject(id, 2, var5 + 4, var1, x, y, def.animation, true, null);
                        var26 = new DynamicObject(id, 2, var24, var1, x, y, def.animation, true, null);
                    }

                    scene.addBoundary(var0, x, y, var17, var25, var26, Statics45.anIntArray406[var5], Statics45.anIntArray406[var24], uid, var22);
                    if (def.anInt791 != 0) {
                        map.method154(x, y, var6, var5, def.impenetrable);
                    }

                } else if (var6 == 3) {
                    if (def.animation == -1 && def.transformIds == null) {
                        var23 = def.method1103(3, var5, heights, var18, var17, var19);
                    } else {
                        var23 = new DynamicObject(id, 3, var5, var1, x, y, def.animation, true, null);
                    }

                    scene.addBoundary(var0, x, y, var17, var23, null, Statics45.anIntArray395[var5], 0, uid, var22);
                    if (def.anInt791 != 0) {
                        map.method154(x, y, var6, var5, def.impenetrable);
                    }

                } else if (var6 == 9) {
                    if (def.animation == -1 && def.transformIds == null) {
                        var23 = def.method1103(var6, var5, heights, var18, var17, var19);
                    } else {
                        var23 = new DynamicObject(id, var6, var5, var1, x, y, def.animation, true, null);
                    }

                    scene.method1470(var0, x, y, var17, 1, 1, var23, 0, uid, var22);
                    if (def.anInt791 != 0) {
                        map.method160(x, y, width, height, def.impenetrable);
                    }

                } else if (var6 == 4) {
                    if (def.animation == -1 && def.transformIds == null) {
                        var23 = def.method1103(4, var5, heights, var18, var17, var19);
                    } else {
                        var23 = new DynamicObject(id, 4, var5, var1, x, y, def.animation, true, null);
                    }

                    scene.addBoundaryDecor(var0, x, y, var17, var23, null, Statics45.anIntArray406[var5], 0, 0, 0, uid, var22);
                } else {
                    long var27;
                    Entity var29;
                    if (var6 == 5) {
                        var24 = 16;
                        var27 = scene.getBoundaryUidAt(var0, x, y);
                        if (var27 != 0L) {
                            var24 = ObjectDefinition.get(EntityUID.getObjectId(var27)).anInt1369;
                        }

                        if (def.animation == -1 && def.transformIds == null) {
                            var29 = def.method1103(4, var5, heights, var18, var17, var19);
                        } else {
                            var29 = new DynamicObject(id, 4, var5, var1, x, y, def.animation, true, null);
                        }

                        scene.addBoundaryDecor(var0, x, y, var17, var29, null, Statics45.anIntArray406[var5], 0, var24 * Statics45.anIntArray402[var5], var24 * Statics45.anIntArray394[var5], uid, var22);
                    } else if (var6 == 6) {
                        var24 = 8;
                        var27 = scene.getBoundaryUidAt(var0, x, y);
                        if (var27 != 0L) {
                            var24 = ObjectDefinition.get(EntityUID.getObjectId(var27)).anInt1369 / 2;
                        }

                        if (def.animation == -1 && def.transformIds == null) {
                            var29 = def.method1103(4, var5 + 4, heights, var18, var17, var19);
                        } else {
                            var29 = new DynamicObject(id, 4, var5 + 4, var1, x, y, def.animation, true, null);
                        }

                        scene.addBoundaryDecor(var0, x, y, var17, var29, null, 256, var5, var24 * Statics45.anIntArray397[var5], var24 * Statics45.anIntArray392[var5], uid, var22);
                    } else if (var6 == 7) {
                        int var30 = var5 + 2 & 3;
                        if (def.animation == -1 && def.transformIds == null) {
                            var23 = def.method1103(4, var30 + 4, heights, var18, var17, var19);
                        } else {
                            var23 = new DynamicObject(id, 4, var30 + 4, var1, x, y, def.animation, true, null);
                        }

                        scene.addBoundaryDecor(var0, x, y, var17, var23, null, 256, var30, 0, 0, uid, var22);
                    } else if (var6 == 8) {
                        var24 = 8;
                        var27 = scene.getBoundaryUidAt(var0, x, y);
                        if (var27 != 0L) {
                            var24 = ObjectDefinition.get(EntityUID.getObjectId(var27)).anInt1369 / 2;
                        }

                        int var31 = var5 + 2 & 3;
                        Entity var32;
                        if (def.animation == -1 && def.transformIds == null) {
                            var29 = def.method1103(4, var5 + 4, heights, var18, var17, var19);
                            var32 = def.method1103(4, var31 + 4, heights, var18, var17, var19);
                        } else {
                            var29 = new DynamicObject(id, 4, var5 + 4, var1, x, y, def.animation, true, null);
                            var32 = new DynamicObject(id, 4, var31 + 4, var1, x, y, def.animation, true, null);
                        }

                        scene.addBoundaryDecor(var0, x, y, var17, var29, var32, 256, var5, var24 * Statics45.anIntArray397[var5], var24 * Statics45.anIntArray392[var5], uid, var22);
                    }
                }
            }
        } else {
            if (def.animation == -1 && def.transformIds == null) {
                var23 = def.method1103(10, var5, heights, var18, var17, var19);
            } else {
                var23 = new DynamicObject(id, 10, var5, var1, x, y, def.animation, true, null);
            }

            if (var23 != null) {
                scene.method1470(var0, x, y, var17, width, height, var23, var6 == 11 ? 256 : 0, uid, var22);
            }

            if (def.anInt791 != 0) {
                map.method160(x, y, width, height, def.impenetrable);
            }

        }
    }

    public int getOrdinal() {
        return ordinal;
    }

    public Object decode(Buffer buffer) {
        return value.decode(buffer);
    }
}
