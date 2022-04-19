package week27.task01;

import java.util.ArrayList;
import java.util.Arrays;

public class Task01_1 {
    public static void main(String[] args) {
        final int TARGETED_SUM = 8;
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 6, 4, 4));
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = i+1; j < arrayList.size(); j++) {
                if (arrayList.get(i) + arrayList.get(j) == TARGETED_SUM) {
                    System.out.printf("%d + %d = %d\n", arrayList.get(i), arrayList.get(j), TARGETED_SUM);
                }
            }
        }
    }
}
