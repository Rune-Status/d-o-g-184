package jag.game;

import jag.*;
import jag.audi.*;
import jag.audi.vorbis.Vorbis8;
import jag.commons.JSObjectUtil;
import jag.commons.Jagception;
import jag.commons.collection.*;
import jag.commons.input.Keyboard;
import jag.commons.input.Mouse;
import jag.commons.time.Clock;
import jag.game.option.AttackOptionPriority;
import jag.opcode.LoginStep;
import jag.game.option.ClientPreferences;
import jag.game.relationship.*;
import jag.game.scene.CollisionMap;
import jag.game.scene.SceneGraph;
import jag.game.scene.Tile;
import jag.game.scene.entity.*;
import jag.game.stockmarket.*;
import jag.game.type.*;
import jag.graphics.*;
import jag.js5.*;
import jag.opcode.*;
import jag.script.RuneScript;
import jag.script.ScriptEvent;
import jag.statics.*;
import jag.worldmap.*;
import netscape.javascript.JSObject;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class client extends GameEngine implements LocalPlayerNameProvider {

    public static byte[] random;

    public static final boolean[] renderedComponents;
    public static final boolean[] menuShiftClickActions;
    public static final boolean[] aBooleanArray1083;
    public static final boolean[] aBooleanArray1087;
    public static final boolean[] playerActionPriorities;
    public static final boolean[] aBooleanArray919;

    public static final boolean aBoolean927;
    public static final boolean lockMouseRecorder;
    public static boolean membersWorld;
    public static boolean dynamicScene;
    public static boolean menuOpen;
    public static boolean spellSelected;
    public static boolean lowMemory;
    public static boolean processingComponentDrag;
    public static boolean pendingDisconnect;
    public static boolean processingComponentDragTopLevel;
    public static boolean clientParameter1;
    public static boolean resizableMode;
    public static boolean aBoolean904;
    public static boolean aBoolean1028;
    public static boolean aBoolean939;
    public static boolean aBoolean937;
    public static boolean aBoolean944;
    public static boolean aBoolean1024;
    public static boolean aBoolean1021;
    public static boolean aBoolean1043;
    public static boolean aBoolean1062;
    public static boolean cameraLocked;
    public static boolean aBoolean1042;
    public static boolean aBoolean1044;
    public static boolean aBoolean958;
    public static boolean aBoolean1037;
    public static boolean aBoolean996;
    public static boolean aBoolean984;
    public static boolean aBoolean1020;
    public static boolean aBoolean999;
    public static boolean aBoolean1056;

    public static final int[][][] dynamicSceneData;
    public static final int[][] anIntArrayArray1003;
    public static final int[] menuOpcodes;
    public static final int[] OBJECT_TYPE_TO_STUB_TYPE;
    public static final int[] PLAYER_ACTION_OPCODES;
    public static final int[] menuPrimaryArgs;
    public static final int[] npcIndices2;
    public static final int[] menuSecondaryArgs;
    public static final int[] npcIndices;
    public static final int[] menuTertiaryArgs;
    public static final int[] anIntArray963;
    public static final int[] interfacePositionsX;
    public static final int[] interfaceWidths;
    public static final int[] currentLevels;
    public static final int[] interfaceHeights;
    public static final int[] levels;
    public static final int[] interfacePositionsY;
    public static final int[] experiences;
    public static final int[] anIntArray1035;
    public static final int[] anIntArray945;
    public static final int[] anIntArray942;
    public static final int[] inventories;
    public static final int[] anIntArray1096;
    public static final int[] anIntArray899;
    public static final int[] anIntArray905;
    public static final int[] anIntArray906;
    public static final int[] anIntArray902;
    public static final int[] anIntArray917;
    public static final int[] anIntArray918;
    public static final int[] anIntArray1076;
    public static final int[] anIntArray914;
    public static final int[] anIntArray916;
    public static final int[] anIntArray892;
    public static final int[] anIntArray894;
    public static final int[] anIntArray1013;
    public static final int[] anIntArray1005;
    public static final int[] anIntArray1012;
    public static final int[] anIntArray994;
    public static final int[] anIntArray995;
    public static final int[] anIntArray1007;
    public static final int[] anIntArray991;
    public static final int[] anIntArray1097;
    public static final int[] anIntArray1094;
    public static final int[] anIntArray1079;

    public static final int redrawMode;
    public static final int anInt1036;
    public static final int anInt980;
    public static final int anInt987;
    public static final int anInt983;
    public static final int anInt990;
    public static final int anInt1010;
    public static int clientParameter4;
    public static int anInt1232;
    public static int baseX;
    public static int baseY;
    public static int currentWorld;
    public static int anInt929;
    public static int rights;
    public static int build;
    public static int canvasWidth;
    public static int canvasHeight;
    public static int engineCycle;
    public static int npcCount2;
    public static int anInt934;
    public static int rootInterfaceIndex;
    public static int itemSelectionState;
    public static int menuRowCount;
    public static int gameState;
    public static int playerIndex;
    public static int crosshairX;
    public static int anInt998;
    public static int anInt1034;
    public static int anInt964;
    public static int anInt1085;
    public static int anInt1084;
    public static int logoutTimer;
    public static int anInt993;
    public static int anInt949;
    public static int anInt950;
    public static int currentWorldMask;
    public static int crosshairY;
    public static int anInt954;
    public static int anInt956;
    public static int anInt925;
    public static int crosshairState;
    public static int anInt1039;
    public static int anInt1029;
    public static int anInt923;
    public static int hintArrowState;
    public static int anInt1038;
    public static int npcCount;
    public static int destinationX;
    public static int anInt957;
    public static int anInt1075;
    public static int anInt1065;
    public static int anInt959;
    public static int destinationY;
    public static int currentComponentDragX;
    public static int anInt1066;
    public static int currentComponentDragY;
    public static int anInt1030;
    public static int anInt1060;
    public static int anInt1068;
    public static int anInt1073;
    public static int lastMouseRecordX;
    public static int lastMouseRecordY;
    public static int anInt1047;
    public static int selectedSpellComponentIndex;
    public static int anInt1069;
    public static int anInt972;
    public static int anInt1059;
    public static int viewportWidth;
    public static int anInt975;
    public static int viewportScale;
    public static int hintArrowType;
    public static int anInt966;
    public static int hintArrowNpcIndex;
    public static int anInt1027;
    public static int anInt971;
    public static int hintArrowPlayerIndex;
    public static int anInt968;
    public static int hintArrowX;
    public static int viewportHeight;
    public static int anInt974;
    public static int hintArrowY;
    public static int anInt1016;
    public static int anInt1022;
    public static int anInt1018;
    public static int hintArrowZ;
    public static int anInt946;
    public static int anInt988;
    public static int anInt938;
    public static int anInt1053;
    public static int mapState;
    public static int anInt1015;
    public static int anInt1023;
    public static int anInt1019;
    public static int bootState;
    public static int anInt1074;
    public static int anInt1077;
    public static int audioEffectCount;
    public static int energy;
    public static int anInt898;
    public static int weight;
    public static int anInt952;
    public static int mapRotation;
    public static int anInt1002;
    public static int anInt897;
    public static int anInt1092;
    public static int anInt1061;
    public static int anInt1078;
    public static int minimapFloorLevel;
    public static int anInt930;
    public static int anInt1052;
    public static int anInt1086;
    public static int anInt931;
    public static int anInt1071;
    public static int anInt1001;
    public static int anInt1006;
    public static int anInt926;
    public static int anInt976;
    public static int anInt1041;
    public static int anInt1064;
    public static int anInt1014;
    public static int anInt891;
    public static int anInt900;
    public static int anInt985;
    public static int anInt901;
    public static int publicChatMode;
    public static int anInt982;
    public static int anInt1031;
    public static int tradeChatMode;
    public static int anInt1045;
    public static int anInt1004;
    public static int anInt1054;
    public static int anInt992;
    public static int anInt933;
    public static int anInt895;
    public static int anInt981;
    public static int anInt989;
    public static int anInt979;
    public static int anInt978;
    public static int anInt977;
    public static int anInt986;
    public static int anInt997;
    public static int anInt1008;
    public static int anInt909;
    public static int anInt1000;
    public static int anInt908;
    public static int anInt1063;
    public static int spellTargetFlags;

    public static final long[] aLongArray896;

    public static long aLong1081;
    public static long timeOfPreviousClick;
    public static long lastMouseRecordTime;
    public static long aLong1095;

    public static short aShort922;
    public static short aShort912;
    public static short aShort910;
    public static short aShort921;
    public static short aShort907;
    public static short aShort915;
    public static short aShort913;
    public static short aShort920;

    public static final String[] menuActions;
    public static final String[] menuTargets;
    public static final String[] playerActions;
    public static final String[] overheadMessages;
    public static String[] aStringArray1533;

    public static String aString1091;
    public static String selectedItemName;
    public static String selectedComponentAction;
    public static String selectedSpellName;

    public static final NodeDeque<Pickable>[][][] pickableNodeDeques;
    public static InterfaceComponent[][] interfaces;
    public static final CollisionMap[] collisionMaps;
    public static final StockMarketOffer[] stockMarketOffers;
    public static final AudioEffect[] audioEffects;
    public static final Sprite[] minimapFunctions;
    public static final PlayerEntity[] players;
    public static final NpcEntity[] npcs;

    public static final NodeDeque<ScriptEvent> aNodeDeque1080;
    public static final NodeDeque<ScriptEvent> aNodeDeque1088;
    public static final NodeDeque<ScriptEvent> aNodeDeque1082;
    public static final NodeDeque<EffectObject> effectObjects;
    public static final NodeDeque<Projectile> projectiles;
    public static NodeDeque<PendingSpawn> pendingSpawns;

    public static NodeTable<SubInterface> subInterfaces;
    public static NodeTable<IntegerNode> interfaceConfigs;

    public static InterfaceComponent draggedSpecialComponent;
    public static InterfaceComponent draggedComponent;
    public static InterfaceComponent topLevelOfDraggedComponent;
    public static InterfaceComponent pleaseWaitComponent;
    public static InterfaceComponent minimapComponent;

    public static AttackOptionPriority playerAttackOptionPriority;
    public static AttackOptionPriority npcAttackOptionPriority;

    public static final PlayerAppearance renderedAppearance;

    public static final Map<Integer, ChatHistory> chatHistory;

    public static final ConnectionContext connectionContext;

    public static final OperatingSystemProvider operatingSystemProvider;

    public static LoginStep loginStep;

    public static SceneGraph sceneGraph;

    public static ClientPreferences preferences;

    public static MouseRecorder mouseRecorder;

    public static Varcs varcs;

    public static WorldMap worldMap;

    public static ChatModePrivacyType publicChatPrivacyMode;

    public static OperatingSystemNode operatingSystemNode;

    public static ClanSystem clanSystem;

    public static RelationshipSystem relationshipSystem;

    public static Archive aArchive953;

    public static Archive aArchive948;

    public static final ArrayList anArrayList928;

    public static final RouteStrategy_Sub1 routeStrategy;

    public static final GameStateEvent gameStateEvents;

    public static final StockMarketOfferWorldComparator stockMarketComparator;

    public static Class69 class69;

    public static URLRequestProcessor urlRequestProcessor;

    public static SecureRandomService secureRandomService;

    public static HashMap<NamedFont, BaseFont> fonts;

    public static client instance;

    static {
        lockMouseRecorder = true;
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
        playerAttackOptionPriority = AttackOptionPriority.anActionPrioritySetting330;
        npcAttackOptionPriority = AttackOptionPriority.anActionPrioritySetting330;
        bootState = 0;
        anInt950 = 0;
        anInt949 = 0;
        anInt959 = 0;
        anInt956 = 0;
        anInt957 = 0;
        anInt954 = 0;
        anInt952 = 0;
        loginStep = LoginStep.anEnum_Sub3_826;
        aBoolean958 = false;
        secureRandomService = new SecureRandomService();
        random = null;
        npcs = new NpcEntity[32768];
        npcCount = 0;
        npcIndices = new int[32768];
        anInt964 = 0;
        anIntArray963 = new int[250];
        connectionContext = new ConnectionContext();
        logoutTimer = 0;
        pendingDisconnect = false;
        clientParameter1 = true;
        gameStateEvents = new GameStateEvent();
        fonts = new HashMap<>();
        anInt966 = 0;
        anInt971 = 1;
        anInt968 = 0;
        anInt974 = 1;
        anInt975 = 0;
        collisionMaps = new CollisionMap[4];
        dynamicScene = false;
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
        overheadMessages = new String[anInt1010];
        anIntArrayArray1003 = new int[104][104];
        anInt1001 = 0;
        anInt998 = -1;
        anInt993 = -1;
        crosshairX = 0;
        crosshairY = 0;
        hintArrowState = 0;
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
        PLAYER_ACTION_OPCODES = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
        playerActions = new String[8];
        playerActionPriorities = new boolean[8];
        anIntArray1035 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
        anInt1030 = -1;
        pickableNodeDeques = new NodeDeque[4][104][104];
        pendingSpawns = new NodeDeque<>();
        projectiles = new NodeDeque<>();
        effectObjects = new NodeDeque<>();
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
        selectedItemName = null;
        spellSelected = false;
        selectedSpellComponentIndex = -1;
        anInt1052 = -1;
        selectedComponentAction = null;
        selectedSpellName = null;
        rootInterfaceIndex = -1;
        subInterfaces = new NodeTable<>(8);
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
        minimapComponent = null;
        draggedComponent = null;
        topLevelOfDraggedComponent = null;
        currentComponentDragX = 0;
        currentComponentDragY = 0;
        draggedSpecialComponent = null;
        processingComponentDragTopLevel = false;
        anInt1060 = -1;
        anInt1069 = -1;
        processingComponentDrag = false;
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
        aNodeDeque1082 = new NodeDeque<>();
        aNodeDeque1088 = new NodeDeque<>();
        aNodeDeque1080 = new NodeDeque<>();
        interfaceConfigs = new NodeTable<>(512);
        anInt1085 = 0;
        anInt1084 = -2;
        renderedComponents = new boolean[100];
        aBooleanArray1087 = new boolean[100];
        aBooleanArray1083 = new boolean[100];
        interfacePositionsX = new int[100];
        interfacePositionsY = new int[100];
        interfaceWidths = new int[100];
        interfaceHeights = new int[100];
        redrawMode = 0;
        aLong1081 = 0L;
        resizableMode = true;
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
        minimapFunctions = new Sprite[1000];
        destinationX = 0;
        destinationY = 0;
        mapState = 0;
        anInt900 = 255;
        anInt898 = -1;
        aBoolean904 = false;
        anInt901 = 127;
        anInt897 = 127;
        audioEffectCount = 0;
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
        renderedAppearance = new PlayerAppearance();
        anInt930 = -1;
        anInt931 = -1;
        operatingSystemProvider = new DefaultOperatingSystemProvider();
        stockMarketOffers = new StockMarketOffer[8];
        stockMarketComparator = new StockMarketOfferWorldComparator();
        anInt929 = -1;
        anArrayList928 = new ArrayList(10);
        anInt926 = 0;
        anInt933 = 0;
        routeStrategy = new RouteStrategy_Sub1();
        anIntArray945 = new int[50];
        anIntArray942 = new int[50];
        chatHistory = new HashMap<>();
    }

    public static void processAudioEffects() {
        for (int i = 0; i < audioEffectCount; ++i) {
            if (anIntArray906[i] >= -10) {
                AudioEffect effect = audioEffects[i];
                if (effect == null) {
                    effect = AudioEffect.load(StockMarketOfferLifetimeComparator.aArchive586, anIntArray899[i], 0);
                    if (effect == null) {
                        continue;
                    }

                    anIntArray906[i] += effect.method1521();
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
                        Vorbis8 var10 = effect.method1523().method349(Statics46.aClass98_446);
                        PcmStream_Sub2 var11 = PcmStream_Sub2.method598(var10, 100, var9);
                        var11.method585(anIntArray905[i] - 1);
                        WorldMapLabelSize.aClass5_Sub6_Sub1_528.method312(var11);
                    }

                    anIntArray906[i] = -100;
                }
            } else {
                --audioEffectCount;

                for (int var1 = i; var1 < audioEffectCount; ++var1) {
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
            if (Statics57.anInt1157 != 0) {
                var12 = true;
            } else {
                var12 = Statics50.aClass5_Sub6_Sub3_326.method684();
            }

            if (!var12) {
                if (anInt900 != 0 && anInt898 != -1) {
                    Statics51.method344(Statics15.aArchive1234, anInt898, 0, anInt900, false);
                }

                aBoolean904 = false;
            }
        }

    }

    public static void processObjectSpawns() {
        for (PendingSpawn spawn = pendingSpawns.head(); spawn != null; spawn = pendingSpawns.next()) {
            if (spawn.hitpoints > 0) {
                --spawn.hitpoints;
            }

            int var1;
            int var2;
            ObjectDefinition var3;
            boolean var4;
            if (spawn.hitpoints == 0) {
                if (spawn.anInt380 >= 0) {
                    var1 = spawn.anInt380;
                    var2 = spawn.anInt375;
                    var3 = ObjectDefinition.get(var1);
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

                SerializableInteger.method404(spawn.floorLevel, spawn.type, spawn.sceneX, spawn.sceneY, spawn.anInt380, spawn.anInt112, spawn.anInt375);
                spawn.unlink();
            } else {
                if (spawn.delay > 0) {
                    --spawn.delay;
                }

                if (spawn.delay == 0 && spawn.sceneX >= 1 && spawn.sceneY >= 1 && spawn.sceneX <= 102 && spawn.sceneY <= 102) {
                    if (spawn.anInt693 >= 0) {
                        var1 = spawn.anInt693;
                        var2 = spawn.anInt564;
                        var3 = ObjectDefinition.get(var1);
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

                    SerializableInteger.method404(spawn.floorLevel, spawn.type, spawn.sceneX, spawn.sceneY, spawn.anInt693, spawn.orientation, spawn.anInt564);
                    spawn.delay = -1;
                    if (spawn.anInt380 == spawn.anInt693 && spawn.anInt380 == -1) {
                        spawn.unlink();
                    } else if (spawn.anInt693 == spawn.anInt380 && spawn.anInt112 == spawn.orientation && spawn.anInt375 == spawn.anInt564) {
                        spawn.unlink();
                    }
                }
            }
        }

    }

    public static void dropConnection() {
        if (logoutTimer > 0) {
            DynamicObject.method1506();
        } else {
            gameStateEvents.dropConnection();
            setGameState(40);
            WorldMapGroundDecorType2.aConnection299 = connectionContext.unwrap();
            connectionContext.kill();
        }
    }

    public static void processPlayers() {
        int var0 = GPI.playerCount;
        int[] var1 = GPI.playerIndices;

        for (int var2 = 0; var2 < var0; ++var2) {
            PlayerEntity var3 = players[var1[var2]];
            if (var3 != null) {
                PathingEntity.method1320(var3);
            }
        }

    }

    public static void processNpcs() {
        for (int var0 = 0; var0 < npcCount; ++var0) {
            int var1 = npcIndices[var0];
            NpcEntity var2 = npcs[var1];
            if (var2 != null) {
                PathingEntity.method1320(var2);
            }
        }

    }

    public static int isResizable() {
        return resizableMode ? 2 : 1;
    }

    public static void processAction(int secondary, int tertiary, int opcode, int primary, String action, int crosshairX, int crosshairY) {
        if (opcode >= 2000) {
            opcode -= 2000;
        }

        if (opcode == 1) {
            client.crosshairX = crosshairX;
            client.crosshairY = crosshairY;
            crosshairState = 2;
            hintArrowState = 0;
            destinationX = secondary;
            destinationY = tertiary;
            OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.USE_ITEM_ON_OBJECT, connectionContext.encryptor);
            packet.buffer.writeLEShort(baseX + secondary);
            packet.buffer.writeShort(baseY + tertiary);
            packet.buffer.writeShortA(WorldMapTileDecor.selectedItemIndex);
            packet.buffer.writeIMEInt(SerializableLong.selectedItemComponentUid);
            packet.buffer.writeShort(DefaultAudioSystemProvider.selectedItemId);
            packet.buffer.writeLEShortA(primary);
            packet.buffer.writeNegatedByte(Keyboard.heldKeys[82] ? 1 : 0);
            connectionContext.writeLater(packet);
        } else if (opcode == 2) {
            client.crosshairX = crosshairX;
            client.crosshairY = crosshairY;
            crosshairState = 2;
            hintArrowState = 0;
            destinationX = secondary;
            destinationY = tertiary;
            OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.USE_SPELL_ON_OBJECT, connectionContext.encryptor);
            packet.buffer.writeInt(AttackOptionPriority.selectedSpellComponentUid);
            packet.buffer.writeByte(Keyboard.heldKeys[82] ? 1 : 0);
            packet.buffer.writeShort(baseY + tertiary);
            packet.buffer.writeLEShortA(primary);
            packet.buffer.writeShort(baseX + secondary);
            packet.buffer.writeShortA(selectedSpellComponentIndex);
            connectionContext.writeLater(packet);
        } else if (opcode == 3) {
            client.crosshairX = crosshairX;
            client.crosshairY = crosshairY;
            crosshairState = 2;
            hintArrowState = 0;
            destinationX = secondary;
            destinationY = tertiary;
            OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.OBJECT_ACTION_0, connectionContext.encryptor);
            packet.buffer.writeNegatedByte(Keyboard.heldKeys[82] ? 1 : 0);
            packet.buffer.writeShort(primary);
            packet.buffer.writeShortA(baseY + tertiary);
            packet.buffer.writeLEShortA(baseX + secondary);
            connectionContext.writeLater(packet);
        } else if (opcode == 4) {
            client.crosshairX = crosshairX;
            client.crosshairY = crosshairY;
            crosshairState = 2;
            hintArrowState = 0;
            destinationX = secondary;
            destinationY = tertiary;
            OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.OBJECT_ACTION_1, connectionContext.encryptor);
            packet.buffer.writeLEShortA(primary);
            packet.buffer.writeShort(baseX + secondary);
            packet.buffer.writeByteS(Keyboard.heldKeys[82] ? 1 : 0);
            packet.buffer.writeShortA(baseY + tertiary);
            connectionContext.writeLater(packet);
        } else if (opcode == 5) {
            client.crosshairX = crosshairX;
            client.crosshairY = crosshairY;
            crosshairState = 2;
            hintArrowState = 0;
            destinationX = secondary;
            destinationY = tertiary;
            OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.OBJECT_ACTION_2, connectionContext.encryptor);
            packet.buffer.writeShort(primary);
            packet.buffer.writeShortA(baseX + secondary);
            packet.buffer.writeLEShortA(baseY + tertiary);
            packet.buffer.method1058(Keyboard.heldKeys[82] ? 1 : 0);
            connectionContext.writeLater(packet);
        } else if (opcode == 6) {
            client.crosshairX = crosshairX;
            client.crosshairY = crosshairY;
            crosshairState = 2;
            hintArrowState = 0;
            destinationX = secondary;
            destinationY = tertiary;
            OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.OBJECT_ACTION_3, connectionContext.encryptor);
            packet.buffer.writeShort(baseX + secondary);
            packet.buffer.writeNegatedByte(Keyboard.heldKeys[82] ? 1 : 0);
            packet.buffer.writeShortA(primary);
            packet.buffer.writeShortA(baseY + tertiary);
            connectionContext.writeLater(packet);
        } else {
            if (opcode == 7) {
                NpcEntity npc = npcs[primary];
                if (npc != null) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    hintArrowState = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.USE_ITEM_ON_NPC, connectionContext.encryptor);
                    packet.buffer.writeLEInt(SerializableLong.selectedItemComponentUid);
                    packet.buffer.writeLEShortA(WorldMapTileDecor.selectedItemIndex);
                    packet.buffer.writeShortA(primary);
                    packet.buffer.writeLEShortA(DefaultAudioSystemProvider.selectedItemId);
                    packet.buffer.writeByteS(Keyboard.heldKeys[82] ? 1 : 0);
                    connectionContext.writeLater(packet);
                }
            } else if (opcode == 8) {
                NpcEntity npc = npcs[primary];
                if (npc != null) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    hintArrowState = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.USE_SPELL_ON_NPC, connectionContext.encryptor);
                    packet.buffer.writeLEShort(selectedSpellComponentIndex);
                    packet.buffer.writeLEShort(primary);
                    packet.buffer.writeLEInt(AttackOptionPriority.selectedSpellComponentUid);
                    packet.buffer.writeByte(Keyboard.heldKeys[82] ? 1 : 0);
                    connectionContext.writeLater(packet);
                }
            } else if (opcode == 9) {
                NpcEntity npc = npcs[primary];
                if (npc != null) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    hintArrowState = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.NPC_ACTION_0, connectionContext.encryptor);
                    packet.buffer.writeByteS(Keyboard.heldKeys[82] ? 1 : 0);
                    packet.buffer.writeLEShort(primary);
                    connectionContext.writeLater(packet);
                }
            } else if (opcode == 10) {
                NpcEntity npc = npcs[primary];
                if (npc != null) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    hintArrowState = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.NPC_ACTION_1, connectionContext.encryptor);
                    packet.buffer.writeByteS(Keyboard.heldKeys[82] ? 1 : 0);
                    packet.buffer.writeShortA(primary);
                    connectionContext.writeLater(packet);
                }
            } else if (opcode == 11) {
                NpcEntity npc = npcs[primary];
                if (npc != null) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    hintArrowState = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.NPC_ACTION_2, connectionContext.encryptor);
                    packet.buffer.writeByte(Keyboard.heldKeys[82] ? 1 : 0);
                    packet.buffer.writeLEShort(primary);
                    connectionContext.writeLater(packet);
                }
            } else if (opcode == 12) {
                NpcEntity npc = npcs[primary];
                if (npc != null) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    hintArrowState = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.NPC_ACTION_3, connectionContext.encryptor);
                    packet.buffer.writeByte(Keyboard.heldKeys[82] ? 1 : 0);
                    packet.buffer.writeLEShort(primary);
                    connectionContext.writeLater(packet);
                }
            } else if (opcode == 13) {
                NpcEntity npc = npcs[primary];
                if (npc != null) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    hintArrowState = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.NPC_ACTION_4, connectionContext.encryptor);
                    packet.buffer.writeByteS(Keyboard.heldKeys[82] ? 1 : 0);
                    packet.buffer.writeLEShort(primary);
                    connectionContext.writeLater(packet);
                }
            } else {
                if (opcode == 14) {
                    PlayerEntity player = players[primary];
                    if (player != null) {
                        client.crosshairX = crosshairX;
                        client.crosshairY = crosshairY;
                        crosshairState = 2;
                        hintArrowState = 0;
                        destinationX = secondary;
                        destinationY = tertiary;
                        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.USE_ITEM_ON_PLAYER, connectionContext.encryptor);
                        packet.buffer.writeLEShortA(primary);
                        packet.buffer.writeIMEInt(SerializableLong.selectedItemComponentUid);
                        packet.buffer.writeShort(WorldMapTileDecor.selectedItemIndex);
                        packet.buffer.writeLEShort(DefaultAudioSystemProvider.selectedItemId);
                        packet.buffer.writeByte(Keyboard.heldKeys[82] ? 1 : 0);
                        connectionContext.writeLater(packet);
                    }
                } else if (opcode == 15) {
                    PlayerEntity player = players[primary];
                    if (player != null) {
                        client.crosshairX = crosshairX;
                        client.crosshairY = crosshairY;
                        crosshairState = 2;
                        hintArrowState = 0;
                        destinationX = secondary;
                        destinationY = tertiary;
                        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.USE_SPELL_ON_PLAYER, connectionContext.encryptor);
                        packet.buffer.writeLEShort(primary);
                        packet.buffer.writeShortA(selectedSpellComponentIndex);
                        packet.buffer.writeByte(Keyboard.heldKeys[82] ? 1 : 0);
                        packet.buffer.method1014(AttackOptionPriority.selectedSpellComponentUid);
                        connectionContext.writeLater(packet);
                    }
                } else if (opcode == 16) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    hintArrowState = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.USE_ITEM_ON_PICKABLE, connectionContext.encryptor);
                    packet.buffer.writeLEShortA(primary);
                    packet.buffer.writeInt(SerializableLong.selectedItemComponentUid);
                    packet.buffer.writeShortA(DefaultAudioSystemProvider.selectedItemId);
                    packet.buffer.writeLEShortA(baseY + tertiary);
                    packet.buffer.writeByteS(Keyboard.heldKeys[82] ? 1 : 0);
                    packet.buffer.writeShortA(baseX + secondary);
                    packet.buffer.writeShortA(WorldMapTileDecor.selectedItemIndex);
                    connectionContext.writeLater(packet);
                } else if (opcode == 17) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    hintArrowState = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.USE_SPELL_ON_PICKABLE, connectionContext.encryptor);
                    packet.buffer.writeShortA(baseY + tertiary);
                    packet.buffer.writeLEInt(AttackOptionPriority.selectedSpellComponentUid);
                    packet.buffer.writeLEShortA(primary);
                    packet.buffer.writeShortA(selectedSpellComponentIndex);
                    packet.buffer.writeLEShort(baseX + secondary);
                    packet.buffer.method1058(Keyboard.heldKeys[82] ? 1 : 0);
                    connectionContext.writeLater(packet);
                } else if (opcode == 18) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    hintArrowState = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.PICKABLE_ACTION_0, connectionContext.encryptor);
                    packet.buffer.writeByteS(Keyboard.heldKeys[82] ? 1 : 0);
                    packet.buffer.writeLEShort(baseY + tertiary);
                    packet.buffer.writeShortA(baseX + secondary);
                    packet.buffer.writeLEShortA(primary);
                    connectionContext.writeLater(packet);
                } else if (opcode == 19) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    hintArrowState = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.PICKABLE_ACTION_1, connectionContext.encryptor);
                    packet.buffer.method1058(Keyboard.heldKeys[82] ? 1 : 0);
                    packet.buffer.writeShortA(baseX + secondary);
                    packet.buffer.writeShortA(primary);
                    packet.buffer.writeShortA(baseY + tertiary);
                    connectionContext.writeLater(packet);
                } else if (opcode == 20) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    hintArrowState = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.PICKABLE_ACTION_2, connectionContext.encryptor);
                    packet.buffer.writeNegatedByte(Keyboard.heldKeys[82] ? 1 : 0);
                    packet.buffer.writeLEShortA(baseX + secondary);
                    packet.buffer.writeShortA(baseY + tertiary);
                    packet.buffer.writeLEShort(primary);
                    connectionContext.writeLater(packet);
                } else if (opcode == 21) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    hintArrowState = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.PICKABLE_ACTION_3, connectionContext.encryptor);
                    packet.buffer.writeLEShortA(baseX + secondary);
                    packet.buffer.writeShortA(baseY + tertiary);
                    packet.buffer.writeByteS(Keyboard.heldKeys[82] ? 1 : 0);
                    packet.buffer.writeShort(primary);
                    connectionContext.writeLater(packet);
                } else if (opcode == 22) {
                    client.crosshairX = crosshairX;
                    client.crosshairY = crosshairY;
                    crosshairState = 2;
                    hintArrowState = 0;
                    destinationX = secondary;
                    destinationY = tertiary;
                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.PICKABLE_ACTION_4, connectionContext.encryptor);
                    packet.buffer.writeLEShort(baseX + secondary);
                    packet.buffer.writeLEShort(baseY + tertiary);
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
                    if (opcode == 24) {
                        InterfaceComponent component = InterfaceComponent.lookup(tertiary);
                        boolean appearance = true;
                        if (component.contentType > 0) {
                            appearance = Statics48.isAppearanceCode(component);
                        }

                        if (appearance) {
                            OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.BUTTON_ACTION, connectionContext.encryptor);
                            packet.buffer.writeInt(tertiary);
                            connectionContext.writeLater(packet);
                        }
                    } else {
                        if (opcode == 25) {
                            InterfaceComponent component = InterfaceComponent.lookup(tertiary, secondary);
                            if (component != null) {
                                Statics17.processSelectedSpell();
                                Statics49.selectSpell(tertiary, secondary, SerializableLong.getComponentSpellTargets(InterfaceComponent.getConfig(component)), component.itemId);
                                itemSelectionState = 0;
                                selectedComponentAction = Enum_Sub8.method1091(component);
                                if (selectedComponentAction == null) {
                                    selectedComponentAction = "null";
                                }

                                if (component.aBoolean562) {
                                    selectedSpellName = component.name + World.getColorTags(16777215);
                                } else {
                                    selectedSpellName = World.getColorTags(65280) + component.spellName + World.getColorTags(16777215);
                                }
                            }

                            return;
                        }

                        if (opcode == 26) {
                            InterfaceComponent.closeInterface();
                        } else {
                            if (opcode == 28) {
                                OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.BUTTON_ACTION, connectionContext.encryptor);
                                packet.buffer.writeInt(tertiary);
                                connectionContext.writeLater(packet);
                                InterfaceComponent component = InterfaceComponent.lookup(tertiary);
                                if (component.functionOpcodes != null && component.functionOpcodes[0][0] == 5) {
                                    int index = component.functionOpcodes[0][1];
                                    Vars.values[index] = 1 - Vars.values[index];
                                    OldConnection.method712(index);
                                }
                            } else if (opcode == 29) {
                                OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.BUTTON_ACTION, connectionContext.encryptor);
                                packet.buffer.writeInt(tertiary);
                                connectionContext.writeLater(packet);
                                InterfaceComponent component = InterfaceComponent.lookup(tertiary);
                                if (component.functionOpcodes != null && component.functionOpcodes[0][0] == 5) {
                                    int index = component.functionOpcodes[0][1];
                                    if (Vars.values[index] != component.anIntArray1395[0]) {
                                        Vars.values[index] = component.anIntArray1395[0];
                                        OldConnection.method712(index);
                                    }
                                }
                            } else if (opcode == 30) {
                                if (pleaseWaitComponent == null) {
                                    Clock.processDialogActionPacket(tertiary, secondary);
                                    pleaseWaitComponent = InterfaceComponent.lookup(tertiary, secondary);
                                    InterfaceComponent.repaint(pleaseWaitComponent);
                                }
                            } else if (opcode == 31) {
                                OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.USE_ITEM_ON_ITEM, connectionContext.encryptor);
                                packet.buffer.writeIMEInt(tertiary);
                                packet.buffer.writeLEShortA(DefaultAudioSystemProvider.selectedItemId);
                                packet.buffer.writeInt(SerializableLong.selectedItemComponentUid);
                                packet.buffer.writeShort(WorldMapTileDecor.selectedItemIndex);
                                packet.buffer.writeShort(secondary);
                                packet.buffer.writeShort(primary);
                                connectionContext.writeLater(packet);
                                anInt1018 = 0;
                                StockMarketOfferWorldComparator.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                anInt1015 = secondary;
                            } else if (opcode == 32) {
                                OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.USE_SPELL_ON_ITEM, connectionContext.encryptor);
                                packet.buffer.writeLEShortA(selectedSpellComponentIndex);
                                packet.buffer.writeLEShort(secondary);
                                packet.buffer.writeLEShort(primary);
                                packet.buffer.writeIMEInt(tertiary);
                                packet.buffer.method1014(AttackOptionPriority.selectedSpellComponentUid);
                                connectionContext.writeLater(packet);
                                anInt1018 = 0;
                                StockMarketOfferWorldComparator.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                anInt1015 = secondary;
                            } else if (opcode == 33) {
                                OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.ITEM_ACTION_0, connectionContext.encryptor);
                                packet.buffer.writeInt(tertiary);
                                packet.buffer.writeLEShort(secondary);
                                packet.buffer.writeLEShort(primary);
                                connectionContext.writeLater(packet);
                                anInt1018 = 0;
                                StockMarketOfferWorldComparator.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                anInt1015 = secondary;
                            } else if (opcode == 34) {
                                OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.ITEM_ACTION_1, connectionContext.encryptor);
                                packet.buffer.writeInt(tertiary);
                                packet.buffer.writeLEShort(secondary);
                                packet.buffer.writeShortA(primary);
                                connectionContext.writeLater(packet);
                                anInt1018 = 0;
                                StockMarketOfferWorldComparator.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                anInt1015 = secondary;
                            } else if (opcode == 35) {
                                OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.ITEM_ACTION_2, connectionContext.encryptor);
                                packet.buffer.writeLEShort(primary);
                                packet.buffer.writeLEInt(tertiary);
                                packet.buffer.writeShort(secondary);
                                connectionContext.writeLater(packet);
                                anInt1018 = 0;
                                StockMarketOfferWorldComparator.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                anInt1015 = secondary;
                            } else if (opcode == 36) {
                                OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.ITEM_ACTION_3, connectionContext.encryptor);
                                packet.buffer.writeLEShortA(primary);
                                packet.buffer.writeLEShort(secondary);
                                packet.buffer.writeIMEInt(tertiary);
                                connectionContext.writeLater(packet);
                                anInt1018 = 0;
                                StockMarketOfferWorldComparator.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                anInt1015 = secondary;
                            } else if (opcode == 37) {
                                OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.ITEM_ACTION_4, connectionContext.encryptor);
                                packet.buffer.writeShortA(secondary);
                                packet.buffer.writeIMEInt(tertiary);
                                packet.buffer.writeShortA(primary);
                                connectionContext.writeLater(packet);
                                anInt1018 = 0;
                                StockMarketOfferWorldComparator.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                anInt1015 = secondary;
                            } else {
                                if (opcode == 38) {
                                    Statics17.processSelectedSpell();
                                    InterfaceComponent component = InterfaceComponent.lookup(tertiary);
                                    itemSelectionState = 1;
                                    DefaultAudioSystemProvider.selectedItemId = secondary;
                                    SerializableLong.selectedItemComponentUid = tertiary;
                                    WorldMapTileDecor.selectedItemIndex = primary;
                                    InterfaceComponent.repaint(component);
                                    selectedItemName = World.getColorTags(16748608) + ItemDefinition.get(primary).name + World.getColorTags(16777215);
                                    if (selectedItemName == null) {
                                        selectedItemName = "null";
                                    }

                                    return;
                                }

                                if (opcode == 39) {
                                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.TABLE_ACTION_0, connectionContext.encryptor);
                                    packet.buffer.writeShortA(secondary);
                                    packet.buffer.writeShort(primary);
                                    packet.buffer.method1014(tertiary);
                                    connectionContext.writeLater(packet);
                                    anInt1018 = 0;
                                    StockMarketOfferWorldComparator.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                    anInt1015 = secondary;
                                } else if (opcode == 40) {
                                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.TABLE_ACTION_1, connectionContext.encryptor);
                                    packet.buffer.writeIMEInt(tertiary);
                                    packet.buffer.writeShortA(secondary);
                                    packet.buffer.writeLEShortA(primary);
                                    connectionContext.writeLater(packet);
                                    anInt1018 = 0;
                                    StockMarketOfferWorldComparator.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                    anInt1015 = secondary;
                                } else if (opcode == 41) {
                                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.TABLE_ACTION_2, connectionContext.encryptor);
                                    packet.buffer.writeLEShort(secondary);
                                    packet.buffer.method1014(tertiary);
                                    packet.buffer.writeLEShort(primary);
                                    connectionContext.writeLater(packet);
                                    anInt1018 = 0;
                                    StockMarketOfferWorldComparator.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                    anInt1015 = secondary;
                                } else if (opcode == 42) {
                                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.TABLE_ACTION_3, connectionContext.encryptor);
                                    packet.buffer.writeShort(primary);
                                    packet.buffer.writeShort(secondary);
                                    packet.buffer.writeIMEInt(tertiary);
                                    connectionContext.writeLater(packet);
                                    anInt1018 = 0;
                                    StockMarketOfferWorldComparator.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                    anInt1015 = secondary;
                                } else if (opcode == 43) {
                                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.TABLE_ACTION_4, connectionContext.encryptor);
                                    packet.buffer.writeShort(primary);
                                    packet.buffer.method1014(tertiary);
                                    packet.buffer.writeShort(secondary);
                                    connectionContext.writeLater(packet);
                                    anInt1018 = 0;
                                    StockMarketOfferWorldComparator.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                    anInt1015 = secondary;
                                } else if (opcode == 44) {
                                    PlayerEntity player = players[primary];
                                    if (player != null) {
                                        client.crosshairX = crosshairX;
                                        client.crosshairY = crosshairY;
                                        crosshairState = 2;
                                        hintArrowState = 0;
                                        destinationX = secondary;
                                        destinationY = tertiary;
                                        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.PLAYER_ACTION_0, connectionContext.encryptor);
                                        packet.buffer.writeShortA(primary);
                                        packet.buffer.method1058(Keyboard.heldKeys[82] ? 1 : 0);
                                        connectionContext.writeLater(packet);
                                    }
                                } else if (opcode == 45) {
                                    PlayerEntity player = players[primary];
                                    if (player != null) {
                                        client.crosshairX = crosshairX;
                                        client.crosshairY = crosshairY;
                                        crosshairState = 2;
                                        hintArrowState = 0;
                                        destinationX = secondary;
                                        destinationY = tertiary;
                                        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.PLAYER_ACTION_1, connectionContext.encryptor);
                                        packet.buffer.writeLEShortA(primary);
                                        packet.buffer.writeByte(Keyboard.heldKeys[82] ? 1 : 0);
                                        connectionContext.writeLater(packet);
                                    }
                                } else if (opcode == 46) {
                                    PlayerEntity player = players[primary];
                                    if (player != null) {
                                        client.crosshairX = crosshairX;
                                        client.crosshairY = crosshairY;
                                        crosshairState = 2;
                                        hintArrowState = 0;
                                        destinationX = secondary;
                                        destinationY = tertiary;
                                        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.PLAYER_ACTION_2, connectionContext.encryptor);
                                        packet.buffer.writeByteS(Keyboard.heldKeys[82] ? 1 : 0);
                                        packet.buffer.writeLEShort(primary);
                                        connectionContext.writeLater(packet);
                                    }
                                } else if (opcode == 47) {
                                    PlayerEntity player = players[primary];
                                    if (player != null) {
                                        client.crosshairX = crosshairX;
                                        client.crosshairY = crosshairY;
                                        crosshairState = 2;
                                        hintArrowState = 0;
                                        destinationX = secondary;
                                        destinationY = tertiary;
                                        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.PLAYER_ACTION_3, connectionContext.encryptor);
                                        packet.buffer.writeLEShortA(primary);
                                        packet.buffer.writeNegatedByte(Keyboard.heldKeys[82] ? 1 : 0);
                                        connectionContext.writeLater(packet);
                                    }
                                } else if (opcode == 48) {
                                    PlayerEntity player = players[primary];
                                    if (player != null) {
                                        client.crosshairX = crosshairX;
                                        client.crosshairY = crosshairY;
                                        crosshairState = 2;
                                        hintArrowState = 0;
                                        destinationX = secondary;
                                        destinationY = tertiary;
                                        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.PLAYER_ACTION_4, connectionContext.encryptor);
                                        packet.buffer.writeNegatedByte(Keyboard.heldKeys[82] ? 1 : 0);
                                        packet.buffer.writeLEShort(primary);
                                        connectionContext.writeLater(packet);
                                    }
                                } else if (opcode == 49) {
                                    PlayerEntity player = players[primary];
                                    if (player != null) {
                                        client.crosshairX = crosshairX;
                                        client.crosshairY = crosshairY;
                                        crosshairState = 2;
                                        hintArrowState = 0;
                                        destinationX = secondary;
                                        destinationY = tertiary;
                                        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.PLAYER_ACTION_5, connectionContext.encryptor);
                                        packet.buffer.writeShort(primary);
                                        packet.buffer.method1058(Keyboard.heldKeys[82] ? 1 : 0);
                                        connectionContext.writeLater(packet);
                                    }
                                } else if (opcode == 50) {
                                    PlayerEntity player = players[primary];
                                    if (player != null) {
                                        client.crosshairX = crosshairX;
                                        client.crosshairY = crosshairY;
                                        crosshairState = 2;
                                        hintArrowState = 0;
                                        destinationX = secondary;
                                        destinationY = tertiary;
                                        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.PLAYER_ACTION_6, connectionContext.encryptor);
                                        packet.buffer.writeLEShort(primary);
                                        packet.buffer.method1058(Keyboard.heldKeys[82] ? 1 : 0);
                                        connectionContext.writeLater(packet);
                                    }
                                } else if (opcode == 51) {
                                    PlayerEntity player = players[primary];
                                    if (player != null) {
                                        client.crosshairX = crosshairX;
                                        client.crosshairY = crosshairY;
                                        crosshairState = 2;
                                        hintArrowState = 0;
                                        destinationX = secondary;
                                        destinationY = tertiary;
                                        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.PLAYER_ACTION_7, connectionContext.encryptor);
                                        packet.buffer.method1058(Keyboard.heldKeys[82] ? 1 : 0);
                                        packet.buffer.writeShortA(primary);
                                        connectionContext.writeLater(packet);
                                    }
                                } else {
                                    label960:
                                    {
                                        if (opcode != 57) {
                                            if (opcode == 58) {
                                                InterfaceComponent component = InterfaceComponent.lookup(tertiary, secondary);
                                                if (component != null) {
                                                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.USE_SPELL_ON_COMPONENT, connectionContext.encryptor);
                                                    packet.buffer.writeIMEInt(tertiary);
                                                    packet.buffer.writeShort(component.itemId);
                                                    packet.buffer.writeLEInt(AttackOptionPriority.selectedSpellComponentUid);
                                                    packet.buffer.writeLEShortA(secondary);
                                                    packet.buffer.writeShortA(selectedSpellComponentIndex);
                                                    packet.buffer.writeShortA(anInt1052);
                                                    connectionContext.writeLater(packet);
                                                }
                                                break label960;
                                            }

                                            if (opcode == 1001) {
                                                client.crosshairX = crosshairX;
                                                client.crosshairY = crosshairY;
                                                crosshairState = 2;
                                                hintArrowState = 0;
                                                destinationX = secondary;
                                                destinationY = tertiary;
                                                OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.OBJECT_ACTION_4, connectionContext.encryptor);
                                                packet.buffer.writeShort(baseY + tertiary);
                                                packet.buffer.writeShort(baseX + secondary);
                                                packet.buffer.writeShort(primary);
                                                packet.buffer.method1058(Keyboard.heldKeys[82] ? 1 : 0);
                                                connectionContext.writeLater(packet);
                                                break label960;
                                            }

                                            if (opcode == 1002) {
                                                client.crosshairX = crosshairX;
                                                client.crosshairY = crosshairY;
                                                crosshairState = 2;
                                                hintArrowState = 0;
                                                OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.EXAMINE_OBJECT, connectionContext.encryptor);
                                                packet.buffer.writeLEShort(primary);
                                                connectionContext.writeLater(packet);
                                                break label960;
                                            }

                                            if (opcode == 1003) {
                                                client.crosshairX = crosshairX;
                                                client.crosshairY = crosshairY;
                                                crosshairState = 2;
                                                hintArrowState = 0;
                                                NpcEntity npc = npcs[primary];
                                                if (npc != null) {
                                                    NpcDefinition definition = npc.definition;
                                                    if (definition.transformIds != null) {
                                                        definition = definition.transform();
                                                    }

                                                    if (definition != null) {
                                                        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.EXAMINE_NPC, connectionContext.encryptor);
                                                        packet.buffer.writeShortA(definition.id);
                                                        connectionContext.writeLater(packet);
                                                    }
                                                }
                                                break label960;
                                            }

                                            if (opcode == 1004) {
                                                client.crosshairX = crosshairX;
                                                client.crosshairY = crosshairY;
                                                crosshairState = 2;
                                                hintArrowState = 0;
                                                OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.EXAMINE_ITEM, connectionContext.encryptor);
                                                packet.buffer.writeShort(primary);
                                                connectionContext.writeLater(packet);
                                                break label960;
                                            }

                                            if (opcode == 1005) {
                                                InterfaceComponent component = InterfaceComponent.lookup(tertiary);
                                                if (component != null && component.itemStackSizes[secondary] >= 100000) {
                                                    Statics19.messageReceived(27, "", component.itemStackSizes[secondary] + " x " + ItemDefinition.get(primary).name);
                                                } else {
                                                    OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.EXAMINE_ITEM, connectionContext.encryptor);
                                                    packet.buffer.writeShort(primary);
                                                    connectionContext.writeLater(packet);
                                                }

                                                anInt1018 = 0;
                                                StockMarketOfferWorldComparator.anInterfaceComponent351 = InterfaceComponent.lookup(tertiary);
                                                anInt1015 = secondary;
                                                break label960;
                                            }

                                            if (opcode != 1007) {
                                                //world map sht
                                                if (opcode == 1008 || opcode == 1011 || opcode == 1009 || opcode == 1010 || opcode == 1012) {
                                                    worldMap.method1253(opcode, primary, new WorldMapPosition(secondary), new WorldMapPosition(tertiary));
                                                }
                                                break label960;
                                            }
                                        }

                                        InterfaceComponent component = InterfaceComponent.lookup(tertiary, secondary);
                                        if (component != null) {
                                            InterfaceComponent.processAction(primary, tertiary, secondary, component.itemId, action);
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
            InterfaceComponent.repaint(InterfaceComponent.lookup(SerializableLong.selectedItemComponentUid));
        }

        if (spellSelected) {
            Statics17.processSelectedSpell();
        }

        //maybe drag related
        if (StockMarketOfferWorldComparator.anInterfaceComponent351 != null && anInt1018 == 0) {
            InterfaceComponent.repaint(StockMarketOfferWorldComparator.anInterfaceComponent351);
        }

    }

    public static void setGameState(int var0) {
        if (var0 != gameState) {
            if (gameState == 0) {
                instance.method929();
            }

            if (var0 == 20 || var0 == 40 || var0 == 45) {
                anInt956 = 0;
                anInt957 = 0;
                anInt954 = 0;
                gameStateEvents.updateGameState(var0);
                if (var0 != 20) {
                    PlayerAccountType.method918(false);
                }
            }

            if (var0 != 20 && var0 != 40 && WorldMapGroundDecorType2.aConnection299 != null) {
                WorldMapGroundDecorType2.aConnection299.stop();
                WorldMapGroundDecorType2.aConnection299 = null;
            }

            if (gameState == 25) {
                anInt975 = 0;
                anInt966 = 0;
                anInt971 = 1;
                anInt968 = 0;
                anInt974 = 1;
            }

            if (var0 != 5 && var0 != 10) {
                if (var0 == 20) {
                    WorldMapSprite.method245(aArchive948, StockMarketOfferLifetimeComparator.sprites, true, gameState == 11 ? 4 : 0);
                } else if (var0 == 11) {
                    WorldMapSprite.method245(aArchive948, StockMarketOfferLifetimeComparator.sprites, false, 4);
                } else if (Login.aBoolean476) {
                    Statics49.aDoublyNode_Sub24_Sub4_126 = null;
                    GraphicsProvider.aDoublyNode_Sub24_Sub4_1815 = null;
                    Login.aDoublyNode_Sub24_Sub4Array478 = null;
                    WorldMapGroundDecorType.aSprite308 = null;
                    Statics1.aSprite324 = null;
                    NamedFont.aDoublyNode_Sub24_Sub4_1623 = null;
                    AssociateComparator_Sub2.aDoublyNode_Sub24_Sub4Array765 = null;
                    Statics11.aDoublyNode_Sub24_Sub4_1148 = null;
                    WorldMapAreaChunk_Sub2.aDoublyNode_Sub24_Sub4_288 = null;
                    Class46.aSpriteArray429 = null;
                    ClientLocale.aDoublyNode_Sub24_Sub4Array1178 = null;
                    StockMarketOfferQuantityComparator.aDoublyNode_Sub24_Sub4Array653 = null;
                    AnimationFrameGroup.aDoublyNode_Sub24_Sub4Array801 = null;
                    AnimationFrame.aDoublyNode_Sub24_Sub4_811 = null;
                    AsyncOutputStream.loginScreenEffect.method277();
                    Statics57.anInt1157 = 1;
                    Statics57.aReferenceTable1155 = null;
                    Statics8.anInt1122 = -1;
                    Statics50.anInt327 = -1;
                    Pickable.anInt379 = 0;
                    WorldMapChunkType.aBoolean620 = false;
                    AudioOverrideEffect.anInt1130 = 2;
                    DirectByteBufferProvider.method803(true);
                    Login.aBoolean476 = false;
                }
            } else {
                WorldMapSprite.method245(aArchive948, StockMarketOfferLifetimeComparator.sprites, true, 0);
            }

            gameState = var0;
        }
    }

    public static void sendError(String var0, Throwable var1) {
        if (var1 != null) {
            var1.printStackTrace();
        } else {
            try {
                String var2 = "";
                if (var1 != null) {
                    var2 = WorldMapController.method143(var1);
                }

                if (var0 != null) {
                    if (var1 != null) {
                        var2 = var2 + " | ";
                    }

                    var2 = var2 + var0;
                }

                System.out.println("Error: " + var2);
                var2 = var2.replace(':', '.');
                var2 = var2.replace('@', '_');
                var2 = var2.replace('&', '_');
                var2 = var2.replace('#', '_');
                if (Jagception.anApplet1881 == null) {
                    return;
                }

                URL var3 = new URL(Jagception.anApplet1881.getCodeBase(), "clienterror.ws?c=" + build + "&u=" + Jagception.aString1882 + "&v1=" + OldConnectionTaskProcessor.aString855 + "&v2=" + OldConnectionTaskProcessor.aString856 + "&ct=" + clientParameter4 + "&e=" + var2);
                DataInputStream var4 = new DataInputStream(var3.openStream());
                var4.read();
                var4.close();
            } catch (Exception ignored) {
            }

        }
    }

    public static WorldMap getWorldMap() {
        return worldMap;
    }

    public static int method888(int var0) {
        return (int) ((Math.log(var0) / Statics46.aDouble437 - 7.0D) * 256.0D);
    }

    public static void method884(int var0, int var1, int var2) {
        if (anInt901 != 0 && var1 != 0 && audioEffectCount < 50) {
            anIntArray899[audioEffectCount] = var0;
            anIntArray905[audioEffectCount] = var1;
            anIntArray906[audioEffectCount] = var2;
            audioEffects[audioEffectCount] = null;
            anIntArray902[audioEffectCount] = 0;
            ++audioEffectCount;
        }

    }

    public static void method883(int var0, int var1) {
        if (hintArrowType == 2) {
            SceneGraph.absoluteToViewport((hintArrowX - baseX << 7) + anInt946, anInt938 * 64 + (hintArrowY - baseY << 7), hintArrowZ * 4);
            if (anInt998 > -1 && engineCycle % 20 < 10) {
                ClassStructure.hitmarks[0].method809(var0 + anInt998 - 12, anInt993 + var1 - 28);
            }

        }
    }

    public static void method181(AnimationSequence var0, int var1, int var2, int var3) {
        if (audioEffectCount < 50 && anInt897 != 0) {
            if (var0.anIntArray691 != null && var1 < var0.anIntArray691.length) {
                int var4 = var0.anIntArray691[var1];
                if (var4 != 0) {
                    int var5 = var4 >> 8;
                    int var6 = var4 >> 4 & 7;
                    int var7 = var4 & 15;
                    anIntArray899[audioEffectCount] = var5;
                    anIntArray905[audioEffectCount] = var6;
                    anIntArray906[audioEffectCount] = 0;
                    audioEffects[audioEffectCount] = null;
                    int var8 = (var2 - 64) / 128;
                    int var9 = (var3 - 64) / 128;
                    anIntArray902[audioEffectCount] = var7 + (var9 << 8) + (var8 << 16);
                    ++audioEffectCount;
                }
            }
        }
    }

    public static void gc() {
        TileOverlay.aReferenceCache385.clear();
        TileUnderlay.aReferenceCache385.clear();
        IdentikitDefinition.aReferenceCache700.clear();
        ObjectDefinition.aReferenceCache700.clear();
        ObjectDefinition.aReferenceCache1228.clear();
        ObjectDefinition.aReferenceCache1513.clear();
        ObjectDefinition.aReferenceCache1514.clear();
        NpcDefinition.cache.clear();
        NpcDefinition.modelCache.clear();
        ItemDefinition.clear();
        AnimationSequence.aReferenceCache700.clear();
        AnimationSequence.aReferenceCache1228.clear();
        EffectAnimation.clear();
        Varbit.cache.clear();
        AudioOverride.clear();
        StockMarketEvent.clear();
        HealthBarDefinition.cache.clear();
        HealthBarDefinition.aReferenceCache700.clear();
        ParameterDefinition.aReferenceCache385.clear();
        DefinitionProperty.clear();
        WorldMapFunction.cache.clear();
        Class223.clear();
        InterfaceComponent.aReferenceCache1370.clear();
        InterfaceComponent.aReferenceCache1364.clear();
        InterfaceComponent.aReferenceCache1367.clear();
        InterfaceComponent.aReferenceCache1374.clear();
        ((DefaultMaterialProvider) JagGraphics3D.aMaterialProvider783).clear();
        RuneScript.aReferenceCache1647.clear();
        SerializableInteger.aArchive583.clear();
        WorldMapLabelSize.aArchive526.clear();
        Login.aArchive1876.clear();
        StockMarketOfferLifetimeComparator.aArchive586.clear();
        SerializableProcessor.aArchive635.clear();
        Statics15.aArchive1234.clear();
        ClientLocale.aArchive1188.clear();
        StockMarketOfferLifetimeComparator.sprites.clear();
        AttackOptionPriority.aArchive329.clear();
        aArchive948.clear();
        ClanMember.aArchive867.clear();
        StockMarketOfferWorldComparator.aArchive348.clear();
    }

    public static String method9() {
        String var0 = "";

        ChatLine var2;
        for (Iterator var1 = Statics53.A_ITERABLE_NODE_TABLE_523.iterator(); var1.hasNext(); var0 = var0 + var2.channel + ':' + var2.message + '\n') {
            var2 = (ChatLine) var1.next();
        }

        return var0;
    }

    public static void insertMenuItem(String action, String target, int opcode, int primary, int secondary, int tertiary, boolean var6) {
        if (!menuOpen) {
            if (menuRowCount < 500) {
                menuActions[menuRowCount] = action;
                menuTargets[menuRowCount] = target;
                menuOpcodes[menuRowCount] = opcode;
                menuPrimaryArgs[menuRowCount] = primary;
                menuSecondaryArgs[menuRowCount] = secondary;
                menuTertiaryArgs[menuRowCount] = tertiary;
                menuShiftClickActions[menuRowCount] = var6;
                ++menuRowCount;
            }

        }
    }

    public void method741() {
        if (gameState != 1000) {
            boolean var1 = ResourceRequest.processResources();
            if (!var1) {
                this.method738();
            }

        }
    }

    public NamePair getNamePair() {
        return PlayerEntity.local != null ? PlayerEntity.local.namePair : null;
    }

    public void method733() {
        int var1 = canvasWidth;
        int var2 = canvasHeight;
        if (this.anInt1296 < var1) {
        }

        if (this.anInt1312 < var2) {
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
        if (varcs.persist()) {
            varcs.update();
        }

        if (mouseRecorder != null) {
            mouseRecorder.enabled = false;
        }

        mouseRecorder = null;
        connectionContext.stop();
        Keyboard.destroy();
        Mouse.destroy();
        Keyboard.aMouseWheelProvider_158 = null;
        if (AudioSystem.anAudioSystem1236 != null) {
            AudioSystem.anAudioSystem1236.destroy();
        }

        if (Class76.anAudioSystem599 != null) {
            Class76.anAudioSystem599.destroy();
        }

        Connection.destroy();
        CacheRequestWorker.release();
        if (urlRequestProcessor != null) {
            urlRequestProcessor.release();
            urlRequestProcessor = null;
        }

        BufferedFile.releaseAll();
    }

    protected final void method745() {
        int[] var1 = new int[]{20, 260, 10000};
        int[] var2 = new int[]{1000, 100, 500};
        if (var1 != null && var2 != null) {
            Statics56.anIntArray1637 = var1;
            Statics56.anIntArray1642 = new int[var1.length];
            EntityUID.aByteArrayArrayArray547 = new byte[var1.length][][];

            for (int var5 = 0; var5 < Statics56.anIntArray1637.length; ++var5) {
                EntityUID.aByteArrayArrayArray547[var5] = new byte[var2[var5]][];
            }
        } else {
            Statics56.anIntArray1637 = null;
            Statics56.anIntArray1642 = null;
            EntityUID.aByteArrayArrayArray547 = null;
        }

        HitsplatDefinition.anInt1929 = anInt925 == 0 ? 43594 : currentWorld + 40000;
        Bzip2Entry.anInt1579 = anInt925 == 0 ? 443 : currentWorld + 50000;
        NpcEntity.anInt823 = HitsplatDefinition.anInt1929;
        Enum_Sub9.aShortArray1482 = Statics14.aShortArray1225;
        PlayerAppearance.aShortArrayArray1928 = Statics14.aShortArrayArray1226;
        PlayerAppearance.aShortArray1927 = Statics14.aShortArray1224;
        DefaultAudioSystemProvider.aShortArrayArray145 = Statics14.aShortArrayArray1223;
        urlRequestProcessor = new URLRequestProcessor();
        this.method949();
        this.method938();
        Keyboard.aMouseWheelProvider_158 = this.method943();
        WorldMapTileDecor_Sub2.aResourceCache649 = new ResourceCache(255, BufferedFile.dataFile, BufferedFile.indexFile, 500000);
        preferences = ItemDefinition.method529();
        this.method944();
        String var4 = WorldMapController.aString264;
        Statics1.anApplet323 = this;
        if (var4 != null) {
            Statics1.aString325 = var4;
        }

        if (anInt925 != 0) {
            aBoolean944 = true;
        }

        AssociateComparatorByMyWorld.method603(preferences.resizable);
        relationshipSystem = new RelationshipSystem(PreciseWorldMapAreaChunk.aClientParameter_343);
    }

    public final void method734(boolean var1) {
        Statics26.method1112(rootInterfaceIndex, canvasWidth, canvasHeight, var1);
    }

    public void method740(int var1) {
        Login.aOldConnectionTask_464 = null;
        Statics48.aConnection140 = null;
        anInt950 = 0;
        if (NpcEntity.anInt823 == HitsplatDefinition.anInt1929) {
            NpcEntity.anInt823 = Bzip2Entry.anInt1579;
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

    public final boolean method731() {
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

    public final boolean processIncomingPacket() {
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
            gameStateEvents.updateTime();

            client.connectionContext.thirdLastIncomingPacket = client.connectionContext.secondLastIncomingPacket;
            client.connectionContext.secondLastIncomingPacket = client.connectionContext.lastIncomingPacket;
            client.connectionContext.lastIncomingPacket = client.connectionContext.currentIncomingPacket;

            if (IncomingPacketMeta.anIncomingPacketMeta186 == client.connectionContext.currentIncomingPacket) {
                StockMarketOfferQuantityComparator.method479(RegionUpdateType.SPAWN_PROJECTILE);
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
                    IntegerNode var45 = interfaceConfigs.lookup(var10);
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
                NetWorker.method1092(var6);
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
                    InterfaceComponent.repaint(var47);
                    this.method742(var47);
                    if (var47.type == 0) {
                        GameEngine.method925(interfaces[var7 >> 16], var47, false);
                    }
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta201 == client.connectionContext.currentIncomingPacket) {
                StockMarketOfferQuantityComparator.method479(RegionUpdateType.REMOVE_SCENE_OBJECT);
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
                    EntityUID.aLong548 = GameEngine.currentTime() - incoming.readLong();
                    Pickable.aStockMarketMediator_890 = new StockMarketMediator(incoming);
                } else {
                    Pickable.aStockMarketMediator_890 = null;
                }

                anInt1077 = anInt1075;
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta230 == client.connectionContext.currentIncomingPacket) {
                GameEngine.method1417(incoming.readString());
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
                    InterfaceComponent.repaint(component);
                }

                SubInterface.process();
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
                Clock.anInt889 = incoming.readUByte() * 128;
                StockMarketOfferWorldComparator.anInt347 = incoming.readUShort();
                MouseRecorder.anInt388 = incoming.readUByte();
                Statics53.anInt520 = incoming.readUByte();
                if (Statics53.anInt520 >= 100) {
                    StockMarketOfferWorldComparator.cameraX = Statics15.anInt1235 * 16384 + 64;
                    WorldMapIcon_Sub1.cameraY = Clock.anInt889 * 16384 + 64;
                    Varcs.cameraZ = SceneGraph.getTileHeight(StockMarketOfferWorldComparator.cameraX, WorldMapIcon_Sub1.cameraY, SceneGraph.floorLevel) - StockMarketOfferWorldComparator.anInt347;
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta202 == client.connectionContext.currentIncomingPacket) {
                StockMarketOfferQuantityComparator.method479(RegionUpdateType.A_REGION_UPDATE_TYPE___1205);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta178 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.readInt();
                var5 = incoming.readInt();
                var7 = SerializableString.method437();
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
                SubInterface.process();
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
                if (clanSystem != null) {
                    clanSystem.method1389(incoming);
                }

                RegionUpdateType.method865();
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            SubInterface var13;
            InterfaceComponent var17;
            if (IncomingPacketMeta.anIncomingPacketMeta211 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.method1015();
                var5 = incoming.readInt();
                SubInterface var53 = subInterfaces.lookup(var5);
                var13 = subInterfaces.lookup(var6);
                if (var13 != null) {
                    NamedFont.method1182(var13, var53 == null || var13.id != var53.id);
                }

                if (var53 != null) {
                    var53.unlink();
                    subInterfaces.put(var53, var6);
                }

                var17 = InterfaceComponent.lookup(var5);
                if (var17 != null) {
                    InterfaceComponent.repaint(var17);
                }

                var17 = InterfaceComponent.lookup(var6);
                if (var17 != null) {
                    InterfaceComponent.repaint(var17);
                    GameEngine.method925(interfaces[var17.uid >>> 16], var17, true);
                }

                if (rootInterfaceIndex != -1) {
                    InterfaceComponent.method118(rootInterfaceIndex, 1);
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta210 == client.connectionContext.currentIncomingPacket) {
                relationshipSystem.decodeFriends(incoming, client.connectionContext.incomingPacketSize);
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
                var20 = incoming.readUShort();
                var10 = incoming.readMediumInt();
                PlayerAccountType var12 = (PlayerAccountType) OldConnection.method716(Statics13.method871(), incoming.readUByte());
                var22 = var10 + (var20 << 32);
                boolean var54 = false;

                for (int var25 = 0; var25 < 100; ++var25) {
                    if (aLongArray896[var25] == var22) {
                        var54 = true;
                        break;
                    }
                }

                if (var12.aBoolean1258 && relationshipSystem.isIgnoring(new NamePair(var38, PreciseWorldMapAreaChunk.aClientParameter_343))) {
                    var54 = true;
                }

                if (!var54 && anInt1014 == 0) {
                    aLongArray896[anInt891] = var22;
                    anInt891 = (anInt891 + 1) % 100;
                    String var26 = BaseFont.method1166(OldConnection.method714(RouteStrategy_Sub1.method294(incoming)));
                    if (var12.anInt1218 != -1) {
                        ChatHistory.messageReceived(9, Statics26.method1111(var12.anInt1218) + var38, var26, World.method1353(var18));
                    } else {
                        ChatHistory.messageReceived(9, var38, var26, World.method1353(var18));
                    }
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_RANDOM == client.connectionContext.currentIncomingPacket) {
                incoming.caret += 28;
                if (incoming.matchCrcs()) {
                    ResourceCache.method1489(incoming, incoming.caret - 28);
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_GRAND_EXCHANGE == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.readUByte();
                if (incoming.readUByte() == 0) {
                    stockMarketOffers[var6] = new StockMarketOffer();
                    incoming.caret += 18;
                } else {
                    --incoming.caret;
                    stockMarketOffers[var6] = new StockMarketOffer(incoming);
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
                    InterfaceComponent.repaint(var14);
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

                    var52 = ItemDefinition.get(var7);
                    var47.modelType = 4;
                    var47.modelId = var7;
                    var47.xRotation = var52.spritePitch;
                    var47.zRotation = var52.spriteRoll;
                    var47.modelZoom = var52.spriteScale * 100 / var5;
                } else {
                    var47.itemId = var7;
                    var47.itemStackSize = var5;
                    var52 = ItemDefinition.get(var7);
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

                }
                InterfaceComponent.repaint(var47);

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
                    InterfaceComponent.repaint(var14);
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta235 == client.connectionContext.currentIncomingPacket) {
                StockMarketOfferQuantityComparator.method479(RegionUpdateType.SPAWN_GRAPHICS_OBJECT);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta180 == client.connectionContext.currentIncomingPacket) {
                var38 = incoming.readString();
                var18 = incoming.readUShort();
                var20 = incoming.readMediumInt();
                PlayerAccountType var27 = (PlayerAccountType) OldConnection.method716(Statics13.method871(), incoming.readUByte());
                long var28 = (var18 << 32) + var20;
                boolean var30 = false;

                for (int var31 = 0; var31 < 100; ++var31) {
                    if (aLongArray896[var31] == var28) {
                        var30 = true;
                        break;
                    }
                }

                if (relationshipSystem.isIgnoring(new NamePair(var38, PreciseWorldMapAreaChunk.aClientParameter_343))) {
                    var30 = true;
                }

                if (!var30 && anInt1014 == 0) {
                    aLongArray896[anInt891] = var28;
                    anInt891 = (anInt891 + 1) % 100;
                    String var32 = BaseFont.method1166(OldConnection.method714(RouteStrategy_Sub1.method294(incoming)));
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

                InterfaceComponent.repaint(var57);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta184 == client.connectionContext.currentIncomingPacket) {
                NpcEntity.update(true, incoming);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_VARP2 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.method1019();
                var5 = incoming.readLEUShortA();
                Vars.baseValues[var5] = var6;
                if (Vars.values[var5] != var6) {
                    Vars.values[var5] = var6;
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
                setGameState(45);
                connection.stop();
                SerializableString.setWorld(var41);
                client.connectionContext.currentIncomingPacket = null;
                return false;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta200 == client.connectionContext.currentIncomingPacket) {
                relationshipSystem.method210();
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
                StockMarketOfferQuantityComparator.method479(RegionUpdateType.ADD_PICKABLE);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta197 == client.connectionContext.currentIncomingPacket) {
                if (client.connectionContext.incomingPacketSize == 0) {
                    clanSystem = null;
                } else {
                    if (clanSystem == null) {
                        clanSystem = new ClanSystem(PreciseWorldMapAreaChunk.aClientParameter_343, instance);
                    }

                    clanSystem.decode(incoming);
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
                Inventory.delete(var6);
                inventories[++anInt1078 - 1 & 31] = var6 & 32767;
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta236 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.method1055();
                rootInterfaceIndex = var6;
                this.method734(false);
                InterfaceComponent.method146(var6);
                Statics9.method796(rootInterfaceIndex);

                for (var5 = 0; var5 < 100; ++var5) {
                    renderedComponents[var5] = true;
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
                    if (relationshipSystem.isIgnoring(new NamePair(var50, PreciseWorldMapAreaChunk.aClientParameter_343))) {
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
                PlayerAccountType.onSceneXTEAKeyChange(false, client.connectionContext.inbuffer);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.OPEN_BROWSER_URL == client.connectionContext.currentIncomingPacket) {
                byte[] var40 = new byte[client.connectionContext.incomingPacketSize];
                incoming.method1397(var40, 0, var40.length);
                Buffer var61 = new Buffer(var40);
                var50 = var61.readString();
                CacheRequestWorker.method1006(var50, true, false);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.SET_COMPONENT_HIDDEN == client.connectionContext.currentIncomingPacket) {
                var42 = incoming.readUByte() == 1;
                var5 = incoming.method1015();
                var14 = InterfaceComponent.lookup(var5);
                if (var42 != var14.explicitlyHidden) {
                    var14.explicitlyHidden = var42;
                    InterfaceComponent.repaint(var14);
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
                    InterfaceComponent.repaint(var14);
                }

                SubInterface.process();
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
                    InterfaceComponent.repaint(var14);
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
                    InterfaceComponent.repaint(var59);
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
                    InterfaceComponent.repaint(var17);
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
                SubInterface.process();
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
                ScriptEvent.fire(var48);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta219 == client.connectionContext.currentIncomingPacket) {
                cameraLocked = true;
                GameEngine.anInt1288 = incoming.readUByte() * 16384;
                SecureRandomService.anInt458 = incoming.readUByte() * 128;
                Statics52.anInt499 = incoming.readUShort();
                Statics54.anInt627 = incoming.readUByte();
                ScriptEvent.anInt1806 = incoming.readUByte();
                if (ScriptEvent.anInt1806 >= 100) {
                    var6 = GameEngine.anInt1288 * 128 + 64;
                    var5 = SecureRandomService.anInt458 * 16384 + 64;
                    var7 = SceneGraph.getTileHeight(var6, var5, SceneGraph.floorLevel) - Statics52.anInt499;
                    var8 = var6 - StockMarketOfferWorldComparator.cameraX;
                    var9 = var7 - Varcs.cameraZ;
                    var15 = var5 - WorldMapIcon_Sub1.cameraY;
                    var16 = (int) Math.sqrt(var15 * var15 + var8 * var8);
                    IgnoreListContext.cameraPitch = (int) (Math.atan2(var9, var16) * 325.949D) & 2047;
                    RectangularWorldMapAreaChunk.cameraYaw = (int) (Math.atan2(var8, var15) * -325.949D) & 2047;
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
                StockMarketOfferQuantityComparator.method479(RegionUpdateType.A_REGION_UPDATE_TYPE___1206);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta240 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.readInt();
                var5 = incoming.readUByte();
                var7 = incoming.readUShort();
                var13 = subInterfaces.lookup(var6);
                if (var13 != null) {
                    NamedFont.method1182(var13, var7 != var13.id);
                }

                SubInterface.create(var6, var7, var5);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta215 == client.connectionContext.currentIncomingPacket) {
                StockMarketOfferQuantityComparator.method479(RegionUpdateType.A_REGION_UPDATE_TYPE___1204);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta227 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.readInt();
                SubInterface var58 = subInterfaces.lookup(var6);
                if (var58 != null) {
                    NamedFont.method1182(var58, true);
                }

                if (pleaseWaitComponent != null) {
                    InterfaceComponent.repaint(pleaseWaitComponent);
                    pleaseWaitComponent = null;
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_VARP == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.method1055();
                byte var43 = incoming.readByte();
                Vars.baseValues[var6] = var43;
                if (Vars.values[var6] != var43) {
                    Vars.values[var6] = var43;
                }

                OldConnection.method712(var6);
                anIntArray1076[++anInt1064 - 1 & 31] = var6;
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta182 == client.connectionContext.currentIncomingPacket) {
                SubInterface.process();
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
                InterfaceComponent.repaint(var57);
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
                            Pickable.refresh(var6, var5);
                        }
                    }
                }

                for (PendingSpawn spawn = pendingSpawns.head(); spawn != null; spawn = pendingSpawns.next()) {
                    if (spawn.sceneX >= SceneGraph.regionChunkX && spawn.sceneX < SceneGraph.regionChunkX + 8 && spawn.sceneY >= SceneGraph.regionChunkY && spawn.sceneY < SceneGraph.regionChunkY + 8 && spawn.floorLevel == SceneGraph.floorLevel) {
                        spawn.hitpoints = 0;
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
                for (var6 = 0; var6 < Vars.values.length; ++var6) {
                    if (Vars.baseValues[var6] != Vars.values[var6]) {
                        Vars.values[var6] = Vars.baseValues[var6];
                        OldConnection.method712(var6);
                        anIntArray1076[++anInt1064 - 1 & 31] = var6;
                    }
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta225 == client.connectionContext.currentIncomingPacket) {
                relationshipSystem.ignoreListContext.method338(incoming, client.connectionContext.incomingPacketSize);
                Statics11.method843();
                anInt1065 = anInt1075;
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_NPCS == client.connectionContext.currentIncomingPacket) {
                NpcEntity.update(false, incoming);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_INSTANCE_REGION == client.connectionContext.currentIncomingPacket) {
                PlayerAccountType.onSceneXTEAKeyChange(true, client.connectionContext.inbuffer);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_COMPONENT_TEXT == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.method1015();
                var33 = new StringBuilder(incoming.readString());
                var14 = InterfaceComponent.lookup(var6);
                if (!var33.toString().equals(var14.text)) {
                    var14.text = var33.toString();
                    InterfaceComponent.repaint(var14);
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta194 == client.connectionContext.currentIncomingPacket) {
                var6 = incoming.readUShort();
                if (var6 == 65535) {
                    var6 = -1;
                }

                AudioOverrideEffect.method795(var6);
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
                StockMarketOfferQuantityComparator.method479(RegionUpdateType.A_REGION_UPDATE_TYPE___1201);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta246 == client.connectionContext.currentIncomingPacket) {
                for (var6 = 0; var6 < VarDefinition.anInt568; ++var6) {
                    VarDefinition var56 = WorldMapTileDecor.method360(var6);
                    if (var56 != null) {
                        Vars.baseValues[var6] = 0;
                        Vars.values[var6] = 0;
                    }
                }

                SubInterface.process();
                anInt1064 += 32;
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta188 == client.connectionContext.currentIncomingPacket) {
                StockMarketOfferQuantityComparator.method479(RegionUpdateType.REMOVE_PICKABLE);
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
                    InterfaceComponent.method146(rootInterfaceIndex);
                    Statics9.method796(rootInterfaceIndex);

                    for (var8 = 0; var8 < 100; ++var8) {
                        renderedComponents[var8] = true;
                    }
                }

                SubInterface var34;
                while (var7-- > 0) {
                    var8 = incoming.readInt();
                    var9 = incoming.readUShort();
                    var15 = incoming.readUByte();
                    var34 = subInterfaces.lookup(var8);
                    if (var34 != null && var9 != var34.id) {
                        NamedFont.method1182(var34, true);
                        var34 = null;
                    }

                    if (var34 == null) {
                        var34 = SubInterface.create(var8, var9, var15);
                    }
                    var34.aBoolean790 = true;
                }

                for (var13 = subInterfaces.head(); var13 != null; var13 = subInterfaces.next()) {
                    if (var13.aBoolean790) {
                        var13.aBoolean790 = false;
                    } else {
                        NamedFont.method1182(var13, true);
                    }
                }

                interfaceConfigs = new NodeTable<>(512);

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
                var33 = new StringBuilder(BaseFont.method1166(OldConnection.method714(RouteStrategy_Sub1.method294(incoming))));
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
                method884(var6, var5, var7);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta249 == client.connectionContext.currentIncomingPacket) {
                PlayerEntity.update(incoming, client.connectionContext.incomingPacketSize);
                Archive.method485();
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta254 == client.connectionContext.currentIncomingPacket) {
                StockMarketOfferQuantityComparator.method479(RegionUpdateType.SET_PICKABLE_STACK_SIZE);
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta218 == client.connectionContext.currentIncomingPacket) {
                if (rootInterfaceIndex != -1) {
                    InterfaceComponent.method118(rootInterfaceIndex, 0);
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
                    StockMarketOfferQuantityComparator.method479(var55);
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
                publicChatPrivacyMode = ChatModePrivacyType.valueOf(incoming.readUByte());
                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta177 == client.connectionContext.currentIncomingPacket) {
                var42 = incoming.readBoolean();
                if (var42) {
                    if (class69 == null) {
                        class69 = new Class69();
                    }
                } else {
                    class69 = null;
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
                        InterfaceComponent.repaint(var14);
                    }
                }

                client.connectionContext.currentIncomingPacket = null;
                return true;
            }

            sendError("" + (client.connectionContext.currentIncomingPacket != null ? client.connectionContext.currentIncomingPacket.opcode : -1) + "," + (client.connectionContext.secondLastIncomingPacket != null ? client.connectionContext.secondLastIncomingPacket.opcode : -1) + "," + (client.connectionContext.thirdLastIncomingPacket != null ? client.connectionContext.thirdLastIncomingPacket.opcode : -1) + "," + client.connectionContext.incomingPacketSize, null);
            DynamicObject.method1506();
        } catch (IOException var36) {
            dropConnection();
        } catch (Exception var37) {
            var33 = new StringBuilder("" + (client.connectionContext.currentIncomingPacket != null ? client.connectionContext.currentIncomingPacket.opcode : -1) + "," + (client.connectionContext.secondLastIncomingPacket != null ? client.connectionContext.secondLastIncomingPacket.opcode : -1) + "," + (client.connectionContext.thirdLastIncomingPacket != null ? client.connectionContext.thirdLastIncomingPacket.opcode : -1) + "," + client.connectionContext.incomingPacketSize + "," + (PlayerEntity.local.pathXQueue[0] + baseX) + "," + (PlayerEntity.local.pathYQueue[0] + baseY) + ",");

            for (var7 = 0; var7 < client.connectionContext.incomingPacketSize && var7 < 50; ++var7) {
                var33.append(incoming.payload[var7]).append(",");
            }

            sendError(var33.toString(), var37);
            DynamicObject.method1506();
        }

        return true;
    }

    void method738() {
        if (NetWorker.anInt1492 >= 4) {
            this.method926("js5crc");
            gameState = 1000;
        } else {
            if (NetWorker.anInt1488 >= 4) {
                if (gameState <= 5) {
                    this.method926("js5io");
                    gameState = 1000;
                    return;
                }

                anInt949 = 3000;
                NetWorker.anInt1488 = 3;
            }

            if (--anInt949 + 1 <= 0) {
                try {
                    if (anInt950 == 0) {
                        Login.aOldConnectionTask_464 = aOldConnectionTaskProcessor_1321.method698(LoginStep.currentDomain, NpcEntity.anInt823);
                        ++anInt950;
                    }

                    if (anInt950 == 1) {
                        if (Login.aOldConnectionTask_464.anInt885 == 2) {
                            this.method740(-1);
                            return;
                        }

                        if (Login.aOldConnectionTask_464.anInt885 == 1) {
                            ++anInt950;
                        }
                    }

                    if (anInt950 == 2) {
                        if (clientParameter1) {
                            Socket var1 = (Socket) Login.aOldConnectionTask_464.anObject886;
                            Statics48.aConnection140 = new AsyncConnection(var1, 40000, 5000);
                        } else {
                            Statics48.aConnection140 = new OldConnection((Socket) Login.aOldConnectionTask_464.anObject886, aOldConnectionTaskProcessor_1321, 5000);
                        }

                        Buffer var5 = new Buffer(5);
                        var5.writeByte(15);
                        var5.writeInt(184);
                        Statics48.aConnection140.writeBytes(var5.payload, 0, 5);
                        ++anInt950;
                        Enum_Sub8.aLong1478 = GameEngine.currentTime();
                    }

                    if (anInt950 == 3) {
                        if (Statics48.aConnection140.readable() > 0 || !clientParameter1 && gameState <= 5) {
                            int var3 = Statics48.aConnection140.readByte();
                            if (var3 != 0) {
                                this.method740(var3);
                                return;
                            }

                            ++anInt950;
                        } else if (GameEngine.currentTime() - Enum_Sub8.aLong1478 > 30000L) {
                            this.method740(-2);
                            return;
                        }
                    }

                    if (anInt950 == 4) {
                        MenuItemNode.method420(Statics48.aConnection140, gameState > 20);
                        Login.aOldConnectionTask_464 = null;
                        Statics48.aConnection140 = null;
                        anInt950 = 0;
                        anInt959 = 0;
                    }
                } catch (IOException var4) {
                    this.method740(-3);
                }

            }
        }
    }

    public final void openMenu(int var1, int var2) {
        AssociateComparatorByName.openMenu(var1, var2);
        sceneGraph.method1451(SceneGraph.floorLevel, var1, var2, false);
        menuOpen = true;
    }

    protected final void method736() {
        ++engineCycle;
        this.method741();

        while (true) {
            CacheRequest var2;
            synchronized (CacheRequestWorker.requests) {
                var2 = CacheRequestWorker.read.popFirst();
            }

            if (var2 == null) {
                int var4;
                try {
                    if (Statics57.anInt1157 == 1) {
                        var4 = Statics50.aClass5_Sub6_Sub3_326.method770();
                        if (var4 > 0 && Statics50.aClass5_Sub6_Sub3_326.method684()) {
                            var4 -= AudioOverrideEffect.anInt1130;
                            if (var4 < 0) {
                                var4 = 0;
                            }

                            Statics50.aClass5_Sub6_Sub3_326.method703(var4);
                        } else {
                            Statics50.aClass5_Sub6_Sub3_326.method756();
                            Statics50.aClass5_Sub6_Sub3_326.method592();
                            if (Statics57.aReferenceTable1155 != null) {
                                Statics57.anInt1157 = 2;
                            } else {
                                Statics57.anInt1157 = 0;
                            }

                            Statics57.anAudioTrack1158 = null;
                            FriendLoginUpdate.aClass97_668 = null;
                        }
                    }
                } catch (Exception var9) {
                    var9.printStackTrace();
                    Statics50.aClass5_Sub6_Sub3_326.method756();
                    Statics57.anInt1157 = 0;
                    Statics57.anAudioTrack1158 = null;
                    FriendLoginUpdate.aClass97_668 = null;
                    Statics57.aReferenceTable1155 = null;
                }

                AudioSystem.process();
                synchronized (Keyboard.instance) {
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

                Vertex.processMouse();
                if (Keyboard.aMouseWheelProvider_158 != null) {
                    var4 = Keyboard.aMouseWheelProvider_158.method222();
                    anInt1086 = var4;
                }

                if (gameState == 0) {
                    Login.method798();
                    WorldMapDecor.method383();
                } else if (gameState == 5) {
                    LoginPacketMeta.processLoginScreen();
                    Login.method798();
                    WorldMapDecor.method383();
                } else if (gameState != 10 && gameState != 11) {
                    if (gameState == 20) {
                        LoginPacketMeta.processLoginScreen();
                        this.method748();
                    } else if (gameState == 25) {
                        Keyboard.method101();
                    }
                } else {
                    LoginPacketMeta.processLoginScreen();
                }

                if (gameState == 30) {
                    this.method752();
                } else if (gameState == 40 || gameState == 45) {
                    this.method748();
                }

                return;
            }

            var2.archive.method486(var2.cache, (int) var2.key, var2.data, false);
        }
    }

    public final void method729() {
        int var1;
        if (rootInterfaceIndex != -1) {
            var1 = rootInterfaceIndex;
            if (InterfaceComponent.load(var1)) {
                InterfaceComponent.method513(interfaces[var1], -1);
            }
        }

        for (var1 = 0; var1 < anInt1085; ++var1) {
            if (renderedComponents[var1]) {
                aBooleanArray1087[var1] = true;
            }

            aBooleanArray1083[var1] = renderedComponents[var1];
            renderedComponents[var1] = false;
        }

        anInt1084 = engineCycle;
        anInt1039 = -1;
        anInt1038 = -1;
        DefaultAudioSystemProvider.anInterfaceComponent144 = null;
        if (rootInterfaceIndex != -1) {
            anInt1085 = 0;
            InterfaceComponent.renderInterface(rootInterfaceIndex, 0, 0, canvasWidth, canvasHeight, 0, 0, -1);
        }

        JagGraphics.resetDrawingArea();
        if (aBoolean1028) {
            if (crosshairState == 1) {
                URLRequest.hintIcons[hintArrowState * 400 / 100].method809(crosshairX - 8, crosshairY - 8);
            }

            if (crosshairState == 2) {
                URLRequest.hintIcons[hintArrowState * 400 / 100 + 4].method809(crosshairX - 8, crosshairY - 8);
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
                        var4 = "Use" + " " + selectedItemName + " " + "->";
                    } else if (spellSelected && menuRowCount < 2) {
                        var4 = selectedComponentAction + " " + selectedSpellName + " " + "->";
                    } else {
                        var4 = WorldMapRenderRules.method131(var3);
                    }

                    if (menuRowCount > 2) {
                        var4 = var4 + World.getColorTags(16777215) + " " + '/' + " " + (menuRowCount - 2) + " more options";
                    }

                    Statics7.aFont863.method1142(var4, var1 + 4, var2 + 15, 16777215, 0, engineCycle / 1000);
                }
            }
        } else {
            var1 = URLRequestProcessor.anInt797;
            var2 = Statics1.anInt321;
            var3 = RelationshipSystem.anInt319;
            int var5 = WorldMapDecor.anInt543;
            int var6 = 6116423;
            JagGraphics.fillRect(var1, var2, var3, var5, var6);
            JagGraphics.fillRect(var1 + 1, var2 + 1, var3 - 2, 16, 0);
            JagGraphics.method1372(var1 + 1, var2 + 18, var3 - 2, var5 - 19, 0);
            Statics7.aFont863.drawString("Choose Option", var1 + 3, var2 + 14, var6, -1);
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

                Statics7.aFont863.drawString(WorldMapRenderRules.method131(var9), var1 + 3, var10, var11, 0);
            }

            var9 = URLRequestProcessor.anInt797;
            var10 = Statics1.anInt321;
            var11 = RelationshipSystem.anInt319;
            int var12 = WorldMapDecor.anInt543;

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

        SerializableProcessor.method456(SceneGraph.floorLevel, PlayerEntity.local.fineX, PlayerEntity.local.fineY, anInt972);
        anInt972 = 0;
    }

    protected final void draw(boolean drawing) {
        boolean var2;
        label168:
        {
            try {
                if (Statics57.anInt1157 == 2) {
                    if (Statics57.anAudioTrack1158 == null) {
                        Statics57.anAudioTrack1158 = AudioTrack.load(Statics57.aReferenceTable1155, Statics8.anInt1122, Statics50.anInt327);
                        if (Statics57.anAudioTrack1158 == null) {
                            var2 = false;
                            break label168;
                        }
                    }

                    if (FriendLoginUpdate.aClass97_668 == null) {
                        FriendLoginUpdate.aClass97_668 = new Class97(Statics57.aReferenceTable1159, SecureRandomCallable.aReferenceTable382);
                    }

                    if (Statics50.aClass5_Sub6_Sub3_326.method776(Statics57.anAudioTrack1158, Statics57.aReferenceTable1160, FriendLoginUpdate.aClass97_668, 22050)) {
                        Statics50.aClass5_Sub6_Sub3_326.method775();
                        Statics50.aClass5_Sub6_Sub3_326.method703(Pickable.anInt379);
                        Statics50.aClass5_Sub6_Sub3_326.method766(Statics57.anAudioTrack1158, WorldMapChunkType.aBoolean620);
                        Statics57.anInt1157 = 0;
                        Statics57.anAudioTrack1158 = null;
                        FriendLoginUpdate.aClass97_668 = null;
                        Statics57.aReferenceTable1155 = null;
                        var2 = true;
                        break label168;
                    }
                }
            } catch (Exception var6) {
                var6.printStackTrace();
                Statics50.aClass5_Sub6_Sub3_326.method756();
                Statics57.anInt1157 = 0;
                Statics57.anAudioTrack1158 = null;
                FriendLoginUpdate.aClass97_668 = null;
                Statics57.aReferenceTable1155 = null;
            }

            var2 = false;
        }

        if (var2 && aBoolean904 && AudioSystem.anAudioSystem1236 != null) {
            AudioSystem.anAudioSystem1236.method1333();
        }

        if ((gameState == 10 || gameState == 20 || gameState == 30) && 0L != aLong1081 && GameEngine.currentTime() > aLong1081) {
            AssociateComparatorByMyWorld.method603(isResizable());
        }

        int var5;
        if (drawing) {
            for (var5 = 0; var5 < 100; ++var5) {
                renderedComponents[var5] = true;
            }
        }

        if (gameState == 0) {
            this.method931(Login.anInt473, Login.aString475, drawing);
        } else if (gameState == 5) {
            Login.draw(Statics7.aFont863, StockMarketOfferWorldComparator.aFont345, BootSprites.font_p12full);
        } else if (gameState != 10 && gameState != 11) {
            if (gameState == 20) {
                Login.draw(Statics7.aFont863, StockMarketOfferWorldComparator.aFont345, BootSprites.font_p12full);
            } else if (gameState == 25) {
                if (anInt975 == 1) {
                    if (anInt966 > anInt971) {
                        anInt971 = anInt966;
                    }

                    var5 = (anInt971 * 50 - anInt966 * 50) / anInt971;
                    WorldMapSprite.method242("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
                } else if (anInt975 == 2) {
                    if (anInt968 > anInt974) {
                        anInt974 = anInt968;
                    }

                    var5 = (anInt974 * 50 - anInt968 * 50) / anInt974 + 50;
                    WorldMapSprite.method242("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
                } else {
                    WorldMapSprite.method242("Loading - please wait.", false);
                }
            } else if (gameState == 30) {
                this.method729();
            } else if (gameState == 40) {
                WorldMapSprite.method242("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
            } else if (gameState == 45) {
                WorldMapSprite.method242("Please wait...", false);
            }
        } else {
            Login.draw(Statics7.aFont863, StockMarketOfferWorldComparator.aFont345, BootSprites.font_p12full);
        }

        if (gameState == 30 && redrawMode == 0 && !drawing && !resizableMode) {
            for (var5 = 0; var5 < anInt1085; ++var5) {
                if (aBooleanArray1087[var5]) {
                    WorldMapAreaChunk_Sub2.aGraphicsProvider_284.method20(interfacePositionsX[var5], interfacePositionsY[var5], interfaceWidths[var5], interfaceHeights[var5]);
                    aBooleanArray1087[var5] = false;
                }
            }
        } else if (gameState > 0) {
            WorldMapAreaChunk_Sub2.aGraphicsProvider_284.method22(0, 0);

            for (var5 = 0; var5 < anInt1085; ++var5) {
                aBooleanArray1087[var5] = false;
            }
        }

    }

    protected final void method737() {
        aLong1081 = GameEngine.currentTime() + 500L;
        this.method733();
        if (rootInterfaceIndex != -1) {
            this.method734(true);
        }

    }

    public void method742(InterfaceComponent var1) {
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

        InterfaceComponent.method728(var1, var3, var4, false);
        InterfaceComponent.method185(var1, var3, var4);
    }

    public final void method752() {
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
                        if (gameStateEvents.aBoolean1525) {
                            var4 = OutgoingPacket.prepare(OutgoingPacketMeta.GAME_STATE_EVENT_REQUEST, connectionContext.encryptor);
                            var4.buffer.writeByte(0);
                            var5 = var4.buffer.caret;
                            gameStateEvents.writeTo(var4.buffer);
                            var4.buffer.method1050(var4.buffer.caret - var5);
                            connectionContext.writeLater(var4);
                            gameStateEvents.method1118();
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
                        synchronized (mouseRecorder.lock) {
                            if (!lockMouseRecorder) {
                                mouseRecorder.caret = 0;
                            } else if (Mouse.clickMeta != 0 || mouseRecorder.caret >= 40) {
                                packet = null;
                                var3 = 0;
                                var6 = 0;
                                var7 = 0;
                                var8 = 0;

                                for (var9 = 0; var9 < mouseRecorder.caret && (packet == null || packet.buffer.caret - var3 < 246); ++var9) {
                                    var6 = var9;
                                    var10 = mouseRecorder.yHistory[var9];
                                    if (var10 < -1) {
                                        var10 = -1;
                                    } else if (var10 > 65534) {
                                        var10 = 65534;
                                    }

                                    var11 = mouseRecorder.xHistory[var9];
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
                                            var14 = (int) ((mouseRecorder.timeHistory[var9] - lastMouseRecordTime) / 20L);
                                            var7 = (int) ((long) var7 + (mouseRecorder.timeHistory[var9] - lastMouseRecordTime) % 20L);
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
                                        lastMouseRecordTime = mouseRecorder.timeHistory[var9];
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

                                if (var6 >= mouseRecorder.caret) {
                                    mouseRecorder.caret = 0;
                                } else {
                                    MouseRecorder var42 = mouseRecorder;
                                    var42.caret -= var6;
                                    System.arraycopy(mouseRecorder.xHistory, var6, mouseRecorder.xHistory, 0, mouseRecorder.caret);
                                    System.arraycopy(mouseRecorder.yHistory, var6, mouseRecorder.yHistory, 0, mouseRecorder.caret);
                                    System.arraycopy(mouseRecorder.timeHistory, var6, mouseRecorder.timeHistory, 0, mouseRecorder.caret);
                                }
                            }
                        }

                        OutgoingPacket var18;
                        if (Mouse.clickMeta == 1 || !WorldMapIcon_Sub1.aBoolean492 && Mouse.clickMeta == 4 || Mouse.clickMeta == 2) {
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
                            long var19 = GameEngine.currentTime();

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
                            var4 = OutgoingPacket.prepare(OutgoingPacketMeta.MINIMAP_DATA, connectionContext.encryptor);
                            var4.buffer.writeLEShortA(anInt985);
                            var4.buffer.writeLEShort(mapRotation);
                            connectionContext.writeLater(var4);
                        }

                        if (OldConnectionTaskProcessor.aBoolean853 && !aBoolean937) {
                            aBoolean937 = true;
                            var4 = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta97, connectionContext.encryptor);
                            var4.buffer.writeByte(1);
                            connectionContext.writeLater(var4);
                        }

                        if (!OldConnectionTaskProcessor.aBoolean853 && aBoolean937) {
                            aBoolean937 = false;
                            var4 = OutgoingPacket.prepare(OutgoingPacketMeta.anOutgoingPacketMeta97, connectionContext.encryptor);
                            var4.buffer.writeByte(0);
                            connectionContext.writeLater(var4);
                        }

                        if (worldMap != null) {
                            worldMap.method1272();
                        }

                        if (StockMarketOfferLifetimeComparator.aBoolean584) {
                            if (clanSystem != null) {
                                clanSystem.sort();
                            }

                            GPI.method488();
                            StockMarketOfferLifetimeComparator.aBoolean584 = false;
                        }

                        Statics44.updateMinimapFloorLevel();
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
                            hintArrowState = hintArrowState + 20;
                            if (hintArrowState >= 400) {
                                crosshairState = 0;
                            }
                        }

                        if (StockMarketOfferWorldComparator.anInterfaceComponent351 != null) {
                            ++anInt1018;
                            if (anInt1018 >= 15) {
                                InterfaceComponent.repaint(StockMarketOfferWorldComparator.anInterfaceComponent351);
                                StockMarketOfferWorldComparator.anInterfaceComponent351 = null;
                            }
                        }

                        InterfaceComponent var34 = OldConnection.anInterfaceComponent873;
                        InterfaceComponent var31 = Statics24.anInterfaceComponent1417;
                        OldConnection.anInterfaceComponent873 = null;
                        Statics24.anInterfaceComponent1417 = null;
                        draggedSpecialComponent = null;
                        processingComponentDrag = false;
                        processingComponentDragTopLevel = false;
                        anInt1092 = 0;

                        while (DynamicObject.method1114() && anInt1092 < 128) {
                            if (rights >= 2 && Keyboard.heldKeys[82] && SecureRandomService.anInt457 == 66) {
                                String var39 = method9();
                                instance.method941(var39);
                            } else if (anInt988 != 1 || Keyboard.aChar151 <= 0) {
                                anIntArray1096[anInt1092] = SecureRandomService.anInt457;
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
                                Statics35.method1171(PlayerEntity.local.pathXQueue[0] + baseX, PlayerEntity.local.pathYQueue[0] + baseY, var6, false);
                            }

                            anInt1086 = 0;
                        }

                        if (rootInterfaceIndex != -1) {
                            WorldMapTileDecor.processComponentRendering(rootInterfaceIndex, 0, 0, canvasWidth, canvasHeight, 0, 0);
                        }

                        ++anInt1075;

                        while (true) {
                            InterfaceComponent var25;
                            InterfaceComponent var38;
                            ScriptEvent var40;
                            do {
                                var40 = aNodeDeque1088.popFirst();
                                if (var40 == null) {
                                    while (true) {
                                        do {
                                            var40 = aNodeDeque1080.popFirst();
                                            if (var40 == null) {
                                                while (true) {
                                                    do {
                                                        var40 = aNodeDeque1082.popFirst();
                                                        if (var40 == null) {
                                                            this.method751();
                                                            if (worldMap != null) {
                                                                worldMap.method1261(SceneGraph.floorLevel, baseX + (PlayerEntity.local.fineX >> 7), baseY + (PlayerEntity.local.fineY >> 7), false);
                                                                worldMap.method1225();
                                                            }

                                                            if (draggedComponent != null) {
                                                                this.method732();
                                                            }

                                                            if (AnimationFrameGroup.anInterfaceComponent800 != null) {
                                                                InterfaceComponent.repaint(AnimationFrameGroup.anInterfaceComponent800);
                                                                ++anInt1027;
                                                                if (Mouse.pressMeta == 0) {
                                                                    if (aBoolean1024) {
                                                                        if (AnimationFrameGroup.anInterfaceComponent800 == DefaultAudioSystemProvider.anInterfaceComponent144 && anInt1019 != anInt1023) {
                                                                            InterfaceComponent var41 = AnimationFrameGroup.anInterfaceComponent800;
                                                                            byte var35 = 0;
                                                                            if (anInt1054 == 1 && var41.contentType == 206) {
                                                                                var35 = 1;
                                                                            }

                                                                            if (var41.itemIds[anInt1019] <= 0) {
                                                                                var35 = 0;
                                                                            }

                                                                            if (WorldMapAreaChunk_Sub3.method367(InterfaceComponent.getConfig(var41))) {
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
                                                                            var18.buffer.writeIMEInt(AnimationFrameGroup.anInterfaceComponent800.uid);
                                                                            var18.buffer.writeShort(anInt1019);
                                                                            var18.buffer.writeByte(var35);
                                                                            var18.buffer.writeLEShort(anInt1023);
                                                                            connectionContext.writeLater(var18);
                                                                        }
                                                                    } else if (this.method731()) {
                                                                        this.openMenu(anInt1016, anInt1022);
                                                                    } else if (menuRowCount > 0) {
                                                                        SerializableProcessor.method459(anInt1016, anInt1022);
                                                                    }

                                                                    anInt1018 = 10;
                                                                    Mouse.clickMeta = 0;
                                                                    AnimationFrameGroup.anInterfaceComponent800 = null;
                                                                } else if (anInt1027 >= 5 && (Mouse.x > anInt1016 + 5 || Mouse.x < anInt1016 - 5 || Mouse.y > anInt1022 + 5 || Mouse.y < anInt1022 - 5)) {
                                                                    aBoolean1024 = true;
                                                                }
                                                            }

                                                            if (SceneGraph.isMovementPending()) {
                                                                var6 = SceneGraph.selectedRegionTileX;
                                                                var7 = SceneGraph.selectedRegionTileY;
                                                                var18 = OutgoingPacket.prepare(OutgoingPacketMeta.PROCESS_MOVEMENT, connectionContext.encryptor);
                                                                var18.buffer.writeByte(5);
                                                                var18.buffer.writeLEShortA(baseX + var6);
                                                                var18.buffer.writeLEShort(baseY + var7);
                                                                var18.buffer.writeNegatedByte(Keyboard.heldKeys[82] ? (Keyboard.heldKeys[81] ? 2 : 1) : 0);
                                                                connectionContext.writeLater(var18);
                                                                SceneGraph.unsetPendingMovement();
                                                                crosshairX = Mouse.clickX;
                                                                crosshairY = Mouse.clickY;
                                                                crosshairState = 1;
                                                                hintArrowState = 0;
                                                                destinationX = var6;
                                                                destinationY = var7;
                                                            }

                                                            if (var34 != OldConnection.anInterfaceComponent873) {
                                                                if (var34 != null) {
                                                                    InterfaceComponent.repaint(var34);
                                                                }

                                                                if (OldConnection.anInterfaceComponent873 != null) {
                                                                    InterfaceComponent.repaint(OldConnection.anInterfaceComponent873);
                                                                }
                                                            }

                                                            if (var31 != Statics24.anInterfaceComponent1417 && anInt1036 == anInt1041) {
                                                                if (var31 != null) {
                                                                    InterfaceComponent.repaint(var31);
                                                                }

                                                                if (Statics24.anInterfaceComponent1417 != null) {
                                                                    InterfaceComponent.repaint(Statics24.anInterfaceComponent1417);
                                                                }
                                                            }

                                                            if (Statics24.anInterfaceComponent1417 != null) {
                                                                if (anInt1041 < anInt1036) {
                                                                    ++anInt1041;
                                                                    if (anInt1041 == anInt1036) {
                                                                        InterfaceComponent.repaint(Statics24.anInterfaceComponent1417);
                                                                    }
                                                                }
                                                            } else if (anInt1041 > 0) {
                                                                --anInt1041;
                                                            }

                                                            if (anInt988 == 0) {
                                                                var6 = PlayerEntity.local.fineX;
                                                                var7 = PlayerEntity.local.fineY;
                                                                if (ObjectSound.anInt371 - var6 < -500 || ObjectSound.anInt371 - var6 > 500 || Statics52.anInt498 - var7 < -500 || Statics52.anInt498 - var7 > 500) {
                                                                    ObjectSound.anInt371 = var6;
                                                                    Statics52.anInt498 = var7;
                                                                }

                                                                if (var6 != ObjectSound.anInt371) {
                                                                    ObjectSound.anInt371 += (var6 - ObjectSound.anInt371) / 16;
                                                                }

                                                                if (var7 != Statics52.anInt498) {
                                                                    Statics52.anInt498 += (var7 - Statics52.anInt498) / 16;
                                                                }

                                                                var8 = ObjectSound.anInt371 >> 7;
                                                                var9 = Statics52.anInt498 >> 7;
                                                                var10 = SceneGraph.getTileHeight(ObjectSound.anInt371, Statics52.anInt498, SceneGraph.floorLevel);
                                                                var11 = 0;
                                                                if (var8 > 3 && var9 > 3 && var8 < 100 && var9 < 100) {
                                                                    for (var12 = var8 - 4; var12 <= var8 + 4; ++var12) {
                                                                        for (var13 = var9 - 4; var13 <= var9 + 4; ++var13) {
                                                                            var14 = SceneGraph.floorLevel;
                                                                            if (var14 < 3 && (Statics45.sceneRenderRules[1][var12][var13] & 2) == 2) {
                                                                                ++var14;
                                                                            }

                                                                            int var26 = var10 - Statics45.tileHeights[var14][var12][var13];
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
                                                                SerializableInteger.method407();
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
                                                                        var6 = anInt986 - RectangularWorldMapAreaChunk.cameraYaw & 2047;
                                                                        var10 = JagGraphics3D.SIN_TABLE[var6];
                                                                        var11 = JagGraphics3D.COS_TABLE[var6];
                                                                        ObjectSound.anInt371 += var10 * var9 / 65536;
                                                                        Statics52.anInt498 += var9 * var11 / 65536;
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

                                                            if (Mouse.pressMeta == 4 && WorldMapIcon_Sub1.aBoolean492) {
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
                                                                SceneGraph.method517();
                                                            }

                                                            for (var6 = 0; var6 < 5; ++var6) {
                                                                int var10002 = anIntArray916[var6]++;
                                                            }

                                                            varcs.method425();
                                                            var6 = WorldMapLabelSize.getAndIncrementMouseIdleTime();
                                                            var7 = Keyboard.getIdleTime();
                                                            if (var6 > 15000 && var7 > 15000) {
                                                                logoutTimer = 250;
                                                                Mouse.idleTime = 14500;
                                                                var18 = OutgoingPacket.prepare(OutgoingPacketMeta.IDLE_LOGOUT, connectionContext.encryptor);
                                                                connectionContext.writeLater(var18);
                                                            }

                                                            relationshipSystem.processFriendLoginUpdates();
                                                            ++connectionContext.idleWriteTicks;
                                                            if (connectionContext.idleWriteTicks > 50) {
                                                                var18 = OutgoingPacket.prepare(OutgoingPacketMeta.IDLE_WRITE, connectionContext.encryptor);
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

                                                    ScriptEvent.fire(var40);
                                                }
                                            }

                                            var25 = var40.source;
                                            if (var25.componentIndex < 0) {
                                                break;
                                            }

                                            var38 = InterfaceComponent.lookup(var25.parentUid);
                                        }
                                        while (var38 == null || var38.components == null || var25.componentIndex >= var38.components.length || var25 != var38.components[var25.componentIndex]);

                                        ScriptEvent.fire(var40);
                                    }
                                }

                                var25 = var40.source;
                                if (var25.componentIndex < 0) {
                                    break;
                                }

                                var38 = InterfaceComponent.lookup(var25.parentUid);
                            }
                            while (var38 == null || var38.components == null || var25.componentIndex >= var38.components.length || var25 != var38.components[var25.componentIndex]);

                            ScriptEvent.fire(var40);
                        }
                    }

                    packet = OutgoingPacket.prepare(OutgoingPacketMeta.PROCESS_REFLECTION, connectionContext.encryptor);
                    packet.buffer.writeByte(0);
                    var3 = packet.buffer.caret;
                    ClassStructure.process(packet.buffer);
                    packet.buffer.method1050(packet.buffer.caret - var3);
                    connectionContext.writeLater(packet);
                }
            }
        }
    }

    public final void method748() {
        Connection var1 = connectionContext.unwrap();
        PacketBuffer var2 = connectionContext.inbuffer;

        try {
            if (anInt956 == 0) {
                if (SecureRandomService.aSecureRandom864 == null && (secureRandomService.isDone() || anInt957 > 250)) {
                    SecureRandomService.aSecureRandom864 = secureRandomService.get();
                    secureRandomService.kill();
                    secureRandomService = null;
                }

                if (SecureRandomService.aSecureRandom864 != null) {
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
                    LoginPacketMeta.aOldConnectionTask_1992 = aOldConnectionTaskProcessor_1321.method698(LoginStep.currentDomain, NpcEntity.anInt823);
                }

                if (LoginPacketMeta.aOldConnectionTask_1992.anInt885 == 2) {
                    throw new IOException();
                }

                if (LoginPacketMeta.aOldConnectionTask_1992.anInt885 == 1) {
                    if (clientParameter1) {
                        Socket var3 = (Socket) LoginPacketMeta.aOldConnectionTask_1992.anObject886;
                        var1 = new AsyncConnection(var3, 40000, 5000);
                    } else {
                        var1 = new OldConnection((Socket) LoginPacketMeta.aOldConnectionTask_1992.anObject886, aOldConnectionTaskProcessor_1321, 5000);
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
                if (AudioSystem.anAudioSystem1236 != null) {
                    AudioSystem.anAudioSystem1236.method1332();
                }

                if (Class76.anAudioSystem599 != null) {
                    Class76.anAudioSystem599.method1332();
                }

                var5 = !clientParameter1 || var1.available(1);

                if (var5) {
                    var6 = var1.readByte();
                    if (AudioSystem.anAudioSystem1236 != null) {
                        AudioSystem.anAudioSystem1236.method1332();
                    }

                    if (Class76.anAudioSystem599 != null) {
                        Class76.anAudioSystem599.method1332();
                    }

                    if (var6 != 0) {
                        Login.processResponseCode(var6);
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
                    Statics45.aLong403 = var2.readLong();
                    anInt956 = 5;
                }
            }

            int var8;
            if (anInt956 == 5) {
                connectionContext.inbuffer.caret = 0;
                connectionContext.drop();
                PacketBuffer var26 = new PacketBuffer(500);
                int[] var22 = new int[]{SecureRandomService.aSecureRandom864.nextInt(), SecureRandomService.aSecureRandom864.nextInt(), SecureRandomService.aSecureRandom864.nextInt(), SecureRandomService.aSecureRandom864.nextInt()};
                var26.caret = 0;
                var26.writeByte(1);
                var26.writeInt(var22[0]);
                var26.writeInt(var22[1]);
                var26.writeInt(var22[2]);
                var26.writeInt(var22[3]);
                var26.writeLong(Statics45.aLong403);
                if (gameState == 40) {
                    var26.writeInt(DirectByteBufferProvider.anIntArray1136[0]);
                    var26.writeInt(DirectByteBufferProvider.anIntArray1136[1]);
                    var26.writeInt(DirectByteBufferProvider.anIntArray1136[2]);
                    var26.writeInt(DirectByteBufferProvider.anIntArray1136[3]);
                } else {
                    var26.writeByte(loginStep.getOrdinal());
                    switch (loginStep.anInt619) {
                        case 0:
                        case 1:
                            var26.writeMediumInt(RegionUpdateType.anInt1199);
                            ++var26.caret;
                            break;
                        case 2:
                            var26.caret += 4;
                            break;
                        case 3:
                            var26.writeInt((Integer) preferences.properties.get(Statics33.method1141(Login.username)));
                    }

                    var26.writeByte(LoginHeaderType.anEnum_Sub10_1767.getOrdinal());
                    var26.writeCString(Login.password);
                }

                var26.writeRSA(Statics51.aBigInteger496, Statics51.aBigInteger497);
                DirectByteBufferProvider.anIntArray1136 = var22;
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
                packet.buffer.writeCString(Login.username);
                packet.buffer.writeByte((resizableMode ? 1 : 0) << 1 | (lowMemory ? 1 : 0));
                packet.buffer.writeShort(canvasWidth);
                packet.buffer.writeShort(canvasHeight);
                PacketBuffer var10 = packet.buffer;
                int var12;
                if (random != null) {
                    var10.writeBytes(random, 0, random.length);
                } else {
                    byte[] var11 = new byte[24];

                    try {
                        BufferedFile.random.seek(0L);
                        BufferedFile.random.read(var11);

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

                packet.buffer.writeCString(Statics57.aString1162);
                packet.buffer.writeInt(WorldMapArea.anInt130);
                Buffer var15 = new Buffer(operatingSystemNode.getPayloadSize());
                operatingSystemNode.method1098(var15);
                packet.buffer.writeBytes(var15.payload, 0, var15.payload.length);
                packet.buffer.writeByte(anInt923);
                packet.buffer.writeInt(0);
                packet.buffer.writeInt(SerializableInteger.aArchive583.anInt1240);
                packet.buffer.writeInt(WorldMapLabelSize.aArchive526.anInt1240);
                packet.buffer.writeInt(Face.aArchive773.anInt1240);
                packet.buffer.writeInt(Login.aArchive1876.anInt1240);
                packet.buffer.writeInt(StockMarketOfferLifetimeComparator.aArchive586.anInt1240);
                packet.buffer.writeInt(SerializableProcessor.aArchive635.anInt1240);
                packet.buffer.writeInt(Statics15.aArchive1234.anInt1240);
                packet.buffer.writeInt(ClientLocale.aArchive1188.anInt1240);
                packet.buffer.writeInt(StockMarketOfferLifetimeComparator.sprites.anInt1240);
                packet.buffer.writeInt(AttackOptionPriority.aArchive329.anInt1240);
                packet.buffer.writeInt(aArchive948.anInt1240);
                packet.buffer.writeInt(ClanMember.aArchive867.anInt1240);
                packet.buffer.writeInt(StockMarketOfferWorldComparator.aArchive348.anInt1240);
                packet.buffer.writeInt(Tile.aArchive1152.anInt1240);
                packet.buffer.writeInt(WorldMapTileDecor_Sub1.aArchive166.anInt1240);
                packet.buffer.writeInt(RuneScript.aArchive1644.anInt1240);
                packet.buffer.writeInt(0);
                packet.buffer.writeInt(aArchive953.anInt1240);
                packet.buffer.writeInt(VarcInteger.aArchive1506.anInt1240);
                packet.buffer.writeInt(WorldMapLabel.aArchive341.anInt1240);
                packet.buffer.writeInt(WorldMapScriptEvent.aArchive304.anInt1240);
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
                        Login.processResponseCode(var29);
                        return;
                    }

                    anInt956 = 14;
                }
            }

            if (anInt956 == 7 && var1.readable() > 0) {
                anInt1232 = var1.readByte();
                anInt956 = 8;
            }

            if (anInt956 == 8 && var1.readable() >= anInt1232) {
                var1.readBytes(var2.payload, 0, anInt1232);
                var2.caret = 0;
                anInt956 = 6;
            }

            if (anInt956 == 9 && var1.readable() > 0) {
                anInt952 = (var1.readByte() + 3) * 60;
                anInt956 = 10;
            }

            if (anInt956 == 10) {
                anInt957 = 0;
                PlayerAccountType.setLoginMessages("You have only just left another world.", "Your profile will be transferred in:", anInt952 / 60 + " seconds.");
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
                        var16 = Statics33.method1141(Login.username);
                        if (preferences.properties.size() >= 10 && !preferences.properties.containsKey(var16)) {
                            Iterator var17 = preferences.properties.entrySet().iterator();
                            var17.next();
                            var17.remove();
                        }

                        preferences.properties.put(var16, var6);
                    }

                    if (aBoolean958) {
                        preferences.aString362 = Login.username;
                    } else {
                        preferences.aString362 = null;
                    }

                    ClientLocale.method854();
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
                        JSObjectUtil.call(instance, "zap");
                    } catch (Throwable ignored) {
                    }

                    anInt956 = 13;
                }

                if (anInt956 == 13) {
                    if (var1.readable() >= connectionContext.incomingPacketSize) {
                        var2.caret = 0;
                        var1.readBytes(var2.payload, 0, connectionContext.incomingPacketSize);
                        gameStateEvents.method1119();
                        timeOfPreviousClick = 1L;
                        mouseRecorder.caret = 0;
                        OldConnectionTaskProcessor.aBoolean853 = true;
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
                        ChatHistory.clear();
                        itemSelectionState = 0;
                        spellSelected = false;
                        audioEffectCount = 0;
                        mapRotation = 0;
                        anInt988 = 0;
                        class69 = null;
                        mapState = 0;
                        minimapFloorLevel = -1;
                        destinationX = 0;
                        destinationY = 0;
                        playerAttackOptionPriority = AttackOptionPriority.anActionPrioritySetting330;
                        npcAttackOptionPriority = AttackOptionPriority.anActionPrioritySetting330;
                        npcCount = 0;
                        ClientPreferences.method250();

                        for (var29 = 0; var29 < 2048; ++var29) {
                            players[var29] = null;
                        }

                        for (var29 = 0; var29 < 32768; ++var29) {
                            npcs[var29] = null;
                        }

                        anInt1030 = -1;
                        projectiles.clear();
                        effectObjects.clear();

                        for (var29 = 0; var29 < 4; ++var29) {
                            for (var6 = 0; var6 < 104; ++var6) {
                                for (var16 = 0; var16 < 104; ++var16) {
                                    pickableNodeDeques[var29][var6][var16] = null;
                                }
                            }
                        }

                        pendingSpawns = new NodeDeque();
                        relationshipSystem.clear();

                        for (var29 = 0; var29 < VarDefinition.anInt568; ++var29) {
                            VarDefinition var24 = WorldMapTileDecor.method360(var29);
                            if (var24 != null) {
                                Vars.baseValues[var29] = 0;
                                Vars.values[var29] = 0;
                            }
                        }

                        varcs.method430();
                        anInt1053 = -1;
                        if (rootInterfaceIndex != -1) {
                            InterfaceComponent.method830(rootInterfaceIndex);
                        }

                        for (SubInterface var28 = subInterfaces.head(); var28 != null; var28 = subInterfaces.next()) {
                            NamedFont.method1182(var28, true);
                        }

                        rootInterfaceIndex = -1;
                        subInterfaces = new NodeTable(8);
                        pleaseWaitComponent = null;
                        ScriptEvent.method1305();
                        renderedAppearance.update(null, new int[]{0, 0, 0, 0, 0}, false, -1);

                        for (var29 = 0; var29 < 8; ++var29) {
                            playerActions[var29] = null;
                            playerActionPriorities[var29] = false;
                        }

                        NamedFont.method1181();
                        aBoolean939 = true;

                        for (var29 = 0; var29 < 100; ++var29) {
                            renderedComponents[var29] = true;
                        }

                        Statics19.method919();
                        clanSystem = null;

                        for (var29 = 0; var29 < 8; ++var29) {
                            stockMarketOffers[var29] = new StockMarketOffer();
                        }

                        Pickable.aStockMarketMediator_890 = null;
                        PlayerEntity.update(var2);
                        IncomingPacketMeta.anInt206 = -1;
                        PlayerAccountType.onSceneXTEAKeyChange(false, var2);
                        connectionContext.currentIncomingPacket = null;
                    }

                } else {
                    if (anInt956 == 14 && var1.readable() >= 2) {
                        var2.caret = 0;
                        var1.readBytes(var2.payload, 0, 2);
                        var2.caret = 0;
                        WorldMapRenderRules.anInt168 = var2.readUShort();
                        anInt956 = 15;
                    }

                    if (anInt956 == 15 && var1.readable() >= WorldMapRenderRules.anInt168) {
                        var2.caret = 0;
                        var1.readBytes(var2.payload, 0, WorldMapRenderRules.anInt168);
                        var2.caret = 0;
                        String var27 = var2.readString();
                        String var23 = var2.readString();
                        String var32 = var2.readString();
                        PlayerAccountType.setLoginMessages(var27, var23, var32);
                        setGameState(10);
                    }

                    if (anInt956 != 16) {
                        ++anInt957;
                        if (anInt957 > 2000) {
                            if (anInt954 < 1) {
                                if (HitsplatDefinition.anInt1929 == NpcEntity.anInt823) {
                                    NpcEntity.anInt823 = Bzip2Entry.anInt1579;
                                } else {
                                    NpcEntity.anInt823 = HitsplatDefinition.anInt1929;
                                }

                                ++anInt954;
                                anInt956 = 0;
                            } else {
                                Login.processResponseCode(-3);
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
                            gameStateEvents.method1116();
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

                            NamedFont.method1181();
                            setGameState(30);

                            for (var6 = 0; var6 < 100; ++var6) {
                                renderedComponents[var6] = true;
                            }

                            Statics19.method919();
                            PlayerEntity.update(var2);
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
                    NpcEntity.anInt823 = Bzip2Entry.anInt1579;
                } else {
                    NpcEntity.anInt823 = HitsplatDefinition.anInt1929;
                }

                ++anInt954;
                anInt956 = 0;
            } else {
                Login.processResponseCode(-2);
            }
        }
    }

    public final void method751() {
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

        if (AnimationFrameGroup.anInterfaceComponent800 == null) {
            if (draggedComponent == null) {
                int var16 = Mouse.clickMeta;
                int var7;
                int var8;
                if (menuOpen) {
                    int var9;
                    int var10;
                    int var17;
                    if (var16 != 1 && (WorldMapIcon_Sub1.aBoolean492 || var16 != 4)) {
                        var2 = Mouse.x;
                        var7 = Mouse.y;
                        if (var2 < URLRequestProcessor.anInt797 - 10 || var2 > RelationshipSystem.anInt319 + URLRequestProcessor.anInt797 + 10 || var7 < Statics1.anInt321 - 10 || var7 > Statics1.anInt321 + WorldMapDecor.anInt543 + 10) {
                            menuOpen = false;
                            var8 = URLRequestProcessor.anInt797;
                            var5 = Statics1.anInt321;
                            var17 = RelationshipSystem.anInt319;
                            var9 = WorldMapDecor.anInt543;

                            for (var10 = 0; var10 < anInt1085; ++var10) {
                                if (interfaceWidths[var10] + interfacePositionsX[var10] > var8 && interfacePositionsX[var10] < var17 + var8 && interfaceHeights[var10] + interfacePositionsY[var10] > var5 && interfacePositionsY[var10] < var5 + var9) {
                                    renderedComponents[var10] = true;
                                }
                            }
                        }
                    }

                    if (var16 == 1 || !WorldMapIcon_Sub1.aBoolean492 && var16 == 4) {
                        var2 = URLRequestProcessor.anInt797;
                        var7 = Statics1.anInt321;
                        var8 = RelationshipSystem.anInt319;
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
                        var10 = URLRequestProcessor.anInt797;
                        var11 = Statics1.anInt321;
                        int var12 = RelationshipSystem.anInt319;
                        int var13 = WorldMapDecor.anInt543;

                        for (int var14 = 0; var14 < anInt1085; ++var14) {
                            if (interfacePositionsX[var14] + interfaceWidths[var14] > var10 && interfacePositionsX[var14] < var10 + var12 && interfaceHeights[var14] + interfacePositionsY[var14] > var11 && interfacePositionsY[var14] < var13 + var11) {
                                renderedComponents[var14] = true;
                            }
                        }
                    }
                } else {
                    var2 = AssociateComparatorByRank.method679();
                    if ((var16 == 1 || !WorldMapIcon_Sub1.aBoolean492 && var16 == 4) && var2 >= 0) {
                        var7 = menuOpcodes[var2];
                        if (var7 == 39 || var7 == 40 || var7 == 41 || var7 == 42 || var7 == 43 || var7 == 33 || var7 == 34 || var7 == 35 || var7 == 36 || var7 == 37 || var7 == 38 || var7 == 1005) {
                            var8 = menuSecondaryArgs[var2];
                            var5 = menuTertiaryArgs[var2];
                            InterfaceComponent var15 = InterfaceComponent.lookup(var5);
                            if (Statics3.method650(InterfaceComponent.getConfig(var15)) || WorldMapAreaChunk_Sub3.method367(InterfaceComponent.getConfig(var15))) {
                                if (AnimationFrameGroup.anInterfaceComponent800 != null && !aBoolean1024 && menuRowCount > 0 && !this.method731()) {
                                    SerializableProcessor.method459(anInt1016, anInt1022);
                                }

                                aBoolean1024 = false;
                                anInt1027 = 0;
                                if (AnimationFrameGroup.anInterfaceComponent800 != null) {
                                    InterfaceComponent.repaint(AnimationFrameGroup.anInterfaceComponent800);
                                }

                                AnimationFrameGroup.anInterfaceComponent800 = InterfaceComponent.lookup(var5);
                                anInt1023 = var8;
                                anInt1016 = Mouse.clickX;
                                anInt1022 = Mouse.clickY;
                                if (var2 >= 0) {
                                    DefinitionProperty.method516(var2);
                                }

                                InterfaceComponent.repaint(AnimationFrameGroup.anInterfaceComponent800);
                                return;
                            }
                        }
                    }

                    if ((var16 == 1 || !WorldMapIcon_Sub1.aBoolean492 && var16 == 4) && this.method731()) {
                        var16 = 2;
                    }

                    if ((var16 == 1 || !WorldMapIcon_Sub1.aBoolean492 && var16 == 4) && menuRowCount > 0) {
                        Statics3.processActionAt(var2);
                    }

                    if (var16 == 2 && menuRowCount > 0) {
                        this.openMenu(Mouse.clickX, Mouse.clickY);
                    }
                }

            }
        }
    }

    public final void method732() {
        InterfaceComponent.repaint(draggedComponent);
        ++Statics2.anInt654;
        if (processingComponentDrag && processingComponentDragTopLevel) {
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
                ScriptEvent.fire(var8);
            }

            if (Mouse.pressMeta == 0) {
                if (aBoolean1062) {
                    if (draggedComponent.anObjectArray1387 != null) {
                        var8 = new ScriptEvent();
                        var8.source = draggedComponent;
                        var8.mouseX = var6;
                        var8.mouseY = var7;
                        var8.target = draggedSpecialComponent;
                        var8.args = draggedComponent.anObjectArray1387;
                        ScriptEvent.fire(var8);
                    }

                    if (draggedSpecialComponent != null && InterfaceComponent.getTopLevelComponent(draggedComponent) != null) {
                        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.DRAGGED_COMPONENT, connectionContext.encryptor);
                        packet.buffer.writeLEShortA(draggedSpecialComponent.componentIndex);
                        packet.buffer.writeLEShortA(draggedSpecialComponent.itemId);
                        packet.buffer.writeLEShort(draggedComponent.componentIndex);
                        packet.buffer.writeIMEInt(draggedSpecialComponent.uid);
                        packet.buffer.writeShortA(draggedComponent.itemId);
                        packet.buffer.writeInt(draggedComponent.uid);
                        connectionContext.writeLater(packet);
                    }
                } else if (this.method731()) {
                    this.openMenu(anInt1068 + currentComponentDragX, currentComponentDragY + anInt1073);
                } else if (menuRowCount > 0) {
                    SerializableProcessor.method459(anInt1068 + currentComponentDragX, anInt1073 + currentComponentDragY);
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
                                clientParameter1 = Integer.parseInt(var2) != 0;
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
                                WorldMapLabelSize.aClientLocale_525 = ClientLocale.valueOf(Integer.parseInt(var2));
                                break;
                            case 7:
                                Vertex.aDevelopmentBuild_725 = DevelopmentBuild.valueOf(Integer.parseInt(var2));
                                break;
                            case 8:
                                if (var2.equalsIgnoreCase("true")) {
                                }
                                break;
                            case 9:
                                Statics57.aString1162 = var2;
                                break;
                            case 10:
                                GameType[] var3 = new GameType[]{GameType.GAME3, GameType.RUNESCAPE, GameType.STELLARDAWN, GameType.anEnum_Sub5_1211, GameType.GAME4, GameType.GAME5};
                                Statics55.anGameType_629 = (GameType) OldConnection.method716(var3, Integer.parseInt(var2));
                                if (Statics55.anGameType_629 == GameType.anEnum_Sub5_1211) {
                                    PreciseWorldMapAreaChunk.aClientParameter_343 = ClientParameter.A_CLIENT_PARAMETER___1801;
                                } else {
                                    PreciseWorldMapAreaChunk.aClientParameter_343 = ClientParameter.A_CLIENT_PARAMETER___1799;
                                }
                                break;
                            case 12:
                                currentWorld = Integer.parseInt(var2);
                                break;
                            case 14:
                                WorldMapArea.anInt130 = Integer.parseInt(var2);
                                break;
                            case 15:
                                anInt925 = Integer.parseInt(var2);
                                break;
                            case 17:
                                WorldMapChunkType.aString623 = var2;
                        }
                    }
                }

                StockMarketOfferPriceComparator.method330();
                LoginStep.currentDomain = this.getCodeBase().getHost();
                String var4 = Vertex.aDevelopmentBuild_725.name;
                byte var5 = 0;

                try {
                    BufferedFile.indexCount = 21;
                    AsyncConnection.anInt1210 = var5;

                    try {
                        DefaultOperatingSystemProvider.aString407 = System.getProperty("os.name");
                    } catch (Exception var19) {
                        DefaultOperatingSystemProvider.aString407 = "Unknown";
                    }

                    DefaultOperatingSystemProvider.aString845 = DefaultOperatingSystemProvider.aString407.toLowerCase();

                    try {
                        Statics5.userhome = System.getProperty("user.home");
                        if (Statics5.userhome != null) {
                            Statics5.userhome = Statics5.userhome + "/";
                        }
                    } catch (Exception ignored) {
                    }

                    try {
                        if (DefaultOperatingSystemProvider.aString845.startsWith("win")) {
                            if (Statics5.userhome == null) {
                                Statics5.userhome = System.getenv("USERPROFILE");
                            }
                        } else if (Statics5.userhome == null) {
                            Statics5.userhome = System.getenv("HOME");
                        }

                        if (Statics5.userhome != null) {
                            Statics5.userhome = Statics5.userhome + "/";
                        }
                    } catch (Exception ignored) {
                    }

                    if (Statics5.userhome == null) {
                        Statics5.userhome = "~/";
                    }

                    Class114.cacheDirectories = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", Statics5.userhome, "/tmp/", ""};
                    aStringArray1533 = new String[]{".jagex_cache_" + AsyncConnection.anInt1210, ".file_store_" + AsyncConnection.anInt1210};

                    int var9;
                    File var10;
                    label176:
                    for (int var6 = 0; var6 < 4; ++var6) {
                        StockMarketOfferWorldComparator.aFile346 = Statics5.method60("oldschool", var4, var6);
                        if (!StockMarketOfferWorldComparator.aFile346.exists()) {
                            StockMarketOfferWorldComparator.aFile346.mkdirs();
                        }

                        File[] var7 = StockMarketOfferWorldComparator.aFile346.listFiles();
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

                    Statics4.aFile831 = StockMarketOfferWorldComparator.aFile346;
                    if (!Statics4.aFile831.exists()) {
                        throw new RuntimeException("");
                    }

                    Statics4.aBoolean830 = true;

                    try {
                        File var24 = new File(Statics5.userhome, "random.dat");
                        if (var24.exists()) {
                            BufferedFile.random = new BufferedFile(new DiskFile(var24, "rw", 25L), 24, 0);
                        } else {
                            label153:
                            for (int var14 = 0; var14 < aStringArray1533.length; ++var14) {
                                for (var9 = 0; var9 < Class114.cacheDirectories.length; ++var9) {
                                    var10 = new File(Class114.cacheDirectories[var9] + aStringArray1533[var14] + File.separatorChar + "random.dat");
                                    if (var10.exists()) {
                                        BufferedFile.random = new BufferedFile(new DiskFile(var10, "rw", 25L), 24, 0);
                                        break label153;
                                    }
                                }
                            }
                        }

                        if (BufferedFile.random == null) {
                            RandomAccessFile var25 = new RandomAccessFile(var24, "rw");
                            var9 = var25.read();
                            var25.seek(0L);
                            var25.write(var9);
                            var25.seek(0L);
                            var25.close();
                            BufferedFile.random = new BufferedFile(new DiskFile(var24, "rw", 25L), 24, 0);
                        }
                    } catch (IOException ignored) {
                    }

                    BufferedFile.dataFile = new BufferedFile(new DiskFile(BufferedFile.openRw("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
                    BufferedFile.indexFile = new BufferedFile(new DiskFile(BufferedFile.openRw("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
                    BufferedFile.indexes = new BufferedFile[BufferedFile.indexCount];

                    for (int i = 0; i < BufferedFile.indexCount; ++i) {
                        BufferedFile.indexes[i] = new BufferedFile(new DiskFile(BufferedFile.openRw("main_file_cache.idx" + i), "rw", 1048576L), 6000, 0);
                    }
                } catch (Exception var21) {
                    sendError(null, var21);
                }

                instance = this;
                clientParameter4 = anInt923;
                this.method935();
            }
        } catch (RuntimeException var22) {
            throw Statics52.method348(var22, "client.init(" + ')');
        }
    }
}
