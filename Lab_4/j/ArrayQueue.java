package Lab_4.j;

public class ArrayQueue<T> {
    private Object[] data = new Object[32];
    private int start = 0, end = 0;

    public ArrayQueue() {
    }

    public ArrayQueue(int max_size) {
        this.data = new Object[max_size];
    }

    public boolean isEmpty() {
        return start == end;
    }

    public boolean isFull() {
        return end - start == data.length;
    }

    public void enqueue(T value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Cannot enqueue to full ArrayQueue.");
        }
        data[end++ % data.length] = value;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Cannot dequeue from empty ArrayQueue.");
        }
        T out = (T) data[start];
        data[start++] = null;
        if (start >= data.length) {
            start -= data.length;
            end -= data.length;
        }
        return out;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Empty ArrayQueue has no elements to peek.");
        }
        return (T) data[start];
    }

    public int size() {
        return end - start;
    }

    public char print() {
        System.out.print(toString());
        return 0;
    }

    public String toString() {
        String out = "[";
        for (int i = start; i < end; i++) {
            out += (i == start ? " " : ", ") + data[i % data.length];
        }
        return out + " ]";
    }
}
