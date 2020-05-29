package jag.statics;

import jag.PlayerAccountType;
import jag.game.type.AnimationFrameGroup;
import jag.game.type.AnimationSequence;
import jag.js5.ReferenceTable;

public class Statics13 {
    public static AnimationFrameGroup method870(int var0) {
        AnimationFrameGroup var1 = (AnimationFrameGroup) AnimationSequence.aReferenceCache1228.get(var0);
        if (var1 != null) {
            return var1;
        }
        ReferenceTable var2 = AnimationSequence.aReferenceTable697;
        ReferenceTable var3 = Statics8.aReferenceTable1123;
        boolean var4 = true;
        int[] var5 = var2.getFileIds(var0);

        for (int aVar5 : var5) {
            byte[] var7 = var2.method899(var0, aVar5);
            if (var7 == null) {
                var4 = false;
            } else {
                int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
                byte[] var9 = var3.method899(var8, 0);
                if (var9 == null) {
                    var4 = false;
                }
            }
        }

        AnimationFrameGroup var10;
        if (!var4) {
            var10 = null;
        } else {
            try {
                var10 = new AnimationFrameGroup(var2, var3, var0);
            } catch (Exception var12) {
                var10 = null;
            }
        }

        if (var10 != null) {
            AnimationSequence.aReferenceCache1228.put(var10, var0);
        }

        return var10;
    }

    public static PlayerAccountType[] method871() {
        return new PlayerAccountType[]{PlayerAccountType.anEnum_Sub6_1256, PlayerAccountType.anEnum_Sub6_1259, PlayerAccountType.anEnum_Sub6_1260, PlayerAccountType.anEnum_Sub6_1255, PlayerAccountType.anEnum_Sub6_1252, PlayerAccountType.anEnum_Sub6_1254};
    }
}
