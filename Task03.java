package bigDataTypes;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Task03 {
	public static void main(String[] args) {
		BigDecimal e = BigDecimal.ONE;
		for (int i = 1; i <= 1000; i++) {
			e = e.add(BigDecimal.ONE.divide(new BigDecimal(factorial(i)), 1000, RoundingMode.HALF_UP));
			if (i == 100 || i == 200 || i == 1000)
			    System.out.printf("i = %d e -> %s\n", i, e.toString());
		}
	}
	
	public static BigInteger factorial(int n) {
		BigInteger result = BigInteger.ONE;
		for(int i = 1; i <= n; i++)
			result = result.multiply(new BigInteger(Integer.toString(i)));
		return result;
	}
}
