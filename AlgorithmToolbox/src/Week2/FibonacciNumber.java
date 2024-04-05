import java.util.Scanner;

public class FibonacciNumber {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int input = inputScanner.nextInt();

        System.out.println(findFibonacci(input));
    }

    static int findFibonacci(int value){
        int prev = 0;
        int curr = 1;
        if (value <= 1) return value;
        for (int i = 1; i < value; i++) {
            int temp = prev;
            prev = curr;
            curr = prev+ temp;
        }


        return curr;
    }
}