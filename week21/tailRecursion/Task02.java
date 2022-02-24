package tailRecursion;

public class Task02 {
	public static void main(String[] args) {
		int x = 5, y = 15;
		System.out.printf("foo(%d, %d)= %d", x, y, foo(x, y));
	}

	public static int foo(int x, int y) {
		if (y == 0)
			return x;
		else
			return foo(y, x % y);
	}

}
