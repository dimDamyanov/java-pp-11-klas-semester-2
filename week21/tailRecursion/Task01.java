package tailRecursion;

import java.util.Scanner;

public class Task01 {
	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		scanner.close();
		System.out.print(apple(n));
	}
	
	public static int apple(int n) {
		if (n == 1)
			return 1;
		else if (n == 2)
			return 2;
		else if (n % 3 == 0)
			return 3 * apple(n / 3) + 1;
		else if (n % 3 == 1)
			return apple(n-1) + 1;
		else
			return apple(n - 2) + 2;
	}
}
