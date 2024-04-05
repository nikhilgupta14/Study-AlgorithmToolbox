import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int a = inputScanner.nextInt();
        int b = inputScanner.nextInt();
        System.out.println(gcd(a,b));
    }

    static int gcd(int a, int b) {
        int result = a%b;
        if (result == 0){
            return b;
        }
        return gcd(b, result);
    }


}
