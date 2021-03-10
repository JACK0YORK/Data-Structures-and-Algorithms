#ifndef JACKBUCKET
#define JACKBUCKET 

#include <exception>
namespace jack
{
    struct bucket
    {
        int length = 0;
        int last;
        int **elements;
    };

    bucket new_bucket(int length, int last, int *elements)
    {
        bucket out;
        out.length = length;
        out.last = last;
        out.elements = new int[length];
        memcpy(out.elements, elements, sizeof(elements[0]) * length);
        return out;
    };

    void append(bucket *this_bucket, int value)
    {
        if (this_bucket->length == 0)
        {
            this_bucket->length=1;
            this_bucket->last=0;
            this_bucket->elements=new int[1]{value};
        }
        else if (this_bucket->last < this_bucket->length - 1)
        {
            this_bucket->last++;
            this_bucket->elements[this_bucket->last] = value;
        }
        else
        {
            this_bucket->length = this_bucket->length * 2;
            this_bucket->elements = new int[this_bucket->length];
            memcpy(this_bucket->elements, this_bucket->elements, sizeof(this_bucket->elements[0]) * this_bucket->length);

            this_bucket->last++;
            this_bucket->elements[this_bucket->last] = value;
        }
    }
} // namespace jack
#endif // !JACKBUCKET