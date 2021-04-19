#include <stdexcept>
#include <iostream>

template <typename T>
class HybridStack;

template <typename T>
class ArrayStack
{
    T *data;
    int length = 0, max_size = 32;

public:
    ArrayStack()
    {
        this->data = new T[max_size];
    }

    ArrayStack(int max_size)
    {
        this->max_size = max_size;
        this->data = new T[max_size];
    }

    bool isEmpty()
    {
        return length == 0;
    }

    bool isFull()
    {
        return length == max_size;
    }

    void push(T value)
    {
        if (isFull())
        {
            throw std::out_of_range("Cannot push to full ArrayStack.");
        }
        data[length++] = value;
    }

    T pop()
    {
        if (isEmpty())
        {
            throw std::out_of_range("Cannot pop from empty ArrayStack.");
        }
        T out = data[--length];
        // data[length] = NULL;
        return out;
    }

    T top()
    {
        if (isEmpty())
        {
            throw std::out_of_range("Empty ArrayStack has no top.");
        }
        return data[length - 1];
    }

    int size()
    {
        return length;
    }

    char print()
    {
        std::cout << "[";
        for (int i = length - 1; i >= 0; i--)
        {
            std::cout << (i == length - 1 ? " " : ", ") << data[i];
        }
        std::cout << " ]";
        return 0;
    }

    template <typename E>
    friend char HybridStack<E>::print();
};

template <typename T>
class LinkedListStack
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

    T pop()
    {
        if (isEmpty())
        {
            throw std::out_of_range("Cannot pop from empty LinkedListStack.");
        }
        T out = tail->data;
        tail = tail->prev;
        if (tail != nullptr)
            tail->next = nullptr;
        else
            head = nullptr;
        length--;
        return out;
    }

    void push(T value)
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

    T top()
    {
        if (isEmpty())
        {
            throw std::out_of_range("Empty LinkedListStack has no top.");
        }
        return tail->data;
    }

    int size()
    {
        return length;
    }

    char print()
    {
        std::cout << "[";
        for (Node *i = tail; i != nullptr; i = i->prev)
        {
            std::cout << (i == tail ? " " : ", ") << i->data;
        }
        std::cout << " ]";
        return 0;
    }
    template <typename E>
    friend char HybridStack<E>::print();
};

template <typename T>
class HybridStack
{
    ArrayStack<T> *a_stack;
    LinkedListStack<T> *ll_stack = new LinkedListStack<T>();

public:
    HybridStack(int expectedMaxSize)
    {
        a_stack = new ArrayStack<T>(expectedMaxSize);
    }

    HybridStack()
    {
        a_stack = new ArrayStack<T>();
    }

    bool isEmpty()
    {
        return a_stack->isEmpty();
    }

    void push(T value)
    {
        if (a_stack->isFull())
            ll_stack->push(value);
        else
            a_stack->push(value);
    }

    T pop()
    {
        if (isEmpty())
            throw std::out_of_range("Cannot pop from empty HybridStack.");

        if (ll_stack->isEmpty())
            return a_stack->pop();
        else
            return ll_stack->pop();
    }

    T top()
    {
        if (isEmpty())
            throw std::out_of_range("Empty HybridStack has no top.");

        if (ll_stack->isEmpty())
            return a_stack->top();
        else
            return ll_stack->top();
    }

    int size()
    {
        return a_stack->size() + ll_stack->size();
    }

    char print()
    {
        std::cout << "[";
        auto *x = ll_stack->tail;
        for (; x != nullptr; x = x->prev)
        {
            std::cout << (x == ll_stack->tail ? " " : ", ") << x->data;
        }
        for (int i = a_stack->length - 1; i >= 0; i--)
        {
            std::cout << ((i == a_stack->length - 1) && (x == ll_stack->tail) ? " " : ", ") << a_stack->data[i];
        }
        std::cout << " ]";
        return 0;
    }
};

// int main(int argc, char const *argv[])
// {
//     HybridStack<int> as = HybridStack<int>(3);
//     as.push(1);
//     as.push(2);
//     std::cout << as.print() << std::endl;
//     as.push(3);
//     as.push(4);
//     std::cout << as.print() << std::endl;
//     as.pop();
//     as.pop();
//     as.pop();
//     as.push(5);
//     std::cout << as.print() << std::endl;
//     as.pop();
//     as.pop();
//     std::cout << as.print() << std::endl;

//     return 0;
// }