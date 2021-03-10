package Lab_1.j;
import java.util.Scanner;

/**
 * Showcase of modulus, conditionals, and function calls through a simple
 * function to determine whether a given year is a leap year.
 * 
 * @author Jack York
 * @since 1/11/2021
 */
public class LeapYear {

    public static boolean is_leap_year(int year) {
        if (year % 400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        if (year % 4 == 0)
            return true;
        return false;
    }

    /**
     * Helper function that prompts the user with the specified message until an
     * integer is received.
     * 
     * @return received integer
     */
    public static int prompt_int(Scanner s, String message) {
        System.out.println(message);
        while (!s.hasNextInt()) {
            s.next();
            System.out.println(message);
            s.hasNext();
        }

        int output = s.nextInt();
        return output;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int year = prompt_int(s, "Enter a year to test");
        System.out.println(is_leap_year(year));
        s.close();
    }
}