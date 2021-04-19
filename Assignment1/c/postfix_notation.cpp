#include <iostream>
#include <string>

#include "stack.h"

double postfix_calculate(std::string input) {
    Stack<double> *stack = new Stack<double>();
    std::string item = "";
    int i = 0, j = 0;
    while (i != -1) {
        double value = 0, num1 = 0, num2 = 0;
        try {
            item = input.substr(i, j - i);
            switch (item[0]) {
                case 0:
                    i = input.find_first_not_of(" ", j);
                    j = input.find_first_of(" ", i);
                    continue;
                    break;  // for clarity
                case '+':
                    num2 = stack->pop();
                    num1 = stack->pop();
                    value = (num1 + num2);
                    break;
                case '-':
                    num2 = stack->pop();
                    num1 = stack->pop();
                    value = (num1 - num2);
                    break;
                case '*':
                    num2 = stack->pop();
                    num1 = stack->pop();
                    value = (num1 * num2);
                    break;
                case '/':
                    num2 = stack->pop();
                    num1 = stack->pop();
                    value = (num1 / num2);
                    break;
                default:
                    value = std::stod(item);
                    break;
            }
            i = input.find_first_not_of(" ", j);
            j = input.find_first_of(" ", i);
        } catch (std::invalid_argument e) {
            throw std::invalid_argument("Invalid string, \"" + item + "\" is not a valid number or operator. The calculation \"" + input + "\" cannot be performed.");
        } catch (std::out_of_range e) {
            throw std::invalid_argument("Invalid string, incorrect number of operators. The calculation \"" + input + "\" cannot be performed.");
        }
        stack->push(value);
    }
    if (stack->size() != 1) {
        throw std::invalid_argument("Invalid string, incorrect number of operators. The calculation \"" + input + "\" cannot be performed.");
    }
    return stack->pop();
}

int main(int argc, char const *argv[]) {
    std::cout << postfix_calculate(" 5 2 + 8 3 - * 4 / ") << std::endl;
    std::cout << ((5. + 2) * (8 - 3)) / 4 << std::endl;
    return 0;
}
