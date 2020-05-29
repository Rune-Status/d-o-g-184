package jag.statics;

import jag.game.InterfaceComponent;
import jag.game.client;
import jag.game.relationship.AssociateComparatorByRank;
import jag.game.type.DefinitionProperty;

public final class Statics23 {
    public static int anInt1342;

    public static void drag(InterfaceComponent component, int var1, int var2) {
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
                        DefinitionProperty.method516(var5);
                    }

                }
            }

        }
    }
}
