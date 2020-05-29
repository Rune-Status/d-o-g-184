package jag.game;

import jag.SecureRandomService;
import jag.commons.collection.Node;
import jag.statics.Statics9;

public class SubInterface extends Node {

    public boolean aBoolean790;
    public int state;
    public int id;

    public SubInterface() {
        this.aBoolean790 = false;
    }

    public static void process() {
        for (SubInterface sub = client.subInterfaces.head(); sub != null; sub = client.subInterfaces.next()) {
            int groupIndex = sub.id;
            if (InterfaceComponent.load(groupIndex)) {
                boolean check = true;
                InterfaceComponent[] group = client.interfaces[groupIndex];
                for (InterfaceComponent component : group) {
                    if (component != null) {
                        check = component.aBoolean562;
                        break;
                    }
                }

                if (!check) {
                    int var4 = (int) sub.key;
                    InterfaceComponent var5 = InterfaceComponent.lookup(var4);
                    if (var5 != null) {
                        InterfaceComponent.repaint(var5);
                    }
                }
            }
        }

    }

    public static SubInterface create(int key, int id, int state) {
        SubInterface sub = new SubInterface();
        sub.id = id;
        sub.state = state;
        client.subInterfaces.put(sub, key);
        InterfaceComponent.method146(id);
        InterfaceComponent component = InterfaceComponent.lookup(key);
        InterfaceComponent.repaint(component);
        if (client.pleaseWaitComponent != null) {
            InterfaceComponent.repaint(client.pleaseWaitComponent);
            client.pleaseWaitComponent = null;
        }

        SecureRandomService.method317();
        GameEngine.method925(client.interfaces[key >> 16], component, false);
        Statics9.method796(id);
        if (client.rootInterfaceIndex != -1) {
            InterfaceComponent.method118(client.rootInterfaceIndex, 1);
        }

        return sub;
    }
}
