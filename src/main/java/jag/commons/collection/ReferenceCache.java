package jag.commons.collection;

public final class ReferenceCache {

    public final IterableNodeTable table;
    public final IterableDoublyLinkedNode iterable;
    public final int anInt485;
    public int anInt483;
    public DoublyLinkedNode sentinel;

    public ReferenceCache(int var1) {
        this.sentinel = new DoublyLinkedNode();
        this.iterable = new IterableDoublyLinkedNode();
        this.anInt485 = var1;
        this.anInt483 = var1;

        int var2 = 1;
        while (var2 + var2 < var1) {
            var2 += var2;
        }

        this.table = new IterableNodeTable(var2);
    }

    public DoublyLinkedNode get(long var1) {
        DoublyLinkedNode var3 = (DoublyLinkedNode) this.table.lookup(var1);
        if (var3 != null) {
            this.iterable.method1134(var3);
        }

        return var3;
    }

    public void put(DoublyLinkedNode var1, long var2) {
        if (this.anInt483 == 0) {
            DoublyLinkedNode var4 = this.iterable.method1131();
            var4.unlink();
            var4.unlinkDoubly();
            if (var4 == this.sentinel) {
                var4 = this.iterable.method1131();
                var4.unlink();
                var4.unlinkDoubly();
            }
        } else {
            --this.anInt483;
        }

        this.table.method237(var1, var2);
        this.iterable.method1134(var1);
    }

    public void clear() {
        this.iterable.method1133();
        this.table.method236();
        this.sentinel = new DoublyLinkedNode();
        this.anInt483 = this.anInt485;
    }

    public void method337(long var1) {
        DoublyLinkedNode var3 = (DoublyLinkedNode) this.table.lookup(var1);
        if (var3 != null) {
            var3.unlink();
            var3.unlinkDoubly();
            ++this.anInt483;
        }

    }
}
