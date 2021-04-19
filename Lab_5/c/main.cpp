#include <iostream>
#include "stack_with_queue.cpp"
#include "queue_with_stack.cpp"

int main()
{
    char x;

    std::cout << std::boolalpha << ("\nStackWithQueue: ") << std::endl;
    StackWithQueue<char> stack;
    x = 'a';
    std::cout << "\tstack.push(" << x << ");" << std::endl;
    stack.push(x++);
    std::cout << "\tstack.push(" << x << ");" << std::endl;
    stack.push(x++);
    std::cout << "\tstack.push(" << x << ");" << std::endl;
    stack.push(x++);
    std::cout << "\tstack.print();\t\t" << stack.print() << std::endl;
    std::cout << "\tstack.size();\t\t" << stack.size() << std::endl;
    std::cout << "\tstack.isEmpty();\t" << stack.isEmpty() << std::endl;
    std::cout << "\tstack.pop();\t\t" << stack.pop() << std::endl;
    std::cout << "\tstack.pop();\t\t" << stack.pop() << std::endl;
    std::cout << "\tstack.push(" << x << ");" << std::endl;
    stack.push(x++);
    std::cout << "\tstack.push(" << x << ");" << std::endl;
    stack.push(x++);
    std::cout << "\tstack.top();\t\t" << stack.top() << std::endl;
    std::cout << "\tstack.pop();\t\t" << stack.pop() << std::endl;
    std::cout << "\tstack.pop();\t\t" << stack.pop() << std::endl;
    std::cout << "\tstack.pop();\t\t" << stack.pop() << std::endl;
    std::cout << "\tstack.print();\t\t" << stack.print() << std::endl;
    std::cout << "\tstack.size();\t\t" << stack.size() << std::endl;
    std::cout << "\tstack.isEmpty();\t" << stack.isEmpty() << std::endl;

    std::cout << ("\nQueueWithStack: ") << std::endl;
    QueueWithStack<char> queue;
    x = 'a';
    std::cout << "\tqueue.enqueue(" << x << ");" << std::endl;
    queue.enqueue(x++);
    std::cout << "\tqueue.enqueue(" << x << ");" << std::endl;
    queue.enqueue(x++);
    std::cout << "\tqueue.enqueue(" << x << ");" << std::endl;
    queue.enqueue(x++);
    std::cout << "\tqueue.print();\t\t" << queue.print() << std::endl;
    std::cout << "\tqueue.size();\t\t" << queue.size() << std::endl;
    std::cout << "\tqueue.isEmpty();\t" << queue.isEmpty() << std::endl;
    std::cout << "\tqueue.dequeue();\t" << queue.dequeue() << std::endl;
    std::cout << "\tqueue.dequeue();\t" << queue.dequeue() << std::endl;
    std::cout << "\tqueue.enqueue(" << x << ");" << std::endl;
    queue.enqueue(x++);
    std::cout << "\tqueue.enqueue(" << x << ");" << std::endl;
    queue.enqueue(x++);
    std::cout << "\tqueue.peek();\t\t" << queue.peek() << std::endl;
    std::cout << "\tqueue.dequeue();\t" << queue.dequeue() << std::endl;
    std::cout << "\tqueue.dequeue();\t" << queue.dequeue() << std::endl;
    std::cout << "\tqueue.dequeue();\t" << queue.dequeue() << std::endl;
    std::cout << "\tqueue.print();\t\t" << queue.print() << std::endl;
    std::cout << "\tqueue.size();\t\t" << queue.size() << std::endl;
    std::cout << "\tqueue.isEmpty();\t" << queue.isEmpty() << std::endl;
}