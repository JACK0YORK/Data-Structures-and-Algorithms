#ifndef MY_QUEUE
#define MY_QUEUE

#include <iostream>

template <typename T>
class Queue {
    class Node {
       public:
        Node *prev, *next;
        T data;

        Node(Node *prev, T data, Node *next) {
            this->prev = prev;
            this->next = next;
            this->data = data;
        }
    };

    Node *head = nullptr, *tail = nullptr;
    int length = 0;

   public:
    bool isEmpty() {
        return head == nullptr;
    }

    T dequeue() {
        if (isEmpty()) {
            throw std::out_of_range("Cannot dequeue from empty Queue.");
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

    void enqueue(T value) {
        if (isEmpty()) {
            head = new Node(nullptr, value, nullptr);
            tail = head;
        } else {
            tail->next = new Node(tail, value, nullptr);
            tail = tail->next;
        }
        length++;
    }

    T peek() {
        if (isEmpty())
            throw std::out_of_range("Empty Queue has no elements to peek.");

        return head->data;
    }

    int size() {
        return length;
    }

    char print() {
        std::cout << *this;
        return 0;
    }

    friend std::ostream &operator<<(std::ostream &o, Queue<T> const &queue) {
        o << "[";
        for (auto *i = queue.head; i != nullptr; i = i->next) {
            o << (i == queue.head ? " " : ", ") << i->data;
        }
        o << " ]";
        return o;
    }
};

#endif  // !MY_QUEUE