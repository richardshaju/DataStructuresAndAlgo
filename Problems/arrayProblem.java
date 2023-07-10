//To find the two numbers in array which sums particular number

public class arrayProblem {
    public static int[] find(int[] array, int target) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j <= array.length - 1; j++) {
                if (array[i] + array[j] == target) {
                    return new int[] { array[i], array[j] };
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5, 6, 9 };
        int target = 6;
        int[] result = find(arr, target);
        System.out.print(result[0] + " + " + result[1] + " = " + target);
    }
}
