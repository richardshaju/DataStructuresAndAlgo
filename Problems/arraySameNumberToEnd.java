public class arraySameNumberToEnd {
    public static int[] SameNumberToEnd(int[] array, int target) {
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[j] == target) {
                j--;
            }
            if (array[i] == target) {
                swap(array, i, j);
            }
            i++;
        }
        return array;
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
        int[] arr = { 7, 0, 6, 2, 6, 1, 7, 6, 2, 4, 2 };
        int target = 6;
        display(SameNumberToEnd(arr, target));

    }
}
