
class MaxHeap<T extends Comparable<T>> {
    // Instance Variables
    private T[] heap = null;
    private int length = 0;
    private int last = -1;

    // Private Static Methods
    private static int root() {
        return 0;
    }

    private static int up(int child) {
        return (child - 1) / 2;
    }

    private static int left(int root) {
        return 2 * root + 1;
    }

    private static int right(int root) {
        return 2 * root + 2;
    }

    // Private Instance Methods
    private boolean isLeaf(int root) {
        final int left = left(root);
        final int right = right(root);
        return left > last || (heap[left] == null && heap[right] == null);
    }

    private int posOfMax(int indices[]) {
        int max_i = indices[0];
        T max_T = heap[max_i];

        for (int i = 1; i < indices.length; i++) {
            final int index = indices[i];
            final T value = heap[index];

            if (value != null && max_T.compareTo(value) < 0) {
                max_i = index;
                max_T = value;
            }
        }

        return max_i;
    }

    private void swap(int a, int b) {
        T temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    @SuppressWarnings("unchecked")
    private void grow(int desired_index) {
        if (desired_index >= length) {
            length = right(length - 1) + 1;
            T temp[] = (T[])new Comparable[length];
            for (int i = 0; i <= last; i++) {
                temp[i] = heap[i];
            }
            heap = temp;
        }
    }

    private int heapify(int root) {
        if (isLeaf(root))
            return 0; // No change if leaf

        final int pos_of_max = this.posOfMax(new int[] { root, left(root), right(root) });

        if (pos_of_max != root) {
            this.swap(pos_of_max, root);
            return pos_of_max;
        }
        return 0; // no swap necessary
    }

    // Construtors
    @SuppressWarnings("unchecked")
    public MaxHeap() {
        this.last = -1;

        this.length = 3;

        this.heap = (T[])new Comparable[this.length];
    }

    @SuppressWarnings("unchecked")
    MaxHeap(T array[]) {
        this.last = array.length - 1;

        this.length = 0;
        while (this.length < this.last) {
            this.length = right(this.length);
        }
        this.length++;

        this.heap = (T[])new Comparable[this.length];

        for (int i = 0; i < array.length; i++) {
            this.heap[i] = array[i];
        }
        for (int i = array.length - 1; i >= 0; i--) {
            int swapped = heapify(i);
            while (swapped != 0)
                swapped = heapify(swapped);
        }
    }

    // Public Instance Methods
    T getMax() {
        return heap[0];
    }

    int getSize() {
        return length;
    }

    void insert(T key) {
        grow(last + 1);
        last++;
        heap[last] = key;

        int ancestor = up(last);
        while (heapify(ancestor)!=0) {
            // std::cout << " ";
            // tree_tools::tree_draw(heap, length, ancestor, " ");
            ancestor = up(ancestor);
        }
        ;
    }

    T remove() {
        if (last < 0) {
            throw new IndexOutOfBoundsException("cannot remove from empty heap.");
        }
        T out = heap[0];
        heap[0] = heap[last];
        heap[last] = null;
        last--;

        int swapped = heapify(0);
        while (swapped!=0) {
            swapped = heapify(swapped);
        }
        return out;
    }

    public String toString() {
        String out = "Heap: \n";
        out+=(heap[left(root())] != null || heap[right(root())] != null) ? "┬" : "─";
        out += tree_draw(root(), "");
        return out;
    }

    private String draw_branch(int head, String lpad, boolean end) {
        String out = lpad + (end ? "└" : "├");
        if (heap[head] == null) {
            out += "─\n";
        } else if (isLeaf(head)) {
            T value = heap[head];
            out += "─" + value + "\n";
        } else {
            out += "┬" + tree_draw(head, lpad + (end ? " " : "│"));
        }
        return out;
    }

    private String tree_draw(int head, String lpad) {
        String out = ""+heap[head]+"\n";
        if (!isLeaf(head)) {
            out += draw_branch(left(head), lpad, false);
            out += draw_branch(right(head), lpad, true);
        }
        return out;
    }

    public static void main(String[] args) {
        Integer arr[] = { 7, 17, 3, 5, 21, 27, 13 };
        MaxHeap<Integer> m = new MaxHeap<Integer>(arr);
        System.out.println(m);

        MaxHeap<Integer> n = new MaxHeap<>();
        for (Integer var : arr) {
            n.insert(var);
        }
        System.out.println(n);

        m.remove();
        System.out.println(m);
    }
};

// class Max_Heap{
// public:
// int size = 5;
// int *heap = new int[size];

// void maxheap_fromArray(int arr[], int n){
// this.heap = arr;
// this.size = n;
// int last = size;
// for(int i= last; i>=0 ; i-- ){
// this.heapify(i);
// }
// }

// void heapify(int index){
// }

// int get_max() {
// return heap[0];
// }

// int get_size() {
// return this.size;
// }

// void insert(int element);
// int remove();
// };

// int main() {
// int arr[] = {7, 17, 3, 5, 21, 27, 13};
// MaxHeap<int> m = MaxHeap<int>(arr);
// std::cout << m;

// MaxHeap<int> n = MaxHeap<int>();
// for (auto var : arr) {
// n.insert(var);
// }
// std::cout << n;

// m.remove();
// std::cout << m;
// }
