package jag.commons.collection;

public final class NodeTable<T extends Node> {

    public final Node[] buckets;
    public final int size;
    public int index;
    public Node tail;
    public Node head;

    public NodeTable(int var1) {
        this.index = 0;
        this.size = var1;
        this.buckets = new Node[var1];

        for (int var2 = 0; var2 < var1; ++var2) {
            Node var3 = this.buckets[var2] = new Node();
            var3.next = var3;
            var3.previous = var3;
        }

    }

    public T head() {
        this.index = 0;
        return this.next();
    }

    public T lookup(long var1) {
        Node var3 = this.buckets[(int) (var1 & (long) (this.size - 1))];

        for (this.head = var3.next; var3 != this.head; this.head = this.head.next) {
            if (this.head.key == var1) {
                Node var4 = this.head;
                this.head = this.head.next;
                return (T) var4;
            }
        }

        this.head = null;
        return null;
    }

    public T next() {
        Node var1;
        if (this.index > 0 && this.buckets[this.index - 1] != this.tail) {
            var1 = this.tail;
            this.tail = var1.next;
            return (T) var1;
        }
        do {
            if (this.index >= this.size) {
                return null;
            }

            var1 = this.buckets[this.index++].next;
        } while (var1 == this.buckets[this.index - 1]);

        this.tail = var1.next;
        return (T) var1;
    }

    public void put(T var1, long var2) {
        if (var1.previous != null) {
            var1.unlink();
        }

        Node var4 = this.buckets[(int) (var2 & (long) (this.size - 1))];
        var1.previous = var4.previous;
        var1.next = var4;
        var1.previous.next = var1;
        var1.next.previous = var1;
        var1.key = var2;
    }
}
