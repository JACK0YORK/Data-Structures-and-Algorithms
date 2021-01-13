
/**
 * Showcase of the efficiency (and inefficiency) of recursive and iterative
 * implementations of fibbonacci generators.
 * 
 * @author Jackson York
 * @since 1/11/2021
 */
public class Fibbonacci {

    /**
     * Returns the nth term in the Fibbonacci Sequence ( 0, 1, 1, 2, ... ). I made a
     * wrapper so that the range check doesn't unfairly impact the run-time of the
     * recursive function.
     * 
     * @param n
     */
    public static int recursive_fibbonacci(int n) {
        if (n < 1 || n > 48)
            throw new IllegalArgumentException(
                    "This Fibbonacci generator only works for integers in the range [1, 48]\n ie. " + n
                            + " is out of bounds. ");
        return recursive_fibbonacci_r(n, 0, 1);
    }

    private static int recursive_fibbonacci_r(int n, int current, int previous) {
        if (n <= 1)
            return current;
        else {
            current = current + previous;
            previous = current - previous;
            return recursive_fibbonacci_r(n - 1, current, previous);
        }
    }

    /**
     * Returns the nth term in the Fibbonacci Sequence ( 0, 1, 1, 2, ... ).
     * 
     * @param n
     */
    public static int iterative_fibbonacci(int n) {
        if (n < 1 || n > 48)
            throw new IllegalArgumentException(
                    "This Fibbonacci generator only works for integers in the range [1, 48]\n ie. " + n
                            + " is out of bounds. ");
        int current = 0;
        int previous = 1;
        while (n > 1) {
            current = current + previous;
            previous = current - previous;
            n--;
        }
        return current;
    }

    /**
     * After running this a couple times (with much larger timescales and with more
     * repetitions), it's clear that the iterative function is faster, likely
     * because it requires a function call to itself.
     * 
     * @param args
     */
    public static void main(String[] args) {

        final int repetitions = 20; // Modify as needed
        final int scale = 10000000 / 20 * repetitions; // I find this is reasonable for testing

        System.out.println("| Recursive\t| Iterative\t|");
        System.out.println("+---------------+---------------+");
        System.out.println("| Value\t| Time\t| Value\t| Time\t|");
        System.out.println("+-------+-------+-------+-------+");

        for (int i = 1; i < repetitions; i++) {
            long time1 = System.currentTimeMillis();
            int recursive_fibbonacci = recursive_fibbonacci(i);
            for (int j = 0; j < scale; j++) {
                recursive_fibbonacci = recursive_fibbonacci(i);
            }
            long time2 = System.currentTimeMillis();
            int iterative_fibbonacci = iterative_fibbonacci(i);
            for (int j = 0; j < scale; j++) {
                iterative_fibbonacci = iterative_fibbonacci(i);
            }
            long time3 = System.currentTimeMillis();
            System.out.println("| " + recursive_fibbonacci + "\t| " + (time2 - time1) + "ms\t| " + iterative_fibbonacci
                    + "\t| " + (time3 - time2) + "ms\t|");
        }
    }
}
