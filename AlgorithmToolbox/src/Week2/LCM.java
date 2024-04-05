import java.util.Scanner;

public class LCM {
    private static long lcm_naive(int a, int b) {
        for (long l = 1; l <= (long) a * b; ++l)
            if (l % a == 0 && l % b == 0)
                return l;

        return (long) a * b;
    }


    private static long lcm_fast(int a, int b) {
        int reminder = gcd(a,b);

        return ((long) (a / reminder) *(b/reminder))*reminder;
    }

    private static int gcd(int a, int b) {
        int result = a%b;
        if (result == 0){
            return b;
        }
        return gcd(b, result);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(lcm_fast(a, b));
    }
}
