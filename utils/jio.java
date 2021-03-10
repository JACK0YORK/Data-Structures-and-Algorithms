package utils;

import java.util.Scanner;

/**
 * Helper functions for io. 
 * 
 * @author Jackson York
 * @since 1/13/2021
 */
public class jio {
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

    /**
     * Helper function that prompts the user with the specified message until a
     * double is received.
     * 
     * @return received double
     */
    public static double prompt_double(Scanner s, String message) {
        System.out.println(message);
        while (!s.hasNextDouble()) {
            s.next();
            System.out.println(message);
            s.hasNext();
        }
        double output = s.nextDouble();
        return output;
    }

    /**
     * Helper function that prompts the user with the specified message until a
     * String is received.
     * 
     * @return received Line
     */
    public static String prompt_String(Scanner s, String message) {
        System.out.println(message);
        while (!s.hasNextLine()) {
            s.next();
            System.out.println(message);
            s.hasNext();
        }
        String output = s.nextLine();
        return output;
    }

}
