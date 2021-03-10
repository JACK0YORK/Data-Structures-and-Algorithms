/**
 * @file Question3.java
 * @author Jackson York
 * @brief Question 3 on Exam 1 for Data Structures and Algorithms
 * @date 2021-02-25
 */

import java.lang.Math;

public class Question3 {
    /**
     * @note runtime = 6 * n + 7 = O(n)
     * 
     * @brief This algorithm relies on the understanding that if the maximum value
     *        in an array is added to itself, that is the highest value achievable
     *        by summing values in that array.
     * 
     * @param A Array with arbitrary integers
     * @return int that cannot be formed from the sum of any two values in A
     */
    public static int find_unformable(int[] A) {
        if (A.length < 1)
            return 1; // 1 cannot be formed from the sum of two non-existant numbers.
        int max = A[0];
        for (int i = 1; i < A.length; i++) // iterate over all elements after A[0]
            if (Math.abs(A[i]) > Math.abs(max))
                max = A[i]; // set max if new max is found
        return Math.abs(max) * 2 + 1; // return 1 more than highest possible sum
    }
}
