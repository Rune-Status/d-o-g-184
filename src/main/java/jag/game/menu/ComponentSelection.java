package jag.game.menu;

import jag.game.InterfaceComponent;
import jag.script.ScriptEvent;

public class ComponentSelection {

    public static String action;

    public static class Item {

        public static int uid;
        public static int index;
        public static int id;
        public static int state;

        public static String name;
    }

    public static class Spell {

        public static int index;
        public static int target;
        public static int flags;
        public static int uid;

        public static String name;

        public static boolean state;

        public static void process() {
            if (state) {
                InterfaceComponent component = InterfaceComponent.lookup(uid, index);
                if (component != null && component.targetExitListeners != null) {
                    ScriptEvent event = new ScriptEvent();
                    event.component = component;
                    event.args = component.targetExitListeners;
                    ScriptEvent.fire(event);
                }

                state = false;
                InterfaceComponent.repaint(component);
            }
        }

        public static void select(int uid, int index, int flags, int target) {
            InterfaceComponent component = InterfaceComponent.lookup(uid, index);
            if (component != null && component.targetEnterListeners != null) {
                ScriptEvent event = new ScriptEvent();
                event.component = component;
                event.args = component.targetEnterListeners;
                ScriptEvent.fire(event);
            }

            state = true;
            Spell.target = target;
            Spell.uid = uid;
            Spell.index = index;
            Spell.flags = flags;
            InterfaceComponent.repaint(component);
        }
    }

}
