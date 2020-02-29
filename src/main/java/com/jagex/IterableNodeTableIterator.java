package com.jagex;

import java.util.Iterator;

public class IterableNodeTableIterator implements Iterator {
    Node aNode1826;
    Node aNode1829;
    IterableNodeTable table;
    int anInt1827;

    IterableNodeTableIterator(IterableNodeTable var1) {
        aNode1826 = null;
        table = var1;
        method1327();
    }

    void method1327() {
        aNode1829 = table.buckets[0].next;
        anInt1827 = 1;
        aNode1826 = null;
    }

    public void remove() {
        if (aNode1826 == null) {
            throw new IllegalStateException();
        }
        aNode1826.unlink();
        aNode1826 = null;
    }

    public Object next() {
        Node var1;
        if (table.buckets[anInt1827 - 1] != aNode1829) {
            var1 = aNode1829;
            aNode1829 = var1.next;
            aNode1826 = var1;
            return var1;
        }
        do {
            if (anInt1827 >= table.size) {
                return null;
            }

            var1 = table.buckets[anInt1827++].next;
        } while (var1 == table.buckets[anInt1827 - 1]);

        aNode1829 = var1.next;
        aNode1826 = var1;
        return var1;
    }

    public boolean hasNext() {
        if (table.buckets[anInt1827 - 1] != aNode1829) {
            return true;
        }
        while (anInt1827 < table.size) {
            if (table.buckets[anInt1827++].next != table.buckets[anInt1827 - 1]) {
                aNode1829 = table.buckets[anInt1827 - 1].next;
                return true;
            }

            aNode1829 = table.buckets[anInt1827 - 1];
        }

        return false;
    }
}
