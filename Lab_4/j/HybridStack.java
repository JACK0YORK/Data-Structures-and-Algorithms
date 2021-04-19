package Lab_4.j;

public class HybridStack<T> {
    private ArrayStack<T> a_stack;
    private LinkedListStack<T> ll_stack = new LinkedListStack<T>();

    public HybridStack(int expectedMaxSize) {
        a_stack = new ArrayStack<T>(expectedMaxSize);
    }

    public HybridStack() {
        a_stack = new ArrayStack<T>();
    }

    public boolean isEmpty() {
        return a_stack.isEmpty();
    }

    public void push(T value) {
        if (a_stack.isFull()) {
            ll_stack.push(value);
        } else {
            a_stack.push(value);
        }
    }

    public T pop() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Cannot pop from empty HybridStack.");

        if (ll_stack.isEmpty()) {
            return a_stack.pop();
        } else {
            return ll_stack.pop();
        }
    }

    public T top() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Empty HybridStack has no top.");

        if (ll_stack.isEmpty()) {
            return a_stack.top();
        } else {
            return ll_stack.top();
        }
    }

    public int size() {
        return a_stack.size() + ll_stack.size();
    }

    public char print() {
        System.out.print(toString());
        return 0;
    }

    public String toString() {
        String out = "[ ";
        if (!ll_stack.isEmpty()) {
            String ll_str = ll_stack.toString();
            out += ll_str.substring(2, ll_str.length() - 2) + ", ";
        }
        String a_str = a_stack.toString();
        out += a_str.substring(2, a_str.length() - 1);
        return out + "]";
    }

    // public static void main(String[] args) {
    //     HybridStack<Integer> stack = new HybridStack<>(3);
    //     stack.push(1);
    //     stack.push(2);
    //     System.out.println(stack.print());
    //     stack.push(3);
    //     stack.push(4);
    //     System.out.println(stack.print());
    //     stack.pop();
    //     stack.pop();
    //     stack.pop();
    //     stack.push(5);
    //     System.out.println(stack.print());
    //     stack.pop();
    //     stack.pop();
    //     System.out.println(stack.print());
    // }
}
