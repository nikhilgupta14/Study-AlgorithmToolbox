import java.util.Scanner;

public class APlusB {
    public static void main(String[] args) {
        sum();
    }

    static int sum() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(a+b);
        return a+b;
    }
}


