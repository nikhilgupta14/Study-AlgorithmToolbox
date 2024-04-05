package Week3;

import java.util.Scanner;

public class fractional_knapsack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalCompounds = input.nextInt();
        long capacity = input.nextLong();
        long knapsack = 0;
        long[] cost = new long[totalCompounds];
        long[] weight = new long[totalCompounds];
        double[] actualweight = new double[totalCompounds];
        double result = 0;
        for (int i = 0; i < totalCompounds; i++) {
            cost[i] = input.nextInt();
            weight[i] = input.nextInt();
            actualweight[i] = (double) cost[i] / weight[i];
        }

        int maxIndex = findMaxIndex(actualweight);

        while (knapsack != capacity) {
            if (weight[maxIndex] > capacity) {
                knapsack = capacity;
                result = result + actualweight[maxIndex] * capacity;
            } else {
                knapsack = knapsack + weight[maxIndex];
                result = result + cost[maxIndex];
                cost[maxIndex] = -1;
                weight[maxIndex] = -1;
                actualweight[maxIndex] = -1;
                maxIndex = findMaxIndex(actualweight);
            }
        }
        System.out.printf("%.4f", result);
    }

    static int findMaxIndex(double[] actualweight) {
        int temp = 0;
        for (int i = 0; i < actualweight.length; i++) {
            if (actualweight[i] > actualweight[temp]) {
                temp = i;
            }
        }
        return temp;
    }
}