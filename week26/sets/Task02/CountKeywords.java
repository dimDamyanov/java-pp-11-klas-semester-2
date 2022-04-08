package sets.Task02;

import java.util.*;
import java.io.*;

public class CountKeywords {
    public static void main(String[] args) throws Exception {
        File file = new File("src/sets/TestHashSet.java");
        if (file.exists()) {
            System.out.println("The number of keywords is " + countKeywords(file));
        } else {
            System.out.println("File does not exist");
        }

    }

    public static int countKeywords(File file) throws Exception {
        // Array of all Java keywords + true, false and null
        String[] keywordString = { "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
                "const", "continue", "default", "do", "double", "else", "enum", "extends", "for", "final", "finally",
                "float", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
                "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super",
                "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while",
                "true", "false", "null" };
        Set<String> keywordSet = new HashSet<String>(Arrays.asList(keywordString));
        int count = 0;
        boolean stringFlag = false, singleLineCommentFlag = false, multilineCommentFlag = false;


        Scanner input = new Scanner(file);
//        while (input.hasNext()) {
//            String word = input.next();
//            if (word.chars().filter(ch -> ch == '"').count() % 2 == 1)
//                stringFlag = !stringFlag;
//            if (word.contains("//"))
//                singleLineCommentFlag = true;
//            System.out.println(word);
//            if (!stringFlag && keywordSet.contains(word))
//                count++;
//        }
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
                System.out.println(word);
                if (!stringFlag && !singleLineCommentFlag && !multilineCommentFlag && keywordSet.contains(word))
                    count++;
            }
            singleLineCommentFlag = false;
        }
        input.close();
        return count;

    }
}