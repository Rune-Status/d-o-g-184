package com.jagex;

public class AssociateComparatorByName extends AssociateComparator {
    final boolean aBoolean764;

    public AssociateComparatorByName(boolean var1) {
        this.aBoolean764 = var1;
    }

    static void openMenu(int var0, int var1) {
        int var2 = Statics7.aFont863.method1145("Choose Option");

        int var3;
        int var4;
        for (var3 = 0; var3 < client.menuRowCount; ++var3) {
            var4 = Statics7.aFont863.method1145(Class16.method131(var3));
            if (var4 > var2) {
                var2 = var4;
            }
        }

        var2 += 8;
        var3 = client.menuRowCount * 15 + 22;
        var4 = var0 - var2 / 2;
        if (var4 + var2 > client.canvasWidth) {
            var4 = client.canvasWidth - var2;
        }

        if (var4 < 0) {
            var4 = 0;
        }

        int var5 = var1;
        if (var1 + var3 > client.canvasHeight) {
            var5 = client.canvasHeight - var3;
        }

        if (var5 < 0) {
            var5 = 0;
        }

        Class108.anInt797 = var4;
        Statics1.anInt321 = var5;
        SocialSystem.anInt319 = var2;
        Class69.anInt543 = client.menuRowCount * 15 + 22;
    }

    public static String method719(byte[] var0, int var1, int var2) {
        char[] var3 = new char[var2];
        int var4 = 0;
        int var5 = var1;

        int var8;
        for (int var6 = var2 + var1; var5 < var6; var3[var4++] = (char) var8) {
            int var7 = var0[var5++] & 255;
            if (var7 < 128) {
                if (var7 == 0) {
                    var8 = 65533;
                } else {
                    var8 = var7;
                }
            } else if (var7 < 192) {
                var8 = 65533;
            } else if (var7 < 224) {
                if (var5 < var6 && (var0[var5] & 192) == 128) {
                    var8 = (var7 & 31) << 6 | var0[var5++] & 63;
                    if (var8 < 128) {
                        var8 = 65533;
                    }
                } else {
                    var8 = 65533;
                }
            } else if (var7 < 240) {
                if (var5 + 1 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128) {
                    var8 = (var7 & 15) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
                    if (var8 < 2048) {
                        var8 = 65533;
                    }
                } else {
                    var8 = 65533;
                }
            } else if (var7 < 248) {
                if (var5 + 2 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128 && (var0[var5 + 2] & 192) == 128) {
                    var8 = (var7 & 7) << 18 | (var0[var5++] & 63) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
                    if (var8 >= 65536 && var8 <= 1114111) {
                        var8 = 65533;
                    } else {
                        var8 = 65533;
                    }
                } else {
                    var8 = 65533;
                }
            } else {
                var8 = 65533;
            }
        }

        return new String(var3, 0, var4);
    }

