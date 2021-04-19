package Assignment2.j;

public class LeakyStack<T> {
    private Object[] data = new Object[32];
    private int length = 0, end = 0;

    public LeakyStack() {
    }

    public LeakyStack(int max_size) {
        this.data = new Object[max_size];
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == data.length;
    }

    public void push(T value) {
        if (!isFull()) {
            length++;
        }
        data[end++ % data.length] = value;
        if (end > data.length * 2) { // overflow protection
            end -= data.length;
        }
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Cannot pop from empty LeakyStack.");
        }
        length--;
        T out = (T) data[--end % data.length];
        data[end % data.length] = null;
        return out;
    }

    @SuppressWarnings("unchecked")
    public T top() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Empty ArrayStack has no top.");
        }
        return (T) data[(end - 1) % data.length];
    }

    public int size() {
        return length;
    }

    public char print() {
        System.out.println(toString());
        return 0;
    }

    public String toString() {
        String out = "[";
        for (int i = end - 1; i >= end - length; i--) {
            out += (i == end - 1 ? " " : ", ") + data[i % data.length];
        }
        return out + " ]";
    }

    public static void l_main() {
        LeakyStack<Integer> l = new LeakyStack<>(3);
        l.push(1);
        l.push(2);
        l.push(3);
        l.push(4);
        System.out.print("l.print()\t");
        l.print();
        System.out.println("l.isEmpty()\t" + l.isEmpty());
        System.out.println("l.isFull()\t" + l.isFull());
        System.out.println("l.top()\t\t" + l.top());
        System.out.println("l.pop()\t\t" + l.pop());
        System.out.println("l.size()\t" + l.size());
        System.out.print("l.print()\t");
        l.print();
    }
}
