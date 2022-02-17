package bigDataTypes;

import java.math.BigInteger;

public class Task01 {
	public static void main(String[] args) {
		BigInteger a = new BigInteger(Long.toString(Long.MAX_VALUE));
		int n = 0;
		while (n < 5) {
			a = a.add(BigInteger.ONE);
			if (a.isProbablePrime(1)) {
				System.out.printf("%d -> %d\n", n + 1, a);
				n++;
			}
		}
	}
}