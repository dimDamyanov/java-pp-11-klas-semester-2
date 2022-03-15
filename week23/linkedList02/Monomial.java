package linkedList02;

import java.text.DecimalFormat;

public class Monomial {
	public double coeficient;
	public int power;
	
	public Monomial(int power, double coeficient) {
		this.power = power;
		this.coeficient = coeficient;
	}
	
	public static void print(Monomial monomial) {
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println(String.format("%s%s%s", (monomial.coeficient > 0) ? "+" : "-", df.format(Math.abs(monomial.coeficient)), (monomial.power != 0 && monomial.power != 1) ? String.format("x%s", Superscript.getSuperscript(monomial.power)) : (monomial.power == 1) ? "x " : ""));
	}
}
