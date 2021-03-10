```c++
#include <iostream>

// Integers
int i = 1;

// Booleans
bool b = true;

// Characters
char c = 'a';

// Floats
float f = 1.1;
double d = 1.1;
```
# Structs 
A group of variables. 
>Note that structs store data in the order specified by the user, 
so prefer {char,char,int} (CCCC IIII) to {char,int,char} (CC00 IIII CC00)

```c++
struct good
{
    char x;
    char y;
    int z;
};
struct bad
{
    char x;
    int z;
    char y;
};
void struct_test()
{
    good *test1_p;
    bad *test2_p;
    std::cout << test1_p << "\t" << ++test1_p << std::endl; // 0x0   0x8 <- 8 bytes
    std::cout << test2_p << "\t" << ++test2_p << std::endl; // 0x0   0xC <- 12 bytes
}

// Objects
class A
{
public:
    int a, b, c;
    virtual void test() = 0;
    A(int a, int b)
    {
        std::cout << "Hello I am the constructor" << std::endl;
    }
};

class B : public A
{
    int y; // Private variable cannot be accessed from outside.

public:
    B(int i, int j) : A(a, b)
    {
        a = i;
        b = j;
        c = a + b;
    }
    void test() { std::cout << "The sum is = " << c << std::endl; }
};

void object_test()
{
    B obj(4, 5);
    obj.test();
    obj.a; // valid
    // obj.y; cannot be accessed
}
```

# Pointers
Pointers store the address of a variable.
`p = 0x00104001, p.length=TYPE(int)=32`
`dangerous = 0x00104001, dangerous.length=TYPE(void)=null`
- The ampersand(&), when in an expression, gets the adress of a variable
-  The star(\*), when in an expression, indicates that the compiler should unpack the pointer, 
        ie. get the value of the data at that location in memory. 
```c++
int *p = &i;
```
- The star(\*), when in a declaration, indicates that a variable will be a pointer to the 
        specified data type.
```c++
void *dangerous = p;
```
# References
*   References are static pointers - they always point to the same data. 
        ie. r++ is equivalent to (\*p)++ or i++
>Reference allows you to manipulate an object using pointer, but without the pointer syntax of referencing and dereferencing.

```c++
int &r = i;
//! References should always "trickle down", never return a reference to local memory.
// int &getLocalVariable()
// {
//     int x;
//     return x;
// }
//! References can also fail if they point to NULL.
void nullref()
{
    int *x = nullptr;
    int &y = *x;
}
void pointer_reference_test()
{
    r++;
    std::cout << i << std::endl;
    i = 1;
    (*p)++;
    std::cout << i << std::endl; // same output
    i = 1;
    std::cout << p << "\t" << *p << std::endl;
    p++;
    std::cout << p << "\t" << *p << std::endl; // Note the increase of 4 - that's the size of an int - 4 bytes.
    //We've reached incorrectly assigned memory now, so don't do this outside arrays and the like.
    p = &i;
    std::cout << dangerous << "\t" << *((int *)dangerous) << std::endl;
    // Pointer arithmetic relies on type, so void* cannot use math. Cast to type of appropriate size, then operate.
    dangerous = (void *)((char *)dangerous + 1);
}

int main(int argc, char const *argv[])
{
    **// struct_test();**
    // object_test();
    return 0;
}
