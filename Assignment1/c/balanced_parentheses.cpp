#include <string>
#include <iostream>
// #include <stack>
#include "stack.h"

bool balanced_parens(std::string input)
{
    // std::stack<bool> stack = std::stack<bool>();
    Stack<bool> stack = Stack<bool>();
    stack.push(true);

    for (char c : input)
    {
        switch (c)
        {
        case '(':
            stack.push(false);
            break;
        case ')':
            if (stack.pop())
                return false;
            break;
        default:
            break;
        }
    }

    return stack.pop();
}

int main(int argc, char const *argv[])
{
    std::string s1 = "()";
    std::string s2 = "(()())";
    std::string s3 = "((())())";
    std::string s4 = ")(";
    std::string s5 = "((()";
    std::string s6 = "())(()))())";
    std::cout << std::boolalpha;
    std::cout << (balanced_parens(s1)) << std::endl;
    std::cout << (balanced_parens(s2)) << std::endl;
    std::cout << (balanced_parens(s3)) << std::endl;
    std::cout << (balanced_parens(s4)) << std::endl;
    std::cout << (balanced_parens(s5)) << std::endl;
    std::cout << (balanced_parens(s6)) << std::endl;
    return 0;
}