package jag.audi;

import jag.audi.vorbis.Vorbis8;
import jag.audi.vorbis.Vorbis9;
import jag.commons.collection.NodeTable;
import jag.js5.ReferenceTable;

public class Class97 {
    final ReferenceTable aReferenceTable733;
    final ReferenceTable aReferenceTable732;
    final NodeTable aNodeTable730;
    final NodeTable aNodeTable731;

    public Class97(ReferenceTable var1, ReferenceTable var2) {
        this.aNodeTable731 = new NodeTable(256);
        this.aNodeTable730 = new NodeTable(256);
        this.aReferenceTable732 = var1;
        this.aReferenceTable733 = var2;
    }

    public static int method536(CharSequence var0, int var1) {
        if (var1 >= 2 && var1 <= 36) {
            boolean var3 = false;
            boolean var4 = false;
            int var5 = 0;
            int var6 = var0.length();

            for (int var7 = 0; var7 < var6; ++var7) {
                char var8 = var0.charAt(var7);
                if (var7 == 0) {
                    if (var8 == '-') {
                        var3 = true;
                        continue;
                    }

                    if (var8 == '+') {
                        continue;
                    }
                }

                int var10;
                if (var8 >= '0' && var8 <= '9') {
                    var10 = var8 - '0';
                } else if (var8 >= 'A' && var8 <= 'Z') {
                    var10 = var8 - '7';
                } else {
                    if (var8 < 'a' || var8 > 'z') {
                        throw new NumberFormatException();
                    }

                    var10 = var8 - 'W';
                }

                if (var10 >= var1) {
                    throw new NumberFormatException();
                }

                if (var3) {
                    var10 = -var10;
                }

                int var9 = var5 * var1 + var10;
                if (var9 / var1 != var5) {
                    throw new NumberFormatException();
                }

                var5 = var9;
                var4 = true;
            }

            if (!var4) {
                throw new NumberFormatException();
            }
            return var5;
        }
        throw new IllegalArgumentException("" + var1);
    }

    Vorbis8 method540(int var1, int var2, int[] var3) {
        int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
        var4 |= var1 << 16;
        long var5 = (long) var4 ^ 4294967296L;
        Vorbis8 var7 = (Vorbis8) this.aNodeTable730.lookup(var5);
        if (var7 != null) {
            return var7;
        }
        if (var3 != null && var3[0] <= 0) {
            return null;
        }
        Vorbis9 var8 = (Vorbis9) this.aNodeTable731.lookup(var5);
        if (var8 == null) {
            var8 = Vorbis9.method399(this.aReferenceTable733, var1, var2);
            if (var8 == null) {
                return null;
            }

            this.aNodeTable731.put(var8, var5);
        }

        var7 = var8.method398(var3);
        if (var7 == null) {
            return null;
        }
        var8.unlink();
        this.aNodeTable730.put(var7, var5);
        return var7;
    }

    Vorbis8 method539(int var1, int var2, int[] var3) {
        int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
        var4 |= var1 << 16;
        long var5 = var4;
        Vorbis8 var7 = (Vorbis8) this.aNodeTable730.lookup(var5);
        if (var7 != null) {
            return var7;
        }
        if (var3 != null && var3[0] <= 0) {
            return null;
        }
        AudioEffect var8 = AudioEffect.load(this.aReferenceTable732, var1, var2);
        if (var8 == null) {
            return null;
        }
        var7 = var8.method1523();
        this.aNodeTable730.put(var7, var5);
        if (var3 != null) {
            var3[0] -= var7.aByteArray503.length;
        }

        return var7;
    }

    public Vorbis8 method537(int var1, int[] var2) {
        if (this.aReferenceTable733.method916() == 1) {
            return this.method540(0, var1, var2);
        }
        if (this.aReferenceTable733.method901(var1) == 1) {
            return this.method540(var1, 0, var2);
        }
        throw new RuntimeException();
    }

    public Vorbis8 method538(int var1, int[] var2) {
        if (this.aReferenceTable732.method916() == 1) {
            return this.method539(0, var1, var2);
        }
        if (this.aReferenceTable732.method901(var1) == 1) {
            return this.method539(var1, 0, var2);
        }
        throw new RuntimeException();
    }
}
