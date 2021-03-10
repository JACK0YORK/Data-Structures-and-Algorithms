#include <iostream>
#include <iterator>
template <typename T>
class d_linkedlist
{

public:
    struct d_node
    {
    public:
        T data;
        d_node *next = nullptr;
        d_node *prev = nullptr;

        d_node(T data) : data(data) {}
        ~d_node()
        {
            this->next = nullptr;
            this->next = nullptr;
        };
    };
    d_linkedlist();
    d_linkedlist(T *array, int length);
    ~d_linkedlist();
    bool is_empty();
    void append(T value);
    T pop();
    void push(T value);
    T unpush();
    d_linkedlist filter(bool function(T));
    int size();
    T get(int i);

    // Iter
    struct iterator
    {
        d_node *n;
        iterator(d_node *n) : n(n){};
        iterator &operator++()
        {
            n = n->next;
            return *this;
        }
        bool operator!=(const iterator &t) const { return n != t.n; }
        T &operator*() { return n->data; }
    };
    iterator begin() { return iterator(head); };
    iterator end() { return iterator(nullptr); };

    
private:
    d_node *head = nullptr;
    d_node *tail = nullptr;
    int length = 0;
};

template <typename T>
d_linkedlist<T>::d_linkedlist()
{
}

template <typename T>
d_linkedlist<T>::d_linkedlist(T *array, int length)
{
    for (size_t i = 0; i < length; i++)
    {
        append(array[i]);
    }
}

template <typename T>
d_linkedlist<T>::~d_linkedlist()
{
    d_node *temp = head;
    head = nullptr;
    tail = nullptr;
    while (temp->next != nullptr)
    {
        temp = temp->next;
        delete temp->prev;
        temp->prev = nullptr;
    }
    delete temp;
    temp = nullptr;
}

template <typename T>
bool d_linkedlist<T>::is_empty()
{
    return this->length <= 0;
}

template <typename T>
void d_linkedlist<T>::append(T value)
{
    d_node *elem = new d_node(value);
    if (this->head == nullptr)
        this->head = elem;
    else
        this->tail->next = elem;
    elem->prev = this->tail;
    this->tail = elem;
    this->length++;
}

template <typename T>
T d_linkedlist<T>::pop()
{
    if (this->length <= 0)
        throw std::logic_error("Nothing to pop.");

    T out = tail->data;
    d_node *prev = tail->prev;
    if (prev == nullptr)
        head == nullptr;
    else
        prev->next = nullptr;
    delete tail;
    tail = prev;
    this->length--;
    return out;
}

template <typename T>
void d_linkedlist<T>::push(T value)
{
    d_node *elem = new d_node(value);
    if (this->head == nullptr)
        this->tail = elem;
    else
        this->head->prev = elem;
    elem->next = this->head;
    this->head = elem;
    this->length++;
}

template <typename T>
T d_linkedlist<T>::unpush()
{
    if (this->length <= 0)
        throw std::logic_error("Nothing to unpush.");

    T out = head->data;
    d_node *next = head->next;
    if (next == nullptr)
        tail == nullptr;
    else
        next->prev = nullptr;
    delete head;
    head = next;
    this->length--;
    return out;
}

template <typename T>
d_linkedlist<T> d_linkedlist<T>::filter(bool function(T))
{
    d_linkedlist<T> out = d_linkedlist<T>();
    for (T elem : *this)
    {
        if (function(elem))
            out.append(elem);
    }
    return out;
}

template <typename T>
int d_linkedlist<T>::size()
{
    return this->length;
}

template <typename T>
T d_linkedlist<T>::get(int i)
{
    d_node* temp = head;
    for (int j = 0; j < i; j++)
    {
        temp=temp->next;
    }
    return temp->data;
}
