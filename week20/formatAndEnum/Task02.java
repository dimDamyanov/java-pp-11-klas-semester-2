package formatAndEnum;

public class Task02 {
	public static void main(String[] args) {
		System.out.print("i           m(i)\n------------------\n");
		for (int i = 1; i < 1000; i += 100) {
			System.out.printf("%-3d%15.4f\n", i, calculateSeries(i));
		}
	}
	
	public static double calculateSeries(int n) {
		double result = 0;
		for(int i = 1; i <= n; i++) {
			if (i % 2 == 0)
				result -= (double) 1 / (2 * i - 1);
			else
				result += (double) 1 / (2 * i - 1);
		}
		return 4 * result;
	} 
}
