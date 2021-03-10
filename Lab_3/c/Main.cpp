
#include <iostream>
#include <string>
#include "ArrayList.cpp"

/// Abstract Wrapper Class, allows dynamic ArrayLists through the child<T> class.
/// The only restriction on what classes can be accepted is that thefollowing must be implemented:
/// bool operator==(T,T), and
/// std::ostream& operator<<(std::ostream&, (&)T)
class parent
{
public:
    virtual std::ostream &push_to(std::ostream &) = 0;
    virtual bool equals(parent &) = 0;
    friend std::ostream &operator<<(std::ostream &o, parent &p)
    {
        return p.push_to(o);
    }
    friend bool operator==(parent &p1, parent &p2)
    {
        return p1.equals(p2);
    }
};
template <typename U, typename T=U>
class child : public parent
{
    T val;

public:
    child(U value) : val(value){};
    T value() { return val; }
    std::ostream &push_to(std::ostream &o)
    {
        return o << val;
    }
    bool equals(parent &p)
    {
        child<T> *c = dynamic_cast<child<T> *>(&p);
        if (c == nullptr)
            return false;
        return c->val == this->val;
    }
};

std::ostream &operator<<(std::ostream &o, ArrayList<parent> p_vec)
{
    for (size_t i = 0; i < p_vec.size(); i++)
    {
        if (i != 0)
            o << ", ";
        p_vec.get(i).push_to(o);
    }
    return o;
}

int main()
{
    ArrayList<parent> *w = new ArrayList<parent>();
    std::cout << std::boolalpha;

    w->add(0, new child<int>(5));
    w->add(0, new child<int>(10));
    w->add(0, new child<int>(15));
    w->add(0, new child<int>(20));
    w->add(0, new child<int>(25));
    w->add(0, new child<std::string>("pi"));
    w->add(4, new child<int>(-1));
    w->add(4, new child<int>(-1));
    w->add(5, new child<int>(-2));
    w->add(5, new child<int>(-2));
    for (int i = 0; i < w->size(); i++)
    {
        std::cout << i << " -> " << w->get(i) << std::endl;
    }
    std::cout << "Removed " << w->remove(4) << std::endl;
    std::cout << "Removed " << w->remove(5) << std::endl;
    std::cout << "Removed " << w->remove(5) << std::endl;
    std::cout << "Removed " << w->remove(4) << std::endl;
    for (int i = 0; i < w->size(); i++)
    {
        std::cout << i << " -> " << w->get(i) << std::endl;
    }
    std::cout << w->contains(new child<int>(5)) << std::endl;
    std::cout << w->contains(new child<int>(30)) << std::endl;
    std::cout << w->contains(new child<int>(-1)) << std::endl;
    std::cout << "Empty? " << w->isEmpty() << std::endl;
    w->clear();
    std::cout << "Empty? " << w->isEmpty() << std::endl;
    for (int i = 0; i < w->size(); i++)
    {
        std::cout << i << " -> " << w->get(i) << std::endl;
    }

    w->add(0, new child<int>(5));
    w->add(1, new child<int>(6));
    w->add(2, new child<int>(7));
    for (int i = 0; i < w->size(); i++)
    {
        std::cout << i << " -> " << w->get(i) << std::endl;
    }
    return 0;
}