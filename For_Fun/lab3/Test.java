package For_Fun.lab3;


public class Test {
    public static void main(String[] args) {
        // Scanner s = new Scanner(System.in);
        // System.out.println("Enter the possible palindrome: ");
        // String possible_palindrome = s.nextLine();
        // System.out.println("\"" + possible_palindrome + "\" is " + (palindrome(possible_palindrome) ? "" : "not ")
        //         + "a palindrome");
        // s.close();
        boolean b1 = false;
    //  if (condition) expression; else expression;
        if (b1) System.out.println("true"); else System.out.println("false");
    //    
    }

    public static boolean palindrome(String str) {
        str = str.toUpperCase();
        int i = 0, j = str.length() - 1;
        while (i < j) {
            while (str.charAt(i) < 'A' || str.charAt(i) > 'Z')
                i++;
            while (str.charAt(j) < 'A' || str.charAt(j) > 'Z')
                j--;
            if (i < j && str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
