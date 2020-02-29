package com.jagex;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class Class7 {
    public static Class112 aClass112_118;
    static Sprite[] skullIconSprites;

    static {
        aClass112_118 = new Class112(37748736, 256);
    }

    final HashMap aHashMap117;
    List aList119;
    java.util.LinkedList aLinkedList122;
    HashMap aHashMap125;
    int anInt115;
    Class63_Sub2 aClass63_Sub2_124;
    int anInt120;
    int anInt116;
    int anInt123;

    Class7(int var1, int var2, int var3, HashMap var4) {
        this.anInt115 = var1;
        this.anInt116 = var2;
        this.aLinkedList122 = new java.util.LinkedList();
        this.aList119 = new java.util.LinkedList();
        this.aHashMap125 = new HashMap();
        this.anInt123 = var3 | -16777216;
        this.aHashMap117 = var4;
    }

    static Node_Sub16 method59(ReferenceTable var0, int var1) {
        byte[] var2 = var0.method904(var1);
        return var2 == null ? null : new Node_Sub16(var2);
    }

    public static File method60(String var0, String var1, int var2) {
        String var3 = var2 == 0 ? "" : "" + var2;
        Statics5.aFile837 = new File(Statics5.aString839, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
        String var4 = null;
        String var5 = null;
        boolean var6 = false;
        Buffer var8;
        int var12;
        File var27;
        if (Statics5.aFile837.exists()) {
            try {
                DiskFile var7 = new DiskFile(Statics5.aFile837, "rw", 10000L);

                int var9;
                for (var8 = new Buffer((int) var7.length()); var8.caret < var8.payload.length; var8.caret += var9) {
                    var9 = var7.read(var8.payload, var8.caret, var8.payload.length - var8.caret);
                    if (var9 == -1) {
                        throw new IOException();
                    }
                }

                var8.caret = 0;
                var9 = var8.readUByte();
                if (var9 < 1 || var9 > 3) {
                    throw new IOException("" + var9);
                }

                int var10 = 0;
                if (var9 > 1) {
                    var10 = var8.readUByte();
                }

                if (var9 <= 2) {
                    var4 = var8.readCString();
                    if (var10 == 1) {
                        var5 = var8.readCString();
                    }
                } else {
                    var4 = var8.method1045();
                    if (var10 == 1) {
                        var5 = var8.method1045();
                    }
                }

                var7.close();
            } catch (IOException var25) {
                var25.printStackTrace();
            }

            if (var4 != null) {
                var27 = new File(var4);
                if (!var27.exists()) {
                    var4 = null;
                }
            }

            if (var4 != null) {
                var27 = new File(var4, "test.dat");

                boolean var28;
                try {
                    RandomAccessFile var11 = new RandomAccessFile(var27, "rw");
                    var12 = var11.read();
                    var11.seek(0L);
                    var11.write(var12);
                    var11.seek(0L);
                    var11.close();
                    var27.delete();
                    var28 = true;
                } catch (Exception var23) {
                    var28 = false;
                }

                if (!var28) {
                    var4 = null;
                }
            }
        }

        if (var4 == null && var2 == 0) {
            label159:
            for (int var13 = 0; var13 < Statics29.aStringArray1533.length; ++var13) {
                for (int var14 = 0; var14 < Class114.cacheDirectories.length; ++var14) {
                    File var15 = new File(Class114.cacheDirectories[var14] + Statics29.aStringArray1533[var13] + File.separatorChar + var0 + File.separatorChar);
                    if (var15.exists()) {
                        File var16 = new File(var15, "test.dat");

                        boolean var30;
                        try {
                            RandomAccessFile var17 = new RandomAccessFile(var16, "rw");
                            int var18 = var17.read();
                            var17.seek(0L);
                            var17.write(var18);
                            var17.seek(0L);
                            var17.close();
                            var16.delete();
                            var30 = true;
                        } catch (Exception var22) {
                            var30 = false;
                        }

                        if (var30) {
                            var4 = var15.toString();
                            var6 = true;
                            break label159;
                        }
                    }
                }
            }
        }

        if (var4 == null) {
            var4 = Statics5.aString839 + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
            var6 = true;
        }

        File var26;
        if (var5 != null) {
            var26 = new File(var5);
            var27 = new File(var4);

            try {

                for (var12 = 0; var12 < var26.listFiles().length; ++var12) {
                    File var34 = var26.listFiles()[var12];
                    File var19 = new File(var27, var34.getName());
                    boolean var20 = var34.renameTo(var19);
                    if (!var20) {
                        throw new IOException();
                    }
                }
            } catch (Exception var24) {
                var24.printStackTrace();
            }

            var6 = true;
        }

        if (var6) {
            var26 = new File(var4);
            var8 = null;

            try {
                DiskFile var33 = new DiskFile(Statics5.aFile837, "rw", 10000L);
                Buffer var31 = new Buffer(500);
                var31.writeByte(3);
                var31.writeByte(var8 != null ? 1 : 0);
                var31.method1052(var26.getPath());
                if (var8 != null) {
                    var31.method1052("");
                }

                var33.write(var31.payload, 0, var31.caret);
                var33.close();
            } catch (IOException var21) {
                var21.printStackTrace();
            }
        }

        return new File(var4);
    }

    void method42(int var1, int var2, Class63 var3) {
        for (int var4 = 0; var4 < var3.anInt512; ++var4) {
            Class69[] var5 = var3.aClass69ArrayArrayArrayArray511[var4][var1][var2];
            if (var5 != null && var5.length != 0) {

                for (Class69 var8 : var5) {
                    int var9 = var8.anInt544;
                    boolean var10 = var9 >= Enum_Sub7.anEnum_Sub7_1287.anInt1267 && var9 <= Enum_Sub7.anEnum_Sub7_1282.anInt1267 || var9 == Enum_Sub7.anEnum_Sub7_1279.anInt1267;
                    if (var10) {
                        ObjectDefinition var11 = Class38.getObjectDefinition(var8.anInt542);
                        int var12 = var11.mapDoorFlag != 0 ? -3407872 : -3355444;
                        if (var8.anInt544 == Enum_Sub7.anEnum_Sub7_1287.anInt1267) {
                            this.method39(var1, var2, var8.anInt541, var12);
                        }

                        if (var8.anInt544 == Enum_Sub7.anEnum_Sub7_1283.anInt1267) {
                            this.method39(var1, var2, var8.anInt541, -3355444);
                            this.method39(var1, var2, var8.anInt541 + 1, var12);
                        }

                        if (var8.anInt544 == Enum_Sub7.anEnum_Sub7_1282.anInt1267) {
                            if (var8.anInt541 == 0) {
                                JagGraphics.drawHorizontalLine(this.anInt120 * var1, this.anInt120 * (63 - var2), 1, var12);
                            }

                            if (var8.anInt541 == 1) {
                                JagGraphics.drawHorizontalLine(this.anInt120 * var1 + this.anInt120 - 1, this.anInt120 * (63 - var2), 1, var12);
                            }

                            if (var8.anInt541 == 2) {
                                JagGraphics.drawHorizontalLine(this.anInt120 + this.anInt120 * var1 - 1, this.anInt120 * (63 - var2) + this.anInt120 - 1, 1, var12);
                            }

                            if (var8.anInt541 == 3) {
                                JagGraphics.drawHorizontalLine(this.anInt120 * var1, this.anInt120 * (63 - var2) + this.anInt120 - 1, 1, var12);
                            }
                        }

                        if (var8.anInt544 == Enum_Sub7.anEnum_Sub7_1279.anInt1267) {
                            int var13 = var8.anInt541 % 2;
                            int var14;
                            if (var13 == 0) {
                                for (var14 = 0; var14 < this.anInt120; ++var14) {
                                    JagGraphics.drawHorizontalLine(var14 + this.anInt120 * var1, (64 - var2) * this.anInt120 - 1 - var14, 1, var12);
                                }
                            } else {
                                for (var14 = 0; var14 < this.anInt120; ++var14) {
                                    JagGraphics.drawHorizontalLine(var14 + this.anInt120 * var1, var14 + this.anInt120 * (63 - var2), 1, var12);
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    void method40(int var1, int var2, HashSet var3, int var4) {
        float var5 = (float) var4 / 64.0F;
        float var6 = var5 / 2.0F;

        for (Object o : this.aHashMap125.entrySet()) {
            Entry var8 = (Entry) o;
            SceneOffset var9 = (SceneOffset) var8.getKey();
            int var10 = (int) ((float) var1 + var5 * (float) var9.anInt1891 - var6);
            int var11 = (int) ((float) (var2 + var4) - var5 * (float) var9.anInt1892 - var6);
            Class27 var12 = (Class27) var8.getValue();
            if (var12 != null && var12.method195()) {
                var12.anInt315 = var10;
                var12.anInt316 = var11;
                DoublyLinkedNode_Sub15 var13 = Class98.method545(var12.method199());
                if (!var3.contains(var13.method1082())) {
                    this.method46(var12, var10, var11, var5);
                }
            }
        }

    }

    void method31(int var1, int var2, Class63 var3, DoublyLinkedNode_Sub24_Sub4[] var4) {
        for (int var5 = 0; var5 < var3.anInt512; ++var5) {
            Class69[] var6 = var3.aClass69ArrayArrayArrayArray511[var5][var1][var2];
            if (var6 != null && var6.length != 0) {

                for (Class69 var9 : var6) {
                    if (!Statics24.method966(var9.anInt544)) {
                        int var10 = var9.anInt544;
                        boolean var11 = var10 == Enum_Sub7.anEnum_Sub7_1273.anInt1267;
                        if (!var11) {
                            continue;
                        }
                    }

                    ObjectDefinition var12 = Class38.getObjectDefinition(var9.anInt542);
                    if (var12.mapSceneId != -1) {
                        if (var12.mapSceneId != 46 && var12.mapSceneId != 52) {
                            var4[var12.mapSceneId].method1322(this.anInt120 * var1, this.anInt120 * (63 - var2), this.anInt120 * 2, this.anInt120 * 2);
                        } else {
                            var4[var12.mapSceneId].method1322(this.anInt120 * var1, this.anInt120 * (63 - var2), this.anInt120 * 2 + 1, this.anInt120 * 2 + 1);
                        }
                    }
                }
            }
        }

    }

    void method53(int var1, int var2, Class63 var3, Class16 var4, Class37 var5) {
        int var6 = var3.aShortArrayArrayArray518[0][var1][var2] - 1;
        int var7 = var3.aShortArrayArrayArray508[0][var1][var2] - 1;
        if (var6 == -1 && var7 == -1) {
            JagGraphics.fillRect(this.anInt120 * var1, this.anInt120 * (63 - var2), this.anInt120, this.anInt120, this.anInt123);
        }

        int var8 = 16711935;
        int var12;
        if (var7 != -1) {
            int var9 = this.anInt123;
            DoublyLinkedNode_Sub14 var10 = (DoublyLinkedNode_Sub14) DoublyLinkedNode_Sub14.aReferenceCache385.get((long) var7);
            DoublyLinkedNode_Sub14 var11;
            if (var10 != null) {
                var11 = var10;
            } else {
                byte[] var13 = DoublyLinkedNode_Sub14.aReferenceTable383.unpack(4, var7);
                var10 = new DoublyLinkedNode_Sub14();
                if (var13 != null) {
                    var10.method1010(new Buffer(var13));
                }

                var10.method499();
                DoublyLinkedNode_Sub14.aReferenceCache385.put(var10, (long) var7);
                var11 = var10;
            }

            if (var11 == null) {
                var12 = var9;
            } else if (var11.anInt112 >= 0) {
                var12 = var11.anInt112 | -16777216;
            } else {
                int var14;
                byte var15;
                int var16;
                int var18;
                if (var11.anInt377 >= 0) {
                    var14 = JagGraphics3D.aTextureProvider783.method1424(var11.anInt377);
                    var15 = 96;
                    if (var14 == -2) {
                        var16 = 12345678;
                    } else if (var14 == -1) {
                        if (var15 < 0) {
                            var15 = 0;
                        } else if (var15 > 127) {
                            var15 = 127;
                        }

                        var18 = 127 - var15;
                        var16 = var18;
                    } else {
                        var18 = var15 * (var14 & 127) / 128;
                        if (var18 < 2) {
                            var18 = 2;
                        } else if (var18 > 126) {
                            var18 = 126;
                        }

                        var16 = var18 + (var14 & 65408);
                    }

                    var12 = JagGraphics3D.anIntArray782[var16] | -16777216;
                } else if (var11.anInt378 == 16711935) {
                    var12 = var9;
                } else {
                    var16 = Class123_Sub1.method293(var11.anInt375, var11.anInt372, var11.anInt379);
                    var15 = 96;
                    if (var16 == -2) {
                        var14 = 12345678;
                    } else if (var16 == -1) {
                        if (var15 < 0) {
                            var15 = 0;
                        } else if (var15 > 127) {
                            var15 = 127;
                        }

                        var18 = 127 - var15;
                        var14 = var18;
                    } else {
                        var18 = var15 * (var16 & 127) / 128;
                        if (var18 < 2) {
                            var18 = 2;
                        } else if (var18 > 126) {
                            var18 = 126;
                        }

                        var14 = var18 + (var16 & 65408);
                    }

                    var12 = JagGraphics3D.anIntArray782[var14] | -16777216;
                }
            }

            var8 = var12;
        }

        if (var7 > -1 && var3.aByteArrayArrayArray506[0][var1][var2] == 0) {
            JagGraphics.fillRect(this.anInt120 * var1, this.anInt120 * (63 - var2), this.anInt120, this.anInt120, var8);
        } else {
            var12 = this.method38(var1, var2, var3, var5);
            if (var7 == -1) {
                JagGraphics.fillRect(this.anInt120 * var1, this.anInt120 * (63 - var2), this.anInt120, this.anInt120, var12);
            } else {
                var4.method129(this.anInt120 * var1, this.anInt120 * (63 - var2), var12, var8, this.anInt120, this.anInt120, var3.aByteArrayArrayArray506[0][var1][var2], var3.aByteArrayArrayArray505[0][var1][var2]);
            }
        }
    }

    void method56(int var1, int var2, HashSet var3, int var4) {
        float var5 = (float) var4 / 64.0F;

        for (Object anAList119 : this.aList119) {
            Class27 var7 = (Class27) anAList119;
            if (var7.method195()) {
                int var8 = var7.aSceneOffset313.anInt1891 % 64;
                int var9 = var7.aSceneOffset313.anInt1892 % 64;
                var7.anInt315 = (int) (var5 * (float) var8 + (float) var1);
                var7.anInt316 = (int) ((float) var2 + (float) (63 - var9) * var5);
                if (!var3.contains(var7.method199())) {
                    this.method46(var7, var7.anInt315, var7.anInt316, var5);
                }
            }
        }

    }

    int method51(Sprite var1, Enum_Sub9 var2) {
        switch (var2.anInt633) {
            case 1:
                return 0;
            case 2:
                return -var1.width / 2;
            default:
                return -var1.width;
        }
    }

    void method58(List var1) {

        for (Object aVar1 : var1) {
            Class27_Sub2 var3 = (Class27_Sub2) aVar1;
            if (var3.aSceneOffset313.anInt1891 >> 6 == this.anInt115 && var3.aSceneOffset313.anInt1892 >> 6 == this.anInt116) {
                Class27_Sub2 var4 = new Class27_Sub2(var3.aSceneOffset313, var3.aSceneOffset313, var3.anInt491, this.method41(var3.anInt491));
                this.aList119.add(var4);
            }
        }

    }

    void method35(int var1, int var2, Class63 var3, DoublyLinkedNode_Sub24_Sub4[] var5) {
        this.method42(var1, var2, var3);
        this.method31(var1, var2, var3, var5);
    }

    Class34 method29(DoublyLinkedNode_Sub15 var1) {
        if (var1.aString1474 != null && this.aHashMap117 != null && this.aHashMap117.get(Class65.aClass65_531) != null) {
            int var2 = var1.anInt564;
            Class65[] var3 = Class65.method364();
            int var4 = 0;

            Class65 var6;
            while (true) {
                if (var4 >= var3.length) {
                    var6 = null;
                    break;
                }

                Class65 var5 = var3[var4];
                if (var2 == var5.anInt527) {
                    var6 = var5;
                    break;
                }

                ++var4;
            }

            if (var6 == null) {
                return null;
            }
            Font var7 = (Font) this.aHashMap117.get(var6);
            if (var7 == null) {
                return null;
            }
            int var8 = var7.method1150(var1.aString1474, 1000000);
            String[] var9 = new String[var8];
            var7.method1161(var1.aString1474, null, var9);
            int var10 = var9.length * var7.anInt375 / 2;
            int var11 = 0;

            for (String var14 : var9) {
                int var15 = var7.method1145(var14);
                if (var15 > var11) {
                    var11 = var15;
                }
            }

            return new Class34(var1.aString1474, var11, var10, var6);
        }
        return null;
    }

    void method27(HashSet var1, int var2, int var3) {

        for (Object anAList119 : this.aList119) {
            Class27 var5 = (Class27) anAList119;
            if (var5.method195()) {
                DoublyLinkedNode_Sub15 var6 = Class98.method545(var5.method199());
                if (var6 != null && var1.contains(var6.method1082())) {
                    this.method24(var6, var5.anInt315, var5.anInt316, var2, var3);
                }
            }
        }

    }

    void method34(int var1, int var2, Class63 var3, Class16 var4) {
        for (int var5 = 1; var5 < var3.anInt512; ++var5) {
            int var6 = var3.aShortArrayArrayArray508[var5][var1][var2] - 1;
            if (var6 > -1) {
                int var7 = this.anInt123;
                DoublyLinkedNode_Sub14 var8 = (DoublyLinkedNode_Sub14) DoublyLinkedNode_Sub14.aReferenceCache385.get((long) var6);
                DoublyLinkedNode_Sub14 var9;
                if (var8 != null) {
                    var9 = var8;
                } else {
                    byte[] var12 = DoublyLinkedNode_Sub14.aReferenceTable383.unpack(4, var6);
                    var8 = new DoublyLinkedNode_Sub14();
                    if (var12 != null) {
                        var8.method1010(new Buffer(var12));
                    }

                    var8.method499();
                    DoublyLinkedNode_Sub14.aReferenceCache385.put(var8, (long) var6);
                    var9 = var8;
                }

                int var10;
                if (var9 == null) {
                    var10 = var7;
                } else if (var9.anInt112 >= 0) {
                    var10 = var9.anInt112 | -16777216;
                } else {
                    int var13;
                    byte var14;
                    int var15;
                    int var17;
                    if (var9.anInt377 >= 0) {
                        var13 = JagGraphics3D.aTextureProvider783.method1424(var9.anInt377);
                        var14 = 96;
                        if (var13 == -2) {
                            var15 = 12345678;
                        } else if (var13 == -1) {
                            if (var14 < 0) {
                                var14 = 0;
                            } else if (var14 > 127) {
                                var14 = 127;
                            }

                            var17 = 127 - var14;
                            var15 = var17;
                        } else {
                            var17 = var14 * (var13 & 127) / 128;
                            if (var17 < 2) {
                                var17 = 2;
                            } else if (var17 > 126) {
                                var17 = 126;
                            }

                            var15 = var17 + (var13 & 65408);
                        }

                        var10 = JagGraphics3D.anIntArray782[var15] | -16777216;
                    } else if (var9.anInt378 == 16711935) {
                        var10 = var7;
                    } else {
                        var15 = Class123_Sub1.method293(var9.anInt375, var9.anInt372, var9.anInt379);
                        var14 = 96;
                        if (var15 == -2) {
                            var13 = 12345678;
                        } else if (var15 == -1) {
                            if (var14 < 0) {
                                var14 = 0;
                            } else if (var14 > 127) {
                                var14 = 127;
                            }

                            var17 = 127 - var14;
                            var13 = var17;
                        } else {
                            var17 = var14 * (var15 & 127) / 128;
                            if (var17 < 2) {
                                var17 = 2;
                            } else if (var17 > 126) {
                                var17 = 126;
                            }

                            var13 = var17 + (var15 & 65408);
                        }

                        var10 = JagGraphics3D.anIntArray782[var13] | -16777216;
                    }
                }

                if (var3.aByteArrayArrayArray506[var5][var1][var2] == 0) {
                    JagGraphics.fillRect(this.anInt120 * var1, this.anInt120 * (63 - var2), this.anInt120, this.anInt120, var10);
                } else {
                    var4.method129(this.anInt120 * var1, this.anInt120 * (63 - var2), 0, var10, this.anInt120, this.anInt120, var3.aByteArrayArrayArray506[var5][var1][var2], var3.aByteArrayArrayArray505[var5][var1][var2]);
                }
            }
        }

    }

    void method49(DoublyLinkedNode_Sub15 var1, int var2, int var3) {
        Sprite var4 = var1.method1083();
        if (var4 != null) {
            int var5 = this.method51(var4, var1.anEnum_Sub9_1477);
            int var6 = this.method45(var4, var1.anEnum_Sub8_1472);
            var4.method809(var5 + var2, var3 + var6);
        }

    }

    int method45(Sprite var1, Enum_Sub8 var2) {
        switch (var2.anInt633) {
            case 0:
                return 0;
            case 2:
                return -var1.height / 2;
            default:
                return -var1.height;
        }
    }

    void method25(Class27 var1, DoublyLinkedNode_Sub15 var2, int var3, int var4, float var5) {
        Class34 var6 = var1.method201();
        if (var6 != null) {
            if (var6.aClass65_338.method366(var5)) {
                Font var7 = (Font) this.aHashMap117.get(var6.aClass65_338);
                var7.method1149(var6.aString340, var3 - var6.anInt342 / 2, var4, var6.anInt342, var6.anInt339, -16777216 | var2.anInt379, 0, 1, 0, var7.anInt375 / 2);
            }
        }
    }

    void method48(int var1, int var2, int var3, int var4, Class63 var5) {
        for (int var6 = var1; var6 < var3 + var1; ++var6) {
            label73:
            for (int var7 = var2; var7 < var2 + var4; ++var7) {
                for (int var8 = 0; var8 < var5.anInt512; ++var8) {
                    Class69[] var9 = var5.aClass69ArrayArrayArrayArray511[var8][var6][var7];
                    if (var9 != null && var9.length != 0) {

                        for (Class69 aVar10 : var9) {
                            ObjectDefinition var13;
                            boolean var18;
                            label64:
                            {
                                var13 = Class38.getObjectDefinition(aVar10.anInt542);
                                if (var13.transformIds != null) {
                                    int[] var14 = var13.transformIds;

                                    for (int var16 : var14) {
                                        ObjectDefinition var17 = Class38.getObjectDefinition(var16);
                                        if (var17.mapFunction != -1) {
                                            var18 = true;
                                            break label64;
                                        }
                                    }
                                } else if (var13.mapFunction != -1) {
                                    var18 = true;
                                    break label64;
                                }

                                var18 = false;
                            }

                            if (var18) {
                                this.method50(var13, var8, var6, var7, var5);
                                continue label73;
                            }
                        }
                    }
                }
            }
        }

    }

    boolean method30(ReferenceTable var1) {
        this.aHashMap125.clear();
        if (this.aClass63_Sub2_124 != null) {
            this.aClass63_Sub2_124.method354(var1);
            if (this.aClass63_Sub2_124.method359()) {
                this.method48(0, 0, 64, 64, this.aClass63_Sub2_124);
                return true;
            }
            return false;
        }
        boolean var2 = true;

        Iterator var3;
        Class63_Sub1 var4;
        for (var3 = this.aLinkedList122.iterator(); var3.hasNext(); var2 &= var4.method359()) {
            var4 = (Class63_Sub1) var3.next();
            var4.method354(var1);
        }

        if (var2) {
            var3 = this.aLinkedList122.iterator();

            while (var3.hasNext()) {
                var4 = (Class63_Sub1) var3.next();
                this.method48(var4.method110() * 8, var4.method108() * 8, 8, 8, var4);
            }
        }

        return var2;
    }

    List method36() {
        java.util.LinkedList var1 = new java.util.LinkedList();
        var1.addAll(this.aList119);
        var1.addAll(this.aHashMap125.values());
        return var1;
    }

    Class34 method41(int var1) {
        DoublyLinkedNode_Sub15 var2 = Class98.method545(var1);
        return this.method29(var2);
    }

    int method38(int var1, int var2, Class63 var3, Class37 var4) {
        return var3.aShortArrayArrayArray518[0][var1][var2] == 0 ? this.anInt123 : var4.method244(var1, var2);
    }

    void method50(ObjectDefinition var1, int var2, int var3, int var4, Class63 var5) {
        SceneOffset var6 = new SceneOffset(var2, var3 + this.anInt115 * 64, this.anInt116 * 64 + var4);
        SceneOffset var7 = null;
        if (this.aClass63_Sub2_124 != null) {
            var7 = new SceneOffset(this.aClass63_Sub2_124.anInt515 + var2, var3 + this.aClass63_Sub2_124.anInt519 * 64, this.aClass63_Sub2_124.anInt510 * 4096 + var4);
        } else {
            Class63_Sub1 var8 = (Class63_Sub1) var5;
            var7 = new SceneOffset(var2 + var8.anInt515, var8.anInt519 * 64 + var3 + var8.method107() * 8, var8.anInt510 * 4096 + var4 + var8.method106() * 8);
        }

        Object var10;
        if (var1.transformIds != null) {
            var10 = new Class27_Sub1(var7, var6, var1.anInt693, this);
        } else {
            DoublyLinkedNode_Sub15 var9 = Class98.method545(var1.mapFunction);
            var10 = new Class27_Sub2(var7, var6, var9.anInt574, this.method29(var9));
        }

        this.aHashMap125.put(new SceneOffset(0, var3, var4), var10);
    }

    void method24(DoublyLinkedNode_Sub15 var1, int var2, int var3, int var4, int var5) {
        Sprite var6 = var1.method1083();
        if (var6 != null) {
            var6.method809(var2 - var6.width / 2, var3 - var6.height / 2);
            if (var4 % var5 < var5 / 2) {
                JagGraphics.method1367(var2, var3, 15, 16776960, 128);
                JagGraphics.method1367(var2, var3, 7, 16777215, 256);
            }

        }
    }

    void method43() {

        for (Object o : this.aHashMap125.values()) {
            Class27 var2 = (Class27) o;
            if (var2 instanceof Class27_Sub1) {
                ((Class27_Sub1) var2).method341();
            }
        }

    }

    void method46(Class27 var1, int var2, int var3, float var4) {
        DoublyLinkedNode_Sub15 var5 = Class98.method545(var1.method199());
        this.method49(var5, var2, var3);
        this.method25(var1, var5, var2, var3, var4);
    }

    void method26(HashSet var1, int var2, int var3) {

        for (Object o : this.aHashMap125.values()) {
            Class27 var5 = (Class27) o;
            if (var5.method195()) {
                int var6 = var5.method199();
                if (var1.contains(var6)) {
                    DoublyLinkedNode_Sub15 var7 = Class98.method545(var6);
                    this.method24(var7, var5.anInt315, var5.anInt316, var2, var3);
                }
            }
        }

        this.method27(var1, var2, var3);
    }

    void method39(int var1, int var2, int var3, int var4) {
        var3 %= 4;
        if (var3 == 0) {
            JagGraphics.drawVerticalLine(this.anInt120 * var1, this.anInt120 * (63 - var2), this.anInt120, var4);
        }

        if (var3 == 1) {
            JagGraphics.drawHorizontalLine(this.anInt120 * var1, this.anInt120 * (63 - var2), this.anInt120, var4);
        }

        if (var3 == 2) {
            JagGraphics.drawVerticalLine(this.anInt120 * var1 + this.anInt120 - 1, this.anInt120 * (63 - var2), this.anInt120, var4);
        }

        if (var3 == 3) {
            JagGraphics.drawHorizontalLine(this.anInt120 * var1, this.anInt120 * (63 - var2) + this.anInt120 - 1, this.anInt120, var4);
        }

    }

    void method57(Class16 var1, DoublyLinkedNode_Sub24_Sub4[] var2, Class37 var3) {
        Iterator var4 = this.aLinkedList122.iterator();

        Class63_Sub1 var5;
        int var6;
        int var7;
        while (var4.hasNext()) {
            var5 = (Class63_Sub1) var4.next();

            for (var6 = var5.method110() * 8; var6 < var5.method110() * 8 + 8; ++var6) {
                for (var7 = var5.method108() * 8; var7 < var5.method108() * 8 + 8; ++var7) {
                    this.method53(var6, var7, var5, var1, var3);
                    this.method34(var6, var7, var5, var1);
                }
            }
        }

        var4 = this.aLinkedList122.iterator();

        while (var4.hasNext()) {
            var5 = (Class63_Sub1) var4.next();

            for (var6 = var5.method110() * 8; var6 < var5.method110() * 8 + 8; ++var6) {
                for (var7 = var5.method108() * 8; var7 < var5.method108() * 8 + 8; ++var7) {
                    this.method35(var6, var7, var5, var2);
                }
            }
        }

    }

    void method33(Class16 var1, DoublyLinkedNode_Sub24_Sub4[] var2, Class37 var3) {
        int var4;
        int var5;
        for (var4 = 0; var4 < 64; ++var4) {
            for (var5 = 0; var5 < 64; ++var5) {
                this.method53(var4, var5, this.aClass63_Sub2_124, var1, var3);
                this.method34(var4, var5, this.aClass63_Sub2_124, var1);
            }
        }

        for (var4 = 0; var4 < 64; ++var4) {
            for (var5 = 0; var5 < 64; ++var5) {
                this.method35(var4, var5, this.aClass63_Sub2_124, var2);
            }
        }

    }

    void method47(int var1, int var2, int var3, HashSet var4) {
        if (var4 == null) {
            var4 = new HashSet();
        }

        this.method40(var1, var2, var4, var3);
        this.method56(var1, var2, var4, var3);
    }

    List method44(int var1, int var2, int var3, int var4, int var5) {
        java.util.LinkedList var6 = new java.util.LinkedList();
        if (var4 >= var1 && var5 >= var2) {
            if (var4 < var3 + var1 && var5 < var3 + var2) {
                Iterator var7 = this.aHashMap125.values().iterator();

                Class27 var8;
                while (var7.hasNext()) {
                    var8 = (Class27) var7.next();
                    if (var8.method195() && var8.method200(var4, var5)) {
                        var6.add(var8);
                    }
                }

                var7 = this.aList119.iterator();

                while (var7.hasNext()) {
                    var8 = (Class27) var7.next();
                    if (var8.method195() && var8.method200(var4, var5)) {
                        var6.add(var8);
                    }
                }

                return var6;
            }
            return var6;
        }
        return var6;
    }

    void method37() {
        if (this.aClass63_Sub2_124 != null) {
            this.aClass63_Sub2_124.method352();
        } else {

            for (Object anALinkedList122 : this.aLinkedList122) {
                Class63_Sub1 var2 = (Class63_Sub1) anALinkedList122;
                var2.method352();
            }
        }

    }

    void method28(int var1, Class16 var2, DoublyLinkedNode_Sub24_Sub4[] var3, ReferenceTable var4, ReferenceTable var5) {
        this.anInt120 = var1;
        if (this.aClass63_Sub2_124 != null || !this.aLinkedList122.isEmpty()) {
            int var6 = this.anInt115;
            int var7 = this.anInt116;
            Sprite var8 = (Sprite) aClass112_118.method669(Class42.method256(var6, var7, var1));
            if (var8 == null) {
                boolean var9 = true;
                var9 &= this.method30(var4);
                int var10;
                if (this.aClass63_Sub2_124 != null) {
                    var10 = this.aClass63_Sub2_124.anInt514;
                } else {
                    var10 = ((Class63) this.aLinkedList122.getFirst()).anInt514;
                }

                var9 &= var5.method911(var10);
                if (var9) {
                    byte[] var11 = var5.method904(var10);
                    Class37 var12;
                    if (var11 == null) {
                        var12 = new Class37();
                    } else {
                        var12 = new Class37(Class16.method130(var11).pixels);
                    }

                    Sprite var14 = new Sprite(this.anInt120 * 64, this.anInt120 * 64);
                    var14.method23();
                    if (this.aClass63_Sub2_124 != null) {
                        this.method33(var2, var3, var12);
                    } else {
                        this.method57(var2, var3, var12);
                    }

                    int var15 = this.anInt115;
                    int var16 = this.anInt116;
                    int var17 = this.anInt120;
                    aClass112_118.method667(var14, Class42.method256(var15, var16, var17), var14.pixels.length * 4);
                    this.method37();
                }
            }
        }
    }

    void method55(int var1, int var2, int var3) {
        int var4 = this.anInt115;
        int var5 = this.anInt116;
        int var6 = this.anInt120;
        Sprite var7 = (Sprite) aClass112_118.method669(Class42.method256(var4, var5, var6));
        if (var7 != null) {
            if (var3 == this.anInt120 * 64) {
                var7.method817(var1, var2);
            } else {
                var7.method811(var1, var2, var3, var3);
            }

        }
    }

    void method54(Class63_Sub2 var1, List var2) {
        this.aHashMap125.clear();
        this.aClass63_Sub2_124 = var1;
        this.method58(var2);
    }

    void method52(HashSet var1, List var2) {
        this.aHashMap125.clear();

        for (Object aVar1 : var1) {
            Class63_Sub1 var4 = (Class63_Sub1) aVar1;
            if (var4.method353() == this.anInt115 && var4.method358() == this.anInt116) {
                this.aLinkedList122.add(var4);
            }
        }

        this.method58(var2);
    }
}
