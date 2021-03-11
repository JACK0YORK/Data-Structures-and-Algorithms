package For_Fun.lab1;
public class BinarySearch {

    public static int binary_search_r(int[] list, int value) {
        return binary_search_r(list, value, 0, list.length - 1);
    }

    public static int binary_search_r(int[] list, int value, int min_i, int max_i) {
        int med_i = (max_i + min_i) / 2;
        if (min_i > max_i)
            return -1;
        if (list[med_i] > value)
            return binary_search_r(list, value, min_i, med_i - 1);
        else if (list[med_i] < value)
            return binary_search_r(list, value, med_i + 1, max_i);
        else// (list[med] == value)
            return med_i;
    }

    public static int binary_search_i(int[] list, int value) {
        int min_i, max_i, med_i;
        min_i = 0;
        max_i = list.length;
        med_i = (min_i + max_i) / 2;
        while (list[med_i] != value) {
            if (min_i > max_i)
                return -1;
            if (list[med_i] < value)
                min_i = med_i + 1;
            else
                max_i = med_i - 1;

            med_i = (min_i + max_i) / 2;
        }
        return med_i;
    }

    public static void main(String[] args) {
        int[] list = new int[] { 1, 3, 5, 6, 32, 78, 101, 120 };
        System.out.println(binary_search_r(list, 32));
    }
}

