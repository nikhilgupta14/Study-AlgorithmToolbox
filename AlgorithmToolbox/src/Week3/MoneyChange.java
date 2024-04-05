import java.util.Scanner;

public class MoneyChange {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int money = input.nextInt();

        int coins = 0;
        while (money > 0) {
            if (money >= 10) {
                coins++;
                money = money - 10;
            } else if (money >= 5) {
                coins++;
                money = money - 5;
            } else {
                coins++;
                money = money - 1;
            }
        }
        System.out.println(coins);
    }


}
