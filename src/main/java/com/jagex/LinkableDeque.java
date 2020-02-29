package com.jagex;

public class LinkableDeque {

    Linkable aLinkable_1531;
    Linkable aLinkable_1532;

    public LinkableDeque() {
        this.aLinkable_1531 = new Linkable();
        this.aLinkable_1531.next = this.aLinkable_1531;
        this.aLinkable_1531.previous = this.aLinkable_1531;
    }

    public Linkable current() {
        Linkable var1 = this.aLinkable_1531.next;
        if (var1 == this.aLinkable_1531) {
            this.aLinkable_1532 = null;
            return null;
        }
        this.aLinkable_1532 = var1.next;
        return var1;
    }

    public Linkable next() {
        Linkable var1 = this.aLinkable_1532;
        if (var1 == this.aLinkable_1531) {
            this.aLinkable_1532 = null;
            return null;
        }
        this.aLinkable_1532 = var1.next;
        return var1;
    }

    public void method1125(Linkable var1) {
        if (var1.previous != null) {
            var1.unlink();
        }

        var1.previous = this.aLinkable_1531.previous;
        var1.next = this.aLinkable_1531;
        var1.previous.next = var1;
        var1.next.previous = var1;
    }
}
