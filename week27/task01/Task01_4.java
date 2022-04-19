package week27.task01;

import java.util.Arrays;
import java.util.HashSet;

public class Task01_4 {
    public static void main(String[] args) {
        final int TARGETED_SUM = 8;
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(1, 2, 4, 6));
        HashSet<Integer> compSet = new HashSet<>();
        for (int element: hashSet) {
            if (compSet.contains(element))
                System.out.printf("%d + %d = %d\n", element, TARGETED_SUM - element, TARGETED_SUM);
            compSet.add(TARGETED_SUM - element);
        }
    }
}
