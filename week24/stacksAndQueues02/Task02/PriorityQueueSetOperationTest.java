package stacksAndQueues02;

import java.util.PriorityQueue;

public class PriorityQueueSetOperationTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        PriorityQueue<Integer> queue2 = new PriorityQueue<>();
        for(int i = 0; i < 10; i++)
            queue1.offer(i);
        for(int i = 5; i < 15; i++)
            queue2.offer(i);

        System.out.println(PriorityQueueSetOperation.getIntersection(queue1, queue2));
        System.out.println(PriorityQueueSetOperation.getUnion(queue1, queue2));
        System.out.println(PriorityQueueSetOperation.getDifference(queue1, queue2));
    }
}
