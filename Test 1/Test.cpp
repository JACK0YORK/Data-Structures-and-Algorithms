/**
 * @file Test.cpp
 * @author Jackson York
 * @brief Test functions with sample main() for Exam 1 for Data Structures and Algorithms
 * @date 2021-02-25
 */

#include "./Question1.cpp"
#include "./Question2.cpp"
#include "./Question3.cpp"
#include "./Question4.cpp"
#include "./Question5.cpp"

void testq1()
{
    Array<int> *a = new Array<int>(new int[5]{5, 2, 3, 1, 4}, 5);
    std::cout << "a\t\t\t\t";
    a->println();
    a->remove_at(2);
    std::cout << "a->remove_at(2)\t\t\t";
    a->println();
    a->insert_at(2, 1);
    std::cout << "a->insert_at(2,1)\t\t";
    a->println();
    std::cout << "a->filter()\t\t\t";
    a->filter([](int x) -> bool { return x % 2 == 0; })->println();
    std::cout << "a->size()\t\t\t" << a->size() << std::endl;
    std::cout << "a->index_of(4)\t\t\t" << a->index_of(4) << std::endl;
    std::cout << "a->index_of(7)\t\t\t" << a->index_of(7) << std::endl;
    std::cout << std::boolalpha;
    std::cout << "a->is_empty()\t\t\t" << a->is_empty() << std::endl;
    Array<int> *temp = new Array<int>(3);
    temp->print();
    std::cout << "->is_empty()\t\t" << temp->is_empty() << std::endl;
    std::cout << "a->is_equal([0, 0, 0])\t\t" << a->is_equal(temp) << std::endl;
    delete temp;
    temp = new Array<int>(new int[5]{5, 2, 1, 1, 4}, 5);
    std::cout << "a->is_equal(";
    temp->print();
    std::cout << ")\t" << a->is_equal(temp) << std::endl;
    delete temp;
    std::cout << "a->shuffle\t\t\t";
    a->shuffle()->println();
    std::cout << "a->sort()\t\t\t";
    a->sort()->println();
    std::cout << "a->slice(1,3)\t\t\t";
    a->slice(1, 3)->println();
}

template <typename T>
void print(T A[], int n)
{
    std::cout << "[" << A[0];
    for (int i = 1; i < n; i++)
        std::cout << ", " << A[i];
    std::cout << "]";
}

void testq2()
{
    int n = 4;
    int *A = new int[n]{1, 3, 5, 7};
    std::cout << "A = ";
    print(A, n);
    std::cout << std::endl;
    for (int i = -3; i < 10; i++)
    {
        std::cout << std::boolalpha << "is_k_bit_int_not_in_A(" << i << ", A, " << n << ")  \t-> ";
        std::cout << is_k_bit_int_not_in_A(i, A, n) << std::endl;
    }
}

void testq3()
{
    int test[5] = {2, 3, 1, -4, -5};
    std::cout << "find_unformable(";
    print(test, 5);
    std::cout << ") -> \t";
    std::cout << find_unformable(test) << std::endl;
}

void testq4()
{
    int pivot = 2;
    int n = 5;
    int A[] = {5, 3, 2, 4, 1};
    std::cout << "rearrange_around_pivot(A,pivot)\n\tA = ";
    print(A, n);
    std::cout << ", \tpivot = " << pivot << " \t-> ";
    rearrange_around_pivot(A, pivot);
    std::cout;
    print(A, n);
    std::cout << std::endl;
    pivot = 3;
    std::cout << "\tA = ";
    print(A, n);
    std::cout << ", \tpivot = " << pivot << " \t-> ";
    rearrange_around_pivot(A, pivot);
    std::cout;
    print(A, n);
    std::cout << std::endl;
    pivot = 4;
    std::cout << "\tA = ";
    print(A, n);
    std::cout << ", \tpivot = " << pivot << " \t-> ";
    rearrange_around_pivot(A, pivot);
    std::cout;
    print(A, n);
    std::cout << std::endl;
}

void testq5()
{
    String *this_str = new String("Foo");
    String *other_str = new String("   Bar");
    std::cout << std::boolalpha;
    std::cout << "this        -> \t" << this_str << std::endl;
    std::cout << "other       -> \t" << other_str << std::endl;
    std::cout << "strlen()    -> \t" << this_str->strlen() << std::endl;
    std::cout << "strlwr()    -> \t" << this_str->strlwr() << std::endl;
    std::cout << "strlwr()    -> \t" << this_str->strupr() << std::endl;
    std::cout << "other       -> \t" << other_str << std::endl;
    std::cout << "strcat(o)   -> \t" << this_str->strcat(other_str) << std::endl;
    std::cout << "other       -> \t" << other_str << std::endl;
    std::cout << "strcpy(o)   -> \t" << this_str->strcpy(other_str) << std::endl;
    std::cout << "other       -> \t" << other_str << std::endl;
    std::cout << "o.strcpy(t) -> \t" << other_str->strcpy(this_str) << std::endl;
    std::cout << "this        -> \t" << this_str << std::endl;
    std::cout << "strcmp(o)   -> \t" << this_str->strcmp(other_str) << std::endl;
    std::cout << "strcmp(t)   -> \t" << this_str->strcmp(this_str) << std::endl;
    std::cout << "strcmp(\" \") -> \t" << this_str->strcmp(new String(" ")) << std::endl;
}
int main(int argc, char const *argv[])
{
    std::cout << "\n\nQUESTION 1 TEST OUTPUT" << std::endl;
    testq1();
    std::cout << "\n\nQUESTION 2 TEST OUTPUT" << std::endl;
    testq2();
    std::cout << "\n\nQUESTION 3 TEST OUTPUT" << std::endl;
    testq3();
    std::cout << "\n\nQUESTION 4 TEST OUTPUT" << std::endl;
    testq4();
    std::cout << "\n\nQUESTION 5 TEST OUTPUT" << std::endl;
    testq5();
    return 0;
}
