public class InsertSort {
    public static void sort(int array[]) {
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                array[j] = current;
                j--;
            }

        }
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
        int[] arr = { 54, 2, 66, 1, 888, 0 };
        display(arr);
        sort(arr);
        display(arr);

    }
}
