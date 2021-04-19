package Assignment1.j;
import java.util.Stack;

/**
 * BalancedParentheses
 */
public class BalancedParentheses {

    public static boolean balanced_parens(String input) {
        Stack<Boolean> stack = new Stack<>();
        stack.push(true);
        for (char c : input.toCharArray()) {
            switch (c) {
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
}