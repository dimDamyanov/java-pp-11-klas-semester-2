package linkedList02;

public class PolynomialTest {
	public static void main(String[] args) {
		Monomial monomial1 = new Monomial(4, 2);
		Monomial.print(monomial1);
		Polynomial polynomial1 = Polynomial.create(0, -4, 0, 5);
		Polynomial.print(polynomial1);
		Polynomial polynomial2 = Polynomial.create(5, 3, 7, 1);
		Polynomial.print(polynomial2);
		Polynomial.print(Polynomial.addPolynomials(polynomial1, polynomial2));
		Polynomial.print(Polynomial.multPolynomialMonomial(polynomial1, monomial1));
		Polynomial.print(Polynomial.multPolynomials(polynomial1, polynomial2));
	}
}
