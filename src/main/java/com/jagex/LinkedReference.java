package com.jagex;

public abstract class LinkedReference extends DoublyLinkedNode {

    final int size;

    LinkedReference(int size) {
        this.size = size;
    }

    abstract boolean isSoft();

    abstract Object getReferent();
}
