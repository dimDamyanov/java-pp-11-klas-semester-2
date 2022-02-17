package bigDataTypes;

import java.math.BigInteger;

public class Task02 {
	public static void main(String[] args) {
		BigInteger a = new BigInteger("1");
		BigInteger bigOne = new BigInteger("1");
		BigInteger bigTwo = new BigInteger("2");
		int n = 0;
		for (int i = 0; i < 101; i++) {
			a = a.subtract(bigOne);
			if (a.isProbablePrime(1)) {
				System.out.printf("%d: 2^%d - 1 = %s\n", n, i, a.toString());
				n++;
			}
			a = a.add(bigOne);
			a = a.multiply(bigTwo);
		}
	}
}
