package Week2;

import java.util.Scanner;

public class FibonacciLastDigit {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int input = inputScanner.nextInt();
        System.out.println(findFibonacci(input));
    }

    static long findFibonacci(int value){
        long prev = 0;
        long curr = 1;
        value = value % 60;

        if (value == 0) {
            return 0;
        }
        else if (value == 1){
            return 1;
        }
        for (int i = 1; i < value; i++) {
            long tempfibo = prev;
            prev = curr;
            curr = tempfibo + prev;
        }
        return curr%10;
    }
}