#include <iostream>
#include ".\bucket.hpp"

int get_radix(int value, int current_base, int base);
int *radix_sort(int unsorted_array[], const int length, const int base);

int *radix_sort(int unsorted_array[], const int length, const int base)
{
    int *array = new int[length];
    memcpy(array, unsorted_array, length);
    int current_base = 1;
    for (size_t i = 0; i < 7 && current_base > 0; i++)
    {
        jack::bucket *buckets = new jack::bucket[base];
        for (size_t i = 0; i < length; i++)
            jack::append(&buckets[get_radix(array[i], current_base, base)], array[i]);
        int offset = 0;
        for (size_t i = 0; i < base && offset < length; i++)
        {
            memcpy(array + offset, buckets[i].elements, buckets[i].last + 1);
            offset += buckets[i].last + 1;
        }
        current_base *= base;
        for (size_t i = 0; i < length; i++)
        {
            std::cout << array[i] << " ";
        }
    }
    return array;
}

int get_radix(int value, int current_base, int base)
{
    return (value / current_base) % base;
}

int main(int argc, char const *argv[])
{
    radix_sort(new int[11]{111,21,13,213,231,222,11,23,112,121,11}, 11, 10);
    return 0;
}
