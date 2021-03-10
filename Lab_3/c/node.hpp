template <typename T>
class node
{
public:
    T data;
    node *next = nullptr;

    node(T data) : data(data) {}
    ~node()
    {
        delete this->next;
        this->next = nullptr;
    }
};



