package jag.game.scene;

import jag.game.client;
import jag.graphics.Sprite;

public class HintArrow {

    public static Sprite[] sprites;
    public static Sprite[] overheadSprites;

    public static int state;
    public static int type;

    public static int npc;
    public static int player;

    public static int x;
    public static int y;
    public static int z;

    public static int insetX;
    public static int insetY;

    static {
        type = 0;
        npc = 0;
        player = 0;
        x = 0;
        y = 0;
        z = 0;
        state = 0;
    }

    public static void draw(int baseX, int baseY) {
        if (type == 2) {
            SceneGraph.absoluteToViewport((x - client.baseX << 7) + insetX, (y - client.baseY << 7) + insetY, z * 4);
            if (client.viewportRenderX > -1 && client.engineCycle % 20 < 10) {
                overheadSprites[0].renderAlphaAt(baseX + client.viewportRenderX - 12, client.viewportRenderY + baseY - 28);
            }
        }
    }
}
