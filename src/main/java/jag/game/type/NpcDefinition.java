package jag.game.type;

import jag.Varcs;
import jag.audi.ObjectSound;
import jag.commons.collection.DoublyLinkedNode;
import jag.commons.collection.IterableNodeTable;
import jag.commons.collection.ReferenceCache;
import jag.game.HealthBar;
import jag.game.Vars;
import jag.game.client;
import jag.game.relationship.IgnoreListContext;
import jag.game.scene.entity.Model;
import jag.game.scene.entity.PlayerEntity;
import jag.game.scene.entity.UnlitModel;
import jag.game.stockmarket.StockMarketOfferWorldComparator;
import jag.graphics.JagGraphics3D;
import jag.js5.ReferenceTable;
import jag.opcode.Buffer;
import jag.statics.Statics35;
import jag.statics.Statics52;
import jag.worldmap.WorldMapIcon_Sub1;
import jag.worldmap.RectangularWorldMapAreaChunk;

public class NpcDefinition extends DoublyLinkedNode {

    public static final ReferenceCache cache;
    public static final ReferenceCache modelCache;
    public static ReferenceTable table;
    public static ReferenceTable aReferenceTable697;

    static {
        cache = new ReferenceCache(64);
        modelCache = new ReferenceCache(50);
    }

    public int[] transformIds;
    public String name;
    public int id;
    public int size;
    public int idleAnimation;
    public int walkAnimation;
    public int anInt368;
    public int anInt367;
    public String[] actions;
    public boolean renderedOnMinimap;
    public int anInt366;
    public int anInt696;
    public int combatLevel;
    public boolean renderingPrioritized;
    public int anInt702;
    public int prayerIcon;
    public int anInt694;
    public boolean aBoolean703;
    public boolean aBoolean699;
    public boolean aBoolean698;
    public IterableNodeTable properties;
    public int varpbitIndex;
    public int[] anIntArray691;
    public int varpIndex;
    public int[] modelIds;
    public int scaleXY;
    public short[] textures;
    public int scaleZ;
    public short[] colors;
    public short[] newTextures;
    public short[] newColors;
    public int anInt695;
    public int anInt704;

    public NpcDefinition() {
        this.name = "null";
        this.size = 1;
        this.idleAnimation = -1;
        this.anInt368 = -1;
        this.anInt367 = -1;
        this.walkAnimation = -1;
        this.anInt366 = -1;
        this.anInt696 = -1;
        this.anInt702 = -1;
        this.actions = new String[5];
        this.renderedOnMinimap = true;
        this.combatLevel = -1;
        this.scaleXY = 128;
        this.scaleZ = 128;
        this.renderingPrioritized = false;
        this.anInt695 = 0;
        this.anInt704 = 0;
        this.prayerIcon = -1;
        this.anInt694 = 32;
        this.varpbitIndex = -1;
        this.varpIndex = -1;
        this.aBoolean703 = true;
        this.aBoolean699 = true;
        this.aBoolean698 = false;
    }

    public static void method505(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
        int var7 = var6 - 334;
        if (var7 < 0) {
            var7 = 0;
        } else if (var7 > 100) {
            var7 = 100;
        }

        int var8 = (client.aShort920 - client.aShort913) * var7 / 100 + client.aShort913;
        int var9 = var5 * var8 / 256;
        var7 = 2048 - var3 & 2047;
        var8 = 2048 - var4 & 2047;
        int var10 = 0;
        int var11 = 0;
        int var12 = var9;
        int var13;
        int var14;
        int var15;
        if (var7 != 0) {
            var13 = JagGraphics3D.SIN_TABLE[var7];
            var14 = JagGraphics3D.COS_TABLE[var7];
            var15 = var11 * var14 - var9 * var13 >> 16;
            var12 = var14 * var9 + var13 * var11 >> 16;
            var11 = var15;
        }

        if (var8 != 0) {
            var13 = JagGraphics3D.SIN_TABLE[var8];
            var14 = JagGraphics3D.COS_TABLE[var8];
            var15 = var10 * var14 + var13 * var12 >> 16;
            var12 = var12 * var14 - var10 * var13 >> 16;
            var10 = var15;
        }

        StockMarketOfferWorldComparator.cameraX = var0 - var10;
        Varcs.cameraZ = var1 - var11;
        WorldMapIcon_Sub1.cameraY = var2 - var12;
        IgnoreListContext.cameraPitch = var3;
        RectangularWorldMapAreaChunk.cameraYaw = var4;
        if (client.anInt988 == 1 && client.rights >= 2 && client.engineCycle % 50 == 0 && (ObjectSound.anInt371 >> 7 != PlayerEntity.local.fineX >> 7 || Statics52.anInt498 >> 7 != PlayerEntity.local.fineY >> 7)) {
            var13 = PlayerEntity.local.anInt1473;
            var14 = client.baseX + (ObjectSound.anInt371 >> 7);
            var15 = client.baseY + (Statics52.anInt498 >> 7);
            Statics35.method1171(var14, var15, var13, true);
        }

    }

