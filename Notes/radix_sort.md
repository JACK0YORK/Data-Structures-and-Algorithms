```c++
struct node
{
    int data;
    node *next = nullptr;
};

int radix_of(int value, int base, int n)
{
    for (size_t i = 0; i < n; i++)
        value /= base;
    value %= base;
    return value;
}

int *radix_sort(const int *unsorted_array, const int length)
{
    const int base = 10;
    node *head = new node;
    node *temp = head;
    for (size_t i = 1; i < length; i++)
    {
        temp->next = new node;
        temp = temp->next;
        temp->data = unsorted_array[i];
    }
    node *bucket_tails[base] = {nullptr};
    temp = head;
    int n = 0;
    while (temp != nullptr)
    {
        n++;
        // radix=(temp->data/10**n)%base
        int radix = radix_of(temp->data, base, n);

        //2->1

        // **1
        node *temp_next = temp->next;

        // insert temp to bucket
        if (bucket_tails[radix] != nullptr)
        {
            temp->next = bucket_tails[radix]->next;
            bucket_tails[radix]->next = temp;
        }
        else if (radix_of(head->data, base, n) > radix)
        {
            head = temp;
            temp->next = head;
        }
        //bt[2]=2
        bucket_tails[radix] = temp;
        //t=1
        temp = temp_next;
    }

    // array now a linkedlist
}
```