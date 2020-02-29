package com.jagex;

public class Class23 {
    public static final Class23 aClass23_297;
    public static final Class23 aClass23_298;
    public static final Class23 aClass23_295;
    public static final Class23 aClass23_293;
    static final Class23 aClass23_294;
    static int anInt296;

    static {
        aClass23_297 = new Class23("details");
        aClass23_298 = new Class23("compositemap");
        aClass23_295 = new Class23("compositetexture");
        aClass23_294 = new Class23("area");
        aClass23_293 = new Class23("labels");
    }

    public final String aString292;

    Class23(String var1) {
        this.aString292 = var1;
    }

    static void method178() {
        DoublyLinkedNode_Sub11.method989();
    }

    static void refreshPickables(int sceneX, int sceneY) {
        NodeDeque deque = client.pickableNodeDeques[SceneGraph.floorLevel][sceneX][sceneY];
        if (deque == null) {
            client.sceneGraph.deleteItemPile(SceneGraph.floorLevel, sceneX, sceneY);
        } else {
            long highestValue = -99999999L;
            PickableNode top = null;

            PickableNode current;
            for (current = (PickableNode) deque.head(); current != null; current = (PickableNode) deque.next()) {
                ItemDefinition definition = CameraCapture.getItemDefinition(current.id);
                long value = (long) definition.value;
                if (definition.stackable == 1) {
                    value *= (long) (current.stackSize + 1);
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
                PickableNode var13 = null;
                PickableNode var10 = null;

                for (current = (PickableNode) deque.head(); current != null; current = (PickableNode) deque.next()) {
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
}
