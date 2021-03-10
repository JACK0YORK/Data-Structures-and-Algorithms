/**
 * @file Question5.cpp
 * @author Jackson York
 * @brief Question 5 on Exam 1 for Data Structures and Algorithms
 * @date 2021-02-25
 */

#ifndef Q5
#define Q5 

#include "./Question1.cpp"
#include <iostream>

// #include <iostream>

// unsafe flag
struct unsafe
{
};

class String
{
    Array<char> *values = nullptr;

    /// runtime = 1
    String(Array<char> *values, unsafe u)
    {
        // unsafe, uses given value array without copying
        this->values = values;
    };

public:
    /// runtime = 3n+6
    template <int n>
    String(const char (&char_array)[n])
    { // template allows entry of only char[].
        this->values = new Array<char>(n - 1);
        for (size_t i = 0; i < n - 1; i++)
        {
            this->values->insert_at(i, char_array[i]);
        }
    };
    /// runtime = 8n+11
    String(Array<char> *values)
    {
        // copies all values by filtering with a condition of true.
        this->values = values->filter([](char _) -> bool { return true; });
    };
    /// runtime = 2
    ~String()
    {
        delete[] values;  // free memory
        values = nullptr; // dereferencing
    }

    /**
     * @note runtime = 2
     *               = O(1)
     * 
     * @brief length of the string
     * 
     * @return int the length of the string
     */
    int strlen() const { return values->size(); }

    /**
     * @note runtime = 9n + 10
     *               = O(n)
     * 
     * @brief converts all uppercase characters to their lowercase equivalents
     * 
     * @return String* converted string
     */
    String *strlwr() const
    {
        // setting this_len causes an order-n speedup as size() would be called in the for loop.
        int this_len = this->values->size();
        Array<char> *lower_arr = new Array<char>(this_len);
        for (int i = 0; i < this_len; i++)
        {
            // this can save up to 3n in runtime at face value. I could use [[gnu::pure]] to cause
            //     this behavior at compile time, at the expense of explicitness.
            char c = this->values->at(i);
            // constant math is calculated at compile time. ('a' - 'A')=32 is purely for readability.
            // triconditional helps with caching.
            lower_arr->insert_at(i, c + ((c >= 'A' && c <= 'Z') ? ('a' - 'A') : 0));
        }
        // using unsafe version because upper_arr is otherwise inaccessible.
        return new String(lower_arr, unsafe());
    }

    /**
     * @note runtime = 9n + 10
     *               = O(n)
     * 
     * @brief converts all lower case characters to their uppercase equivalents.
     * 
     * @return String* converted string
     */
    String *strupr() const
    {
        // see strlwr() for comments, these are identical outside of logic.
        int this_len = this->values->size();
        Array<char> *upper_arr = new Array<char>(this->values->size());
        for (int i = 0; i < this_len; i++)
        {
            char c = this->values->at(i);
            upper_arr->insert_at(i, c - ((c >= 'a' && c <= 'z') ? ('a' - 'A') : 0));
        }
        return new String(upper_arr, unsafe());
    }

    /**
     * @note runtime = 4m+5p + 13  | m := this_len, p := other_len
     *               = 9n + 13     | n := (4m + 5p) / 9 = (weighted) average length of input strings
     *               = O(n)
     * 
     * @brief appends the given string to the end of this string
     * 
     * @param other string to append
     * @return String* containing the concatenated string
     */
    String *strcat(String *other) const
    {
        // setting this_len, other_len causes an order-n speedup as size() would be called in the for loop.
        int this_len = this->values->size();
        int other_len = other->values->size();
        Array<char> *concat_arr = new Array<char>(this_len + other_len);
        for (size_t i = 0; i < this_len; i++)
            concat_arr->insert_at(i, this->values->at(i));
        for (size_t i = 0; i < other_len; i++)
            concat_arr->insert_at(this_len + i, other->values->at(i));
        return new String(concat_arr, unsafe());
    }

    /**
     * @note runtime = 4n + 7
     *               = O(n)
     * 
     * @brief copies this string into the destination string
     * 
     * @param dest_str the destination string
     * @return bool whether the copy succeeded 
     */
    bool strcpy(String *dest_str) const
    {
        int this_len = this->values->size();                     // 2
        if (this_len > dest_str->values->size())                 // 2
            return false;                                        // cannot copy string to other.
        for (size_t i = 0; i < this_len; i++)                    // 2n+2
            dest_str->values->insert_at(i, this->values->at(i)); // 2n
        return true;                                             // 1
    }

    /**
     * @note runtime = 10n + 13
     *               = O(n)
     * 
     * @brief compares this with other, returning 
     * 0 if equal,
     * 1 if greater than,
     * -1 if less than
     * 
     * @param other string to compare
     * @return int ( == 0; > 1; < -1 )
     */
    int strcmp(const String *other) const
    {
        int this_len = this->values->size();
        int other_len = other->values->size();
        for (size_t i = 0; i < this_len && i < other_len; i++)
            if (this->values->at(i) < other->values->at(i))
                return -1;
            else if (this->values->at(i) > other->values->at(i))
                return 1;
        return this_len == other_len ? 0 : (this_len > other_len ? 1 : -1);
    }
    friend std::ostream &operator<<(std::ostream &o, String *s);
};

std::ostream &operator<<(std::ostream &o, String *s)
{
    o << "\"";
    for (int i = 0; i < s->strlen(); i++)
        o << s->values->at(i);
    return o << "\"";
}

#endif // !Q5
