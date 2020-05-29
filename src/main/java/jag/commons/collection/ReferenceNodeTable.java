package jag.commons.collection;

public final class ReferenceNodeTable {

    final int capacity;
    final IterableNodeTable table;
    final IterableDoublyLinkedNode iterable;
    int remaining;
    ReferenceSweeper aReferenceSweeper_805;

    public ReferenceNodeTable(int var1, int var2) {
        this.iterable = new IterableDoublyLinkedNode();
        this.capacity = var1;
        this.remaining = var1;

        int var3;
        for (var3 = 1; var3 + var3 < var1 && var3 < var2; var3 += var3) {
        }

        this.table = new IterableNodeTable(var3);
    }

    public void method666(int var1) {
        for (LinkedReference var2 = (LinkedReference) this.iterable.method1130(); var2 != null; var2 = (LinkedReference) this.iterable.method1129()) {
            if (var2.isSoft()) {
                if (var2.getReferent() == null) {
                    var2.unlink();
                    var2.unlinkDoubly();
                    this.remaining += var2.size;
                }
            } else if (++var2.doublyKey > (long) var1) {
                SoftLinkedReference var3 = new SoftLinkedReference(var2.getReferent(), var2.size);
                this.table.method237(var3, var2.key);
                IterableDoublyLinkedNode.method1132(var3, var2);
                var2.unlink();
                var2.unlinkDoubly();
            }
        }

    }

    void method670(long var1) {
        LinkedReference var3 = (LinkedReference) this.table.lookup(var1);
        this.method668(var3);
    }

    void method668(LinkedReference var1) {
        if (var1 != null) {
            var1.unlink();
            var1.unlinkDoubly();
            this.remaining += var1.size;
        }

    }

    public Object method669(long var1) {
        LinkedReference var3 = (LinkedReference) this.table.lookup(var1);
        if (var3 == null) {
            return null;
        }
        Object var4 = var3.getReferent();
        if (var4 == null) {
            var3.unlink();
            var3.unlinkDoubly();
            this.remaining += var3.size;
            return null;
        }
        if (var3.isSoft()) {
            HardLinkedReference var5 = new HardLinkedReference(var4, var3.size);
            this.table.method237(var5, var3.key);
            this.iterable.method1134(var5);
            var5.doublyKey = 0L;
            var3.unlink();
            var3.unlinkDoubly();
        } else {
            this.iterable.method1134(var3);
            var3.doublyKey = 0L;
        }

        return var4;
    }

    public void method667(Object var1, long var2, int var4) {
        if (var4 > this.capacity) {
            throw new IllegalStateException();
        }
        this.method670(var2);
        this.remaining -= var4;

        while (this.remaining < 0) {
            LinkedReference var5 = (LinkedReference) this.iterable.method1131();
            if (var5 == null) {
                throw new RuntimeException("");
            }

            if (!var5.isSoft()) {
            }

            this.method668(var5);
            if (this.aReferenceSweeper_805 != null) {
                this.aReferenceSweeper_805.method671(var5.getReferent());
            }
        }

        HardLinkedReference var6 = new HardLinkedReference(var1, var4);
        this.table.method237(var6, var2);
        this.iterable.method1134(var6);
        var6.doublyKey = 0L;
    }

    public void method665() {
        this.iterable.method1133();
        this.table.method236();
        this.remaining = this.capacity;
    }
}
