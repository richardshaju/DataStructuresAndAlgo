
import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr) {
        // Base case: If the array has only one element or is empty, it's already sorted
        if (arr.length <= 1) {
            return;
        }

        // Step 1: Divide the array into two halves
        int mid = arr.length / 2;
        int[] leftHalf = Arrays.copyOfRange(arr, 0, mid);
        int[] rightHalf = Arrays.copyOfRange(arr, mid, arr.length);

        // Recursively sort the two halves
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        // Step 2: Merge the sorted halves
        merge(arr, leftHalf, rightHalf);


    }

    public static void merge(int[] arr, int[] left, int[] right) {

        int leftIndex = 0, rightIndex = 0, index = 0;

        // Step 3: Merge the sorted arrays
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                arr[index] = left[leftIndex];
                leftIndex++;
            } else {
                arr[index] = right[rightIndex];
                rightIndex++;
            }
            index++;
        }

        // Add the remaining elements from both arrays (if any)
        while (leftIndex < left.length) {
            arr[index] = left[leftIndex];
            leftIndex++;
            index++;
        }

        while (rightIndex < right.length) {
            arr[index] = right[rightIndex];
            rightIndex++;
            index++;
        }



    }

    public static void main(String[] args) {
        int[] inputArray = { 6, 9, 3 };

        System.out.println("Input Array: " + Arrays.toString(inputArray));

        mergeSort(inputArray);

        System.out.println("Sorted Array: " + Arrays.toString(inputArray));
    }
}
