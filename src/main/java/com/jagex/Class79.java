package com.jagex;

import java.io.EOFException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Class79 {
    static int cameraZ;
    static int anInt614;
    String[] aStringArray613;
    Map aMap615;
    boolean[] aBooleanArray616;
    boolean aBoolean611;
    long aLong612;

    Class79() {
        this.aBoolean611 = false;
        int var1 = Class104.aCacheReferenceTable773.method901(19);
        this.aMap615 = new HashMap();
        this.aBooleanArray616 = new boolean[var1];

        int var2;
        for (var2 = 0; var2 < var1; ++var2) {
            DoublyLinkedNode_Sub18 var3 = (DoublyLinkedNode_Sub18) DoublyLinkedNode_Sub18.aReferenceCache385.get((long) var2);
            DoublyLinkedNode_Sub18 var4;
            if (var3 != null) {
                var4 = var3;
            } else {
                byte[] var5 = DoublyLinkedNode_Sub18.aReferenceTable383.unpack(19, var2);
                var3 = new DoublyLinkedNode_Sub18();
                if (var5 != null) {
                    var3.method1098(new Buffer(var5));
                }

                DoublyLinkedNode_Sub18.aReferenceCache385.put(var3, (long) var2);
                var4 = var3;
            }

            this.aBooleanArray616[var2] = var4.aBoolean790;
        }

        var2 = 0;
        if (Class104.aCacheReferenceTable773.method496(15)) {
            var2 = Class104.aCacheReferenceTable773.method901(15);
        }

        this.aStringArray613 = new String[var2];
        this.method426();
    }

    DiskFile method427(boolean var1) {
        return RegionUpdateType.method863("2", Class83.anEnum_Sub5_629.aString1212, var1);
    }

    boolean method424() {
        return this.aBoolean611;
    }

    void method434() {
        DiskFile var1 = this.method427(true);

        try {
            int var2 = 3;
            int var3 = 0;

            for (Object o1 : this.aMap615.entrySet()) {
                Entry var5 = (Entry) o1;
                int var6 = (Integer) var5.getKey();
                if (this.aBooleanArray616[var6]) {
                    Object var7 = var5.getValue();
                    var2 += 3;
                    if (var7 instanceof Integer) {
                        var2 += 4;
                    } else if (var7 instanceof String) {
                        var2 += Statics30.stringLengthPlusOne((String) var7);
                    }

                    ++var3;
                }
            }

            Buffer var26 = new Buffer(var2);
            var26.writeByte(2);
            var26.writeShort(var3);

            for (Object o : this.aMap615.entrySet()) {
                Entry var8 = (Entry) o;
                int var9 = (Integer) var8.getKey();
                if (this.aBooleanArray616[var9]) {
                    var26.writeShort(var9);
                    Object var10 = var8.getValue();
                    Class85 var11 = Class85.method452(var10.getClass());
                    var26.writeByte(var11.anInt619);
                    Class var12 = var10.getClass();
                    Class85 var13 = Class85.method452(var12);
                    if (var13 == null) {
                        throw new IllegalArgumentException();
                    }

                    Class89 var14 = var13.aClass89_632;
                    var14.method408(var10, var26);
                }
            }

            var1.write(var26.payload, 0, var26.caret);
        } catch (Exception ignored) {
        } finally {
            try {
                var1.close();
            } catch (Exception ignored) {
            }

        }

        this.aBoolean611 = false;
        this.aLong612 = Class24.currentTime();
    }

    void method426() {
        DiskFile var1 = this.method427(false);

        label227:
        {
            try {
                byte[] var2 = new byte[(int) var1.length()];

                int var4;
                for (int var3 = 0; var3 < var2.length; var3 += var4) {
                    var4 = var1.read(var2, var3, var2.length - var3);
                    if (var4 == -1) {
                        throw new EOFException();
                    }
                }

                Buffer var5 = new Buffer(var2);
                if (var5.payload.length - var5.caret < 1) {
                    return;
                }

                int var7 = var5.readUByte();
                if (var7 >= 0 && var7 <= 2) {
                    int var9;
                    int var10;
                    int var11;
                    int var12;
                    if (var7 >= 2) {
                        var9 = var5.readUShort();
                        var10 = 0;

                        while (true) {
                            if (var10 >= var9) {
                                break label227;
                            }

                            var11 = var5.readUShort();
                            var12 = var5.readUByte();
                            Class85 var13 = (Class85) OldConnection.method716(Class85.method457(), var12);
                            Object var14 = var13.method454(var5);
                            if (this.aBooleanArray616[var11]) {
                                this.aMap615.put(var11, var14);
                            }

                            ++var10;
                        }
                    } else {
                        var9 = var5.readUShort();

                        for (var10 = 0; var10 < var9; ++var10) {
                            var11 = var5.readUShort();
                            var12 = var5.readInt();
                            if (this.aBooleanArray616[var11]) {
                                this.aMap615.put(var11, var12);
                            }
                        }

                        var10 = var5.readUShort();
                        var11 = 0;

                        while (true) {
                            if (var11 >= var10) {
                                break label227;
                            }

                            var5.readUShort();
                            var5.readString();
                            ++var11;
                        }
                    }
                }
            } catch (Exception var25) {
                break label227;
            } finally {
                try {
                    var1.close();
                } catch (Exception ignored) {
                }

            }

            return;
        }

        this.aBoolean611 = false;
    }

    String method429(int var1) {
        return this.aStringArray613[var1];
    }

    int method428(int var1) {
        Object var2 = this.aMap615.get(var1);
        return var2 instanceof Integer ? (Integer) var2 : -1;
    }

    String method432(int var1) {
        Object var2 = this.aMap615.get(var1);
        return var2 instanceof String ? (String) var2 : "";
    }

    void method435(int var1, int var2) {
        this.aMap615.put(var1, var2);
        if (this.aBooleanArray616[var1]) {
            this.aBoolean611 = true;
        }

    }

    void method431(int var1, String var2) {
        this.aStringArray613[var1] = var2;
    }

    void method433(int var1, String var2) {
        this.aMap615.put(var1, var2);
    }

    void method430() {
        int var1;
        for (var1 = 0; var1 < this.aBooleanArray616.length; ++var1) {
            if (!this.aBooleanArray616[var1]) {
                this.aMap615.remove(var1);
            }
        }

        for (var1 = 0; var1 < this.aStringArray613.length; ++var1) {
            this.aStringArray613[var1] = null;
        }

    }

    void method425() {
        if (this.aBoolean611 && this.aLong612 < Class24.currentTime() - 60000L) {
            this.method434();
        }

    }
}
