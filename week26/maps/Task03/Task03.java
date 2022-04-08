package maps.Task03;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Task03 {
    public static void main(String[] args) throws Exception {
        File file = new File("src/maps/Task03/TestHashSet.java");
        if (file.exists()) {
            for (Map.Entry<String, Integer> entry: countKeywords(file).entrySet()) {
                System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
            }
        } else {
            System.out.println("File does not exist");
        }
    }

    public static Map<String, Integer> countKeywords(File file) throws Exception {
        // Array of all Java keywords + true, false and null
        String[] keywordString = { "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
                "const", "continue", "default", "do", "double", "else", "enum", "extends", "for", "final", "finally",
                "float", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
                "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super",
                "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while",
                "true", "false", "null" };
        Map<String, Integer> map = new LinkedHashMap<>(Arrays.stream(keywordString).collect(Collectors.toMap(x -> x, x -> 0)));

        boolean stringFlag = false, singleLineCommentFlag = false, multilineCommentFlag = false;


        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String line = input.nextLine().stripLeading();
            if (line.length() == 0)
                continue;
            String[] words = line.split("[\s]+");
            for (String word: words) {
                if (word.chars().filter(ch -> ch == '"').count() % 2 == 1)
                    stringFlag = !stringFlag;
                if (word.contains("//"))
                    singleLineCommentFlag = true;
                if (word.contains("/*"))
                    multilineCommentFlag = true;
                if (word.contains("*/"))
                    multilineCommentFlag = false;
                if (!stringFlag && !singleLineCommentFlag && !multilineCommentFlag && map.containsKey(word))
                    map.put(word, map.get(word) + 1);
            }
            singleLineCommentFlag = false;
        }
        input.close();
        return map;
    }
}
