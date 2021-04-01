package jag.game;

import jag.*;
import jag.audi.*;
import jag.audi.vorbis.RawAudioOverride;
import jag.commons.JSObjectUtil;
import jag.commons.Jagexception;
import jag.commons.collection.IntegerNode;
import jag.commons.collection.LinkedList;
import jag.commons.collection.NodeDeque;
import jag.commons.collection.NodeTable;
import jag.commons.crypt.Base37;
import jag.commons.crypt.Djb2;
import jag.commons.input.Keyboard;
import jag.commons.input.Mouse;
import jag.commons.input.MouseWheel;
import jag.commons.time.Clock;
import jag.game.menu.ComponentSelection;
import jag.game.menu.ContextMenu;
import jag.game.menu.ContextMenuBuilder;
import jag.game.option.AttackOptionPriority;
import jag.game.option.ClientPreferences;
import jag.game.relationship.*;
import jag.game.scene.CollisionMap;
import jag.game.scene.HintArrow;
import jag.game.scene.SceneGraph;
import jag.game.scene.entity.*;
import jag.game.stockmarket.*;
import jag.game.type.*;
import jag.graphics.*;
import jag.js5.*;
import jag.opcode.*;
import jag.opcode.login.LoginHeaderType;
import jag.opcode.login.LoginPacketMeta;
import jag.opcode.login.LoginStep;
import jag.script.ClientScript;
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

public final class client extends GameShell implements LocalPlayerNameProvider {

    public static final boolean[] renderedComponents;
    public static final boolean[] aBooleanArray1083;
    public static final boolean[] aBooleanArray1087;
    public static final boolean[] playerActionPriorities;
    public static final boolean[] aBooleanArray919;

    public static final boolean mobile;
    public static final boolean lockMouseRecorder;

    public static final int[][][] dynamicSceneData;

    public static final int[][] pathingEntityRenderPositions;

    public static final int[] OBJECT_TYPE_TO_STUB_TYPE;
    public static final int[] PLAYER_ACTION_OPCODES;
    public static final int[] npcIndices2;
    public static final int[] npcIndices;
    public static final int[] processedNpcIndices;
    public static final int[] interfacePositionsX;
    public static final int[] interfaceWidths;
    public static final int[] currentLevels;
    public static final int[] interfaceHeights;
    public static final int[] levels;
    public static final int[] interfacePositionsY;
    public static final int[] experiences;
    public static final int[] pathingEntityOrientations;
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
    public static final int[] overheadMessageXPositions;
    public static final int[] overheadMessageYPositions;
    public static final int[] overheadMessageYShifts;
    public static final int[] overheadMessageXShifts;
    public static final int[] overheadMessageColors;
    public static final int[] overheadMessageEffects;
    public static final int[] overheadMessageCyclesRemaining;
    public static final int[] anIntArray1097;
    public static final int[] anIntArray1094;
    public static final int[] anIntArray1079;

    public static final int redrawMode;
    public static final int anInt1036;
    public static final int anInt980;
    public static final int anInt987;
    public static final int anInt983;
    public static final int anInt990;
    public static final int overheadMessageCapacity;

    public static final long[] aLongArray896;

    public static final String[] playerActions;
    public static final String[] overheadMessages;

    public static final NodeDeque<Pickable>[][][] pickables;

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

    public static final Map<Integer, ChatHistory> chatHistory;
    public static final ArrayList<LoadedArchive> archives;
    public static final PlayerModel renderedAppearance;
    public static final NetWriter netWriter;
    public static final OperatingSystemProvider operatingSystemProvider;
    public static final DefaultRouteStrategy routeStrategy;
    public static final GameStateEvent gameStateEvents;
    public static final StockMarketOfferWorldComparator stockMarketComparator;

    public static byte[] random;

    public static boolean membersWorld;
    public static boolean dynamicScene;
    public static boolean lowMemory;
    public static boolean processingComponentDrag;
    public static boolean pendingDisconnect;
    public static boolean processingComponentDragTopLevel;
    public static boolean usingBufferedConnection;
    public static boolean resizableMode;
    public static boolean aBoolean904;
    public static boolean loadingPleaseWait;
    public static boolean previousFocusState;
    public static boolean displayFps;
    public static boolean draggingComponent;
    public static boolean displayLoadingMessages;
    public static boolean aBoolean1043;
    public static boolean aBoolean1062;
    public static boolean cameraLocked;
    public static boolean aBoolean1042;
    public static boolean aBoolean1044;
    public static boolean rememberUsername;
    public static boolean aBoolean1037;
    public static boolean oculusOrbOnPlayer;
    public static boolean useDefaultScrollbar;
    public static boolean displaySelf;
    public static boolean emitCameraMovementPackets;
    public static boolean aBoolean1056;

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
    public static int rebootTimer;
    public static int rootInterfaceIndex;
    public static int gameState;
    public static int playerIndex;
    public static int viewportRenderX;
    public static int anInt1034;
    public static int npcUpdateCount;
    public static int renderedComponentCount;
    public static int anInt1084;
    public static int logoutTimer;
    public static int viewportRenderY;
    public static int js5Cycles;
    public static int js5State;
    public static int currentWorldMask;
    public static int loginProcess;
    public static int loginStage;
    public static int gameType;
    public static int anInt1039;
    public static int relationshipSystemState;
    public static int anInt923;
    public static int anInt1038;
    public static int npcCount;
    public static int destinationX;
    public static int loginStageCycles;
    public static int anInt1075;
    public static int anInt1065;
    public static int js5ErrorCount;
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
    public static int anInt1069;
    public static int anInt972;
    public static int anInt1059;
    public static int viewportWidth;
    public static int loadingDrawState;
    public static int viewportScale;
    public static int loadingIndicator1;
    public static int componentDragCycles;
    public static int loadingIndicator2;
    public static int loadingIndicator3;
    public static int viewportHeight;
    public static int loadingIndicator4;
    public static int draggingComponentX;
    public static int draggingComponentY;
    public static int anInt1018;
    public static int oculusOrbState;
    public static int anInt1053;
    public static int mapState;
    public static int anInt1015;
    public static int draggingComponentSourceIndex;
    public static int draggingComponentIndex;
    public static int bootState;
    public static int anInt1074;
    public static int anInt1077;
    public static int audioEffectCount;
    public static int energy;
    public static int anInt898;
    public static int weight;
    public static int serverTransferCycles;
    public static int cameraY;
    public static int anInt1002;
    public static int anInt897;
    public static int anInt1092;
    public static int anInt1061;
    public static int anInt1078;
    public static int minimapFloorLevel;
    public static int anInt930;
    public static int mouseWheelPtr;
    public static int anInt931;
    public static int anInt1071;
    public static int viewportRenderCount;
    public static int cameraMovementPacketIndicator;
    public static int anInt926;
    public static int scrollbarWidth;
    public static int anInt1041;
    public static int anInt1064;
    public static int anInt1014;
    public static int anInt891;
    public static int anInt900;
    public static int cameraX;
    public static int anInt901;
    public static int publicChatMode;
    public static int cameraFollowHeight;
    public static int displayPlayerNames;
    public static int tradeChatMode;
    public static int anInt1045;
    public static int oculusOrbSpeed;
    public static int anInt1054;
    public static int oculusOrbSlowSpeed;
    public static int archiveEntryCount;
    public static int anInt895;
    public static int cameraXDiff;
    public static int cameraYDiff;
    public static int mouseCameraDragX;
    public static int mouseCameraDragY;
    public static int anInt977;
    public static int anInt986;
    public static int anInt997;
    public static int anInt1008;
    public static int anInt909;
    public static int overheadMessageCount;
    public static int anInt908;
    public static int anInt1063;

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

    public static String[] aStringArray1533;

    public static String aString1091;

    public static InterfaceComponent[][] interfaces;

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

    public static URLRequestProcessor urlRequestProcessor;

    public static SecureRandomService secureRandomService;

    public static HashMap<NamedFont, BaseFont> fonts;

    public static client instance;

    public static DevelopmentBuild devbuild;

    public static GraphicsProvider graphicsProvider;

    static {
        lockMouseRecorder = true;
        currentWorld = 1;
        currentWorldMask = 0;
        gameType = 0;
        membersWorld = false;
        lowMemory = false;
        anInt923 = -1;
        mobile = false;
        gameState = 0;
        loadingPleaseWait = true;
        engineCycle = 0;
        timeOfPreviousClick = 1L;
        lastMouseRecordX = -1;
        lastMouseRecordY = -1;
        lastMouseRecordTime = -1L;
        previousFocusState = true;
        displayFps = false;
        rebootTimer = 0;
        HintArrow.insetX = 0;
        HintArrow.insetY = 0;
        playerAttackOptionPriority = AttackOptionPriority.HIDDEN;
        npcAttackOptionPriority = AttackOptionPriority.HIDDEN;
        bootState = 0;
        js5State = 0;
        js5Cycles = 0;
        js5ErrorCount = 0;
        loginStage = 0;
        loginStageCycles = 0;
        loginProcess = 0; //TODO name
        serverTransferCycles = 0;
        loginStep = LoginStep.anEnum_Sub3_826;
        rememberUsername = false;
        secureRandomService = new SecureRandomService();
        random = null;
        npcs = new NpcEntity[32768];
        npcCount = 0;
        npcIndices = new int[32768];
        npcUpdateCount = 0;
        processedNpcIndices = new int[250];
        netWriter = new NetWriter();
        logoutTimer = 0;
        pendingDisconnect = false;
        usingBufferedConnection = true;
        gameStateEvents = new GameStateEvent();
        fonts = new HashMap<>();
        loadingIndicator1 = 0;
        loadingIndicator2 = 1;
        loadingIndicator3 = 0;
        loadingIndicator4 = 1;
        loadingDrawState = 0;
        collisionMaps = new CollisionMap[4];
        dynamicScene = false;
        dynamicSceneData = new int[4][13][13];
        OBJECT_TYPE_TO_STUB_TYPE = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
        anInt972 = 0;
        anInt980 = 2301979;
        anInt987 = 5063219;
        anInt983 = 3353893;
        anInt990 = 7759444;
        useDefaultScrollbar = false;
        scrollbarWidth = 0;
        cameraX = 128;
        cameraY = 0;
        cameraXDiff = 0;
        cameraYDiff = 0;
        mouseCameraDragX = 0;
        mouseCameraDragY = 0;
        oculusOrbState = 0;
        cameraFollowHeight = 50;
        anInt977 = 0;
        anInt986 = 0;
        anInt997 = 0;
        oculusOrbSpeed = 12;
        oculusOrbSlowSpeed = 6;
        anInt1002 = 0;
        oculusOrbOnPlayer = false;
        cameraMovementPacketIndicator = 0;
        emitCameraMovementPackets = false;
        anInt1008 = 0;
        overheadMessageCount = 0;
        overheadMessageCapacity = 50;
        overheadMessageXPositions = new int[overheadMessageCapacity];
        overheadMessageYPositions = new int[overheadMessageCapacity];
        overheadMessageYShifts = new int[overheadMessageCapacity];
        overheadMessageXShifts = new int[overheadMessageCapacity];
        overheadMessageColors = new int[overheadMessageCapacity];
        overheadMessageEffects = new int[overheadMessageCapacity];
        overheadMessageCyclesRemaining = new int[overheadMessageCapacity];
        overheadMessages = new String[overheadMessageCapacity];
        pathingEntityRenderPositions = new int[104][104];
        viewportRenderCount = 0;
        viewportRenderX = -1;
        viewportRenderY = -1;
        ContextMenu.Crosshair.x = 0;
        ContextMenu.Crosshair.y = 0;
        ContextMenu.Crosshair.state = 0;
        ContextMenu.Crosshair.display = true;
        anInt1018 = 0;
        anInt1015 = 0;
        draggingComponentSourceIndex = 0;
        draggingComponentX = 0;
        draggingComponentY = 0;
        draggingComponentIndex = 0;
        draggingComponent = false;
        componentDragCycles = 0;
        anInt1014 = 0;
        displayLoadingMessages = true;
        players = new PlayerEntity[2048];
        playerIndex = -1;
        relationshipSystemState = 0;
        displaySelf = true;
        displayPlayerNames = 0;
        npcCount2 = 0;
        npcIndices2 = new int[1000];
        PLAYER_ACTION_OPCODES = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
        playerActions = new String[8];
        playerActionPriorities = new boolean[8];
        pathingEntityOrientations = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
        anInt1030 = -1;
        pickables = new NodeDeque[4][104][104];
        pendingSpawns = new NodeDeque<>();
        projectiles = new NodeDeque<>();
        effectObjects = new NodeDeque<>();
        currentLevels = new int[25];
        levels = new int[25];
        experiences = new int[25];
        anInt1034 = 0;
        aBoolean1042 = false;
        aBoolean1044 = false;
        aBoolean1037 = false;
        aBoolean1043 = true;
        anInt1039 = -1;
        anInt1038 = -1;
        anInt1041 = 0;
        anInt1036 = 50;
        ComponentSelection.Item.state = 0;
        ComponentSelection.Item.name = null;
        ComponentSelection.Spell.state = false;
        ComponentSelection.Spell.index = -1;
        ComponentSelection.Spell.target = -1;
        ComponentSelection.action = null;
        ComponentSelection.Spell.name = null;
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
        mouseWheelPtr = 0;
        aNodeDeque1082 = new NodeDeque<>();
        aNodeDeque1088 = new NodeDeque<>();
        aNodeDeque1080 = new NodeDeque<>();
        interfaceConfigs = new NodeTable<>(512);
        renderedComponentCount = 0;
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
        renderedAppearance = new PlayerModel();
        anInt930 = -1;
        anInt931 = -1;
        operatingSystemProvider = new DefaultOperatingSystemProvider();
        stockMarketOffers = new StockMarketOffer[8];
        stockMarketComparator = new StockMarketOfferWorldComparator();
        anInt929 = -1;
        archives = new ArrayList<>(10);
        anInt926 = 0;
        archiveEntryCount = 0;
        routeStrategy = new DefaultRouteStrategy();
        anIntArray945 = new int[50];
        anIntArray942 = new int[50];
        chatHistory = new HashMap<>();
    }

