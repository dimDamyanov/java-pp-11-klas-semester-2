package tailRecursion;

import java.util.Scanner;

public class Task04 {
	public static void main(String[] args) {
		double x;
		int n;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter base (x): ");
		x = scanner.nextDouble();
		System.out.print("Enter power (n): ");
		n = scanner.nextInt();
		scanner.close();

		System.out.printf("Recursive result: %.2f\n", powerRecursive(x, n));
	}

	public static double powerRecursive(double x, int n) {
		return powerRecursive(x, n, 1);
	}

	private static double powerRecursive(double x, int n, double a) {
		if (n == 0)
			return a;
		else
			return powerRecursive(x, n - 1, a * x);
	}
}
