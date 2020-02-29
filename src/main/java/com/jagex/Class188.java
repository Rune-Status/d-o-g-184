package com.jagex;

import java.util.Iterator;

public class Class188 implements Iterator {
    DoublyLinkedNode aDoublyLinkedNode1560;
    DoublyLinkedNode aDoublyLinkedNode1558;
    IterableDoublyLinkedNode aIterableDoublyLinkedNode_1559;

    Class188(IterableDoublyLinkedNode var1) {
        this.aDoublyLinkedNode1558 = null;
        this.aIterableDoublyLinkedNode_1559 = var1;
        this.aDoublyLinkedNode1560 = this.aIterableDoublyLinkedNode_1559.aDoublyLinkedNode1534.nextDoubly;
        this.aDoublyLinkedNode1558 = null;
    }

    public void remove() {
        if (this.aDoublyLinkedNode1558 == null) {
            throw new IllegalStateException();
        }
        this.aDoublyLinkedNode1558.unlinkDoubly();
        this.aDoublyLinkedNode1558 = null;
    }

    public boolean hasNext() {
        return this.aIterableDoublyLinkedNode_1559.aDoublyLinkedNode1534 != this.aDoublyLinkedNode1560;
    }

    public Object next() {
        DoublyLinkedNode var1 = this.aDoublyLinkedNode1560;
        if (var1 == this.aIterableDoublyLinkedNode_1559.aDoublyLinkedNode1534) {
            var1 = null;
            this.aDoublyLinkedNode1560 = null;
        } else {
            this.aDoublyLinkedNode1560 = var1.nextDoubly;
        }

        this.aDoublyLinkedNode1558 = var1;
        return var1;
    }
}
