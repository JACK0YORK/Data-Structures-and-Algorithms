#include <iostream>
#include <stdexcept>

template <typename T>
class LeakyStack
{
    T **data;
    int length = 0, end = 0;
    int SIZE;

public:
    LeakyStack()
    {
        this->SIZE = 32;
        this->data = new T *[SIZE];
    }
    LeakyStack(size_t size)
    {
        this->SIZE = size;
        this->data = new T *[SIZE];
    }

    bool isEmpty()
    {
        return length == 0;
    }

    bool isFull()
    {
        return length == SIZE;
    }

    void push(T const &value)
    {
        if (!isFull())
            length++;
        data[end++ % SIZE] = new T{value};
        if (end > SIZE * 2)
            end -= SIZE; // overflow protection
    }

    T pop()
    {
        if (isEmpty())
            throw std::out_of_range("Cannot pop from empty LeakyStack.");
        length--;
        T out = *data[--end % SIZE];
        data[end % SIZE] = nullptr;
        return out;
    }

    T top()
    {
        if (isEmpty())
            throw std::out_of_range("Empty ArrayStack has no top.");
        return *data[(end - 1) % SIZE];
    }

    int size()
    {
        return length;
    }

    char print()
    {
        std::cout << *this << std::endl;
        return 0;
    }

    friend std::ostream &operator<<(std::ostream &o, LeakyStack const &l)
    {
        o << "[";
        for (int i = l.end - 1; i >= l.end - l.length; i--)
            o << (i == l.end - 1 ? " " : ", ") << *l.data[i % l.SIZE];
        return o << " ]";
    }
};

inline int l_main()
{
    LeakyStack<int> *l = new LeakyStack<int>(3);
    l->push(1);
    l->push(2);
    l->push(3);
    l->push(4);
    std::cout <<"l.print()\t"<< std::boolalpha;
    l->print();
    std::cout <<"l.isEmpty()\t"<< l->isEmpty() << std::endl;
    std::cout <<"l.isFull()\t"<< l->isFull() << std::endl;
    std::cout <<"l.top()\t\t"<< l->top() << std::endl;
    std::cout <<"l.pop()\t\t"<< l->pop() << std::endl;
    std::cout <<"l.size()\t"<< l->size() << std::endl;
    std::cout <<"l.print()\t"<< std::boolalpha;
    l->print();
    
    return 0;
}
