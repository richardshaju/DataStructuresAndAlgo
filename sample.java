public class sample {

    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    public static void quickSortHelper(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int piovt = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            if (array[left] > array[piovt] && array[right] < array[piovt]) {
                swap(array, left, right);
                left++;
                right--;
            }
            if (array[left] <= array[piovt]) {
                left++;
            }
            if (array[right] >= array[piovt]) {
                right--;
            }
        }
        swap(array, piovt, right);
        quickSortHelper(array, start, right - 1);
        quickSortHelper(array, right + 1, end);
    }

    public static void swap(int[] array, int smallIndx, int i) {
        int temp = array[smallIndx];
        array[smallIndx] = array[i];
        array[i] = temp;
    }

    public static void display(int[] array) {
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.print(array[i] + "   ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 8, 3, 0 };
        display(arr);
        quickSort(arr);
        display(arr);
    }

}
