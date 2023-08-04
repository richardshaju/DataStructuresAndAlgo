// Divide without  /, *, % operators

import java.util.function.IntToLongFunction;

public class BitManipulation {

    public static int Divide(int dividend, int divisor) {

        if (divisor == 0) {
            throw new ArithmeticException(
                    "Divison not possible");
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isNegative = (dividend<0) ^ (divisor<0);
        int positiveDividend = Math.abs(dividend);
        int positiveDivisor = Math.abs(divisor);

        int result = 0;

        while(positiveDividend >= positiveDivisor){
            int shift = 0;
            while(positiveDividend >= (positiveDivisor<<shift)){
                shift ++;
            }
            shift --;

            positiveDividend -= positiveDivisor<<shift;
            result += 1<<shift;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Divide(0,564));
    }

}
