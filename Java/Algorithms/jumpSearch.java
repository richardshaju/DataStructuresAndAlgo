public class jumpSearch {

    public static int search(int[] array, int target) {
        int pointer = 0;
        int distance = (int) (Math.sqrt(array.length)) - 1;
        for (pointer = 0; pointer <= array.length - 1; pointer += distance) {
            if (array[pointer] > target) {
                break;
            }
        }
        int checker = pointer - distance;
        while (checker != pointer) {
            if (array[checker] == target) {
                return checker;
            }
            checker++;
        }
        return -1;
    }


    public static void main(String[] args) {
        int array[] = {1,23,45,55,56,99,100};

        System.out.println(search(array, 99)); 

    }
}
