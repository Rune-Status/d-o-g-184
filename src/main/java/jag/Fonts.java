package jag;

import jag.game.relationship.ClanMember;
import jag.graphics.BaseFont;
import jag.graphics.Font;
import jag.graphics.NamedFont;
import jag.js5.ReferenceTable;

import java.util.HashMap;

public class Fonts {

    final ReferenceTable aReferenceTable1630;
    final ReferenceTable aReferenceTable1631;
    final HashMap<NamedFont, BaseFont> aHashMap1629;

    public Fonts(ReferenceTable var1, ReferenceTable var2) {
        this.aReferenceTable1630 = var1;
        this.aReferenceTable1631 = var2;
        this.aHashMap1629 = new HashMap<>();
    }

    public HashMap<NamedFont, BaseFont> lookup(NamedFont[] var1) {
        HashMap<NamedFont, BaseFont> map = new HashMap<>();

        for (NamedFont var5 : var1) {
            if (this.aHashMap1629.containsKey(var5)) {
                map.put(var5, this.aHashMap1629.get(var5));
            } else {
                ReferenceTable var6 = this.aReferenceTable1630;
                String var8 = var5.name;
                int var9 = var6.get(var8);
                int var10 = var6.method907(var9, "");
                Font var11 = ClanMember.method708(var6, this.aReferenceTable1631, var9, var10);
                if (var11 != null) {
                    this.aHashMap1629.put(var5, var11);
                    map.put(var5, var11);
                }
            }
        }

        return map;
    }
}
