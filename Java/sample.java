public class sample {

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIdx = partition(array, low, high);

            quickSort(array, low, pivotIdx-1);
            quickSort(array, pivotIdx+1, high);
        }

    }

    public static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;

        for (int j = start; j <= end; j++) {
            if(array[j] < pivot){

                i++;
                swap(array, i, j);
            }
        }
        swap(array, i+1, end);
        return i+1;
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
        quickSort(arr,0,arr.length-1);
        display(arr);
    }

}
