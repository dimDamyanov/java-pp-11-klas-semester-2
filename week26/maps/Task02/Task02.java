package maps.Task02;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Task02 {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("Afghanistan", "Kabul");
        map.put("Albania", "Tirana");
        map.put("Algeria", "Algiers");
        map.put("Andorra", "Andorra la Vella");
        map.put("Angola", "Luanda");
        map.put("Antigua and Barbuda", "St. John's");
        map.put("Argentina", "Buenos Aires");
        map.put("Armenia", "Yerevan");
        map.put("Australia", "Canberra");
        map.put("Austria", "Vienna");
        map.put("Azerbaijan", "Baku");
        map.put("Bahamas", "Nassau");
        map.put("Bahrain", "Manama");
        map.put("Bangladesh", "Dhaka");
        map.put("Barbados", "Bridgetown");
        map.put("Belarus", "Minsk");
        map.put("Belgium", "Brussels");
        map.put("Belize", "Belmopan");
        map.put("Benin", "Porto Novo");
        map.put("Bhutan", "Thimphu");

        int points = 0, mistakes = 0;
        List<String> countries = new ArrayList<String>(map.keySet());
        Scanner scanner = new Scanner(System.in);
        while (mistakes < 3 && !countries.isEmpty()) {
            String currentCountry = countries.get(ThreadLocalRandom.current().nextInt(0, countries.size()));
            countries.remove(currentCountry);
            String currentCapital = map.get(currentCountry);

            System.out.printf("Current result: ✖: %d, ✓: %d\n", mistakes, points);
            System.out.printf("What is the capital of %s: ", currentCountry);
            String answer = scanner.nextLine();
            if (currentCapital.equalsIgnoreCase(answer)) {
                points++;
                System.out.println("Congratulations!");
            } else {
                mistakes++;
                System.out.printf("Wrong answer! - The capital of %s is %s\n", currentCountry, currentCapital);
            }
        }
        scanner.close();

        if (!countries.isEmpty())
            System.out.printf("Game over! - Result: ✖: %d, ✓: %d", mistakes, points);
        else
            System.out.printf("Congratulations! You won! - Result: ✖: %d, ✓: %d", mistakes, points);
    }
}
