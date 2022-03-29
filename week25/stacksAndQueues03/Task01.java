package stacksAndQueues03;

import java.util.Scanner;
import java.util.Stack;

public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.nextLine();

        Stack<Character> column = new Stack<>();
        for(int i = 0; i < sequence.length(); i++) {
            char currentChar = sequence.charAt(i);
            if (currentChar == 'O') {
                if (column.isEmpty() || column.peek() != 'T')
                    column.push(currentChar);
            }
            else if (currentChar == 'L') {
                if (!column.isEmpty() && column.peek() == 'O') {
                    do
                        column.pop();
                    while (!column.isEmpty() && column.peek() != 'O');
                }
                column.push(currentChar);
            }
            else if (currentChar == 'T')
                column.push(currentChar);
        }
        System.out.println(column.size());
    }
}