    public static NpcDefinition get(int id) {
        NpcDefinition var2 = (NpcDefinition) cache.get(id);
        if (var2 != null) {
            return var2;
        }
        byte[] var3 = table.unpack(9, id);
        var2 = new NpcDefinition();
        var2.id = id;
        if (var3 != null) {
            var2.decode(new Buffer(var3));
        }

        var2.method254();
        cache.put(var2, id);
        return var2;
    }

    public final NpcDefinition transform() {
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

        return var2 != -1 ? get(var2) : null;
    }

    public void decodeOpcode(Buffer buffer, int opcode) {
        int var3;
        int var4;
        if (opcode == 1) {
            var3 = buffer.readUByte();
            this.modelIds = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.modelIds[var4] = buffer.readUShort();
            }
        } else if (opcode == 2) {
            this.name = buffer.readString();
        } else if (opcode == 12) {
            this.size = buffer.readUByte();
        } else if (opcode == 13) {
            this.idleAnimation = buffer.readUShort();
        } else if (opcode == 14) {
            this.walkAnimation = buffer.readUShort();
        } else if (opcode == 15) {
            this.anInt368 = buffer.readUShort();
        } else if (opcode == 16) {
            this.anInt367 = buffer.readUShort();
        } else if (opcode == 17) {
            this.walkAnimation = buffer.readUShort();
            this.anInt366 = buffer.readUShort();
            this.anInt696 = buffer.readUShort();
            this.anInt702 = buffer.readUShort();
        } else if (opcode >= 30 && opcode < 35) {
            this.actions[opcode - 30] = buffer.readString();
            if (this.actions[opcode - 30].equalsIgnoreCase("Hidden")) {
                this.actions[opcode - 30] = null;
            }
        } else if (opcode == 40) {
            var3 = buffer.readUByte();
            this.textures = new short[var3];
            this.newTextures = new short[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.textures[var4] = (short) buffer.readUShort();
                this.newTextures[var4] = (short) buffer.readUShort();
            }
        } else if (opcode == 41) {
            var3 = buffer.readUByte();
            this.colors = new short[var3];
            this.newColors = new short[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.colors[var4] = (short) buffer.readUShort();
                this.newColors[var4] = (short) buffer.readUShort();
            }
        } else if (opcode == 60) {
            var3 = buffer.readUByte();
            this.anIntArray691 = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.anIntArray691[var4] = buffer.readUShort();
            }
        } else if (opcode == 93) {
            this.renderedOnMinimap = false;
        } else if (opcode == 95) {
            this.combatLevel = buffer.readUShort();
        } else if (opcode == 97) {
            this.scaleXY = buffer.readUShort();
        } else if (opcode == 98) {
            this.scaleZ = buffer.readUShort();
        } else if (opcode == 99) {
            this.renderingPrioritized = true;
        } else if (opcode == 100) {
            this.anInt695 = buffer.readByte();
        } else if (opcode == 101) {
            this.anInt704 = buffer.readByte();
        } else if (opcode == 102) {
            this.prayerIcon = buffer.readUShort();
        } else if (opcode == 103) {
            this.anInt694 = buffer.readUShort();
        } else if (opcode != 106 && opcode != 118) {
            if (opcode == 107) {
                this.aBoolean703 = false;
            } else if (opcode == 109) {
                this.aBoolean699 = false;
            } else if (opcode == 111) {
                this.aBoolean698 = true;
            } else if (opcode == 249) {
                this.properties = IterableNodeTable.read(buffer, this.properties);
            }
        } else {
            this.varpbitIndex = buffer.readUShort();
            if (this.varpbitIndex == 65535) {
                this.varpbitIndex = -1;
            }

            this.varpIndex = buffer.readUShort();
            if (this.varpIndex == 65535) {
                this.varpIndex = -1;
            }

            var3 = -1;
            if (opcode == 118) {
                var3 = buffer.readUShort();
                if (var3 == 65535) {
                    var3 = -1;
                }
            }

            var4 = buffer.readUByte();
            this.transformIds = new int[var4 + 2];

            for (int var5 = 0; var5 <= var4; ++var5) {
                this.transformIds[var5] = buffer.readUShort();
                if (this.transformIds[var5] == 65535) {
                    this.transformIds[var5] = -1;
                }
            }

            this.transformIds[var4 + 1] = var3;
        }

    }

    public final UnlitModel method507() {
        if (this.transformIds != null) {
            NpcDefinition var1 = this.transform();
            return var1 == null ? null : var1.method507();
        }
        if (this.anIntArray691 == null) {
            return null;
        }
        boolean var2 = false;

        for (int anAnIntArray691 : this.anIntArray691) {
            if (!aReferenceTable697.method913(anAnIntArray691, 0)) {
                var2 = true;
            }
        }

        if (var2) {
            return null;
        }
        UnlitModel[] var4 = new UnlitModel[this.anIntArray691.length];

        for (int var5 = 0; var5 < this.anIntArray691.length; ++var5) {
            var4[var5] = UnlitModel.method982(aReferenceTable697, this.anIntArray691[var5], 0);
        }

        UnlitModel var6;
        if (var4.length == 1) {
            var6 = var4[0];
        } else {
            var6 = new UnlitModel(var4, var4.length);
        }

        int var7;
        if (this.textures != null) {
            for (var7 = 0; var7 < this.textures.length; ++var7) {
                var6.texturize(this.textures[var7], this.newTextures[var7]);
            }
        }

        if (this.colors != null) {
            for (var7 = 0; var7 < this.colors.length; ++var7) {
                var6.colorize(this.colors[var7], this.newColors[var7]);
            }
        }

        return var6;
    }

    public final Model getModel(AnimationSequence anim, int animFrame, AnimationSequence stance, int stanceFrame) {
        if (this.transformIds != null) {
            NpcDefinition trans = this.transform();
            return trans == null ? null : trans.getModel(anim, animFrame, stance, stanceFrame);
        }

        Model staticModel = (Model) modelCache.get(this.id);
        if (staticModel == null) {
            boolean var6 = false;

            for (int modelId : this.modelIds) {
                if (!aReferenceTable697.method913(modelId, 0)) {
                    var6 = true;
                }
            }

            if (var6) {
                return null;
            }

            UnlitModel[] unlit = new UnlitModel[this.modelIds.length];

            for (int i = 0; i < this.modelIds.length; ++i) {
                unlit[i] = UnlitModel.method982(aReferenceTable697, this.modelIds[i], 0);
            }

            UnlitModel base;
            if (unlit.length == 1) {
                base = unlit[0];
            } else {
                base = new UnlitModel(unlit, unlit.length);
            }

            if (this.textures != null) {
                for (int i = 0; i < this.textures.length; ++i) {
                    base.texturize(this.textures[i], this.newTextures[i]);
                }
            }

            if (this.colors != null) {
                for (int i = 0; i < this.colors.length; ++i) {
                    base.colorize(this.colors[i], this.newColors[i]);
                }
            }

            staticModel = base.light(this.anInt695 + 64, this.anInt704 * 5 + 850, -30, -50, -30);
            modelCache.put(staticModel, this.id);
        }

        Model model;
        if (anim != null && stance != null) {
            model = anim.applyStanceAndAnimation(staticModel, animFrame, stance, stanceFrame);
        } else if (anim != null) {
            model = anim.applySequence(staticModel, animFrame);
        } else if (stance != null) {
            model = stance.applySequence(staticModel, stanceFrame);
        } else {
            model = staticModel.method1291(true);
        }

        if (this.scaleXY != 128 || this.scaleZ != 128) {
            model.scale(this.scaleXY, this.scaleZ, this.scaleXY);
        }

        return model;
    }

    public void method254() {
    }

    public void decode(Buffer var1) {
        while (true) {
            int var2 = var1.readUByte();
            if (var2 == 0) {
                return;
            }

            this.decodeOpcode(var1, var2);
        }
    }

    public boolean validate() {
        if (this.transformIds == null) {
            return true;
        }
        int var1 = -1;
        if (this.varpbitIndex != -1) {
            var1 = Varbit.get(this.varpbitIndex);
        } else if (this.varpIndex != -1) {
            var1 = Vars.values[this.varpIndex];
        }

        if (var1 >= 0 && var1 < this.transformIds.length) {
            return this.transformIds[var1] != -1;
        }
        return this.transformIds[this.transformIds.length - 1] != -1;
    }

    public int method511(int var1, int var2) {
        return HealthBar.method696(this.properties, var1, var2);
    }

    public String method504(int var1, String var2) {
        return IterableNodeTable.getStringParameter(this.properties, var1, var2);
    }
}
