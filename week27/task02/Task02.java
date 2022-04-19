package week27.task02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        ArrayList<Integer> primeFactorsList = getPrimeFactors(n);
        HashSet<Integer> primeFactorsSet = new HashSet<>(primeFactorsList);

        StringBuilder primeProductBuilder = new StringBuilder();
        for (int element: primeFactorsList)
            primeProductBuilder.append(String.format("%d * ", element));
        primeProductBuilder.setLength(primeProductBuilder.length() - 3);
        String primeProduct = primeProductBuilder.toString();
        
        System.out.printf("%d = %s\n", n, primeProduct);

        StringBuilder primeFactorsBuilder = new StringBuilder();
        for (int element: primeFactorsSet)
            primeFactorsBuilder.append(String.format("%d ", element));
        primeFactorsBuilder.setLength(primeFactorsBuilder.length() - 1);
        String primeFactors = primeFactorsBuilder.toString();
        
        System.out.println(primeFactors);
    }
    
    public static ArrayList<Integer> getPrimeFactors(int a) {
        ArrayList<Integer> primeFactorsList = new ArrayList<>();
        for (int i = 2; i < Math.ceil(Math.sqrt(a)); i++) {
            while (a % i == 0) {
                primeFactorsList.add(i);
                a /= i;
            }
        }
        
        return primeFactorsList;
    }
}
