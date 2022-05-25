package ss14_sort_algorithm.excrecise.algorithm_settings_insertion;

public class InsertionSort {
    public static int[] list = {9, 8, 6, 5, 3, 2, 4, 1, 7};

    public static void main(String[] args) {
        insertionSortBySteep(list);
//        System.out.println(Arrays.toString(list));
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }

    public static void insertionSortBySteep(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }
}