    public static void processAudioEffects() {
        for (int i = 0; i < audioEffectCount; ++i) {
            if (anIntArray906[i] >= -10) {
                AudioEffect effect = audioEffects[i];
                if (effect == null) {
                    effect = AudioEffect.load(Archive.audioEffects, anIntArray899[i], 0);
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
                        int var5 = var4 * 128 + 64 - PlayerEntity.local.absoluteX;
                        if (var5 < 0) {
                            var5 = -var5;
                        }

                        int var6 = anIntArray902[i] >> 8 & 255;
                        int var7 = var6 * 128 + 64 - PlayerEntity.local.absoluteY;
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
                        RawAudioOverride var10 = effect.method1523().resample(Statics46.aClass98_446);
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
            if (AudioSystem.state != 0) {
                var12 = true;
            } else {
                var12 = Statics50.aClass5_Sub6_Sub3_326.method684();
            }

            if (!var12) {
                if (anInt900 != 0 && anInt898 != -1) {
                    Statics51.method344(Archive.audioTracks, anInt898, 0, anInt900, false);
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
            WorldMapGroundDecorType2.aConnection299 = netWriter.unwrap();
            netWriter.kill();
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

    public static void setGameState(int var0) {
        if (var0 != gameState) {
            if (gameState == 0) {
                instance.method929();
            }

            if (var0 == 20 || var0 == 40 || var0 == 45) {
                loginStage = 0;
                loginStageCycles = 0;
                loginProcess = 0;
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
                loadingDrawState = 0;
                loadingIndicator1 = 0;
                loadingIndicator2 = 1;
                loadingIndicator3 = 0;
                loadingIndicator4 = 1;
            }

            if (var0 != 5 && var0 != 10) {
                if (var0 == 20) {
                    Login.prepare(Archive.huffman, Archive.sprites, true, gameState == 11 ? 4 : 0);
                } else if (var0 == 11) {
                    Login.prepare(Archive.huffman, Archive.sprites, false, 4);
                } else if (Login.clear) {
                    Statics49.titleboxSprite = null;
                    GraphicsProvider.titlebuttonSprite = null;
                    Login.runeSprites = null;
                    Login.leftTitleSprite = null;
                    Login.rightTitleSprite = null;
                    Login.logoSprite = null;
                    AssociateComparator_Sub2.titleMuteSprites = null;
                    Statics11.aDoublyNode_Sub24_Sub4_1148 = null;
                    WorldMapAreaChunk_Sub2.aDoublyNode_Sub24_Sub4_288 = null;
                    LoadedArchive.aSpriteArray429 = null;
                    ClientLocale.aDoublyNode_Sub24_Sub4Array1178 = null;
                    StockMarketOfferQuantityComparator.aDoublyNode_Sub24_Sub4Array653 = null;
                    AnimationFrameGroup.aDoublyNode_Sub24_Sub4Array801 = null;
                    Login.slbutton = null;
                    AsyncOutputStream.loginScreenEffect.destroy();
                    AudioSystem.state = 1;
                    AudioSystem.tracks = null;
                    AudioSystem.trackGroup = -1;
                    AudioSystem.trackFile = -1;
                    AudioSystem.volume = 0;
                    AudioSystem.aBoolean620 = false;
                    AudioSystem.pcmSampleLength = 2;
                    Js5Worker.kill(true);
                    Login.clear = false;
                }
            } else {
                Login.prepare(Archive.huffman, Archive.sprites, true, 0);
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
                if (Jagexception.applet == null) {
                    return;
                }

                URL var3 = new URL(Jagexception.applet.getCodeBase(), "clienterror.ws?c=" + build + "&u=" + Jagexception.aString1882 + "&v1=" + OldConnectionTaskProcessor.javaVendor + "&v2=" + OldConnectionTaskProcessor.javaVerson + "&ct=" + clientParameter4 + "&e=" + var2);
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
        TileOverlay.cache.clear();
        TileUnderlay.cache.clear();
        IdentikitDefinition.cache.clear();
        ObjectDefinition.cache.clear();
        ObjectDefinition.rawmodels.clear();
        ObjectDefinition.aReferenceCache1513.clear();
        ObjectDefinition.models.clear();
        NpcDefinition.cache.clear();
        NpcDefinition.models.clear();
        ItemDefinition.clear();
        AnimationSequence.cache.clear();
        AnimationSequence.frames.clear();
        EffectAnimation.clear();
        Varbit.cache.clear();
        AudioOverride.clear();
        StockMarketEvent.clear();
        HealthBarDefinition.cache.clear();
        HealthBarDefinition.sprites.clear();
        ParameterDefinition.cache.clear();
        DefinitionProperty.clear();
        WorldMapFunction.cache.clear();
        Class223.clear();
        InterfaceComponent.sprites.clear();
        InterfaceComponent.models.clear();
        InterfaceComponent.fonts.clear();
        InterfaceComponent.specialSprites.clear();
        ((DefaultMaterialProvider) JagGraphics3D.aMaterialProvider783).clear();
        ClientScript.cache.clear();
        Archive.skeletons.clear();
        Archive.skins.clear();
        Archive.interfaces.clear();
        Archive.audioEffects.clear();
        Archive.landscape.clear();
        Archive.audioTracks.clear();
        Archive.models.clear();
        Archive.sprites.clear();
        Archive.textures.clear();
        Archive.huffman.clear();
        Archive.audioTracks2.clear();
        Archive.cs2.clear();
    }

    public static String method9() {
        String var0 = "";

        ChatLine var2;
        for (Iterator<ChatLine> var1 = Statics53.CHAT_LINE_TABLE.iterator(); var1.hasNext(); var0 = var0 + var2.channel + ':' + var2.message + '\n') {
            var2 = var1.next();
        }

        return var0;
    }

    public static void processGameBoundsPacket() {
        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.GAME_BOUNDS, netWriter.encryptor);
        packet.buffer.p1(isResizable());
        packet.buffer.p2(canvasWidth);
        packet.buffer.p2(canvasHeight);
        netWriter.writeLater(packet);
    }

    public static String getColorTags(int color) {
        return "<col=" + Integer.toHexString(color) + ">";
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
        if (this.width_ < var1) {
        }

        if (this.height_ < var2) {
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
        netWriter.stop();
        Keyboard.destroy();
        Mouse.destroy();
        MouseWheel.provider = null;
        if (AudioSystem.anAudioSystem1236 != null) {
            AudioSystem.anAudioSystem1236.destroy();
        }

        if (AudioSystem.anAudioSystem599 != null) {
            AudioSystem.anAudioSystem599.destroy();
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
            Buffer.variadicSizes = var1;
            Buffer.variadicIndices = new int[var1.length];
            Buffer.variadic = new byte[var1.length][][];

            for (int var5 = 0; var5 < Buffer.variadicSizes.length; ++var5) {
                Buffer.variadic[var5] = new byte[var2[var5]][];
            }
        } else {
            Buffer.variadicSizes = null;
            Buffer.variadicIndices = null;
            Buffer.variadic = null;
        }

        HitsplatDefinition.anInt1929 = gameType == 0 ? 43594 : currentWorld + 40000;
        Bzip2Entry.anInt1579 = gameType == 0 ? 443 : currentWorld + 50000;
        NpcEntity.port = HitsplatDefinition.anInt1929;
        HAlign.aShortArray1482 = PlayerModelColors.aShortArray1225;
        PlayerModel.colors = PlayerModelColors.aShortArrayArray1226;
        PlayerModel.colors2 = PlayerModelColors.aShortArray1224;
        DefaultAudioSystemProvider.aShortArrayArray145 = PlayerModelColors.aShortArrayArray1223;
        urlRequestProcessor = new URLRequestProcessor();
        Keyboard.method921();

        java.awt.Canvas canvas = super.canvas;
        canvas.setFocusTraversalKeysEnabled(false);
        canvas.addKeyListener(Keyboard.instance);
        canvas.addFocusListener(Keyboard.instance);
        Statics48.method95(canvas);

        MouseWheel.provider = this.method943();
        WorldMapTileDecor_Sub2.aResourceCache649 = new ResourceCache(255, BufferedFile.dataFile, BufferedFile.indexFile, 500000);
        preferences = ItemDefinition.method529();
        this.updateClipboard();
        String var4 = WorldMapController.aString264;
        GameShell.applet = this;
        if (var4 != null) {
            WorldMapController.aString325 = var4;
        }

        if (gameType != 0) {
            displayFps = true;
        }

        AssociateComparatorByMyWorld.method603(preferences.resizable);
        relationshipSystem = new RelationshipSystem(PreciseWorldMapAreaChunk.nameLengthParameter);
    }

    public final void method734(boolean var1) {
        Statics26.method1112(rootInterfaceIndex, canvasWidth, canvasHeight, var1);
    }

    public void js5error(int var1) {
        Login.js5task = null;
        Statics48.js5connection = null;
        js5State = 0;
        if (NpcEntity.port == HitsplatDefinition.anInt1929) {
            NpcEntity.port = Bzip2Entry.anInt1579;
        } else {
            NpcEntity.port = HitsplatDefinition.anInt1929;
        }

        ++js5ErrorCount;
        if (js5ErrorCount >= 2 && (var1 == 7 || var1 == 9)) {
            if (gameState <= 5) {
                this.error("js5connect_full");
                gameState = 1000;
            } else {
                js5Cycles = 3000;
            }
        } else if (js5ErrorCount >= 2 && var1 == 6) {
            this.error("js5connect_outofdate");
            gameState = 1000;
        } else if (js5ErrorCount >= 4) {
            if (gameState <= 5) {
                this.error("js5connect");
                gameState = 1000;
            } else {
                js5Cycles = 3000;
            }
        }

    }

    public final boolean method731() {
        int var1 = AssociateComparatorByRank.getMaximumMenuRowIndex();
        return (anInt1034 == 1 && ContextMenu.rowCount > 2 || ContextMenu.isComponentAction2(var1)) && !ContextMenu.shiftClickActions[var1];
    }

    protected final void method743() {

    }

    private boolean readIncomingPacket(Connection connection, PacketBuffer incoming) throws IOException {
        if (client.netWriter.alive) {
            if (!connection.available(1)) {
                return false;
            }

            connection.read(client.netWriter.inbuffer.payload, 0, 1);
            client.netWriter.idleReadTicks = 0;
            client.netWriter.alive = false;
        }

        incoming.pos = 0;
        if (incoming.method258()) {
            if (!connection.available(1)) {
                return false;
            }

            connection.read(client.netWriter.inbuffer.payload, 1, 1);
            client.netWriter.idleReadTicks = 0;
        }

        client.netWriter.alive = true;
        IncomingPacketMeta[] incomingPacketTypes = IncomingPacketMeta.values();
        int packetIndex = incoming.method1396();
        if (packetIndex < 0 || packetIndex >= incomingPacketTypes.length) {
            throw new IOException(packetIndex + " " + incoming.pos);
        }

        client.netWriter.currentIncomingPacket = incomingPacketTypes[packetIndex];
        client.netWriter.incomingPacketSize = client.netWriter.currentIncomingPacket.size;
        return true;
    }

    public final boolean processIncomingPacket() {
        Connection connection = client.netWriter.unwrap();
        PacketBuffer incoming = client.netWriter.inbuffer;
        if (connection == null) {
            return false;
        }

        int var7;
        StringBuilder var33;
        int var5;

        try {
            if (client.netWriter.currentIncomingPacket == null && !readIncomingPacket(connection, incoming)) {
                return false;
            }

            if (client.netWriter.incomingPacketSize == -1) {
                if (!connection.available(1)) {
                    return false;
                }

                client.netWriter.unwrap().read(incoming.payload, 0, 1);
                client.netWriter.incomingPacketSize = incoming.payload[0] & 0xff;
            }

            if (client.netWriter.incomingPacketSize == -2) {
                if (!connection.available(2)) {
                    return false;
                }

                client.netWriter.unwrap().read(incoming.payload, 0, 2);
                incoming.pos = 0;
                client.netWriter.incomingPacketSize = incoming.g2();
            }

            if (!connection.available(client.netWriter.incomingPacketSize)) {
                return false;
            }

            incoming.pos = 0;
            connection.read(incoming.payload, 0, client.netWriter.incomingPacketSize);
            client.netWriter.idleReadTicks = 0;
            gameStateEvents.updateTime();

            client.netWriter.thirdLastIncomingPacket = client.netWriter.secondLastIncomingPacket;
            client.netWriter.secondLastIncomingPacket = client.netWriter.lastIncomingPacket;
            client.netWriter.lastIncomingPacket = client.netWriter.currentIncomingPacket;

            if (IncomingPacketMeta.anIncomingPacketMeta186 == client.netWriter.currentIncomingPacket) {
                StockMarketOfferQuantityComparator.method479(RegionUpdateType.SPAWN_PROJECTILE);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            int var6;
            int var8;
            int var9;
            long var10;
            if (IncomingPacketMeta.UPDATE_COMPONENT_CONFIG == client.netWriter.currentIncomingPacket) {
                var6 = incoming.readLEUShortA();
                if (var6 == 65535) {
                    var6 = -1;
                }

                var5 = incoming.g2();
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

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta228 == client.netWriter.currentIncomingPacket) {
                var6 = incoming.g1();
                Js5Worker.setOculusOrbState(var6);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            InterfaceComponent var47;
            if (IncomingPacketMeta.anIncomingPacketMeta175 == client.netWriter.currentIncomingPacket) {
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
                        GameShell.method925(interfaces[var7 >> 16], var47, false);
                    }
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta201 == client.netWriter.currentIncomingPacket) {
                StockMarketOfferQuantityComparator.method479(RegionUpdateType.REMOVE_SCENE_OBJECT);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta217 == client.netWriter.currentIncomingPacket) {
                rebootTimer = incoming.readLEUShortA() * 30;
                anInt1074 = anInt1075;
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            boolean var42;
            if (IncomingPacketMeta.anIncomingPacketMeta232 == client.netWriter.currentIncomingPacket) {
                var42 = incoming.g1() == 1;
                if (var42) {
                    EntityUID.aLong548 = Clock.now() - incoming.g8();
                    Pickable.aStockMarketMediator_890 = new StockMarketMediator(incoming);
                } else {
                    Pickable.aStockMarketMediator_890 = null;
                }

                anInt1077 = anInt1075;
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta230 == client.netWriter.currentIncomingPacket) {
                GameShell.method1417(incoming.gstr());
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_ITEMTABLE == client.netWriter.currentIncomingPacket) {
                int componentUid = incoming.g4();
                int key = incoming.g2();
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

                int size = incoming.g2();
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
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            InterfaceComponent var14;
            int var15;
            int var16;

            if (IncomingPacketMeta.LOCK_CAMERA == client.netWriter.currentIncomingPacket) {
                cameraLocked = true;
                SceneGraph.anInt1235 = incoming.g1() * 128;
                Clock.anInt889 = incoming.g1() * 128;
                StockMarketOfferWorldComparator.anInt347 = incoming.g2();
                MouseRecorder.anInt388 = incoming.g1();
                Statics53.anInt520 = incoming.g1();
                if (Statics53.anInt520 >= 100) {
                    SceneGraph.cameraX = SceneGraph.anInt1235 * 16384 + 64;
                    SceneGraph.cameraY = Clock.anInt889 * 16384 + 64;
                    SceneGraph.cameraZ = SceneGraph.getTileHeight(SceneGraph.cameraX, SceneGraph.cameraY, SceneGraph.floorLevel) - StockMarketOfferWorldComparator.anInt347;
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta202 == client.netWriter.currentIncomingPacket) {
                StockMarketOfferQuantityComparator.method479(RegionUpdateType.A_REGION_UPDATE_TYPE___1205);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta178 == client.netWriter.currentIncomingPacket) {
                var6 = incoming.g4();
                var5 = incoming.g4();
                var7 = SerializableString.getGcTime();
                OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.GARBAGE_COLLECTOR, netWriter.encryptor);
                packet.buffer.p1n(var7);
                packet.buffer.p4(var6);
                packet.buffer.pif4(var5);
                packet.buffer.writeByteS(anInt1292);
                netWriter.writeLater(packet);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta224 == client.netWriter.currentIncomingPacket) {
                SubInterface.process();
                weight = incoming.g2b();
                anInt1074 = anInt1075;
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta203 == client.netWriter.currentIncomingPacket) {
                var6 = incoming.g4();
                if (var6 != anInt1002) {
                    anInt1002 = var6;
                    Class114.method672();
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta250 == client.netWriter.currentIncomingPacket) {
                if (clanSystem != null) {
                    clanSystem.decodeUpdate(incoming);
                }

                RegionUpdateType.method865();
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            SubInterface var13;
            InterfaceComponent var17;
            if (IncomingPacketMeta.anIncomingPacketMeta211 == client.netWriter.currentIncomingPacket) {
                var6 = incoming.method1015();
                var5 = incoming.g4();
                SubInterface var53 = subInterfaces.lookup(var5);
                var13 = subInterfaces.lookup(var6);
                if (var13 != null) {
                    InterfaceComponent.close(var13, var53 == null || var13.id != var53.id);
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
                    GameShell.method925(interfaces[var17.uid >>> 16], var17, true);
                }

                if (rootInterfaceIndex != -1) {
                    InterfaceComponent.method118(rootInterfaceIndex, 1);
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta210 == client.netWriter.currentIncomingPacket) {
                relationshipSystem.decodeFriends(incoming, client.netWriter.incomingPacketSize);
                anInt1065 = anInt1075;
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            long var18;
            long var20;
            long var22;
            String var38;
            if (IncomingPacketMeta.anIncomingPacketMeta238 == client.netWriter.currentIncomingPacket) {
                var38 = incoming.gstr();
                var18 = incoming.g8();
                var20 = incoming.g2();
                var10 = incoming.g3();
                PlayerAccountType var12 = (PlayerAccountType) EnumType.getByOrdinal(PlayerAccountType.getValues(), incoming.g1());
                var22 = var10 + (var20 << 32);
                boolean var54 = false;

                for (int var25 = 0; var25 < 100; ++var25) {
                    if (aLongArray896[var25] == var22) {
                        var54 = true;
                        break;
                    }
                }

                if (var12.aBoolean1258 && relationshipSystem.isIgnoring(new NamePair(var38, PreciseWorldMapAreaChunk.nameLengthParameter))) {
                    var54 = true;
                }

                if (!var54 && anInt1014 == 0) {
                    aLongArray896[anInt891] = var22;
                    anInt891 = (anInt891 + 1) % 100;
                    String var26 = BaseFont.method1166(OldConnection.method714(DefaultRouteStrategy.method294(incoming)));
                    if (var12.anInt1218 != -1) {
                        ChatHistory.messageReceived(9, Statics26.addImgTags(var12.anInt1218) + var38, var26, Base37.decode(var18));
                    } else {
                        ChatHistory.messageReceived(9, var38, var26, Base37.decode(var18));
                    }
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_RANDOM == client.netWriter.currentIncomingPacket) {
                incoming.pos += 28;
                if (incoming.matchCrcs()) {
                    ResourceCache.method1489(incoming, incoming.pos - 28);
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_GRAND_EXCHANGE == client.netWriter.currentIncomingPacket) {
                var6 = incoming.g1();
                if (incoming.g1() == 0) {
                    stockMarketOffers[var6] = new StockMarketOffer();
                    incoming.pos += 18;
                } else {
                    --incoming.pos;
                    stockMarketOffers[var6] = new StockMarketOffer(incoming);
                }

                anInt1071 = anInt1075;
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta181 == client.netWriter.currentIncomingPacket) {
                var6 = incoming.method1067();
                var5 = incoming.method1011();
                var14 = InterfaceComponent.lookup(var5);
                if (var6 != var14.animation || var6 == -1) {
                    var14.animation = var6;
                    var14.animationFrame = 0;
                    var14.animationFrameCycle = 0;
                    InterfaceComponent.repaint(var14);
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.SET_COMPONENT_TO_ITEM_MODEL == client.netWriter.currentIncomingPacket) {
                var6 = incoming.g4();
                var5 = incoming.method1015();
                var7 = incoming.readLEUShortA();
                if (var7 == 65535) {
                    var7 = -1;
                }

                var47 = InterfaceComponent.lookup(var6);
                ItemDefinition var52;
                if (!var47.format) {
                    if (var7 == -1) {
                        var47.modelType = 0;
                        client.netWriter.currentIncomingPacket = null;
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
                        var47.itemStackSizeMode = 1;
                    } else {
                        var47.itemStackSizeMode = 2;
                    }

                    if (var47.scaleZ > 0) {
                        var47.modelZoom = var47.modelZoom * 32 / var47.scaleZ;
                    } else if (var47.baseWidth > 0) {
                        var47.modelZoom = var47.modelZoom * 32 / var47.baseWidth;
                    }

                }
                InterfaceComponent.repaint(var47);

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.SET_COMPONENT_MODEL_TYPE2 == client.netWriter.currentIncomingPacket) {
                var6 = incoming.method1011();
                var5 = incoming.method1055();
                var14 = InterfaceComponent.lookup(var6);
                if (var14.modelType != 2 || var5 != var14.modelId) {
                    var14.modelType = 2;
                    var14.modelId = var5;
                    InterfaceComponent.repaint(var14);
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta235 == client.netWriter.currentIncomingPacket) {
                StockMarketOfferQuantityComparator.method479(RegionUpdateType.SPAWN_GRAPHICS_OBJECT);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta180 == client.netWriter.currentIncomingPacket) {
                var38 = incoming.gstr();
                var18 = incoming.g2();
                var20 = incoming.g3();
                PlayerAccountType var27 = (PlayerAccountType) EnumType.getByOrdinal(PlayerAccountType.getValues(), incoming.g1());
                long var28 = (var18 << 32) + var20;
                boolean var30 = false;

                for (int var31 = 0; var31 < 100; ++var31) {
                    if (aLongArray896[var31] == var28) {
                        var30 = true;
                        break;
                    }
                }

                if (relationshipSystem.isIgnoring(new NamePair(var38, PreciseWorldMapAreaChunk.nameLengthParameter))) {
                    var30 = true;
                }

                if (!var30 && anInt1014 == 0) {
                    aLongArray896[anInt891] = var28;
                    anInt891 = (anInt891 + 1) % 100;
                    String var32 = BaseFont.method1166(OldConnection.method714(DefaultRouteStrategy.method294(incoming)));
                    byte var24;
                    if (var27.aBoolean1257) {
                        var24 = 7;
                    } else {
                        var24 = 3;
                    }

                    if (var27.anInt1218 != -1) {
                        ChatHistory.messageReceived(var24, Statics26.addImgTags(var27.anInt1218) + var38, var32);
                    } else {
                        ChatHistory.messageReceived(var24, var38, var32);
                    }
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            InterfaceComponent var57;
            if (IncomingPacketMeta.anIncomingPacketMeta258 == client.netWriter.currentIncomingPacket) {
                var6 = incoming.method1015();
                var57 = InterfaceComponent.lookup(var6);

                for (var7 = 0; var7 < var57.itemIds.length; ++var7) {
                    var57.itemIds[var7] = -1;
                    var57.itemIds[var7] = 0;
                }

                InterfaceComponent.repaint(var57);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta184 == client.netWriter.currentIncomingPacket) {
                NpcEntity.update(true, incoming);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_VARP2 == client.netWriter.currentIncomingPacket) {
                var6 = incoming.method1019();
                var5 = incoming.readLEUShortA();
                Vars.baseValues[var5] = var6;
                if (Vars.values[var5] != var6) {
                    Vars.values[var5] = var6;
                }

                OldConnection.method712(var5);
                anIntArray1076[++anInt1064 - 1 & 31] = var5;
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.SET_REGION_CHUNK == client.netWriter.currentIncomingPacket) {
                SceneGraph.regionChunkX = incoming.ig1();
                SceneGraph.regionChunkY = incoming.g1();
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta192 == client.netWriter.currentIncomingPacket) {
                var6 = incoming.g1();
                var5 = incoming.g1();
                var7 = incoming.g1();
                var8 = incoming.g1();
                aBooleanArray919[var6] = true;
                anIntArray917[var6] = var5;
                anIntArray918[var6] = var7;
                anIntArray914[var6] = var8;
                anIntArray916[var6] = 0;
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.SET_PLAYER_ACTION == client.netWriter.currentIncomingPacket) {
                var6 = incoming.method1074();
                var33 = new StringBuilder(incoming.gstr());
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

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.SET_WORLD == client.netWriter.currentIncomingPacket) {
                Server var41 = new Server();
                var41.domain = incoming.gstr();
                var41.id = incoming.g2();
                var5 = incoming.g4();
                var41.mask = var5;
                setGameState(45);
                connection.stop();
                SerializableString.setWorld(var41);
                client.netWriter.currentIncomingPacket = null;
                return false;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta200 == client.netWriter.currentIncomingPacket) {
                relationshipSystem.isLoading();
                anInt1065 = anInt1075;
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.DROP_CONNECTION == client.netWriter.currentIncomingPacket) {
                var6 = incoming.g1();
                AnimationSequence.method881(var6);
                client.netWriter.currentIncomingPacket = null;
                return false;
            }

            if (IncomingPacketMeta.UNLOCK_CAMERA == client.netWriter.currentIncomingPacket) {
                cameraLocked = false;

                for (var6 = 0; var6 < 5; ++var6) {
                    aBooleanArray919[var6] = false;
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.ADD_PICKABLE == client.netWriter.currentIncomingPacket) {
                StockMarketOfferQuantityComparator.method479(RegionUpdateType.ADD_PICKABLE);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta197 == client.netWriter.currentIncomingPacket) {
                if (client.netWriter.incomingPacketSize == 0) {
                    clanSystem = null;
                } else {
                    if (clanSystem == null) {
                        clanSystem = new ClanSystem(PreciseWorldMapAreaChunk.nameLengthParameter, instance);
                    }

                    clanSystem.decode(incoming);
                }

                RegionUpdateType.method865();
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_HINT_ARROW == client.netWriter.currentIncomingPacket) {
                HintArrow.type = incoming.g1();
                if (HintArrow.type == 1) {
                    HintArrow.npc = incoming.g2();
                }

                if (HintArrow.type >= 2 && HintArrow.type <= 6) {
                    if (HintArrow.type == 2) {
                        HintArrow.insetX = 64;
                        HintArrow.insetY = 4096;
                    }

                    if (HintArrow.type == 3) {
                        HintArrow.insetX = 0;
                        HintArrow.insetY = 4096;
                    }

                    if (HintArrow.type == 4) {
                        HintArrow.insetX = 128;
                        HintArrow.insetY = 4096;
                    }

                    if (HintArrow.type == 5) {
                        HintArrow.insetX = 64;
                        HintArrow.insetY = 0;
                    }

                    if (HintArrow.type == 6) {
                        HintArrow.insetX = 64;
                        HintArrow.insetY = 8192;
                    }

                    HintArrow.type = 2;
                    HintArrow.x = incoming.g2();
                    HintArrow.y = incoming.g2();
                    HintArrow.z = incoming.g1() * 2;
                }

                if (HintArrow.type == 10) {
                    HintArrow.player = incoming.g2();
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta209 == client.netWriter.currentIncomingPacket) {
                var6 = incoming.method1055();
                Inventory.delete(var6);
                inventories[++anInt1078 - 1 & 31] = var6 & 32767;
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta236 == client.netWriter.currentIncomingPacket) {
                var6 = incoming.method1055();
                rootInterfaceIndex = var6;
                this.method734(false);
                InterfaceComponent.loadAnimable(var6);
                InterfaceComponent.loadAndInitialize(rootInterfaceIndex);

                for (var5 = 0; var5 < 100; ++var5) {
                    renderedComponents[var5] = true;
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            String var50;
            if (IncomingPacketMeta.ADD_CHAT_MESSAGE == client.netWriter.currentIncomingPacket) {
                var6 = incoming.gsmarts();
                boolean var46 = incoming.g1() == 1;
                var50 = "";
                boolean var44 = false;
                if (var46) {
                    var50 = incoming.gstr();
                    if (relationshipSystem.isIgnoring(new NamePair(var50, PreciseWorldMapAreaChunk.nameLengthParameter))) {
                        var44 = true;
                    }
                }

                String var51 = incoming.gstr();
                if (!var44) {
                    ChatHistory.messageReceived(var6, var50, var51);
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_MAP_REGION == client.netWriter.currentIncomingPacket) {
                PlayerAccountType.onSceneXTEAKeyChange(false, client.netWriter.inbuffer);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.OPEN_BROWSER_URL == client.netWriter.currentIncomingPacket) {
                byte[] var40 = new byte[client.netWriter.incomingPacketSize];
                incoming.method1397(var40, 0, var40.length);
                Buffer var61 = new Buffer(var40);
                var50 = var61.gstr();
                CacheRequestWorker.openURL(var50, true, false);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.SET_COMPONENT_HIDDEN == client.netWriter.currentIncomingPacket) {
                var42 = incoming.g1() == 1;
                var5 = incoming.method1015();
                var14 = InterfaceComponent.lookup(var5);
                if (var42 != var14.explicitlyHidden) {
                    var14.explicitlyHidden = var42;
                    InterfaceComponent.repaint(var14);
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_ITEM_TABLE == client.netWriter.currentIncomingPacket) {
                var6 = incoming.g4();
                var5 = incoming.g2();
                if (var6 < -70000) {
                    var5 += 32768;
                }

                if (var6 >= 0) {
                    var14 = InterfaceComponent.lookup(var6);
                } else {
                    var14 = null;
                }

                while (incoming.pos < client.netWriter.incomingPacketSize) {
                    var8 = incoming.gsmarts();
                    var9 = incoming.g2();
                    var15 = 0;
                    if (var9 != 0) {
                        var15 = incoming.g1();
                        if (var15 == 255) {
                            var15 = incoming.g4();
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
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.SET_COMPONENT_MODEL_TYPE1 == client.netWriter.currentIncomingPacket) {
                var6 = incoming.method1019();
                var5 = incoming.method1055();
                var14 = InterfaceComponent.lookup(var6);
                if (var14.modelType != 1 || var5 != var14.modelId) {
                    var14.modelType = 1;
                    var14.modelId = var5;
                    InterfaceComponent.repaint(var14);
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.SET_COMPONENT_FOREGROUND == client.netWriter.currentIncomingPacket) {
                var6 = incoming.g2();
                var5 = incoming.method1015();
                var7 = var6 >> 10 & 31;
                var8 = var6 >> 5 & 31;
                var9 = var6 & 31;
                var15 = (var8 << 11) + (var7 << 19) + (var9 << 3);
                InterfaceComponent var59 = InterfaceComponent.lookup(var5);
                if (var15 != var59.foreground) {
                    var59.foreground = var15;
                    InterfaceComponent.repaint(var59);
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.SET_COMPONENT_ZOOM == client.netWriter.currentIncomingPacket) {
                var6 = incoming.g2();
                var5 = incoming.method1055();
                var7 = incoming.method1060();
                var8 = incoming.g4();
                var17 = InterfaceComponent.lookup(var8);
                if (var5 != var17.xRotation || var7 != var17.zRotation || var6 != var17.modelZoom) {
                    var17.xRotation = var5;
                    var17.zRotation = var7;
                    var17.modelZoom = var6;
                    InterfaceComponent.repaint(var17);
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_CHAT_MODE == client.netWriter.currentIncomingPacket) {
                tradeChatMode = incoming.method1074();
                publicChatMode = incoming.method1056();
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_STATS == client.netWriter.currentIncomingPacket) {
                SubInterface.process();
                var6 = incoming.method1019();
                var5 = incoming.method1056();
                var7 = incoming.method1074();
                experiences[var5] = var6;
                currentLevels[var5] = var7;
                levels[var5] = 1;

                for (var8 = 0; var8 < 98; ++var8) {
                    if (var6 >= Skills.EXP_TABLE[var8]) {
                        levels[var5] = var8 + 2;
                    }
                }

                anIntArray1079[++anInt1063 - 1 & 31] = var5;
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.SET_MAP_STATE == client.netWriter.currentIncomingPacket) {
                mapState = incoming.g1();
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta245 == client.netWriter.currentIncomingPacket) {
                var6 = incoming.method1055();
                var5 = incoming.method1011();
                var7 = incoming.method1060();
                var47 = InterfaceComponent.lookup(var5);
                var47.rotationKey = var6 + (var7 << 16);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.FIRE_SCRIPT_EVENT == client.netWriter.currentIncomingPacket) {
                var38 = incoming.gstr();
                Object[] var60 = new Object[var38.length() + 1];

                for (var7 = var38.length() - 1; var7 >= 0; --var7) {
                    if (var38.charAt(var7) == 's') {
                        var60[var7 + 1] = incoming.gstr();
                    } else {
                        var60[var7 + 1] = incoming.g4();
                    }
                }

                var60[0] = incoming.g4();
                ScriptEvent var48 = new ScriptEvent();
                var48.args = var60;
                ScriptEvent.fire(var48);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta219 == client.netWriter.currentIncomingPacket) {
                cameraLocked = true;
                GameShell.anInt1288 = incoming.g1() * 16384;
                SecureRandomService.anInt458 = incoming.g1() * 128;
                Statics52.anInt499 = incoming.g2();
                Statics54.anInt627 = incoming.g1();
                ScriptEvent.anInt1806 = incoming.g1();
                if (ScriptEvent.anInt1806 >= 100) {
                    var6 = GameShell.anInt1288 * 128 + 64;
                    var5 = SecureRandomService.anInt458 * 16384 + 64;
                    var7 = SceneGraph.getTileHeight(var6, var5, SceneGraph.floorLevel) - Statics52.anInt499;
                    var8 = var6 - SceneGraph.cameraX;
                    var9 = var7 - SceneGraph.cameraZ;
                    var15 = var5 - SceneGraph.cameraY;
                    var16 = (int) Math.sqrt(var15 * var15 + var8 * var8);
                    SceneGraph.cameraPitch = (int) (Math.atan2(var9, var16) * 325.949D) & 2047;
                    SceneGraph.cameraYaw = (int) (Math.atan2(var8, var15) * -325.949D) & 2047;
                    if (SceneGraph.cameraPitch < 128) {
                        SceneGraph.cameraPitch = 128;
                    }

                    if (SceneGraph.cameraPitch > 383) {
                        SceneGraph.cameraPitch = 383;
                    }
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta189 == client.netWriter.currentIncomingPacket) {
                StockMarketOfferQuantityComparator.method479(RegionUpdateType.A_REGION_UPDATE_TYPE___1206);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta240 == client.netWriter.currentIncomingPacket) {
                var6 = incoming.g4();
                var5 = incoming.g1();
                var7 = incoming.g2();
                var13 = subInterfaces.lookup(var6);
                if (var13 != null) {
                    InterfaceComponent.close(var13, var7 != var13.id);
                }

                SubInterface.create(var6, var7, var5);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta215 == client.netWriter.currentIncomingPacket) {
                StockMarketOfferQuantityComparator.method479(RegionUpdateType.A_REGION_UPDATE_TYPE___1204);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta227 == client.netWriter.currentIncomingPacket) {
                var6 = incoming.g4();
                SubInterface var58 = subInterfaces.lookup(var6);
                if (var58 != null) {
                    InterfaceComponent.close(var58, true);
                }

                if (pleaseWaitComponent != null) {
                    InterfaceComponent.repaint(pleaseWaitComponent);
                    pleaseWaitComponent = null;
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_VARP == client.netWriter.currentIncomingPacket) {
                var6 = incoming.method1055();
                byte var43 = incoming.g1b();
                Vars.baseValues[var6] = var43;
                if (Vars.values[var6] != var43) {
                    Vars.values[var6] = var43;
                }

                OldConnection.method712(var6);
                anIntArray1076[++anInt1064 - 1 & 31] = var6;
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta182 == client.netWriter.currentIncomingPacket) {
                SubInterface.process();
                energy = incoming.g1();
                anInt1074 = anInt1075;
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.SET_COMPONENT_MODEL_TYPE3 == client.netWriter.currentIncomingPacket) {
                var6 = incoming.method1015();
                var57 = InterfaceComponent.lookup(var6);
                var57.modelType = 3;
                var57.modelId = PlayerEntity.local.model.hash();
                InterfaceComponent.repaint(var57);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.RESET_REGION_CHUNK == client.netWriter.currentIncomingPacket) {
                SceneGraph.regionChunkY = incoming.method1074();
                SceneGraph.regionChunkX = incoming.ig1();

                for (var6 = SceneGraph.regionChunkX; var6 < SceneGraph.regionChunkX + 8; ++var6) {
                    for (var5 = SceneGraph.regionChunkY; var5 < SceneGraph.regionChunkY + 8; ++var5) {
                        if (pickables[SceneGraph.floorLevel][var6][var5] != null) {
                            pickables[SceneGraph.floorLevel][var6][var5] = null;
                            Pickable.refresh(var6, var5);
                        }
                    }
                }

                for (PendingSpawn spawn = pendingSpawns.head(); spawn != null; spawn = pendingSpawns.next()) {
                    if (spawn.sceneX >= SceneGraph.regionChunkX && spawn.sceneX < SceneGraph.regionChunkX + 8 && spawn.sceneY >= SceneGraph.regionChunkY && spawn.sceneY < SceneGraph.regionChunkY + 8 && spawn.floorLevel == SceneGraph.floorLevel) {
                        spawn.hitpoints = 0;
                    }
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.PROCESS_REFLECTION_REQUEST == client.netWriter.currentIncomingPacket) {
                ClassStructure.decode(incoming);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_VARPS == client.netWriter.currentIncomingPacket) {
                for (var6 = 0; var6 < Vars.values.length; ++var6) {
                    if (Vars.baseValues[var6] != Vars.values[var6]) {
                        Vars.values[var6] = Vars.baseValues[var6];
                        OldConnection.method712(var6);
                        anIntArray1076[++anInt1064 - 1 & 31] = var6;
                    }
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta225 == client.netWriter.currentIncomingPacket) {
                relationshipSystem.ignoreListContext.decode(incoming, client.netWriter.incomingPacketSize);
                Statics11.method843();
                anInt1065 = anInt1075;
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_NPCS == client.netWriter.currentIncomingPacket) {
                NpcEntity.update(false, incoming);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_INSTANCE_REGION == client.netWriter.currentIncomingPacket) {
                PlayerAccountType.onSceneXTEAKeyChange(true, client.netWriter.inbuffer);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_COMPONENT_TEXT == client.netWriter.currentIncomingPacket) {
                var6 = incoming.method1015();
                var33 = new StringBuilder(incoming.gstr());
                var14 = InterfaceComponent.lookup(var6);
                if (!var33.toString().equals(var14.text)) {
                    var14.text = var33.toString();
                    InterfaceComponent.repaint(var14);
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta194 == client.netWriter.currentIncomingPacket) {
                var6 = incoming.g2();
                if (var6 == 65535) {
                    var6 = -1;
                }

                AudioOverrideEffect.method795(var6);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta231 == client.netWriter.currentIncomingPacket) {
                var6 = incoming.method1060();
                if (var6 == 65535) {
                    var6 = -1;
                }

                var5 = incoming.method1017();
                OutgoingPacketMeta.method5(var6);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta233 == client.netWriter.currentIncomingPacket) {
                StockMarketOfferQuantityComparator.method479(RegionUpdateType.TRANSMOGRIFY_PLAYER);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta246 == client.netWriter.currentIncomingPacket) {
                for (var6 = 0; var6 < VarDefinition.anInt568; ++var6) {
                    VarDefinition var56 = VarDefinition.get(var6);
                    if (var56 != null) {
                        Vars.baseValues[var6] = 0;
                        Vars.values[var6] = 0;
                    }
                }

                SubInterface.process();
                anInt1064 += 32;
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta188 == client.netWriter.currentIncomingPacket) {
                StockMarketOfferQuantityComparator.method479(RegionUpdateType.REMOVE_PICKABLE);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta190 == client.netWriter.currentIncomingPacket) {
                var6 = incoming.pos + client.netWriter.incomingPacketSize;
                var5 = incoming.g2();
                var7 = incoming.g2();
                if (var5 != rootInterfaceIndex) {
                    rootInterfaceIndex = var5;
                    this.method734(false);
                    InterfaceComponent.loadAnimable(rootInterfaceIndex);
                    InterfaceComponent.loadAndInitialize(rootInterfaceIndex);

                    for (var8 = 0; var8 < 100; ++var8) {
                        renderedComponents[var8] = true;
                    }
                }

                SubInterface var34;
                while (var7-- > 0) {
                    var8 = incoming.g4();
                    var9 = incoming.g2();
                    var15 = incoming.g1();
                    var34 = subInterfaces.lookup(var8);
                    if (var34 != null && var9 != var34.id) {
                        InterfaceComponent.close(var34, true);
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
                        InterfaceComponent.close(var13, true);
                    }
                }

                interfaceConfigs = new NodeTable<>(512);

                while (incoming.pos < var6) {
                    var8 = incoming.g4();
                    var9 = incoming.g2();
                    var15 = incoming.g2();
                    var16 = incoming.g4();

                    for (int var35 = var9; var35 <= var15; ++var35) {
                        var22 = (long) var35 + ((long) var8 << 32);
                        interfaceConfigs.put(new IntegerNode(var16), var22);
                    }
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta247 == client.netWriter.currentIncomingPacket) {
                var38 = incoming.gstr();
                var33 = new StringBuilder(BaseFont.method1166(OldConnection.method714(DefaultRouteStrategy.method294(incoming))));
                ChatHistory.messageReceived(6, var38, var33.toString());
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.LOGOUT == client.netWriter.currentIncomingPacket) {
                DynamicObject.method1506();
                client.netWriter.currentIncomingPacket = null;
                return false;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta196 == client.netWriter.currentIncomingPacket) {
                var6 = incoming.g2();
                var5 = incoming.g1();
                var7 = incoming.g2();
                method884(var6, var5, var7);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta249 == client.netWriter.currentIncomingPacket) {
                PlayerEntity.update(incoming, client.netWriter.incomingPacketSize);
                Archive.method485();
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta254 == client.netWriter.currentIncomingPacket) {
                StockMarketOfferQuantityComparator.method479(RegionUpdateType.SET_PICKABLE_STACK_SIZE);
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta218 == client.netWriter.currentIncomingPacket) {
                if (rootInterfaceIndex != -1) {
                    InterfaceComponent.method118(rootInterfaceIndex, 0);
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.UPDATE_REGION_CHUNK == client.netWriter.currentIncomingPacket) {
                SceneGraph.regionChunkX = incoming.ig1();
                SceneGraph.regionChunkY = incoming.g1();

                while (incoming.pos < client.netWriter.incomingPacketSize) {
                    var6 = incoming.g1();
                    RegionUpdateType var55 = RegionUpdateType.values()[var6];
                    StockMarketOfferQuantityComparator.method479(var55);
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta223 == client.netWriter.currentIncomingPacket) {
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

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.SET_DESTINATION == client.netWriter.currentIncomingPacket) {
                destinationX = incoming.g1();
                if (destinationX == 255) {
                    destinationX = 0;
                }

                destinationY = incoming.g1();
                if (destinationY == 255) {
                    destinationY = 0;
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta234 == client.netWriter.currentIncomingPacket) {
                publicChatPrivacyMode = ChatModePrivacyType.valueOf(incoming.g1());
                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta177 == client.netWriter.currentIncomingPacket) {
                var42 = incoming.gbool();
                if (var42) {
                    if (WorldMap.heatmap == null) {
                        WorldMap.heatmap = new WorldMapHeatMap();
                    }
                } else {
                    WorldMap.heatmap = null;
                }

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            if (IncomingPacketMeta.anIncomingPacketMeta241 == client.netWriter.currentIncomingPacket) {
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

                client.netWriter.currentIncomingPacket = null;
                return true;
            }

            sendError("" + (client.netWriter.currentIncomingPacket != null ? client.netWriter.currentIncomingPacket.opcode : -1) + "," + (client.netWriter.secondLastIncomingPacket != null ? client.netWriter.secondLastIncomingPacket.opcode : -1) + "," + (client.netWriter.thirdLastIncomingPacket != null ? client.netWriter.thirdLastIncomingPacket.opcode : -1) + "," + client.netWriter.incomingPacketSize, null);
            DynamicObject.method1506();
        } catch (IOException var36) {
            dropConnection();
        } catch (Exception var37) {
            var33 = new StringBuilder("" + (client.netWriter.currentIncomingPacket != null ? client.netWriter.currentIncomingPacket.opcode : -1) + "," + (client.netWriter.secondLastIncomingPacket != null ? client.netWriter.secondLastIncomingPacket.opcode : -1) + "," + (client.netWriter.thirdLastIncomingPacket != null ? client.netWriter.thirdLastIncomingPacket.opcode : -1) + "," + client.netWriter.incomingPacketSize + "," + (PlayerEntity.local.pathXQueue[0] + baseX) + "," + (PlayerEntity.local.pathYQueue[0] + baseY) + ",");

            for (var7 = 0; var7 < client.netWriter.incomingPacketSize && var7 < 50; ++var7) {
                var33.append(incoming.payload[var7]).append(",");
            }

            sendError(var33.toString(), var37);
            DynamicObject.method1506();
        }

        return true;
    }

    void method738() {
        if (Js5Worker.mismatchedCrcCount >= 4) {
            this.error("js5crc");
            gameState = 1000;
        } else {
            if (Js5Worker.ioExceptionCount >= 4) {
                if (gameState <= 5) {
                    this.error("js5io");
                    gameState = 1000;
                    return;
                }

                js5Cycles = 3000;
                Js5Worker.ioExceptionCount = 3;
            }

            if (--js5Cycles + 1 <= 0) {
                try {
                    if (js5State == 0) {
                        Login.js5task = taskProcessor.create(LoginStep.currentDomain, NpcEntity.port);
                        ++js5State;
                    }

                    if (js5State == 1) {
                        if (Login.js5task.state == 2) {
                            this.js5error(-1);
                            return;
                        }

                        if (Login.js5task.state == 1) {
                            ++js5State;
                        }
                    }

                    if (js5State == 2) {
                        if (usingBufferedConnection) {
                            Socket socket = (Socket) Login.js5task.result;
                            Statics48.js5connection = new AsyncConnection(socket, 40000, 5000);
                        } else {
                            Statics48.js5connection = new OldConnection((Socket) Login.js5task.result, taskProcessor, 5000);
                        }

                        Buffer var5 = new Buffer(5);
                        var5.p1(15);
                        var5.p4(184);
                        Statics48.js5connection.write(var5.payload, 0, 5);
                        ++js5State;
                        VAlign.aLong1478 = Clock.now();
                    }

                    if (js5State == 3) {
                        if (Statics48.js5connection.available() > 0 || !usingBufferedConnection && gameState <= 5) {
                            int var3 = Statics48.js5connection.read();
                            if (var3 != 0) {
                                this.js5error(var3);
                                return;
                            }

                            ++js5State;
                        } else if (Clock.now() - VAlign.aLong1478 > 30000L) {
                            this.js5error(-2);
                            return;
                        }
                    }

                    if (js5State == 4) {
                        Connection.method420(Statics48.js5connection, gameState > 20);
                        Login.js5task = null;
                        Statics48.js5connection = null;
                        js5State = 0;
                        js5ErrorCount = 0;
                    }
                } catch (IOException var4) {
                    this.js5error(-3);
                }

            }
        }
    }

    public final void openMenu(int var1, int var2) {
        ContextMenu.open(var1, var2);
        sceneGraph.method1451(SceneGraph.floorLevel, var1, var2, false);
        ContextMenu.open = true;
    }

    protected final void cycle() {
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
                    if (AudioSystem.state == 1) {
                        var4 = Statics50.aClass5_Sub6_Sub3_326.method770();
                        if (var4 > 0 && Statics50.aClass5_Sub6_Sub3_326.method684()) {
                            var4 -= AudioSystem.pcmSampleLength;
                            if (var4 < 0) {
                                var4 = 0;
                            }

                            Statics50.aClass5_Sub6_Sub3_326.method703(var4);
                        } else {
                            Statics50.aClass5_Sub6_Sub3_326.method756();
                            Statics50.aClass5_Sub6_Sub3_326.method592();
                            if (AudioSystem.tracks != null) {
                                AudioSystem.state = 2;
                            } else {
                                AudioSystem.state = 0;
                            }

                            Statics57.anAudioTrack1158 = null;
                            FriendLoginUpdate.aClass97_668 = null;
                        }
                    }
                } catch (Exception var9) {
                    var9.printStackTrace();
                    Statics50.aClass5_Sub6_Sub3_326.method756();
                    AudioSystem.state = 0;
                    Statics57.anAudioTrack1158 = null;
                    FriendLoginUpdate.aClass97_668 = null;
                    AudioSystem.tracks = null;
                }

                AudioSystem.process();
                synchronized (Keyboard.instance) {
                    Keyboard.idleTime++;
                    Keyboard.anInt157 = Keyboard.anInt162;
                    Keyboard.pressedKeysCount = 0;
                    int var5;
                    if (Keyboard.meta >= 0) {
                        while (Keyboard.meta != Keyboard.pendingMeta) {
                            int index = Keyboard.anIntArray154[Keyboard.pendingMeta];
                            Keyboard.pendingMeta = Keyboard.pendingMeta + 1 & 0x7f;
                            if (index < 0) {
                                Keyboard.heldKeys[~index] = false;
                            } else {
                                if (!Keyboard.heldKeys[index] && Keyboard.pressedKeysCount < Keyboard.anIntArray147.length - 1) {
                                    Keyboard.anIntArray147[Keyboard.pressedKeysCount++] = index;
                                }

                                Keyboard.heldKeys[index] = true;
                            }
                        }
                    } else {
                        for (int i = 0; i < 112; i++) {
                            Keyboard.heldKeys[i] = false;
                        }

                        Keyboard.meta = Keyboard.pendingMeta;
                    }

                    if (Keyboard.pressedKeysCount > 0) {
                        Keyboard.idleTime = 0;
                    }

                    Keyboard.anInt162 = Keyboard.anInt153;
                }

                Mouse.process();
                if (MouseWheel.provider != null) {
                    var4 = MouseWheel.provider.getAndReset();
                    mouseWheelPtr = var4;
                }

                if (gameState == 0) {
                    Login.processLoadingScreen();
                    GameShell.updateClock();
                } else if (gameState == 5) {
                    Login.processLoginScreen();
                    Login.processLoadingScreen();
                    GameShell.updateClock();
                } else if (gameState != 10 && gameState != 11) {
                    if (gameState == 20) {
                        Login.processLoginScreen();
                        processConnect();
                    } else if (gameState == 25) {
                        SceneGraph.load();
                    }
                } else {
                    Login.processLoginScreen();
                }

                if (gameState == 30) {
                    processPackets();
                } else if (gameState == 40 || gameState == 45) {
                    processConnect();
                }

                return;
            }

            var2.archive.method486(var2.cache, (int) var2.key, var2.data, false);
        }
    }

    public final void method729() {
        if (rootInterfaceIndex != -1) {
            int root = rootInterfaceIndex;
            if (InterfaceComponent.load(root)) {
                InterfaceComponent.method513(interfaces[root], -1);
            }
        }

        for (int i = 0; i < renderedComponentCount; ++i) {
            if (renderedComponents[i]) {
                aBooleanArray1087[i] = true;
            }

            aBooleanArray1083[i] = renderedComponents[i];
            renderedComponents[i] = false;
        }

        anInt1084 = engineCycle;
        anInt1039 = -1;
        anInt1038 = -1;
        DefaultAudioSystemProvider.processingItemComponent = null;
        if (rootInterfaceIndex != -1) {
            renderedComponentCount = 0;
            InterfaceComponent.renderInterface(rootInterfaceIndex, 0, 0, canvasWidth, canvasHeight, 0, 0, -1);
        }

        JagGraphics.resetDrawingArea();
        if (ContextMenu.Crosshair.display) {
            if (ContextMenu.Crosshair.state == 1) {
                HintArrow.sprites[HintArrow.state * 400 / 100].renderAlphaAt(ContextMenu.Crosshair.x - 8, ContextMenu.Crosshair.y - 8);
            }

            if (ContextMenu.Crosshair.state == 2) {
                HintArrow.sprites[HintArrow.state * 400 / 100 + 4].renderAlphaAt(ContextMenu.Crosshair.x - 8, ContextMenu.Crosshair.y - 8);
            }
        }

        if (!ContextMenu.open) {
            if (anInt1039 != -1) {
                int var1 = anInt1039;
                int var2 = anInt1038;
                if ((ContextMenu.rowCount >= 2 || ComponentSelection.Item.state != 0 || ComponentSelection.Spell.state) && aBoolean1043) {
                    int var3 = AssociateComparatorByRank.getMaximumMenuRowIndex();
                    String var4;
                    if (ComponentSelection.Item.state == 1 && ContextMenu.rowCount < 2) {
                        var4 = "Use" + " " + ComponentSelection.Item.name + " " + "->";
                    } else if (ComponentSelection.Spell.state && ContextMenu.rowCount < 2) {
                        var4 = ComponentSelection.action + " " + ComponentSelection.Spell.name + " " + "->";
                    } else {
                        var4 = ContextMenu.getRowText(var3);
                    }

                    if (ContextMenu.rowCount > 2) {
                        var4 = var4 + getColorTags(16777215) + " " + '/' + " " + (ContextMenu.rowCount - 2) + " more options";
                    }

                    Statics7.fontb12full.method1142(var4, var1 + 4, var2 + 15, 16777215, 0, engineCycle / 1000);
                }
            }
        } else {
            int x = ContextMenu.x;
            int y = ContextMenu.y;
            int w = ContextMenu.width;
            int h = ContextMenu.height;
            int col = 6116423;
            JagGraphics.fillRect(x, y, w, h, col);
            JagGraphics.fillRect(x + 1, y + 1, w - 2, 16, 0);
            JagGraphics.method1372(x + 1, y + 18, w - 2, h - 19, 0);
            Statics7.fontb12full.drawString("Choose Option", x + 3, y + 14, col, -1);
            int var7 = Mouse.x;
            int var8 = Mouse.y;

            for (int i = 0; i < ContextMenu.rowCount; ++i) {
                int endX = y + (ContextMenu.rowCount - 1 - i) * 15 + 31;
                int endY = 16777215;
                if (var7 > x && var7 < w + x && var8 > endX - 13 && var8 < endX + 3) {
                    endY = 16776960;
                }

                Statics7.fontb12full.drawString(ContextMenu.getRowText(i), x + 3, endX, endY, 0);
            }

            int var9 = ContextMenu.x;
            int var10 = ContextMenu.y;
            int var11 = ContextMenu.width;
            int var12 = ContextMenu.height;

            for (int i = 0; i < renderedComponentCount; ++i) {
                if (interfacePositionsX[i] + interfaceWidths[i] > var9 && interfacePositionsX[i] < var11 + var9 && interfaceHeights[i] + interfacePositionsY[i] > var10 && interfacePositionsY[i] < var10 + var12) {
                    aBooleanArray1087[i] = true;
                }
            }
        }

        if (redrawMode == 3) {
            for (int i = 0; i < renderedComponentCount; ++i) {
                if (aBooleanArray1083[i]) {
                    JagGraphics.method1370(interfacePositionsX[i], interfacePositionsY[i], interfaceWidths[i], interfaceHeights[i], 16711935, 128);
                } else if (aBooleanArray1087[i]) {
                    JagGraphics.method1370(interfacePositionsX[i], interfacePositionsY[i], interfaceWidths[i], interfaceHeights[i], 16711680, 128);
                }
            }
        }

        SerializableProcessor.method456(SceneGraph.floorLevel, PlayerEntity.local.absoluteX, PlayerEntity.local.absoluteY, anInt972);
        anInt972 = 0;
    }

    protected final void draw(boolean drawing) {
        boolean var2;
        label168:
        {
            try {
                if (AudioSystem.state == 2) {
                    if (Statics57.anAudioTrack1158 == null) {
                        Statics57.anAudioTrack1158 = AudioTrack.load(AudioSystem.tracks, AudioSystem.trackGroup, AudioSystem.trackFile);
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
                        Statics50.aClass5_Sub6_Sub3_326.method703(AudioSystem.volume);
                        Statics50.aClass5_Sub6_Sub3_326.method766(Statics57.anAudioTrack1158, AudioSystem.aBoolean620);
                        AudioSystem.state = 0;
                        Statics57.anAudioTrack1158 = null;
                        FriendLoginUpdate.aClass97_668 = null;
                        AudioSystem.tracks = null;
                        var2 = true;
                        break label168;
                    }
                }
            } catch (Exception var6) {
                var6.printStackTrace();
                Statics50.aClass5_Sub6_Sub3_326.method756();
                AudioSystem.state = 0;
                Statics57.anAudioTrack1158 = null;
                FriendLoginUpdate.aClass97_668 = null;
                AudioSystem.tracks = null;
            }

            var2 = false;
        }

        if (var2 && aBoolean904 && AudioSystem.anAudioSystem1236 != null) {
            AudioSystem.anAudioSystem1236.method1333();
        }

        if ((gameState == 10 || gameState == 20 || gameState == 30) && 0L != aLong1081 && Clock.now() > aLong1081) {
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
            Login.draw(Statics7.fontb12full, StockMarketOfferWorldComparator.aFont345, BootSprites.font_p12full);
        } else if (gameState != 10 && gameState != 11) {
            if (gameState == 20) {
                Login.draw(Statics7.fontb12full, StockMarketOfferWorldComparator.aFont345, BootSprites.font_p12full);
            } else if (gameState == 25) {
                if (loadingDrawState == 1) {
                    if (loadingIndicator1 > loadingIndicator2) {
                        loadingIndicator2 = loadingIndicator1;
                    }

                    var5 = (loadingIndicator2 * 50 - loadingIndicator1 * 50) / loadingIndicator2;
                    WorldMapElement.method242("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
                } else if (loadingDrawState == 2) {
                    if (loadingIndicator3 > loadingIndicator4) {
                        loadingIndicator4 = loadingIndicator3;
                    }

                    var5 = (loadingIndicator4 * 50 - loadingIndicator3 * 50) / loadingIndicator4 + 50;
                    WorldMapElement.method242("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
                } else {
                    WorldMapElement.method242("Loading - please wait.", false);
                }
            } else if (gameState == 30) {
                this.method729();
            } else if (gameState == 40) {
                WorldMapElement.method242("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
            } else if (gameState == 45) {
                WorldMapElement.method242("Please wait...", false);
            }
        } else {
            Login.draw(Statics7.fontb12full, StockMarketOfferWorldComparator.aFont345, BootSprites.font_p12full);
        }

        if (gameState == 30 && redrawMode == 0 && !drawing && !resizableMode) {
            for (var5 = 0; var5 < renderedComponentCount; ++var5) {
                if (aBooleanArray1087[var5]) {
                    graphicsProvider.method20(interfacePositionsX[var5], interfacePositionsY[var5], interfaceWidths[var5], interfaceHeights[var5]);
                    aBooleanArray1087[var5] = false;
                }
            }
        } else if (gameState > 0) {
            graphicsProvider.drawGame(0, 0);

            for (var5 = 0; var5 < renderedComponentCount; ++var5) {
                aBooleanArray1087[var5] = false;
            }
        }

    }

    protected final void method737() {
        aLong1081 = Clock.now() + 500L;
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

    public final void processPackets() {
        if (rebootTimer > 1) {
            --rebootTimer;
        }

        if (logoutTimer > 0) {
            --logoutTimer;
        }

        if (pendingDisconnect) {
            pendingDisconnect = false;
            dropConnection();
        } else {
            if (!ContextMenu.open) {
                ContextMenuBuilder.insertCancelItem();
            }

            for (int i = 0; i < 100 && processIncomingPacket(); ++i) {
            }

            if (gameState == 30) {
                while (true) {
                    ClassStructure var2 = ClassStructure.list.head();
                    boolean var29;
                    var29 = var2 != null;

                    int offset;
                    OutgoingPacket packet;
                    if (!var29) {
                        OutgoingPacket var4;
                        int var5;
                        if (gameStateEvents.aBoolean1525) {
                            var4 = OutgoingPacket.prepare(OutgoingPacketMeta.GAME_STATE_EVENT_REQUEST, netWriter.encryptor);
                            var4.buffer.p1(0);
                            var5 = var4.buffer.pos;
                            gameStateEvents.writeTo(var4.buffer);
                            var4.buffer.psize1(var4.buffer.pos - var5);
                            netWriter.writeLater(var4);
                            gameStateEvents.method1118();
                        }

                        int var6;
                        int var7;
                        int var8;
                        int var9;
                        int var10;
                        int var11;
                        int xd;
                        int yd;
                        int td;
                        synchronized (mouseRecorder.lock) {
                            if (!lockMouseRecorder) {
                                mouseRecorder.caret = 0;
                            } else if (Mouse.clickMeta != 0 || mouseRecorder.caret >= 40) {
                                packet = null;
                                offset = 0;
                                var6 = 0;
                                var7 = 0;
                                var8 = 0;

                                for (var9 = 0; var9 < mouseRecorder.caret && (packet == null || packet.buffer.pos - offset < 246); ++var9) {
                                    var6 = var9;
                                    var10 = mouseRecorder.ys[var9];
                                    if (var10 < -1) {
                                        var10 = -1;
                                    } else if (var10 > 65534) {
                                        var10 = 65534;
                                    }

                                    var11 = mouseRecorder.xs[var9];
                                    if (var11 < -1) {
                                        var11 = -1;
                                    } else if (var11 > 65534) {
                                        var11 = 65534;
                                    }

                                    if (var11 != lastMouseRecordX || var10 != lastMouseRecordY) {
                                        if (packet == null) {
                                            packet = OutgoingPacket.prepare(OutgoingPacketMeta.MOUSE_MOTION_RECORD, netWriter.encryptor);
                                            packet.buffer.p1(0);
                                            offset = packet.buffer.pos;
                                            packet.buffer.pos += 2;
                                            var7 = 0;
                                            var8 = 0;
                                        }

                                        if (lastMouseRecordTime != -1L) {
                                            xd = var11 - lastMouseRecordX;
                                            yd = var10 - lastMouseRecordY;
                                            td = (int) ((mouseRecorder.times[var9] - lastMouseRecordTime) / 20L);
                                            var7 = (int) ((long) var7 + (mouseRecorder.times[var9] - lastMouseRecordTime) % 20L);
                                        } else {
                                            xd = var11;
                                            yd = var10;
                                            td = Integer.MAX_VALUE;
                                        }

                                        lastMouseRecordX = var11;
                                        lastMouseRecordY = var10;
                                        if (td < 8 && xd >= -32 && xd <= 31 && yd >= -32 && yd <= 31) {
                                            xd += 32;
                                            yd += 32;
                                            packet.buffer.p2((td << 12) + yd + (xd << 6));
                                        } else if (td < 32 && xd >= -128 && xd <= 127 && yd >= -128 && yd <= 127) {
                                            xd += 128;
                                            yd += 128;
                                            packet.buffer.p1(td + 128);
                                            packet.buffer.p2(yd + (xd << 8));
                                        } else if (td < 32) {
                                            packet.buffer.p1(td + 192);
                                            if (var11 != -1 && var10 != -1) {
                                                packet.buffer.p4(var11 | var10 << 16);
                                            } else {
                                                packet.buffer.p4(Integer.MIN_VALUE);
                                            }
                                        } else {
                                            packet.buffer.p2((td & 0x1fff) + 0xe000);
                                            if (var11 != -1 && var10 != -1) {
                                                packet.buffer.p4(var11 | (var10 << 16));
                                            } else {
                                                packet.buffer.p4(Integer.MIN_VALUE);
                                            }
                                        }

                                        ++var8;
                                        lastMouseRecordTime = mouseRecorder.times[var9];
                                    }
                                }

                                if (packet != null) {
                                    packet.buffer.psize1(packet.buffer.pos - offset);
                                    var9 = packet.buffer.pos;
                                    packet.buffer.pos = offset;
                                    packet.buffer.p1(var7 / var8);
                                    packet.buffer.p1(var7 % var8);
                                    packet.buffer.pos = var9;
                                    netWriter.writeLater(packet);
                                }

                                if (var6 >= mouseRecorder.caret) {
                                    mouseRecorder.caret = 0;
                                } else {
                                    MouseRecorder var42 = mouseRecorder;
                                    var42.caret -= var6;
                                    System.arraycopy(mouseRecorder.xs, var6, mouseRecorder.xs, 0, mouseRecorder.caret);
                                    System.arraycopy(mouseRecorder.ys, var6, mouseRecorder.ys, 0, mouseRecorder.caret);
                                    System.arraycopy(mouseRecorder.times, var6, mouseRecorder.times, 0, mouseRecorder.caret);
                                }
                            }
                        }

                        if (Mouse.clickMeta == 1 || !WorldMapObjectIcon.mouseCameraEnabled && Mouse.clickMeta == 4 || Mouse.clickMeta == 2) {
                            long clickTimeDelta = (Mouse.timeOfClick - timeOfPreviousClick * -1L) / 50L;
                            if (clickTimeDelta > 4095L) {
                                clickTimeDelta = 4095L;
                            }

                            timeOfPreviousClick = Mouse.timeOfClick * -1L;
                            int y = Mouse.clickY;
                            if (y < 0) {
                                y = 0;
                            } else if (y > canvasHeight) {
                                y = canvasHeight;
                            }

                            int x = Mouse.clickX;
                            if (x < 0) {
                                x = 0;
                            } else if (x > canvasWidth) {
                                x = canvasWidth;
                            }

                            int compressedClickTimeDelta = (int) clickTimeDelta;
                            OutgoingPacket outgoing = OutgoingPacket.prepare(OutgoingPacketMeta.MOUSE_ACTION, netWriter.encryptor);
                            outgoing.buffer.p2((Mouse.clickMeta == 2 ? 1 : 0) + (compressedClickTimeDelta << 1));
                            outgoing.buffer.p2(x);
                            outgoing.buffer.p2(y);
                            netWriter.writeLater(outgoing);
                        }

                        if (Keyboard.pressedKeysCount > 0) {
                            OutgoingPacket outgoing = OutgoingPacket.prepare(OutgoingPacketMeta.KEYBOARD_INFO, netWriter.encryptor);
                            outgoing.buffer.p2(0);
                            int startOffset = outgoing.buffer.pos;
                            long time = Clock.now();

                            for (int i = 0; i < Keyboard.pressedKeysCount; ++i) {
                                long timeOffset = time - aLong1095;
                                if (timeOffset > 16777215L) {
                                    timeOffset = 16777215L;
                                }

                                aLong1095 = time;
                                outgoing.buffer.ip3((int) timeOffset);
                                outgoing.buffer.writeByteS(Keyboard.anIntArray147[i]);
                            }

                            outgoing.buffer.psize2(outgoing.buffer.pos - startOffset);
                            netWriter.writeLater(outgoing);
                        }

                        if (cameraMovementPacketIndicator > 0) {
                            --cameraMovementPacketIndicator;
                        }

                        if (Keyboard.heldKeys[96] || Keyboard.heldKeys[97] || Keyboard.heldKeys[98] || Keyboard.heldKeys[99]) {
                            emitCameraMovementPackets = true;
                        }

                        if (emitCameraMovementPackets && cameraMovementPacketIndicator <= 0) {
                            cameraMovementPacketIndicator = 20;
                            emitCameraMovementPackets = false;
                            var4 = OutgoingPacket.prepare(OutgoingPacketMeta.CAMERA_DATA, netWriter.encryptor);
                            var4.buffer.ip2a(cameraX);
                            var4.buffer.ip2(cameraY);
                            netWriter.writeLater(var4);
                        }

                        if (OldConnectionTaskProcessor.hasFocus && !previousFocusState) {
                            previousFocusState = true;
                            var4 = OutgoingPacket.prepare(OutgoingPacketMeta.FOCUS_INFO, netWriter.encryptor);
                            var4.buffer.p1(1);
                            netWriter.writeLater(var4);
                        }

                        if (!OldConnectionTaskProcessor.hasFocus && previousFocusState) {
                            previousFocusState = false;
                            var4 = OutgoingPacket.prepare(OutgoingPacketMeta.FOCUS_INFO, netWriter.encryptor);
                            var4.buffer.p1(0);
                            netWriter.writeLater(var4);
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
                        ++netWriter.idleReadTicks;
                        if (netWriter.idleReadTicks > 750) {
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
                            offset = npcIndices[var5];
                            NpcEntity var24 = npcs[offset];
                            if (var24 != null && var24.anInt1344 > 0) {
                                --var24.anInt1344;
                                if (var24.anInt1344 == 0) {
                                    var24.overheadText = null;
                                }
                            }
                        }

                        ++anInt972;
                        if (ContextMenu.Crosshair.state != 0) {
                            HintArrow.state = HintArrow.state + 20;
                            if (HintArrow.state >= 400) {
                                ContextMenu.Crosshair.state = 0;
                            }
                        }

                        if (StockMarketOfferWorldComparator.anInterfaceComponent351 != null) {
                            ++anInt1018;
                            if (anInt1018 >= 15) {
                                InterfaceComponent.repaint(StockMarketOfferWorldComparator.anInterfaceComponent351);
                                StockMarketOfferWorldComparator.anInterfaceComponent351 = null;
                            }
                        }

                        InterfaceComponent var34 = OldConnection.hoveredComponent;
                        InterfaceComponent var31 = Statics24.anInterfaceComponent1417;
                        OldConnection.hoveredComponent = null;
                        Statics24.anInterfaceComponent1417 = null;
                        draggedSpecialComponent = null;
                        processingComponentDrag = false;
                        processingComponentDragTopLevel = false;
                        anInt1092 = 0;

                        while (Keyboard.isKeyHeld() && anInt1092 < 128) {
                            if (rights >= 2 && Keyboard.heldKeys[82] && SecureRandomService.anInt457 == 66) {
                                String var39 = method9();
                                instance.copyToClipboard(var39);
                            } else if (oculusOrbState != 1 || Keyboard.aChar151 <= 0) {
                                anIntArray1096[anInt1092] = SecureRandomService.anInt457;
                                anIntArray1097[anInt1092] = Keyboard.aChar151;
                                ++anInt1092;
                            }
                        }

                        boolean jmod = rights >= 2;
                        if (jmod && Keyboard.heldKeys[82] && Keyboard.heldKeys[81] && mouseWheelPtr != 0) {
                            var6 = PlayerEntity.local.floorLevel - mouseWheelPtr;
                            if (var6 < 0) {
                                var6 = 0;
                            } else if (var6 > 3) {
                                var6 = 3;
                            }

                            if (var6 != PlayerEntity.local.floorLevel) {
                                Statics35.teleport(PlayerEntity.local.pathXQueue[0] + baseX, PlayerEntity.local.pathYQueue[0] + baseY, var6, false);
                            }

                            mouseWheelPtr = 0;
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
                                                                worldMap.method1261(SceneGraph.floorLevel, baseX + (PlayerEntity.local.absoluteX >> 7), baseY + (PlayerEntity.local.absoluteY >> 7), false);
                                                                worldMap.method1225();
                                                            }

                                                            if (draggedComponent != null) {
                                                                this.method732();
                                                            }

                                                            if (AnimationFrameGroup.dragComponent != null) {
                                                                InterfaceComponent.repaint(AnimationFrameGroup.dragComponent);
                                                                ++componentDragCycles;
                                                                if (Mouse.pressMeta == 0) {
                                                                    if (draggingComponent) {
                                                                        if (AnimationFrameGroup.dragComponent == DefaultAudioSystemProvider.processingItemComponent && draggingComponentIndex != draggingComponentSourceIndex) {
                                                                            InterfaceComponent var41 = AnimationFrameGroup.dragComponent;
                                                                            byte var35 = 0;
                                                                            if (anInt1054 == 1 && var41.contentType == 206) {
                                                                                var35 = 1;
                                                                            }

                                                                            if (var41.itemIds[draggingComponentIndex] <= 0) {
                                                                                var35 = 0;
                                                                            }

                                                                            if (WorldMapAreaChunk_Sub3.method367(InterfaceComponent.getConfig(var41))) {
                                                                                var8 = draggingComponentSourceIndex;
                                                                                var9 = draggingComponentIndex;
                                                                                var41.itemIds[var9] = var41.itemIds[var8];
                                                                                var41.itemStackSizes[var9] = var41.itemStackSizes[var8];
                                                                                var41.itemIds[var8] = -1;
                                                                                var41.itemStackSizes[var8] = 0;
                                                                            } else if (var35 == 1) {
                                                                                var8 = draggingComponentSourceIndex;
                                                                                var9 = draggingComponentIndex;

                                                                                while (var9 != var8) {
                                                                                    if (var8 > var9) {
                                                                                        var41.swapItem(var8 - 1, var8);
                                                                                        --var8;
                                                                                    } else if (var8 < var9) {
                                                                                        var41.swapItem(var8 + 1, var8);
                                                                                        ++var8;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                var41.swapItem(draggingComponentIndex, draggingComponentSourceIndex);
                                                                            }

                                                                            OutgoingPacket outgoing = OutgoingPacket.prepare(OutgoingPacketMeta.DRAG_ITEM, netWriter.encryptor);
                                                                            outgoing.buffer.pirf4(AnimationFrameGroup.dragComponent.uid);
                                                                            outgoing.buffer.p2(draggingComponentIndex);
                                                                            outgoing.buffer.p1(var35);
                                                                            outgoing.buffer.ip2(draggingComponentSourceIndex);
                                                                            netWriter.writeLater(outgoing);
                                                                        }
                                                                    } else if (this.method731()) {
                                                                        this.openMenu(draggingComponentX, draggingComponentY);
                                                                    } else if (ContextMenu.rowCount > 0) {
                                                                        SerializableProcessor.method459(draggingComponentX, draggingComponentY);
                                                                    }

                                                                    anInt1018 = 10;
                                                                    Mouse.clickMeta = 0;
                                                                    AnimationFrameGroup.dragComponent = null;
                                                                } else if (componentDragCycles >= 5 && (Mouse.x > draggingComponentX + 5 || Mouse.x < draggingComponentX - 5 || Mouse.y > draggingComponentY + 5 || Mouse.y < draggingComponentY - 5)) {
                                                                    draggingComponent = true;
                                                                }
                                                            }

                                                            if (SceneGraph.isMovementPending()) {
                                                                var6 = SceneGraph.pendingDestinationX;
                                                                var7 = SceneGraph.pendingDestinationY;
                                                                OutgoingPacket outgoing = OutgoingPacket.prepare(OutgoingPacketMeta.PROCESS_MOVEMENT, netWriter.encryptor);
                                                                outgoing.buffer.p1(5);
                                                                outgoing.buffer.ip2a(baseX + var6);
                                                                outgoing.buffer.ip2(baseY + var7);
                                                                outgoing.buffer.p1n(Keyboard.heldKeys[82] ? (Keyboard.heldKeys[81] ? 2 : 1) : 0);
                                                                netWriter.writeLater(outgoing);
                                                                SceneGraph.unsetPendingMovement();
                                                                ContextMenu.Crosshair.x = Mouse.clickX;
                                                                ContextMenu.Crosshair.y = Mouse.clickY;
                                                                ContextMenu.Crosshair.state = 1;
                                                                HintArrow.state = 0;
                                                                destinationX = var6;
                                                                destinationY = var7;
                                                            }

                                                            if (var34 != OldConnection.hoveredComponent) {
                                                                if (var34 != null) {
                                                                    InterfaceComponent.repaint(var34);
                                                                }

                                                                if (OldConnection.hoveredComponent != null) {
                                                                    InterfaceComponent.repaint(OldConnection.hoveredComponent);
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

                                                            if (oculusOrbState == 0) {
                                                                var6 = PlayerEntity.local.absoluteX;
                                                                var7 = PlayerEntity.local.absoluteY;
                                                                if (ObjectSound.oculusOrbAbsoluteX - var6 < -500 || ObjectSound.oculusOrbAbsoluteX - var6 > 500 || Statics52.oculusOrbAbsoluteY - var7 < -500 || Statics52.oculusOrbAbsoluteY - var7 > 500) {
                                                                    ObjectSound.oculusOrbAbsoluteX = var6;
                                                                    Statics52.oculusOrbAbsoluteY = var7;
                                                                }

                                                                if (var6 != ObjectSound.oculusOrbAbsoluteX) {
                                                                    ObjectSound.oculusOrbAbsoluteX += (var6 - ObjectSound.oculusOrbAbsoluteX) / 16;
                                                                }

                                                                if (var7 != Statics52.oculusOrbAbsoluteY) {
                                                                    Statics52.oculusOrbAbsoluteY += (var7 - Statics52.oculusOrbAbsoluteY) / 16;
                                                                }

                                                                var8 = ObjectSound.oculusOrbAbsoluteX >> 7;
                                                                var9 = Statics52.oculusOrbAbsoluteY >> 7;
                                                                var10 = SceneGraph.getTileHeight(ObjectSound.oculusOrbAbsoluteX, Statics52.oculusOrbAbsoluteY, SceneGraph.floorLevel);
                                                                var11 = 0;
                                                                if (var8 > 3 && var9 > 3 && var8 < 100 && var9 < 100) {
                                                                    for (xd = var8 - 4; xd <= var8 + 4; ++xd) {
                                                                        for (yd = var9 - 4; yd <= var9 + 4; ++yd) {
                                                                            td = SceneGraph.floorLevel;
                                                                            if (td < 3 && (Statics45.sceneRenderRules[1][xd][yd] & 2) == 2) {
                                                                                ++td;
                                                                            }

                                                                            int var26 = var10 - Statics45.tileHeights[td][xd][yd];
                                                                            if (var26 > var11) {
                                                                                var11 = var26;
                                                                            }
                                                                        }
                                                                    }
                                                                }

                                                                xd = var11 * 192;
                                                                if (xd > 98048) {
                                                                    xd = 98048;
                                                                }

                                                                if (xd < 32768) {
                                                                    xd = 32768;
                                                                }

                                                                if (xd > anInt1008) {
                                                                    anInt1008 += (xd - anInt1008) / 24;
                                                                } else if (xd < anInt1008) {
                                                                    anInt1008 += (xd - anInt1008) / 80;
                                                                }

                                                                Statics3.anInt802 = SceneGraph.getTileHeight(PlayerEntity.local.absoluteX, PlayerEntity.local.absoluteY, SceneGraph.floorLevel) - cameraFollowHeight;
                                                            } else if (oculusOrbState == 1) {
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
                                                                    var8 = Keyboard.heldKeys[81] ? oculusOrbSlowSpeed : oculusOrbSpeed;
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
                                                                        var6 = anInt986 - SceneGraph.cameraYaw & 2047;
                                                                        var10 = JagGraphics3D.SIN_TABLE[var6];
                                                                        var11 = JagGraphics3D.COS_TABLE[var6];
                                                                        ObjectSound.oculusOrbAbsoluteX += var10 * var9 / 65536;
                                                                        Statics52.oculusOrbAbsoluteY += var9 * var11 / 65536;
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
                                                                    netWriter.writeLater(OutgoingPacket.prepare(OutgoingPacketMeta.CLOSE_OCULUS_ORB, netWriter.encryptor));
                                                                    oculusOrbState = 0;
                                                                }
                                                            }

                                                            if (Mouse.pressMeta == 4 && WorldMapObjectIcon.mouseCameraEnabled) {
                                                                var6 = Mouse.y - mouseCameraDragY;
                                                                cameraYDiff = var6 * 2;
                                                                mouseCameraDragY = var6 != -1 && var6 != 1 ? (mouseCameraDragY + Mouse.y) / 2 : Mouse.y;
                                                                var7 = mouseCameraDragX - Mouse.x;
                                                                cameraXDiff = var7 * 2;
                                                                mouseCameraDragX = var7 != -1 && var7 != 1 ? (Mouse.x + mouseCameraDragX) / 2 : Mouse.x;
                                                            } else {
                                                                if (Keyboard.heldKeys[96]) {
                                                                    cameraXDiff += (-24 - cameraXDiff) / 2;
                                                                } else if (Keyboard.heldKeys[97]) {
                                                                    cameraXDiff += (24 - cameraXDiff) / 2;
                                                                } else {
                                                                    cameraXDiff /= 2;
                                                                }

                                                                if (Keyboard.heldKeys[98]) {
                                                                    cameraYDiff += (12 - cameraYDiff) / 2;
                                                                } else if (Keyboard.heldKeys[99]) {
                                                                    cameraYDiff += (-12 - cameraYDiff) / 2;
                                                                } else {
                                                                    cameraYDiff /= 2;
                                                                }

                                                                mouseCameraDragY = Mouse.y;
                                                                mouseCameraDragX = Mouse.x;
                                                            }

                                                            cameraY = cameraXDiff / 2 + cameraY & 2047;
                                                            cameraX += cameraYDiff / 2;
                                                            if (cameraX < 128) {
                                                                cameraX = 128;
                                                            }

                                                            if (cameraX > 383) {
                                                                cameraX = 383;
                                                            }

                                                            if (cameraLocked) {
                                                                SceneGraph.method517();
                                                            }

                                                            for (var6 = 0; var6 < 5; ++var6) {
                                                                int var10002 = anIntArray916[var6]++;
                                                            }

                                                            varcs.updateIfRequired();

                                                            int mouseIdle = Mouse.getAndIncrementIdleTime();
                                                            int keyboardIdle = Keyboard.getIdleTime();
                                                            if (mouseIdle > 15000 && keyboardIdle > 15000) {
                                                                logoutTimer = 250;
                                                                Mouse.idleTime = 14500;
                                                                OutgoingPacket outgoing = OutgoingPacket.prepare(OutgoingPacketMeta.IDLE_LOGOUT, netWriter.encryptor);
                                                                netWriter.writeLater(outgoing);
                                                            }

                                                            relationshipSystem.processFriendLogins();
                                                            ++netWriter.idleWriteTicks;
                                                            if (netWriter.idleWriteTicks > 50) {
                                                                OutgoingPacket outgoing = OutgoingPacket.prepare(OutgoingPacketMeta.KEEP_ALIVE, netWriter.encryptor);
                                                                netWriter.writeLater(outgoing);
                                                            }

                                                            try {
                                                                netWriter.flush();
                                                            } catch (IOException e) {
                                                                dropConnection();
                                                            }

                                                            return;
                                                        }

                                                        var25 = var40.component;
                                                        if (var25.subComponentIndex < 0) {
                                                            break;
                                                        }

                                                        var38 = InterfaceComponent.lookup(var25.parentUid);
                                                    }
                                                    while (var38 == null || var38.subcomponents == null || var25.subComponentIndex >= var38.subcomponents.length || var25 != var38.subcomponents[var25.subComponentIndex]);

                                                    ScriptEvent.fire(var40);
                                                }
                                            }

                                            var25 = var40.component;
                                            if (var25.subComponentIndex < 0) {
                                                break;
                                            }

                                            var38 = InterfaceComponent.lookup(var25.parentUid);
                                        }
                                        while (var38 == null || var38.subcomponents == null || var25.subComponentIndex >= var38.subcomponents.length || var25 != var38.subcomponents[var25.subComponentIndex]);

                                        ScriptEvent.fire(var40);
                                    }
                                }

                                var25 = var40.component;
                                if (var25.subComponentIndex < 0) {
                                    break;
                                }

                                var38 = InterfaceComponent.lookup(var25.parentUid);
                            }
                            while (var38 == null || var38.subcomponents == null || var25.subComponentIndex >= var38.subcomponents.length || var25 != var38.subcomponents[var25.subComponentIndex]);

                            ScriptEvent.fire(var40);
                        }
                    }

                    packet = OutgoingPacket.prepare(OutgoingPacketMeta.PROCESS_REFLECTION, netWriter.encryptor);
                    packet.buffer.p1(0);
                    offset = packet.buffer.pos;
                    ClassStructure.process(packet.buffer);
                    packet.buffer.psize1(packet.buffer.pos - offset);
                    netWriter.writeLater(packet);
                }
            }
        }
    }

    public final void processConnect() {
        Connection connection = netWriter.unwrap();
        PacketBuffer input = netWriter.inbuffer;

        try {
            if (loginStage == 0) {
                if (SecureRandomService.instance == null && (secureRandomService.isDone() || loginStageCycles > 250)) {
                    SecureRandomService.instance = secureRandomService.get();
                    secureRandomService.kill();
                    secureRandomService = null;
                }

                if (SecureRandomService.instance != null) {
                    if (connection != null) {
                        connection.stop();
                        connection = null;
                    }

                    LoginPacketMeta.task = null;
                    pendingDisconnect = false;
                    loginStageCycles = 0;
                    loginStage = 1;
                }
            }

            if (loginStage == 1) {
                if (LoginPacketMeta.task == null) {
                    LoginPacketMeta.task = taskProcessor.create(LoginStep.currentDomain, NpcEntity.port);
                }

                if (LoginPacketMeta.task.state == 2) {
                    throw new IOException();
                }

                if (LoginPacketMeta.task.state == 1) {
                    if (usingBufferedConnection) {
                        Socket socket = (Socket) LoginPacketMeta.task.result;
                        connection = new AsyncConnection(socket, 40000, 5000);
                    } else {
                        connection = new OldConnection((Socket) LoginPacketMeta.task.result, taskProcessor, 5000);
                    }

                    netWriter.setConnection(connection);
                    LoginPacketMeta.task = null;
                    loginStage = 2;
                }
            }

            if (loginStage == 2) {
                netWriter.drop();
                OutgoingPacket packet = OutgoingPacket.prepareLoginPacket();
                packet.buffer.p1(LoginPacketMeta.HANDSHAKE.value);
                netWriter.writeLater(packet);
                netWriter.flush();
                input.pos = 0;
                loginStage = 3;
            }

            if (loginStage == 3) {
                if (AudioSystem.anAudioSystem1236 != null) {
                    AudioSystem.anAudioSystem1236.method1332();
                }

                if (AudioSystem.anAudioSystem599 != null) {
                    AudioSystem.anAudioSystem599.method1332();
                }

                boolean available = !usingBufferedConnection || connection.available(1);

                if (available) {
                    int read = connection.read();
                    if (AudioSystem.anAudioSystem1236 != null) {
                        AudioSystem.anAudioSystem1236.method1332();
                    }

                    if (AudioSystem.anAudioSystem599 != null) {
                        AudioSystem.anAudioSystem599.method1332();
                    }

                    if (read != 0) {
                        Login.processResponseCode(read);
                        return;
                    }

                    input.pos = 0;
                    loginStage = 4;
                }
            }

            if (loginStage == 4) {
                if (input.pos < 8) {
                    int len = connection.available();
                    if (len > 8 - input.pos) {
                        len = 8 - input.pos;
                    }

                    if (len > 0) {
                        connection.read(input.payload, input.pos, len);
                        input.pos += len;
                    }
                }

                if (input.pos == 8) {
                    input.pos = 0;
                    Statics45.aLong403 = input.g8();
                    loginStage = 5;
                }
            }

            if (loginStage == 5) {
                netWriter.inbuffer.pos = 0;
                netWriter.drop();
                PacketBuffer buffer = new PacketBuffer(500);
                int[] seed = new int[]{SecureRandomService.instance.nextInt(), SecureRandomService.instance.nextInt(), SecureRandomService.instance.nextInt(), SecureRandomService.instance.nextInt()};
                buffer.pos = 0;
                buffer.p1(1);
                buffer.p4(seed[0]);
                buffer.p4(seed[1]);
                buffer.p4(seed[2]);
                buffer.p4(seed[3]);
                buffer.p8(Statics45.aLong403);
                if (gameState == 40) {
                    buffer.p4(DirectByteBufferProvider.anIntArray1136[0]);
                    buffer.p4(DirectByteBufferProvider.anIntArray1136[1]);
                    buffer.p4(DirectByteBufferProvider.anIntArray1136[2]);
                    buffer.p4(DirectByteBufferProvider.anIntArray1136[3]);
                } else {
                    buffer.p1(loginStep.getOrdinal());
                    switch (loginStep.anInt619) {
                        case 0:
                        case 1:
                            buffer.p3(RegionUpdateType.parsedTotp);
                            ++buffer.pos;
                            break;
                        case 2:
                            buffer.pos += 4;
                            break;
                        case 3:
                            buffer.p4(preferences.properties.get(Djb2.hash(Login.username)));
                    }

                    buffer.p1(LoginHeaderType.anEnum_Sub10_1767.getOrdinal());
                    buffer.pcstr(Login.password);
                }

                buffer.prsa(Statics51.rsaExponent, Statics51.rsaModulus);
                DirectByteBufferProvider.anIntArray1136 = seed;
                OutgoingPacket packet = OutgoingPacket.prepareLoginPacket();
                packet.buffer.pos = 0;
                if (gameState == 40) {
                    packet.buffer.p1(LoginPacketMeta.aLoginPacketMeta1996.value);
                } else {
                    packet.buffer.p1(LoginPacketMeta.aLoginPacketMeta1997.value);
                }

                packet.buffer.p2(0);
                int var8 = packet.buffer.pos;
                packet.buffer.p4(184);
                packet.buffer.p4(1);
                packet.buffer.p1(anInt923);
                packet.buffer.p(buffer.payload, 0, buffer.pos);
                int offset = packet.buffer.pos;
                packet.buffer.pcstr(Login.username);
                packet.buffer.p1((resizableMode ? 1 : 0) << 1 | (lowMemory ? 1 : 0));
                packet.buffer.p2(canvasWidth);
                packet.buffer.p2(canvasHeight);
                int var12;
                if (random != null) {
                    packet.buffer.p(random, 0, random.length);
                } else {
                    byte[] var11 = new byte[24];

                    try {
                        BufferedFile.random.seek(0L);
                        BufferedFile.random.read(var11);

                        var12 = 0;
                        while (var12 < 24 && var11[var12] == 0) {
                            ++var12;
                        }

                        if (var12 >= 24) {
                            throw new IOException();
                        }
                    } catch (Exception var20) {
                        for (int var14 = 0; var14 < 24; ++var14) {
                            var11[var14] = -1;
                        }
                    }

                    packet.buffer.p(var11, 0, var11.length);
                }

                packet.buffer.pcstr(Statics57.aString1162);
                packet.buffer.p4(WorldMapCacheArea.anInt130);
                Buffer var15 = new Buffer(operatingSystemNode.getPayloadSize());
                operatingSystemNode.method1098(var15);
                packet.buffer.p(var15.payload, 0, var15.payload.length);
                packet.buffer.p1(anInt923);
                packet.buffer.p4(0);
                packet.buffer.p4(Archive.skeletons.hash);
                packet.buffer.p4(Archive.skins.hash);
                packet.buffer.p4(Archive.config.hash);
                packet.buffer.p4(Archive.interfaces.hash);
                packet.buffer.p4(Archive.audioEffects.hash);
                packet.buffer.p4(Archive.landscape.hash);
                packet.buffer.p4(Archive.audioTracks.hash);
                packet.buffer.p4(Archive.models.hash);
                packet.buffer.p4(Archive.sprites.hash);
                packet.buffer.p4(Archive.textures.hash);
                packet.buffer.p4(Archive.huffman.hash);
                packet.buffer.p4(Archive.audioTracks2.hash);
                packet.buffer.p4(Archive.cs2.hash);
                packet.buffer.p4(Archive.fonts.hash);
                packet.buffer.p4(Archive.audioEffects2.hash);
                packet.buffer.p4(Archive.audioEffects3.hash);
                packet.buffer.p4(0);
                packet.buffer.p4(Archive.bootSprites.hash);
                packet.buffer.p4(Archive.mapscene.hash);
                packet.buffer.p4(Archive.worldmap.hash);
                packet.buffer.p4(Archive.mapland.hash);
                packet.buffer.tinyenc2(seed, offset, packet.buffer.pos);
                packet.buffer.psize2(packet.buffer.pos - var8);
                netWriter.writeLater(packet);
                netWriter.flush();
                netWriter.encryptor = new IsaacCipher(seed);
                int[] var34 = new int[4];

                for (var12 = 0; var12 < 4; ++var12) {
                    var34[var12] = seed[var12] + 50;
                }

                input.setCipher(var34);
                loginStage = 6;
            }

            if (loginStage == 6 && connection.available() > 0) {
                int next = connection.read();
                if (next == 21 && gameState == 20) {
                    loginStage = 9;
                } else if (next == 2) {
                    loginStage = 11;
                } else if (next == 15 && gameState == 40) {
                    netWriter.incomingPacketSize = -1;
                    loginStage = 16;
                } else if (next == 64) {
                    loginStage = 7;
                } else if (next == 23 && loginProcess < 1) {
                    ++loginProcess;
                    loginStage = 0;
                } else {
                    if (next != 29) {
                        Login.processResponseCode(next);
                        return;
                    }

                    loginStage = 14;
                }
            }

            if (loginStage == 7 && connection.available() > 0) {
                anInt1232 = connection.read();
                loginStage = 8;
            }

            if (loginStage == 8 && connection.available() >= anInt1232) {
                connection.read(input.payload, 0, anInt1232);
                input.pos = 0;
                loginStage = 6;
            }

            if (loginStage == 9 && connection.available() > 0) {
                serverTransferCycles = (connection.read() + 3) * 60;
                loginStage = 10;
            }

            if (loginStage == 10) {
                loginStageCycles = 0;
                Login.setMessages("You have only just left another world.", "Your profile will be transferred in:", serverTransferCycles / 60 + " seconds.");
                if (--serverTransferCycles <= 0) {
                    loginStage = 0;
                }

            } else {
                if (loginStage == 11 && connection.available() >= 1) {
                    Server.expectedRead = connection.read();
                    loginStage = 12;
                }

                int var16;
                if (loginStage == 12 && connection.available() >= Server.expectedRead) {
                    boolean var5 = connection.read() == 1;
                    connection.read(input.payload, 0, 4);
                    input.pos = 0;
                    if (var5) {
                        int var6 = input.readHeader() << 24;
                        var6 |= input.readHeader() << 16;
                        var6 |= input.readHeader() << 8;
                        var6 |= input.readHeader();
                        var16 = Djb2.hash(Login.username);
                        if (preferences.properties.size() >= 10 && !preferences.properties.containsKey(var16)) {
                            Iterator<Map.Entry<Integer, Integer>> var17 = preferences.properties.entrySet().iterator();
                            var17.next();
                            var17.remove();
                        }

                        preferences.properties.put(var16, var6);
                    }

                    if (rememberUsername) {
                        preferences.rememberedUsername = Login.username;
                    } else {
                        preferences.rememberedUsername = null;
                    }

                    ClientLocale.method854();
                    rights = connection.read();
                    aBoolean1056 = connection.read() == 1;
                    playerIndex = connection.read();
                    playerIndex <<= 8;
                    playerIndex += connection.read();
                    relationshipSystemState = connection.read();
                    connection.read(input.payload, 0, 1);
                    input.pos = 0;
                    IncomingPacketMeta[] var31 = IncomingPacketMeta.values();
                    int var8 = input.method1396();
                    if (var8 < 0 || var8 >= var31.length) {
                        throw new IOException(var8 + " " + input.pos);
                    }

                    netWriter.currentIncomingPacket = var31[var8];
                    netWriter.incomingPacketSize = netWriter.currentIncomingPacket.size;
                    connection.read(input.payload, 0, 2);
                    input.pos = 0;
                    netWriter.incomingPacketSize = input.g2();

                    try {
                        JSObjectUtil.call(instance, "zap");
                    } catch (Throwable ignored) {
                    }

                    loginStage = 13;
                }

                if (loginStage == 13) {
                    if (connection.available() >= netWriter.incomingPacketSize) {
                        input.pos = 0;
                        connection.read(input.payload, 0, netWriter.incomingPacketSize);
                        gameStateEvents.method1119();
                        timeOfPreviousClick = 1L;
                        mouseRecorder.caret = 0;
                        OldConnectionTaskProcessor.hasFocus = true;
                        previousFocusState = true;
                        aLong1095 = -1L;
                        ClassStructure.list = new LinkedList<>();
                        netWriter.drop();
                        netWriter.inbuffer.pos = 0;
                        netWriter.currentIncomingPacket = null;
                        netWriter.lastIncomingPacket = null;
                        netWriter.secondLastIncomingPacket = null;
                        netWriter.thirdLastIncomingPacket = null;
                        netWriter.incomingPacketSize = 0;
                        netWriter.idleReadTicks = 0;
                        rebootTimer = 0;
                        logoutTimer = 0;
                        HintArrow.type = 0;
                        ContextMenu.close();
                        Mouse.idleTime = 0;
                        ChatHistory.clear();
                        ComponentSelection.Item.state = 0;
                        ComponentSelection.Spell.state = false;
                        audioEffectCount = 0;
                        cameraY = 0;
                        oculusOrbState = 0;
                        WorldMap.heatmap = null;
                        mapState = 0;
                        minimapFloorLevel = -1;
                        destinationX = 0;
                        destinationY = 0;
                        playerAttackOptionPriority = AttackOptionPriority.HIDDEN;
                        npcAttackOptionPriority = AttackOptionPriority.HIDDEN;
                        npcCount = 0;
                        GPI.method250();

                        int var29;
                        int var6;
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
                                    pickables[var29][var6][var16] = null;
                                }
                            }
                        }

                        pendingSpawns = new NodeDeque();
                        relationshipSystem.clear();

                        for (var29 = 0; var29 < VarDefinition.anInt568; ++var29) {
                            VarDefinition var24 = VarDefinition.get(var29);
                            if (var24 != null) {
                                Vars.baseValues[var29] = 0;
                                Vars.values[var29] = 0;
                            }
                        }

                        varcs.clear();
                        anInt1053 = -1;
                        if (rootInterfaceIndex != -1) {
                            InterfaceComponent.method830(rootInterfaceIndex);
                        }

                        for (SubInterface var28 = subInterfaces.head(); var28 != null; var28 = subInterfaces.next()) {
                            InterfaceComponent.close(var28, true);
                        }

                        rootInterfaceIndex = -1;
                        subInterfaces = new NodeTable(8);
                        pleaseWaitComponent = null;
                        ContextMenu.close();
                        renderedAppearance.update(null, new int[]{0, 0, 0, 0, 0}, false, -1);

                        for (var29 = 0; var29 < 8; ++var29) {
                            playerActions[var29] = null;
                            playerActionPriorities[var29] = false;
                        }

                        NamedFont.method1181();
                        loadingPleaseWait = true;

                        for (var29 = 0; var29 < 100; ++var29) {
                            renderedComponents[var29] = true;
                        }

                        processGameBoundsPacket();
                        clanSystem = null;

                        for (var29 = 0; var29 < 8; ++var29) {
                            stockMarketOffers[var29] = new StockMarketOffer();
                        }

                        Pickable.aStockMarketMediator_890 = null;
                        PlayerEntity.update(input);
                        IncomingPacketMeta.anInt206 = -1;
                        PlayerAccountType.onSceneXTEAKeyChange(false, input);
                        netWriter.currentIncomingPacket = null;
                    }

                } else {
                    if (loginStage == 14 && connection.available() >= 2) {
                        input.pos = 0;
                        connection.read(input.payload, 0, 2);
                        input.pos = 0;
                        WorldMapRenderRules.anInt168 = input.g2();
                        loginStage = 15;
                    }

                    if (loginStage == 15 && connection.available() >= WorldMapRenderRules.anInt168) {
                        input.pos = 0;
                        connection.read(input.payload, 0, WorldMapRenderRules.anInt168);
                        input.pos = 0;
                        String var27 = input.gstr();
                        String var23 = input.gstr();
                        String var32 = input.gstr();
                        Login.setMessages(var27, var23, var32);
                        setGameState(10);
                    }

                    if (loginStage != 16) {
                        ++loginStageCycles;
                        if (loginStageCycles > 2000) {
                            if (loginProcess < 1) {
                                if (HitsplatDefinition.anInt1929 == NpcEntity.port) {
                                    NpcEntity.port = Bzip2Entry.anInt1579;
                                } else {
                                    NpcEntity.port = HitsplatDefinition.anInt1929;
                                }

                                ++loginProcess;
                                loginStage = 0;
                            } else {
                                Login.processResponseCode(-3);
                            }
                        }
                    } else {
                        if (netWriter.incomingPacketSize == -1) {
                            if (connection.available() < 2) {
                                return;
                            }

                            connection.read(input.payload, 0, 2);
                            input.pos = 0;
                            netWriter.incomingPacketSize = input.g2();
                        }

                        if (connection.available() >= netWriter.incomingPacketSize) {
                            connection.read(input.payload, 0, netWriter.incomingPacketSize);
                            input.pos = 0;
                            int var29 = netWriter.incomingPacketSize;
                            gameStateEvents.method1116();
                            netWriter.drop();
                            netWriter.inbuffer.pos = 0;
                            netWriter.currentIncomingPacket = null;
                            netWriter.lastIncomingPacket = null;
                            netWriter.secondLastIncomingPacket = null;
                            netWriter.thirdLastIncomingPacket = null;
                            netWriter.incomingPacketSize = 0;
                            netWriter.idleReadTicks = 0;
                            rebootTimer = 0;
                            ContextMenu.close();
                            mapState = 0;
                            destinationX = 0;

                            for (int var6 = 0; var6 < 2048; ++var6) {
                                players[var6] = null;
                            }

                            PlayerEntity.local = null;

                            for (int var6 = 0; var6 < npcs.length; ++var6) {
                                NpcEntity var33 = npcs[var6];
                                if (var33 != null) {
                                    var33.targetIndex = -1;
                                    var33.aBoolean2015 = false;
                                }
                            }

                            NamedFont.method1181();
                            setGameState(30);

                            for (int var6 = 0; var6 < 100; ++var6) {
                                renderedComponents[var6] = true;
                            }

                            processGameBoundsPacket();
                            PlayerEntity.update(input);
                            if (var29 != input.pos) {
                                throw new RuntimeException();
                            }
                        }
                    }
                }
            }
        } catch (IOException var21) {
            if (loginProcess < 1) {
                if (NpcEntity.port == HitsplatDefinition.anInt1929) {
                    NpcEntity.port = Bzip2Entry.anInt1579;
                } else {
                    NpcEntity.port = HitsplatDefinition.anInt1929;
                }

                ++loginProcess;
                loginStage = 0;
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

            for (var2 = 0; var2 < ContextMenu.rowCount - 1; ++var2) {
                if (ContextMenu.opcodes[var2] < 1000 && ContextMenu.opcodes[var2 + 1] > 1000) {
                    String var3 = ContextMenu.targets[var2];
                    ContextMenu.targets[var2] = ContextMenu.targets[var2 + 1];
                    ContextMenu.targets[var2 + 1] = var3;
                    String var4 = ContextMenu.actions[var2];
                    ContextMenu.actions[var2] = ContextMenu.actions[var2 + 1];
                    ContextMenu.actions[var2 + 1] = var4;
                    var5 = ContextMenu.opcodes[var2];
                    ContextMenu.opcodes[var2] = ContextMenu.opcodes[var2 + 1];
                    ContextMenu.opcodes[var2 + 1] = var5;
                    var5 = ContextMenu.secondaryArgs[var2];
                    ContextMenu.secondaryArgs[var2] = ContextMenu.secondaryArgs[var2 + 1];
                    ContextMenu.secondaryArgs[var2 + 1] = var5;
                    var5 = ContextMenu.tertiaryArgs[var2];
                    ContextMenu.tertiaryArgs[var2] = ContextMenu.tertiaryArgs[var2 + 1];
                    ContextMenu.tertiaryArgs[var2 + 1] = var5;
                    var5 = ContextMenu.primaryArgs[var2];
                    ContextMenu.primaryArgs[var2] = ContextMenu.primaryArgs[var2 + 1];
                    ContextMenu.primaryArgs[var2 + 1] = var5;
                    boolean var6 = ContextMenu.shiftClickActions[var2];
                    ContextMenu.shiftClickActions[var2] = ContextMenu.shiftClickActions[var2 + 1];
                    ContextMenu.shiftClickActions[var2 + 1] = var6;
                    var1 = false;
                }
            }
        }

        if (AnimationFrameGroup.dragComponent == null) {
            if (draggedComponent == null) {
                int var16 = Mouse.clickMeta;
                int var7;
                int var8;
                if (ContextMenu.open) {
                    int var9;
                    int var10;
                    int var17;
                    if (var16 != 1 && (WorldMapObjectIcon.mouseCameraEnabled || var16 != 4)) {
                        var2 = Mouse.x;
                        var7 = Mouse.y;
                        if (var2 < ContextMenu.x - 10 || var2 > ContextMenu.width + ContextMenu.x + 10 || var7 < ContextMenu.y - 10 || var7 > ContextMenu.y + ContextMenu.height + 10) {
                            ContextMenu.open = false;
                            var8 = ContextMenu.x;
                            var5 = ContextMenu.y;
                            var17 = ContextMenu.width;
                            var9 = ContextMenu.height;

                            for (var10 = 0; var10 < renderedComponentCount; ++var10) {
                                if (interfaceWidths[var10] + interfacePositionsX[var10] > var8 && interfacePositionsX[var10] < var17 + var8 && interfaceHeights[var10] + interfacePositionsY[var10] > var5 && interfacePositionsY[var10] < var5 + var9) {
                                    renderedComponents[var10] = true;
                                }
                            }
                        }
                    }

                    if (var16 == 1 || !WorldMapObjectIcon.mouseCameraEnabled && var16 == 4) {
                        var2 = ContextMenu.x;
                        var7 = ContextMenu.y;
                        var8 = ContextMenu.width;
                        var5 = Mouse.clickX;
                        var17 = Mouse.clickY;
                        var9 = -1;

                        int var11;
                        for (var10 = 0; var10 < ContextMenu.rowCount; ++var10) {
                            var11 = (ContextMenu.rowCount - 1 - var10) * 15 + var7 + 31;
                            if (var5 > var2 && var5 < var8 + var2 && var17 > var11 - 13 && var17 < var11 + 3) {
                                var9 = var10;
                            }
                        }

                        if (var9 != -1) {
                            ContextMenu.processActionAt(var9);
                        }

                        ContextMenu.open = false;
                        var10 = ContextMenu.x;
                        var11 = ContextMenu.y;
                        int var12 = ContextMenu.width;
                        int var13 = ContextMenu.height;

                        for (int var14 = 0; var14 < renderedComponentCount; ++var14) {
                            if (interfacePositionsX[var14] + interfaceWidths[var14] > var10 && interfacePositionsX[var14] < var10 + var12 && interfaceHeights[var14] + interfacePositionsY[var14] > var11 && interfacePositionsY[var14] < var13 + var11) {
                                renderedComponents[var14] = true;
                            }
                        }
                    }
                } else {
                    var2 = AssociateComparatorByRank.getMaximumMenuRowIndex();
                    if ((var16 == 1 || !WorldMapObjectIcon.mouseCameraEnabled && var16 == 4) && var2 >= 0) {
                        var7 = ContextMenu.opcodes[var2];
                        if (var7 == 39 || var7 == 40 || var7 == 41 || var7 == 42 || var7 == 43 || var7 == 33 || var7 == 34 || var7 == 35 || var7 == 36 || var7 == 37 || var7 == 38 || var7 == 1005) {
                            var8 = ContextMenu.secondaryArgs[var2];
                            var5 = ContextMenu.tertiaryArgs[var2];
                            InterfaceComponent var15 = InterfaceComponent.lookup(var5);
                            if (Statics3.method650(InterfaceComponent.getConfig(var15)) || WorldMapAreaChunk_Sub3.method367(InterfaceComponent.getConfig(var15))) {
                                if (AnimationFrameGroup.dragComponent != null && !draggingComponent && ContextMenu.rowCount > 0 && !this.method731()) {
                                    SerializableProcessor.method459(draggingComponentX, draggingComponentY);
                                }

                                draggingComponent = false;
                                componentDragCycles = 0;
                                if (AnimationFrameGroup.dragComponent != null) {
                                    InterfaceComponent.repaint(AnimationFrameGroup.dragComponent);
                                }

                                AnimationFrameGroup.dragComponent = InterfaceComponent.lookup(var5);
                                draggingComponentSourceIndex = var8;
                                draggingComponentX = Mouse.clickX;
                                draggingComponentY = Mouse.clickY;
                                if (var2 >= 0) {
                                    DefinitionProperty.method516(var2);
                                }

                                InterfaceComponent.repaint(AnimationFrameGroup.dragComponent);
                                return;
                            }
                        }
                    }

                    if ((var16 == 1 || !WorldMapObjectIcon.mouseCameraEnabled && var16 == 4) && this.method731()) {
                        var16 = 2;
                    }

                    if ((var16 == 1 || !WorldMapObjectIcon.mouseCameraEnabled && var16 == 4) && ContextMenu.rowCount > 0) {
                        ContextMenu.processActionAt(var2);
                    }

                    if (var16 == 2 && ContextMenu.rowCount > 0) {
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
            int var5 = draggedComponent.dragArea;
            if (Statics2.anInt654 > draggedComponent.dragAreaThreshold && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
                aBoolean1062 = true;
            }

            int var6 = var1 - anInt1060 + topLevelOfDraggedComponent.insetX;
            int var7 = var2 - anInt1069 + topLevelOfDraggedComponent.insetY;
            ScriptEvent var8;
            if (draggedComponent.dragListeners != null && aBoolean1062) {
                var8 = new ScriptEvent();
                var8.component = draggedComponent;
                var8.mouseX = var6;
                var8.mouseY = var7;
                var8.args = draggedComponent.dragListeners;
                ScriptEvent.fire(var8);
            }

            if (Mouse.pressMeta == 0) {
                if (aBoolean1062) {
                    if (draggedComponent.dragReleaseListeners != null) {
                        var8 = new ScriptEvent();
                        var8.component = draggedComponent;
                        var8.mouseX = var6;
                        var8.mouseY = var7;
                        var8.dragTarget = draggedSpecialComponent;
                        var8.args = draggedComponent.dragReleaseListeners;
                        ScriptEvent.fire(var8);
                    }

                    if (draggedSpecialComponent != null && InterfaceComponent.getTopLevelComponent(draggedComponent) != null) {
                        OutgoingPacket packet = OutgoingPacket.prepare(OutgoingPacketMeta.DRAGGED_COMPONENT, netWriter.encryptor);
                        packet.buffer.ip2a(draggedSpecialComponent.subComponentIndex);
                        packet.buffer.ip2a(draggedSpecialComponent.itemId);
                        packet.buffer.ip2(draggedComponent.subComponentIndex);
                        packet.buffer.pirf4(draggedSpecialComponent.uid);
                        packet.buffer.p2a(draggedComponent.itemId);
                        packet.buffer.p4(draggedComponent.uid);
                        netWriter.writeLater(packet);
                    }
                } else if (this.method731()) {
                    this.openMenu(anInt1068 + currentComponentDragX, currentComponentDragY + anInt1073);
                } else if (ContextMenu.rowCount > 0) {
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
                                usingBufferedConnection = Integer.parseInt(var2) != 0;
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
                                devbuild = DevelopmentBuild.valueOf(Integer.parseInt(var2));
                                break;
                            case 8:
                                if (var2.equalsIgnoreCase("true")) {
                                }
                                break;
                            case 9:
                                Statics57.aString1162 = var2;
                                break;
                            case 10:
                                GameType[] var3 = new GameType[]{GameType.GAME3, GameType.RUNESCAPE, GameType.STELLARDAWN, GameType.OSRS, GameType.GAME4, GameType.GAME5};
                                Statics55.gameType = (GameType) EnumType.getByOrdinal(var3, Integer.parseInt(var2));
                                if (Statics55.gameType == GameType.OSRS) {
                                    PreciseWorldMapAreaChunk.nameLengthParameter = ClientParameter.A_CLIENT_PARAMETER___1801;
                                } else {
                                    PreciseWorldMapAreaChunk.nameLengthParameter = ClientParameter.A_CLIENT_PARAMETER___1799;
                                }
                                break;
                            case 12:
                                currentWorld = Integer.parseInt(var2);
                                break;
                            case 14:
                                WorldMapCacheArea.anInt130 = Integer.parseInt(var2);
                                break;
                            case 15:
                                gameType = Integer.parseInt(var2);
                                break;
                            case 17:
                                Server.slu = var2;
                        }
                    }
                }

                StockMarketOfferPriceComparator.method330();
                LoginStep.currentDomain = this.getCodeBase().getHost();
                String var4 = devbuild.name;
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
