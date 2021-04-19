package Assignment1.j;
import java.util.Stack;

public class PostfixNotation {
    public static Double postfix_calculate(String input) {
        Stack<Double> stack = new Stack<Double>();
        String[] items = input.split("\\s+");
        for (String item : items) {
            Double num2 = null, num1 = null, value = null;
            try {
                switch (item) {
                case "+":
                    num2 = stack.pop();
                    num1 = stack.pop();
                    value = (num1 + num2);
                    break;
                case "-":
                    num2 = stack.pop();
                    num1 = stack.pop();
                    value = (num1 - num2);
                    break;
                case "*":
                    num2 = stack.pop();
                    num1 = stack.pop();
                    value = (num1 * num2);
                    break;
                case "/":
                    num2 = stack.pop();
                    num1 = stack.pop();
                    value = (num1 / num2);
                    break;
                default:
                    value = Double.parseDouble(item);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid string, \"" + item + "\" is not a valid number or operator. The calculation \"" + input
                                + "\" cannot be performed.");
                return null;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid string, incorrect number of operators. The calculation \"" + input
                        + "\" cannot be performed.");
                return null;
            }
            stack.push(value);
        }
        if (stack.size() != 1) {
            System.out.println("Invalid string, incorrect number of operators. The calculation \"" + input
                    + "\" cannot be performed.");
            return null;
        }
        return stack.pop();
    }
}
