package formatAndEnum;

public class Task01 {
	public static void main(String[] args) {
		System.out.print("i          m(i)\n-----------------\n");
		double sum = 0;
		for(int i = 1; i <= 20; i++) {
			sum += (double) i / (i + 2);
			System.out.printf("%-2d%15.4f\n", i, sum);
		}
	}
}
