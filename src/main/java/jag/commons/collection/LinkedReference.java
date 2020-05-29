package jag.commons.collection;

public abstract class LinkedReference extends DoublyLinkedNode {

    public final int size;

    public LinkedReference(int size) {
        this.size = size;
    }

    public abstract boolean isSoft();

    public abstract Object getReferent();
}
