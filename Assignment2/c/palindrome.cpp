#include <iostream>
#include <string>

#include "queue.h"
#include "stack.h"

inline bool is_palindrome_stack(std::string input) {
    Stack<char> s =  Stack<char>();
    Queue<char> q =  Queue<char>();
    for (char ch : input) {
        s.push(ch);
        q.enqueue(ch);
    }
    while (!s.isEmpty() && !q.isEmpty())
        if (s.pop() != q.dequeue())
            return false;
    return true;
}

inline int p_main() {
    std::cout << std::boolalpha;
    std::cout <<"\"racecar\"\t"<< (is_palindrome_stack("racecar")) << std::endl;  // true
    std::cout <<"\"x\"\t\t\t"<< (is_palindrome_stack("x")) << std::endl;        // one character
    std::cout <<"\"\"\t\t\t"<< (is_palindrome_stack("")) << std::endl;         // null case
    std::cout <<"\"sample\"\t"<< (is_palindrome_stack("sample")) << std::endl;     // false
    std::cout <<"\"dab\"\t\t"<< (is_palindrome_stack("dab")) << std::endl;       // false
    std::cout <<"\"<>\"\t\t"<< (is_palindrome_stack("<>")) << std::endl;       // false
    return 0;
}
