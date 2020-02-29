package com.jagex;

public abstract class ReferenceTable {

    static GzipDecompressor aGzipDecompressor_1238;
    static int maximumContainerSize;

    static {
        aGzipDecompressor_1238 = new GzipDecompressor();
        maximumContainerSize = 0;
    }

    public int anInt1240;
    int[] entryIndices;
    Object[] anObjectArray1239;
    Object[][] childrenSizes;
    int[][] childrenIndices;
    boolean aBoolean1250;
    IdentityTable[] children;
    IdentityTable entry;
    int[] anIntArray1246;
    int[] childrenCounts;
    boolean aBoolean1247;
    int[] anIntArray1245;
    int entryCount;
    int[] anIntArray1248;
    int[][] childrenNames;

    ReferenceTable(boolean var1, boolean var2) {
        this.aBoolean1250 = var1;
        this.aBoolean1247 = var2;
    }

    public static boolean method898(char var0) {
        return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
    }

    static byte[] decodeContainer(byte[] data) {
        Buffer buffer = new Buffer(data);
        int type = buffer.readUByte();
        int compressed = buffer.readInt();
        if (compressed < 0 || maximumContainerSize != 0 && compressed > maximumContainerSize) {
            throw new RuntimeException();
        }

        if (type == 0) { //uncompressed
            byte[] decoded = new byte[compressed];
            buffer.readBytes(decoded, 0, compressed);
            return decoded;
        }

        int length = buffer.readInt();
        if (length < 0 || maximumContainerSize != 0 && length > maximumContainerSize) {
            throw new RuntimeException();
        }

        byte[] decoded = new byte[length];
        if (type == 1) {
            Bzip2Decompressor.decompress(decoded, length, data, 9);
        } else {
            aGzipDecompressor_1238.method1326(buffer, decoded);
        }
        return decoded;
    }

    public int[] method894(int var1) {
        return var1 >= 0 && var1 < this.childrenIndices.length ? this.childrenIndices[var1] : null;
    }

    public byte[] unpack(int var1, int var2, int[] var3) {
        if (var1 >= 0 && var1 < this.childrenSizes.length && this.childrenSizes[var1] != null && var2 >= 0 && var2 < this.childrenSizes[var1].length) {
            if (this.childrenSizes[var1][var2] == null) {
                boolean var5 = this.method905(var1, var3);
                if (!var5) {
                    this.method492(var1);
                    var5 = this.method905(var1, var3);
                    if (!var5) {
                        return null;
                    }
                }
            }

            byte[] var6 = Class57.method333(this.childrenSizes[var1][var2], false);
            if (this.aBoolean1247) {
                this.childrenSizes[var1][var2] = null;
            }

            return var6;
        }
        return null;
    }

    public byte[] unpack(int var1, int var2) {
        return this.unpack(var1, var2, null);
    }

    public int method916() {
        return this.childrenSizes.length;
    }

    public byte[] method904(int var1) {
        if (this.childrenSizes.length == 1) {
            return this.unpack(0, var1);
        }
        if (this.childrenSizes[var1].length == 1) {
            return this.unpack(var1, 0);
        }
        throw new RuntimeException();
    }

    public byte[] method899(int var1, int var2) {
        if (var1 >= 0 && var1 < this.childrenSizes.length && this.childrenSizes[var1] != null && var2 >= 0 && var2 < this.childrenSizes[var1].length) {
            if (this.childrenSizes[var1][var2] == null) {
                boolean var3 = this.method905(var1, null);
                if (!var3) {
                    this.method492(var1);
                    var3 = this.method905(var1, null);
                    if (!var3) {
                        return null;
                    }
                }
            }

            return Class57.method333(this.childrenSizes[var1][var2], false);
        }
        return null;
    }

    public boolean method913(int var1, int var2) {
        if (var1 >= 0 && var1 < this.childrenSizes.length && this.childrenSizes[var1] != null && var2 >= 0 && var2 < this.childrenSizes[var1].length) {
            if (this.childrenSizes[var1][var2] != null) {
                return true;
            }
            if (this.anObjectArray1239[var1] != null) {
                return true;
            }
            this.method492(var1);
            return this.anObjectArray1239[var1] != null;
        }
        return false;
    }

    void method492(int var1) {
    }

    public byte[] method896(int var1) {
        if (this.childrenSizes.length == 1) {
            return this.method899(0, var1);
        }
        if (this.childrenSizes[var1].length == 1) {
            return this.method899(var1, 0);
        }
        throw new RuntimeException();
    }

    public boolean method911(int var1) {
        if (this.anObjectArray1239[var1] != null) {
            return true;
        }
        this.method492(var1);
        return this.anObjectArray1239[var1] != null;
    }

    public int method901(int var1) {
        return this.childrenSizes[var1].length;
    }

    int method497(int var1) {
        return this.anObjectArray1239[var1] != null ? 100 : 0;
    }

