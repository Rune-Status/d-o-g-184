package com.jagex;

public class NodeDeque {

    public Node sentinel;
    Node current;

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

    public void insert(Node node) {
        if (node.previous != null) {
            node.unlink();
        }

        node.previous = this.sentinel;
        node.next = this.sentinel.next;
        node.previous.next = node;
        node.next.previous = node;
    }

    public Node head() {
        Node first = this.sentinel.next;
        if (first == this.sentinel) {
            this.current = null;
            return null;
        }
        this.current = first.next;
        return first;
    }

    public Node next() {
        Node next = this.current;
        if (next == this.sentinel) {
            this.current = null;
            return null;
        }
        this.current = next.next;
        return next;
    }

    public void add(Node node) {
        if (node.previous != null) {
            node.unlink();
        }

        node.previous = this.sentinel.previous;
        node.next = this.sentinel;
        node.previous.next = node;
        node.next.previous = node;
    }

    public Node popFirst() {
        Node var1 = this.sentinel.next;
        if (var1 == this.sentinel) {
            return null;
        }
        var1.unlink();
        return var1;
    }

    public Node tail() {
        Node var1 = this.sentinel.previous;
        if (var1 == this.sentinel) {
            this.current = null;
            return null;
        }
        this.current = var1.previous;
        return var1;
    }

    public Node popLast() {
        Node var1 = this.sentinel.previous;
        if (var1 == this.sentinel) {
            return null;
        }
        var1.unlink();
        return var1;
    }

    public Node previous() {
        Node var1 = this.current;
        if (var1 == this.sentinel) {
            this.current = null;
            return null;
        }
        this.current = var1.previous;
        return var1;
    }

    public void clear() {
        while (true) {
            Node var1 = this.sentinel.next;
            if (var1 == this.sentinel) {
                this.current = null;
                return;
            }

            var1.unlink();
        }
    }
}
