package week27.task01;

import java.util.ArrayList;
import java.util.Arrays;

public class Task01_3 {
    public static void main(String[] args) {
        final int TARGETED_SUM = 8;
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 4, 4, 6));
        int n = 0, m = arrayList.size() - 1;
        while (n != m) {
            if (arrayList.get(n) + arrayList.get(m) < TARGETED_SUM)
                n++;
            else if (arrayList.get(n) + arrayList.get(m) > TARGETED_SUM)
                m--;
            else {
                System.out.printf("%d + %d = %d\n", arrayList.get(n), arrayList.get(m), TARGETED_SUM);
                n++;
            }
        }

    }
}
