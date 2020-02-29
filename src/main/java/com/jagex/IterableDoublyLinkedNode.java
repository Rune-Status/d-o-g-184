package com.jagex;

import java.util.Iterator;

public class IterableDoublyLinkedNode implements Iterable {
    public DoublyLinkedNode aDoublyLinkedNode1534;
    DoublyLinkedNode aDoublyLinkedNode1535;

    public IterableDoublyLinkedNode() {
        this.aDoublyLinkedNode1534 = new DoublyLinkedNode();
        this.aDoublyLinkedNode1534.nextDoubly = this.aDoublyLinkedNode1534;
        this.aDoublyLinkedNode1534.previousDoubly = this.aDoublyLinkedNode1534;
    }

    public static void method1132(DoublyLinkedNode var0, DoublyLinkedNode var1) {
        if (var0.previousDoubly != null) {
            var0.unlinkDoubly();
        }

        var0.previousDoubly = var1;
        var0.nextDoubly = var1.nextDoubly;
        var0.previousDoubly.nextDoubly = var0;
        var0.nextDoubly.previousDoubly = var0;
    }

    DoublyLinkedNode method1128() {
        DoublyLinkedNode var2;
        if (null == null) {
            var2 = this.aDoublyLinkedNode1534.nextDoubly;
        } else {
            var2 = null;
        }

        if (var2 == this.aDoublyLinkedNode1534) {
            this.aDoublyLinkedNode1535 = null;
            return null;
        }
        this.aDoublyLinkedNode1535 = var2.nextDoubly;
        return var2;
    }

    public DoublyLinkedNode method1130() {
        return this.method1128();
    }

    public void method1133() {
        while (this.aDoublyLinkedNode1534.nextDoubly != this.aDoublyLinkedNode1534) {
            this.aDoublyLinkedNode1534.nextDoubly.unlinkDoubly();
        }

    }

    public DoublyLinkedNode method1131() {
        DoublyLinkedNode var1 = this.aDoublyLinkedNode1534.nextDoubly;
        if (var1 == this.aDoublyLinkedNode1534) {
            return null;
        }
        var1.unlinkDoubly();
        return var1;
    }

    public void method1134(DoublyLinkedNode var1) {
        if (var1.previousDoubly != null) {
            var1.unlinkDoubly();
        }

        var1.previousDoubly = this.aDoublyLinkedNode1534.previousDoubly;
        var1.nextDoubly = this.aDoublyLinkedNode1534;
        var1.previousDoubly.nextDoubly = var1;
        var1.nextDoubly.previousDoubly = var1;
    }

    public DoublyLinkedNode method1129() {
        DoublyLinkedNode var1 = this.aDoublyLinkedNode1535;
        if (var1 == this.aDoublyLinkedNode1534) {
            this.aDoublyLinkedNode1535 = null;
            return null;
        }
        this.aDoublyLinkedNode1535 = var1.nextDoubly;
        return var1;
    }

    public Iterator iterator() {
        return new Class188(this);
    }
}
