package com.jagex;

import java.lang.ref.SoftReference;

public class SoftLinkedReference extends LinkedReference {

    SoftReference referent;

    SoftLinkedReference(Object referent, int size) {
        super(size);
        this.referent = new SoftReference(referent);
    }

    boolean isSoft() {
        return true;
    }

    Object getReferent() {
        return this.referent.get();
    }
}
