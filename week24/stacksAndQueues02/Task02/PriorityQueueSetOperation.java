package stacksAndQueues02;

import java.util.PriorityQueue;

public class PriorityQueueSetOperation {
    private PriorityQueueSetOperation() {}

    public static <E> PriorityQueue<E> getIntersection(PriorityQueue<E> queue1, PriorityQueue<E> queue2) {
        PriorityQueue<E> result = new PriorityQueue<>();
        for(E element: queue1) {
            if (queue2.contains(element))
                result.offer(element);
        }
        return result;
    }

    public static <E> PriorityQueue<E> getUnion(PriorityQueue<E> queue1, PriorityQueue<E> queue2) {
        PriorityQueue<E> result = new PriorityQueue<>();
        for(E element: queue1)
            result.offer(element);
        for(E element: queue2) {
            if (!result.contains(element))
                result.offer(element);
        }
        return result;
    }

    public static  <E> PriorityQueue<E> getDifference(PriorityQueue<E> queue1, PriorityQueue<E> queue2) {
        PriorityQueue<E> result = new PriorityQueue<>();
        for(E element: queue1) {
            if (!queue2.contains(element))
                result.offer(element);
        }
        for(E element: queue2) {
            if (!queue1.contains(element))
                result.offer(element);
        }
        return result;
    }
}
