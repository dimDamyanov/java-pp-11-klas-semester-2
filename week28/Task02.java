package week28.mergeAndQuickSort;

import java.util.concurrent.ThreadLocalRandom;

public class Task02 {

    public static void main(String[] args) {
        long startTime, endTime;
        System.out.println("Array size  | Selection Sort     Bubble Sort     Merge Sort      Quick Sort");
        for (int i = 50000; i <= 300000; i += 50000) {
            int[] arr = new int[i];
            for (int j = 0; j < i; j++) {
                arr[j] = ThreadLocalRandom.current().nextInt();
            }

            System.out.printf("%d       |   ", i);

            int[] arrSort = new int[i];
            System.arraycopy(arr, 0, arrSort, 0, arr.length);
            startTime = System.currentTimeMillis();
            selectionSort(arrSort);
            endTime = System.currentTimeMillis();
            System.out.printf("%d   ", endTime - startTime);


            System.arraycopy(arr, 0, arrSort, 0, arr.length);
            startTime = System.currentTimeMillis();
            bubbleSort(arrSort);
            endTime = System.currentTimeMillis();
            System.out.printf("%d   ", endTime - startTime);

            System.arraycopy(arr, 0, arrSort, 0, arr.length);
            startTime = System.currentTimeMillis();
            mergeSort(arrSort);
            endTime = System.currentTimeMillis();
            System.out.printf("%d   ", endTime - startTime);

            System.arraycopy(arr, 0, arrSort, 0, arr.length);
            startTime = System.currentTimeMillis();
            quickSort(arrSort);
            endTime = System.currentTimeMillis();
            System.out.printf("%d   \n", endTime - startTime);

        }

    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int[] firstHalf = new int[arr.length / 2];
            System.arraycopy(arr, 0, firstHalf, 0, arr.length / 2);
            mergeSort(firstHalf);

            int secondHalfLength = arr.length - arr.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(arr, arr.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            merge(firstHalf, secondHalf, arr);
        }
    }

    public static void merge(int[] list1, int[] list2, int[] temp) {
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2])
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }
        while (current1 < list1.length)
            temp[current3++] = list1[current1++];
        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }

    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }

    public static void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    public static int partition(int[] list, int first, int last) {
        int pivot = list[first]; 
        int low = first + 1; 
        int high = last; 
        while (high > low) {

            while (low <= high && list[low] <= pivot)
                low++;

            while (low <= high && list[high] > pivot)
                high--;

            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
        while (high > first && list[high] >= pivot)
            high--;
        if (pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return first;
        }
    }
}


