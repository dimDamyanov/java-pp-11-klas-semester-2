package week27.task01;

import java.util.ArrayList;
import java.util.Arrays;

public class Task01_2 {
    public static void main(String[] args) {
        final int TARGETED_SUM = 8;
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 4, 4, 6));
        for (int i = 0; i < arrayList.size(); i++) {
            int index = binarySearch(arrayList, i + 1, arrayList.size() - 1, TARGETED_SUM - arrayList.get(i));
            if (index != -1) {
                System.out.printf("%d + %d = %d\n", arrayList.get(i), arrayList.get(index), TARGETED_SUM);
            }
        }
    }

    public static int binarySearch(ArrayList<Integer> arrayList, int startIndex, int finalIndex, int x) {
        if (finalIndex >= startIndex) {
            int middleIndex = startIndex + (finalIndex - startIndex) / 2;
            if (arrayList.get(middleIndex) == x)
                return middleIndex;
            else if (arrayList.get(middleIndex) > x)
                return binarySearch(arrayList, startIndex, middleIndex - 1, x);
            else
                return binarySearch(arrayList, middleIndex + 1, finalIndex, x);
        }

        return -1;
    }
}
