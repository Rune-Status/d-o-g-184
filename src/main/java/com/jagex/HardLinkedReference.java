package com.jagex;

public class HardLinkedReference extends LinkedReference {

    Object element;

    HardLinkedReference(Object element, int size) {
        super(size);
        this.element = element;
    }

    boolean isSoft() {
        return false;
    }

    Object getReferent() {
        return this.element;
    }
}
