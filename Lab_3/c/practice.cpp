#include "d_linkedlist.hpp"
#include "iter_enumerate.hpp"
#include <iostream>
#define del(ptr) delete ptr; ptr = NULL; 
#define adel(ptr) delete[] ptr; ptr = nullptr; 

using namespace std;
int main(int argc, char const *argv[])
{
    d_linkedlist<int>* ll1 = new d_linkedlist<int>(new int[5]{10,11,12,13,14},5);
    ll1->append(15);
    int x = ll1->pop();
    bool y = ll1->is_empty();
    d_linkedlist<int> ll2 = ll1->filter([](int x)->bool{ return x%2==0; });
    delete ll1;
    ll1=nullptr;
    x=ll2.size();

    
}
