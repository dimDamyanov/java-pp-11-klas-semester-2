package recursion;

import java.util.Scanner;

public class Task05 {
	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number (n): ");
		n = scanner.nextInt();
		scanner.close();
		
		System.out.printf("Number in binary: %s", dec2Bin(n));
	}
	
	public static String dec2Bin(int value) {
		if (value == 1)
			return "1";
		else
			return dec2Bin(value / 2) + String.format("%d", value % 2);
	}
}
