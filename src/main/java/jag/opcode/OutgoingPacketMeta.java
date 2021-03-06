package jag.opcode;

import jag.Login;
import jag.audi.ObjectSound;
import jag.game.client;
import jag.graphics.IndexedSprite;
import jag.js5.Archive;
import jag.statics.Statics11;
import jag.statics.Statics51;
import jag.worldmap.WorldMapAreaChunk_Sub2;
import jag.worldmap.WorldMapElement;
import jag.worldmap.WorldMapLabelSize;

public class OutgoingPacketMeta implements OutgoingPacketProtocol {
    public static final OutgoingPacketMeta USING_AWT_FRAME;
    public static final OutgoingPacketMeta ITEM_ACTION_2;
    public static final OutgoingPacketMeta DIALOG_ACTION;
    public static final OutgoingPacketMeta BUTTON_CLOSE_ACTION;
    public static final OutgoingPacketMeta TABLE_ACTION_4;
    public static final OutgoingPacketMeta INTERFACE_ACTION_9;
    public static final OutgoingPacketMeta REMOVE_FRIEND;
    public static final OutgoingPacketMeta REMOVE_FROM_IGNORE_LIST;
    public static final OutgoingPacketMeta OBJECT_ACTION_4;
    public static final OutgoingPacketMeta GAME_STATE_EVENT_REQUEST;
    public static final OutgoingPacketMeta PLAYER_ACTION_1;
    public static final OutgoingPacketMeta MOUSE_MOTION_RECORD;
    public static final OutgoingPacketMeta PICKABLE_ACTION_4;
    public static final OutgoingPacketMeta NPC_ACTION_2;
    public static final OutgoingPacketMeta OBJECT_ACTION_2;
    public static final OutgoingPacketMeta USE_SPELL_ON_ITEM;
    public static final OutgoingPacketMeta ADD_FRIEND;
    public static final OutgoingPacketMeta ADD_TO_IGNORE_LIST;
    public static final OutgoingPacketMeta TABLE_ACTION_0;
    public static final OutgoingPacketMeta OBJECT_ACTION_0;
    public static final OutgoingPacketMeta TABLE_ACTION_1;
    public static final OutgoingPacketMeta PLAYER_ACTION_3;
    public static final OutgoingPacketMeta OBJECT_ACTION_1;
    public static final OutgoingPacketMeta ITEM_ACTION_0;
    public static final OutgoingPacketMeta USE_ITEM_ON_PLAYER;
    public static final OutgoingPacketMeta BUTTON_ACTION;
    public static final OutgoingPacketMeta PROCESS_REFLECTION;
    public static final OutgoingPacketMeta NPC_ACTION_0;
    public static final OutgoingPacketMeta TELEPORT;
    public static final OutgoingPacketMeta NPC_ACTION_1;
    public static final OutgoingPacketMeta TABLE_ACTION_3;
    public static final OutgoingPacketMeta PLAYER_ACTION_0;
    public static final OutgoingPacketMeta PROCESS_NUMERIC_INPUT;
    public static final OutgoingPacketMeta EXAMINE_ITEM;
    public static final OutgoingPacketMeta USE_ITEM_ON_PICKABLE;
    public static final OutgoingPacketMeta USE_SPELL_ON_NPC;
    public static final OutgoingPacketMeta EXAMINE_NPC;
    public static final OutgoingPacketMeta INTERFACE_ACTION_3;
    public static final OutgoingPacketMeta OBJECT_ACTION_3;
    public static final OutgoingPacketMeta NPC_ACTION_4;
    public static final OutgoingPacketMeta PLAYER_ACTION_2;
    public static final OutgoingPacketMeta USE_ITEM_ON_NPC;
    public static final OutgoingPacketMeta ITEM_ACTION_3;
    public static final OutgoingPacketMeta WORLD_MAP_DRAG;
    public static final OutgoingPacketMeta NPC_ACTION_3;
    public static final OutgoingPacketMeta PICKABLE_ACTION_3;
    public static final OutgoingPacketMeta USE_SPELL_ON_COMPONENT;
    public static final OutgoingPacketMeta ITEM_ACTION_1;
    public static final OutgoingPacketMeta PLAYER_APPEARANCE_BUTTON;
    public static final OutgoingPacketMeta SCENE_LOADED;
    public static final OutgoingPacketMeta INTERFACE_ACTION_0;
    public static final OutgoingPacketMeta EXAMINE_OBJECT;
    public static final OutgoingPacketMeta GAME_BOUNDS;
    public static final OutgoingPacketMeta PLAYER_ACTION_6;
    public static final OutgoingPacketMeta PICKABLE_ACTION_0;
    public static final OutgoingPacketMeta PLAYER_ACTION_5;
    public static final OutgoingPacketMeta FOCUS_INFO;
    public static final OutgoingPacketMeta USE_SPELL_ON_OBJECT;
    public static final OutgoingPacketMeta PICKABLE_ACTION_2;
    public static final OutgoingPacketMeta INTERFACE_ACTION_5;
    public static final OutgoingPacketMeta PLAYER_ACTION_7;
    public static final OutgoingPacketMeta USE_ITEM_ON_ITEM;
    public static final OutgoingPacketMeta ITEM_ACTION_4;
    public static final OutgoingPacketMeta PROCESS_COMMAND;
    public static final OutgoingPacketMeta INTERFACE_ACTION_1;
    public static final OutgoingPacketMeta INTERFACE_ACTION_2;
    public static final OutgoingPacketMeta TABLE_ACTION_2;
    public static final OutgoingPacketMeta INTERFACE_ACTION_7;
    public static final OutgoingPacketMeta USE_SPELL_ON_PLAYER;
    public static final OutgoingPacketMeta INTERFACE_ACTION_4;
    public static final OutgoingPacketMeta PICKABLE_ACTION_1;
    public static final OutgoingPacketMeta USE_ITEM_ON_OBJECT;
    public static final OutgoingPacketMeta PROCESS_CHAT_MODE;
    public static final OutgoingPacketMeta USE_SPELL_ON_PICKABLE;
    public static final OutgoingPacketMeta GARBAGE_COLLECTOR;
    public static final OutgoingPacketMeta KICK_CLANCHANNEL_USER;
    public static final OutgoingPacketMeta WALK_MAP;
    public static final OutgoingPacketMeta PLAYER_ACTION_4;
    public static final OutgoingPacketMeta KEEP_ALIVE;
    public static final OutgoingPacketMeta CAMERA_DATA;
    public static final OutgoingPacketMeta MOUSE_ACTION;
    public static final OutgoingPacketMeta DRAGGED_COMPONENT;
    public static final OutgoingPacketMeta KEYBOARD_INFO;
    public static final OutgoingPacketMeta INTERFACE_ACTION_8;
    public static final OutgoingPacketMeta SEND_PUBLIC_CHAT;
    public static final OutgoingPacketMeta DRAG_ITEM;
    public static final OutgoingPacketMeta PROCESS_ALPHABETICAL_INPUT;
    public static final OutgoingPacketMeta INTERFACE_ACTION_6;
    public static final OutgoingPacketMeta IDLE_LOGOUT;
    public static final OutgoingPacketMeta PROCESS_NAME_INPUT;
    public static final OutgoingPacketMeta PROCESS_OBJ_INPUT;
    public static final OutgoingPacketMeta SET_CLANCHANNEL_RANK;
    public static final OutgoingPacketMeta JOIN_CLANCHANNEL;
    public static final OutgoingPacketMeta SEND_PRIVATE_CHAT;
    public static final OutgoingPacketMeta REPORT_ABUSE;
    public static final OutgoingPacketMeta REPORT_BUG;
    public static final OutgoingPacketMeta CLOSE_OCULUS_ORB;
    public static final OutgoingPacketMeta PROCESS_MOVEMENT;

