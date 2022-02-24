package tailRecursion;

import java.util.Scanner;

public class Task05 {
	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter size of array (n): ");
		n = scanner.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.printf("array[%d]= ", i);
			array[i] = scanner.nextInt();
		}
		scanner.close();
		System.out.printf("Arithmetic mean of array: %.2f", arithmeticMeanRecursive(array, n));
	}

	public static double arithmeticMeanRecursive(int[] array, int n) {
		return arithmeticMeanRecursive(array, n, 0, n - 1);
	}

	private static double arithmeticMeanRecursive(int[] array, int n, double s, int i) {
		if (i == -1)
			return s / n;
		else
			return arithmeticMeanRecursive(array, n, s + array[i], i - 1);
	}
}
