package jag.game.scene.entity;

import jag.EntityUID;
import jag.commons.collection.NodeDeque;
import jag.game.InterfaceComponent;
import jag.game.client;
import jag.game.scene.SceneGraph;
import jag.game.stockmarket.StockMarketMediator;
import jag.game.type.ItemDefinition;
import jag.script.ScriptEvent;

public final class Pickable extends Entity {

    public static int anInt379;
    public static StockMarketMediator aStockMarketMediator_890;

    public int id;
    public int stackSize;

    public Pickable() {

    }

    public static void refresh(int sceneX, int sceneY) {
        NodeDeque<Pickable> deque = client.pickableNodeDeques[SceneGraph.floorLevel][sceneX][sceneY];
        if (deque == null) {
            client.sceneGraph.deleteItemPile(SceneGraph.floorLevel, sceneX, sceneY);
        } else {
            long highestValue = -99999999L;
            Pickable top = null;

            Pickable current;
            for (current = deque.head(); current != null; current = deque.next()) {
                ItemDefinition definition = ItemDefinition.get(current.id);
                long value = definition.value;
                if (definition.stackable == 1) {
                    value *= current.stackSize + 1;
                }

                if (value > highestValue) {
                    highestValue = value;
                    top = current;
                }
            }

            if (top == null) {
                client.sceneGraph.deleteItemPile(SceneGraph.floorLevel, sceneX, sceneY);
            } else {
                deque.insert(top);
                Pickable var13 = null;
                Pickable var10 = null;

                for (current = deque.head(); current != null; current = deque.next()) {
                    if (top.id != current.id) {
                        if (var13 == null) {
                            var13 = current;
                        }

                        if (current.id != var13.id && var10 == null) {
                            var10 = current;
                        }
                    }
                }

                long uid = EntityUID.build(sceneX, sceneY, 3, false, 0);
                client.sceneGraph.addPickable(SceneGraph.floorLevel, sceneX, sceneY, SceneGraph.getTileHeight(sceneX * 128 + 64, sceneY * 128 + 64, SceneGraph.floorLevel), top, uid, var13, var10);
            }
        }
    }

    protected final Model getModel() {
        return ItemDefinition.get(this.id).getModel(this.stackSize);
    }
}