    static final OutgoingPacketMeta anOutgoingPacketMeta8;
    static final OutgoingPacketMeta anOutgoingPacketMeta32;
    static final OutgoingPacketMeta anOutgoingPacketMeta63;

    static {
        USING_AWT_FRAME = new OutgoingPacketMeta(0, 4);
        DIALOG_ACTION = new OutgoingPacketMeta(1, 6);
        INTERFACE_ACTION_9 = new OutgoingPacketMeta(2, 8);
        GAME_STATE_EVENT_REQUEST = new OutgoingPacketMeta(3, -1);
        MOUSE_MOTION_RECORD = new OutgoingPacketMeta(4, -1);
        ITEM_ACTION_2 = new OutgoingPacketMeta(5, 8);
        OBJECT_ACTION_1 = new OutgoingPacketMeta(6, 7);
        TELEPORT = new OutgoingPacketMeta(7, 9);
        PROCESS_NUMERIC_INPUT = new OutgoingPacketMeta(8, 4);
        EXAMINE_NPC = new OutgoingPacketMeta(9, 2);
        INTERFACE_ACTION_3 = new OutgoingPacketMeta(10, 8);
        USE_ITEM_ON_NPC = new OutgoingPacketMeta(11, 11);
        PROCESS_REFLECTION = new OutgoingPacketMeta(12, -1);
        SCENE_LOADED = new OutgoingPacketMeta(13, 0);
        ITEM_ACTION_3 = new OutgoingPacketMeta(14, 8);
        FOCUS_INFO = new OutgoingPacketMeta(15, 1);
        INTERFACE_ACTION_5 = new OutgoingPacketMeta(16, 8);
        PROCESS_COMMAND = new OutgoingPacketMeta(17, -1);
        PICKABLE_ACTION_2 = new OutgoingPacketMeta(18, 7);
        INTERFACE_ACTION_7 = new OutgoingPacketMeta(19, 8);
        INTERFACE_ACTION_4 = new OutgoingPacketMeta(20, 8);
        PROCESS_CHAT_MODE = new OutgoingPacketMeta(21, 3);
        KICK_CLANCHANNEL_USER = new OutgoingPacketMeta(22, -1);
        KEEP_ALIVE = new OutgoingPacketMeta(23, 0);
        PICKABLE_ACTION_4 = new OutgoingPacketMeta(24, 7);
        CAMERA_DATA = new OutgoingPacketMeta(25, 4);
        MOUSE_ACTION = new OutgoingPacketMeta(26, 6);
        PICKABLE_ACTION_1 = new OutgoingPacketMeta(27, 7);
        EXAMINE_ITEM = new OutgoingPacketMeta(28, 2);
        INTERFACE_ACTION_8 = new OutgoingPacketMeta(29, 8);
        TABLE_ACTION_3 = new OutgoingPacketMeta(30, 8);
        TABLE_ACTION_1 = new OutgoingPacketMeta(31, 8);
        SEND_PUBLIC_CHAT = new OutgoingPacketMeta(32, -1);
        TABLE_ACTION_0 = new OutgoingPacketMeta(33, 8);
        USE_SPELL_ON_PICKABLE = new OutgoingPacketMeta(34, 13);
        NPC_ACTION_2 = new OutgoingPacketMeta(35, 3);
        EXAMINE_OBJECT = new OutgoingPacketMeta(36, 2);
        NPC_ACTION_4 = new OutgoingPacketMeta(37, 3);
        DRAG_ITEM = new OutgoingPacketMeta(38, 9);
        PROCESS_ALPHABETICAL_INPUT = new OutgoingPacketMeta(39, -1);
        KEYBOARD_INFO = new OutgoingPacketMeta(40, -2);
        IDLE_LOGOUT = new OutgoingPacketMeta(41, 0);
        OBJECT_ACTION_2 = new OutgoingPacketMeta(42, 7);
        PLAYER_ACTION_1 = new OutgoingPacketMeta(43, 3);
        PLAYER_APPEARANCE_BUTTON = new OutgoingPacketMeta(44, 13);
        anOutgoingPacketMeta8 = new OutgoingPacketMeta(45, -1);
        USE_ITEM_ON_OBJECT = new OutgoingPacketMeta(46, 15);
        TABLE_ACTION_4 = new OutgoingPacketMeta(47, 8);
        REMOVE_FRIEND = new OutgoingPacketMeta(48, -1);
        CLOSE_OCULUS_ORB = new OutgoingPacketMeta(49, 0);
        OBJECT_ACTION_4 = new OutgoingPacketMeta(50, 7);
        OBJECT_ACTION_0 = new OutgoingPacketMeta(51, 7);
        PLAYER_ACTION_5 = new OutgoingPacketMeta(52, 3);
        JOIN_CLANCHANNEL = new OutgoingPacketMeta(53, -1);
        PROCESS_OBJ_INPUT = new OutgoingPacketMeta(54, 2);
        USE_SPELL_ON_PLAYER = new OutgoingPacketMeta(55, 9);
        REMOVE_FROM_IGNORE_LIST = new OutgoingPacketMeta(56, -1);
        BUTTON_CLOSE_ACTION = new OutgoingPacketMeta(57, 0);
        PLAYER_ACTION_4 = new OutgoingPacketMeta(58, 3);
        USE_ITEM_ON_PLAYER = new OutgoingPacketMeta(59, 11);
        INTERFACE_ACTION_0 = new OutgoingPacketMeta(60, 8);
        PLAYER_ACTION_2 = new OutgoingPacketMeta(61, 3);
        USE_SPELL_ON_ITEM = new OutgoingPacketMeta(62, 14);
        PICKABLE_ACTION_3 = new OutgoingPacketMeta(63, 7);
        USE_SPELL_ON_COMPONENT = new OutgoingPacketMeta(64, 16);
        INTERFACE_ACTION_1 = new OutgoingPacketMeta(65, 8);
        TABLE_ACTION_2 = new OutgoingPacketMeta(66, 8);
        SET_CLANCHANNEL_RANK = new OutgoingPacketMeta(67, -1);
        USE_SPELL_ON_OBJECT = new OutgoingPacketMeta(68, 13);
        WORLD_MAP_DRAG = new OutgoingPacketMeta(69, 4);
        ITEM_ACTION_1 = new OutgoingPacketMeta(70, 8);
        PLAYER_ACTION_3 = new OutgoingPacketMeta(71, 3);
        GAME_BOUNDS = new OutgoingPacketMeta(72, 5);
        INTERFACE_ACTION_2 = new OutgoingPacketMeta(73, 8);
        anOutgoingPacketMeta32 = new OutgoingPacketMeta(74, 7);
        GARBAGE_COLLECTOR = new OutgoingPacketMeta(75, 10);
        ITEM_ACTION_4 = new OutgoingPacketMeta(76, 8);
        USE_SPELL_ON_NPC = new OutgoingPacketMeta(77, 9);
        PLAYER_ACTION_7 = new OutgoingPacketMeta(78, 3);
        NPC_ACTION_3 = new OutgoingPacketMeta(79, 3);
        ADD_FRIEND = new OutgoingPacketMeta(80, -1);
        PLAYER_ACTION_0 = new OutgoingPacketMeta(81, 3);
        USE_ITEM_ON_PICKABLE = new OutgoingPacketMeta(82, 15);
        anOutgoingPacketMeta63 = new OutgoingPacketMeta(83, 2);
        ADD_TO_IGNORE_LIST = new OutgoingPacketMeta(84, -1);
        USE_ITEM_ON_ITEM = new OutgoingPacketMeta(85, 16);
        REPORT_BUG = new OutgoingPacketMeta(86, -2);
        INTERFACE_ACTION_6 = new OutgoingPacketMeta(87, 8);
        ITEM_ACTION_0 = new OutgoingPacketMeta(88, 8);
        NPC_ACTION_0 = new OutgoingPacketMeta(89, 3);
        PLAYER_ACTION_6 = new OutgoingPacketMeta(90, 3);
        WALK_MAP = new OutgoingPacketMeta(91, -1);
        REPORT_ABUSE = new OutgoingPacketMeta(92, -1);
        SEND_PRIVATE_CHAT = new OutgoingPacketMeta(93, -2);
        DRAGGED_COMPONENT = new OutgoingPacketMeta(94, 16);
        OBJECT_ACTION_3 = new OutgoingPacketMeta(95, 7);
        NPC_ACTION_1 = new OutgoingPacketMeta(96, 3);
        PICKABLE_ACTION_0 = new OutgoingPacketMeta(97, 7);
        PROCESS_MOVEMENT = new OutgoingPacketMeta(98, -1);
        BUTTON_ACTION = new OutgoingPacketMeta(99, 4);
        PROCESS_NAME_INPUT = new OutgoingPacketMeta(100, -1);
    }

