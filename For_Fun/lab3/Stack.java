package For_Fun.lab3;

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

    @SafeVarargs
    public Stack(T... arr) {
        this(arr.length > DEFAULT_SIZE / 2 ? (arr.length * 2) : DEFAULT_SIZE);
        for (T t : arr) {
            push(t);
        }
    }

    private void check_index(int desired_max_index) {
        if (desired_max_index < 0 || desired_max_index >= array.length)
            throw new IndexOutOfBoundsException("Length: " + array.length + ", Index: " + desired_max_index);
    }

    public void push(T value) {
        check_index(length);
        array[length++] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        check_index(--length);
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
            return "Stack<>()";
        String out = "Stack<>( " + array[length - 1].toString();
        for (int i = length - 2; i >= 0; i--) {
            out += ", " + array[i].toString();
        }
        return out + " )";
    }

}