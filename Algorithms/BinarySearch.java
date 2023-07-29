public class BinarySearch {
    public static int search(int[] array, int target) {

        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int middle = start + ((end - start) / 2);
            if (array[middle] == target) {
                return middle;
            } else if (array[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return -1;
    }

    public static int BinaryRec(int[] array, int target) {
        return BinaryRecHelper(array, target, 0, array.length - 1);

    }

    public static int BinaryRecHelper(int[] array, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middle = start + ((end - start) / 2);
        if (array[middle] == target) {
            return middle;
        } else if (array[middle] < target) {
           return BinaryRecHelper(array, target, middle + 1, end);
        } else {
           return BinaryRecHelper(array, target, start, middle - 1);
        }
    }

    public static void main(String[] args) {
        int array[] = { 1, 23, 45, 55, 56, 99, 100 };

        System.out.println(search(array, 55));
        System.out.println(BinaryRec(array, 23));

    }
}
