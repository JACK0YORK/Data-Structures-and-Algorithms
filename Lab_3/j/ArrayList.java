package Lab_3.j;
/**
 * @brief An implementation of ArrayList that uses a series of LinkedList-style
 *        Nodes where each node contains an array. In every node of the linked
 *        list the size of the array it contains must be at least double the
 *        size of the previous node’s array.
 * 
 * @note dynamic arraylist that can accept any public datatype can be created by
 *       setting the template parameter to Object
 * 
 *       <pre>
 *       {@code ArrayList<Object> o = new ArrayList<>();}
 *       </pre>
 * 
 *       The only limitation of this in java is that primitives (int,boolean)
 *       will be converted to their Object versions (Integer,Boolean).
 */
public class ArrayList<E> {
    private static final int DEFAULT_CAPACITY = 5;

    private class Node {
        Object[] data; // T[]
        Node previous, next;
        int capacity;

        public Node(int capacity, Node previous, Node next) {
            this.capacity = capacity;
            data = new Object[capacity]; // T[]
            this.previous = previous;
            this.next = next;
        }
    }

    int capacity, length;
    Node head, tail;

    public ArrayList() {
        capacity = DEFAULT_CAPACITY;
        length = 0;
        head = new Node(capacity, null, null);
        tail = head;
    }

    /**
     * 
     * @param index
     * @param size
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   {@code (index < 0 ||
     *                                   index >= size())}
     */
    private static void checkIndex(int index, int size) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index = " + index + ", Size = " + size);
    }

    /**
     * add(int index, E e)
     * 
     * @brief Inserts the specified element at the specified position in this list.
     *        Shifts the element currently at that position (if any) and any
     *        subsequent elements to the right (adds one to their indices).
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   {@code (index < 0 ||
     *                                   index > size())}
     */
    public void add(int index, E element) {
        checkIndex(index, ++length);
        ensureCapacity(length);
        Node temp = head;
        int last_index = length - 1;
        while (temp.capacity <= index) {
            last_index -= temp.capacity;
            index -= temp.capacity;
            temp = temp.next;
        }
        Object last = temp.data[temp.capacity - 1];
        if (temp.capacity > index)
            System.arraycopy(temp.data, index, temp.data, index + 1, temp.capacity - index - 1);
        temp.data[index] = element;
        while (temp.capacity <= last_index) {
            last_index -= temp.capacity;
            temp = temp.next;
            Object temp_last = temp.data[temp.capacity - 1];
            System.arraycopy(temp.data, 0, temp.data, 1, temp.capacity - 1);
            temp.data[0] = last;
            last = temp_last;
        }
    }

    /**
     * clear()
     * 
     * @brief Removes all of the elements from this list. The list will be empty
     *        after this call returns.
     */
    public void clear() {
        Node temp = head;
        while (temp.capacity <= length) {
            for (int i = 0; i < temp.capacity; i++)
                temp.data[i] = null;
            length -= temp.capacity;
            temp = temp.next;
        }
        length = 0;
    }

    /**
     * contains(E e)
     * 
     * @brief Returns {@code true} if this list contains the specified element. More
     *        formally, returns {@code true} if and only if this list contains at
     *        least one element {@code e} such that {@code Objects.equals(o, e)}.
     *
     * @param e element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     */
    public boolean contains(E e) {
        int last_index = length - 1;
        Node temp = head;
        while (temp.capacity <= last_index) {
            for (int i = 0; i < temp.capacity; i++) {
                if (temp.data[i].equals(e))
                    return true;
            }
            last_index -= temp.capacity;
            temp = temp.next;
        }
        for (int i = 0; i <= last_index; i++) {
            if (temp.data[i].equals(e))
                return true;
        }
        return false;
    }

    /**
     * ensureCapacity(int minCapacity)
     * 
     * @brief Increases the capacity to ensure that it can hold at least the number
     *        of elements specified by the minimum capacity argument.
     *
     * @param minCapacity the desired minimum capacity
     */
    private void ensureCapacity(int minCapacity) {
        if (capacity < minCapacity) {
            Node newNode = new Node(tail.capacity * 2, tail, null);
            tail = newNode;
            tail.previous.next = newNode;
            capacity += newNode.capacity;
        }
    }

    /**
     * isEmpty()
     * 
     * @brief Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * get(int index)
     * 
     * @brief Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   {@code (index < 0 ||
     *                                   index >= size())}
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkIndex(index, length);
        Node temp = head;
        while (temp.capacity <= index) {
            index -= temp.capacity;
            temp = temp.next;
        }
        return (E) temp.data[index];
    }

    /**
     * Private remove method that skips bounds checking and does not return the
     * value removed.
     */
    private void removeAt(Node temp, int index, int last_index) {
        if (temp.capacity > index)
            System.arraycopy(temp.data, index + 1, temp.data, index, temp.capacity - index - 1);
        while (temp.capacity <= last_index) {
            last_index -= temp.capacity;
            temp.data[temp.capacity - 1] = temp.next.data[0];
            temp = temp.next;
            System.arraycopy(temp.data, 1, temp.data, 0, temp.capacity - 1);
        }
        temp.data[last_index] = null;
        length--;
    }

    /**
     * remove(int index)
     * 
     * @brief Removes the element at the specified position in this list. Shifts any
     *        subsequent elements to the left (subtracts one from their indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   {@code (index < 0 ||
     *                                   index >= size())}
     */
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        checkIndex(index, length);
        Node temp = head;
        int last_index = length - 1;
        while (temp.capacity <= index) {
            last_index -= temp.capacity;
            index -= temp.capacity;
            temp = temp.next;
        }
        E out = (E) temp.data[index];
        removeAt(temp, index, last_index);
        return out;
    }

    /**
     * size()
     * 
     * @brief Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return length;
    }

}
