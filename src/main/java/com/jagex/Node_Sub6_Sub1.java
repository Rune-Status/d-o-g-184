package com.jagex;

public class Node_Sub6_Sub1 extends Node_Sub6 {
    NodeDeque aNodeDeque454;
    NodeDeque aNodeDeque373;
    int anInt377;
    int anInt378;

    public Node_Sub6_Sub1() {
        this.aNodeDeque454 = new NodeDeque();
        this.aNodeDeque373 = new NodeDeque();
        this.anInt378 = 0;
        this.anInt377 = -1;
    }

    void method304(int[] var1, int var2, int var3) {
        for (Node_Sub6 var4 = (Node_Sub6) this.aNodeDeque454.head(); var4 != null; var4 = (Node_Sub6) this.aNodeDeque454.next()) {
            var4.method482(var1, var2, var3);
        }

    }

    void method302(int var1) {
        for (Node_Sub6 var2 = (Node_Sub6) this.aNodeDeque454.head(); var2 != null; var2 = (Node_Sub6) this.aNodeDeque454.next()) {
            var2.method303(var1);
        }

    }

    public final synchronized void method311(int[] var1, int var2, int var3) {
        do {
            if (this.anInt377 < 0) {
                this.method304(var1, var2, var3);
                return;
            }

            if (var3 + this.anInt378 < this.anInt377) {
                this.anInt378 += var3;
                this.method304(var1, var2, var3);
                return;
            }

            int var4 = this.anInt377 - this.anInt378;
            this.method304(var1, var2, var4);
            var2 += var4;
            var3 -= var4;
            this.anInt378 += var4;
            this.method23();
            Node_Sub7 var5 = (Node_Sub7) this.aNodeDeque373.head();
            synchronized (var5) {
                int var7 = var5.method500(this);
                if (var7 < 0) {
                    var5.anInt380 = 0;
                    this.method309(var5);
                } else {
                    var5.anInt380 = var7;
                    this.method310(var5.next, var5);
                }
            }
        } while (var3 != 0);

    }

    public final synchronized void method303(int var1) {
        do {
            if (this.anInt377 < 0) {
                this.method302(var1);
                return;
            }

            if (this.anInt378 + var1 < this.anInt377) {
                this.anInt378 += var1;
                this.method302(var1);
                return;
            }

            int var2 = this.anInt377 - this.anInt378;
            this.method302(var2);
            var1 -= var2;
            this.anInt378 += var2;
            this.method23();
            Node_Sub7 var3 = (Node_Sub7) this.aNodeDeque373.head();
            synchronized (var3) {
                int var5 = var3.method500(this);
                if (var5 < 0) {
                    var3.anInt380 = 0;
                    this.method309(var3);
                } else {
                    var3.anInt380 = var5;
                    this.method310(var3.next, var3);
                }
            }
        } while (var1 != 0);

    }

    protected Node_Sub6 method308() {
        return (Node_Sub6) this.aNodeDeque454.next();
    }

    void method23() {
        if (this.anInt378 > 0) {
            for (Node_Sub7 var1 = (Node_Sub7) this.aNodeDeque373.head(); var1 != null; var1 = (Node_Sub7) this.aNodeDeque373.next()) {
                var1.anInt380 -= this.anInt378;
            }

            this.anInt377 -= this.anInt378;
            this.anInt378 = 0;
        }

    }

    public final synchronized void method312(Node_Sub6 var1) {
        this.aNodeDeque454.insert(var1);
    }

    protected Node_Sub6 method307() {
        return (Node_Sub6) this.aNodeDeque454.head();
    }

    public final synchronized void method306(Node_Sub6 var1) {
        var1.unlink();
    }

    void method309(Node_Sub7 var1) {
        var1.unlink();
        var1.method499();
        Node var2 = this.aNodeDeque373.sentinel.next;
        if (var2 == this.aNodeDeque373.sentinel) {
            this.anInt377 = -1;
        } else {
            this.anInt377 = ((Node_Sub7) var2).anInt380;
        }

    }

    void method310(Node var1, Node_Sub7 var2) {
        while (this.aNodeDeque373.sentinel != var1 && ((Node_Sub7) var1).anInt380 <= var2.anInt380) {
            var1 = var1.next;
        }

        NodeDeque.replace(var2, var1);
        this.anInt377 = ((Node_Sub7) this.aNodeDeque373.sentinel.next).anInt380;
    }

    protected int method305() {
        return 0;
    }
}
