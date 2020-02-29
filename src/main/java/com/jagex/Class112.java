package com.jagex;

public final class Class112 {
    int anInt808;
    IterableNodeTable aIterableNodeTable807;
    IterableDoublyLinkedNode aIterableDoublyLinkedNode_806;
    int anInt809;
    Class113 aClass113_805;

    public Class112(int var1, int var2) {
        this.aIterableDoublyLinkedNode_806 = new IterableDoublyLinkedNode();
        this.anInt808 = var1;
        this.anInt809 = var1;

        int var3;
        for (var3 = 1; var3 + var3 < var1 && var3 < var2; var3 += var3) {
        }

        this.aIterableNodeTable807 = new IterableNodeTable(var3);
    }

    public void method666(int var1) {
        for (LinkedReference var2 = (LinkedReference) this.aIterableDoublyLinkedNode_806.method1130(); var2 != null; var2 = (LinkedReference) this.aIterableDoublyLinkedNode_806.method1129()) {
            if (var2.isSoft()) {
                if (var2.getReferent() == null) {
                    var2.unlink();
                    var2.unlinkDoubly();
                    this.anInt809 += var2.size;
                }
            } else if (++var2.doublyKey > (long) var1) {
                SoftLinkedReference var3 = new SoftLinkedReference(var2.getReferent(), var2.size);
                this.aIterableNodeTable807.method237(var3, var2.key);
                IterableDoublyLinkedNode.method1132(var3, var2);
                var2.unlink();
                var2.unlinkDoubly();
            }
        }

    }

    void method670(long var1) {
        LinkedReference var3 = (LinkedReference) this.aIterableNodeTable807.lookup(var1);
        this.method668(var3);
    }

    void method668(LinkedReference var1) {
        if (var1 != null) {
            var1.unlink();
            var1.unlinkDoubly();
            this.anInt809 += var1.size;
        }

    }

    public Object method669(long var1) {
        LinkedReference var3 = (LinkedReference) this.aIterableNodeTable807.lookup(var1);
        if (var3 == null) {
            return null;
        }
        Object var4 = var3.getReferent();
        if (var4 == null) {
            var3.unlink();
            var3.unlinkDoubly();
            this.anInt809 += var3.size;
            return null;
        }
        if (var3.isSoft()) {
            HardLinkedReference var5 = new HardLinkedReference(var4, var3.size);
            this.aIterableNodeTable807.method237(var5, var3.key);
            this.aIterableDoublyLinkedNode_806.method1134(var5);
            var5.doublyKey = 0L;
            var3.unlink();
            var3.unlinkDoubly();
        } else {
            this.aIterableDoublyLinkedNode_806.method1134(var3);
            var3.doublyKey = 0L;
        }

        return var4;
    }

    public void method667(Object var1, long var2, int var4) {
        if (var4 > this.anInt808) {
            throw new IllegalStateException();
        }
        this.method670(var2);
        this.anInt809 -= var4;

        while (this.anInt809 < 0) {
            LinkedReference var5 = (LinkedReference) this.aIterableDoublyLinkedNode_806.method1131();
            if (var5 == null) {
                throw new RuntimeException("");
            }

            if (!var5.isSoft()) {
            }

            this.method668(var5);
            if (this.aClass113_805 != null) {
                this.aClass113_805.method671(var5.getReferent());
            }
        }

        HardLinkedReference var6 = new HardLinkedReference(var1, var4);
        this.aIterableNodeTable807.method237(var6, var2);
        this.aIterableDoublyLinkedNode_806.method1134(var6);
        var6.doublyKey = 0L;
    }

    public void method665() {
        this.aIterableDoublyLinkedNode_806.method1133();
        this.aIterableNodeTable807.method236();
        this.anInt809 = this.anInt808;
    }
}
