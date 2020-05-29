package jag.game;

import jag.audi.DefaultAudioSystemProvider;
import jag.commons.collection.ReferenceCache;
import jag.game.scene.entity.Model;
import jag.game.scene.entity.UnlitModel;
import jag.game.type.AnimationSequence;
import jag.game.type.IdentikitDefinition;
import jag.game.type.ItemDefinition;
import jag.game.type.NpcDefinition;
import jag.opcode.Buffer;
import jag.statics.Statics21;
import jag.js5.NetWorker;
import jag.worldmap.Enum_Sub9;

public class PlayerAppearance {

    public static final int[] anIntArray1926;
    public static final ReferenceCache aReferenceCache1924;
    public static short[][] aShortArrayArray1928;
    public static short[] aShortArray1927;

    static {
        anIntArray1926 = new int[]{8, 11, 4, 6, 9, 7, 10};
        aReferenceCache1924 = new ReferenceCache(260);
    }

    public int transformedNpcId;
    public boolean female;
    public int[] ids;
    public long aLong1925;
    public int[] equipmentIds;
    public long aLong1923;

    public static int method1426(int var0) {
        return (int) Math.pow(2.0D, 7.0F + (float) var0 / 256.0F);
    }

    public void update(int[] equipmentIds, int[] ids, boolean female, int transformedNpcId) {
        if (equipmentIds == null) {
            equipmentIds = new int[12];

            for (int var5 = 0; var5 < 7; ++var5) {
                for (int var6 = 0; var6 < DefaultAudioSystemProvider.anInt143; ++var6) {
                    IdentikitDefinition var7 = Statics21.method923(var6);
                    if (var7 != null && !var7.aBoolean1517 && var5 + (female ? 7 : 0) == var7.anInt574) {
                        equipmentIds[anIntArray1926[var5]] = var6 + 256;
                        break;
                    }
                }
            }
        }

        this.equipmentIds = equipmentIds;
        this.ids = ids;
        this.female = female;
        this.transformedNpcId = transformedNpcId;
        this.method1429();
    }

    public void method1429() {
        long var1 = this.aLong1925;
        int var3 = this.equipmentIds[5];
        int var4 = this.equipmentIds[9];
        this.equipmentIds[5] = var4;
        this.equipmentIds[9] = var3;
        this.aLong1925 = 0L;

        int var5;
        for (var5 = 0; var5 < 12; ++var5) {
            this.aLong1925 <<= 4;
            if (this.equipmentIds[var5] >= 256) {
                this.aLong1925 += this.equipmentIds[var5] - 256;
            }
        }

        if (this.equipmentIds[0] >= 256) {
            this.aLong1925 += this.equipmentIds[0] - 256 >> 4;
        }

        if (this.equipmentIds[1] >= 256) {
            this.aLong1925 += this.equipmentIds[1] - 256 >> 8;
        }

        for (var5 = 0; var5 < 5; ++var5) {
            this.aLong1925 <<= 3;
            this.aLong1925 += this.ids[var5];
        }

        this.aLong1925 <<= 1;
        this.aLong1925 += this.female ? 1 : 0;
        this.equipmentIds[5] = var3;
        this.equipmentIds[9] = var4;
        if (var1 != 0L && this.aLong1925 != var1) {
            aReferenceCache1924.method337(var1);
        }

    }

    public Model getModel(AnimationSequence var1, int var2, AnimationSequence var3, int var4) {
        if (this.transformedNpcId != -1) {
            return NpcDefinition.get(this.transformedNpcId).getModel(var1, var2, var3, var4);
        }
        long var6 = this.aLong1925;
        int[] var8 = this.equipmentIds;
        if (var1 != null && (var1.offHand >= 0 || var1.mainHand >= 0)) {
            var8 = new int[12];

            System.arraycopy(this.equipmentIds, 0, var8, 0, 12);

            if (var1.offHand >= 0) {
                var6 += var1.offHand - this.equipmentIds[5] << 8;
                var8[5] = var1.offHand;
            }

            if (var1.mainHand >= 0) {
                var6 += var1.mainHand - this.equipmentIds[3] << 16;
                var8[3] = var1.mainHand;
            }
        }

        Model var9 = (Model) aReferenceCache1924.get(var6);
        if (var9 == null) {
            boolean var11 = false;

            int var13;
            for (int var12 = 0; var12 < 12; ++var12) {
                var13 = var8[var12];
                if (var13 >= 256 && var13 < 512 && !Statics21.method923(var13 - 256).method1114()) {
                    var11 = true;
                }

                if (var13 >= 512 && !ItemDefinition.get(var13 - 512).method518(this.female)) {
                    var11 = true;
                }
            }

            if (var11) {
                if (-1L != this.aLong1923) {
                    var9 = (Model) aReferenceCache1924.get(this.aLong1923);
                }

                if (var9 == null) {
                    return null;
                }
            }

            if (var9 == null) {
                UnlitModel[] var14 = new UnlitModel[12];
                var13 = 0;

                int var16;
                for (int var15 = 0; var15 < 12; ++var15) {
                    var16 = var8[var15];
                    UnlitModel var17;
                    if (var16 >= 256 && var16 < 512) {
                        var17 = Statics21.method923(var16 - 256).method978();
                        if (var17 != null) {
                            var14[var13++] = var17;
                        }
                    }

                    if (var16 >= 512) {
                        var17 = ItemDefinition.get(var16 - 512).getEquipmentModel(this.female);
                        if (var17 != null) {
                            var14[var13++] = var17;
                        }
                    }
                }

                UnlitModel var19 = new UnlitModel(var14, var13);

                for (var16 = 0; var16 < 5; ++var16) {
                    if (this.ids[var16] < aShortArrayArray1928[var16].length) {
                        var19.texturize(Enum_Sub9.aShortArray1482[var16], aShortArrayArray1928[var16][this.ids[var16]]);
                    }

                    if (this.ids[var16] < DefaultAudioSystemProvider.aShortArrayArray145[var16].length) {
                        var19.texturize(aShortArray1927[var16], DefaultAudioSystemProvider.aShortArrayArray145[var16][this.ids[var16]]);
                    }
                }

                var9 = var19.light(64, 850, -30, -50, -30);
                aReferenceCache1924.put(var9, var6);
                this.aLong1923 = var6;
            }
        }

        if (var1 == null && var3 == null) {
            return var9;
        }
        Model var18;
        if (var1 != null && var3 != null) {
            var18 = var1.applyStanceAndAnimation(var9, var2, var3, var4);
        } else if (var1 != null) {
            var18 = var1.applySequence(var9, var2);
        } else {
            var18 = var3.applySequence(var9, var4);
        }

        return var18;
    }

