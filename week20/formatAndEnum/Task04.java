package formatingAndEnum;

import java.util.Scanner;

public class Task04 {
	public static void main(String[] args) {
		enum Currencies {
			IRANIAN_RIAL,
			VIETNAMESE_DONG,
			INDONESIAN_RUPIAH,
			SIERA_LEONIAN_LEON,
			LAO_KIP,
			UZBEK_SOM
		}

		for (Currencies currency: Currencies.values()) {
			System.out.printf("%s with ordinal %d\n", currency, currency.ordinal());
		}

		Scanner sysInput = new Scanner(System.in);
		int n;
		System.out.print("Enter ordinal to get further information: ");
		n = sysInput.nextInt();
		sysInput.close();
		switch (n) {
			case 0:
				System.out.print("The rial (Persian: ریال ایران, romanized: riyâl-e Irân; sign: ﷼; code: IRR) is the currency of Iran.");
				break;
			case 1:
				System.out.print("The đồng (Chữ Hán: 銅) (/dɒŋ/; Vietnamese: [ˀɗɜwŋ͡m˨˩]; sign: ₫ or informally đ; code: VND) has been the currency of Vietnam since 3 May 1978.");
				break;
			case 2:
				System.out.print("The rupiah (Rp) is the official currency of Indonesia.");
				break;
			case 3:
				System.out.print("The leone is the currency of Sierra Leone.");
				break;
			case 4:
				System.out.print("The kip (Lao: ກີບ; code: LAK; sign: ₭ or ₭N; French: kip; officially: ເງີນກີບລາວ, lit. \"currency Lao kip\") is the currency of Laos since 1955.The kip (Lao: ກີບ; code: LAK; sign: ₭ or ₭N; French: kip; officially: ເງີນກີບລາວ, lit. \"currency Lao kip\") is the currency of Laos since 1955.");
				break;
			case 5:
				System.out.print("The soʻm (Uzbek: soʻm in Latin script, сўм in Cyrillic script) is the currency of Uzbekistan in Central Asia.");
				break;
		}
	}
}
