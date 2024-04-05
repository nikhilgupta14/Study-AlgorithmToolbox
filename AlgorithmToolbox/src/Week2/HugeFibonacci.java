import java.util.Scanner;

public class HugeFibonacci {
    /*
    Huge Fibonacci Number Problem Compute the n-th Fibonacci number modulo m.
    Input: Integers n and m.
    Output: n-th Fibonacci number modulo m.
    */

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        long fiboNumber = inputScanner.nextLong();
        long mod = inputScanner.nextLong();
        System.out.println(findFibonacci(fiboNumber, mod));
    }

    static long findFibonacci(long value, long mod){
        long prev = 0;
        long curr = 1;
        value = value % pisano(mod);

        if (value == 0)
            return 0;
        else if (value == 1)
            return 1;

        for (int i = 1; i < value; i++) {
            long tempfibo = prev;
            prev = curr;
            curr = (tempfibo + prev) % mod;
        }
        return curr%mod;
    }
    public static long pisano(long m)
    {
        long prev = 0;
        long curr = 1;
        long res = 0;

        for(int i = 0; i < m * m; i++)
        {
            long temp = 0;
            temp = curr;
            curr = (prev + curr) % m;
            prev = temp;

            if (prev == 0 && curr == 1)
                res= i + 1;
        }
        return res;
    }
}
