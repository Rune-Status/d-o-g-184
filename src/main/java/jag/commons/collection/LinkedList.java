package jag.commons.collection;

import java.util.Collection;
import java.util.Iterator;

public class LinkedList implements Iterable, Collection {

    public final Node sentinel;
    public Node tail;

    public LinkedList() {
        this.sentinel = new Node();
        this.sentinel.next = this.sentinel;
        this.sentinel.previous = this.sentinel;
    }

    public static void insertBefore(Node var0, Node var1) {
        if (var0.previous != null) {
            var0.unlink();
        }

        var0.previous = var1;
        var0.next = var1.next;
        var0.previous.next = var0;
        var0.next.previous = var0;
    }

    public boolean method653(Node var1) {
        this.pushBack(var1);
        return true;
    }

    public Node[] method654() {
        Node[] var1 = new Node[this.method655()];
        int var2 = 0;

        for (Node var3 = this.sentinel.next; var3 != this.sentinel; var3 = var3.next) {
            var1[var2++] = var3;
        }

        return var1;
    }

    public int method655() {
        int var1 = 0;

        for (Node var2 = this.sentinel.next; var2 != this.sentinel; var2 = var2.next) {
            ++var1;
        }

        return var1;
    }

    public void removeAll() {
        while (this.sentinel.next != this.sentinel) {
            this.sentinel.next.unlink();
        }

    }

    public Node method657() {
        Node var2 = this.sentinel.next;

        if (var2 == this.sentinel) {
            this.tail = null;
            return null;
        }
        this.tail = var2.next;
        return var2;
    }

    public boolean method662() {
        return this.sentinel.next == this.sentinel;
    }

    public void pushBack(Node var1) {
        if (var1.previous != null) {
            var1.unlink();
        }

        var1.previous = this.sentinel.previous;
        var1.next = this.sentinel;
        var1.previous.next = var1;
        var1.next.previous = var1;
    }

    public Node head() {
        return this.method657();
    }

    public Node next() {
        Node var1 = this.tail;
        if (var1 == this.sentinel) {
            this.tail = null;
            return null;
        }
        this.tail = var1.next;
        return var1;
    }

    public void addElement(Node var1) {
        if (var1.previous != null) {
            var1.unlink();
        }

        var1.previous = this.sentinel;
        var1.next = this.sentinel.next;
        var1.previous.next = var1;
        var1.next.previous = var1;
    }

    public Iterator iterator() {
        return new LinkedListIterator(this);
    }

    public int size() {
        return this.method655();
    }

    public boolean isEmpty() {
        return this.method662();
    }

    public boolean contains(Object var1) {
        throw new RuntimeException();
    }

    public Object[] toArray(Object[] var1) {
        int var2 = 0;

        for (Node var3 = this.sentinel.next; var3 != this.sentinel; var3 = var3.next) {
            var1[var2++] = var3;
        }

        return var1;
    }

    public void clear() {
        this.removeAll();
    }

    public boolean add(Object var1) {
        return this.method653((Node) var1);
    }

    public boolean equals(Object var1) {
        return super.equals(var1);
    }

    public boolean retainAll(Collection var1) {
        throw new RuntimeException();
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean containsAll(Collection var1) {
        throw new RuntimeException();
    }

    public boolean addAll(Collection var1) {
        throw new RuntimeException();
    }

    public boolean remove(Object var1) {
        throw new RuntimeException();
    }

    public Object[] toArray() {
        return this.method654();
    }

    public boolean removeAll(Collection var1) {
        throw new RuntimeException();
    }
}
