#include <iostream>
#include "leaky_stack.cpp"
#include "balanced_parentheses.cpp"
#include "palindrome.cpp"

int main() {
  std::cout << "Leaky Stack Main:\n";
  l_main();
  std::cout << "Balanced Parens Main:\n";
  b_main();
  std::cout << "Palindrome Main:\n";
  p_main();
}