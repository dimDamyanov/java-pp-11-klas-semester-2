package week29;

import java.util.Comparator;

public class Task02 {
    public static void main(String[] args) {
        Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
        heapSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }

    public static <E extends Comparable<E>> void heapSort(E[] list) {
        Heap<E> heap = new Heap<>();
        for (int i = 0; i < list.length; i++)
            heap.add(list[i]);
        for (int i = list.length - 1; i >= 0; i--)
            list[i] = heap.remove();
    }

    public static <E> void heapSort(E[] list, Comparator<? super E> comparator) {
        HeapComparator<E> heap = new HeapComparator<>();
        for (int i = 0; i < list.length; i++)
            heap.add(list[i], comparator);
        for (int i = list.length - 1; i >= 0; i--)
            list[i] = heap.remove(comparator);
    }
}
