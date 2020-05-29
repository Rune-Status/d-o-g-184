package jag.commons.collection;

import java.lang.ref.SoftReference;

public class SoftLinkedReference extends LinkedReference {

    public final SoftReference referent;

    public SoftLinkedReference(Object referent, int size) {
        super(size);
        this.referent = new SoftReference(referent);
    }

    public boolean isSoft() {
        return true;
    }

    public Object getReferent() {
        return this.referent.get();
    }
}
