package stacksAndQueues;

public class QueueOfIntegers {
	private int[] elements;
	private int size;
	public static final int DEFAULT_CAPACITY = 8;
	
	
	public QueueOfIntegers() {
		this(DEFAULT_CAPACITY);
	}
	
	private QueueOfIntegers(int capacity) {
		elements = new int[capacity];
	}
	
	public void enqueue(int v) {
		if (size >= elements.length) {
			int[] temp = new int[elements.length * 2];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements = temp;
		}
		elements[size++] = v;
	}
	
	public int dequeue() {
		int x = elements[0];
		size--;
		for (int i = 0; i < size; i++) {
			elements[i] = elements[i + 1];
		}
		return x;
	}
	
	public boolean empty() {
		return this.size == 0;
	}
	
	public int getSize() {
		return this.size;
	}
}
