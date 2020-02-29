package com.jagex;

public final class Statics23 {
    static int anInt1342;

    static void drag(InterfaceComponent component, int var1, int var2) {
        if (client.draggedComponent == null && !client.menuOpen) {
            if (component != null) {
                InterfaceComponent parent = InterfaceComponent.getTopLevelComponent(component);
                if (parent == null) {
                    parent = component.parent;
                }

                if (parent != null) {
                    client.draggedComponent = component;
                    parent = InterfaceComponent.getTopLevelComponent(component);
                    if (parent == null) {
                        parent = component.parent;
                    }

                    client.topLevelOfDraggedComponent = parent;
                    client.currentComponentDragX = var1;
                    client.currentComponentDragY = var2;
                    Statics2.anInt654 = 0;
                    client.aBoolean1062 = false;
                    int var5 = AssociateComparatorByRank.method679();
                    if (var5 != -1) {
                        Chatstream.method516(var5);
                    }

                }
            }

        }
    }
}
