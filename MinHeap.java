import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MinHeap {
    List<Integer> heap = new ArrayList<>();

    public MinHeap() {

    }

    public MinHeap(List<Integer> array) {
        heap = array;
        buildHeap(heap, 0);
    }

    public void sort() {
        for (int i = 0; i <= heap.size() - 1; i++) {
            buildHeap(heap,i);
        }

    }

    private void buildHeap(List<Integer> heap, int limit) {
        for (int i = parent(heap.size() - 1) + limit; i >= limit; i--) {
            shiftDown(i, limit);
        }
    }

    private void shiftDown(int currentIdx, int limit) {
        int endIndx = heap.size() - 1;
        int leftIdx = leftChild(currentIdx) - limit; // Limit is for Sorting
        while (leftIdx <= endIndx) {
            int rightIdx = rightChild(currentIdx)  - limit;
            int idxToShift;
            if (rightIdx <= endIndx && heap.get(rightIdx) < heap.get(leftIdx)) {
                idxToShift = rightIdx;
            } else {
                idxToShift = leftIdx;
            }
            if (heap.get(currentIdx) > heap.get(idxToShift)) {
                Collections.swap(heap, currentIdx, idxToShift);
                currentIdx = idxToShift;
                leftIdx = leftChild(currentIdx)  - limit;
            } else {
                return;
            }
        }
    }

    private void shiftUp(int currentIdx) {
        int parentIdx = parent(currentIdx);
        while (currentIdx > 0 && heap.get(parentIdx) > heap.get(currentIdx)) {
            Collections.swap(heap, currentIdx, parentIdx);
            currentIdx = parentIdx;
            parentIdx = parent(currentIdx);
        }
    }

    public int peek() {
        return heap.get(0);
    }

    public void remove() {
        Collections.swap(heap, 0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        shiftDown(0,0);
    }

    public void insert(int value) {
        heap.add(value);
        shiftUp(heap.size() - 1);
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return (i * 2) + 1;
    }

    private int rightChild(int i) {
        return (i * 2) + 2;
    }

    public void display() {
        for (int i = 0; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(99, 10, 60,8888,999,333,42,25,6,1000));
        MinHeap heap = new MinHeap(array);

        heap.display();
        System.out.println();
        System.out.println(heap.peek());
        System.out.println();
        //heap.remove();
        heap.sort();
        System.out.print( "Sorted Value : ");
        heap.display();

    }
}