    UnlitModel method1427() {
        if (this.transformedNpcId != -1) {
            return NpcDefinition.get(this.transformedNpcId).method507();
        }
        boolean var1 = false;

        int var3;
        for (int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if (var3 >= 256 && var3 < 512 && !Statics21.method923(var3 - 256).method882()) {
                var1 = true;
            }

            if (var3 >= 512 && !ItemDefinition.get(var3 - 512).method530(this.female)) {
                var1 = true;
            }
        }

        if (var1) {
            return null;
        }
        UnlitModel[] var4 = new UnlitModel[12];
        var3 = 0;

        int var6;
        for (int var5 = 0; var5 < 12; ++var5) {
            var6 = this.equipmentIds[var5];
            UnlitModel var7;
            if (var6 >= 256 && var6 < 512) {
                var7 = Statics21.method923(var6 - 256).method1113();
                if (var7 != null) {
                    var4[var3++] = var7;
                }
            }

            if (var6 >= 512) {
                var7 = ItemDefinition.get(var6 - 512).method521(this.female);
                if (var7 != null) {
                    var4[var3++] = var7;
                }
            }
        }

        UnlitModel var8 = new UnlitModel(var4, var3);

        for (var6 = 0; var6 < 5; ++var6) {
            if (this.ids[var6] < aShortArrayArray1928[var6].length) {
                var8.texturize(Enum_Sub9.aShortArray1482[var6], aShortArrayArray1928[var6][this.ids[var6]]);
            }

            if (this.ids[var6] < DefaultAudioSystemProvider.aShortArrayArray145[var6].length) {
                var8.texturize(aShortArray1927[var6], DefaultAudioSystemProvider.aShortArrayArray145[var6][this.ids[var6]]);
            }
        }

        return var8;
    }

    public void method1428(int var1, boolean var2) {
        if (var1 != 1 || !this.female) {
            int var3 = this.equipmentIds[anIntArray1926[var1]];
            if (var3 != 0) {
                var3 -= 256;

                IdentikitDefinition var4;
                do {
                    if (!var2) {
                        --var3;
                        if (var3 < 0) {
                            var3 = DefaultAudioSystemProvider.anInt143 - 1;
                        }
                    } else {
                        ++var3;
                        if (var3 >= DefaultAudioSystemProvider.anInt143) {
                            var3 = 0;
                        }
                    }

                    var4 = Statics21.method923(var3);
                } while (var4 == null || var4.aBoolean1517 || var4.anInt574 != var1 + (this.female ? 7 : 0));

                this.equipmentIds[anIntArray1926[var1]] = var3 + 256;
                this.method1429();
            }
        }
    }

    public void method1432(int var1, boolean var2) {
        int var3 = this.ids[var1];
        if (!var2) {
            do {
                --var3;
                if (var3 < 0) {
                    var3 = aShortArrayArray1928[var1].length - 1;
                }
            } while (!NetWorker.method1094(var1, var3));
        } else {
            do {
                ++var3;
                if (var3 >= aShortArrayArray1928[var1].length) {
                    var3 = 0;
                }
            } while (!NetWorker.method1094(var1, var3));
        }

        this.ids[var1] = var3;
        this.method1429();
    }

    public void method1431(boolean var1) {
        if (this.female != var1) {
            this.update(null, this.ids, var1, -1);
        }
    }

    public void method1430(Buffer var1) {
        var1.writeByte(this.female ? 1 : 0);

        int var2;
        for (var2 = 0; var2 < 7; ++var2) {
            int var3 = this.equipmentIds[anIntArray1926[var2]];
            if (var3 == 0) {
                var1.writeByte(-1);
            } else {
                var1.writeByte(var3 - 256);
            }
        }

        for (var2 = 0; var2 < 5; ++var2) {
            var1.writeByte(this.ids[var2]);
        }

    }

    public int method1433() {
        return this.transformedNpcId == -1 ? (this.equipmentIds[0] << 15) + this.equipmentIds[1] + (this.equipmentIds[11] << 5) + (this.equipmentIds[8] << 10) + (this.ids[0] << 25) + (this.ids[4] << 20) : 305419896 + NpcDefinition.get(this.transformedNpcId).id;
    }
}
