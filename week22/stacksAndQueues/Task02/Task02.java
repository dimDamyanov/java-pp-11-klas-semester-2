package stacksAndQueues;

public class Task02 {
	public static void main(String[] args) {
		QueueOfIntegers queueOfIntegers = new QueueOfIntegers();
		for (int i = 0; i < 20; i++) {
			queueOfIntegers.enqueue(i);
		}
		
		for (int i = 0; i < 20; i++) {
			System.out.println(queueOfIntegers.dequeue());
		}
	}
}
