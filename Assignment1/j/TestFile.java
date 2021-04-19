package Assignment1.j;

public class TestFile {
    public static void pfnot() {
        System.out.println(PostfixNotation.postfix_calculate("5 2 + 8 3 - * 4 /")+"\t\"5 2 + 8 3 - * 4 /\"");
        System.out.println((((5. + 2) * (8 - 3)) / 4)+"\t((5. + 2) * (8 - 3)) / 4");
    }

	public static void bparens(){
		String s1 = "()";
        String s2 = "(()())";
        String s3 = "((())())";
        String s4 = ")(";
        String s5 = "((()";
        String s6 = "())(()))())";
        System.out.println(BalancedParentheses.balanced_parens(s1)+"\t\""+s1+"\"");
        System.out.println(BalancedParentheses.balanced_parens(s2)+"\t\""+s2+"\"");
        System.out.println(BalancedParentheses.balanced_parens(s3)+"\t\""+s3+"\"");
        System.out.println(BalancedParentheses.balanced_parens(s4)+"\t\""+s4+"\"");
        System.out.println(BalancedParentheses.balanced_parens(s5)+"\t\""+s5+"\"");
        System.out.println(BalancedParentheses.balanced_parens(s6)+"\t\""+s6+"\"");
	}

	public static void pdrome() {
        System.out.println(Palindrome.is_palindrome_stack("racecar")+"\t\"racecar\""); // true
        System.out.println(Palindrome.is_palindrome_stack("x")+"\t\"x\""); // one character
        System.out.println(Palindrome.is_palindrome_stack("")+"\t\"\""); // null case
        System.out.println(Palindrome.is_palindrome_stack("ohio")+"\t\"ohio\""); // false
        System.out.println(Palindrome.is_palindrome_stack("<>")+"\t\"<>\""); // false
    }

    public static void main(String[] args) {
		System.out.println("Postfix Notation:");
		pfnot();
		System.out.println("Balanced Parens:");
		bparens();
		System.out.println("Palindrome:");
		pdrome();
    }
}
