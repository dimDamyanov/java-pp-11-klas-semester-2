package stacksAndQueues04;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Task02 {
    public static class TrafficSign {
        public int position;
        public int speedLimit;

        public TrafficSign(int position, int speedLimit) {
            this.position = position;
            this.speedLimit = speedLimit;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int distance = scanner.nextInt();
        int distanceTravelled = 0;
        double time = 0;
        scanner.nextLine();
        String line = scanner.nextLine();
        Stack<TrafficSign> signs = new Stack<>();
        while(!line.equalsIgnoreCase("stop")) {
            List<Integer> tokens = Arrays.stream(line.split(" ")).map(Integer::valueOf).toList();
            TrafficSign currentSign = new TrafficSign(tokens.get(0), tokens.get(1));
            if (currentSign.speedLimit == -1) {
                TrafficSign previousSign = signs.pop();
                time += (double) (currentSign.position - distanceTravelled) / previousSign.speedLimit;
                distanceTravelled = currentSign.position;
            }
            else {
                if (signs.isEmpty()) {
                    time += (double) (currentSign.position - distanceTravelled) / 80;
                }
                else {
                    time += (double) (currentSign.position - distanceTravelled) / signs.peek().speedLimit;
                }
                distanceTravelled = currentSign.position;
                signs.push(currentSign);
            }
            line = scanner.nextLine();
        }
        time += (double) (distance - distanceTravelled) / 80;
        System.out.printf("%.2f\n", time);
    }
}
