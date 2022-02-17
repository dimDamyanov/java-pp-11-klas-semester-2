package complexTask;

public class ComplexTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Complex x = new Complex(1.5, 2);
		Complex y = new Complex(2);
		System.out.println(x.add(y));
		System.out.println(x.subtract(y));
		System.out.println(x.multiply(y));
		System.out.println(x.divide(y));
		System.out.println(x.abs());
		System.out.println(y.abs());
	}

}
