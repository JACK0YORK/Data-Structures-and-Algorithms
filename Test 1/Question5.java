/**
 * @file Question5.java
 * @author Jackson York
 * @brief Question 5 on Exam 1 for Data Structures and Algorithms
 * @date 2021-02-25
 */

public class Question5 {
    // unsafe flag
    private static class unsafe {
    };

    private static final unsafe UNSAFE = null;

    public static class String {
        Question1.Array<Character> values = null;

        /// runtime = 1
        private String(Question1.Array<Character> values, unsafe u) {
            // unsafe, uses given value array without copying
            this.values = values;
        };

        /// runtime = 3n+4
        public String(Character[] char_array) { // template allows entry of only Character[].
            this.values = new Question1.Array<Character>(char_array.length);
            for (int i = 0; i < char_array.length; i++) {
                this.values.insert_at(i, char_array[i]);
            }
        };

        /// runtime = 8n+11
        public String(Question1.Array<Character> values) {
            // copies all values by filtering with a condition of true.
            this.values = values.filter((Character __) -> {
                return true;
            });
        };
        /// runtime = 2

        /**
         * @note runtime = 2 = O(1)
         * 
         * @brief length of the string
         * 
         * @return int the length of the string
         */
        int strlen() {
            return values.size();
        }

        /**
         * @note runtime = 10n + 10 = O(n)
         * 
         * @brief converts all uppercase characters to their lowercase equivalents
         * 
         * @return String* converted string
         */
        String strlwr() {
            // setting this_len causes an order-n speedup as size() would be called in the
            // for loop.
            int this_len = this.values.size();
            Question1.Array<Character> lower_arr = new Question1.Array<Character>(this_len);
            for (int i = 0; i < this_len; i++) {
                // this can save up to 3n in runtime at face value. I could use [[gnu::pure]] to
                // cause
                // this behavior at compile time, at the expense of explicitness.
                Character c = this.values.at(i);
                // ant math is calculated at compile time. ('a' - 'A')=32 is purely for
                // readability.
                // triconditional helps with caching.
                lower_arr.insert_at(i, (char) (c + ((c >= 'A' && c <= 'Z') ? ('a' - 'A') : 0)));
            }
            // using unsafe version because upper_arr is otherwise inaccessible.
            return new String(lower_arr, UNSAFE);
        }

        /**
         * @note runtime = 10n + 10 = O(n)
         * 
         * @brief converts all lower case characters to their uppercase equivalents.
         * 
         * @return String* converted string
         */
        String strupr() {
            // see strlwr() for comments, these are identical outside of logic.
            int this_len = this.values.size();
            Question1.Array<Character> upper_arr = new Question1.Array<Character>(this.values.size());
            for (int i = 0; i < this_len; i++) {
                Character c = this.values.at(i);
                upper_arr.insert_at(i, (char) (c - ((c >= 'a' && c <= 'z') ? ('a' - 'A') : 0)));
            }
            return new String(upper_arr, UNSAFE);
        }

        /**
         * @note runtime = 4m+5p + 13 | m := this_len, p := other_len = 9n + 13 | n :=
         *       (4m + 5p) / 9 = (weighted) average length of input strings = O(n)
         * 
         * @brief appends the given string to the end of this string
         * 
         * @param other string to append
         * @return String* containing the concatenated string
         */
        String strcat(String other) {
            // setting this_len, other_len causes an order-n speedup as size() would be
            // called in the for loop.
            int this_len = this.values.size();
            int other_len = other.values.size();
            Question1.Array<Character> concat_arr = new Question1.Array<Character>(this_len + other_len);
            for (int i = 0; i < this_len; i++)
                concat_arr.insert_at(i, this.values.at(i));
            for (int i = 0; i < other_len; i++)
                concat_arr.insert_at(this_len + i, other.values.at(i));
            return new String(concat_arr, UNSAFE);
        }

        /**
         * @note runtime = 4n + 7 = O(n)
         * 
         * @brief copies this string into the destination string
         * 
         * @param dest_str the destination string
         * @return boolean whether the copy succeeded
         */
        boolean strcpy(String dest_str) {
            int this_len = this.values.size(); // 2
            if (this_len > dest_str.values.size()) // 2
                return false; // cannot copy string to other.
            for (int i = 0; i < this_len; i++) // 2n+2
                dest_str.values.insert_at(i, this.values.at(i)); // 2n
            return true; // 1
        }

        /**
         * @note runtime = 10n + 13 = O(n)
         * 
         * @brief compares this with other, returning 0 if equal, 1 if greater than, -1
         *        if less than
         * 
         * @param other string to compare
         * @return int ( == 0; > 1; < -1 )
         */
        int strcmp(String other) {
            int this_len = this.values.size();
            int other_len = other.values.size();
            for (int i = 0; i < this_len && i < other_len; i++)
                if (this.values.at(i) < other.values.at(i))
                    return -1;
                else if (this.values.at(i) > other.values.at(i))
                    return 1;
            return this_len == other_len ? 0 : (this_len > other_len ? 1 : -1);
        }

        public void print() {
            int this_len = this.values.size();
            System.out.print("\"");
            for (int i = 0; i < this_len; i++)
                System.out.print(this.values.at(i));
            System.out.print("\"");
        }
        // friend std::ostream &operator<<(std::ostream &o, String s);
    };
}
