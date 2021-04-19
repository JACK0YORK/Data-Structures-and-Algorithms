#include <cstddef>
#include <iostream>

#include "array_tree_draw.h"

template <typename T>
class MaxHeap {
    // Instance Variables
    T** heap = nullptr;
    size_t length = 0;
    int last = -1;

    // Private Static Methods

    template <typename E>
    static size_t root();

    template <typename E>
    static size_t up(size_t child);

    template <typename E>
    static size_t left(size_t root);

    template <typename E>
    static size_t right(size_t root);

    static size_t root() {
        return 0;
    }

    static size_t up(size_t child) {
        return ((long)child - 1) / 2;
    }

    static size_t left(size_t root) {
        return 2 * root + 1;
    }

    static size_t right(size_t root) {
        return 2 * root + 2;
    }

    // Private Instance Methods

    template <typename E, size_t n>
    size_t posOfMax(size_t (&indices)[n]);

    template <typename E>
    void swap(size_t a, size_t b);

    template <typename E>
    void grow(size_t desired_index);

    template <typename E>
    void heapify(size_t root);

    template <size_t n>
    size_t posOfMax(size_t const (&indices)[n]) {
        size_t max_i = indices[0];
        T max_T = *heap[max_i];

        for (size_t i = 1; i < n; i++) {
            const auto index = indices[i];
            const auto* value = heap[index];

            if (value && max_T < *value) {
                max_i = index;
                max_T = *value;
            }
        }

        return max_i;
    }

    void swap(size_t a, size_t b) {
        auto* temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    void grow(size_t desired_index) {
        if (desired_index >= length) {
            length = right(length - 1) + 1;
            T** temp = new T* [length] { nullptr };
            for (size_t i = 0; i <= last; i++) {
                temp[i] = heap[i];
            }
            heap = temp;
        }
    }

    size_t heapify(size_t root) {
        const size_t indices[] = {root, left(root), right(root)};

        if (indices[1] > last || (!heap[indices[1]] && !heap[indices[2]]))
            return 0;  // No change if leaf

        const size_t pos_of_max = this->posOfMax(indices);

        if (pos_of_max != root) {
            this->swap(pos_of_max, root);
            return pos_of_max;
        }
        return 0;  // no swap necessary
    }

   public:
    // Construtors

    MaxHeap() {
        this->last = -1;

        this->length = 3;

        this->heap = new T* [this->length] { nullptr };
        // for (size_t i = 0; i < this->length; i++) {
        //     this->heap[i] = nullptr;
        // }
    }

    template <size_t n>
    MaxHeap(T (&array)[n]) {
        this->last = n - 1;

        this->length = 0;
        while (this->length < this->last) {
            this->length = right(this->length);
        }
        this->length++;

        this->heap = new T* [this->length] { nullptr };
        // for (size_t i = n; i < this->length; i++) {
        //     this->heap[i] = nullptr;
        // }
        for (size_t i = 0; i < n; i++) {
            this->heap[i] = new T{array[i]};
        }
        for (int i = (int)n - 1; i >= 0; i--) {
            size_t swapped = heapify(i);
            while (swapped)
                swapped = heapify(swapped);
        }
    }

    ~MaxHeap() {
        for (size_t i = 0; i < length; i++) {
            if (heap[i]) {
                delete heap[i];
                heap[i] = nullptr;
            }
        }
        delete[] heap;
        heap = nullptr;
    }

    // Public Instance Methods
    template <typename E>
    E getMax();
    template <typename E>
    size_t getSize();

    T getMax() {
        return *heap[0];
    }

    size_t getSize() {
        return length;
    }

    void insert(T& key) {
        grow(last + 1);
        last++;
        heap[last] = new T{key};

        size_t ancestor = up(last);
        while (heapify(ancestor)) {
            // std::cout << "    ";
            // tree_tools::tree_draw(heap, length, ancestor, "    ");
            ancestor = up(ancestor);
        };
    }

    T remove() {
        if (last < 0) {
            throw std::out_of_range("cannot remove from empty heap.");
        }
        T out = *heap[0];
        heap[0] = heap[last];
        heap[last] = nullptr;
        last--;

        size_t swapped = heapify(0);
        while (swapped) {
            swapped = heapify(swapped);
        }
        return out;
    }

    template <typename E>
    friend std::ostream& operator<<(std::ostream& o, MaxHeap<E>& m) {
        o << "Heap: " << std::endl;
        tree_tools::print(m.heap, m.length + 1);
        return o;
    }
};

// class Max_Heap{
// public:
// int size = 5;
// int *heap = new int[size];

// void maxheap_fromArray(int arr[], int n){
//     this->heap = arr;
//     this->size = n;
//     int last = size;
//     for(int i= last; i>=0 ; i-- ){
//         this->heapify(i);
//     }
// }

// void heapify(int index){
// }

// int get_max() {
//     return heap[0];
// }

// int get_size() {
//     return this->size;
// }

// void insert(int element);
// int remove();
// };

int main() {
    int arr[] = {7, 17, 3, 5, 21, 27, 13};
    MaxHeap<int> m = MaxHeap<int>(arr);
    std::cout << m << std::endl;

    MaxHeap<int> n = MaxHeap<int>();
    for (auto var : arr) {
        n.insert(var);
    }
    std::cout << n << std::endl;

    m.remove();
    std::cout << m << std::endl;
}
