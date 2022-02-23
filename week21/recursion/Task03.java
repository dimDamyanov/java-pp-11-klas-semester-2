package recursion;

import java.util.Scanner;

public class Task03 {
	public static void main(String[] args) {
		double x;
		int n;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter base (x): ");
		x = scanner.nextDouble();
		System.out.print("Enter power (n): " );
		n = scanner.nextInt();
		scanner.close();
		
		System.out.printf("Recursive result: %.2f\n", powerRecursive(x, n));
		System.out.printf("Iterative result: %.2f\n", powerIterative(x, n));
	}
	
	public static double powerRecursive(double x, int n) {
		if (n == 0)
			return 1;
		else
			return x * powerRecursive(x, n - 1);
	}
	
	public static double powerIterative(double x, int n) {
		double result = 1;
		for (int i = 0; i < n; i++)
			result *= x;
		return result;
	}
}
