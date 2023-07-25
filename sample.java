import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class sample {
    List<Integer> heap = new ArrayList<>();

    public void insert(int data) {
        heap.add(data);
        for (int i = parent(heap.size() - 1); i >= 0; i--) {
            shiftDown(i);
        }
    }

    public void shiftDown(int currentIdx) {
        int leftIdx = leftChild(currentIdx);
        int endIndx = heap.size() - 1;
        while (leftIdx <= endIndx) {
            int rightIdx = rightChild(currentIdx);
            int idxToShift;
            if (rightIdx <= endIndx && heap.get(leftIdx) > heap.get(rightIdx)) {
                idxToShift = rightIdx;
            } else {
                idxToShift = leftIdx;
            }
            if (heap.get(currentIdx) > heap.get(idxToShift)) {
                Collections.swap(heap, currentIdx, idxToShift);
                currentIdx = idxToShift;
                leftIdx = leftChild(currentIdx);
            }else{
                return;
            }
        }
    }

    private int leftChild(int i) {
        return (i * 2) + 1;
    }

    private int rightChild(int i) {
        return (i * 2) + 2;
    }

    private int parent(int value) {
        return (value - 1) / 2;
    }

    public void display() {
        for (int i = 0; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
    }

     public static void main(String[] args) {
   
        sample heap = new sample();
        heap.insert(99);
        heap.insert(10);
        heap.insert(60);
        heap.insert(8888);
        heap.insert(999);
        heap.insert(333);
        heap.insert(42);
        heap.insert(25);
        heap.insert(6);
        heap.insert(1000);
        heap.display();

    }
}
