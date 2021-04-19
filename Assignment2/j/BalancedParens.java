package Assignment2.j;

public class BalancedParens {
    public static boolean are_balanced(String input) {
        Queue<Boolean> q = new Queue<>();
        for (char ch : input.toCharArray()) {
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

    public static void b_main() {
        System.out.println("()\t\t\t" + are_balanced("()"));
        System.out.println("(()())\t\t" + are_balanced("(()())"));
        System.out.println("((())())\t" + are_balanced("((())())"));
        System.out.println(")(\t\t\t" + are_balanced(")("));
        System.out.println("(()\t\t\t" + are_balanced("(()"));
        System.out.println("())(()))())\t" + are_balanced("())(()))())"));

    }
}
