package stacksAndQueues;

import java.util.Scanner;

public class Task01 {
	public static void main(String[] args) {
		final String oppeningBrackets = "([{";
		final String closingBrackets = ")]}";
		boolean isValid = true;
		Scanner scanner = new Scanner(System.in);
		String brackets;
		brackets = scanner.next();
		scanner.close();
		
		StackOfChars stackOfChars = new StackOfChars();
		for (int i = 0; i < brackets.length(); i++) {
			if (oppeningBrackets.indexOf(brackets.charAt(i)) != -1) {
				stackOfChars.push(brackets.charAt(i));
			}
			else if (closingBrackets.indexOf(brackets.charAt(i)) != -1) {
				if (stackOfChars.empty() || closingBrackets.indexOf(brackets.charAt(i)) != oppeningBrackets.indexOf(stackOfChars.pop())) {
					isValid = false;
					break;
				}
			}
		}
		
		if (isValid && stackOfChars.empty())
			System.out.println("valid");
		else
			System.out.println("invalid");
	}
}
