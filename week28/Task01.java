package week28.mergeAndQuickSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

public class Task01 {

    public static void main(String[] args) {
        Integer[] arr = new Integer[100];
        for (int j = 0; j < 100; j++) {
            arr[j] = ThreadLocalRandom.current().nextInt();
        }
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static <E extends Comparable<E>> void mergeSort(E[] list) {
        mergeSort(list, 0, list.length - 1);
    }
    public static <E> void mergeSort(E[] list, Comparator<? super E> comparator) {
        mergeSort(list, 0, list.length - 1, comparator);
    }

    public static <E extends Comparable<E>> void mergeSort(E[] array, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;

            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }

    public static <E> void mergeSort(E[] array, int start, int end, Comparator<? super E> comparator) {
        if (start < end) {
            int middle = (start + end) / 2;

            mergeSort(array, start, middle, comparator);
            mergeSort(array, middle + 1, end, comparator);
            merge(array, start, middle, end, comparator);
        }
    }

    public static <E extends Comparable<E>> void merge(E[] array, int start, int middle, int end) {
        E[] firstHalf = (E[]) new Comparable[middle - start + 1];
        E[] secondHalf = (E[]) new Comparable[end - middle];

        System.arraycopy(array, start, firstHalf, 0, firstHalf.length);
        System.arraycopy(array, middle + 1, secondHalf, 0, secondHalf.length);

        int firstInd = 0, secondInd = 0, currentInd = start;

        while (firstInd < firstHalf.length && secondInd < secondHalf.length) {
            if (firstHalf[firstInd].compareTo(secondHalf[secondInd]) <= 0) {
                array[currentInd] = firstHalf[firstInd];
                firstInd++;
            }
            else {
                array[currentInd] = secondHalf[secondInd];
                secondInd++;
            }
            currentInd++;
        }

        while (firstInd < firstHalf.length)
            array[currentInd++] = firstHalf[firstInd++];
        while (secondInd < secondHalf.length)
            array[currentInd++] = secondHalf[secondInd++];
    }

    public static <E> void merge(E[] array, int start, int middle, int end, Comparator<? super E> comparator) {
        E[] firstHalf = (E[]) new Object[middle - start + 1];
        E[] secondHalf = (E[]) new Object[end - middle];

        System.arraycopy(array, start, firstHalf, 0, firstHalf.length);
        System.arraycopy(array, middle + 1, secondHalf, 0, secondHalf.length);

        int firstInd = 0, secondInd = 0, currentInd = start;

        while (firstInd < firstHalf.length && secondInd < secondHalf.length) {
            if (comparator.compare(firstHalf[firstInd], secondHalf[secondInd]) <= 0) {
                array[currentInd] = firstHalf[firstInd];
                firstInd++;
            }
            else {
                array[currentInd] = secondHalf[secondInd];
                secondInd++;
            }
            currentInd++;
        }

        while (firstInd < firstHalf.length)
            array[currentInd++] = firstHalf[firstInd++];
        while (secondInd < secondHalf.length)
            array[currentInd++] = secondHalf[secondInd++];
    }
}
