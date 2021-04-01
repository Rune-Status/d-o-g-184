package jag.game.scene.entity;

import jag.commons.collection.NodeDeque;
import jag.game.client;
import jag.game.scene.SceneGraph;
import jag.game.stockmarket.StockMarketMediator;
import jag.game.type.ItemDefinition;

public final class Pickable extends Entity {

    public static StockMarketMediator aStockMarketMediator_890;

    public int id;
    public int stackSize;

    public Pickable() {

    }

    public static void refresh(int sceneX, int sceneY) {
        NodeDeque<Pickable> deque = client.pickables[SceneGraph.floorLevel][sceneX][sceneY];
        if (deque == null) {
            client.sceneGraph.deleteItemPile(SceneGraph.floorLevel, sceneX, sceneY);
            return;
        }

        long highestValue = -99999999L;
        Pickable bottom = null;

        for (Pickable current = deque.head(); current != null; current = deque.next()) {
            ItemDefinition definition = ItemDefinition.get(current.id);
            long value = definition.value;
            if (definition.stackable == 1) {
                value *= current.stackSize + 1;
            }

            if (value > highestValue) {
                highestValue = value;
                bottom = current;
            }
        }

        if (bottom == null) {
            client.sceneGraph.deleteItemPile(SceneGraph.floorLevel, sceneX, sceneY);
            return;
        }

        deque.insert(bottom);
        Pickable middle = null;
        Pickable top = null;

        for (Pickable current = deque.head(); current != null; current = deque.next()) {
            if (bottom.id != current.id) {
                if (middle == null) {
                    middle = current;
                }

                if (current.id != middle.id && top == null) {
                    top = current;
                }
            }
        }

        long uid = EntityUID.build(sceneX, sceneY, 3, false, 0);
        client.sceneGraph.addPickable(SceneGraph.floorLevel, sceneX, sceneY, SceneGraph.getTileHeight(sceneX * 128 + 64, sceneY * 128 + 64, SceneGraph.floorLevel), bottom, uid, middle, top);
    }

    protected final Model getModel() {
        return ItemDefinition.get(id).getModel(stackSize);
    }
}
