#include <stdexcept>
#include <iostream>

template <typename T>
class HybridQueue;

template <typename T>
class ArrayQueue
{
private:
    T *data;
    int start = 0, end = 0, max_size = 32;

public:
    ArrayQueue()
    {
        data = new T[max_size];
    }

    ArrayQueue(int max_size)
    {
        this->max_size = max_size;
        data = new T[max_size];
    }

    bool isEmpty()
    {
        return start == end;
    }

    bool isFull()
    {
        return end - start == max_size;
    }

    void enqueue(T value)
    {
        if (isFull())
        {
            throw std::out_of_range("Cannot enqueue to full ArrayQueue.");
        }
        data[end++ % max_size] = value;
    }

    T dequeue()
    {
        if (isEmpty())
        {
            throw std::out_of_range("Cannot dequeue from empty ArrayQueue.");
        }
        T out = data[start++];
        // data[start++] = NULL;

        if (start >= max_size)
        {
            start -= max_size;
            end -= max_size;
        }
        return out;
    }

    T peek()
    {
        if (isEmpty())
            throw std::out_of_range("Empty ArrayQueue has no elements to peek.");

        return data[start];
    }

    int size()
    {
        return end - start;
    }

    char print()
    {
        std::cout << "[";
        for (int i = start; i < end; i++)
        {
            std::cout << (i == start ? " " : ", ") << data[i % max_size];
        }
        std::cout << " ]";
        return 0;
    }

    template <typename E>
    friend char HybridQueue<E>::print();
};

template <typename T>
class LinkedListQueue
{
    class Node
    {
    public:
        Node *prev, *next;
        T data;

        Node(Node *prev, T data, Node *next)
        {
            this->prev = prev;
            this->next = next;
            this->data = data;
        }
    };

    Node *head = nullptr, *tail = nullptr;
    int length = 0;

public:
    bool isEmpty()
    {
        return head == nullptr;
    }

    T dequeue()
    {
        if (isEmpty())
        {
            throw std::out_of_range("Cannot dequeue from empty LinkedListQueue.");
        }
        T out = head->data;
        head = head->next;
        if (head != nullptr)
            head->prev = nullptr;
        else
            tail = nullptr;
        length--;
        return out;
    }

    void enqueue(T value)
    {
        if (isEmpty())
        {
            head = new Node(nullptr, value, nullptr);
            tail = head;
        }
        else
        {
            tail->next = new Node(tail, value, nullptr);
            tail = tail->next;
        }
        length++;
    }

    T peek()
    {
        if (isEmpty())
            throw std::out_of_range("Empty LinkedListQueue has no elements to peek.");

        return head->data;
    }

    int size()
    {
        return length;
    }

    char print()
    {
        std::cout << "[";
        for (auto *i = head; i != nullptr; i = i->next)
        {
            std::cout << (i == head ? " " : ", ") << i->data;
        }
        std::cout << " ]";
        return 0;
    }

    template <typename E>
    friend char HybridQueue<E>::print();
};

template <typename T>
class HybridQueue
{
    ArrayQueue<T> *a_queue;
    LinkedListQueue<T> *ll_queue = new LinkedListQueue<T>();

public:
    HybridQueue(int expectedMaxSize)
    {
        a_queue = new ArrayQueue<T>(expectedMaxSize);
    }

    HybridQueue()
    {
        a_queue = new ArrayQueue<T>();
    }

    bool isEmpty()
    {
        return a_queue->isEmpty();
    }
    void enqueue(T value)
    {
        if (a_queue->isFull())
            ll_queue->enqueue(value);
        else
            a_queue->enqueue(value);
    }

    T dequeue()
    {
        T out = a_queue->dequeue();
        if (!ll_queue->isEmpty())
            a_queue->enqueue(ll_queue->dequeue());
        return out;
    }

    T peek()
    {
        if (isEmpty())
            throw std::out_of_range("Empty HybridQueue has no elements to peek.");

        return a_queue->peek();
    }

    int size()
    {
        return a_queue->size() + ll_queue->size();
    }

    char print()
    {
        std::cout << "[";
        for (int i = a_queue->start; i < a_queue->end; i++)
        {
            std::cout << (i == a_queue->start ? " " : ", ") << a_queue->data[i % a_queue->max_size];
        }
        for (auto *i = ll_queue->head; i != nullptr; i = i->next)
        {
            std::cout << ", " << i->data;
        }
        std::cout << " ]";
        return 0;
    }
};

// int main(int argc, char const *argv[])
// {
//     HybridQueue<int> hq = HybridQueue<int>(3);
//     hq.enqueue(1);
//     hq.enqueue(2);
//     std::cout << hq.print() << std::endl;
//     hq.enqueue(3);
//     hq.enqueue(4);
//     std::cout << hq.print() << std::endl;
//     hq.dequeue();
//     hq.dequeue();
//     hq.dequeue();
//     hq.enqueue(5);
//     std::cout << hq.print() << std::endl;
//     hq.dequeue();
//     hq.dequeue();
//     std::cout << hq.print() << std::endl;
//     return 0;
// }
