package Lab_4.j;

public class LinkedListStack<T> {
    private class Node {
        Node prev, next;
        T data;

        public Node(Node prev, T data, Node next) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }
    }

    private Node head, tail;
    private int length = 0;

    public boolean isEmpty() {
        return head == null;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Cannot pop from empty LinkedListStack.");
        }
        T out = tail.data;
        tail = tail.prev;
        if (tail != null)
            tail.next = null;
        else
            head = null;
        length--;
        return out;
    }

    public void push(T value) {
        if (isEmpty()) {
            head = new Node(null, value, null);
            tail = head;
        } else {
            tail.next = new Node(tail, value, null);
            tail = tail.next;
        }
        length++;
    }

    public T top() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Empty ArrayStack has no top.");
        }
        return (T) tail.data;
    }

    public int size() {
        return length;
    }

    public char print() {
        System.out.print(toString());
        return 0;
    }

    public String toString() {
        String out = "[";
        for (Node i = tail; i != null; i = i.prev) {
            out += (i == tail ? " " : ", ") + i.data;
        }
        return out + " ]";
    }
}
