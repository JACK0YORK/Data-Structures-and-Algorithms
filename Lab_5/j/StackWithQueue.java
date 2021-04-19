package Lab_5.j;

public class StackWithQueue<T> {
    private Queue<T> queue1 = new Queue<T>();
    private Queue<T> queue2 = new Queue<T>();

    public void push(T value) {
        queue2.enqueue(value);

        while (!queue1.isEmpty()) {
            queue2.enqueue(queue1.dequeue());
        }

        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public T pop() {
        return queue1.dequeue();
    }

    public T top() {
        return queue1.peek();
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public int size() {
        return queue1.size();
    }

    public char print() {
        System.out.print(toString());
        return 0;
    }

    public String toString() {
        return queue1.toString();
    }
}
