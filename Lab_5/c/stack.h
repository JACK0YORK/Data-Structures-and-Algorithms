#ifndef MY_STACK
#define MY_STACK

#include <iostream>

template <typename T>
class Stack {
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

    T pop() {
        if (isEmpty()) {
            throw std::out_of_range("Cannot pop from empty Stack.");
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

    void push(T value) {
        if (isEmpty()) {
            head = new Node(nullptr, value, nullptr);
            tail = head;
        } else {
            tail->next = new Node(tail, value, nullptr);
            tail = tail->next;
        }
        length++;
    }

    T top() {
        if (isEmpty()) {
            throw std::out_of_range("Empty Stack has no top.");
        }
        return tail->data;
    }

    int size() {
        return length;
    }

    char print() {
        std::cout << *this;
        return 0;
    }

    friend std::ostream &operator<<(std::ostream &o, Stack<T> const &stack) {
        o << "[";
        for (Node *i = stack.tail; i != nullptr; i = i->prev) {
            o << (i == stack.tail ? " " : ", ") << i->data;
        }
        o << " ]";
        return o;
    }
};

#endif  // !MY_STACK