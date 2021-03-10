/**
 * @file Question1.java
 * @author Jackson York
 * @brief Question 1 on Exam 1 for Data Structures and Algorithms
 * @date 2021-02-25
 */

import java.lang.Math;
public class Question1 {
    public interface FunctionalInterface<T> {
        boolean call(T value);
    }

    public static class Array<T extends Comparable<T>> {
    
        private int length;
        private T[] data;
    
        // runtime = 2
        @SuppressWarnings("unchecked")
        public Array(int length) {
            this.data = (T[]) new Comparable[length]; // 1
            this.length = length; // 1
        };
    
        // runtime = 3n+4
        @SuppressWarnings("unchecked")
        public Array(T[] arr, int n) {
            this.data = (T[]) new Comparable[n]; // 1
            for (int i = 0; i < n; i++) // 2n+2
            {
                this.data[i] = arr[i]; // n
            }
            this.length = n; // 1
        };
    
        // runtime = 3n+4
        @SuppressWarnings("unchecked")
        public Array(T arr[]) {
            this.data = (T[]) new Comparable[arr.length];
            for (int i = 0; i < arr.length; i++) {
                this.data[i] = arr[i];
            }
            this.length = arr.length;
        };
    
        /**
         * @note runtime = 3n+3 = O(n)
         * 
         * @brief is the array all null values
         * 
         * @return whether the array is empty
         */
        public boolean is_empty() {
            for (int i = 0; i < length; i++) // 2n+2
                if (data[i] != null) // n
                    return false;
            return true; // 1
        };
    
        /**
         * @note runtime = 3n+4 = O(n)
         * 
         * @brief are all elements in each array equal?
         * 
         * @param other Array to check
         * @return whether all elements in this equal all elements in other
         */
        public boolean is_equal(Array<T> other) {
            if (this.length != other.length)
                return false;
            for (int i = 0; i < this.length; i++)
                if (this.data[i] != other.data[i])
                    return false;
            return true;
        };
    
        /**
         * @note runtime = 1 = O(1)
         * 
         * @brief replaces the value at index with value.
         * 
         * @param index at which to insert
         * @param value to insert
         * @return (void)
         */
        public void insert_at(int index, T value) {
            this.data[index] = value;
        };
    
        /// runtime = 1, O(1)
        public T at(int index) {
            return this.data[index];
        };
    
        /**
         * @note runtime = 7n+n*runtime(f)+10 = O(n) if f~O(1) = O(n*O(f)) else
         * 
         * @brief filters elements by the result of f
         * 
         * @param f test function
         * @return Array<T>* of elements where f(T value) returned true.
         */
        @SuppressWarnings("unchecked")
        public Array<T> filter(FunctionalInterface<T> f) {
            T[] arr = (T[]) new Comparable[length]; // 1
            int j = 0; // 1
            for (int i = 0; i < length; i++) // 2n+2
            {
                if (f.call(this.data[i])) // n*runtime(f)
                {
                    arr[j] = this.data[i]; // n
                    j++; // n
                }
            }
            Array<T> out = new Array<T>(arr, j); // 1 + (3n+4)
            return out; // 1
        }
    
        /**
         * @note runtime = 1 = O(1)
         * 
         * @brief returns the size of the array.
         * 
         * @return int size
         */
        public int size() {
            return length;
        }
    
        /**
         * @note runtime = 1 = O(1)
         * 
         * @brief sets the value at index to null.
         * 
         * @param index value to remove.
         */
        public void remove_at(int index) {
            this.data[index] = null; // 1
        }
    
        /**
         * @note runtime = 1.5n^2 + 4.5n + 2 = O(n^2)
         * 
         * @brief removes all values that are repeats after their first appearance.
         * 
         */
        public void remove_duplicates() {
            for (int i = 0; i < length; i++) // 2n+2
            {
                if (this.data[i] != null) // n | worst case scenario is a list with no duplicates
                {
                    for (int j = i + 1; j < length; j++) // n*(2[(n-1)/2]+3) | since j=i+1, the average length of the
                                                         // loop is (n-1)/2
                    {
                        if (this.data[i] == this.data[j]) // n*(n-1)/2
                        {
                            // can happen a max of n-1 times because data[i]!= null, so can only act on
                            // an
                            // element after data[0] once.
                            // This max does not matter, however, because reaching it would decrease the
                            // total runtime by an order of magnitude(data[i]!= null).
                            // therefore, the worst case is a list with no repeats.
                            this.data[j] = null; // 0
                        }
                    }
                }
            }
        }
    
