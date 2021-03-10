/**
 * @file Question4.java
 * @author Jackson York
 * @brief Question 4 on Exam 1 for Data Structures and Algorithms
 * @date 2021-02-25
 */

public class Question4 {
    /**
     * @note runtime = 8n+2 = O(n)
     *
     * @brief Recursively rearranges A so that elements larger than k are to the
     *        right of other elements.
     * 
     * @param A Array to be rearranged
     * @param k value around which to pivot
     */
    public static void rearrange_around_pivot(int[] A, int k) {
        recursive_call(A, 0, A.length, k);
    }

    private static void recursive_call(int[] A, int i, int n, int k) {
        if (i == n) // every call of this function moves n and i closer together.
            return; // this stops the calls when all elements have been switched or skipped.

        if (A[i] > k) { // switch {n-1}th element and {i}th element
            int temp = A[i];
            int n_1 = n - 1;
            A[i] = A[n_1];
            A[n_1] = temp;
            recursive_call(A, i, n_1, k); // moves n closer to i
        } else { // skip {i}th element
            recursive_call(A, i + 1, n, k); // moves i closer to n
        }
    }
}
