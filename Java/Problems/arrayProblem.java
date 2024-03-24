//To find the two numbers in array which sums particular number

import java.util.Hashtable;

public class arrayProblem {
    // Time complexcity O(n^2)
    
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

    // With lower time complexcity O(n)

    public static int[] find_2(int[] array, int target) {
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        String s = String.valueOf(array[0]);
        hashtable.put(s, array[0]);
        for (int i = 1; i <= array.length - 1; i++) {
            int sumMinusTarget = target - array[i];
            s = String.valueOf(sumMinusTarget);
            if (hashtable.containsKey(s)) {
                return new int[] { array[i], sumMinusTarget };
            }
            String newKey = String.valueOf(array[i]);
            hashtable.put(newKey, array[i]);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] arr = { 0, 2, 1, 8, 10, 9, 4, 3, 2 };
        int target = 10;
        int[] result = find_2(arr, target);
        System.out.print(result[0] + " + " + result[1] + " = " + target);
    }
}
