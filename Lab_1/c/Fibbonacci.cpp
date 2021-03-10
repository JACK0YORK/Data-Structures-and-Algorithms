#include <iostream>
#include <time.h>

int recursive_fibbonacci(int n)
{
    if (n == 0)
        return 0;
    if (n == 1)
        return 1;
    return recursive_fibbonacci(n - 1) + recursive_fibbonacci(n - 2);
}

int iterative_fibbonacci(int n)
{

    int current = 0;
    int previous = 1;
    while (n > 0)
    {
        current = current + previous;
        previous = current - previous;
        n--;
    }
    return current;
}

int main(int argc, const char **argv)
{

    int repetitions = 10;                    // Modify as needed
    int scale = 10000000 / 10 * repetitions; // I find this is reasonable for testing

    std::cout << ("| Recursive\t| Iterative\t|") << std::endl;
    std::cout << ("+---------------+---------------+") << std::endl;
    std::cout << ("| Value\t| Time\t| Value\t| Time\t|") << std::endl;
    std::cout << ("+-------+-------+-------+-------+") << std::endl;

    for (int i = 1; i < repetitions; i++)
    {
        time_t time1 = time(NULL);
        int recursive_fibbonacci_value = recursive_fibbonacci(i);
        for (int j = 0; j < scale; j++)
        {
            recursive_fibbonacci_value = recursive_fibbonacci(i);
        }
        time_t time2 = time(NULL);
        int iterative_fibbonacci_value = iterative_fibbonacci(i);
        for (int j = 0; j < scale; j++)
        {
            iterative_fibbonacci_value = iterative_fibbonacci(i);
        }
        time_t time3 = time(NULL);
        std::cout << "| " << recursive_fibbonacci_value << "\t| " << (time2 - time1) << "s\t| " << iterative_fibbonacci_value << "\t| " << (time3 - time2) << "s\t|" << std::endl;
    }
    return 0;
}