package bigDataTypes;

import java.math.BigInteger;

public class Task01 {
	public static void main(String[] args) {
		BigInteger a = new BigInteger(Long.toString(Long.MAX_VALUE));
		BigInteger bigOne = new BigInteger("1");
		int n = 0;
		while (n < 5) {
			a = a.add(bigOne);
			if (a.isProbablePrime(1)) {
				System.out.println(a);
				n++;
			}
		}
	}
}
