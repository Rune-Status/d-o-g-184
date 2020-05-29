package jag.commons.collection;

public class HardLinkedReference extends LinkedReference {

    public final Object element;

    public HardLinkedReference(Object element, int size) {
        super(size);
        this.element = element;
    }

    public boolean isSoft() {
        return false;
    }

    public Object getReferent() {
        return this.element;
    }
}
