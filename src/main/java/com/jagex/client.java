package com.jagex;

import netscape.javascript.JSObject;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class client extends GameEngine implements LocalPlayerNameProvider {
    public static final ConnectionContext connectionContext;
    static final Class123_Sub1 aClass123_Sub1_940;
    static final int[] OBJECT_TYPE_TO_STUB_TYPE;
    static final int[] anIntArray1032;
    public static int currentWorld;
    public static boolean membersWorld;
    public static int anInt929;
    public static int rights;
    public static int build;
    public static int canvasWidth;
    public static int canvasHeight;
    static int npcCount2;
    static boolean aBoolean911;
    static boolean inInstancedScene;
    static int anInt934;
    static NodeDeque pendingSpawns;
    static boolean menuOpen;
    static int rootInterfaceIndex;
    static int itemSelectionState;
    static InterfaceComponent draggedComponent;
    static int menuRowCount;
    static int engineCycle;
    static int gameState;
    static int anInt998;
    static int anInt1034;
    static Class108 aClass108_965;
    static int anInt964;
    static boolean spellSelected;
    static int anInt1085;
    static int playerIndex;
    static int crosshairX;
    static int anInt1084;
    static int logoutTimer;
    static long aLong1081;
    static int anInt993;
    static PlayerEntity[] players;
    static int anInt949;
    static int anInt950;
    static String[] menuActions;
    static int currentWorldMask;
    static int[] menuOpcodes;
    static int crosshairY;
    static boolean[] aBooleanArray1089;
    static NpcEntity[] npcs;
    static int anInt954;
    static int anInt956;
    static boolean lowMemory;
    static boolean[] menuShiftClickActions;
    static int anInt925;
    static int crosshairState;
    static Class180 aClass180_967;
    static int anInt1039;
    static boolean[] aBooleanArray1083;
    static boolean aBoolean1067;
    static boolean[] aBooleanArray1087;
    static String[] menuTargets;
    static int anInt1029;
    static int anInt923;
    static boolean pendingDisconnect;
    static int anInt1017;
    static int anInt1038;
    static Class53 aClass53_960;
    static boolean aBoolean1070;
    static boolean aBoolean970;
    static int npcCount;
    static int destinationX;
    static int anInt957;
    static boolean aBoolean1090;
    static int anInt1075;
    static int anInt1065;
    static int anInt959;
    static int destinationY;
    static int currentComponentDragX;
    static int[] menuPrimaryArgs;
    static boolean aBoolean904;
    static int[] npcIndices2;
    static boolean aBoolean927;
    static int anInt1066;
    static InterfaceComponent topLevelOfDraggedComponent;
    static NodeTable interfaceNodes;
    static int currentComponentDragY;
    static int anInt1030;
    static int[] menuSecondaryArgs;
    static boolean aBoolean1028;
    static int anInt1060;
    static int[] npcIndices;
    static boolean aBoolean939;
    static NodeTable interfaceConfigs;
    static InterfaceComponent pleaseWaitComponent;
    static int[] menuTertiaryArgs;
    static int[][][] dynamicSceneData;
    static int anInt1068;
    static long timeOfPreviousClick;
    static int anInt1073;
    static int lastMouseRecordX;
    static int[] anIntArray963;
    static int lastMouseRecordY;
    static int anInt1047;
    static int selectedSpellComponentIndex;
    static int anInt1069;
    static long lastMouseRecordTime;
    static int anInt972;
    static int[] interfacePositionsX;
    static int anInt1059;
    static boolean aBoolean937;
    static int[] interfaceWidths;
    static boolean aBoolean944;
    static PlayerAppearance aPlayerAppearance924;
    static int viewportWidth;
    static NodeDeque[][][] pickableNodeDeques;
    static InterfaceComponent anInterfaceComponent1055;
    static int redrawMode;
    static int anInt975;
    static int[] currentLevels;
    static int viewportScale;
    static int hintArrowType;
    static boolean aBoolean1024;
    static int anInt966;
    static int hintArrowNpcIndex;
    static int[] interfaceHeights;
    static int anInt1027;
    static int anInt971;
    static int hintArrowPlayerIndex;
    static int[] levels;
    static int anInt968;
    static int[] interfacePositionsY;
    static NodeDeque aNodeDeque1082;
    static int hintArrowX;
    static boolean aBoolean1021;
    static int viewportHeight;
    static int anInt974;
    static int hintArrowY;
    static int[] experiences;
    static int anInt1016;
    static int anInt1022;
    static int anInt1018;
    static int hintArrowZ;
    static CacheReferenceTable aCacheReferenceTable948;
    static int anInt946;
    static String aString1009;
    static int anInt988;
    static int anInt938;
    static int anInt1053;
    static int mapState;
    static boolean aBoolean1043;
    static int[] anIntArray1035;
    static String aString1049;
    static ActionPrioritySetting playerActionPriority;
    static int anInt1015;
    static String aString1051;
    static ActionPrioritySetting npcActionPriority;
    static CollisionMap[] collisionMaps;
    static int anInt1023;
    static int anInt1019;
    static int bootState;
    static String[] playerActions;
    static int anInt1074;
    static int[] anIntArray945;
    static boolean aBoolean1062;
    static int[] anIntArray942;
    static int anInt1077;
    static boolean[] playerActionPriorities;
    static int anInt903;
    static boolean cameraLocked;
    static int energy;
    static int anInt898;
    static int weight;
    static int anInt952;
    static boolean aBoolean1042;
    static Enum_Sub3 anEnum_Sub3_955;
    static boolean aBoolean1044;
    static int mapRotation;
    static boolean aBoolean958;
    static boolean aBoolean1037;
    static int anInt1002;
    static byte[] random;
    static int anInt897;
    static int[] inventories;
    static int anInt1092;
    static int anInt1061;
    static int anInt1078;
    static int[] anIntArray1096;
    static int minimapFloorLevel;
    static boolean aBoolean996;
    static NodeDeque graphicsObjectDeque;
    static InterfaceComponent anInterfaceComponent1058;
    static int anInt930;
    static int anInt1052;
    static NodeDeque projectileDeque;
    static int anInt1086;
    static int anInt931;
    static int[] anIntArray899;
    static int[] anIntArray905;
    static GrandExchangeOffer[] grandExchangeOffers;
    static int[] anIntArray906;
    static AudioEffect[] audioEffects;
    static HashMap aHashMap961;
    static int[] anIntArray902;
    static int anInt1071;
    static int anInt1001;
    static ArrayList anArrayList928;
    static int anInt1006;
    static int anInt926;
    static boolean aBoolean984;
    static boolean aBoolean1020;
    static int anInt976;
    static int anInt1041;
    static boolean aBoolean999;
    static int anInt1036;
    static int anInt980;
    static boolean[] aBooleanArray919;
    static long[] aLongArray896;
    static int[] anIntArray917;
    static long aLong1095;
    static int[] anIntArray918;
    static int[] anIntArray1076;
    static int[] anIntArray914;
    static int anInt1064;
    static int anInt1014;
    static int[] anIntArray916;
    static int anInt891;
    static OperatingSystemProvider aOperatingSystemProvider_935;
    static int anInt900;
    static int anInt987;
    static int anInt985;
    static int anInt983;
    static int[][] anIntArrayArray1003;
    static int anInt990;
    static int anInt895;
    static int[] anIntArray892;
    static int anInt901;
    static int[] anIntArray894;
    static int anInt981;
    static int anInt989;
    static short aShort922;
    static short aShort912;
    static int anInt979;
    static short aShort910;
    static Sprite[] aSpriteArray1093;
    static int publicChatMode;
    static int anInt978;
    static short aShort921;
    static short aShort907;
    static CacheReferenceTable aCacheReferenceTable953;
    static int anInt982;
    static short aShort915;
    static short aShort913;
    static int anInt977;
    static int anInt1031;
    static boolean aBoolean1056;
    static int anInt986;
    static int tradeChatMode;
    static int anInt1045;
    static int anInt997;
    static int anInt1004;
    static int anInt1054;
    static int anInt992;
    static short aShort920;
    static String aString1091;
    static Class38 aClass38_936;
    static int anInt1008;
    static int anInt909;
    static int anInt1000;
    static int[] anIntArray1079;
    static int anInt908;
    static int anInt1010;
    static int anInt1063;
    static int[] anIntArray1013;
    static int[] anIntArray1005;
    static int[] anIntArray1012;
    static int anInt933;
    static int[] anIntArray994;
    static int[] anIntArray995;
    static NodeDeque aNodeDeque1080;
    static int[] anIntArray1007;
    static int[] anIntArray991;
    static String[] aStringArray1011;
    static int[] anIntArray1097;
    static NodeDeque aNodeDeque1088;
    static int[] anIntArray1094;
    static SceneGraph sceneGraph;
    static client instance;
    static ClientPreferences preferences;
    static int spellTargetFlags;

    static {
        aBoolean911 = true;
        currentWorld = 1;
        currentWorldMask = 0;
        anInt925 = 0;
        membersWorld = false;
        lowMemory = false;
        anInt923 = -1;
        aBoolean927 = false;
        gameState = 0;
        aBoolean939 = true;
        engineCycle = 0;
        timeOfPreviousClick = 1L;
        lastMouseRecordX = -1;
        lastMouseRecordY = -1;
        lastMouseRecordTime = -1L;
        aBoolean937 = true;
        aBoolean944 = false;
        anInt934 = 0;
        hintArrowType = 0;
        hintArrowNpcIndex = 0;
        hintArrowPlayerIndex = 0;
        hintArrowX = 0;
        hintArrowY = 0;
        hintArrowZ = 0;
        anInt946 = 0;
        anInt938 = 0;
        playerActionPriority = ActionPrioritySetting.anActionPrioritySetting330;
        npcActionPriority = ActionPrioritySetting.anActionPrioritySetting330;
        bootState = 0;
        anInt950 = 0;
        anInt949 = 0;
        anInt959 = 0;
        anInt956 = 0;
        anInt957 = 0;
        anInt954 = 0;
        anInt952 = 0;
        anEnum_Sub3_955 = Enum_Sub3.anEnum_Sub3_826;
        aBoolean958 = false;
        aClass53_960 = new Class53();
        random = null;
        npcs = new NpcEntity[32768];
        npcCount = 0;
        npcIndices = new int[32768];
        anInt964 = 0;
        anIntArray963 = new int[250];
        connectionContext = new ConnectionContext();
        logoutTimer = 0;
        pendingDisconnect = false;
        aBoolean970 = true;
        aClass180_967 = new Class180();
        aHashMap961 = new HashMap();
        anInt966 = 0;
        anInt971 = 1;
        anInt968 = 0;
        anInt974 = 1;
        anInt975 = 0;
        collisionMaps = new CollisionMap[4];
        inInstancedScene = false;
        dynamicSceneData = new int[4][13][13];
        OBJECT_TYPE_TO_STUB_TYPE = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
        anInt972 = 0;
        anInt980 = 2301979;
        anInt987 = 5063219;
        anInt983 = 3353893;
        anInt990 = 7759444;
        aBoolean984 = false;
        anInt976 = 0;
        anInt985 = 128;
        mapRotation = 0;
        anInt981 = 0;
        anInt989 = 0;
        anInt979 = 0;
        anInt978 = 0;
        anInt988 = 0;
        anInt982 = 50;
        anInt977 = 0;
        anInt986 = 0;
        anInt997 = 0;
        anInt1004 = 12;
        anInt992 = 6;
        anInt1002 = 0;
        aBoolean996 = false;
        anInt1006 = 0;
        aBoolean999 = false;
        anInt1008 = 0;
        anInt1000 = 0;
        anInt1010 = 50;
        anIntArray1013 = new int[anInt1010];
        anIntArray1005 = new int[anInt1010];
        anIntArray1012 = new int[anInt1010];
        anIntArray994 = new int[anInt1010];
        anIntArray995 = new int[anInt1010];
        anIntArray1007 = new int[anInt1010];
        anIntArray991 = new int[anInt1010];
        aStringArray1011 = new String[anInt1010];
        anIntArrayArray1003 = new int[104][104];
        anInt1001 = 0;
        anInt998 = -1;
        anInt993 = -1;
        crosshairX = 0;
        crosshairY = 0;
        anInt1017 = 0;
        crosshairState = 0;
        aBoolean1028 = true;
        anInt1018 = 0;
        anInt1015 = 0;
        anInt1023 = 0;
        anInt1016 = 0;
        anInt1022 = 0;
        anInt1019 = 0;
        aBoolean1024 = false;
        anInt1027 = 0;
        anInt1014 = 0;
        aBoolean1021 = true;
        players = new PlayerEntity[2048];
        playerIndex = -1;
        anInt1029 = 0;
        aBoolean1020 = true;
        anInt1031 = 0;
        npcCount2 = 0;
        npcIndices2 = new int[1000];
        anIntArray1032 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
        playerActions = new String[8];
        playerActionPriorities = new boolean[8];
        anIntArray1035 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
        anInt1030 = -1;
        pickableNodeDeques = new NodeDeque[4][104][104];
        pendingSpawns = new NodeDeque();
        projectileDeque = new NodeDeque();
        graphicsObjectDeque = new NodeDeque();
        currentLevels = new int[25];
        levels = new int[25];
        experiences = new int[25];
        anInt1034 = 0;
        menuOpen = false;
        menuRowCount = 0;
        menuSecondaryArgs = new int[500];
        menuTertiaryArgs = new int[500];
        menuOpcodes = new int[500];
        menuPrimaryArgs = new int[500];
        menuActions = new String[500];
        menuTargets = new String[500];
        menuShiftClickActions = new boolean[500];
        aBoolean1042 = false;
        aBoolean1044 = false;
        aBoolean1037 = false;
        aBoolean1043 = true;
        anInt1039 = -1;
        anInt1038 = -1;
        anInt1041 = 0;
        anInt1036 = 50;
        itemSelectionState = 0;
        aString1009 = null;
        spellSelected = false;
        selectedSpellComponentIndex = -1;
        anInt1052 = -1;
        aString1049 = null;
        aString1051 = null;
        rootInterfaceIndex = -1;
        interfaceNodes = new NodeTable(8);
        anInt1047 = 0;
        anInt1059 = -1;
        anInt1045 = 0;
        anInt1054 = 0;
        pleaseWaitComponent = null;
        energy = 0;
        weight = 0;
        rights = 0;
        anInt1053 = -1;
        aBoolean1056 = false;
        anInterfaceComponent1055 = null;
        draggedComponent = null;
        topLevelOfDraggedComponent = null;
        currentComponentDragX = 0;
        currentComponentDragY = 0;
        anInterfaceComponent1058 = null;
        aBoolean1070 = false;
        anInt1060 = -1;
        anInt1069 = -1;
        aBoolean1067 = false;
        anInt1068 = -1;
        anInt1073 = -1;
        aBoolean1062 = false;
        anInt1075 = 1;
        anIntArray1076 = new int[32];
        anInt1064 = 0;
        inventories = new int[32];
        anInt1078 = 0;
        anIntArray1079 = new int[32];
        anInt1063 = 0;
        anInt1066 = 0;
        anInt1065 = 0;
        anInt1061 = 0;
        anInt1071 = 0;
        anInt1077 = 0;
        anInt1074 = 0;
        anInt1086 = 0;
        aNodeDeque1082 = new NodeDeque();
        aNodeDeque1088 = new NodeDeque();
        aNodeDeque1080 = new NodeDeque();
        interfaceConfigs = new NodeTable(512);
        anInt1085 = 0;
        anInt1084 = -2;
        aBooleanArray1089 = new boolean[100];
        aBooleanArray1087 = new boolean[100];
        aBooleanArray1083 = new boolean[100];
        interfacePositionsX = new int[100];
        interfacePositionsY = new int[100];
        interfaceWidths = new int[100];
        interfaceHeights = new int[100];
        redrawMode = 0;
        aLong1081 = 0L;
        aBoolean1090 = true;
        anIntArray1094 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
        publicChatMode = 0;
        tradeChatMode = 0;
        aString1091 = "";
        aLongArray896 = new long[100];
        anInt891 = 0;
        anInt1092 = 0;
        anIntArray1097 = new int[128];
        anIntArray1096 = new int[128];
        aLong1095 = -1L;
        minimapFloorLevel = -1;
        anInt895 = 0;
        anIntArray892 = new int[1000];
        anIntArray894 = new int[1000];
        aSpriteArray1093 = new Sprite[1000];
        destinationX = 0;
        destinationY = 0;
        mapState = 0;
        anInt900 = 255;
        anInt898 = -1;
        aBoolean904 = false;
        anInt901 = 127;
        anInt897 = 127;
        anInt903 = 0;
        anIntArray899 = new int[50];
        anIntArray905 = new int[50];
        anIntArray906 = new int[50];
        anIntArray902 = new int[50];
        audioEffects = new AudioEffect[50];
        cameraLocked = false;
        aBooleanArray919 = new boolean[5];
        anIntArray917 = new int[5];
        anIntArray918 = new int[5];
        anIntArray914 = new int[5];
        anIntArray916 = new int[5];
        aShort922 = 256;
        aShort912 = 205;
        aShort913 = 256;
        aShort920 = 320;
        aShort915 = 1;
        aShort907 = 32767;
        aShort910 = 1;
        aShort921 = 32767;
        anInt909 = 0;
        anInt908 = 0;
        viewportWidth = 0;
        viewportHeight = 0;
        viewportScale = 0;
        aPlayerAppearance924 = new PlayerAppearance();
        anInt930 = -1;
        anInt931 = -1;
        aOperatingSystemProvider_935 = new DefaultOperatingSystemProvider();
        grandExchangeOffers = new GrandExchangeOffer[8];
        aClass38_936 = new Class38();
        anInt929 = -1;
        anArrayList928 = new ArrayList(10);
        anInt926 = 0;
        anInt933 = 0;
        aClass123_Sub1_940 = new Class123_Sub1();
        anIntArray945 = new int[50];
        anIntArray942 = new int[50];
    }

    public static void method749() {
        if (Mouse.instance != null) {
            synchronized (Mouse.instance) {
                Mouse.instance = null;
            }
        }

    }

    static void processAudioEffects() {
        for (int i = 0; i < anInt903; ++i) {
            if (anIntArray906[i] >= -10) {
                AudioEffect effect = audioEffects[i];
                if (effect == null) {
                    effect = AudioEffect.load(Class74.aCacheReferenceTable586, anIntArray899[i], 0);
                    if (effect == null) {
                        continue;
                    }

                    int[] var13 = anIntArray906;
                    var13[i] += effect.method1521();
                    audioEffects[i] = effect;
                }

                if (anIntArray906[i] < 0) {
                    int var9;
                    if (anIntArray902[i] != 0) {
                        int var3 = (anIntArray902[i] & 255) * 128;
                        int var4 = anIntArray902[i] >> 16 & 255;
                        int var5 = var4 * 128 + 64 - PlayerEntity.local.fineX;
                        if (var5 < 0) {
                            var5 = -var5;
                        }

                        int var6 = anIntArray902[i] >> 8 & 255;
                        int var7 = var6 * 128 + 64 - PlayerEntity.local.fineY;
                        if (var7 < 0) {
                            var7 = -var7;
                        }

                        int var8 = var5 + var7 - 128;
                        if (var8 > var3) {
                            anIntArray906[i] = -100;
                            continue;
                        }

                        if (var8 < 0) {
                            var8 = 0;
                        }

                        var9 = (var3 - var8) * anInt897 / var3;
                    } else {
                        var9 = anInt901;
                    }

                    if (var9 > 0) {
                        Node_Sub10_Sub1 var10 = effect.method1523().method349(Class49.aClass98_446);
                        Node_Sub6_Sub2 var11 = Node_Sub6_Sub2.method598(var10, 100, var9);
                        var11.method585(anIntArray905[i] - 1);
                        Class65.aClass5_Sub6_Sub1_528.method312(var11);
                    }

                    anIntArray906[i] = -100;
                }
            } else {
                --anInt903;

                for (int var1 = i; var1 < anInt903; ++var1) {
                    anIntArray899[var1] = anIntArray899[var1 + 1];
                    audioEffects[var1] = audioEffects[var1 + 1];
                    anIntArray905[var1] = anIntArray905[var1 + 1];
                    anIntArray906[var1] = anIntArray906[var1 + 1];
                    anIntArray902[var1] = anIntArray902[var1 + 1];
                }

                --i;
            }
        }

        if (aBoolean904) {
            boolean var12;
            if (Class147.anInt1157 != 0) {
                var12 = true;
            } else {
                var12 = Class30.aClass5_Sub6_Sub3_326.method684();
            }

            if (!var12) {
                if (anInt900 != 0 && anInt898 != -1) {
                    Class61.method344(Statics15.aCacheReferenceTable1234, anInt898, 0, anInt900, false);
                }

                aBoolean904 = false;
            }
        }

    }

    static void processObjectSpawns() {
        for (PendingSpawn var0 = (PendingSpawn) pendingSpawns.head(); var0 != null; var0 = (PendingSpawn) pendingSpawns.next()) {
            if (var0.hitpoints > 0) {
                --var0.hitpoints;
            }

            int var1;
            int var2;
            ObjectDefinition var3;
            boolean var4;
            if (var0.hitpoints == 0) {
                if (var0.anInt380 >= 0) {
                    var1 = var0.anInt380;
                    var2 = var0.anInt375;
                    var3 = Class38.getObjectDefinition(var1);
                    if (var2 == 11) {
                        var2 = 10;
                    }

                    if (var2 >= 5 && var2 <= 8) {
                        var2 = 4;
                    }

                    var4 = var3.method1106(var2);
                    if (!var4) {
                        continue;
                    }
                }

                Class73.method404(var0.floorLevel, var0.type, var0.sceneX, var0.sceneY, var0.anInt380, var0.anInt112, var0.anInt375);
                var0.unlink();
            } else {
                if (var0.delay > 0) {
                    --var0.delay;
                }

                if (var0.delay == 0 && var0.sceneX >= 1 && var0.sceneY >= 1 && var0.sceneX <= 102 && var0.sceneY <= 102) {
                    if (var0.anInt693 >= 0) {
                        var1 = var0.anInt693;
                        var2 = var0.anInt564;
                        var3 = Class38.getObjectDefinition(var1);
                        if (var2 == 11) {
                            var2 = 10;
                        }

                        if (var2 >= 5 && var2 <= 8) {
                            var2 = 4;
                        }

                        var4 = var3.method1106(var2);
                        if (!var4) {
                            continue;
                        }
                    }

                    Class73.method404(var0.floorLevel, var0.type, var0.sceneX, var0.sceneY, var0.anInt693, var0.orientation, var0.anInt564);
                    var0.delay = -1;
                    if (var0.anInt380 == var0.anInt693 && var0.anInt380 == -1) {
                        var0.unlink();
                    } else if (var0.anInt693 == var0.anInt380 && var0.anInt112 == var0.orientation && var0.anInt375 == var0.anInt564) {
                        var0.unlink();
                    }
                }
            }
        }

    }

    static void dropConnection() {
        if (logoutTimer > 0) {
            DynamicObject.method1506();
        } else {
            aClass180_967.dropConnection();
            MouseRecorder.setGameState(40);
            Class24.aConnection299 = connectionContext.unwrap();
            connectionContext.kill();
        }
    }

    static void processPlayers() {
        int var0 = GPI.playerCount;
        int[] var1 = GPI.playerIndices;

        for (int var2 = 0; var2 < var0; ++var2) {
            PlayerEntity var3 = players[var1[var2]];
            if (var3 != null) {
                PathingEntity.method1320(var3);
            }
        }

    }

    static void processNpcs() {
        for (int var0 = 0; var0 < npcCount; ++var0) {
            int var1 = npcIndices[var0];
            NpcEntity var2 = npcs[var1];
            if (var2 != null) {
                PathingEntity.method1320(var2);
            }
        }

    }

    static int isResizable() {
        return aBoolean1090 ? 2 : 1;
    }

    static void processAction(int secondary, int tertiary, int opcode, int primary, String action, int crosshairX, int crosshairY) {
        if (opcode >= 2000) {
            opcode -= 2000;
        }

        OutgoingPacket packet;
        if (opcode == 1) {
            client.crosshairX = crosshairX;
            client.crosshairY = crosshairY;
            crosshairState = 2;
            anInt1017 = 0;
            destinationX = secondary;
            destinationY = tertiary;
            packet = OutgoingPacket.prepare(OutgoingPacketMeta.USE_ITEM_ON_OBJECT, connectionContext.encryptor);
            packet.buffer.writeLEShort(Statics18.baseX + secondary);
            packet.buffer.writeShort(Statics36.baseY + tertiary);
            packet.buffer.writeShortA(Class63.anInt513);
            packet.buffer.writeIMEInt(Class87.selectedItemComponentUid);
            packet.buffer.writeShort(Class12.selectedItemId);
            packet.buffer.writeLEShortA(primary);
            packet.buffer.writeNegatedByte(Keyboard.heldKeys[82] ? 1 : 0);
            connectionContext.writeLater(packet);
        } else if (opcode == 2) {
            client.crosshairX = crosshairX;
            client.crosshairY = crosshairY;
            crosshairState = 2;
            anInt1017 = 0;
            destinationX = secondary;
            destinationY = tertiary;
            packet = OutgoingPacket.prepare(OutgoingPacketMeta.USE_SPELL_ON_OBJECT, connectionContext.encryptor);
            packet.buffer.writeInt(ActionPrioritySetting.selectedSpellComponentUid);
            packet.buffer.writeByte(Keyboard.heldKeys[82] ? 1 : 0);
            packet.buffer.writeShort(Statics36.baseY + tertiary);
            packet.buffer.writeLEShortA(primary);
            packet.buffer.writeShort(Statics18.baseX + secondary);
            packet.buffer.writeShortA(selectedSpellComponentIndex);
            connectionContext.writeLater(packet);
        } else if (opcode == 3) {
            client.crosshairX = crosshairX;
            client.crosshairY = crosshairY;
            crosshairState = 2;
            anInt1017 = 0;
            destinationX = secondary;
            destinationY = tertiary;
            packet = OutgoingPacket.prepare(OutgoingPacketMeta.OBJECT_ACTION_0, connectionContext.encryptor);
            packet.buffer.writeNegatedByte(Keyboard.heldKeys[82] ? 1 : 0);
            packet.buffer.writeShort(primary);
            packet.buffer.writeShortA(Statics36.baseY + tertiary);
            packet.buffer.writeLEShortA(Statics18.baseX + secondary);
            connectionContext.writeLater(packet);
        } else if (opcode == 4) {
            client.crosshairX = crosshairX;
            client.crosshairY = crosshairY;
            crosshairState = 2;
            anInt1017 = 0;
            destinationX = secondary;
            destinationY = tertiary;
            packet = OutgoingPacket.prepare(OutgoingPacketMeta.OBJECT_ACTION_1, connectionContext.encryptor);
            packet.buffer.writeLEShortA(primary);
            packet.buffer.writeShort(Statics18.baseX + secondary);
            packet.buffer.writeByteS(Keyboard.heldKeys[82] ? 1 : 0);
            packet.buffer.writeShortA(Statics36.baseY + tertiary);
            connectionContext.writeLater(packet);
        } else if (opcode == 5) {
            client.crosshairX = crosshairX;
            client.crosshairY = crosshairY;
            crosshairState = 2;
            anInt1017 = 0;
            destinationX = secondary;
            destinationY = tertiary;
            packet = OutgoingPacket.prepare(OutgoingPacketMeta.OBJECT_ACTION_2, connectionContext.encryptor);
            packet.buffer.writeShort(primary);
            packet.buffer.writeShortA(Statics18.baseX + secondary);
            packet.buffer.writeLEShortA(Statics36.baseY + tertiary);
            packet.buffer.method1058(Keyboard.heldKeys[82] ? 1 : 0);
            connectionContext.writeLater(packet);
        } else if (opcode == 6) {
            client.crosshairX = crosshairX;
            client.crosshairY = crosshairY;
            crosshairState = 2;
            anInt1017 = 0;
            destinationX = secondary;
            destinationY = tertiary;
            packet = OutgoingPacket.prepare(OutgoingPacketMeta.OBJECT_ACTION_3, connectionContext.encryptor);
            packet.buffer.writeShort(Statics18.baseX + secondary);
            packet.buffer.writeNegatedByte(Keyboard.heldKeys[82] ? 1 : 0);
            packet.buffer.writeShortA(primary);
            packet.buffer.writeShortA(Statics36.baseY + tertiary);
            connectionContext.writeLater(packet);
        } else {
            OutgoingPacket var10;
            NpcEntity var14;
            if (opcode == 7) {
                var14 = npcs[primary];
                if (var14 != null) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    anInt1017 = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    var10 = OutgoingPacket.prepare(OutgoingPacketMeta.USE_ITEM_ON_NPC, connectionContext.encryptor);
                    var10.buffer.writeLEInt(Class87.selectedItemComponentUid);
                    var10.buffer.writeLEShortA(Class63.anInt513);
                    var10.buffer.writeShortA(primary);
                    var10.buffer.writeLEShortA(Class12.selectedItemId);
                    var10.buffer.writeByteS(Keyboard.heldKeys[82] ? 1 : 0);
                    connectionContext.writeLater(var10);
                }
            } else if (opcode == 8) {
                var14 = npcs[primary];
                if (var14 != null) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    anInt1017 = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    var10 = OutgoingPacket.prepare(OutgoingPacketMeta.USE_SPELL_ON_NPC, connectionContext.encryptor);
                    var10.buffer.writeLEShort(selectedSpellComponentIndex);
                    var10.buffer.writeLEShort(primary);
                    var10.buffer.writeLEInt(ActionPrioritySetting.selectedSpellComponentUid);
                    var10.buffer.writeByte(Keyboard.heldKeys[82] ? 1 : 0);
                    connectionContext.writeLater(var10);
                }
            } else if (opcode == 9) {
                var14 = npcs[primary];
                if (var14 != null) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    anInt1017 = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    var10 = OutgoingPacket.prepare(OutgoingPacketMeta.NPC_ACTION_0, connectionContext.encryptor);
                    var10.buffer.writeByteS(Keyboard.heldKeys[82] ? 1 : 0);
                    var10.buffer.writeLEShort(primary);
                    connectionContext.writeLater(var10);
                }
            } else if (opcode == 10) {
                var14 = npcs[primary];
                if (var14 != null) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    anInt1017 = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    var10 = OutgoingPacket.prepare(OutgoingPacketMeta.NPC_ACTION_1, connectionContext.encryptor);
                    var10.buffer.writeByteS(Keyboard.heldKeys[82] ? 1 : 0);
                    var10.buffer.writeShortA(primary);
                    connectionContext.writeLater(var10);
                }
            } else if (opcode == 11) {
                var14 = npcs[primary];
                if (var14 != null) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    anInt1017 = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    var10 = OutgoingPacket.prepare(OutgoingPacketMeta.NPC_ACTION_2, connectionContext.encryptor);
                    var10.buffer.writeByte(Keyboard.heldKeys[82] ? 1 : 0);
                    var10.buffer.writeLEShort(primary);
                    connectionContext.writeLater(var10);
                }
            } else if (opcode == 12) {
                var14 = npcs[primary];
                if (var14 != null) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    anInt1017 = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    var10 = OutgoingPacket.prepare(OutgoingPacketMeta.NPC_ACTION_3, connectionContext.encryptor);
                    var10.buffer.writeByte(Keyboard.heldKeys[82] ? 1 : 0);
                    var10.buffer.writeLEShort(primary);
                    connectionContext.writeLater(var10);
                }
            } else if (opcode == 13) {
                var14 = npcs[primary];
                if (var14 != null) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    anInt1017 = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    var10 = OutgoingPacket.prepare(OutgoingPacketMeta.NPC_ACTION_4, connectionContext.encryptor);
                    var10.buffer.writeByteS(Keyboard.heldKeys[82] ? 1 : 0);
                    var10.buffer.writeLEShort(primary);
                    connectionContext.writeLater(var10);
                }
            } else {
                PlayerEntity var16;
                if (opcode == 14) {
                    var16 = players[primary];
                    if (var16 != null) {
                        client.crosshairX = crosshairX;
                        client.crosshairY = crosshairY;
                        crosshairState = 2;
                        anInt1017 = 0;
                        destinationX = secondary;
                        destinationY = tertiary;
                        var10 = OutgoingPacket.prepare(OutgoingPacketMeta.USE_ITEM_ON_PLAYER, connectionContext.encryptor);
                        var10.buffer.writeLEShortA(primary);
                        var10.buffer.writeIMEInt(Class87.selectedItemComponentUid);
                        var10.buffer.writeShort(Class63.anInt513);
                        var10.buffer.writeLEShort(Class12.selectedItemId);
                        var10.buffer.writeByte(Keyboard.heldKeys[82] ? 1 : 0);
                        connectionContext.writeLater(var10);
                    }
                } else if (opcode == 15) {
                    var16 = players[primary];
                    if (var16 != null) {
                        client.crosshairX = crosshairX;
                        client.crosshairY = crosshairY;
                        crosshairState = 2;
                        anInt1017 = 0;
                        destinationX = secondary;
                        destinationY = tertiary;
                        var10 = OutgoingPacket.prepare(OutgoingPacketMeta.USE_SPELL_ON_PLAYER, connectionContext.encryptor);
                        var10.buffer.writeLEShort(primary);
                        var10.buffer.writeShortA(selectedSpellComponentIndex);
                        var10.buffer.writeByte(Keyboard.heldKeys[82] ? 1 : 0);
                        var10.buffer.method1014(ActionPrioritySetting.selectedSpellComponentUid);
                        connectionContext.writeLater(var10);
                    }
                } else if (opcode == 16) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    anInt1017 = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    packet = OutgoingPacket.prepare(OutgoingPacketMeta.USE_ITEM_ON_PICKABLE, connectionContext.encryptor);
                    packet.buffer.writeLEShortA(primary);
                    packet.buffer.writeInt(Class87.selectedItemComponentUid);
                    packet.buffer.writeShortA(Class12.selectedItemId);
                    packet.buffer.writeLEShortA(Statics36.baseY + tertiary);
                    packet.buffer.writeByteS(Keyboard.heldKeys[82] ? 1 : 0);
                    packet.buffer.writeShortA(Statics18.baseX + secondary);
                    packet.buffer.writeShortA(Class63.anInt513);
                    connectionContext.writeLater(packet);
                } else if (opcode == 17) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    anInt1017 = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    packet = OutgoingPacket.prepare(OutgoingPacketMeta.USE_SPELL_ON_PICKABLE, connectionContext.encryptor);
                    packet.buffer.writeShortA(Statics36.baseY + tertiary);
                    packet.buffer.writeLEInt(ActionPrioritySetting.selectedSpellComponentUid);
                    packet.buffer.writeLEShortA(primary);
                    packet.buffer.writeShortA(selectedSpellComponentIndex);
                    packet.buffer.writeLEShort(Statics18.baseX + secondary);
                    packet.buffer.method1058(Keyboard.heldKeys[82] ? 1 : 0);
                    connectionContext.writeLater(packet);
                } else if (opcode == 18) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    anInt1017 = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    packet = OutgoingPacket.prepare(OutgoingPacketMeta.PICKABLE_ACTION_0, connectionContext.encryptor);
                    packet.buffer.writeByteS(Keyboard.heldKeys[82] ? 1 : 0);
                    packet.buffer.writeLEShort(Statics36.baseY + tertiary);
                    packet.buffer.writeShortA(Statics18.baseX + secondary);
                    packet.buffer.writeLEShortA(primary);
                    connectionContext.writeLater(packet);
                } else if (opcode == 19) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    anInt1017 = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    packet = OutgoingPacket.prepare(OutgoingPacketMeta.PICKABLE_ACTION_1, connectionContext.encryptor);
                    packet.buffer.method1058(Keyboard.heldKeys[82] ? 1 : 0);
                    packet.buffer.writeShortA(Statics18.baseX + secondary);
                    packet.buffer.writeShortA(primary);
                    packet.buffer.writeShortA(Statics36.baseY + tertiary);
                    connectionContext.writeLater(packet);
                } else if (opcode == 20) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    anInt1017 = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    packet = OutgoingPacket.prepare(OutgoingPacketMeta.PICKABLE_ACTION_2, connectionContext.encryptor);
                    packet.buffer.writeNegatedByte(Keyboard.heldKeys[82] ? 1 : 0);
                    packet.buffer.writeLEShortA(Statics18.baseX + secondary);
                    packet.buffer.writeShortA(Statics36.baseY + tertiary);
                    packet.buffer.writeLEShort(primary);
                    connectionContext.writeLater(packet);
                } else if (opcode == 21) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    anInt1017 = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    packet = OutgoingPacket.prepare(OutgoingPacketMeta.PICKABLE_ACTION_3, connectionContext.encryptor);
                    packet.buffer.writeLEShortA(Statics18.baseX + secondary);
                    packet.buffer.writeShortA(Statics36.baseY + tertiary);
                    packet.buffer.writeByteS(Keyboard.heldKeys[82] ? 1 : 0);
                    packet.buffer.writeShort(primary);
                    connectionContext.writeLater(packet);
                } else if (opcode == 22) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    anInt1017 = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    packet = OutgoingPacket.prepare(OutgoingPacketMeta.PICKABLE_ACTION_4, connectionContext.encryptor);
                    packet.buffer.writeLEShort(Statics18.baseX + secondary);
                    packet.buffer.writeLEShort(Statics36.baseY + tertiary);
                    packet.buffer.writeLEShortA(primary);
                    packet.buffer.writeByteS(Keyboard.heldKeys[82] ? 1 : 0);
                    connectionContext.writeLater(packet);
                } else if (opcode == 23) {
                    if (menuOpen) {
                        sceneGraph.method1443();
                    } else {
                        sceneGraph.method1451(SceneGraph.floorLevel, secondary, tertiary, true);
                    }
                } else {
                    OutgoingPacket var12;
                    InterfaceComponent var17;
                    if (opcode == 24) {
                        var17 = InterfaceComponent.lookup(tertiary);
                        boolean var11 = true;
                        if (var17.contentType > 0) {
                            var11 = Class11.method96(var17);
                        }

                        if (var11) {
                            var12 = OutgoingPacket.prepare(OutgoingPacketMeta.BUTTON_ACTION, connectionContext.encryptor);
                            var12.buffer.writeInt(tertiary);
                            connectionContext.writeLater(var12);
                        }
                    } else {
                        if (opcode == 25) {
                            var17 = InterfaceComponent.lookup(tertiary, secondary);
                            if (var17 != null) {
                                Statics17.processSelectedSpell();
                                Class8.selectSpell(tertiary, secondary, Class87.getComponentSpellTargets(InterfaceComponent.getConfig(var17)), var17.itemId);
                                itemSelectionState = 0;
                                aString1049 = Enum_Sub8.method1091(var17);
                                if (aString1049 == null) {
                                    aString1049 = "null";
                                }

                                if (var17.aBoolean562) {
                                    aString1051 = var17.name + World.getColorTags(16777215);
                                } else {
                                    aString1051 = World.getColorTags(65280) + var17.spellName + World.getColorTags(16777215);
                                }
                            }

                            return;
                        }

                        if (opcode == 26) {
                            InterfaceComponent.closeInterface();
                        } else {
                            int var13;
                            InterfaceComponent var15;
                            if (opcode == 28) {
                                packet = OutgoingPacket.prepare(OutgoingPacketMeta.BUTTON_ACTION, connectionContext.encryptor);
                                packet.buffer.writeInt(tertiary);
                                connectionContext.writeLater(packet);
                                var15 = InterfaceComponent.lookup(tertiary);
                                if (var15.functionOpcodes != null && var15.functionOpcodes[0][0] == 5) {
                                    var13 = var15.functionOpcodes[0][1];
                                    Varps.values[var13] = 1 - Varps.values[var13];
                                    OldConnection.method712(var13);
                                }
                            } else if (opcode == 29) {
                                packet = OutgoingPacket.prepare(OutgoingPacketMeta.BUTTON_ACTION, connectionContext.encryptor);
                                packet.buffer.writeInt(tertiary);
                                connectionContext.writeLater(packet);
                                var15 = InterfaceComponent.lookup(tertiary);
                                if (var15.functionOpcodes != null && var15.functionOpcodes[0][0] == 5) {
                                    var13 = var15.functionOpcodes[0][1];
                                    if (Varps.values[var13] != var15.anIntArray1395[0]) {
                                        Varps.values[var13] = var15.anIntArray1395[0];
                                        OldConnection.method712(var13);
                                    }
                                }
                            } else if (opcode == 30) {
                                if (pleaseWaitComponent == null) {
                                    Class135.writeDialogActionPacket(tertiary, secondary);
                                    pleaseWaitComponent = InterfaceComponent.lookup(tertiary, secondary);
                                    Enum_Sub2.repaintComponent(pleaseWaitComponent);
                                }
                            } else if (opcode == 31) {
                                packet = OutgoingPacket.prepare(OutgoingPacketMeta.USE_ITEM_ON_ITEM, connectionContext.encryptor);
                                packet.buffer.writeIMEInt(tertiary);
                                packet.buffer.writeLEShortA(Class12.selectedItemId);
                                packet.buffer.writeInt(Class87.selectedItemComponentUid);
                                packet.buffer.writeShort(Class63.anInt513);
                                packet.buffer.writeShort(secondary);
                                packet.buffer.writeShort(primary);
                                connectionContext.writeLater(packet);
                                anInt1018 = 0;
                                Class38.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                anInt1015 = secondary;
                            } else if (opcode == 32) {
                                packet = OutgoingPacket.prepare(OutgoingPacketMeta.USE_SPELL_ON_ITEM, connectionContext.encryptor);
                                packet.buffer.writeLEShortA(selectedSpellComponentIndex);
                                packet.buffer.writeLEShort(secondary);
                                packet.buffer.writeLEShort(primary);
                                packet.buffer.writeIMEInt(tertiary);
                                packet.buffer.method1014(ActionPrioritySetting.selectedSpellComponentUid);
                                connectionContext.writeLater(packet);
                                anInt1018 = 0;
                                Class38.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                anInt1015 = secondary;
                            } else if (opcode == 33) {
                                packet = OutgoingPacket.prepare(OutgoingPacketMeta.ITEM_ACTION_0, connectionContext.encryptor);
                                packet.buffer.writeInt(tertiary);
                                packet.buffer.writeLEShort(secondary);
                                packet.buffer.writeLEShort(primary);
                                connectionContext.writeLater(packet);
                                anInt1018 = 0;
                                Class38.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                anInt1015 = secondary;
                            } else if (opcode == 34) {
                                packet = OutgoingPacket.prepare(OutgoingPacketMeta.ITEM_ACTION_1, connectionContext.encryptor);
                                packet.buffer.writeInt(tertiary);
                                packet.buffer.writeLEShort(secondary);
                                packet.buffer.writeShortA(primary);
                                connectionContext.writeLater(packet);
                                anInt1018 = 0;
                                Class38.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                anInt1015 = secondary;
                            } else if (opcode == 35) {
                                packet = OutgoingPacket.prepare(OutgoingPacketMeta.ITEM_ACTION_2, connectionContext.encryptor);
                                packet.buffer.writeLEShort(primary);
                                packet.buffer.writeLEInt(tertiary);
                                packet.buffer.writeShort(secondary);
                                connectionContext.writeLater(packet);
                                anInt1018 = 0;
                                Class38.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                anInt1015 = secondary;
                            } else if (opcode == 36) {
                                packet = OutgoingPacket.prepare(OutgoingPacketMeta.ITEM_ACTION_3, connectionContext.encryptor);
                                packet.buffer.writeLEShortA(primary);
                                packet.buffer.writeLEShort(secondary);
                                packet.buffer.writeIMEInt(tertiary);
                                connectionContext.writeLater(packet);
                                anInt1018 = 0;
                                Class38.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                anInt1015 = secondary;
                            } else if (opcode == 37) {
                                packet = OutgoingPacket.prepare(OutgoingPacketMeta.ITEM_ACTION_4, connectionContext.encryptor);
                                packet.buffer.writeShortA(secondary);
                                packet.buffer.writeIMEInt(tertiary);
                                packet.buffer.writeShortA(primary);
                                connectionContext.writeLater(packet);
                                anInt1018 = 0;
                                Class38.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                anInt1015 = secondary;
                            } else {
                                if (opcode == 38) {
                                    Statics17.processSelectedSpell();
                                    var17 = InterfaceComponent.lookup(tertiary);
                                    itemSelectionState = 1;
                                    Class12.selectedItemId = secondary;
                                    Class87.selectedItemComponentUid = tertiary;
                                    Class63.anInt513 = primary;
                                    Enum_Sub2.repaintComponent(var17);
                                    aString1009 = World.getColorTags(16748608) + CameraCapture.getItemDefinition(primary).name + World.getColorTags(16777215);
                                    if (aString1009 == null) {
                                        aString1009 = "null";
                                    }

                                    return;
                                }

                                if (opcode == 39) {
                                    packet = OutgoingPacket.prepare(OutgoingPacketMeta.TABLE_ACTION_0, connectionContext.encryptor);
                                    packet.buffer.writeShortA(secondary);
                                    packet.buffer.writeShort(primary);
                                    packet.buffer.method1014(tertiary);
                                    connectionContext.writeLater(packet);
                                    anInt1018 = 0;
                                    Class38.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                    anInt1015 = secondary;
                                } else if (opcode == 40) {
                                    packet = OutgoingPacket.prepare(OutgoingPacketMeta.TABLE_ACTION_1, connectionContext.encryptor);
                                    packet.buffer.writeIMEInt(tertiary);
                                    packet.buffer.writeShortA(secondary);
                                    packet.buffer.writeLEShortA(primary);
                                    connectionContext.writeLater(packet);
                                    anInt1018 = 0;
                                    Class38.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                    anInt1015 = secondary;
                                } else if (opcode == 41) {
                                    packet = OutgoingPacket.prepare(OutgoingPacketMeta.TABLE_ACTION_2, connectionContext.encryptor);
                                    packet.buffer.writeLEShort(secondary);
                                    packet.buffer.method1014(tertiary);
                                    packet.buffer.writeLEShort(primary);
                                    connectionContext.writeLater(packet);
                                    anInt1018 = 0;
                                    Class38.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                    anInt1015 = secondary;
                                } else if (opcode == 42) {
                                    packet = OutgoingPacket.prepare(OutgoingPacketMeta.TABLE_ACTION_3, connectionContext.encryptor);
                                    packet.buffer.writeShort(primary);
                                    packet.buffer.writeShort(secondary);
                                    packet.buffer.writeIMEInt(tertiary);
                                    connectionContext.writeLater(packet);
                                    anInt1018 = 0;
                                    Class38.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                    anInt1015 = secondary;
                                } else if (opcode == 43) {
                                    packet = OutgoingPacket.prepare(OutgoingPacketMeta.TABLE_ACTION_4, connectionContext.encryptor);
                                    packet.buffer.writeShort(primary);
                                    packet.buffer.method1014(tertiary);
                                    packet.buffer.writeShort(secondary);
                                    connectionContext.writeLater(packet);
                                    anInt1018 = 0;
                                    Class38.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                    anInt1015 = secondary;
                                } else if (opcode == 44) {
                                    var16 = players[primary];
                                    if (var16 != null) {
                                        client.crosshairX = crosshairX;
                                        client.crosshairY = crosshairY;
                                        crosshairState = 2;
                                        anInt1017 = 0;
                                        destinationX = secondary;
                                        destinationY = tertiary;
                                        var10 = OutgoingPacket.prepare(OutgoingPacketMeta.PLAYER_ACTION_0, connectionContext.encryptor);
                                        var10.buffer.writeShortA(primary);
                                        var10.buffer.method1058(Keyboard.heldKeys[82] ? 1 : 0);
                                        connectionContext.writeLater(var10);
                                    }
                                } else if (opcode == 45) {
                                    var16 = players[primary];
                                    if (var16 != null) {
                                        client.crosshairX = crosshairX;
                                        client.crosshairY = crosshairY;
                                        crosshairState = 2;
                                        anInt1017 = 0;
                                        destinationX = secondary;
                                        destinationY = tertiary;
                                        var10 = OutgoingPacket.prepare(OutgoingPacketMeta.PLAYER_ACTION_1, connectionContext.encryptor);
                                        var10.buffer.writeLEShortA(primary);
                                        var10.buffer.writeByte(Keyboard.heldKeys[82] ? 1 : 0);
                                        connectionContext.writeLater(var10);
                                    }
                                } else if (opcode == 46) {
                                    var16 = players[primary];
                                    if (var16 != null) {
                                        client.crosshairX = crosshairX;
                                        client.crosshairY = crosshairY;
                                        crosshairState = 2;
                                        anInt1017 = 0;
                                        destinationX = secondary;
                                        destinationY = tertiary;
                                        var10 = OutgoingPacket.prepare(OutgoingPacketMeta.PLAYER_ACTION_2, connectionContext.encryptor);
                                        var10.buffer.writeByteS(Keyboard.heldKeys[82] ? 1 : 0);
                                        var10.buffer.writeLEShort(primary);
                                        connectionContext.writeLater(var10);
                                    }
                                } else if (opcode == 47) {
                                    var16 = players[primary];
                                    if (var16 != null) {
                                        client.crosshairX = crosshairX;
                                        client.crosshairY = crosshairY;
                                        crosshairState = 2;
                                        anInt1017 = 0;
                                        destinationX = secondary;
                                        destinationY = tertiary;
                                        var10 = OutgoingPacket.prepare(OutgoingPacketMeta.PLAYER_ACTION_3, connectionContext.encryptor);
                                        var10.buffer.writeLEShortA(primary);
                                        var10.buffer.writeNegatedByte(Keyboard.heldKeys[82] ? 1 : 0);
                                        connectionContext.writeLater(var10);
                                    }
                                } else if (opcode == 48) {
                                    var16 = players[primary];
                                    if (var16 != null) {
                                        client.crosshairX = crosshairX;
                                        client.crosshairY = crosshairY;
                                        crosshairState = 2;
                                        anInt1017 = 0;
                                        destinationX = secondary;
                                        destinationY = tertiary;
                                        var10 = OutgoingPacket.prepare(OutgoingPacketMeta.PLAYER_ACTION_4, connectionContext.encryptor);
                                        var10.buffer.writeNegatedByte(Keyboard.heldKeys[82] ? 1 : 0);
                                        var10.buffer.writeLEShort(primary);
                                        connectionContext.writeLater(var10);
                                    }
                                } else if (opcode == 49) {
                                    var16 = players[primary];
                                    if (var16 != null) {
                                        client.crosshairX = crosshairX;
                                        client.crosshairY = crosshairY;
                                        crosshairState = 2;
                                        anInt1017 = 0;
                                        destinationX = secondary;
                                        destinationY = tertiary;
                                        var10 = OutgoingPacket.prepare(OutgoingPacketMeta.PLAYER_ACTION_5, connectionContext.encryptor);
                                        var10.buffer.writeShort(primary);
                                        var10.buffer.method1058(Keyboard.heldKeys[82] ? 1 : 0);
                                        connectionContext.writeLater(var10);
                                    }
                                } else if (opcode == 50) {
                                    var16 = players[primary];
                                    if (var16 != null) {
                                        client.crosshairX = crosshairX;
                                        client.crosshairY = crosshairY;
                                        crosshairState = 2;
                                        anInt1017 = 0;
                                        destinationX = secondary;
                                        destinationY = tertiary;
                                        var10 = OutgoingPacket.prepare(OutgoingPacketMeta.PLAYER_ACTION_6, connectionContext.encryptor);
                                        var10.buffer.writeLEShort(primary);
                                        var10.buffer.method1058(Keyboard.heldKeys[82] ? 1 : 0);
                                        connectionContext.writeLater(var10);
                                    }
                                } else if (opcode == 51) {
                                    var16 = players[primary];
                                    if (var16 != null) {
                                        client.crosshairX = crosshairX;
                                        client.crosshairY = crosshairY;
                                        crosshairState = 2;
                                        anInt1017 = 0;
                                        destinationX = secondary;
                                        destinationY = tertiary;
                                        var10 = OutgoingPacket.prepare(OutgoingPacketMeta.PLAYER_ACTION_7, connectionContext.encryptor);
                                        var10.buffer.method1058(Keyboard.heldKeys[82] ? 1 : 0);
                                        var10.buffer.writeShortA(primary);
                                        connectionContext.writeLater(var10);
                                    }
                                } else {
                                    label960:
                                    {
                                        if (opcode != 57) {
                                            if (opcode == 58) {
                                                var17 = InterfaceComponent.lookup(tertiary, secondary);
                                                if (var17 != null) {
                                                    var10 = OutgoingPacket.prepare(OutgoingPacketMeta.USE_SPELL_ON_COMPONENT, connectionContext.encryptor);
                                                    var10.buffer.writeIMEInt(tertiary);
                                                    var10.buffer.writeShort(var17.itemId);
                                                    var10.buffer.writeLEInt(ActionPrioritySetting.selectedSpellComponentUid);
                                                    var10.buffer.writeLEShortA(secondary);
                                                    var10.buffer.writeShortA(selectedSpellComponentIndex);
                                                    var10.buffer.writeShortA(anInt1052);
                                                    connectionContext.writeLater(var10);
                                                }
                                                break label960;
                                            }

                                            if (opcode == 1001) {
                                                client.crosshairX = crosshairX;
                                                client.crosshairY = crosshairY;
                                                crosshairState = 2;
                                                anInt1017 = 0;
                                                destinationX = secondary;
                                                destinationY = tertiary;
                                                packet = OutgoingPacket.prepare(OutgoingPacketMeta.OBJECT_ACTION_4, connectionContext.encryptor);
                                                packet.buffer.writeShort(Statics36.baseY + tertiary);
                                                packet.buffer.writeShort(Statics18.baseX + secondary);
                                                packet.buffer.writeShort(primary);
                                                packet.buffer.method1058(Keyboard.heldKeys[82] ? 1 : 0);
                                                connectionContext.writeLater(packet);
                                                break label960;
                                            }

                                            if (opcode == 1002) {
                                                client.crosshairX = crosshairX;
                                                client.crosshairY = crosshairY;
                                                crosshairState = 2;
                                                anInt1017 = 0;
                                                packet = OutgoingPacket.prepare(OutgoingPacketMeta.EXAMINE_OBJECT, connectionContext.encryptor);
                                                packet.buffer.writeLEShort(primary);
                                                connectionContext.writeLater(packet);
                                                break label960;
                                            }

                                            if (opcode == 1003) {
                                                client.crosshairX = crosshairX;
                                                client.crosshairY = crosshairY;
                                                crosshairState = 2;
                                                anInt1017 = 0;
                                                var14 = npcs[primary];
                                                if (var14 != null) {
                                                    NpcDefinition var18 = var14.definition;
                                                    if (var18.transformIds != null) {
                                                        var18 = var18.transform();
                                                    }

                                                    if (var18 != null) {
                                                        var12 = OutgoingPacket.prepare(OutgoingPacketMeta.EXAMINE_NPC, connectionContext.encryptor);
                                                        var12.buffer.writeShortA(var18.id);
                                                        connectionContext.writeLater(var12);
                                                    }
                                                }
                                                break label960;
                                            }

                                            if (opcode == 1004) {
                                                client.crosshairX = crosshairX;
                                                client.crosshairY = crosshairY;
                                                crosshairState = 2;
                                                anInt1017 = 0;
                                                packet = OutgoingPacket.prepare(OutgoingPacketMeta.EXAMINE_ITEM, connectionContext.encryptor);
                                                packet.buffer.writeShort(primary);
                                                connectionContext.writeLater(packet);
                                                break label960;
                                            }

                                            if (opcode == 1005) {
                                                var17 = InterfaceComponent.lookup(tertiary);
                                                if (var17 != null && var17.itemStackSizes[secondary] >= 100000) {
                                                    Statics19.messageReceived(27, "", var17.itemStackSizes[secondary] + " x " + CameraCapture.getItemDefinition(primary).name);
                                                } else {
                                                    var10 = OutgoingPacket.prepare(OutgoingPacketMeta.EXAMINE_ITEM, connectionContext.encryptor);
                                                    var10.buffer.writeShort(primary);
                                                    connectionContext.writeLater(var10);
                                                }

                                                anInt1018 = 0;
                                                Class38.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                                anInt1015 = secondary;
                                                break label960;
                                            }

                                            if (opcode != 1007) {
                                                //world map sht
                                                if (opcode == 1008 || opcode == 1011 || opcode == 1009 || opcode == 1010 || opcode == 1012) {
                                                    Class44.aClass209_391.method1253(opcode, primary, new SceneOffset(secondary), new SceneOffset(tertiary));
                                                }
                                                break label960;
                                            }
                                        }

                                        var17 = InterfaceComponent.lookup(tertiary, secondary);
                                        if (var17 != null) {
                                            Class36.processComponentAction(primary, tertiary, secondary, var17.itemId, action);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (itemSelectionState != 0) {
            itemSelectionState = 0;
            Enum_Sub2.repaintComponent(InterfaceComponent.lookup(Class87.selectedItemComponentUid));
        }

        if (spellSelected) {
            Statics17.processSelectedSpell();
        }

        //maybe drag related
        if (Class38.anInterfaceComponent351 != null && anInt1018 == 0) {
            Enum_Sub2.repaintComponent(Class38.anInterfaceComponent351);
        }

    }

    void method741() {
        if (gameState != 1000) {
            boolean var1 = PlayerAppearance.loadWorlds();
            if (!var1) {
                this.method738();
            }

        }
    }

    public NamePair getNamePair() {
        return PlayerEntity.local != null ? PlayerEntity.local.namePair : null;
    }

    void method733() {
        int var1 = canvasWidth;
        int var2 = canvasHeight;
        if (this.anInt1296 < var1) {
            var1 = this.anInt1296;
        }

        if (this.anInt1312 < var2) {
            var2 = this.anInt1312;
        }

        if (preferences != null) {
            try {
                client var3 = instance;
                Object[] var4 = new Object[]{isResizable()};
                JSObject.getWindow(var3).call("resize", var4);
            } catch (Throwable ignored) {
            }
        }

    }

    protected final void method747() {
        if (Class147.aClass79_1161.method424()) {
            Class147.aClass79_1161.method434();
        }

        if (Class34.mouseRecorder != null) {
            Class34.mouseRecorder.enabled = false;
        }

        Class34.mouseRecorder = null;
        connectionContext.stop();
        Class144.method840();
        method749();
        Keyboard.aClass131_158 = null;
        if (Statics16.anAudioSystem1236 != null) {
            Statics16.anAudioSystem1236.method1329();
        }

        if (Class76.anAudioSystem599 != null) {
            Class76.anAudioSystem599.method1329();
        }

        Class82.method443();
        Class105.method614();
        if (aClass108_965 != null) {
            aClass108_965.method648();
            aClass108_965 = null;
        }

        CameraCapture.method1416();
    }

    protected final void method745() {
        int[] var1 = new int[]{20, 260, 10000};
        int[] var2 = new int[]{1000, 100, 500};
        if (var1 != null && var2 != null) {
            Class204.anIntArray1637 = var1;
            Class204.anIntArray1642 = new int[var1.length];
            EntityUID.aByteArrayArrayArray547 = new byte[var1.length][][];

            for (int var5 = 0; var5 < Class204.anIntArray1637.length; ++var5) {
                EntityUID.aByteArrayArrayArray547[var5] = new byte[var2[var5]][];
            }
        } else {
            Class204.anIntArray1637 = null;
            Class204.anIntArray1642 = null;
            EntityUID.aByteArrayArrayArray547 = null;
        }

        HitsplatDefinition.anInt1929 = anInt925 == 0 ? 43594 : currentWorld + 40000;
        Bzip2Context.anInt1579 = anInt925 == 0 ? 443 : currentWorld + 50000;
        NpcEntity.anInt823 = HitsplatDefinition.anInt1929;
        Enum_Sub9.aShortArray1482 = Statics14.aShortArray1225;
        PlayerAppearance.aShortArrayArray1928 = Statics14.aShortArrayArray1226;
        PlayerAppearance.aShortArray1927 = Statics14.aShortArray1224;
        Class12.aShortArrayArray145 = Statics14.aShortArrayArray1223;
        aClass108_965 = new Class108();
        this.method949();
        this.method938();
        Keyboard.aClass131_158 = this.method943();
        Class63_Sub2.aCacheIndex649 = new CacheIndex(255, Statics5.aBufferedFile_840, Statics5.aBufferedFile_835, 500000);
        preferences = ItemDefinition.method529();
        this.method944();
        String var4 = Class19.aString264;
        Statics1.anApplet323 = this;
        if (var4 != null) {
            Statics1.aString325 = var4;
        }

        if (anInt925 != 0) {
            aBoolean944 = true;
        }

        AssociateComparatorByMyWorld.method603(preferences.resizable);
        Class44.socialSystem = new SocialSystem(Class36.aClass213_343);
    }

    final void method734(boolean var1) {
        Statics26.method1112(rootInterfaceIndex, canvasWidth, canvasHeight, var1);
    }

    void method740(int var1) {
        Class55.aOldConnectionTask_464 = null;
        Class11.aConnection140 = null;
        anInt950 = 0;
        if (NpcEntity.anInt823 == HitsplatDefinition.anInt1929) {
            NpcEntity.anInt823 = Bzip2Context.anInt1579;
        } else {
            NpcEntity.anInt823 = HitsplatDefinition.anInt1929;
        }

        ++anInt959;
        if (anInt959 >= 2 && (var1 == 7 || var1 == 9)) {
            if (gameState <= 5) {
                this.method926("js5connect_full");
                gameState = 1000;
            } else {
                anInt949 = 3000;
            }
        } else if (anInt959 >= 2 && var1 == 6) {
            this.method926("js5connect_outofdate");
            gameState = 1000;
        } else if (anInt959 >= 4) {
            if (gameState <= 5) {
                this.method926("js5connect");
                gameState = 1000;
            } else {
                anInt949 = 3000;
            }
        }

    }

    final boolean method731() {
        int var1 = AssociateComparatorByRank.method679();
        return (anInt1034 == 1 && menuRowCount > 2 || DefinitionProperty.method261(var1)) && !menuShiftClickActions[var1];
    }

    protected final void method743() {

    }

    private boolean readIncomingPacket(Connection connection, PacketBuffer incoming) throws IOException {
        if (client.connectionContext.alive) {
            if (!connection.available(1)) {
                return false;
            }

            connection.readBytes(client.connectionContext.inbuffer.payload, 0, 1);
            client.connectionContext.idleReadTicks = 0;
            client.connectionContext.alive = false;
        }

        incoming.caret = 0;
        if (incoming.method258()) {
            if (!connection.available(1)) {
                return false;
            }

            connection.readBytes(client.connectionContext.inbuffer.payload, 1, 1);
            client.connectionContext.idleReadTicks = 0;
        }

        client.connectionContext.alive = true;
        IncomingPacketMeta[] incomingPacketTypes = IncomingPacketMeta.values();
        int packetIndex = incoming.method1396();
        if (packetIndex < 0 || packetIndex >= incomingPacketTypes.length) {
            throw new IOException(packetIndex + " " + incoming.caret);
        }

        client.connectionContext.currentIncomingPacket = incomingPacketTypes[packetIndex];
        client.connectionContext.incomingPacketSize = client.connectionContext.currentIncomingPacket.size;
        return true;
    }

    final boolean processIncomingPacket() {
        Connection connection = client.connectionContext.unwrap();
        PacketBuffer incoming = client.connectionContext.inbuffer;
        if (connection == null) {
            return false;
        }

        int var7;
        StringBuilder var33;
        int var5;

        try {
            if (client.connectionContext.currentIncomingPacket == null && !readIncomingPacket(connection, incoming)) {
                return false;
            }

            if (client.connectionContext.incomingPacketSize == -1) {
                if (!connection.available(1)) {
                    return false;
                }

                client.connectionContext.unwrap().readBytes(incoming.payload, 0, 1);
                client.connectionContext.incomingPacketSize = incoming.payload[0] & 0xff;
            }

            if (client.connectionContext.incomingPacketSize == -2) {
                if (!connection.available(2)) {
                    return false;
                }

                client.connectionContext.unwrap().readBytes(incoming.payload, 0, 2);
                incoming.caret = 0;
                client.connectionContext.incomingPacketSize = incoming.readUShort();
            }

            if (!connection.available(client.connectionContext.incomingPacketSize)) {
                return false;
            }

            incoming.caret = 0;
            connection.readBytes(incoming.payload, 0, client.connectionContext.incomingPacketSize);
            client.connectionContext.idleReadTicks = 0;
            aClass180_967.updateTime();

            client.connectionContext.thirdLastIncomingPacket = client.connectionContext.secondLastIncomingPacket;
            client.connectionContext.secondLastIncomingPacket = client.connectionContext.lastIncomingPacket;
            client.connectionContext.lastIncomingPacket = client.connectionContext.currentIncomingPacket;

            if (IncomingPacketMeta.anIncomingPacketMeta186 == client.connectionContext.currentIncomingPacket) {
                Class88.method479(RegionUpdateType.SPAWN_PROJECTILE);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            int var6;
            int var8;
            int var9;
            long var10;
            if (IncomingPacketMeta.UPDATE_COMPONENT_CONFIG == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.readLEUShortA();
                if (var6 == 65535) {
                    var6 = -1;
                }

                var5 = incoming.readUShort();
                if (var5 == 65535) {
                    var5 = -1;
                }

                var7 = incoming.method1015();
                var8 = incoming.method1015();

                for (var9 = var6; var9 <= var5; ++var9) {
                    var10 = ((long) var8 << 32) + (long) var9;
                    Node var45 = interfaceConfigs.lookup(var10);
                    if (var45 != null) {
                        var45.unlink();
                    }

                    interfaceConfigs.put(new IntegerNode(var7), var10);
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta228 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.readUByte();
                Statics25.method1092(var6);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            InterfaceComponent var47;
            if (IncomingPacketMeta.anIncomingPacketMeta175 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.method1070();
                var5 = incoming.method1070();
                var7 = incoming.method1015();
                var47 = InterfaceComponent.lookup(var7);
                if (var5 != var47.xMargin || var6 != var47.yMargin || var47.xLayout != 0 || var47.yLayout != 0) {
                    var47.xMargin = var5;
                    var47.yMargin = var6;
                    var47.xLayout = 0;
                    var47.yLayout = 0;
                    Enum_Sub2.repaintComponent(var47);
                    this.method742(var47);
                    if (var47.type == 0) {
                        GameEngine.method925(AssociateComparator_Sub5.interfaces[var7 >> 16], var47, false);
                    }
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta201 == client.connectionContext.currentIncomingPacket) {
                Class88.method479(RegionUpdateType.REMOVE_SCENE_OBJECT);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta217 == client.connectionContext.currentIncomingPacket) {
                anInt934 = incoming.readLEUShortA() * 30;
                anInt1074 = anInt1075;
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            boolean var42;
            if (IncomingPacketMeta.anIncomingPacketMeta232 == client.connectionContext.currentIncomingPacket) {
                var42 = incoming.readUByte() == 1;
                if (var42) {
                    EntityUID.aLong548 = Class24.currentTime() - incoming.readLong();
                    PickableNode.aClass78_890 = new Class78(incoming);
                } else {
                    PickableNode.aClass78_890 = null;
                }

                anInt1077 = anInt1075;
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta230 == client.connectionContext.currentIncomingPacket) {
                CameraCapture.method1417(incoming.readString());
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_ITEMTABLE == client.connectionContext.currentIncomingPacket) {
                int componentUid = incoming.readInt();
                int key = incoming.readUShort();
                if (componentUid < -70000) {
                    key += 32768;
                }

                InterfaceComponent component = null;
                if (componentUid >= 0) {
                    //identify this block and inject setter (either set uid or component, either works)
                    // -> client.mediator.notify(key, componentUid) to map itemtables to components
                    //unfortunately this seems to only apply to inventories which use the table layout
                    component = InterfaceComponent.lookup(componentUid);
                }

                if (component != null) {
                    for (int i = 0; i < component.itemIds.length; ++i) {
                        component.itemIds[i] = 0;
                        component.itemStackSizes[i] = 0;
                    }
                }

                Inventory.clear(key);

                int size = incoming.readUShort();
                for (int index = 0; index < size; ++index) {
                    int id = incoming.readLEUShortA();
                    int stack = incoming.method1056();
                    if (stack == 255) {
                        stack = incoming.method1015();
                    }

                    if (component != null && index < component.itemIds.length) {
                        component.itemIds[index] = id;
                        component.itemStackSizes[index] = stack;
                    }

                    Inventory.addItem(key, index, id - 1, stack);
                }

                if (component != null) {
                    Enum_Sub2.repaintComponent(component);
                }

                InterfaceNode.method1319();
                inventories[++anInt1078 - 1 & 31] = key & 32767;
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            InterfaceComponent var14;
            int var15;
            int var16;

            if (IncomingPacketMeta.anIncomingPacketMeta259 == client.connectionContext.currentIncomingPacket) {
                cameraLocked = true;
                Statics15.anInt1235 = incoming.readUByte() * 128;
                Class135.anInt889 = incoming.readUByte() * 128;
                Class38.anInt347 = incoming.readUShort();
                MouseRecorder.anInt388 = incoming.readUByte();
                Class64.anInt520 = incoming.readUByte();
                if (Class64.anInt520 >= 100) {
                    Class38.cameraX = Statics15.anInt1235 * 16384 + 64;
                    Class27_Sub1.cameraY = Class135.anInt889 * 16384 + 64;
                    Class79.cameraZ = SceneGraph.getTileHeight(Class38.cameraX, Class27_Sub1.cameraY, SceneGraph.floorLevel) - Class38.anInt347;
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta202 == client.connectionContext.currentIncomingPacket) {
                Class88.method479(RegionUpdateType.A_REGION_UPDATE_TYPE___1205);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta178 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.readInt();
                var5 = incoming.readInt();
                var7 = Class80.method437();
                OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta33, connectionContext.encryptor);
                packet.buffer.writeNegatedByte(var7);
                packet.buffer.writeInt(var6);
                packet.buffer.method1014(var5);
                packet.buffer.writeByteS(anInt1292);
                connectionContext.writeLater(packet);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta224 == client.connectionContext.currentIncomingPacket) {
                InterfaceNode.method1319();
                weight = incoming.method1029();
                anInt1074 = anInt1075;
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta203 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.readInt();
                if (var6 != anInt1002) {
                    anInt1002 = var6;
                    Class114.method672();
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta250 == client.connectionContext.currentIncomingPacket) {
                if (Varps.clanSystem != null) {
                    Varps.clanSystem.method1389(incoming);
                }

                RegionUpdateType.method865();
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            InterfaceNode var13;
            InterfaceComponent var17;
            if (IncomingPacketMeta.anIncomingPacketMeta211 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.method1015();
                var5 = incoming.readInt();
                InterfaceNode var53 = (InterfaceNode) interfaceNodes.lookup((long) var5);
                var13 = (InterfaceNode) interfaceNodes.lookup((long) var6);
                if (var13 != null) {
                    Class199.method1182(var13, var53 == null || var13.id != var53.id);
                }

                if (var53 != null) {
                    var53.unlink();
                    interfaceNodes.put(var53, (long) var6);
                }

                var17 = InterfaceComponent.lookup(var5);
                if (var17 != null) {
                    Enum_Sub2.repaintComponent(var17);
                }

                var17 = InterfaceComponent.lookup(var6);
                if (var17 != null) {
                    Enum_Sub2.repaintComponent(var17);
                    GameEngine.method925(AssociateComparator_Sub5.interfaces[var17.uid >>> 16], var17, true);
                }

                if (rootInterfaceIndex != -1) {
                    Class16.method118(rootInterfaceIndex, 1);
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta210 == client.connectionContext.currentIncomingPacket) {
                Class44.socialSystem.decodeFriends(incoming, client.connectionContext.incomingPacketSize);
                anInt1065 = anInt1075;
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            long var18;
            long var20;
            long var22;
            String var38;
            if (IncomingPacketMeta.anIncomingPacketMeta238 == client.connectionContext.currentIncomingPacket) {
                var38 = incoming.readString();
                var18 = incoming.readLong();
                var20 = (long) incoming.readUShort();
                var10 = (long) incoming.readMediumInt();
                Enum_Sub6 var12 = (Enum_Sub6) OldConnection.method716(Statics13.method871(), incoming.readUByte());
                var22 = var10 + (var20 << 32);
                boolean var54 = false;

                for (int var25 = 0; var25 < 100; ++var25) {
                    if (aLongArray896[var25] == var22) {
                        var54 = true;
                        break;
                    }
                }

                if (var12.aBoolean1258 && Class44.socialSystem.isOnIgnoreList(new NamePair(var38, Class36.aClass213_343))) {
                    var54 = true;
                }

                if (!var54 && anInt1014 == 0) {
                    aLongArray896[anInt891] = var22;
                    anInt891 = (anInt891 + 1) % 100;
                    String var26 = DoublyLinkedNode_Sub24_Sub3.method1166(OldConnection.method714(Class123_Sub1.method294(incoming)));
                    if (var12.anInt1218 != -1) {
                        Class63_Sub1.messageReceived(9, Statics26.method1111(var12.anInt1218) + var38, var26, World.method1353(var18));
                    } else {
                        Class63_Sub1.messageReceived(9, var38, var26, World.method1353(var18));
                    }
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_RANDOM == client.connectionContext.currentIncomingPacket) {
                incoming.caret += 28;
                if (incoming.matchCrcs()) {
                    CacheIndex.method1489(incoming, incoming.caret - 28);
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_GRAND_EXCHANGE == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.readUByte();
                if (incoming.readUByte() == 0) {
                    grandExchangeOffers[var6] = new GrandExchangeOffer();
                    incoming.caret += 18;
                } else {
                    --incoming.caret;
                    grandExchangeOffers[var6] = new GrandExchangeOffer(incoming);
                }

                anInt1071 = anInt1075;
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta181 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.method1067();
                var5 = incoming.method1011();
                var14 = InterfaceComponent.lookup(var5);
                if (var6 != var14.anInt1357 || var6 == -1) {
                    var14.anInt1357 = var6;
                    var14.anInt1389 = 0;
                    var14.anInt1401 = 0;
                    Enum_Sub2.repaintComponent(var14);
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.SET_COMPONENT_TO_ITEM_MODEL == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.readInt();
                var5 = incoming.method1015();
                var7 = incoming.readLEUShortA();
                if (var7 == 65535) {
                    var7 = -1;
                }

                var47 = InterfaceComponent.lookup(var6);
                ItemDefinition var52;
                if (!var47.aBoolean562) {
                    if (var7 == -1) {
                        var47.modelType = 0;
                        client.connectionContext.currentIncomingPacket = null;
                        return true;
                    }

                    var52 = CameraCapture.getItemDefinition(var7);
                    var47.modelType = 4;
                    var47.modelId = var7;
                    var47.xRotation = var52.spritePitch;
                    var47.zRotation = var52.spriteRoll;
                    var47.modelZoom = var52.spriteScale * 100 / var5;
                    Enum_Sub2.repaintComponent(var47);
                } else {
                    var47.itemId = var7;
                    var47.itemStackSize = var5;
                    var52 = CameraCapture.getItemDefinition(var7);
                    var47.xRotation = var52.spritePitch;
                    var47.zRotation = var52.spriteRoll;
                    var47.yRotation = var52.spriteYaw;
                    var47.modelOffsetX = var52.spriteTranslateX;
                    var47.modelOffsetY = var52.spriteTranslateY;
                    var47.modelZoom = var52.spriteScale;
                    if (var52.stackable == 1) {
                        var47.anInt1356 = 1;
                    } else {
                        var47.anInt1356 = 2;
                    }

                    if (var47.anInt1354 > 0) {
                        var47.modelZoom = var47.modelZoom * 32 / var47.anInt1354;
                    } else if (var47.anInt694 > 0) {
                        var47.modelZoom = var47.modelZoom * 32 / var47.anInt694;
                    }

                    Enum_Sub2.repaintComponent(var47);
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.SET_COMPONENT_MODEL_TYPE2 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.method1011();
                var5 = incoming.method1055();
                var14 = InterfaceComponent.lookup(var6);
                if (var14.modelType != 2 || var5 != var14.modelId) {
                    var14.modelType = 2;
                    var14.modelId = var5;
                    Enum_Sub2.repaintComponent(var14);
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta235 == client.connectionContext.currentIncomingPacket) {
                Class88.method479(RegionUpdateType.SPAWN_GRAPHICS_OBJECT);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta180 == client.connectionContext.currentIncomingPacket) {
                var38 = incoming.readString();
                var18 = (long) incoming.readUShort();
                var20 = (long) incoming.readMediumInt();
                Enum_Sub6 var27 = (Enum_Sub6) OldConnection.method716(Statics13.method871(), incoming.readUByte());
                long var28 = (var18 << 32) + var20;
                boolean var30 = false;

                for (int var31 = 0; var31 < 100; ++var31) {
                    if (aLongArray896[var31] == var28) {
                        var30 = true;
                        break;
                    }
                }

                if (Class44.socialSystem.isOnIgnoreList(new NamePair(var38, Class36.aClass213_343))) {
                    var30 = true;
                }

                if (!var30 && anInt1014 == 0) {
                    aLongArray896[anInt891] = var28;
                    anInt891 = (anInt891 + 1) % 100;
                    String var32 = DoublyLinkedNode_Sub24_Sub3.method1166(OldConnection.method714(Class123_Sub1.method294(incoming)));
                    byte var24;
                    if (var27.aBoolean1257) {
                        var24 = 7;
                    } else {
                        var24 = 3;
                    }

                    if (var27.anInt1218 != -1) {
                        Statics19.messageReceived(var24, Statics26.method1111(var27.anInt1218) + var38, var32);
                    } else {
                        Statics19.messageReceived(var24, var38, var32);
                    }
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            InterfaceComponent var57;
            if (IncomingPacketMeta.anIncomingPacketMeta258 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.method1015();
                var57 = InterfaceComponent.lookup(var6);

                for (var7 = 0; var7 < var57.itemIds.length; ++var7) {
                    var57.itemIds[var7] = -1;
                    var57.itemIds[var7] = 0;
                }

                Enum_Sub2.repaintComponent(var57);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta184 == client.connectionContext.currentIncomingPacket) {
                InterfaceNode.updateNpcs(true, incoming);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_VARP2 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.method1019();
                var5 = incoming.readLEUShortA();
                Varps.tempVarps[var5] = var6;
                if (Varps.values[var5] != var6) {
                    Varps.values[var5] = var6;
                }

                OldConnection.method712(var5);
                anIntArray1076[++anInt1064 - 1 & 31] = var5;
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.SET_REGION_CHUNK == client.connectionContext.currentIncomingPacket) {
                SceneGraph.regionChunkX = incoming.method1072();
                SceneGraph.regionChunkY = incoming.readUByte();
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta192 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.readUByte();
                var5 = incoming.readUByte();
                var7 = incoming.readUByte();
                var8 = incoming.readUByte();
                aBooleanArray919[var6] = true;
                anIntArray917[var6] = var5;
                anIntArray918[var6] = var7;
                anIntArray914[var6] = var8;
                anIntArray916[var6] = 0;
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.SET_PLAYER_ACTION == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.method1074();
                var33 = new StringBuilder(incoming.readString());
                var7 = incoming.method1056();
                if (var7 >= 1 && var7 <= 8) {
                    if (var33.toString().equalsIgnoreCase("null")) {
                        var33 = null;
                    }

                    if (var33 != null) {
                        playerActions[var7 - 1] = var33.toString();
                        playerActionPriorities[var7 - 1] = var6 == 0;
                    }
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.SET_WORLD == client.connectionContext.currentIncomingPacket) {
                World var41 = new World();
                var41.domain = incoming.readString();
                var41.anInt1875 = incoming.readUShort();
                var5 = incoming.readInt();
                var41.mask = var5;
                MouseRecorder.setGameState(45);
                connection.stop();
                Class80.setWorld(var41);
                client.connectionContext.currentIncomingPacket = null;
                return false;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta200 == client.connectionContext.currentIncomingPacket) {
                Class44.socialSystem.method210();
                anInt1065 = anInt1075;
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.DROP_CONNECTION == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.readUByte();
                AnimationSequence.method881(var6);
                client.connectionContext.currentIncomingPacket = null;
                return false;
            }

            if (IncomingPacketMeta.UNLOCK_CAMERA == client.connectionContext.currentIncomingPacket) {
                cameraLocked = false;

                for (var6 = 0; var6 < 5; ++var6) {
                    aBooleanArray919[var6] = false;
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.ADD_PICKABLE == client.connectionContext.currentIncomingPacket) {
                Class88.method479(RegionUpdateType.ADD_PICKABLE);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta197 == client.connectionContext.currentIncomingPacket) {
                if (client.connectionContext.incomingPacketSize == 0) {
                    Varps.clanSystem = null;
                } else {
                    if (Varps.clanSystem == null) {
                        Varps.clanSystem = new ClanSystem(Class36.aClass213_343, instance);
                    }

                    Varps.clanSystem.method1390(incoming);
                }

                RegionUpdateType.method865();
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_HINT_ARROW == client.connectionContext.currentIncomingPacket) {
                hintArrowType = incoming.readUByte();
                if (hintArrowType == 1) {
                    hintArrowNpcIndex = incoming.readUShort();
                }

                if (hintArrowType >= 2 && hintArrowType <= 6) {
                    if (hintArrowType == 2) {
                        anInt946 = 64;
                        anInt938 = 4096;
                    }

                    if (hintArrowType == 3) {
                        anInt946 = 0;
                        anInt938 = 4096;
                    }

                    if (hintArrowType == 4) {
                        anInt946 = 128;
                        anInt938 = 4096;
                    }

                    if (hintArrowType == 5) {
                        anInt946 = 64;
                        anInt938 = 0;
                    }

                    if (hintArrowType == 6) {
                        anInt946 = 64;
                        anInt938 = 8192;
                    }

                    hintArrowType = 2;
                    hintArrowX = incoming.readUShort();
                    hintArrowY = incoming.readUShort();
                    hintArrowZ = incoming.readUByte() * 2;
                }

                if (hintArrowType == 10) {
                    hintArrowPlayerIndex = incoming.readUShort();
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta209 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.method1055();
                Class9_Sub1.method173(var6);
                inventories[++anInt1078 - 1 & 31] = var6 & 32767;
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta236 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.method1055();
                rootInterfaceIndex = var6;
                this.method734(false);
                Class19.method146(var6);
                Statics9.method796(rootInterfaceIndex);

                for (var5 = 0; var5 < 100; ++var5) {
                    aBooleanArray1089[var5] = true;
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            String var50;
            if (IncomingPacketMeta.ADD_CHAT_MESSAGE == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.readSmart();
                boolean var46 = incoming.readUByte() == 1;
                var50 = "";
                boolean var44 = false;
                if (var46) {
                    var50 = incoming.readString();
                    if (Class44.socialSystem.isOnIgnoreList(new NamePair(var50, Class36.aClass213_343))) {
                        var44 = true;
                    }
                }

                String var51 = incoming.readString();
                if (!var44) {
                    Statics19.messageReceived(var6, var50, var51);
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_MAP_REGION == client.connectionContext.currentIncomingPacket) {
                Enum_Sub6.onSceneXTEAKeyChange(false, client.connectionContext.inbuffer);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.OPEN_BROWSER_URL == client.connectionContext.currentIncomingPacket) {
                byte[] var40 = new byte[client.connectionContext.incomingPacketSize];
                incoming.method1397(var40, 0, var40.length);
                Buffer var61 = new Buffer(var40);
                var50 = var61.readString();
                Class174.method1006(var50, true, false);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.SET_COMPONENT_HIDDEN == client.connectionContext.currentIncomingPacket) {
                var42 = incoming.readUByte() == 1;
                var5 = incoming.method1015();
                var14 = InterfaceComponent.lookup(var5);
                if (var42 != var14.explicitlyHidden) {
                    var14.explicitlyHidden = var42;
                    Enum_Sub2.repaintComponent(var14);
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_ITEM_TABLE == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.readInt();
                var5 = incoming.readUShort();
                if (var6 < -70000) {
                    var5 += 32768;
                }

                if (var6 >= 0) {
                    var14 = InterfaceComponent.lookup(var6);
                } else {
                    var14 = null;
                }

                while (incoming.caret < client.connectionContext.incomingPacketSize) {
                    var8 = incoming.readSmart();
                    var9 = incoming.readUShort();
                    var15 = 0;
                    if (var9 != 0) {
                        var15 = incoming.readUByte();
                        if (var15 == 255) {
                            var15 = incoming.readInt();
                        }
                    }

                    if (var14 != null && var8 >= 0 && var8 < var14.itemIds.length) {
                        var14.itemIds[var8] = var9;
                        var14.itemStackSizes[var8] = var15;
                    }
                    Inventory.addItem(var5, var8, var9 - 1, var15);
                }

                if (var14 != null) {
                    Enum_Sub2.repaintComponent(var14);
                }

                InterfaceNode.method1319();
                inventories[++anInt1078 - 1 & 31] = var5 & 32767;
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.SET_COMPONENT_MODEL_TYPE1 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.method1019();
                var5 = incoming.method1055();
                var14 = InterfaceComponent.lookup(var6);
                if (var14.modelType != 1 || var5 != var14.modelId) {
                    var14.modelType = 1;
                    var14.modelId = var5;
                    Enum_Sub2.repaintComponent(var14);
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.SET_COMPONENT_FOREGROUND == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.readUShort();
                var5 = incoming.method1015();
                var7 = var6 >> 10 & 31;
                var8 = var6 >> 5 & 31;
                var9 = var6 & 31;
                var15 = (var8 << 11) + (var7 << 19) + (var9 << 3);
                InterfaceComponent var59 = InterfaceComponent.lookup(var5);
                if (var15 != var59.textColor) {
                    var59.textColor = var15;
                    Enum_Sub2.repaintComponent(var59);
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.SET_COMPONENT_ZOOM == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.readUShort();
                var5 = incoming.method1055();
                var7 = incoming.method1060();
                var8 = incoming.readInt();
                var17 = InterfaceComponent.lookup(var8);
                if (var5 != var17.xRotation || var7 != var17.zRotation || var6 != var17.modelZoom) {
                    var17.xRotation = var5;
                    var17.zRotation = var7;
                    var17.modelZoom = var6;
                    Enum_Sub2.repaintComponent(var17);
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_CHAT_MODE == client.connectionContext.currentIncomingPacket) {
                tradeChatMode = incoming.method1074();
                publicChatMode = incoming.method1056();
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_STATS == client.connectionContext.currentIncomingPacket) {
                InterfaceNode.method1319();
                var6 = incoming.method1019();
                var5 = incoming.method1056();
                var7 = incoming.method1074();
                experiences[var5] = var6;
                currentLevels[var5] = var7;
                levels[var5] = 1;

                for (var8 = 0; var8 < 98; ++var8) {
                    if (var6 >= Statics20.anIntArray1262[var8]) {
                        levels[var5] = var8 + 2;
                    }
                }

                anIntArray1079[++anInt1063 - 1 & 31] = var5;
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.SET_MAP_STATE == client.connectionContext.currentIncomingPacket) {
                mapState = incoming.readUByte();
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta245 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.method1055();
                var5 = incoming.method1011();
                var7 = incoming.method1060();
                var47 = InterfaceComponent.lookup(var5);
                var47.anInt1351 = var6 + (var7 << 16);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.FIRE_SCRIPT_EVENT == client.connectionContext.currentIncomingPacket) {
                var38 = incoming.readString();
                Object[] var60 = new Object[var38.length() + 1];

                for (var7 = var38.length() - 1; var7 >= 0; --var7) {
                    if (var38.charAt(var7) == 's') {
                        var60[var7 + 1] = incoming.readString();
                    } else {
                        var60[var7 + 1] = incoming.readInt();
                    }
                }

                var60[0] = incoming.readInt();
                ScriptEvent var48 = new ScriptEvent();
                var48.args = var60;
                DefinitionProperty.fireScriptEvent(var48);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta219 == client.connectionContext.currentIncomingPacket) {
                cameraLocked = true;
                GameEngine.anInt1288 = incoming.readUByte() * 16384;
                Class53.anInt458 = incoming.readUByte() * 128;
                Class62.anInt499 = incoming.readUShort();
                Class82.anInt627 = incoming.readUByte();
                ScriptEvent.anInt1806 = incoming.readUByte();
                if (ScriptEvent.anInt1806 >= 100) {
                    var6 = GameEngine.anInt1288 * 128 + 64;
                    var5 = Class53.anInt458 * 16384 + 64;
                    var7 = SceneGraph.getTileHeight(var6, var5, SceneGraph.floorLevel) - Class62.anInt499;
                    var8 = var6 - Class38.cameraX;
                    var9 = var7 - Class79.cameraZ;
                    var15 = var5 - Class27_Sub1.cameraY;
                    var16 = (int) Math.sqrt((double) (var15 * var15 + var8 * var8));
                    IgnoreListContext.cameraPitch = (int) (Math.atan2((double) var9, (double) var16) * 325.949D) & 2047;
                    Class70.cameraYaw = (int) (Math.atan2((double) var8, (double) var15) * -325.949D) & 2047;
                    if (IgnoreListContext.cameraPitch < 128) {
                        IgnoreListContext.cameraPitch = 128;
                    }

                    if (IgnoreListContext.cameraPitch > 383) {
                        IgnoreListContext.cameraPitch = 383;
                    }
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta189 == client.connectionContext.currentIncomingPacket) {
                Class88.method479(RegionUpdateType.A_REGION_UPDATE_TYPE___1206);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta240 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.readInt();
                var5 = incoming.readUByte();
                var7 = incoming.readUShort();
                var13 = (InterfaceNode) interfaceNodes.lookup((long) var6);
                if (var13 != null) {
                    Class199.method1182(var13, var7 != var13.id);
                }

                Class19.method147(var6, var7, var5);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta215 == client.connectionContext.currentIncomingPacket) {
                Class88.method479(RegionUpdateType.A_REGION_UPDATE_TYPE___1204);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta227 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.readInt();
                InterfaceNode var58 = (InterfaceNode) interfaceNodes.lookup((long) var6);
                if (var58 != null) {
                    Class199.method1182(var58, true);
                }

                if (pleaseWaitComponent != null) {
                    Enum_Sub2.repaintComponent(pleaseWaitComponent);
                    pleaseWaitComponent = null;
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_VARP == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.method1055();
                byte var43 = incoming.readByte();
                Varps.tempVarps[var6] = var43;
                if (Varps.values[var6] != var43) {
                    Varps.values[var6] = var43;
                }

                OldConnection.method712(var6);
                anIntArray1076[++anInt1064 - 1 & 31] = var6;
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta182 == client.connectionContext.currentIncomingPacket) {
                InterfaceNode.method1319();
                energy = incoming.readUByte();
                anInt1074 = anInt1075;
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.SET_COMPONENT_MODEL_TYPE3 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.method1015();
                var57 = InterfaceComponent.lookup(var6);
                var57.modelType = 3;
                var57.modelId = PlayerEntity.local.appearance.method1433();
                Enum_Sub2.repaintComponent(var57);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.RESET_REGION_CHUNK == client.connectionContext.currentIncomingPacket) {
                SceneGraph.regionChunkY = incoming.method1074();
                SceneGraph.regionChunkX = incoming.method1072();

                for (var6 = SceneGraph.regionChunkX; var6 < SceneGraph.regionChunkX + 8; ++var6) {
                    for (var5 = SceneGraph.regionChunkY; var5 < SceneGraph.regionChunkY + 8; ++var5) {
                        if (pickableNodeDeques[SceneGraph.floorLevel][var6][var5] != null) {
                            pickableNodeDeques[SceneGraph.floorLevel][var6][var5] = null;
                            Class23.refreshPickables(var6, var5);
                        }
                    }
                }

                for (PendingSpawn var39 = (PendingSpawn) pendingSpawns.head(); var39 != null; var39 = (PendingSpawn) pendingSpawns.next()) {
                    if (var39.sceneX >= SceneGraph.regionChunkX && var39.sceneX < SceneGraph.regionChunkX + 8 && var39.sceneY >= SceneGraph.regionChunkY && var39.sceneY < SceneGraph.regionChunkY + 8 && var39.floorLevel == SceneGraph.floorLevel) {
                        var39.hitpoints = 0;
                    }
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.PROCESS_REFLECTION_REQUEST == client.connectionContext.currentIncomingPacket) {
                ClassStructure.decode(incoming);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_VARPS == client.connectionContext.currentIncomingPacket) {
                for (var6 = 0; var6 < Varps.values.length; ++var6) {
                    if (Varps.tempVarps[var6] != Varps.values[var6]) {
                        Varps.values[var6] = Varps.tempVarps[var6];
                        OldConnection.method712(var6);
                        anIntArray1076[++anInt1064 - 1 & 31] = var6;
                    }
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta225 == client.connectionContext.currentIncomingPacket) {
                Class44.socialSystem.ignoreListContext.method338(incoming, client.connectionContext.incomingPacketSize);
                Statics11.method843();
                anInt1065 = anInt1075;
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_NPCS == client.connectionContext.currentIncomingPacket) {
                InterfaceNode.updateNpcs(false, incoming);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_INSTANCE_REGION == client.connectionContext.currentIncomingPacket) {
                Enum_Sub6.onSceneXTEAKeyChange(true, client.connectionContext.inbuffer);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_COMPONENT_TEXT == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.method1015();
                var33 = new StringBuilder(incoming.readString());
                var14 = InterfaceComponent.lookup(var6);
                if (!var33.toString().equals(var14.text)) {
                    var14.text = var33.toString();
                    Enum_Sub2.repaintComponent(var14);
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta194 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.readUShort();
                if (var6 == 65535) {
                    var6 = -1;
                }

                Class139.method795(var6);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta231 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.method1060();
                if (var6 == 65535) {
                    var6 = -1;
                }

                var5 = incoming.method1017();
                OutgoingPacketMeta.method5(var6);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta233 == client.connectionContext.currentIncomingPacket) {
                Class88.method479(RegionUpdateType.A_REGION_UPDATE_TYPE___1201);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta246 == client.connectionContext.currentIncomingPacket) {
                for (var6 = 0; var6 < DoublyLinkedNode_Sub16.anInt568; ++var6) {
                    DoublyLinkedNode_Sub16 var56 = Class63.method360(var6);
                    if (var56 != null) {
                        Varps.tempVarps[var6] = 0;
                        Varps.values[var6] = 0;
                    }
                }

                InterfaceNode.method1319();
                anInt1064 += 32;
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta188 == client.connectionContext.currentIncomingPacket) {
                Class88.method479(RegionUpdateType.REMOVE_PICKABLE);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta190 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.caret + client.connectionContext.incomingPacketSize;
                var5 = incoming.readUShort();
                var7 = incoming.readUShort();
                if (var5 != rootInterfaceIndex) {
                    rootInterfaceIndex = var5;
                    this.method734(false);
                    Class19.method146(rootInterfaceIndex);
                    Statics9.method796(rootInterfaceIndex);

                    for (var8 = 0; var8 < 100; ++var8) {
                        aBooleanArray1089[var8] = true;
                    }
                }

                InterfaceNode var34;
                for (; var7-- > 0; var34.aBoolean790 = true) {
                    var8 = incoming.readInt();
                    var9 = incoming.readUShort();
                    var15 = incoming.readUByte();
                    var34 = (InterfaceNode) interfaceNodes.lookup((long) var8);
                    if (var34 != null && var9 != var34.id) {
                        Class199.method1182(var34, true);
                        var34 = null;
                    }

                    if (var34 == null) {
                        var34 = Class19.method147(var8, var9, var15);
                    }
                }

                for (var13 = (InterfaceNode) interfaceNodes.method314(); var13 != null; var13 = (InterfaceNode) interfaceNodes.method313()) {
                    if (var13.aBoolean790) {
                        var13.aBoolean790 = false;
                    } else {
                        Class199.method1182(var13, true);
                    }
                }

                interfaceConfigs = new NodeTable(512);

                while (incoming.caret < var6) {
                    var8 = incoming.readInt();
                    var9 = incoming.readUShort();
                    var15 = incoming.readUShort();
                    var16 = incoming.readInt();

                    for (int var35 = var9; var35 <= var15; ++var35) {
                        var22 = (long) var35 + ((long) var8 << 32);
                        interfaceConfigs.put(new IntegerNode(var16), var22);
                    }
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta247 == client.connectionContext.currentIncomingPacket) {
                var38 = incoming.readString();
                var33 = new StringBuilder(DoublyLinkedNode_Sub24_Sub3.method1166(OldConnection.method714(Class123_Sub1.method294(incoming))));
                Statics19.messageReceived(6, var38, var33.toString());
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.LOGOUT == client.connectionContext.currentIncomingPacket) {
                DynamicObject.method1506();
                client.connectionContext.currentIncomingPacket = null;
                return false;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta196 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.readUShort();
                var5 = incoming.readUByte();
                var7 = incoming.readUShort();
                Chatline.method884(var6, var5, var7);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta249 == client.connectionContext.currentIncomingPacket) {
                Class19.updatePlayers(incoming, client.connectionContext.incomingPacketSize);
                CacheReferenceTable.method485();
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta254 == client.connectionContext.currentIncomingPacket) {
                Class88.method479(RegionUpdateType.SET_PICKABLE_STACK_SIZE);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta218 == client.connectionContext.currentIncomingPacket) {
                if (rootInterfaceIndex != -1) {
                    Class16.method118(rootInterfaceIndex, 0);
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_REGION_CHUNK == client.connectionContext.currentIncomingPacket) {
                SceneGraph.regionChunkX = incoming.method1072();
                SceneGraph.regionChunkY = incoming.readUByte();

                while (incoming.caret < client.connectionContext.incomingPacketSize) {
                    var6 = incoming.readUByte();
                    RegionUpdateType var55 = RegionUpdateType.values()[var6];
                    Class88.method479(var55);
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta223 == client.connectionContext.currentIncomingPacket) {
                for (var6 = 0; var6 < players.length; ++var6) {
                    if (players[var6] != null) {
                        players[var6].animation = -1;
                    }
                }

                for (var6 = 0; var6 < npcs.length; ++var6) {
                    if (npcs[var6] != null) {
                        npcs[var6].animation = -1;
                    }
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.SET_DESTINATION == client.connectionContext.currentIncomingPacket) {
                destinationX = incoming.readUByte();
                if (destinationX == 255) {
                    destinationX = 0;
                }

                destinationY = incoming.readUByte();
                if (destinationY == 255) {
                    destinationY = 0;
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta234 == client.connectionContext.currentIncomingPacket) {
                Statics16.aClass193_1237 = Class202.method1186(incoming.readUByte());
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta177 == client.connectionContext.currentIncomingPacket) {
                var42 = incoming.readBoolean();
                if (var42) {
                    if (Enum_Sub5.aClass172_1216 == null) {
                        Enum_Sub5.aClass172_1216 = new Class172();
                    }
                } else {
                    Enum_Sub5.aClass172_1216 = null;
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta241 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.method1015();
                var5 = incoming.method1060();
                var14 = InterfaceComponent.lookup(var6);
                if (var14 != null && var14.type == 0) {
                    if (var5 > var14.viewportHeight - var14.height) {
                        var5 = var14.viewportHeight - var14.height;
                    }

                    if (var5 < 0) {
                        var5 = 0;
                    }

                    if (var5 != var14.insetY) {
                        var14.insetY = var5;
                        Enum_Sub2.repaintComponent(var14);
                    }
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            Class8.method65("" + (client.connectionContext.currentIncomingPacket != null ? client.connectionContext.currentIncomingPacket.opcode : -1) + "," + (client.connectionContext.secondLastIncomingPacket != null ? client.connectionContext.secondLastIncomingPacket.opcode : -1) + "," + (client.connectionContext.thirdLastIncomingPacket != null ? client.connectionContext.thirdLastIncomingPacket.opcode : -1) + "," + client.connectionContext.incomingPacketSize, null);
            DynamicObject.method1506();
        } catch (IOException var36) {
            dropConnection();
        } catch (Exception var37) {
            var33 = new StringBuilder("" + (client.connectionContext.currentIncomingPacket != null ? client.connectionContext.currentIncomingPacket.opcode : -1) + "," + (client.connectionContext.secondLastIncomingPacket != null ? client.connectionContext.secondLastIncomingPacket.opcode : -1) + "," + (client.connectionContext.thirdLastIncomingPacket != null ? client.connectionContext.thirdLastIncomingPacket.opcode : -1) + "," + client.connectionContext.incomingPacketSize + "," + (PlayerEntity.local.pathXQueue[0] + Statics18.baseX) + "," + (PlayerEntity.local.pathYQueue[0] + Statics36.baseY) + ",");

            for (var7 = 0; var7 < client.connectionContext.incomingPacketSize && var7 < 50; ++var7) {
                var33.append(incoming.payload[var7]).append(",");
            }

            Class8.method65(var33.toString(), var37);
            DynamicObject.method1506();
        }

        return true;
    }

    void method738() {
        if (Statics25.anInt1492 >= 4) {
            this.method926("js5crc");
            gameState = 1000;
        } else {
            if (Statics25.anInt1488 >= 4) {
                if (gameState <= 5) {
                    this.method926("js5io");
                    gameState = 1000;
                    return;
                }

                anInt949 = 3000;
                Statics25.anInt1488 = 3;
            }

            if (--anInt949 + 1 <= 0) {
                try {
                    if (anInt950 == 0) {
                        Class55.aOldConnectionTask_464 = aClass125_1321.method698(Enum_Sub3.currentDomain, NpcEntity.anInt823);
                        ++anInt950;
                    }

                    if (anInt950 == 1) {
                        if (Class55.aOldConnectionTask_464.anInt885 == 2) {
                            this.method740(-1);
                            return;
                        }

                        if (Class55.aOldConnectionTask_464.anInt885 == 1) {
                            ++anInt950;
                        }
                    }

                    if (anInt950 == 2) {
                        if (aBoolean970) {
                            Socket var1 = (Socket) Class55.aOldConnectionTask_464.anObject886;
                            Class11.aConnection140 = new AsyncConnection(var1, 40000, 5000);
                        } else {
                            Class11.aConnection140 = new OldConnection((Socket) Class55.aOldConnectionTask_464.anObject886, aClass125_1321, 5000);
                        }

                        Buffer var5 = new Buffer(5);
                        var5.writeByte(15);
                        var5.writeInt(184);
                        Class11.aConnection140.writeBytes(var5.payload, 0, 5);
                        ++anInt950;
                        Enum_Sub8.aLong1478 = Class24.currentTime();
                    }

                    if (anInt950 == 3) {
                        if (Class11.aConnection140.readable() > 0 || !aBoolean970 && gameState <= 5) {
                            int var3 = Class11.aConnection140.readByte();
                            if (var3 != 0) {
                                this.method740(var3);
                                return;
                            }

                            ++anInt950;
                        } else if (Class24.currentTime() - Enum_Sub8.aLong1478 > 30000L) {
                            this.method740(-2);
                            return;
                        }
                    }

                    if (anInt950 == 4) {
                        Class77.method420(Class11.aConnection140, gameState > 20);
                        Class55.aOldConnectionTask_464 = null;
                        Class11.aConnection140 = null;
                        anInt950 = 0;
                        anInt959 = 0;
                    }
                } catch (IOException var4) {
                    this.method740(-3);
                }

            }
        }
    }

    final void openMenu(int var1, int var2) {
        AssociateComparatorByName.openMenu(var1, var2);
        sceneGraph.method1451(SceneGraph.floorLevel, var1, var2, false);
        menuOpen = true;
    }

    protected final void method736() {
        ++engineCycle;
        this.method741();

        while (true) {
            FileSystem var2;
            synchronized (Class174.aNodeDeque1465) {
                var2 = (FileSystem) Class174.aNodeDeque1466.popFirst();
            }

            if (var2 == null) {
                int var4;
                try {
                    if (Class147.anInt1157 == 1) {
                        var4 = Class30.aClass5_Sub6_Sub3_326.method770();
                        if (var4 > 0 && Class30.aClass5_Sub6_Sub3_326.method684()) {
                            var4 -= Class139.anInt1130;
                            if (var4 < 0) {
                                var4 = 0;
                            }

                            Class30.aClass5_Sub6_Sub3_326.method703(var4);
                        } else {
                            Class30.aClass5_Sub6_Sub3_326.method756();
                            Class30.aClass5_Sub6_Sub3_326.method592();
                            if (Class147.aReferenceTable1155 != null) {
                                Class147.anInt1157 = 2;
                            } else {
                                Class147.anInt1157 = 0;
                            }

                            Class147.anAudioTrack1158 = null;
                            FriendLoginUpdate.aClass97_668 = null;
                        }
                    }
                } catch (Exception var9) {
                    var9.printStackTrace();
                    Class30.aClass5_Sub6_Sub3_326.method756();
                    Class147.anInt1157 = 0;
                    Class147.anAudioTrack1158 = null;
                    FriendLoginUpdate.aClass97_668 = null;
                    Class147.aReferenceTable1155 = null;
                }

                Class26.method190();
                synchronized (Keyboard.keyboard) {
                    ++Keyboard.idleTime;
                    Keyboard.anInt157 = Keyboard.anInt162;
                    Keyboard.anInt152 = 0;
                    int var5;
                    if (Keyboard.anInt150 >= 0) {
                        while (Keyboard.anInt150 != Keyboard.anInt155) {
                            var5 = Keyboard.anIntArray154[Keyboard.anInt155];
                            Keyboard.anInt155 = Keyboard.anInt155 + 1 & 127;
                            if (var5 < 0) {
                                Keyboard.heldKeys[~var5] = false;
                            } else {
                                if (!Keyboard.heldKeys[var5] && Keyboard.anInt152 < Keyboard.anIntArray147.length - 1) {
                                    Keyboard.anIntArray147[++Keyboard.anInt152 - 1] = var5;
                                }

                                Keyboard.heldKeys[var5] = true;
                            }
                        }
                    } else {
                        for (var5 = 0; var5 < 112; ++var5) {
                            Keyboard.heldKeys[var5] = false;
                        }

                        Keyboard.anInt150 = Keyboard.anInt155;
                    }

                    if (Keyboard.anInt152 > 0) {
                        Keyboard.idleTime = 0;
                    }

                    Keyboard.anInt162 = Keyboard.anInt153;
                }

                Class96.method532();
                if (Keyboard.aClass131_158 != null) {
                    var4 = Keyboard.aClass131_158.method222();
                    anInt1086 = var4;
                }

                if (gameState == 0) {
                    Statics10.method798();
                    Class69.method383();
                } else if (gameState == 5) {
                    LoginPacketMeta.method1498();
                    Statics10.method798();
                    Class69.method383();
                } else if (gameState != 10 && gameState != 11) {
                    if (gameState == 20) {
                        LoginPacketMeta.method1498();
                        this.method748();
                    } else if (gameState == 25) {
                        Keyboard.method101();
                    }
                } else {
                    LoginPacketMeta.method1498();
                }

                if (gameState == 30) {
                    this.method752();
                } else if (gameState == 40 || gameState == 45) {
                    this.method748();
                }

                return;
            }

            var2.table.method486(var2.index, (int) var2.key, var2.buffer, false);
        }
    }

    final void method729() {
        int var1;
        if (rootInterfaceIndex != -1) {
            var1 = rootInterfaceIndex;
            if (Class63_Sub2.loadInterface(var1)) {
                Chatstream.method513(AssociateComparator_Sub5.interfaces[var1], -1);
            }
        }

        for (var1 = 0; var1 < anInt1085; ++var1) {
            if (aBooleanArray1089[var1]) {
                aBooleanArray1087[var1] = true;
            }

            aBooleanArray1083[var1] = aBooleanArray1089[var1];
            aBooleanArray1089[var1] = false;
        }

        anInt1084 = engineCycle;
        anInt1039 = -1;
        anInt1038 = -1;
        Class12.anInterfaceComponent144 = null;
        if (rootInterfaceIndex != -1) {
            anInt1085 = 0;
            InterfaceComponent.method1201(rootInterfaceIndex, 0, 0, canvasWidth, canvasHeight, 0, 0, -1);
        }

        JagGraphics.resetDrawingArea();
        if (aBoolean1028) {
            if (crosshairState == 1) {
                Class105.hintIcons[anInt1017 * 400 / 100].method809(crosshairX - 8, crosshairY - 8);
            }

            if (crosshairState == 2) {
                Class105.hintIcons[anInt1017 * 400 / 100 + 4].method809(crosshairX - 8, crosshairY - 8);
            }
        }

        int var2;
        int var3;
        if (!menuOpen) {
            if (anInt1039 != -1) {
                var1 = anInt1039;
                var2 = anInt1038;
                if ((menuRowCount >= 2 || itemSelectionState != 0 || spellSelected) && aBoolean1043) {
                    var3 = AssociateComparatorByRank.method679();
                    String var4;
                    if (itemSelectionState == 1 && menuRowCount < 2) {
                        var4 = "Use" + " " + aString1009 + " " + "->";
                    } else if (spellSelected && menuRowCount < 2) {
                        var4 = aString1049 + " " + aString1051 + " " + "->";
                    } else {
                        var4 = Class16.method131(var3);
                    }

                    if (menuRowCount > 2) {
                        var4 = var4 + World.getColorTags(16777215) + " " + '/' + " " + (menuRowCount - 2) + " more options";
                    }

                    Statics7.aFont863.method1142(var4, var1 + 4, var2 + 15, 16777215, 0, engineCycle / 1000);
                }
            }
        } else {
            var1 = Class108.anInt797;
            var2 = Statics1.anInt321;
            var3 = SocialSystem.anInt319;
            int var5 = Class69.anInt543;
            int var6 = 6116423;
            JagGraphics.fillRect(var1, var2, var3, var5, var6);
            JagGraphics.fillRect(var1 + 1, var2 + 1, var3 - 2, 16, 0);
            JagGraphics.method1372(var1 + 1, var2 + 18, var3 - 2, var5 - 19, 0);
            Statics7.aFont863.method1152("Choose Option", var1 + 3, var2 + 14, var6, -1);
            int var7 = Mouse.x;
            int var8 = Mouse.y;

            int var9;
            int var10;
            int var11;
            for (var9 = 0; var9 < menuRowCount; ++var9) {
                var10 = var2 + (menuRowCount - 1 - var9) * 15 + 31;
                var11 = 16777215;
                if (var7 > var1 && var7 < var3 + var1 && var8 > var10 - 13 && var8 < var10 + 3) {
                    var11 = 16776960;
                }

                Statics7.aFont863.method1152(Class16.method131(var9), var1 + 3, var10, var11, 0);
            }

            var9 = Class108.anInt797;
            var10 = Statics1.anInt321;
            var11 = SocialSystem.anInt319;
            int var12 = Class69.anInt543;

            for (int var13 = 0; var13 < anInt1085; ++var13) {
                if (interfacePositionsX[var13] + interfaceWidths[var13] > var9 && interfacePositionsX[var13] < var11 + var9 && interfaceHeights[var13] + interfacePositionsY[var13] > var10 && interfacePositionsY[var13] < var10 + var12) {
                    aBooleanArray1087[var13] = true;
                }
            }
        }

        if (redrawMode == 3) {
            for (var1 = 0; var1 < anInt1085; ++var1) {
                if (aBooleanArray1083[var1]) {
                    JagGraphics.method1370(interfacePositionsX[var1], interfacePositionsY[var1], interfaceWidths[var1], interfaceHeights[var1], 16711935, 128);
                } else if (aBooleanArray1087[var1]) {
                    JagGraphics.method1370(interfacePositionsX[var1], interfacePositionsY[var1], interfaceWidths[var1], interfaceHeights[var1], 16711680, 128);
                }
            }
        }

        Class85.method456(SceneGraph.floorLevel, PlayerEntity.local.fineX, PlayerEntity.local.fineY, anInt972);
        anInt972 = 0;
    }

    protected final void draw(boolean drawing) {
        boolean var2;
        label168:
        {
            try {
                if (Class147.anInt1157 == 2) {
                    if (Class147.anAudioTrack1158 == null) {
                        Class147.anAudioTrack1158 = AudioTrack.loadAudioTrack(Class147.aReferenceTable1155, Statics8.anInt1122, Class30.anInt327);
                        if (Class147.anAudioTrack1158 == null) {
                            var2 = false;
                            break label168;
                        }
                    }

                    if (FriendLoginUpdate.aClass97_668 == null) {
                        FriendLoginUpdate.aClass97_668 = new Class97(Class147.aReferenceTable1159, Class42.aReferenceTable382);
                    }

                    if (Class30.aClass5_Sub6_Sub3_326.method776(Class147.anAudioTrack1158, Class147.aReferenceTable1160, FriendLoginUpdate.aClass97_668, 22050)) {
                        Class30.aClass5_Sub6_Sub3_326.method775();
                        Class30.aClass5_Sub6_Sub3_326.method703(PickableNode.anInt379);
                        Class30.aClass5_Sub6_Sub3_326.method766(Class147.anAudioTrack1158, Enum_Sub2.aBoolean620);
                        Class147.anInt1157 = 0;
                        Class147.anAudioTrack1158 = null;
                        FriendLoginUpdate.aClass97_668 = null;
                        Class147.aReferenceTable1155 = null;
                        var2 = true;
                        break label168;
                    }
                }
            } catch (Exception var6) {
                var6.printStackTrace();
                Class30.aClass5_Sub6_Sub3_326.method756();
                Class147.anInt1157 = 0;
                Class147.anAudioTrack1158 = null;
                FriendLoginUpdate.aClass97_668 = null;
                Class147.aReferenceTable1155 = null;
            }

            var2 = false;
        }

        if (var2 && aBoolean904 && Statics16.anAudioSystem1236 != null) {
            Statics16.anAudioSystem1236.method1333();
        }

        if ((gameState == 10 || gameState == 20 || gameState == 30) && 0L != aLong1081 && Class24.currentTime() > aLong1081) {
            AssociateComparatorByMyWorld.method603(isResizable());
        }

        int var5;
        if (drawing) {
            for (var5 = 0; var5 < 100; ++var5) {
                aBooleanArray1089[var5] = true;
            }
        }

        if (gameState == 0) {
            this.method931(Class55.anInt473, Class55.aString475, drawing);
        } else if (gameState == 5) {
            Varpbit.method1301(Statics7.aFont863, Class38.aFont345, BootSprites.font_p12full);
        } else if (gameState != 10 && gameState != 11) {
            if (gameState == 20) {
                Varpbit.method1301(Statics7.aFont863, Class38.aFont345, BootSprites.font_p12full);
            } else if (gameState == 25) {
                if (anInt975 == 1) {
                    if (anInt966 > anInt971) {
                        anInt971 = anInt966;
                    }

                    var5 = (anInt971 * 50 - anInt966 * 50) / anInt971;
                    Class37.method242("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
                } else if (anInt975 == 2) {
                    if (anInt968 > anInt974) {
                        anInt974 = anInt968;
                    }

                    var5 = (anInt974 * 50 - anInt968 * 50) / anInt974 + 50;
                    Class37.method242("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
                } else {
                    Class37.method242("Loading - please wait.", false);
                }
            } else if (gameState == 30) {
                this.method729();
            } else if (gameState == 40) {
                Class37.method242("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
            } else if (gameState == 45) {
                Class37.method242("Please wait...", false);
            }
        } else {
            Varpbit.method1301(Statics7.aFont863, Class38.aFont345, BootSprites.font_p12full);
        }

        if (gameState == 30 && redrawMode == 0 && !drawing && !aBoolean1090) {
            for (var5 = 0; var5 < anInt1085; ++var5) {
                if (aBooleanArray1087[var5]) {
                    Class20.aClass216_284.method20(interfacePositionsX[var5], interfacePositionsY[var5], interfaceWidths[var5], interfaceHeights[var5]);
                    aBooleanArray1087[var5] = false;
                }
            }
        } else if (gameState > 0) {
            Class20.aClass216_284.method22(0, 0);

            for (var5 = 0; var5 < anInt1085; ++var5) {
                aBooleanArray1087[var5] = false;
            }
        }

    }

    protected final void method737() {
        aLong1081 = Class24.currentTime() + 500L;
        this.method733();
        if (rootInterfaceIndex != -1) {
            this.method734(true);
        }

    }

    void method742(InterfaceComponent var1) {
        InterfaceComponent var2 = var1.parentUid == -1 ? null : InterfaceComponent.lookup(var1.parentUid);
        int var3;
        int var4;
        if (var2 == null) {
            var3 = canvasWidth;
            var4 = canvasHeight;
        } else {
            var3 = var2.width;
            var4 = var2.height;
        }

        PickableNode.method728(var1, var3, var4, false);
        Class24.method185(var1, var3, var4);
    }

    final void method752() {
        if (anInt934 > 1) {
            --anInt934;
        }

        if (logoutTimer > 0) {
            --logoutTimer;
        }

        if (pendingDisconnect) {
            pendingDisconnect = false;
            dropConnection();
        } else {
            if (!menuOpen) {
                Keyboard.method102();
            }

            for (int var1 = 0; var1 < 100 && this.processIncomingPacket(); ++var1) {
            }

            if (gameState == 30) {
                while (true) {
                    ClassStructure var2 = (ClassStructure) Statics43.classStructures.head();
                    boolean var29;
                    var29 = var2 != null;

                    int var3;
                    OutgoingPacket packet;
                    if (!var29) {
                        OutgoingPacket var4;
                        int var5;
                        if (aClass180_967.aBoolean1525) {
                            var4 = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta93, connectionContext.encryptor);
                            var4.buffer.writeByte(0);
                            var5 = var4.buffer.caret;
                            aClass180_967.writeTo(var4.buffer);
                            var4.buffer.method1050(var4.buffer.caret - var5);
                            connectionContext.writeLater(var4);
                            aClass180_967.method1118();
                        }

                        int var6;
                        int var7;
                        int var8;
                        int var9;
                        int var10;
                        int var11;
                        int var12;
                        int var13;
                        int var14;
                        synchronized (Class34.mouseRecorder.lock) {
                            if (!aBoolean911) {
                                Class34.mouseRecorder.caret = 0;
                            } else if (Mouse.clickMeta != 0 || Class34.mouseRecorder.caret >= 40) {
                                packet = null;
                                var3 = 0;
                                var6 = 0;
                                var7 = 0;
                                var8 = 0;

                                for (var9 = 0; var9 < Class34.mouseRecorder.caret && (packet == null || packet.buffer.caret - var3 < 246); ++var9) {
                                    var6 = var9;
                                    var10 = Class34.mouseRecorder.yHistory[var9];
                                    if (var10 < -1) {
                                        var10 = -1;
                                    } else if (var10 > 65534) {
                                        var10 = 65534;
                                    }

                                    var11 = Class34.mouseRecorder.xHistory[var9];
                                    if (var11 < -1) {
                                        var11 = -1;
                                    } else if (var11 > 65534) {
                                        var11 = 65534;
                                    }

                                    if (var11 != lastMouseRecordX || var10 != lastMouseRecordY) {
                                        if (packet == null) {
                                            packet = OutgoingPacket.prepare(OutgoingPacketMeta.MOUSE_MOTION_RECORD, connectionContext.encryptor);
                                            packet.buffer.writeByte(0);
                                            var3 = packet.buffer.caret;
                                            packet.buffer.caret += 2;
                                            var7 = 0;
                                            var8 = 0;
                                        }

                                        if (lastMouseRecordTime != -1L) {
                                            var12 = var11 - lastMouseRecordX;
                                            var13 = var10 - lastMouseRecordY;
                                            var14 = (int) ((Class34.mouseRecorder.timeHistory[var9] - lastMouseRecordTime) / 20L);
                                            var7 = (int) ((long) var7 + (Class34.mouseRecorder.timeHistory[var9] - lastMouseRecordTime) % 20L);
                                        } else {
                                            var12 = var11;
                                            var13 = var10;
                                            var14 = Integer.MAX_VALUE;
                                        }

                                        lastMouseRecordX = var11;
                                        lastMouseRecordY = var10;
                                        if (var14 < 8 && var12 >= -32 && var12 <= 31 && var13 >= -32 && var13 <= 31) {
                                            var12 += 32;
                                            var13 += 32;
                                            packet.buffer.writeShort((var14 << 12) + var13 + (var12 << 6));
                                        } else if (var14 < 32 && var12 >= -128 && var12 <= 127 && var13 >= -128 && var13 <= 127) {
                                            var12 += 128;
                                            var13 += 128;
                                            packet.buffer.writeByte(var14 + 128);
                                            packet.buffer.writeShort(var13 + (var12 << 8));
                                        } else if (var14 < 32) {
                                            packet.buffer.writeByte(var14 + 192);
                                            if (var11 != -1 && var10 != -1) {
                                                packet.buffer.writeInt(var11 | var10 << 16);
                                            } else {
                                                packet.buffer.writeInt(Integer.MIN_VALUE);
                                            }
                                        } else {
                                            packet.buffer.writeShort((var14 & 0x1fff) + 0xe000);
                                            if (var11 != -1 && var10 != -1) {
                                                packet.buffer.writeInt(var11 | var10 << 16);
                                            } else {
                                                packet.buffer.writeInt(Integer.MIN_VALUE);
                                            }
                                        }

                                        ++var8;
                                        lastMouseRecordTime = Class34.mouseRecorder.timeHistory[var9];
                                    }
                                }

                                if (packet != null) {
                                    packet.buffer.method1050(packet.buffer.caret - var3);
                                    var9 = packet.buffer.caret;
                                    packet.buffer.caret = var3;
                                    packet.buffer.writeByte(var7 / var8);
                                    packet.buffer.writeByte(var7 % var8);
                                    packet.buffer.caret = var9;
                                    connectionContext.writeLater(packet);
                                }

                                if (var6 >= Class34.mouseRecorder.caret) {
                                    Class34.mouseRecorder.caret = 0;
                                } else {
                                    MouseRecorder var42 = Class34.mouseRecorder;
                                    var42.caret -= var6;
                                    System.arraycopy(Class34.mouseRecorder.xHistory, var6, Class34.mouseRecorder.xHistory, 0, Class34.mouseRecorder.caret);
                                    System.arraycopy(Class34.mouseRecorder.yHistory, var6, Class34.mouseRecorder.yHistory, 0, Class34.mouseRecorder.caret);
                                    System.arraycopy(Class34.mouseRecorder.timeHistory, var6, Class34.mouseRecorder.timeHistory, 0, Class34.mouseRecorder.caret);
                                }
                            }
                        }

                        OutgoingPacket var18;
                        if (Mouse.clickMeta == 1 || !Class27_Sub1.aBoolean492 && Mouse.clickMeta == 4 || Mouse.clickMeta == 2) {
                            long var16 = (Mouse.timeOfClick - timeOfPreviousClick * -1L) / 50L;
                            if (var16 > 4095L) {
                                var16 = 4095L;
                            }

                            timeOfPreviousClick = Mouse.timeOfClick * -1L;
                            var3 = Mouse.clickY;
                            if (var3 < 0) {
                                var3 = 0;
                            } else if (var3 > canvasHeight) {
                                var3 = canvasHeight;
                            }

                            var6 = Mouse.clickX;
                            if (var6 < 0) {
                                var6 = 0;
                            } else if (var6 > canvasWidth) {
                                var6 = canvasWidth;
                            }

                            var7 = (int) var16;
                            var18 = OutgoingPacket.prepare(OutgoingPacketMeta.MOUSE_ACTION, connectionContext.encryptor);
                            var18.buffer.writeShort((Mouse.clickMeta == 2 ? 1 : 0) + (var7 << 1));
                            var18.buffer.writeShort(var6);
                            var18.buffer.writeShort(var3);
                            connectionContext.writeLater(var18);
                        }

                        if (Keyboard.anInt152 > 0) {
                            var4 = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta11, connectionContext.encryptor);
                            var4.buffer.writeShort(0);
                            var5 = var4.buffer.caret;
                            long var19 = Class24.currentTime();

                            for (var7 = 0; var7 < Keyboard.anInt152; ++var7) {
                                long var21 = var19 - aLong1095;
                                if (var21 > 16777215L) {
                                    var21 = 16777215L;
                                }

                                aLong1095 = var19;
                                var4.buffer.method1062((int) var21);
                                var4.buffer.writeByteS(Keyboard.anIntArray147[var7]);
                            }

                            var4.buffer.method1041(var4.buffer.caret - var5);
                            connectionContext.writeLater(var4);
                        }

                        if (anInt1006 > 0) {
                            --anInt1006;
                        }

                        if (Keyboard.heldKeys[96] || Keyboard.heldKeys[97] || Keyboard.heldKeys[98] || Keyboard.heldKeys[99]) {
                            aBoolean999 = true;
                        }

                        if (aBoolean999 && anInt1006 <= 0) {
                            anInt1006 = 20;
                            aBoolean999 = false;
                            var4 = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta75, connectionContext.encryptor);
                            var4.buffer.writeLEShortA(anInt985);
                            var4.buffer.writeLEShort(mapRotation);
                            connectionContext.writeLater(var4);
                        }

                        if (Class125.aBoolean853 && !aBoolean937) {
                            aBoolean937 = true;
                            var4 = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta97, connectionContext.encryptor);
                            var4.buffer.writeByte(1);
                            connectionContext.writeLater(var4);
                        }

                        if (!Class125.aBoolean853 && aBoolean937) {
                            aBoolean937 = false;
                            var4 = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta97, connectionContext.encryptor);
                            var4.buffer.writeByte(0);
                            connectionContext.writeLater(var4);
                        }

                        if (Class44.aClass209_391 != null) {
                            Class44.aClass209_391.method1272();
                        }

                        if (Class74.aBoolean584) {
                            if (Varps.clanSystem != null) {
                                Varps.clanSystem.sort();
                            }

                            CacheReferenceTable.method488();
                            Class74.aBoolean584 = false;
                        }

                        Class39.updateMinimapFloorLevel();
                        if (gameState != 30) {
                            return;
                        }

                        processObjectSpawns();
                        processAudioEffects();
                        ++connectionContext.idleReadTicks;
                        if (connectionContext.idleReadTicks > 750) {
                            dropConnection();
                            return;
                        }

                        processPlayers();
                        processNpcs();

                        int[] var32 = GPI.playerIndices;
                        for (var5 = 0; var5 < GPI.playerCount; ++var5) {
                            PlayerEntity var23 = players[var32[var5]];
                            if (var23 != null && var23.anInt1344 > 0) {
                                --var23.anInt1344;
                                if (var23.anInt1344 == 0) {
                                    var23.overheadText = null;
                                }
                            }
                        }

                        for (var5 = 0; var5 < npcCount; ++var5) {
                            var3 = npcIndices[var5];
                            NpcEntity var24 = npcs[var3];
                            if (var24 != null && var24.anInt1344 > 0) {
                                --var24.anInt1344;
                                if (var24.anInt1344 == 0) {
                                    var24.overheadText = null;
                                }
                            }
                        }

                        ++anInt972;
                        if (crosshairState != 0) {
                            anInt1017 = anInt1017 + 20;
                            if (anInt1017 >= 400) {
                                crosshairState = 0;
                            }
                        }

                        if (Class38.anInterfaceComponent351 != null) {
                            ++anInt1018;
                            if (anInt1018 >= 15) {
                                Enum_Sub2.repaintComponent(Class38.anInterfaceComponent351);
                                Class38.anInterfaceComponent351 = null;
                            }
                        }

                        InterfaceComponent var34 = OldConnection.anInterfaceComponent873;
                        InterfaceComponent var31 = Statics24.anInterfaceComponent1417;
                        OldConnection.anInterfaceComponent873 = null;
                        Statics24.anInterfaceComponent1417 = null;
                        anInterfaceComponent1058 = null;
                        aBoolean1067 = false;
                        aBoolean1070 = false;
                        anInt1092 = 0;

                        while (DynamicObject.method1114() && anInt1092 < 128) {
                            if (rights >= 2 && Keyboard.heldKeys[82] && Class53.anInt457 == 66) {
                                String var39 = Entity.method9();
                                instance.method941(var39);
                            } else if (anInt988 != 1 || Keyboard.aChar151 <= 0) {
                                anIntArray1096[anInt1092] = Class53.anInt457;
                                anIntArray1097[anInt1092] = Keyboard.aChar151;
                                ++anInt1092;
                            }
                        }

                        boolean var33 = rights >= 2;
                        if (var33 && Keyboard.heldKeys[82] && Keyboard.heldKeys[81] && anInt1086 != 0) {
                            var6 = PlayerEntity.local.anInt1473 - anInt1086;
                            if (var6 < 0) {
                                var6 = 0;
                            } else if (var6 > 3) {
                                var6 = 3;
                            }

                            if (var6 != PlayerEntity.local.anInt1473) {
                                Statics35.method1171(PlayerEntity.local.pathXQueue[0] + Statics18.baseX, PlayerEntity.local.pathYQueue[0] + Statics36.baseY, var6, false);
                            }

                            anInt1086 = 0;
                        }

                        if (rootInterfaceIndex != -1) {
                            Class63.processComponentRendering(rootInterfaceIndex, 0, 0, canvasWidth, canvasHeight, 0, 0);
                        }

                        ++anInt1075;

                        while (true) {
                            InterfaceComponent var25;
                            InterfaceComponent var38;
                            ScriptEvent var40;
                            do {
                                var40 = (ScriptEvent) aNodeDeque1088.popFirst();
                                if (var40 == null) {
                                    while (true) {
                                        do {
                                            var40 = (ScriptEvent) aNodeDeque1080.popFirst();
                                            if (var40 == null) {
                                                while (true) {
                                                    do {
                                                        var40 = (ScriptEvent) aNodeDeque1082.popFirst();
                                                        if (var40 == null) {
                                                            this.method751();
                                                            if (Class44.aClass209_391 != null) {
                                                                Class44.aClass209_391.method1261(SceneGraph.floorLevel, Statics18.baseX + (PlayerEntity.local.fineX >> 7), Statics36.baseY + (PlayerEntity.local.fineY >> 7), false);
                                                                Class44.aClass209_391.method1225();
                                                            }

                                                            if (draggedComponent != null) {
                                                                this.method732();
                                                            }

                                                            if (DoublyLinkedNode_Sub6.anInterfaceComponent800 != null) {
                                                                Enum_Sub2.repaintComponent(DoublyLinkedNode_Sub6.anInterfaceComponent800);
                                                                ++anInt1027;
                                                                if (Mouse.pressMeta == 0) {
                                                                    if (aBoolean1024) {
                                                                        if (DoublyLinkedNode_Sub6.anInterfaceComponent800 == Class12.anInterfaceComponent144 && anInt1019 != anInt1023) {
                                                                            InterfaceComponent var41 = DoublyLinkedNode_Sub6.anInterfaceComponent800;
                                                                            byte var35 = 0;
                                                                            if (anInt1054 == 1 && var41.contentType == 206) {
                                                                                var35 = 1;
                                                                            }

                                                                            if (var41.itemIds[anInt1019] <= 0) {
                                                                                var35 = 0;
                                                                            }

                                                                            if (Class66.method367(InterfaceComponent.getConfig(var41))) {
                                                                                var8 = anInt1023;
                                                                                var9 = anInt1019;
                                                                                var41.itemIds[var9] = var41.itemIds[var8];
                                                                                var41.itemStackSizes[var9] = var41.itemStackSizes[var8];
                                                                                var41.itemIds[var8] = -1;
                                                                                var41.itemStackSizes[var8] = 0;
                                                                            } else if (var35 == 1) {
                                                                                var8 = anInt1023;
                                                                                var9 = anInt1019;

                                                                                while (var9 != var8) {
                                                                                    if (var8 > var9) {
                                                                                        var41.method817(var8 - 1, var8);
                                                                                        --var8;
                                                                                    } else if (var8 < var9) {
                                                                                        var41.method817(var8 + 1, var8);
                                                                                        ++var8;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                var41.method817(anInt1019, anInt1023);
                                                                            }

                                                                            var18 = OutgoingPacket.prepare(OutgoingPacketMeta.DRAG_ITEM, connectionContext.encryptor);
                                                                            var18.buffer.writeIMEInt(DoublyLinkedNode_Sub6.anInterfaceComponent800.uid);
                                                                            var18.buffer.writeShort(anInt1019);
                                                                            var18.buffer.writeByte(var35);
                                                                            var18.buffer.writeLEShort(anInt1023);
                                                                            connectionContext.writeLater(var18);
                                                                        }
                                                                    } else if (this.method731()) {
                                                                        this.openMenu(anInt1016, anInt1022);
                                                                    } else if (menuRowCount > 0) {
                                                                        Class85.method459(anInt1016, anInt1022);
                                                                    }

                                                                    anInt1018 = 10;
                                                                    Mouse.clickMeta = 0;
                                                                    DoublyLinkedNode_Sub6.anInterfaceComponent800 = null;
                                                                } else if (anInt1027 >= 5 && (Mouse.x > anInt1016 + 5 || Mouse.x < anInt1016 - 5 || Mouse.y > anInt1022 + 5 || Mouse.y < anInt1022 - 5)) {
                                                                    aBoolean1024 = true;
                                                                }
                                                            }

                                                            if (SceneGraph.isMovementPending()) {
                                                                var6 = SceneGraph.selectedRegionTileX;
                                                                var7 = SceneGraph.selectedRegionTileY;
                                                                var18 = OutgoingPacket.prepare(OutgoingPacketMeta.PROCESS_MOVEMENT, connectionContext.encryptor);
                                                                var18.buffer.writeByte(5);
                                                                var18.buffer.writeLEShortA(Statics18.baseX + var6);
                                                                var18.buffer.writeLEShort(Statics36.baseY + var7);
                                                                var18.buffer.writeNegatedByte(Keyboard.heldKeys[82] ? (Keyboard.heldKeys[81] ? 2 : 1) : 0);
                                                                connectionContext.writeLater(var18);
                                                                SceneGraph.unsetPendingMovement();
                                                                crosshairX = Mouse.clickX;
                                                                crosshairY = Mouse.clickY;
                                                                crosshairState = 1;
                                                                anInt1017 = 0;
                                                                destinationX = var6;
                                                                destinationY = var7;
                                                            }

                                                            if (var34 != OldConnection.anInterfaceComponent873) {
                                                                if (var34 != null) {
                                                                    Enum_Sub2.repaintComponent(var34);
                                                                }

                                                                if (OldConnection.anInterfaceComponent873 != null) {
                                                                    Enum_Sub2.repaintComponent(OldConnection.anInterfaceComponent873);
                                                                }
                                                            }

                                                            if (var31 != Statics24.anInterfaceComponent1417 && anInt1036 == anInt1041) {
                                                                if (var31 != null) {
                                                                    Enum_Sub2.repaintComponent(var31);
                                                                }

                                                                if (Statics24.anInterfaceComponent1417 != null) {
                                                                    Enum_Sub2.repaintComponent(Statics24.anInterfaceComponent1417);
                                                                }
                                                            }

                                                            if (Statics24.anInterfaceComponent1417 != null) {
                                                                if (anInt1041 < anInt1036) {
                                                                    ++anInt1041;
                                                                    if (anInt1041 == anInt1036) {
                                                                        Enum_Sub2.repaintComponent(Statics24.anInterfaceComponent1417);
                                                                    }
                                                                }
                                                            } else if (anInt1041 > 0) {
                                                                --anInt1041;
                                                            }

                                                            if (anInt988 == 0) {
                                                                var6 = PlayerEntity.local.fineX;
                                                                var7 = PlayerEntity.local.fineY;
                                                                if (Node_Sub2.anInt371 - var6 < -500 || Node_Sub2.anInt371 - var6 > 500 || Class62.anInt498 - var7 < -500 || Class62.anInt498 - var7 > 500) {
                                                                    Node_Sub2.anInt371 = var6;
                                                                    Class62.anInt498 = var7;
                                                                }

                                                                if (var6 != Node_Sub2.anInt371) {
                                                                    Node_Sub2.anInt371 += (var6 - Node_Sub2.anInt371) / 16;
                                                                }

                                                                if (var7 != Class62.anInt498) {
                                                                    Class62.anInt498 += (var7 - Class62.anInt498) / 16;
                                                                }

                                                                var8 = Node_Sub2.anInt371 >> 7;
                                                                var9 = Class62.anInt498 >> 7;
                                                                var10 = SceneGraph.getTileHeight(Node_Sub2.anInt371, Class62.anInt498, SceneGraph.floorLevel);
                                                                var11 = 0;
                                                                if (var8 > 3 && var9 > 3 && var8 < 100 && var9 < 100) {
                                                                    for (var12 = var8 - 4; var12 <= var8 + 4; ++var12) {
                                                                        for (var13 = var9 - 4; var13 <= var9 + 4; ++var13) {
                                                                            var14 = SceneGraph.floorLevel;
                                                                            if (var14 < 3 && (Class44.sceneRenderRules[1][var12][var13] & 2) == 2) {
                                                                                ++var14;
                                                                            }

                                                                            int var26 = var10 - Class44.tileHeights[var14][var12][var13];
                                                                            if (var26 > var11) {
                                                                                var11 = var26;
                                                                            }
                                                                        }
                                                                    }
                                                                }

                                                                var12 = var11 * 192;
                                                                if (var12 > 98048) {
                                                                    var12 = 98048;
                                                                }

                                                                if (var12 < 32768) {
                                                                    var12 = 32768;
                                                                }

                                                                if (var12 > anInt1008) {
                                                                    anInt1008 += (var12 - anInt1008) / 24;
                                                                } else if (var12 < anInt1008) {
                                                                    anInt1008 += (var12 - anInt1008) / 80;
                                                                }

                                                                Statics3.anInt802 = SceneGraph.getTileHeight(PlayerEntity.local.fineX, PlayerEntity.local.fineY, SceneGraph.floorLevel) - anInt982;
                                                            } else if (anInt988 == 1) {
                                                                Class73.method407();
                                                                short var36 = -1;
                                                                if (Keyboard.heldKeys[33]) {
                                                                    var36 = 0;
                                                                } else if (Keyboard.heldKeys[49]) {
                                                                    var36 = 1024;
                                                                }

                                                                if (Keyboard.heldKeys[48]) {
                                                                    if (var36 == 0) {
                                                                        var36 = 1792;
                                                                    } else if (var36 == 1024) {
                                                                        var36 = 1280;
                                                                    } else {
                                                                        var36 = 1536;
                                                                    }
                                                                } else if (Keyboard.heldKeys[50]) {
                                                                    if (var36 == 0) {
                                                                        var36 = 256;
                                                                    } else if (var36 == 1024) {
                                                                        var36 = 768;
                                                                    } else {
                                                                        var36 = 512;
                                                                    }
                                                                }

                                                                byte var37 = 0;
                                                                if (Keyboard.heldKeys[35]) {
                                                                    var37 = -1;
                                                                } else if (Keyboard.heldKeys[51]) {
                                                                    var37 = 1;
                                                                }

                                                                var8 = 0;
                                                                if (var36 >= 0 || var37 != 0) {
                                                                    var8 = Keyboard.heldKeys[81] ? anInt992 : anInt1004;
                                                                    var8 *= 16;
                                                                    anInt986 = var36;
                                                                    anInt997 = var37;
                                                                }

                                                                if (anInt977 < var8) {
                                                                    anInt977 += var8 / 8;
                                                                    if (anInt977 > var8) {
                                                                        anInt977 = var8;
                                                                    }
                                                                } else if (anInt977 > var8) {
                                                                    anInt977 = anInt977 * 9 / 10;
                                                                }

                                                                if (anInt977 > 0) {
                                                                    var9 = anInt977 / 16;
                                                                    if (anInt986 >= 0) {
                                                                        var6 = anInt986 - Class70.cameraYaw & 2047;
                                                                        var10 = JagGraphics3D.SIN_TABLE[var6];
                                                                        var11 = JagGraphics3D.COS_TABLE[var6];
                                                                        Node_Sub2.anInt371 += var10 * var9 / 65536;
                                                                        Class62.anInt498 += var9 * var11 / 65536;
                                                                    }

                                                                    if (anInt997 != 0) {
                                                                        Statics3.anInt802 += var9 * anInt997;
                                                                        if (Statics3.anInt802 > 0) {
                                                                            Statics3.anInt802 = 0;
                                                                        }
                                                                    }
                                                                } else {
                                                                    anInt986 = -1;
                                                                    anInt997 = -1;
                                                                }

                                                                if (Keyboard.heldKeys[13]) {
                                                                    connectionContext.writeLater(OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta21, connectionContext.encryptor));
                                                                    anInt988 = 0;
                                                                }
                                                            }

                                                            if (Mouse.pressMeta == 4 && Class27_Sub1.aBoolean492) {
                                                                var6 = Mouse.y - anInt978;
                                                                anInt989 = var6 * 2;
                                                                anInt978 = var6 != -1 && var6 != 1 ? (anInt978 + Mouse.y) / 2 : Mouse.y;
                                                                var7 = anInt979 - Mouse.x;
                                                                anInt981 = var7 * 2;
                                                                anInt979 = var7 != -1 && var7 != 1 ? (Mouse.x + anInt979) / 2 : Mouse.x;
                                                            } else {
                                                                if (Keyboard.heldKeys[96]) {
                                                                    anInt981 += (-24 - anInt981) / 2;
                                                                } else if (Keyboard.heldKeys[97]) {
                                                                    anInt981 += (24 - anInt981) / 2;
                                                                } else {
                                                                    anInt981 /= 2;
                                                                }

                                                                if (Keyboard.heldKeys[98]) {
                                                                    anInt989 += (12 - anInt989) / 2;
                                                                } else if (Keyboard.heldKeys[99]) {
                                                                    anInt989 += (-12 - anInt989) / 2;
                                                                } else {
                                                                    anInt989 /= 2;
                                                                }

                                                                anInt978 = Mouse.y;
                                                                anInt979 = Mouse.x;
                                                            }

                                                            mapRotation = anInt981 / 2 + mapRotation & 2047;
                                                            anInt985 += anInt989 / 2;
                                                            if (anInt985 < 128) {
                                                                anInt985 = 128;
                                                            }

                                                            if (anInt985 > 383) {
                                                                anInt985 = 383;
                                                            }

                                                            if (cameraLocked) {
                                                                Chatstream.method517();
                                                            }

                                                            for (var6 = 0; var6 < 5; ++var6) {
                                                                int var10002 = anIntArray916[var6]++;
                                                            }

                                                            Class147.aClass79_1161.method425();
                                                            var6 = Class65.getAndIncrementMouseIdleTime();
                                                            var7 = Class42.getKeyboardIdleTime();
                                                            if (var6 > 15000 && var7 > 15000) {
                                                                logoutTimer = 250;
                                                                Mouse.idleTime = 14500;
                                                                var18 = OutgoingPacket.prepare(OutgoingPacketMeta.IDLE_LOGOUT, connectionContext.encryptor);
                                                                connectionContext.writeLater(var18);
                                                            }

                                                            Class44.socialSystem.processFriendLoginUpdates();
                                                            ++connectionContext.idleWriteTicks;
                                                            if (connectionContext.idleWriteTicks > 50) {
                                                                var18 = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta62, connectionContext.encryptor);
                                                                connectionContext.writeLater(var18);
                                                            }

                                                            try {
                                                                connectionContext.flush();
                                                            } catch (IOException var27) {
                                                                dropConnection();
                                                            }

                                                            return;
                                                        }

                                                        var25 = var40.source;
                                                        if (var25.componentIndex < 0) {
                                                            break;
                                                        }

                                                        var38 = InterfaceComponent.lookup(var25.parentUid);
                                                    }
                                                    while (var38 == null || var38.components == null || var25.componentIndex >= var38.components.length || var25 != var38.components[var25.componentIndex]);

                                                    DefinitionProperty.fireScriptEvent(var40);
                                                }
                                            }

                                            var25 = var40.source;
                                            if (var25.componentIndex < 0) {
                                                break;
                                            }

                                            var38 = InterfaceComponent.lookup(var25.parentUid);
                                        }
                                        while (var38 == null || var38.components == null || var25.componentIndex >= var38.components.length || var25 != var38.components[var25.componentIndex]);

                                        DefinitionProperty.fireScriptEvent(var40);
                                    }
                                }

                                var25 = var40.source;
                                if (var25.componentIndex < 0) {
                                    break;
                                }

                                var38 = InterfaceComponent.lookup(var25.parentUid);
                            }
                            while (var38 == null || var38.components == null || var25.componentIndex >= var38.components.length || var25 != var38.components[var25.componentIndex]);

                            DefinitionProperty.fireScriptEvent(var40);
                        }
                    }

                    packet = OutgoingPacket.prepare(OutgoingPacketMeta.PROCESS_REFLECTION, connectionContext.encryptor);
                    packet.buffer.writeByte(0);
                    var3 = packet.buffer.caret;
                    Statics10.processClassStructurePacket(packet.buffer);
                    packet.buffer.method1050(packet.buffer.caret - var3);
                    connectionContext.writeLater(packet);
                }
            }
        }
    }

    final void method748() {
        Connection var1 = connectionContext.unwrap();
        PacketBuffer var2 = connectionContext.inbuffer;

        try {
            if (anInt956 == 0) {
                if (SpotAnimationObject.aSecureRandom864 == null && (aClass53_960.method319() || anInt957 > 250)) {
                    SpotAnimationObject.aSecureRandom864 = aClass53_960.method316();
                    aClass53_960.method318();
                    aClass53_960 = null;
                }

                if (SpotAnimationObject.aSecureRandom864 != null) {
                    if (var1 != null) {
                        var1.stop();
                        var1 = null;
                    }

                    LoginPacketMeta.aOldConnectionTask_1992 = null;
                    pendingDisconnect = false;
                    anInt957 = 0;
                    anInt956 = 1;
                }
            }

            if (anInt956 == 1) {
                if (LoginPacketMeta.aOldConnectionTask_1992 == null) {
                    LoginPacketMeta.aOldConnectionTask_1992 = aClass125_1321.method698(Enum_Sub3.currentDomain, NpcEntity.anInt823);
                }

                if (LoginPacketMeta.aOldConnectionTask_1992.anInt885 == 2) {
                    throw new IOException();
                }

                if (LoginPacketMeta.aOldConnectionTask_1992.anInt885 == 1) {
                    if (aBoolean970) {
                        Socket var3 = (Socket) LoginPacketMeta.aOldConnectionTask_1992.anObject886;
                        var1 = new AsyncConnection(var3, 40000, 5000);
                    } else {
                        var1 = new OldConnection((Socket) LoginPacketMeta.aOldConnectionTask_1992.anObject886, aClass125_1321, 5000);
                    }

                    connectionContext.method1000(var1);
                    LoginPacketMeta.aOldConnectionTask_1992 = null;
                    anInt956 = 2;
                }
            }

            if (anInt956 == 2) {
                connectionContext.drop();
                OutgoingPacket packet = OutgoingPacket.prepareLoginPacket();
                packet.buffer.writeByte(LoginPacketMeta.aLoginPacketMeta1998.anInt1993);
                connectionContext.writeLater(packet);
                connectionContext.flush();
                var2.caret = 0;
                anInt956 = 3;
            }

            boolean var5;
            int var6;
            if (anInt956 == 3) {
                if (Statics16.anAudioSystem1236 != null) {
                    Statics16.anAudioSystem1236.method1332();
                }

                if (Class76.anAudioSystem599 != null) {
                    Class76.anAudioSystem599.method1332();
                }

                var5 = !aBoolean970 || var1.available(1);

                if (var5) {
                    var6 = var1.readByte();
                    if (Statics16.anAudioSystem1236 != null) {
                        Statics16.anAudioSystem1236.method1332();
                    }

                    if (Class76.anAudioSystem599 != null) {
                        Class76.anAudioSystem599.method1332();
                    }

                    if (var6 != 0) {
                        CacheIndex.method1488(var6);
                        return;
                    }

                    var2.caret = 0;
                    anInt956 = 4;
                }
            }

            int var29;
            if (anInt956 == 4) {
                if (var2.caret < 8) {
                    var29 = var1.readable();
                    if (var29 > 8 - var2.caret) {
                        var29 = 8 - var2.caret;
                    }

                    if (var29 > 0) {
                        var1.readBytes(var2.payload, var2.caret, var29);
                        var2.caret += var29;
                    }
                }

                if (var2.caret == 8) {
                    var2.caret = 0;
                    Class44.aLong403 = var2.readLong();
                    anInt956 = 5;
                }
            }

            int var8;
            if (anInt956 == 5) {
                connectionContext.inbuffer.caret = 0;
                connectionContext.drop();
                PacketBuffer var26 = new PacketBuffer(500);
                int[] var22 = new int[]{SpotAnimationObject.aSecureRandom864.nextInt(), SpotAnimationObject.aSecureRandom864.nextInt(), SpotAnimationObject.aSecureRandom864.nextInt(), SpotAnimationObject.aSecureRandom864.nextInt()};
                var26.caret = 0;
                var26.writeByte(1);
                var26.writeInt(var22[0]);
                var26.writeInt(var22[1]);
                var26.writeInt(var22[2]);
                var26.writeInt(var22[3]);
                var26.writeLong(Class44.aLong403);
                if (gameState == 40) {
                    var26.writeInt(Class152_Sub1.anIntArray1136[0]);
                    var26.writeInt(Class152_Sub1.anIntArray1136[1]);
                    var26.writeInt(Class152_Sub1.anIntArray1136[2]);
                    var26.writeInt(Class152_Sub1.anIntArray1136[3]);
                } else {
                    var26.writeByte(anEnum_Sub3_955.getOrdinal());
                    switch (anEnum_Sub3_955.anInt619) {
                        case 0:
                        case 1:
                            var26.writeMediumInt(RegionUpdateType.anInt1199);
                            ++var26.caret;
                            break;
                        case 2:
                            var26.caret += 4;
                            break;
                        case 3:
                            var26.writeInt((Integer) preferences.properties.get(Statics33.method1141(Class55.username)));
                    }

                    var26.writeByte(Enum_Sub10.anEnum_Sub10_1767.getOrdinal());
                    var26.writeCString(Class55.password);
                }

                var26.writeRSA(Class61.aBigInteger496, Class61.aBigInteger497);
                Class152_Sub1.anIntArray1136 = var22;
                OutgoingPacket packet = OutgoingPacket.prepareLoginPacket();
                packet.buffer.caret = 0;
                if (gameState == 40) {
                    packet.buffer.writeByte(LoginPacketMeta.aLoginPacketMeta1996.anInt1993);
                } else {
                    packet.buffer.writeByte(LoginPacketMeta.aLoginPacketMeta1997.anInt1993);
                }

                packet.buffer.writeShort(0);
                var8 = packet.buffer.caret;
                packet.buffer.writeInt(184);
                packet.buffer.writeInt(1);
                packet.buffer.writeByte(anInt923);
                packet.buffer.writeBytes(var26.payload, 0, var26.caret);
                int var9 = packet.buffer.caret;
                packet.buffer.writeCString(Class55.username);
                packet.buffer.writeByte((aBoolean1090 ? 1 : 0) << 1 | (lowMemory ? 1 : 0));
                packet.buffer.writeShort(canvasWidth);
                packet.buffer.writeShort(canvasHeight);
                PacketBuffer var10 = packet.buffer;
                int var12;
                if (random != null) {
                    var10.writeBytes(random, 0, random.length);
                } else {
                    byte[] var11 = new byte[24];

                    try {
                        Statics5.random.seek(0L);
                        Statics5.random.read(var11);

                        for (var12 = 0; var12 < 24 && var11[var12] == 0; ++var12) {
                        }

                        if (var12 >= 24) {
                            throw new IOException();
                        }
                    } catch (Exception var20) {
                        for (int var14 = 0; var14 < 24; ++var14) {
                            var11[var14] = -1;
                        }
                    }

                    var10.writeBytes(var11, 0, var11.length);
                }

                packet.buffer.writeCString(Class147.aString1162);
                packet.buffer.writeInt(Class9.anInt130);
                Buffer var15 = new Buffer(Statics27.operatingSystemNode.getPayloadSize());
                Statics27.operatingSystemNode.method1098(var15);
                packet.buffer.writeBytes(var15.payload, 0, var15.payload.length);
                packet.buffer.writeByte(anInt923);
                packet.buffer.writeInt(0);
                packet.buffer.writeInt(Class73.aCacheReferenceTable583.anInt1240);
                packet.buffer.writeInt(Class65.aCacheReferenceTable526.anInt1240);
                packet.buffer.writeInt(Class104.aCacheReferenceTable773.anInt1240);
                packet.buffer.writeInt(Boundary.aCacheReferenceTable1876.anInt1240);
                packet.buffer.writeInt(Class74.aCacheReferenceTable586.anInt1240);
                packet.buffer.writeInt(Class85.aCacheReferenceTable635.anInt1240);
                packet.buffer.writeInt(Statics15.aCacheReferenceTable1234.anInt1240);
                packet.buffer.writeInt(Class149.aCacheReferenceTable1188.anInt1240);
                packet.buffer.writeInt(Class74.sprites.anInt1240);
                packet.buffer.writeInt(ActionPrioritySetting.aCacheReferenceTable329.anInt1240);
                packet.buffer.writeInt(aCacheReferenceTable948.anInt1240);
                packet.buffer.writeInt(ClanMember.aCacheReferenceTable867.anInt1240);
                packet.buffer.writeInt(Class38.aCacheReferenceTable348.anInt1240);
                packet.buffer.writeInt(Tile.aCacheReferenceTable1152.anInt1240);
                packet.buffer.writeInt(Class63_Sub1.aCacheReferenceTable166.anInt1240);
                packet.buffer.writeInt(RuneScript.aCacheReferenceTable1644.anInt1240);
                packet.buffer.writeInt(0);
                packet.buffer.writeInt(aCacheReferenceTable953.anInt1240);
                packet.buffer.writeInt(DoublyLinkedNode_Sub18.aCacheReferenceTable1506.anInt1240);
                packet.buffer.writeInt(Class34.aCacheReferenceTable341.anInt1240);
                packet.buffer.writeInt(Class25.aCacheReferenceTable304.anInt1240);
                packet.buffer.method1076(var22, var9, packet.buffer.caret);
                packet.buffer.method1041(packet.buffer.caret - var8);
                connectionContext.writeLater(packet);
                connectionContext.flush();
                connectionContext.encryptor = new IsaacCipher(var22);
                int[] var34 = new int[4];

                for (var12 = 0; var12 < 4; ++var12) {
                    var34[var12] = var22[var12] + 50;
                }

                var2.method1399(var34);
                anInt956 = 6;
            }

            if (anInt956 == 6 && var1.readable() > 0) {
                var29 = var1.readByte();
                if (var29 == 21 && gameState == 20) {
                    anInt956 = 9;
                } else if (var29 == 2) {
                    anInt956 = 11;
                } else if (var29 == 15 && gameState == 40) {
                    connectionContext.incomingPacketSize = -1;
                    anInt956 = 16;
                } else if (var29 == 64) {
                    anInt956 = 7;
                } else if (var29 == 23 && anInt954 < 1) {
                    ++anInt954;
                    anInt956 = 0;
                } else {
                    if (var29 != 29) {
                        CacheIndex.method1488(var29);
                        return;
                    }

                    anInt956 = 14;
                }
            }

            if (anInt956 == 7 && var1.readable() > 0) {
                Chatline.anInt1232 = var1.readByte();
                anInt956 = 8;
            }

            if (anInt956 == 8 && var1.readable() >= Chatline.anInt1232) {
                var1.readBytes(var2.payload, 0, Chatline.anInt1232);
                var2.caret = 0;
                anInt956 = 6;
            }

            if (anInt956 == 9 && var1.readable() > 0) {
                anInt952 = (var1.readByte() + 3) * 60;
                anInt956 = 10;
            }

            if (anInt956 == 10) {
                anInt957 = 0;
                Enum_Sub6.setLoginMessages("You have only just left another world.", "Your profile will be transferred in:", anInt952 / 60 + " seconds.");
                if (--anInt952 <= 0) {
                    anInt956 = 0;
                }

            } else {
                if (anInt956 == 11 && var1.readable() >= 1) {
                    World.anInt1869 = var1.readByte();
                    anInt956 = 12;
                }

                int var16;
                if (anInt956 == 12 && var1.readable() >= World.anInt1869) {
                    var5 = var1.readByte() == 1;
                    var1.readBytes(var2.payload, 0, 4);
                    var2.caret = 0;
                    boolean var30 = false;
                    if (var5) {
                        var6 = var2.readHeader() << 24;
                        var6 |= var2.readHeader() << 16;
                        var6 |= var2.readHeader() << 8;
                        var6 |= var2.readHeader();
                        var16 = Statics33.method1141(Class55.username);
                        if (preferences.properties.size() >= 10 && !preferences.properties.containsKey(var16)) {
                            Iterator var17 = preferences.properties.entrySet().iterator();
                            var17.next();
                            var17.remove();
                        }

                        preferences.properties.put(var16, var6);
                    }

                    if (aBoolean958) {
                        preferences.aString362 = Class55.username;
                    } else {
                        preferences.aString362 = null;
                    }

                    Class149.method854();
                    rights = var1.readByte();
                    aBoolean1056 = var1.readByte() == 1;
                    playerIndex = var1.readByte();
                    playerIndex <<= 8;
                    playerIndex += var1.readByte();
                    anInt1029 = var1.readByte();
                    var1.readBytes(var2.payload, 0, 1);
                    var2.caret = 0;
                    IncomingPacketMeta[] var31 = IncomingPacketMeta.values();
                    var8 = var2.method1396();
                    if (var8 < 0 || var8 >= var31.length) {
                        throw new IOException(var8 + " " + var2.caret);
                    }

                    connectionContext.currentIncomingPacket = var31[var8];
                    connectionContext.incomingPacketSize = connectionContext.currentIncomingPacket.size;
                    var1.readBytes(var2.payload, 0, 2);
                    var2.caret = 0;
                    connectionContext.incomingPacketSize = var2.readUShort();

                    try {
                        Class15.method114(instance, "zap");
                    } catch (Throwable ignored) {
                    }

                    anInt956 = 13;
                }

                if (anInt956 == 13) {
                    if (var1.readable() >= connectionContext.incomingPacketSize) {
                        var2.caret = 0;
                        var1.readBytes(var2.payload, 0, connectionContext.incomingPacketSize);
                        aClass180_967.method1119();
                        timeOfPreviousClick = 1L;
                        Class34.mouseRecorder.caret = 0;
                        Class125.aBoolean853 = true;
                        aBoolean937 = true;
                        aLong1095 = -1L;
                        Statics43.classStructures = new LinkedList();
                        connectionContext.drop();
                        connectionContext.inbuffer.caret = 0;
                        connectionContext.currentIncomingPacket = null;
                        connectionContext.lastIncomingPacket = null;
                        connectionContext.secondLastIncomingPacket = null;
                        connectionContext.thirdLastIncomingPacket = null;
                        connectionContext.incomingPacketSize = 0;
                        connectionContext.idleReadTicks = 0;
                        anInt934 = 0;
                        logoutTimer = 0;
                        hintArrowType = 0;
                        ScriptEvent.method1305();
                        Mouse.idleTime = 0;
                        Class69.method376();
                        itemSelectionState = 0;
                        spellSelected = false;
                        anInt903 = 0;
                        mapRotation = 0;
                        anInt988 = 0;
                        Enum_Sub5.aClass172_1216 = null;
                        mapState = 0;
                        minimapFloorLevel = -1;
                        destinationX = 0;
                        destinationY = 0;
                        playerActionPriority = ActionPrioritySetting.anActionPrioritySetting330;
                        npcActionPriority = ActionPrioritySetting.anActionPrioritySetting330;
                        npcCount = 0;
                        ClientPreferences.method250();

                        for (var29 = 0; var29 < 2048; ++var29) {
                            players[var29] = null;
                        }

                        for (var29 = 0; var29 < 32768; ++var29) {
                            npcs[var29] = null;
                        }

                        anInt1030 = -1;
                        projectileDeque.clear();
                        graphicsObjectDeque.clear();

                        for (var29 = 0; var29 < 4; ++var29) {
                            for (var6 = 0; var6 < 104; ++var6) {
                                for (var16 = 0; var16 < 104; ++var16) {
                                    pickableNodeDeques[var29][var6][var16] = null;
                                }
                            }
                        }

                        pendingSpawns = new NodeDeque();
                        Class44.socialSystem.clear();

                        for (var29 = 0; var29 < DoublyLinkedNode_Sub16.anInt568; ++var29) {
                            DoublyLinkedNode_Sub16 var24 = Class63.method360(var29);
                            if (var24 != null) {
                                Varps.tempVarps[var29] = 0;
                                Varps.values[var29] = 0;
                            }
                        }

                        Class147.aClass79_1161.method430();
                        anInt1053 = -1;
                        if (rootInterfaceIndex != -1) {
                            InterfaceNode.method830(rootInterfaceIndex);
                        }

                        for (InterfaceNode var28 = (InterfaceNode) interfaceNodes.method314(); var28 != null; var28 = (InterfaceNode) interfaceNodes.method313()) {
                            Class199.method1182(var28, true);
                        }

                        rootInterfaceIndex = -1;
                        interfaceNodes = new NodeTable(8);
                        pleaseWaitComponent = null;
                        ScriptEvent.method1305();
                        aPlayerAppearance924.update(null, new int[]{0, 0, 0, 0, 0}, false, -1);

                        for (var29 = 0; var29 < 8; ++var29) {
                            playerActions[var29] = null;
                            playerActionPriorities[var29] = false;
                        }

                        Class199.method1181();
                        aBoolean939 = true;

                        for (var29 = 0; var29 < 100; ++var29) {
                            aBooleanArray1089[var29] = true;
                        }

                        Statics19.method919();
                        Varps.clanSystem = null;

                        for (var29 = 0; var29 < 8; ++var29) {
                            grandExchangeOffers[var29] = new GrandExchangeOffer();
                        }

                        PickableNode.aClass78_890 = null;
                        ActionPrioritySetting.processPlayerUpdate(var2);
                        IncomingPacketMeta.anInt206 = -1;
                        Enum_Sub6.onSceneXTEAKeyChange(false, var2);
                        connectionContext.currentIncomingPacket = null;
                    }

                } else {
                    if (anInt956 == 14 && var1.readable() >= 2) {
                        var2.caret = 0;
                        var1.readBytes(var2.payload, 0, 2);
                        var2.caret = 0;
                        Class16.anInt168 = var2.readUShort();
                        anInt956 = 15;
                    }

                    if (anInt956 == 15 && var1.readable() >= Class16.anInt168) {
                        var2.caret = 0;
                        var1.readBytes(var2.payload, 0, Class16.anInt168);
                        var2.caret = 0;
                        String var27 = var2.readString();
                        String var23 = var2.readString();
                        String var32 = var2.readString();
                        Enum_Sub6.setLoginMessages(var27, var23, var32);
                        MouseRecorder.setGameState(10);
                    }

                    if (anInt956 != 16) {
                        ++anInt957;
                        if (anInt957 > 2000) {
                            if (anInt954 < 1) {
                                if (HitsplatDefinition.anInt1929 == NpcEntity.anInt823) {
                                    NpcEntity.anInt823 = Bzip2Context.anInt1579;
                                } else {
                                    NpcEntity.anInt823 = HitsplatDefinition.anInt1929;
                                }

                                ++anInt954;
                                anInt956 = 0;
                            } else {
                                CacheIndex.method1488(-3);
                            }
                        }
                    } else {
                        if (connectionContext.incomingPacketSize == -1) {
                            if (var1.readable() < 2) {
                                return;
                            }

                            var1.readBytes(var2.payload, 0, 2);
                            var2.caret = 0;
                            connectionContext.incomingPacketSize = var2.readUShort();
                        }

                        if (var1.readable() >= connectionContext.incomingPacketSize) {
                            var1.readBytes(var2.payload, 0, connectionContext.incomingPacketSize);
                            var2.caret = 0;
                            var29 = connectionContext.incomingPacketSize;
                            aClass180_967.method1116();
                            connectionContext.drop();
                            connectionContext.inbuffer.caret = 0;
                            connectionContext.currentIncomingPacket = null;
                            connectionContext.lastIncomingPacket = null;
                            connectionContext.secondLastIncomingPacket = null;
                            connectionContext.thirdLastIncomingPacket = null;
                            connectionContext.incomingPacketSize = 0;
                            connectionContext.idleReadTicks = 0;
                            anInt934 = 0;
                            ScriptEvent.method1305();
                            mapState = 0;
                            destinationX = 0;

                            for (var6 = 0; var6 < 2048; ++var6) {
                                players[var6] = null;
                            }

                            PlayerEntity.local = null;

                            for (var6 = 0; var6 < npcs.length; ++var6) {
                                NpcEntity var33 = npcs[var6];
                                if (var33 != null) {
                                    var33.targetIndex = -1;
                                    var33.aBoolean2015 = false;
                                }
                            }

                            Class199.method1181();
                            MouseRecorder.setGameState(30);

                            for (var6 = 0; var6 < 100; ++var6) {
                                aBooleanArray1089[var6] = true;
                            }

                            Statics19.method919();
                            ActionPrioritySetting.processPlayerUpdate(var2);
                            if (var29 != var2.caret) {
                                throw new RuntimeException();
                            }
                        }
                    }
                }
            }
        } catch (IOException var21) {
            if (anInt954 < 1) {
                if (NpcEntity.anInt823 == HitsplatDefinition.anInt1929) {
                    NpcEntity.anInt823 = Bzip2Context.anInt1579;
                } else {
                    NpcEntity.anInt823 = HitsplatDefinition.anInt1929;
                }

                ++anInt954;
                anInt956 = 0;
            } else {
                CacheIndex.method1488(-2);
            }
        }
    }

    final void method751() {
        boolean var1 = false;

        int var2;
        int var5;
        while (!var1) {
            var1 = true;

            for (var2 = 0; var2 < menuRowCount - 1; ++var2) {
                if (menuOpcodes[var2] < 1000 && menuOpcodes[var2 + 1] > 1000) {
                    String var3 = menuTargets[var2];
                    menuTargets[var2] = menuTargets[var2 + 1];
                    menuTargets[var2 + 1] = var3;
                    String var4 = menuActions[var2];
                    menuActions[var2] = menuActions[var2 + 1];
                    menuActions[var2 + 1] = var4;
                    var5 = menuOpcodes[var2];
                    menuOpcodes[var2] = menuOpcodes[var2 + 1];
                    menuOpcodes[var2 + 1] = var5;
                    var5 = menuSecondaryArgs[var2];
                    menuSecondaryArgs[var2] = menuSecondaryArgs[var2 + 1];
                    menuSecondaryArgs[var2 + 1] = var5;
                    var5 = menuTertiaryArgs[var2];
                    menuTertiaryArgs[var2] = menuTertiaryArgs[var2 + 1];
                    menuTertiaryArgs[var2 + 1] = var5;
                    var5 = menuPrimaryArgs[var2];
                    menuPrimaryArgs[var2] = menuPrimaryArgs[var2 + 1];
                    menuPrimaryArgs[var2 + 1] = var5;
                    boolean var6 = menuShiftClickActions[var2];
                    menuShiftClickActions[var2] = menuShiftClickActions[var2 + 1];
                    menuShiftClickActions[var2 + 1] = var6;
                    var1 = false;
                }
            }
        }

        if (DoublyLinkedNode_Sub6.anInterfaceComponent800 == null) {
            if (draggedComponent == null) {
                int var16 = Mouse.clickMeta;
                int var7;
                int var8;
                if (menuOpen) {
                    int var9;
                    int var10;
                    int var17;
                    if (var16 != 1 && (Class27_Sub1.aBoolean492 || var16 != 4)) {
                        var2 = Mouse.x;
                        var7 = Mouse.y;
                        if (var2 < Class108.anInt797 - 10 || var2 > SocialSystem.anInt319 + Class108.anInt797 + 10 || var7 < Statics1.anInt321 - 10 || var7 > Statics1.anInt321 + Class69.anInt543 + 10) {
                            menuOpen = false;
                            var8 = Class108.anInt797;
                            var5 = Statics1.anInt321;
                            var17 = SocialSystem.anInt319;
                            var9 = Class69.anInt543;

                            for (var10 = 0; var10 < anInt1085; ++var10) {
                                if (interfaceWidths[var10] + interfacePositionsX[var10] > var8 && interfacePositionsX[var10] < var17 + var8 && interfaceHeights[var10] + interfacePositionsY[var10] > var5 && interfacePositionsY[var10] < var5 + var9) {
                                    aBooleanArray1089[var10] = true;
                                }
                            }
                        }
                    }

                    if (var16 == 1 || !Class27_Sub1.aBoolean492 && var16 == 4) {
                        var2 = Class108.anInt797;
                        var7 = Statics1.anInt321;
                        var8 = SocialSystem.anInt319;
                        var5 = Mouse.clickX;
                        var17 = Mouse.clickY;
                        var9 = -1;

                        int var11;
                        for (var10 = 0; var10 < menuRowCount; ++var10) {
                            var11 = (menuRowCount - 1 - var10) * 15 + var7 + 31;
                            if (var5 > var2 && var5 < var8 + var2 && var17 > var11 - 13 && var17 < var11 + 3) {
                                var9 = var10;
                            }
                        }

                        if (var9 != -1) {
                            Statics3.processActionAt(var9);
                        }

                        menuOpen = false;
                        var10 = Class108.anInt797;
                        var11 = Statics1.anInt321;
                        int var12 = SocialSystem.anInt319;
                        int var13 = Class69.anInt543;

                        for (int var14 = 0; var14 < anInt1085; ++var14) {
                            if (interfacePositionsX[var14] + interfaceWidths[var14] > var10 && interfacePositionsX[var14] < var10 + var12 && interfaceHeights[var14] + interfacePositionsY[var14] > var11 && interfacePositionsY[var14] < var13 + var11) {
                                aBooleanArray1089[var14] = true;
                            }
                        }
                    }
                } else {
                    var2 = AssociateComparatorByRank.method679();
                    if ((var16 == 1 || !Class27_Sub1.aBoolean492 && var16 == 4) && var2 >= 0) {
                        var7 = menuOpcodes[var2];
                        if (var7 == 39 || var7 == 40 || var7 == 41 || var7 == 42 || var7 == 43 || var7 == 33 || var7 == 34 || var7 == 35 || var7 == 36 || var7 == 37 || var7 == 38 || var7 == 1005) {
                            var8 = menuSecondaryArgs[var2];
                            var5 = menuTertiaryArgs[var2];
                            InterfaceComponent var15 = InterfaceComponent.lookup(var5);
                            if (Statics3.method650(InterfaceComponent.getConfig(var15)) || Class66.method367(InterfaceComponent.getConfig(var15))) {
                                if (DoublyLinkedNode_Sub6.anInterfaceComponent800 != null && !aBoolean1024 && menuRowCount > 0 && !this.method731()) {
                                    Class85.method459(anInt1016, anInt1022);
                                }

                                aBoolean1024 = false;
                                anInt1027 = 0;
                                if (DoublyLinkedNode_Sub6.anInterfaceComponent800 != null) {
                                    Enum_Sub2.repaintComponent(DoublyLinkedNode_Sub6.anInterfaceComponent800);
                                }

                                DoublyLinkedNode_Sub6.anInterfaceComponent800 = InterfaceComponent.lookup(var5);
                                anInt1023 = var8;
                                anInt1016 = Mouse.clickX;
                                anInt1022 = Mouse.clickY;
                                if (var2 >= 0) {
                                    Chatstream.method516(var2);
                                }

                                Enum_Sub2.repaintComponent(DoublyLinkedNode_Sub6.anInterfaceComponent800);
                                return;
                            }
                        }
                    }

                    if ((var16 == 1 || !Class27_Sub1.aBoolean492 && var16 == 4) && this.method731()) {
                        var16 = 2;
                    }

                    if ((var16 == 1 || !Class27_Sub1.aBoolean492 && var16 == 4) && menuRowCount > 0) {
                        Statics3.processActionAt(var2);
                    }

                    if (var16 == 2 && menuRowCount > 0) {
                        this.openMenu(Mouse.clickX, Mouse.clickY);
                    }
                }

            }
        }
    }

    final void method732() {
        Enum_Sub2.repaintComponent(draggedComponent);
        ++Statics2.anInt654;
        if (aBoolean1067 && aBoolean1070) {
            int var1 = Mouse.x;
            int var2 = Mouse.y;
            var1 -= currentComponentDragX;
            var2 -= currentComponentDragY;
            if (var1 < anInt1060) {
                var1 = anInt1060;
            }

            if (var1 + draggedComponent.width > anInt1060 + topLevelOfDraggedComponent.width) {
                var1 = anInt1060 + topLevelOfDraggedComponent.width - draggedComponent.width;
            }

            if (var2 < anInt1069) {
                var2 = anInt1069;
            }

            if (var2 + draggedComponent.height > anInt1069 + topLevelOfDraggedComponent.height) {
                var2 = anInt1069 + topLevelOfDraggedComponent.height - draggedComponent.height;
            }

            int var3 = var1 - anInt1068;
            int var4 = var2 - anInt1073;
            int var5 = draggedComponent.anInt1381;
            if (Statics2.anInt654 > draggedComponent.anInt1383 && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
                aBoolean1062 = true;
            }

            int var6 = var1 - anInt1060 + topLevelOfDraggedComponent.insetX;
            int var7 = var2 - anInt1069 + topLevelOfDraggedComponent.insetY;
            ScriptEvent var8;
            if (draggedComponent.dragListeners != null && aBoolean1062) {
                var8 = new ScriptEvent();
                var8.source = draggedComponent;
                var8.mouseX = var6;
                var8.mouseY = var7;
                var8.args = draggedComponent.dragListeners;
                DefinitionProperty.fireScriptEvent(var8);
            }

            if (Mouse.pressMeta == 0) {
                if (aBoolean1062) {
                    if (draggedComponent.anObjectArray1387 != null) {
                        var8 = new ScriptEvent();
                        var8.source = draggedComponent;
                        var8.mouseX = var6;
                        var8.mouseY = var7;
                        var8.target = anInterfaceComponent1058;
                        var8.args = draggedComponent.anObjectArray1387;
                        DefinitionProperty.fireScriptEvent(var8);
                    }

                    if (anInterfaceComponent1058 != null && InterfaceComponent.getTopLevelComponent(draggedComponent) != null) {
                        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta55, connectionContext.encryptor);
                        packet.buffer.writeLEShortA(anInterfaceComponent1058.componentIndex);
                        packet.buffer.writeLEShortA(anInterfaceComponent1058.itemId);
                        packet.buffer.writeLEShort(draggedComponent.componentIndex);
                        packet.buffer.writeIMEInt(anInterfaceComponent1058.uid);
                        packet.buffer.writeShortA(draggedComponent.itemId);
                        packet.buffer.writeInt(draggedComponent.uid);
                        connectionContext.writeLater(packet);
                    }
                } else if (this.method731()) {
                    this.openMenu(anInt1068 + currentComponentDragX, currentComponentDragY + anInt1073);
                } else if (menuRowCount > 0) {
                    Class85.method459(anInt1068 + currentComponentDragX, anInt1073 + currentComponentDragY);
                }

                draggedComponent = null;
            }

        } else {
            if (Statics2.anInt654 > 1) {
                draggedComponent = null;
            }

        }
    }

    public final void init() {
        try {
            if (this.method937()) {
                for (int var1 = 0; var1 <= 19; ++var1) {
                    String var2 = this.getParameter(Integer.toString(var1));
                    if (var2 != null) {
                        switch (var1) {
                            case 1:
                                aBoolean970 = Integer.parseInt(var2) != 0;
                            case 2:
                            case 11:
                            case 13:
                            case 16:
                            default:
                                break;
                            case 3:
                                membersWorld = var2.equalsIgnoreCase("true");
                                break;
                            case 4:
                                if (anInt923 == -1) {
                                    anInt923 = Integer.parseInt(var2);
                                }
                                break;
                            case 5:
                                currentWorldMask = Integer.parseInt(var2);
                                break;
                            case 6:
                                Class65.aClass149_525 = Class149.method853(Integer.parseInt(var2));
                                break;
                            case 7:
                                Class96.aClass165_725 = TileDecor.method2(Integer.parseInt(var2));
                                break;
                            case 8:
                                if (var2.equalsIgnoreCase("true")) {
                                }
                                break;
                            case 9:
                                Class147.aString1162 = var2;
                                break;
                            case 10:
                                Enum_Sub5[] var3 = new Enum_Sub5[]{Enum_Sub5.anEnum_Sub5_1215, Enum_Sub5.anEnum_Sub5_1217, Enum_Sub5.anEnum_Sub5_1219, Enum_Sub5.anEnum_Sub5_1211, Enum_Sub5.anEnum_Sub5_1214, Enum_Sub5.anEnum_Sub5_1213};
                                Class83.anEnum_Sub5_629 = (Enum_Sub5) OldConnection.method716(var3, Integer.parseInt(var2));
                                if (Class83.anEnum_Sub5_629 == Enum_Sub5.anEnum_Sub5_1211) {
                                    Class36.aClass213_343 = Class213.aClass213_1801;
                                } else {
                                    Class36.aClass213_343 = Class213.aClass213_1799;
                                }
                                break;
                            case 12:
                                currentWorld = Integer.parseInt(var2);
                                break;
                            case 14:
                                Class9.anInt130 = Integer.parseInt(var2);
                                break;
                            case 15:
                                anInt925 = Integer.parseInt(var2);
                                break;
                            case 17:
                                Enum_Sub2.aString623 = var2;
                        }
                    }
                }

                Class57.method330();
                Enum_Sub3.currentDomain = this.getCodeBase().getHost();
                String var4 = Class96.aClass165_725.aString1333;
                byte var5 = 0;

                try {
                    Statics5.anInt834 = 21;
                    AsyncConnection.anInt1210 = var5;

                    try {
                        HitUpdate.aString407 = System.getProperty("os.name");
                    } catch (Exception var19) {
                        HitUpdate.aString407 = "Unknown";
                    }

                    Statics6.aString845 = HitUpdate.aString407.toLowerCase();

                    try {
                        Statics5.aString839 = System.getProperty("user.home");
                        if (Statics5.aString839 != null) {
                            Statics5.aString839 = Statics5.aString839 + "/";
                        }
                    } catch (Exception ignored) {
                    }

                    try {
                        if (Statics6.aString845.startsWith("win")) {
                            if (Statics5.aString839 == null) {
                                Statics5.aString839 = System.getenv("USERPROFILE");
                            }
                        } else if (Statics5.aString839 == null) {
                            Statics5.aString839 = System.getenv("HOME");
                        }

                        if (Statics5.aString839 != null) {
                            Statics5.aString839 = Statics5.aString839 + "/";
                        }
                    } catch (Exception ignored) {
                    }

                    if (Statics5.aString839 == null) {
                        Statics5.aString839 = "~/";
                    }

                    Class114.cacheDirectories = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", Statics5.aString839, "/tmp/", ""};
                    Statics29.aStringArray1533 = new String[]{".jagex_cache_" + AsyncConnection.anInt1210, ".file_store_" + AsyncConnection.anInt1210};

                    int var9;
                    File var10;
                    label176:
                    for (int var6 = 0; var6 < 4; ++var6) {
                        Class38.aFile346 = Class7.method60("oldschool", var4, var6);
                        if (!Class38.aFile346.exists()) {
                            Class38.aFile346.mkdirs();
                        }

                        File[] var7 = Class38.aFile346.listFiles();
                        if (var7 == null) {
                            break;
                        }

                        var9 = 0;

                        while (true) {
                            if (var9 >= var7.length) {
                                break label176;
                            }

                            var10 = var7[var9];

                            boolean var13;
                            try {
                                RandomAccessFile var11 = new RandomAccessFile(var10, "rw");
                                int var12 = var11.read();
                                var11.seek(0L);
                                var11.write(var12);
                                var11.seek(0L);
                                var11.close();
                                var13 = true;
                            } catch (Exception var16) {
                                var13 = false;
                            }

                            if (!var13) {
                                break;
                            }

                            ++var9;
                        }
                    }

                    Statics4.aFile831 = Class38.aFile346;
                    if (!Statics4.aFile831.exists()) {
                        throw new RuntimeException("");
                    }

                    Statics4.aBoolean830 = true;

                    try {
                        File var24 = new File(Statics5.aString839, "random.dat");
                        if (var24.exists()) {
                            Statics5.random = new BufferedFile(new DiskFile(var24, "rw", 25L), 24, 0);
                        } else {
                            label153:
                            for (int var14 = 0; var14 < Statics29.aStringArray1533.length; ++var14) {
                                for (var9 = 0; var9 < Class114.cacheDirectories.length; ++var9) {
                                    var10 = new File(Class114.cacheDirectories[var9] + Statics29.aStringArray1533[var14] + File.separatorChar + "random.dat");
                                    if (var10.exists()) {
                                        Statics5.random = new BufferedFile(new DiskFile(var10, "rw", 25L), 24, 0);
                                        break label153;
                                    }
                                }
                            }
                        }

                        if (Statics5.random == null) {
                            RandomAccessFile var25 = new RandomAccessFile(var24, "rw");
                            var9 = var25.read();
                            var25.seek(0L);
                            var25.write(var9);
                            var25.seek(0L);
                            var25.close();
                            Statics5.random = new BufferedFile(new DiskFile(var24, "rw", 25L), 24, 0);
                        }
                    } catch (IOException ignored) {
                    }

                    Statics5.aBufferedFile_840 = new BufferedFile(new DiskFile(AssociateComparatorByMyWorld.method605("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
                    Statics5.aBufferedFile_835 = new BufferedFile(new DiskFile(AssociateComparatorByMyWorld.method605("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
                    Statics10.aBufferedFileArray1135 = new BufferedFile[Statics5.anInt834];

                    for (int var15 = 0; var15 < Statics5.anInt834; ++var15) {
                        Statics10.aBufferedFileArray1135[var15] = new BufferedFile(new DiskFile(AssociateComparatorByMyWorld.method605("main_file_cache.idx" + var15), "rw", 1048576L), 6000, 0);
                    }
                } catch (Exception var21) {
                    Class8.method65(null, var21);
                }

                instance = this;
                Statics40.anInt1819 = anInt923;
                this.method935();
            }
        } catch (RuntimeException var22) {
            throw Class62.method348(var22, "client.init(" + ')');
        }
    }
}
