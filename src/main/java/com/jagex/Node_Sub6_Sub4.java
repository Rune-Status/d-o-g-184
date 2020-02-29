package com.jagex;

public class Node_Sub6_Sub4 extends Node_Sub6 {
    public static int[] anIntArray1107;
    Node_Sub6_Sub1 aClass5_Sub6_Sub1_1153;
    Node_Sub6_Sub3 aClass5_Sub6_Sub3_1154;
    NodeDeque aNodeDeque373;

    Node_Sub6_Sub4(Node_Sub6_Sub3 var1) {
        this.aNodeDeque373 = new NodeDeque();
        this.aClass5_Sub6_Sub1_1153 = new Node_Sub6_Sub1();
        this.aClass5_Sub6_Sub3_1154 = var1;
    }

    protected void method311(int[] var1, int var2, int var3) {
        this.aClass5_Sub6_Sub1_1153.method311(var1, var2, var3);

        for (Node_Sub19 var4 = (Node_Sub19) this.aNodeDeque373.head(); var4 != null; var4 = (Node_Sub19) this.aNodeDeque373.next()) {
            if (!this.aClass5_Sub6_Sub3_1154.method754(var4)) {
                int var5 = var2;
                int var6 = var3;

                do {
                    if (var6 <= var4.anInt563) {
                        this.method845(var4, var1, var5, var6, var5 + var6);
                        var4.anInt563 -= var6;
                        break;
                    }

                    this.method845(var4, var1, var5, var4.anInt563, var5 + var6);
                    var5 += var4.anInt563;
                    var6 -= var4.anInt563;
                } while (!this.aClass5_Sub6_Sub3_1154.method753(var4, var1, var5, var6));
            }
        }

    }

    protected void method303(int var1) {
        this.aClass5_Sub6_Sub1_1153.method303(var1);

        for (Node_Sub19 var2 = (Node_Sub19) this.aNodeDeque373.head(); var2 != null; var2 = (Node_Sub19) this.aNodeDeque373.next()) {
            if (!this.aClass5_Sub6_Sub3_1154.method754(var2)) {
                int var3 = var1;

                do {
                    if (var3 <= var2.anInt563) {
                        this.method846(var2, var3);
                        var2.anInt563 -= var3;
                        break;
                    }

                    this.method846(var2, var2.anInt563);
                    var3 -= var2.anInt563;
                } while (!this.aClass5_Sub6_Sub3_1154.method753(var2, null, 0, var3));
            }
        }

    }

    protected Node_Sub6 method308() {
        Node_Sub19 var1;
        do {
            var1 = (Node_Sub19) this.aNodeDeque373.next();
            if (var1 == null) {
                return null;
            }
        } while (var1.aClass5_Sub6_Sub2_1195 == null);

        return var1.aClass5_Sub6_Sub2_1195;
    }

    void method846(Node_Sub19 var1, int var2) {
        if ((this.aClass5_Sub6_Sub3_1154.anIntArray1102[var1.anInt380] & 4) != 0 && var1.anInt696 < 0) {
            int var3 = this.aClass5_Sub6_Sub3_1154.anIntArray785[var1.anInt380] / Class105.anInt775;
            int var4 = (var3 + 1048575 - var1.anInt1149) / var3;
            var1.anInt1149 = var3 * var2 + var1.anInt1149 & 1048575;
            if (var4 <= var2) {
                if (this.aClass5_Sub6_Sub3_1154.anIntArray1103[var1.anInt380] == 0) {
                    var1.aClass5_Sub6_Sub2_1195 = Node_Sub6_Sub2.method597(var1.aClass5_Sub10_Sub1_1194, var1.aClass5_Sub6_Sub2_1195.method583(), var1.aClass5_Sub6_Sub2_1195.method578(), var1.aClass5_Sub6_Sub2_1195.method599());
                } else {
                    var1.aClass5_Sub6_Sub2_1195 = Node_Sub6_Sub2.method597(var1.aClass5_Sub10_Sub1_1194, var1.aClass5_Sub6_Sub2_1195.method583(), 0, var1.aClass5_Sub6_Sub2_1195.method599());
                    this.aClass5_Sub6_Sub3_1154.method771(var1, var1.aNode_Sub16_1192.aShortArray1142[var1.anInt112] < 0);
                }

                if (var1.aNode_Sub16_1192.aShortArray1142[var1.anInt112] < 0) {
                    var1.aClass5_Sub6_Sub2_1195.method585(-1);
                }

                var2 = var1.anInt1149 / var3;
            }
        }

        var1.aClass5_Sub6_Sub2_1195.method303(var2);
    }

    void method845(Node_Sub19 var1, int[] var2, int var3, int var4, int var5) {
        if ((this.aClass5_Sub6_Sub3_1154.anIntArray1102[var1.anInt380] & 4) != 0 && var1.anInt696 < 0) {
            int var6 = this.aClass5_Sub6_Sub3_1154.anIntArray785[var1.anInt380] / Class105.anInt775;

            while (true) {
                int var7 = (var6 + 1048575 - var1.anInt1149) / var6;
                if (var7 > var4) {
                    var1.anInt1149 += var6 * var4;
                    break;
                }

                var1.aClass5_Sub6_Sub2_1195.method311(var2, var3, var7);
                var3 += var7;
                var4 -= var7;
                var1.anInt1149 += var7 * var6 - 1048576;
                int var8 = Class105.anInt775 / 100;
                int var9 = 262144 / var6;
                if (var9 < var8) {
                    var8 = var9;
                }

                Node_Sub6_Sub2 var10 = var1.aClass5_Sub6_Sub2_1195;
                if (this.aClass5_Sub6_Sub3_1154.anIntArray1103[var1.anInt380] == 0) {
                    var1.aClass5_Sub6_Sub2_1195 = Node_Sub6_Sub2.method597(var1.aClass5_Sub10_Sub1_1194, var10.method583(), var10.method578(), var10.method599());
                } else {
                    var1.aClass5_Sub6_Sub2_1195 = Node_Sub6_Sub2.method597(var1.aClass5_Sub10_Sub1_1194, var10.method583(), 0, var10.method599());
                    this.aClass5_Sub6_Sub3_1154.method771(var1, var1.aNode_Sub16_1192.aShortArray1142[var1.anInt112] < 0);
                    var1.aClass5_Sub6_Sub2_1195.method587(var8, var10.method578());
                }

                if (var1.aNode_Sub16_1192.aShortArray1142[var1.anInt112] < 0) {
                    var1.aClass5_Sub6_Sub2_1195.method585(-1);
                }

                var10.method589(var8);
                var10.method311(var2, var3, var5 - var3);
                if (var10.method577()) {
                    this.aClass5_Sub6_Sub1_1153.method312(var10);
                }
            }
        }

        var1.aClass5_Sub6_Sub2_1195.method311(var2, var3, var4);
    }

    protected Node_Sub6 method307() {
        Node_Sub19 var1 = (Node_Sub19) this.aNodeDeque373.head();
        if (var1 == null) {
            return null;
        }
        return (var1.aClass5_Sub6_Sub2_1195 != null ? var1.aClass5_Sub6_Sub2_1195 : this.method308());
    }

    protected int method305() {
        return 0;
    }
}
