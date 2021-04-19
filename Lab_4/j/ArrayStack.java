package Lab_4.j;

public class ArrayStack<T> {
    private Object[] data = new Object[32];
    private int length = 0;

    public ArrayStack() {
    }

    public ArrayStack(int max_size) {
        this.data = new Object[max_size];
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == data.length;
    }

    public void push(T value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Cannot push to full ArrayStack.");
        }
        data[length++] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Cannot pop from empty ArrayStack.");
        }
        T out = (T) data[--length];
        data[length] = null;
        return out;
    }

    @SuppressWarnings("unchecked")
    public T top() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Empty ArrayStack has no top.");
        }
        return (T) data[length - 1];
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
        for (int i = length - 1; i >= 0; i--) {
            out += (i == length - 1 ? " " : ", ") + data[i];
        }
        return out + " ]";
    }
}