        /**
         * @note runtime = 4n + 4 = O(n)
         * 
         * @brief prints the array inline
         * 
         */
        public void print() {
            if (this.length == 0) // 1
            {
                System.out.print("[]");
                return;
            }
            System.out.print("[" + this.data[0]); // 2
            for (int i = 1; i < length; i++) // 2(n-1) + 2
            {
                System.out.print(", " + this.data[i]); // 2n
            }
            System.out.print("]"); // 1
        };
    
        /**
         * @note runtime = 4n + 5 = O(n)
         * 
         * @brief prints the array with a newline at the end
         * 
         */
        public void println() {
            print();
            System.out.println();
        }
    
        /// runtime = 4nlogn + 13n - 4logn + 6, O(nlogn)
        private void quicksort(T[] array, int low_index, int high_index) {
            if (low_index < high_index) // 2n-1 | n-1 for each split, n for each end
            {
                int pivot_index = partition(array, low_index, high_index); // (n-1)*(4(hi-lo) + 9) = (n - 1) * (4 log n + 9)
                quicksort(array, low_index, pivot_index); // n-1
                quicksort(array, pivot_index + 1, high_index); // n-1
            }
        }
    
        /// runtime = 4n + 8 | n = hi - lo
        private int partition(T[] array, int low_index, int high_index) {
            T pivot_value = array[(high_index + low_index) / 2]; // 3
            int i = low_index - 1; // 2
            int j = high_index + 1; // 2
            while (true) {
                do
                    i++; // n/2
                while (array[i].compareTo(pivot_value) < 0); // n/2
                do
                    j--; // n/2
                while (array[j].compareTo(pivot_value) > 0); // n/2
    
                if (i >= j) // n/2
                    return j; // 1
    
                T temp = array[i]; // n/2
                array[i] = array[j]; // n/2
                array[j] = temp; // n/2
            }
        }
    
        /**
         * @note runtime = 4nlogn + 16n - 4logn + 12 = O(nlogn)
         * 
         * @brief sorts the array using the quicksort algorithm
         * 
         * @return sorted array
         */
        public Array<T> sort() {
            Array<T> out = new Array<T>(this.data, this.length); // 3n+5
            quicksort(out.data, 0, out.length - 1); // 4nlogn + 13n - 4logn + 6, O(nlogn)
            return out; // 1
        };
    
        /**
         * @note runtime = 3n+3 = O(n)
         * 
         * @brief searches for a value and returns the index.
         * 
         * @param value to find
         * @return int
         */
        int index_of(T value) {
            for (int i = 0; i < this.length; i++) // 2n+2
                if (this.data[i].compareTo(value) == 0) // n
                    return i;
            return -1; // 1
        };
    
        /**
         * @note runtime = 14n + 12 = O(n)
         * 
         * @brief shuffles the values in this array.
         * 
         * @return Array<T>* containing the randomly shuffled values
         */
        Array<T> shuffle() {
            Array<T> out = new Array<T>(this.data, this.length); // 3n+5
            int seed = (int) (System.currentTimeMillis()%Integer.MAX_VALUE); // 4
            for (int i = 0; i < out.length - 2; i++) // 2n+2
            {
                int random = (int)(Math.random() * seed)%(out.length-i) + i; // 6n
                T temp = out.data[i]; // n
                out.data[i] = out.data[random]; // n
                out.data[random] = temp; // n
            }
            return out; // 1
        };
    
        /**
         * @note runtime = 4n + 7
         * @brief Returns the slice of the array in the range [min, max)
         * 
         * @param min lowest index to include (inclusive)
         * @param max highest index to include (exclusive)
         * @return Array<T>* containing the values of this in the range [min, max)
         */
        Array<T> slice(int min, int max) {
            Array<T> out = new Array<T>(max - min); // 4
            for (int i = min; i < max; i++) // 2n+2
                out.data[i - min] = this.data[i]; // 2n
            return out; // 1
        };
    
    }
    
}
