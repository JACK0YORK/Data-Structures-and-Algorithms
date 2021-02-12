#include <iostream>

template <typename T>
class Array
{
    T *elements;
    int length;

public:
    Array(int length)
    {
        this->length = length;
    }

    Array(T *to_copy, int length)
    {
        this->length = length;
        this->elements = new T[length];
        for (int i; i < length; i++)
        {
            this->elements[i] = to_copy[i];
        }
    }

    bool is_empty()
    {
        if (this->length == 0)
            return true;
        for (int i = 0; i < length; i++)
        {
            if (elements[i] != NULL)
                return false;
        }
        return true;
    }

    template <typename E>
    bool is_equal(Array<E> other)
    {
        if (static_cast<E>(new T) == nullptr || static_cast<T>(new E) == nullptr)
            return false;
        if (this->length != other.length)
            return false;
        for (int i = 0; i < length; i++)
        {
            if (elements[i] != other[i])
                return false;
        }
        return true;
    }

    void replace(int index, T element)
    {
        if (index < 0 || index >= this->length)
        {
            std::cerr << "Invalid index" << std::endl;
            return;
        }
        this->elements[index] = element;
    }

    Array<T> filter(bool func(T))
    {
        T out = new T[this->length];
        int j = 0;
        for (int i = 0; i < this->length; i++)
        {
            if (func(this->elements[i]))
            {
                out[j] = this->elements[i];
                j++;
            }
        }
        return Array(out, j);
    }

    int size()
    {
        return this->length;
    }

    /*
		Replaces value at index with NULL. 
	*/
    void remove(int index)
    {
        if (index < 0 || index >= this->length)
        {
            std::cerr << "Invalid index" << std::endl;
            return;
        }
        this->elements[index] = NULL;
    }
    /*
		removes value at index, and shifts values to the left, leaving a NULL at the end. 
	*/
    void remove_and_shift(int index)
    {
        if (index < 0 || index >= this->length)
        {
            std::cerr << "Invalid index" << std::endl;
            return;
        }
        for (; index < length - 1; index++)
        {
            elements[index] = elements[index + 1];
        }
        this->elements[length - 1] = NULL;
    }
    /*
		removes value at index, and shifts values to the left, decreasing the length of the array. 
	*/
    void remove_and_shift_and_delete(int index)
    {
        if (index < 0 || index >= this->length)
        {
            std::cerr << "Invalid index" << std::endl;
            return;
        }
        for (; index < length - 1; index++)
        {
            elements[index] = elements[index + 1];
        }
        this->length -= 1;
        this->elements[length] = NULL;
    }

    
};

int main()
{
    std::cout << "Hello World!\n";
}
