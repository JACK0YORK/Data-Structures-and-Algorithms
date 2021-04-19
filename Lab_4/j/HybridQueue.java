package Lab_4.j;

public class HybridQueue<T> {
    private ArrayQueue<T> a_queue;
    private LinkedListQueue<T> ll_queue = new LinkedListQueue<T>();

    public HybridQueue(int expectedMaxSize) {
        a_queue = new ArrayQueue<T>(expectedMaxSize);
    }

    public HybridQueue() {
        a_queue = new ArrayQueue<T>();
    }

    public boolean isEmpty() {
        return a_queue.isEmpty();
    }

    public void enqueue(T value) {
        if (a_queue.isFull())
            ll_queue.enqueue(value);
        else
            a_queue.enqueue(value);
    }

    public T dequeue() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Cannot dequeue from empty HybridQueue.");
        T out = a_queue.dequeue();
        if (!ll_queue.isEmpty())
            a_queue.enqueue(ll_queue.dequeue());
        return out;
    }

    public T peek() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Empty HybridQueue has no elements to peek.");
        return a_queue.peek();
    }

    public int size() {
        return a_queue.size() + ll_queue.size();
    }

    public char print() {
        System.out.print(toString());
        return 0;
    }

    public String toString() {
        String out = "[";
        String a_str = a_queue.toString();
        out += a_str.substring(1, a_str.length() - 2);
        if (!ll_queue.isEmpty()) {
            String ll_str = ll_queue.toString();
            out +=", "+ ll_str.substring(2, ll_str.length() - 2) ;
        }
        return out + " ]";
    }

    // public static void main(String[] args) {
    //     HybridQueue<Integer> queue = new HybridQueue<>(3);
    //     queue.enqueue(1);
    //     queue.enqueue(2);
    //     System.out.println(queue.print());
    //     queue.enqueue(3);
    //     queue.enqueue(4);
    //     System.out.println(queue.print());
    //     queue.dequeue();
    //     queue.dequeue();
    //     queue.dequeue();
    //     queue.enqueue(5);
    //     System.out.println(queue.print());
    //     queue.dequeue();
    //     queue.dequeue();
    //     System.out.println(queue.print());
    // }
}