    void decode(byte[] var1) {
        this.anInt1240 = NamePair.crc32(var1, var1.length);
        Buffer buffer = new Buffer(decodeContainer(var1));
        int var3 = buffer.readUByte();
        if (var3 >= 5 && var3 <= 7) {
            if (var3 >= 6) {
                buffer.readInt();
            }

            int var4 = buffer.readUByte();
            if (var3 >= 7) {
                this.entryCount = buffer.method1035();
            } else {
                this.entryCount = buffer.readUShort();
            }

            int var5 = 0;
            int var6 = -1;
            this.entryIndices = new int[this.entryCount];
            int var7;
            if (var3 >= 7) {
                for (var7 = 0; var7 < this.entryCount; ++var7) {
                    this.entryIndices[var7] = var5 += buffer.method1035();
                    if (this.entryIndices[var7] > var6) {
                        var6 = this.entryIndices[var7];
                    }
                }
            } else {
                for (var7 = 0; var7 < this.entryCount; ++var7) {
                    this.entryIndices[var7] = var5 += buffer.readUShort();
                    if (this.entryIndices[var7] > var6) {
                        var6 = this.entryIndices[var7];
                    }
                }
            }

            this.anIntArray1245 = new int[var6 + 1];
            this.anIntArray1246 = new int[var6 + 1];
            this.childrenCounts = new int[var6 + 1];
            this.childrenIndices = new int[var6 + 1][];
            this.anObjectArray1239 = new Object[var6 + 1];
            this.childrenSizes = new Object[var6 + 1][];
            if (var4 != 0) {
                this.anIntArray1248 = new int[var6 + 1];

                for (var7 = 0; var7 < this.entryCount; ++var7) {
                    this.anIntArray1248[this.entryIndices[var7]] = buffer.readInt();
                }

                this.entry = new IdentityTable(this.anIntArray1248);
            }

            for (var7 = 0; var7 < this.entryCount; ++var7) {
                this.anIntArray1245[this.entryIndices[var7]] = buffer.readInt();
            }

            for (var7 = 0; var7 < this.entryCount; ++var7) {
                this.anIntArray1246[this.entryIndices[var7]] = buffer.readInt();
            }

            for (var7 = 0; var7 < this.entryCount; ++var7) {
                this.childrenCounts[this.entryIndices[var7]] = buffer.readUShort();
            }

            int var8;
            int var9;
            int var10;
            int var11;
            int var12;
            if (var3 >= 7) {
                for (var7 = 0; var7 < this.entryCount; ++var7) {
                    var8 = this.entryIndices[var7];
                    var9 = this.childrenCounts[var8];
                    var5 = 0;
                    var10 = -1;
                    this.childrenIndices[var8] = new int[var9];

                    for (var11 = 0; var11 < var9; ++var11) {
                        var12 = this.childrenIndices[var8][var11] = var5 += buffer.method1035();
                        if (var12 > var10) {
                            var10 = var12;
                        }
                    }

                    this.childrenSizes[var8] = new Object[var10 + 1];
                }
            } else {
                for (var7 = 0; var7 < this.entryCount; ++var7) {
                    var8 = this.entryIndices[var7];
                    var9 = this.childrenCounts[var8];
                    var5 = 0;
                    var10 = -1;
                    this.childrenIndices[var8] = new int[var9];

                    for (var11 = 0; var11 < var9; ++var11) {
                        var12 = this.childrenIndices[var8][var11] = var5 += buffer.readUShort();
                        if (var12 > var10) {
                            var10 = var12;
                        }
                    }

                    this.childrenSizes[var8] = new Object[var10 + 1];
                }
            }

            if (var4 != 0) {
                this.childrenNames = new int[var6 + 1][];
                this.children = new IdentityTable[var6 + 1];

                for (var7 = 0; var7 < this.entryCount; ++var7) {
                    var8 = this.entryIndices[var7];
                    var9 = this.childrenCounts[var8];
                    this.childrenNames[var8] = new int[this.childrenSizes[var8].length];

                    for (var10 = 0; var10 < var9; ++var10) {
                        this.childrenNames[var8][this.childrenIndices[var8][var10]] = buffer.readInt();
                    }

                    this.children[var8] = new IdentityTable(this.childrenNames[var8]);
                }
            }

        } else {
            throw new RuntimeException("");
        }
    }

    public boolean method893(String var1, String var2) {
        var1 = var1.toLowerCase();
        var2 = var2.toLowerCase();
        int var3 = this.entry.get(Class63_Sub2.method473(var1));
        int var4 = this.children[var3].get(Class63_Sub2.method473(var2));
        return this.method913(var3, var4);
    }

    void method490(int var1) {
    }

    public boolean method906(String var1, String var2) {
        var1 = var1.toLowerCase();
        var2 = var2.toLowerCase();
        int var3 = this.entry.get(Class63_Sub2.method473(var1));
        if (var3 < 0) {
            return false;
        }
        int var4 = this.children[var3].get(Class63_Sub2.method473(var2));
        return var4 >= 0;
    }

