#include "queue.h"

template <typename T>
class StackWithQueue
{
    my::Queue<T> *queue1 = new my::Queue<T>();
    my::Queue<T> *queue2 = new my::Queue<T>();

public:
    void push(T value)
    {
        queue2->enqueue(value);

        while (!queue1->isEmpty())
        {
            queue2->enqueue(queue1->dequeue());
        }

        auto temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    T pop()
    {
        return queue1->dequeue();
    }

    T top()
    {
        return queue1->peek();
    }

    bool isEmpty()
    {
        return queue1->isEmpty();
    }

    int size()
    {
        return queue1->size();
    }

    char print()
    {
        queue1->print();
        return 0;
    }
};
