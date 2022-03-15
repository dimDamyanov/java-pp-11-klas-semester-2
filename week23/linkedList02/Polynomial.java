package linkedList02;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Polynomial implements Cloneable {
	LinkedList<Monomial> list = new LinkedList<Monomial>();
	
	private Polynomial() {}
	
	private Polynomial(double coeficients[]) {
		for(int i = 0; i < coeficients.length; i++) {
			if (coeficients[i] != 0)
				this.list.add(new Monomial(i, coeficients[i]));
		}
	}
	
	private Polynomial(LinkedList<Monomial> list) {
		this.list = new LinkedList<Monomial>(list);
	}
	
	public int getPower() {
		Iterator<Monomial> iterator = this.list.iterator();
		int power = 0;
		while(iterator.hasNext()) {
			Monomial currentMonomial = iterator.next();
			if (currentMonomial.power > power)
				power = currentMonomial.power;
		}
		return power;
	}
	
	public double getCoeficientAt(int power) {
		Iterator<Monomial> iterator = this.list.iterator();
		while(iterator.hasNext()) {
			Monomial currentMonomial = iterator.next();
			if (currentMonomial.power == power)
				return currentMonomial.coeficient;
		}
		return 0;
	}
	
	public void normalize() {
		double[] coeficients = new double[this.getPower() + 1];
		Iterator<Monomial> iterator = this.list.iterator();
		while(iterator.hasNext()) {
			Monomial currentMonomial = iterator.next();
			coeficients[currentMonomial.power] += currentMonomial.coeficient;
		}
		LinkedList<Monomial> newList = new LinkedList<Monomial>();
		for (int i = 0; i < this.getPower() + 1; i++) {
			newList.add(new Monomial(i, coeficients[i]));
		}
		this.list = newList;
	}
	
	@Override
	public Object clone() {
		return new Polynomial(new LinkedList<Monomial>(this.list));
	}
	
	public static Polynomial create(double... coeficients) {
		return new Polynomial(coeficients);
	}
	
	public static void print(Polynomial polynomial) {
		StringBuilder polynomialStringBuilder = new StringBuilder();
		ListIterator<Monomial> listIterator = polynomial.list.listIterator(polynomial.list.size());
		while(listIterator.hasPrevious()) {
			Monomial currentMonomial = listIterator.previous();
			DecimalFormat df = new DecimalFormat("#.##");
			polynomialStringBuilder.append(String.format("%s%s%s", (currentMonomial.coeficient > 0) ? "+" : "-", df.format(Math.abs(currentMonomial.coeficient)), (currentMonomial.power != 0 && currentMonomial.power != 1) ? String.format("x%s", Superscript.getSuperscript(currentMonomial.power)) : (currentMonomial.power == 1) ? "x " : ""));
		}
		System.out.println(polynomialStringBuilder.toString());
	}
	
	public static Polynomial addPolynomials(Polynomial polynomial1, Polynomial polynomial2) {
		int power = (polynomial1.getPower() > polynomial2.getPower()) ? polynomial1.getPower() : polynomial2.getPower();
		double[] coeficients = new double[power + 1];
		for (int i = 0; i < power + 1; i++)
			coeficients[i] = polynomial1.getCoeficientAt(i) + polynomial2.getCoeficientAt(i);
		return new Polynomial(coeficients);
	}
	
	public static Polynomial multPolynomialMonomial(Polynomial polynomial, Monomial monomial) {
		int power = polynomial.getPower() + monomial.power + 1;
		double[] coeficients = new double[power];
		Iterator<Monomial> iterator = polynomial.list.iterator();
		while(iterator.hasNext()) {
			Monomial currentMonomial = iterator.next();
			coeficients[currentMonomial.power + monomial.power] += currentMonomial.coeficient * monomial.coeficient;
		}
		return new Polynomial(coeficients);
	}
	
	public static Polynomial multPolynomials(Polynomial polynomial1, Polynomial polynomial2) {
		if (polynomial1.getPower() < polynomial2.getPower()) {
			Polynomial temp = (Polynomial) polynomial1.clone();
			polynomial1 = polynomial2;
			polynomial2 = temp;
		}
		
		Polynomial resultPolynomial = new Polynomial();
		Iterator<Monomial> iterator = polynomial2.list.iterator();
		while(iterator.hasNext()) {
			resultPolynomial = Polynomial.addPolynomials(resultPolynomial, Polynomial.multPolynomialMonomial(polynomial1, iterator.next()));
		}
		
		return resultPolynomial;
	}
}
