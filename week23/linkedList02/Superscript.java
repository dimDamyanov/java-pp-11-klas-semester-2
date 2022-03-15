package linkedList02;

public class Superscript {
	public static String getSuperscript(int a) {
		switch (a) {
		case 0:
			return "⁰";
		case 1:
			return "¹";
		case 2:
			return "²";
		case 3:
			return "³";
		case 4:
			return "⁴";
		case 5:
			return "⁵";
		case 6:
			return "⁶";
		case 7:
			return "⁷";
		case 8:
			return "⁸";
		case 9:
			return "⁹";

		default:
			throw new IllegalArgumentException("Unexpected value: " + a);
		}
	}
}
