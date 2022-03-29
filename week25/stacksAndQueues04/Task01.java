package stacksAndQueues04;

import java.util.Scanner;
import java.util.Stack;

public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.nextLine();

        Stack<Character> row = new Stack<>();
        for(int i = 0; i < sequence.length(); i++) {
            char currentCharacter = sequence.charAt(i);
            if (currentCharacter == 'R')
                row.push(currentCharacter);
            else if (currentCharacter == 'L') {
                if (!row.isEmpty() && row.peek() == 'R')
                    row.pop();
                else
                    row.push(currentCharacter);
            }
        }
        System.out.println(row.size());
    }
}
