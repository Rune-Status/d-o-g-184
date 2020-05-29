package jag.commons.collection;

public final class Queue {

    public final DoublyLinkedNode root;

    public Queue() {
        this.root = new DoublyLinkedNode();
        this.root.nextDoubly = this.root;
        this.root.previousDoubly = this.root;
    }

    public void method301(DoublyLinkedNode var1) {
        if (var1.previousDoubly != null) {
            var1.unlinkDoubly();
        }

        var1.previousDoubly = this.root;
        var1.nextDoubly = this.root.nextDoubly;
        var1.previousDoubly.nextDoubly = var1;
        var1.nextDoubly.previousDoubly = var1;
    }

    public DoublyLinkedNode method299() {
        DoublyLinkedNode var1 = this.root.nextDoubly;
        return var1 == this.root ? null : var1;
    }

    public void method300(DoublyLinkedNode var1) {
        if (var1.previousDoubly != null) {
            var1.unlinkDoubly();
        }

        var1.previousDoubly = this.root.previousDoubly;
        var1.nextDoubly = this.root;
        var1.previousDoubly.nextDoubly = var1;
        var1.nextDoubly.previousDoubly = var1;
    }
}
