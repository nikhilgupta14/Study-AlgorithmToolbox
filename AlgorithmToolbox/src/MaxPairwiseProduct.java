import java.util.Arrays;
import java.util.Scanner;

public class MaxPairwiseProduct {

    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);
        int n = number.nextInt();
        long[] numbers = new long[n];
        for (int i=0; i<n; i++) {
            numbers[i] = number.nextInt();
        }
        System.out.println(getMaxPairWiseResult(numbers, n));
    }

    static long getMaxPairWiseResult(long[] numbers, int length) {
        Arrays.sort(numbers);
        return numbers[length-1] * numbers[length-2];
    }

}