    static int method718(int var0) {
        int var3;
        if (var0 == 6600) {
            var3 = SceneGraph.floorLevel;
            int var9 = Statics18.baseX + (PlayerEntity.local.fineX >> 7);
            int var5 = Statics36.baseY + (PlayerEntity.local.fineY >> 7);
            Class98.method542().method1261(var3, var9, var5, true);
            return 1;
        }
        Class9 var11;
        if (var0 == 6601) {
            var3 = ScriptEvent.intStack[--Class49.anInt442];
            String var16 = "";
            var11 = Class98.method542().method1242(var3);
            if (var11 != null) {
                var16 = var11.method68();
            }

            ScriptEvent.stringStack[++Class49.anInt441 - 1] = var16;
            return 1;
        }
        if (var0 == 6602) {
            var3 = ScriptEvent.intStack[--Class49.anInt442];
            Class98.method542().method1273(var3);
            return 1;
        }
        if (var0 == 6603) {
            ScriptEvent.intStack[++Class49.anInt442 - 1] = Class98.method542().method1241();
            return 1;
        }
        if (var0 == 6604) {
            var3 = ScriptEvent.intStack[--Class49.anInt442];
            Class98.method542().method1226(var3);
            return 1;
        }
        if (var0 == 6605) {
            ScriptEvent.intStack[++Class49.anInt442 - 1] = Class98.method542().method1246() ? 1 : 0;
            return 1;
        }
        SceneOffset var15;
        if (var0 == 6606) {
            var15 = new SceneOffset(ScriptEvent.intStack[--Class49.anInt442]);
            Class98.method542().method1238(var15.anInt1891, var15.anInt1892);
            return 1;
        }
        if (var0 == 6607) {
            var15 = new SceneOffset(ScriptEvent.intStack[--Class49.anInt442]);
            Class98.method542().method1235(var15.anInt1891, var15.anInt1892);
            return 1;
        }
        if (var0 == 6608) {
            var15 = new SceneOffset(ScriptEvent.intStack[--Class49.anInt442]);
            Class98.method542().method1227(var15.floorLevel, var15.anInt1891, var15.anInt1892);
            return 1;
        }
        if (var0 == 6609) {
            var15 = new SceneOffset(ScriptEvent.intStack[--Class49.anInt442]);
            Class98.method542().method1237(var15.floorLevel, var15.anInt1891, var15.anInt1892);
            return 1;
        }
        if (var0 == 6610) {
            ScriptEvent.intStack[++Class49.anInt442 - 1] = Class98.method542().method1232();
            ScriptEvent.intStack[++Class49.anInt442 - 1] = Class98.method542().method1234();
            return 1;
        }
        Class9 var13;
        if (var0 == 6611) {
            var3 = ScriptEvent.intStack[--Class49.anInt442];
            var13 = Class98.method542().method1242(var3);
            if (var13 == null) {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = 0;
            } else {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = var13.method69().positionHash();
            }

            return 1;
        }
        if (var0 == 6612) {
            var3 = ScriptEvent.intStack[--Class49.anInt442];
            var13 = Class98.method542().method1242(var3);
            if (var13 == null) {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = 0;
                ScriptEvent.intStack[++Class49.anInt442 - 1] = 0;
            } else {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = (var13.method70() - var13.method66() + 1) * 64;
                ScriptEvent.intStack[++Class49.anInt442 - 1] = (var13.method72() - var13.method85() + 1) * 64;
            }

            return 1;
        }
        if (var0 == 6613) {
            var3 = ScriptEvent.intStack[--Class49.anInt442];
            var13 = Class98.method542().method1242(var3);
            if (var13 == null) {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = 0;
                ScriptEvent.intStack[++Class49.anInt442 - 1] = 0;
                ScriptEvent.intStack[++Class49.anInt442 - 1] = 0;
                ScriptEvent.intStack[++Class49.anInt442 - 1] = 0;
            } else {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = var13.method66() * 64;
                ScriptEvent.intStack[++Class49.anInt442 - 1] = var13.method85() * 64;
                ScriptEvent.intStack[++Class49.anInt442 - 1] = var13.method70() * 64 + 64 - 1;
                ScriptEvent.intStack[++Class49.anInt442 - 1] = var13.method72() * 64 + 64 - 1;
            }

            return 1;
        }
        if (var0 == 6614) {
            var3 = ScriptEvent.intStack[--Class49.anInt442];
            var13 = Class98.method542().method1242(var3);
            if (var13 == null) {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = -1;
            } else {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = var13.method78();
            }

            return 1;
        }
        if (var0 == 6615) {
            var15 = Class98.method542().method1240();
            if (var15 == null) {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = -1;
                ScriptEvent.intStack[++Class49.anInt442 - 1] = -1;
            } else {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = var15.anInt1891;
                ScriptEvent.intStack[++Class49.anInt442 - 1] = var15.anInt1892;
            }

            return 1;
        }
        if (var0 == 6616) {
            ScriptEvent.intStack[++Class49.anInt442 - 1] = Class98.method542().method1260();
            return 1;
        }
        if (var0 == 6617) {
            var15 = new SceneOffset(ScriptEvent.intStack[--Class49.anInt442]);
            var13 = Class98.method542().method1264();
            if (var13 == null) {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = -1;
                ScriptEvent.intStack[++Class49.anInt442 - 1] = -1;
                return 1;
            }
            int[] var14 = var13.method81(var15.floorLevel, var15.anInt1891, var15.anInt1892);
            if (var14 == null) {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = -1;
                ScriptEvent.intStack[++Class49.anInt442 - 1] = -1;
            } else {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = var14[0];
                ScriptEvent.intStack[++Class49.anInt442 - 1] = var14[1];
            }

            return 1;
        }
        SceneOffset var7;
        if (var0 == 6618) {
            var15 = new SceneOffset(ScriptEvent.intStack[--Class49.anInt442]);
            var13 = Class98.method542().method1264();
            if (var13 == null) {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = -1;
                ScriptEvent.intStack[++Class49.anInt442 - 1] = -1;
                return 1;
            }
            var7 = var13.method79(var15.anInt1891, var15.anInt1892);
            if (var7 == null) {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = -1;
            } else {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = var7.positionHash();
            }

            return 1;
        }
        SceneOffset var12;
        if (var0 == 6619) {
            Class49.anInt442 -= 2;
            var3 = ScriptEvent.intStack[Class49.anInt442];
            var12 = new SceneOffset(ScriptEvent.intStack[Class49.anInt442 + 1]);
            Class34.method233(var3, var12, false);
            return 1;
        }
        if (var0 == 6620) {
            Class49.anInt442 -= 2;
            var3 = ScriptEvent.intStack[Class49.anInt442];
            var12 = new SceneOffset(ScriptEvent.intStack[Class49.anInt442 + 1]);
            Class34.method233(var3, var12, true);
            return 1;
        }
        if (var0 == 6621) {
            Class49.anInt442 -= 2;
            var3 = ScriptEvent.intStack[Class49.anInt442];
            var12 = new SceneOffset(ScriptEvent.intStack[Class49.anInt442 + 1]);
            var11 = Class98.method542().method1242(var3);
            if (var11 == null) {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = 0;
                return 1;
            }
            ScriptEvent.intStack[++Class49.anInt442 - 1] = var11.method84(var12.floorLevel, var12.anInt1891, var12.anInt1892) ? 1 : 0;
            return 1;
        }
        if (var0 == 6622) {
            ScriptEvent.intStack[++Class49.anInt442 - 1] = Class98.method542().method1236();
            ScriptEvent.intStack[++Class49.anInt442 - 1] = Class98.method542().method1228();
            return 1;
        }
        if (var0 == 6623) {
            var15 = new SceneOffset(ScriptEvent.intStack[--Class49.anInt442]);
            var13 = Class98.method542().method1262(var15.floorLevel, var15.anInt1891, var15.anInt1892);
            if (var13 == null) {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = -1;
            } else {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = var13.method75();
            }

            return 1;
        }
        if (var0 == 6624) {
            Class98.method542().method1245(ScriptEvent.intStack[--Class49.anInt442]);
            return 1;
        }
        if (var0 == 6625) {
            Class98.method542().method1231();
            return 1;
        }
        if (var0 == 6626) {
            Class98.method542().method1230(ScriptEvent.intStack[--Class49.anInt442]);
            return 1;
        }
        if (var0 == 6627) {
            Class98.method542().method1233();
            return 1;
        }
        boolean var10;
        if (var0 == 6628) {
            var10 = ScriptEvent.intStack[--Class49.anInt442] == 1;
            Class98.method542().method1247(var10);
            return 1;
        }
        if (var0 == 6629) {
            var3 = ScriptEvent.intStack[--Class49.anInt442];
            Class98.method542().method1244(var3);
            return 1;
        }
        if (var0 == 6630) {
            var3 = ScriptEvent.intStack[--Class49.anInt442];
            Class98.method542().method1229(var3);
            return 1;
        }
        if (var0 == 6631) {
            Class98.method542().method1243();
            return 1;
        }
        if (var0 == 6632) {
            var10 = ScriptEvent.intStack[--Class49.anInt442] == 1;
            Class98.method542().method1258(var10);
            return 1;
        }
        boolean var4;
        if (var0 == 6633) {
            Class49.anInt442 -= 2;
            var3 = ScriptEvent.intStack[Class49.anInt442];
            var4 = ScriptEvent.intStack[Class49.anInt442 + 1] == 1;
            Class98.method542().method1251(var3, var4);
            return 1;
        }
        if (var0 == 6634) {
            Class49.anInt442 -= 2;
            var3 = ScriptEvent.intStack[Class49.anInt442];
            var4 = ScriptEvent.intStack[Class49.anInt442 + 1] == 1;
            Class98.method542().method1250(var3, var4);
            return 1;
        }
        if (var0 == 6635) {
            ScriptEvent.intStack[++Class49.anInt442 - 1] = Class98.method542().method1254() ? 1 : 0;
            return 1;
        }
        if (var0 == 6636) {
            var3 = ScriptEvent.intStack[--Class49.anInt442];
            ScriptEvent.intStack[++Class49.anInt442 - 1] = Class98.method542().method1257(var3) ? 1 : 0;
            return 1;
        }
        if (var0 == 6637) {
            var3 = ScriptEvent.intStack[--Class49.anInt442];
            ScriptEvent.intStack[++Class49.anInt442 - 1] = Class98.method542().method1252(var3) ? 1 : 0;
            return 1;
        }
        if (var0 == 6638) {
            Class49.anInt442 -= 2;
            var3 = ScriptEvent.intStack[Class49.anInt442];
            var12 = new SceneOffset(ScriptEvent.intStack[Class49.anInt442 + 1]);
            var7 = Class98.method542().method1249(var3, var12);
            if (var7 == null) {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = -1;
            } else {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = var7.positionHash();
            }

            return 1;
        }
        Class27 var8;
        if (var0 == 6639) {
            var8 = Class98.method542().method1248();
            if (var8 == null) {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = -1;
                ScriptEvent.intStack[++Class49.anInt442 - 1] = -1;
            } else {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = var8.method199();
                ScriptEvent.intStack[++Class49.anInt442 - 1] = var8.aSceneOffset313.positionHash();
            }

            return 1;
        }
        if (var0 == 6640) {
            var8 = Class98.method542().method1255();
            if (var8 == null) {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = -1;
                ScriptEvent.intStack[++Class49.anInt442 - 1] = -1;
            } else {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = var8.method199();
                ScriptEvent.intStack[++Class49.anInt442 - 1] = var8.aSceneOffset313.positionHash();
            }

            return 1;
        }
        DoublyLinkedNode_Sub15 var6;
        if (var0 == 6693) {
            var3 = ScriptEvent.intStack[--Class49.anInt442];
            var6 = Class98.method545(var3);
            if (var6.aString1474 == null) {
                ScriptEvent.stringStack[++Class49.anInt441 - 1] = "";
            } else {
                ScriptEvent.stringStack[++Class49.anInt441 - 1] = var6.aString1474;
            }

            return 1;
        }
        if (var0 == 6694) {
            var3 = ScriptEvent.intStack[--Class49.anInt442];
            var6 = Class98.method545(var3);
            ScriptEvent.intStack[++Class49.anInt442 - 1] = var6.anInt564;
            return 1;
        }
        if (var0 == 6695) {
            var3 = ScriptEvent.intStack[--Class49.anInt442];
            var6 = Class98.method545(var3);
            if (var6 == null) {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = -1;
            } else {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = var6.anInt1473;
            }

            return 1;
        }
        if (var0 == 6696) {
            var3 = ScriptEvent.intStack[--Class49.anInt442];
            var6 = Class98.method545(var3);
            if (var6 == null) {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = -1;
            } else {
                ScriptEvent.intStack[++Class49.anInt442 - 1] = var6.anInt112;
            }

            return 1;
        }
        if (var0 == 6697) {
            ScriptEvent.intStack[++Class49.anInt442 - 1] = DoublyLinkedNode_Sub11.aClass25_1443.anInt306;
            return 1;
        }
        if (var0 == 6698) {
            ScriptEvent.intStack[++Class49.anInt442 - 1] = DoublyLinkedNode_Sub11.aClass25_1443.aSceneOffset307.positionHash();
            return 1;
        }
        if (var0 == 6699) {
            ScriptEvent.intStack[++Class49.anInt442 - 1] = DoublyLinkedNode_Sub11.aClass25_1443.aSceneOffset305.positionHash();
            return 1;
        }
        return 2;
    }

    int method604(Associate var1, Associate var2) {
        if (var1.world != 0 && var2.world != 0) {
            return this.aBoolean764 ? var1.getDisplayName().compare0(var2.getDisplayName()) : var2.getDisplayName().compare0(var1.getDisplayName());
        }
        return this.method1135(var1, var2);
    }

    public int compare(Associate var1, Associate var2) {
        return this.method604(var1, var2);
    }
}
