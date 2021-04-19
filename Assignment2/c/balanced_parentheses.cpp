#include <iostream>
#include <string>
// #include <stack>
#include "queue.h"

inline bool balanced_parens(std::string input) {
    Queue<char> q = Queue<char>();
    for (char ch : input) {
        switch (ch) {
        case '(':
            q.enqueue(true);
            break;
        case ')':
            if (q.isEmpty())
                return false; // too many ")"s.
            q.dequeue();
            break;
        default:
            break;
        }
    }
    return q.isEmpty(); // too many "("s.
}

inline int b_main() {
    std::string s1 = "()";
    std::string s2 = "(()())";
    std::string s3 = "((())())";
    std::string s4 = ")(";
    std::string s5 = "(()";
    std::string s6 = "())(()))())";
    std::cout << std::boolalpha;
    std::cout <<"()\t\t\t"     << (balanced_parens(s1)) << std::endl;
    std::cout <<"(()())\t\t"   << (balanced_parens(s2)) << std::endl;
    std::cout <<"((())())\t"   << (balanced_parens(s3)) << std::endl;
    std::cout <<")(\t\t\t"     << (balanced_parens(s4)) << std::endl;
    std::cout <<"(()\t\t\t"    << (balanced_parens(s5)) << std::endl;
    std::cout <<"())(()))())\t"<< (balanced_parens(s6)) << std::endl;
    return 0;
}