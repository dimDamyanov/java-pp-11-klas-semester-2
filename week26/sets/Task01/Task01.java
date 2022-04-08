package sets.Task01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task01 {
    public static void main(String[] args) throws FileNotFoundException {
        int vowelsCount = 0, consonantsCount = 0;
        final Set<Character> vowels = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U'));
        File file = new File("src/sets/text.txt");
        Scanner scanner = new Scanner(file);
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine());
        }
        scanner.close();
        String[] words = stringBuilder.toString().split("[\\s\\p{P}]+");
        for (String word: words)
            for (char chr: word.toUpperCase(Locale.ROOT).toCharArray())
                if (vowels.contains(chr))
                    vowelsCount++;
                else
                    consonantsCount++;
        System.out.println("Vowels count: " + vowelsCount);
        System.out.println("Consonants count: " + consonantsCount);
    }
}
