package com.jagex;

import java.util.Iterator;

public class Class190 implements Iterator {
    LinkedList aLinkedList1562;
    Node aNode1563;
    Node aNode1561;

    Class190(LinkedList var1) {
        this.aNode1561 = null;
        this.method1138(var1);
    }

    void method1137() {
        this.aNode1563 = this.aLinkedList1562 != null ? this.aLinkedList1562.sentinel.next : null;
        this.aNode1561 = null;
    }

    void method1138(LinkedList var1) {
        this.aLinkedList1562 = var1;
        this.method1137();
    }

    public void remove() {
        if (this.aNode1561 == null) {
            throw new IllegalStateException();
        }
        this.aNode1561.unlink();
        this.aNode1561 = null;
    }

    public Object next() {
        Node var1 = this.aNode1563;
        if (var1 == this.aLinkedList1562.sentinel) {
            var1 = null;
            this.aNode1563 = null;
        } else {
            this.aNode1563 = var1.next;
        }

        this.aNode1561 = var1;
        return var1;
    }

    public boolean hasNext() {
        return this.aLinkedList1562.sentinel != this.aNode1563;
    }
}
