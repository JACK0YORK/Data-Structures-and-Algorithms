package Assignment2.j;

public class Palindrome {
    public static boolean is_palindrome(String input) {
        Stack<Character> s = new Stack<>();
        Queue<Character> q = new Queue<>();
        for (char ch : input.toCharArray()) {
            s.push(ch);
            q.enqueue(ch);
        }
        while (!s.isEmpty() && !q.isEmpty())
            if (s.pop() != q.dequeue())
                return false;
        return true;
    }

    public static void p_main() {
        System.out.println("\"racecar\"\t" + is_palindrome("racecar"));
        System.out.println("\"x\"\t\t\t" + is_palindrome("x"));
        System.out.println("\"\"\t\t\t" + is_palindrome(""));
        System.out.println("\"sample\"\t" + is_palindrome("sample"));
        System.out.println("\"dab\"\t\t" + is_palindrome("dab"));
        System.out.println("\"<>\"\t\t" + is_palindrome("<>"));
    }
}
