package recursion;

public class Task01 {
	public static void main(String[] args) {
		System.out.println("Sum is " + iterativeXMethod(5));
	}
	
	public static int iterativeXMethod(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++)
			sum += i;
		return sum;
	}

}
