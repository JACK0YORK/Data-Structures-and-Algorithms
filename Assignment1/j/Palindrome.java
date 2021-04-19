package Assignment1.j;
import java.util.Stack;

public class Palindrome {


    /**
     * Uses 2 stacks, and 0 char variables, and 0 int variables
     * 
     * Takes input, 1 character at a time, and determines if the given input is a
     * palindrome - that is, whether it reads the same forwards and backwards.
     * 
     * @param input
     * @return true if and only if input is a palindrome.
     */
    public static boolean is_palindrome_stack(String input) {
        // Stack<Character> stack1 = new Stack<>();
        // stack1.push(null);
        // while (stack1.top() == null || stack1.top() > 32) {
        // try {
        // stack1.push((char) System.in.read()); // * stack1.push(char_input);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        // }
        // stack1.pop();
        Stack<Character> stack1 = new Stack<>();
        for (char char_input : input.toCharArray())
            stack1.push(char_input); // simulates getting String one character at a time, see comment above for
                                     // sample implementation
        Stack<Character> stack2 = new Stack<>();
        while (stack1.size() > stack2.size())
            stack2.push(stack1.pop());
        if (stack2.size() != stack1.size()) // odd case
            stack2.pop();
        while (!stack1.isEmpty()/* && !stack2.is_empty() */)
            if (stack1.pop() != stack2.pop())
                return false;
        return true;
    }
}
