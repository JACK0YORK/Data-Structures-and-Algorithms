/**
 * @file Test.java
 * @author Jackson York
 * @brief Test functions with sample main() for Exam 1 for Data Structures and Algorithms
 * @date 2021-02-25
 */

public class Test {

    public static void testq1() {
        Question1.Array<Integer> a = new Question1.Array<Integer>(new Integer[] { 5, 2, 3, 1, 4 }, 5);
        a.println();
        a.remove_at(2);
        a.println();
        a.insert_at(2, 1);
        a.println();
        a.filter((Integer x) -> {
            return x % 2 == 0;
        }).println();
        System.out.println("a.size()\t\t\t" + a.size());
        System.out.println("a.index_of(4)\t\t\t" + a.index_of(4));
        System.out.println("a.index_of(7)\t\t\t" + a.index_of(7));
        System.out.println("a.is_empty()\t\t\t" + a.is_empty());
        System.out.print("a.filter((x)->{x%2==0})\t\t");
        a.filter((Integer x) -> {
            return x % 2 == 0;
        }).println();
        Question1.Array<Integer> temp = new Question1.Array<Integer>(3);
        temp.print();
        System.out.println(".is_empty()\t" + temp.is_empty());
        System.out.println("a.is_equal(temp)\t\t" + a.is_equal(temp));
        temp = new Question1.Array<Integer>(new Integer[] { 5, 2, 1, null, 4 }, 5);
        System.out.print("a.is_equal(");
        temp.print();
        System.out.println(")\t" + a.is_equal(temp));
        temp = a.shuffle();
        temp.println();
        temp.sort().println();
        temp.slice(1, 3).println();
    }

    private static void print(int[] A) {
        System.out.print("[" + A[0]);
        for (int i = 1; i < A.length; i++) {
            System.out.print(", " + A[i]);
        }
        System.out.print("]");
    }

    public static void testq2() {
        int n = 4;
        int A[] = new int[] { 1, 3, 5, 7 };
        System.out.print("A = ");
        print(A);
        System.out.println();
        for (int i = -3; i < 10; i++) {
            System.out.print("is_k_bit_int_not_in_A(" + i + ", A, " + n + ")  \t-> ");
            System.out.println(Question2.is_k_bit_int_not_in_A(i, A));
        }
    }

    public static void testq3() {
        int test[] = { 2, 3, 1, -4, -5 };
        System.out.print("find_unformable(");
        print(test);
        System.out.print(") -> \t");
        System.out.println(Question3.find_unformable(test));
    }

    public static void testq4() {
        int pivot = 2;
        int A[] = { 5, 3, 2, 4, 1 };
        System.out.print("rearrange_around_pivot(A, pivot)" + "\n\tA = ");
        print(A);
        System.out.print(",\tpivot = " + pivot + "\t-> ");
        Question4.rearrange_around_pivot(A, pivot);
        pivot = 3;
        print(A);
        System.out.print("\n\tA = ");
        print(A);
        System.out.print(",\tpivot = " + pivot + "\t-> ");
        Question4.rearrange_around_pivot(A, pivot);
        pivot = 4;
        print(A);
        System.out.print("\n\tA = ");
        print(A);
        System.out.print(",\tpivot = " + pivot + "\t-> ");
        Question4.rearrange_around_pivot(A, pivot);
        print(A);
        System.out.println();
    }

    public static void testq5() {
        Question5.String this_str = new Question5.String(new Character[] { 'F', 'o', 'o' });
        Question5.String other_str = new Question5.String(new Character[] { ' ', ' ', ' ', 'B', 'a', 'r' });
        System.out.print("this        -> \t");
        this_str.print();
        System.out.println();
        System.out.print("other       -> \t");
        other_str.print();
        System.out.println();
        System.out.println("strlen()    -> \t" + this_str.strlen());
        System.out.print("strlwr()    -> \t");
        this_str.strlwr().print();
        System.out.println();
        System.out.print("strlwr()    -> \t");
        this_str.strupr().print();
        System.out.println();
        System.out.print("other       -> \t");
        other_str.print();
        System.out.println();
        System.out.print("strcat(o)   -> \t");
        this_str.strcat(other_str).print();
        System.out.println();
        System.out.print("other       -> \t");
        other_str.print();
        System.out.println();
        System.out.println("strcpy(o)   -> \t" + this_str.strcpy(other_str));
        System.out.print("other       -> \t");
        other_str.print();
        System.out.println();
        System.out.println("o.strcpy(t) -> \t" + other_str.strcpy(this_str));
        System.out.print("this        -> \t");
        this_str.print();
        System.out.println();
        System.out.println("strcmp(o)   -> \t" + this_str.strcmp(other_str));
        System.out.println("strcmp(t)   -> \t" + this_str.strcmp(this_str));
        System.out.println("strcmp(\" \") -> \t" + this_str.strcmp(new Question5.String(new Character[] { ' ' })));
    }

    public static void main(String[] args) {
        System.out.println("\n\nQUESTION 1 TEST OUTPUT");
        testq1();
        System.out.println("\n\nQUESTION 2 TEST OUTPUT");
        testq2();
        System.out.println("\n\nQUESTION 3 TEST OUTPUT");
        testq3();
        System.out.println("\n\nQUESTION 4 TEST OUTPUT");
        testq4();
        System.out.println("\n\nQUESTION 5 TEST OUTPUT");
        testq5();
    }
}