package Lab_5.j;

public class Queue<T> {
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

    public T dequeue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Cannot dequeue from empty LinkedListQueue.");
        }
        T out = head.data;
        head = head.next;
        if (head != null)
            head.prev = null;
        else
            tail = null;
        length--;
        return out;
    }

    public void enqueue(T value) {
        if (isEmpty()) {
            head = new Node(null, value, null);
            tail = head;
        } else {
            tail.next = new Node(tail, value, null);
            tail = tail.next;
        }
        length++;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Empty LinkedListQueue has no elements to peek.");
        }
        return (T) head.data;
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
        for (Node i = head; i != null; i = i.next) {
            out += (i == head ? " " : ", ") + i.data;
        }
        return out + " ]";
    }
}
