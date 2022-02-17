package formatAndEnum;

public class Task04 {
	public static void main(String[] args) {
		enum Currencies {
			IRANIAN_RIAL,
		    VIETNAMESE_DONG,
		    INDONESIAN_RUPIAH,
		    SIERA_LEONIAN_LEON,
		    LAO,
		    UZBEK_SUM
		}
		
		for (Currencies currency: Currencies.values()) {
			System.out.printf("%s with ordinal %d\n", currency, currency.ordinal());
		}
	}
}
