import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HeapSort {

    static List<Integer> heap = new ArrayList<>();

    public static void sort(List<Integer> array) {
        heap = array;
        int size = array.size();
        for (int i = size - 1; i >= 0; i--) {
           // Collections.swap(heap, 0, i);
            heapify(heap, i);
        }
    }

    public static void heapify(List<Integer> array, int size) {
        int endIdx = size;
        int current = (size - 1) / 2;
        int leftIdx = (endIdx * 2) + 1;
        while (leftIdx <= endIdx) {
            int rightIdx = (endIdx * 2) + 2;
            int idxToShift;
            if (rightIdx <= endIdx && array.get(rightIdx) < array.get(leftIdx)) {
                idxToShift = leftIdx;
            } else {
                idxToShift = rightIdx;
            }

            if (array.get(idxToShift) > array.get(current)) {
                Collections.swap(array, current, idxToShift);
                current = idxToShift;
                leftIdx = (current * 2) + 1;
            }
        }
        current--;

    }

    public static void display(List<Integer> array){
        for(int i = 0;i<array.size();i++){
            System.out.print(array.get(i) + " ");
            
        }
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(99, 10, 60, 8888, 999, 333, 42, 25, 6, 1000));
        display(array);
        sort(array);
        System.out.println();
        display(array);

    }
}