    final int opcode;
    final int size;

    OutgoingPacketMeta(int var1, int var2) {
        this.opcode = var1;
        this.size = var2;
    }

    public static void method4() {
        for (ObjectSound var0 = ObjectSound.OBJECT_SOUNDS.head(); var0 != null; var0 = ObjectSound.OBJECT_SOUNDS.next()) {
            if (var0.aClass5_Sub6_Sub2_370 != null) {
                WorldMapLabelSize.aClass5_Sub6_Sub1_528.removeDelegate(var0.aClass5_Sub6_Sub2_370);
                var0.aClass5_Sub6_Sub2_370 = null;
            }

            if (var0.aClass5_Sub6_Sub2_369 != null) {
                WorldMapLabelSize.aClass5_Sub6_Sub1_528.removeDelegate(var0.aClass5_Sub6_Sub2_369);
                var0.aClass5_Sub6_Sub2_369 = null;
            }
        }

        ObjectSound.OBJECT_SOUNDS.clear();
    }

    public static IndexedSprite method6(boolean var0, boolean var1) {
        return var0 ? (var1 ? Login.aDoublyNode_Sub24_Sub4_470 : WorldMapAreaChunk_Sub2.aDoublyNode_Sub24_Sub4_288) : (var1 ? WorldMapElement.aDoublyNode_Sub24_Sub4_363 : Statics11.aDoublyNode_Sub24_Sub4_1148);
    }

    public static void method5(int var0) {
        if (client.anInt900 != 0 && var0 != -1) {
            Statics51.method344(Archive.audioTracks2, var0, 0, client.anInt900, false);
            client.aBoolean904 = true;
        }

    }
}
