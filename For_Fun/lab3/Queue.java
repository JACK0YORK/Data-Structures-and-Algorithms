package For_Fun.lab3;

public class Queue<T> {
    public static final int DEFAULT_SIZE = 128;

    Object[] array;
    int begin, end;

    public Queue(int max_size) {

        array = new Object[max_size];
        begin = 0;
        end = 0;
    }

    public Queue() {
        this(DEFAULT_SIZE);
    }

    @SafeVarargs
    public Queue(T... arr) {
        this(arr.length > DEFAULT_SIZE / 2 ? (arr.length * 2) : DEFAULT_SIZE);
        for (T t : arr) {
            enqueue(t);
        }
    }

    private void check_index(int desired_max_index) {
        if (desired_max_index < 0 || desired_max_index >= array.length)
            throw new IndexOutOfBoundsException("Length: " + array.length + ", Index: " + desired_max_index);
    }

    private void reallign() {
        if (end == array.length) {
            for (int i = begin; i < array.length; i++) {
                array[i - begin] = array[i];
                array[i] = null;
            }
            end -= begin;
            begin = 0;
        }
    }

    public void enqueue(T value) {
        check_index(size());
        reallign();
        array[end++] = value;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        check_index(size() - 1);
        T temp = (T) array[begin];
        array[begin++] = null;
        return temp;
    }

    public int size() {
        return end - begin;
    }

    public boolean is_empty() {
        return end - begin == 0;
    }

    @SuppressWarnings("unchecked")
    public T front() {
        return (T) array[begin];
    }

    public String toString() {
        if (is_empty())
            return "Queue<>()";
        String out = "Queue<>( " + array[begin].toString();
        for (int i = begin + 1; i < end; i++) {
            out += ", " + array[i].toString();
        }
        return out + " )";
    }

}
