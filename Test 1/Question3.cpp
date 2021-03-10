/**
 * @file Question3.cpp
 * @author Jackson York
 * @brief Question 3 on Exam 1 for Data Structures and Algorithms
 * @date 2021-02-25
 */

#ifndef Q3
#define Q3

#include <cmath>
/**
 * @note rumtime = 6n + 7
 *               = O(n)
 * 
 * @brief This algorithm relies on the understanding that if the maximum value in an
 * array is added to itself, that is the highest value achievable by summing values in that array.
 * 
 * @tparam n number of values in array A
 * @param A Array with arbitrary integers
 * @return int that cannot be formed from the sum of any two values in A
 */
template <int n>
int find_unformable(int (&A)[n])
{
    if (n < 1)
        return 1; // 1 cannot be formed from the sum of two non-existant numbers.
    int max_from_0 = A[0];
    for (int i = 1; i < n; i++) // iterate over all elements after A[0]
    {
        if (abs(A[i]) > abs(max_from_0))
            max_from_0 = A[i]; // set max if new max is found
    }
    return abs(max_from_0) * 2 + 1; // return 1 more than highest possible sum
}

#endif // !Q3