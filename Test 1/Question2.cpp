/**
 * @file Question2.cpp
 * @author Jackson York
 * @brief Question 2 on Exam 1 for Data Structures and Algorithms
 * @date 2021-02-25
 */
#ifndef Q2
#define Q2 

#include <cmath>

/**
 * @note runtime = 3 * n + 22
 *               = O(n)
 * 
 * @brief Given an array of n positive odd integers, each represented with k=|`logn`|+1 bits, 
 * write an O(n)-time method for finding whether an integer is a k-bit integer not in A.
 * 
 * @param x The number that must be k-bits and not in A
 * @param A The array containing only positive odd k-bit integers 
 * @param n The length of the array A, determines k by k=ceil(log2(n))+1
 */
bool is_k_bit_int_not_in_A(int x, int A[], int n)
{
    int k = ceil(log2((double)n)) + 1; // k=|`logn`|+1 bits
    if (k < 1)
        k = 1;
    // std::cout << "k = " << k;
    int num_of_bits_in_x = (int)(log2((double)x)) + 1;
    if (num_of_bits_in_x < 1)
        num_of_bits_in_x = 1;
    // std::cout << "\tb = " << num_of_bits_in_x << "\t";

    // I'm choosing to throw out negatives because the professor said in class that,
    // for this problem, (0=0, 1=1, 2=10, 3=11, ... )
    // This indicates that 2's complement notation (-2=10,-1=11, 0 = 0, 1=01, ...) 
    // is invalid (and thus negative values are invalid).
    if (num_of_bits_in_x > k || x < 0)
        return false; // is not "a positive k-bit int"
    if (x % 2 == 0)
        return true; // is not odd, therefore is "a positive k-bit integer not in A"
    for (size_t i = 0; i < n; i++)
        if (x == A[i])
            return false; // is not "not in A"

    return true; // is "a positive k-bit integer not in A"
}

#endif // !Q2