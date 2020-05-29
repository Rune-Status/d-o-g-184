package jag.game.relationship;

import jag.ClientParameter;
import jag.opcode.Buffer;

public class IgnoreListContext extends ChatterContext {

    public static int cameraPitch;
    public final ClientParameter aClientParameter_486;

    public IgnoreListContext(ClientParameter var1) {
        super(400);
        this.aClientParameter_486 = var1;
    }

    Chatter newChatter() {
        return new IgnoredPlayer();
    }

    Chatter[] newArray(int size) {
        return new IgnoredPlayer[size];
    }

    public void method338(Buffer var1, int var2) {
        while (true) {
            if (var1.caret < var2) {
                int var3 = var1.readUByte();
                boolean var4 = (var3 & 1) == 1;
                NamePair var5 = new NamePair(var1.readString(), this.aClientParameter_486);
                NamePair var6 = new NamePair(var1.readString(), this.aClientParameter_486);
                var1.readString();
                if (var5 != null && var5.isFormattedPresent()) {
                    IgnoredPlayer var7 = (IgnoredPlayer) this.getChatterByDisplayName(var5);
                    if (var4) {
                        IgnoredPlayer var8 = (IgnoredPlayer) this.getChatterByDisplayName(var6);
                        if (var8 != null && var7 != var8) {
                            if (var7 != null) {
                                this.remove(var8);
                            } else {
                                var7 = var8;
                            }
                        }
                    }

                    if (var7 != null) {
                        this.update(var7, var5, var6);
                        continue;
                    }

                    if (this.getCount() < 400) {
                        int var9 = this.getCount();
                        var7 = (IgnoredPlayer) this.addAndCache(var5, var6);
                        var7.anInt1147 = var9;
                    }
                    continue;
                }

                throw new IllegalStateException();
            }

            return;
        }
    }
}
