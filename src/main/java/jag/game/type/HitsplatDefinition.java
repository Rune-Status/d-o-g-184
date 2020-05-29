package jag.game.type;

import jag.commons.collection.DoublyLinkedNode;
import jag.commons.collection.ReferenceCache;
import jag.game.HealthBar;
import jag.game.Vars;
import jag.game.relationship.ClanMember;
import jag.game.stockmarket.StockMarketOfferNameComparator;
import jag.graphics.Font;
import jag.graphics.Sprite;
import jag.js5.ReferenceTable;
import jag.opcode.Buffer;

public class HitsplatDefinition extends DoublyLinkedNode {

    public static final ReferenceCache cache;
    public static final ReferenceCache aReferenceCache1513;
    public static final ReferenceCache aReferenceCache1228;
    public static ReferenceTable table;
    public static int anInt1929;
    public static ReferenceTable aReferenceTable1515;

    static {
        cache = new ReferenceCache(64);
        aReferenceCache1228 = new ReferenceCache(64);
        aReferenceCache1513 = new ReferenceCache(20);
    }

    public int textColor;
    public int comparisonType;
    public int duration;
    public int[] transformIds;
    public int offsetX;
    public int fade;
    public int offsetY;
    public int anInt1659;
    public String amount;
    public int varpbitIndex;
    public int iconId;
    public int leftSpriteId;
    public int rightSpriteId;
    public int middleSpriteId;
    public int fontId;
    public int varpIndex;

    public HitsplatDefinition() {
        this.fontId = -1;
        this.textColor = 16777215;
        this.duration = 70;
        this.iconId = -1;
        this.middleSpriteId = -1;
        this.leftSpriteId = -1;
        this.rightSpriteId = -1;
        this.offsetX = 0;
        this.offsetY = 0;
        this.fade = -1;
        this.amount = "";
        this.comparisonType = -1;
        this.anInt1659 = 0;
        this.varpbitIndex = -1;
        this.varpIndex = -1;
    }

    public void method988(Buffer var1, int var2) {
        if (var2 == 1) {
            this.fontId = var1.method1051();
        } else if (var2 == 2) {
            this.textColor = var1.readMediumInt();
        } else if (var2 == 3) {
            this.iconId = var1.method1051();
        } else if (var2 == 4) {
            this.leftSpriteId = var1.method1051();
        } else if (var2 == 5) {
            this.middleSpriteId = var1.method1051();
        } else if (var2 == 6) {
            this.rightSpriteId = var1.method1051();
        } else if (var2 == 7) {
            this.offsetX = var1.method1029();
        } else if (var2 == 8) {
            this.amount = var1.readCString();
        } else if (var2 == 9) {
            this.duration = var1.readUShort();
        } else if (var2 == 10) {
            this.offsetY = var1.method1029();
        } else if (var2 == 11) {
            this.fade = 0;
        } else if (var2 == 12) {
            this.comparisonType = var1.readUByte();
        } else if (var2 == 13) {
            this.anInt1659 = var1.method1029();
        } else if (var2 == 14) {
            this.fade = var1.readUShort();
        } else if (var2 == 17 || var2 == 18) {
            this.varpbitIndex = var1.readUShort();
            if (this.varpbitIndex == 65535) {
                this.varpbitIndex = -1;
            }

            this.varpIndex = var1.readUShort();
            if (this.varpIndex == 65535) {
                this.varpIndex = -1;
            }

            int var3 = -1;
            if (var2 == 18) {
                var3 = var1.readUShort();
                if (var3 == 65535) {
                    var3 = -1;
                }
            }

            int var4 = var1.readUByte();
            this.transformIds = new int[var4 + 2];

            for (int var5 = 0; var5 <= var4; ++var5) {
                this.transformIds[var5] = var1.readUShort();
                if (this.transformIds[var5] == 65535) {
                    this.transformIds[var5] = -1;
                }
            }

            this.transformIds[var4 + 1] = var3;
        }

    }

