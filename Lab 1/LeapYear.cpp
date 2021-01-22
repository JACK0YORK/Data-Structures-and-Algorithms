#include <iostream>

bool is_leap_year(int year)
{
    if (year % 400 == 0)
        return true;
    if (year % 100 == 0)
        return false;
    if (year % 4 == 0)
        return true;
    return false;
}

int main()
{
    std::cout << "Enter a year to test" << std::endl;
    int year=12;
    // std::cin >> year;
    std::cout << is_leap_year(year) << std::endl;
    return 0;
}