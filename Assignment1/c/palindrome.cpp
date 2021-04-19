#include <string>
#include <iostream>
#include "stack.h"

bool is_palindrome_stack(std::string input)
{
    Stack<char> stack1 = Stack<char>();
    for (char char_input : input)
        stack1.push(char_input); // simulates getting String one character at a time
    Stack<char> stack2 = Stack<char>();
    while (stack1.size() > stack2.size())
        stack2.push(stack1.pop());
    if (stack2.size() != stack1.size()) // odd case
        stack2.pop();
    while (!stack1.isEmpty() /* && !stack2.is_empty() */)
        if (stack1.pop() != stack2.pop())
            return false;
    return true;
}

int main(int argc, char const *argv[])
{
    std::cout << std::boolalpha;
    std::cout << (is_palindrome_stack("racecar")) << std::endl; // true
    std::cout << (is_palindrome_stack("x")) << std::endl;       // one character
    std::cout << (is_palindrome_stack("")) << std::endl;        // null case
    std::cout << (is_palindrome_stack("ohio")) << std::endl;    // false
    std::cout << (is_palindrome_stack("<>")) << std::endl;     // false
    return 0;
}