    public void decode(Buffer var1) {
        while (true) {
            int var2 = var1.readUByte();
            if (var2 == 0) {
                return;
            }

            this.method988(var1, var2);
        }
    }

    public final HitsplatDefinition method1437() {
        int var1 = -1;
        if (this.varpbitIndex != -1) {
            var1 = Varbit.get(this.varpbitIndex);
        } else if (this.varpIndex != -1) {
            var1 = Vars.values[this.varpIndex];
        }

        int var2;
        if (var1 >= 0 && var1 < this.transformIds.length - 1) {
            var2 = this.transformIds[var1];
        } else {
            var2 = this.transformIds[this.transformIds.length - 1];
        }

        if (var2 != -1) {
            HitsplatDefinition var3 = (HitsplatDefinition) cache.get(var2);
            HitsplatDefinition var4;
            if (var3 == null) {
                byte[] var5 = table.unpack(32, var2);
                var3 = new HitsplatDefinition();
                if (var5 != null) {
                    var3.decode(new Buffer(var5));
                }

                cache.put(var3, var2);
            }
            var4 = var3;

            return var4;
        }
        return null;
    }

    public Sprite getIcon() {
        if (this.iconId < 0) {
            return null;
        }
        Sprite var2 = (Sprite) aReferenceCache1228.get(this.iconId);
        if (var2 != null) {
            return var2;
        }
        var2 = Sprite.get(StockMarketOfferNameComparator.aReferenceTable480, this.iconId, 0);
        if (var2 != null) {
            aReferenceCache1228.put(var2, this.iconId);
        }

        return var2;
    }

    public Sprite getMiddleSprite() {
        if (this.middleSpriteId < 0) {
            return null;
        }
        Sprite var2 = (Sprite) aReferenceCache1228.get(this.middleSpriteId);
        if (var2 != null) {
            return var2;
        }
        var2 = Sprite.get(StockMarketOfferNameComparator.aReferenceTable480, this.middleSpriteId, 0);
        if (var2 != null) {
            aReferenceCache1228.put(var2, this.middleSpriteId);
        }

        return var2;
    }

    public Sprite getLeftSprite() {
        if (this.leftSpriteId < 0) {
            return null;
        }
        Sprite var2 = (Sprite) aReferenceCache1228.get(this.leftSpriteId);
        if (var2 != null) {
            return var2;
        }
        var2 = Sprite.get(StockMarketOfferNameComparator.aReferenceTable480, this.leftSpriteId, 0);
        if (var2 != null) {
            aReferenceCache1228.put(var2, this.leftSpriteId);
        }

        return var2;
    }

    public Sprite getRightSprite() {
        if (this.rightSpriteId < 0) {
            return null;
        }
        Sprite var2 = (Sprite) aReferenceCache1228.get(this.rightSpriteId);
        if (var2 != null) {
            return var2;
        }
        var2 = Sprite.get(StockMarketOfferNameComparator.aReferenceTable480, this.rightSpriteId, 0);
        if (var2 != null) {
            aReferenceCache1228.put(var2, this.rightSpriteId);
        }

        return var2;
    }

    public Font method1438() {
        if (this.fontId == -1) {
            return null;
        }
        Font var1 = (Font) aReferenceCache1513.get(this.fontId);
        if (var1 != null) {
            return var1;
        }
        var1 = ClanMember.method708(StockMarketOfferNameComparator.aReferenceTable480, aReferenceTable1515, this.fontId, 0);
        if (var1 != null) {
            aReferenceCache1513.put(var1, this.fontId);
        }

        return var1;
    }

    public String method1436(int var1) {
        String var2 = this.amount;

        while (true) {
            int var3 = var2.indexOf("%1");
            if (var3 < 0) {
                return var2;
            }

            var2 = var2.substring(0, var3) + HealthBar.method692(var1, false) + var2.substring(var3 + 2);
        }
    }
}
