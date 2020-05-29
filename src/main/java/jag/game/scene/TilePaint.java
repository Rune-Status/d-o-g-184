package jag.game.scene;

import jag.Login;
import jag.audi.Class97;
import jag.game.client;
import jag.opcode.Buffer;
import jag.statics.Statics19;
import jag.game.stockmarket.Class46;

public final class TilePaint {

    public final int anInt2002;
    public final int anInt2003;
    public final int rgb;
    public final int anInt2001;
    public final int anInt2000;
    public final int texture;
    public boolean flatShade;

    public TilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
        this.flatShade = true;
        this.anInt2002 = var1;
        this.anInt2003 = var2;
        this.anInt2001 = var3;
        this.anInt2000 = var4;
        this.texture = var5;
        this.rgb = var6;
        this.flatShade = var7;
    }

}
