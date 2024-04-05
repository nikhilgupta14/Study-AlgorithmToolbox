package Week3;

import java.util.Scanner;

public class CarFueling {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalDistance = input.nextInt();
        int maxBurn = input.nextInt();
        int totalStation = input.nextInt();
        int[] stationAtDistance = new int[totalStation];
        int totalRefuel = 0;
        for (int i = 0; i < totalStation; i++) {
            stationAtDistance[i] = input.nextInt();
        }

        if (totalDistance < maxBurn) {
            System.out.println(totalRefuel);
        }
        int nextStop = 0;
        int stopIndex = 0;
        while (totalDistance >= 0){
            for (int i=0; i < stationAtDistance.length; i++) {
                if (stationAtDistance[i] > (totalDistance - maxBurn)) {
//                System.out.println("Impossible"); // something to write here to control -1
                    nextStop = stationAtDistance[i];
                    stopIndex = i;
                    totalRefuel++;
                }
            }
            totalDistance = totalDistance-maxBurn;
        }

        System.out.println("TotalRefuel: "+totalRefuel);
    }
}