    public int method900(String var1) {
        var1 = var1.toLowerCase();
        return this.entry.get(Class63_Sub2.method473(var1));
    }

    public int method907(int var1, String var2) {
        var2 = var2.toLowerCase();
        return this.children[var1].get(Class63_Sub2.method473(var2));
    }

    public boolean method910(int var1) {
        if (this.childrenSizes.length == 1) {
            return this.method913(0, var1);
        }
        if (this.childrenSizes[var1].length == 1) {
            return this.method913(var1, 0);
        }
        throw new RuntimeException();
    }

    boolean method905(int var1, int[] var2) {
        if (this.anObjectArray1239[var1] == null) {
            return false;
        }
        int var3 = this.childrenCounts[var1];
        int[] var4 = this.childrenIndices[var1];
        Object[] var5 = this.childrenSizes[var1];
        boolean var6 = true;

        for (int var7 = 0; var7 < var3; ++var7) {
            if (var5[var4[var7]] == null) {
                var6 = false;
                break;
            }
        }

        if (var6) {
            return true;
        }
        byte[] var8;
        if (var2 != null && (var2[0] != 0 || var2[1] != 0 || var2[2] != 0 || var2[3] != 0)) {
            var8 = Class57.method333(this.anObjectArray1239[var1], true);
            Buffer var9 = new Buffer(var8);
            var9.method1069(var2, 5, var9.payload.length);
        } else {
            var8 = Class57.method333(this.anObjectArray1239[var1], false);
        }

        byte[] var20 = decodeContainer(var8);
        if (this.aBoolean1250) {
            this.anObjectArray1239[var1] = null;
        }

        if (var3 > 1) {
            int var10 = var20.length;
            --var10;
            int var11 = var20[var10] & 255;
            var10 -= var11 * var3 * 4;
            Buffer var12 = new Buffer(var20);
            int[] var13 = new int[var3];
            var12.caret = var10;

            int var15;
            int var16;
            for (int var14 = 0; var14 < var11; ++var14) {
                var15 = 0;

                for (var16 = 0; var16 < var3; ++var16) {
                    var15 += var12.readInt();
                    var13[var16] += var15;
                }
            }

            byte[][] var17 = new byte[var3][];

            for (var15 = 0; var15 < var3; ++var15) {
                var17[var15] = new byte[var13[var15]];
                var13[var15] = 0;
            }

            var12.caret = var10;
            var15 = 0;

            for (var16 = 0; var16 < var11; ++var16) {
                int var18 = 0;

                for (int var19 = 0; var19 < var3; ++var19) {
                    var18 += var12.readInt();
                    System.arraycopy(var20, var15, var17[var19], var13[var19], var18);
                    var13[var19] += var18;
                    var15 += var18;
                }
            }

            for (var16 = 0; var16 < var3; ++var16) {
                if (!this.aBoolean1247) {
                    var5[var4[var16]] = Class78.method422(var17[var16]);
                } else {
                    var5[var4[var16]] = var17[var16];
                }
            }
        } else if (!this.aBoolean1247) {
            var5[var4[0]] = Class78.method422(var20);
        } else {
            var5[var4[0]] = var20;
        }

        return true;
    }

    public byte[] method897(String var1, String var2) {
        var1 = var1.toLowerCase();
        var2 = var2.toLowerCase();
        int var3 = this.entry.get(Class63_Sub2.method473(var1));
        int var4 = this.children[var3].get(Class63_Sub2.method473(var2));
        return this.unpack(var3, var4);
    }

    public void method903() {
        for (int var1 = 0; var1 < this.anObjectArray1239.length; ++var1) {
            this.anObjectArray1239[var1] = null;
        }

    }

    public void method902() {
        for (int var1 = 0; var1 < this.childrenSizes.length; ++var1) {
            if (this.childrenSizes[var1] != null) {
                for (int var2 = 0; var2 < this.childrenSizes[var1].length; ++var2) {
                    this.childrenSizes[var1][var2] = null;
                }
            }
        }

    }

    public boolean method908() {
        boolean var1 = true;

        for (int var3 : this.entryIndices) {
            if (this.anObjectArray1239[var3] == null) {
                this.method492(var3);
                if (this.anObjectArray1239[var3] == null) {
                    var1 = false;
                }
            }
        }

        return var1;
    }

    public boolean method909(String var1) {
        var1 = var1.toLowerCase();
        int var2 = this.entry.get(Class63_Sub2.method473(var1));
        return this.method911(var2);
    }

    public int method895(String var1) {
        var1 = var1.toLowerCase();
        int var2 = this.entry.get(Class63_Sub2.method473(var1));
        return this.method497(var2);
    }

    public void method914(int var1) {
        for (int var2 = 0; var2 < this.childrenSizes[var1].length; ++var2) {
            this.childrenSizes[var1][var2] = null;
        }

    }

    public void method912(String var1) {
        var1 = var1.toLowerCase();
        int var2 = this.entry.get(Class63_Sub2.method473(var1));
        if (var2 >= 0) {
            this.method490(var2);
        }
    }
}
