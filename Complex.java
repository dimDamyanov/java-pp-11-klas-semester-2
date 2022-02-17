package complexTask;

public class Complex implements Cloneable, Comparable<Complex> {
	private double a, b;
	
	Complex(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	Complex(double a) {
		this(a, 0);
	}
	
	Complex() {
		this(0, 0);
	}

	public Complex add(Complex augend) {
		return new Complex(this.a + augend.a, this.b + augend.b);
	}
	
	public Complex subtract(Complex subtrahend) {
		return new Complex(this.a - subtrahend.a, this.b - subtrahend.b);
	}
	
	public Complex multiply(Complex multiplicand) {
		return new Complex(this.a * multiplicand.a - this.b * multiplicand.b, this.b * multiplicand.a + this.a * multiplicand.b);
	}
	
	public Complex divide(Complex divisor) {
		return new Complex((this.a * divisor.a + this.b * divisor.b) / (Math.pow(divisor.a, 2) + Math.pow(divisor.b, 2)), (this.b * divisor.a - this.a * divisor.b) / (Math.pow(divisor.a, 2) + Math.pow(divisor.b, 2)));
	}
	
	public double abs() {
		return Math.sqrt(Math.pow(this.a, 2) + Math.pow(this.b, 2));
	}
	
	public double getRealPart() {
		return this.a;
	}
	
	public double getImaginaryPart() {
		return this.b;
	}
	
	@Override
	public String toString() {
		if (b == 0) 
			return Double.toString(a);
		return String.format("(%f + %fi)", this.a, this.b);
	}

	@Override
	public int compareTo(Complex o) {
		return (int) Math.ceil(this.abs() - o.abs());
	}
	
	@Override
	public Complex clone() {
		return new Complex(this.a, this.b);
	}
}
