package recursion;

public class Task02 {
	public static void main(String[] args) {
		iterativeXMethod(1234567);
	}
	
	public static void iterativeXMethod(int n) {
		while (n > 0) {
			System.out.print(n % 10);
			n /= 10;
		}
	}

}
