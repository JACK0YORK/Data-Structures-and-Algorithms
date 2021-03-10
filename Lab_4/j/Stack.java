package Lab_4.j;

/**
 * Stack
 */
public class Stack<T> {
    public static final int DEFAULT_SIZE = 128;
    private Object array[];
    private int length;

    public Stack(int max_size) {
        array = new Object[max_size];
        length = 0;
    }

    public Stack() {
        this(DEFAULT_SIZE);
    }

    private void check_size(int desired_max_index) {
        if (desired_max_index < 0 || desired_max_index >= array.length)
            throw new IndexOutOfBoundsException("Length: " + array.length + ", Index: " + desired_max_index);
    }

    public void push(T value) {
        check_size(length);
        array[length++] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        check_size(--length);
        T temp = (T) array[length];
        array[length] = null;
        return temp;
    }

    public int size() {
        return length;
    }

    public boolean is_empty() {
        return length == 0;
    }

    @SuppressWarnings("unchecked")
    public T top() {
        return (T) array[length - 1];
    }

    public String toString() {
        if (is_empty())
            return "[ ]";
        String out = "[ " + array[0].toString();
        for (int i = 1; i < length; i++) {
            out += ", " + array[i].toString();
        }
        return out + " ]";
    }

}