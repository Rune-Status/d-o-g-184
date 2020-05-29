package jag.commons.collection;

public class NodeDeque<T extends Node> {

    public final Node sentinel;
    public Node current;

    public NodeDeque() {
        this.sentinel = new Node();
        this.sentinel.next = this.sentinel;
        this.sentinel.previous = this.sentinel;
    }

    public static void replace(Node a, Node b) {
        if (a.previous != null) {
            a.unlink();
        }

        a.previous = b.previous;
        a.next = b;
        a.previous.next = a;
        a.next.previous = a;
    }

    public void insert(T node) {
        if (node.previous != null) {
            node.unlink();
        }

        node.previous = this.sentinel;
        node.next = this.sentinel.next;
        node.previous.next = node;
        node.next.previous = node;
    }

    public T head() {
        Node first = this.sentinel.next;
        if (first == this.sentinel) {
            this.current = null;
            return null;
        }
        this.current = first.next;
        return (T) first;
    }

    public T next() {
        Node next = this.current;
        if (next == this.sentinel) {
            this.current = null;
            return null;
        }
        this.current = next.next;
        return (T) next;
    }

    public void add(T node) {
        if (node.previous != null) {
            node.unlink();
        }

        node.previous = this.sentinel.previous;
        node.next = this.sentinel;
        node.previous.next = node;
        node.next.previous = node;
    }

    public T popFirst() {
        Node var1 = this.sentinel.next;
        if (var1 == this.sentinel) {
            return null;
        }
        var1.unlink();
        return (T) var1;
    }

    public T tail() {
        Node var1 = this.sentinel.previous;
        if (var1 == this.sentinel) {
            this.current = null;
            return null;
        }
        this.current = var1.previous;
        return (T) var1;
    }

    public T popLast() {
        Node var1 = this.sentinel.previous;
        if (var1 == this.sentinel) {
            return null;
        }
        var1.unlink();
        return (T) var1;
    }

    public T previous() {
        Node var1 = this.current;
        if (var1 == this.sentinel) {
            this.current = null;
            return null;
        }
        this.current = var1.previous;
        return (T) var1;
    }

    public void clear() {
        while (true) {
            Node remove = this.sentinel.next;
            if (remove == this.sentinel) {
                this.current = null;
                return;
            }
            remove.unlink();
        }
    }
}
