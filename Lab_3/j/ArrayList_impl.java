package Lab_3.j;

//  import java.util.ArrayList;

/**
 * ArrayList
 */
public class ArrayList_impl<T> {
    private int capacity = 5, length = 0;
    private Object[] data; // T

    public ArrayList_impl() {
        capacity = 5;
        data = new Object[capacity];
        length = 0;
    }

    private static void checkIndex(int index, int size) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index = " + index + ", Size = " + size);
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean contains(T value) {
        for (int i = 0; i < length; i++)
            if (data[i].equals(value))
                return true;
        return false;
    }

    public void clear() {
        for (int i = 0; i < length; i++) {
            data[i] = null;
        }
        length = 0;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index, length);
        return (T) data[index];
    }

    public void add(int index, T element) {
        int newLength = length + 1;
        checkIndex(index, newLength);
        ensureCapacity(newLength);
        System.arraycopy(data, index, data, index + 1, length - index);
        data[index] = element;
        length = newLength;
    }

    private void removeAt(int index) {
        if (--length > index)
            System.arraycopy(data, index + 1, data, index, length - index);
        data[length] = null;
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        checkIndex(index, length);
        T out = (T) data[index];
        removeAt(index);
        return out;
    }

    public void ensureCapacity(int minCapacity) {
        if (capacity < minCapacity) {
            int newCapacity = capacity * 2;
            Object[] temp = new Object[newCapacity];
            System.arraycopy(data, 0, temp, 0, capacity);
            capacity = newCapacity;
            data = temp;
        }
    }

    public static void main(String[] args) {
        ArrayList_impl<Integer> w = new ArrayList_impl<>();
        w.add(0, 5);
        w.add(0, 10);
        w.add(0, 15);
        w.add(0, 20);
        w.add(0, 25);
        w.add(0, 30);
        w.add(4, -1);
        w.add(4, -1);
        w.add(5, -2);
        w.add(5, -2);
        for (int i = 0; i < w.size(); i++) {
            System.out.println(i + " -> " + w.get(i));
        }
        System.out.println("Removed " + w.remove(4));
        System.out.println("Removed " + w.remove(5));
        System.out.println("Removed " + w.remove(5));
        System.out.println("Removed " + w.remove(4));
        for (int i = 0; i < w.size(); i++) {
            System.out.println(i + " -> " + w.get(i));
        }
        System.out.println(w.contains(5));
        System.out.println(w.contains(30));
        System.out.println(w.contains(-1));
        System.out.println("Empty? " + w.isEmpty());
        w.clear();
        System.out.println("Empty? " + w.isEmpty());
        for (int i = 0; i < w.size(); i++) {
            System.out.println(i + " -> " + w.get(i));
        }
        w.add(0, 5);
        w.add(1, 6);
        w.add(2, 7);
        for (int i = 0; i < w.size(); i++) {
            System.out.println(i + " -> " + w.get(i));
        }
        // System.out.println()
    }
}