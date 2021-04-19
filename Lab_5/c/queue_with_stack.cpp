#include "stack.h"

template <typename T>
class QueueWithStack
{
    my::Stack<T> *stack = new my::Stack<T>();
    my::Stack<T> *stack_r = new my::Stack<T>();

    template <typename E>
    static void ensure(my::Stack<E> *will_be_empty, my::Stack<E> *will_be_full)
    {
        if (will_be_full->isEmpty())
            while (!will_be_empty->isEmpty())
                will_be_full->push(will_be_empty->pop());
    }

public:
    void enqueue(T value)
    {
        ensure(stack_r, stack);
        stack->push(value);
    }

    T dequeue()
    {
        ensure(stack, stack_r);
        return stack_r->pop();
    }

    T peek()
    {
        ensure(stack, stack_r);
        return stack_r->top();
    }

    bool isEmpty()
    {
        return stack->isEmpty() && stack_r->isEmpty();
    }

    int size()
    {
        return stack->size() + stack_r->size();
    }

    char print()
    {
        ensure(stack, stack_r);
        stack_r->print();
        return 0;
    }
};