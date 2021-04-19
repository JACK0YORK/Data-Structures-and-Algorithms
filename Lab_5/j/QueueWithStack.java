package Lab_5.j;

public class QueueWithStack<T> {
    private Stack<T> stack = new Stack<T>();
    private Stack<T> stack_r = new Stack<T>();

    private void ensure(Stack<T> will_be_empty, Stack<T> will_be_full) {
        if (will_be_full.isEmpty())
            while (!will_be_empty.isEmpty())
                will_be_full.push(will_be_empty.pop());
    }

    public void enqueue(T value) {
        ensure(stack_r, stack);
        stack.push(value);
    }

    public T dequeue() {
        ensure(stack, stack_r);
        return stack_r.pop();
    }

    public T peek() {
        ensure(stack, stack_r);
        return stack_r.top();
    }

    public boolean isEmpty() {
        return stack.isEmpty() && stack_r.isEmpty();
    }

    public int size() {
        return stack.size() + stack_r.size();
    }

    public char print() {
        System.out.print(toString());
        return 0;
    }

    public String toString() {
        ensure(stack, stack_r);
        return stack_r.toString();
    }
}