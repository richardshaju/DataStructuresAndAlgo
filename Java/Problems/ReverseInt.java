public class ReverseInt {
    public static int reverse(int val) {
        boolean isNegative = false;
        int temp = val;

        if (val < 0) {
            temp = Math.abs(val);
            isNegative = true;
        }

        int reversed = 0;

        while (temp != 0) {
            int digit = temp % 10;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }

        return isNegative ? -reversed : reversed;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-567));
    }
}
